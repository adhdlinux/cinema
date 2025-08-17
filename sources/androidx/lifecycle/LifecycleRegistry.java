package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class LifecycleRegistry extends Lifecycle {

    /* renamed from: b  reason: collision with root package name */
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> f3672b;

    /* renamed from: c  reason: collision with root package name */
    private Lifecycle.State f3673c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakReference<LifecycleOwner> f3674d;

    /* renamed from: e  reason: collision with root package name */
    private int f3675e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3676f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3677g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<Lifecycle.State> f3678h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f3679i;

    static class ObserverWithState {

        /* renamed from: a  reason: collision with root package name */
        Lifecycle.State f3680a;

        /* renamed from: b  reason: collision with root package name */
        LifecycleEventObserver f3681b;

        ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            this.f3681b = Lifecycling.f(lifecycleObserver);
            this.f3680a = state;
        }

        /* access modifiers changed from: package-private */
        public void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State b2 = event.b();
            this.f3680a = LifecycleRegistry.k(this.f3680a, b2);
            this.f3681b.onStateChanged(lifecycleOwner, event);
            this.f3680a = b2;
        }
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, true);
    }

    private void d(LifecycleOwner lifecycleOwner) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> descendingIterator = this.f3672b.descendingIterator();
        while (descendingIterator.hasNext() && !this.f3677g) {
            Map.Entry next = descendingIterator.next();
            ObserverWithState observerWithState = (ObserverWithState) next.getValue();
            while (observerWithState.f3680a.compareTo(this.f3673c) > 0 && !this.f3677g && this.f3672b.contains((LifecycleObserver) next.getKey())) {
                Lifecycle.Event a2 = Lifecycle.Event.a(observerWithState.f3680a);
                if (a2 != null) {
                    n(a2.b());
                    observerWithState.a(lifecycleOwner, a2);
                    m();
                } else {
                    throw new IllegalStateException("no event down from " + observerWithState.f3680a);
                }
            }
        }
    }

    private Lifecycle.State e(LifecycleObserver lifecycleObserver) {
        Lifecycle.State state;
        Map.Entry<LifecycleObserver, ObserverWithState> i2 = this.f3672b.i(lifecycleObserver);
        Lifecycle.State state2 = null;
        if (i2 != null) {
            state = i2.getValue().f3680a;
        } else {
            state = null;
        }
        if (!this.f3678h.isEmpty()) {
            ArrayList<Lifecycle.State> arrayList = this.f3678h;
            state2 = arrayList.get(arrayList.size() - 1);
        }
        return k(k(this.f3673c, state), state2);
    }

    @SuppressLint({"RestrictedApi"})
    private void f(String str) {
        if (this.f3679i && !ArchTaskExecutor.e().b()) {
            throw new IllegalStateException("Method " + str + " must be called on the main thread");
        }
    }

    private void g(LifecycleOwner lifecycleOwner) {
        SafeIterableMap<K, V>.IteratorWithAdditions c2 = this.f3672b.c();
        while (c2.hasNext() && !this.f3677g) {
            Map.Entry entry = (Map.Entry) c2.next();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.f3680a.compareTo(this.f3673c) < 0 && !this.f3677g && this.f3672b.contains((LifecycleObserver) entry.getKey())) {
                n(observerWithState.f3680a);
                Lifecycle.Event c3 = Lifecycle.Event.c(observerWithState.f3680a);
                if (c3 != null) {
                    observerWithState.a(lifecycleOwner, c3);
                    m();
                } else {
                    throw new IllegalStateException("no event up from " + observerWithState.f3680a);
                }
            }
        }
    }

    private boolean i() {
        if (this.f3672b.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.f3672b.a().getValue().f3680a;
        Lifecycle.State state2 = this.f3672b.d().getValue().f3680a;
        if (state == state2 && this.f3673c == state2) {
            return true;
        }
        return false;
    }

    static Lifecycle.State k(Lifecycle.State state, Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    private void l(Lifecycle.State state) {
        Lifecycle.State state2 = this.f3673c;
        if (state2 != state) {
            if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
                throw new IllegalStateException("no event down from " + this.f3673c);
            }
            this.f3673c = state;
            if (this.f3676f || this.f3675e != 0) {
                this.f3677g = true;
                return;
            }
            this.f3676f = true;
            p();
            this.f3676f = false;
            if (this.f3673c == Lifecycle.State.DESTROYED) {
                this.f3672b = new FastSafeIterableMap<>();
            }
        }
    }

    private void m() {
        ArrayList<Lifecycle.State> arrayList = this.f3678h;
        arrayList.remove(arrayList.size() - 1);
    }

    private void n(Lifecycle.State state) {
        this.f3678h.add(state);
    }

    private void p() {
        LifecycleOwner lifecycleOwner = this.f3674d.get();
        if (lifecycleOwner != null) {
            while (!i()) {
                this.f3677g = false;
                if (this.f3673c.compareTo(this.f3672b.a().getValue().f3680a) < 0) {
                    d(lifecycleOwner);
                }
                Map.Entry<LifecycleObserver, ObserverWithState> d2 = this.f3672b.d();
                if (!this.f3677g && d2 != null && this.f3673c.compareTo(d2.getValue().f3680a) > 0) {
                    g(lifecycleOwner);
                }
            }
            this.f3677g = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    public void a(LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        boolean z2;
        f("addObserver");
        Lifecycle.State state = this.f3673c;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, state2);
        if (this.f3672b.g(lifecycleObserver, observerWithState) == null && (lifecycleOwner = this.f3674d.get()) != null) {
            if (this.f3675e != 0 || this.f3676f) {
                z2 = true;
            } else {
                z2 = false;
            }
            Lifecycle.State e2 = e(lifecycleObserver);
            this.f3675e++;
            while (observerWithState.f3680a.compareTo(e2) < 0 && this.f3672b.contains(lifecycleObserver)) {
                n(observerWithState.f3680a);
                Lifecycle.Event c2 = Lifecycle.Event.c(observerWithState.f3680a);
                if (c2 != null) {
                    observerWithState.a(lifecycleOwner, c2);
                    m();
                    e2 = e(lifecycleObserver);
                } else {
                    throw new IllegalStateException("no event up from " + observerWithState.f3680a);
                }
            }
            if (!z2) {
                p();
            }
            this.f3675e--;
        }
    }

    public Lifecycle.State b() {
        return this.f3673c;
    }

    public void c(LifecycleObserver lifecycleObserver) {
        f("removeObserver");
        this.f3672b.h(lifecycleObserver);
    }

    public void h(Lifecycle.Event event) {
        f("handleLifecycleEvent");
        l(event.b());
    }

    @Deprecated
    public void j(Lifecycle.State state) {
        f("markState");
        o(state);
    }

    public void o(Lifecycle.State state) {
        f("setCurrentState");
        l(state);
    }

    private LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean z2) {
        this.f3672b = new FastSafeIterableMap<>();
        this.f3675e = 0;
        this.f3676f = false;
        this.f3677g = false;
        this.f3678h = new ArrayList<>();
        this.f3674d = new WeakReference<>(lifecycleOwner);
        this.f3673c = Lifecycle.State.INITIALIZED;
        this.f3679i = z2;
    }
}
