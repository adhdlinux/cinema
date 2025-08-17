package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.AdBreakClipInfo;
import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.cast.framework.media.uicontroller.zza;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.cast.framework.media.widget.zzb;
import com.google.android.gms.cast.framework.media.widget.zzc;
import com.google.android.gms.cast.framework.media.widget.zze;
import java.util.ArrayList;
import java.util.List;

public final class zzbs extends UIController implements RemoteMediaClient.ProgressListener {
    private final CastSeekBar zza;
    private final long zzb;
    private final zza zzc;

    public zzbs(CastSeekBar castSeekBar, long j2, zza zza2) {
        this.zza = castSeekBar;
        this.zzb = j2;
        this.zzc = zza2;
        castSeekBar.setEnabled(false);
        castSeekBar.zzd((List) null);
        castSeekBar.zzb = null;
        castSeekBar.postInvalidate();
    }

    public final RemoteMediaClient getRemoteMediaClient() {
        return super.getRemoteMediaClient();
    }

    public final void onMediaStatusUpdated() {
        zzc();
    }

    public final void onProgressUpdated(long j2, long j3) {
        zzb();
        zza();
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        RemoteMediaClient remoteMediaClient = super.getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.addProgressListener(this, this.zzb);
        }
        zzc();
    }

    public final void onSessionEnded() {
        RemoteMediaClient remoteMediaClient = super.getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.removeProgressListener(this);
        }
        super.onSessionEnded();
        zzc();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        int i2;
        RemoteMediaClient remoteMediaClient = super.getRemoteMediaClient();
        AdBreakClipInfo adBreakClipInfo = null;
        if (remoteMediaClient == null || !remoteMediaClient.isPlayingAd()) {
            CastSeekBar castSeekBar = this.zza;
            castSeekBar.zzb = null;
            castSeekBar.postInvalidate();
            return;
        }
        int approximateAdBreakClipPositionMs = (int) remoteMediaClient.getApproximateAdBreakClipPositionMs();
        MediaStatus mediaStatus = remoteMediaClient.getMediaStatus();
        if (mediaStatus != null) {
            adBreakClipInfo = mediaStatus.getCurrentAdBreakClip();
        }
        if (adBreakClipInfo != null) {
            i2 = (int) adBreakClipInfo.getDurationInMs();
        } else {
            i2 = approximateAdBreakClipPositionMs;
        }
        if (approximateAdBreakClipPositionMs < 0) {
            approximateAdBreakClipPositionMs = 0;
        }
        if (i2 < 0) {
            i2 = 1;
        }
        CastSeekBar castSeekBar2 = this.zza;
        if (approximateAdBreakClipPositionMs > i2) {
            i2 = approximateAdBreakClipPositionMs;
        }
        castSeekBar2.zzb = new zzc(approximateAdBreakClipPositionMs, i2);
        castSeekBar2.postInvalidate();
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        int i2;
        int i3;
        RemoteMediaClient remoteMediaClient = super.getRemoteMediaClient();
        boolean z2 = true;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || remoteMediaClient.isPlayingAd()) {
            this.zza.setEnabled(false);
        } else {
            this.zza.setEnabled(true);
        }
        zze zze = new zze();
        zze.zza = this.zzc.zza();
        zze.zzb = this.zzc.zzb();
        zze.zzc = (int) (-this.zzc.zze());
        RemoteMediaClient remoteMediaClient2 = super.getRemoteMediaClient();
        if (remoteMediaClient2 == null || !remoteMediaClient2.hasMediaSession() || !remoteMediaClient2.zzv()) {
            i2 = this.zzc.zza();
        } else {
            i2 = this.zzc.zzd();
        }
        zze.zzd = i2;
        RemoteMediaClient remoteMediaClient3 = super.getRemoteMediaClient();
        if (remoteMediaClient3 == null || !remoteMediaClient3.hasMediaSession() || !remoteMediaClient3.zzv()) {
            i3 = this.zzc.zza();
        } else {
            i3 = this.zzc.zzc();
        }
        zze.zze = i3;
        RemoteMediaClient remoteMediaClient4 = super.getRemoteMediaClient();
        if (remoteMediaClient4 == null || !remoteMediaClient4.hasMediaSession() || !remoteMediaClient4.zzv()) {
            z2 = false;
        }
        zze.zzf = z2;
        this.zza.zze(zze);
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        MediaInfo mediaInfo;
        int i2;
        zzb();
        RemoteMediaClient remoteMediaClient = super.getRemoteMediaClient();
        ArrayList arrayList = null;
        if (remoteMediaClient == null) {
            mediaInfo = null;
        } else {
            mediaInfo = remoteMediaClient.getMediaInfo();
        }
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || remoteMediaClient.isLoadingNextItem() || mediaInfo == null) {
            this.zza.zzd((List) null);
        } else {
            CastSeekBar castSeekBar = this.zza;
            List<AdBreakInfo> adBreaks = mediaInfo.getAdBreaks();
            if (adBreaks != null) {
                arrayList = new ArrayList();
                for (AdBreakInfo next : adBreaks) {
                    if (next != null) {
                        long playbackPositionInMs = next.getPlaybackPositionInMs();
                        if (playbackPositionInMs == -1000) {
                            i2 = this.zzc.zzb();
                        } else {
                            i2 = Math.min((int) (playbackPositionInMs - this.zzc.zze()), this.zzc.zzb());
                        }
                        if (i2 >= 0) {
                            arrayList.add(new zzb(i2, (int) next.getDurationInMs(), next.isExpanded()));
                        }
                    }
                }
            }
            castSeekBar.zzd(arrayList);
        }
        zza();
    }
}
