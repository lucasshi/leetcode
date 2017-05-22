package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/5/21.
 */
public class P204_CountPrimes {
    boolean[] noPrimeArray;

    public int countPrimes(int n) {
        noPrimeArray = new boolean[n];
        for (int i = 1; i <= Math.sqrt(n); i++) {
            isPrime(i);
        }

        int count = 0;
        for (int i = 2; i < noPrimeArray.length;i++) {
            if (noPrimeArray[i] == false) {
                count++;
            }
        }

        return count;
    }

    public boolean isPrime(int k) {
        if (k == 1) {
            return true;
        }

        if (k == 2) {
            return true;
        }

        if (noPrimeArray[k] == true) {
            return false;
        }

        // 不是质数
        if (k % 2 == 0) {
            noPrimeArray[k] = true;
            return false;
        }

        for (int i = 2; i <= Math.sqrt(k); i++) {
            if (k % i == 0) {
                noPrimeArray[k] = true;
                return false;
            }
        }


        for (int i = 1; i < noPrimeArray.length; i++) {
            if (i * k >= noPrimeArray.length) {
                break;
            }
            noPrimeArray[i * k] = true;
        }

        return true;
    }
}
