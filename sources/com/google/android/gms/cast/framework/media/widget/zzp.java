package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

final class zzp implements RemoteMediaClient.Listener {
    final /* synthetic */ ExpandedControllerActivity zza;

    /* synthetic */ zzp(ExpandedControllerActivity expandedControllerActivity, zzo zzo) {
        this.zza = expandedControllerActivity;
    }

    public final void onAdBreakStatusUpdated() {
        this.zza.zzp();
    }

    public final void onMetadataUpdated() {
        this.zza.zzo();
    }

    public final void onPreloadStatusUpdated() {
    }

    public final void onQueueStatusUpdated() {
    }

    public final void onSendingRemoteMediaRequest() {
        ExpandedControllerActivity expandedControllerActivity = this.zza;
        expandedControllerActivity.zzw.setText(expandedControllerActivity.getResources().getString(R.string.cast_expanded_controller_loading));
    }

    public final void onStatusUpdated() {
        RemoteMediaClient zze = this.zza.zzj();
        if (zze == null || !zze.hasMediaSession()) {
            ExpandedControllerActivity expandedControllerActivity = this.zza;
            if (!expandedControllerActivity.zzd) {
                expandedControllerActivity.finish();
                return;
            }
            return;
        }
        ExpandedControllerActivity expandedControllerActivity2 = this.zza;
        expandedControllerActivity2.zzd = false;
        expandedControllerActivity2.zzn();
        this.zza.zzp();
    }
}
