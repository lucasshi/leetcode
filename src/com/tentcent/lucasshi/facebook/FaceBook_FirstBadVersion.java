package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/15.
 */
public class FaceBook_FirstBadVersion {
    private boolean isBadVersion(int version) {
        if (version >= 1702766719)
            return true;
        return false;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = (left + right) / 2;
            System.out.println(mid);

            if (isBadVersion(mid)) {
                if (mid == 1 || !isBadVersion(mid - 1)) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }

        }

        return n;
    }

    public static void main(String[] args) {
        FaceBook_FirstBadVersion p = new FaceBook_FirstBadVersion();
        // p.firstBadVersion(2126753390);
        System.out.println((2126753390 + 1) / 2);

    }
}
