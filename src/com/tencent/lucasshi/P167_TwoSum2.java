package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/14.
 */
public class P167_TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        int[] result = new int[2];

        while (startIndex < endIndex) {
            if (numbers[startIndex] + numbers[endIndex] == target) {
                result[0] = startIndex;
                result[1] = endIndex;
                return result;
            } else if (numbers[startIndex] + numbers[endIndex] < target) {
                startIndex += 1;
                continue;
            } else {
                endIndex -= 1;
                continue;
            }
        }

        return null;
    }
}
