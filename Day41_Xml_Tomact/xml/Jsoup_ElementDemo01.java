package Day41_Xml_Tomact.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

public class Jsoup_ElementDemo01 {

    public static void main(String[] args) throws Exception{
        String path = Jsoup_documentDemo.class.getClassLoader().getResource("student.xml").toURI().getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        Element student = document.getElementById("2");

        // 使用Element对象来获取子元素对象
        Element name = student.getElementById("1");
        System.out.println(name);
        System.out.println("----------------------");
        Elements age = student.getElementsByTag("age");
        System.out.println(age);

        System.out.println("----------------------");
        // 获取当前element对象的属性值 attr("属性值名称")
        String id = student.attr("id");
        System.out.println(id);

        System.out.println("----------------------");
        // 获取文本内容
        String text = student.text();
        System.out.println(text);
        System.out.println("----------------------");
        String html = student.html();
        System.out.println(html);
    }

}
