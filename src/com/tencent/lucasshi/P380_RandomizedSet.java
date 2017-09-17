package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by fzy on 17/9/17.
 */
public class P380_RandomizedSet {
    static class RandomizedSet {
        private ArrayList<Integer> list;
        private HashMap<Integer, Integer> hashMap;
        private Random rand;

        public RandomizedSet() {
            list = new ArrayList<>();
            hashMap = new HashMap<>();
            rand = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (hashMap.containsKey(val)) {
                return false;
            }
            list.add(val);
            hashMap.put(val, list.size() - 1);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!hashMap.containsKey(val)) {
                return false;
            }

            int index = hashMap.get(val);
            int last = list.get(list.size() - 1);
            // 如果就是最后一个
            if (last == val) {
                list.remove(list.size() - 1);
                hashMap.remove(val);
                return true;
            }

            list.remove(list.size() - 1);
            list.set(index, last);
            hashMap.put(last, index);
            hashMap.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        P380_RandomizedSet p = new P380_RandomizedSet();
        P380_RandomizedSet.RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(3);
        randomizedSet.remove(3);
        randomizedSet.remove(0);
        randomizedSet.insert(3);
        randomizedSet.remove(0);

    }
}
