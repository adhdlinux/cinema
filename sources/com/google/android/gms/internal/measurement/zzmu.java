package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

abstract class zzmu {
    final Unsafe zza;

    zzmu(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract double zza(Object obj, long j2);

    public abstract float zzb(Object obj, long j2);

    public abstract void zzc(Object obj, long j2, boolean z2);

    public abstract void zzd(Object obj, long j2, byte b2);

    public abstract void zze(Object obj, long j2, double d2);

    public abstract void zzf(Object obj, long j2, float f2);

    public abstract boolean zzg(Object obj, long j2);

    public final int zzh(Class cls) {
        return this.zza.arrayBaseOffset(cls);
    }

    public final int zzi(Class cls) {
        return this.zza.arrayIndexScale(cls);
    }

    public final int zzj(Object obj, long j2) {
        return this.zza.getInt(obj, j2);
    }

    public final long zzk(Object obj, long j2) {
        return this.zza.getLong(obj, j2);
    }

    public final long zzl(Field field) {
        return this.zza.objectFieldOffset(field);
    }

    public final Object zzm(Object obj, long j2) {
        return this.zza.getObject(obj, j2);
    }

    public final void zzn(Object obj, long j2, int i2) {
        this.zza.putInt(obj, j2, i2);
    }

    public final void zzo(Object obj, long j2, long j3) {
        this.zza.putLong(obj, j2, j3);
    }

    public final void zzp(Object obj, long j2, Object obj2) {
        this.zza.putObject(obj, j2, obj2);
    }
}
