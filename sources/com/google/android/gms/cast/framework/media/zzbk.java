package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
abstract class zzbk extends BasePendingResult {
    private zzat zza;
    private final boolean zzb;
    final /* synthetic */ RemoteMediaClient zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbk(RemoteMediaClient remoteMediaClient, boolean z2) {
        super((GoogleApiClient) null);
        this.zzg = remoteMediaClient;
        this.zzb = z2;
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzbj(this, status);
    }

    /* access modifiers changed from: package-private */
    public abstract void zza() throws zzao;

    /* access modifiers changed from: package-private */
    public final zzat zzb() {
        if (this.zza == null) {
            this.zza = new zzbi(this);
        }
        return this.zza;
    }

    public final void zzc() {
        if (!this.zzb) {
            for (RemoteMediaClient.Listener onSendingRemoteMediaRequest : this.zzg.zzj) {
                onSendingRemoteMediaRequest.onSendingRemoteMediaRequest();
            }
            for (RemoteMediaClient.Callback onSendingRemoteMediaRequest2 : this.zzg.zza) {
                onSendingRemoteMediaRequest2.onSendingRemoteMediaRequest();
            }
        }
        try {
            synchronized (this.zzg.zzc) {
                zza();
            }
        } catch (zzao unused) {
            setResult(new zzbj(this, new Status(2100)));
        }
    }
}
