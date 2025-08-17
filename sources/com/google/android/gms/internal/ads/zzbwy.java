package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.common.util.Clock;

public final class zzbwy {
    private final Clock zza;
    private final zzbww zzb;

    zzbwy(Clock clock, zzbww zzbww) {
        this.zza = clock;
        this.zzb = zzbww;
    }

    public static zzbwy zza(Context context) {
        return zzbxx.zzd(context).zzb();
    }

    public final void zzb(int i2, long j2) {
        this.zzb.zzb(i2, j2);
    }

    public final void zzc() {
        this.zzb.zza();
    }

    public final void zzd(zzff zzff) {
        this.zzb.zzb(-1, this.zza.currentTimeMillis());
    }

    public final void zze() {
        this.zzb.zzb(-1, this.zza.currentTimeMillis());
    }
}
