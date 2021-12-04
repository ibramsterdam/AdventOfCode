package com.company.AOC2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day4 {
    public Day4() {
        getInput();
    }

    void getInput() {
        String dir = System.getProperty("user.dir");
        File input = new File(dir + "\\src\\com\\company\\Input\\day4");
        List<String> bingoList = getBingoInput(input);
        List<String[][]> bingoCards = getBingoCards(input);


    }


    void puzzleOne(List<String> list) {
        System.out.println("test");

    }


    void puzzleTwo(List<String> list) {

    }

    List<String> getBingoInput(File input) {
        List<String> bingoList = null;
        try {
            Scanner scanner = new Scanner(input);
            bingoList = Arrays.asList(scanner.nextLine().split(","));

            return bingoList;

        } catch (FileNotFoundException e) {
            System.out.println("File not found..");
            e.printStackTrace();
            return bingoList;
        }
    }

    List<String[][]> getBingoCards(File input) {
        List<String[][]> bingoCardList = null;
        String[][] bingoCard = new String[4][4];
        try {
            Scanner scanner = new Scanner(input);
            skipLines(scanner, 2);
            while (scanner.hasNextLine()) {

                StringBuilder str = new StringBuilder(scanner.nextLine());
                char x = ',';
                str.setCharAt(2, x);
                str.setCharAt(5, x);
                str.setCharAt(8, x);
                str.setCharAt(11, x);
                String string = str.toString();
                string = string.replaceAll("\\s", "");


                List<String> lis = Arrays.asList(string.split(","));
                System.out.println(lis);

                for (int row = 0; row < lis.size(); row++) {
                    for (int col = 0; col < lis.size(); col++) {
                        if (lis.size() == 5) {
                            bingoCard[col][row] = lis.get(col);

                        }
                    }
                }


            }


            return bingoCardList;

        } catch (FileNotFoundException e) {
            System.out.println("File not found..");
            e.printStackTrace();
            return bingoCardList;
        }
    }

    public static void skipLines(Scanner s, int lineNum) {
        for (int i = 0; i < lineNum; i++) {
            if (s.hasNextLine()) s.nextLine();
        }
    }
}
