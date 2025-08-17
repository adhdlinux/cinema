package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class zzfog implements ServiceConnection {
    final /* synthetic */ zzfoh zza;

    /* synthetic */ zzfog(zzfoh zzfoh, zzfof zzfof) {
        this.zza = zzfoh;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zza.zzc.zzc("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        zzfoh zzfoh = this.zza;
        zzfoh.zzc().post(new zzfod(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zzc.zzc("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        zzfoh zzfoh = this.zza;
        zzfoh.zzc().post(new zzfoe(this));
    }
}
