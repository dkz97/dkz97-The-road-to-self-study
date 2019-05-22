package day14_Collection.Demo1;


/*
 * `public boolean add(E e)`：  把给定的对象添加到当前集合中 。
 * `public void clear()` :清空集合中所有的元素。
 * `public boolean remove(E e)`: 把给定的对象在当前集合中删除。
 * `public boolean contains(E e)`: 判断当前集合中是否包含给定的对象。
 * `public boolean isEmpty()`: 判断当前集合是否为空。
 * `public int size()`: 返回集合中元素的个数。
 * `public Object[] toArray()`: 把集合中的元素，存储到数组中。
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MyCollectionDemo01 {

    public static void main(String[] args) {
        // 利用多态去创建对象
        Collection<String> coll = new ArrayList<>();
        System.out.println("刚创建的时候: " + coll);

        coll.add("AAAAA");
        coll.add("AA");
        coll.add("AAA");
        System.out.println("add()方法加入了字符串: " + coll);

        coll.remove("AA");   // 在集合中删除AA
        System.out.println(coll);

        boolean bol = coll.contains("B");   // 判断集合中是否有B
        System.out.println(bol);

        boolean bol1 = coll.isEmpty(); // 判断是否空集合
        System.out.println(bol1);

        int size = coll.size(); // 返回元素个数
        System.out.println(size);

        Object[] arr = coll.toArray();  // 把集合的数据返回存到数组中
        System.out.println(Arrays.toString(arr));

        coll.clear();   // 清空集合
        System.out.println(coll);
    }

}
