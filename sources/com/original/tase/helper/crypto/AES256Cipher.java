package com.original.tase.helper.crypto;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES256Cipher {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f33877a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static String a(String str, String str2) {
        try {
            byte[] decode = Base64.decode(str, 0);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f33877a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            return new String(instance.doFinal(decode), "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }
}
