package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/16.
 */
public class P29_Divide {
    public int divide(int dividend, int divisor) {
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend * divisor <  0)
            return helper(dividend, divisor) * -1;
        else
            return helper(dividend, divisor);
    }

    public int helper(int dividend, int divisor) {
        if (dividend < divisor)
            return 0;

        int d = divisor;
        int result = 1;
        int risidual = 0;

        while (d < dividend) {
            risidual = dividend - d;
            d = d * 2;
            result = result * 2;
        }

        result /= 2;
        return result + divide(risidual, divisor);
    }

    public static void main(String[] args) {
        P29_Divide p29_divide = new P29_Divide();
        System.out.println(p29_divide.divide(10, 3));
    }
}
