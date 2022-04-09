package com.kriti.android1_30;

public class StudentData
{
    int rollno;
    String name;
    String gender;

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString()
    {
        return getRollno() + " " + getName() + " " + getGender();
    }
}
