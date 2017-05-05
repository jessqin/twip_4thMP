package com.company;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("src/rawDataU6.txt"));

        sc.nextLine();

        int txtLength = -1;
        String [] options = new String[500];

        while (sc.hasNextLine())
        {
            txtLength++;

            options [txtLength] = sc.nextLine();
        }

        String [] numbers = new String [27];
        double total = 0;

        for (int i = 0; i < options.length; i ++)
        {
            int indx = options[i].indexOf("+");
            options[i] = options[i].substring(0,indx) + options[i].substring(indx + 1);
            total = total + (Double.parseDouble(options[i].substring(indx + 2, indx + 4)));
        }

    }
}
