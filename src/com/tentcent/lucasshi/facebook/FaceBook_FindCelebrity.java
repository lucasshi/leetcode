package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/9.
 */
public class FaceBook_FindCelebrity {
    public boolean isRight(int i, int j) {
        return false;
    }

    public int findCelebrity(int n) {
        int possible = 0;

        for (int i = 1; i < n; i++) {
            if (isRight(possible, i)) {
                possible = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == possible)
                continue;

            if (isRight(possible, i) || !isRight(i, possible)) {
                return -1;
            }
        }

        return 1;
    }
}
