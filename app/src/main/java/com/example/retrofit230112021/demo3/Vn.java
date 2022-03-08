package com.example.retrofit230112021.demo3;


public class Vn {

    private String name;
    private String address;
    private String course1;
    private String course2;
    private String course3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourse1() {
        return course1;
    }

    public void setCourse1(String course1) {
        this.course1 = course1;
    }

    public String getCourse2() {
        return course2;
    }

    public void setCourse2(String course2) {
        this.course2 = course2;
    }

    public String getCourse3() {
        return course3;
    }

    public void setCourse3(String course3) {
        this.course3 = course3;
    }

    @Override
    public String toString() {
        return "Vn{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", course1='" + course1 + '\'' +
                ", course2='" + course2 + '\'' +
                ", course3='" + course3 + '\'' +
                '}';
    }
}