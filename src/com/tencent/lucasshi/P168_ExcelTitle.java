package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/14.
 */
public class P168_ExcelTitle {
    public String convertToTitle(int n) {
        int mod = -1;
        int left = -1;
        String result = "";

        while (n != 0) {
            mod = (n - 1) % 26;
            n = (n - 1) / 26;
            result = (char) (mod + 'A') + result;
        }

        return result;
    }

    public static void main(String[] args) {
        P168_ExcelTitle p = new P168_ExcelTitle();
        p.convertToTitle(26);
    }
}
