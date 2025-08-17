package com.google.android.gms.internal.ads;

import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.Provider;

final class zzgmo implements zzgmp {
    private final zzgmy zza;

    /* synthetic */ zzgmo(zzgmy zzgmy, zzgmn zzgmn) {
        this.zza = zzgmy;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider zza2 : zzgmq.zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL", "Conscrypt")) {
            try {
                return this.zza.zza(str, zza2);
            } catch (Exception e2) {
                if (exc == null) {
                    exc = e2;
                }
            }
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
