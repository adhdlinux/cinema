package com.iab.omid.library.applovin.walking.a;

import com.iab.omid.library.applovin.walking.a.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue<Runnable> f31570a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadPoolExecutor f31571b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque<b> f31572c = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    private b f31573d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f31570a = linkedBlockingQueue;
        this.f31571b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void a() {
        b poll = this.f31572c.poll();
        this.f31573d = poll;
        if (poll != null) {
            poll.a(this.f31571b);
        }
    }

    public void a(b bVar) {
        this.f31573d = null;
        a();
    }

    public void b(b bVar) {
        bVar.a((b.a) this);
        this.f31572c.add(bVar);
        if (this.f31573d == null) {
            a();
        }
    }
}
