package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzar;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzdm implements zzar {
    final /* synthetic */ RemoteMediaPlayer zza;
    private GoogleApiClient zzb;
    private long zzc = 0;

    public zzdm(RemoteMediaPlayer remoteMediaPlayer) {
        this.zza = remoteMediaPlayer;
    }

    public final long zza() {
        long j2 = this.zzc + 1;
        this.zzc = j2;
        return j2;
    }

    public final void zzb(String str, String str2, long j2, String str3) {
        GoogleApiClient googleApiClient = this.zzb;
        if (googleApiClient != null) {
            Cast.CastApi.sendMessage(googleApiClient, str, str2).setResultCallback(new zzdl(this, j2));
            return;
        }
        throw new IllegalStateException("No GoogleApiClient available");
    }

    public final void zzc(GoogleApiClient googleApiClient) {
        this.zzb = googleApiClient;
    }
}
