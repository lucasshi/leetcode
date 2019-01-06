package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashSet;

public class P787_FindCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[n][K + 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < K + 2; j++) {
                dp[i][j] = -1;
            }
        }

        dp[dst][0] = 0;
        int[][] connects = new int[n][n];
        for (int i = 0; i < flights.length; i++) {
            int start = flights[i][0];
            int end = flights[i][1];
            connects[start][end] = flights[i][2];
        }

        for (int j = 1; j < K + 2; j++) {
            for (int i = 0; i < n; i++) {
                if (i == dst)
                    continue;
                for (int p = 0; p < n; p++) {
                    if (connects[i][p] == 0 || i == p || dp[p][j - 1] == -1)
                        continue;
                    if (dp[i][j] == -1)
                        dp[i][j] = 1000;
                    dp[i][j] = Math.min(dp[i][j], dp[p][j - 1] + connects[i][p]);
                }
            }
        }

        int minPrices = Integer.MAX_VALUE;
        for (int i = 0; i < K + 2; i++) {
            if (dp[src][i] == -1)
                continue;
            minPrices = Math.min(dp[src][i], minPrices);
        }
        return minPrices;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] flghts = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        P787_FindCheapestPrice p = new P787_FindCheapestPrice();
        System.out.println(p.findCheapestPrice(3, flghts, 0, 2, 1));
    }
}
