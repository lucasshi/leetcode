package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/10.
 */
public class P673_NumberOfLCS {
    public int findNumberOfLIS(int[] nums) {
        int[] dpLength = new int[nums.length];
        int[] maxCount = new int[nums.length];
        // dp
        for (int i = 0; i < nums.length; i++) {
            int maxLength = 1;
            int cnt = 1;
            dpLength[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dpLength[j] + 1 > maxLength) {
                        maxLength = dpLength[j] + 1;
                        cnt = maxCount[j];
                    } else if (dpLength[j] + 1 == maxLength) {
                        cnt += maxCount[j];
                    }
                }
            }

            dpLength[i] = maxLength;
            maxCount[i] = cnt;
        }

        int maxLCSLength = 0;
        int maxLCSCount = 0;
        for (int i = 0; i < dpLength.length; i++) {
            if (maxLCSLength < dpLength[i]) {
                maxLCSCount = maxCount[i];
                maxLCSLength = dpLength[i];
            } else if (dpLength[i] == maxLCSLength) {
                maxLCSCount += maxCount[i];
            }
        }
        return maxLCSCount;
    }

    public static void main(String[] args) {
        P673_NumberOfLCS p673_numberOfLCS = new P673_NumberOfLCS();
        int[] nums1 = {1, 3, 5, 4, 7};
        int[] nums2 = {1, 2, 4, 3, 5, 4, 7, 2};

        //System.out.println(p673_numberOfLCS.findNumberOfLIS(nums1));
        System.out.println(p673_numberOfLCS.findNumberOfLIS(nums2));

    }
}
