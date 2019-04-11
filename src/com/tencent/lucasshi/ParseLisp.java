package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseLisp {
    public int eval(List<String> tokens) {
        if (tokens.size() == 1) {
            return Integer.parseInt(tokens.get(0));
        }
        System.out.println(tokens);
        String operator = tokens.get(1);
        ArrayList<Integer> result = new ArrayList<>();

        int cnt = 0;
        int index = 2;
        List<String> subTokens = new ArrayList<>();
        for (int i = index; i < tokens.size() - 1; i++) {
            if (tokens.get(i).equals("(")) {
                cnt += 1;
            } else if (tokens.get(i).equals(")")) {
                cnt -= 1;
            }
            subTokens.add(tokens.get(i));
            if (cnt == 0) {
                // subTokens.remove(subTokens.size() - 1);
                result.add(eval(subTokens));
                subTokens.clear();
            }
        }

        System.out.println(result);
        if (operator.equals("+"))
            return result.get(0) + result.get(1);
        else if (operator.equals('-'))
            return result.get(0) + result.get(1);
        else if (operator.equals('*'))
            return result.get(0) * result.get(1);
        else
            return result.get(0) / result.get(1);
    }

    public static void main(String[] args) {
        String[] tokenArray = {"(", "*", "(", " - ", "4", "3", ")", "(", "+", "1", "2", ")", ")"};
        List<String> tokens = Arrays.asList(tokenArray);
        ParseLisp p = new ParseLisp();
        System.out.println(p.eval(tokens));
    }
}
