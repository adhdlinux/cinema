package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public final class zzgbh extends zzgdu {
    zzgbh() {
        super(zzgjl.class, new zzgbf(zzfxh.class));
    }

    public static void zzg(boolean z2) throws GeneralSecurityException {
        if (zzm()) {
            zzfyp.zze(new zzgbh(), true);
            int i2 = zzgbr.zza;
            zzgbr.zzc(zzgeg.zzc());
        }
    }

    static /* bridge */ /* synthetic */ zzgds zzh(int i2, int i3) {
        zzgjn zzc = zzgjo.zzc();
        zzc.zza(i2);
        return new zzgds((zzgjo) zzc.zzal(), i3);
    }

    private static boolean zzm() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public final zzgdt zza() {
        return new zzgbg(this, zzgjo.class);
    }

    public final zzgkj zzb() {
        return zzgkj.SYMMETRIC;
    }

    public final /* synthetic */ zzgqw zzc(zzgoe zzgoe) throws zzgpy {
        return zzgjl.zze(zzgoe, zzgoy.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzgqw zzgqw) throws GeneralSecurityException {
        zzgjl zzgjl = (zzgjl) zzgqw;
        zzgni.zzb(zzgjl.zza(), 0);
        zzgni.zza(zzgjl.zzf().zzd());
    }
}
