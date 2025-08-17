package com.google.android.gms.internal.cast;

public final class zzpn extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzpn zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzsp zzg = zzsh.zzz();
    private zzsp zzh = zzsh.zzz();
    private int zzi;

    static {
        zzpn zzpn = new zzpn();
        zzb = zzpn;
        zzsh.zzG(zzpn.class, zzpn);
    }

    private zzpn() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            Class<zznc> cls = zznc.class;
            return zzsh.zzD(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003\u001b\u0004\u001b\u0005ဌ\u0002", new Object[]{"zzd", "zze", zzlb.zza(), "zzf", zzle.zza(), "zzg", cls, "zzh", cls, "zzi", zzie.zza()});
        } else if (i3 == 3) {
            return new zzpn();
        } else {
            if (i3 == 4) {
                return new zzpm((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
