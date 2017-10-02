package com.tencent.lucasshi;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by fzy on 17/9/23.
 */
public class Airbnb_RoundNumber {
    public Double[] getRoundNumber(double[] input) {
        double sum = 0;
        double floorSum = 0;

        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            floorSum += Math.floor(input[i]);
        }

        double residule = Math.floor(sum) - floorSum;

        // 排序
        Double[] outputDouble = new Double[input.length];
        for (int i = 0; i < input.length; i++) {
            outputDouble[i] = input[i];
        }

        Arrays.sort(outputDouble, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                Double ceilo1 = Math.ceil(o1) - o1;
                Double ceilo2 = Math.ceil(o2) - o2;

                return ceilo1.compareTo(ceilo2);
            }
        });

        // do
        for (int i = 0; i < outputDouble.length; i++) {
            if (residule == 0) {
                outputDouble[i] = Math.floor(outputDouble[i]);
                continue;
            }

            residule -= 1;
            outputDouble[i] = Math.ceil(outputDouble[i]);
        }

        return outputDouble;
    }
}
