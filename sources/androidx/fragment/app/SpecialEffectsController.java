package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

abstract class SpecialEffectsController {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f3615a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<Operation> f3616b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<Operation> f3617c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    boolean f3618d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f3619e = false;

    /* renamed from: androidx.fragment.app.SpecialEffectsController$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3624a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3625b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        static {
            /*
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3625b = r0
                r1 = 1
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r2 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.ADDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f3625b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r3 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.REMOVING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f3625b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r4 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.NONE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                androidx.fragment.app.SpecialEffectsController$Operation$State[] r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f3624a = r3
                androidx.fragment.app.SpecialEffectsController$Operation$State r4 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f3624a     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f3624a     // Catch:{ NoSuchFieldError -> 0x004d }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f3624a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.AnonymousClass3.<clinit>():void");
        }
    }

    private static class FragmentStateManagerOperation extends Operation {

        /* renamed from: h  reason: collision with root package name */
        private final FragmentStateManager f3626h;

        FragmentStateManagerOperation(Operation.State state, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager, CancellationSignal cancellationSignal) {
            super(state, lifecycleImpact, fragmentStateManager.k(), cancellationSignal);
            this.f3626h = fragmentStateManager;
        }

        public void c() {
            super.c();
            this.f3626h.m();
        }

        /* access modifiers changed from: package-private */
        public void l() {
            if (g() == Operation.LifecycleImpact.ADDING) {
                Fragment k2 = this.f3626h.k();
                View findFocus = k2.mView.findFocus();
                if (findFocus != null) {
                    k2.setFocusedView(findFocus);
                    if (FragmentManager.G0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + k2);
                    }
                }
                View requireView = f().requireView();
                if (requireView.getParent() == null) {
                    this.f3626h.b();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(k2.getPostOnViewCreatedAlpha());
            }
        }
    }

    static class Operation {

        /* renamed from: a  reason: collision with root package name */
        private State f3627a;

        /* renamed from: b  reason: collision with root package name */
        private LifecycleImpact f3628b;

        /* renamed from: c  reason: collision with root package name */
        private final Fragment f3629c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Runnable> f3630d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private final HashSet<CancellationSignal> f3631e = new HashSet<>();

        /* renamed from: f  reason: collision with root package name */
        private boolean f3632f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f3633g = false;

        enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            static State b(int i2) {
                if (i2 == 0) {
                    return VISIBLE;
                }
                if (i2 == 4) {
                    return INVISIBLE;
                }
                if (i2 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i2);
            }

            static State c(View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return b(view.getVisibility());
            }

            /* access modifiers changed from: package-private */
            public void a(View view) {
                int i2 = AnonymousClass3.f3624a[ordinal()];
                if (i2 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.G0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                    }
                } else if (i2 == 2) {
                    if (FragmentManager.G0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                } else if (i2 == 3) {
                    if (FragmentManager.G0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                } else if (i2 == 4) {
                    if (FragmentManager.G0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                    }
                    view.setVisibility(4);
                }
            }
        }

        Operation(State state, LifecycleImpact lifecycleImpact, Fragment fragment, CancellationSignal cancellationSignal) {
            this.f3627a = state;
            this.f3628b = lifecycleImpact;
            this.f3629c = fragment;
            cancellationSignal.c(new CancellationSignal.OnCancelListener() {
                public void onCancel() {
                    Operation.this.b();
                }
            });
        }

        /* access modifiers changed from: package-private */
        public final void a(Runnable runnable) {
            this.f3630d.add(runnable);
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            if (!h()) {
                this.f3632f = true;
                if (this.f3631e.isEmpty()) {
                    c();
                    return;
                }
                Iterator it2 = new ArrayList(this.f3631e).iterator();
                while (it2.hasNext()) {
                    ((CancellationSignal) it2.next()).a();
                }
            }
        }

        public void c() {
            if (!this.f3633g) {
                if (FragmentManager.G0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
                }
                this.f3633g = true;
                for (Runnable run : this.f3630d) {
                    run.run();
                }
            }
        }

        public final void d(CancellationSignal cancellationSignal) {
            if (this.f3631e.remove(cancellationSignal) && this.f3631e.isEmpty()) {
                c();
            }
        }

        public State e() {
            return this.f3627a;
        }

        public final Fragment f() {
            return this.f3629c;
        }

        /* access modifiers changed from: package-private */
        public LifecycleImpact g() {
            return this.f3628b;
        }

        /* access modifiers changed from: package-private */
        public final boolean h() {
            return this.f3632f;
        }

        /* access modifiers changed from: package-private */
        public final boolean i() {
            return this.f3633g;
        }

        public final void j(CancellationSignal cancellationSignal) {
            l();
            this.f3631e.add(cancellationSignal);
        }

        /* access modifiers changed from: package-private */
        public final void k(State state, LifecycleImpact lifecycleImpact) {
            int i2 = AnonymousClass3.f3625b[lifecycleImpact.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (FragmentManager.G0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3629c + " mFinalState = " + this.f3627a + " -> REMOVED. mLifecycleImpact  = " + this.f3628b + " to REMOVING.");
                    }
                    this.f3627a = State.REMOVED;
                    this.f3628b = LifecycleImpact.REMOVING;
                } else if (i2 == 3 && this.f3627a != State.REMOVED) {
                    if (FragmentManager.G0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3629c + " mFinalState = " + this.f3627a + " -> " + state + ". ");
                    }
                    this.f3627a = state;
                }
            } else if (this.f3627a == State.REMOVED) {
                if (FragmentManager.G0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3629c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f3628b + " to ADDING.");
                }
                this.f3627a = State.VISIBLE;
                this.f3628b = LifecycleImpact.ADDING;
            }
        }

        /* access modifiers changed from: package-private */
        public void l() {
        }

        public String toString() {
            return "Operation " + "{" + Integer.toHexString(System.identityHashCode(this)) + "} " + "{" + "mFinalState = " + this.f3627a + "} " + "{" + "mLifecycleImpact = " + this.f3628b + "} " + "{" + "mFragment = " + this.f3629c + "}";
        }
    }

    SpecialEffectsController(ViewGroup viewGroup) {
        this.f3615a = viewGroup;
    }

    private void a(Operation.State state, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager) {
        synchronized (this.f3616b) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            Operation h2 = h(fragmentStateManager.k());
            if (h2 != null) {
                h2.k(state, lifecycleImpact);
                return;
            }
            final FragmentStateManagerOperation fragmentStateManagerOperation = new FragmentStateManagerOperation(state, lifecycleImpact, fragmentStateManager, cancellationSignal);
            this.f3616b.add(fragmentStateManagerOperation);
            fragmentStateManagerOperation.a(new Runnable() {
                public void run() {
                    if (SpecialEffectsController.this.f3616b.contains(fragmentStateManagerOperation)) {
                        fragmentStateManagerOperation.e().a(fragmentStateManagerOperation.f().mView);
                    }
                }
            });
            fragmentStateManagerOperation.a(new Runnable() {
                public void run() {
                    SpecialEffectsController.this.f3616b.remove(fragmentStateManagerOperation);
                    SpecialEffectsController.this.f3617c.remove(fragmentStateManagerOperation);
                }
            });
        }
    }

    private Operation h(Fragment fragment) {
        Iterator<Operation> it2 = this.f3616b.iterator();
        while (it2.hasNext()) {
            Operation next = it2.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    private Operation i(Fragment fragment) {
        Iterator<Operation> it2 = this.f3617c.iterator();
        while (it2.hasNext()) {
            Operation next = it2.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    static SpecialEffectsController n(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.z0());
    }

    static SpecialEffectsController o(ViewGroup viewGroup, SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        int i2 = R$id.f3250b;
        Object tag = viewGroup.getTag(i2);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController a2 = specialEffectsControllerFactory.a(viewGroup);
        viewGroup.setTag(i2, a2);
        return a2;
    }

    private void q() {
        Iterator<Operation> it2 = this.f3616b.iterator();
        while (it2.hasNext()) {
            Operation next = it2.next();
            if (next.g() == Operation.LifecycleImpact.ADDING) {
                next.k(Operation.State.b(next.f().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Operation.State state, FragmentStateManager fragmentStateManager) {
        if (FragmentManager.G0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.k());
        }
        a(state, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    /* access modifiers changed from: package-private */
    public void c(FragmentStateManager fragmentStateManager) {
        if (FragmentManager.G0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.k());
        }
        a(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    /* access modifiers changed from: package-private */
    public void d(FragmentStateManager fragmentStateManager) {
        if (FragmentManager.G0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.k());
        }
        a(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    /* access modifiers changed from: package-private */
    public void e(FragmentStateManager fragmentStateManager) {
        if (FragmentManager.G0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.k());
        }
        a(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    /* access modifiers changed from: package-private */
    public abstract void f(List<Operation> list, boolean z2);

    /* access modifiers changed from: package-private */
    public void g() {
        if (!this.f3619e) {
            if (!ViewCompat.U(this.f3615a)) {
                j();
                this.f3618d = false;
                return;
            }
            synchronized (this.f3616b) {
                if (!this.f3616b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f3617c);
                    this.f3617c.clear();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        Operation operation = (Operation) it2.next();
                        if (FragmentManager.G0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation);
                        }
                        operation.b();
                        if (!operation.i()) {
                            this.f3617c.add(operation);
                        }
                    }
                    q();
                    ArrayList arrayList2 = new ArrayList(this.f3616b);
                    this.f3616b.clear();
                    this.f3617c.addAll(arrayList2);
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        ((Operation) it3.next()).l();
                    }
                    f(arrayList2, this.f3618d);
                    this.f3618d = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        String str;
        String str2;
        boolean U = ViewCompat.U(this.f3615a);
        synchronized (this.f3616b) {
            q();
            Iterator<Operation> it2 = this.f3616b.iterator();
            while (it2.hasNext()) {
                it2.next().l();
            }
            Iterator it3 = new ArrayList(this.f3617c).iterator();
            while (it3.hasNext()) {
                Operation operation = (Operation) it3.next();
                if (FragmentManager.G0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (U) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f3615a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(operation);
                    Log.v("FragmentManager", sb.toString());
                }
                operation.b();
            }
            Iterator it4 = new ArrayList(this.f3616b).iterator();
            while (it4.hasNext()) {
                Operation operation2 = (Operation) it4.next();
                if (FragmentManager.G0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (U) {
                        str = "";
                    } else {
                        str = "Container " + this.f3615a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(operation2);
                    Log.v("FragmentManager", sb2.toString());
                }
                operation2.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        if (this.f3619e) {
            this.f3619e = false;
            g();
        }
    }

    /* access modifiers changed from: package-private */
    public Operation.LifecycleImpact l(FragmentStateManager fragmentStateManager) {
        Operation.LifecycleImpact lifecycleImpact;
        Operation h2 = h(fragmentStateManager.k());
        if (h2 != null) {
            lifecycleImpact = h2.g();
        } else {
            lifecycleImpact = null;
        }
        Operation i2 = i(fragmentStateManager.k());
        if (i2 == null || (lifecycleImpact != null && lifecycleImpact != Operation.LifecycleImpact.NONE)) {
            return lifecycleImpact;
        }
        return i2.g();
    }

    public ViewGroup m() {
        return this.f3615a;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        synchronized (this.f3616b) {
            q();
            this.f3619e = false;
            int size = this.f3616b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Operation operation = this.f3616b.get(size);
                Operation.State c2 = Operation.State.c(operation.f().mView);
                Operation.State e2 = operation.e();
                Operation.State state = Operation.State.VISIBLE;
                if (e2 == state && c2 != state) {
                    this.f3619e = operation.f().isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(boolean z2) {
        this.f3618d = z2;
    }
}
