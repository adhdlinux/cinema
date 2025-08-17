package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.b;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.mediarouter.app.MediaRouteChooserDialog;
import androidx.mediarouter.app.MediaRouteChooserDialogFragment;

public final class zzz extends MediaRouteChooserDialogFragment {
    public /* bridge */ /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return b.a(this);
    }

    public final MediaRouteChooserDialog onCreateChooserDialog(Context context, Bundle bundle) {
        zzy zzy = new zzy(context, 0);
        zzy.zze();
        return zzy;
    }
}
