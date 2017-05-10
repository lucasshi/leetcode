package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by fzy on 17/5/10.
 */
public class P166_FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        int intPart = numerator / denominator;
        int residual = numerator % denominator;
        //
        String floatPart = "";
        HashMap<Integer, Integer> residualMap = new HashMap<>();
        while (true) {
            int divided = residual * 10 / denominator;
            residualMap.put(residual, divided);
            floatPart += divided;
            residual = residual * 10 % denominator;
            if (residualMap.containsKey(residual)) {
                break;
            }
        }

        System.out.println(floatPart);
        return floatPart;
    }

    public static void main(String[] args) {
        P166_FractionToDecimal
    }

}
