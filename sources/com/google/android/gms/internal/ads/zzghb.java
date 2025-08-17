package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzghb {
    public static final /* synthetic */ int zza = 0;
    private static final zzgnk zzb;
    private static final zzgeo zzc;
    private static final zzgek zzd;
    private static final zzgdr zze;
    private static final zzgdn zzf;

    static {
        zzgnk zza2 = zzgfm.zza("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zza2;
        Class<zzgfb> cls = zzgfb.class;
        zzc = zzgeo.zzb(zzggx.zza, zzggw.class, cls);
        zzd = zzgek.zzb(zzggy.zza, zza2, cls);
        Class<zzgfa> cls2 = zzgfa.class;
        zze = zzgdr.zza(zzggz.zza, zzggm.class, cls2);
        zzf = zzgdn.zzb(zzgha.zza, zza2, cls2);
    }

    public static /* synthetic */ zzggm zza(zzgfa zzgfa, zzfyq zzfyq) {
        if (zzgfa.zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzgjz zzf2 = zzgjz.zzf(zzgfa.zze(), zzgoy.zza());
                if (zzf2.zza() == 0) {
                    zzggs zzggs = new zzggs((zzggr) null);
                    zzggs.zzb(zzf2.zzh().zzd());
                    zzggs.zzc(zzf2.zzg().zza());
                    zzggs.zza(zze(zzf2.zzg().zzg()));
                    zzggs.zzd(zzd(zzgfa.zzc()));
                    zzggw zze2 = zzggs.zze();
                    zzggk zzggk = new zzggk((zzggj) null);
                    zzggk.zzc(zze2);
                    zzggk.zzb(zzgnl.zzb(zzf2.zzh().zzA(), zzfyq));
                    zzggk.zza(zzgfa.zzf());
                    return zzggk.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgpy | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing HmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzggw zzb(zzgfb zzgfb) {
        if (zzgfb.zzb().zzh().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzgkc zzg = zzgkc.zzg(zzgfb.zzb().zzg(), zzgoy.zza());
                if (zzg.zzc() == 0) {
                    zzggs zzggs = new zzggs((zzggr) null);
                    zzggs.zzb(zzg.zza());
                    zzggs.zzc(zzg.zzh().zza());
                    zzggs.zza(zze(zzg.zzh().zzg()));
                    zzggs.zzd(zzd(zzgfb.zzb().zzf()));
                    return zzggs.zze();
                }
                int zzc2 = zzg.zzc();
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zzc2);
            } catch (zzgpy e2) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: ", e2);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgfb.zzb().zzh())));
        }
    }

    public static void zzc(zzgeg zzgeg) throws GeneralSecurityException {
        zzgeg.zzh(zzc);
        zzgeg.zzg(zzd);
        zzgeg.zzf(zze);
        zzgeg.zze(zzf);
    }

    private static zzggu zzd(zzglq zzglq) throws GeneralSecurityException {
        zzglq zzglq2 = zzglq.UNKNOWN_PREFIX;
        int ordinal = zzglq.ordinal();
        if (ordinal == 1) {
            return zzggu.zza;
        }
        if (ordinal == 2) {
            return zzggu.zzc;
        }
        if (ordinal == 3) {
            return zzggu.zzd;
        }
        if (ordinal == 4) {
            return zzggu.zzb;
        }
        int zza2 = zzglq.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }

    private static zzggt zze(int i2) throws GeneralSecurityException {
        zzglq zzglq = zzglq.UNKNOWN_PREFIX;
        int i3 = i2 - 2;
        if (i3 == 1) {
            return zzggt.zza;
        }
        if (i3 == 2) {
            return zzggt.zzd;
        }
        if (i3 == 3) {
            return zzggt.zzc;
        }
        if (i3 == 4) {
            return zzggt.zze;
        }
        if (i3 == 5) {
            return zzggt.zzb;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + zzgjw.zza(i2));
    }
}
