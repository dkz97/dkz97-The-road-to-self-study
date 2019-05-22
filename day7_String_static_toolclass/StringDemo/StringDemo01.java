package day7_String_static_toolclass.StringDemo;


// 将数组{1,2,3}按照指定格式拼接成一个字符串，格式为[word1#word2#word3].
public class StringDemo01 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        String str = stringNums(nums);
        System.out.println(str);

    }

    // 定义一个拼接方法
    public static String stringNums(int[] nums) {
        String str = "[";
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                str += "word" + nums[i] + "]";
            } else {
                str += "word" + nums[i] + "#";
            }
        }
        return str;
    }
}
