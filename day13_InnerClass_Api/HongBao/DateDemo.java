package day13_InnerClass_Api.HongBao;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

    public DateDemo() {
    }

    public static void main(String[] args) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月DD日 HH时mm分ss秒");
        Date date = new Date();
        System.out.println(date);
        // 获得系统时间的毫秒值并且利用format方法转换成格式
        String time = simpleDateFormat.format(date.getTime());
        System.out.println(time);


    }

}
