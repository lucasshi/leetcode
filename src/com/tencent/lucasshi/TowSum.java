package com.tencent.lucasshi;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by fzy on 16/9/11.
 */
public class TowSum {
    class MyNumber implements Comparable<MyNumber> {
        public Integer num;
        public int index;

        @Override
        public int compareTo(MyNumber other) {
            return this.num.compareTo(other.num);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        MyNumber[] numList = new MyNumber[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numList[i] = new MyNumber();
            numList[i].num = nums[i];
            numList[i].index = i;
        }

        Arrays.sort(numList);
        int[] solution = new int[2];
        // 进行查询

        for (int i = 0, j = numList.length - 1; i < j; ) {
            if (numList[i].num + numList[j].num == target) {
                solution[0] = numList[i].index;
                solution[1] = numList[j].index;
                return solution;
            } else if (numList[i].num + numList[j].num > target) {
                j--;
            } else if (numList[i].num + numList[j].num < target) {
                i++;
            }
        }

        return solution;
    }

    public static void main(String[] args) {
        TowSum towSum = new TowSum();
        int[] nums = {150, 24, 79, 50, 88, 345, 3};
        towSum.twoSum(nums, 200);
    }
}
