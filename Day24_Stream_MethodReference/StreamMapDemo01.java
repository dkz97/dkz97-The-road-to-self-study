package Day24_Stream_MethodReference;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamMapDemo01 {

    public static void main(String[] args) {
        // of方法创建Stream流
        Stream<Integer> stream = Stream.of(11,12,13,4,15,16,17,8);
        // Stream流中的转换型
        Stream<String> stringStream = stream.map(i -> i.toString());
        // Stream流中的筛选型
        Stream<String> stream1 = stringStream.filter(i->i.startsWith("1"));

        // Stream流中的打印，并且终结Stream流
        stream1.forEach(i -> System.out.println(i + " 1"));
        // 统计Stream流中的个数,并且终结Stream流
        System.out.println(stream1.count());

        // 用集合创建Stream流
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        // limit切片取前3个元素
        Stream<Integer> stream2 = list.stream();
        Stream<Integer> limit = stream2.limit(3);
        limit.forEach(num->System.out.println(num));

        // of方法创建新流
        Stream<Integer> stream3 = Stream.of(11,12,13,4,15,16,17,8);
        // skip方法，跳过前n个元素截取后面的元素
        Stream<Integer> skip = stream3.skip(3);
        skip.forEach(i-> System.out.println(i));

    }

}
