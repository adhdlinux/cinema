package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

@Deprecated
public final class zzdp extends GmsClient implements IBinder.DeathRecipient {
    /* access modifiers changed from: private */
    public static final Logger zze = new Logger("CastRemoteDisplayClientImpl");
    /* access modifiers changed from: private */
    public final CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzf;
    private final CastDevice zzg;
    private final Bundle zzh;

    public zzdp(Context context, Looper looper, ClientSettings clientSettings, CastDevice castDevice, Bundle bundle, CastRemoteDisplay.CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 83, clientSettings, connectionCallbacks, onConnectionFailedListener);
        zze.d("instance created", new Object[0]);
        this.zzf = castRemoteDisplaySessionCallbacks;
        this.zzg = castDevice;
        this.zzh = bundle;
    }

    public final void binderDied() {
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
        if (queryLocalInterface instanceof zzds) {
            return (zzds) queryLocalInterface;
        }
        return new zzds(iBinder);
    }

    public final void disconnect() {
        zze.d("disconnect", new Object[0]);
        try {
            ((zzds) getService()).zze();
        } catch (RemoteException | IllegalStateException unused) {
        } finally {
            super.disconnect();
        }
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.cast.remote_display.service.START";
    }

    public final void zzr(zzdr zzdr, zzdu zzdu, String str) throws RemoteException {
        zze.d("startRemoteDisplay", new Object[0]);
        zzdr zzdr2 = zzdr;
        ((zzds) getService()).zzg(zzdr2, new zzdo(this, zzdu), this.zzg.getDeviceId(), str, this.zzh);
    }

    public final void zzs(zzdr zzdr) throws RemoteException {
        zze.d("stopRemoteDisplay", new Object[0]);
        ((zzds) getService()).zzi(zzdr);
    }
}
