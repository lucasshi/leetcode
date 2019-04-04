package com.tencent.lucasshi;

import java.util.*;

public class P381_RandomizedCollection {
    /**
     * Initialize your data structure here.
     */
    private List<Integer> containers;
    private HashMap<Integer, List<Integer>> hashIndex;
    private int count = 0;
    private Random random;

    public P381_RandomizedCollection() {
        containers = new ArrayList<>();
        hashIndex = new HashMap<>();
        count = 0;
        random = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        count += 1;
        containers.add(val);
        int temp = containers.get(count - 1);
        containers.set(count - 1, val);
        containers.set(containers.size() - 1, temp);

        // do
        if (hashIndex.containsKey(val)) {
            hashIndex.get(val).add(count - 1);
            return false;
        } else {
            hashIndex.put(val, new ArrayList<>());
            hashIndex.get(val).add(count - 1);
            return true;
        }
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!hashIndex.containsKey(val))
            return false;

        List<Integer> indexes = hashIndex.get(val);
        int removeIndex = indexes.get(0);
        int tailElement = containers.get(count - 1);
        containers.set(removeIndex, tailElement);

        // tail
        List<Integer> tailIndexes = hashIndex.get(tailElement);
        for (int i = 0; i < tailIndexes.size(); i++) {
            if (tailIndexes.get(i) == count - 1) {
                tailIndexes.set(i, removeIndex);
                break;
            }
        }

        count = count - 1;
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        int randomIndex = random.nextInt(count);
        return containers.get(randomIndex);
    }
}
