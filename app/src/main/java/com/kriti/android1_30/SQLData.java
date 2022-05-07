package com.kriti.android1_30;

public class SQLData
{
    int rollno;
    String name;
    String gender;
    double marks;

    SQLData(int rollno, String name, String gender, double marks)
    {
        this.rollno = rollno;
        this.name = name;
        this.gender = gender;
        this.marks = marks;
    }

    public String toString()
    {
        return this.rollno + ". " + this.name + " " + this.gender + " " + this.marks;
    }

}
