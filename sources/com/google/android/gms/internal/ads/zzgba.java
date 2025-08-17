package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzgba {
    public static final /* synthetic */ int zza = 0;
    private static final zzgnk zzb;
    private static final zzgeo zzc;
    private static final zzgek zzd;
    private static final zzgdr zze;
    private static final zzgdn zzf;

    static {
        zzgnk zza2 = zzgfm.zza("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzb = zza2;
        Class<zzgfb> cls = zzgfb.class;
        zzc = zzgeo.zzb(zzgaw.zza, zzgav.class, cls);
        zzd = zzgek.zzb(zzgax.zza, zza2, cls);
        Class<zzgfa> cls2 = zzgfa.class;
        zze = zzgdr.zza(zzgay.zza, zzgan.class, cls2);
        zzf = zzgdn.zzb(zzgaz.zza, zza2, cls2);
    }

    public static /* synthetic */ zzgan zza(zzgfa zzgfa, zzfyq zzfyq) {
        if (zzgfa.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzgjf zze2 = zzgjf.zze(zzgfa.zze(), zzgoy.zza());
                if (zze2.zza() == 0) {
                    zzgas zzgas = new zzgas((zzgar) null);
                    zzgas.zzb(zze2.zzf().zzd());
                    zzgas.zza(12);
                    zzgas.zzc(16);
                    zzgas.zzd(zzd(zzgfa.zzc()));
                    zzgav zze3 = zzgas.zze();
                    zzgal zzgal = new zzgal((zzgak) null);
                    zzgal.zzc(zze3);
                    zzgal.zzb(zzgnl.zzb(zze2.zzf().zzA(), zzfyq));
                    zzgal.zza(zzgfa.zzf());
                    return zzgal.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgpy unused) {
                throw new GeneralSecurityException("Parsing AesGcmKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmParameters.parseParameters");
        }
    }

    public static /* synthetic */ zzgav zzb(zzgfb zzgfb) {
        if (zzgfb.zzb().zzh().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzgji zze2 = zzgji.zze(zzgfb.zzb().zzg(), zzgoy.zza());
                zzgas zzgas = new zzgas((zzgar) null);
                zzgas.zzb(zze2.zza());
                zzgas.zza(12);
                zzgas.zzc(16);
                zzgas.zzd(zzd(zzgfb.zzb().zzf()));
                return zzgas.zze();
            } catch (zzgpy e2) {
                throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e2);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmParameters.parseParameters: ".concat(String.valueOf(zzgfb.zzb().zzh())));
        }
    }

    public static void zzc(zzgeg zzgeg) throws GeneralSecurityException {
        zzgeg.zzh(zzc);
        zzgeg.zzg(zzd);
        zzgeg.zzf(zze);
        zzgeg.zze(zzf);
    }

    private static zzgat zzd(zzglq zzglq) throws GeneralSecurityException {
        zzglq zzglq2 = zzglq.UNKNOWN_PREFIX;
        int ordinal = zzglq.ordinal();
        if (ordinal == 1) {
            return zzgat.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgat.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzglq.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzgat.zzb;
    }
}
