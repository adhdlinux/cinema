package com.google.android.gms.internal.ads;

public final class zzgub extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgub zzb;
    private int zzd;
    private zzgua zze;
    private zzgpv zzf = zzgpm.zzaN();
    private zzgoe zzg;
    private zzgoe zzh;
    private int zzi;
    private byte zzj = 2;

    static {
        zzgub zzgub = new zzgub();
        zzb = zzgub;
        zzgpm.zzaU(zzgub.class, zzgub);
    }

    private zzgub() {
        zzgoe zzgoe = zzgoe.zzb;
        this.zzg = zzgoe;
        this.zzh = zzgoe;
    }

    public static zzgty zza() {
        return (zzgty) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzgub zzgub, zzgtx zzgtx) {
        zzgtx.getClass();
        zzgpv zzgpv = zzgub.zzf;
        if (!zzgpv.zzc()) {
            zzgub.zzf = zzgpm.zzaO(zzgpv);
        }
        zzgub.zzf.add(zzgtx);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.zzj);
        }
        byte b2 = 1;
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzd", "zze", "zzf", zzgtx.class, "zzg", "zzh", "zzi"});
        } else if (i3 == 3) {
            return new zzgub();
        } else {
            if (i3 == 4) {
                return new zzgty((zzgtb) null);
            }
            if (i3 == 5) {
                return zzb;
            }
            if (obj == null) {
                b2 = 0;
            }
            this.zzj = b2;
            return null;
        }
    }
}
