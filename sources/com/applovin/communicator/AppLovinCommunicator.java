package com.applovin.communicator;

import android.content.Context;
import com.applovin.impl.communicator.MessagingServiceImpl;
import com.applovin.impl.communicator.a;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;
import java.util.Collections;
import java.util.List;

public final class AppLovinCommunicator {

    /* renamed from: a  reason: collision with root package name */
    private static AppLovinCommunicator f13713a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f13714b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private m f13715c;

    /* renamed from: d  reason: collision with root package name */
    private v f13716d;

    /* renamed from: e  reason: collision with root package name */
    private final a f13717e;

    /* renamed from: f  reason: collision with root package name */
    private final MessagingServiceImpl f13718f;

    private AppLovinCommunicator(Context context) {
        this.f13717e = new a(context);
        this.f13718f = new MessagingServiceImpl(context);
    }

    private void a(String str) {
        v vVar = this.f13716d;
        if (vVar != null) {
            vVar.b("AppLovinCommunicator", str);
        }
    }

    public static AppLovinCommunicator getInstance(Context context) {
        synchronized (f13714b) {
            if (f13713a == null) {
                f13713a = new AppLovinCommunicator(context.getApplicationContext());
            }
        }
        return f13713a;
    }

    public void a(m mVar) {
        this.f13715c = mVar;
        this.f13716d = mVar.A();
        if (v.a()) {
            a("Attached SDK instance: " + mVar + "...");
        }
    }

    public AppLovinCommunicatorMessagingService getMessagingService() {
        return this.f13718f;
    }

    public boolean hasSubscriber(String str) {
        return this.f13717e.a(str);
    }

    public boolean respondsToTopic(String str) {
        return this.f13715c.ag().a(str);
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        subscribe(appLovinCommunicatorSubscriber, (List<String>) Collections.singletonList(str));
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String next : list) {
            if (this.f13717e.a(appLovinCommunicatorSubscriber, next)) {
                this.f13718f.maybeFlushStickyMessages(next);
            } else if (v.a()) {
                a("Unable to subscribe " + appLovinCommunicatorSubscriber + " to topic: " + next);
            }
        }
    }

    public String toString() {
        return "AppLovinCommunicator{sdk=" + this.f13715c + '}';
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        unsubscribe(appLovinCommunicatorSubscriber, (List<String>) Collections.singletonList(str));
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String next : list) {
            if (v.a()) {
                a("Unsubscribing " + appLovinCommunicatorSubscriber + " from topic: " + next);
            }
            this.f13717e.b(appLovinCommunicatorSubscriber, next);
        }
    }
}
