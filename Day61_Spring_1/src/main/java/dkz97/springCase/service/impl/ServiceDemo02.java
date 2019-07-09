package dkz97.springCase.service.impl;

import java.util.Date;

public class ServiceDemo02 {

    /**
     * 使用Set方法注入
     */
    private Integer age;
    private String username;
    private Date birthday;



    @Override
    public String toString() {
        return "ServiceDemo{" +
                "age=" + age +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

