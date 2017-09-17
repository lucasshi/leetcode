package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/17.
 */
public class P186_ReverseWord {
    public void reverseWord(char[] s, int wordStart, int wordEnd) {
        while (wordStart < wordEnd) {
            char tmp = s[wordStart];
            s[wordStart] = s[wordEnd];
            s[wordEnd] = tmp;

            wordStart++;
            wordEnd--;
        }
    }

    public void reverseWords(char[] s) {
        int wordStart = -1;
        int wordEnd = -1;

        for (int i = 0; i < s.length; i++) {
            if (s[i] != ' ') {
                if (wordStart == -1) {
                    wordStart = i;
                }
                wordEnd = i;
            }

            // other
            if (s[i] == ' ') {
                reverseWord(s, wordStart, wordEnd);
                wordStart = wordEnd = -1;
            }
        }

        reverseWord(s, wordStart, wordEnd);
        reverseWord(s, 0, s.length - 1);
    }

    public static void main(String[] args) {
        P186_ReverseWord p = new P186_ReverseWord();
        String s = "the sky is blue";
        char[] sArray = s.toCharArray();
        p.reverseWords(sArray);

        s = new String(sArray);
        System.out.println(s);
    }
}
