package com.tencent.lucasshi;

public class P1518_numWaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange)
            return numBottles;

        return helper(numBottles, 0, numExchange);
    }

    public int helper(int numBeers, int numEmpty, int numExchange) {
        if (numBeers + numEmpty < numExchange)
            return numBeers;

        return numBeers + helper((numBeers + numEmpty) / numExchange, (numBeers + numEmpty) % numExchange, numExchange);
    }
}
