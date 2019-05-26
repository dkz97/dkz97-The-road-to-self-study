package Day24_Stream_MethodReference.MethodReference;

public class SuperMethodDemo01 extends ObjectMethod {



    public static void addDemo (ClassInterfeceDemo01 cifd) {
        cifd.add(10);

    }

    public void add() {
        // 使用lambda表达式,super只能访问父类的成员方法
        addDemo((num)->{
            super.addDemo(num);
        });
    }

    public void add1() {
        // 使用super引用方法
        addDemo(super::addDemo);
    }

    public static void main(String[] args) {

         new SuperMethodDemo01().add();
         new SuperMethodDemo01().add1();
    }


}
