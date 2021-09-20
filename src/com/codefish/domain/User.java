package com.codefish.domain;/**
 * @author codefish
 * @date 9/20/2021
 * @apinote
 */

/**
 * @author: codefish
 * @discription:
 */
public class User {
    private String userName;
    private Integer age;
    private String passWord;

    public User() {
    }

    public User(String userName, Integer age, String passWord) {
        this.userName = userName;
        this.age = age;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
