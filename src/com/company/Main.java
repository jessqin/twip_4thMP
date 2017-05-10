package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader test = new BufferedReader(new FileReader("src/rawDataU6.txt"));

        int txtLength = -1;
        int size = -1;

        while (test.readLine() != null)
        {
            size++;
        }
        test.close();

        ArrayList<Student> studentList = new ArrayList();
        String [] options = new String[size];

        BufferedReader br = new BufferedReader(new FileReader("src/rawDataU6.txt"));
        br .readLine();
        String line;
        while ((line = br.readLine()) != null)
        {
            txtLength++;

            options [txtLength] = line;

        }
        for (int i = 0; i<options.length; i++)
        {
            System.out.println(options[i]);
        }


        String [] secretNum = new String [27];

        for (int i = 0; i < options.length; i++)
        {
            if (!options[i].contains("+"))
            {
                if (!options[i].substring(0, 2).replaceAll("//s","").contains("(") && !options[i].substring(0, 2).replaceAll("//s","").contains("A"))
                {
                    secretNum[i] = options[i].substring(0,2);
                }
            }

        }

        double total = 0;

        for (int i = 0; i < options.length; i++)
        {
            options[i] = options[i].replaceAll("//s", "");
        }

        for (int k = 0; k<options.length; k++)
        {
            for (int i = 0; i < options.length; i ++)
            {
                int indx = options[i].indexOf("+");
                if (indx != -1 && (options[i].substring(i+1, i+2).equalsIgnoreCase("1") || options[i].substring(i+1, i+2).equalsIgnoreCase(".")))
                {
                    options[i] = options[i].substring(0,indx) + options[i].substring(indx + 1);
                    total = total + (Double.parseDouble(options[i].substring(indx + 1, indx + 3)));
                }

            }
            Student s = new Student(secretNum[k], total);
            studentList.add(s);
        }

        double avg;


    }
}
