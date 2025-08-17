package com.google.android.gms.cast.framework.media;

import android.util.LruCache;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.common.internal.Preconditions;

final class zzr extends LruCache {
    final /* synthetic */ MediaQueue zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzr(MediaQueue mediaQueue, int i2) {
        super(i2);
        this.zza = mediaQueue;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void entryRemoved(boolean z2, Object obj, Object obj2, Object obj3) {
        Integer num = (Integer) obj;
        MediaQueueItem mediaQueueItem = (MediaQueueItem) obj2;
        MediaQueueItem mediaQueueItem2 = (MediaQueueItem) obj3;
        if (z2) {
            Preconditions.checkNotNull(this.zza.zze);
            this.zza.zze.add(num);
        }
    }
}
