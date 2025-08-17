package com.google.android.gms.internal.cast;

public final class zznx extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zznx zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zznx zznx = new zznx();
        zzb = zznx;
        zzsh.zzG(zznx.class, zznx);
    }

    private zznx() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002င\u0001", new Object[]{"zzd", "zze", zzib.zza(), "zzf"});
        } else if (i3 == 3) {
            return new zznx();
        } else {
            if (i3 == 4) {
                return new zznw((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
