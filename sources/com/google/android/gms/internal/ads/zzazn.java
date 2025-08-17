package com.google.android.gms.internal.ads;

public final class zzazn extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzazn zzb;
    private int zzd;
    private zzgpv zze = zzgpm.zzaN();
    private int zzf;
    private int zzg;
    private long zzh;
    private String zzi = "";
    private String zzj = "";
    private long zzk;
    private int zzl;

    static {
        zzazn zzazn = new zzazn();
        zzb = zzazn;
        zzgpm.zzaU(zzazn.class, zzazn);
    }

    private zzazn() {
    }

    public static zzazj zza() {
        return (zzazj) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzazn zzazn, Iterable iterable) {
        zzgpv zzgpv = zzazn.zze;
        if (!zzgpv.zzc()) {
            zzazn.zze = zzgpm.zzaO(zzgpv);
        }
        zzgnn.zzav(iterable, zzazn.zze);
    }

    static /* synthetic */ void zze(zzazn zzazn, int i2) {
        zzazn.zzd |= 1;
        zzazn.zzf = i2;
    }

    static /* synthetic */ void zzf(zzazn zzazn, int i2) {
        zzazn.zzd |= 2;
        zzazn.zzg = i2;
    }

    static /* synthetic */ void zzg(zzazn zzazn, long j2) {
        zzazn.zzd |= 4;
        zzazn.zzh = j2;
    }

    static /* synthetic */ void zzh(zzazn zzazn, String str) {
        str.getClass();
        zzazn.zzd |= 8;
        zzazn.zzi = str;
    }

    static /* synthetic */ void zzi(zzazn zzazn, String str) {
        str.getClass();
        zzazn.zzd |= 16;
        zzazn.zzj = str;
    }

    static /* synthetic */ void zzj(zzazn zzazn, long j2) {
        zzazn.zzd |= 32;
        zzazn.zzk = j2;
    }

    static /* synthetic */ void zzk(zzazn zzazn, int i2) {
        zzazn.zzd |= 64;
        zzazn.zzl = i2;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u001b\u0002င\u0000\u0003င\u0001\u0004ဂ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဂ\u0005\bင\u0006", new Object[]{"zzd", "zze", zzazi.class, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        } else if (i3 == 3) {
            return new zzazn();
        } else {
            if (i3 == 4) {
                return new zzazj((zzaxg) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
