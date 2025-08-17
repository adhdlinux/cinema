package com.google.android.exoplayer2.util;

import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.util.FlagSet;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ListenerSet<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Clock f28689a;

    /* renamed from: b  reason: collision with root package name */
    private final HandlerWrapper f28690b;

    /* renamed from: c  reason: collision with root package name */
    private final IterationFinishedEvent<T> f28691c;

    /* renamed from: d  reason: collision with root package name */
    private final CopyOnWriteArraySet<ListenerHolder<T>> f28692d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayDeque<Runnable> f28693e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayDeque<Runnable> f28694f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f28695g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f28696h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f28697i;

    public interface Event<T> {
        void invoke(T t2);
    }

    public interface IterationFinishedEvent<T> {
        void a(T t2, FlagSet flagSet);
    }

    private static final class ListenerHolder<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T f28698a;

        /* renamed from: b  reason: collision with root package name */
        private FlagSet.Builder f28699b = new FlagSet.Builder();

        /* renamed from: c  reason: collision with root package name */
        private boolean f28700c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f28701d;

        public ListenerHolder(T t2) {
            this.f28698a = t2;
        }

        public void a(int i2, Event<T> event) {
            if (!this.f28701d) {
                if (i2 != -1) {
                    this.f28699b.a(i2);
                }
                this.f28700c = true;
                event.invoke(this.f28698a);
            }
        }

        public void b(IterationFinishedEvent<T> iterationFinishedEvent) {
            if (!this.f28701d && this.f28700c) {
                FlagSet e2 = this.f28699b.e();
                this.f28699b = new FlagSet.Builder();
                this.f28700c = false;
                iterationFinishedEvent.a(this.f28698a, e2);
            }
        }

        public void c(IterationFinishedEvent<T> iterationFinishedEvent) {
            this.f28701d = true;
            if (this.f28700c) {
                this.f28700c = false;
                iterationFinishedEvent.a(this.f28698a, this.f28699b.e());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ListenerHolder.class != obj.getClass()) {
                return false;
            }
            return this.f28698a.equals(((ListenerHolder) obj).f28698a);
        }

        public int hashCode() {
            return this.f28698a.hashCode();
        }
    }

    public ListenerSet(Looper looper, Clock clock, IterationFinishedEvent<T> iterationFinishedEvent) {
        this(new CopyOnWriteArraySet(), looper, clock, iterationFinishedEvent);
    }

    /* access modifiers changed from: private */
    public boolean g(Message message) {
        Iterator<ListenerHolder<T>> it2 = this.f28692d.iterator();
        while (it2.hasNext()) {
            it2.next().b(this.f28691c);
            if (this.f28690b.b(0)) {
                return true;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void h(CopyOnWriteArraySet copyOnWriteArraySet, int i2, Event event) {
        Iterator it2 = copyOnWriteArraySet.iterator();
        while (it2.hasNext()) {
            ((ListenerHolder) it2.next()).a(i2, event);
        }
    }

    private void m() {
        boolean z2;
        if (this.f28697i) {
            if (Thread.currentThread() == this.f28690b.e().getThread()) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
        }
    }

    public void c(T t2) {
        Assertions.e(t2);
        synchronized (this.f28695g) {
            if (!this.f28696h) {
                this.f28692d.add(new ListenerHolder(t2));
            }
        }
    }

    public ListenerSet<T> d(Looper looper, Clock clock, IterationFinishedEvent<T> iterationFinishedEvent) {
        return new ListenerSet<>(this.f28692d, looper, clock, iterationFinishedEvent);
    }

    public ListenerSet<T> e(Looper looper, IterationFinishedEvent<T> iterationFinishedEvent) {
        return d(looper, this.f28689a, iterationFinishedEvent);
    }

    public void f() {
        m();
        if (!this.f28694f.isEmpty()) {
            if (!this.f28690b.b(0)) {
                HandlerWrapper handlerWrapper = this.f28690b;
                handlerWrapper.k(handlerWrapper.a(0));
            }
            boolean z2 = !this.f28693e.isEmpty();
            this.f28693e.addAll(this.f28694f);
            this.f28694f.clear();
            if (!z2) {
                while (!this.f28693e.isEmpty()) {
                    this.f28693e.peekFirst().run();
                    this.f28693e.removeFirst();
                }
            }
        }
    }

    public void i(int i2, Event<T> event) {
        m();
        this.f28694f.add(new b(new CopyOnWriteArraySet(this.f28692d), i2, event));
    }

    public void j() {
        m();
        synchronized (this.f28695g) {
            this.f28696h = true;
        }
        Iterator<ListenerHolder<T>> it2 = this.f28692d.iterator();
        while (it2.hasNext()) {
            it2.next().c(this.f28691c);
        }
        this.f28692d.clear();
    }

    public void k(T t2) {
        m();
        Iterator<ListenerHolder<T>> it2 = this.f28692d.iterator();
        while (it2.hasNext()) {
            ListenerHolder next = it2.next();
            if (next.f28698a.equals(t2)) {
                next.c(this.f28691c);
                this.f28692d.remove(next);
            }
        }
    }

    public void l(int i2, Event<T> event) {
        i(i2, event);
        f();
    }

    private ListenerSet(CopyOnWriteArraySet<ListenerHolder<T>> copyOnWriteArraySet, Looper looper, Clock clock, IterationFinishedEvent<T> iterationFinishedEvent) {
        this.f28689a = clock;
        this.f28692d = copyOnWriteArraySet;
        this.f28691c = iterationFinishedEvent;
        this.f28695g = new Object();
        this.f28693e = new ArrayDeque<>();
        this.f28694f = new ArrayDeque<>();
        this.f28690b = clock.b(looper, new a(this));
        this.f28697i = true;
    }
}
