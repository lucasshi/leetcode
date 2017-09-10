package com.tencent.lucasshi;

/**
 * Created by fzy on 17/7/31.
 */
public class P231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        if (n % 2 == 0)
            return isPowerOfTwo(n / 2);
        return false;
    }
}
