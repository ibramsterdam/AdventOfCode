package com.company.AOC2020;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class PuzzleTemplate {
    public PuzzleTemplate(String day) {
        String dir = System.getProperty("user.dir");
        File input = new File(dir + "\\src\\com\\company\\Input\\day" + day);
        List<String> list = new ArrayList<>();

        if(!input.exists())
        {
            System.out.println("Maak input file aan");
            return;
        }
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found..");
            e.printStackTrace();
        }
        puzzleOne(list);
        puzzleTwo(list);
    }

    abstract void puzzleOne(List<String> list);
    abstract void puzzleTwo(List<String> list);

    public void answer(int answer)
    {
        System.out.println(answer);
    }

    public List<Integer> convertToInts(List<String> input)
    {
        List<Integer> ints = new ArrayList<>();
        for(String s : input)
            ints.add(Integer.parseInt(s));
        return ints;
    }

    public List<Long> convertToLongs(List<String> input)
    {
        List<Long> ints = new ArrayList<>();
        for(String s : input)
            ints.add(Long.parseLong(s));
        return ints;
    }

}
