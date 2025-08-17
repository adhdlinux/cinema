package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public final class zzfau {
    public zzfau() {
        try {
            zzfys.zza();
        } catch (GeneralSecurityException e2) {
            zze.zza("Failed to Configure Aead. ".concat(e2.toString()));
            zzt.zzo().zzu(e2, "CryptoUtils.registerAead");
        }
    }

    public static final String zza() {
        zzgob zzt = zzgoe.zzt();
        try {
            zzfxk.zzb(zzfyb.zzc(zzfxu.zza("AES128_GCM").zza()), zzfxj.zzb(zzt));
        } catch (IOException | GeneralSecurityException e2) {
            zze.zza("Failed to generate key".concat(e2.toString()));
            zzt.zzo().zzu(e2, "CryptoUtils.generateKey");
        }
        String encodeToString = Base64.encodeToString(zzt.zzb().zzA(), 11);
        zzt.zzc();
        return encodeToString;
    }

    public static final String zzb(byte[] bArr, byte[] bArr2, String str, zzdpv zzdpv) {
        zzfyb zzc = zzc(str);
        if (zzc == null) {
            return null;
        }
        try {
            byte[] zza = ((zzfxh) zzc.zze(zzgfc.zza(), zzfxh.class)).zza(bArr, bArr2);
            zzdpv.zza().put("ds", "1");
            return new String(zza, "UTF-8");
        } catch (UnsupportedEncodingException | GeneralSecurityException e2) {
            zze.zza("Failed to decrypt ".concat(e2.toString()));
            zzt.zzo().zzu(e2, "CryptoUtils.decrypt");
            zzdpv.zza().put("dsf", e2.toString());
            return null;
        }
    }

    private static final zzfyb zzc(String str) {
        try {
            return zzfxk.zza(zzfxi.zzb(Base64.decode(str, 11)));
        } catch (IOException | GeneralSecurityException e2) {
            zze.zza("Failed to get keysethandle".concat(e2.toString()));
            zzt.zzo().zzu(e2, "CryptoUtils.getHandle");
            return null;
        }
    }
}
