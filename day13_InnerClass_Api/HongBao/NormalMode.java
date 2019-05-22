package day13_InnerClass_Api.HongBao;

import day13_InnerClass_Api.FaHongBao.red.red.OpenMode;

import java.util.ArrayList;

public class NormalMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();
        int avg = totalMoney / totalCount;  // 平均值
        int mod = totalMoney % totalCount;  // 余数

        // 把红包加到列表中
        for (int i = 0; i < totalCount - 1; i++) {
            list.add(avg);
        }
        list.add( mod + avg ); // 最后一个红包

        return list;
    }
}
