package com.tentcent.lucasshi.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/10/10.
 */
public class FaceBook_AddOperators {
    private List<String> result = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        helper("", 0, num, target);
        return result;
    }

    public void helper(String expCurr, int valCurr, String num, int target) {
        if (num.length() == 0) {
            if (valCurr == target)
                result.add(expCurr);
            return;
        }

        // other
        for (int i = 1; i <= num.length(); i++) {
            int val = Integer.valueOf(num.substring(0, i));
            String nextExpCurr = "";
            if (expCurr != "") {
                nextExpCurr = expCurr + "+" + val;
            } else {
                nextExpCurr = "" + val;
            }
            int nextValCurr = valCurr + val;
            String nextNum = num.substring(i);
            helper(nextExpCurr, nextValCurr, nextNum, target);

            // -
            if (expCurr == "")
                continue;
            nextExpCurr = expCurr + "-" + val;
            nextValCurr = valCurr - val;
            System.out.println(nextExpCurr + " " + nextValCurr + " " + nextNum);
            helper(nextExpCurr, nextValCurr, nextNum, target);
        }
    }

    public static void main(String[] args) {
        FaceBook_AddOperators p = new FaceBook_AddOperators();
        System.out.println(p.addOperators("123", 6));
        System.out.println("123".substring(3).length());
    }
}
