package com.google.android.gms.internal.cast;

import android.os.Handler;
import android.os.Looper;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.mediarouter.media.MediaRouter;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;

public final class zzbb implements MediaRouter.OnPrepareTransferListener {
    private static final Logger zza = new Logger("MediaRouterOPTListener");
    private final zzbm zzb;
    private final Handler zzc = new zzdy(Looper.getMainLooper());

    public zzbb(zzbm zzbm) {
        this.zzb = (zzbm) Preconditions.checkNotNull(zzbm);
    }

    public final ListenableFuture onPrepareTransfer(MediaRouter.RouteInfo routeInfo, MediaRouter.RouteInfo routeInfo2) {
        zza.d("Prepare transfer from Route(%s) to Route(%s)", routeInfo, routeInfo2);
        return CallbackToFutureAdapter.a(new zzba(this, routeInfo, routeInfo2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(MediaRouter.RouteInfo routeInfo, MediaRouter.RouteInfo routeInfo2, CallbackToFutureAdapter.Completer completer) throws Exception {
        return Boolean.valueOf(this.zzc.post(new zzaz(this, routeInfo, routeInfo2, completer)));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(MediaRouter.RouteInfo routeInfo, MediaRouter.RouteInfo routeInfo2, CallbackToFutureAdapter.Completer completer) {
        this.zzb.zzl(routeInfo, routeInfo2, completer);
    }
}
