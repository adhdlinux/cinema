package com.google.android.gms.internal.cast;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.mediarouter.media.MediaRouter;

public final /* synthetic */ class zzba implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ zzbb zza;
    public final /* synthetic */ MediaRouter.RouteInfo zzb;
    public final /* synthetic */ MediaRouter.RouteInfo zzc;

    public /* synthetic */ zzba(zzbb zzbb, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteInfo routeInfo2) {
        this.zza = zzbb;
        this.zzb = routeInfo;
        this.zzc = routeInfo2;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.zza.zza(this.zzb, this.zzc, completer);
    }
}
