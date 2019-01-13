package com.tencent.lucasshi;

public class P738_MonotonIncreaseDigits {
    public int monotoneIncreasingDigits(int N) {
        String n = N + "";
        StringBuffer res = new StringBuffer();
        boolean endMode = false;
        for (int i = 0; i < n.length(); i++) {
            if (endMode) {
                res.append("9");
            } else if (n.charAt(i) <= n.charAt(i)) {
                res.append(n.charAt(i));
            } else if (n.charAt(i) == '0') {
                res.setCharAt(i - 1, (char) (n.charAt(i - 1) - 1));
                res.append('9');
                endMode = true;
            } else {
                res.setCharAt(i, (char) (n.charAt(i) - 1));
                endMode = true;
            }
        }
        return Integer.parseInt(res.toString());
    }
}
