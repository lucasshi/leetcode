package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class P465_OptimalAccountBalance {
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> balanceMap = new HashMap<>();

        int maxId = Integer.MIN_VALUE;
        for (int i = 0; i < transactions.length; i++) {
            int from = transactions[i][0];
            int to = transactions[i][1];
            int money = transactions[i][2];

            if (!balanceMap.containsKey(from))
                balanceMap.put(from, 0);
            if (!balanceMap.containsKey(to))
                balanceMap.put(to, 0);

            maxId = Math.max(maxId, from);
            maxId = Math.max(maxId, to);
            balanceMap.put(from, balanceMap.get(from) - money);
            balanceMap.put(to, balanceMap.get(to) + money);
        }

        int[] accounts = new int[maxId + 1];
        for (Integer id : balanceMap.keySet())
            accounts[id] = balanceMap.get(id);

        return helper(accounts, 0, 0);

    }

    public int helper(int[] accounts, int start, int steps) {
        int res = Integer.MAX_VALUE;
        while ( start < accounts.length && accounts[start] == 0)
            start++;
        for (int i = start + 1; i < accounts.length; i++) {
            if ((accounts[i] > 0 && accounts[start] < 0) || (accounts[i] < 0 && accounts[start] > 0)) {
                accounts[i] += accounts[start];
                res = Math.min(res, helper(accounts, start + 1, steps + 1));
                accounts[i] -= accounts[start];
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < accounts.length;i++)
            list.add(accounts[i]);
        System.out.println(list);
        return res != Integer.MAX_VALUE ? res : steps;
    }

    public static void main(String[] args) {
        int[][] input = {{0, 1, 10}, {2, 0, 5}};
        P465_OptimalAccountBalance p = new P465_OptimalAccountBalance();
        System.out.println(p.minTransfers(input));
    }
}
