package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.ge;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class oe implements ge.a {

    /* renamed from: a  reason: collision with root package name */
    public final BlockingQueue f18318a;

    /* renamed from: b  reason: collision with root package name */
    public final ThreadPoolExecutor f18319b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayDeque f18320c = new ArrayDeque();

    /* renamed from: d  reason: collision with root package name */
    public ge f18321d = null;

    public oe() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f18318a = linkedBlockingQueue;
        this.f18319b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    public final void a() {
        ge geVar = (ge) this.f18320c.poll();
        this.f18321d = geVar;
        if (geVar != null) {
            geVar.a(this.f18319b);
        }
    }

    public void b(ge geVar) {
        geVar.a((ge.a) this);
        this.f18320c.add(geVar);
        if (this.f18321d == null) {
            a();
        }
    }

    public void a(ge geVar) {
        this.f18321d = null;
        a();
    }
}
