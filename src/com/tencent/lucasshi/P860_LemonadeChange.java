package com.tencent.lucasshi;

import java.util.HashMap;

public class P860_LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] leftMoney = new int[5];
        for (int i = 0; i < bills.length; i++) {
            System.out.println(bills[i]);
            if (!helper(leftMoney, (bills[i] - 5) / 5)) {
                for (int j = 0; j < leftMoney.length; j++)
                    System.out.print(leftMoney[j] + " ");
                System.out.println();
                return false;
            }
            leftMoney[bills[i] / 5] += 1;
            for (int j = 0; j < leftMoney.length; j++)
                System.out.print(leftMoney[j] + " ");
            System.out.println();
        }
        return true;
    }

    public boolean helper(int[] leftMoney, int needMoney) {
        for (int i = 4; i >= 1; i--) {
            if (leftMoney[i] != 0) {
                // System.out.println("5 / 1 is " + (5 % 1));
                // System.out.println("the index of " + i + " " + needMoney / i);
                int cnt = Math.min(needMoney / i, leftMoney[i]);
                leftMoney[i] -= cnt;
                needMoney -= cnt * i;
            }
            //System.out.println(needMoney);
            if (needMoney == 0)
                break;
        }
        return needMoney == 0;
    }

    public static void main(String[] args) {
        P860_LemonadeChange p = new P860_LemonadeChange();
        int[] bills = {5, 5, 5, 10, 5, 5, 10, 20, 20, 20};
        int[] bills2 = {5, 5, 5, 10, 20};
        System.out.print(p.lemonadeChange(bills2));
    }
}
