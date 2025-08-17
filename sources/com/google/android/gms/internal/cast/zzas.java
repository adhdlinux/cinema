package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import android.text.TextUtils;
import androidx.mediarouter.media.MediaRouter;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

public final class zzas extends MediaRouter.Callback {
    private static final Logger zza = new Logger("MediaRouterCallback");
    private final zzan zzb;

    public zzas(zzan zzan) {
        this.zzb = (zzan) Preconditions.checkNotNull(zzan);
    }

    public final void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        try {
            this.zzb.zzf(routeInfo.k(), routeInfo.i());
        } catch (RemoteException e2) {
            zza.d(e2, "Unable to call %s on %s.", "onRouteAdded", zzan.class.getSimpleName());
        }
    }

    public final void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        try {
            this.zzb.zzg(routeInfo.k(), routeInfo.i());
        } catch (RemoteException e2) {
            zza.d(e2, "Unable to call %s on %s.", "onRouteChanged", zzan.class.getSimpleName());
        }
    }

    public final void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        try {
            this.zzb.zzh(routeInfo.k(), routeInfo.i());
        } catch (RemoteException e2) {
            zza.d(e2, "Unable to call %s on %s.", "onRouteRemoved", zzan.class.getSimpleName());
        }
    }

    public final void onRouteSelected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, int i2) {
        CastDevice fromBundle;
        zza.i("onRouteSelected with reason = %d, routeId = %s", Integer.valueOf(i2), routeInfo.k());
        if (routeInfo.o() == 1) {
            try {
                String k2 = routeInfo.k();
                String k3 = routeInfo.k();
                if (k3 != null) {
                    if (k3.endsWith("-groupRoute")) {
                        CastDevice fromBundle2 = CastDevice.getFromBundle(routeInfo.i());
                        if (fromBundle2 != null) {
                            String deviceId = fromBundle2.getDeviceId();
                            Iterator<MediaRouter.RouteInfo> it2 = mediaRouter.m().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    MediaRouter.RouteInfo next = it2.next();
                                    String k4 = next.k();
                                    if (k4 != null && !k4.endsWith("-groupRoute") && (fromBundle = CastDevice.getFromBundle(next.i())) != null && TextUtils.equals(fromBundle.getDeviceId(), deviceId)) {
                                        zza.d("routeId is changed from %s to %s", k3, next.k());
                                        k3 = next.k();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
                if (this.zzb.zze() >= 220400000) {
                    this.zzb.zzj(k3, k2, routeInfo.i());
                } else {
                    this.zzb.zzi(k3, routeInfo.i());
                }
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "onRouteSelected", zzan.class.getSimpleName());
            }
        }
    }

    public final void onRouteUnselected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, int i2) {
        Logger logger = zza;
        logger.i("onRouteUnselected with reason = %d, routeId = %s", Integer.valueOf(i2), routeInfo.k());
        if (routeInfo.o() != 1) {
            logger.d("skip route unselection for non-cast route", new Object[0]);
            return;
        }
        try {
            this.zzb.zzk(routeInfo.k(), routeInfo.i(), i2);
        } catch (RemoteException e2) {
            zza.d(e2, "Unable to call %s on %s.", "onRouteUnselected", zzan.class.getSimpleName());
        }
    }
}
