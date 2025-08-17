package com.google.android.gms.internal.cast;

import androidx.mediarouter.app.MediaRouteChooserDialogFragment;
import androidx.mediarouter.app.MediaRouteDialogFactory;

public final class zzaa extends MediaRouteDialogFactory {
    private static zzaa zza;

    public zzaa() {
        zzr.zzd(zzln.CAST_DEVICE_DIALOG_FACTORY_INSTANTIATED);
    }

    public static zzaa zza() {
        if (zza == null) {
            zza = new zzaa();
        }
        return zza;
    }

    public final MediaRouteChooserDialogFragment onCreateChooserDialogFragment() {
        return new zzz();
    }
}
