package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/4/28.
 */
public class P77_Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        // 空的
        if (n < k) {
            return null;
        }

        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                ArrayList<Integer> res = new ArrayList<>();
                res.add(i);
                result.add(res);
            }

            return result;
        }

        List<List<Integer>> subResult = combine(n - 1, k);
        List<List<Integer>> subResult2 = combine(n - 1, k - 1);


        if (subResult2 != null) {
            for (List<Integer> subs : subResult2) {
                subs.add(n);
            }
            for (List<Integer> subRes : subResult2) {
                if (subRes.size() != 0) {
                    result.add(subRes);
                }
            }
        }

        if (subResult != null) {
            for (List<Integer> subRes : subResult) {
                if (subRes.size() != 0) {
                    result.add(subRes);
                }
            }
        }

        return result;
    }

    // sub
    public static void main(String[] args) {
        List<List<Integer>> result = combine(10, 2);
    }
}

