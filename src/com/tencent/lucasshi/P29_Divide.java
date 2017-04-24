package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/16.
 */
public class P29_Divide {
    public int divide(int dividend, int divisor) {
        int prefix = 1;
        if (dividend < 0 && divisor > 0) {
            prefix = -1;
        } else if (dividend > 0 && divisor < 0) {
            prefix = -1;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;
        while (dividend >= divisor) {
            int sDivisor = divisor;
            int index = 1;
            while (sDivisor <= dividend) {
                result = index;
                index = index << 1;
                sDivisor = sDivisor << 1;
            }

            dividend = dividend - (sDivisor >> 1);
            result = result + (index >> 1);
        }

        return result * prefix;
    }
}
