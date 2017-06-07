import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.*;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;
import java.nio.charset.Charset;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class test{
	
	 public static void main(String [] argv) throws IOException, ParseException
	{   
	    final String filePath = "C:/My.xml/BabyMother-1-5719.json";           
	    FileReader reader = new FileReader(filePath);
	    JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
		JSONObject a=new JSONObject("articles");
		JSONArray b = a.getJSONArray("article_id");
	    //下面是讀取每一個數組
	    for (int i = 0; i <a.length(); i++) {
	    JSONObject c = b.getJSONObject(i);
		String article_title=c.getString("article_title");
	    String content=c.getString("content");
	    String article_id = c.getString("article_id");
	    Document doc = DocumentHelper.createDocument();//創檔
	    Element root = doc.addElement("PTTCorpus");//<PTTCorpus>
	    Element second = root.addElement("TEXT");//<TEXT>
	    CDATA cdata = DocumentHelper.createCDATA("標題: " + article_title+"\n內文:\n"+content);
		second.add(cdata);
	    FileWriter fw = new FileWriter("C:/My.xml/"+article_id+".xml"); //存檔位子
	    OutputFormat of = new OutputFormat(); // 格式化XML
        of.setIndentSize(4); // 設定 Tab 為 4 個空白
        of.setNewlines(true);// 設定 自動換行
        XMLWriter xw = new XMLWriter(fw, of);
        xw.write(doc);
        xw.close();} }}