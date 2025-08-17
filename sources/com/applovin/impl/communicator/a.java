package com.applovin.impl.communicator;

import android.content.Context;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashSet;
import java.util.Set;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14150a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<b> f14151b = new HashSet(32);

    /* renamed from: c  reason: collision with root package name */
    private final Object f14152c = new Object();

    public a(Context context) {
        this.f14150a = context;
    }

    private b a(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        for (b next : this.f14151b) {
            if (str.equals(next.a()) && appLovinCommunicatorSubscriber.equals(next.b())) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0054, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.applovin.communicator.AppLovinCommunicatorSubscriber r7, java.lang.String r8) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x0072
            boolean r0 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r8)
            if (r0 != 0) goto L_0x0009
            goto L_0x0072
        L_0x0009:
            java.lang.Object r0 = r6.f14152c
            monitor-enter(r0)
            com.applovin.impl.communicator.b r1 = r6.a((java.lang.String) r8, (com.applovin.communicator.AppLovinCommunicatorSubscriber) r7)     // Catch:{ all -> 0x006f }
            r2 = 1
            if (r1 == 0) goto L_0x0055
            boolean r3 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x006f }
            if (r3 == 0) goto L_0x003c
            java.lang.String r3 = "AppLovinCommunicator"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r4.<init>()     // Catch:{ all -> 0x006f }
            java.lang.String r5 = "Attempting to re-subscribe subscriber ("
            r4.append(r5)     // Catch:{ all -> 0x006f }
            r4.append(r7)     // Catch:{ all -> 0x006f }
            java.lang.String r7 = ") to topic ("
            r4.append(r7)     // Catch:{ all -> 0x006f }
            r4.append(r8)     // Catch:{ all -> 0x006f }
            java.lang.String r7 = ")"
            r4.append(r7)     // Catch:{ all -> 0x006f }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x006f }
            com.applovin.impl.sdk.v.i(r3, r7)     // Catch:{ all -> 0x006f }
        L_0x003c:
            boolean r7 = r1.c()     // Catch:{ all -> 0x006f }
            if (r7 != 0) goto L_0x0053
            r1.a(r2)     // Catch:{ all -> 0x006f }
            android.content.Context r7 = r6.f14150a     // Catch:{ all -> 0x006f }
            com.applovin.impl.sdk.AppLovinBroadcastManager r7 = com.applovin.impl.sdk.AppLovinBroadcastManager.getInstance(r7)     // Catch:{ all -> 0x006f }
            android.content.IntentFilter r3 = new android.content.IntentFilter     // Catch:{ all -> 0x006f }
            r3.<init>(r8)     // Catch:{ all -> 0x006f }
            r7.registerReceiver(r1, r3)     // Catch:{ all -> 0x006f }
        L_0x0053:
            monitor-exit(r0)     // Catch:{ all -> 0x006f }
            return r2
        L_0x0055:
            com.applovin.impl.communicator.b r1 = new com.applovin.impl.communicator.b     // Catch:{ all -> 0x006f }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x006f }
            java.util.Set<com.applovin.impl.communicator.b> r7 = r6.f14151b     // Catch:{ all -> 0x006f }
            r7.add(r1)     // Catch:{ all -> 0x006f }
            monitor-exit(r0)     // Catch:{ all -> 0x006f }
            android.content.Context r7 = r6.f14150a
            com.applovin.impl.sdk.AppLovinBroadcastManager r7 = com.applovin.impl.sdk.AppLovinBroadcastManager.getInstance(r7)
            android.content.IntentFilter r0 = new android.content.IntentFilter
            r0.<init>(r8)
            r7.registerReceiver(r1, r0)
            return r2
        L_0x006f:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006f }
            throw r7
        L_0x0072:
            boolean r0 = com.applovin.impl.sdk.v.a()
            if (r0 == 0) goto L_0x009b
            java.lang.String r0 = "AppLovinCommunicator"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to subscribe - invalid subscriber ("
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = ") or topic ("
            r1.append(r7)
            r1.append(r8)
            java.lang.String r7 = ")"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.applovin.impl.sdk.v.i(r0, r7)
        L_0x009b:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.communicator.a.a(com.applovin.communicator.AppLovinCommunicatorSubscriber, java.lang.String):boolean");
    }

    public boolean a(String str) {
        synchronized (this.f14152c) {
            for (b a2 : this.f14151b) {
                if (str.equals(a2.a())) {
                    return true;
                }
            }
            return false;
        }
    }

    public void b(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        b a2;
        if (StringUtils.isValidString(str)) {
            synchronized (this.f14152c) {
                a2 = a(str, appLovinCommunicatorSubscriber);
            }
            if (a2 != null) {
                a2.a(false);
                AppLovinBroadcastManager.getInstance(this.f14150a).unregisterReceiver(a2);
            }
        }
    }
}
