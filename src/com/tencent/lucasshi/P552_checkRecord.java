package com.tencent.lucasshi;

public class P552_checkRecord {
    int result = 0;
    public int checkRecord(int n) {
        dfs(0, 0, "", n);
        return result;
    }

    public void dfs(int cntA, int prevL, String s, int n) {
        if (s.length() == n)
            result += 1;

        dfs(cntA, 0, s + "P", n);
        if (cntA < 1) {
            dfs(cntA + 1, 0, s + "A", n);
        }

        if (prevL < 2) {
            dfs(cntA, prevL + 1, s + "A", n);
        }
    }
}
