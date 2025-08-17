package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {
    private final ListenerHolder zaa;
    private final Feature[] zab;
    private final boolean zac;
    private final int zad;

    @KeepForSdk
    protected RegisterListenerMethod(ListenerHolder<L> listenerHolder) {
        this(listenerHolder, (Feature[]) null, false, 0);
    }

    @KeepForSdk
    protected RegisterListenerMethod(ListenerHolder<L> listenerHolder, Feature[] featureArr, boolean z2, int i2) {
        this.zaa = listenerHolder;
        this.zab = featureArr;
        this.zac = z2;
        this.zad = i2;
    }

    @KeepForSdk
    public void clearListener() {
        this.zaa.clear();
    }

    @KeepForSdk
    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.zaa.getListenerKey();
    }

    @KeepForSdk
    public Feature[] getRequiredFeatures() {
        return this.zab;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract void registerListener(A a2, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    public final int zaa() {
        return this.zad;
    }

    public final boolean zab() {
        return this.zac;
    }

    @KeepForSdk
    protected RegisterListenerMethod(ListenerHolder<L> listenerHolder, Feature[] featureArr, boolean z2) {
        this(listenerHolder, featureArr, z2, 0);
    }
}
