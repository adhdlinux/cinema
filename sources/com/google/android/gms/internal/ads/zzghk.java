package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzghk implements zzggf {
    private final zzggm zza;

    public zzghk(zzggm zzggm) throws GeneralSecurityException {
        if (zzgdh.zza(2)) {
            this.zza = zzggm;
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
