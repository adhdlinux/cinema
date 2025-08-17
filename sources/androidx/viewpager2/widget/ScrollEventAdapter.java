package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
    private boolean A;

    /* renamed from: o  reason: collision with root package name */
    private ViewPager2.OnPageChangeCallback f12002o;

    /* renamed from: p  reason: collision with root package name */
    private final ViewPager2 f12003p;

    /* renamed from: q  reason: collision with root package name */
    private final RecyclerView f12004q;

    /* renamed from: r  reason: collision with root package name */
    private final LinearLayoutManager f12005r;

    /* renamed from: s  reason: collision with root package name */
    private int f12006s;

    /* renamed from: t  reason: collision with root package name */
    private int f12007t;

    /* renamed from: u  reason: collision with root package name */
    private ScrollEventValues f12008u = new ScrollEventValues();

    /* renamed from: v  reason: collision with root package name */
    private int f12009v;

    /* renamed from: w  reason: collision with root package name */
    private int f12010w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f12011x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f12012y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f12013z;

    private static final class ScrollEventValues {

        /* renamed from: a  reason: collision with root package name */
        int f12014a;

        /* renamed from: b  reason: collision with root package name */
        float f12015b;

        /* renamed from: c  reason: collision with root package name */
        int f12016c;

        ScrollEventValues() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f12014a = -1;
            this.f12015b = 0.0f;
            this.f12016c = 0;
        }
    }

    ScrollEventAdapter(ViewPager2 viewPager2) {
        this.f12003p = viewPager2;
        RecyclerView recyclerView = viewPager2.f12027k;
        this.f12004q = recyclerView;
        this.f12005r = (LinearLayoutManager) recyclerView.getLayoutManager();
        o();
    }

    private void a(int i2, float f2, int i3) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f12002o;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.b(i2, f2, i3);
        }
    }

    private void e(int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f12002o;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.c(i2);
        }
    }

    private void f(int i2) {
        if ((this.f12006s != 3 || this.f12007t != 0) && this.f12007t != i2) {
            this.f12007t = i2;
            ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f12002o;
            if (onPageChangeCallback != null) {
                onPageChangeCallback.a(i2);
            }
        }
    }

    private int g() {
        return this.f12005r.findFirstVisibleItemPosition();
    }

    private boolean l() {
        int i2 = this.f12006s;
        return i2 == 1 || i2 == 4;
    }

    private void o() {
        this.f12006s = 0;
        this.f12007t = 0;
        this.f12008u.a();
        this.f12009v = -1;
        this.f12010w = -1;
        this.f12011x = false;
        this.f12012y = false;
        this.A = false;
        this.f12013z = false;
    }

    private void q(boolean z2) {
        int i2;
        this.A = z2;
        if (z2) {
            i2 = 4;
        } else {
            i2 = 1;
        }
        this.f12006s = i2;
        int i3 = this.f12010w;
        if (i3 != -1) {
            this.f12009v = i3;
            this.f12010w = -1;
        } else if (this.f12009v == -1) {
            this.f12009v = g();
        }
        f(1);
    }

    private void r() {
        boolean z2;
        int i2;
        float f2;
        ScrollEventValues scrollEventValues = this.f12008u;
        int findFirstVisibleItemPosition = this.f12005r.findFirstVisibleItemPosition();
        scrollEventValues.f12014a = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            scrollEventValues.a();
            return;
        }
        View findViewByPosition = this.f12005r.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            scrollEventValues.a();
            return;
        }
        int leftDecorationWidth = this.f12005r.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.f12005r.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.f12005r.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.f12005r.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.f12005r.getOrientation() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i2 = (findViewByPosition.getLeft() - leftDecorationWidth) - this.f12004q.getPaddingLeft();
            if (this.f12003p.d()) {
                i2 = -i2;
            }
            height = width;
        } else {
            i2 = (findViewByPosition.getTop() - topDecorationHeight) - this.f12004q.getPaddingTop();
        }
        int i3 = -i2;
        scrollEventValues.f12016c = i3;
        if (i3 >= 0) {
            if (height == 0) {
                f2 = 0.0f;
            } else {
                f2 = ((float) i3) / ((float) height);
            }
            scrollEventValues.f12015b = f2;
        } else if (new AnimateLayoutChangeDetector(this.f12005r).d()) {
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        } else {
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[]{Integer.valueOf(scrollEventValues.f12016c)}));
        }
    }

    /* access modifiers changed from: package-private */
    public double h() {
        r();
        ScrollEventValues scrollEventValues = this.f12008u;
        return ((double) scrollEventValues.f12014a) + ((double) scrollEventValues.f12015b);
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.f12007t;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.A;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.f12007t == 0;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        this.f12013z = true;
    }

    /* access modifiers changed from: package-private */
    public void n(int i2, boolean z2) {
        int i3;
        if (z2) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        this.f12006s = i3;
        boolean z3 = false;
        this.A = false;
        if (this.f12010w != i2) {
            z3 = true;
        }
        this.f12010w = i2;
        f(2);
        if (z3) {
            e(i2);
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        boolean z2 = true;
        if (!(this.f12006s == 1 && this.f12007t == 1) && i2 == 1) {
            q(false);
        } else if (!l() || i2 != 2) {
            if (l() && i2 == 0) {
                r();
                if (!this.f12012y) {
                    int i3 = this.f12008u.f12014a;
                    if (i3 != -1) {
                        a(i3, 0.0f, 0);
                    }
                } else {
                    ScrollEventValues scrollEventValues = this.f12008u;
                    if (scrollEventValues.f12016c == 0) {
                        int i4 = this.f12009v;
                        int i5 = scrollEventValues.f12014a;
                        if (i4 != i5) {
                            e(i5);
                        }
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    f(0);
                    o();
                }
            }
            if (this.f12006s == 2 && i2 == 0 && this.f12013z) {
                r();
                ScrollEventValues scrollEventValues2 = this.f12008u;
                if (scrollEventValues2.f12016c == 0) {
                    int i6 = this.f12010w;
                    int i7 = scrollEventValues2.f12014a;
                    if (i6 != i7) {
                        if (i7 == -1) {
                            i7 = 0;
                        }
                        e(i7);
                    }
                    f(0);
                    o();
                }
            }
        } else if (this.f12012y) {
            f(2);
            this.f12011x = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r5 == r3.f12003p.d()) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f12012y = r4
            r3.r()
            boolean r0 = r3.f12011x
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L_0x003d
            r3.f12011x = r2
            if (r6 > 0) goto L_0x0022
            if (r6 != 0) goto L_0x0020
            if (r5 >= 0) goto L_0x0016
            r5 = 1
            goto L_0x0017
        L_0x0016:
            r5 = 0
        L_0x0017:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f12003p
            boolean r6 = r6.d()
            if (r5 != r6) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r5 = 0
            goto L_0x0023
        L_0x0022:
            r5 = 1
        L_0x0023:
            if (r5 == 0) goto L_0x002f
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f12008u
            int r6 = r5.f12016c
            if (r6 == 0) goto L_0x002f
            int r5 = r5.f12014a
            int r5 = r5 + r4
            goto L_0x0033
        L_0x002f:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f12008u
            int r5 = r5.f12014a
        L_0x0033:
            r3.f12010w = r5
            int r6 = r3.f12009v
            if (r6 == r5) goto L_0x004b
            r3.e(r5)
            goto L_0x004b
        L_0x003d:
            int r5 = r3.f12006s
            if (r5 != 0) goto L_0x004b
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f12008u
            int r5 = r5.f12014a
            if (r5 != r1) goto L_0x0048
            r5 = 0
        L_0x0048:
            r3.e(r5)
        L_0x004b:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f12008u
            int r6 = r5.f12014a
            if (r6 != r1) goto L_0x0052
            r6 = 0
        L_0x0052:
            float r0 = r5.f12015b
            int r5 = r5.f12016c
            r3.a(r6, r0, r5)
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f12008u
            int r6 = r5.f12014a
            int r0 = r3.f12010w
            if (r6 == r0) goto L_0x0063
            if (r0 != r1) goto L_0x0071
        L_0x0063:
            int r5 = r5.f12016c
            if (r5 != 0) goto L_0x0071
            int r5 = r3.f12007t
            if (r5 == r4) goto L_0x0071
            r3.f(r2)
            r3.o()
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void p(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f12002o = onPageChangeCallback;
    }
}
