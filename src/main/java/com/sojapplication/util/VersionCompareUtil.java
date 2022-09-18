package com.sojapplication.util;

public class VersionCompareUtil {

    public static int compareVersions(final String version1, final String version2) {
        final String[] str1 = version1.split("\\.");
        final String[] str2 = version2.split("\\.");
        final int max = Math.max(str1.length, str2.length);
        for (int i = 0; i < max; i++) {
            final int num1 = i >= str1.length ? 0 : Integer.parseInt(str1[i]);
            final int num2 = i >= str2.length ? 0 : Integer.parseInt(str2[i]);
            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }
        return 0;
    }
    
}
