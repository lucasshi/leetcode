package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.List;

/**
 * Created by fzy on 17/7/31.
 */
class MyException extends Exception {

}

public class P228_ExpressionAddOperator {

    public void B() {
        try {
            A(9);
        } catch (MyException e) {
            System.out.println("cao ni ma bi de");
            e.printStackTrace();
        }
    }

    public int A(int value) throws MyException {
        if (value < 10) {
            throw new MyException();
        }

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(111);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    public static void main(String[] args) {
        P228_ExpressionAddOperator p = new P228_ExpressionAddOperator();
        p.B();
    }

}
