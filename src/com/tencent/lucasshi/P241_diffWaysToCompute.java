package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.List;

/**
 * Created by fzy on 17/7/30.
 */
public class P241_diffWaysToCompute {
    public static HashMap<String, List<String>> tmpResult = new HashMap<>();

    public boolean isOpeartor(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public List<Integer> diffWaysToCompute(String input) {
        char operator = '\t';
        for (int i = 0; i < input.length(); i++) {
            if (isOpeartor(input.charAt(i))) {
                operator = input.charAt(i);
                String left = input.substring(0, i);
                String right = input.substring(i + 1);

                List<Integer> leftResult = diffWaysToCompute(left);
                List<Integer> rightResult = diffWaysToCompute(right);
                // 进行笛卡尔
            }
        }

        return null;
    }
}
