package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.zzax;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public final class zzx extends GmsClient {
    private static final Logger zze = new Logger("CastClientImplCxless");
    private final CastDevice zzf;
    private final long zzg;
    private final Bundle zzh;
    private final String zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzx(Context context, Looper looper, ClientSettings clientSettings, CastDevice castDevice, long j2, Bundle bundle, String str, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzf = castDevice;
        this.zzg = j2;
        this.zzh = bundle;
        this.zzi = str;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        if (queryLocalInterface instanceof zzag) {
            return (zzag) queryLocalInterface;
        }
        return new zzag(iBinder);
    }

    public final void disconnect() {
        try {
            ((zzag) getService()).zzf();
        } catch (RemoteException | IllegalStateException e2) {
            zze.d(e2, "Error while disconnecting the controller interface", new Object[0]);
        } finally {
            super.disconnect();
        }
    }

    public final Feature[] getApiFeatures() {
        return zzax.zzn;
    }

    /* access modifiers changed from: protected */
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        zze.d("getRemoteService()", new Object[0]);
        this.zzf.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzg);
        bundle.putString("connectionless_client_record_id", this.zzi);
        Bundle bundle2 = this.zzh;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        return bundle;
    }

    public final int getMinApkVersion() {
        return 19390000;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    public final boolean usesClientTelemetry() {
        return true;
    }
}
