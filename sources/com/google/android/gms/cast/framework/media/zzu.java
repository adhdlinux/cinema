package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.MediaQueue;
import java.util.List;

final class zzu extends MediaQueue.Callback {
    final /* synthetic */ MediaQueueArrayAdapter zza;

    /* synthetic */ zzu(MediaQueueArrayAdapter mediaQueueArrayAdapter, zzt zzt) {
        this.zza = mediaQueueArrayAdapter;
    }

    public final void itemsInsertedInRange(int i2, int i3) {
        this.zza.notifyDataSetChanged();
    }

    public final void itemsReloaded() {
        this.zza.notifyDataSetChanged();
    }

    public final void itemsRemovedAtIndexes(int[] iArr) {
        this.zza.notifyDataSetChanged();
    }

    public final void itemsReorderedAtIndexes(List<Integer> list, int i2) {
        this.zza.notifyDataSetChanged();
    }

    public final void itemsUpdatedAtIndexes(int[] iArr) {
        this.zza.notifyDataSetChanged();
    }

    public final void mediaQueueChanged() {
        this.zza.notifyDataSetChanged();
    }

    public final void mediaQueueWillChange() {
    }
}
