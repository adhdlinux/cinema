package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    SparseArray<View> f1996b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<ConstraintHelper> f1997c = new ArrayList<>(4);

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<ConstraintWidget> f1998d = new ArrayList<>(100);

    /* renamed from: e  reason: collision with root package name */
    ConstraintWidgetContainer f1999e = new ConstraintWidgetContainer();

    /* renamed from: f  reason: collision with root package name */
    private int f2000f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f2001g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f2002h = Integer.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    private int f2003i = Integer.MAX_VALUE;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2004j = true;

    /* renamed from: k  reason: collision with root package name */
    private int f2005k = 7;

    /* renamed from: l  reason: collision with root package name */
    private ConstraintSet f2006l = null;

    /* renamed from: m  reason: collision with root package name */
    private int f2007m = -1;

    /* renamed from: n  reason: collision with root package name */
    private HashMap<String, Integer> f2008n = new HashMap<>();

    /* renamed from: o  reason: collision with root package name */
    private int f2009o = -1;

    /* renamed from: p  reason: collision with root package name */
    private int f2010p = -1;

    /* renamed from: q  reason: collision with root package name */
    int f2011q = -1;

    /* renamed from: r  reason: collision with root package name */
    int f2012r = -1;

    /* renamed from: s  reason: collision with root package name */
    int f2013s = 0;

    /* renamed from: t  reason: collision with root package name */
    int f2014t = 0;

    /* renamed from: u  reason: collision with root package name */
    private Metrics f2015u;

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g(attributeSet);
    }

    private final ConstraintWidget d(int i2) {
        if (i2 == 0) {
            return this.f1999e;
        }
        View view = this.f1996b.get(i2);
        if (view == null && (view = findViewById(i2)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f1999e;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f2039l0;
    }

    private void g(AttributeSet attributeSet) {
        this.f1999e.W(this);
        this.f1996b.put(getId(), this);
        this.f2006l = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f2124a);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.f2136e) {
                    this.f2000f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2000f);
                } else if (index == R$styleable.f2139f) {
                    this.f2001g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2001g);
                } else if (index == R$styleable.f2130c) {
                    this.f2002h = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2002h);
                } else if (index == R$styleable.f2133d) {
                    this.f2003i = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2003i);
                } else if (index == R$styleable.f2146h0) {
                    this.f2005k = obtainStyledAttributes.getInt(index, this.f2005k);
                } else if (index == R$styleable.f2148i) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f2006l = constraintSet;
                        constraintSet.e(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.f2006l = null;
                    }
                    this.f2007m = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1999e.c1(this.f2005k);
    }

    private void h(int i2, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int baseline;
        int i4;
        int i5;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i6 = i2;
        int i7 = i3;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = layoutParams.f2039l0;
                if (!layoutParams.Y && !layoutParams.Z) {
                    constraintWidget.x0(childAt.getVisibility());
                    int i9 = layoutParams.width;
                    int i10 = layoutParams.height;
                    boolean z9 = layoutParams.V;
                    if (z9 || z8 || ((!z9 && layoutParams.I == 1) || i9 == -1 || (!(z8 = layoutParams.W) && (layoutParams.J == 1 || i10 == -1)))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        if (i9 == 0) {
                            i4 = ViewGroup.getChildMeasureSpec(i6, paddingLeft, -2);
                            z4 = true;
                        } else if (i9 == -1) {
                            i4 = ViewGroup.getChildMeasureSpec(i6, paddingLeft, -1);
                            z4 = false;
                        } else {
                            if (i9 == -2) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            z4 = z7;
                            i4 = ViewGroup.getChildMeasureSpec(i6, paddingLeft, i9);
                        }
                        if (i10 == 0) {
                            i5 = ViewGroup.getChildMeasureSpec(i7, paddingTop, -2);
                            z3 = true;
                        } else if (i10 == -1) {
                            i5 = ViewGroup.getChildMeasureSpec(i7, paddingTop, -1);
                            z3 = false;
                        } else {
                            if (i10 == -2) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            i5 = ViewGroup.getChildMeasureSpec(i7, paddingTop, i10);
                        }
                        childAt.measure(i4, i5);
                        Metrics metrics = this.f2015u;
                        if (metrics != null) {
                            metrics.f1789a++;
                        }
                        if (i9 == -2) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        constraintWidget.z0(z5);
                        if (i10 == -2) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        constraintWidget.c0(z6);
                        i9 = childAt.getMeasuredWidth();
                        i10 = childAt.getMeasuredHeight();
                    } else {
                        z4 = false;
                        z3 = false;
                    }
                    constraintWidget.y0(i9);
                    constraintWidget.b0(i10);
                    if (z4) {
                        constraintWidget.B0(i9);
                    }
                    if (z3) {
                        constraintWidget.A0(i10);
                    }
                    if (layoutParams.X && (baseline = childAt.getBaseline()) != -1) {
                        constraintWidget.V(baseline);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i(int r24, int r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            int r3 = r23.getPaddingTop()
            int r4 = r23.getPaddingBottom()
            int r3 = r3 + r4
            int r4 = r23.getPaddingLeft()
            int r5 = r23.getPaddingRight()
            int r4 = r4 + r5
            int r5 = r23.getChildCount()
            r7 = 0
        L_0x001d:
            r8 = 1
            r10 = 8
            r12 = -2
            if (r7 >= r5) goto L_0x00dc
            android.view.View r14 = r0.getChildAt(r7)
            int r15 = r14.getVisibility()
            if (r15 != r10) goto L_0x0030
            goto L_0x00d4
        L_0x0030:
            android.view.ViewGroup$LayoutParams r10 = r14.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r10 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r10
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = r10.f2039l0
            boolean r6 = r10.Y
            if (r6 != 0) goto L_0x00d4
            boolean r6 = r10.Z
            if (r6 == 0) goto L_0x0042
            goto L_0x00d4
        L_0x0042:
            int r6 = r14.getVisibility()
            r15.x0(r6)
            int r6 = r10.width
            int r13 = r10.height
            if (r6 == 0) goto L_0x00c4
            if (r13 != 0) goto L_0x0053
            goto L_0x00c4
        L_0x0053:
            if (r6 != r12) goto L_0x0058
            r16 = 1
            goto L_0x005a
        L_0x0058:
            r16 = 0
        L_0x005a:
            int r11 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r6)
            if (r13 != r12) goto L_0x0063
            r17 = 1
            goto L_0x0065
        L_0x0063:
            r17 = 0
        L_0x0065:
            int r12 = android.view.ViewGroup.getChildMeasureSpec(r2, r3, r13)
            r14.measure(r11, r12)
            androidx.constraintlayout.solver.Metrics r11 = r0.f2015u
            r12 = r3
            if (r11 == 0) goto L_0x0076
            long r2 = r11.f1789a
            long r2 = r2 + r8
            r11.f1789a = r2
        L_0x0076:
            r2 = -2
            if (r6 != r2) goto L_0x007b
            r3 = 1
            goto L_0x007c
        L_0x007b:
            r3 = 0
        L_0x007c:
            r15.z0(r3)
            if (r13 != r2) goto L_0x0083
            r13 = 1
            goto L_0x0084
        L_0x0083:
            r13 = 0
        L_0x0084:
            r15.c0(r13)
            int r2 = r14.getMeasuredWidth()
            int r3 = r14.getMeasuredHeight()
            r15.y0(r2)
            r15.b0(r3)
            if (r16 == 0) goto L_0x009a
            r15.B0(r2)
        L_0x009a:
            if (r17 == 0) goto L_0x009f
            r15.A0(r3)
        L_0x009f:
            boolean r6 = r10.X
            if (r6 == 0) goto L_0x00ad
            int r6 = r14.getBaseline()
            r8 = -1
            if (r6 == r8) goto L_0x00ad
            r15.V(r6)
        L_0x00ad:
            boolean r6 = r10.V
            if (r6 == 0) goto L_0x00d5
            boolean r6 = r10.W
            if (r6 == 0) goto L_0x00d5
            androidx.constraintlayout.solver.widgets.ResolutionDimension r6 = r15.x()
            r6.h(r2)
            androidx.constraintlayout.solver.widgets.ResolutionDimension r2 = r15.w()
            r2.h(r3)
            goto L_0x00d5
        L_0x00c4:
            r12 = r3
            androidx.constraintlayout.solver.widgets.ResolutionDimension r2 = r15.x()
            r2.c()
            androidx.constraintlayout.solver.widgets.ResolutionDimension r2 = r15.w()
            r2.c()
            goto L_0x00d5
        L_0x00d4:
            r12 = r3
        L_0x00d5:
            int r7 = r7 + 1
            r2 = r25
            r3 = r12
            goto L_0x001d
        L_0x00dc:
            r12 = r3
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r2 = r0.f1999e
            r2.e1()
            r2 = 0
        L_0x00e3:
            if (r2 >= r5) goto L_0x02de
            android.view.View r3 = r0.getChildAt(r2)
            int r6 = r3.getVisibility()
            if (r6 != r10) goto L_0x00f1
            goto L_0x02c5
        L_0x00f1:
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r6 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r6
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r6.f2039l0
            boolean r11 = r6.Y
            if (r11 != 0) goto L_0x02c5
            boolean r11 = r6.Z
            if (r11 == 0) goto L_0x0103
            goto L_0x02c5
        L_0x0103:
            int r11 = r3.getVisibility()
            r7.x0(r11)
            int r11 = r6.width
            int r13 = r6.height
            if (r11 == 0) goto L_0x0114
            if (r13 == 0) goto L_0x0114
            goto L_0x02c5
        L_0x0114:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r14 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r15 = r7.h(r14)
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r15 = r15.f()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r17 = r7.h(r10)
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r17 = r17.f()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r7.h(r14)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r14.i()
            if (r14 == 0) goto L_0x013e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r7.h(r10)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r10.i()
            if (r10 == 0) goto L_0x013e
            r10 = 1
            goto L_0x013f
        L_0x013e:
            r10 = 0
        L_0x013f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r14 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r18 = r7.h(r14)
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r18 = r18.f()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r7.h(r8)
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r9 = r9.f()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r7.h(r14)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r14.i()
            if (r14 == 0) goto L_0x0169
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r7.h(r8)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.i()
            if (r8 == 0) goto L_0x0169
            r8 = 1
            goto L_0x016a
        L_0x0169:
            r8 = 0
        L_0x016a:
            if (r11 != 0) goto L_0x017e
            if (r13 != 0) goto L_0x017e
            if (r10 == 0) goto L_0x017e
            if (r8 == 0) goto L_0x017e
            r8 = r25
            r21 = r2
            r20 = r5
            r0 = -2
            r2 = -1
            r18 = 1
            goto L_0x02cf
        L_0x017e:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r14 = r0.f1999e
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = r14.s()
            r20 = r5
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r21 = r2
            if (r14 == r5) goto L_0x018e
            r14 = 1
            goto L_0x018f
        L_0x018e:
            r14 = 0
        L_0x018f:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r2 = r0.f1999e
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = r2.B()
            if (r2 == r5) goto L_0x0199
            r2 = 1
            goto L_0x019a
        L_0x0199:
            r2 = 0
        L_0x019a:
            if (r14 != 0) goto L_0x01a3
            androidx.constraintlayout.solver.widgets.ResolutionDimension r5 = r7.x()
            r5.c()
        L_0x01a3:
            if (r2 != 0) goto L_0x01ac
            androidx.constraintlayout.solver.widgets.ResolutionDimension r5 = r7.w()
            r5.c()
        L_0x01ac:
            if (r11 != 0) goto L_0x01e3
            if (r14 == 0) goto L_0x01da
            boolean r5 = r7.P()
            if (r5 == 0) goto L_0x01da
            if (r10 == 0) goto L_0x01da
            boolean r5 = r15.d()
            if (r5 == 0) goto L_0x01da
            boolean r5 = r17.d()
            if (r5 == 0) goto L_0x01da
            float r5 = r17.k()
            float r10 = r15.k()
            float r5 = r5 - r10
            int r11 = (int) r5
            androidx.constraintlayout.solver.widgets.ResolutionDimension r5 = r7.x()
            r5.h(r11)
            int r5 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r11)
            goto L_0x01ec
        L_0x01da:
            r5 = -2
            int r10 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r5)
            r5 = r10
            r10 = 1
            r14 = 0
            goto L_0x01fc
        L_0x01e3:
            r5 = -2
            r10 = -1
            if (r11 != r10) goto L_0x01ee
            int r15 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r10)
            r5 = r15
        L_0x01ec:
            r10 = 0
            goto L_0x01fc
        L_0x01ee:
            if (r11 != r5) goto L_0x01f2
            r5 = 1
            goto L_0x01f3
        L_0x01f2:
            r5 = 0
        L_0x01f3:
            int r10 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r11)
            r22 = r10
            r10 = r5
            r5 = r22
        L_0x01fc:
            if (r13 != 0) goto L_0x0239
            if (r2 == 0) goto L_0x022d
            boolean r15 = r7.O()
            if (r15 == 0) goto L_0x022d
            if (r8 == 0) goto L_0x022d
            boolean r8 = r18.d()
            if (r8 == 0) goto L_0x022d
            boolean r8 = r9.d()
            if (r8 == 0) goto L_0x022d
            float r8 = r9.k()
            float r9 = r18.k()
            float r8 = r8 - r9
            int r13 = (int) r8
            androidx.constraintlayout.solver.widgets.ResolutionDimension r8 = r7.w()
            r8.h(r13)
            r8 = r25
            int r9 = android.view.ViewGroup.getChildMeasureSpec(r8, r12, r13)
            r15 = r13
            goto L_0x0246
        L_0x022d:
            r8 = r25
            r9 = -2
            int r2 = android.view.ViewGroup.getChildMeasureSpec(r8, r12, r9)
            r9 = r2
            r15 = r13
            r2 = 0
            r13 = 1
            goto L_0x0257
        L_0x0239:
            r8 = r25
            r9 = -2
            r15 = -1
            if (r13 != r15) goto L_0x0248
            int r17 = android.view.ViewGroup.getChildMeasureSpec(r8, r12, r15)
            r15 = r13
            r9 = r17
        L_0x0246:
            r13 = 0
            goto L_0x0257
        L_0x0248:
            if (r13 != r9) goto L_0x024c
            r9 = 1
            goto L_0x024d
        L_0x024c:
            r9 = 0
        L_0x024d:
            int r15 = android.view.ViewGroup.getChildMeasureSpec(r8, r12, r13)
            r22 = r13
            r13 = r9
            r9 = r15
            r15 = r22
        L_0x0257:
            r3.measure(r5, r9)
            androidx.constraintlayout.solver.Metrics r5 = r0.f2015u
            if (r5 == 0) goto L_0x0267
            long r0 = r5.f1789a
            r18 = 1
            long r0 = r0 + r18
            r5.f1789a = r0
            goto L_0x0269
        L_0x0267:
            r18 = 1
        L_0x0269:
            r0 = -2
            if (r11 != r0) goto L_0x026e
            r1 = 1
            goto L_0x026f
        L_0x026e:
            r1 = 0
        L_0x026f:
            r7.z0(r1)
            if (r15 != r0) goto L_0x0276
            r1 = 1
            goto L_0x0277
        L_0x0276:
            r1 = 0
        L_0x0277:
            r7.c0(r1)
            int r1 = r3.getMeasuredWidth()
            int r5 = r3.getMeasuredHeight()
            r7.y0(r1)
            r7.b0(r5)
            if (r10 == 0) goto L_0x028d
            r7.B0(r1)
        L_0x028d:
            if (r13 == 0) goto L_0x0292
            r7.A0(r5)
        L_0x0292:
            if (r14 == 0) goto L_0x029c
            androidx.constraintlayout.solver.widgets.ResolutionDimension r9 = r7.x()
            r9.h(r1)
            goto L_0x02a3
        L_0x029c:
            androidx.constraintlayout.solver.widgets.ResolutionDimension r1 = r7.x()
            r1.g()
        L_0x02a3:
            if (r2 == 0) goto L_0x02ad
            androidx.constraintlayout.solver.widgets.ResolutionDimension r1 = r7.w()
            r1.h(r5)
            goto L_0x02b4
        L_0x02ad:
            androidx.constraintlayout.solver.widgets.ResolutionDimension r1 = r7.w()
            r1.g()
        L_0x02b4:
            boolean r1 = r6.X
            if (r1 == 0) goto L_0x02c3
            int r1 = r3.getBaseline()
            r2 = -1
            if (r1 == r2) goto L_0x02cf
            r7.V(r1)
            goto L_0x02cf
        L_0x02c3:
            r2 = -1
            goto L_0x02cf
        L_0x02c5:
            r21 = r2
            r20 = r5
            r18 = r8
            r0 = -2
            r2 = -1
            r8 = r25
        L_0x02cf:
            int r1 = r21 + 1
            r0 = r23
            r2 = r1
            r8 = r18
            r5 = r20
            r10 = 8
            r1 = r24
            goto L_0x00e3
        L_0x02de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.i(int, int):void");
    }

    private void j() {
        int i2;
        int i3;
        int i4;
        float f2;
        ConstraintWidget d2;
        ConstraintWidget d3;
        ConstraintWidget d4;
        ConstraintWidget d5;
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        boolean z2 = false;
        if (isInEditMode) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    k(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    d(childAt.getId()).X(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            ConstraintWidget f3 = f(getChildAt(i6));
            if (f3 != null) {
                f3.Q();
            }
        }
        if (this.f2007m != -1) {
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt2 = getChildAt(i7);
                if (childAt2.getId() == this.f2007m && (childAt2 instanceof Constraints)) {
                    this.f2006l = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.f2006l;
        if (constraintSet != null) {
            constraintSet.a(this);
        }
        this.f1999e.M0();
        int size = this.f1997c.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                this.f1997c.get(i8).e(this);
            }
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt3 = getChildAt(i9);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).c(this);
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt4 = getChildAt(i10);
            ConstraintWidget f4 = f(childAt4);
            if (f4 != null) {
                LayoutParams layoutParams = (LayoutParams) childAt4.getLayoutParams();
                layoutParams.a();
                if (layoutParams.f2041m0) {
                    layoutParams.f2041m0 = z2;
                } else if (isInEditMode) {
                    try {
                        String resourceName2 = getResources().getResourceName(childAt4.getId());
                        k(z2 ? 1 : 0, resourceName2, Integer.valueOf(childAt4.getId()));
                        d(childAt4.getId()).X(resourceName2.substring(resourceName2.indexOf("id/") + 3));
                    } catch (Resources.NotFoundException unused2) {
                    }
                }
                f4.x0(childAt4.getVisibility());
                if (layoutParams.f2017a0) {
                    f4.x0(8);
                }
                f4.W(childAt4);
                this.f1999e.I0(f4);
                if (!layoutParams.W || !layoutParams.V) {
                    this.f1998d.add(f4);
                }
                if (layoutParams.Y) {
                    Guideline guideline = (Guideline) f4;
                    int i11 = layoutParams.f2033i0;
                    int i12 = layoutParams.f2035j0;
                    float f5 = layoutParams.f2037k0;
                    if (f5 != -1.0f) {
                        guideline.L0(f5);
                    } else if (i11 != -1) {
                        guideline.J0(i11);
                    } else if (i12 != -1) {
                        guideline.K0(i12);
                    }
                } else if (layoutParams.f2022d != -1 || layoutParams.f2024e != -1 || layoutParams.f2026f != -1 || layoutParams.f2028g != -1 || layoutParams.f2045q != -1 || layoutParams.f2044p != -1 || layoutParams.f2046r != -1 || layoutParams.f2047s != -1 || layoutParams.f2030h != -1 || layoutParams.f2032i != -1 || layoutParams.f2034j != -1 || layoutParams.f2036k != -1 || layoutParams.f2038l != -1 || layoutParams.Q != -1 || layoutParams.R != -1 || layoutParams.f2040m != -1 || layoutParams.width == -1 || layoutParams.height == -1) {
                    int i13 = layoutParams.f2019b0;
                    int i14 = layoutParams.f2021c0;
                    int i15 = layoutParams.f2023d0;
                    int i16 = layoutParams.f2025e0;
                    int i17 = layoutParams.f2027f0;
                    int i18 = layoutParams.f2029g0;
                    float f6 = layoutParams.f2031h0;
                    int i19 = layoutParams.f2040m;
                    if (i19 != -1) {
                        ConstraintWidget d6 = d(i19);
                        if (d6 != null) {
                            f4.f(d6, layoutParams.f2043o, layoutParams.f2042n);
                        }
                    } else {
                        if (i13 != -1) {
                            ConstraintWidget d7 = d(i13);
                            if (d7 != null) {
                                ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                                ConstraintAnchor.Type type2 = type;
                                f2 = f6;
                                ConstraintWidget constraintWidget = d7;
                                i4 = i18;
                                ConstraintAnchor.Type type3 = type;
                                i3 = i16;
                                f4.J(type2, constraintWidget, type3, layoutParams.leftMargin, i17);
                            } else {
                                f2 = f6;
                                i4 = i18;
                                i3 = i16;
                            }
                        } else {
                            f2 = f6;
                            i4 = i18;
                            int i20 = i17;
                            i3 = i16;
                            if (!(i14 == -1 || (d5 = d(i14)) == null)) {
                                f4.J(ConstraintAnchor.Type.LEFT, d5, ConstraintAnchor.Type.RIGHT, layoutParams.leftMargin, i20);
                            }
                        }
                        if (i15 != -1) {
                            ConstraintWidget d8 = d(i15);
                            if (d8 != null) {
                                f4.J(ConstraintAnchor.Type.RIGHT, d8, ConstraintAnchor.Type.LEFT, layoutParams.rightMargin, i4);
                            }
                        } else {
                            int i21 = i3;
                            if (!(i21 == -1 || (d4 = d(i21)) == null)) {
                                ConstraintAnchor.Type type4 = ConstraintAnchor.Type.RIGHT;
                                f4.J(type4, d4, type4, layoutParams.rightMargin, i4);
                            }
                        }
                        int i22 = layoutParams.f2030h;
                        if (i22 != -1) {
                            ConstraintWidget d9 = d(i22);
                            if (d9 != null) {
                                ConstraintAnchor.Type type5 = ConstraintAnchor.Type.TOP;
                                f4.J(type5, d9, type5, layoutParams.topMargin, layoutParams.f2049u);
                            }
                        } else {
                            int i23 = layoutParams.f2032i;
                            if (!(i23 == -1 || (d3 = d(i23)) == null)) {
                                f4.J(ConstraintAnchor.Type.TOP, d3, ConstraintAnchor.Type.BOTTOM, layoutParams.topMargin, layoutParams.f2049u);
                            }
                        }
                        int i24 = layoutParams.f2034j;
                        if (i24 != -1) {
                            ConstraintWidget d10 = d(i24);
                            if (d10 != null) {
                                f4.J(ConstraintAnchor.Type.BOTTOM, d10, ConstraintAnchor.Type.TOP, layoutParams.bottomMargin, layoutParams.f2051w);
                            }
                        } else {
                            int i25 = layoutParams.f2036k;
                            if (!(i25 == -1 || (d2 = d(i25)) == null)) {
                                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.BOTTOM;
                                f4.J(type6, d2, type6, layoutParams.bottomMargin, layoutParams.f2051w);
                            }
                        }
                        int i26 = layoutParams.f2038l;
                        if (i26 != -1) {
                            View view = this.f1996b.get(i26);
                            ConstraintWidget d11 = d(layoutParams.f2038l);
                            if (!(d11 == null || view == null || !(view.getLayoutParams() instanceof LayoutParams))) {
                                layoutParams.X = true;
                                ((LayoutParams) view.getLayoutParams()).X = true;
                                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.BASELINE;
                                f4.h(type7).a(d11.h(type7), 0, -1, ConstraintAnchor.Strength.STRONG, 0, true);
                                f4.h(ConstraintAnchor.Type.TOP).m();
                                f4.h(ConstraintAnchor.Type.BOTTOM).m();
                            }
                        }
                        if (f2 >= 0.0f && f2 != 0.5f) {
                            f4.d0(f2);
                        }
                        float f7 = layoutParams.A;
                        if (f7 >= 0.0f && f7 != 0.5f) {
                            f4.r0(f7);
                        }
                    }
                    if (isInEditMode && !((i2 = layoutParams.Q) == -1 && layoutParams.R == -1)) {
                        f4.o0(i2, layoutParams.R);
                    }
                    if (layoutParams.V) {
                        f4.g0(ConstraintWidget.DimensionBehaviour.FIXED);
                        f4.y0(layoutParams.width);
                    } else if (layoutParams.width == -1) {
                        f4.g0(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                        f4.h(ConstraintAnchor.Type.LEFT).f1858e = layoutParams.leftMargin;
                        f4.h(ConstraintAnchor.Type.RIGHT).f1858e = layoutParams.rightMargin;
                    } else {
                        f4.g0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                        f4.y0(0);
                    }
                    if (layoutParams.W) {
                        z2 = false;
                        f4.u0(ConstraintWidget.DimensionBehaviour.FIXED);
                        f4.b0(layoutParams.height);
                    } else if (layoutParams.height == -1) {
                        f4.u0(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                        f4.h(ConstraintAnchor.Type.TOP).f1858e = layoutParams.topMargin;
                        f4.h(ConstraintAnchor.Type.BOTTOM).f1858e = layoutParams.bottomMargin;
                        z2 = false;
                    } else {
                        f4.u0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                        z2 = false;
                        f4.b0(0);
                    }
                    String str = layoutParams.B;
                    if (str != null) {
                        f4.Y(str);
                    }
                    f4.i0(layoutParams.E);
                    f4.w0(layoutParams.F);
                    f4.e0(layoutParams.G);
                    f4.s0(layoutParams.H);
                    f4.h0(layoutParams.I, layoutParams.K, layoutParams.M, layoutParams.O);
                    f4.v0(layoutParams.J, layoutParams.L, layoutParams.N, layoutParams.P);
                }
            }
        }
    }

    private void l(int i2, int i3) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int i4;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (mode != 1073741824) {
                dimensionBehaviour = dimensionBehaviour2;
            } else {
                i4 = Math.min(this.f2002h, size) - paddingLeft;
                dimensionBehaviour = dimensionBehaviour2;
            }
            i4 = 0;
        } else {
            i4 = size;
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.f2003i, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        this.f1999e.m0(0);
        this.f1999e.l0(0);
        this.f1999e.g0(dimensionBehaviour);
        this.f1999e.y0(i4);
        this.f1999e.u0(dimensionBehaviour2);
        this.f1999e.b0(size2);
        this.f1999e.m0((this.f2000f - getPaddingLeft()) - getPaddingRight());
        this.f1999e.l0((this.f2001g - getPaddingTop()) - getPaddingBottom());
    }

    private void n() {
        int childCount = getChildCount();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (getChildAt(i2).isLayoutRequested()) {
                z2 = true;
                break;
            } else {
                i2++;
            }
        }
        if (z2) {
            this.f1998d.clear();
            j();
        }
    }

    private void o() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof Placeholder) {
                ((Placeholder) childAt).b(this);
            }
        }
        int size = this.f1997c.size();
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                this.f1997c.get(i3).d(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
    }

    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public Object c(int i2, Object obj) {
        if (i2 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.f2008n;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.f2008n.get(str);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i3 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i4 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f2 = (float) i3;
                        float f3 = (float) i4;
                        float f4 = (float) (i3 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f5 = f3;
                        float f6 = f3;
                        float f7 = f4;
                        float f8 = f2;
                        Paint paint2 = paint;
                        canvas2.drawLine(f2, f5, f7, f6, paint);
                        float parseInt4 = (float) (i4 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f9 = f4;
                        float f10 = parseInt4;
                        canvas2.drawLine(f9, f6, f7, f10, paint);
                        float f11 = parseInt4;
                        float f12 = f8;
                        canvas2.drawLine(f9, f11, f12, f10, paint);
                        float f13 = f8;
                        canvas2.drawLine(f13, f11, f12, f6, paint);
                        paint.setColor(-16711936);
                        float f14 = f4;
                        Paint paint3 = paint;
                        canvas2.drawLine(f13, f6, f14, parseInt4, paint);
                        canvas2.drawLine(f13, parseInt4, f14, f6, paint);
                    }
                }
            }
        }
    }

    public View e(int i2) {
        return this.f1996b.get(i2);
    }

    public final ConstraintWidget f(View view) {
        if (view == this) {
            return this.f1999e;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f2039l0;
    }

    public int getMaxHeight() {
        return this.f2003i;
    }

    public int getMaxWidth() {
        return this.f2002h;
    }

    public int getMinHeight() {
        return this.f2001g;
    }

    public int getMinWidth() {
        return this.f2000f;
    }

    public int getOptimizationLevel() {
        return this.f1999e.R0();
    }

    public void k(int i2, Object obj, Object obj2) {
        if (i2 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f2008n == null) {
                this.f2008n = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.f2008n.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    /* access modifiers changed from: protected */
    public void m(String str) {
        this.f1999e.K0();
        Metrics metrics = this.f2015u;
        if (metrics != null) {
            metrics.f1791c++;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.f2039l0;
            if ((childAt.getVisibility() != 8 || layoutParams.Y || layoutParams.Z || isInEditMode) && !layoutParams.f2017a0) {
                int p2 = constraintWidget.p();
                int q2 = constraintWidget.q();
                int D = constraintWidget.D() + p2;
                int r2 = constraintWidget.r() + q2;
                childAt.layout(p2, q2, D, r2);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(p2, q2, D, r2);
                }
            }
        }
        int size = this.f1997c.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.f1997c.get(i7).c(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0390  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0132  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r24, int r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            int r3 = android.view.View.MeasureSpec.getMode(r24)
            int r4 = android.view.View.MeasureSpec.getSize(r24)
            int r5 = android.view.View.MeasureSpec.getMode(r25)
            int r6 = android.view.View.MeasureSpec.getSize(r25)
            int r7 = r23.getPaddingLeft()
            int r8 = r23.getPaddingTop()
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.f1999e
            r9.C0(r7)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.f1999e
            r9.D0(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.f1999e
            int r10 = r0.f2002h
            r9.k0(r10)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.f1999e
            int r10 = r0.f2003i
            r9.j0(r10)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.f1999e
            int r10 = r23.getLayoutDirection()
            r11 = 0
            r12 = 1
            if (r10 != r12) goto L_0x0042
            r10 = 1
            goto L_0x0043
        L_0x0042:
            r10 = 0
        L_0x0043:
            r9.d1(r10)
            r23.l(r24, r25)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.f1999e
            int r9 = r9.D()
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r10 = r0.f1999e
            int r10 = r10.r()
            boolean r13 = r0.f2004j
            if (r13 == 0) goto L_0x0060
            r0.f2004j = r11
            r23.n()
            r13 = 1
            goto L_0x0061
        L_0x0060:
            r13 = 0
        L_0x0061:
            int r14 = r0.f2005k
            r15 = 8
            r14 = r14 & r15
            if (r14 != r15) goto L_0x006a
            r14 = 1
            goto L_0x006b
        L_0x006a:
            r14 = 0
        L_0x006b:
            if (r14 == 0) goto L_0x007b
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r15 = r0.f1999e
            r15.a1()
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r15 = r0.f1999e
            r15.Y0(r9, r10)
            r23.i(r24, r25)
            goto L_0x007e
        L_0x007b:
            r23.h(r24, r25)
        L_0x007e:
            r23.o()
            int r15 = r23.getChildCount()
            if (r15 <= 0) goto L_0x008e
            if (r13 == 0) goto L_0x008e
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.f1999e
            androidx.constraintlayout.solver.widgets.Analyzer.a(r13)
        L_0x008e:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.f1999e
            boolean r15 = r13.I0
            if (r15 == 0) goto L_0x00c0
            boolean r15 = r13.J0
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r15 == 0) goto L_0x00aa
            if (r3 != r12) goto L_0x00aa
            int r15 = r13.L0
            if (r15 >= r4) goto L_0x00a3
            r13.y0(r15)
        L_0x00a3:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.f1999e
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r13.g0(r15)
        L_0x00aa:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.f1999e
            boolean r15 = r13.K0
            if (r15 == 0) goto L_0x00c0
            if (r5 != r12) goto L_0x00c0
            int r12 = r13.M0
            if (r12 >= r6) goto L_0x00b9
            r13.b0(r12)
        L_0x00b9:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r12 = r0.f1999e
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r12.u0(r13)
        L_0x00c0:
            int r12 = r0.f2005k
            r13 = 32
            r12 = r12 & r13
            r15 = 1073741824(0x40000000, float:2.0)
            if (r12 != r13) goto L_0x0114
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r12 = r0.f1999e
            int r12 = r12.D()
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.f1999e
            int r13 = r13.r()
            int r11 = r0.f2009o
            if (r11 == r12) goto L_0x00e3
            if (r3 != r15) goto L_0x00e3
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.f1999e
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r3 = r3.H0
            r11 = 0
            androidx.constraintlayout.solver.widgets.Analyzer.i(r3, r11, r12)
        L_0x00e3:
            int r3 = r0.f2010p
            if (r3 == r13) goto L_0x00f1
            if (r5 != r15) goto L_0x00f1
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.f1999e
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r3 = r3.H0
            r5 = 1
            androidx.constraintlayout.solver.widgets.Analyzer.i(r3, r5, r13)
        L_0x00f1:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.f1999e
            boolean r5 = r3.J0
            if (r5 == 0) goto L_0x0102
            int r5 = r3.L0
            if (r5 <= r4) goto L_0x0102
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r3 = r3.H0
            r11 = 0
            androidx.constraintlayout.solver.widgets.Analyzer.i(r3, r11, r4)
            goto L_0x0103
        L_0x0102:
            r11 = 0
        L_0x0103:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.f1999e
            boolean r4 = r3.K0
            if (r4 == 0) goto L_0x0114
            int r4 = r3.M0
            if (r4 <= r6) goto L_0x0114
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r3 = r3.H0
            r4 = 1
            androidx.constraintlayout.solver.widgets.Analyzer.i(r3, r4, r6)
            goto L_0x0115
        L_0x0114:
            r4 = 1
        L_0x0115:
            int r3 = r23.getChildCount()
            if (r3 <= 0) goto L_0x0120
            java.lang.String r3 = "First pass"
            r0.m(r3)
        L_0x0120:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r3 = r0.f1998d
            int r3 = r3.size()
            int r5 = r23.getPaddingBottom()
            int r8 = r8 + r5
            int r5 = r23.getPaddingRight()
            int r7 = r7 + r5
            if (r3 <= 0) goto L_0x0359
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r5 = r0.f1999e
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = r5.s()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r6) goto L_0x013e
            r5 = 1
            goto L_0x013f
        L_0x013e:
            r5 = 0
        L_0x013f:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r12 = r0.f1999e
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = r12.B()
            if (r12 != r6) goto L_0x0149
            r6 = 1
            goto L_0x014a
        L_0x0149:
            r6 = 0
        L_0x014a:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r12 = r0.f1999e
            int r12 = r12.D()
            int r13 = r0.f2000f
            int r12 = java.lang.Math.max(r12, r13)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.f1999e
            int r13 = r13.r()
            int r4 = r0.f2001g
            int r4 = java.lang.Math.max(r13, r4)
            r16 = r12
            r12 = 0
            r13 = 0
        L_0x0166:
            r17 = 1
            if (r12 >= r3) goto L_0x02b3
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r15 = r0.f1998d
            java.lang.Object r15 = r15.get(r12)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r15
            java.lang.Object r19 = r15.m()
            r20 = r3
            r3 = r19
            android.view.View r3 = (android.view.View) r3
            if (r3 != 0) goto L_0x0184
            r19 = r9
            r21 = r10
            goto L_0x0295
        L_0x0184:
            android.view.ViewGroup$LayoutParams r19 = r3.getLayoutParams()
            r21 = r10
            r10 = r19
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r10 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r10
            r19 = r9
            boolean r9 = r10.Z
            if (r9 != 0) goto L_0x0295
            boolean r9 = r10.Y
            if (r9 == 0) goto L_0x019a
            goto L_0x0295
        L_0x019a:
            int r9 = r3.getVisibility()
            r22 = r13
            r13 = 8
            if (r9 != r13) goto L_0x01ab
        L_0x01a4:
            r13 = r8
            r9 = r16
            r16 = r5
            goto L_0x029c
        L_0x01ab:
            if (r14 == 0) goto L_0x01c2
            androidx.constraintlayout.solver.widgets.ResolutionDimension r9 = r15.x()
            boolean r9 = r9.d()
            if (r9 == 0) goto L_0x01c2
            androidx.constraintlayout.solver.widgets.ResolutionDimension r9 = r15.w()
            boolean r9 = r9.d()
            if (r9 == 0) goto L_0x01c2
            goto L_0x01a4
        L_0x01c2:
            int r9 = r10.width
            r13 = -2
            if (r9 != r13) goto L_0x01d0
            boolean r13 = r10.V
            if (r13 == 0) goto L_0x01d0
            int r9 = android.view.ViewGroup.getChildMeasureSpec(r1, r7, r9)
            goto L_0x01da
        L_0x01d0:
            int r9 = r15.D()
            r13 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r13)
        L_0x01da:
            int r13 = r10.height
            r1 = -2
            if (r13 != r1) goto L_0x01e8
            boolean r1 = r10.W
            if (r1 == 0) goto L_0x01e8
            int r1 = android.view.ViewGroup.getChildMeasureSpec(r2, r8, r13)
            goto L_0x01f2
        L_0x01e8:
            int r1 = r15.r()
            r13 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r13)
        L_0x01f2:
            r3.measure(r9, r1)
            androidx.constraintlayout.solver.Metrics r1 = r0.f2015u
            r13 = r8
            if (r1 == 0) goto L_0x0200
            long r8 = r1.f1790b
            long r8 = r8 + r17
            r1.f1790b = r8
        L_0x0200:
            int r1 = r3.getMeasuredWidth()
            int r8 = r3.getMeasuredHeight()
            int r9 = r15.D()
            if (r1 == r9) goto L_0x0241
            r15.y0(r1)
            if (r14 == 0) goto L_0x021a
            androidx.constraintlayout.solver.widgets.ResolutionDimension r9 = r15.x()
            r9.h(r1)
        L_0x021a:
            if (r5 == 0) goto L_0x023a
            int r1 = r15.y()
            r9 = r16
            if (r1 <= r9) goto L_0x023c
            int r1 = r15.y()
            r16 = r5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r15.h(r5)
            int r5 = r5.d()
            int r1 = r1 + r5
            int r1 = java.lang.Math.max(r9, r1)
            goto L_0x023f
        L_0x023a:
            r9 = r16
        L_0x023c:
            r16 = r5
            r1 = r9
        L_0x023f:
            r5 = 1
            goto L_0x0248
        L_0x0241:
            r9 = r16
            r16 = r5
            r1 = r9
            r5 = r22
        L_0x0248:
            int r9 = r15.r()
            if (r8 == r9) goto L_0x0276
            r15.b0(r8)
            if (r14 == 0) goto L_0x025a
            androidx.constraintlayout.solver.widgets.ResolutionDimension r5 = r15.w()
            r5.h(r8)
        L_0x025a:
            if (r6 == 0) goto L_0x0275
            int r5 = r15.l()
            if (r5 <= r4) goto L_0x0275
            int r5 = r15.l()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r15.h(r8)
            int r8 = r8.d()
            int r5 = r5 + r8
            int r4 = java.lang.Math.max(r4, r5)
        L_0x0275:
            r5 = 1
        L_0x0276:
            boolean r8 = r10.X
            if (r8 == 0) goto L_0x028b
            int r8 = r3.getBaseline()
            r9 = -1
            if (r8 == r9) goto L_0x028b
            int r9 = r15.j()
            if (r8 == r9) goto L_0x028b
            r15.V(r8)
            r5 = 1
        L_0x028b:
            int r3 = r3.getMeasuredState()
            int r3 = android.view.View.combineMeasuredStates(r11, r3)
            r11 = r3
            goto L_0x029f
        L_0x0295:
            r22 = r13
            r9 = r16
            r16 = r5
            r13 = r8
        L_0x029c:
            r1 = r9
            r5 = r22
        L_0x029f:
            int r12 = r12 + 1
            r8 = r13
            r9 = r19
            r3 = r20
            r10 = r21
            r15 = 1073741824(0x40000000, float:2.0)
            r13 = r5
            r5 = r16
            r16 = r1
            r1 = r24
            goto L_0x0166
        L_0x02b3:
            r20 = r3
            r19 = r9
            r21 = r10
            r22 = r13
            r9 = r16
            r13 = r8
            if (r22 == 0) goto L_0x0301
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.f1999e
            r3 = r19
            r1.y0(r3)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.f1999e
            r3 = r21
            r1.b0(r3)
            if (r14 == 0) goto L_0x02d5
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.f1999e
            r1.e1()
        L_0x02d5:
            java.lang.String r1 = "2nd pass"
            r0.m(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.f1999e
            int r1 = r1.D()
            if (r1 >= r9) goto L_0x02e9
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.f1999e
            r1.y0(r9)
            r1 = 1
            goto L_0x02ea
        L_0x02e9:
            r1 = 0
        L_0x02ea:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.f1999e
            int r3 = r3.r()
            if (r3 >= r4) goto L_0x02f9
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.f1999e
            r1.b0(r4)
            r12 = 1
            goto L_0x02fa
        L_0x02f9:
            r12 = r1
        L_0x02fa:
            if (r12 == 0) goto L_0x0301
            java.lang.String r1 = "3rd pass"
            r0.m(r1)
        L_0x0301:
            r3 = r20
            r1 = 0
        L_0x0304:
            if (r1 >= r3) goto L_0x035b
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r4 = r0.f1998d
            java.lang.Object r4 = r4.get(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r4
            java.lang.Object r5 = r4.m()
            android.view.View r5 = (android.view.View) r5
            if (r5 != 0) goto L_0x031b
        L_0x0316:
            r8 = 8
        L_0x0318:
            r9 = 1073741824(0x40000000, float:2.0)
            goto L_0x0356
        L_0x031b:
            int r6 = r5.getMeasuredWidth()
            int r8 = r4.D()
            if (r6 != r8) goto L_0x032f
            int r6 = r5.getMeasuredHeight()
            int r8 = r4.r()
            if (r6 == r8) goto L_0x0316
        L_0x032f:
            int r6 = r4.C()
            r8 = 8
            if (r6 == r8) goto L_0x0318
            int r6 = r4.D()
            r9 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r9)
            int r4 = r4.r()
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r9)
            r5.measure(r6, r4)
            androidx.constraintlayout.solver.Metrics r4 = r0.f2015u
            if (r4 == 0) goto L_0x0356
            long r5 = r4.f1790b
            long r5 = r5 + r17
            r4.f1790b = r5
        L_0x0356:
            int r1 = r1 + 1
            goto L_0x0304
        L_0x0359:
            r13 = r8
            r11 = 0
        L_0x035b:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.f1999e
            int r1 = r1.D()
            int r1 = r1 + r7
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.f1999e
            int r3 = r3.r()
            int r3 = r3 + r13
            r4 = r24
            int r1 = android.view.View.resolveSizeAndState(r1, r4, r11)
            int r4 = r11 << 16
            int r2 = android.view.View.resolveSizeAndState(r3, r2, r4)
            r3 = 16777215(0xffffff, float:2.3509886E-38)
            r1 = r1 & r3
            r2 = r2 & r3
            int r3 = r0.f2002h
            int r1 = java.lang.Math.min(r3, r1)
            int r3 = r0.f2003i
            int r2 = java.lang.Math.min(r3, r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.f1999e
            boolean r3 = r3.V0()
            r4 = 16777216(0x1000000, float:2.3509887E-38)
            if (r3 == 0) goto L_0x0391
            r1 = r1 | r4
        L_0x0391:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.f1999e
            boolean r3 = r3.T0()
            if (r3 == 0) goto L_0x039a
            r2 = r2 | r4
        L_0x039a:
            r0.setMeasuredDimension(r1, r2)
            r0.f2009o = r1
            r0.f2010p = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget f2 = f(view);
        if ((view instanceof Guideline) && !(f2 instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Guideline guideline = new Guideline();
            layoutParams.f2039l0 = guideline;
            layoutParams.Y = true;
            guideline.M0(layoutParams.S);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.f();
            ((LayoutParams) view.getLayoutParams()).Z = true;
            if (!this.f1997c.contains(constraintHelper)) {
                this.f1997c.add(constraintHelper);
            }
        }
        this.f1996b.put(view.getId(), view);
        this.f2004j = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f1996b.remove(view.getId());
        ConstraintWidget f2 = f(view);
        this.f1999e.L0(f2);
        this.f1997c.remove(view);
        this.f1998d.remove(f2);
        this.f2004j = true;
    }

    public void removeView(View view) {
        super.removeView(view);
    }

    public void requestLayout() {
        super.requestLayout();
        this.f2004j = true;
        this.f2009o = -1;
        this.f2010p = -1;
        this.f2011q = -1;
        this.f2012r = -1;
        this.f2013s = 0;
        this.f2014t = 0;
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.f2006l = constraintSet;
    }

    public void setId(int i2) {
        this.f1996b.remove(getId());
        super.setId(i2);
        this.f1996b.put(getId(), this);
    }

    public void setMaxHeight(int i2) {
        if (i2 != this.f2003i) {
            this.f2003i = i2;
            requestLayout();
        }
    }

    public void setMaxWidth(int i2) {
        if (i2 != this.f2002h) {
            this.f2002h = i2;
            requestLayout();
        }
    }

    public void setMinHeight(int i2) {
        if (i2 != this.f2001g) {
            this.f2001g = i2;
            requestLayout();
        }
    }

    public void setMinWidth(int i2) {
        if (i2 != this.f2000f) {
            this.f2000f = i2;
            requestLayout();
        }
    }

    public void setOptimizationLevel(int i2) {
        this.f1999e.c1(i2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        g(attributeSet);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public float A = 0.5f;
        public String B = null;
        float C = 0.0f;
        int D = 1;
        public float E = -1.0f;
        public float F = -1.0f;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public float O = 1.0f;
        public float P = 1.0f;
        public int Q = -1;
        public int R = -1;
        public int S = -1;
        public boolean T = false;
        public boolean U = false;
        boolean V = true;
        boolean W = true;
        boolean X = false;
        boolean Y = false;
        boolean Z = false;

        /* renamed from: a  reason: collision with root package name */
        public int f2016a = -1;

        /* renamed from: a0  reason: collision with root package name */
        boolean f2017a0 = false;

        /* renamed from: b  reason: collision with root package name */
        public int f2018b = -1;

        /* renamed from: b0  reason: collision with root package name */
        int f2019b0 = -1;

        /* renamed from: c  reason: collision with root package name */
        public float f2020c = -1.0f;

        /* renamed from: c0  reason: collision with root package name */
        int f2021c0 = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f2022d = -1;

        /* renamed from: d0  reason: collision with root package name */
        int f2023d0 = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f2024e = -1;

        /* renamed from: e0  reason: collision with root package name */
        int f2025e0 = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f2026f = -1;

        /* renamed from: f0  reason: collision with root package name */
        int f2027f0 = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f2028g = -1;

        /* renamed from: g0  reason: collision with root package name */
        int f2029g0 = -1;

        /* renamed from: h  reason: collision with root package name */
        public int f2030h = -1;

        /* renamed from: h0  reason: collision with root package name */
        float f2031h0 = 0.5f;

        /* renamed from: i  reason: collision with root package name */
        public int f2032i = -1;

        /* renamed from: i0  reason: collision with root package name */
        int f2033i0;

        /* renamed from: j  reason: collision with root package name */
        public int f2034j = -1;

        /* renamed from: j0  reason: collision with root package name */
        int f2035j0;

        /* renamed from: k  reason: collision with root package name */
        public int f2036k = -1;

        /* renamed from: k0  reason: collision with root package name */
        float f2037k0;

        /* renamed from: l  reason: collision with root package name */
        public int f2038l = -1;

        /* renamed from: l0  reason: collision with root package name */
        ConstraintWidget f2039l0 = new ConstraintWidget();

        /* renamed from: m  reason: collision with root package name */
        public int f2040m = -1;

        /* renamed from: m0  reason: collision with root package name */
        public boolean f2041m0 = false;

        /* renamed from: n  reason: collision with root package name */
        public int f2042n = 0;

        /* renamed from: o  reason: collision with root package name */
        public float f2043o = 0.0f;

        /* renamed from: p  reason: collision with root package name */
        public int f2044p = -1;

        /* renamed from: q  reason: collision with root package name */
        public int f2045q = -1;

        /* renamed from: r  reason: collision with root package name */
        public int f2046r = -1;

        /* renamed from: s  reason: collision with root package name */
        public int f2047s = -1;

        /* renamed from: t  reason: collision with root package name */
        public int f2048t = -1;

        /* renamed from: u  reason: collision with root package name */
        public int f2049u = -1;

        /* renamed from: v  reason: collision with root package name */
        public int f2050v = -1;

        /* renamed from: w  reason: collision with root package name */
        public int f2051w = -1;

        /* renamed from: x  reason: collision with root package name */
        public int f2052x = -1;

        /* renamed from: y  reason: collision with root package name */
        public int f2053y = -1;

        /* renamed from: z  reason: collision with root package name */
        public float f2054z = 0.5f;

        private static class Table {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f2055a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f2055a = sparseIntArray;
                sparseIntArray.append(R$styleable.I, 8);
                sparseIntArray.append(R$styleable.J, 9);
                sparseIntArray.append(R$styleable.L, 10);
                sparseIntArray.append(R$styleable.M, 11);
                sparseIntArray.append(R$styleable.R, 12);
                sparseIntArray.append(R$styleable.Q, 13);
                sparseIntArray.append(R$styleable.f2172q, 14);
                sparseIntArray.append(R$styleable.f2169p, 15);
                sparseIntArray.append(R$styleable.f2163n, 16);
                sparseIntArray.append(R$styleable.f2175r, 2);
                sparseIntArray.append(R$styleable.f2181t, 3);
                sparseIntArray.append(R$styleable.f2178s, 4);
                sparseIntArray.append(R$styleable.Z, 49);
                sparseIntArray.append(R$styleable.f2125a0, 50);
                sparseIntArray.append(R$styleable.f2189x, 5);
                sparseIntArray.append(R$styleable.f2191y, 6);
                sparseIntArray.append(R$styleable.f2193z, 7);
                sparseIntArray.append(R$styleable.f2127b, 1);
                sparseIntArray.append(R$styleable.N, 17);
                sparseIntArray.append(R$styleable.O, 18);
                sparseIntArray.append(R$styleable.f2187w, 19);
                sparseIntArray.append(R$styleable.f2185v, 20);
                sparseIntArray.append(R$styleable.f2134d0, 21);
                sparseIntArray.append(R$styleable.f2143g0, 22);
                sparseIntArray.append(R$styleable.f2137e0, 23);
                sparseIntArray.append(R$styleable.f2128b0, 24);
                sparseIntArray.append(R$styleable.f2140f0, 25);
                sparseIntArray.append(R$styleable.f2131c0, 26);
                sparseIntArray.append(R$styleable.E, 29);
                sparseIntArray.append(R$styleable.S, 30);
                sparseIntArray.append(R$styleable.f2183u, 44);
                sparseIntArray.append(R$styleable.G, 45);
                sparseIntArray.append(R$styleable.U, 46);
                sparseIntArray.append(R$styleable.F, 47);
                sparseIntArray.append(R$styleable.T, 48);
                sparseIntArray.append(R$styleable.f2157l, 27);
                sparseIntArray.append(R$styleable.f2154k, 28);
                sparseIntArray.append(R$styleable.V, 31);
                sparseIntArray.append(R$styleable.A, 32);
                sparseIntArray.append(R$styleable.X, 33);
                sparseIntArray.append(R$styleable.W, 34);
                sparseIntArray.append(R$styleable.Y, 35);
                sparseIntArray.append(R$styleable.C, 36);
                sparseIntArray.append(R$styleable.B, 37);
                sparseIntArray.append(R$styleable.D, 38);
                sparseIntArray.append(R$styleable.H, 39);
                sparseIntArray.append(R$styleable.P, 40);
                sparseIntArray.append(R$styleable.K, 41);
                sparseIntArray.append(R$styleable.f2166o, 42);
                sparseIntArray.append(R$styleable.f2160m, 43);
            }

            private Table() {
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i2;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f2124a);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                int i4 = Table.f2055a.get(index);
                switch (i4) {
                    case 1:
                        this.S = obtainStyledAttributes.getInt(index, this.S);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f2040m);
                        this.f2040m = resourceId;
                        if (resourceId != -1) {
                            break;
                        } else {
                            this.f2040m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        this.f2042n = obtainStyledAttributes.getDimensionPixelSize(index, this.f2042n);
                        break;
                    case 4:
                        float f2 = obtainStyledAttributes.getFloat(index, this.f2043o) % 360.0f;
                        this.f2043o = f2;
                        if (f2 >= 0.0f) {
                            break;
                        } else {
                            this.f2043o = (360.0f - f2) % 360.0f;
                            break;
                        }
                    case 5:
                        this.f2016a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2016a);
                        break;
                    case 6:
                        this.f2018b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2018b);
                        break;
                    case 7:
                        this.f2020c = obtainStyledAttributes.getFloat(index, this.f2020c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f2022d);
                        this.f2022d = resourceId2;
                        if (resourceId2 != -1) {
                            break;
                        } else {
                            this.f2022d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f2024e);
                        this.f2024e = resourceId3;
                        if (resourceId3 != -1) {
                            break;
                        } else {
                            this.f2024e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f2026f);
                        this.f2026f = resourceId4;
                        if (resourceId4 != -1) {
                            break;
                        } else {
                            this.f2026f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f2028g);
                        this.f2028g = resourceId5;
                        if (resourceId5 != -1) {
                            break;
                        } else {
                            this.f2028g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f2030h);
                        this.f2030h = resourceId6;
                        if (resourceId6 != -1) {
                            break;
                        } else {
                            this.f2030h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f2032i);
                        this.f2032i = resourceId7;
                        if (resourceId7 != -1) {
                            break;
                        } else {
                            this.f2032i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f2034j);
                        this.f2034j = resourceId8;
                        if (resourceId8 != -1) {
                            break;
                        } else {
                            this.f2034j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f2036k);
                        this.f2036k = resourceId9;
                        if (resourceId9 != -1) {
                            break;
                        } else {
                            this.f2036k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f2038l);
                        this.f2038l = resourceId10;
                        if (resourceId10 != -1) {
                            break;
                        } else {
                            this.f2038l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.f2044p);
                        this.f2044p = resourceId11;
                        if (resourceId11 != -1) {
                            break;
                        } else {
                            this.f2044p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f2045q);
                        this.f2045q = resourceId12;
                        if (resourceId12 != -1) {
                            break;
                        } else {
                            this.f2045q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f2046r);
                        this.f2046r = resourceId13;
                        if (resourceId13 != -1) {
                            break;
                        } else {
                            this.f2046r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f2047s);
                        this.f2047s = resourceId14;
                        if (resourceId14 != -1) {
                            break;
                        } else {
                            this.f2047s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        this.f2048t = obtainStyledAttributes.getDimensionPixelSize(index, this.f2048t);
                        break;
                    case 22:
                        this.f2049u = obtainStyledAttributes.getDimensionPixelSize(index, this.f2049u);
                        break;
                    case 23:
                        this.f2050v = obtainStyledAttributes.getDimensionPixelSize(index, this.f2050v);
                        break;
                    case 24:
                        this.f2051w = obtainStyledAttributes.getDimensionPixelSize(index, this.f2051w);
                        break;
                    case 25:
                        this.f2052x = obtainStyledAttributes.getDimensionPixelSize(index, this.f2052x);
                        break;
                    case 26:
                        this.f2053y = obtainStyledAttributes.getDimensionPixelSize(index, this.f2053y);
                        break;
                    case 27:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 28:
                        this.U = obtainStyledAttributes.getBoolean(index, this.U);
                        break;
                    case 29:
                        this.f2054z = obtainStyledAttributes.getFloat(index, this.f2054z);
                        break;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        int i5 = obtainStyledAttributes.getInt(index, 0);
                        this.I = i5;
                        if (i5 != 1) {
                            break;
                        } else {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        }
                    case 32:
                        int i6 = obtainStyledAttributes.getInt(index, 0);
                        this.J = i6;
                        if (i6 != 1) {
                            break;
                        } else {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        }
                    case 33:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.K) != -2) {
                                break;
                            } else {
                                this.K = -2;
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.M) != -2) {
                                break;
                            } else {
                                this.M = -2;
                                break;
                            }
                        }
                    case 35:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        break;
                    case 36:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.L) != -2) {
                                break;
                            } else {
                                this.L = -2;
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.N) != -2) {
                                break;
                            } else {
                                this.N = -2;
                                break;
                            }
                        }
                    case 38:
                        this.P = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.P));
                        break;
                    default:
                        switch (i4) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.B = string;
                                this.C = Float.NaN;
                                this.D = -1;
                                if (string == null) {
                                    break;
                                } else {
                                    int length = string.length();
                                    int indexOf = this.B.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i2 = 0;
                                    } else {
                                        String substring = this.B.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.D = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.D = 1;
                                        }
                                        i2 = indexOf + 1;
                                    }
                                    int indexOf2 = this.B.indexOf(58);
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.B.substring(i2, indexOf2);
                                        String substring3 = this.B.substring(indexOf2 + 1);
                                        if (substring2.length() > 0 && substring3.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring2);
                                                float parseFloat2 = Float.parseFloat(substring3);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.D != 1) {
                                                        this.C = Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    } else {
                                                        this.C = Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    } else {
                                        String substring4 = this.B.substring(i2);
                                        if (substring4.length() <= 0) {
                                            break;
                                        } else {
                                            this.C = Float.parseFloat(substring4);
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 45:
                                this.E = obtainStyledAttributes.getFloat(index, this.E);
                                break;
                            case 46:
                                this.F = obtainStyledAttributes.getFloat(index, this.F);
                                break;
                            case 47:
                                this.G = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.H = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                                break;
                            case 50:
                                this.R = obtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                                break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.Y = false;
            this.V = true;
            this.W = true;
            int i2 = this.width;
            if (i2 == -2 && this.T) {
                this.V = false;
                this.I = 1;
            }
            int i3 = this.height;
            if (i3 == -2 && this.U) {
                this.W = false;
                this.J = 1;
            }
            if (i2 == 0 || i2 == -1) {
                this.V = false;
                if (i2 == 0 && this.I == 1) {
                    this.width = -2;
                    this.T = true;
                }
            }
            if (i3 == 0 || i3 == -1) {
                this.W = false;
                if (i3 == 0 && this.J == 1) {
                    this.height = -2;
                    this.U = true;
                }
            }
            if (this.f2020c != -1.0f || this.f2016a != -1 || this.f2018b != -1) {
                this.Y = true;
                this.V = true;
                this.W = true;
                if (!(this.f2039l0 instanceof Guideline)) {
                    this.f2039l0 = new Guideline();
                }
                ((Guideline) this.f2039l0).M0(this.S);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0078  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0080  */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r7) {
            /*
                r6 = this;
                int r0 = r6.leftMargin
                int r1 = r6.rightMargin
                super.resolveLayoutDirection(r7)
                r7 = -1
                r6.f2023d0 = r7
                r6.f2025e0 = r7
                r6.f2019b0 = r7
                r6.f2021c0 = r7
                int r2 = r6.f2048t
                r6.f2027f0 = r2
                int r2 = r6.f2050v
                r6.f2029g0 = r2
                float r2 = r6.f2054z
                r6.f2031h0 = r2
                int r2 = r6.f2016a
                r6.f2033i0 = r2
                int r2 = r6.f2018b
                r6.f2035j0 = r2
                float r2 = r6.f2020c
                r6.f2037k0 = r2
                int r2 = r6.getLayoutDirection()
                r3 = 0
                r4 = 1
                if (r4 != r2) goto L_0x0032
                r2 = 1
                goto L_0x0033
            L_0x0032:
                r2 = 0
            L_0x0033:
                if (r2 == 0) goto L_0x0096
                int r2 = r6.f2044p
                if (r2 == r7) goto L_0x003d
                r6.f2023d0 = r2
            L_0x003b:
                r3 = 1
                goto L_0x0044
            L_0x003d:
                int r2 = r6.f2045q
                if (r2 == r7) goto L_0x0044
                r6.f2025e0 = r2
                goto L_0x003b
            L_0x0044:
                int r2 = r6.f2046r
                if (r2 == r7) goto L_0x004b
                r6.f2021c0 = r2
                r3 = 1
            L_0x004b:
                int r2 = r6.f2047s
                if (r2 == r7) goto L_0x0052
                r6.f2019b0 = r2
                r3 = 1
            L_0x0052:
                int r2 = r6.f2052x
                if (r2 == r7) goto L_0x0058
                r6.f2029g0 = r2
            L_0x0058:
                int r2 = r6.f2053y
                if (r2 == r7) goto L_0x005e
                r6.f2027f0 = r2
            L_0x005e:
                r2 = 1065353216(0x3f800000, float:1.0)
                if (r3 == 0) goto L_0x0068
                float r3 = r6.f2054z
                float r3 = r2 - r3
                r6.f2031h0 = r3
            L_0x0068:
                boolean r3 = r6.Y
                if (r3 == 0) goto L_0x00ba
                int r3 = r6.S
                if (r3 != r4) goto L_0x00ba
                float r3 = r6.f2020c
                r4 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r5 == 0) goto L_0x0080
                float r2 = r2 - r3
                r6.f2037k0 = r2
                r6.f2033i0 = r7
                r6.f2035j0 = r7
                goto L_0x00ba
            L_0x0080:
                int r2 = r6.f2016a
                if (r2 == r7) goto L_0x008b
                r6.f2035j0 = r2
                r6.f2033i0 = r7
                r6.f2037k0 = r4
                goto L_0x00ba
            L_0x008b:
                int r2 = r6.f2018b
                if (r2 == r7) goto L_0x00ba
                r6.f2033i0 = r2
                r6.f2035j0 = r7
                r6.f2037k0 = r4
                goto L_0x00ba
            L_0x0096:
                int r2 = r6.f2044p
                if (r2 == r7) goto L_0x009c
                r6.f2021c0 = r2
            L_0x009c:
                int r2 = r6.f2045q
                if (r2 == r7) goto L_0x00a2
                r6.f2019b0 = r2
            L_0x00a2:
                int r2 = r6.f2046r
                if (r2 == r7) goto L_0x00a8
                r6.f2023d0 = r2
            L_0x00a8:
                int r2 = r6.f2047s
                if (r2 == r7) goto L_0x00ae
                r6.f2025e0 = r2
            L_0x00ae:
                int r2 = r6.f2052x
                if (r2 == r7) goto L_0x00b4
                r6.f2027f0 = r2
            L_0x00b4:
                int r2 = r6.f2053y
                if (r2 == r7) goto L_0x00ba
                r6.f2029g0 = r2
            L_0x00ba:
                int r2 = r6.f2046r
                if (r2 != r7) goto L_0x0104
                int r2 = r6.f2047s
                if (r2 != r7) goto L_0x0104
                int r2 = r6.f2045q
                if (r2 != r7) goto L_0x0104
                int r2 = r6.f2044p
                if (r2 != r7) goto L_0x0104
                int r2 = r6.f2026f
                if (r2 == r7) goto L_0x00d9
                r6.f2023d0 = r2
                int r2 = r6.rightMargin
                if (r2 > 0) goto L_0x00e7
                if (r1 <= 0) goto L_0x00e7
                r6.rightMargin = r1
                goto L_0x00e7
            L_0x00d9:
                int r2 = r6.f2028g
                if (r2 == r7) goto L_0x00e7
                r6.f2025e0 = r2
                int r2 = r6.rightMargin
                if (r2 > 0) goto L_0x00e7
                if (r1 <= 0) goto L_0x00e7
                r6.rightMargin = r1
            L_0x00e7:
                int r1 = r6.f2022d
                if (r1 == r7) goto L_0x00f6
                r6.f2019b0 = r1
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x0104
                if (r0 <= 0) goto L_0x0104
                r6.leftMargin = r0
                goto L_0x0104
            L_0x00f6:
                int r1 = r6.f2024e
                if (r1 == r7) goto L_0x0104
                r6.f2021c0 = r1
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x0104
                if (r0 <= 0) goto L_0x0104
                r6.leftMargin = r0
            L_0x0104:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
