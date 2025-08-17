package com.google.android.gms.internal.ads;

public final class zzgkw extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgkw zzb;
    private zzgkk zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zzgkw zzgkw = new zzgkw();
        zzb = zzgkw;
        zzgpm.zzaU(zzgkw.class, zzgkw);
    }

    private zzgkw() {
    }

    public static zzgkv zzd() {
        return (zzgkv) zzb.zzaA();
    }

    static /* synthetic */ void zzg(zzgkw zzgkw, zzgkk zzgkk) {
        zzgkk.getClass();
        zzgkw.zzd = zzgkk;
    }

    public final int zza() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i3 == 3) {
            return new zzgkw();
        } else {
            if (i3 == 4) {
                return new zzgkv((zzgkt) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgkk zzc() {
        zzgkk zzgkk = this.zzd;
        return zzgkk == null ? zzgkk.zze() : zzgkk;
    }

    public final zzglq zzf() {
        zzglq zzb2 = zzglq.zzb(this.zzg);
        return zzb2 == null ? zzglq.UNRECOGNIZED : zzb2;
    }

    public final boolean zzj() {
        return this.zzd != null;
    }

    public final int zzk() {
        int i2 = this.zze;
        int i3 = 2;
        if (i2 != 0) {
            i3 = i2 != 1 ? i2 != 2 ? i2 != 3 ? 0 : 5 : 4 : 3;
        }
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }
}
