import java.io.*;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;
import java.nio.charset.Charset;

public class ex {

    public static void main(String[] args) throws Exception {
        Document doc = DocumentHelper.createDocument();
        //------------------------------------------------------
        // �e�m�ʧ@�A�̻ݨD�i�ٲ��G
        doc.addProcessingInstruction("xml", "type=\"user-data\""); // �ŧi
        /* doc.addDocType(<�ڤ���>,<���U//��´//��������//�w�q�y��>,<���������w�q��m>);
         * �򥻤W <�ڤ���> �W�٭n�P doc.addElement() �ۦP�A�{���X�� 23 ��
         */

     
        //------------------------------------------------------
        // �إ߮ڤ���(������)�G
        Element root = doc.addElement("�ۭqXML"); // �إ� <�ۭqXML>
        //------------------------------------------------------
        // ���e(�l����)�G
        Element root_user = root.addElement("�Τ�"); // �b<��>���U�إ� <�Τ�>
        root_user.addAttribute("�s��", "1"); //�إ�<�Τ�>���ݩʡG �s��="1"
        root_user.addAttribute("�W�l", "ī�G"); //�إ�<�Τ�>���ݩʡG �W�l="ī�G"
        root_user.addAttribute("�a�}", "��y �f�󴵤s ���̰��p");

        Element root_user_address = root_user.addElement("���");
        root_user_address.addAttribute("�q�H", "�ت�q�H");
        root_user_address.addAttribute("���X", "091314520");
        root_user_address.addText("�s�몺 IPhone 5"); // <���>�s�몺 IPhone 5
        //-----------------------------------------
        Element e2 = root.addElement("�Τ�");
        e2.addAttribute("�s��", "2");
        e2.addAttribute("�W�l", "����");
        e2.addAttribute("�a�}", "�a�y �߰��Զ��s ���̧C�p");

        Element e2_1 = e2.addElement("���");
        e2_1.addAttribute("�q�H", "��ǹq�H");
        e2_1.addAttribute("���X", "0954385478");
        e2_1.addText("�T�n");
        //-----------------------------------------
        Element e3 = root.addElement("�Τ�");
        e3.addAttribute("�s��", "3");
        e3.addAttribute("�W�l", "����");
        e3.addAttribute("�a�}", "�a�y �x�W �`�Ω�");

        Element e3_1 = e3.addElement("���");
        e3_1.addAttribute("�q�H", "�Y�g�q�H");
        e3_1.addAttribute("���X", "097878787878");
        e3_1.addText("HTC Magic �]�N��");
        //------------------------------------------------------
        // �w��/��X XML�A�]�����|�榡�� XML �ҥH�������b�P�@��...�G
        System.out.println(doc.asXML());
        //------------------------------------------------------
        // �x�s XML �ɮסG
        FileWriter fw = new FileWriter("C:\\My.xml"); // �i�ۭq
        // �U���o��G�w�]�۰ʴ���BTab �� 2 �Ӫť�
        // OutputFormat of = OutputFormat.createPrettyPrint(); // �榡��XML
        OutputFormat of = new OutputFormat(); // �榡��XML
        of.setIndentSize(4); // �]�w Tab �� 4 �Ӫť�
        of.setNewlines(true);// �]�w �۰ʴ���
        XMLWriter xw = new XMLWriter(fw, of);
        xw.write(doc);
        xw.close();
    }
}