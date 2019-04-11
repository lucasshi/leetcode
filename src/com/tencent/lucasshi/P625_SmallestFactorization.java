package com.tencent.lucasshi;

public class P625_SmallestFactorization {
    public int smallestFactorization(int a) {
        int a1 = (int)(Math.sqrt(a));
        int b1 = a1;
        while (a1 * b1 != a) {
            if (a1 * b1 < a) {
                b1 += 1;
            } else {
                a1 -= 1;
            }
        }

        return a1 + b1;
    }
}
