package day13_InnerClass_Api.HongBao;


import day13_InnerClass_Api.FaHongBao.red.red.OpenMode;

import java.util.ArrayList;
import java.util.Random;

// 随机红包
public class RandomMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();

        // 随机分配，最少一分钱，最多不超过平均数的两倍

        int remainCount = totalCount;
        for (int i = 0; i < totalCount - 1; i++) {
            int randmoney = 1 + random.nextInt(totalMoney / remainCount * 2);
            totalMoney = totalMoney - randmoney;
            remainCount -= 1;
            list.add(randmoney);
        }
        list.add(totalMoney);



        return list;
    }
}
