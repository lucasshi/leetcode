package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/14.
 */
public class P171_TitleToNumber {
    public int titleToNumber(String s) {
        int value = 0;
        int key = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            value += key * (c - 'A' + 1);
            key = key * 26;
        }

        return value;
    }

    public static void main(String[] args) {
        P171_TitleToNumber p = new P171_TitleToNumber();
        p.titleToNumber("AA");
    }
}
