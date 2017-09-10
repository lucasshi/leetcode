package com.tencent.lucasshi;

import java.util.*;

/**
 * Created by fzy on 17/9/5.
 */
public class Amazon_ListJoin {
    public void ListJoin(List<List<String>> list1, List<List<String>> list2) {
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, HashSet<String>> map2 = new HashMap<>();

        // cai
        for (int i = 0; i < list1.size(); i++) {
            List<String> val = list1.get(i);
            map1.put(val.get(0), val.get(1));
        }

        HashSet<String> allDishes = new HashSet<>();
        for (int i = 0; i < list2.size(); i++) {
            List<String> val = list2.get(i);
            if (!map2.containsKey(map2)) {
                map2.put(val.get(0), new HashSet<>());
            }
            map2.get(val.get(0)).add(val.get(1));
            allDishes.add(val.get(1));
        }

        // Join
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String key = entry.getKey();
            String dishType = entry.getValue();
            HashSet<String> dishes = null;

            if (dishType == "*"){
                dishes = allDishes;
            } else {
                dishes = map2.get(dishType);
            }
        }
    }
}
