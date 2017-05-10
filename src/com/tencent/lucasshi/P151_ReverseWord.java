package com.tencent.lucasshi;

import java.util.ArrayList;

/**
 * Created by fzy on 17/5/6.
 */
public class P151_ReverseWord {
    public String reverseWords(String s) {
        char previousChar = ' ';
        int startIndex = 0;
        int endIndex = 0;
        String result = "";
        if (s.length() == 0) {
            return result;
        }
        // do
        for (int i = 0; i < s.length(); i++) {
            // meet new word
            if (s.charAt(i) != ' ' && previousChar == ' ') {
                startIndex = i;
            }

            if (s.charAt(i) == ' ' && previousChar != ' ') {
                endIndex = i;
                String element = s.substring(startIndex, endIndex);
                if (result == "") {
                    result = element;
                } else {
                    result = element + " " + result;
                }
            }

            previousChar = s.charAt(i);
        }

        //
        if (s.charAt(s.length() - 1) != ' ') {
            String element = s.substring(startIndex);
            if (result == "") {
                result = element;
            } else {
                result = element + " " + result;
            }
        }

        return result;
    }
}
