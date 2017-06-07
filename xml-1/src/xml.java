import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
 
public class xml {
 
    public static void main(String[] args) {
        EncodingExamples(); // ½s½X½d¨Ò
        DecodingExamples(); // ¸Ñ½X½d¨Ò
    }
 
    static String myJson;
 
    static void EncodingExamples() {
        JSONObject obj = new JSONObject();
        obj.put("A", "aaa");
        obj.put("B", 123);
        obj.put("C", 1.2345);
        obj.put("D", true);
 
        JSONArray list = new JSONArray();
        list.put("E");
        list.put("F");
        list.put("G");

        Map m = new HashMap();
        m.put("X", "xxx");
        m.put("Y", "yyy");
        m.put("Z", "zzz");
 
        list.put(m);
 
        obj.put("Messages", list);
 
        myJson = obj.toString();
 
        System.out.println("Encoding Examples : " + myJson);
        System.out.println("---------------------------------------------------");
    }
 
    static void DecodingExamples() {
        JSONObject root = new JSONObject(myJson);
        System.out.println("Decoding Examples : ");
        System.out.println(root.get("A"));
        System.out.println(root.get("B"));
        System.out.println(root.get("C"));
        System.out.println(root.get("D"));
        System.out.println(root.get("Messages"));
        System.out.println(root.getJSONArray("Messages"));
 
        JSONArray a = root.getJSONArray("Messages");
        for (int i = 0; i < a.length(); i++) {
            System.out.println(a.get(i));
        }

        JSONObject m = (JSONObject) a.get(3);
        System.out.println(m.get("X"));
        System.out.println(m.get("Y"));
        System.out.println(m.get("Z"));
    }
 
}
