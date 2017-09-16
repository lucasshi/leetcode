package com.tencent.lucasshi;

import java.util.HashMap;

/**
 * Created by fzy on 17/9/10.
 */
public class P279_PerfectSquares {
    private HashMap<Integer, Integer> cacheResult = new HashMap<>();

    public int numSquares(int n) {
        int k = (new Double(Math.sqrt(n))).intValue();
        if (k * k == n) {
            cacheResult.put(n, 1);
            return 1;
        }

        if (cacheResult.containsKey(n))
            return cacheResult.get(n);

        // other
        int minNum = 10000;
        for (int i = k; i > 0; i--) {
            int subNumSquares = numSquares(n - i * i);
            minNum = Math.min(minNum, subNumSquares + 1);
        }

        cacheResult.put(n, minNum);
        return minNum;
    }

    public static void main(String[] args) {
        int k = (new Double(Math.sqrt(3))).intValue();
        //System.out.println(k);
        P279_PerfectSquares p279_perfectSquares = new P279_PerfectSquares();
        System.out.println(p279_perfectSquares.numSquares(12));
    }
}
