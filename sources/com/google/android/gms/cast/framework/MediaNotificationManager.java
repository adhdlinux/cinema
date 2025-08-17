package com.google.android.gms.cast.framework;

public class MediaNotificationManager {
    private final SessionManager zza;

    public MediaNotificationManager(SessionManager sessionManager) {
        this.zza = sessionManager;
    }

    public void updateNotification() {
        CastSession currentCastSession = this.zza.getCurrentCastSession();
        if (currentCastSession != null) {
            currentCastSession.zzd().zzl(true);
        }
    }
}
