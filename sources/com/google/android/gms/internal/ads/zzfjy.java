package com.google.android.gms.internal.ads;

public final class zzfjy extends zzgpm implements zzgqx {
    private static final zzgps zzb = new zzfjv();
    /* access modifiers changed from: private */
    public static final zzfjy zzd;
    private int zze;
    private zzgpr zzf = zzgpm.zzaJ();
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzfjy zzfjy = new zzfjy();
        zzd = zzfjy;
        zzgpm.zzaU(zzfjy.class, zzfjy);
    }

    private zzfjy() {
    }

    public static zzfjx zza() {
        return (zzfjx) zzd.zzaA();
    }

    static /* synthetic */ void zzd(zzfjy zzfjy, String str) {
        str.getClass();
        zzfjy.zze |= 1;
        zzfjy.zzg = str;
    }

    static /* synthetic */ void zze(zzfjy zzfjy, int i2) {
        zzgpr zzgpr = zzfjy.zzf;
        if (!zzgpr.zzc()) {
            zzfjy.zzf = zzgpm.zzaK(zzgpr);
        }
        zzfjy.zzf.zzh(2);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzd, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ࠞ\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zze", "zzf", zzfjw.zza, "zzg", "zzh", "zzi"});
        } else if (i3 == 3) {
            return new zzfjy();
        } else {
            if (i3 == 4) {
                return new zzfjx((zzfjv) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzd;
        }
    }
}
