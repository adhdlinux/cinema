package com.google.android.gms.internal.ads;

public final class zzgkp extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgkp zzb;
    /* access modifiers changed from: private */
    public String zzd = "";
    /* access modifiers changed from: private */
    public zzgoe zze = zzgoe.zzb;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzgkp zzgkp = new zzgkp();
        zzb = zzgkp;
        zzgpm.zzaU(zzgkp.class, zzgkp);
    }

    private zzgkp() {
    }

    public static zzgko zza() {
        return (zzgko) zzb.zzaA();
    }

    public static zzgkp zzd() {
        return zzb;
    }

    public static zzgkp zze(byte[] bArr, zzgoy zzgoy) throws zzgpy {
        return (zzgkp) zzgpm.zzaI(zzb, bArr, zzgoy);
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
            return new zzgkp();
        } else {
            if (i3 == 4) {
                return new zzgko((zzgkn) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzglq zzf() {
        zzglq zzb2 = zzglq.zzb(this.zzf);
        return zzb2 == null ? zzglq.UNRECOGNIZED : zzb2;
    }

    public final zzgoe zzg() {
        return this.zze;
    }

    public final String zzh() {
        return this.zzd;
    }
}
