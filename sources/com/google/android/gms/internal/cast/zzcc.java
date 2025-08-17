package com.google.android.gms.internal.cast;

import android.widget.TextView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import java.util.ArrayList;
import java.util.List;

public final class zzcc extends UIController {
    private final TextView zza;
    private final List zzb;

    public zzcc(TextView textView, List list) {
        ArrayList arrayList = new ArrayList();
        this.zzb = arrayList;
        this.zza = textView;
        arrayList.addAll(list);
    }

    public final void onMediaStatusUpdated() {
        MediaQueueItem preloadedItem;
        MediaInfo media;
        MediaMetadata metadata;
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && (preloadedItem = remoteMediaClient.getPreloadedItem()) != null && (media = preloadedItem.getMedia()) != null && (metadata = media.getMetadata()) != null) {
            for (String str : this.zzb) {
                if (metadata.containsKey(str)) {
                    this.zza.setText(metadata.getString(str));
                    return;
                }
            }
            this.zza.setText("");
        }
    }
}
