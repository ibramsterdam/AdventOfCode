package com.company.AOC2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day3 extends PuzzleTemplate {
    public Day3(String day) {
        super(day);
    }

    @Override
    void puzzleOne(List<String> list) {
        int gamma;
        int epsilon;
        StringBuilder gammaRate = new StringBuilder();

        for (int i = 0; i < list.get(0).length(); i++) {
            int count1 = 0;
            int count0 = 0;

            for (String bits : list) {
                String[] bit = bits.split("");
                if (bit[i].equals("1")) {
                    count1++;
                } else {
                    count0++;
                }
            }

            if (count1 > count0) {
                gammaRate.append("1");
            } else {
                gammaRate.append("0");
            }
        }

        epsilon = Integer.parseInt(invertStr(gammaRate.toString()), 2);
        gamma = Integer.parseInt(gammaRate.toString(), 2);
        answer(epsilon * gamma);

    }




    @Override
    void puzzleTwo(List<String> list) {
        int lifeSupport = 0;
        int oxygenGenerator = 0;
        List<String> lifeList = new ArrayList<>(list);
        List<String> oxyList = new ArrayList<>(list);

        //lifeSupport
        for (int i = 0; i < list.get(0).length(); i++) {
            int count1 = 0;
            int count0 = 0;
            //Get OxyStats
            int[] OxyResult = count(oxyList, i, count0, count1);
            oxyList = findRatingOxygen(oxyList, i, OxyResult[0], OxyResult[1]);

            //Get LifeStats
            int[] LifeResults = count(lifeList, i, count0, count1);
            lifeList = findRatingLife(lifeList, i, LifeResults[0], LifeResults[1]);

            for (int j = 0; j < list.size(); j++) {
                if (!Objects.equals(lifeList.get(j), "xxxxxxxxxxxx")){
                    lifeSupport = Integer.parseInt(lifeList.get(j), 2);
                }
                if (!Objects.equals(oxyList.get(j), "xxxxxxxxxxxx")){
                    oxygenGenerator = Integer.parseInt(oxyList.get(j), 2);
                }
            }
        }

        answer(lifeSupport * oxygenGenerator);


    }

    public int[] count(List<String> list, int iteration, int count0, int count1){
        for (String s : list) {
            if (String.valueOf(s.charAt(iteration)).equals("1")) {
                count1++;
            } else if (String.valueOf(s.charAt(iteration)).equals("0")){
                count0++;
            }
        }
        return new int[]{count0, count1};
    }

    public List<String> findRatingLife(List<String> lis, int iteration, int count0, int count1){
        int remaining=0;
        for(String item : lis){
            if (!item.equals("xxxxxxxxxxxx"))remaining++;
        }
        if (remaining == 1) return lis;

        if (count0 > count1) {
            for (int j = 0; j < lis.size(); j++) {
                String str = lis.get(j);
                if (String.valueOf(str.charAt(iteration)).equals("1")) {
                    lis.set(lis.indexOf(str), "xxxxxxxxxxxx");
                }
            }
        } else {
            for (int j = 0; j < lis.size(); j++) {
                String str = lis.get(j);
                if (String.valueOf(str.charAt(iteration)).equals("0")) {
                    lis.set(lis.indexOf(str), "xxxxxxxxxxxx");
                }
            }
        }

        return lis;
    }

    public List<String> findRatingOxygen(List<String> lis, int iteration, int count0, int count1){
        int remaining=0;
        for(String item : lis){
            if (!item.equals("xxxxxxxxxxxx"))remaining++;
        }
        if (remaining == 1) return lis;

        if (count1 > count0) {
            for (int j = 0; j < lis.size(); j++) {
                String str = lis.get(j);
                if (String.valueOf(str.charAt(iteration)).equals("1")) {
                    lis.set(lis.indexOf(str), "xxxxxxxxxxxx");
                }
            }
        } else {
            if (count0 == count1) {
                for (int j = 0; j < lis.size(); j++) {
                    String str = lis.get(j);
                    if (String.valueOf(str.charAt(iteration)).equals("1")) {
                        lis.set(lis.indexOf(str), "xxxxxxxxxxxx");
                    }
                }
            } else {
                for (int j = 0; j < lis.size(); j++) {
                    String str = lis.get(j);
                    if (String.valueOf(str.charAt(iteration)).equals("0")) {
                        lis.set(lis.indexOf(str), "xxxxxxxxxxxx");
                    }
                }
            }

        }

        return lis;
    }

    public String invertStr(String str) {
        String[] inverted = str.split("");

        for (int i = 0; i < inverted.length; i++) {
            if (inverted[i].equals("1")) {
                inverted[i] = "0";
            } else {
                inverted[i] = "1";
            }
        }

        return String.join("", inverted);
    }

}
