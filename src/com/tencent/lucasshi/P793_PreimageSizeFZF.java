package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P793_PreimageSizeFZF {
    public int helper(int number) {
        int result = 0;
        while (number % 5 == 0) {
            number = number / 5;
            result += 1;
        }
        return result;
    }

    public int preimageSizeFZF(int K) {
        ArrayList<int[]> tuples = new ArrayList<>();
        int number = 5;
        tuples.add(new int[]{5, 1});

        int index = 1;
        while (true) {
            number += 5;
            int offset = helper(number);
            index += offset;
            tuples.add(new int[]{number, index});
            if (index > K) {
                break;
            }
        }

        for (int i = 0; i < tuples.size(); i++) {
            System.out.println(tuples.get(i)[0] + " " + tuples.get(i)[1]);
        }

        int[] last = tuples.get(tuples.size() - 1);
        int[] second = tuples.get(tuples.size() - 2);

        if (second[1] != K)
            return 0;
        return last[0] - second[0];
    }

    public static void main(String[] args) {
        P793_PreimageSizeFZF p = new P793_PreimageSizeFZF();
        System.out.println(p.preimageSizeFZF(10));
    }
}
