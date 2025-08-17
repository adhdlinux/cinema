package com.google.android.gms.internal.ads;

public final class zzayd extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzayd zzb;
    private int zzd;
    private String zze = "";
    private zzgpv zzf = zzgpm.zzaN();
    private int zzg = 1000;
    private int zzh = 1000;
    private int zzi = 1000;

    static {
        zzayd zzayd = new zzayd();
        zzb = zzayd;
        zzgpm.zzaU(zzayd.class, zzayd);
    }

    private zzayd() {
    }

    public static zzayd zzc() {
        return zzb;
    }

    static /* synthetic */ void zzd(zzayd zzayd, String str) {
        str.getClass();
        zzayd.zzd |= 1;
        zzayd.zze = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            zzgpq zzgpq = zzaym.zza;
            return zzgpm.zzaR(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003᠌\u0001\u0004᠌\u0002\u0005᠌\u0003", new Object[]{"zzd", "zze", "zzf", zzaxz.class, "zzg", zzgpq, "zzh", zzgpq, "zzi", zzgpq});
        } else if (i3 == 3) {
            return new zzayd();
        } else {
            if (i3 == 4) {
                return new zzayc((zzaxg) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
