package com.google.android.gms.internal.cast;

public final class zzob extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzob zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzob zzob = new zzob();
        zzb = zzob;
        zzsh.zzG(zzob.class, zzob);
    }

    private zzob() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i3 == 3) {
            return new zzob();
        } else {
            if (i3 == 4) {
                return new zzoa((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
