package com.tencent.lucasshi;

public class P771_numJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        char[] js = new char[256];
        for (int i = 0; i < J.length(); i++) {
            js[J.charAt(i)] = 1;
        }

        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {
            if (js[S.charAt(i)] == 1) {
                cnt += 1;
            }
        }
        return cnt;
    }
}
