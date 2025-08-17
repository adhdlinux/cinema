package com.iab.omid.library.adcolony.walking.a;

import com.iab.omid.library.adcolony.walking.a.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue<Runnable> f31453a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadPoolExecutor f31454b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque<b> f31455c = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    private b f31456d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f31453a = linkedBlockingQueue;
        this.f31454b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void b() {
        b poll = this.f31455c.poll();
        this.f31456d = poll;
        if (poll != null) {
            poll.c(this.f31454b);
        }
    }

    public void a(b bVar) {
        this.f31456d = null;
        b();
    }

    public void c(b bVar) {
        bVar.a(this);
        this.f31455c.add(bVar);
        if (this.f31456d == null) {
            b();
        }
    }
}
