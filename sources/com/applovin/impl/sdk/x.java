package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import java.util.LinkedList;
import java.util.Queue;

class x {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<AppLovinAdImpl> f15939a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    private final Object f15940b = new Object();

    x() {
    }

    /* access modifiers changed from: package-private */
    public int a() {
        int size;
        synchronized (this.f15940b) {
            size = this.f15939a.size();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    public void a(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.f15940b) {
            if (a() <= 25) {
                this.f15939a.offer(appLovinAdImpl);
            } else if (v.a()) {
                v.i("AppLovinSdk", "Maximum queue capacity reached - discarding ad...");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        boolean z2;
        synchronized (this.f15940b) {
            z2 = a() == 0;
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public AppLovinAdImpl c() {
        AppLovinAdImpl poll;
        synchronized (this.f15940b) {
            poll = !b() ? this.f15939a.poll() : null;
        }
        return poll;
    }

    /* access modifiers changed from: package-private */
    public AppLovinAdImpl d() {
        AppLovinAdImpl peek;
        synchronized (this.f15940b) {
            peek = this.f15939a.peek();
        }
        return peek;
    }
}
