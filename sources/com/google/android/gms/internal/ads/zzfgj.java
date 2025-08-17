package com.google.android.gms.internal.ads;

public final class zzfgj extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzfgj zzb;
    /* access modifiers changed from: private */
    public zzgpv zzd = zzgpm.zzaN();

    static {
        zzfgj zzfgj = new zzfgj();
        zzb = zzfgj;
        zzgpm.zzaU(zzfgj.class, zzfgj);
    }

    private zzfgj() {
    }

    public static zzfgg zzc() {
        return (zzfgg) zzb.zzaA();
    }

    static /* synthetic */ void zzf(zzfgj zzfgj, zzfgi zzfgi) {
        zzfgi.getClass();
        zzgpv zzgpv = zzfgj.zzd;
        if (!zzgpv.zzc()) {
            zzfgj.zzd = zzgpm.zzaO(zzgpv);
        }
        zzfgj.zzd.add(zzfgi);
    }

    public final int zza() {
        return this.zzd.size();
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzfgi.class});
        } else if (i3 == 3) {
            return new zzfgj();
        } else {
            if (i3 == 4) {
                return new zzfgg((zzfgf) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
