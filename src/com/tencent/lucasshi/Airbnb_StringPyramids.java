package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fzy on 17/9/23.
 */
public class Airbnb_StringPyramids {
    public static HashMap<String, String> transfers = new HashMap<>();
    public static HashMap<String, Set<String>> tmps = new HashMap<>();

    public String stringPrimids(String input) {
        Set<String> base = new HashSet<>();
        base.add(input);

        for (int i = 0; i < input.length() - 1; i++) {
            Set<String> nextLevel = new HashSet<>();
            for (String baseStr : base) {
                nextLevel.addAll(getNext(baseStr));
            }
            base = nextLevel;
            System.out.println(base);
        }
        System.out.println();

        return base.toString();
    }

    public Set<String> getNext(String input) {
        // 等于2就终止
        if (tmps.containsKey(input))
            return tmps.get(input);

        Set<String> result = new HashSet<>();
        if (input.length() == 2) {
            String trans = transfers.get(input);
            for (int i = 0; i < trans.length(); i++) {
                result.add(trans.charAt(i) + "");
            }
            tmps.put(input, result);
            return result;
        }

        // other
        String head = transfers.get(input.substring(0, 2));
        if (head == null) {
            tmps.put(input, new HashSet<>());
            return new HashSet<>();
        }
        Set<String> next = getNext(input.substring(1));
        Set<String> newResult = new HashSet<>();

        for (int i = 0; i < head.length(); i++) {
            for (String nextStr : next) {
                newResult.add(head.charAt(i) + nextStr);
            }
        }

        tmps.put(input, newResult);
        return newResult;
    }

    public static void main(String[] args) {
        transfers.put("AA", "B");
        transfers.put("AB", "AC");
        transfers.put("AC", "D");
        transfers.put("AD", "B");
        transfers.put("BA", "B");
        transfers.put("BB", "BC");
        transfers.put("BC", "A");
        transfers.put("CD", "B");

        Airbnb_StringPyramids p = new Airbnb_StringPyramids();
        System.out.println(p.stringPrimids("ABCD"));

    }
}
