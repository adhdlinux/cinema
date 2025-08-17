package com.google.android.gms.cast.framework.media;

import android.content.Context;
import java.util.List;

public abstract class NotificationActionsProvider {
    private final Context zza;
    private final zzg zzb = new zzz(this, (zzy) null);

    public NotificationActionsProvider(Context context) {
        this.zza = context.getApplicationContext();
    }

    public Context getApplicationContext() {
        return this.zza;
    }

    public abstract int[] getCompactViewActionIndices();

    public abstract List<NotificationAction> getNotificationActions();

    public final zzg zza() {
        return this.zzb;
    }
}
