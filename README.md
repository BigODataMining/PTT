import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.io.*;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;
import java.nio.charset.Charset;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class test2{
	
	 public static void main(String [] argv) throws IOException
	{    
		JSONParser parser = new JSONParser();
		try{	
		  Object obj = parser.parse(new FileReader("C:/My.xml/BabyMother-1-5719.json"));//開檔         
	      JSONObject a = (JSONObject) obj;
	      //下面是讀取每一個數組
	      for (int i = 0; i <10; i++) {
		  String article_id = (String)a.get("article_id");
		  String article_title=(String)a.get("article_title");
	      String content=(String)a.get("content");
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
	      xw.write(doc);xw.close();}}
		catch (Exception e) {e.printStackTrace();}}}
