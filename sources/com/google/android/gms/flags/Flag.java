package com.google.android.gms.flags;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@Deprecated
public abstract class Flag<T> {
    private final int zza;
    private final String zzb;
    private final T zzc;

    @Deprecated
    public static class BooleanFlag extends Flag<Boolean> {
        public BooleanFlag(int i2, String str, Boolean bool) {
            super(i2, str, bool, (zza) null);
        }

        public final /* bridge */ /* synthetic */ Object zza(zze zze) {
            try {
                return Boolean.valueOf(zze.getBooleanFlagValue(zzd(), ((Boolean) zzc()).booleanValue(), zzb()));
            } catch (RemoteException unused) {
                return (Boolean) zzc();
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public static class IntegerFlag extends Flag<Integer> {
        public IntegerFlag(int i2, String str, Integer num) {
            super(i2, str, num, (zza) null);
        }

        public final /* bridge */ /* synthetic */ Object zza(zze zze) {
            try {
                return Integer.valueOf(zze.getIntFlagValue(zzd(), ((Integer) zzc()).intValue(), zzb()));
            } catch (RemoteException unused) {
                return (Integer) zzc();
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public static class LongFlag extends Flag<Long> {
        public LongFlag(int i2, String str, Long l2) {
            super(i2, str, l2, (zza) null);
        }

        public final /* bridge */ /* synthetic */ Object zza(zze zze) {
            try {
                return Long.valueOf(zze.getLongFlagValue(zzd(), ((Long) zzc()).longValue(), zzb()));
            } catch (RemoteException unused) {
                return (Long) zzc();
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public static class StringFlag extends Flag<String> {
        public StringFlag(int i2, String str, String str2) {
            super(i2, str, str2, (zza) null);
        }

        public final /* bridge */ /* synthetic */ Object zza(zze zze) {
            try {
                return zze.getStringFlagValue(zzd(), (String) zzc(), zzb());
            } catch (RemoteException unused) {
                return (String) zzc();
            }
        }
    }

    /* synthetic */ Flag(int i2, String str, Object obj, zza zza2) {
        this.zza = i2;
        this.zzb = str;
        this.zzc = obj;
        Singletons.flagRegistry().zza(this);
    }

    @KeepForSdk
    @Deprecated
    public static IntegerFlag define(int i2, String str, int i3) {
        return new IntegerFlag(i2, str, Integer.valueOf(i3));
    }

    @KeepForSdk
    public T get() {
        return Singletons.zza().zza(this);
    }

    /* access modifiers changed from: protected */
    public abstract T zza(zze zze);

    @Deprecated
    public final int zzb() {
        return this.zza;
    }

    public final T zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }

    @KeepForSdk
    @Deprecated
    public static LongFlag define(int i2, String str, long j2) {
        return new LongFlag(i2, str, Long.valueOf(j2));
    }

    @KeepForSdk
    @Deprecated
    public static BooleanFlag define(int i2, String str, Boolean bool) {
        return new BooleanFlag(i2, str, bool);
    }

    @KeepForSdk
    @Deprecated
    public static StringFlag define(int i2, String str, String str2) {
        return new StringFlag(i2, str, str2);
    }
}
