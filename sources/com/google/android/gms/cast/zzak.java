package com.google.android.gms.cast;

import com.google.android.gms.cast.CastRemoteDisplayLocalService;

final class zzak implements Runnable {
    final /* synthetic */ CastRemoteDisplayLocalService.NotificationSettings zza;
    final /* synthetic */ CastRemoteDisplayLocalService zzb;

    zzak(CastRemoteDisplayLocalService castRemoteDisplayLocalService, CastRemoteDisplayLocalService.NotificationSettings notificationSettings) {
        this.zzb = castRemoteDisplayLocalService;
        this.zza = notificationSettings;
    }

    public final void run() {
        CastRemoteDisplayLocalService.zzq(this.zzb, this.zza);
    }
}
