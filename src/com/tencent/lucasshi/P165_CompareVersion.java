package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/10.
 */
public class P165_CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");

        int length = Math.min(version1Array.length, version2Array.length);

        for (int i = 0; i < length; i++) {
            int subV1 = Integer.parseInt(version1Array[i]);
            int subV2 = Integer.parseInt(version2Array[i]);

            if (subV1 > subV2)
                return 1;
            else if (subV1 < subV2)
                return -1;
        }

        if (version1Array.length == version2Array.length) {
            return 0;
        } else if (version1Array.length < version1Array.length) {
            for (int i = version1Array.length - 1; i < version2Array.length; i++) {
                if (Integer.parseInt(version2Array[i]) != 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            for (int i = version2Array.length - 1; i < version1Array.length; i++) {
                if (Integer.parseInt(version2Array[i]) != 0) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        P165_CompareVersion p = new P165_CompareVersion();
        p.compareVersion("1.1", "1.1.0");
    }
}
