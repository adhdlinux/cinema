package com.google.android.gms.internal.ads;

public final class zzgut extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgut zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private zzgub zzg;
    private zzguf zzh;
    private int zzi;
    private zzgpr zzj = zzgpm.zzaJ();
    private String zzk = "";
    private int zzl;
    private zzgpv zzm = zzgpm.zzaN();
    private byte zzn = 2;

    static {
        zzgut zzgut = new zzgut();
        zzb = zzgut;
        zzgpm.zzaU(zzgut.class, zzgut);
    }

    private zzgut() {
    }

    public static zzgus zzc() {
        return (zzgus) zzb.zzaA();
    }

    static /* synthetic */ void zzf(zzgut zzgut, int i2) {
        zzgut.zzd |= 1;
        zzgut.zze = i2;
    }

    static /* synthetic */ void zzg(zzgut zzgut, String str) {
        str.getClass();
        zzgut.zzd |= 2;
        zzgut.zzf = str;
    }

    static /* synthetic */ void zzh(zzgut zzgut, zzgub zzgub) {
        zzgub.getClass();
        zzgut.zzg = zzgub;
        zzgut.zzd |= 4;
    }

    static /* synthetic */ void zzi(zzgut zzgut, String str) {
        str.getClass();
        zzgpv zzgpv = zzgut.zzm;
        if (!zzgpv.zzc()) {
            zzgut.zzm = zzgpm.zzaO(zzgpv);
        }
        zzgut.zzm.add(str);
    }

    static /* synthetic */ void zzj(zzgut zzgut, int i2) {
        zzgut.zzl = i2 - 1;
        zzgut.zzd |= 64;
    }

    public final int zza() {
        return this.zzm.size();
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.zzn);
        }
        byte b2 = 1;
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\b᠌\u0006\t\u001a", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzguq.zza, "zzm"});
        } else if (i3 == 3) {
            return new zzgut();
        } else {
            if (i3 == 4) {
                return new zzgus((zzgtb) null);
            }
            if (i3 == 5) {
                return zzb;
            }
            if (obj == null) {
                b2 = 0;
            }
            this.zzn = b2;
            return null;
        }
    }

    public final String zze() {
        return this.zzf;
    }
}
