package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class FragmentLifecycleCallbacksDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> f3407a = new CopyOnWriteArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final FragmentManager f3408b;

    private static final class FragmentLifecycleCallbacksHolder {

        /* renamed from: a  reason: collision with root package name */
        final FragmentManager.FragmentLifecycleCallbacks f3409a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f3410b;

        FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z2) {
            this.f3409a = fragmentLifecycleCallbacks;
            this.f3410b = z2;
        }
    }

    FragmentLifecycleCallbacksDispatcher(FragmentManager fragmentManager) {
        this.f3408b = fragmentManager;
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment x02 = this.f3408b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().a(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f3407a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z2 || next.f3410b) {
                next.f3409a.a(this.f3408b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment, boolean z2) {
        Context f2 = this.f3408b.u0().f();
        Fragment x02 = this.f3408b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().b(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f3407a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z2 || next.f3410b) {
                next.f3409a.b(this.f3408b, fragment, f2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment x02 = this.f3408b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().c(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f3407a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z2 || next.f3410b) {
                next.f3409a.c(this.f3408b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Fragment fragment, boolean z2) {
        Fragment x02 = this.f3408b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().d(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f3407a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z2 || next.f3410b) {
                next.f3409a.d(this.f3408b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(Fragment fragment, boolean z2) {
        Fragment x02 = this.f3408b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().e(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f3407a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z2 || next.f3410b) {
                next.f3409a.e(this.f3408b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment, boolean z2) {
        Fragment x02 = this.f3408b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().f(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f3407a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z2 || next.f3410b) {
                next.f3409a.f(this.f3408b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(Fragment fragment, boolean z2) {
        Context f2 = this.f3408b.u0().f();
        Fragment x02 = this.f3408b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().g(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f3407a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z2 || next.f3410b) {
                next.f3409a.g(this.f3408b, fragment, f2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment x02 = this.f3408b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().h(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f3407a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z2 || next.f3410b) {
                next.f3409a.h(this.f3408b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i(Fragment fragment, boolean z2) {
        Fragment x02 = this.f3408b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().i(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f3407a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z2 || next.f3410b) {
                next.f3409a.i(this.f3408b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment x02 = this.f3408b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().j(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f3407a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z2 || next.f3410b) {
                next.f3409a.j(this.f3408b, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k(Fragment fragment, boolean z2) {
        Fragment x02 = this.f3408b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().k(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f3407a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z2 || next.f3410b) {
                next.f3409a.k(this.f3408b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l(Fragment fragment, boolean z2) {
        Fragment x02 = this.f3408b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().l(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f3407a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z2 || next.f3410b) {
                next.f3409a.l(this.f3408b, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m(Fragment fragment, View view, Bundle bundle, boolean z2) {
        Fragment x02 = this.f3408b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().m(fragment, view, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f3407a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z2 || next.f3410b) {
                next.f3409a.m(this.f3408b, fragment, view, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void n(Fragment fragment, boolean z2) {
        Fragment x02 = this.f3408b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().n(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it2 = this.f3407a.iterator();
        while (it2.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it2.next();
            if (!z2 || next.f3410b) {
                next.f3409a.n(this.f3408b, fragment);
            }
        }
    }

    public void o(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z2) {
        this.f3407a.add(new FragmentLifecycleCallbacksHolder(fragmentLifecycleCallbacks, z2));
    }

    public void p(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        synchronized (this.f3407a) {
            int size = this.f3407a.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (this.f3407a.get(i2).f3409a == fragmentLifecycleCallbacks) {
                    this.f3407a.remove(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
    }
}
