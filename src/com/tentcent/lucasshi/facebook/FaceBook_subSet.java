package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/2.
 */
public class FaceBook_subset {
    public double getResult(int i, int j) {
        double sum = 0;
        System.out.println(i + " " + j);
        for (int k = i + 1; k <= j; k++) {
            sum += Math.pow(2, j - i - 1);
        }
        return sum;
    }

    public double subSet(int[] nums, int k) {
        int i = 0;
        int j = nums.length - 1;

        // doSub
        double result = 0;
        while (i <= j) {
            if (nums[i] + nums[j] < k) {
                result += getResult(i, j);
                i++;
            } else {
                j--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 5, 7};
        int k = 8;

        FaceBook_subset p = new FaceBook_subset();
        System.out.println(p.subSet(A, k));
    }
}
