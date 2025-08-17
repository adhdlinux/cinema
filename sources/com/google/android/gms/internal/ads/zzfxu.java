package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzfxu {
    public static zzfxt zza(String str) throws GeneralSecurityException {
        zzfxt zzfxt = (zzfxt) zzfyp.zzd().get("AES128_GCM");
        if (zzfxt != null) {
            return zzfxt;
        }
        throw new GeneralSecurityException("cannot find key template: AES128_GCM");
    }
}
