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
	    //�U���OŪ���C�@�ӼƲ�
	    for (int i = 0; i <a.length(); i++) {
	    JSONObject c = b.getJSONObject(i);
		String article_title=c.getString("article_title");
	    String content=c.getString("content");
	    String article_id = c.getString("article_id");
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
        xw.write(doc);
        xw.close();} }}