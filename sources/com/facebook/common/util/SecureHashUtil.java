package com.facebook.common.util;

import android.util.Base64;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Nullsafe(Nullsafe.Mode.STRICT)
public class SecureHashUtil {
    private static final int BUFFER_SIZE = 4096;
    static final byte[] HEX_CHAR_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    public static String convertToHex(byte[] bArr) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder(bArr.length);
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            byte[] bArr2 = HEX_CHAR_TABLE;
            sb.append((char) bArr2[b3 >>> 4]);
            sb.append((char) bArr2[b3 & 15]);
        }
        return sb.toString();
    }

    private static String makeHash(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr, 0, bArr.length);
            return convertToHex(instance.digest());
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static String makeMD5Hash(String str) {
        try {
            return makeMD5Hash(str.getBytes(AudienceNetworkActivity.WEBVIEW_ENCODING));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String makeSHA1Hash(String str) {
        try {
            return makeSHA1Hash(str.getBytes(AudienceNetworkActivity.WEBVIEW_ENCODING));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String makeSHA1HashBase64(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bArr, 0, bArr.length);
            return Base64.encodeToString(instance.digest(), 11);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String makeSHA256Hash(byte[] bArr) {
        return makeHash(bArr, "SHA-256");
    }

    public static String makeMD5Hash(byte[] bArr) {
        return makeHash(bArr, "MD5");
    }

    public static String makeSHA1Hash(byte[] bArr) {
        return makeHash(bArr, "SHA-1");
    }

    public static String makeMD5Hash(InputStream inputStream) throws IOException {
        return makeHash(inputStream, "MD5");
    }

    private static String makeHash(InputStream inputStream, String str) throws IOException {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return convertToHex(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException(e3);
        }
    }
}
