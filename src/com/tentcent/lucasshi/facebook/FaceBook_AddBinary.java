package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/8.
 */
public class FaceBook_AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return null;
        }

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        String res = "";

        while (i >= 0 || j >= 0) {
            int valueA = i >= 0 ? a.charAt(i) - '0' : 0;
            int valueB = j >= 0 ? b.charAt(j) - '0' : 0;
            int val = valueA + valueB + carry;

            if (val == 1) {
                res += '1';
            } else if (val == 0) {
                res += '0';
            } else if (val == 2) {
                res += '0';
                carry = 1;
            } else {
                res += '1';
                carry = 1;
            }

            i--;
            j--;
        }

        if (carry == 1) {
            res+='1';
        }

        StringBuffer sb = new StringBuffer(res);
        return sb.reverse().toString();
    }
}
