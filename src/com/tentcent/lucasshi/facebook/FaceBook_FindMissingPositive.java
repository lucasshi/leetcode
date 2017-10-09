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

    public static void main(String[] args) {

    }
}
