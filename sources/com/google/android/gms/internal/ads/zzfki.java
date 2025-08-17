package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.internal.BaseGmsClient;

public final class zzfki extends zzc {
    private final int zze;

    public zzfki(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener, int i2) {
        super(context, looper, 116, baseConnectionCallbacks, baseOnConnectionFailedListener, (String) null);
        this.zze = i2;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
        if (queryLocalInterface instanceof zzfkn) {
            return (zzfkn) queryLocalInterface;
        }
        return new zzfkn(iBinder);
    }

    public final int getMinApkVersion() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.gass.START";
    }

    public final zzfkn zzp() throws DeadObjectException {
        return (zzfkn) super.getService();
    }
}
