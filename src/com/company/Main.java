package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        int txtLength = -1;
        int size = -1;

        ArrayList<Student> studentList = new ArrayList();
        ArrayList<String> options = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("src/rawDataU6.txt"));
        br .readLine();
        String line;
        while ((line = br.readLine()) != null)
        {
            txtLength++;

            options.add(line);

        }
        for (int i = 0; i<options.size(); i++)
        {
            if ((!options.get(i).contains("+")) || options.get(i).substring(0,1).equalsIgnoreCase("(") || options.get(i).substring(0,1).equalsIgnoreCase("A"))
            {
                options.remove(i);
            }
        }
        options.remove(26);
        String [] secretNum = new String [51];

        String [] lineOp = new String[2];
        double fr1 = 0;
        double fr2 = 0;

        double [] fr1Array = new double[options.size()];
        double [] fr2Array = new double[options.size()];

        for (int i = 0; i < options.size(); i++)
        {
            secretNum[i] = options.get(i).substring(0,2).replaceAll("\t", "");

        }
        for (int i = 0; i < options.size(); i++)
        {
            options.get(i).replaceAll("\t"," ");
//            System.out.println(options.get(i));
        }

        for (int i = 0; i < options.size(); i++)
        {
            int k = 0;
            int start = options.get(i).indexOf("\"");
            options.set(i, options.get(i).substring(start + 1));
            int end = options.get(i).indexOf("\"");
            String q = options.get(i).substring(0,end);

            if (q.contains("+"))
            {
                for (k = 0; i < q.length(); k ++)
                {
                    int indx = q.indexOf("+");
                    while (indx !=-1)
                    {
                        if (q.substring(indx + 2, indx + 4).contains("1"))
                        {
                            fr1 += 1;
                        }
                        else if (q.substring(indx + 2, indx + 4).contains("5"))
                        {
                            fr1 += .5;
                        }
                        q = q.substring(indx + 1);
                        indx = q.indexOf("+");
                    }
                    fr1Array[i] = fr1;
                    fr1 = 0;
                    q = options.get(i).substring(end + 1);
                    break;
                }
                start = q.indexOf("\"");
                q = q.substring(start + 1);
                end = q.indexOf("\"");
                if  (end != -1)
                {
                    q = q.substring(0,end);
                }
                for (k = 0; i < q.length(); k ++)
                {
                    int indx = q.indexOf("+");
                    while (indx !=-1)
                    {
                        if (q.substring(indx + 2, indx + 4).contains("1"))
                        {
                            fr2 += 1;
                        }
                        else if (q.substring(indx + 2, indx + 4).contains("5"))
                        {
                            fr2 += .5;
                        }
                        q = q.substring(indx + 1);
                        indx = q.indexOf("+");
                    }
                    fr2Array[i] = fr2;
                    fr2 = 0;
                    break;
                }
            }

        }

        for (int i = 0; i < fr1Array.length; i++)
        {
            Student s = new Student(secretNum[i], fr1Array[i], fr2Array[i], fr1Array[i] + fr2Array[i]);
            studentList.add(s);
        }
        ArrayList<Student> avgGrade = new ArrayList<>();

        double avg = 0;
        double fr1Avg = 0;
        double fr2Avg = 0;

        //BufferedReader nameFile = new BufferedReader(new FileReader("names.txt"));

        for (int i = 1; i < studentList.size(); i++)
        {
            if ((studentList.get(i).returnNum()).equalsIgnoreCase(studentList.get(i-1).returnNum()))
            {
                avg = (studentList.get(i).returnScore() + studentList.get(i-1).returnScore())/2;
                fr1Avg = (studentList.get(i).getResponse1() + studentList.get(i-1).getResponse1())/2;
                fr2Avg = (studentList.get(i).getResponse2() + studentList.get(i-1).getResponse2())/2;
                Student s = new Student(studentList.get(i).returnNum(), fr1Avg, fr2Avg, avg);
                avgGrade.add(s);
            }
            else if (studentList.get(i).returnNum().equalsIgnoreCase("12")
                    || studentList.get(i).returnNum().equalsIgnoreCase("15")
                    ||studentList.get(i).returnNum().equalsIgnoreCase("21")
                    ||studentList.get(i).returnNum().equalsIgnoreCase("25"))
            {
                Student s = new Student(studentList.get(i).returnNum(),studentList.get(i).getResponse1(), studentList.get(i).getResponse2(), studentList.get(i).returnScore());
                avgGrade.add(s);
            }
        }

        System.out.println("Secret Number" + "\t\t" + "FR1" + "\t\t\t\t" + "FR2" + "\t\t\t\t" + "AVG Total Grade");
        for (int i = 0; i<avgGrade.size();i++)
        {

            System.out.println(avgGrade.get(i).returnNum() + "\t\t\t\t\t" + avgGrade.get(i).getResponse1() + "\t\t\t\t\t" + avgGrade.get(i).getResponse2() + "\t\t\t\t"
                    + avgGrade.get(i).returnScore() + "/19");
        }










//        double total = 0;
//
//        double [] totals = new double[secretNum.length];
//
//        for (int i = 0; i < options.size(); i ++)
//        {
//            int indx = options.get(i).indexOf("+");
//            while (indx !=-1)
//            {
//                if (options.get(i).substring(indx + 2, indx + 4).contains("1"))
//                {
//                    total += 1;
//                }
//                else if (options.get(i).substring(indx + 2, indx + 4).contains("5"))
//                {
//                    total += .5;
//                }
//                options.set(i,options.get(i).substring(indx + 1));
//                indx = options.get(i).indexOf("+");
//            }
//            totals[i] = total;
//            total = 0;
//        }
//        for (int k = 0; k < options.size();k++)
//        {
//            //Student s = new Student(secretNum[k], totals[k]);
//            studentList.add(s);
//        }


    }
}
