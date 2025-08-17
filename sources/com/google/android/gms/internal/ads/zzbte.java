package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.internal.BaseGmsClient;

public final class zzbte extends zzc {
    public zzbte(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(zzbus.zza(context), looper, 8, baseConnectionCallbacks, baseOnConnectionFailedListener, (String) null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (queryLocalInterface instanceof zzbtq) {
            return (zzbtq) queryLocalInterface;
        }
        return new zzbto(iBinder);
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.START";
    }

    public final zzbtq zzp() throws DeadObjectException {
        return (zzbtq) super.getService();
    }
}
