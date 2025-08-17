package com.google.android.gms.cast.framework.media;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.media.MediaQueue;

public abstract class MediaQueueRecyclerViewAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private final MediaQueue zza;
    private final MediaQueue.Callback zzb;

    public MediaQueueRecyclerViewAdapter(MediaQueue mediaQueue) {
        this.zza = mediaQueue;
        zzw zzw = new zzw(this, (zzv) null);
        this.zzb = zzw;
        mediaQueue.registerCallback(zzw);
    }

    public void dispose() {
        this.zza.unregisterCallback(this.zzb);
    }

    public MediaQueueItem getItem(int i2) {
        return this.zza.getItemAtIndex(i2);
    }

    public int getItemCount() {
        return this.zza.getItemCount();
    }

    public long getItemId(int i2) {
        return (long) this.zza.itemIdAtIndex(i2);
    }

    public MediaQueue getMediaQueue() {
        return this.zza;
    }
}
