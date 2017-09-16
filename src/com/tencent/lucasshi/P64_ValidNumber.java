package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/15.
 */
public class P64_ValidNumber {
    private static final int INITIAL_STATE = 0;
    private static final int NEGATIVE_STATE = 1;
    private static final int INTEGER_STATE = 2;
    private static final int POINT_STATE = 3;
    private static final int DECIMAL_STATE = 6;
    private static final int SCIENCE_STATE = 4;
    private static final int LAST_STATE = 5;

    private int state = INITIAL_STATE;
    private String integerPart = "";
    private String decimalPart = "";
    private String sciencePart = "";

}
