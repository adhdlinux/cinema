package com.google.android.gms.internal.ads;

public final class zzguv extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzguv zzb;
    private int zzd;
    private String zze = "";
    private long zzf;
    private boolean zzg;
    private int zzh;
    private String zzi = "";
    private String zzj = "";

    static {
        zzguv zzguv = new zzguv();
        zzb = zzguv;
        zzgpm.zzaU(zzguv.class, zzguv);
    }

    private zzguv() {
    }

    public static zzguu zza() {
        return (zzguu) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzguv zzguv, String str) {
        zzguv.zzd |= 1;
        zzguv.zze = str;
    }

    static /* synthetic */ void zze(zzguv zzguv, long j2) {
        zzguv.zzd |= 2;
        zzguv.zzf = j2;
    }

    static /* synthetic */ void zzf(zzguv zzguv, boolean z2) {
        zzguv.zzd |= 4;
        zzguv.zzg = z2;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005ဈ\u0004\u0006ဈ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzguw.zza, "zzi", "zzj"});
        } else if (i3 == 3) {
            return new zzguv();
        } else {
            if (i3 == 4) {
                return new zzguu((zzgtb) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
