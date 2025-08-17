package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzgaj {
    public static final /* synthetic */ int zza = 0;
    private static final zzgnk zzb;
    private static final zzgeo zzc;
    private static final zzgek zzd;
    private static final zzgdr zze;
    private static final zzgdn zzf;

    static {
        zzgnk zza2 = zzgfm.zza("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zza2;
        Class<zzgfb> cls = zzgfb.class;
        zzc = zzgeo.zzb(zzgaf.zza, zzgae.class, cls);
        zzd = zzgek.zzb(zzgag.zza, zza2, cls);
        Class<zzgfa> cls2 = zzgfa.class;
        zze = zzgdr.zza(zzgah.zza, zzfzw.class, cls2);
        zzf = zzgdn.zzb(zzgai.zza, zza2, cls2);
    }

    public static /* synthetic */ zzfzw zza(zzgfa zzgfa, zzfyq zzfyq) {
        if (zzgfa.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzgiw zze2 = zzgiw.zze(zzgfa.zze(), zzgoy.zza());
                if (zze2.zza() == 0) {
                    zzgab zzgab = new zzgab((zzgaa) null);
                    zzgab.zzb(zze2.zzg().zzd());
                    zzgab.zza(zze2.zzf().zza());
                    zzgab.zzc(16);
                    zzgab.zzd(zzd(zzgfa.zzc()));
                    zzgae zze3 = zzgab.zze();
                    zzfzu zzfzu = new zzfzu((zzfzt) null);
                    zzfzu.zzc(zze3);
                    zzfzu.zzb(zzgnl.zzb(zze2.zzg().zzA(), zzfyq));
                    zzfzu.zza(zzgfa.zzf());
                    return zzfzu.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgpy unused) {
                throw new GeneralSecurityException("Parsing AesEaxcKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters");
        }
    }

    public static /* synthetic */ zzgae zzb(zzgfb zzgfb) {
        if (zzgfb.zzb().zzh().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzgiz zze2 = zzgiz.zze(zzgfb.zzb().zzg(), zzgoy.zza());
                zzgab zzgab = new zzgab((zzgaa) null);
                zzgab.zzb(zze2.zza());
                zzgab.zza(zze2.zzf().zza());
                zzgab.zzc(16);
                zzgab.zzd(zzd(zzgfb.zzb().zzf()));
                return zzgab.zze();
            } catch (zzgpy e2) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e2);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters: ".concat(String.valueOf(zzgfb.zzb().zzh())));
        }
    }

    public static void zzc(zzgeg zzgeg) throws GeneralSecurityException {
        zzgeg.zzh(zzc);
        zzgeg.zzg(zzd);
        zzgeg.zzf(zze);
        zzgeg.zze(zzf);
    }

    private static zzgac zzd(zzglq zzglq) throws GeneralSecurityException {
        zzglq zzglq2 = zzglq.UNKNOWN_PREFIX;
        int ordinal = zzglq.ordinal();
        if (ordinal == 1) {
            return zzgac.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgac.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzglq.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzgac.zzb;
    }
}
