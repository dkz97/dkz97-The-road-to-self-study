package day13_InnerClass_Api.HongBao;

import java.util.ArrayList;
import java.util.Arrays;

public class SystemDemo {

    public static void main(String[] args) {
        int[] a1 = {1,2,3,4,5,6};
        int[] a2 = {6,5,4,3,2,1};
        System.arraycopy(a1, 0, a2, 0, 2); // 原数组a1开始，给a2的0到2给复制
        System.out.println(Arrays.toString(a2));
    }

}
