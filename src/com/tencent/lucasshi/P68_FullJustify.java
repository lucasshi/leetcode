package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

public class P68_FullJustify {
    public String getLineString(List<String> lineWords, int maxWidth) {
        int allWordLength = 0;
        String result = "";
        for (String lineWord : lineWords) {
            allWordLength += lineWord.length();
        }
        if (lineWords.size() == 1) {
            result += lineWords.get(0);
        } else {
            // do
            int whiteSize = (maxWidth - allWordLength) / (lineWords.size() - 1);
            int moreCount = (maxWidth - allWordLength) % (lineWords.size() - 1);
            for (int i = 0; i < lineWords.size() - 1; i++) {
                result += lineWords.get(i);
                int spaceSize = whiteSize;
                if (moreCount > 0) {
                    spaceSize = whiteSize + 1;
                }

                for (int j = 0; j < spaceSize; j++)
                    result += " ";
            }

            result += lineWords.get(lineWords.size() - 1);
        }
        return result;
    }

    public List<String> textJustify(String[] words, int maxWidth) {
        List<String> lineWords = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int lineSize = 0;

        for (int i = 0; i < words.length; i++) {
            lineSize += words[i].length();
            if (lineSize < maxWidth) {
                lineWords.add(words[i]);
                lineSize += 1;
            } else {
                // dump
                String line = getLineString(lineWords, maxWidth);
                result.add(line);
                // init
                lineSize = words[i].length() + 1;
                lineWords.clear();
                lineWords.add(words[i]);
            }
        }

        // refact last
        return result;
    }
}
