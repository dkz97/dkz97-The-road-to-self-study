package day14_Collection.Demo1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyIteratorDemo01 {

    public static void main(String[] args) {
        // 创建一个集合
        Collection<String> coll = new ArrayList<>();

        // 添加元素
        coll.add("第一个");
        coll.add("第二个");
        coll.add("第三个");
        coll.add("第四个");
        coll.add("第五个");

        // 获得迭代器
        Iterator<String> iter = coll.iterator();

        // 用迭代器遍历集合读取元素
        while (iter.hasNext()) {
            String str = iter.next();
            System.out.println(str);
        }
        System.out.println(coll);

        // 使用增强for循环遍历集合和数组
        for (String i : coll) {
            System.out.println(i);
        }
        bigFor();
    }


    // 增强for循环
    public static void bigFor() {
        int[] nums = {1, 3, 4, 5, 7, 8};
        for (int a : nums) {
            System.out.println(a);
        }
    }
}
