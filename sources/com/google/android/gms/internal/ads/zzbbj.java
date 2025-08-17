package com.google.android.gms.internal.ads;

final class zzbbj implements zzbdu {
    final /* synthetic */ zzbbk zza;

    zzbbj(zzbbk zzbbk) {
        this.zza = zzbbk;
    }

    public final Boolean zza(String str, boolean z2) {
        try {
            return Boolean.valueOf(this.zza.zze.getBoolean(str, z2));
        } catch (ClassCastException unused) {
            return Boolean.valueOf(this.zza.zze.getString(str, String.valueOf(z2)));
        }
    }

    public final Double zzb(String str, double d2) {
        try {
            return Double.valueOf((double) this.zza.zze.getFloat(str, (float) d2));
        } catch (ClassCastException unused) {
            return Double.valueOf(this.zza.zze.getString(str, String.valueOf(d2)));
        }
    }

    public final Long zzc(String str, long j2) {
        try {
            return Long.valueOf(this.zza.zze.getLong(str, j2));
        } catch (ClassCastException unused) {
            return Long.valueOf((long) this.zza.zze.getInt(str, (int) j2));
        }
    }

    public final String zzd(String str, String str2) {
        return this.zza.zze.getString(str, str2);
    }
}
