package com.pri.entity;

/**
 * @ClassName: TestUser
 * @Description: 测试批量插入
 * @Auther: Chenqi
 * @Date: 2019/7/14 0014 下午 10:06
 * @Version 1.0 jdk1.8
 */
public class TestUser {
    private Integer uid;
    private String name;
    private int age;
    private String role;
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
