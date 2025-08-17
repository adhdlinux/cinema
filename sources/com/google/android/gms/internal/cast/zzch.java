package com.google.android.gms.internal.cast;

import android.widget.ProgressBar;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

public final class zzch extends UIController implements RemoteMediaClient.ProgressListener {
    private final ProgressBar zza;
    private final long zzb;

    public zzch(ProgressBar progressBar, long j2) {
        this.zza = progressBar;
        this.zzb = j2;
        progressBar.setMax(1);
        progressBar.setProgress(0);
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onProgressUpdated(long j2, long j3) {
        zza();
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.addProgressListener(this, this.zzb);
        }
        zza();
    }

    public final void onSessionEnded() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.removeProgressListener(this);
        }
        super.onSessionEnded();
        zza();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || remoteMediaClient.isLiveStream()) {
            this.zza.setMax(1);
            this.zza.setProgress(0);
            return;
        }
        this.zza.setMax((int) remoteMediaClient.getStreamDuration());
        this.zza.setProgress((int) remoteMediaClient.getApproximateStreamPosition());
    }
}
