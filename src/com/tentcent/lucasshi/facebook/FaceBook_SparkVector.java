package com.tentcent.lucasshi.facebook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fzy on 17/10/9.
 */
public class FaceBook_SparkVector {
    public int multiply(HashMap<Integer, Integer> vec1,
                        HashMap<Integer, Integer> vec2) {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : vec1.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (vec2.containsKey(key)) {
                result += value * vec2.get(key);
            }
        }

        return result;
    }

    class Pair {
        public int dimension;
        public int value;
    }

    public int multiply(ArrayList<Pair> vec1, ArrayList<Pair> vec2) {
        Comparator<Pair> comparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.dimension < o2.dimension) {
                    return -1;
                } else if (o1.dimension == o2.dimension) {
                    return 0;
                } else {
                    return 1;
                }
            }
        };

        vec1.sort(comparator);
        vec2.sort(comparator);

        int i = 0;
        int j = 0;
        int result = 0;
        while (i < vec1.size() && j < vec2.size()) {
            Pair v1 = vec1.get(i);
            Pair v2 = vec2.get(j);

            // data
            if (v1.dimension == v2.dimension) {
                result += v1.value * v2.value;
            } else if (v1.dimension > v2.dimension) {
                j++;
            } else if (v1.dimension < v2.dimension) {
                i++;
            }
        }

        return result;
    }
}
