package com.google.android.gms.internal.ads;

public final class zzgkk extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgkk zzb;
    /* access modifiers changed from: private */
    public String zzd = "";
    /* access modifiers changed from: private */
    public zzgoe zze = zzgoe.zzb;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzgkk zzgkk = new zzgkk();
        zzb = zzgkk;
        zzgpm.zzaU(zzgkk.class, zzgkk);
    }

    private zzgkk() {
    }

    public static zzgkh zza() {
        return (zzgkh) zzb.zzaA();
    }

    public static zzgkk zze() {
        return zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        } else if (i3 == 3) {
            return new zzgkk();
        } else {
            if (i3 == 4) {
                return new zzgkh((zzgkg) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgkj zzc() {
        int i2 = this.zzf;
        zzgkj zzgkj = zzgkj.UNKNOWN_KEYMATERIAL;
        zzgkj zzgkj2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : zzgkj.REMOTE : zzgkj.ASYMMETRIC_PUBLIC : zzgkj.ASYMMETRIC_PRIVATE : zzgkj.SYMMETRIC : zzgkj.UNKNOWN_KEYMATERIAL;
        return zzgkj2 == null ? zzgkj.UNRECOGNIZED : zzgkj2;
    }

    public final zzgoe zzf() {
        return this.zze;
    }

    public final String zzg() {
        return this.zzd;
    }
}
