package com.tencent.lucasshi;

public class P266_canPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        int[] bits = new int[256];
        for (int i = 0; i < s.length(); i++)
            bits[Character.getNumericValue(s.charAt(i))] += 1;

        boolean meetOdd = false;
        for (int i = 0; i < bits.length; i++) {
           if (meetOdd && bits[i] % 2 == 1)
               return false;
           else if (bits[i] % 2 == 1)
               meetOdd = true;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Character.getNumericValue('c'));
    }
}
