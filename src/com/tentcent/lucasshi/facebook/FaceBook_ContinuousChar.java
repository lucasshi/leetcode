package com.tentcent.lucasshi.facebook;

import java.util.HashSet;

/**
 * Created by fzy on 17/10/14.
 */
public class FaceBook_ContinuousChar {
  public void continuousChar(String str) {
    HashSet<Character> maxSets = new HashSet<>();
    int maxCount = 0;
    int count = 0;
    char prev = 0;

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ')
        continue;

      if (str.charAt(i) != prev) {
        if (count > maxCount) {
          maxCount = count;
          maxSets.clear();
          maxSets.add(prev);
        } else if (count == maxCount) {
          maxSets.add(prev);
        }

        count = 1;
        prev = str.charAt(i);
      } else {
        count++;
        prev = str.charAt(i);
      }
    }

    if (count == maxCount) {
      maxSets.add(prev);
    }

    System.out.println(maxSets);
  }

  public static void main(String[] args) {
    String s = "this send meet";
    String s2 = "this is pea";
    FaceBook_ContinuousChar p = new FaceBook_ContinuousChar();
    p.continuousChar(s);
    p.continuousChar(s2);
  }
}
