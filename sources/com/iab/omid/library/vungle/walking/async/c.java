package com.iab.omid.library.vungle.walking.async;

import com.iab.omid.library.vungle.walking.async.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue<Runnable> f31790a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadPoolExecutor f31791b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque<b> f31792c = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    private b f31793d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f31790a = linkedBlockingQueue;
        this.f31791b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void b() {
        b poll = this.f31792c.poll();
        this.f31793d = poll;
        if (poll != null) {
            poll.c(this.f31791b);
        }
    }

    public void a(b bVar) {
        this.f31793d = null;
        b();
    }

    public void c(b bVar) {
        bVar.a(this);
        this.f31792c.add(bVar);
        if (this.f31793d == null) {
            b();
        }
    }
}
