package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.cast.zzax;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public final class zzo extends GmsClient {
    public zzo(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 161, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastService");
        if (queryLocalInterface instanceof zzaj) {
            return (zzaj) queryLocalInterface;
        }
        return new zzaj(iBinder);
    }

    public final Feature[] getApiFeatures() {
        return zzax.zzn;
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.cast.internal.ICastService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    public final boolean usesClientTelemetry() {
        return true;
    }
}
