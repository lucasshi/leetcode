package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/16.
 */
public class P201_BitWiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            i++;
        }

        return m << i;
    }
}
