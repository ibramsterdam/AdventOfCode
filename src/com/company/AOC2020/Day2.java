package com.company.AOC2020;

import java.util.List;

public class Day2 extends PuzzleTemplate {

    public Day2(String day) {
        super(day);
    }

    @Override
    void puzzleOne(List<String> list) {
        int horizontalPos = 0;
        int depth = 0;

        for (String e : list) {
            e = e.replaceAll("\\s+", "");

            if (e.contains("forward")) {
                e = e.replaceAll("forward", "");
                horizontalPos += Integer.parseInt(e);

            }if (e.contains("down")) {
                e = e.replaceAll("down", "");
                depth += Integer.parseInt(e);

            }if (e.contains("up")) {
                e = e.replaceAll("up", "");
                depth -= Integer.parseInt(e);

            }
        }
            System.out.println("puzzleOne = " + horizontalPos * depth);
    }

    @Override
    void puzzleTwo(List<String> list) {
        int horizontalPos = 0;
        int depth = 0;
        int aim = 0;

        for (String e : list) {
            e = e.replaceAll("\\s+", "");

            if (e.contains("forward")) {
                e = e.replaceAll("forward", "");
                horizontalPos += Integer.parseInt(e);
                if (aim > 0) depth += aim * Integer.parseInt(e);

            }

            if (e.contains("down")) {
                e = e.replaceAll("down", "");
                aim += Integer.parseInt(e);

            }

            if (e.contains("up")) {
                e = e.replaceAll("up", "");
                aim -= Integer.parseInt(e);

            }

        }

        System.out.println("puzzleTwo = " + horizontalPos * depth);
    }
}
