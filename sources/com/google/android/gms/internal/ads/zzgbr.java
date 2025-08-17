package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzgbr {
    public static final /* synthetic */ int zza = 0;
    private static final zzgnk zzb;
    private static final zzgeo zzc;
    private static final zzgek zzd;
    private static final zzgdr zze;
    private static final zzgdn zzf;

    static {
        zzgnk zza2 = zzgfm.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zza2;
        Class<zzgfb> cls = zzgfb.class;
        zzc = zzgeo.zzb(zzgbn.zza, zzgbm.class, cls);
        zzd = zzgek.zzb(zzgbo.zza, zza2, cls);
        Class<zzgfa> cls2 = zzgfa.class;
        zze = zzgdr.zza(zzgbp.zza, zzgbe.class, cls2);
        zzf = zzgdn.zzb(zzgbq.zza, zza2, cls2);
    }

    public static /* synthetic */ zzgbe zza(zzgfa zzgfa, zzfyq zzfyq) {
        if (zzgfa.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzgjl zze2 = zzgjl.zze(zzgfa.zze(), zzgoy.zza());
                if (zze2.zza() == 0) {
                    zzgbj zzgbj = new zzgbj((zzgbi) null);
                    zzgbj.zza(zze2.zzf().zzd());
                    zzgbj.zzb(zzd(zzgfa.zzc()));
                    zzgbm zzc2 = zzgbj.zzc();
                    zzgbc zzgbc = new zzgbc((zzgbb) null);
                    zzgbc.zzc(zzc2);
                    zzgbc.zzb(zzgnl.zzb(zze2.zzf().zzA(), zzfyq));
                    zzgbc.zza(zzgfa.zzf());
                    return zzgbc.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgpy unused) {
                throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivParameters.parseParameters");
        }
    }

    public static /* synthetic */ zzgbm zzb(zzgfb zzgfb) {
        if (zzgfb.zzb().zzh().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzgjo zze2 = zzgjo.zze(zzgfb.zzb().zzg(), zzgoy.zza());
                zzgbj zzgbj = new zzgbj((zzgbi) null);
                zzgbj.zza(zze2.zza());
                zzgbj.zzb(zzd(zzgfb.zzb().zzf()));
                return zzgbj.zzc();
            } catch (zzgpy e2) {
                throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e2);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivParameters.parseParameters: ".concat(String.valueOf(zzgfb.zzb().zzh())));
        }
    }

    public static void zzc(zzgeg zzgeg) throws GeneralSecurityException {
        zzgeg.zzh(zzc);
        zzgeg.zzg(zzd);
        zzgeg.zzf(zze);
        zzgeg.zze(zzf);
    }

    private static zzgbk zzd(zzglq zzglq) throws GeneralSecurityException {
        zzglq zzglq2 = zzglq.UNKNOWN_PREFIX;
        int ordinal = zzglq.ordinal();
        if (ordinal == 1) {
            return zzgbk.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgbk.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzglq.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzgbk.zzb;
    }
}
