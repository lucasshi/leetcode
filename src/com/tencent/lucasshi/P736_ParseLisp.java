package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P736_ParseLisp {
    public int evaluate(String expression) {
        return 1;
    }

    // 中间是变量名
    public int evaluate(String expression, List<HashMap<String, Integer>> variables, int index) {
        List<String> tokens = new ArrayList<>();

        if (tokens.get(index).equals("let")) {
            return let(tokens, index + 1, variables);
        } else if (tokens.get(index).equals("add")) {
            return add(tokens, index + 1, variables);
        } else {
            return multipy(tokens, index + 1, variables);
        }
    }

    public int let(List<String> tokens, int index, List<HashMap<String, Integer>> varibales) {
        return -1;
    }

    public int add(List<String> tokens, int index, List<HashMap<String, Integer>> varibales) {
        return -1;
    }

    public int multipy(List<String> tokens, int index, List<HashMap<String, Integer>> varibales) {
        return 1;
    }

    public List<String> getTokens(String expression) {
        List<String> tokens = new ArrayList<>();
        expression = expression.substring(1, expression.length() - 1);
        // parse
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < expression.length(); ) {
            if (expression.charAt(i) == '(') {
                int lcount = 0;
                int rcount = 0;
                int sindex = i;
                while (lcount != rcount || lcount == 0) {
                    if (expression.charAt(i) == '(') {
                        lcount += 1;
                    } else if (expression.charAt(i) == ')') {
                        rcount += 1;
                    }
                    i++;
                }
                tokens.add(expression.substring(sindex, i));
            } else if (expression.charAt(i) != ' ') {
                int sindex = i;
                while (i < expression.length() && expression.charAt(i) != ' ')
                    i++;
                tokens.add(expression.substring(sindex, i));
            }
        }
        return tokens;
    }

    public static void main(String[] args) {

    }

}
