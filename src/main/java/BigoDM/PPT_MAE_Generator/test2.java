package BigoDM.PPT_MAE_Generator;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import org.dom4j.CDATA;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * https://cliftonlabs.github.io/json-simple/
 * http://dom4j.sourceforge.net/dom4j-1.6.1/index.html
 * 
 * @author Dai
 *
 */
public class test2 {

	public static void main(String[] argv) throws IOException {
		try {
			JsonReader jsonReader = Json
					.createReader(new InputStreamReader(new FileInputStream("sample.json"), "Big5"));// UTF8
			// "BabyMother-1-5719.json"), "UTF-8"));// UTF8
			// 編碼
			JsonObject jsonObject = jsonReader.readObject();
			JsonArray jsonArray = jsonObject.getJsonArray("articles");
			// ?U???O????C?@????
			for (JsonValue value : jsonArray) {
				JsonObject article = (JsonObject) value;
				String article_id = (String) article.getString("article_id");
				String article_title = (String) article.getString("article_title");
				String content = (String) article.getString("content");
				Document doc = DocumentHelper.createDocument();// ????
				Element root = doc.addElement("PTTCorpus");// <PTTCorpus>
				Element second = root.addElement("TEXT");// <TEXT>
				CDATA cdata = DocumentHelper.createCDATA("標題: " + article_title + "\n內文:\n" + content);
				second.add(cdata);
				FileWriter fw = new FileWriter(article_id + ".xml");
				OutputFormat of = new OutputFormat(); // ?榡??XML
				of.setIndentSize(4); // ?]?w Tab ?? 4 ????
				of.setNewlines(true);// ?]?w ??????
				XMLWriter xw = new XMLWriter(fw, of);
				xw.write(doc);
				xw.close();
				fw.close();
			}
			jsonReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}