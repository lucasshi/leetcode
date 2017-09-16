package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;

/**
 * Created by fzy on 17/9/16.
 */
public class P273_IntegerToEnglish {
    public static HashMap<Integer, String> numberToString = new HashMap<>();
    public static HashMap<Integer, String> tenToString = new HashMap<>();

    static {
        //
        numberToString.put(1, "One");
        numberToString.put(2, "Two");
        numberToString.put(3, "Three");
        numberToString.put(4, "Four");
        numberToString.put(5, "Five");
        numberToString.put(6, "Six");
        numberToString.put(7, "Seven");
        numberToString.put(8, "Eight");
        numberToString.put(9, "Nine");

        // tenNumberToString
        numberToString.put(10, "Ten");
        numberToString.put(11, "Eleven");
        numberToString.put(12, "Twelve");
        numberToString.put(13, "Thirteen");
        numberToString.put(14, "Fourteen");
        numberToString.put(15, "Fifteen");
        numberToString.put(16, "Sixteen");
        numberToString.put(17, "Seventeen");
        numberToString.put(18, "Eighteen");
        numberToString.put(19, "Nineteen");

        // tentoString
        tenToString.put(2, "Twenty");
        tenToString.put(3, "Thirty");
        tenToString.put(4, "Forty");
        tenToString.put(5, "Fifty");
        tenToString.put(6, "Sixty");
        tenToString.put(7, "Seventy");
        tenToString.put(8, "Eighty");
        tenToString.put(9, "Ninety");
    }

    public String thoundsToWords(int num) {
        ArrayList<String> stringParts = new ArrayList<>();
        int hundred = num / 100;
        if (hundred != 0) {
            stringParts.add(numberToString.get(hundred));
            stringParts.add("Hundred");
        }

        int leftPart = num % 100;
        if (numberToString.containsKey(leftPart)) {
            stringParts.add(numberToString.get(leftPart));
        } else {
            int tenPart = leftPart / 10;
            int singlePart = leftPart % 10;
            if (tenToString.containsKey(tenPart)) {
                stringParts.add(tenToString.get(tenPart));
            }
            if (numberToString.containsKey(singlePart)) {
                stringParts.add(numberToString.get(singlePart));
            }
        }

        // doStringParts
        return String.join(" ", stringParts);
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        ArrayList<Integer> parts = new ArrayList<>();

        while (num != 0) {
            parts.add(num % 1000);
            num = num / 1000;
        }

        String result = "";
        for (int i = 0; i < parts.size(); i++) {
            String part = thoundsToWords(parts.get(i));
            if (i == 0) {
                result = part;
            } else if (i == 1 && !part.equals("")) {
                result = part + " Thousand " + result;
            } else if (i == 2 && !part.equals("")) {
                result = part + " Million " + result;
            } else if (i == 3 && !part.equals("")) {
                result = part + " Billion " + result;
            } else if (i == 4 && !part.equals("")) {
                result = part + " Trillion" + result;
            }
        }

        result = result.trim();
        return result;
    }

    public static void main(String[] args) {
        P273_IntegerToEnglish p = new P273_IntegerToEnglish();
        System.out.println(p.numberToWords(1000000));
    }
}
