package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.Map;

public class P904_totalFruit {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> windows = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        while (left <= right && left != fruits.length) {
            if (windows.size() <= 2 && right != fruits.length) {
                windows.putIfAbsent(fruits[right], 0);
                windows.put(fruits[right], windows.get(fruits[right]) + 1);
                right += 1;
            } else {
                windows.put(fruits[left], windows.get(fruits[left]) - 1);
                if (windows.get(fruits[left]) == 0)
                    windows.remove(fruits[left]);
                left += 1;
            }

            if (windows.size() <= 2) {
                max = Math.max(max, right - left);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        P904_totalFruit p904_totalFruit = new P904_totalFruit();
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(p904_totalFruit.totalFruit(fruits));
    }
}
