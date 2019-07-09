package dkz97.springCase.service.impl;

import java.util.Date;

public class ServiceDemo {

    /**
     * 使用构造函数注入
     */
    private Integer age;
    private String username;
    private Date birthday;

    public ServiceDemo(Integer age, String username, Date birthday) {
        this.age = age;
        this.username = username;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "ServiceDemo{" +
                "age=" + age +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
