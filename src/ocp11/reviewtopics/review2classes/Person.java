package ocp11.reviewtopics.review2classes;

import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<String> classmate;

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
