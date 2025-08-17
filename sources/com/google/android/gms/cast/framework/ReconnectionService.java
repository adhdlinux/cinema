package com.google.android.gms.cast.framework;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.internal.cast.zzaf;

public class ReconnectionService extends Service {
    private static final Logger zza = new Logger("ReconnectionService");
    private zzaj zzb;

    public IBinder onBind(Intent intent) {
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                return zzaj.zzf(intent);
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "onBind", zzaj.class.getSimpleName());
            }
        }
        return null;
    }

    public void onCreate() {
        CastContext sharedInstance = CastContext.getSharedInstance(this);
        zzaj zzc = zzaf.zzc(this, sharedInstance.getSessionManager().zzb(), sharedInstance.zzc().zza());
        this.zzb = zzc;
        if (zzc != null) {
            try {
                zzc.zzg();
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "onCreate", zzaj.class.getSimpleName());
            }
            super.onCreate();
        }
    }

    public void onDestroy() {
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                zzaj.zzh();
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "onDestroy", zzaj.class.getSimpleName());
            }
            super.onDestroy();
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                return zzaj.zze(intent, i2, i3);
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "onStartCommand", zzaj.class.getSimpleName());
            }
        }
        return 2;
    }
}
