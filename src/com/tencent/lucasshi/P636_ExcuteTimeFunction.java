package com.tencent.lucasshi;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by fzy on 17/9/18.
 */
public class P636_ExcuteTimeFunction {
    class Function {
        public int functionId;
        public int startTime;
        public int endTime;

        Function(final int functionId, final int startTime) {
            this.functionId = functionId;
            this.startTime = startTime;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Function> stack = new Stack<>();
        int[] res = new int[n];

        for (int i = 0; i < logs.size(); i++) {
            String[] eles = logs.get(i).split(":");
            if (eles[1].equals("start")) {
                stack.push(new Function(
                        Integer.valueOf(eles[0]),
                        Integer.valueOf(eles[2])));
            } if (eles[1].equals("end")) {
                int otherFucntionTime = 0;
                while (stack.peek().functionId != Integer.valueOf(eles[0])) {
                    Function func = stack.pop();
                    otherFucntionTime += func.endTime - func.startTime;
                }
                Function function = stack.pop();
                function.endTime = Integer.valueOf(eles[2]);
                res[function.functionId] += function.endTime - function.startTime - otherFucntionTime;
                stack.push(function);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] calls = {
                "0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"};
        P636_ExcuteTimeFunction p = new P636_ExcuteTimeFunction();
        int[] result = p.exclusiveTime(1, Arrays.asList(calls));
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
