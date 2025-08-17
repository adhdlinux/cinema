package com.google.android.gms.cast.framework.media;

public final /* synthetic */ class zzk implements Runnable {
    public final /* synthetic */ MediaNotificationService zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzk(MediaNotificationService mediaNotificationService, int i2) {
        this.zza = mediaNotificationService;
        this.zzb = i2;
    }

    public final void run() {
        this.zza.stopSelf(this.zzb);
    }
}
