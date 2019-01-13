package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

public class P842_SplitIntoFibonacci {
    public List<Integer> splitIntoFibonacci(String S) {
        for (int i = 1; i < S.length(); i++) {
            for (int j = i + 1; j < S.length(); j++) {
                ArrayList<Integer> res = new ArrayList<>();
                if (helper(i, j, S, res)) {
                    return res;
                }
            }
        }
        return new ArrayList<Integer>();
    }

    public boolean helper(int first, int second, String S, ArrayList<Integer> res) {
        int f = Integer.parseInt(S.substring(0, first));
        int s = Integer.parseInt(S.substring(first + 1, second));
        int index = s;
        res.add(f);
        res.add(s);

        while (index < S.length()) {
            int nextInt = f + s;
            String next = f + s + "";
            if (S.substring(index + 1, next.length()).equals(next)) {
                index = index + next.length();
                f = s;
                s = nextInt;
                res.add(nextInt);
            } else {
                return false;
            }
        }
        return true;
    }
}
