package com.company.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        String dir = System.getProperty("user.dir");
        try {
            File input = new File(dir + "\\src\\com\\company\\Day1\\measurements");
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                list.add(Integer.parseInt(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found..");
            e.printStackTrace();
        }


        System.out.println("Total count = " + puzzleOne(list));
        System.out.println("Sum of each three-measurements = " + puzzleTwo(list));

    }

    public static int puzzleOne(List<Integer> list) {
        int count = 0;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i - 1)) count++;
        }

        return count;
    }

    public static int puzzleTwo(List<Integer> list) {
        int count = 0;

        for (int i = 3; i < list.size(); i++) {
            if (list.get(i - 3) + list.get(i - 2) + list.get(i - 1) < list.get(i) +list.get(i - 1) + list.get(i - 2)) {
                count++;
            }
        }

        return count;
    }

}
