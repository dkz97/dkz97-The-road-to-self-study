package Day21_File_IO.FileDemo01;

/*
File类的路径及文件名称
public String getAbsolutePath() ：返回此File的绝对路径名字符串。 无论什么路径都会转化成绝对路径 FileAbsolutePath
public String getPath() ：将此File转换为路径名字符串。   File创建的是什么路径就输出什么路径
public String getName() ：返回由此File表示的文件或目录的名称。
public long length() ：返回由此File表示的文件的长度。
*/

import java.io.File;

public class FileDemo02 {

    public static void main(String[] args) {
        File file = new File("/Users/User/Desktop/Java Workspace/a.txt");
        File file1 = new File("a.txt");

        show1(file);
        show1(file1);
        System.out.println("-----------------");
        show2(file);
        show2(file1);
        System.out.println("-----------------");
        show3(file);
        show3(file1);
        System.out.println("-----------------");
        show4(file);
        show4(file1);

    }

    static void show1(File file) {
        // 返回据对路径字符串
        String str = file.getAbsolutePath();
        System.out.println(str);

    }

    static void show2(File file) {
        String str = file.getPath();
        System.out.println(str);
    }

    static void show3(File file) {
        String name = file.getName();
        System.out.println(name);
    }

    static void show4(File file) {
        long long1 = file.length();
        System.out.println(long1);
    }
}
