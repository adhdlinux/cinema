package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.common.internal.Preconditions;

public final /* synthetic */ class zzbg implements Runnable {
    public final /* synthetic */ zzbm zza;

    public /* synthetic */ zzbg(zzbm zzbm) {
        this.zza = zzbm;
    }

    public final void run() {
        ((SessionManager) Preconditions.checkNotNull(this.zza.zzg)).addSessionManagerListener(new zzbl(this.zza, (zzbk) null), CastSession.class);
    }
}
