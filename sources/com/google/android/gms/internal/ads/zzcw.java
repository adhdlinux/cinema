package com.google.android.gms.internal.ads;

import android.util.Pair;

public abstract class zzcw {
    public static final zzcw zza = new zzcr();
    public static final zzn zzb = zzcq.zza;
    private static final String zzc = Integer.toString(0, 36);
    private static final String zzd = Integer.toString(1, 36);
    private static final String zze = Integer.toString(2, 36);

    protected zzcw() {
    }

    public final boolean equals(Object obj) {
        int zzh;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcw)) {
            return false;
        }
        zzcw zzcw = (zzcw) obj;
        if (zzcw.zzc() == zzc() && zzcw.zzb() == zzb()) {
            zzcv zzcv = new zzcv();
            zzct zzct = new zzct();
            zzcv zzcv2 = new zzcv();
            zzct zzct2 = new zzct();
            for (int i2 = 0; i2 < zzc(); i2++) {
                if (!zze(i2, zzcv, 0).equals(zzcw.zze(i2, zzcv2, 0))) {
                    return false;
                }
            }
            for (int i3 = 0; i3 < zzb(); i3++) {
                if (!zzd(i3, zzct, true).equals(zzcw.zzd(i3, zzct2, true))) {
                    return false;
                }
            }
            int zzg = zzg(true);
            if (zzg == zzcw.zzg(true) && (zzh = zzh(true)) == zzcw.zzh(true)) {
                while (zzg != zzh) {
                    int zzj = zzj(zzg, 0, true);
                    if (zzj != zzcw.zzj(zzg, 0, true)) {
                        return false;
                    }
                    zzg = zzj;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        zzcv zzcv = new zzcv();
        zzct zzct = new zzct();
        int zzc2 = zzc() + 217;
        for (int i2 = 0; i2 < zzc(); i2++) {
            zzc2 = (zzc2 * 31) + zze(i2, zzcv, 0).hashCode();
        }
        int zzb2 = (zzc2 * 31) + zzb();
        for (int i3 = 0; i3 < zzb(); i3++) {
            zzb2 = (zzb2 * 31) + zzd(i3, zzct, true).hashCode();
        }
        int zzg = zzg(true);
        while (zzg != -1) {
            zzb2 = (zzb2 * 31) + zzg;
            zzg = zzj(zzg, 0, true);
        }
        return zzb2;
    }

    public abstract int zza(Object obj);

    public abstract int zzb();

    public abstract int zzc();

    public abstract zzct zzd(int i2, zzct zzct, boolean z2);

    public abstract zzcv zze(int i2, zzcv zzcv, long j2);

    public abstract Object zzf(int i2);

    public int zzg(boolean z2) {
        return zzo() ? -1 : 0;
    }

    public int zzh(boolean z2) {
        if (zzo()) {
            return -1;
        }
        return zzc() - 1;
    }

    public final int zzi(int i2, zzct zzct, zzcv zzcv, int i3, boolean z2) {
        int i4 = zzd(i2, zzct, false).zzd;
        if (zze(i4, zzcv, 0).zzp != i2) {
            return i2 + 1;
        }
        int zzj = zzj(i4, i3, z2);
        if (zzj == -1) {
            return -1;
        }
        return zze(zzj, zzcv, 0).zzo;
    }

    public int zzj(int i2, int i3, boolean z2) {
        if (i3 != 0) {
            if (i3 == 1) {
                return i2;
            }
            if (i3 != 2) {
                throw new IllegalStateException();
            } else if (i2 == zzh(z2)) {
                return zzg(z2);
            } else {
                return i2 + 1;
            }
        } else if (i2 == zzh(z2)) {
            return -1;
        } else {
            return i2 + 1;
        }
    }

    public int zzk(int i2, int i3, boolean z2) {
        if (i2 == zzg(false)) {
            return -1;
        }
        return i2 - 1;
    }

    public final Pair zzl(zzcv zzcv, zzct zzct, int i2, long j2) {
        Pair zzm = zzm(zzcv, zzct, i2, j2, 0);
        zzm.getClass();
        return zzm;
    }

    public final Pair zzm(zzcv zzcv, zzct zzct, int i2, long j2, long j3) {
        zzdy.zza(i2, 0, zzc());
        zze(i2, zzcv, j3);
        if (j2 == -9223372036854775807L) {
            long j4 = zzcv.zzm;
            j2 = 0;
        }
        int i3 = zzcv.zzo;
        zzd(i3, zzct, false);
        while (i3 < zzcv.zzp) {
            long j5 = zzct.zzf;
            int i4 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i4 == 0) {
                break;
            }
            int i5 = i3 + 1;
            long j6 = zzd(i5, zzct, false).zzf;
            if (i4 < 0) {
                break;
            }
            i3 = i5;
        }
        zzd(i3, zzct, true);
        long j7 = zzct.zzf;
        long j8 = zzct.zze;
        if (j8 != -9223372036854775807L) {
            j2 = Math.min(j2, j8 - 1);
        }
        long max = Math.max(0, j2);
        Object obj = zzct.zzc;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(max));
    }

    public zzct zzn(Object obj, zzct zzct) {
        return zzd(zza(obj), zzct, true);
    }

    public final boolean zzo() {
        return zzc() == 0;
    }
}
