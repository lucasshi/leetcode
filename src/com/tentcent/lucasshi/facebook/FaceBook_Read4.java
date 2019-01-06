package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/15.
 */
public class FaceBook_Read4 {
    int read4(char[] buf) {
        return -1;
    }

    public int read(char[] buf, int n) {
        int count = 0;
        char[] buf4 = new char[4];
        int bufStart = 0;
        int bufEnd = 0;

        // do count
        while (count < n) {
            if (bufStart < bufEnd) {
                buf[count++] = buf4[bufStart++];
            } else {
                int cnt = read4(buf4);
                if (cnt < 0)
                    break;
                bufStart = 0;
                bufEnd = cnt - 1;
            }
        }

        return count;
    }
}
