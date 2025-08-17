package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.gms.cast.framework.media.NotificationOptions;

public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {

    /* renamed from: n  reason: collision with root package name */
    final Lifecycle f11965n;

    /* renamed from: o  reason: collision with root package name */
    final FragmentManager f11966o;

    /* renamed from: p  reason: collision with root package name */
    final LongSparseArray<Fragment> f11967p;

    /* renamed from: q  reason: collision with root package name */
    private final LongSparseArray<Fragment.SavedState> f11968q;

    /* renamed from: r  reason: collision with root package name */
    private final LongSparseArray<Integer> f11969r;

    /* renamed from: s  reason: collision with root package name */
    private FragmentMaxLifecycleEnforcer f11970s;

    /* renamed from: t  reason: collision with root package name */
    boolean f11971t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f11972u;

    private static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        public abstract void onChanged();

        public final void onItemRangeChanged(int i2, int i3) {
            onChanged();
        }

        public final void onItemRangeInserted(int i2, int i3) {
            onChanged();
        }

        public final void onItemRangeMoved(int i2, int i3, int i4) {
            onChanged();
        }

        public final void onItemRangeRemoved(int i2, int i3) {
            onChanged();
        }

        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            onChanged();
        }
    }

    class FragmentMaxLifecycleEnforcer {

        /* renamed from: a  reason: collision with root package name */
        private ViewPager2.OnPageChangeCallback f11985a;

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView.AdapterDataObserver f11986b;

        /* renamed from: c  reason: collision with root package name */
        private LifecycleEventObserver f11987c;

        /* renamed from: d  reason: collision with root package name */
        private ViewPager2 f11988d;

        /* renamed from: e  reason: collision with root package name */
        private long f11989e = -1;

        FragmentMaxLifecycleEnforcer() {
        }

        private ViewPager2 a(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        /* access modifiers changed from: package-private */
        public void b(RecyclerView recyclerView) {
            this.f11988d = a(recyclerView);
            AnonymousClass1 r2 = new ViewPager2.OnPageChangeCallback() {
                public void a(int i2) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }

                public void c(int i2) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f11985a = r2;
            this.f11988d.g(r2);
            AnonymousClass2 r22 = new DataSetChangeObserver() {
                public void onChanged() {
                    FragmentMaxLifecycleEnforcer.this.d(true);
                }
            };
            this.f11986b = r22;
            FragmentStateAdapter.this.registerAdapterDataObserver(r22);
            AnonymousClass3 r23 = new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f11987c = r23;
            FragmentStateAdapter.this.f11965n.a(r23);
        }

        /* access modifiers changed from: package-private */
        public void c(RecyclerView recyclerView) {
            a(recyclerView).n(this.f11985a);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.f11986b);
            FragmentStateAdapter.this.f11965n.c(this.f11987c);
            this.f11988d = null;
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z2) {
            int currentItem;
            Fragment f2;
            boolean z3;
            if (!FragmentStateAdapter.this.v() && this.f11988d.getScrollState() == 0 && !FragmentStateAdapter.this.f11967p.i() && FragmentStateAdapter.this.getItemCount() != 0 && (currentItem = this.f11988d.getCurrentItem()) < FragmentStateAdapter.this.getItemCount()) {
                long itemId = FragmentStateAdapter.this.getItemId(currentItem);
                if ((itemId != this.f11989e || z2) && (f2 = FragmentStateAdapter.this.f11967p.f(itemId)) != null && f2.isAdded()) {
                    this.f11989e = itemId;
                    FragmentTransaction n2 = FragmentStateAdapter.this.f11966o.n();
                    Fragment fragment = null;
                    for (int i2 = 0; i2 < FragmentStateAdapter.this.f11967p.n(); i2++) {
                        long j2 = FragmentStateAdapter.this.f11967p.j(i2);
                        Fragment o2 = FragmentStateAdapter.this.f11967p.o(i2);
                        if (o2.isAdded()) {
                            if (j2 != this.f11989e) {
                                n2.s(o2, Lifecycle.State.STARTED);
                            } else {
                                fragment = o2;
                            }
                            if (j2 == this.f11989e) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            o2.setMenuVisibility(z3);
                        }
                    }
                    if (fragment != null) {
                        n2.s(fragment, Lifecycle.State.RESUMED);
                    }
                    if (!n2.n()) {
                        n2.j();
                    }
                }
            }
        }
    }

    private static String f(String str, long j2) {
        return str + j2;
    }

    private void g(int i2) {
        long itemId = getItemId(i2);
        if (!this.f11967p.d(itemId)) {
            Fragment e2 = e(i2);
            e2.setInitialSavedState(this.f11968q.f(itemId));
            this.f11967p.k(itemId, e2);
        }
    }

    private boolean i(long j2) {
        View view;
        if (this.f11969r.d(j2)) {
            return true;
        }
        Fragment f2 = this.f11967p.f(j2);
        if (f2 == null || (view = f2.getView()) == null || view.getParent() == null) {
            return false;
        }
        return true;
    }

    private static boolean j(String str, String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private Long k(int i2) {
        Long l2 = null;
        for (int i3 = 0; i3 < this.f11969r.n(); i3++) {
            if (this.f11969r.o(i3).intValue() == i2) {
                if (l2 == null) {
                    l2 = Long.valueOf(this.f11969r.j(i3));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l2;
    }

    private static long q(String str, String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void s(long j2) {
        ViewParent parent;
        Fragment f2 = this.f11967p.f(j2);
        if (f2 != null) {
            if (!(f2.getView() == null || (parent = f2.getView().getParent()) == null)) {
                ((FrameLayout) parent).removeAllViews();
            }
            if (!d(j2)) {
                this.f11968q.l(j2);
            }
            if (!f2.isAdded()) {
                this.f11967p.l(j2);
            } else if (v()) {
                this.f11972u = true;
            } else {
                if (f2.isAdded() && d(j2)) {
                    this.f11968q.k(j2, this.f11966o.n1(f2));
                }
                this.f11966o.n().o(f2).j();
                this.f11967p.l(j2);
            }
        }
    }

    private void t() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final AnonymousClass4 r12 = new Runnable() {
            public void run() {
                FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
                fragmentStateAdapter.f11971t = false;
                fragmentStateAdapter.h();
            }
        };
        this.f11965n.a(new LifecycleEventObserver() {
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(r12);
                    lifecycleOwner.getLifecycle().c(this);
                }
            }
        });
        handler.postDelayed(r12, NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
    }

    private void u(final Fragment fragment, final FrameLayout frameLayout) {
        this.f11966o.e1(new FragmentManager.FragmentLifecycleCallbacks() {
            public void m(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
                if (fragment == fragment) {
                    fragmentManager.w1(this);
                    FragmentStateAdapter.this.c(view, frameLayout);
                }
            }
        }, false);
    }

    public final void a(Parcelable parcelable) {
        if (!this.f11968q.i() || !this.f11967p.i()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String next : bundle.keySet()) {
            if (j(next, "f#")) {
                this.f11967p.k(q(next, "f#"), this.f11966o.p0(bundle, next));
            } else if (j(next, "s#")) {
                long q2 = q(next, "s#");
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(next);
                if (d(q2)) {
                    this.f11968q.k(q2, savedState);
                }
            } else {
                throw new IllegalArgumentException("Unexpected key in savedState: " + next);
            }
        }
        if (!this.f11967p.i()) {
            this.f11972u = true;
            this.f11971t = true;
            h();
            t();
        }
    }

    public final Parcelable b() {
        Bundle bundle = new Bundle(this.f11967p.n() + this.f11968q.n());
        for (int i2 = 0; i2 < this.f11967p.n(); i2++) {
            long j2 = this.f11967p.j(i2);
            Fragment f2 = this.f11967p.f(j2);
            if (f2 != null && f2.isAdded()) {
                this.f11966o.d1(bundle, f("f#", j2), f2);
            }
        }
        for (int i3 = 0; i3 < this.f11968q.n(); i3++) {
            long j3 = this.f11968q.j(i3);
            if (d(j3)) {
                bundle.putParcelable(f("s#", j3), this.f11968q.f(j3));
            }
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public void c(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    public boolean d(long j2) {
        return j2 >= 0 && j2 < ((long) getItemCount());
    }

    public abstract Fragment e(int i2);

    public long getItemId(int i2) {
        return (long) i2;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (this.f11972u && !v()) {
            ArraySet<Long> arraySet = new ArraySet<>();
            for (int i2 = 0; i2 < this.f11967p.n(); i2++) {
                long j2 = this.f11967p.j(i2);
                if (!d(j2)) {
                    arraySet.add(Long.valueOf(j2));
                    this.f11969r.l(j2);
                }
            }
            if (!this.f11971t) {
                this.f11972u = false;
                for (int i3 = 0; i3 < this.f11967p.n(); i3++) {
                    long j3 = this.f11967p.j(i3);
                    if (!i(j3)) {
                        arraySet.add(Long.valueOf(j3));
                    }
                }
            }
            for (Long longValue : arraySet) {
                s(longValue.longValue());
            }
        }
    }

    /* renamed from: l */
    public final void onBindViewHolder(final FragmentViewHolder fragmentViewHolder, int i2) {
        long itemId = fragmentViewHolder.getItemId();
        int id = fragmentViewHolder.b().getId();
        Long k2 = k(id);
        if (!(k2 == null || k2.longValue() == itemId)) {
            s(k2.longValue());
            this.f11969r.l(k2.longValue());
        }
        this.f11969r.k(itemId, Integer.valueOf(id));
        g(i2);
        final FrameLayout b2 = fragmentViewHolder.b();
        if (ViewCompat.U(b2)) {
            if (b2.getParent() == null) {
                b2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                        if (b2.getParent() != null) {
                            b2.removeOnLayoutChangeListener(this);
                            FragmentStateAdapter.this.r(fragmentViewHolder);
                        }
                    }
                });
            } else {
                throw new IllegalStateException("Design assumption violated.");
            }
        }
        h();
    }

    /* renamed from: m */
    public final FragmentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return FragmentViewHolder.a(viewGroup);
    }

    /* renamed from: n */
    public final boolean onFailedToRecycleView(FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    /* renamed from: o */
    public final void onViewAttachedToWindow(FragmentViewHolder fragmentViewHolder) {
        r(fragmentViewHolder);
        h();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        boolean z2;
        if (this.f11970s == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.a(z2);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.f11970s = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.b(recyclerView);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.f11970s.c(recyclerView);
        this.f11970s = null;
    }

    /* renamed from: p */
    public final void onViewRecycled(FragmentViewHolder fragmentViewHolder) {
        Long k2 = k(fragmentViewHolder.b().getId());
        if (k2 != null) {
            s(k2.longValue());
            this.f11969r.l(k2.longValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void r(final FragmentViewHolder fragmentViewHolder) {
        Fragment f2 = this.f11967p.f(fragmentViewHolder.getItemId());
        if (f2 != null) {
            FrameLayout b2 = fragmentViewHolder.b();
            View view = f2.getView();
            if (!f2.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            } else if (f2.isAdded() && view == null) {
                u(f2, b2);
            } else if (!f2.isAdded() || view.getParent() == null) {
                if (f2.isAdded()) {
                    c(view, b2);
                } else if (!v()) {
                    u(f2, b2);
                    FragmentTransaction n2 = this.f11966o.n();
                    n2.e(f2, "f" + fragmentViewHolder.getItemId()).s(f2, Lifecycle.State.STARTED).j();
                    this.f11970s.d(false);
                } else if (!this.f11966o.F0()) {
                    this.f11965n.a(new LifecycleEventObserver() {
                        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                            if (!FragmentStateAdapter.this.v()) {
                                lifecycleOwner.getLifecycle().c(this);
                                if (ViewCompat.U(fragmentViewHolder.b())) {
                                    FragmentStateAdapter.this.r(fragmentViewHolder);
                                }
                            }
                        }
                    });
                }
            } else if (view.getParent() != b2) {
                c(view, b2);
            }
        } else {
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    public final void setHasStableIds(boolean z2) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    /* access modifiers changed from: package-private */
    public boolean v() {
        return this.f11966o.L0();
    }
}
