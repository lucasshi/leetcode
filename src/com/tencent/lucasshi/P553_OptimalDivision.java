package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/19.
 */
public class P553_OptimalDivision {
    class DpNode {
        public double value;
        public int seperator;

        public DpNode(double value, int seperator) {
            this.value = value;
            this.seperator = seperator;
        }
    }

    public String optimalDivision(int[] nums) {
        DpNode[][] minDp = new DpNode[nums.length][nums.length];
        DpNode[][] maxDp = new DpNode[nums.length][nums.length];

        // init dp

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                minDp[i][j] = new DpNode(Double.MAX_VALUE, i);
                maxDp[i][j] = new DpNode(Double.MIN_VALUE, i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            maxDp[i][i] = new DpNode(nums[i], i);
            minDp[i][i] = new DpNode(nums[i], i);
        }


        // length是window的长度,p是起始点
        for (int length = 1; length < nums.length; length++) {
            for (int i = 0; i < nums.length; i++) {
                if (i + length >= nums.length)
                    continue;
                // num
                for (int k = i; k < i + length; k++) {
                    double minValue = minDp[i][k].value / maxDp[k + 1][i + length].value;
                    double maxValue = maxDp[i][k].value / minDp[k + 1][i + length].value;

                    if (minValue < minDp[i][i + length].value) {
                        minDp[i][i + length].value = minValue;
                        minDp[i][i + length].seperator = k;
                    }

                    if (maxValue > maxDp[i][i + length].value) {
                        maxDp[i][i + length].value = maxValue;
                        maxDp[i][i + length].seperator = k;
                    }
                }
            }


            System.out.println("end");

        }


        return printString(maxDp, minDp, 0, nums.length - 1, nums, true);
    }

    public String printString(DpNode[][] maxDp, DpNode[][] minDp, int start, int end, int[] nums, boolean useMax) {
        if (start == end) {
            return nums[start] + "";
        }
        if (start > end) {
            return "";
        }

        String left, right;
        int sepPoint = -1;
        if (useMax) {
            sepPoint = maxDp[start][end].seperator;
            left = printString(maxDp, minDp, start, sepPoint, nums, true);
            right = printString(maxDp, minDp, sepPoint + 1, end, nums, false);
        } else {
            sepPoint = minDp[start][end].seperator;
            left = printString(maxDp, minDp, start, sepPoint, nums, false);
            right = printString(maxDp, minDp, sepPoint + 1, end, nums, true);
        }

        if (right.contains("/")) {
            return left + "/(" + right + ")";
        } else if (right.length() == 0) {
            return left;
        }

        return left + "/" + right;
    }

    public static void main(String[] args) {
        int[] input = {1000, 100, 10, 2};
        P553_OptimalDivision p = new P553_OptimalDivision();
        System.out.println(p.optimalDivision(input));
    }
}
