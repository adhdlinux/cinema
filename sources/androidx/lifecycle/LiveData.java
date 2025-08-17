package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.util.Map;

public abstract class LiveData<T> {

    /* renamed from: k  reason: collision with root package name */
    static final Object f3686k = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Object f3687a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> f3688b = new SafeIterableMap<>();

    /* renamed from: c  reason: collision with root package name */
    int f3689c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3690d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Object f3691e;

    /* renamed from: f  reason: collision with root package name */
    volatile Object f3692f;

    /* renamed from: g  reason: collision with root package name */
    private int f3693g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3694h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3695i;

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f3696j;

    private class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        AlwaysActiveObserver(Observer<? super T> observer) {
            super(observer);
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return true;
        }
    }

    class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {

        /* renamed from: f  reason: collision with root package name */
        final LifecycleOwner f3699f;

        LifecycleBoundObserver(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
            super(observer);
            this.f3699f = lifecycleOwner;
        }

        /* access modifiers changed from: package-private */
        public void h() {
            this.f3699f.getLifecycle().c(this);
        }

        /* access modifiers changed from: package-private */
        public boolean i(LifecycleOwner lifecycleOwner) {
            return this.f3699f == lifecycleOwner;
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return this.f3699f.getLifecycle().b().a(Lifecycle.State.STARTED);
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State b2 = this.f3699f.getLifecycle().b();
            if (b2 == Lifecycle.State.DESTROYED) {
                LiveData.this.m(this.f3701b);
                return;
            }
            Lifecycle.State state = null;
            while (state != b2) {
                g(j());
                state = b2;
                b2 = this.f3699f.getLifecycle().b();
            }
        }
    }

    private abstract class ObserverWrapper {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f3701b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3702c;

        /* renamed from: d  reason: collision with root package name */
        int f3703d = -1;

        ObserverWrapper(Observer<? super T> observer) {
            this.f3701b = observer;
        }

        /* access modifiers changed from: package-private */
        public void g(boolean z2) {
            int i2;
            if (z2 != this.f3702c) {
                this.f3702c = z2;
                LiveData liveData = LiveData.this;
                if (z2) {
                    i2 = 1;
                } else {
                    i2 = -1;
                }
                liveData.c(i2);
                if (this.f3702c) {
                    LiveData.this.e(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
        }

        /* access modifiers changed from: package-private */
        public boolean i(LifecycleOwner lifecycleOwner) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract boolean j();
    }

    public LiveData() {
        Object obj = f3686k;
        this.f3692f = obj;
        this.f3696j = new Runnable() {
            public void run() {
                Object obj;
                synchronized (LiveData.this.f3687a) {
                    obj = LiveData.this.f3692f;
                    LiveData.this.f3692f = LiveData.f3686k;
                }
                LiveData.this.n(obj);
            }
        };
        this.f3691e = obj;
        this.f3693g = -1;
    }

    static void b(String str) {
        if (!ArchTaskExecutor.e().b()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    private void d(LiveData<T>.ObserverWrapper observerWrapper) {
        if (observerWrapper.f3702c) {
            if (!observerWrapper.j()) {
                observerWrapper.g(false);
                return;
            }
            int i2 = observerWrapper.f3703d;
            int i3 = this.f3693g;
            if (i2 < i3) {
                observerWrapper.f3703d = i3;
                observerWrapper.f3701b.a(this.f3691e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        boolean z2;
        boolean z3;
        int i3 = this.f3689c;
        this.f3689c = i2 + i3;
        if (!this.f3690d) {
            this.f3690d = true;
            while (true) {
                try {
                    int i4 = this.f3689c;
                    if (i3 != i4) {
                        if (i3 != 0 || i4 <= 0) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (i3 <= 0 || i4 != 0) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (z2) {
                            j();
                        } else if (z3) {
                            k();
                        }
                        i3 = i4;
                    } else {
                        return;
                    }
                } finally {
                    this.f3690d = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(LiveData<T>.ObserverWrapper observerWrapper) {
        if (this.f3694h) {
            this.f3695i = true;
            return;
        }
        this.f3694h = true;
        do {
            this.f3695i = false;
            if (observerWrapper == null) {
                SafeIterableMap<K, V>.IteratorWithAdditions c2 = this.f3688b.c();
                while (c2.hasNext()) {
                    d((ObserverWrapper) ((Map.Entry) c2.next()).getValue());
                    if (this.f3695i) {
                        break;
                    }
                }
            } else {
                d(observerWrapper);
                observerWrapper = null;
            }
        } while (this.f3695i);
        this.f3694h = false;
    }

    public T f() {
        T t2 = this.f3691e;
        if (t2 != f3686k) {
            return t2;
        }
        return null;
    }

    public boolean g() {
        return this.f3689c > 0;
    }

    public void h(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        b("observe");
        if (lifecycleOwner.getLifecycle().b() != Lifecycle.State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
            ObserverWrapper g2 = this.f3688b.g(observer, lifecycleBoundObserver);
            if (g2 != null && !g2.i(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (g2 == null) {
                lifecycleOwner.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    public void i(Observer<? super T> observer) {
        b("observeForever");
        AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(observer);
        ObserverWrapper g2 = this.f3688b.g(observer, alwaysActiveObserver);
        if (g2 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (g2 == null) {
            alwaysActiveObserver.g(true);
        }
    }

    /* access modifiers changed from: protected */
    public void j() {
    }

    /* access modifiers changed from: protected */
    public void k() {
    }

    /* access modifiers changed from: protected */
    public void l(T t2) {
        boolean z2;
        synchronized (this.f3687a) {
            if (this.f3692f == f3686k) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f3692f = t2;
        }
        if (z2) {
            ArchTaskExecutor.e().c(this.f3696j);
        }
    }

    public void m(Observer<? super T> observer) {
        b("removeObserver");
        ObserverWrapper h2 = this.f3688b.h(observer);
        if (h2 != null) {
            h2.h();
            h2.g(false);
        }
    }

    /* access modifiers changed from: protected */
    public void n(T t2) {
        b("setValue");
        this.f3693g++;
        this.f3691e = t2;
        e((LiveData<T>.ObserverWrapper) null);
    }
}
