package com.facebook.ads.internal.p.b;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.facebook.ads.AudienceNetworkActivity;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class m {
    static String a(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i2])}));
        }
        return stringBuffer.toString();
    }

    static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                Log.e("ProxyCache", "Error closing resource", e2);
            }
        }
    }

    static void a(byte[] bArr, long j2, int i2) {
        j.a(bArr, "Buffer must be not null!");
        boolean z2 = true;
        j.a(j2 >= 0, "Data offset must be positive!");
        if (i2 < 0 || i2 > bArr.length) {
            z2 = false;
        }
        j.a(z2, "Length must be in range [0..buffer.length]");
    }

    static String b(String str) {
        try {
            return URLEncoder.encode(str, AudienceNetworkActivity.WEBVIEW_ENCODING);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Error encoding url", e2);
        }
    }

    static String c(String str) {
        try {
            return URLDecoder.decode(str, AudienceNetworkActivity.WEBVIEW_ENCODING);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Error decoding url", e2);
        }
    }

    public static String d(String str) {
        try {
            return a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
