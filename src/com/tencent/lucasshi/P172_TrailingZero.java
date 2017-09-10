package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/9.
 */
public class P172_TrailingZero {
    public int trailingZeroes(int n) {
        int k = 5;
        int sum = 0;

        while (n > 0) {
            sum += n / 5;
            n = n / 5;
        }

        return sum;
    }

    public static void main(String[] args) {
        P172_TrailingZero p = new P172_TrailingZero();
        System.out.println(p.trailingZeroes(1808548329));
        System.out.println(Integer.MAX_VALUE);
    }

}
