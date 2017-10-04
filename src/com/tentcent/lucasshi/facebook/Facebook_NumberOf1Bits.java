package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/2.
 */
public class Facebook_NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            int k = n - 1;
            n = (n & k);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Facebook_NumberOf1Bits p = new Facebook_NumberOf1Bits();
        System.out.println(p.hammingWeight(11));
    }
}
