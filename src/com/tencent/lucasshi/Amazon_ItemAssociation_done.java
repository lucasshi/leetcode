package com.tencent.lucasshi;

import java.util.*;

/**
 * Created by fzy on 17/9/5.
 */
public class Amazon_ItemAssociation_done {
    public TreeSet<Integer> getItemAssociation(List<List<Integer>> items) {
        int maxCount = 0;
        HashMap<Integer, TreeSet<Integer>> associations = new HashMap<>();
        TreeSet<Integer> maxSet = new TreeSet<>();
        int maxSetPointer = -1;

        for (int i = 0; i < items.size(); i++) {
            int x = items.get(i).get(0);
            int y = items.get(i).get(1);

            if (!associations.containsKey(x)) {
                TreeSet<Integer> newSet = new TreeSet<>();
                newSet.add(x);
                associations.put(x, newSet);
            }

            if (!associations.containsKey(y)) {
                TreeSet<Integer> newSet = new TreeSet<>();
                newSet.add(y);
                associations.put(y, newSet);
            }

            TreeSet<Integer> setX = associations.get(x);
            TreeSet<Integer> setY = associations.get(y);
            setX.addAll(setY);

            associations.put(x, setX);
            associations.put(y, setX);

            if (setX.size() > maxSet.size()) {
                maxSet = setX;
                continue;
            }

            if (setX.size() == maxSet.size() && setX.first() < maxSet.first()) {
                maxSet = setX;
                continue;
            }
        }

        return maxSet;
    }

    public static void main(String[] args) {
        List<Integer> aList = Arrays.asList(2, 3);
        List<Integer> bList = Arrays.asList(1, 2);
        List<Integer> cList = Arrays.asList(4, 5);
        List<Integer> dList = Arrays.asList(5, 6);


        List<List<Integer>> input = new ArrayList<List<Integer>>();
        input.add(cList);
        input.add(dList);
        input.add(aList);
        input.add(bList);


        Amazon_ItemAssociation_done a = new Amazon_ItemAssociation_done();
        a.getItemAssociation(input);
    }


}
