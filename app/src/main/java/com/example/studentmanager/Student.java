package com.example.studentmanager;

import android.os.IBinder;

public class Student {
    private String name;
    private int birthday;
    private String address;
    private String id;

    public Student(String id, String name, int birthday, String address) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
