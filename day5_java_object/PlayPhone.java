package day5_java_object;

import day5_java_object.Phone;
public class PlayPhone {
    public static void main(String[] args) {
        Phone phone = new Phone();

        phone.colour = "黑色";
        phone.brand = "华为";
        phone.price = "5499";

        phone.phone();
    }
}
