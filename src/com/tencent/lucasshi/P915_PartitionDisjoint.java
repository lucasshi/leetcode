package com.tencent.lucasshi;

public class P915_PartitionDisjoint {
    public int partitionDisjoint(int[] A) {
        int[] maxArray = new int[A.length];
        int[] minArray = new int[A.length];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            maxArray[i] = max;
            System.out.print(maxArray[i] + " ");
        }
        System.out.println();

        int min = Integer.MAX_VALUE;
        for (int i = A.length - 1; i >= 0; i--) {
            min = Math.min(min, A[i]);
            minArray[i] = min;
            System.out.print(minArray[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < A.length; i++) {
            if (maxArray[i] < minArray[i + 1])
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        P915_PartitionDisjoint p = new P915_PartitionDisjoint();
        int[] input = {5, 0, 3, 8, 6};
        p.partitionDisjoint(input);
    }
}
