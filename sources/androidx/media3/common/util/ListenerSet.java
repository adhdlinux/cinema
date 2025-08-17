package androidx.media3.common.util;

import android.os.Looper;
import android.os.Message;
import androidx.media3.common.FlagSet;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ListenerSet<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Clock f4656a;

    /* renamed from: b  reason: collision with root package name */
    private final HandlerWrapper f4657b;

    /* renamed from: c  reason: collision with root package name */
    private final IterationFinishedEvent<T> f4658c;

    /* renamed from: d  reason: collision with root package name */
    private final CopyOnWriteArraySet<ListenerHolder<T>> f4659d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayDeque<Runnable> f4660e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayDeque<Runnable> f4661f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f4662g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4663h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4664i;

    public interface Event<T> {
        void invoke(T t2);
    }

    public interface IterationFinishedEvent<T> {
        void a(T t2, FlagSet flagSet);
    }

    private static final class ListenerHolder<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T f4665a;

        /* renamed from: b  reason: collision with root package name */
        private FlagSet.Builder f4666b = new FlagSet.Builder();

        /* renamed from: c  reason: collision with root package name */
        private boolean f4667c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f4668d;

        public ListenerHolder(T t2) {
            this.f4665a = t2;
        }

        public void a(int i2, Event<T> event) {
            if (!this.f4668d) {
                if (i2 != -1) {
                    this.f4666b.a(i2);
                }
                this.f4667c = true;
                event.invoke(this.f4665a);
            }
        }

        public void b(IterationFinishedEvent<T> iterationFinishedEvent) {
            if (!this.f4668d && this.f4667c) {
                FlagSet e2 = this.f4666b.e();
                this.f4666b = new FlagSet.Builder();
                this.f4667c = false;
                iterationFinishedEvent.a(this.f4665a, e2);
            }
        }

        public void c(IterationFinishedEvent<T> iterationFinishedEvent) {
            this.f4668d = true;
            if (this.f4667c) {
                this.f4667c = false;
                iterationFinishedEvent.a(this.f4665a, this.f4666b.e());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ListenerHolder.class != obj.getClass()) {
                return false;
            }
            return this.f4665a.equals(((ListenerHolder) obj).f4665a);
        }

        public int hashCode() {
            return this.f4665a.hashCode();
        }
    }

    public ListenerSet(Looper looper, Clock clock, IterationFinishedEvent<T> iterationFinishedEvent) {
        this(new CopyOnWriteArraySet(), looper, clock, iterationFinishedEvent, true);
    }

    /* access modifiers changed from: private */
    public boolean g(Message message) {
        Iterator<ListenerHolder<T>> it2 = this.f4659d.iterator();
        while (it2.hasNext()) {
            it2.next().b(this.f4658c);
            if (this.f4657b.b(1)) {
                break;
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
        if (this.f4664i) {
            if (Thread.currentThread() == this.f4657b.e().getThread()) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.h(z2);
        }
    }

    public void c(T t2) {
        Assertions.f(t2);
        synchronized (this.f4662g) {
            if (!this.f4663h) {
                this.f4659d.add(new ListenerHolder(t2));
            }
        }
    }

    public ListenerSet<T> d(Looper looper, Clock clock, IterationFinishedEvent<T> iterationFinishedEvent) {
        return new ListenerSet(this.f4659d, looper, clock, iterationFinishedEvent, this.f4664i);
    }

    public ListenerSet<T> e(Looper looper, IterationFinishedEvent<T> iterationFinishedEvent) {
        return d(looper, this.f4656a, iterationFinishedEvent);
    }

    public void f() {
        m();
        if (!this.f4661f.isEmpty()) {
            if (!this.f4657b.b(1)) {
                HandlerWrapper handlerWrapper = this.f4657b;
                handlerWrapper.k(handlerWrapper.a(1));
            }
            boolean z2 = !this.f4660e.isEmpty();
            this.f4660e.addAll(this.f4661f);
            this.f4661f.clear();
            if (!z2) {
                while (!this.f4660e.isEmpty()) {
                    this.f4660e.peekFirst().run();
                    this.f4660e.removeFirst();
                }
            }
        }
    }

    public void i(int i2, Event<T> event) {
        m();
        this.f4661f.add(new b(new CopyOnWriteArraySet(this.f4659d), i2, event));
    }

    public void j() {
        m();
        synchronized (this.f4662g) {
            this.f4663h = true;
        }
        Iterator<ListenerHolder<T>> it2 = this.f4659d.iterator();
        while (it2.hasNext()) {
            it2.next().c(this.f4658c);
        }
        this.f4659d.clear();
    }

    public void k(T t2) {
        m();
        Iterator<ListenerHolder<T>> it2 = this.f4659d.iterator();
        while (it2.hasNext()) {
            ListenerHolder next = it2.next();
            if (next.f4665a.equals(t2)) {
                next.c(this.f4658c);
                this.f4659d.remove(next);
            }
        }
    }

    public void l(int i2, Event<T> event) {
        i(i2, event);
        f();
    }

    private ListenerSet(CopyOnWriteArraySet<ListenerHolder<T>> copyOnWriteArraySet, Looper looper, Clock clock, IterationFinishedEvent<T> iterationFinishedEvent, boolean z2) {
        this.f4656a = clock;
        this.f4659d = copyOnWriteArraySet;
        this.f4658c = iterationFinishedEvent;
        this.f4662g = new Object();
        this.f4660e = new ArrayDeque<>();
        this.f4661f = new ArrayDeque<>();
        this.f4657b = clock.b(looper, new a(this));
        this.f4664i = z2;
    }
}
