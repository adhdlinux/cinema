package com.google.android.gms.internal.ads;

public final class zzfkc extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzfkc zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private zzfjy zzh;

    static {
        zzfkc zzfkc = new zzfkc();
        zzb = zzfkc;
        zzgpm.zzaU(zzfkc.class, zzfkc);
    }

    private zzfkc() {
    }

    public static zzfka zza() {
        return (zzfka) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzfkc zzfkc, String str) {
        str.getClass();
        zzfkc.zzd |= 2;
        zzfkc.zzf = str;
    }

    static /* synthetic */ void zze(zzfkc zzfkc, zzfjy zzfjy) {
        zzfjy.getClass();
        zzfkc.zzh = zzfjy;
        zzfkc.zzd |= 8;
    }

    static /* synthetic */ void zzf(zzfkc zzfkc, int i2) {
        zzfkc.zze = 1;
        zzfkc.zzd = 1 | zzfkc.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzd", "zze", zzfkb.zza, "zzf", "zzg", "zzh"});
        } else if (i3 == 3) {
            return new zzfkc();
        } else {
            if (i3 == 4) {
                return new zzfka((zzfjz) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
