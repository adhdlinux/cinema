package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    private boolean f1286b;

    /* renamed from: c  reason: collision with root package name */
    private int f1287c;

    /* renamed from: d  reason: collision with root package name */
    private int f1288d;

    /* renamed from: e  reason: collision with root package name */
    private int f1289e;

    /* renamed from: f  reason: collision with root package name */
    private int f1290f;

    /* renamed from: g  reason: collision with root package name */
    private int f1291g;

    /* renamed from: h  reason: collision with root package name */
    private float f1292h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1293i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f1294j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f1295k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f1296l;

    /* renamed from: m  reason: collision with root package name */
    private int f1297m;

    /* renamed from: n  reason: collision with root package name */
    private int f1298n;

    /* renamed from: o  reason: collision with root package name */
    private int f1299o;

    /* renamed from: p  reason: collision with root package name */
    private int f1300p;

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public LinearLayoutCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    private void i(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View q2 = q(i4);
            if (q2.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) q2.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i5 = layoutParams.width;
                    layoutParams.width = q2.getMeasuredWidth();
                    measureChildWithMargins(q2, i3, 0, makeMeasureSpec, 0);
                    layoutParams.width = i5;
                }
            }
        }
    }

    private void j(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View q2 = q(i4);
            if (q2.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) q2.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i5 = layoutParams.height;
                    layoutParams.height = q2.getMeasuredHeight();
                    measureChildWithMargins(q2, makeMeasureSpec, 0, i3, 0);
                    layoutParams.height = i5;
                }
            }
        }
    }

    private void y(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    public void e(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int i5;
        int virtualChildCount = getVirtualChildCount();
        boolean b2 = ViewUtils.b(this);
        for (int i6 = 0; i6 < virtualChildCount; i6++) {
            View q2 = q(i6);
            if (!(q2 == null || q2.getVisibility() == 8 || !r(i6))) {
                LayoutParams layoutParams = (LayoutParams) q2.getLayoutParams();
                if (b2) {
                    i5 = q2.getRight() + layoutParams.rightMargin;
                } else {
                    i5 = (q2.getLeft() - layoutParams.leftMargin) - this.f1297m;
                }
                h(canvas, i5);
            }
        }
        if (r(virtualChildCount)) {
            View q3 = q(virtualChildCount - 1);
            if (q3 != null) {
                LayoutParams layoutParams2 = (LayoutParams) q3.getLayoutParams();
                if (b2) {
                    i4 = q3.getLeft() - layoutParams2.leftMargin;
                    i3 = this.f1297m;
                } else {
                    i2 = q3.getRight() + layoutParams2.rightMargin;
                    h(canvas, i2);
                }
            } else if (b2) {
                i2 = getPaddingLeft();
                h(canvas, i2);
            } else {
                i4 = getWidth() - getPaddingRight();
                i3 = this.f1297m;
            }
            i2 = i4 - i3;
            h(canvas, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Canvas canvas) {
        int i2;
        int virtualChildCount = getVirtualChildCount();
        for (int i3 = 0; i3 < virtualChildCount; i3++) {
            View q2 = q(i3);
            if (!(q2 == null || q2.getVisibility() == 8 || !r(i3))) {
                g(canvas, (q2.getTop() - ((LayoutParams) q2.getLayoutParams()).topMargin) - this.f1298n);
            }
        }
        if (r(virtualChildCount)) {
            View q3 = q(virtualChildCount - 1);
            if (q3 == null) {
                i2 = (getHeight() - getPaddingBottom()) - this.f1298n;
            } else {
                i2 = q3.getBottom() + ((LayoutParams) q3.getLayoutParams()).bottomMargin;
            }
            g(canvas, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(Canvas canvas, int i2) {
        this.f1296l.setBounds(getPaddingLeft() + this.f1300p, i2, (getWidth() - getPaddingRight()) - this.f1300p, this.f1298n + i2);
        this.f1296l.draw(canvas);
    }

    public int getBaseline() {
        int i2;
        if (this.f1287c < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.f1287c;
        if (childCount > i3) {
            View childAt = getChildAt(i3);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i4 = this.f1288d;
                if (this.f1289e == 1 && (i2 = this.f1290f & 112) != 48) {
                    if (i2 == 16) {
                        i4 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1291g) / 2;
                    } else if (i2 == 80) {
                        i4 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1291g;
                    }
                }
                return i4 + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
            } else if (this.f1287c == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1287c;
    }

    public Drawable getDividerDrawable() {
        return this.f1296l;
    }

    public int getDividerPadding() {
        return this.f1300p;
    }

    public int getDividerWidth() {
        return this.f1297m;
    }

    public int getGravity() {
        return this.f1290f;
    }

    public int getOrientation() {
        return this.f1289e;
    }

    public int getShowDividers() {
        return this.f1299o;
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1292h;
    }

    /* access modifiers changed from: package-private */
    public void h(Canvas canvas, int i2) {
        this.f1296l.setBounds(i2, getPaddingTop() + this.f1300p, this.f1297m + i2, (getHeight() - getPaddingBottom()) - this.f1300p);
        this.f1296l.draw(canvas);
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public LayoutParams generateDefaultLayoutParams() {
        int i2 = this.f1289e;
        if (i2 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i2 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* renamed from: l */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public int n(View view, int i2) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int o(View view) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f1296l != null) {
            if (this.f1289e == 1) {
                f(canvas);
            } else {
                e(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        if (this.f1289e == 1) {
            t(i2, i3, i4, i5);
        } else {
            s(i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f1289e == 1) {
            x(i2, i3);
        } else {
            v(i2, i3);
        }
    }

    /* access modifiers changed from: package-private */
    public int p(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public View q(int i2) {
        return getChildAt(i2);
    }

    /* access modifiers changed from: protected */
    public boolean r(int i2) {
        if (i2 == 0) {
            if ((this.f1299o & 1) != 0) {
                return true;
            }
            return false;
        } else if (i2 == getChildCount()) {
            if ((this.f1299o & 4) != 0) {
                return true;
            }
            return false;
        } else if ((this.f1299o & 2) == 0) {
            return false;
        } else {
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                if (getChildAt(i3).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s(int r25, int r26, int r27, int r28) {
        /*
            r24 = this;
            r6 = r24
            boolean r0 = androidx.appcompat.widget.ViewUtils.b(r24)
            int r7 = r24.getPaddingTop()
            int r1 = r28 - r26
            int r2 = r24.getPaddingBottom()
            int r8 = r1 - r2
            int r1 = r1 - r7
            int r2 = r24.getPaddingBottom()
            int r9 = r1 - r2
            int r10 = r24.getVirtualChildCount()
            int r1 = r6.f1290f
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r2 = r2 & r1
            r11 = r1 & 112(0x70, float:1.57E-43)
            boolean r12 = r6.f1286b
            int[] r13 = r6.f1294j
            int[] r14 = r6.f1295k
            int r1 = androidx.core.view.ViewCompat.D(r24)
            int r1 = androidx.core.view.GravityCompat.b(r2, r1)
            r15 = 2
            r5 = 1
            if (r1 == r5) goto L_0x004b
            r2 = 5
            if (r1 == r2) goto L_0x003f
            int r1 = r24.getPaddingLeft()
            goto L_0x0056
        L_0x003f:
            int r1 = r24.getPaddingLeft()
            int r1 = r1 + r27
            int r1 = r1 - r25
            int r2 = r6.f1291g
            int r1 = r1 - r2
            goto L_0x0056
        L_0x004b:
            int r1 = r24.getPaddingLeft()
            int r2 = r27 - r25
            int r3 = r6.f1291g
            int r2 = r2 - r3
            int r2 = r2 / r15
            int r1 = r1 + r2
        L_0x0056:
            r2 = 0
            if (r0 == 0) goto L_0x0060
            int r0 = r10 + -1
            r16 = r0
            r17 = -1
            goto L_0x0064
        L_0x0060:
            r16 = 0
            r17 = 1
        L_0x0064:
            r3 = 0
        L_0x0065:
            if (r3 >= r10) goto L_0x0140
            int r0 = r17 * r3
            int r2 = r16 + r0
            android.view.View r0 = r6.q(r2)
            if (r0 != 0) goto L_0x0078
            int r0 = r6.w(r2)
            int r1 = r1 + r0
            goto L_0x012a
        L_0x0078:
            int r5 = r0.getVisibility()
            r15 = 8
            if (r5 == r15) goto L_0x0128
            int r15 = r0.getMeasuredWidth()
            int r5 = r0.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r18 = r0.getLayoutParams()
            r4 = r18
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r4 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r4
            r18 = r3
            if (r12 == 0) goto L_0x00a0
            int r3 = r4.height
            r19 = r10
            r10 = -1
            if (r3 == r10) goto L_0x00a2
            int r10 = r0.getBaseline()
            goto L_0x00a3
        L_0x00a0:
            r19 = r10
        L_0x00a2:
            r10 = -1
        L_0x00a3:
            int r3 = r4.gravity
            if (r3 >= 0) goto L_0x00a8
            r3 = r11
        L_0x00a8:
            r3 = r3 & 112(0x70, float:1.57E-43)
            r20 = r11
            r11 = 16
            if (r3 == r11) goto L_0x00e3
            r11 = 48
            if (r3 == r11) goto L_0x00d1
            r11 = 80
            if (r3 == r11) goto L_0x00bb
            r3 = r7
            r11 = -1
            goto L_0x00e0
        L_0x00bb:
            int r3 = r8 - r5
            int r11 = r4.bottomMargin
            int r3 = r3 - r11
            r11 = -1
            if (r10 == r11) goto L_0x00e0
            int r21 = r0.getMeasuredHeight()
            int r21 = r21 - r10
            r10 = 2
            r22 = r14[r10]
            int r22 = r22 - r21
            int r3 = r3 - r22
            goto L_0x00e0
        L_0x00d1:
            r11 = -1
            int r3 = r4.topMargin
            int r3 = r3 + r7
            if (r10 == r11) goto L_0x00e0
            r21 = 1
            r22 = r13[r21]
            int r22 = r22 - r10
            int r3 = r3 + r22
            goto L_0x00f1
        L_0x00e0:
            r21 = 1
            goto L_0x00f1
        L_0x00e3:
            r11 = -1
            r21 = 1
            int r3 = r9 - r5
            r10 = 2
            int r3 = r3 / r10
            int r3 = r3 + r7
            int r10 = r4.topMargin
            int r3 = r3 + r10
            int r10 = r4.bottomMargin
            int r3 = r3 - r10
        L_0x00f1:
            boolean r10 = r6.r(r2)
            if (r10 == 0) goto L_0x00fa
            int r10 = r6.f1297m
            int r1 = r1 + r10
        L_0x00fa:
            int r10 = r4.leftMargin
            int r10 = r10 + r1
            int r1 = r6.o(r0)
            int r22 = r10 + r1
            r25 = r0
            r0 = r24
            r1 = r25
            r11 = r2
            r2 = r22
            r22 = r7
            r23 = -1
            r7 = r4
            r4 = r15
            r0.y(r1, r2, r3, r4, r5)
            int r0 = r7.rightMargin
            int r15 = r15 + r0
            r0 = r25
            int r1 = r6.p(r0)
            int r15 = r15 + r1
            int r10 = r10 + r15
            int r0 = r6.n(r0, r11)
            int r3 = r18 + r0
            r1 = r10
            goto L_0x0134
        L_0x0128:
            r18 = r3
        L_0x012a:
            r22 = r7
            r19 = r10
            r20 = r11
            r21 = 1
            r23 = -1
        L_0x0134:
            int r3 = r3 + 1
            r10 = r19
            r11 = r20
            r7 = r22
            r5 = 1
            r15 = 2
            goto L_0x0065
        L_0x0140:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.s(int, int, int, int):void");
    }

    public void setBaselineAligned(boolean z2) {
        this.f1286b = z2;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 < 0 || i2 >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f1287c = i2;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.f1296l) {
            this.f1296l = drawable;
            boolean z2 = false;
            if (drawable != null) {
                this.f1297m = drawable.getIntrinsicWidth();
                this.f1298n = drawable.getIntrinsicHeight();
            } else {
                this.f1297m = 0;
                this.f1298n = 0;
            }
            if (drawable == null) {
                z2 = true;
            }
            setWillNotDraw(z2);
            requestLayout();
        }
    }

    public void setDividerPadding(int i2) {
        this.f1300p = i2;
    }

    public void setGravity(int i2) {
        if (this.f1290f != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f1290f = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        int i4 = this.f1290f;
        if ((8388615 & i4) != i3) {
            this.f1290f = i3 | (-8388616 & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z2) {
        this.f1293i = z2;
    }

    public void setOrientation(int i2) {
        if (this.f1289e != i2) {
            this.f1289e = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.f1299o) {
            requestLayout();
        }
        this.f1299o = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        int i4 = this.f1290f;
        if ((i4 & 112) != i3) {
            this.f1290f = i3 | (i4 & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.f1292h = Math.max(0.0f, f2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void t(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r20 - r18
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r10 = r17.getVirtualChildCount()
            int r0 = r6.f1290f
            r1 = r0 & 112(0x70, float:1.57E-43)
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r0 & r2
            r0 = 16
            if (r1 == r0) goto L_0x003b
            r0 = 80
            if (r1 == r0) goto L_0x002f
            int r0 = r17.getPaddingTop()
            goto L_0x0047
        L_0x002f:
            int r0 = r17.getPaddingTop()
            int r0 = r0 + r21
            int r0 = r0 - r19
            int r1 = r6.f1291g
            int r0 = r0 - r1
            goto L_0x0047
        L_0x003b:
            int r0 = r17.getPaddingTop()
            int r1 = r21 - r19
            int r2 = r6.f1291g
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r0 = r0 + r1
        L_0x0047:
            r1 = 0
            r12 = 0
        L_0x0049:
            if (r12 >= r10) goto L_0x00c8
            android.view.View r13 = r6.q(r12)
            r14 = 1
            if (r13 != 0) goto L_0x0059
            int r1 = r6.w(r12)
            int r0 = r0 + r1
            goto L_0x00c5
        L_0x0059:
            int r1 = r13.getVisibility()
            r2 = 8
            if (r1 == r2) goto L_0x00c5
            int r4 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r5 = r1
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            int r1 = r5.gravity
            if (r1 >= 0) goto L_0x0075
            r1 = r11
        L_0x0075:
            int r2 = androidx.core.view.ViewCompat.D(r17)
            int r1 = androidx.core.view.GravityCompat.b(r1, r2)
            r1 = r1 & 7
            if (r1 == r14) goto L_0x008d
            r2 = 5
            if (r1 == r2) goto L_0x0088
            int r1 = r5.leftMargin
            int r1 = r1 + r7
            goto L_0x0098
        L_0x0088:
            int r1 = r8 - r4
            int r2 = r5.rightMargin
            goto L_0x0097
        L_0x008d:
            int r1 = r9 - r4
            int r1 = r1 / 2
            int r1 = r1 + r7
            int r2 = r5.leftMargin
            int r1 = r1 + r2
            int r2 = r5.rightMargin
        L_0x0097:
            int r1 = r1 - r2
        L_0x0098:
            r2 = r1
            boolean r1 = r6.r(r12)
            if (r1 == 0) goto L_0x00a2
            int r1 = r6.f1298n
            int r0 = r0 + r1
        L_0x00a2:
            int r1 = r5.topMargin
            int r16 = r0 + r1
            int r0 = r6.o(r13)
            int r3 = r16 + r0
            r0 = r17
            r1 = r13
            r14 = r5
            r5 = r15
            r0.y(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r15 = r15 + r0
            int r0 = r6.p(r13)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.n(r13, r12)
            int r12 = r12 + r0
            r0 = r16
        L_0x00c5:
            r1 = 1
            int r12 = r12 + r1
            goto L_0x0049
        L_0x00c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.t(int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void u(View view, int i2, int i3, int i4, int i5, int i6) {
        measureChildWithMargins(view, i3, i4, i5, i6);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x044c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void v(int r38, int r39) {
        /*
            r37 = this;
            r7 = r37
            r8 = r38
            r9 = r39
            r10 = 0
            r7.f1291g = r10
            int r11 = r37.getVirtualChildCount()
            int r12 = android.view.View.MeasureSpec.getMode(r38)
            int r13 = android.view.View.MeasureSpec.getMode(r39)
            int[] r0 = r7.f1294j
            r14 = 4
            if (r0 == 0) goto L_0x001e
            int[] r0 = r7.f1295k
            if (r0 != 0) goto L_0x0026
        L_0x001e:
            int[] r0 = new int[r14]
            r7.f1294j = r0
            int[] r0 = new int[r14]
            r7.f1295k = r0
        L_0x0026:
            int[] r15 = r7.f1294j
            int[] r6 = r7.f1295k
            r16 = 3
            r5 = -1
            r15[r16] = r5
            r17 = 2
            r15[r17] = r5
            r18 = 1
            r15[r18] = r5
            r15[r10] = r5
            r6[r16] = r5
            r6[r17] = r5
            r6[r18] = r5
            r6[r10] = r5
            boolean r4 = r7.f1286b
            boolean r3 = r7.f1293i
            r2 = 1073741824(0x40000000, float:2.0)
            if (r12 != r2) goto L_0x004c
            r19 = 1
            goto L_0x004e
        L_0x004c:
            r19 = 0
        L_0x004e:
            r20 = 0
            r0 = 0
            r1 = 0
            r14 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 1
            r27 = 0
        L_0x0061:
            r28 = r6
            r5 = 8
            if (r1 >= r11) goto L_0x01fd
            android.view.View r6 = r7.q(r1)
            if (r6 != 0) goto L_0x007f
            int r5 = r7.f1291g
            int r6 = r7.w(r1)
            int r5 = r5 + r6
            r7.f1291g = r5
        L_0x0076:
            r2 = r1
            r32 = r3
            r36 = r4
            r1 = 1073741824(0x40000000, float:2.0)
            goto L_0x01ec
        L_0x007f:
            int r10 = r6.getVisibility()
            if (r10 != r5) goto L_0x008b
            int r5 = r7.n(r6, r1)
            int r1 = r1 + r5
            goto L_0x0076
        L_0x008b:
            boolean r5 = r7.r(r1)
            if (r5 == 0) goto L_0x0098
            int r5 = r7.f1291g
            int r10 = r7.f1297m
            int r5 = r5 + r10
            r7.f1291g = r5
        L_0x0098:
            android.view.ViewGroup$LayoutParams r5 = r6.getLayoutParams()
            r10 = r5
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r10 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r10
            float r5 = r10.weight
            float r31 = r0 + r5
            if (r12 != r2) goto L_0x00ec
            int r0 = r10.width
            if (r0 != 0) goto L_0x00ec
            int r0 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x00ec
            if (r19 == 0) goto L_0x00ba
            int r0 = r7.f1291g
            int r5 = r10.leftMargin
            int r2 = r10.rightMargin
            int r5 = r5 + r2
            int r0 = r0 + r5
            r7.f1291g = r0
            goto L_0x00c8
        L_0x00ba:
            int r0 = r7.f1291g
            int r2 = r10.leftMargin
            int r2 = r2 + r0
            int r5 = r10.rightMargin
            int r2 = r2 + r5
            int r0 = java.lang.Math.max(r0, r2)
            r7.f1291g = r0
        L_0x00c8:
            if (r4 == 0) goto L_0x00dd
            r0 = 0
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r0)
            r6.measure(r2, r2)
            r34 = r1
            r32 = r3
            r36 = r4
            r3 = r6
            r30 = -2
            goto L_0x0166
        L_0x00dd:
            r34 = r1
            r32 = r3
            r36 = r4
            r3 = r6
            r1 = 1073741824(0x40000000, float:2.0)
            r24 = 1
            r30 = -2
            goto L_0x0168
        L_0x00ec:
            int r0 = r10.width
            if (r0 != 0) goto L_0x00f9
            int r0 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x00f9
            r5 = -2
            r10.width = r5
            r2 = 0
            goto L_0x00fc
        L_0x00f9:
            r5 = -2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00fc:
            int r0 = (r31 > r20 ? 1 : (r31 == r20 ? 0 : -1))
            if (r0 != 0) goto L_0x0105
            int r0 = r7.f1291g
            r29 = r0
            goto L_0x0107
        L_0x0105:
            r29 = 0
        L_0x0107:
            r33 = 0
            r0 = r37
            r34 = r1
            r1 = r6
            r35 = r2
            r2 = r34
            r32 = r3
            r3 = r38
            r36 = r4
            r4 = r29
            r9 = -1
            r29 = -2
            r5 = r39
            r29 = r6
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r30 = -2
            r6 = r33
            r0.u(r1, r2, r3, r4, r5, r6)
            r0 = r35
            if (r0 == r9) goto L_0x0130
            r10.width = r0
        L_0x0130:
            int r0 = r29.getMeasuredWidth()
            if (r19 == 0) goto L_0x0149
            int r1 = r7.f1291g
            int r2 = r10.leftMargin
            int r2 = r2 + r0
            int r3 = r10.rightMargin
            int r2 = r2 + r3
            r3 = r29
            int r4 = r7.p(r3)
            int r2 = r2 + r4
            int r1 = r1 + r2
            r7.f1291g = r1
            goto L_0x0160
        L_0x0149:
            r3 = r29
            int r1 = r7.f1291g
            int r2 = r1 + r0
            int r4 = r10.leftMargin
            int r2 = r2 + r4
            int r4 = r10.rightMargin
            int r2 = r2 + r4
            int r4 = r7.p(r3)
            int r2 = r2 + r4
            int r1 = java.lang.Math.max(r1, r2)
            r7.f1291g = r1
        L_0x0160:
            if (r32 == 0) goto L_0x0166
            int r14 = java.lang.Math.max(r0, r14)
        L_0x0166:
            r1 = 1073741824(0x40000000, float:2.0)
        L_0x0168:
            if (r13 == r1) goto L_0x0173
            int r0 = r10.height
            r2 = -1
            if (r0 != r2) goto L_0x0173
            r0 = 1
            r27 = 1
            goto L_0x0174
        L_0x0173:
            r0 = 0
        L_0x0174:
            int r2 = r10.topMargin
            int r4 = r10.bottomMargin
            int r2 = r2 + r4
            int r4 = r3.getMeasuredHeight()
            int r4 = r4 + r2
            int r5 = r3.getMeasuredState()
            r6 = r25
            int r25 = android.view.View.combineMeasuredStates(r6, r5)
            if (r36 == 0) goto L_0x01b1
            int r5 = r3.getBaseline()
            r6 = -1
            if (r5 == r6) goto L_0x01b1
            int r6 = r10.gravity
            if (r6 >= 0) goto L_0x0197
            int r6 = r7.f1290f
        L_0x0197:
            r6 = r6 & 112(0x70, float:1.57E-43)
            r9 = 4
            int r6 = r6 >> r9
            r6 = r6 & -2
            int r6 = r6 >> 1
            r9 = r15[r6]
            int r9 = java.lang.Math.max(r9, r5)
            r15[r6] = r9
            r9 = r28[r6]
            int r5 = r4 - r5
            int r5 = java.lang.Math.max(r9, r5)
            r28[r6] = r5
        L_0x01b1:
            r5 = r21
            int r21 = java.lang.Math.max(r5, r4)
            if (r26 == 0) goto L_0x01c1
            int r5 = r10.height
            r6 = -1
            if (r5 != r6) goto L_0x01c1
            r26 = 1
            goto L_0x01c3
        L_0x01c1:
            r26 = 0
        L_0x01c3:
            float r5 = r10.weight
            int r5 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r5 <= 0) goto L_0x01d4
            if (r0 == 0) goto L_0x01cc
            goto L_0x01cd
        L_0x01cc:
            r2 = r4
        L_0x01cd:
            r10 = r23
            int r23 = java.lang.Math.max(r10, r2)
            goto L_0x01e2
        L_0x01d4:
            r10 = r23
            if (r0 == 0) goto L_0x01d9
            goto L_0x01da
        L_0x01d9:
            r2 = r4
        L_0x01da:
            r4 = r22
            int r22 = java.lang.Math.max(r4, r2)
            r23 = r10
        L_0x01e2:
            r10 = r34
            int r0 = r7.n(r3, r10)
            int r0 = r0 + r10
            r2 = r0
            r0 = r31
        L_0x01ec:
            int r2 = r2 + 1
            r9 = r39
            r1 = r2
            r6 = r28
            r3 = r32
            r4 = r36
            r2 = 1073741824(0x40000000, float:2.0)
            r5 = -1
            r10 = 0
            goto L_0x0061
        L_0x01fd:
            r32 = r3
            r36 = r4
            r2 = r21
            r4 = r22
            r10 = r23
            r6 = r25
            r1 = 1073741824(0x40000000, float:2.0)
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r30 = -2
            int r3 = r7.f1291g
            if (r3 <= 0) goto L_0x0220
            boolean r3 = r7.r(r11)
            if (r3 == 0) goto L_0x0220
            int r3 = r7.f1291g
            int r1 = r7.f1297m
            int r3 = r3 + r1
            r7.f1291g = r3
        L_0x0220:
            r1 = r15[r18]
            r3 = -1
            if (r1 != r3) goto L_0x0238
            r21 = 0
            r5 = r15[r21]
            if (r5 != r3) goto L_0x0238
            r5 = r15[r17]
            if (r5 != r3) goto L_0x0238
            r5 = r15[r16]
            if (r5 == r3) goto L_0x0234
            goto L_0x0238
        L_0x0234:
            r1 = r2
            r23 = r6
            goto L_0x0267
        L_0x0238:
            r3 = r15[r16]
            r5 = 0
            r9 = r15[r5]
            r5 = r15[r17]
            int r1 = java.lang.Math.max(r1, r5)
            int r1 = java.lang.Math.max(r9, r1)
            int r1 = java.lang.Math.max(r3, r1)
            r3 = r28[r16]
            r5 = 0
            r9 = r28[r5]
            r5 = r28[r18]
            r23 = r6
            r6 = r28[r17]
            int r5 = java.lang.Math.max(r5, r6)
            int r5 = java.lang.Math.max(r9, r5)
            int r3 = java.lang.Math.max(r3, r5)
            int r1 = r1 + r3
            int r1 = java.lang.Math.max(r2, r1)
        L_0x0267:
            if (r32 == 0) goto L_0x02ca
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r12 == r2) goto L_0x026f
            if (r12 != 0) goto L_0x02ca
        L_0x026f:
            r2 = 0
            r7.f1291g = r2
            r2 = 0
        L_0x0273:
            if (r2 >= r11) goto L_0x02ca
            android.view.View r3 = r7.q(r2)
            if (r3 != 0) goto L_0x0285
            int r3 = r7.f1291g
            int r5 = r7.w(r2)
            int r3 = r3 + r5
            r7.f1291g = r3
            goto L_0x0292
        L_0x0285:
            int r5 = r3.getVisibility()
            r6 = 8
            if (r5 != r6) goto L_0x0295
            int r3 = r7.n(r3, r2)
            int r2 = r2 + r3
        L_0x0292:
            r21 = r1
            goto L_0x02c5
        L_0x0295:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            if (r19 == 0) goto L_0x02ae
            int r6 = r7.f1291g
            int r9 = r5.leftMargin
            int r9 = r9 + r14
            int r5 = r5.rightMargin
            int r9 = r9 + r5
            int r3 = r7.p(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            r7.f1291g = r6
            goto L_0x0292
        L_0x02ae:
            int r6 = r7.f1291g
            int r9 = r6 + r14
            r21 = r1
            int r1 = r5.leftMargin
            int r9 = r9 + r1
            int r1 = r5.rightMargin
            int r9 = r9 + r1
            int r1 = r7.p(r3)
            int r9 = r9 + r1
            int r1 = java.lang.Math.max(r6, r9)
            r7.f1291g = r1
        L_0x02c5:
            int r2 = r2 + 1
            r1 = r21
            goto L_0x0273
        L_0x02ca:
            r21 = r1
            int r1 = r7.f1291g
            int r2 = r37.getPaddingLeft()
            int r3 = r37.getPaddingRight()
            int r2 = r2 + r3
            int r1 = r1 + r2
            r7.f1291g = r1
            int r2 = r37.getSuggestedMinimumWidth()
            int r1 = java.lang.Math.max(r1, r2)
            r2 = 0
            int r1 = android.view.View.resolveSizeAndState(r1, r8, r2)
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r2 = r2 & r1
            int r3 = r7.f1291g
            int r2 = r2 - r3
            if (r24 != 0) goto L_0x033b
            if (r2 == 0) goto L_0x02f7
            int r5 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r5 <= 0) goto L_0x02f7
            goto L_0x033b
        L_0x02f7:
            int r0 = java.lang.Math.max(r4, r10)
            if (r32 == 0) goto L_0x0333
            r2 = 1073741824(0x40000000, float:2.0)
            if (r12 == r2) goto L_0x0333
            r10 = 0
        L_0x0302:
            if (r10 >= r11) goto L_0x0333
            android.view.View r2 = r7.q(r10)
            if (r2 == 0) goto L_0x0330
            int r4 = r2.getVisibility()
            r5 = 8
            if (r4 != r5) goto L_0x0313
            goto L_0x0330
        L_0x0313:
            android.view.ViewGroup$LayoutParams r4 = r2.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r4 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r4
            float r4 = r4.weight
            int r4 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
            if (r4 <= 0) goto L_0x0330
            r4 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r4)
            int r6 = r2.getMeasuredHeight()
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r4)
            r2.measure(r5, r6)
        L_0x0330:
            int r10 = r10 + 1
            goto L_0x0302
        L_0x0333:
            r2 = r39
            r25 = r11
            r3 = r21
            goto L_0x04d3
        L_0x033b:
            float r5 = r7.f1292h
            int r6 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r6 <= 0) goto L_0x0342
            r0 = r5
        L_0x0342:
            r5 = -1
            r15[r16] = r5
            r15[r17] = r5
            r15[r18] = r5
            r6 = 0
            r15[r6] = r5
            r28[r16] = r5
            r28[r17] = r5
            r28[r18] = r5
            r28[r6] = r5
            r7.f1291g = r6
            r6 = r4
            r9 = r23
            r4 = -1
            r10 = 0
        L_0x035b:
            if (r10 >= r11) goto L_0x047c
            android.view.View r14 = r7.q(r10)
            if (r14 == 0) goto L_0x046d
            int r5 = r14.getVisibility()
            r3 = 8
            if (r5 != r3) goto L_0x036d
            goto L_0x046d
        L_0x036d:
            android.view.ViewGroup$LayoutParams r5 = r14.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            float r3 = r5.weight
            int r23 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r23 <= 0) goto L_0x03d6
            float r8 = (float) r2
            float r8 = r8 * r3
            float r8 = r8 / r0
            int r8 = (int) r8
            float r0 = r0 - r3
            int r2 = r2 - r8
            int r3 = r37.getPaddingTop()
            int r23 = r37.getPaddingBottom()
            int r3 = r3 + r23
            r23 = r0
            int r0 = r5.topMargin
            int r3 = r3 + r0
            int r0 = r5.bottomMargin
            int r3 = r3 + r0
            int r0 = r5.height
            r24 = r2
            r25 = r11
            r11 = -1
            r2 = r39
            int r0 = android.view.ViewGroup.getChildMeasureSpec(r2, r3, r0)
            int r3 = r5.width
            if (r3 != 0) goto L_0x03b4
            r3 = 1073741824(0x40000000, float:2.0)
            if (r12 == r3) goto L_0x03a8
            goto L_0x03b6
        L_0x03a8:
            if (r8 <= 0) goto L_0x03ab
            goto L_0x03ac
        L_0x03ab:
            r8 = 0
        L_0x03ac:
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r3)
            r14.measure(r8, r0)
            goto L_0x03c6
        L_0x03b4:
            r3 = 1073741824(0x40000000, float:2.0)
        L_0x03b6:
            int r29 = r14.getMeasuredWidth()
            int r8 = r29 + r8
            if (r8 >= 0) goto L_0x03bf
            r8 = 0
        L_0x03bf:
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r3)
            r14.measure(r8, r0)
        L_0x03c6:
            int r0 = r14.getMeasuredState()
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r3
            int r9 = android.view.View.combineMeasuredStates(r9, r0)
            r0 = r23
            r3 = r24
            goto L_0x03dc
        L_0x03d6:
            r3 = r2
            r25 = r11
            r11 = -1
            r2 = r39
        L_0x03dc:
            if (r19 == 0) goto L_0x03f9
            int r8 = r7.f1291g
            int r23 = r14.getMeasuredWidth()
            int r11 = r5.leftMargin
            int r23 = r23 + r11
            int r11 = r5.rightMargin
            int r23 = r23 + r11
            int r11 = r7.p(r14)
            int r23 = r23 + r11
            int r8 = r8 + r23
            r7.f1291g = r8
            r23 = r0
            goto L_0x0413
        L_0x03f9:
            int r8 = r7.f1291g
            int r11 = r14.getMeasuredWidth()
            int r11 = r11 + r8
            r23 = r0
            int r0 = r5.leftMargin
            int r11 = r11 + r0
            int r0 = r5.rightMargin
            int r11 = r11 + r0
            int r0 = r7.p(r14)
            int r11 = r11 + r0
            int r0 = java.lang.Math.max(r8, r11)
            r7.f1291g = r0
        L_0x0413:
            r0 = 1073741824(0x40000000, float:2.0)
            if (r13 == r0) goto L_0x041e
            int r0 = r5.height
            r8 = -1
            if (r0 != r8) goto L_0x041e
            r0 = 1
            goto L_0x041f
        L_0x041e:
            r0 = 0
        L_0x041f:
            int r8 = r5.topMargin
            int r11 = r5.bottomMargin
            int r8 = r8 + r11
            int r11 = r14.getMeasuredHeight()
            int r11 = r11 + r8
            int r4 = java.lang.Math.max(r4, r11)
            if (r0 == 0) goto L_0x0430
            goto L_0x0431
        L_0x0430:
            r8 = r11
        L_0x0431:
            int r0 = java.lang.Math.max(r6, r8)
            if (r26 == 0) goto L_0x043e
            int r6 = r5.height
            r8 = -1
            if (r6 != r8) goto L_0x043f
            r6 = 1
            goto L_0x0440
        L_0x043e:
            r8 = -1
        L_0x043f:
            r6 = 0
        L_0x0440:
            if (r36 == 0) goto L_0x0467
            int r14 = r14.getBaseline()
            if (r14 == r8) goto L_0x0467
            int r5 = r5.gravity
            if (r5 >= 0) goto L_0x044e
            int r5 = r7.f1290f
        L_0x044e:
            r5 = r5 & 112(0x70, float:1.57E-43)
            r8 = 4
            int r5 = r5 >> r8
            r5 = r5 & -2
            int r5 = r5 >> 1
            r8 = r15[r5]
            int r8 = java.lang.Math.max(r8, r14)
            r15[r5] = r8
            r8 = r28[r5]
            int r11 = r11 - r14
            int r8 = java.lang.Math.max(r8, r11)
            r28[r5] = r8
        L_0x0467:
            r26 = r6
            r6 = r0
            r0 = r23
            goto L_0x0472
        L_0x046d:
            r3 = r2
            r25 = r11
            r2 = r39
        L_0x0472:
            int r10 = r10 + 1
            r8 = r38
            r2 = r3
            r11 = r25
            r5 = -1
            goto L_0x035b
        L_0x047c:
            r2 = r39
            r25 = r11
            int r0 = r7.f1291g
            int r3 = r37.getPaddingLeft()
            int r5 = r37.getPaddingRight()
            int r3 = r3 + r5
            int r0 = r0 + r3
            r7.f1291g = r0
            r0 = r15[r18]
            r3 = -1
            if (r0 != r3) goto L_0x04a3
            r5 = 0
            r8 = r15[r5]
            if (r8 != r3) goto L_0x04a3
            r5 = r15[r17]
            if (r5 != r3) goto L_0x04a3
            r5 = r15[r16]
            if (r5 == r3) goto L_0x04a1
            goto L_0x04a3
        L_0x04a1:
            r0 = r4
            goto L_0x04cf
        L_0x04a3:
            r3 = r15[r16]
            r5 = 0
            r8 = r15[r5]
            r10 = r15[r17]
            int r0 = java.lang.Math.max(r0, r10)
            int r0 = java.lang.Math.max(r8, r0)
            int r0 = java.lang.Math.max(r3, r0)
            r3 = r28[r16]
            r5 = r28[r5]
            r8 = r28[r18]
            r10 = r28[r17]
            int r8 = java.lang.Math.max(r8, r10)
            int r5 = java.lang.Math.max(r5, r8)
            int r3 = java.lang.Math.max(r3, r5)
            int r0 = r0 + r3
            int r0 = java.lang.Math.max(r4, r0)
        L_0x04cf:
            r3 = r0
            r0 = r6
            r23 = r9
        L_0x04d3:
            if (r26 != 0) goto L_0x04da
            r4 = 1073741824(0x40000000, float:2.0)
            if (r13 == r4) goto L_0x04da
            goto L_0x04db
        L_0x04da:
            r0 = r3
        L_0x04db:
            int r3 = r37.getPaddingTop()
            int r4 = r37.getPaddingBottom()
            int r3 = r3 + r4
            int r0 = r0 + r3
            int r3 = r37.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r0, r3)
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3 = r23 & r3
            r1 = r1 | r3
            int r3 = r23 << 16
            int r0 = android.view.View.resolveSizeAndState(r0, r2, r3)
            r7.setMeasuredDimension(r1, r0)
            if (r27 == 0) goto L_0x0504
            r0 = r38
            r1 = r25
            r7.i(r1, r0)
        L_0x0504:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.v(int, int):void");
    }

    /* access modifiers changed from: package-private */
    public int w(int i2) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0330  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x(int r34, int r35) {
        /*
            r33 = this;
            r7 = r33
            r8 = r34
            r9 = r35
            r10 = 0
            r7.f1291g = r10
            int r11 = r33.getVirtualChildCount()
            int r12 = android.view.View.MeasureSpec.getMode(r34)
            int r13 = android.view.View.MeasureSpec.getMode(r35)
            int r14 = r7.f1287c
            boolean r15 = r7.f1293i
            r16 = 1
            r17 = 0
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r18 = 0
            r19 = 1
            r20 = 0
        L_0x002a:
            r10 = 8
            r22 = r4
            if (r6 >= r11) goto L_0x0197
            android.view.View r4 = r7.q(r6)
            if (r4 != 0) goto L_0x0047
            int r4 = r7.f1291g
            int r10 = r7.w(r6)
            int r4 = r4 + r10
            r7.f1291g = r4
            r26 = r11
            r24 = r13
            r4 = r22
            goto L_0x018b
        L_0x0047:
            r24 = r1
            int r1 = r4.getVisibility()
            if (r1 != r10) goto L_0x005e
            int r1 = r7.n(r4, r6)
            int r6 = r6 + r1
            r26 = r11
            r4 = r22
            r1 = r24
            r24 = r13
            goto L_0x018b
        L_0x005e:
            boolean r1 = r7.r(r6)
            if (r1 == 0) goto L_0x006b
            int r1 = r7.f1291g
            int r10 = r7.f1298n
            int r1 = r1 + r10
            r7.f1291g = r1
        L_0x006b:
            android.view.ViewGroup$LayoutParams r1 = r4.getLayoutParams()
            r10 = r1
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r10 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r10
            float r1 = r10.weight
            float r25 = r0 + r1
            r0 = 1073741824(0x40000000, float:2.0)
            if (r13 != r0) goto L_0x00a5
            int r0 = r10.height
            if (r0 != 0) goto L_0x00a5
            int r0 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a5
            int r0 = r7.f1291g
            int r1 = r10.topMargin
            int r1 = r1 + r0
            r26 = r2
            int r2 = r10.bottomMargin
            int r1 = r1 + r2
            int r0 = java.lang.Math.max(r0, r1)
            r7.f1291g = r0
            r0 = r3
            r3 = r4
            r31 = r5
            r8 = r24
            r29 = r26
            r18 = 1
            r26 = r11
            r24 = r13
            r13 = r22
            r11 = r6
            goto L_0x0113
        L_0x00a5:
            r26 = r2
            int r0 = r10.height
            if (r0 != 0) goto L_0x00b4
            int r0 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x00b4
            r0 = -2
            r10.height = r0
            r2 = 0
            goto L_0x00b6
        L_0x00b4:
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00b6:
            r27 = 0
            int r0 = (r25 > r17 ? 1 : (r25 == r17 ? 0 : -1))
            if (r0 != 0) goto L_0x00c1
            int r0 = r7.f1291g
            r23 = r0
            goto L_0x00c3
        L_0x00c1:
            r23 = 0
        L_0x00c3:
            r28 = 1073741824(0x40000000, float:2.0)
            r0 = r33
            r8 = r24
            r1 = r4
            r30 = r2
            r29 = r26
            r2 = r6
            r9 = r3
            r3 = r34
            r26 = r11
            r24 = r13
            r13 = r22
            r11 = 1073741824(0x40000000, float:2.0)
            r22 = r4
            r4 = r27
            r31 = r5
            r5 = r35
            r11 = r6
            r6 = r23
            r0.u(r1, r2, r3, r4, r5, r6)
            r0 = r30
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r1) goto L_0x00f0
            r10.height = r0
        L_0x00f0:
            int r0 = r22.getMeasuredHeight()
            int r1 = r7.f1291g
            int r2 = r1 + r0
            int r3 = r10.topMargin
            int r2 = r2 + r3
            int r3 = r10.bottomMargin
            int r2 = r2 + r3
            r3 = r22
            int r4 = r7.p(r3)
            int r2 = r2 + r4
            int r1 = java.lang.Math.max(r1, r2)
            r7.f1291g = r1
            if (r15 == 0) goto L_0x0112
            int r0 = java.lang.Math.max(r0, r9)
            goto L_0x0113
        L_0x0112:
            r0 = r9
        L_0x0113:
            if (r14 < 0) goto L_0x011d
            int r6 = r11 + 1
            if (r14 != r6) goto L_0x011d
            int r1 = r7.f1291g
            r7.f1288d = r1
        L_0x011d:
            if (r11 >= r14) goto L_0x012e
            float r1 = r10.weight
            int r1 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r1 > 0) goto L_0x0126
            goto L_0x012e
        L_0x0126:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex."
            r0.<init>(r1)
            throw r0
        L_0x012e:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r12 == r1) goto L_0x013b
            int r1 = r10.width
            r2 = -1
            if (r1 != r2) goto L_0x013b
            r1 = 1
            r20 = 1
            goto L_0x013c
        L_0x013b:
            r1 = 0
        L_0x013c:
            int r2 = r10.leftMargin
            int r4 = r10.rightMargin
            int r2 = r2 + r4
            int r4 = r3.getMeasuredWidth()
            int r4 = r4 + r2
            r5 = r29
            int r5 = java.lang.Math.max(r5, r4)
            int r6 = r3.getMeasuredState()
            int r6 = android.view.View.combineMeasuredStates(r8, r6)
            if (r19 == 0) goto L_0x015e
            int r8 = r10.width
            r9 = -1
            if (r8 != r9) goto L_0x015e
            r19 = 1
            goto L_0x0160
        L_0x015e:
            r19 = 0
        L_0x0160:
            float r8 = r10.weight
            int r8 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r8 <= 0) goto L_0x0171
            if (r1 == 0) goto L_0x0169
            goto L_0x016a
        L_0x0169:
            r2 = r4
        L_0x016a:
            int r4 = java.lang.Math.max(r13, r2)
            r1 = r31
            goto L_0x017c
        L_0x0171:
            if (r1 == 0) goto L_0x0174
            goto L_0x0175
        L_0x0174:
            r2 = r4
        L_0x0175:
            r1 = r31
            int r1 = java.lang.Math.max(r1, r2)
            r4 = r13
        L_0x017c:
            int r2 = r7.n(r3, r11)
            int r2 = r2 + r11
            r3 = r0
            r0 = r25
            r32 = r5
            r5 = r1
            r1 = r6
            r6 = r2
            r2 = r32
        L_0x018b:
            int r6 = r6 + 1
            r8 = r34
            r9 = r35
            r13 = r24
            r11 = r26
            goto L_0x002a
        L_0x0197:
            r8 = r1
            r9 = r3
            r1 = r5
            r26 = r11
            r24 = r13
            r13 = r22
            r5 = r2
            int r2 = r7.f1291g
            if (r2 <= 0) goto L_0x01b5
            r2 = r26
            boolean r3 = r7.r(r2)
            if (r3 == 0) goto L_0x01b7
            int r3 = r7.f1291g
            int r4 = r7.f1298n
            int r3 = r3 + r4
            r7.f1291g = r3
            goto L_0x01b7
        L_0x01b5:
            r2 = r26
        L_0x01b7:
            r3 = r24
            if (r15 == 0) goto L_0x0206
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 == r4) goto L_0x01c1
            if (r3 != 0) goto L_0x0206
        L_0x01c1:
            r4 = 0
            r7.f1291g = r4
            r4 = 0
        L_0x01c5:
            if (r4 >= r2) goto L_0x0206
            android.view.View r6 = r7.q(r4)
            if (r6 != 0) goto L_0x01d7
            int r6 = r7.f1291g
            int r11 = r7.w(r4)
            int r6 = r6 + r11
            r7.f1291g = r6
            goto L_0x0201
        L_0x01d7:
            int r11 = r6.getVisibility()
            if (r11 != r10) goto L_0x01e3
            int r6 = r7.n(r6, r4)
            int r4 = r4 + r6
            goto L_0x0201
        L_0x01e3:
            android.view.ViewGroup$LayoutParams r11 = r6.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r11 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r11
            int r14 = r7.f1291g
            int r21 = r14 + r9
            int r10 = r11.topMargin
            int r21 = r21 + r10
            int r10 = r11.bottomMargin
            int r21 = r21 + r10
            int r6 = r7.p(r6)
            int r6 = r21 + r6
            int r6 = java.lang.Math.max(r14, r6)
            r7.f1291g = r6
        L_0x0201:
            int r4 = r4 + 1
            r10 = 8
            goto L_0x01c5
        L_0x0206:
            int r4 = r7.f1291g
            int r6 = r33.getPaddingTop()
            int r10 = r33.getPaddingBottom()
            int r6 = r6 + r10
            int r4 = r4 + r6
            r7.f1291g = r4
            int r6 = r33.getSuggestedMinimumHeight()
            int r4 = java.lang.Math.max(r4, r6)
            r6 = r35
            r10 = r9
            r9 = 0
            int r4 = android.view.View.resolveSizeAndState(r4, r6, r9)
            r9 = 16777215(0xffffff, float:2.3509886E-38)
            r9 = r9 & r4
            int r11 = r7.f1291g
            int r9 = r9 - r11
            if (r18 != 0) goto L_0x0275
            if (r9 == 0) goto L_0x0234
            int r11 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r11 <= 0) goto L_0x0234
            goto L_0x0275
        L_0x0234:
            int r0 = java.lang.Math.max(r1, r13)
            if (r15 == 0) goto L_0x0270
            r1 = 1073741824(0x40000000, float:2.0)
            if (r3 == r1) goto L_0x0270
            r1 = 0
        L_0x023f:
            if (r1 >= r2) goto L_0x0270
            android.view.View r3 = r7.q(r1)
            if (r3 == 0) goto L_0x026d
            int r9 = r3.getVisibility()
            r11 = 8
            if (r9 != r11) goto L_0x0250
            goto L_0x026d
        L_0x0250:
            android.view.ViewGroup$LayoutParams r9 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r9 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r9
            float r9 = r9.weight
            int r9 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r9 <= 0) goto L_0x026d
            int r9 = r3.getMeasuredWidth()
            r11 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r11)
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r11)
            r3.measure(r9, r13)
        L_0x026d:
            int r1 = r1 + 1
            goto L_0x023f
        L_0x0270:
            r11 = r34
            r1 = r8
            goto L_0x0368
        L_0x0275:
            float r10 = r7.f1292h
            int r11 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r11 <= 0) goto L_0x027c
            r0 = r10
        L_0x027c:
            r10 = 0
            r7.f1291g = r10
            r11 = r9
            r9 = r1
            r1 = r8
            r8 = 0
        L_0x0283:
            if (r8 >= r2) goto L_0x0357
            android.view.View r13 = r7.q(r8)
            int r14 = r13.getVisibility()
            r15 = 8
            if (r14 != r15) goto L_0x0297
            r21 = r11
            r11 = r34
            goto L_0x0350
        L_0x0297:
            android.view.ViewGroup$LayoutParams r14 = r13.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r14 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r14
            float r10 = r14.weight
            int r18 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r18 <= 0) goto L_0x02fa
            float r15 = (float) r11
            float r15 = r15 * r10
            float r15 = r15 / r0
            int r15 = (int) r15
            float r0 = r0 - r10
            int r11 = r11 - r15
            int r10 = r33.getPaddingLeft()
            int r18 = r33.getPaddingRight()
            int r10 = r10 + r18
            r18 = r0
            int r0 = r14.leftMargin
            int r10 = r10 + r0
            int r0 = r14.rightMargin
            int r10 = r10 + r0
            int r0 = r14.width
            r21 = r11
            r11 = r34
            int r0 = android.view.ViewGroup.getChildMeasureSpec(r11, r10, r0)
            int r10 = r14.height
            if (r10 != 0) goto L_0x02db
            r10 = 1073741824(0x40000000, float:2.0)
            if (r3 == r10) goto L_0x02cf
            goto L_0x02dd
        L_0x02cf:
            if (r15 <= 0) goto L_0x02d2
            goto L_0x02d3
        L_0x02d2:
            r15 = 0
        L_0x02d3:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r10)
            r13.measure(r0, r15)
            goto L_0x02ed
        L_0x02db:
            r10 = 1073741824(0x40000000, float:2.0)
        L_0x02dd:
            int r23 = r13.getMeasuredHeight()
            int r15 = r23 + r15
            if (r15 >= 0) goto L_0x02e6
            r15 = 0
        L_0x02e6:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r10)
            r13.measure(r0, r15)
        L_0x02ed:
            int r0 = r13.getMeasuredState()
            r0 = r0 & -256(0xffffffffffffff00, float:NaN)
            int r1 = android.view.View.combineMeasuredStates(r1, r0)
            r0 = r18
            goto L_0x02ff
        L_0x02fa:
            r10 = r11
            r11 = r34
            r21 = r10
        L_0x02ff:
            int r10 = r14.leftMargin
            int r15 = r14.rightMargin
            int r10 = r10 + r15
            int r15 = r13.getMeasuredWidth()
            int r15 = r15 + r10
            int r5 = java.lang.Math.max(r5, r15)
            r18 = r0
            r0 = 1073741824(0x40000000, float:2.0)
            if (r12 == r0) goto L_0x031c
            int r0 = r14.width
            r23 = r1
            r1 = -1
            if (r0 != r1) goto L_0x031f
            r0 = 1
            goto L_0x0320
        L_0x031c:
            r23 = r1
            r1 = -1
        L_0x031f:
            r0 = 0
        L_0x0320:
            if (r0 == 0) goto L_0x0323
            goto L_0x0324
        L_0x0323:
            r10 = r15
        L_0x0324:
            int r0 = java.lang.Math.max(r9, r10)
            if (r19 == 0) goto L_0x0330
            int r9 = r14.width
            if (r9 != r1) goto L_0x0330
            r9 = 1
            goto L_0x0331
        L_0x0330:
            r9 = 0
        L_0x0331:
            int r10 = r7.f1291g
            int r15 = r13.getMeasuredHeight()
            int r15 = r15 + r10
            int r1 = r14.topMargin
            int r15 = r15 + r1
            int r1 = r14.bottomMargin
            int r15 = r15 + r1
            int r1 = r7.p(r13)
            int r15 = r15 + r1
            int r1 = java.lang.Math.max(r10, r15)
            r7.f1291g = r1
            r19 = r9
            r1 = r23
            r9 = r0
            r0 = r18
        L_0x0350:
            int r8 = r8 + 1
            r11 = r21
            r10 = 0
            goto L_0x0283
        L_0x0357:
            r11 = r34
            int r0 = r7.f1291g
            int r3 = r33.getPaddingTop()
            int r8 = r33.getPaddingBottom()
            int r3 = r3 + r8
            int r0 = r0 + r3
            r7.f1291g = r0
            r0 = r9
        L_0x0368:
            if (r19 != 0) goto L_0x036f
            r3 = 1073741824(0x40000000, float:2.0)
            if (r12 == r3) goto L_0x036f
            goto L_0x0370
        L_0x036f:
            r0 = r5
        L_0x0370:
            int r3 = r33.getPaddingLeft()
            int r5 = r33.getPaddingRight()
            int r3 = r3 + r5
            int r0 = r0 + r3
            int r3 = r33.getSuggestedMinimumWidth()
            int r0 = java.lang.Math.max(r0, r3)
            int r0 = android.view.View.resolveSizeAndState(r0, r11, r1)
            r7.setMeasuredDimension(r0, r4)
            if (r20 == 0) goto L_0x038e
            r7.j(r2, r6)
        L_0x038e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.x(int, int):void");
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1286b = true;
        this.f1287c = -1;
        this.f1288d = 0;
        this.f1290f = 8388659;
        int[] iArr = R$styleable.f267k1;
        TintTypedArray v2 = TintTypedArray.v(context, attributeSet, iArr, i2, 0);
        ViewCompat.p0(this, context, iArr, attributeSet, v2.r(), i2, 0);
        int k2 = v2.k(R$styleable.f273m1, -1);
        if (k2 >= 0) {
            setOrientation(k2);
        }
        int k3 = v2.k(R$styleable.f270l1, -1);
        if (k3 >= 0) {
            setGravity(k3);
        }
        boolean a2 = v2.a(R$styleable.f276n1, true);
        if (!a2) {
            setBaselineAligned(a2);
        }
        this.f1292h = v2.i(R$styleable.f282p1, -1.0f);
        this.f1287c = v2.k(R$styleable.f279o1, -1);
        this.f1293i = v2.a(R$styleable.f291s1, false);
        setDividerDrawable(v2.g(R$styleable.f285q1));
        this.f1299o = v2.k(R$styleable.t1, 0);
        this.f1300p = v2.f(R$styleable.f288r1, 0);
        v2.w();
    }
}
