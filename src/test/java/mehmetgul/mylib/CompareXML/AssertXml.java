package mehmetgul.mylib.CompareXML;

import org.junit.Assert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class AssertXml {

	private AssertXml() {
	}
	private static Pattern NAMESPACE_PATTERN = Pattern.compile("xmlns:(ns\\d+)=\"(.*?)\"");

	/**
	 * Asserts that two XML are of identical content (namespace aliases are ignored).
	 *
	 * @param expectedXml expected XML
	 * @param actualXml actual XML
	 * @throws Exception thrown if XML parsing fails
	 */
	public static void assertEqualXmls(String expectedXml, String actualXml) throws Exception {
		// Find all namespace mappings
		Map<String, String> fullnamespace2newAlias = new HashMap<String, String>();
		generateNewAliasesForNamespacesFromXml(expectedXml, fullnamespace2newAlias);
		generateNewAliasesForNamespacesFromXml(actualXml, fullnamespace2newAlias);

		for (Map.Entry<String, String> entry : fullnamespace2newAlias.entrySet()) {
			String newAlias = entry.getValue();
			String namespace = entry.getKey();
			Pattern nsReplacePattern = Pattern.compile("xmlns:(ns\\d+)=\"" + namespace + "\"");
			expectedXml = transletaNamespaceAliasesToNewAlias(expectedXml, newAlias, nsReplacePattern);
			actualXml = transletaNamespaceAliasesToNewAlias(actualXml, newAlias, nsReplacePattern);
		}

		// nomralize namespaces accoring to given mapping

		DocumentBuilder db = initDocumentParserFactory();

		Document expectedDocuemnt = db.parse(new ByteArrayInputStream(expectedXml.getBytes(Charset.forName("UTF-8"))));
		expectedDocuemnt.normalizeDocument();

		Document actualDocument = db.parse(new ByteArrayInputStream(actualXml.getBytes(Charset.forName("UTF-8"))));
		actualDocument.normalizeDocument();

		if (!expectedDocuemnt.isEqualNode(actualDocument)) {
			Assert.assertEquals(expectedXml, actualXml); //just to better visualize the diffeences i.e. in eclipse
		}

	}


	private static DocumentBuilder initDocumentParserFactory() throws ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(false);
		dbf.setCoalescing(true);
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setIgnoringComments(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		return db;
	}

	private static String transletaNamespaceAliasesToNewAlias(String xml, String newAlias, Pattern namespacePattern) {
		Matcher nsMatcherExp = namespacePattern.matcher(xml);
		if (nsMatcherExp.find()) {
			xml = xml.replaceAll(nsMatcherExp.group(1) + "[:]", newAlias + ":");
			xml = xml.replaceAll(nsMatcherExp.group(1) + "=", newAlias + "=");
		}
		return xml;
	}

	private static void generateNewAliasesForNamespacesFromXml(String xml, Map<String, String> fullnamespace2newAlias) {
		Matcher nsMatcher = NAMESPACE_PATTERN.matcher(xml);
		while (nsMatcher.find()) {
			if (!fullnamespace2newAlias.containsKey(nsMatcher.group(2))) {
				fullnamespace2newAlias.put(nsMatcher.group(2), "nsTr" + (fullnamespace2newAlias.size() + 1));
			}
		}
	}

}

