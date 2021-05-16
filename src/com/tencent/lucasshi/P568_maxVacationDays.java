package com.tencent.lucasshi;

public class P568_maxVacationDays {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int cityLength = flights.length;
        int dayLength = days.length;

        int[][] dp = new int[cityLength][dayLength];

        for (int j = 0; j < dayLength; j++) {
            for (int i = 0; i < cityLength; i++) {
                if (j == 0) {
                    if (flights[0][i] == 1 || i == 0) { // since start from 0
                        dp[i][j] = days[i][0];
                    }
                } else {
                    for (int k = 0; k < cityLength; k++) {
                        if (dp[k][j - 1] != 0 && (flights[k][i] == 1 ||k == i)) {
                            dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + days[i][j]);
                        }
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < cityLength; i++)
            max = Math.max(max, dp[i][dayLength - 1]);
        return max;
    }

    public static void main(String[] args) {
        P568_maxVacationDays p568_maxVacationDays = new P568_maxVacationDays();
        int[][] flights = {{0,1,1},{1,0,1},{1,1,0}};
        int[][] days = {{1,3,1},{6,0,3},{3,3,3}};
        p568_maxVacationDays.maxVacationDays(flights, days);
    }
}
