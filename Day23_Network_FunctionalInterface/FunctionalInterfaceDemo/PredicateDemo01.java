package Day23_Network_FunctionalInterface.FunctionalInterfaceDemo;


import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.function.Predicate;

/*数组当中有多条“姓名+性别”的信息如下，请通过 Predicate 接口的拼装将符合要求的字符串筛选到集合
ArrayList 中，需要同时满足两个条件：
1. 必须为女生；
2. 姓名为4个字。*/
public class PredicateDemo01 {

    public static void main(String[] args) {
        String[] array = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女"};
        List<String> list = screen(array,
                s->"女".equals(s.split(",")[1]),
                s->s.split(",")[0].length() == 4
        );
        System.out.println(list);
    }

    public static List<String> screen(String[] array, Predicate<String> p1, Predicate<String> p2) {
        List<String> list = new ArrayList<>();
        for (String str : array) {
            if (p1.and(p2).test(str)) { // 意思就是p1和p2传递到test()的判断中，都可返回true的话就ok
                list.add(str);  // 都符合条件就可以增加返回到列表中
            }
        }
        return list;
    }
}