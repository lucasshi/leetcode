package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fzy on 17/4/28.
 */
public class P17_LetterOfPhone {
    public static HashMap<Character, String>
            map = new HashMap<Character, String>();

    static {
        map.put('0', "0");
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            List<String> res = new ArrayList<String>();
            return res;
        }

        List<String> res = new ArrayList<String>();
        char digit = digits.charAt(0);
        String value = map.get(digit);
        // length = 1

        if (digits.length() == 1) {
            for (int i = 0; i < value.length(); i++) {
                res.add(value.charAt(i) + "");
            }
            return res;
        }
        // length > 1

        String subDigits = digits.substring(1);

        List<String> sub_result = letterCombinations(subDigits);
        for (int i = 0; i < sub_result.size(); i++) {
            String s = sub_result.get(i);
            for (int j = 0; j < value.length(); j++) {
                String tmp = value.charAt(j) + s;
                res.add(tmp);
            }
            ;
        }
        return res;
    }
}
