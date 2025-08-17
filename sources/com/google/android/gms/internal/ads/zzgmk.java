package com.google.android.gms.internal.ads;

import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.Provider;

final class zzgmk implements zzgmp {
    private final zzgmy zza;

    /* synthetic */ zzgmk(zzgmy zzgmy, zzgmj zzgmj) {
        this.zza = zzgmy;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        for (Provider zza2 : zzgmq.zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL")) {
            try {
                return this.zza.zza(str, zza2);
            } catch (Exception unused) {
            }
        }
        return this.zza.zza(str, (Provider) null);
    }
}
