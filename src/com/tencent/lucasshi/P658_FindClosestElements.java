package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

public class P658_FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length;
        int rindex = -1;
        ArrayList<Integer> result = new ArrayList<>();
        while (left < right) {
            rindex = (left + right) / 2;
            if (arr[rindex] == x) {
                break;
            } else if (arr[rindex] > x) {
                right = rindex;
            } else {
                left = rindex + 1;
            }
        }

        int lindex = rindex - 1;
        while (result.size() < k) {
            if (lindex < 0) {
                result.add(arr[rindex]);
                rindex += 1;
            } else if (rindex > arr.length - 1) {
                result.add(arr[lindex]);
                lindex -= 1;
            } else if (Math.abs(arr[rindex] - x) < Math.abs(arr[lindex] - x)) {
                result.add(arr[rindex]);
                rindex += 1;
            } else {
                result.add(arr[lindex]);
                lindex -= 1;
            }
        }
        result.sort((a, b) -> a - b);
        return result;
    }

    public static void main(String[] args) {
        P658_FindClosestElements p = new P658_FindClosestElements();
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(p.findClosestElements(arr, 4, 3));
    }
}
