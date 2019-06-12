package Day41_Xml_Tomact.xml;

import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

public class Jsoup_Xpathdemo01 {

    public static void main(String[] args) throws Exception {
        String path = Jsoup_Xpathdemo01.class.getClassLoader().getResource("student.xml").toURI().getPath();
        Document document = Jsoup.parse(new File(path),"utf-8");

        // 获取JX对象来使用Xpath来查询
        JXDocument jxDocument = new JXDocument(document);

        // 查询根目录下的所有student元素 //student  选择所有student元素，不管他在什么位置
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }

        System.out.println("---------------");
        // 查询所有student下的name元素
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes1) {
            System.out.println(jxNode);
        }
        System.out.println("---------------");

        // 查询name元素，并且属性值有id的
        List<JXNode> jxNodes2 = jxDocument.selN("//name[@id]");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }
        System.out.println("---------------");

        // 查询name元素，属性值有id的,并且id的属性值为2的
        List<JXNode> jxNodes3 = jxDocument.selN("//name[@id='2']");
        for (JXNode jxNode:jxNodes3) {
            System.out.println(jxNode);
        }




    }

}
