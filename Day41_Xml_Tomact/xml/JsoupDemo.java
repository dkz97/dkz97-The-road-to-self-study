package Day41_Xml_Tomact.xml;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class JsoupDemo {

    public static void main(String[] args) throws IOException, URISyntaxException {
        // 获取document对象，先获取xml文件路径,因为java workspace有空格，然后getpath遇到空格的话会自动转换成%符号，然后使用toURI可以把误差给弄走
        String path = JsoupDemo.class.getClassLoader().getResource("student.xml").toURI().getPath();
        // 获取document对象
        System.out.println(path);
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 获取elements对象
        Elements students = document.getElementsByTag("student");
        System.out.println(students);
        // 获得单个element对象
        System.out.println("=========");
        Element student_1 = students.get(0);
        System.out.println(student_1);
        // 测试通过网络路径URL来获取文档
        System.out.println("===========");
        Document document1 = Jsoup.parse("https://www.baidu.com");
        System.out.println(document1);
    }

}
