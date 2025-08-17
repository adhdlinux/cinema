package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.RemoteException;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.view.MenuItemCompat;
import androidx.mediarouter.app.MediaRouteActionProvider;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.mediarouter.app.MediaRouteDialogFactory;
import androidx.mediarouter.media.MediaRouteSelector;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzaa;
import com.google.android.gms.internal.cast.zzln;
import com.google.android.gms.internal.cast.zzr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CastButtonFactory {
    public static final /* synthetic */ int zza = 0;
    private static final Logger zzb = new Logger("CastButtonFactory");
    private static final List zzc = new ArrayList();
    private static final List zzd = new ArrayList();
    private static zza zze = null;

    private CastButtonFactory() {
    }

    public static MenuItem setUpMediaRouteButton(Context context, Menu menu, int i2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(menu);
        MenuItem findItem = menu.findItem(i2);
        if (findItem != null) {
            boolean zzh = zzh(context);
            try {
                MediaRouteActionProvider zzc2 = zzc(findItem);
                if (zzc2 != null && zzi(context, (MediaRouteDialogFactory) null)) {
                    zzc2.setAlwaysVisible(true);
                }
                zzf(context, findItem, zzd((MediaRouteDialogFactory) null, zzh));
                zzc.add(new WeakReference(findItem));
                zze((MediaRouteDialogFactory) null, zzh);
                return findItem;
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException(String.format(Locale.ROOT, "menu item with ID %d doesn't have a MediaRouteActionProvider.", new Object[]{Integer.valueOf(i2)}), e2);
            }
        } else {
            throw new IllegalArgumentException(String.format(Locale.ROOT, "menu doesn't contain a menu item whose ID is %d.", new Object[]{Integer.valueOf(i2)}));
        }
    }

    public static void zza(Context context) {
        for (WeakReference weakReference : zzc) {
            MenuItem menuItem = (MenuItem) weakReference.get();
            if (menuItem != null) {
                try {
                    zzf(context, menuItem, (MediaRouteDialogFactory) null);
                } catch (IllegalArgumentException e2) {
                    zzb.w("Unexpected exception when refreshing MediaRouteSelectors for Cast buttons", e2);
                }
            }
        }
        for (WeakReference weakReference2 : zzd) {
            MediaRouteButton mediaRouteButton = (MediaRouteButton) weakReference2.get();
            if (mediaRouteButton != null) {
                zzg(context, mediaRouteButton, (MediaRouteDialogFactory) null);
            }
        }
    }

    static void zzb(zza zza2) {
        zze = zza2;
        try {
            ((zze) zza2).zza.zzf.zzj(false);
        } catch (RemoteException e2) {
            CastContext.zzb.d(e2, "Unable to call %s on %s.", "setCustomMediaRouteDialogFactorySetUp", zzz.class.getSimpleName());
        }
    }

    private static MediaRouteActionProvider zzc(MenuItem menuItem) {
        MediaRouteActionProvider mediaRouteActionProvider = (MediaRouteActionProvider) MenuItemCompat.a(menuItem);
        if (mediaRouteActionProvider == null) {
            return null;
        }
        return mediaRouteActionProvider;
    }

    private static MediaRouteDialogFactory zzd(MediaRouteDialogFactory mediaRouteDialogFactory, boolean z2) {
        if (z2) {
            return zzaa.zza();
        }
        return null;
    }

    private static void zze(MediaRouteDialogFactory mediaRouteDialogFactory, boolean z2) {
        zzln zzln;
        if (z2) {
            zzln = zzln.CAST_SDK_DEFAULT_DEVICE_DIALOG;
        } else {
            zzln = zzln.CAST_DEFAULT_MEDIA_ROUTER_DIALOG;
        }
        zzr.zzd(zzln);
    }

    private static void zzf(Context context, MenuItem menuItem, MediaRouteDialogFactory mediaRouteDialogFactory) throws IllegalArgumentException {
        MediaRouteSelector mergedSelector;
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaRouteActionProvider zzc2 = zzc(menuItem);
        if (zzc2 != null) {
            CastContext zza2 = CastContext.zza(context);
            if (!(zza2 == null || (mergedSelector = zza2.getMergedSelector()) == null)) {
                zzc2.setRouteSelector(mergedSelector);
            }
            if (mediaRouteDialogFactory != null) {
                zzc2.setDialogFactory(mediaRouteDialogFactory);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("cannot refreshButtonSelector with null mediaRouteActionProvider");
    }

    private static void zzg(Context context, MediaRouteButton mediaRouteButton, MediaRouteDialogFactory mediaRouteDialogFactory) {
        MediaRouteSelector mergedSelector;
        Preconditions.checkMainThread("Must be called from the main thread.");
        CastContext zza2 = CastContext.zza(context);
        if (!(zza2 == null || (mergedSelector = zza2.getMergedSelector()) == null)) {
            mediaRouteButton.setRouteSelector(mergedSelector);
        }
        if (mediaRouteDialogFactory != null) {
            mediaRouteButton.setDialogFactory(mediaRouteDialogFactory);
        }
    }

    private static boolean zzh(Context context) {
        CastContext zza2 = CastContext.zza(context);
        if (zza2 == null || !zza2.getCastOptions().zze()) {
            return false;
        }
        return true;
    }

    private static boolean zzi(Context context, MediaRouteDialogFactory mediaRouteDialogFactory) {
        return zzh(context);
    }

    public static void setUpMediaRouteButton(Context context, MediaRouteButton mediaRouteButton) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        boolean zzh = zzh(context);
        if (mediaRouteButton != null) {
            if (zzi(context, (MediaRouteDialogFactory) null)) {
                mediaRouteButton.setAlwaysVisible(true);
            }
            zzg(context, mediaRouteButton, zzd((MediaRouteDialogFactory) null, zzh));
            zzd.add(new WeakReference(mediaRouteButton));
        }
        zze((MediaRouteDialogFactory) null, zzh);
    }
}
