package day6_api_basis;


import java.util.ArrayList;

// 用数组来存储对象
public class ArrayListDemo {

    public static void main(String[] args) {
        // 创建ArrayList集合对象
        ArrayList<String> list = new ArrayList<>();
        add(list);
        System.out.println(list);

        // ArrayList获取对象
        String str = list.get(1);
        System.out.println(str);
        // ArrayList删除对象
        String remove = list.remove(0);
        System.out.println(remove);

        // 创建基础数据类型的包装类对象
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        int num = list1.remove(1);
        System.out.println(num);
    }

    // 用数组来存储对象
    public static void array() {
        Person p1 = new Person("赵利用",12);
        Person p2 = new Person();
        Person p3 = new Person();

        // 将p1 p2 p3的地址值存到数里面去
        Person[] persons = {p1, p2 ,p3};
        System.out.println(persons[0]);
    }

    // ArrayList添加对象
    public static void add(ArrayList<String> list) {
        list.add("赵丽颖");
        list.add("赵又廷");
    }



}
