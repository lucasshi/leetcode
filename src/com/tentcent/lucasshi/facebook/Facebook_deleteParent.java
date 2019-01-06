package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/3.
 */
public class Facebook_deleteParent {
    public String deleteParentThesis(String s) {
        int leftCount = 0;
        int rightCount = 0;

        String s1 = "";
        String s2 = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount += 1;
            } else if (s.charAt(i) == ')') {
                rightCount += 1;
            }

            if (rightCount > leftCount) {
                rightCount = 0;
                leftCount = 0;
                continue;
            }

            s1 += s.charAt(i);
        }

        if (leftCount == rightCount) {
            return s1;
        }

        System.out.println(s1);

        // 说明不对
        rightCount = leftCount = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                leftCount++;
            } else if (s.charAt(i) == '(') {
                rightCount++;
            }

            if (rightCount > leftCount) {
                rightCount = 0;
                leftCount = 0;
                continue;
            }

            s2 = s1.charAt(i) + s2;
        }

        System.out.println(s2);
        return s2;
    }

    public static void main(String[] args) {
        Facebook_deleteParent p = new Facebook_deleteParent();
        p.deleteParentThesis("((((())()))");

    }
}
