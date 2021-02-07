package com.tencent.lucasshi;

import java.util.Arrays;

public class P1223_dieSimulator {
    public int dieSimulator(int n, int[] rollMax) {
        int maxRollMax = Arrays.stream(rollMax).max().getAsInt();
        int numberOfColors = 6;
        int[][][] dp = new int[n][numberOfColors][maxRollMax + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < numberOfColors; j++) {
                // the consecutive contains how many k
                for (int k = 1; k <= maxRollMax; k++) {
                    // check it
                    if (rollMax[j] < k)
                        continue;

                    // the length of the number should be longer than rollmax
                    if (i < k - 1)
                        continue;

                    if (i == 0) {
                        dp[i][j][k] = 1;
                        continue;
                    }

                    if (k == 1) {
                        int sum = 0;
                        for (int newJ = 0; newJ < numberOfColors; newJ++) {
                            for (int newK = 1; newK <= maxRollMax; newK++) {
                                if (newJ == j)
                                    continue;
                                sum = (sum + dp[i - 1][newJ][newK]) % (1000000000 + 7);
                            }
                        }
                        dp[i][j][k] = sum;
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k - 1];
                    }
                }
            }
        }

        int sum = 0;
        for (int j = 0; j < numberOfColors; j++) {
            for (int k = 1; k <= maxRollMax; k++) {
                sum = (sum + dp[n - 1][j][k]) % (1000000000 + 7);
            }
        }

        // return sum % (10^9 + 7);
        return sum;
    }

    public static void main(String[] args) {
        P1223_dieSimulator p1223_dieSimulator = new P1223_dieSimulator();
        int[] rollMax = {1,1,2,2,2,3};
        System.out.println(p1223_dieSimulator.dieSimulator(2, rollMax));
    }
}
