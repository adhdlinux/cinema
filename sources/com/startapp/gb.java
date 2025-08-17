package com.startapp;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

public class gb implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<Runnable> f34589a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    public final Executor f34590b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f34591c;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f34592a;

        public a(Runnable runnable) {
            this.f34592a = runnable;
        }

        public void run() {
            try {
                this.f34592a.run();
            } finally {
                gb.this.a();
            }
        }
    }

    public gb(Executor executor) {
        this.f34590b = executor;
    }

    public synchronized void a() {
        Runnable poll = this.f34589a.poll();
        this.f34591c = poll;
        if (poll != null) {
            this.f34590b.execute(poll);
        }
    }

    public synchronized void execute(Runnable runnable) {
        this.f34589a.offer(new a(runnable));
        if (this.f34591c == null) {
            a();
        }
    }
}
