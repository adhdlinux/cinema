package com.google.android.gms.internal.ads;

public final class zzguf extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzguf zzb;
    private int zzd;
    private zzgue zze;
    private zzgpv zzf = zzgpm.zzaN();
    private zzgoe zzg;
    private zzgoe zzh;
    private int zzi;
    private zzgoe zzj;
    private byte zzk = 2;

    static {
        zzguf zzguf = new zzguf();
        zzb = zzguf;
        zzgpm.zzaU(zzguf.class, zzguf);
    }

    private zzguf() {
        zzgoe zzgoe = zzgoe.zzb;
        this.zzg = zzgoe;
        this.zzh = zzgoe;
        this.zzj = zzgoe;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.zzk);
        }
        byte b2 = 1;
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzd", "zze", "zzf", zzgtx.class, "zzg", "zzh", "zzi", "zzj"});
        } else if (i3 == 3) {
            return new zzguf();
        } else {
            if (i3 == 4) {
                return new zzguc((zzgtb) null);
            }
            if (i3 == 5) {
                return zzb;
            }
            if (obj == null) {
                b2 = 0;
            }
            this.zzk = b2;
            return null;
        }
    }
}
