package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/16.
 */
public class P191_NumOfBits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int x = 0;
        while (n != 0) {
            n = n & n - 1;
            x++;
        }

        return x;
    }
}
