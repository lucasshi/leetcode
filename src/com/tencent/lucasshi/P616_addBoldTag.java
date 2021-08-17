package com.tencent.lucasshi;


import java.util.Arrays;

public class P616_addBoldTag {
    public String addBoldTag(String s, String[] words) {
        boolean[] mask = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i);
            for (int j = 0; j < words.length; j++) {
                if (sub.startsWith(words[j])) {
                    for (int k = 0; k < words[j].length(); k++)
                        mask[k + i] = true;
                }
            }
        }

        String result = "";
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] == true && i == 0) {
                result += "<b>";
            } else if (mask[i] == true && mask[i - 1] == false) {
                result += "<b>";
            } else if (mask[i] == false && mask[i - 1] == true && i != 0) {
                result += "</b>";
            }
            result += s.charAt(i);
        }
        if (mask[mask.length - 1] == true)
            result += "</b>";
        return result;
    }

    public static void main(String[] args) {
        P616_addBoldTag p616_addBoldTag = new P616_addBoldTag();
        System.out.println(p616_addBoldTag.addBoldTag("aaabbcc", new String[]{"aaa", "aab", "bc"}));
    }
}
