package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.BaseGmsClient;

public abstract class zzc extends BaseGmsClient {
    protected zzc(Context context, Looper looper, int i2, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        super(context, looper, i2, baseConnectionCallbacks, baseOnConnectionFailedListener, (String) null);
    }
}
