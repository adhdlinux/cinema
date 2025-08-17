package com.applovin.impl.communicator;

import android.content.Context;
import android.content.Intent;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.v;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class b implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a  reason: collision with root package name */
    private boolean f14153a = true;

    /* renamed from: b  reason: collision with root package name */
    private final String f14154b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<AppLovinCommunicatorSubscriber> f14155c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<CommunicatorMessageImpl> f14156d = new LinkedHashSet();

    /* renamed from: e  reason: collision with root package name */
    private final Object f14157e = new Object();

    b(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        this.f14154b = str;
        this.f14155c = new WeakReference<>(appLovinCommunicatorSubscriber);
    }

    public String a() {
        return this.f14154b;
    }

    public void a(boolean z2) {
        this.f14153a = z2;
    }

    public AppLovinCommunicatorSubscriber b() {
        return this.f14155c.get();
    }

    public boolean c() {
        return this.f14153a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber = this.f14155c.get();
        b bVar = (b) obj;
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber2 = bVar.f14155c.get();
        if (a().equals(bVar.a())) {
            if (appLovinCommunicatorSubscriber != null) {
                if (appLovinCommunicatorSubscriber.equals(appLovinCommunicatorSubscriber2)) {
                    return true;
                }
            } else if (appLovinCommunicatorSubscriber == appLovinCommunicatorSubscriber2) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f14154b.hashCode();
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber = this.f14155c.get();
        return (hashCode * 31) + (appLovinCommunicatorSubscriber != null ? appLovinCommunicatorSubscriber.hashCode() : 0);
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        boolean z2;
        if (b() != null) {
            CommunicatorMessageImpl communicatorMessageImpl = (CommunicatorMessageImpl) intent;
            synchronized (this.f14157e) {
                if (!this.f14156d.contains(communicatorMessageImpl)) {
                    this.f14156d.add(communicatorMessageImpl);
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                b().onMessageReceived((AppLovinCommunicatorMessage) communicatorMessageImpl);
            }
        } else if (v.a()) {
            v.i("AppLovinCommunicator", "Message received for GC'd subscriber");
        }
    }
}
