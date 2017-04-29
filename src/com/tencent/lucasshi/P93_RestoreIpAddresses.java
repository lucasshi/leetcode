package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/4/29.
 */
public class P93_RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        return restoreIpAddressWithNumber(s, 4);
    }

    // restore几个
    public List<String> restoreIpAddressWithNumber(String s, int n) {
        List<String> results = new ArrayList<>();
        if (s.length() == 0) {
            return results;
        }
        if (n == 1) {
            if (s.length() > 3 || Integer.parseInt(s) > 255 || (s.length() > 1 && s.charAt(0) == '0')) {
                return results;
            } else {
                List<String> result = new ArrayList<>();
                result.add(s);
                return result;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (i + 1 > s.length()) {
                continue;
            }
            String substr = s.substring(0, i + 1);
            String posStr = s.substring(i + 1);

            if (substr.length() > 1 && substr.charAt(0) == '0') {
                continue;
            }
            if (Integer.parseInt(substr) <= 255) {
                List<String> subResults = restoreIpAddressWithNumber(posStr, n - 1);
                if (subResults.size() != 0) {
                    for (String subResult : subResults) {
                        subResult = substr + "." + subResult;
                        results.add(subResult);
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        String s = "ab";
        System.out.println(s.substring(0, 2));
        System.out.println(s.substring(1));
        Integer.parseInt("9245587303");

    }

}
