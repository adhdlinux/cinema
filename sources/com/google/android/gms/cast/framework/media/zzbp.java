package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import java.util.HashSet;
import java.util.Set;

final class zzbp {
    final /* synthetic */ RemoteMediaClient zza;
    /* access modifiers changed from: private */
    public final Set zzb = new HashSet();
    /* access modifiers changed from: private */
    public final long zzc;
    private final Runnable zzd;
    private boolean zze;

    public zzbp(RemoteMediaClient remoteMediaClient, long j2) {
        this.zza = remoteMediaClient;
        this.zzc = j2;
        this.zzd = new zzbo(this, remoteMediaClient);
    }

    public final long zzb() {
        return this.zzc;
    }

    public final void zzd(RemoteMediaClient.ProgressListener progressListener) {
        this.zzb.add(progressListener);
    }

    public final void zze(RemoteMediaClient.ProgressListener progressListener) {
        this.zzb.remove(progressListener);
    }

    public final void zzf() {
        this.zza.zzd.removeCallbacks(this.zzd);
        this.zze = true;
        this.zza.zzd.postDelayed(this.zzd, this.zzc);
    }

    public final void zzg() {
        this.zza.zzd.removeCallbacks(this.zzd);
        this.zze = false;
    }

    public final boolean zzh() {
        return !this.zzb.isEmpty();
    }

    public final boolean zzi() {
        return this.zze;
    }
}
