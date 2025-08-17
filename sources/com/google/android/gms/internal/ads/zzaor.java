package com.google.android.gms.internal.ads;

public final class zzaor extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzaor zzb;
    private int zzd;
    private zzgoe zze;
    private zzgoe zzf;
    private zzgoe zzg;
    private zzgoe zzh;

    static {
        zzaor zzaor = new zzaor();
        zzb = zzaor;
        zzgpm.zzaU(zzaor.class, zzaor);
    }

    private zzaor() {
        zzgoe zzgoe = zzgoe.zzb;
        this.zze = zzgoe;
        this.zzf = zzgoe;
        this.zzg = zzgoe;
        this.zzh = zzgoe;
    }

    public static zzaoq zza() {
        return (zzaoq) zzb.zzaA();
    }

    public static zzaor zzd(byte[] bArr, zzgoy zzgoy) throws zzgpy {
        return (zzaor) zzgpm.zzaI(zzb, bArr, zzgoy);
    }

    static /* synthetic */ void zzi(zzaor zzaor, zzgoe zzgoe) {
        zzaor.zzd |= 1;
        zzaor.zze = zzgoe;
    }

    static /* synthetic */ void zzj(zzaor zzaor, zzgoe zzgoe) {
        zzaor.zzd |= 2;
        zzaor.zzf = zzgoe;
    }

    static /* synthetic */ void zzk(zzaor zzaor, zzgoe zzgoe) {
        zzaor.zzd |= 4;
        zzaor.zzg = zzgoe;
    }

    static /* synthetic */ void zzl(zzaor zzaor, zzgoe zzgoe) {
        zzaor.zzd |= 8;
        zzaor.zzh = zzgoe;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i3 == 3) {
            return new zzaor();
        } else {
            if (i3 == 4) {
                return new zzaoq((zzanp) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgoe zze() {
        return this.zze;
    }

    public final zzgoe zzf() {
        return this.zzf;
    }

    public final zzgoe zzg() {
        return this.zzh;
    }

    public final zzgoe zzh() {
        return this.zzg;
    }
}
