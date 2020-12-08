package com.learning.es.api.model;

/**
 * @Author wwwang7
 * @Date 2019/1/2 15:02
 */
public class EsResponse {

    private String name;
    private String job;
    private int level;
    private String sex;
    private String book;
    private int age;

    @Override
    public String toString() {
        return "EsResponse{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", level=" + level +
                ", sex='" + sex + '\'' +
                ", book='" + book + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
