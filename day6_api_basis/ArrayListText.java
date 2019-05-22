package day6_api_basis;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class ArrayListText {

    public static void main(String[] args) {
        randit();
        person();

        ArrayList<String> list = new ArrayList<>();
        list.add("12");
        list.add("34");
        list.add("56");
        printlnarray(list);

        // 创建一个大集合 放20个随机数字
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list1.add(new Random().nextInt());
        }
        System.out.println(list1);
        // 利用方法获取集合中的偶数
        ArrayList<Integer> evenList = screen(list1);
        System.out.println(evenList);


    }

    // 生成6个1～33的随机数并且添加到集合内
    public static void randit() {
        Random ran = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int num = ran.nextInt(33) + 1;
            list.add(num);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    // 自定义四个"人"对象，并且添加到集合，然后遍历
    public static void person() {
        // 创建四个4人对象
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person p4 = new Person();
        // 添加到集合中
        ArrayList<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        // 遍历集合
        for (int i = 0; i < list.size(); i++) {
            Person p =list.get(i);
            System.out.println(p);
        }
    }

    // 定义一个方法，让集合的打印为{元素1@元素2@····}
    public static void printlnarray(ArrayList<String> list) {
        // 打印开头
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1){
                System.out.print(list.get(i));
                System.out.println("}");
                break;
            } else {
                System.out.print(list.get(i));
                System.out.print("@");
            }
        }
    }

    // 筛选集合中的偶数，放到另一个集合中
    public static ArrayList<Integer> screen(ArrayList<Integer> list) {
        ArrayList<Integer> evenList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                evenList.add(list.get(i));
            }
        }
        return evenList;
    }
}
