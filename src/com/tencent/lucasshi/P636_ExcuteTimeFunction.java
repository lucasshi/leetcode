package com.tencent.lucasshi;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by fzy on 17/9/18.
 */
public class P636_ExcuteTimeFunction {
    class FunctionCall {
        public int functionId;
        public int timeStamp;

        // 说明是时间长度
        public int interval = 0;

        public FunctionCall(int functionId, int timeStamp) {
            this.functionId = functionId;
            this.timeStamp = timeStamp;
            this.interval = -1;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<FunctionCall> functionStack = new Stack<>();
        int[] result = new int[n];

        for (int i = 0; i < logs.size(); i++) {
            String log = logs.get(i);
            String[] logArray = log.split(":");

            FunctionCall functionCall = new FunctionCall(
                    Integer.valueOf(logArray[0]), Integer.valueOf(logArray[2]));

            if (logArray[1].equals("start")) {
                functionStack.push(functionCall);
                continue;
            }

            // 肯定是endType了
            int otherInterval = 0;
            while (!functionStack.empty()) {
                FunctionCall stackCall = functionStack.pop();
                if (stackCall.functionId == functionCall.functionId
                        && stackCall.interval == -1) {
                    stackCall.interval = functionCall.timeStamp - stackCall.timeStamp + 1;
                    result[stackCall.functionId] += stackCall.interval - otherInterval;
                    functionStack.push(stackCall);
                    System.out.println(stackCall.interval + " " + otherInterval);
                    break;
                } else {
                    otherInterval += stackCall.interval;
                }
            }
        }

        return result;
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
