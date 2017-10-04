package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/2.
 */
public class FaceBook_DevideTwo {
    public int divide(int dividend, int divisor) {
        int result = 0;

        while (dividend >= divisor) {
            int sub = divisor;
            int subResult = 0;
            for (int i = 1; dividend >= sub; i++) {
                subResult = 1 << (i - 1);
                sub = (sub << 1);
            }

            result += subResult;
            dividend -= sub;
        }

        return result;
    }

    public static void main(String[] args) {
        FaceBook_DevideTwo p = new FaceBook_DevideTwo();
        System.out.println(p.divide(3, 3));
    }
}
