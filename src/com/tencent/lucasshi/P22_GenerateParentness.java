package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by fzy on 17/3/27.
 */
public class P22_GenerateParentness {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(n, n, "", res);
        return res;
    }

    public static void generate(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || left < right)
            return;

        if (left == 0 && right == 0) {
            System.out.println(left + " " + right + " " + out);
            res.add(out);
        }

        generate(left - 1, right, out + "(", res);
        generate(left, right - 1, out + ")", res);
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }


}
