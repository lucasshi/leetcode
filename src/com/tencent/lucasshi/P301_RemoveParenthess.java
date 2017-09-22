package com.tencent.lucasshi;

import java.util.HashSet;

/**
 * Created by fzy on 17/9/19.
 */
public class P301_RemoveParenthess {
    private HashSet<String> results = new HashSet<>();
    private char[] order1 = {'(', ')'};
    private char[] order2 = {')', '('};


    public HashSet<String> removeInvalidParentheses(String s) {
        HashSet<String> positiveResult = getResult(s, order1);
        HashSet<String> finalResult = new HashSet<>();

        for (String positive : positiveResult) {
            StringBuffer tmpBuffer = new StringBuffer(positive);
            String reverse = tmpBuffer.reverse().toString();

            for (String reverseS : getResult(reverse, order2)) {
                tmpBuffer = new StringBuffer(reverseS);
                finalResult.add(tmpBuffer.reverse().toString());
            }
        }
        System.out.println(positiveResult);
        System.out.println(finalResult);
        return finalResult;
    }


    public HashSet<String> getResult(String s, char[] order) {
        int count = 0;
        HashSet<String> result = new HashSet<>();
        int lastIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == order[0])
                count++;
            if (s.charAt(i) == order[1])
                count--;
            if (count >= 0)
                continue;

            HashSet<String> tmpResult = new HashSet<>();
            for (int j = lastIndex; j < i; j++) {
                if (s.charAt(j) == order[1]) {
                    String tmpS = s.substring(lastIndex, j);
                    if (j + 1 <= i) {
                        tmpS += s.substring(j + 1, i + 1);
                    }
                    tmpResult.add(tmpS);
                }
            }
            lastIndex = i;
            count = 0;

            // 开始进行排列组合
            HashSet<String> newResult = new HashSet<>();
            if (result.size() == 0) {
                newResult.addAll(tmpResult);
            } else {
                for (String s1 : result) {
                    for (String s2 : tmpResult) {
                        newResult.add(s1 + s2);
                    }
                }
            }

            result = newResult;
        }

        HashSet<String> finalResult = new HashSet<>();
        if (result.size() == 0) {
            finalResult.add(s);
        } else {
            for (String rs : result) {
                finalResult.add(rs + s.substring(lastIndex + 1));
                System.out.println(rs + s.substring(lastIndex + 1));
            }
        }
        return finalResult;
    }

    public static void main(String[] args) {
        String a = "abbbb";
        System.out.println(a.substring(1, a.length()));
        P301_RemoveParenthess p = new P301_RemoveParenthess();
        p.removeInvalidParentheses("()())()");


    }
}
