package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: i  reason: collision with root package name */
    boolean f11158i = false;

    /* renamed from: j  reason: collision with root package name */
    int f11159j = -1;

    /* renamed from: k  reason: collision with root package name */
    int[] f11160k;

    /* renamed from: l  reason: collision with root package name */
    View[] f11161l;

    /* renamed from: m  reason: collision with root package name */
    final SparseIntArray f11162m = new SparseIntArray();

    /* renamed from: n  reason: collision with root package name */
    final SparseIntArray f11163n = new SparseIntArray();

    /* renamed from: o  reason: collision with root package name */
    SpanSizeLookup f11164o = new DefaultSpanSizeLookup();

    /* renamed from: p  reason: collision with root package name */
    final Rect f11165p = new Rect();

    /* renamed from: q  reason: collision with root package name */
    private boolean f11166q;

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public int e(int i2, int i3) {
            return i2 % i3;
        }

        public int f(int i2) {
            return 1;
        }
    }

    public static abstract class SpanSizeLookup {

        /* renamed from: a  reason: collision with root package name */
        final SparseIntArray f11169a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        final SparseIntArray f11170b = new SparseIntArray();

        /* renamed from: c  reason: collision with root package name */
        private boolean f11171c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f11172d = false;

        static int a(SparseIntArray sparseIntArray, int i2) {
            int size = sparseIntArray.size() - 1;
            int i3 = 0;
            while (i3 <= size) {
                int i4 = (i3 + size) >>> 1;
                if (sparseIntArray.keyAt(i4) < i2) {
                    i3 = i4 + 1;
                } else {
                    size = i4 - 1;
                }
            }
            int i5 = i3 - 1;
            if (i5 < 0 || i5 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i5);
        }

        /* access modifiers changed from: package-private */
        public int b(int i2, int i3) {
            if (!this.f11172d) {
                return d(i2, i3);
            }
            int i4 = this.f11170b.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int d2 = d(i2, i3);
            this.f11170b.put(i2, d2);
            return d2;
        }

        /* access modifiers changed from: package-private */
        public int c(int i2, int i3) {
            if (!this.f11171c) {
                return e(i2, i3);
            }
            int i4 = this.f11169a.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int e2 = e(i2, i3);
            this.f11169a.put(i2, e2);
            return e2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int d(int r7, int r8) {
            /*
                r6 = this;
                boolean r0 = r6.f11172d
                r1 = 0
                if (r0 == 0) goto L_0x0024
                android.util.SparseIntArray r0 = r6.f11170b
                int r0 = a(r0, r7)
                r2 = -1
                if (r0 == r2) goto L_0x0024
                android.util.SparseIntArray r2 = r6.f11170b
                int r2 = r2.get(r0)
                int r3 = r0 + 1
                int r4 = r6.c(r0, r8)
                int r0 = r6.f(r0)
                int r4 = r4 + r0
                if (r4 != r8) goto L_0x0027
                int r2 = r2 + 1
                goto L_0x0026
            L_0x0024:
                r2 = 0
                r3 = 0
            L_0x0026:
                r4 = 0
            L_0x0027:
                int r0 = r6.f(r7)
            L_0x002b:
                if (r3 >= r7) goto L_0x0040
                int r5 = r6.f(r3)
                int r4 = r4 + r5
                if (r4 != r8) goto L_0x0038
                int r2 = r2 + 1
                r4 = 0
                goto L_0x003d
            L_0x0038:
                if (r4 <= r8) goto L_0x003d
                int r2 = r2 + 1
                r4 = r5
            L_0x003d:
                int r3 = r3 + 1
                goto L_0x002b
            L_0x0040:
                int r4 = r4 + r0
                if (r4 <= r8) goto L_0x0045
                int r2 = r2 + 1
            L_0x0045:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.d(int, int):int");
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int e(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.f(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.f11171c
                if (r2 == 0) goto L_0x0020
                android.util.SparseIntArray r2 = r5.f11169a
                int r2 = a(r2, r6)
                if (r2 < 0) goto L_0x0020
                android.util.SparseIntArray r3 = r5.f11169a
                int r3 = r3.get(r2)
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                goto L_0x0030
            L_0x0020:
                r2 = 0
                r3 = 0
            L_0x0022:
                if (r2 >= r6) goto L_0x0033
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x002d
                r3 = 0
                goto L_0x0030
            L_0x002d:
                if (r3 <= r7) goto L_0x0030
                r3 = r4
            L_0x0030:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0033:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x0037
                return r3
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.e(int, int):int");
        }

        public abstract int f(int i2);

        public void g() {
            this.f11170b.clear();
        }

        public void h() {
            this.f11169a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        s(RecyclerView.LayoutManager.getProperties(context, attributeSet, i2, i3).f11241b);
    }

    private void a(RecyclerView.Recycler recycler, RecyclerView.State state, int i2, boolean z2) {
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        if (z2) {
            i3 = i2;
            i4 = 0;
            i5 = 1;
        } else {
            i4 = i2 - 1;
            i3 = -1;
            i5 = -1;
        }
        while (i4 != i3) {
            View view = this.f11161l[i4];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int n2 = n(recycler, state, getPosition(view));
            layoutParams.f11168f = n2;
            layoutParams.f11167e = i6;
            i6 += n2;
            i4 += i5;
        }
    }

    private void b() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
            int a2 = layoutParams.a();
            this.f11162m.put(a2, layoutParams.f());
            this.f11163n.put(a2, layoutParams.e());
        }
    }

    private void c(int i2) {
        this.f11160k = d(this.f11160k, this.f11159j, i2);
    }

    static int[] d(int[] iArr, int i2, int i3) {
        int i4;
        if (!(iArr != null && iArr.length == i2 + 1 && iArr[iArr.length - 1] == i3)) {
            iArr = new int[(i2 + 1)];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i3 / i2;
        int i7 = i3 % i2;
        int i8 = 0;
        for (int i9 = 1; i9 <= i2; i9++) {
            i5 += i7;
            if (i5 <= 0 || i2 - i5 >= i7) {
                i4 = i6;
            } else {
                i4 = i6 + 1;
                i5 -= i2;
            }
            i8 += i4;
            iArr[i9] = i8;
        }
        return iArr;
    }

    private void e() {
        this.f11162m.clear();
        this.f11163n.clear();
    }

    private int f(RecyclerView.State state) {
        int i2;
        if (!(getChildCount() == 0 || state.b() == 0)) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                int b2 = this.f11164o.b(getPosition(findFirstVisibleChildClosestToStart), this.f11159j);
                int b3 = this.f11164o.b(getPosition(findFirstVisibleChildClosestToEnd), this.f11159j);
                int min = Math.min(b2, b3);
                int max = Math.max(b2, b3);
                int b4 = this.f11164o.b(state.b() - 1, this.f11159j) + 1;
                if (this.mShouldReverseLayout) {
                    i2 = Math.max(0, (b4 - max) - 1);
                } else {
                    i2 = Math.max(0, min);
                }
                if (!isSmoothScrollbarEnabled) {
                    return i2;
                }
                return Math.round((((float) i2) * (((float) Math.abs(this.mOrientationHelper.d(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart))) / ((float) ((this.f11164o.b(getPosition(findFirstVisibleChildClosestToEnd), this.f11159j) - this.f11164o.b(getPosition(findFirstVisibleChildClosestToStart), this.f11159j)) + 1)))) + ((float) (this.mOrientationHelper.m() - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart))));
            }
        }
        return 0;
    }

    private int g(RecyclerView.State state) {
        if (!(getChildCount() == 0 || state.b() == 0)) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.f11164o.b(state.b() - 1, this.f11159j) + 1;
                }
                int d2 = this.mOrientationHelper.d(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart);
                int b2 = this.f11164o.b(getPosition(findFirstVisibleChildClosestToStart), this.f11159j);
                return (int) ((((float) d2) / ((float) ((this.f11164o.b(getPosition(findFirstVisibleChildClosestToEnd), this.f11159j) - b2) + 1))) * ((float) (this.f11164o.b(state.b() - 1, this.f11159j) + 1)));
            }
        }
        return 0;
    }

    private void h(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i2) {
        boolean z2;
        if (i2 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int m2 = m(recycler, state, anchorInfo.f11183b);
        if (z2) {
            while (m2 > 0) {
                int i3 = anchorInfo.f11183b;
                if (i3 > 0) {
                    int i4 = i3 - 1;
                    anchorInfo.f11183b = i4;
                    m2 = m(recycler, state, i4);
                } else {
                    return;
                }
            }
            return;
        }
        int b2 = state.b() - 1;
        int i5 = anchorInfo.f11183b;
        while (i5 < b2) {
            int i6 = i5 + 1;
            int m3 = m(recycler, state, i6);
            if (m3 <= m2) {
                break;
            }
            i5 = i6;
            m2 = m3;
        }
        anchorInfo.f11183b = i5;
    }

    private void i() {
        View[] viewArr = this.f11161l;
        if (viewArr == null || viewArr.length != this.f11159j) {
            this.f11161l = new View[this.f11159j];
        }
    }

    private int l(RecyclerView.Recycler recycler, RecyclerView.State state, int i2) {
        if (!state.e()) {
            return this.f11164o.b(i2, this.f11159j);
        }
        int f2 = recycler.f(i2);
        if (f2 != -1) {
            return this.f11164o.b(f2, this.f11159j);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i2);
        return 0;
    }

    private int m(RecyclerView.Recycler recycler, RecyclerView.State state, int i2) {
        if (!state.e()) {
            return this.f11164o.c(i2, this.f11159j);
        }
        int i3 = this.f11163n.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int f2 = recycler.f(i2);
        if (f2 != -1) {
            return this.f11164o.c(f2, this.f11159j);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 0;
    }

    private int n(RecyclerView.Recycler recycler, RecyclerView.State state, int i2) {
        if (!state.e()) {
            return this.f11164o.f(i2);
        }
        int i3 = this.f11162m.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int f2 = recycler.f(i2);
        if (f2 != -1) {
            return this.f11164o.f(f2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 1;
    }

    private void p(float f2, int i2) {
        c(Math.max(Math.round(f2 * ((float) this.f11159j)), i2));
    }

    private void q(View view, int i2, boolean z2) {
        int i3;
        int i4;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f11245b;
        int i5 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i6 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int j2 = j(layoutParams.f11167e, layoutParams.f11168f);
        if (this.mOrientation == 1) {
            i3 = RecyclerView.LayoutManager.getChildMeasureSpec(j2, i2, i6, layoutParams.width, false);
            i4 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.n(), getHeightMode(), i5, layoutParams.height, true);
        } else {
            int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(j2, i2, i5, layoutParams.height, false);
            int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.n(), getWidthMode(), i6, layoutParams.width, true);
            i4 = childMeasureSpec;
            i3 = childMeasureSpec2;
        }
        r(view, i3, i4, z2);
    }

    private void r(View view, int i2, int i3, boolean z2) {
        boolean z3;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z2) {
            z3 = shouldReMeasureChild(view, i2, i3, layoutParams);
        } else {
            z3 = shouldMeasureChild(view, i2, i3, layoutParams);
        }
        if (z3) {
            view.measure(i2, i3);
        }
    }

    private void u() {
        int i2;
        int i3;
        if (getOrientation() == 1) {
            i3 = getWidth() - getPaddingRight();
            i2 = getPaddingLeft();
        } else {
            i3 = getHeight() - getPaddingBottom();
            i2 = getPaddingTop();
        }
        c(i3 - i2);
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i2 = this.f11159j;
        for (int i3 = 0; i3 < this.f11159j && layoutState.c(state) && i2 > 0; i3++) {
            int i4 = layoutState.f11194d;
            layoutPrefetchRegistry.a(i4, Math.max(0, layoutState.f11197g));
            i2 -= this.f11164o.f(i4);
            layoutState.f11194d += layoutState.f11195e;
        }
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        if (this.f11166q) {
            return f(state);
        }
        return super.computeHorizontalScrollOffset(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        if (this.f11166q) {
            return g(state);
        }
        return super.computeHorizontalScrollRange(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        if (this.f11166q) {
            return f(state);
        }
        return super.computeVerticalScrollOffset(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        if (this.f11166q) {
            return g(state);
        }
        return super.computeVerticalScrollRange(state);
    }

    /* access modifiers changed from: package-private */
    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2, boolean z3) {
        int i2;
        int i3;
        int childCount = getChildCount();
        int i4 = 1;
        if (z3) {
            i3 = getChildCount() - 1;
            i2 = -1;
            i4 = -1;
        } else {
            i2 = childCount;
            i3 = 0;
        }
        int b2 = state.b();
        ensureLayoutState();
        int m2 = this.mOrientationHelper.m();
        int i5 = this.mOrientationHelper.i();
        View view = null;
        View view2 = null;
        while (i3 != i2) {
            View childAt = getChildAt(i3);
            int position = getPosition(childAt);
            if (position >= 0 && position < b2 && m(recycler, state, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.g(childAt) < i5 && this.mOrientationHelper.d(childAt) >= m2) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i3 += i4;
        }
        if (view != null) {
            return view;
        }
        return view2;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return this.f11159j;
        }
        if (state.b() < 1) {
            return 0;
        }
        return l(recycler, state, state.b() - 1) + 1;
    }

    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return this.f11159j;
        }
        if (state.b() < 1) {
            return 0;
        }
        return l(recycler, state, state.b() - 1) + 1;
    }

    /* access modifiers changed from: package-private */
    public int j(int i2, int i3) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.f11160k;
            return iArr[i3 + i2] - iArr[i2];
        }
        int[] iArr2 = this.f11160k;
        int i4 = this.f11159j;
        return iArr2[i4 - i2] - iArr2[(i4 - i2) - i3];
    }

    public int k() {
        return this.f11159j;
    }

    /* access modifiers changed from: package-private */
    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        boolean z2;
        int i2;
        boolean z3;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        View d2;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        LinearLayoutManager.LayoutState layoutState2 = layoutState;
        LinearLayoutManager.LayoutChunkResult layoutChunkResult2 = layoutChunkResult;
        int l2 = this.mOrientationHelper.l();
        if (l2 != 1073741824) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (getChildCount() > 0) {
            i2 = this.f11160k[this.f11159j];
        } else {
            i2 = 0;
        }
        if (z2) {
            u();
        }
        if (layoutState2.f11195e == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        int i16 = this.f11159j;
        if (!z3) {
            i16 = m(recycler2, state2, layoutState2.f11194d) + n(recycler2, state2, layoutState2.f11194d);
        }
        int i17 = 0;
        while (i17 < this.f11159j && layoutState2.c(state2) && i16 > 0) {
            int i18 = layoutState2.f11194d;
            int n2 = n(recycler2, state2, i18);
            if (n2 <= this.f11159j) {
                i16 -= n2;
                if (i16 < 0 || (d2 = layoutState2.d(recycler2)) == null) {
                    break;
                }
                this.f11161l[i17] = d2;
                i17++;
            } else {
                throw new IllegalArgumentException("Item at position " + i18 + " requires " + n2 + " spans but GridLayoutManager has only " + this.f11159j + " spans.");
            }
        }
        if (i17 == 0) {
            layoutChunkResult2.f11188b = true;
            return;
        }
        a(recycler2, state2, i17, z3);
        float f2 = 0.0f;
        int i19 = 0;
        for (int i20 = 0; i20 < i17; i20++) {
            View view = this.f11161l[i20];
            if (layoutState2.f11202l == null) {
                if (z3) {
                    addView(view);
                } else {
                    addView(view, 0);
                }
            } else if (z3) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, 0);
            }
            calculateItemDecorationsForChild(view, this.f11165p);
            q(view, l2, false);
            int e2 = this.mOrientationHelper.e(view);
            if (e2 > i19) {
                i19 = e2;
            }
            float f3 = (((float) this.mOrientationHelper.f(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).f11168f);
            if (f3 > f2) {
                f2 = f3;
            }
        }
        if (z2) {
            p(f2, i2);
            i19 = 0;
            for (int i21 = 0; i21 < i17; i21++) {
                View view2 = this.f11161l[i21];
                q(view2, 1073741824, true);
                int e3 = this.mOrientationHelper.e(view2);
                if (e3 > i19) {
                    i19 = e3;
                }
            }
        }
        for (int i22 = 0; i22 < i17; i22++) {
            View view3 = this.f11161l[i22];
            if (this.mOrientationHelper.e(view3) != i19) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.f11245b;
                int i23 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i24 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
                int j2 = j(layoutParams.f11167e, layoutParams.f11168f);
                if (this.mOrientation == 1) {
                    i15 = RecyclerView.LayoutManager.getChildMeasureSpec(j2, 1073741824, i24, layoutParams.width, false);
                    i14 = View.MeasureSpec.makeMeasureSpec(i19 - i23, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i19 - i24, 1073741824);
                    i14 = RecyclerView.LayoutManager.getChildMeasureSpec(j2, 1073741824, i23, layoutParams.height, false);
                    i15 = makeMeasureSpec;
                }
                r(view3, i15, i14, true);
            }
        }
        layoutChunkResult2.f11187a = i19;
        if (this.mOrientation == 1) {
            if (layoutState2.f11196f == -1) {
                i6 = layoutState2.f11192b;
                i13 = i6 - i19;
            } else {
                i13 = layoutState2.f11192b;
                i6 = i13 + i19;
            }
            i3 = i13;
            i5 = 0;
            i4 = 0;
        } else {
            if (layoutState2.f11196f == -1) {
                i12 = layoutState2.f11192b;
                i11 = i12 - i19;
            } else {
                i11 = layoutState2.f11192b;
                i12 = i11 + i19;
            }
            i4 = i11;
            i3 = 0;
            i5 = i12;
            i6 = 0;
        }
        int i25 = 0;
        while (i25 < i17) {
            View view4 = this.f11161l[i25];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.f11160k[this.f11159j - layoutParams2.f11167e];
                    i10 = i6;
                    i9 = paddingLeft;
                    i8 = paddingLeft - this.mOrientationHelper.f(view4);
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.f11160k[layoutParams2.f11167e];
                    i10 = i6;
                    i8 = paddingLeft2;
                    i9 = this.mOrientationHelper.f(view4) + paddingLeft2;
                }
                i7 = i3;
            } else {
                int paddingTop = getPaddingTop() + this.f11160k[layoutParams2.f11167e];
                i7 = paddingTop;
                i9 = i5;
                i8 = i4;
                i10 = this.mOrientationHelper.f(view4) + paddingTop;
            }
            layoutDecoratedWithMargins(view4, i8, i7, i9, i10);
            if (layoutParams2.c() || layoutParams2.b()) {
                layoutChunkResult2.f11189c = true;
            }
            layoutChunkResult2.f11190d |= view4.hasFocusable();
            i25++;
            i6 = i10;
            i5 = i9;
            i4 = i8;
            i3 = i7;
        }
        Arrays.fill(this.f11161l, (Object) null);
    }

    public SpanSizeLookup o() {
        return this.f11164o;
    }

    /* access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i2) {
        super.onAnchorReady(recycler, state, anchorInfo, i2);
        u();
        if (state.b() > 0 && !state.e()) {
            h(recycler, state, anchorInfo, i2);
        }
        i();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d6, code lost:
        if (r13 == r7) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f6, code lost:
        if (r13 == r11) goto L_0x00b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.Recycler r26, androidx.recyclerview.widget.RecyclerView.State r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            android.view.View r3 = r23.findContainingItemView(r24)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r5 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r5
            int r6 = r5.f11167e
            int r5 = r5.f11168f
            int r5 = r5 + r6
            android.view.View r7 = super.onFocusSearchFailed(r24, r25, r26, r27)
            if (r7 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r7 = r25
            int r7 = r0.convertFocusDirectionToLayoutDirection(r7)
            r9 = 1
            if (r7 != r9) goto L_0x002b
            r7 = 1
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            boolean r10 = r0.mShouldReverseLayout
            if (r7 == r10) goto L_0x0032
            r7 = 1
            goto L_0x0033
        L_0x0032:
            r7 = 0
        L_0x0033:
            r10 = -1
            if (r7 == 0) goto L_0x003e
            int r7 = r23.getChildCount()
            int r7 = r7 - r9
            r11 = -1
            r12 = -1
            goto L_0x0045
        L_0x003e:
            int r7 = r23.getChildCount()
            r11 = r7
            r7 = 0
            r12 = 1
        L_0x0045:
            int r13 = r0.mOrientation
            if (r13 != r9) goto L_0x0051
            boolean r13 = r23.isLayoutRTL()
            if (r13 == 0) goto L_0x0051
            r13 = 1
            goto L_0x0052
        L_0x0051:
            r13 = 0
        L_0x0052:
            int r14 = r0.l(r1, r2, r7)
            r10 = r7
            r8 = 0
            r15 = -1
            r16 = -1
            r17 = 0
            r7 = r4
        L_0x005e:
            if (r10 == r11) goto L_0x0149
            int r9 = r0.l(r1, r2, r10)
            android.view.View r1 = r0.getChildAt(r10)
            if (r1 != r3) goto L_0x006c
            goto L_0x0149
        L_0x006c:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0086
            if (r9 == r14) goto L_0x0086
            if (r4 == 0) goto L_0x0078
            goto L_0x0149
        L_0x0078:
            r18 = r3
            r21 = r7
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
            goto L_0x0135
        L_0x0086:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r9
            int r2 = r9.f11167e
            r18 = r3
            int r3 = r9.f11168f
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x009e
            if (r2 != r6) goto L_0x009e
            if (r3 != r5) goto L_0x009e
            return r1
        L_0x009e:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00a6
            if (r4 == 0) goto L_0x00ae
        L_0x00a6:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto L_0x00ba
            if (r7 != 0) goto L_0x00ba
        L_0x00ae:
            r21 = r7
        L_0x00b0:
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
        L_0x00b8:
            r11 = 1
            goto L_0x0105
        L_0x00ba:
            int r19 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r5)
            r21 = r7
            int r7 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00d9
            if (r7 <= r8) goto L_0x00cf
        L_0x00ce:
            goto L_0x00b0
        L_0x00cf:
            if (r7 != r8) goto L_0x00fc
            if (r2 <= r15) goto L_0x00d5
            r7 = 1
            goto L_0x00d6
        L_0x00d5:
            r7 = 0
        L_0x00d6:
            if (r13 != r7) goto L_0x00fc
            goto L_0x00ce
        L_0x00d9:
            if (r4 != 0) goto L_0x00fc
            r19 = r8
            r20 = r11
            r8 = 0
            r11 = 1
            boolean r22 = r0.isViewPartiallyVisible(r1, r8, r11)
            if (r22 == 0) goto L_0x0100
            r8 = r17
            if (r7 <= r8) goto L_0x00ee
            r7 = r16
            goto L_0x0105
        L_0x00ee:
            if (r7 != r8) goto L_0x00f9
            r7 = r16
            if (r2 <= r7) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r11 = 0
        L_0x00f6:
            if (r13 != r11) goto L_0x0104
            goto L_0x00b8
        L_0x00f9:
            r7 = r16
            goto L_0x0104
        L_0x00fc:
            r19 = r8
            r20 = r11
        L_0x0100:
            r7 = r16
            r8 = r17
        L_0x0104:
            r11 = 0
        L_0x0105:
            if (r11 == 0) goto L_0x0135
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x0123
            int r4 = r9.f11167e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r2 = r3 - r2
            r15 = r4
            r16 = r7
            r17 = r8
            r7 = r21
            r4 = r1
            r8 = r2
            goto L_0x013d
        L_0x0123:
            int r7 = r9.f11167e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r17 = r3 - r2
            r16 = r7
            r8 = r19
            r7 = r1
            goto L_0x013d
        L_0x0135:
            r16 = r7
            r17 = r8
            r8 = r19
            r7 = r21
        L_0x013d:
            int r10 = r10 + r12
            r1 = r26
            r2 = r27
            r3 = r18
            r11 = r20
            r9 = 1
            goto L_0x005e
        L_0x0149:
            r21 = r7
            if (r4 == 0) goto L_0x014e
            goto L_0x0150
        L_0x014e:
            r4 = r21
        L_0x0150:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.c0(GridView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int l2 = l(recycler, state, layoutParams2.a());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.f0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.g(layoutParams2.e(), layoutParams2.f(), l2, 1, false, false));
            return;
        }
        accessibilityNodeInfoCompat.f0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.g(l2, 1, layoutParams2.e(), layoutParams2.f(), false, false));
    }

    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        this.f11164o.h();
        this.f11164o.g();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f11164o.h();
        this.f11164o.g();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        this.f11164o.h();
        this.f11164o.g();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        this.f11164o.h();
        this.f11164o.g();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        this.f11164o.h();
        this.f11164o.g();
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.e()) {
            b();
        }
        super.onLayoutChildren(recycler, state);
        e();
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f11158i = false;
    }

    public void s(int i2) {
        if (i2 != this.f11159j) {
            this.f11158i = true;
            if (i2 >= 1) {
                this.f11159j = i2;
                this.f11164o.h();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i2);
        }
    }

    public int scrollHorizontallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        u();
        i();
        return super.scrollHorizontallyBy(i2, recycler, state);
    }

    public int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        u();
        i();
        return super.scrollVerticallyBy(i2, recycler, state);
    }

    public void setMeasuredDimension(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        if (this.f11160k == null) {
            super.setMeasuredDimension(rect, i2, i3);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            i5 = RecyclerView.LayoutManager.chooseSize(i3, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.f11160k;
            i4 = RecyclerView.LayoutManager.chooseSize(i2, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            i4 = RecyclerView.LayoutManager.chooseSize(i2, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.f11160k;
            i5 = RecyclerView.LayoutManager.chooseSize(i3, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i4, i5);
    }

    public void setStackFromEnd(boolean z2) {
        if (!z2) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f11158i;
    }

    public void t(SpanSizeLookup spanSizeLookup) {
        this.f11164o = spanSizeLookup;
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: e  reason: collision with root package name */
        int f11167e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f11168f = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int e() {
            return this.f11167e;
        }

        public int f() {
            return this.f11168f;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public GridLayoutManager(Context context, int i2) {
        super(context);
        s(i2);
    }
}
