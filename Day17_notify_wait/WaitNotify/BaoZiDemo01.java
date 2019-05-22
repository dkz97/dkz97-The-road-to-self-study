package Day17_notify_wait.WaitNotify;


// 包子类，有属性，
// 状态，有的话就true 没有的就false
public class BaoZiDemo01 {

    private String Baozi;
    boolean flage = false;

    public BaoZiDemo01() {
    }

    public BaoZiDemo01(String baozi) {
        Baozi = baozi;
    }

    public String getBaozi() {
        return Baozi;
    }

    public void setBaozi(String baozi) {
        Baozi = baozi;
    }
}
