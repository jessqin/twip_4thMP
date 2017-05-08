package com.company;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner test = new Scanner(new File("src/rawDataU6.txt"));

        test.nextLine();

        int txtLength = -1;
        int size = 0;

        while (test.hasNextLine())
        {
            size++;
            test.nextLine();
        }
        test.close();

        ArrayList<Student> studentList = new ArrayList();
        String [] options = new String[size];
        Scanner sc = new Scanner(new File("src/rawDataU6.txt"));
        sc.nextLine();
        while (sc.hasNextLine())
        {
            txtLength++;

            options [txtLength] = sc.nextLine();
        }

        String [] secretNum = new String [27];

        for (int i = 0; i < options.length; i++)
        {
            if (!options[i].substring(0, 2).replaceAll("//s","").contains("(") || !options[i].substring(0, 2).replaceAll("//s","").contains("A"))
            {
                secretNum[i] = options[i];
            }
        }

        double total = 0;

        for (int i = 0; i < options.length; i ++)
        {
            options[i] = options[i].replaceAll("//s", "");
        }

        for (int k = 0; k<options.length; k++)
        {
            for (int i = 0; i < options.length; i ++)
            {
                int indx = options[i].indexOf("+");
                if (indx != -1)
                {
                    options[i] = options[i].substring(0,indx) + options[i].substring(indx + 1);
                    total = total + (Double.parseDouble(options[i].substring(indx + 1, indx + 3)));
                }

            }
            Student s = new Student(secretNum[k], total);
            studentList.add(s);
        }

    }
}
