package com.google.android.gms.internal.ads;

import android.util.Pair;

public abstract class zzhq extends zzcw {
    private final int zzc;
    private final zzvi zzd;

    public zzhq(boolean z2, zzvi zzvi) {
        this.zzd = zzvi;
        this.zzc = zzvi.zzc();
    }

    private final int zzw(int i2, boolean z2) {
        if (z2) {
            return this.zzd.zzd(i2);
        }
        if (i2 >= this.zzc - 1) {
            return -1;
        }
        return i2 + 1;
    }

    private final int zzx(int i2, boolean z2) {
        if (z2) {
            return this.zzd.zze(i2);
        }
        if (i2 <= 0) {
            return -1;
        }
        return i2 - 1;
    }

    public final int zza(Object obj) {
        int zza;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int zzp = zzp(obj2);
        if (zzp == -1 || (zza = zzu(zzp).zza(obj3)) == -1) {
            return -1;
        }
        return zzs(zzp) + zza;
    }

    public final zzct zzd(int i2, zzct zzct, boolean z2) {
        int zzq = zzq(i2);
        int zzt = zzt(zzq);
        zzu(zzq).zzd(i2 - zzs(zzq), zzct, z2);
        zzct.zzd += zzt;
        if (z2) {
            Object zzv = zzv(zzq);
            Object obj = zzct.zzc;
            obj.getClass();
            zzct.zzc = Pair.create(zzv, obj);
        }
        return zzct;
    }

    public final zzcv zze(int i2, zzcv zzcv, long j2) {
        int zzr = zzr(i2);
        int zzt = zzt(zzr);
        int zzs = zzs(zzr);
        zzu(zzr).zze(i2 - zzt, zzcv, j2);
        Object zzv = zzv(zzr);
        if (!zzcv.zza.equals(zzcv.zzc)) {
            zzv = Pair.create(zzv, zzcv.zzc);
        }
        zzcv.zzc = zzv;
        zzcv.zzo += zzs;
        zzcv.zzp += zzs;
        return zzcv;
    }

    public final Object zzf(int i2) {
        int zzq = zzq(i2);
        return Pair.create(zzv(zzq), zzu(zzq).zzf(i2 - zzs(zzq)));
    }

    public final int zzg(boolean z2) {
        int i2;
        if (this.zzc == 0) {
            return -1;
        }
        if (z2) {
            i2 = this.zzd.zza();
        } else {
            i2 = 0;
        }
        while (zzu(i2).zzo()) {
            i2 = zzw(i2, z2);
            if (i2 == -1) {
                return -1;
            }
        }
        return zzt(i2) + zzu(i2).zzg(z2);
    }

    public final int zzh(boolean z2) {
        int i2;
        int i3 = this.zzc;
        if (i3 == 0) {
            return -1;
        }
        if (z2) {
            i2 = this.zzd.zzb();
        } else {
            i2 = i3 - 1;
        }
        while (zzu(i2).zzo()) {
            i2 = zzx(i2, z2);
            if (i2 == -1) {
                return -1;
            }
        }
        return zzt(i2) + zzu(i2).zzh(z2);
    }

    public final int zzj(int i2, int i3, boolean z2) {
        int i4;
        int zzr = zzr(i2);
        int zzt = zzt(zzr);
        zzcw zzu = zzu(zzr);
        int i5 = i2 - zzt;
        if (i3 == 2) {
            i4 = 0;
        } else {
            i4 = i3;
        }
        int zzj = zzu.zzj(i5, i4, z2);
        if (zzj != -1) {
            return zzt + zzj;
        }
        int zzw = zzw(zzr, z2);
        while (zzw != -1 && zzu(zzw).zzo()) {
            zzw = zzw(zzw, z2);
        }
        if (zzw != -1) {
            return zzt(zzw) + zzu(zzw).zzg(z2);
        }
        if (i3 == 2) {
            return zzg(z2);
        }
        return -1;
    }

    public final int zzk(int i2, int i3, boolean z2) {
        int zzr = zzr(i2);
        int zzt = zzt(zzr);
        int zzk = zzu(zzr).zzk(i2 - zzt, 0, false);
        if (zzk != -1) {
            return zzt + zzk;
        }
        int zzx = zzx(zzr, false);
        while (zzx != -1 && zzu(zzx).zzo()) {
            zzx = zzx(zzx, false);
        }
        if (zzx != -1) {
            return zzt(zzx) + zzu(zzx).zzh(false);
        }
        return -1;
    }

    public final zzct zzn(Object obj, zzct zzct) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int zzp = zzp(obj2);
        int zzt = zzt(zzp);
        zzu(zzp).zzn(obj3, zzct);
        zzct.zzd += zzt;
        zzct.zzc = obj;
        return zzct;
    }

    /* access modifiers changed from: protected */
    public abstract int zzp(Object obj);

    /* access modifiers changed from: protected */
    public abstract int zzq(int i2);

    /* access modifiers changed from: protected */
    public abstract int zzr(int i2);

    /* access modifiers changed from: protected */
    public abstract int zzs(int i2);

    /* access modifiers changed from: protected */
    public abstract int zzt(int i2);

    /* access modifiers changed from: protected */
    public abstract zzcw zzu(int i2);

    /* access modifiers changed from: protected */
    public abstract Object zzv(int i2);
}
