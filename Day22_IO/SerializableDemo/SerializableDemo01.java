package Day22_IO.SerializableDemo;


import java.io.*;
import java.util.ArrayList;

// 把学生类加入集合中将集合序列化
public class SerializableDemo01 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        StudentDemo01 st1 = new StudentDemo01("迪丽热巴",20);
        StudentDemo01 st2 = new StudentDemo01("古力娜扎",13);
        StudentDemo01 st3 = new StudentDemo01("陈越",30);
        StudentDemo01 st4 = new StudentDemo01("欧阳娜娜",15);

        ArrayList<StudentDemo01> list = new ArrayList<>();
        list.add(st1);
        list.add(st2);
        list.add(st3);
        list.add(st4);

        // 将list对象序列化
        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("/Users/User/Desktop/Java Workspace/src/Day22_IO/SerializableDemo/a.txt"));
        ous.writeObject(list);
        ous.close();

        // 把list对象反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/User/Desktop/Java Workspace/src/Day22_IO/SerializableDemo/a.txt"));
        Object o =  ois.readObject();
        ois.close();
        //要先把对象转化成原本的类
        ArrayList<StudentDemo01> list1 = (ArrayList<StudentDemo01>) o;

        // 遍历集合
        for (StudentDemo01 student : list1) {
            System.out.println(student);
        }



    }

}
