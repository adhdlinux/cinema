package com.google.android.gms.internal.cast;

import android.view.View;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

public final class zzcl extends UIController {
    private final View zza;
    private final int zzb;

    public zzcl(View view, int i2) {
        this.zza = view;
        this.zzb = i2;
        view.setEnabled(false);
    }

    private final void zza() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.zzs() || remoteMediaClient.isPlayingAd()) {
            this.zza.setVisibility(this.zzb);
            this.zza.setEnabled(false);
            return;
        }
        this.zza.setVisibility(0);
        this.zza.setEnabled(true);
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onSendingRemoteMediaRequest() {
        this.zza.setEnabled(false);
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        zza();
    }

    public final void onSessionEnded() {
        this.zza.setEnabled(false);
        super.onSessionEnded();
    }
}
