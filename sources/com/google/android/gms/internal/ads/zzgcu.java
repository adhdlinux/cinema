package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzgcu {
    public static final /* synthetic */ int zza = 0;
    private static final zzgnk zzb;
    private static final zzgeo zzc;
    private static final zzgek zzd;
    private static final zzgdr zze;
    private static final zzgdn zzf;

    static {
        zzgnk zza2 = zzgfm.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzb = zza2;
        Class<zzgfb> cls = zzgfb.class;
        zzc = zzgeo.zzb(zzgcq.zza, zzgcp.class, cls);
        zzd = zzgek.zzb(zzgcr.zza, zza2, cls);
        Class<zzgfa> cls2 = zzgfa.class;
        zze = zzgdr.zza(zzgcs.zza, zzgck.class, cls2);
        zzf = zzgdn.zzb(zzgct.zza, zza2, cls2);
    }

    public static /* synthetic */ zzgck zza(zzgfa zzgfa, zzfyq zzfyq) {
        if (zzgfa.zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                zzglw zze2 = zzglw.zze(zzgfa.zze(), zzgoy.zza());
                if (zze2.zza() == 0) {
                    return zzgck.zza(zzd(zzgfa.zzc()), zzgnl.zzb(zze2.zzf().zzA(), zzfyq), zzgfa.zzf());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgpy unused) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305Parameters.parseParameters");
        }
    }

    public static /* synthetic */ zzgcp zzb(zzgfb zzgfb) {
        if (zzgfb.zzb().zzh().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                zzglz.zzd(zzgfb.zzb().zzg(), zzgoy.zza());
                return zzgcp.zzb(zzd(zzgfb.zzb().zzf()));
            } catch (zzgpy e2) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e2);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305Parameters.parseParameters: ".concat(String.valueOf(zzgfb.zzb().zzh())));
        }
    }

    public static void zzc(zzgeg zzgeg) throws GeneralSecurityException {
        zzgeg.zzh(zzc);
        zzgeg.zzg(zzd);
        zzgeg.zzf(zze);
        zzgeg.zze(zzf);
    }

    private static zzgco zzd(zzglq zzglq) throws GeneralSecurityException {
        zzglq zzglq2 = zzglq.UNKNOWN_PREFIX;
        int ordinal = zzglq.ordinal();
        if (ordinal == 1) {
            return zzgco.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgco.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzglq.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzgco.zzb;
    }
}
