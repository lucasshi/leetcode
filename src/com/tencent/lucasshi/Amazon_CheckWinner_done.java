package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fzy on 17/9/3.
 */
public class Amazon_CheckWinner_done {
    public boolean checkWinner(List<List<String>> codeList, List<String> checkList) {
        int codeIndex = 0;
        int checkIndex = 0;

        if (codeList.size() == 0)
            return true;
        // do
        while (checkIndex < checkList.size()) {
            List<String> codes = codeList.get(codeIndex);

            boolean isMatched = true;
            for (int i = 0; i < codes.size(); i++) {
                if (checkIndex + i > checkList.size() - 1)
                    return false;

                if (codes.get(i).equals("anything")) {
                    continue;
                }

                if (!codes.get(i).equals(checkList.get(checkIndex + i))) {
                    isMatched = false;
                    break;
                }
            }

            if (isMatched) {
                checkIndex += codes.size();
                codeIndex++;
            } else {
                checkIndex += 1;
            }
        }

        return codeIndex == codeList.size();
    }

    public static void main(String[] args) {
        ArrayList<List<String>> codeList = new ArrayList<>();
        codeList.add(Arrays.asList("apple", "apple"));
        codeList.add(Arrays.asList("orange", "banana", "orange"));

        ArrayList<String> checkList = new ArrayList<>(
                Arrays.asList("apple", "apple", "grape", "orange", "banana", "orange"));

        Amazon_CheckWinner_done ack = new Amazon_CheckWinner_done();
        System.out.println(ack.checkWinner(codeList, checkList));

        // check2
        codeList.clear();
        codeList.add(Arrays.asList("orange", "banana", "orange"));
        codeList.add(Arrays.asList("apple", "apple"));

        checkList = new ArrayList<>(
                Arrays.asList("orange", "apple", "apple", "orange", "banana", "orange"));
        System.out.println(ack.checkWinner(codeList, checkList));

        // check 3
        codeList.clear();
        codeList.add(Arrays.asList("apple", "apple"));
        codeList.add(Arrays.asList("orange", "banana", "orange"));
        codeList.add(Arrays.asList("pear", "orange", "grape"));

        checkList = new ArrayList<>(
                Arrays.asList("orange", "apple", "apple", "orange", "banana", "orange", "pear", "grape"));
        System.out.println(ack.checkWinner(codeList, checkList));

        // check 4
        codeList.clear();
        codeList.add(Arrays.asList("apple", "apple"));
        codeList.add(Arrays.asList("orange", "anything", "orange"));

        checkList = new ArrayList<>(
                Arrays.asList("orange", "apple", "apple", "orange", "mango", "orange"));
        System.out.println(ack.checkWinner(codeList, checkList));

        //
        codeList.clear();
        codeList.add(Arrays.asList("orange"));
        codeList.add(Arrays.asList("apple", "apple"));
        codeList.add(Arrays.asList("banana", "orange", "apple"));
        codeList.add(Arrays.asList("banana"));

        checkList = new ArrayList<>(
                Arrays.asList("orange", "apple", "apple", "banana", "orange", "apple", "banana"));
        System.out.println(ack.checkWinner(codeList, checkList));

    }


}
