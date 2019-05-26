package Day24_Stream_MethodReference.StreamText;

import java.util.ArrayList;

/*
1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中。
4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
5. 将两个队伍合并为一个队伍；存储到一个新集合中。
6. 根据姓名创建 Person 对象；存储到一个新集合中。
7. 打印整个队伍的Person对象信息*/
public class Demo01 {

    public static void main(String[] args) {
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");

        //1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
        ArrayList<String> newone = new ArrayList<>();
        for (String str : one) {
            if (str.length() == 3) {
                newone.add(str);
            }
        }
        //第一个队伍筛选之后只要前3个人；存储到一个新集合中。
        ArrayList<String> newone1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            newone1.add(newone.get(i));
        }

        //第二个队伍只要姓张的成员姓名；存储到一个新集合中。
        ArrayList<String> two1 = new ArrayList<>();
        for (String str : two) {
            if (str.startsWith("张")) {
                two1.add(str);
            }
        }

        //4第二个队伍筛选之后不要前2个人；存储到一个新集合中。
        ArrayList<String> newtwo = new ArrayList<>();
        for (int i =2; i<two1.size();i++) {
            newtwo.add(two1.get(i));
        }

        //将两个队伍合并为一个队伍；存储到一个新集合中。
        ArrayList<String> list = new ArrayList<>();
        list.addAll(newone1);
        list.addAll(newtwo);

        //根据姓名创建 Person 对象；存储到一个新集合中。
        ArrayList<Person> persons = new ArrayList<>();
        for (String str : list) {
            persons.add(new Person(str));
        }

        //7打印整个队伍的Person对象信息
        for (Person pe: persons) {
            System.out.println(pe);
        }
    }

}
