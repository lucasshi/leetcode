package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/15.
 */
public class FaceBook_read4_2 {
    private char[] buf4 = new char[4];
    private int buf4Start = 0;
    private int buf4End = 0;

    int read4(char[] buf) {
        return -1;
    }

    public int read(char[] buf, int n) {
        int count = 0;
        while (count < n) {
            if (buf4Start < buf4End) {
                buf[count++] = buf4[buf4Start++];
            } else {
                int cnt = read4(buf4);
                if (cnt < 0)
                    return count;
                buf4Start = 0;
                buf4End = cnt - 1;
                buf[count++] = buf[buf4Start++];
            }
        }

        return count;
    }
}
