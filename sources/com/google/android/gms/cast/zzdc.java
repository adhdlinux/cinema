package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import java.util.Locale;
import org.json.JSONObject;

final class zzdc extends zzdp {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaPlayer zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdc(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i2, int i3, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzd = remoteMediaPlayer;
        this.zza = i2;
        this.zzb = i3;
        this.zzc = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) throws zzao {
        int i2;
        int zza2 = RemoteMediaPlayer.zza(this.zzd, this.zza);
        if (zza2 == -1) {
            setResult(new zzdo(this, new Status(0)));
            return;
        }
        int i3 = this.zzb;
        if (i3 < 0) {
            setResult(new zzdo(this, new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", new Object[]{Integer.valueOf(this.zzb)}))));
        } else if (zza2 == i3) {
            setResult(new zzdo(this, new Status(0)));
        } else {
            MediaStatus mediaStatus = this.zzd.getMediaStatus();
            if (mediaStatus == null) {
                setResult(new zzdo(this, new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid MediaStatus", new Object[0]))));
                return;
            }
            int i4 = this.zzb;
            if (i4 > zza2) {
                i4++;
            }
            MediaQueueItem queueItem = mediaStatus.getQueueItem(i4);
            if (queueItem != null) {
                i2 = queueItem.getItemId();
            } else {
                i2 = 0;
            }
            this.zzd.zzb.zzz(zzb(), new int[]{this.zza}, i2, this.zzc);
        }
    }
}
