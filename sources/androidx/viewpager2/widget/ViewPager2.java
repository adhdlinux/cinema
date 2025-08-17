package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R$styleable;
import androidx.viewpager2.adapter.StatefulAdapter;
import com.google.protobuf.CodedOutputStream;

public final class ViewPager2 extends ViewGroup {

    /* renamed from: v  reason: collision with root package name */
    static boolean f12017v = true;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f12018b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private final Rect f12019c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    private CompositeOnPageChangeCallback f12020d = new CompositeOnPageChangeCallback(3);

    /* renamed from: e  reason: collision with root package name */
    int f12021e;

    /* renamed from: f  reason: collision with root package name */
    boolean f12022f = false;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f12023g = new DataSetChangeObserver() {
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f12022f = true;
            viewPager2.f12029m.m();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private LinearLayoutManager f12024h;

    /* renamed from: i  reason: collision with root package name */
    private int f12025i = -1;

    /* renamed from: j  reason: collision with root package name */
    private Parcelable f12026j;

    /* renamed from: k  reason: collision with root package name */
    RecyclerView f12027k;

    /* renamed from: l  reason: collision with root package name */
    private PagerSnapHelper f12028l;

    /* renamed from: m  reason: collision with root package name */
    ScrollEventAdapter f12029m;

    /* renamed from: n  reason: collision with root package name */
    private CompositeOnPageChangeCallback f12030n;

    /* renamed from: o  reason: collision with root package name */
    private FakeDrag f12031o;

    /* renamed from: p  reason: collision with root package name */
    private PageTransformerAdapter f12032p;

    /* renamed from: q  reason: collision with root package name */
    private RecyclerView.ItemAnimator f12033q = null;

    /* renamed from: r  reason: collision with root package name */
    private boolean f12034r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f12035s = true;

    /* renamed from: t  reason: collision with root package name */
    private int f12036t = -1;

    /* renamed from: u  reason: collision with root package name */
    AccessibilityProvider f12037u;

    private abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i2) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean c(int i2, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void e(RecyclerView.Adapter<?> adapter) {
        }

        /* access modifiers changed from: package-private */
        public void f(RecyclerView.Adapter<?> adapter) {
        }

        /* access modifiers changed from: package-private */
        public String g() {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void h(CompositeOnPageChangeCallback compositeOnPageChangeCallback, RecyclerView recyclerView) {
        }

        /* access modifiers changed from: package-private */
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        /* access modifiers changed from: package-private */
        public void j(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        /* access modifiers changed from: package-private */
        public boolean k(int i2) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public boolean l(int i2, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void m() {
        }

        /* access modifiers changed from: package-private */
        public CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void o(AccessibilityEvent accessibilityEvent) {
        }

        /* access modifiers changed from: package-private */
        public void p() {
        }

        /* access modifiers changed from: package-private */
        public void q() {
        }

        /* access modifiers changed from: package-private */
        public void r() {
        }

        /* access modifiers changed from: package-private */
        public void s() {
        }
    }

    class BasicAccessibilityProvider extends AccessibilityProvider {
        BasicAccessibilityProvider() {
            super();
        }

        public boolean b(int i2) {
            if ((i2 == 8192 || i2 == 4096) && !ViewPager2.this.e()) {
                return true;
            }
            return false;
        }

        public boolean d() {
            return true;
        }

        public void j(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (!ViewPager2.this.e()) {
                accessibilityNodeInfoCompat.T(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2870r);
                accessibilityNodeInfoCompat.T(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2869q);
                accessibilityNodeInfoCompat.z0(false);
            }
        }

        public boolean k(int i2) {
            if (b(i2)) {
                return false;
            }
            throw new IllegalStateException();
        }

        public CharSequence n() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

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

    private class LinearLayoutManagerImpl extends LinearLayoutManager {
        LinearLayoutManagerImpl(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(state, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.f12037u.j(accessibilityNodeInfoCompat);
        }

        public boolean performAccessibilityAction(RecyclerView.Recycler recycler, RecyclerView.State state, int i2, Bundle bundle) {
            if (ViewPager2.this.f12037u.b(i2)) {
                return ViewPager2.this.f12037u.k(i2);
            }
            return super.performAccessibilityAction(recycler, state, i2, bundle);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z2, boolean z3) {
            return false;
        }
    }

    public static abstract class OnPageChangeCallback {
        public void a(int i2) {
        }

        public void b(int i2, float f2, int i3) {
        }

        public void c(int i2) {
        }
    }

    class PageAwareAccessibilityProvider extends AccessibilityProvider {

        /* renamed from: b  reason: collision with root package name */
        private final AccessibilityViewCommand f12045b = new AccessibilityViewCommand() {
            public boolean a(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                PageAwareAccessibilityProvider.this.v(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private final AccessibilityViewCommand f12046c = new AccessibilityViewCommand() {
            public boolean a(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                PageAwareAccessibilityProvider.this.v(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        };

        /* renamed from: d  reason: collision with root package name */
        private RecyclerView.AdapterDataObserver f12047d;

        PageAwareAccessibilityProvider() {
            super();
        }

        private void t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int i2;
            int i3;
            if (ViewPager2.this.getAdapter() == null) {
                i3 = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                i3 = ViewPager2.this.getAdapter().getItemCount();
            } else {
                i2 = ViewPager2.this.getAdapter().getItemCount();
                i3 = 0;
                AccessibilityNodeInfoCompat.J0(accessibilityNodeInfo).e0(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(i3, i2, false, 0));
            }
            i2 = 0;
            AccessibilityNodeInfoCompat.J0(accessibilityNodeInfo).e0(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(i3, i2, false, 0));
        }

        private void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter != null && (itemCount = adapter.getItemCount()) != 0 && ViewPager2.this.e()) {
                if (ViewPager2.this.f12021e > 0) {
                    accessibilityNodeInfo.addAction(8192);
                }
                if (ViewPager2.this.f12021e < itemCount - 1) {
                    accessibilityNodeInfo.addAction(CodedOutputStream.DEFAULT_BUFFER_SIZE);
                }
                accessibilityNodeInfo.setScrollable(true);
            }
        }

        public boolean a() {
            return true;
        }

        public boolean c(int i2, Bundle bundle) {
            return i2 == 8192 || i2 == 4096;
        }

        public void e(RecyclerView.Adapter<?> adapter) {
            w();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.f12047d);
            }
        }

        public void f(RecyclerView.Adapter<?> adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.f12047d);
            }
        }

        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        public void h(CompositeOnPageChangeCallback compositeOnPageChangeCallback, RecyclerView recyclerView) {
            ViewCompat.C0(recyclerView, 2);
            this.f12047d = new DataSetChangeObserver() {
                public void onChanged() {
                    PageAwareAccessibilityProvider.this.w();
                }
            };
            if (ViewCompat.B(ViewPager2.this) == 0) {
                ViewCompat.C0(ViewPager2.this, 1);
            }
        }

        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            t(accessibilityNodeInfo);
            u(accessibilityNodeInfo);
        }

        public boolean l(int i2, Bundle bundle) {
            int i3;
            if (c(i2, bundle)) {
                if (i2 == 8192) {
                    i3 = ViewPager2.this.getCurrentItem() - 1;
                } else {
                    i3 = ViewPager2.this.getCurrentItem() + 1;
                }
                v(i3);
                return true;
            }
            throw new IllegalStateException();
        }

        public void m() {
            w();
        }

        public void o(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        public void p() {
            w();
        }

        public void q() {
            w();
        }

        public void r() {
            w();
        }

        public void s() {
            w();
        }

        /* access modifiers changed from: package-private */
        public void v(int i2) {
            if (ViewPager2.this.e()) {
                ViewPager2.this.k(i2, true);
            }
        }

        /* access modifiers changed from: package-private */
        public void w() {
            int itemCount;
            int i2;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i3 = 16908360;
            ViewCompat.l0(viewPager2, 16908360);
            ViewCompat.l0(viewPager2, 16908361);
            ViewCompat.l0(viewPager2, 16908358);
            ViewCompat.l0(viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() != null && (itemCount = ViewPager2.this.getAdapter().getItemCount()) != 0 && ViewPager2.this.e()) {
                if (ViewPager2.this.getOrientation() == 0) {
                    boolean d2 = ViewPager2.this.d();
                    if (d2) {
                        i2 = 16908360;
                    } else {
                        i2 = 16908361;
                    }
                    if (d2) {
                        i3 = 16908361;
                    }
                    if (ViewPager2.this.f12021e < itemCount - 1) {
                        ViewCompat.n0(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i2, (CharSequence) null), (CharSequence) null, this.f12045b);
                    }
                    if (ViewPager2.this.f12021e > 0) {
                        ViewCompat.n0(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i3, (CharSequence) null), (CharSequence) null, this.f12046c);
                        return;
                    }
                    return;
                }
                if (ViewPager2.this.f12021e < itemCount - 1) {
                    ViewCompat.n0(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, (CharSequence) null), (CharSequence) null, this.f12045b);
                }
                if (ViewPager2.this.f12021e > 0) {
                    ViewCompat.n0(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, (CharSequence) null), (CharSequence) null, this.f12046c);
                }
            }
        }
    }

    public interface PageTransformer {
    }

    private class PagerSnapHelperImpl extends PagerSnapHelper {
        PagerSnapHelperImpl() {
        }

        public View g(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.c()) {
                return null;
            }
            return super.g(layoutManager);
        }
    }

    private class RecyclerViewImpl extends RecyclerView {
        RecyclerViewImpl(Context context) {
            super(context);
        }

        public CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.f12037u.d()) {
                return ViewPager2.this.f12037u.n();
            }
            return super.getAccessibilityClassName();
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f12021e);
            accessibilityEvent.setToIndex(ViewPager2.this.f12021e);
            ViewPager2.this.f12037u.o(accessibilityEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onInterceptTouchEvent(motionEvent);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onTouchEvent(motionEvent);
        }
    }

    private static class SmoothScrollToPosition implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final int f12057b;

        /* renamed from: c  reason: collision with root package name */
        private final RecyclerView f12058c;

        SmoothScrollToPosition(int i2, RecyclerView recyclerView) {
            this.f12057b = i2;
            this.f12058c = recyclerView;
        }

        public void run() {
            this.f12058c.smoothScrollToPosition(this.f12057b);
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context, attributeSet);
    }

    private RecyclerView.OnChildAttachStateChangeListener a() {
        return new RecyclerView.OnChildAttachStateChangeListener() {
            public void a(View view) {
            }

            public void b(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (layoutParams.width != -1 || layoutParams.height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }
        };
    }

    private void b(Context context, AttributeSet attributeSet) {
        AccessibilityProvider accessibilityProvider;
        if (f12017v) {
            accessibilityProvider = new PageAwareAccessibilityProvider();
        } else {
            accessibilityProvider = new BasicAccessibilityProvider();
        }
        this.f12037u = accessibilityProvider;
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.f12027k = recyclerViewImpl;
        recyclerViewImpl.setId(ViewCompat.m());
        this.f12027k.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.f12024h = linearLayoutManagerImpl;
        this.f12027k.setLayoutManager(linearLayoutManagerImpl);
        this.f12027k.setScrollingTouchSlop(1);
        l(context, attributeSet);
        this.f12027k.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f12027k.addOnChildAttachStateChangeListener(a());
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.f12029m = scrollEventAdapter;
        this.f12031o = new FakeDrag(this, scrollEventAdapter, this.f12027k);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.f12028l = pagerSnapHelperImpl;
        pagerSnapHelperImpl.b(this.f12027k);
        this.f12027k.addOnScrollListener(this.f12029m);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
        this.f12030n = compositeOnPageChangeCallback;
        this.f12029m.p(compositeOnPageChangeCallback);
        AnonymousClass2 r3 = new OnPageChangeCallback() {
            public void a(int i2) {
                if (i2 == 0) {
                    ViewPager2.this.o();
                }
            }

            public void c(int i2) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.f12021e != i2) {
                    viewPager2.f12021e = i2;
                    viewPager2.f12037u.q();
                }
            }
        };
        AnonymousClass3 r4 = new OnPageChangeCallback() {
            public void c(int i2) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.f12027k.requestFocus(2);
                }
            }
        };
        this.f12030n.d(r3);
        this.f12030n.d(r4);
        this.f12037u.h(this.f12030n, this.f12027k);
        this.f12030n.d(this.f12020d);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.f12024h);
        this.f12032p = pageTransformerAdapter;
        this.f12030n.d(pageTransformerAdapter);
        RecyclerView recyclerView = this.f12027k;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void f(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f12023g);
        }
    }

    private void i() {
        RecyclerView.Adapter adapter;
        if (this.f12025i != -1 && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.f12026j;
            if (parcelable != null) {
                if (adapter instanceof StatefulAdapter) {
                    ((StatefulAdapter) adapter).a(parcelable);
                }
                this.f12026j = null;
            }
            int max = Math.max(0, Math.min(this.f12025i, adapter.getItemCount() - 1));
            this.f12021e = max;
            this.f12025i = -1;
            this.f12027k.scrollToPosition(max);
            this.f12037u.m();
        }
    }

    private void l(Context context, AttributeSet attributeSet) {
        int[] iArr = R$styleable.f11963g;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(R$styleable.f11964h, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f12023g);
        }
    }

    public boolean c() {
        return this.f12031o.a();
    }

    public boolean canScrollHorizontally(int i2) {
        return this.f12027k.canScrollHorizontally(i2);
    }

    public boolean canScrollVertically(int i2) {
        return this.f12027k.canScrollVertically(i2);
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f12024h.getLayoutDirection() == 1;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i2 = ((SavedState) parcelable).f12054b;
            sparseArray.put(this.f12027k.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        i();
    }

    public boolean e() {
        return this.f12035s;
    }

    public void g(OnPageChangeCallback onPageChangeCallback) {
        this.f12020d.d(onPageChangeCallback);
    }

    public CharSequence getAccessibilityClassName() {
        if (this.f12037u.a()) {
            return this.f12037u.g();
        }
        return super.getAccessibilityClassName();
    }

    public RecyclerView.Adapter getAdapter() {
        return this.f12027k.getAdapter();
    }

    public int getCurrentItem() {
        return this.f12021e;
    }

    public int getItemDecorationCount() {
        return this.f12027k.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f12036t;
    }

    public int getOrientation() {
        return this.f12024h.getOrientation();
    }

    /* access modifiers changed from: package-private */
    public int getPageSize() {
        int i2;
        int i3;
        RecyclerView recyclerView = this.f12027k;
        if (getOrientation() == 0) {
            i2 = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            i3 = recyclerView.getPaddingRight();
        } else {
            i2 = recyclerView.getHeight() - recyclerView.getPaddingTop();
            i3 = recyclerView.getPaddingBottom();
        }
        return i2 - i3;
    }

    public int getScrollState() {
        return this.f12029m.i();
    }

    public void h() {
        this.f12032p.d();
    }

    public void j(int i2, boolean z2) {
        if (!c()) {
            k(i2, z2);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    /* access modifiers changed from: package-private */
    public void k(int i2, boolean z2) {
        int i3;
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f12025i != -1) {
                this.f12025i = Math.max(i2, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
            if (min != this.f12021e || !this.f12029m.k()) {
                int i4 = this.f12021e;
                if (min != i4 || !z2) {
                    double d2 = (double) i4;
                    this.f12021e = min;
                    this.f12037u.q();
                    if (!this.f12029m.k()) {
                        d2 = this.f12029m.h();
                    }
                    this.f12029m.n(min, z2);
                    if (!z2) {
                        this.f12027k.scrollToPosition(min);
                        return;
                    }
                    double d3 = (double) min;
                    if (Math.abs(d3 - d2) > 3.0d) {
                        RecyclerView recyclerView = this.f12027k;
                        if (d3 > d2) {
                            i3 = min - 3;
                        } else {
                            i3 = min + 3;
                        }
                        recyclerView.scrollToPosition(i3);
                        RecyclerView recyclerView2 = this.f12027k;
                        recyclerView2.post(new SmoothScrollToPosition(min, recyclerView2));
                        return;
                    }
                    this.f12027k.smoothScrollToPosition(min);
                }
            }
        }
    }

    public void n(OnPageChangeCallback onPageChangeCallback) {
        this.f12020d.e(onPageChangeCallback);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        PagerSnapHelper pagerSnapHelper = this.f12028l;
        if (pagerSnapHelper != null) {
            View g2 = pagerSnapHelper.g(this.f12024h);
            if (g2 != null) {
                int position = this.f12024h.getPosition(g2);
                if (position != this.f12021e && getScrollState() == 0) {
                    this.f12030n.c(position);
                }
                this.f12022f = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f12037u.i(accessibilityNodeInfo);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.f12027k.getMeasuredWidth();
        int measuredHeight = this.f12027k.getMeasuredHeight();
        this.f12018b.left = getPaddingLeft();
        this.f12018b.right = (i4 - i2) - getPaddingRight();
        this.f12018b.top = getPaddingTop();
        this.f12018b.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f12018b, this.f12019c);
        RecyclerView recyclerView = this.f12027k;
        Rect rect = this.f12019c;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f12022f) {
            o();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        measureChild(this.f12027k, i2, i3);
        int measuredWidth = this.f12027k.getMeasuredWidth();
        int measuredHeight = this.f12027k.getMeasuredHeight();
        int measuredState = this.f12027k.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f12025i = savedState.f12055c;
        this.f12026j = savedState.f12056d;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f12054b = this.f12027k.getId();
        int i2 = this.f12025i;
        if (i2 == -1) {
            i2 = this.f12021e;
        }
        savedState.f12055c = i2;
        Parcelable parcelable = this.f12026j;
        if (parcelable != null) {
            savedState.f12056d = parcelable;
        } else {
            RecyclerView.Adapter adapter = this.f12027k.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.f12056d = ((StatefulAdapter) adapter).b();
            }
        }
        return savedState;
    }

    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        if (this.f12037u.c(i2, bundle)) {
            return this.f12037u.l(i2, bundle);
        }
        return super.performAccessibilityAction(i2, bundle);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f12027k.getAdapter();
        this.f12037u.f(adapter2);
        m(adapter2);
        this.f12027k.setAdapter(adapter);
        this.f12021e = 0;
        i();
        this.f12037u.e(adapter);
        f(adapter);
    }

    public void setCurrentItem(int i2) {
        j(i2, true);
    }

    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.f12037u.p();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 >= 1 || i2 == -1) {
            this.f12036t = i2;
            this.f12027k.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int i2) {
        this.f12024h.setOrientation(i2);
        this.f12037u.r();
    }

    public void setPageTransformer(PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.f12034r) {
                this.f12033q = this.f12027k.getItemAnimator();
                this.f12034r = true;
            }
            this.f12027k.setItemAnimator((RecyclerView.ItemAnimator) null);
        } else if (this.f12034r) {
            this.f12027k.setItemAnimator(this.f12033q);
            this.f12033q = null;
            this.f12034r = false;
        }
        this.f12032p.d();
        if (pageTransformer != null) {
            this.f12032p.e(pageTransformer);
            h();
        }
    }

    public void setUserInputEnabled(boolean z2) {
        this.f12035s = z2;
        this.f12037u.s();
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        int f12054b;

        /* renamed from: c  reason: collision with root package name */
        int f12055c;

        /* renamed from: d  reason: collision with root package name */
        Parcelable f12056d;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel, classLoader);
        }

        private void b(Parcel parcel, ClassLoader classLoader) {
            this.f12054b = parcel.readInt();
            this.f12055c = parcel.readInt();
            this.f12056d = parcel.readParcelable(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f12054b);
            parcel.writeInt(this.f12055c);
            parcel.writeParcelable(this.f12056d, i2);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            b(parcel, (ClassLoader) null);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
