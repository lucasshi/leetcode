package com.tencent.lucasshi;

public class P875_minEatingSpeed {
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = 1_000_000_000;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (!possible(piles, H, mi))
                lo = mi + 1;
            else
                hi = mi;
        }

        return lo;
    }

    // Can Koko eat all bananas in H hours with eating speed K?
    public boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p: piles)
            time += (p-1) / K + 1;
        return time <= H;
    }

    public static void main(String[] args) {
        P875_minEatingSpeed p = new P875_minEatingSpeed();
        int[] piles = {3,6,7,11};
        System.out.println(p.minEatingSpeed(piles, 8));
    }
}
