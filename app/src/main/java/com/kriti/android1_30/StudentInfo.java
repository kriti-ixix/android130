package com.kriti.android1_30;

public class StudentInfo
{
    String name;
    int rollno;
    char gender;
    String subject;

    StudentInfo(String sName, int sRollNo, char sGender, String sSubject)
    {
        setName(sName);
        setRollno(sRollNo);
        setGender(sGender);
        setSubject(sSubject);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
