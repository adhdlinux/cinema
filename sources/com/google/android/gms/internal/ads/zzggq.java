package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzggq extends zzgdu {
    private static final zzges zza = zzges.zzb(zzggn.zza, zzggm.class, zzggf.class);

    public zzggq() {
        super(zzgjz.class, new zzggo(zzfye.class));
    }

    public static void zzh(boolean z2) throws GeneralSecurityException {
        zzfyp.zze(new zzggq(), true);
        int i2 = zzghb.zza;
        zzghb.zzc(zzgeg.zzc());
        zzgee.zza().zze(zza);
    }

    public static final void zzm(zzgjz zzgjz) throws GeneralSecurityException {
        zzgni.zzb(zzgjz.zza(), 0);
        if (zzgjz.zzh().zzd() >= 16) {
            zzo(zzgjz.zzg());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    static /* bridge */ /* synthetic */ zzgds zzn(int i2, int i3, int i4, int i5) {
        zzgkb zzd = zzgkc.zzd();
        zzgke zzc = zzgkf.zzc();
        zzc.zzb(i4);
        zzc.zza(i3);
        zzd.zzb((zzgkf) zzc.zzal());
        zzd.zza(i2);
        return new zzgds((zzgkc) zzd.zzal(), i5);
    }

    /* access modifiers changed from: private */
    public static void zzo(zzgkf zzgkf) throws GeneralSecurityException {
        if (zzgkf.zza() >= 10) {
            int zzg = zzgkf.zzg() - 2;
            if (zzg != 1) {
                if (zzg != 2) {
                    if (zzg != 3) {
                        if (zzg != 4) {
                            if (zzg != 5) {
                                throw new GeneralSecurityException("unknown hash type");
                            } else if (zzgkf.zza() > 28) {
                                throw new GeneralSecurityException("tag size too big");
                            }
                        } else if (zzgkf.zza() > 64) {
                            throw new GeneralSecurityException("tag size too big");
                        }
                    } else if (zzgkf.zza() > 32) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (zzgkf.zza() > 48) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (zzgkf.zza() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    public final zzgdt zza() {
        return new zzggp(this, zzgkc.class);
    }

    public final zzgkj zzb() {
        return zzgkj.SYMMETRIC;
    }

    public final /* synthetic */ zzgqw zzc(zzgoe zzgoe) throws zzgpy {
        return zzgjz.zzf(zzgoe, zzgoy.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzgqw zzgqw) throws GeneralSecurityException {
        zzm((zzgjz) zzgqw);
    }

    public final int zzf() {
        return 2;
    }
}
