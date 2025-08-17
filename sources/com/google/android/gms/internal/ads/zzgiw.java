package com.google.android.gms.internal.ads;

public final class zzgiw extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgiw zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzgjc zze;
    /* access modifiers changed from: private */
    public zzgoe zzf = zzgoe.zzb;

    static {
        zzgiw zzgiw = new zzgiw();
        zzb = zzgiw;
        zzgpm.zzaU(zzgiw.class, zzgiw);
    }

    private zzgiw() {
    }

    public static zzgiv zzc() {
        return (zzgiv) zzb.zzaA();
    }

    public static zzgiw zze(zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        return (zzgiw) zzgpm.zzaG(zzb, zzgoe, zzgoy);
    }

    static /* synthetic */ void zzi(zzgiw zzgiw, zzgjc zzgjc) {
        zzgjc.getClass();
        zzgiw.zze = zzgjc;
    }

    public final int zza() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzd", "zze", "zzf"});
        } else if (i3 == 3) {
            return new zzgiw();
        } else {
            if (i3 == 4) {
                return new zzgiv((zzgiu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgjc zzf() {
        zzgjc zzgjc = this.zze;
        return zzgjc == null ? zzgjc.zze() : zzgjc;
    }

    public final zzgoe zzg() {
        return this.zzf;
    }
}
