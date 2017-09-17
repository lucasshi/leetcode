package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by fzy on 17/9/17.
 */
public class P646_MaxiumLengthOfChain {
    class Pair {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int findLongestChain(int[][] pairs) {
        ArrayList<Pair> pairArrayList = new ArrayList<>();
        // add
        for (int i = 0; i < pairs.length; i++) {
            pairArrayList.add(new Pair(pairs[i][0], pairs[i][1]));
        }

        pairArrayList.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }

                return o1.start - o2.start;
            }
        });


        int[] dp = new int[pairArrayList.size()];
        int maxLength = 0;
        dp[dp.length - 1] = 1;
        for (int i = pairArrayList.size() - 2; i >= 0; i--) {
            dp[i] = 1; // 肯定有一个可以
            for (int j = i; j < pairArrayList.size(); j++) {
                Pair check = pairArrayList.get(i);
                Pair tail = pairArrayList.get(j);

                if (tail.start > check.end) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        P646_MaxiumLengthOfChain p = new P646_MaxiumLengthOfChain();
        System.out.println(p.findLongestChain(pairs));
    }
}
