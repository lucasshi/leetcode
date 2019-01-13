package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by fzy on 17/7/29.
 */
public class P406_QueueConstruct {
    class Tuple {
        public int height;
        public int originCount;
        public int count;

        public Tuple(int height, int count) {
            this.height = height;
            this.count = count;
            this.originCount = count;
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        LinkedList<Tuple> tupleList = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            tupleList.add(new Tuple(people[i][0], people[i][1]));
        }

        int[][] result = new int[people.length][people[0].length];
        int index = 0;
        while (!tupleList.isEmpty()) {
            // find min
            Tuple minTuple = tupleList.getFirst();
            for (Tuple tuple : tupleList) {
                if (tuple.count < minTuple.count) {
                    minTuple = tuple;
                    continue;
                }
                if (tuple.count == minTuple.count && tuple.height < minTuple.height) {
                    minTuple = tuple;
                    continue;
                }
            }
            //  revise
            tupleList.remove(minTuple);
            result[index][0] = minTuple.height;
            result[index][1] = minTuple.originCount;
            for (Tuple tuple : tupleList) {
                if (tuple.height <= minTuple.height) {
                    tuple.count -= 1;
                }
            }
        }

        return result;
    }
}
