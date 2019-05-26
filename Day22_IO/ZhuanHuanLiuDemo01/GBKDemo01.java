package Day22_IO.ZhuanHuanLiuDemo01;


import java.io.*;

// OutputStreamWriter
public class GBKDemo01 {

    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("GBK_Demo01.txt"),"GBK");
        osw.write("这个是一个GBK编码的文件");
        osw.flush();
        osw.close();
    }

}
