package com.google.android.gms.cast;

final class zzaj implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ CastRemoteDisplayLocalService zzb;

    zzaj(CastRemoteDisplayLocalService castRemoteDisplayLocalService, boolean z2) {
        this.zzb = castRemoteDisplayLocalService;
        this.zza = z2;
    }

    public final void run() {
        this.zzb.zzx(this.zza);
    }
}
