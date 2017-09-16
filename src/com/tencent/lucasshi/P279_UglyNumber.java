package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by fzy on 17/9/10.
 */
public class P279_UglyNumber {

    public int nthUglyNumber(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> resHashSet = new HashSet<>();
        int startTwoIndex = 0;
        int startThreeIndex = 0;
        int startFiveIndex = 0;

        res.add(1);
        while (res.size() < n) {
            boolean added = false;
            int startTwo = res.get(startTwoIndex) * 2;
            int startThree = res.get(startThreeIndex) * 3;
            int startFive = res.get(startFiveIndex) * 5;

            int min = Math.min(Math.min(startTwo, startThree), startFive);
            if (!resHashSet.contains(min)) {
                res.add(min);
                resHashSet.add(min);
            }

            if (startTwo == min) {
                startTwoIndex++;
                continue;
            }

            if (startThree == min) {
                startThreeIndex++;
                continue;
            }

            if (startFive == min) {
                startFiveIndex++;
                continue;
            }
        }

        for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i) + " ");
        System.out.println();
        return res.get(n - 1);
    }

    public static void main(String[] args) {
        P279_UglyNumber p279_uglyNumber = new P279_UglyNumber();
        p279_uglyNumber.nthUglyNumber(12);
    }
}
