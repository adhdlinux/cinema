package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuHostHelper {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f2750a;

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<MenuProvider> f2751b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<MenuProvider, LifecycleContainer> f2752c = new HashMap();

    private static class LifecycleContainer {

        /* renamed from: a  reason: collision with root package name */
        final Lifecycle f2753a;

        /* renamed from: b  reason: collision with root package name */
        private LifecycleEventObserver f2754b;

        LifecycleContainer(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            this.f2753a = lifecycle;
            this.f2754b = lifecycleEventObserver;
            lifecycle.a(lifecycleEventObserver);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f2753a.c(this.f2754b);
            this.f2754b = null;
        }
    }

    public MenuHostHelper(Runnable runnable) {
        this.f2750a = runnable;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            l(menuProvider);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(Lifecycle.State state, MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.d(state)) {
            c(menuProvider);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            l(menuProvider);
        } else if (event == Lifecycle.Event.a(state)) {
            this.f2751b.remove(menuProvider);
            this.f2750a.run();
        }
    }

    public void c(MenuProvider menuProvider) {
        this.f2751b.add(menuProvider);
        this.f2750a.run();
    }

    public void d(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        c(menuProvider);
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleContainer remove = this.f2752c.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.f2752c.put(menuProvider, new LifecycleContainer(lifecycle, new n(this, menuProvider)));
    }

    @SuppressLint({"LambdaLast"})
    public void e(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleContainer remove = this.f2752c.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.f2752c.put(menuProvider, new LifecycleContainer(lifecycle, new o(this, state, menuProvider)));
    }

    public void h(Menu menu, MenuInflater menuInflater) {
        Iterator<MenuProvider> it2 = this.f2751b.iterator();
        while (it2.hasNext()) {
            it2.next().d(menu, menuInflater);
        }
    }

    public void i(Menu menu) {
        Iterator<MenuProvider> it2 = this.f2751b.iterator();
        while (it2.hasNext()) {
            it2.next().a(menu);
        }
    }

    public boolean j(MenuItem menuItem) {
        Iterator<MenuProvider> it2 = this.f2751b.iterator();
        while (it2.hasNext()) {
            if (it2.next().c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void k(Menu menu) {
        Iterator<MenuProvider> it2 = this.f2751b.iterator();
        while (it2.hasNext()) {
            it2.next().b(menu);
        }
    }

    public void l(MenuProvider menuProvider) {
        this.f2751b.remove(menuProvider);
        LifecycleContainer remove = this.f2752c.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.f2750a.run();
    }
}
