package com.google.android.gms.internal.ads;

@Deprecated
public final class zzglt extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzglt zzb;
    private String zzd = "";
    private zzgpv zze = zzgpm.zzaN();

    static {
        zzglt zzglt = new zzglt();
        zzb = zzglt;
        zzgpm.zzaU(zzglt.class, zzglt);
    }

    private zzglt() {
    }

    public static zzglt zzc() {
        return zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zzgks.class});
        } else if (i3 == 3) {
            return new zzglt();
        } else {
            if (i3 == 4) {
                return new zzgls((zzglr) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
