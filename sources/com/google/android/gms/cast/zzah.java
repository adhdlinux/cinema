package com.google.android.gms.cast;

final class zzah implements Runnable {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    zzah(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.zza = castRemoteDisplayLocalService;
    }

    public final void run() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService = this.zza;
        boolean zzs = castRemoteDisplayLocalService.zzs;
        castRemoteDisplayLocalService.zzv("onCreate after delay. The local service been started: " + zzs);
        CastRemoteDisplayLocalService castRemoteDisplayLocalService2 = this.zza;
        if (!castRemoteDisplayLocalService2.zzs) {
            CastRemoteDisplayLocalService.zza.e("[Instance: %s] %s", castRemoteDisplayLocalService2, "The local service has not been been started, stopping it");
            this.zza.stopSelf();
        }
    }
}
