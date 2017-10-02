package com.tencent.lucasshi;


import java.util.*;

/**
 * Created by fzy on 17/9/23.
 */
public class Airbnb_preference {
    public List<Integer> preferenceList(
            List<List<Integer>> preferLists) {

        HashMap<Integer, HashSet<Integer>> bigOrder = new HashMap<>();
        HashMap<Integer, Integer> smallCount = new HashMap<>();
        HashSet<Integer> zeroCount = new HashSet<>();

        for (List<Integer> preferList : preferLists) {
            for (Integer prefer : preferList) {
                if (!smallCount.containsKey(prefer)) {
                    smallCount.put(prefer, 0);
                    zeroCount.add(prefer);
                }
                if (!bigOrder.containsKey(prefer)) {
                    bigOrder.put(prefer, new HashSet<>());
                }
            }

            for (int i = 0; i < preferList.size() - 1; i++) {
                int bigKey = preferList.get(i);
                int smallKey = preferList.get(i + 1);
                bigOrder.get(bigKey).add(smallKey);
                smallCount.put(smallKey, smallCount.get(smallKey) + 1);
                zeroCount.remove(smallKey);
            }
        }

        // do
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addAll(zeroCount);

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int key = queue.pollFirst();
            result.add(key);

            for (Integer smallKey : bigOrder.get(key)) {
                smallCount.put(smallKey, smallCount.get(smallKey) - 1);
                if (smallCount.get(smallKey) == 0) {
                    queue.addLast(smallKey);
                }
            }

            bigOrder.remove(key);
        }

        return result;
    }
}
