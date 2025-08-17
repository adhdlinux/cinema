package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzgge {
    public static final /* synthetic */ int zza = 0;
    private static final zzgnk zzb;
    private static final zzgeo zzc;
    private static final zzgek zzd;
    private static final zzgdr zze;
    private static final zzgdn zzf;

    static {
        zzgnk zza2 = zzgfm.zza("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zza2;
        Class<zzgfb> cls = zzgfb.class;
        zzc = zzgeo.zzb(zzgga.zza, zzgfz.class, cls);
        zzd = zzgek.zzb(zzggb.zza, zza2, cls);
        Class<zzgfa> cls2 = zzgfa.class;
        zze = zzgdr.zza(zzggc.zza, zzgfq.class, cls2);
        zzf = zzgdn.zzb(zzggd.zza, zza2, cls2);
    }

    public static /* synthetic */ zzgfq zza(zzgfa zzgfa, zzfyq zzfyq) {
        if (zzgfa.zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzghy zze2 = zzghy.zze(zzgfa.zze(), zzgoy.zza());
                if (zze2.zza() == 0) {
                    zzgfw zzgfw = new zzgfw((zzgfv) null);
                    zzgfw.zza(zze2.zzg().zzd());
                    zzgfw.zzb(zze2.zzf().zza());
                    zzgfw.zzc(zzd(zzgfa.zzc()));
                    zzgfz zzd2 = zzgfw.zzd();
                    zzgfo zzgfo = new zzgfo((zzgfn) null);
                    zzgfo.zzc(zzd2);
                    zzgfo.zza(zzgnl.zzb(zze2.zzg().zzA(), zzfyq));
                    zzgfo.zzb(zzgfa.zzf());
                    return zzgfo.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgpy | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing AesCmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters");
        }
    }

    public static /* synthetic */ zzgfz zzb(zzgfb zzgfb) {
        if (zzgfb.zzb().zzh().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzgib zze2 = zzgib.zze(zzgfb.zzb().zzg(), zzgoy.zza());
                zzgfw zzgfw = new zzgfw((zzgfv) null);
                zzgfw.zza(zze2.zza());
                zzgfw.zzb(zze2.zzf().zza());
                zzgfw.zzc(zzd(zzgfb.zzb().zzf()));
                return zzgfw.zzd();
            } catch (zzgpy e2) {
                throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e2);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters: ".concat(String.valueOf(zzgfb.zzb().zzh())));
        }
    }

    public static void zzc(zzgeg zzgeg) throws GeneralSecurityException {
        zzgeg.zzh(zzc);
        zzgeg.zzg(zzd);
        zzgeg.zzf(zze);
        zzgeg.zze(zzf);
    }

    private static zzgfx zzd(zzglq zzglq) throws GeneralSecurityException {
        zzglq zzglq2 = zzglq.UNKNOWN_PREFIX;
        int ordinal = zzglq.ordinal();
        if (ordinal == 1) {
            return zzgfx.zza;
        }
        if (ordinal == 2) {
            return zzgfx.zzc;
        }
        if (ordinal == 3) {
            return zzgfx.zzd;
        }
        if (ordinal == 4) {
            return zzgfx.zzb;
        }
        int zza2 = zzglq.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }
}
