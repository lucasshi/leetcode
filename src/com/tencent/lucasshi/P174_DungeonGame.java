package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/15.
 */
public class P174_DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int height = dungeon.length;
        int width = dungeon[0].length;

        int[][] sumHp = new int[height][width];
        int[][] minHp = new int[height][width];

        if (dungeon[0][0] < 0) {
            minHp[0][0] = Math.abs(dungeon[0][0]);
            sumHp[0][0] = dungeon[0][0];
        } else {
            minHp[0][0] = 0;
            sumHp[0][0] = dungeon[0][0];
        }

        for (int i = 1; i < height; i++) {
            sumHp[i][0] = sumHp[i - 1][0] + dungeon[i][0];
            if (sumHp[i][0] < 0) {
                minHp[i][0] = Math.max(minHp[i - 1][0], -sumHp[i][0]);
            } else {
                minHp[i][0] = minHp[i - 1][0];
            }
        }

        for (int j = 1; j < width; j++) {
            sumHp[0][j] = sumHp[0][j - 1] + dungeon[0][j];
            if (sumHp[0][j] < 0) {
                minHp[0][j] = Math.max(minHp[0][j - 1], -sumHp[0][j]);
            } else {
                minHp[0][j] = minHp[0][j - 1];
            }
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                int sumDown = sumHp[i - 1][j] + dungeon[i][j];
                int minDow = Math.max(minHp[i - 1][j], -sumDown);

                int sumRight = sumHp[i][j - 1] + dungeon[i][j];
                int minRight = Math.max(minHp[i][j - 1], -sumRight);

                minHp[i][j] = Math.min(minDow, minRight);
                if (minDow < minRight) {
                    sumHp[i][j] = sumDown;
                } else if (minDow > minRight) {
                    sumHp[i][j] = sumRight;
                } else {
                    sumHp[i][j] = Math.max(sumDown, sumRight);
                }

            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(dungeon[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(sumHp[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(minHp[i][j] + ",");
            }
            System.out.println();
        }
        return minHp[height - 1][width - 1];
    }

    public static void main(String[] args) {
        int[][] m = {{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}};
        P174_DungeonGame p = new P174_DungeonGame();
        System.out.println(p.calculateMinimumHP(m));
    }
}
