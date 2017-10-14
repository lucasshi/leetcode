package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/9.
 */
public class FaceBook_FindMissingPositive {
  public int firstMissingPositive(int[] a) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] == i + 1)
        continue;

      while (a[i] != i + 1 && a[i] > 0 && a[i] <= a.length) {
        int index = a[i] - 1;
        int tmp = a[index];
        a[index] = a[i];
        a[i] = tmp;
      }
    }

    for (int i = 0; i < a.length; i++) {
      if (a[i] != i + 1) {
        return i;
      }
    }

    return a.length;
  }

  public int findDuplicate(int[] a) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] == i + 1) {
        continue;
      }

      while (a[i] != i + 1) {
        int idx = a[i] - 1;
        // already on the way
        if (a[idx] == idx + 1) {
          return a[idx];
        }

        int tmp = a[idx];
        a[idx] = a[i];
        a[i] = tmp;
      }
    }

    return a[a.length - 1];
  }

  public int findDuplicate2(int[] a) {
    int left = 0;
    int right = a.length - 1;

    while (left < right) {
      int midIndex = (left + right) / 2;
      if (a[midIndex] == midIndex + 1) {
        if (a[midIndex + 1] == a[midIndex])
          return a[midIndex];
        left = midIndex + 1;
      } else {
        if (a[midIndex - 1] == a[midIndex])
          return a[midIndex];
        right = midIndex - 1;
      }
    }

    return a[left];
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10};
    FaceBook_FindMissingPositive p = new FaceBook_FindMissingPositive();
    System.out.println(p.findDuplicate2(a));
  }
}
