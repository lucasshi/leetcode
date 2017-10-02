package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/9/23.
 */
public class Airbnb_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lineWords = new ArrayList<>();
        List<String> result = new ArrayList<>();

        int lineSize = 0;
        for (int i = 0; i < words.length; i++) {
            if (lineWords.size() == 0) {
                lineSize += words[i].length();
            } else {
                lineSize += words[i].length() + 1;
            }

            if (lineSize > maxWidth) {
                result.add(GetResult(lineWords, maxWidth));
                lineWords.clear();
                lineSize = words[i].length();
            }

            lineWords.add(words[i]);
        }

        if (lineWords.size() != 0) {
            String finalStr = GetLast(lineWords, maxWidth);
            result.add(finalStr);
        }

        return result;
    }

    public String GetLast(List<String> words, int maxWidth) {
        String result = "";
        for (int i = 0; i < words.size(); i++) {
            if (i == 0) {
                result = words.get(i);
                continue;
            }
            result = result + " " + words.get(i);
        }

        while (result.length() < maxWidth) {
            result = result + " ";
        }
        return result;
    }

    public String GetResult(List<String> words, int maxWidth) {
        int sumLength = 0;
        for (int i = 0; i < words.size(); i++) {
            sumLength += words.get(i).length();
        }

        int sep = 0;
        int reside = 0;
        if (words.size() > 1) {
            sep = (maxWidth - sumLength) / (words.size() - 1);
            reside = (maxWidth - sumLength) % (words.size() - 1);
        }


        String sepStr = "";
        for (int i = 0; i < sep; i++) {
            sepStr += " ";
        }

        String result = "";
        for (int i = 0; i < words.size(); i++) {
            if (i == 0) {
                result = words.get(i);
                continue;
            }

            if (reside > 0) {
                result = result + " " + sepStr + words.get(i);
                reside--;
            } else {
                result = result + sepStr + words.get(i);
            }
        }

        // 末尾
        while (result.length() < maxWidth) {
            result = result + " ";
        }


        return result;
    }

    public static void main(String[] args) {
        // String[] input = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] input = {"a", "b", "c", "d", "e"};
        Airbnb_TextJustification p = new Airbnb_TextJustification();
        System.out.println(p.fullJustify(input, 3));

    }
}
