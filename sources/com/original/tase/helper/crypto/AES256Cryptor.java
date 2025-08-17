package com.original.tase.helper.crypto;

import android.util.Base64;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES256Cryptor {
    private static byte[] a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, String str, byte[] bArr3, byte[] bArr4) throws NoSuchAlgorithmException {
        int i5 = i2 / 32;
        int i6 = i3 / 32;
        int i7 = i5 + i6;
        byte[] bArr5 = new byte[(i7 * 4)];
        MessageDigest instance = MessageDigest.getInstance(str);
        byte[] bArr6 = null;
        int i8 = 0;
        while (i8 < i7) {
            if (bArr6 != null) {
                instance.update(bArr6);
            }
            instance.update(bArr);
            bArr6 = instance.digest(bArr2);
            instance.reset();
            for (int i9 = 1; i9 < i4; i9++) {
                bArr6 = instance.digest(bArr6);
                instance.reset();
            }
            System.arraycopy(bArr6, 0, bArr5, i8 * 4, Math.min(bArr6.length, (i7 - i8) * 4));
            i8 += bArr6.length / 4;
        }
        int i10 = i5 * 4;
        System.arraycopy(bArr5, 0, bArr3, 0, i10);
        System.arraycopy(bArr5, i10, bArr4, 0, i6 * 4);
        return bArr5;
    }

    private static byte[] b(byte[] bArr, int i2, int i3, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws NoSuchAlgorithmException {
        return a(bArr, i2, i3, bArr2, 1, "MD5", bArr3, bArr4);
    }

    public static String c(String str, String str2) {
        try {
            byte[] decode = Base64.decode(str.getBytes("UTF-8"), 0);
            byte[] copyOfRange = Arrays.copyOfRange(decode, 8, 16);
            byte[] copyOfRange2 = Arrays.copyOfRange(decode, 16, decode.length);
            byte[] bArr = new byte[32];
            byte[] bArr2 = new byte[16];
            b(str2.getBytes("UTF-8"), UserVerificationMethods.USER_VERIFY_HANDPRINT, 128, copyOfRange, bArr, bArr2);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
            return new String(instance.doFinal(copyOfRange2));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String d(String str, String str2) {
        try {
            byte[] bArr = new byte[32];
            byte[] bArr2 = new byte[16];
            byte[] e2 = e(8);
            b(str2.getBytes("UTF-8"), UserVerificationMethods.USER_VERIFY_HANDPRINT, 128, e2, bArr, bArr2);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
            byte[] doFinal = instance.doFinal(str.getBytes("UTF-8"));
            byte[] bytes = "Salted__".getBytes("UTF-8");
            byte[] bArr3 = new byte[(bytes.length + e2.length + doFinal.length)];
            System.arraycopy(bytes, 0, bArr3, 0, bytes.length);
            System.arraycopy(e2, 0, bArr3, bytes.length, e2.length);
            System.arraycopy(doFinal, 0, bArr3, bytes.length + e2.length, doFinal.length);
            return new String(Base64.encode(bArr3, 0));
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private static byte[] e(int i2) {
        byte[] bArr = new byte[i2];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }
}
