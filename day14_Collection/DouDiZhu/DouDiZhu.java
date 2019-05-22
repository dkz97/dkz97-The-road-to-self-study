package day14_Collection.DouDiZhu;

import java.util.*;

public class DouDiZhu {


    public static void main(String[] args) {

        ArrayList<String> cards = buyCards();
        System.out.println(cards);
        ArrayList<String> cardsEnd = washCards(cards);


        // 发牌
        ArrayList<String> play1 = new ArrayList<>();
        ArrayList<String> play2 = new ArrayList<>();
        ArrayList<String> play3 = new ArrayList<>();
        ArrayList<String> remain = new ArrayList<>();

        for (int i = 0; i < cards.size() - 3 ; i++) {
            if (i % 3 == 0) {
                play1.add(cardsEnd.get(i));
            } else if (i % 3 == 1) {
                play2.add(cardsEnd.get(i));
            } else {
                play3.add(cardsEnd.get(i));
            }
        }
        remain.add(cardsEnd.get(51));
        remain.add(cardsEnd.get(52));
        remain.add(cardsEnd.get(53));

        System.out.println(play1);
        System.out.println(play2);
        System.out.println(play3);
        System.out.println(remain);
    }

    // 创建一副牌
    public static ArrayList<String> buyCards() {
        ArrayList<String> coll = new ArrayList<>();
        String[] variety = {"♠️", "♥️", "♣️", "♦️"};
        String[] nums = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String i : variety) {
            for (String j : nums) {
                coll.add(i + " " + j);
            }
        }
        coll.add("大王");
        coll.add("小王");
        return coll;
    }

    // 洗牌
    public static ArrayList<String> washCards(ArrayList<String> cards) {
        Collections.shuffle(cards);
        return cards;
    }




}
