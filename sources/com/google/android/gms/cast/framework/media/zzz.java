package com.google.android.gms.cast.framework.media;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

final class zzz extends zzf {
    final /* synthetic */ NotificationActionsProvider zza;

    /* synthetic */ zzz(NotificationActionsProvider notificationActionsProvider, zzy zzy) {
        this.zza = notificationActionsProvider;
    }

    public final IObjectWrapper zze() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final List zzf() {
        return this.zza.getNotificationActions();
    }

    public final int[] zzg() {
        return this.zza.getCompactViewActionIndices();
    }
}
