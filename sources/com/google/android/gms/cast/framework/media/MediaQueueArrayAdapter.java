package com.google.android.gms.cast.framework.media;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.media.MediaQueue;

public abstract class MediaQueueArrayAdapter extends ArrayAdapter<MediaQueueItem> {
    private final MediaQueue zza;
    private final MediaQueue.Callback zzb;

    public MediaQueueArrayAdapter(MediaQueue mediaQueue, Context context, int i2) {
        super(context, i2);
        this.zza = mediaQueue;
        zzu zzu = new zzu(this, (zzt) null);
        this.zzb = zzu;
        mediaQueue.registerCallback(zzu);
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public void dispose() {
        this.zza.unregisterCallback(this.zzb);
    }

    public int getCount() {
        return this.zza.getItemCount();
    }

    public MediaQueueItem getItem(int i2) {
        return this.zza.getItemAtIndex(i2);
    }

    public long getItemId(int i2) {
        return (long) this.zza.itemIdAtIndex(i2);
    }

    public MediaQueue getMediaQueue() {
        return this.zza;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isEmpty() {
        return this.zza.getItemCount() == 0;
    }

    public boolean isEnabled(int i2) {
        return this.zza.getItemAtIndex(i2, false) != null;
    }
}
