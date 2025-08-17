package com.google.android.gms.internal.cast;

public final class zznn extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zznn zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzsm zzg = zzsh.zzx();
    private zzsm zzh = zzsh.zzx();
    private zzsp zzi = zzsh.zzz();
    private zzsp zzj = zzsh.zzz();
    private int zzk;

    static {
        zznn zznn = new zznn();
        zzb = zznn;
        zzsh.zzG(zznn.class, zznn);
    }

    private zznn() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0004\u0000\u0001င\u0000\u0002ဌ\u0001\u0003\u0016\u0004\u0016\u0005\u001a\u0006\u001a\u0007ဌ\u0002", new Object[]{"zzd", "zze", "zzf", zziq.zza(), "zzg", "zzh", "zzi", "zzj", "zzk", zzie.zza()});
        } else if (i3 == 3) {
            return new zznn();
        } else {
            if (i3 == 4) {
                return new zznm((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
