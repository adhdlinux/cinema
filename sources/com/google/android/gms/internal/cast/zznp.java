package com.google.android.gms.internal.cast;

public final class zznp extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zznp zzb;
    private int zzd;
    private int zze;

    static {
        zznp zznp = new zznp();
        zzb = zznp;
        zzsh.zzG(zznp.class, zznp);
    }

    private zznp() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzd", "zze", zziq.zza()});
        } else if (i3 == 3) {
            return new zznp();
        } else {
            if (i3 == 4) {
                return new zzno((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
