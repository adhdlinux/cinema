package com.google.android.gms.internal.ads;

public final class zzgtx extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgtx zzb;
    private int zzd;
    private zzgoe zze;
    private zzgoe zzf;
    private byte zzg = 2;

    static {
        zzgtx zzgtx = new zzgtx();
        zzb = zzgtx;
        zzgpm.zzaU(zzgtx.class, zzgtx);
    }

    private zzgtx() {
        zzgoe zzgoe = zzgoe.zzb;
        this.zze = zzgoe;
        this.zzf = zzgoe;
    }

    public static zzgtw zza() {
        return (zzgtw) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzgtx zzgtx, zzgoe zzgoe) {
        zzgtx.zzd |= 1;
        zzgtx.zze = zzgoe;
    }

    static /* synthetic */ void zze(zzgtx zzgtx, zzgoe zzgoe) {
        zzgtx.zzd |= 2;
        zzgtx.zzf = zzgoe;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.zzg);
        }
        byte b2 = 1;
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i3 == 3) {
            return new zzgtx();
        } else {
            if (i3 == 4) {
                return new zzgtw((zzgtb) null);
            }
            if (i3 == 5) {
                return zzb;
            }
            if (obj == null) {
                b2 = 0;
            }
            this.zzg = b2;
            return null;
        }
    }
}
