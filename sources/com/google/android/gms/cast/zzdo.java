package com.google.android.gms.cast;

import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzdo implements RemoteMediaPlayer.MediaChannelResult {
    final /* synthetic */ Status zza;

    zzdo(zzdp zzdp, Status status) {
        this.zza = status;
    }

    public final JSONObject getCustomData() {
        return null;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
