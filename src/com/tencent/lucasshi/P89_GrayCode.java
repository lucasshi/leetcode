package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/4/27.
 */
public class P89_GrayCode {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            result.add(1);
            return result;
        }

        if (n == 0) {
            result.add(0);
            return result;
        }


        List<Integer> lastResult = grayCode(n - 1);
        for (Integer i : lastResult) {
            result.add(i);
        }

        int maxValue = (int) Math.pow(2, n - 1);
        for (int i = result.size() - 1; i >= 0; i--) {
            result.add(maxValue + result.get(i));
        }

        return result;
    }
}
