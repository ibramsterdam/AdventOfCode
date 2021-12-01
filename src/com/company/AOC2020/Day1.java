package com.company.AOC2020;
import java.util.*;

public class Day1 extends PuzzleTemplate {
    public Day1(String day) {
        super(day);
    }



    @Override
    void puzzleOne(List<String> list) {
        List<Integer> intList = convertToInts(list);
        int count = 0;

        for (int i = 1; i < intList.size(); i++) {
            if (intList.get(i) > intList.get(i - 1)) count++;
        }

        answer(count);
    }

    @Override
    void puzzleTwo(List<String> list) {
        List<Integer> intList = convertToInts(list);
        int count = 0;

        for (int i = 3; i < intList.size(); i++) {
            if (intList.get(i - 3) + intList.get(i - 2) + intList.get(i - 1) < intList.get(i) + intList.get(i - 1) + intList.get(i - 2)) {
                count++;
            }
        }

        answer(count);
    }
}
