package mehmetgul.mylib.CompareXML;


import org.junit.Assert;
import org.junit.Test;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.*;
import javax.xml.transform.Source;

public class CompareTwoXMLfile {

	@Test
	public void given2XMLS_whenNotIdentical_NodeListLength(){
		Source control = Input.fromFile("src/test/java/mehmetgul/mylib/XMLCompare/data/original.xml").build();
		Source test = Input.fromFile("src/test/java/mehmetgul/mylib/XMLCompare/data/other.xml").build();
		DifferenceEngine diff = new DOMDifferenceEngine();
		diff.addDifferenceListener(new ComparisonListener() {
			@Override
			public void comparisonPerformed(Comparison comparison, ComparisonResult comparisonResult) {
			Assert.fail("Found a difference : " + comparison);
				System.out.println(comparisonResult);
			}
		});
		diff.compare(control,test);

	}

	@Test
	public void given2XMLS_whenNotIdentical_NodeListLength1(){
		Diff d = DiffBuilder.compare(Input.fromFile("src/test/java/mehmetgul/mylib/XMLCompare/data/original.xml"))
				.withTest("src/test/java/mehmetgul/mylib/XMLCompare/data/other.xml").build();
		assert !d.hasDifferences();
	}



}

/**
 * Source : https://github.com/xmlunit/xmlunit
 */
/* DEPENDENCY REQUIRED
<!-- https://mvnrepository.com/artifact/org.xmlunit/xmlunit-core -->
        <dependency>
            <groupId>org.xmlunit</groupId>
            <artifactId>xmlunit-core</artifactId>
            <version>2.6.3</version>
            <scope>test</scope>
        </dependency>
 */
