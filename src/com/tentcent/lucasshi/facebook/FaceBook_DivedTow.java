package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/15.
 */
public class FaceBook_DivedTow {
    public int divid(int a, int b) {
        if (b > a)
            return 0;

        int result = 0;
        while (a >= b) {
            int sub = b;
            int cnt = -1;
            while (a >= sub) {
                cnt += 1;
                sub = (sub << 1);
            }

            result += (1 << cnt);
            a = a - (sub >> 1);
            System.out.println(result + " " + sub + " " + a);

        }

        return result;
    }

    public static void main(String[] args) {
        FaceBook_DivedTow p = new FaceBook_DivedTow();
        System.out.println(p.divid(18, 3));
    }
}
