package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/16.
 */
public class P67_AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        System.out.println(a + " " + b);
        // do
        int shift = 0;
        String result = "";
        for (; i >= 0 || j >= 0; i--, j--) {
            int aInt = i >= 0 ? a.charAt(i) - '0' : 0;
            int bInt = j >= 0 ? b.charAt(j) - '0' : 0;
            int bitSum = aInt + bInt + shift;

            if (bitSum == 3) {
                shift = 1;
                result = "1" + result;
            }

            if (bitSum == 2) {
                shift = 1;
                result = "0" + result;
            }

            if (bitSum == 1) {
                shift = 0;
                result = "1" + result;
            }

            if (bitSum == 0) {
                shift = 0;
                result = "0" + result;
            }
        }

        // other
        if (shift == 1) {
            result = "1" + result;
        }
        return result;
    }

    public static void main(String[] args) {
        P67_AddBinary p = new P67_AddBinary();
        System.out.println(p.addBinary("11", "1"));
    }
}
