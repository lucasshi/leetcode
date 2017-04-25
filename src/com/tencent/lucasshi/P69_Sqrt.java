package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/24.
 */
public class P69_Sqrt {
    public int mySqrt(int x) {
        if (x == 1)
            return 1;

        if (x == 0)
            return 0;

        int start = 1;
        int end = 2;
        while (true) {
            if (end * end < x) {
                end = end * 2;
                start = start * 2;
            } else if (end * end == x) {
                return end;
            } else {
                break;
            }
        }

        // 从StartEnd中间找
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 1;
    }
}
