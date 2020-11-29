package mehmetgul.mylib.CompareJson;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class JsonFileComparison {

	public static void main(String[] args) throws JSONException, IOException {

		String json1 = new String(Files.readAllBytes(Paths.get("src/test/java/mehmetgul/mylib/z_mysandbox/data/json1.json")));
		String json2 = new String(Files.readAllBytes(Paths.get("src/test/java/mehmetgul/mylib/z_mysandbox/data/json2.json")));

		JSONCompareResult result =
				JSONCompare.compareJSON(json1, json2, JSONCompareMode.STRICT);
		System.out.println(result.toString());
	}
}
/* NEED BELOW DEPENDENCY
<dependency>
    <groupId>org.skyscreamer</groupId>
    <artifactId>jsonassert</artifactId>
    <version>1.5.0</version>
    <scope>test</scope>
</dependency>
 */