package com.tentcent.lucasshi.facebook;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by fzy on 17/10/10.
 */
public class FaceBook_ExclusiveTime {
    class Function {
        public int functionId;
        public int timeStamp;

        // 说明是时间长度
        public int interval = 0;

        public Function(int functionId, int timeStamp) {
            this.functionId = functionId;
            this.timeStamp = timeStamp;
            this.interval = -1;
        }
    }


    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Function> stack = new Stack<>();
        int[] result = new int[n];
        //
        for (int i = 0; i < logs.size(); i++) {
            String[] logItem = logs.get(i).split(":");
            int functionId = Integer.parseInt(logItem[0]);
            int timeStamp = Integer.parseInt(logItem[2]);
            String taskType = logItem[1];

            if (taskType.equals("start")) {
                Function function = new Function(functionId, timeStamp);
                stack.push(function);
                continue;
            }

            int innerInterval = 0;
            Function sf = new Function(0, 0);
            while (!stack.isEmpty()) {
                sf = stack.pop();
                if (sf.functionId == functionId && sf.interval == -1) {
                    break;
                }
                innerInterval += sf.interval;
            }

            int period = timeStamp - sf.timeStamp - innerInterval + 1;
            System.out.println(timeStamp + " " + sf.timeStamp + " " + period);
            result[functionId] += timeStamp - sf.timeStamp - innerInterval + 1;
            sf.interval = timeStamp - sf.timeStamp + 1;
            stack.push(sf);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] calls = {
                "0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"};
        FaceBook_ExclusiveTime p = new FaceBook_ExclusiveTime();
        int[] res = p.exclusiveTime(1, Arrays.asList(calls));
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);
    }


}
