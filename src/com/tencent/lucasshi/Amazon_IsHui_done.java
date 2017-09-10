package com.tencent.lucasshi;

import java.util.ArrayList;

/**
 * Created by fzy on 17/9/5.
 */
public class Amazon_IsHui_done {
    public boolean isHui(int number) {
        ArrayList<Boolean> numberBits = new ArrayList<>();

        while (number > 0) {
            numberBits.add(number % 2 == 0);
            number = number / 2;
        }

        for (int i = 0; i < numberBits.size(); i++) {
            if (numberBits.get(i) != numberBits.get(numberBits.size() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Amazon_IsHui_done hui = new Amazon_IsHui_done();
        System.out.println(hui.isHui(0x1001));
        System.out.println(hui.isHui(0x0005));
    }
}
