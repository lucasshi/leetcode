package com.tentcent.lucasshi.facebook;

import java.util.*;

/**
 * Created by fzy on 17/10/2.
 */
public class FaceBook_InterSection {
  public List<Integer> intersecion(List<Integer> aList, List<Integer> bList) {
    Collections.sort(aList);
    Collections.sort(bList);
    int i = 0;
    int j = 0;
    ArrayList<Integer> s = new ArrayList<>();

    // do
    while (i < aList.size() && j < bList.size()) {
      if (aList.get(i) == bList.get(j)) {
        s.add(aList.get(i));
        i++;
        j++;
        continue;
      }

      if (aList.get(i) < bList.get(j)) {
        i++;
        continue;
      }

      if (bList.get(j) < aList.get(i)) {
        j++;
        continue;
      }
    }

    return s;
  }

  public static void main(String[] args) {
    int[] b = {2, 3, 5, 4, 1};
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < b.length; i++) {
      list.add(b[i]);
    }
    Collections.sort(list);
    System.out.print(list);

  }
}
