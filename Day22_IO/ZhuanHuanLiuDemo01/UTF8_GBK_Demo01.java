package Day22_IO.ZhuanHuanLiuDemo01;


import java.io.*;

// 将GBK编码的文件转化成UTF-8的文件
public class UTF8_GBK_Demo01 {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("GBK_Demo01.txt"),"GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("UTF-8_Demo01.txt"));
        char[] chars = new char[1024];
        int len = 0;
        while ((len = isr.read(chars)) != -1) {
            osw.write(chars,0,len);
            osw.write("然后转换成UTF-8了");
        }
        isr.close();
        osw.close();
    }

}
