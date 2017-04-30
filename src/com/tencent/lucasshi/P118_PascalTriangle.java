package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/4/30.
 */
public class P118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        // iteration
        for (int i = 0; i < numRows; i++) {
            if (result.size() == 0) {
                ArrayList<Integer> subResult = new ArrayList<>();
                subResult.add(1);
                result.add(subResult);
                continue;
            }

            // last result
            List<Integer> lastResult = result.get(i - 1);
            ArrayList<Integer> subResult = new ArrayList<>();
            subResult.add(1);
            for (int j = 1; j < lastResult.size(); j++) {
                subResult.add(lastResult.get(j) + lastResult.get(j - 1));
            }
            subResult.add(1);
            result.add(subResult);
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ko = new ArrayList<>();
        ko.add(1);
        ArrayList<Integer> ko2 = ko;
        ko = new ArrayList<>();
        System.out.println(ko2.size());
    }
}
