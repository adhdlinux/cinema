package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.CastUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class zzs extends RemoteMediaClient.Callback {
    final /* synthetic */ MediaQueue zza;

    public zzs(MediaQueue mediaQueue) {
        this.zza = mediaQueue;
    }

    public final void onStatusUpdated() {
        long zza2 = this.zza.zzp();
        MediaQueue mediaQueue = this.zza;
        if (zza2 != mediaQueue.zza) {
            mediaQueue.zza = zza2;
            mediaQueue.zzl();
            MediaQueue mediaQueue2 = this.zza;
            if (mediaQueue2.zza != 0) {
                mediaQueue2.zzo();
            }
        }
    }

    public final void zza(int[] iArr) {
        List zzd = CastUtils.zzd(iArr);
        if (!this.zza.zzb.equals(zzd)) {
            this.zza.zzx();
            this.zza.zzd.evictAll();
            this.zza.zze.clear();
            MediaQueue mediaQueue = this.zza;
            mediaQueue.zzb = zzd;
            MediaQueue.zzk(mediaQueue);
            this.zza.zzv();
            this.zza.zzu();
        }
    }

    public final void zzb(int[] iArr, int i2) {
        int i3;
        if (i2 == 0) {
            i3 = this.zza.zzb.size();
        } else {
            i3 = this.zza.zzc.get(i2, -1);
            if (i3 == -1) {
                this.zza.zzo();
                return;
            }
        }
        int length = iArr.length;
        this.zza.zzx();
        this.zza.zzb.addAll(i3, CastUtils.zzd(iArr));
        MediaQueue.zzk(this.zza);
        MediaQueue.zze(this.zza, i3, length);
        this.zza.zzu();
    }

    public final void zzc(MediaQueueItem[] mediaQueueItemArr) {
        HashSet hashSet = new HashSet();
        this.zza.zze.clear();
        int length = mediaQueueItemArr.length;
        int i2 = 0;
        while (i2 < length) {
            MediaQueueItem mediaQueueItem = mediaQueueItemArr[i2];
            int itemId = mediaQueueItem.getItemId();
            this.zza.zzd.put(Integer.valueOf(itemId), mediaQueueItem);
            int i3 = this.zza.zzc.get(itemId, -1);
            if (i3 == -1) {
                this.zza.zzo();
                return;
            } else {
                hashSet.add(Integer.valueOf(i3));
                i2++;
            }
        }
        for (Integer intValue : this.zza.zze) {
            int i4 = this.zza.zzc.get(intValue.intValue(), -1);
            if (i4 != -1) {
                hashSet.add(Integer.valueOf(i4));
            }
        }
        this.zza.zze.clear();
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        this.zza.zzx();
        this.zza.zzw(CastUtils.zzf(arrayList));
        this.zza.zzu();
    }

    public final void zzd(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            this.zza.zzd.remove(Integer.valueOf(i2));
            int i3 = this.zza.zzc.get(i2, -1);
            if (i3 == -1) {
                this.zza.zzo();
                return;
            }
            this.zza.zzc.delete(i2);
            arrayList.add(Integer.valueOf(i3));
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            this.zza.zzx();
            this.zza.zzb.removeAll(CastUtils.zzd(iArr));
            MediaQueue.zzk(this.zza);
            MediaQueue.zzf(this.zza, CastUtils.zzf(arrayList));
            this.zza.zzu();
        }
    }

    public final void zze(List list, List list2, int i2) {
        int i3;
        ArrayList arrayList = new ArrayList();
        if (i2 == 0) {
            i3 = this.zza.zzb.size();
        } else if (list2.isEmpty()) {
            this.zza.zzg.w("Received a Queue Reordered message with an empty reordered items IDs list.", new Object[0]);
            i3 = -1;
        } else {
            i3 = this.zza.zzc.get(i2, -1);
            if (i3 == -1) {
                i3 = this.zza.zzc.get(((Integer) list2.get(0)).intValue(), -1);
            }
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            int i4 = this.zza.zzc.get(((Integer) it2.next()).intValue(), -1);
            if (i4 == -1) {
                this.zza.zzo();
                return;
            }
            arrayList.add(Integer.valueOf(i4));
        }
        this.zza.zzx();
        MediaQueue mediaQueue = this.zza;
        mediaQueue.zzb = list;
        MediaQueue.zzk(mediaQueue);
        MediaQueue.zzg(this.zza, arrayList, i3);
        this.zza.zzu();
    }

    public final void zzf(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < iArr.length) {
            int i3 = iArr[i2];
            this.zza.zzd.remove(Integer.valueOf(i3));
            int i4 = this.zza.zzc.get(i3, -1);
            if (i4 == -1) {
                this.zza.zzo();
                return;
            } else {
                arrayList.add(Integer.valueOf(i4));
                i2++;
            }
        }
        Collections.sort(arrayList);
        this.zza.zzx();
        this.zza.zzw(CastUtils.zzf(arrayList));
        this.zza.zzu();
    }

    public final void zzg() {
        this.zza.zzo();
    }
}
