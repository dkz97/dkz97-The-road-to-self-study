package Day20_ThreadPool_Lambda.PersonDemo01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo01 {

    public static void main(String[] args) {
        PersonDemo01 p1 = new PersonDemo01("昭华",18);
        PersonDemo01 p2 = new PersonDemo01("张三",17);
        PersonDemo01 p3 = new PersonDemo01("李四",20);
        PersonDemo01 p4 = new PersonDemo01("陈峰",23);
        PersonDemo01 p5 = new PersonDemo01("王五",22);

        ArrayList<PersonDemo01> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);
        System.out.println(persons);

        Collections.sort(persons, new Comparator<PersonDemo01>() {
            @Override
            public int compare(PersonDemo01 o1, PersonDemo01 o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(persons);

        // 使用lambda表达式简化匿名内部类
        Collections.sort(persons, (PersonDemo01 o1,PersonDemo01 o2)->{
            return o2.getAge() - o1.getAge();
        });
        System.out.println(persons);
    }

}
