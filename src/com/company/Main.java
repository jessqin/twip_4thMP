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


//        for (int i = 0; i<options.size(); i++)
//        {
//            System.out.println(options.get(i));
//        }


        String [] secretNum = new String [51];


        double total = 0;

        for (int i = 0; i < options.size(); i++)
        {
            options.set(i,options.get(i).replaceAll("\t"," "));
        }

        for (int i = 0; i < options.size(); i++)
        {
            secretNum[i] = options.get(i).substring(0,2);

        }

        for (int k = 0; k<secretNum.length; k++)
        {
            for (int i = 0; i < options.size(); i ++)
            {
                int indx = options.get(i).indexOf("+");
                while (indx !=-1)
                {
                    if (options.get(i).substring(indx + 2, indx + 4).contains("1"))
                    {
                        total += 1;
                    }
                    else if (options.get(i).substring(indx + 2, indx + 4).contains("5"))
                    {
                        total += .5;
                    }
                    options.set(i,options.get(i).substring(indx + 1));
                    indx = options.get(i).indexOf("+");
                }

            }
            Student s = new Student(secretNum[k], total);
            studentList.add(s);
            total = 0;
        }

        ArrayList<Student> avgGrade = new ArrayList<>();
        System.out.println("Secret Number" + "\t\t" + "Score");
        for (int i = 0; i<studentList.size();i++)
        {

            System.out.println(studentList.get(i).returnNum() + "\t\t\t\t\t" + studentList.get(i).returnScore());
        }


    }
}
