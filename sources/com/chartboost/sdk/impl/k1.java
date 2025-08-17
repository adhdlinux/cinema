package com.chartboost.sdk.impl;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class k1 implements Comparable {

    /* renamed from: b  reason: collision with root package name */
    public final gb f18002b;

    /* renamed from: c  reason: collision with root package name */
    public final i9 f18003c;

    /* renamed from: d  reason: collision with root package name */
    public final String f18004d;

    /* renamed from: e  reason: collision with root package name */
    public final String f18005e;

    /* renamed from: f  reason: collision with root package name */
    public final String f18006f;

    /* renamed from: g  reason: collision with root package name */
    public final String f18007g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicInteger f18008h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicReference f18009i;

    /* renamed from: j  reason: collision with root package name */
    public final long f18010j;

    /* renamed from: k  reason: collision with root package name */
    public final AtomicInteger f18011k;

    public k1(gb gbVar, i9 i9Var, String str, String str2, String str3, AtomicInteger atomicInteger, AtomicReference atomicReference, long j2, AtomicInteger atomicInteger2, String str4) {
        this.f18002b = gbVar;
        this.f18003c = i9Var;
        this.f18004d = str;
        this.f18005e = str2;
        this.f18006f = str3;
        this.f18008h = atomicInteger;
        this.f18009i = atomicReference;
        this.f18010j = j2;
        this.f18011k = atomicInteger2;
        this.f18007g = str4;
        atomicInteger.incrementAndGet();
    }

    /* renamed from: a */
    public int compareTo(k1 k1Var) {
        return this.f18003c.b() - k1Var.f18003c.b();
    }

    public void a(Executor executor, boolean z2) {
        g1 g1Var;
        if ((this.f18008h.decrementAndGet() == 0 || !z2) && (g1Var = (g1) this.f18009i.getAndSet((Object) null)) != null) {
            executor.execute(new h1(g1Var, z2, (int) TimeUnit.NANOSECONDS.toMillis(this.f18002b.b() - this.f18010j), this.f18011k.get()));
        }
    }
}
