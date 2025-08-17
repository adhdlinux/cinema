package com.google.android.gms.internal.cast;

public final class zzpb extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzpb zzb;
    private int zzd;
    private String zze = "";
    private zzsp zzf = zzsh.zzz();
    private zzsp zzg = zzsh.zzz();
    private boolean zzh;

    static {
        zzpb zzpb = new zzpb();
        zzb = zzpb;
        zzsh.zzG(zzpb.class, zzpb);
    }

    private zzpb() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001", new Object[]{"zzd", "zze", "zzf", zznr.class, "zzg", zznc.class, "zzh"});
        } else if (i3 == 3) {
            return new zzpb();
        } else {
            if (i3 == 4) {
                return new zzpa((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
