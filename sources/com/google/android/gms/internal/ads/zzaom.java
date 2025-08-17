package com.google.android.gms.internal.ads;

public final class zzaom extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzaom zzb;
    private int zzd;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;
    private long zzl = -1;

    static {
        zzaom zzaom = new zzaom();
        zzb = zzaom;
        zzgpm.zzaU(zzaom.class, zzaom);
    }

    private zzaom() {
    }

    public static zzaol zza() {
        return (zzaol) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzaom zzaom, long j2) {
        zzaom.zzd |= 1;
        zzaom.zze = j2;
    }

    static /* synthetic */ void zze(zzaom zzaom, long j2) {
        zzaom.zzd |= 4;
        zzaom.zzg = j2;
    }

    static /* synthetic */ void zzf(zzaom zzaom, long j2) {
        zzaom.zzd |= 8;
        zzaom.zzh = j2;
    }

    static /* synthetic */ void zzg(zzaom zzaom, long j2) {
        zzaom.zzd |= 16;
        zzaom.zzi = j2;
    }

    static /* synthetic */ void zzh(zzaom zzaom, long j2) {
        zzaom.zzd |= 32;
        zzaom.zzj = j2;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        } else if (i3 == 3) {
            return new zzaom();
        } else {
            if (i3 == 4) {
                return new zzaol((zzanp) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
