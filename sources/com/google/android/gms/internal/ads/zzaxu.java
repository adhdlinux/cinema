package com.google.android.gms.internal.ads;

public final class zzaxu extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzaxu zzb;
    private zzgpv zzd = zzgpm.zzaN();

    static {
        zzaxu zzaxu = new zzaxu();
        zzb = zzaxu;
        zzgpm.zzaU(zzaxu.class, zzaxu);
    }

    private zzaxu() {
    }

    public static zzaxo zza() {
        return (zzaxo) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzaxu zzaxu, zzaxn zzaxn) {
        zzaxn.getClass();
        zzgpv zzgpv = zzaxu.zzd;
        if (!zzgpv.zzc()) {
            zzaxu.zzd = zzgpm.zzaO(zzgpv);
        }
        zzaxu.zzd.add(zzaxn);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzaxn.class});
        } else if (i3 == 3) {
            return new zzaxu();
        } else {
            if (i3 == 4) {
                return new zzaxo((zzaxg) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
