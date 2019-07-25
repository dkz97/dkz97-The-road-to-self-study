package dkz97.domain;

import java.io.Serializable;

public class User implements Serializable {

    private String uname;
    private String age;

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
