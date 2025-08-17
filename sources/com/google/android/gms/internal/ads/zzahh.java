package com.google.android.gms.internal.ads;

import java.math.BigInteger;

final class zzahh implements zzabv {
    final /* synthetic */ zzahi zza;

    /* synthetic */ zzahh(zzahi zzahi, zzahg zzahg) {
        this.zza = zzahi;
    }

    public final long zze() {
        zzahi zzahi = this.zza;
        return zzahi.zzd.zzf(zzahi.zzf);
    }

    public final zzabt zzg(long j2) {
        zzahi zzahi = this.zza;
        long zzg = zzahi.zzd.zzg(j2);
        long zzb = zzahi.zzb;
        BigInteger valueOf = BigInteger.valueOf(zzg);
        zzahi zzahi2 = this.zza;
        long longValue = zzb + valueOf.multiply(BigInteger.valueOf(zzahi2.zzc - zzahi2.zzb)).divide(BigInteger.valueOf(this.zza.zzf)).longValue();
        zzahi zzahi3 = this.zza;
        zzabw zzabw = new zzabw(j2, Math.max(zzahi3.zzb, Math.min(longValue - 30000, zzahi3.zzc - 1)));
        return new zzabt(zzabw, zzabw);
    }

    public final boolean zzh() {
        return true;
    }
}
