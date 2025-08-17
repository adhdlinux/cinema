package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class zzfoj {
    public static String zza(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            return Base64.encodeToString(instance.digest(), 11);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
