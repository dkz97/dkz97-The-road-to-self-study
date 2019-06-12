package Day41_Xml_Tomact.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;

public class Jsoup_selectorDemo {

    public static void main(String[] args) throws Exception{
        String path = Jsoup_selectorDemo.class.getClassLoader().getResource("student.xml").toURI().getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        // 通过选择器寻找id为2的元素
        Elements select = document.select("#2");
        System.out.println(select);

        System.out.println("----------------");
        // 通过选择器寻找标签为name的元素
        Elements selece1 = document.select("name");
        System.out.println(selece1);
    }

}
