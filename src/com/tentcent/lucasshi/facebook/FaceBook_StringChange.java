package com.tentcent.lucasshi.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/10/12.
 */
public class FaceBook_StringChange {
    List<String> result = new ArrayList<String>();

    public List<String> permuteString(String s) {
        char[] curr = new char[s.length()];
        helper(curr, s, 0);
        return result;
    }

    public void helper(char[] curr, String next, int idx) {
        if (next.length() == 0) {
            result.add(new String(curr));
            return;
        }

        curr[idx] = next.charAt(0);
        helper(curr, next.substring(1), idx + 1);
        curr[idx] = Character.toUpperCase(next.charAt(0));
        helper(curr, next.substring(1), idx + 1);
    }

    public static void main(String[] args) {
        FaceBook_StringChange p = new FaceBook_StringChange();
        System.out.println(p.permuteString("abc"));
    }
}
