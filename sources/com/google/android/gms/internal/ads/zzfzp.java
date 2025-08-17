package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzfzp {
    public static final /* synthetic */ int zza = 0;
    private static final zzgnk zzb;
    private static final zzgeo zzc;
    private static final zzgek zzd;
    private static final zzgdr zze;
    private static final zzgdn zzf;

    static {
        zzgnk zza2 = zzgfm.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzb = zza2;
        Class<zzgfb> cls = zzgfb.class;
        zzc = zzgeo.zzb(zzfzl.zza, zzfzk.class, cls);
        zzd = zzgek.zzb(zzfzm.zza, zza2, cls);
        Class<zzgfa> cls2 = zzgfa.class;
        zze = zzgdr.zza(zzfzn.zza, zzfzb.class, cls2);
        zzf = zzgdn.zzb(zzfzo.zza, zza2, cls2);
    }

    public static /* synthetic */ zzfzb zza(zzgfa zzgfa, zzfyq zzfyq) {
        if (zzgfa.zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzgih zze2 = zzgih.zze(zzgfa.zze(), zzgoy.zza());
                if (zze2.zza() == 0) {
                    zzfzg zzfzg = new zzfzg((zzfzf) null);
                    zzfzg.zza(zze2.zzf().zzh().zzd());
                    zzfzg.zzc(zze2.zzg().zzh().zzd());
                    zzfzg.zzd(zze2.zzf().zzg().zza());
                    zzfzg.zze(zze2.zzg().zzg().zza());
                    zzfzg.zzb(zze(zze2.zzg().zzg().zzg()));
                    zzfzg.zzf(zzd(zzgfa.zzc()));
                    zzfzk zzg = zzfzg.zzg();
                    zzfyz zzfyz = new zzfyz((zzfyy) null);
                    zzfyz.zzd(zzg);
                    zzfyz.zza(zzgnl.zzb(zze2.zzf().zzh().zzA(), zzfyq));
                    zzfyz.zzb(zzgnl.zzb(zze2.zzg().zzh().zzA(), zzfyq));
                    zzfyz.zzc(zzgfa.zzf());
                    return zzfyz.zze();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgpy unused) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzfzk zzb(zzgfb zzgfb) {
        if (zzgfb.zzb().zzh().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzgik zzd2 = zzgik.zzd(zzgfb.zzb().zzg(), zzgoy.zza());
                zzfzg zzfzg = new zzfzg((zzfzf) null);
                zzfzg.zza(zzd2.zze().zza());
                zzfzg.zzc(zzd2.zzf().zza());
                zzfzg.zzd(zzd2.zze().zzg().zza());
                zzfzg.zze(zzd2.zzf().zzh().zza());
                zzfzg.zzb(zze(zzd2.zzf().zzh().zzg()));
                zzfzg.zzf(zzd(zzgfb.zzb().zzf()));
                return zzfzg.zzg();
            } catch (zzgpy e2) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e2);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgfb.zzb().zzh())));
        }
    }

    public static void zzc(zzgeg zzgeg) throws GeneralSecurityException {
        zzgeg.zzh(zzc);
        zzgeg.zzg(zzd);
        zzgeg.zzf(zze);
        zzgeg.zze(zzf);
    }

    private static zzfzi zzd(zzglq zzglq) throws GeneralSecurityException {
        zzglq zzglq2 = zzglq.UNKNOWN_PREFIX;
        int ordinal = zzglq.ordinal();
        if (ordinal == 1) {
            return zzfzi.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzfzi.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzglq.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzfzi.zzb;
    }

    private static zzfzh zze(int i2) throws GeneralSecurityException {
        zzglq zzglq = zzglq.UNKNOWN_PREFIX;
        int i3 = i2 - 2;
        if (i3 == 1) {
            return zzfzh.zza;
        }
        if (i3 == 2) {
            return zzfzh.zzd;
        }
        if (i3 == 3) {
            return zzfzh.zzc;
        }
        if (i3 == 4) {
            return zzfzh.zze;
        }
        if (i3 == 5) {
            return zzfzh.zzb;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + zzgjw.zza(i2));
    }
}
