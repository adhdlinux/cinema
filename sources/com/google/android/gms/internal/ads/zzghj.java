package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzghj implements zzggf {
    private final zzgfq zza;

    public zzghj(zzgfq zzgfq) throws GeneralSecurityException {
        if (zzgdh.zza(1)) {
            this.zza = zzgfq;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }
}
