package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzfxp implements zzfxo {
    private final zzgdu zza;
    private final Class zzb;

    public zzfxp(zzgdu zzgdu, Class cls) {
        if (zzgdu.zzl().contains(cls) || Void.class.equals(cls)) {
            this.zza = zzgdu;
            this.zzb = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{zzgdu.toString(), cls.getName()}));
    }

    public final zzgkk zza(zzgoe zzgoe) throws GeneralSecurityException {
        try {
            zzgdt zza2 = this.zza.zza();
            zzgqw zzb2 = zza2.zzb(zzgoe);
            zza2.zzd(zzb2);
            zzgqw zza3 = zza2.zza(zzb2);
            zzgkh zza4 = zzgkk.zza();
            zza4.zzb(this.zza.zzd());
            zza4.zzc(zza3.zzau());
            zza4.zza(this.zza.zzb());
            return (zzgkk) zza4.zzal();
        } catch (zzgpy e2) {
            throw new GeneralSecurityException("Unexpected proto", e2);
        }
    }

    public final Object zzb(zzgoe zzgoe) throws GeneralSecurityException {
        try {
            zzgqw zzc = this.zza.zzc(zzgoe);
            if (!Void.class.equals(this.zzb)) {
                this.zza.zze(zzc);
                return this.zza.zzk(zzc, this.zzb);
            }
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        } catch (zzgpy e2) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(this.zza.zzj().getName()), e2);
        }
    }

    public final String zzc() {
        return this.zza.zzd();
    }
}
