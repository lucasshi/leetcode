package com.tencent.lucasshi;

import java.util.HashMap;

/**
 * Created by fzy on 17/3/28.
 */
public class P76_minWindow {
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
            return  "";
        }
        return s.substring(minBeginIndex, minEndIndex + 1);
    }

    public static void main(String[] args) {
        P76_minWindow.minWindow("ab", "a");
    }
}
