package com.google.android.gms.internal.cast;

import androidx.mediarouter.media.MediaRouter;

final class zzw extends MediaRouter.Callback {
    final /* synthetic */ zzy zza;

    zzw(zzy zzy) {
        this.zza = zzy;
    }

    public final void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        this.zza.zzf();
    }

    public final void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        this.zza.zzf();
    }

    public final void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        this.zza.zzf();
    }

    public final void onRouteSelected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, int i2) {
        this.zza.zzs = routeInfo;
        this.zza.dismiss();
    }
}
