import java.io.*;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;
import java.nio.charset.Charset;

public class ex {

    public static void main(String[] args) throws Exception {
        Document doc = DocumentHelper.createDocument();
        //------------------------------------------------------
        // 前置動作，依需求可省略：
        doc.addProcessingInstruction("xml", "type=\"user-data\""); // 宣告
        /* doc.addDocType(<根元素>,<註冊//組織//類型標籤//定義語言>,<文檔類型定義位置>);
         * 基本上 <根元素> 名稱要與 doc.addElement() 相同，程式碼第 23 行
         */

     
        //------------------------------------------------------
        // 建立根元素(父元素)：
        Element root = doc.addElement("自訂XML"); // 建立 <自訂XML>
        //------------------------------------------------------
        // 內容(子元素)：
        Element root_user = root.addElement("用戶"); // 在<根>底下建立 <用戶>
        root_user.addAttribute("編號", "1"); //建立<用戶>的屬性： 編號="1"
        root_user.addAttribute("名子", "蘋果"); //建立<用戶>的屬性： 名子="蘋果"
        root_user.addAttribute("地址", "月球 惠更斯山 之最高峰");

        Element root_user_address = root_user.addElement("手機");
        root_user_address.addAttribute("電信", "種花電信");
        root_user_address.addAttribute("號碼", "091314520");
        root_user_address.addText("山寨的 IPhone 5"); // <手機>山寨的 IPhone 5
        //-----------------------------------------
        Element e2 = root.addElement("用戶");
        e2.addAttribute("編號", "2");
        e2.addAttribute("名子", "香蕉");
        e2.addAttribute("地址", "地球 喜馬拉雅山 之最低峰");

        Element e2_1 = e2.addElement("手機");
        e2_1.addAttribute("電信", "近傳電信");
        e2_1.addAttribute("號碼", "0954385478");
        e2_1.addText("三爽");
        //-----------------------------------------
        Element e3 = root.addElement("用戶");
        e3.addAttribute("編號", "3");
        e3.addAttribute("名子", "蓮霧");
        e3.addAttribute("地址", "地球 台灣 總統府");

        Element e3_1 = e3.addElement("手機");
        e3_1.addAttribute("電信", "吃土電信");
        e3_1.addAttribute("號碼", "097878787878");
        e3_1.addText("HTC Magic 魔術機");
        //------------------------------------------------------
        // 預覽/輸出 XML，因為不會格式化 XML 所以全部擠在同一行...：
        System.out.println(doc.asXML());
        //------------------------------------------------------
        // 儲存 XML 檔案：
        FileWriter fw = new FileWriter("C:\\My.xml"); // 可自訂
        // 下面這行：預設自動換行、Tab 為 2 個空白
        // OutputFormat of = OutputFormat.createPrettyPrint(); // 格式化XML
        OutputFormat of = new OutputFormat(); // 格式化XML
        of.setIndentSize(4); // 設定 Tab 為 4 個空白
        of.setNewlines(true);// 設定 自動換行
        XMLWriter xw = new XMLWriter(fw, of);
        xw.write(doc);
        xw.close();
    }
}