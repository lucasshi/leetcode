package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by fzy on 17/7/30.
 */
public class P241_diffWaysToCompute {
    public static HashMap<String, List<Integer>> tmpResult = new HashMap<>();

    public boolean isOpeartor(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> listResults = new ArrayList<>();
        if (tmpResult.containsKey(input)) {
            return tmpResult.get(input);
        }

        char operator = '\t';
        for (int i = 0; i < input.length(); i++) {
            if (isOpeartor(input.charAt(i))) {
                operator = input.charAt(i);
                String left = input.substring(0, i);
                String right = input.substring(i + 1);

                List<Integer> leftResult = diffWaysToCompute(left);
                List<Integer> rightResult = diffWaysToCompute(right);
                // 进行笛卡尔
                for (int j = 0; j < leftResult.size(); j++) {
                    for (int k = 0; k < rightResult.size(); k++) {
                        if (input.charAt(i) == '+') {
                            listResults.add(leftResult.get(j) + rightResult.get(k));
                        } else if (input.charAt(i) == '-') {
                            listResults.add(leftResult.get(j) - rightResult.get(k));
                        } else if (input.charAt(i) == '*') {
                            listResults.add(leftResult.get(j) * rightResult.get(k));
                        }
                    }
                }
            }
        }

        if (listResults.size() == 0) {
            listResults.add(Integer.parseInt(input));
        }

        tmpResult.put(input, listResults);
        return listResults;
    }

    public static void main(String[] args) {
        P241_diffWaysToCompute p241_diffWaysToCompute = new P241_diffWaysToCompute();
        List<Integer> result = p241_diffWaysToCompute.diffWaysToCompute("2*3-4*5");
        // result
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }


}
