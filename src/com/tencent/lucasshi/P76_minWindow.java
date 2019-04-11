package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by fzy on 17/3/28.
 */
public class P76_minWindow {
    // check
    public static boolean isOk(HashMap<Character, Integer> cnt, HashMap<Character, Integer> t) {
        for (Character tKey : t.keySet()) {
            if (!cnt.containsKey(tKey) || cnt.get(tKey) < t.get(tKey))
                return false;
        }
        return true;
    }

    public static String minWindow2(String s, String t) {
        int startIndex = 0;
        int endIndex = 0;
        // do
        HashMap<Character, Integer> cntMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!tMap.containsKey(t.charAt(i)))
                tMap.put(t.charAt(i), 0);
            tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
        }

        String result = s;
        while (endIndex <= s.length()) {
            if (!isOk(cntMap, tMap)) {
                if (endIndex == s.length())
                    break;
                if (!cntMap.containsKey(s.charAt(endIndex)))
                    cntMap.put(s.charAt(endIndex), 0);
                cntMap.put(s.charAt(endIndex), cntMap.get(s.charAt(endIndex)) + 1);
                endIndex += 1;
            } else {
                System.out.println(s.substring(startIndex, endIndex));
                if (endIndex - startIndex < result.length()) {
                    result = s.substring(startIndex, endIndex);
                }
                cntMap.put(s.charAt(startIndex), cntMap.get(s.charAt(startIndex)) - 1);
                startIndex += 1;
            }
        }

        return result;
    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!tMap.containsKey(c)) {
                tMap.put(c, 1);
            } else {
                tMap.put(c, tMap.get(c) + 1);
            }
        }

        int beginIndex = 0;
        int endIndex = 0;
        int matchCount = 0;
        int minLength = Integer.MAX_VALUE;
        int minBeginIndex = -1;
        int minEndIndex = -1;
        HashMap<Character, Integer> bufferMap = new HashMap<>();

        while (true) {
            if (endIndex >= s.length()) {
                break;
            }

            char endChar = s.charAt(endIndex);

            // 匹配的情况
            if (tMap.containsKey(endChar)) {
                if (bufferMap.containsKey(endChar)) {
                    bufferMap.put(endChar, bufferMap.get(endChar) + 1);
                } else {
                    bufferMap.put(endChar, 1);
                }

                // 说明我们还需要在进行查询
                if (bufferMap.get(endChar) <= tMap.get(endChar)) {
                    matchCount++;
                }
            }

            // 这个时候开始查询beginIndex
            if (matchCount == t.length()) {
                while (true) {
                    char beginChar = s.charAt(beginIndex);
                    if (tMap.containsKey(beginChar) &&
                            tMap.get(beginChar) >= bufferMap.get(beginChar)) {
                        break;
                    } else if (tMap.containsKey(beginChar)) {
                        bufferMap.put(beginChar, bufferMap.get(beginChar) - 1);
                    }
                    beginIndex++;
                }

                // 这个时候说明我们已经是最小的了
                int length = endIndex - beginIndex + 1;
                if (length < minLength) {
                    minLength = length;
                    minBeginIndex = beginIndex;
                    minEndIndex = endIndex;
                }
            }

            endIndex++;
        }

        if (minBeginIndex == -1) {
            return "";
        }
        return s.substring(minBeginIndex, minEndIndex + 1);
    }

    public static void main(String[] args) {
        System.out.println(P76_minWindow.minWindow2("ADOBECODEBANC", "ABC"));
    }
}
