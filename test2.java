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
		  Object obj = parser.parse(new FileReader("C:/My.xml/BabyMother-1-5719.json"));//�}��         
	      JSONObject a = (JSONObject) obj;
	      //�U���OŪ���C�@�ӼƲ�
	      for (int i = 0; i <10; i++) {
		  String article_id = (String)a.get("article_id");
		  String article_title=(String)a.get("article_title");
	      String content=(String)a.get("content");
	      Document doc = DocumentHelper.createDocument();//����
	      Element root = doc.addElement("PTTCorpus");//<PTTCorpus>
	      Element second = root.addElement("TEXT");//<TEXT>
	      CDATA cdata = DocumentHelper.createCDATA("���D: " + article_title+"\n����:\n"+content);
	      second.add(cdata);
		  FileWriter fw = new FileWriter("C:/My.xml/"+article_id+".xml"); //�s�ɦ�l
		  OutputFormat of = new OutputFormat(); // �榡��XML
	      of.setIndentSize(4); // �]�w Tab �� 4 �Ӫť�
	      of.setNewlines(true);// �]�w �۰ʴ���
	      XMLWriter xw = new XMLWriter(fw, of);
	      xw.write(doc);xw.close();}}
		catch (Exception e) {e.printStackTrace();}}}