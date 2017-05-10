package com.company;

/**
 * Created by jq210 on 5/5/17.
 */
public class Student
{
    private String num;
    private double score;
    public Student(String n, double s)
    {
        num = n;
        score = s;
    }
    public String returnNum()
    {
        return num;
    }
    public double returnScore()
    {
        return score;
    }

}
