package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/9/16.
 */
public class P282_ExpressionAddOp {
    private List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        for (int i = 0; i < num.length(); i++) {
            int prevNum = Integer.valueOf(num.substring(0, i + 1));
            dfs(num, "" + prevNum, '+', 0, prevNum, i + 1, target);
        }
        return result;
    }

    public void dfs(String num, String expression, char prevOperator, int resWithOutPrev, int prev, int index, int target) {
        if (index == num.length()) {
            int finalResult = prevOperator == '+' ? resWithOutPrev + prev: resWithOutPrev - prev;
            if (finalResult == target)
                result.add(expression);
        }

        int newResWithoutPrev = prevOperator == '+' ? resWithOutPrev + prev: resWithOutPrev - prev;
        for (int i = index; i < num.length(); i++) {
            int bucketNum = Integer.valueOf(num.substring(index, i + 1));
            // adding +
            dfs(num, expression + "+" + bucketNum, '+', newResWithoutPrev, bucketNum, i + 1, target);
            dfs(num, expression + "-" + bucketNum, '-', newResWithoutPrev, bucketNum, i + 1, target);
            // since not change
            dfs(num, expression + "*" + bucketNum, prevOperator, resWithOutPrev, prev * bucketNum, i + 1, target);
        }
    }

    public static void main(String[] args) {
        P282_ExpressionAddOp p282_expressionAddOp = new P282_ExpressionAddOp();
        System.out.println(p282_expressionAddOp.addOperators("232", 8));
    }
}
