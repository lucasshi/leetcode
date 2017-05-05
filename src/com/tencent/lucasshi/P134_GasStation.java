package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/4.
 */
public class P134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int size = gas.length;
        int total = 0, sum = 0, start = 0;
        for (int i = 0; i < size; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            if (sum < 0) {
                sum = (gas[i] - cost[i]);
                start = i;
            } else {
                sum = sum + (gas[i] - cost[i]);
            }
        }

        return total < 0 ? -1 : start;
    }
}
