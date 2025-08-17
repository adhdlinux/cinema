package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

final class zzgmd extends ThreadLocal {
    zzgmd() {
    }

    protected static final Cipher zza() {
        try {
            return (Cipher) zzgmq.zza.zza("AES/CTR/NOPADDING");
        } catch (GeneralSecurityException e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
