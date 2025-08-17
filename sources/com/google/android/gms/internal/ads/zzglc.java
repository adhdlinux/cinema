package com.google.android.gms.internal.ads;

public final class zzglc extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzglc zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzgpv zze = zzgpm.zzaN();

    static {
        zzglc zzglc = new zzglc();
        zzb = zzglc;
        zzgpm.zzaU(zzglc.class, zzglc);
    }

    private zzglc() {
    }

    public static zzgkz zza() {
        return (zzgkz) zzb.zzaA();
    }

    static /* synthetic */ void zze(zzglc zzglc, zzglb zzglb) {
        zzglb.getClass();
        zzgpv zzgpv = zzglc.zze;
        if (!zzgpv.zzc()) {
            zzglc.zze = zzgpm.zzaO(zzgpv);
        }
        zzglc.zze.add(zzglb);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zzglb.class});
        } else if (i3 == 3) {
            return new zzglc();
        } else {
            if (i3 == 4) {
                return new zzgkz((zzgky) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
