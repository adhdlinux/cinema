package com.google.android.gms.internal.ads;

public final class zzayh extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzayh zzb;
    private int zzd;
    private String zze = "";
    private zzazx zzf;
    private int zzg;
    private zzazz zzh;
    private int zzi;
    private int zzj = 1000;
    private int zzk = 1000;
    private int zzl = 1000;

    static {
        zzayh zzayh = new zzayh();
        zzb = zzayh;
        zzgpm.zzaU(zzayh.class, zzayh);
    }

    private zzayh() {
    }

    public static zzayh zzc() {
        return zzb;
    }

    static /* synthetic */ void zzd(zzayh zzayh, String str) {
        zzayh.zzd |= 1;
        zzayh.zze = str;
    }

    static /* synthetic */ void zze(zzayh zzayh, zzazz zzazz) {
        zzazz.getClass();
        zzayh.zzh = zzazz;
        zzayh.zzd |= 8;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            zzgpq zzgpq = zzaym.zza;
            return zzgpm.zzaR(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004ဉ\u0003\u0005င\u0004\u0006᠌\u0005\u0007᠌\u0006\b᠌\u0007", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzgpq, "zzk", zzgpq, "zzl", zzgpq});
        } else if (i3 == 3) {
            return new zzayh();
        } else {
            if (i3 == 4) {
                return new zzayg((zzaxg) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
