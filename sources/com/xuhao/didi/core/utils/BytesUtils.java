package com.xuhao.didi.core.utils;

public class BytesUtils {
    public static String toHexStringForLog(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                String str = Integer.toHexString(bArr[i2] & 255) + " ";
                if (str.length() == 2) {
                    str = "0" + str;
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }
}
