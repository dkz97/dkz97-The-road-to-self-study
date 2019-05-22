package Day21_File_IO.FileDemo01;

/*
File 构造方法
public File(String pathname) ：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
public File(String parent, String child) ：从父路径名字符串和子路径名字符串创建新的 File实例。
public File(File parent, String child) ：从父抽象路径名和子路径名字符串创建新的 File实例。
*/

import java.io.File;

public class FileDemo01 {

    public static void main(String[] args) {
        show1();
        show2();
        show3();
    }

    static void show1() {
        File file = new File("/Users/user/Desktop/Java Workspace/a.txt");
        System.out.println(file);
    }

    static void show2() {
        File file = new File("/Users/user/Desktop/","Java Workspace/a.txt");
        System.out.println(file);
    }

    static void show3() {
        File file = new File("/Users/user/Desktop/");
        File file1 = new File(file,"Java Workspace/a.txt");
        System.out.println(file1);
    }
}
