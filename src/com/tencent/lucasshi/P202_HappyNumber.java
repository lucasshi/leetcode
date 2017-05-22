package com.tencent.lucasshi;

import java.util.HashSet;

/**
 * Created by fzy on 17/5/21.
 */
public class P202_HappyNumber {
    HashSet<Integer> isExists = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }

        if (isExists.contains(sum)) {
            return false;
        }

        isExists.add(sum);
        return isHappy(sum);
    }
}
