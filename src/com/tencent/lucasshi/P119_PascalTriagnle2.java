package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/4/30.
 */
public class P119_PascalTriagnle2 {
    public List<Integer> generate(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        List<Integer> lastResult = new ArrayList<>();

        // iteration
        for (int i = 0; i <= rowIndex; i++) {
            if (result.size() == 0) {
                result.add(1);
                continue;
            }

            // last result
            lastResult = result;
            result = new ArrayList<>();
            result.add(1);
            for (int j = 1; j < lastResult.size(); j++) {
                result.add(lastResult.get(j) + lastResult.get(j - 1));
            }
            result.add(1);
        }

        return result;
    }
}
