package Day22_IO;


import java.io.*;
import java.util.*;

// 对文本进行排序练习
public class WenbenText {

    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<>();

        BufferedReader isr = new BufferedReader(new FileReader("b.txt"));
        BufferedWriter osw = new BufferedWriter(new FileWriter("out.txt"));


        // 读取文件，并且将获取到的字符进行分离放在map集合中
        String str;
        while ((str = isr.readLine()) != null) {
            String[] str1 = str.split("\\.");
            map.put(str1[0],str1[1]);
        }
        isr.close();

        // map集合会自动排序，然后就把集合里面的写入就好
        Set<String> keys = map.keySet();
        for (String key : keys) {
            osw.write(key + "." + map.get(key));
            osw.newLine();
            osw.flush();
        }
        osw.close();
    }

}
