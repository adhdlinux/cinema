package com.google.android.gms.cast.framework.media.uicontroller;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

public abstract class UIController {
    private RemoteMediaClient zza;

    /* access modifiers changed from: protected */
    public RemoteMediaClient getRemoteMediaClient() {
        return this.zza;
    }

    public void onMediaStatusUpdated() {
    }

    public void onSendingRemoteMediaRequest() {
    }

    public void onSessionConnected(CastSession castSession) {
        this.zza = castSession != null ? castSession.getRemoteMediaClient() : null;
    }

    public void onSessionEnded() {
        this.zza = null;
    }
}
