package com.original.tase.helper.crypto;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.original.tase.Logger;
import com.utils.Utils;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AESEncrypter {

    /* renamed from: a  reason: collision with root package name */
    private static String f33878a = "";

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f33879b = {0, 1, 2, 3, 4, 5, 6};

    /* renamed from: c  reason: collision with root package name */
    private static int f33880c = 65536;

    /* renamed from: d  reason: collision with root package name */
    private static int f33881d = UserVerificationMethods.USER_VERIFY_HANDPRINT;

    /* renamed from: e  reason: collision with root package name */
    public static SecretKey f33882e = null;

    private AESEncrypter() {
    }

    public static String a(String str) {
        int length = 16 - (str.length() % 16);
        if (length <= 0 || length >= 16) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + length);
        stringBuffer.insert(0, str);
        while (length > 0) {
            stringBuffer.append(" ");
            length--;
        }
        return stringBuffer.toString();
    }

    public static String b(String str) {
        byte[] bArr;
        try {
            String a2 = a(str);
            e();
            SecretKeySpec secretKeySpec = new SecretKeySpec(f33882e.getEncoded(), "DES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(1, secretKeySpec);
            bArr = instance.doFinal(a2.getBytes());
        } catch (Exception unused) {
            bArr = null;
        }
        return new String(Base64.c(bArr));
    }

    public static String c(String str) {
        byte[] bArr;
        try {
            e();
            SecretKeySpec secretKeySpec = new SecretKeySpec(f33882e.getEncoded(), "DES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, secretKeySpec);
            bArr = instance.doFinal(Base64.b(str));
        } catch (Exception unused) {
            bArr = null;
        }
        return new String(bArr);
    }

    public static String d(String str, String str2) {
        byte[] bArr;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.substring(0, 16).getBytes("UTF-8"), "DES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, secretKeySpec);
            bArr = instance.doFinal(Base64.b(str));
        } catch (Exception unused) {
            bArr = null;
        }
        return new String(bArr);
    }

    public static SecretKey e() {
        SecretKey secretKey = f33882e;
        if (secretKey == null || secretKey.isDestroyed()) {
            String b2 = Utils.b();
            f33878a = b2;
            Logger.b("AESEncrypter key", b2);
            try {
                f33882e = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(f33878a.toCharArray(), f33879b, f33880c, f33881d));
            } catch (Exception unused) {
            }
        }
        return f33882e;
    }
}
