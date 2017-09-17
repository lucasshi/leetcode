package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by fzy on 17/9/17.
 */
public class P508_MostFrequetTreeSum {
    private HashMap<Integer, Integer> sumMap = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        DFS(root);
        ArrayList<Integer> list = new ArrayList<>();
        int maxCount = 0;
        // do
        for (HashMap.Entry<Integer, Integer> entry : sumMap.entrySet()) {
            maxCount = Math.max(maxCount, entry.getValue());
        }

        for (HashMap.Entry<Integer, Integer> entry : sumMap.entrySet()) {
            if (entry.getValue() == maxCount)
                list.add(entry.getKey());
            maxCount = Math.max(maxCount, entry.getValue());
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private int DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }


        int val = root.val;
        int leftSum = DFS(root.left);
        int rightSum = DFS(root.right);
        int sum = val + leftSum + rightSum;

        if (!sumMap.containsKey(sum))
            sumMap.put(sum, 0);
        sumMap.put(sum, sumMap.get(sum) + 1);

        return val + leftSum + rightSum;
    }
}
