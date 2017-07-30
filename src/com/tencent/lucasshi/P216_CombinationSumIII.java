package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/7/30.
 */
public class P216_CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n, int start) {
        if (k == 1) {
            if (n > 9 || n < start) {
                return null;
            }
            List<List<Integer>> results = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            result.add(n);
            results.add(result);
            return results;
        }

        // iteration
        List<List<Integer>> value = new ArrayList<>();
        for (int i = start; i <= 9; i++) {
            List<List<Integer>> subResults = combinationSum3(k - 1, n - i, i + 1);
            if (subResults == null)
                continue;
            for (List<Integer> subResult : subResults) {
                if (!subResult.contains(i)) {
                    subResult.add(i);
                    value.add(subResult);
                }
            }
        }

        return value;
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum3(k, n, 1);
    }
}
