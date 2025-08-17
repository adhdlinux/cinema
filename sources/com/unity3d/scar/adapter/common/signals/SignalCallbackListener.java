package com.unity3d.scar.adapter.common.signals;

import com.unity3d.scar.adapter.common.DispatchGroup;

public class SignalCallbackListener<T> implements ISignalCallbackListener<T> {

    /* renamed from: a  reason: collision with root package name */
    private DispatchGroup f37059a;

    /* renamed from: b  reason: collision with root package name */
    private SignalsStorage<T> f37060b;

    /* renamed from: c  reason: collision with root package name */
    private SignalsResult f37061c;

    public SignalCallbackListener(DispatchGroup dispatchGroup, SignalsResult signalsResult) {
        this(dispatchGroup, (SignalsStorage) null, signalsResult);
    }

    public void a(String str, String str2, T t2) {
        this.f37061c.a(str, str2);
        SignalsStorage<T> signalsStorage = this.f37060b;
        if (signalsStorage != null) {
            signalsStorage.b(str, t2);
        }
        this.f37059a.b();
    }

    public void onFailure(String str) {
        this.f37061c.d(str);
        this.f37059a.b();
    }

    public SignalCallbackListener(DispatchGroup dispatchGroup, SignalsStorage<T> signalsStorage, SignalsResult signalsResult) {
        this.f37059a = dispatchGroup;
        this.f37060b = signalsStorage;
        this.f37061c = signalsResult;
    }
}
