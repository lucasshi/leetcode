package com.tencent.lucasshi;

/**
 * Created by fzy on 16/9/16.
 */
public class P6_ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == "") {
            return "";
        }

        int numCols = numRows == 1 ? s.length() : (s.length() / (numRows * 2 - 2) + 1) * 2 + 1;
        char[][] zigZagTable = new char[numRows][numCols];

        // 进行处理
        int rowIndex = 0;
        int colIndex = 0;

        if (numRows == 1) {
            return s;
        }

        if (numRows == 2) {
            String sequence = "";
            for (int i = 0; i < s.length(); i = i + 2) {
                sequence += s.charAt(i);
            }

            for (int i = 1; i < s.length(); i = i + 2) {
                sequence += s.charAt(i);
            }

            return sequence;
        }

        for (int i = 0; i < s.length(); i++) {
            char seq = s.charAt(i);
            zigZagTable[rowIndex][colIndex] = seq;
            System.out.println(seq);
            // 确定下一个, 奇数
            if (colIndex % 2 == 1) {
                if (rowIndex == 1) {
                    colIndex++;
                    rowIndex = 0;
                } else {
                    rowIndex--;
                }
            } else if (colIndex % 2 == 0) {
                if (rowIndex == numRows - 1) {
                    rowIndex = numRows - 2;
                    colIndex++;
                } else {
                    rowIndex++;
                }
            }
        }

        // 打印一下结果
        String sequence = "";
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numCols; j++) {
                if (zigZagTable[i][j] != '\0') {
                    sequence += zigZagTable[i][j];
                }
            }

        return sequence;
    }

    public static void main(String[] args) {
        P6_ZigZagConversion p = new P6_ZigZagConversion();
        System.out.println(p.convert("ABCDE", 4));
    }
}
