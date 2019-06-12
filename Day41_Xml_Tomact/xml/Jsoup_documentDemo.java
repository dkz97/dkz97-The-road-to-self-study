package Day41_Xml_Tomact.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
/*获取Element对象:
    getElementById​(String id)：根据id属性值获取唯一的element对象
    getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
    getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
    getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合*/

public class Jsoup_documentDemo {

    public static void main(String[] args) throws Exception {
        String path = Jsoup_documentDemo.class.getClassLoader().getResource("student.xml").toURI().getPath();

        Document document = Jsoup.parse(new File(path),"utf-8");
        //    getElementById​(String id)：根据id属性值获取唯一的element对象
        Element element = document.getElementById("1");
        System.out.println(element);

        System.out.println("====================");
        //    getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
        Elements elements1 = document.getElementsByAttribute("number");
        System.out.println(elements1);

        System.out.println("====================");
        //    getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
        Elements elements2 = document.getElementsByAttributeValue("number","001");
        System.out.println(elements2);
        System.out.println("===================");


    }

}
