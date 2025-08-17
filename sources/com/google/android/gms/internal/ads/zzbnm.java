package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;

public final class zzbnm extends zzcgp {
    private final AppMeasurementSdk zza;

    zzbnm(AppMeasurementSdk appMeasurementSdk) {
        this.zza = appMeasurementSdk;
    }

    public final int zzb(String str) throws RemoteException {
        return this.zza.getMaxUserProperties(str);
    }

    public final long zzc() throws RemoteException {
        return this.zza.generateEventId();
    }

    public final Bundle zzd(Bundle bundle) throws RemoteException {
        return this.zza.performActionWithResponse(bundle);
    }

    public final String zze() throws RemoteException {
        return this.zza.getAppIdOrigin();
    }

    public final String zzf() throws RemoteException {
        return this.zza.getAppInstanceId();
    }

    public final String zzg() throws RemoteException {
        return this.zza.getCurrentScreenClass();
    }

    public final String zzh() throws RemoteException {
        return this.zza.getCurrentScreenName();
    }

    public final String zzi() throws RemoteException {
        return this.zza.getGmpAppId();
    }

    public final List zzj(String str, String str2) throws RemoteException {
        return this.zza.getConditionalUserProperties(str, str2);
    }

    public final Map zzk(String str, String str2, boolean z2) throws RemoteException {
        return this.zza.getUserProperties(str, str2, z2);
    }

    public final void zzl(String str) throws RemoteException {
        this.zza.beginAdUnitExposure(str);
    }

    public final void zzm(String str, String str2, Bundle bundle) throws RemoteException {
        this.zza.clearConditionalUserProperty(str, str2, bundle);
    }

    public final void zzn(String str) throws RemoteException {
        this.zza.endAdUnitExposure(str);
    }

    public final void zzo(String str, String str2, Bundle bundle) throws RemoteException {
        this.zza.logEvent(str, str2, bundle);
    }

    public final void zzp(Bundle bundle) throws RemoteException {
        this.zza.performAction(bundle);
    }

    public final void zzq(Bundle bundle) throws RemoteException {
        this.zza.setConditionalUserProperty(bundle);
    }

    public final void zzr(Bundle bundle) throws RemoteException {
        this.zza.setConsent(bundle);
    }

    public final void zzs(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Activity activity;
        AppMeasurementSdk appMeasurementSdk = this.zza;
        if (iObjectWrapper != null) {
            activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        } else {
            activity = null;
        }
        appMeasurementSdk.setCurrentScreen(activity, str, str2);
    }

    public final void zzt(String str, String str2, IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj;
        AppMeasurementSdk appMeasurementSdk = this.zza;
        if (iObjectWrapper != null) {
            obj = ObjectWrapper.unwrap(iObjectWrapper);
        } else {
            obj = null;
        }
        appMeasurementSdk.setUserProperty(str, str2, obj);
    }
}
