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


    public List<String> generateParenthesis1(int n) {
        List<String> result = new ArrayList<>();
        String current = "";
        helper(n, n, current, result);
        return result;
    }

    public void helper(int lcount, int rcount, String current, List<String> result) {
        if (lcount == 0 && rcount == 0) {
            result.add(current);
            return;
        }

        if (lcount > rcount)
            return;

        if (lcount > 0) {
            helper(lcount - 1, rcount, current + "(", result);
        }

        if (rcount > 0) {
            helper(lcount, rcount - 1, current + ")", result);
        }
    }

    public static void main(String[] args) {
        P22_GenerateParentness p = new P22_GenerateParentness();
        p.generateParenthesis1(3);
    }


}
