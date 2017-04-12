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
        for (int i = 0; i < options.length; i ++)
        {
            
        }

    }
}
