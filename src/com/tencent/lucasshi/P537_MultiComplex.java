package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/21.
 */
public class P537_MultiComplex {
    public String complexNumberMultiply(String a, String b) {
        String[] A = a.split("\\+");
        String[] B = b.split("\\+");
        int a1 = Integer.parseInt(A[0]);
        int b1 = Integer.parseInt(A[1].replace("i", ""));
        int a2 = Integer.parseInt(B[0]);
        int b2 = Integer.parseInt(B[1].replace("i", ""));
        String res = (a1 * a2 - b1 * b2) + "+" + (a1 * b2 + a2 * b1) + "i";
        return res;

    }
}
