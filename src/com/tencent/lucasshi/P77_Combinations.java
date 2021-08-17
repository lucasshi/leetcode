package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by fzy on 17/4/28.
 */
public class P77_Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        if (k == 1) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                result.add(Arrays.asList(i));
            }
            return result;
        } else if (n == k) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(IntStream.range(1, n + 1).boxed().collect(Collectors.toList()));
            return result;
        }

        List<List<Integer>> subResult = combine(n - 1, k - 1).stream().map(res -> {
            List<Integer> newRes = new ArrayList<>();
            newRes.addAll(res);
            newRes.add(n);
            return newRes;
        }).collect(Collectors.toList());


        List<List<Integer>> subResult2 = combine(n - 1, k);

        subResult2.addAll(subResult);
        return subResult2;
    }

    // sub
    public static void main(String[] args) {
        List<List<Integer>> result = combine(10, 2);
        System.out.println(result);
    }
}

