package com.google.android.gms.internal.ads;

final class zzbwm implements zzfvy {
    final /* synthetic */ zzfwm zza;

    zzbwm(zzbwn zzbwn, zzfwm zzfwm) {
        this.zza = zzfwm;
    }

    public final void zza(Throwable th) {
        zzbwn.zzc.remove(this.zza);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Void voidR = (Void) obj;
        zzbwn.zzc.remove(this.zza);
    }
}
