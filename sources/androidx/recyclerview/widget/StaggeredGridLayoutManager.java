package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    private final Rect A = new Rect();
    private final AnchorInfo B = new AnchorInfo();
    private boolean C = false;
    private boolean D = true;
    private int[] E;
    private final Runnable F = new Runnable() {
        public void run() {
            StaggeredGridLayoutManager.this.g();
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private int f11319i = -1;

    /* renamed from: j  reason: collision with root package name */
    Span[] f11320j;

    /* renamed from: k  reason: collision with root package name */
    OrientationHelper f11321k;

    /* renamed from: l  reason: collision with root package name */
    OrientationHelper f11322l;

    /* renamed from: m  reason: collision with root package name */
    private int f11323m;

    /* renamed from: n  reason: collision with root package name */
    private int f11324n;

    /* renamed from: o  reason: collision with root package name */
    private final LayoutState f11325o;

    /* renamed from: p  reason: collision with root package name */
    boolean f11326p = false;

    /* renamed from: q  reason: collision with root package name */
    boolean f11327q = false;

    /* renamed from: r  reason: collision with root package name */
    private BitSet f11328r;

    /* renamed from: s  reason: collision with root package name */
    int f11329s = -1;

    /* renamed from: t  reason: collision with root package name */
    int f11330t = Integer.MIN_VALUE;

    /* renamed from: u  reason: collision with root package name */
    LazySpanLookup f11331u = new LazySpanLookup();

    /* renamed from: v  reason: collision with root package name */
    private int f11332v = 2;

    /* renamed from: w  reason: collision with root package name */
    private boolean f11333w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f11334x;

    /* renamed from: y  reason: collision with root package name */
    private SavedState f11335y;

    /* renamed from: z  reason: collision with root package name */
    private int f11336z;

    class AnchorInfo {

        /* renamed from: a  reason: collision with root package name */
        int f11338a;

        /* renamed from: b  reason: collision with root package name */
        int f11339b;

        /* renamed from: c  reason: collision with root package name */
        boolean f11340c;

        /* renamed from: d  reason: collision with root package name */
        boolean f11341d;

        /* renamed from: e  reason: collision with root package name */
        boolean f11342e;

        /* renamed from: f  reason: collision with root package name */
        int[] f11343f;

        AnchorInfo() {
            c();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i2;
            if (this.f11340c) {
                i2 = StaggeredGridLayoutManager.this.f11321k.i();
            } else {
                i2 = StaggeredGridLayoutManager.this.f11321k.m();
            }
            this.f11339b = i2;
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            if (this.f11340c) {
                this.f11339b = StaggeredGridLayoutManager.this.f11321k.i() - i2;
            } else {
                this.f11339b = StaggeredGridLayoutManager.this.f11321k.m() + i2;
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f11338a = -1;
            this.f11339b = Integer.MIN_VALUE;
            this.f11340c = false;
            this.f11341d = false;
            this.f11342e = false;
            int[] iArr = this.f11343f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(Span[] spanArr) {
            int length = spanArr.length;
            int[] iArr = this.f11343f;
            if (iArr == null || iArr.length < length) {
                this.f11343f = new int[StaggeredGridLayoutManager.this.f11320j.length];
            }
            for (int i2 = 0; i2 < length; i2++) {
                this.f11343f[i2] = spanArr[i2].p(Integer.MIN_VALUE);
            }
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: e  reason: collision with root package name */
        Span f11345e;

        /* renamed from: f  reason: collision with root package name */
        boolean f11346f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean e() {
            return this.f11346f;
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

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        int f11353b;

        /* renamed from: c  reason: collision with root package name */
        int f11354c;

        /* renamed from: d  reason: collision with root package name */
        int f11355d;

        /* renamed from: e  reason: collision with root package name */
        int[] f11356e;

        /* renamed from: f  reason: collision with root package name */
        int f11357f;

        /* renamed from: g  reason: collision with root package name */
        int[] f11358g;

        /* renamed from: h  reason: collision with root package name */
        List<LazySpanLookup.FullSpanItem> f11359h;

        /* renamed from: i  reason: collision with root package name */
        boolean f11360i;

        /* renamed from: j  reason: collision with root package name */
        boolean f11361j;

        /* renamed from: k  reason: collision with root package name */
        boolean f11362k;

        public SavedState() {
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f11356e = null;
            this.f11355d = 0;
            this.f11353b = -1;
            this.f11354c = -1;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f11356e = null;
            this.f11355d = 0;
            this.f11357f = 0;
            this.f11358g = null;
            this.f11359h = null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f11353b);
            parcel.writeInt(this.f11354c);
            parcel.writeInt(this.f11355d);
            if (this.f11355d > 0) {
                parcel.writeIntArray(this.f11356e);
            }
            parcel.writeInt(this.f11357f);
            if (this.f11357f > 0) {
                parcel.writeIntArray(this.f11358g);
            }
            parcel.writeInt(this.f11360i ? 1 : 0);
            parcel.writeInt(this.f11361j ? 1 : 0);
            parcel.writeInt(this.f11362k ? 1 : 0);
            parcel.writeList(this.f11359h);
        }

        SavedState(Parcel parcel) {
            this.f11353b = parcel.readInt();
            this.f11354c = parcel.readInt();
            int readInt = parcel.readInt();
            this.f11355d = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f11356e = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f11357f = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f11358g = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z2 = false;
            this.f11360i = parcel.readInt() == 1;
            this.f11361j = parcel.readInt() == 1;
            this.f11362k = parcel.readInt() == 1 ? true : z2;
            this.f11359h = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f11355d = savedState.f11355d;
            this.f11353b = savedState.f11353b;
            this.f11354c = savedState.f11354c;
            this.f11356e = savedState.f11356e;
            this.f11357f = savedState.f11357f;
            this.f11358g = savedState.f11358g;
            this.f11360i = savedState.f11360i;
            this.f11361j = savedState.f11361j;
            this.f11362k = savedState.f11362k;
            this.f11359h = savedState.f11359h;
        }
    }

    class Span {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f11363a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f11364b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f11365c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        int f11366d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int f11367e;

        Span(int i2) {
            this.f11367e = i2;
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            LayoutParams n2 = n(view);
            n2.f11345e = this;
            this.f11363a.add(view);
            this.f11365c = Integer.MIN_VALUE;
            if (this.f11363a.size() == 1) {
                this.f11364b = Integer.MIN_VALUE;
            }
            if (n2.c() || n2.b()) {
                this.f11366d += StaggeredGridLayoutManager.this.f11321k.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(boolean z2, int i2) {
            int i3;
            if (z2) {
                i3 = l(Integer.MIN_VALUE);
            } else {
                i3 = p(Integer.MIN_VALUE);
            }
            e();
            if (i3 != Integer.MIN_VALUE) {
                if (z2 && i3 < StaggeredGridLayoutManager.this.f11321k.i()) {
                    return;
                }
                if (z2 || i3 <= StaggeredGridLayoutManager.this.f11321k.m()) {
                    if (i2 != Integer.MIN_VALUE) {
                        i3 += i2;
                    }
                    this.f11365c = i3;
                    this.f11364b = i3;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            LazySpanLookup.FullSpanItem f2;
            ArrayList<View> arrayList = this.f11363a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams n2 = n(view);
            this.f11365c = StaggeredGridLayoutManager.this.f11321k.d(view);
            if (n2.f11346f && (f2 = StaggeredGridLayoutManager.this.f11331u.f(n2.a())) != null && f2.f11350c == 1) {
                this.f11365c += f2.b(this.f11367e);
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            LazySpanLookup.FullSpanItem f2;
            View view = this.f11363a.get(0);
            LayoutParams n2 = n(view);
            this.f11364b = StaggeredGridLayoutManager.this.f11321k.g(view);
            if (n2.f11346f && (f2 = StaggeredGridLayoutManager.this.f11331u.f(n2.a())) != null && f2.f11350c == -1) {
                this.f11364b -= f2.b(this.f11367e);
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f11363a.clear();
            q();
            this.f11366d = 0;
        }

        public int f() {
            if (StaggeredGridLayoutManager.this.f11326p) {
                return i(this.f11363a.size() - 1, -1, true);
            }
            return i(0, this.f11363a.size(), true);
        }

        public int g() {
            if (StaggeredGridLayoutManager.this.f11326p) {
                return i(0, this.f11363a.size(), true);
            }
            return i(this.f11363a.size() - 1, -1, true);
        }

        /* access modifiers changed from: package-private */
        public int h(int i2, int i3, boolean z2, boolean z3, boolean z4) {
            int i4;
            boolean z5;
            int m2 = StaggeredGridLayoutManager.this.f11321k.m();
            int i5 = StaggeredGridLayoutManager.this.f11321k.i();
            if (i3 > i2) {
                i4 = 1;
            } else {
                i4 = -1;
            }
            while (i2 != i3) {
                View view = this.f11363a.get(i2);
                int g2 = StaggeredGridLayoutManager.this.f11321k.g(view);
                int d2 = StaggeredGridLayoutManager.this.f11321k.d(view);
                boolean z6 = false;
                if (!z4 ? g2 >= i5 : g2 > i5) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (!z4 ? d2 > m2 : d2 >= m2) {
                    z6 = true;
                }
                if (z5 && z6) {
                    if (!z2 || !z3) {
                        if (z3) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (g2 < m2 || d2 > i5) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else if (g2 >= m2 && d2 <= i5) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i2 += i4;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int i(int i2, int i3, boolean z2) {
            return h(i2, i3, false, false, z2);
        }

        public int j() {
            return this.f11366d;
        }

        /* access modifiers changed from: package-private */
        public int k() {
            int i2 = this.f11365c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            c();
            return this.f11365c;
        }

        /* access modifiers changed from: package-private */
        public int l(int i2) {
            int i3 = this.f11365c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f11363a.size() == 0) {
                return i2;
            }
            c();
            return this.f11365c;
        }

        public View m(int i2, int i3) {
            View view = null;
            if (i3 != -1) {
                int size = this.f11363a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f11363a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f11326p && staggeredGridLayoutManager.getPosition(view2) >= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f11326p && staggeredGridLayoutManager2.getPosition(view2) <= i2) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f11363a.size();
                int i4 = 0;
                while (i4 < size2) {
                    View view3 = this.f11363a.get(i4);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f11326p && staggeredGridLayoutManager3.getPosition(view3) <= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f11326p && staggeredGridLayoutManager4.getPosition(view3) >= i2) || !view3.hasFocusable()) {
                        break;
                    }
                    i4++;
                    view = view3;
                }
            }
            return view;
        }

        /* access modifiers changed from: package-private */
        public LayoutParams n(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        public int o() {
            int i2 = this.f11364b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            d();
            return this.f11364b;
        }

        /* access modifiers changed from: package-private */
        public int p(int i2) {
            int i3 = this.f11364b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f11363a.size() == 0) {
                return i2;
            }
            d();
            return this.f11364b;
        }

        /* access modifiers changed from: package-private */
        public void q() {
            this.f11364b = Integer.MIN_VALUE;
            this.f11365c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void r(int i2) {
            int i3 = this.f11364b;
            if (i3 != Integer.MIN_VALUE) {
                this.f11364b = i3 + i2;
            }
            int i4 = this.f11365c;
            if (i4 != Integer.MIN_VALUE) {
                this.f11365c = i4 + i2;
            }
        }

        /* access modifiers changed from: package-private */
        public void s() {
            int size = this.f11363a.size();
            View remove = this.f11363a.remove(size - 1);
            LayoutParams n2 = n(remove);
            n2.f11345e = null;
            if (n2.c() || n2.b()) {
                this.f11366d -= StaggeredGridLayoutManager.this.f11321k.e(remove);
            }
            if (size == 1) {
                this.f11364b = Integer.MIN_VALUE;
            }
            this.f11365c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void t() {
            View remove = this.f11363a.remove(0);
            LayoutParams n2 = n(remove);
            n2.f11345e = null;
            if (this.f11363a.size() == 0) {
                this.f11365c = Integer.MIN_VALUE;
            }
            if (n2.c() || n2.b()) {
                this.f11366d -= StaggeredGridLayoutManager.this.f11321k.e(remove);
            }
            this.f11364b = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void u(View view) {
            LayoutParams n2 = n(view);
            n2.f11345e = this;
            this.f11363a.add(0, view);
            this.f11364b = Integer.MIN_VALUE;
            if (this.f11363a.size() == 1) {
                this.f11365c = Integer.MIN_VALUE;
            }
            if (n2.c() || n2.b()) {
                this.f11366d += StaggeredGridLayoutManager.this.f11321k.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void v(int i2) {
            this.f11364b = i2;
            this.f11365c = i2;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i2, i3);
        setOrientation(properties.f11240a);
        P(properties.f11241b);
        setReverseLayout(properties.f11242c);
        this.f11325o = new LayoutState();
        k();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void B(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f11327q
            if (r0 == 0) goto L_0x0009
            int r0 = r6.u()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.t()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001a
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001c
        L_0x0016:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001d
        L_0x001a:
            int r2 = r7 + r8
        L_0x001c:
            r3 = r7
        L_0x001d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.f11331u
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003c
            r5 = 2
            if (r9 == r5) goto L_0x0036
            if (r9 == r1) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f11331u
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.f11331u
            r7.j(r8, r4)
            goto L_0x0041
        L_0x0036:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f11331u
            r9.k(r7, r8)
            goto L_0x0041
        L_0x003c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f11331u
            r9.j(r7, r8)
        L_0x0041:
            if (r2 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r7 = r6.f11327q
            if (r7 == 0) goto L_0x004d
            int r7 = r6.t()
            goto L_0x0051
        L_0x004d:
            int r7 = r6.u()
        L_0x0051:
            if (r3 > r7) goto L_0x0056
            r6.requestLayout()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.B(int, int, int):void");
    }

    private void E(View view, int i2, int i3, boolean z2) {
        boolean z3;
        calculateItemDecorationsForChild(view, this.A);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = layoutParams.leftMargin;
        Rect rect = this.A;
        int X = X(i2, i4 + rect.left, layoutParams.rightMargin + rect.right);
        int i5 = layoutParams.topMargin;
        Rect rect2 = this.A;
        int X2 = X(i3, i5 + rect2.top, layoutParams.bottomMargin + rect2.bottom);
        if (z2) {
            z3 = shouldReMeasureChild(view, X, X2, layoutParams);
        } else {
            z3 = shouldMeasureChild(view, X, X2, layoutParams);
        }
        if (z3) {
            view.measure(X, X2);
        }
    }

    private void F(View view, LayoutParams layoutParams, boolean z2) {
        if (layoutParams.f11346f) {
            if (this.f11323m == 1) {
                E(view, this.f11336z, RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true), z2);
            } else {
                E(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), this.f11336z, z2);
            }
        } else if (this.f11323m == 1) {
            E(view, RecyclerView.LayoutManager.getChildMeasureSpec(this.f11324n, getWidthMode(), 0, layoutParams.width, false), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true), z2);
        } else {
            E(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.f11324n, getHeightMode(), 0, layoutParams.height, false), z2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0157, code lost:
        if (g() != false) goto L_0x015b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void G(androidx.recyclerview.widget.RecyclerView.Recycler r9, androidx.recyclerview.widget.RecyclerView.State r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r0 = r8.B
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.f11335y
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.f11329s
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.b()
            if (r1 != 0) goto L_0x0018
            r8.removeAndRecycleAllViews(r9)
            r0.c()
            return
        L_0x0018:
            boolean r1 = r0.f11342e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.f11329s
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.f11335y
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.c()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.f11335y
            if (r5 == 0) goto L_0x0037
            r8.b(r0)
            goto L_0x003e
        L_0x0037:
            r8.resolveShouldLayoutReverse()
            boolean r5 = r8.f11327q
            r0.f11340c = r5
        L_0x003e:
            r8.T(r10, r0)
            r0.f11342e = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.f11335y
            if (r5 != 0) goto L_0x0060
            int r5 = r8.f11329s
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.f11340c
            boolean r6 = r8.f11333w
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.isLayoutRTL()
            boolean r6 = r8.f11334x
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r5 = r8.f11331u
            r5.b()
            r0.f11341d = r4
        L_0x0060:
            int r5 = r8.getChildCount()
            if (r5 <= 0) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.f11335y
            if (r5 == 0) goto L_0x006e
            int r5 = r5.f11355d
            if (r5 >= r4) goto L_0x00c9
        L_0x006e:
            boolean r5 = r0.f11341d
            if (r5 == 0) goto L_0x008e
            r1 = 0
        L_0x0073:
            int r5 = r8.f11319i
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r5 = r8.f11320j
            r5 = r5[r1]
            r5.e()
            int r5 = r0.f11339b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008b
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r6 = r8.f11320j
            r6 = r6[r1]
            r6.v(r5)
        L_0x008b:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x008e:
            if (r1 != 0) goto L_0x00af
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r1 = r8.B
            int[] r1 = r1.f11343f
            if (r1 != 0) goto L_0x0097
            goto L_0x00af
        L_0x0097:
            r1 = 0
        L_0x0098:
            int r5 = r8.f11319i
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r5 = r8.f11320j
            r5 = r5[r1]
            r5.e()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r6 = r8.B
            int[] r6 = r6.f11343f
            r6 = r6[r1]
            r5.v(r6)
            int r1 = r1 + 1
            goto L_0x0098
        L_0x00af:
            r1 = 0
        L_0x00b0:
            int r5 = r8.f11319i
            if (r1 >= r5) goto L_0x00c2
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r5 = r8.f11320j
            r5 = r5[r1]
            boolean r6 = r8.f11327q
            int r7 = r0.f11339b
            r5.b(r6, r7)
            int r1 = r1 + 1
            goto L_0x00b0
        L_0x00c2:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r1 = r8.B
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r5 = r8.f11320j
            r1.d(r5)
        L_0x00c9:
            r8.detachAndScrapAttachedViews(r9)
            androidx.recyclerview.widget.LayoutState r1 = r8.f11325o
            r1.f11173a = r3
            r8.C = r3
            androidx.recyclerview.widget.OrientationHelper r1 = r8.f11322l
            int r1 = r1.n()
            r8.V(r1)
            int r1 = r0.f11338a
            r8.U(r1, r10)
            boolean r1 = r0.f11340c
            if (r1 == 0) goto L_0x00fc
            r8.O(r2)
            androidx.recyclerview.widget.LayoutState r1 = r8.f11325o
            r8.l(r9, r1, r10)
            r8.O(r4)
            androidx.recyclerview.widget.LayoutState r1 = r8.f11325o
            int r2 = r0.f11338a
            int r5 = r1.f11176d
            int r2 = r2 + r5
            r1.f11175c = r2
            r8.l(r9, r1, r10)
            goto L_0x0113
        L_0x00fc:
            r8.O(r4)
            androidx.recyclerview.widget.LayoutState r1 = r8.f11325o
            r8.l(r9, r1, r10)
            r8.O(r2)
            androidx.recyclerview.widget.LayoutState r1 = r8.f11325o
            int r2 = r0.f11338a
            int r5 = r1.f11176d
            int r2 = r2 + r5
            r1.f11175c = r2
            r8.l(r9, r1, r10)
        L_0x0113:
            r8.N()
            int r1 = r8.getChildCount()
            if (r1 <= 0) goto L_0x012d
            boolean r1 = r8.f11327q
            if (r1 == 0) goto L_0x0127
            r8.r(r9, r10, r4)
            r8.s(r9, r10, r3)
            goto L_0x012d
        L_0x0127:
            r8.s(r9, r10, r4)
            r8.r(r9, r10, r3)
        L_0x012d:
            if (r11 == 0) goto L_0x015a
            boolean r11 = r10.e()
            if (r11 != 0) goto L_0x015a
            int r11 = r8.f11332v
            if (r11 == 0) goto L_0x014b
            int r11 = r8.getChildCount()
            if (r11 <= 0) goto L_0x014b
            boolean r11 = r8.C
            if (r11 != 0) goto L_0x0149
            android.view.View r11 = r8.C()
            if (r11 == 0) goto L_0x014b
        L_0x0149:
            r11 = 1
            goto L_0x014c
        L_0x014b:
            r11 = 0
        L_0x014c:
            if (r11 == 0) goto L_0x015a
            java.lang.Runnable r11 = r8.F
            r8.removeCallbacks(r11)
            boolean r11 = r8.g()
            if (r11 == 0) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r4 = 0
        L_0x015b:
            boolean r11 = r10.e()
            if (r11 == 0) goto L_0x0166
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r11 = r8.B
            r11.c()
        L_0x0166:
            boolean r11 = r0.f11340c
            r8.f11333w = r11
            boolean r11 = r8.isLayoutRTL()
            r8.f11334x = r11
            if (r4 == 0) goto L_0x017a
            androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo r11 = r8.B
            r11.c()
            r8.G(r9, r10, r3)
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.G(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    private boolean H(int i2) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (this.f11323m == 0) {
            if (i2 == -1) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4 != this.f11327q) {
                return true;
            }
            return false;
        }
        if (i2 == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 == this.f11327q) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 == isLayoutRTL()) {
            return true;
        }
        return false;
    }

    private void J(View view) {
        for (int i2 = this.f11319i - 1; i2 >= 0; i2--) {
            this.f11320j[i2].u(view);
        }
    }

    private void K(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int i2;
        int i3;
        if (layoutState.f11173a && !layoutState.f11181i) {
            if (layoutState.f11174b == 0) {
                if (layoutState.f11177e == -1) {
                    L(recycler, layoutState.f11179g);
                } else {
                    M(recycler, layoutState.f11178f);
                }
            } else if (layoutState.f11177e == -1) {
                int i4 = layoutState.f11178f;
                int w2 = i4 - w(i4);
                if (w2 < 0) {
                    i3 = layoutState.f11179g;
                } else {
                    i3 = layoutState.f11179g - Math.min(w2, layoutState.f11174b);
                }
                L(recycler, i3);
            } else {
                int x2 = x(layoutState.f11179g) - layoutState.f11179g;
                if (x2 < 0) {
                    i2 = layoutState.f11178f;
                } else {
                    i2 = Math.min(x2, layoutState.f11174b) + layoutState.f11178f;
                }
                M(recycler, i2);
            }
        }
    }

    private void L(RecyclerView.Recycler recycler, int i2) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.f11321k.g(childAt) >= i2 && this.f11321k.q(childAt) >= i2) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f11346f) {
                    int i3 = 0;
                    while (i3 < this.f11319i) {
                        if (this.f11320j[i3].f11363a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.f11319i; i4++) {
                        this.f11320j[i4].s();
                    }
                } else if (layoutParams.f11345e.f11363a.size() != 1) {
                    layoutParams.f11345e.s();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
                childCount--;
            } else {
                return;
            }
        }
    }

    private void M(RecyclerView.Recycler recycler, int i2) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f11321k.d(childAt) <= i2 && this.f11321k.p(childAt) <= i2) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f11346f) {
                    int i3 = 0;
                    while (i3 < this.f11319i) {
                        if (this.f11320j[i3].f11363a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.f11319i; i4++) {
                        this.f11320j[i4].t();
                    }
                } else if (layoutParams.f11345e.f11363a.size() != 1) {
                    layoutParams.f11345e.t();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    private void N() {
        if (this.f11322l.k() != 1073741824) {
            int childCount = getChildCount();
            float f2 = 0.0f;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                float e2 = (float) this.f11322l.e(childAt);
                if (e2 >= f2) {
                    if (((LayoutParams) childAt.getLayoutParams()).e()) {
                        e2 = (e2 * 1.0f) / ((float) this.f11319i);
                    }
                    f2 = Math.max(f2, e2);
                }
            }
            int i3 = this.f11324n;
            int round = Math.round(f2 * ((float) this.f11319i));
            if (this.f11322l.k() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f11322l.n());
            }
            V(round);
            if (this.f11324n != i3) {
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt2 = getChildAt(i4);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (!layoutParams.f11346f) {
                        if (!isLayoutRTL() || this.f11323m != 1) {
                            int i5 = layoutParams.f11345e.f11367e;
                            int i6 = this.f11324n * i5;
                            int i7 = i5 * i3;
                            if (this.f11323m == 1) {
                                childAt2.offsetLeftAndRight(i6 - i7);
                            } else {
                                childAt2.offsetTopAndBottom(i6 - i7);
                            }
                        } else {
                            int i8 = this.f11319i;
                            int i9 = layoutParams.f11345e.f11367e;
                            childAt2.offsetLeftAndRight(((-((i8 - 1) - i9)) * this.f11324n) - ((-((i8 - 1) - i9)) * i3));
                        }
                    }
                }
            }
        }
    }

    private void O(int i2) {
        boolean z2;
        LayoutState layoutState = this.f11325o;
        layoutState.f11177e = i2;
        boolean z3 = this.f11327q;
        int i3 = 1;
        if (i2 == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z3 != z2) {
            i3 = -1;
        }
        layoutState.f11176d = i3;
    }

    private void Q(int i2, int i3) {
        for (int i4 = 0; i4 < this.f11319i; i4++) {
            if (!this.f11320j[i4].f11363a.isEmpty()) {
                W(this.f11320j[i4], i2, i3);
            }
        }
    }

    private boolean R(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i2;
        if (this.f11333w) {
            i2 = q(state.b());
        } else {
            i2 = m(state.b());
        }
        anchorInfo.f11338a = i2;
        anchorInfo.f11339b = Integer.MIN_VALUE;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void U(int r5, androidx.recyclerview.widget.RecyclerView.State r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.LayoutState r0 = r4.f11325o
            r1 = 0
            r0.f11174b = r1
            r0.f11175c = r5
            boolean r0 = r4.isSmoothScrolling()
            r2 = 1
            if (r0 == 0) goto L_0x002e
            int r6 = r6.c()
            r0 = -1
            if (r6 == r0) goto L_0x002e
            boolean r0 = r4.f11327q
            if (r6 >= r5) goto L_0x001b
            r5 = 1
            goto L_0x001c
        L_0x001b:
            r5 = 0
        L_0x001c:
            if (r0 != r5) goto L_0x0025
            androidx.recyclerview.widget.OrientationHelper r5 = r4.f11321k
            int r5 = r5.n()
            goto L_0x002f
        L_0x0025:
            androidx.recyclerview.widget.OrientationHelper r5 = r4.f11321k
            int r5 = r5.n()
            r6 = r5
            r5 = 0
            goto L_0x0030
        L_0x002e:
            r5 = 0
        L_0x002f:
            r6 = 0
        L_0x0030:
            boolean r0 = r4.getClipToPadding()
            if (r0 == 0) goto L_0x004d
            androidx.recyclerview.widget.LayoutState r0 = r4.f11325o
            androidx.recyclerview.widget.OrientationHelper r3 = r4.f11321k
            int r3 = r3.m()
            int r3 = r3 - r6
            r0.f11178f = r3
            androidx.recyclerview.widget.LayoutState r6 = r4.f11325o
            androidx.recyclerview.widget.OrientationHelper r0 = r4.f11321k
            int r0 = r0.i()
            int r0 = r0 + r5
            r6.f11179g = r0
            goto L_0x005d
        L_0x004d:
            androidx.recyclerview.widget.LayoutState r0 = r4.f11325o
            androidx.recyclerview.widget.OrientationHelper r3 = r4.f11321k
            int r3 = r3.h()
            int r3 = r3 + r5
            r0.f11179g = r3
            androidx.recyclerview.widget.LayoutState r5 = r4.f11325o
            int r6 = -r6
            r5.f11178f = r6
        L_0x005d:
            androidx.recyclerview.widget.LayoutState r5 = r4.f11325o
            r5.f11180h = r1
            r5.f11173a = r2
            androidx.recyclerview.widget.OrientationHelper r6 = r4.f11321k
            int r6 = r6.k()
            if (r6 != 0) goto L_0x0074
            androidx.recyclerview.widget.OrientationHelper r6 = r4.f11321k
            int r6 = r6.h()
            if (r6 != 0) goto L_0x0074
            r1 = 1
        L_0x0074:
            r5.f11181i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.U(int, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    private void W(Span span, int i2, int i3) {
        int j2 = span.j();
        if (i2 == -1) {
            if (span.o() + j2 <= i3) {
                this.f11328r.set(span.f11367e, false);
            }
        } else if (span.k() - j2 >= i3) {
            this.f11328r.set(span.f11367e, false);
        }
    }

    private int X(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode);
        }
        return i2;
    }

    private void a(View view) {
        for (int i2 = this.f11319i - 1; i2 >= 0; i2--) {
            this.f11320j[i2].a(view);
        }
    }

    private void b(AnchorInfo anchorInfo) {
        int i2;
        SavedState savedState = this.f11335y;
        int i3 = savedState.f11355d;
        if (i3 > 0) {
            if (i3 == this.f11319i) {
                for (int i4 = 0; i4 < this.f11319i; i4++) {
                    this.f11320j[i4].e();
                    SavedState savedState2 = this.f11335y;
                    int i5 = savedState2.f11356e[i4];
                    if (i5 != Integer.MIN_VALUE) {
                        if (savedState2.f11361j) {
                            i2 = this.f11321k.i();
                        } else {
                            i2 = this.f11321k.m();
                        }
                        i5 += i2;
                    }
                    this.f11320j[i4].v(i5);
                }
            } else {
                savedState.c();
                SavedState savedState3 = this.f11335y;
                savedState3.f11353b = savedState3.f11354c;
            }
        }
        SavedState savedState4 = this.f11335y;
        this.f11334x = savedState4.f11362k;
        setReverseLayout(savedState4.f11360i);
        resolveShouldLayoutReverse();
        SavedState savedState5 = this.f11335y;
        int i6 = savedState5.f11353b;
        if (i6 != -1) {
            this.f11329s = i6;
            anchorInfo.f11340c = savedState5.f11361j;
        } else {
            anchorInfo.f11340c = this.f11327q;
        }
        if (savedState5.f11357f > 1) {
            LazySpanLookup lazySpanLookup = this.f11331u;
            lazySpanLookup.f11347a = savedState5.f11358g;
            lazySpanLookup.f11348b = savedState5.f11359h;
        }
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.a(state, this.f11321k, o(!this.D), n(!this.D), this, this.D);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.b(state, this.f11321k, o(!this.D), n(!this.D), this, this.D, this.f11327q);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.c(state, this.f11321k, o(!this.D), n(!this.D), this, this.D);
    }

    private int convertFocusDirectionToLayoutDirection(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 17) {
                    if (i2 != 33) {
                        if (i2 != 66) {
                            if (i2 == 130 && this.f11323m == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        } else if (this.f11323m == 0) {
                            return 1;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    } else if (this.f11323m == 1) {
                        return -1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.f11323m == 0) {
                    return -1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.f11323m != 1 && isLayoutRTL()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.f11323m != 1 && isLayoutRTL()) {
            return 1;
        } else {
            return -1;
        }
    }

    private void e(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.f11177e == 1) {
            if (layoutParams.f11346f) {
                a(view);
            } else {
                layoutParams.f11345e.a(view);
            }
        } else if (layoutParams.f11346f) {
            J(view);
        } else {
            layoutParams.f11345e.u(view);
        }
    }

    private int f(int i2) {
        boolean z2;
        if (getChildCount() != 0) {
            if (i2 < t()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 != this.f11327q) {
                return -1;
            }
            return 1;
        } else if (this.f11327q) {
            return 1;
        } else {
            return -1;
        }
    }

    private boolean h(Span span) {
        if (this.f11327q) {
            if (span.k() < this.f11321k.i()) {
                ArrayList<View> arrayList = span.f11363a;
                return !span.n(arrayList.get(arrayList.size() - 1)).f11346f;
            }
        } else if (span.o() > this.f11321k.m()) {
            return !span.n(span.f11363a.get(0)).f11346f;
        }
        return false;
    }

    private LazySpanLookup.FullSpanItem i(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f11351d = new int[this.f11319i];
        for (int i3 = 0; i3 < this.f11319i; i3++) {
            fullSpanItem.f11351d[i3] = i2 - this.f11320j[i3].l(i2);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem j(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f11351d = new int[this.f11319i];
        for (int i3 = 0; i3 < this.f11319i; i3++) {
            fullSpanItem.f11351d[i3] = this.f11320j[i3].p(i2) - i2;
        }
        return fullSpanItem;
    }

    private void k() {
        this.f11321k = OrientationHelper.b(this, this.f11323m);
        this.f11322l = OrientationHelper.b(this, 1 - this.f11323m);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r9v5 */
    private int l(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        int i2;
        int i3;
        int i4;
        boolean z2;
        Span span;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z3;
        int i11;
        int i12;
        int i13;
        RecyclerView.Recycler recycler2 = recycler;
        LayoutState layoutState2 = layoutState;
        ? r9 = 0;
        this.f11328r.set(0, this.f11319i, true);
        if (!this.f11325o.f11181i) {
            if (layoutState2.f11177e == 1) {
                i13 = layoutState2.f11179g + layoutState2.f11174b;
            } else {
                i13 = layoutState2.f11178f - layoutState2.f11174b;
            }
            i2 = i13;
        } else if (layoutState2.f11177e == 1) {
            i2 = Integer.MAX_VALUE;
        } else {
            i2 = Integer.MIN_VALUE;
        }
        Q(layoutState2.f11177e, i2);
        if (this.f11327q) {
            i3 = this.f11321k.i();
        } else {
            i3 = this.f11321k.m();
        }
        int i14 = i3;
        boolean z4 = false;
        while (layoutState.a(state) && (this.f11325o.f11181i || !this.f11328r.isEmpty())) {
            View b2 = layoutState2.b(recycler2);
            LayoutParams layoutParams = (LayoutParams) b2.getLayoutParams();
            int a2 = layoutParams.a();
            int g2 = this.f11331u.g(a2);
            if (g2 == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (layoutParams.f11346f) {
                    span = this.f11320j[r9];
                } else {
                    span = z(layoutState2);
                }
                this.f11331u.n(a2, span);
            } else {
                span = this.f11320j[g2];
            }
            Span span2 = span;
            layoutParams.f11345e = span2;
            if (layoutState2.f11177e == 1) {
                addView(b2);
            } else {
                addView(b2, r9);
            }
            F(b2, layoutParams, r9);
            if (layoutState2.f11177e == 1) {
                if (layoutParams.f11346f) {
                    i12 = v(i14);
                } else {
                    i12 = span2.l(i14);
                }
                int e2 = this.f11321k.e(b2) + i12;
                if (z2 && layoutParams.f11346f) {
                    LazySpanLookup.FullSpanItem i15 = i(i12);
                    i15.f11350c = -1;
                    i15.f11349b = a2;
                    this.f11331u.a(i15);
                }
                i5 = e2;
                i6 = i12;
            } else {
                if (layoutParams.f11346f) {
                    i11 = y(i14);
                } else {
                    i11 = span2.p(i14);
                }
                i6 = i11 - this.f11321k.e(b2);
                if (z2 && layoutParams.f11346f) {
                    LazySpanLookup.FullSpanItem j2 = j(i11);
                    j2.f11350c = 1;
                    j2.f11349b = a2;
                    this.f11331u.a(j2);
                }
                i5 = i11;
            }
            if (layoutParams.f11346f && layoutState2.f11176d == -1) {
                if (z2) {
                    this.C = true;
                } else {
                    if (layoutState2.f11177e == 1) {
                        z3 = c();
                    } else {
                        z3 = d();
                    }
                    if (!z3) {
                        LazySpanLookup.FullSpanItem f2 = this.f11331u.f(a2);
                        if (f2 != null) {
                            f2.f11352e = true;
                        }
                        this.C = true;
                    }
                }
            }
            e(b2, layoutParams, layoutState2);
            if (!isLayoutRTL() || this.f11323m != 1) {
                if (layoutParams.f11346f) {
                    i9 = this.f11322l.m();
                } else {
                    i9 = (span2.f11367e * this.f11324n) + this.f11322l.m();
                }
                i8 = i9;
                i7 = this.f11322l.e(b2) + i9;
            } else {
                if (layoutParams.f11346f) {
                    i10 = this.f11322l.i();
                } else {
                    i10 = this.f11322l.i() - (((this.f11319i - 1) - span2.f11367e) * this.f11324n);
                }
                i7 = i10;
                i8 = i10 - this.f11322l.e(b2);
            }
            if (this.f11323m == 1) {
                layoutDecoratedWithMargins(b2, i8, i6, i7, i5);
            } else {
                layoutDecoratedWithMargins(b2, i6, i8, i5, i7);
            }
            if (layoutParams.f11346f) {
                Q(this.f11325o.f11177e, i2);
            } else {
                W(span2, this.f11325o.f11177e, i2);
            }
            K(recycler2, this.f11325o);
            if (this.f11325o.f11180h && b2.hasFocusable()) {
                if (layoutParams.f11346f) {
                    this.f11328r.clear();
                } else {
                    this.f11328r.set(span2.f11367e, false);
                    z4 = true;
                    r9 = 0;
                }
            }
            z4 = true;
            r9 = 0;
        }
        if (!z4) {
            K(recycler2, this.f11325o);
        }
        if (this.f11325o.f11177e == -1) {
            i4 = this.f11321k.m() - y(this.f11321k.m());
        } else {
            i4 = v(this.f11321k.i()) - this.f11321k.i();
        }
        if (i4 > 0) {
            return Math.min(layoutState2.f11174b, i4);
        }
        return 0;
    }

    private int m(int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            int position = getPosition(getChildAt(i3));
            if (position >= 0 && position < i2) {
                return position;
            }
        }
        return 0;
    }

    private int q(int i2) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i2) {
                return position;
            }
        }
        return 0;
    }

    private void r(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int i2;
        int v2 = v(Integer.MIN_VALUE);
        if (v2 != Integer.MIN_VALUE && (i2 = this.f11321k.i() - v2) > 0) {
            int i3 = i2 - (-scrollBy(-i2, recycler, state));
            if (z2 && i3 > 0) {
                this.f11321k.r(i3);
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.f11323m == 1 || !isLayoutRTL()) {
            this.f11327q = this.f11326p;
        } else {
            this.f11327q = !this.f11326p;
        }
    }

    private void s(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int m2;
        int y2 = y(Integer.MAX_VALUE);
        if (y2 != Integer.MAX_VALUE && (m2 = y2 - this.f11321k.m()) > 0) {
            int scrollBy = m2 - scrollBy(m2, recycler, state);
            if (z2 && scrollBy > 0) {
                this.f11321k.r(-scrollBy);
            }
        }
    }

    private int v(int i2) {
        int l2 = this.f11320j[0].l(i2);
        for (int i3 = 1; i3 < this.f11319i; i3++) {
            int l3 = this.f11320j[i3].l(i2);
            if (l3 > l2) {
                l2 = l3;
            }
        }
        return l2;
    }

    private int w(int i2) {
        int p2 = this.f11320j[0].p(i2);
        for (int i3 = 1; i3 < this.f11319i; i3++) {
            int p3 = this.f11320j[i3].p(i2);
            if (p3 > p2) {
                p2 = p3;
            }
        }
        return p2;
    }

    private int x(int i2) {
        int l2 = this.f11320j[0].l(i2);
        for (int i3 = 1; i3 < this.f11319i; i3++) {
            int l3 = this.f11320j[i3].l(i2);
            if (l3 < l2) {
                l2 = l3;
            }
        }
        return l2;
    }

    private int y(int i2) {
        int p2 = this.f11320j[0].p(i2);
        for (int i3 = 1; i3 < this.f11319i; i3++) {
            int p3 = this.f11320j[i3].p(i2);
            if (p3 < p2) {
                p2 = p3;
            }
        }
        return p2;
    }

    private Span z(LayoutState layoutState) {
        int i2;
        int i3;
        int i4;
        if (H(layoutState.f11177e)) {
            i4 = this.f11319i - 1;
            i3 = -1;
            i2 = -1;
        } else {
            i3 = this.f11319i;
            i4 = 0;
            i2 = 1;
        }
        Span span = null;
        if (layoutState.f11177e == 1) {
            int m2 = this.f11321k.m();
            int i5 = Integer.MAX_VALUE;
            while (i4 != i3) {
                Span span2 = this.f11320j[i4];
                int l2 = span2.l(m2);
                if (l2 < i5) {
                    span = span2;
                    i5 = l2;
                }
                i4 += i2;
            }
            return span;
        }
        int i6 = this.f11321k.i();
        int i7 = Integer.MIN_VALUE;
        while (i4 != i3) {
            Span span3 = this.f11320j[i4];
            int p2 = span3.p(i6);
            if (p2 > i7) {
                span = span3;
                i7 = p2;
            }
            i4 += i2;
        }
        return span;
    }

    public int A() {
        return this.f11319i;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View C() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f11319i
            r2.<init>(r3)
            int r3 = r12.f11319i
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f11323m
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.isLayoutRTL()
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            boolean r6 = r12.f11327q
            if (r6 == 0) goto L_0x0027
            r6 = -1
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = 1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.f11345e
            int r9 = r9.f11367e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.f11345e
            boolean r9 = r12.h(r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.f11345e
            int r9 = r9.f11367e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f11346f
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.f11327q
            if (r10 == 0) goto L_0x0077
            androidx.recyclerview.widget.OrientationHelper r10 = r12.f11321k
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.f11321k
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            androidx.recyclerview.widget.OrientationHelper r10 = r12.f11321k
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.f11321k
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = 1
            goto L_0x008b
        L_0x008a:
            r10 = 0
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r8 = r8.f11345e
            int r8 = r8.f11367e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r9.f11345e
            int r9 = r9.f11367e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = 1
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = 1
            goto L_0x00a6
        L_0x00a5:
            r9 = 0
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.C():android.view.View");
    }

    public void D() {
        this.f11331u.b();
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void I(int i2, RecyclerView.State state) {
        int i3;
        int i4;
        if (i2 > 0) {
            i4 = u();
            i3 = 1;
        } else {
            i4 = t();
            i3 = -1;
        }
        this.f11325o.f11173a = true;
        U(i4, state);
        O(i3);
        LayoutState layoutState = this.f11325o;
        layoutState.f11175c = i4 + layoutState.f11176d;
        layoutState.f11174b = Math.abs(i2);
    }

    public void P(int i2) {
        assertNotInLayoutOrScroll((String) null);
        if (i2 != this.f11319i) {
            D();
            this.f11319i = i2;
            this.f11328r = new BitSet(this.f11319i);
            this.f11320j = new Span[this.f11319i];
            for (int i3 = 0; i3 < this.f11319i; i3++) {
                this.f11320j[i3] = new Span(i3);
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean S(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i2;
        int i3;
        int i4;
        boolean z2 = false;
        if (!state.e() && (i2 = this.f11329s) != -1) {
            if (i2 < 0 || i2 >= state.b()) {
                this.f11329s = -1;
                this.f11330t = Integer.MIN_VALUE;
            } else {
                SavedState savedState = this.f11335y;
                if (savedState == null || savedState.f11353b == -1 || savedState.f11355d < 1) {
                    View findViewByPosition = findViewByPosition(this.f11329s);
                    if (findViewByPosition != null) {
                        if (this.f11327q) {
                            i3 = u();
                        } else {
                            i3 = t();
                        }
                        anchorInfo.f11338a = i3;
                        if (this.f11330t != Integer.MIN_VALUE) {
                            if (anchorInfo.f11340c) {
                                anchorInfo.f11339b = (this.f11321k.i() - this.f11330t) - this.f11321k.d(findViewByPosition);
                            } else {
                                anchorInfo.f11339b = (this.f11321k.m() + this.f11330t) - this.f11321k.g(findViewByPosition);
                            }
                            return true;
                        } else if (this.f11321k.e(findViewByPosition) > this.f11321k.n()) {
                            if (anchorInfo.f11340c) {
                                i4 = this.f11321k.i();
                            } else {
                                i4 = this.f11321k.m();
                            }
                            anchorInfo.f11339b = i4;
                            return true;
                        } else {
                            int g2 = this.f11321k.g(findViewByPosition) - this.f11321k.m();
                            if (g2 < 0) {
                                anchorInfo.f11339b = -g2;
                                return true;
                            }
                            int i5 = this.f11321k.i() - this.f11321k.d(findViewByPosition);
                            if (i5 < 0) {
                                anchorInfo.f11339b = i5;
                                return true;
                            }
                            anchorInfo.f11339b = Integer.MIN_VALUE;
                        }
                    } else {
                        int i6 = this.f11329s;
                        anchorInfo.f11338a = i6;
                        int i7 = this.f11330t;
                        if (i7 == Integer.MIN_VALUE) {
                            if (f(i6) == 1) {
                                z2 = true;
                            }
                            anchorInfo.f11340c = z2;
                            anchorInfo.a();
                        } else {
                            anchorInfo.b(i7);
                        }
                        anchorInfo.f11341d = true;
                    }
                } else {
                    anchorInfo.f11339b = Integer.MIN_VALUE;
                    anchorInfo.f11338a = this.f11329s;
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void T(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (!S(state, anchorInfo) && !R(state, anchorInfo)) {
            anchorInfo.a();
            anchorInfo.f11338a = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void V(int i2) {
        this.f11324n = i2 / this.f11319i;
        this.f11336z = View.MeasureSpec.makeMeasureSpec(i2, this.f11322l.k());
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.f11335y == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        int l2 = this.f11320j[0].l(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.f11319i; i2++) {
            if (this.f11320j[i2].l(Integer.MIN_VALUE) != l2) {
                return false;
            }
        }
        return true;
    }

    public boolean canScrollHorizontally() {
        return this.f11323m == 0;
    }

    public boolean canScrollVertically() {
        return this.f11323m == 1;
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void collectAdjacentPrefetchPositions(int i2, int i3, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i4;
        int i5;
        if (this.f11323m != 0) {
            i2 = i3;
        }
        if (getChildCount() != 0 && i2 != 0) {
            I(i2, state);
            int[] iArr = this.E;
            if (iArr == null || iArr.length < this.f11319i) {
                this.E = new int[this.f11319i];
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.f11319i; i7++) {
                LayoutState layoutState = this.f11325o;
                if (layoutState.f11176d == -1) {
                    i5 = layoutState.f11178f;
                    i4 = this.f11320j[i7].p(i5);
                } else {
                    i5 = this.f11320j[i7].l(layoutState.f11179g);
                    i4 = this.f11325o.f11179g;
                }
                int i8 = i5 - i4;
                if (i8 >= 0) {
                    this.E[i6] = i8;
                    i6++;
                }
            }
            Arrays.sort(this.E, 0, i6);
            for (int i9 = 0; i9 < i6 && this.f11325o.a(state); i9++) {
                layoutPrefetchRegistry.a(this.f11325o.f11175c, this.E[i9]);
                LayoutState layoutState2 = this.f11325o;
                layoutState2.f11175c += layoutState2.f11176d;
            }
        }
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public PointF computeScrollVectorForPosition(int i2) {
        int f2 = f(i2);
        PointF pointF = new PointF();
        if (f2 == 0) {
            return null;
        }
        if (this.f11323m == 0) {
            pointF.x = (float) f2;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) f2;
        }
        return pointF;
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        int p2 = this.f11320j[0].p(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.f11319i; i2++) {
            if (this.f11320j[i2].p(Integer.MIN_VALUE) != p2) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        int i2;
        int i3;
        int i4;
        if (getChildCount() == 0 || this.f11332v == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f11327q) {
            i3 = u();
            i2 = t();
        } else {
            i3 = t();
            i2 = u();
        }
        if (i3 == 0 && C() != null) {
            this.f11331u.b();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.C) {
            return false;
        } else {
            if (this.f11327q) {
                i4 = -1;
            } else {
                i4 = 1;
            }
            int i5 = i2 + 1;
            LazySpanLookup.FullSpanItem e2 = this.f11331u.e(i3, i5, i4, true);
            if (e2 == null) {
                this.C = false;
                this.f11331u.d(i5);
                return false;
            }
            LazySpanLookup.FullSpanItem e3 = this.f11331u.e(i3, e2.f11349b, i4 * -1, true);
            if (e3 == null) {
                this.f11331u.d(e2.f11349b);
            } else {
                this.f11331u.d(e3.f11349b + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.f11323m == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public boolean isAutoMeasureEnabled() {
        return this.f11332v != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    /* access modifiers changed from: package-private */
    public View n(boolean z2) {
        int m2 = this.f11321k.m();
        int i2 = this.f11321k.i();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int g2 = this.f11321k.g(childAt);
            int d2 = this.f11321k.d(childAt);
            if (d2 > m2 && g2 < i2) {
                if (d2 <= i2 || !z2) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public View o(boolean z2) {
        int m2 = this.f11321k.m();
        int i2 = this.f11321k.i();
        int childCount = getChildCount();
        View view = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int g2 = this.f11321k.g(childAt);
            if (this.f11321k.d(childAt) > m2 && g2 < i2) {
                if (g2 >= m2 || !z2) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public void offsetChildrenHorizontal(int i2) {
        super.offsetChildrenHorizontal(i2);
        for (int i3 = 0; i3 < this.f11319i; i3++) {
            this.f11320j[i3].r(i2);
        }
    }

    public void offsetChildrenVertical(int i2) {
        super.offsetChildrenVertical(i2);
        for (int i3 = 0; i3 < this.f11319i; i3++) {
            this.f11320j[i3].r(i2);
        }
    }

    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.f11331u.b();
        for (int i2 = 0; i2 < this.f11319i; i2++) {
            this.f11320j[i2].e();
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.F);
        for (int i2 = 0; i2 < this.f11319i; i2++) {
            this.f11320j[i2].e();
        }
        recyclerView.requestLayout();
    }

    public View onFocusSearchFailed(View view, int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View findContainingItemView;
        int i3;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        int i6;
        View m2;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i2);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        boolean z4 = layoutParams.f11346f;
        Span span = layoutParams.f11345e;
        if (convertFocusDirectionToLayoutDirection == 1) {
            i3 = u();
        } else {
            i3 = t();
        }
        U(i3, state);
        O(convertFocusDirectionToLayoutDirection);
        LayoutState layoutState = this.f11325o;
        layoutState.f11175c = layoutState.f11176d + i3;
        layoutState.f11174b = (int) (((float) this.f11321k.n()) * 0.33333334f);
        LayoutState layoutState2 = this.f11325o;
        layoutState2.f11180h = true;
        layoutState2.f11173a = false;
        l(recycler, layoutState2, state);
        this.f11333w = this.f11327q;
        if (!z4 && (m2 = span.m(i3, convertFocusDirectionToLayoutDirection)) != null && m2 != findContainingItemView) {
            return m2;
        }
        if (H(convertFocusDirectionToLayoutDirection)) {
            for (int i7 = this.f11319i - 1; i7 >= 0; i7--) {
                View m3 = this.f11320j[i7].m(i3, convertFocusDirectionToLayoutDirection);
                if (m3 != null && m3 != findContainingItemView) {
                    return m3;
                }
            }
        } else {
            for (int i8 = 0; i8 < this.f11319i; i8++) {
                View m4 = this.f11320j[i8].m(i3, convertFocusDirectionToLayoutDirection);
                if (m4 != null && m4 != findContainingItemView) {
                    return m4;
                }
            }
        }
        boolean z5 = !this.f11326p;
        if (convertFocusDirectionToLayoutDirection == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z5 == z2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z4) {
            if (z3) {
                i6 = span.f();
            } else {
                i6 = span.g();
            }
            View findViewByPosition = findViewByPosition(i6);
            if (!(findViewByPosition == null || findViewByPosition == findContainingItemView)) {
                return findViewByPosition;
            }
        }
        if (H(convertFocusDirectionToLayoutDirection)) {
            for (int i9 = this.f11319i - 1; i9 >= 0; i9--) {
                if (i9 != span.f11367e) {
                    if (z3) {
                        i5 = this.f11320j[i9].f();
                    } else {
                        i5 = this.f11320j[i9].g();
                    }
                    View findViewByPosition2 = findViewByPosition(i5);
                    if (!(findViewByPosition2 == null || findViewByPosition2 == findContainingItemView)) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i10 = 0; i10 < this.f11319i; i10++) {
                if (z3) {
                    i4 = this.f11320j[i10].f();
                } else {
                    i4 = this.f11320j[i10].g();
                }
                View findViewByPosition3 = findViewByPosition(i4);
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View o2 = o(false);
            View n2 = n(false);
            if (o2 != null && n2 != null) {
                int position = getPosition(o2);
                int position2 = getPosition(n2);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        B(i2, i3, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f11331u.b();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        B(i2, i3, 8);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        B(i2, i3, 2);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        B(i2, i3, 4);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        G(recycler, state, true);
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f11329s = -1;
        this.f11330t = Integer.MIN_VALUE;
        this.f11335y = null;
        this.B.c();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f11335y = savedState;
            if (this.f11329s != -1) {
                savedState.b();
                this.f11335y.c();
            }
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        int i2;
        int i3;
        int i4;
        int[] iArr;
        if (this.f11335y != null) {
            return new SavedState(this.f11335y);
        }
        SavedState savedState = new SavedState();
        savedState.f11360i = this.f11326p;
        savedState.f11361j = this.f11333w;
        savedState.f11362k = this.f11334x;
        LazySpanLookup lazySpanLookup = this.f11331u;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f11347a) == null) {
            savedState.f11357f = 0;
        } else {
            savedState.f11358g = iArr;
            savedState.f11357f = iArr.length;
            savedState.f11359h = lazySpanLookup.f11348b;
        }
        if (getChildCount() > 0) {
            if (this.f11333w) {
                i2 = u();
            } else {
                i2 = t();
            }
            savedState.f11353b = i2;
            savedState.f11354c = p();
            int i5 = this.f11319i;
            savedState.f11355d = i5;
            savedState.f11356e = new int[i5];
            for (int i6 = 0; i6 < this.f11319i; i6++) {
                if (this.f11333w) {
                    i3 = this.f11320j[i6].l(Integer.MIN_VALUE);
                    if (i3 != Integer.MIN_VALUE) {
                        i4 = this.f11321k.i();
                    } else {
                        savedState.f11356e[i6] = i3;
                    }
                } else {
                    i3 = this.f11320j[i6].p(Integer.MIN_VALUE);
                    if (i3 != Integer.MIN_VALUE) {
                        i4 = this.f11321k.m();
                    } else {
                        savedState.f11356e[i6] = i3;
                    }
                }
                i3 -= i4;
                savedState.f11356e[i6] = i3;
            }
        } else {
            savedState.f11353b = -1;
            savedState.f11354c = -1;
            savedState.f11355d = 0;
        }
        return savedState;
    }

    public void onScrollStateChanged(int i2) {
        if (i2 == 0) {
            g();
        }
    }

    /* access modifiers changed from: package-private */
    public int p() {
        View view;
        if (this.f11327q) {
            view = n(true);
        } else {
            view = o(true);
        }
        if (view == null) {
            return -1;
        }
        return getPosition(view);
    }

    /* access modifiers changed from: package-private */
    public int scrollBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        I(i2, state);
        int l2 = l(recycler, this.f11325o, state);
        if (this.f11325o.f11174b >= l2) {
            if (i2 < 0) {
                i2 = -l2;
            } else {
                i2 = l2;
            }
        }
        this.f11321k.r(-i2);
        this.f11333w = this.f11327q;
        LayoutState layoutState = this.f11325o;
        layoutState.f11174b = 0;
        K(recycler, layoutState);
        return i2;
    }

    public int scrollHorizontallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i2, recycler, state);
    }

    public void scrollToPosition(int i2) {
        SavedState savedState = this.f11335y;
        if (!(savedState == null || savedState.f11353b == i2)) {
            savedState.b();
        }
        this.f11329s = i2;
        this.f11330t = Integer.MIN_VALUE;
        requestLayout();
    }

    public int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i2, recycler, state);
    }

    public void setMeasuredDimension(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f11323m == 1) {
            i5 = RecyclerView.LayoutManager.chooseSize(i3, rect.height() + paddingTop, getMinimumHeight());
            i4 = RecyclerView.LayoutManager.chooseSize(i2, (this.f11324n * this.f11319i) + paddingLeft, getMinimumWidth());
        } else {
            i4 = RecyclerView.LayoutManager.chooseSize(i2, rect.width() + paddingLeft, getMinimumWidth());
            i5 = RecyclerView.LayoutManager.chooseSize(i3, (this.f11324n * this.f11319i) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i4, i5);
    }

    public void setOrientation(int i2) {
        if (i2 == 0 || i2 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i2 != this.f11323m) {
                this.f11323m = i2;
                OrientationHelper orientationHelper = this.f11321k;
                this.f11321k = this.f11322l;
                this.f11322l = orientationHelper;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean z2) {
        assertNotInLayoutOrScroll((String) null);
        SavedState savedState = this.f11335y;
        if (!(savedState == null || savedState.f11360i == z2)) {
            savedState.f11360i = z2;
        }
        this.f11326p = z2;
        requestLayout();
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i2);
        startSmoothScroll(linearSmoothScroller);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.f11335y == null;
    }

    /* access modifiers changed from: package-private */
    public int t() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    /* access modifiers changed from: package-private */
    public int u() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    static class LazySpanLookup {

        /* renamed from: a  reason: collision with root package name */
        int[] f11347a;

        /* renamed from: b  reason: collision with root package name */
        List<FullSpanItem> f11348b;

        LazySpanLookup() {
        }

        private int i(int i2) {
            if (this.f11348b == null) {
                return -1;
            }
            FullSpanItem f2 = f(i2);
            if (f2 != null) {
                this.f11348b.remove(f2);
            }
            int size = this.f11348b.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                } else if (this.f11348b.get(i3).f11349b >= i2) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == -1) {
                return -1;
            }
            this.f11348b.remove(i3);
            return this.f11348b.get(i3).f11349b;
        }

        private void l(int i2, int i3) {
            List<FullSpanItem> list = this.f11348b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f11348b.get(size);
                    int i4 = fullSpanItem.f11349b;
                    if (i4 >= i2) {
                        fullSpanItem.f11349b = i4 + i3;
                    }
                }
            }
        }

        private void m(int i2, int i3) {
            List<FullSpanItem> list = this.f11348b;
            if (list != null) {
                int i4 = i2 + i3;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f11348b.get(size);
                    int i5 = fullSpanItem.f11349b;
                    if (i5 >= i2) {
                        if (i5 < i4) {
                            this.f11348b.remove(size);
                        } else {
                            fullSpanItem.f11349b = i5 - i3;
                        }
                    }
                }
            }
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f11348b == null) {
                this.f11348b = new ArrayList();
            }
            int size = this.f11348b.size();
            for (int i2 = 0; i2 < size; i2++) {
                FullSpanItem fullSpanItem2 = this.f11348b.get(i2);
                if (fullSpanItem2.f11349b == fullSpanItem.f11349b) {
                    this.f11348b.remove(i2);
                }
                if (fullSpanItem2.f11349b >= fullSpanItem.f11349b) {
                    this.f11348b.add(i2, fullSpanItem);
                    return;
                }
            }
            this.f11348b.add(fullSpanItem);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f11347a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f11348b = null;
        }

        /* access modifiers changed from: package-private */
        public void c(int i2) {
            int[] iArr = this.f11347a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i2, 10) + 1)];
                this.f11347a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i2 >= iArr.length) {
                int[] iArr3 = new int[o(i2)];
                this.f11347a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f11347a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public int d(int i2) {
            List<FullSpanItem> list = this.f11348b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f11348b.get(size).f11349b >= i2) {
                        this.f11348b.remove(size);
                    }
                }
            }
            return h(i2);
        }

        public FullSpanItem e(int i2, int i3, int i4, boolean z2) {
            List<FullSpanItem> list = this.f11348b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                FullSpanItem fullSpanItem = this.f11348b.get(i5);
                int i6 = fullSpanItem.f11349b;
                if (i6 >= i3) {
                    return null;
                }
                if (i6 >= i2 && (i4 == 0 || fullSpanItem.f11350c == i4 || (z2 && fullSpanItem.f11352e))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i2) {
            List<FullSpanItem> list = this.f11348b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f11348b.get(size);
                if (fullSpanItem.f11349b == i2) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int g(int i2) {
            int[] iArr = this.f11347a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            return iArr[i2];
        }

        /* access modifiers changed from: package-private */
        public int h(int i2) {
            int[] iArr = this.f11347a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            int i3 = i(i2);
            if (i3 == -1) {
                int[] iArr2 = this.f11347a;
                Arrays.fill(iArr2, i2, iArr2.length, -1);
                return this.f11347a.length;
            }
            int min = Math.min(i3 + 1, this.f11347a.length);
            Arrays.fill(this.f11347a, i2, min, -1);
            return min;
        }

        /* access modifiers changed from: package-private */
        public void j(int i2, int i3) {
            int[] iArr = this.f11347a;
            if (iArr != null && i2 < iArr.length) {
                int i4 = i2 + i3;
                c(i4);
                int[] iArr2 = this.f11347a;
                System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
                Arrays.fill(this.f11347a, i2, i4, -1);
                l(i2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        public void k(int i2, int i3) {
            int[] iArr = this.f11347a;
            if (iArr != null && i2 < iArr.length) {
                int i4 = i2 + i3;
                c(i4);
                int[] iArr2 = this.f11347a;
                System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
                int[] iArr3 = this.f11347a;
                Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
                m(i2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        public void n(int i2, Span span) {
            c(i2);
            this.f11347a[i2] = span.f11367e;
        }

        /* access modifiers changed from: package-private */
        public int o(int i2) {
            int length = this.f11347a.length;
            while (length <= i2) {
                length *= 2;
            }
            return length;
        }

        @SuppressLint({"BanParcelableUsage"})
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
                /* renamed from: a */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* renamed from: b */
                public FullSpanItem[] newArray(int i2) {
                    return new FullSpanItem[i2];
                }
            };

            /* renamed from: b  reason: collision with root package name */
            int f11349b;

            /* renamed from: c  reason: collision with root package name */
            int f11350c;

            /* renamed from: d  reason: collision with root package name */
            int[] f11351d;

            /* renamed from: e  reason: collision with root package name */
            boolean f11352e;

            FullSpanItem(Parcel parcel) {
                this.f11349b = parcel.readInt();
                this.f11350c = parcel.readInt();
                this.f11352e = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f11351d = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            /* access modifiers changed from: package-private */
            public int b(int i2) {
                int[] iArr = this.f11351d;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i2];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f11349b + ", mGapDir=" + this.f11350c + ", mHasUnwantedGapAfter=" + this.f11352e + ", mGapPerSpan=" + Arrays.toString(this.f11351d) + '}';
            }

            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f11349b);
                parcel.writeInt(this.f11350c);
                parcel.writeInt(this.f11352e ? 1 : 0);
                int[] iArr = this.f11351d;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f11351d);
            }

            FullSpanItem() {
            }
        }
    }
}
