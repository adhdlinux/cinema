package com.google.android.gms.internal.cast;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.mediarouter.media.MediaRouter;

public final /* synthetic */ class zzaz implements Runnable {
    public final /* synthetic */ zzbb zza;
    public final /* synthetic */ MediaRouter.RouteInfo zzb;
    public final /* synthetic */ MediaRouter.RouteInfo zzc;
    public final /* synthetic */ CallbackToFutureAdapter.Completer zzd;

    public /* synthetic */ zzaz(zzbb zzbb, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteInfo routeInfo2, CallbackToFutureAdapter.Completer completer) {
        this.zza = zzbb;
        this.zzb = routeInfo;
        this.zzc = routeInfo2;
        this.zzd = completer;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc, this.zzd);
    }
}
