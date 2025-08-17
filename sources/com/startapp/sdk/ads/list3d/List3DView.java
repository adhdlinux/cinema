package com.startapp.sdk.ads.list3d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.startapp.d4;
import com.startapp.g4;
import com.startapp.h4;
import com.startapp.hc;
import java.util.LinkedList;

public class List3DView extends AdapterView<Adapter> {

    /* renamed from: a  reason: collision with root package name */
    public Adapter f35972a;

    /* renamed from: b  reason: collision with root package name */
    public int f35973b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f35974c;

    /* renamed from: d  reason: collision with root package name */
    public int f35975d;

    /* renamed from: e  reason: collision with root package name */
    public int f35976e;

    /* renamed from: f  reason: collision with root package name */
    public int f35977f;

    /* renamed from: g  reason: collision with root package name */
    public int f35978g;

    /* renamed from: h  reason: collision with root package name */
    public int f35979h;

    /* renamed from: i  reason: collision with root package name */
    public int f35980i;

    /* renamed from: j  reason: collision with root package name */
    public int f35981j;

    /* renamed from: k  reason: collision with root package name */
    public VelocityTracker f35982k;

    /* renamed from: l  reason: collision with root package name */
    public d4 f35983l;

    /* renamed from: m  reason: collision with root package name */
    public Runnable f35984m;

    /* renamed from: n  reason: collision with root package name */
    public final LinkedList<View> f35985n = new LinkedList<>();

    /* renamed from: o  reason: collision with root package name */
    public Runnable f35986o;

    /* renamed from: p  reason: collision with root package name */
    public Rect f35987p;

    /* renamed from: q  reason: collision with root package name */
    public Camera f35988q;

    /* renamed from: r  reason: collision with root package name */
    public Matrix f35989r;

    /* renamed from: s  reason: collision with root package name */
    public Paint f35990s;

    /* renamed from: t  reason: collision with root package name */
    public int f35991t = Integer.MIN_VALUE;

    /* renamed from: u  reason: collision with root package name */
    public boolean f35992u = false;

    /* renamed from: v  reason: collision with root package name */
    public boolean f35993v = false;

    /* renamed from: w  reason: collision with root package name */
    public boolean f35994w = false;

    /* renamed from: x  reason: collision with root package name */
    public boolean f35995x = false;

    public List3DView(Context context, AttributeSet attributeSet, String str, String str2) {
        super(context, (AttributeSet) null);
    }

    public final boolean a() {
        int i2 = hc.f34643a;
        return true;
    }

    public int b(int i2, int i3) {
        if (this.f35987p == null) {
            this.f35987p = new Rect();
        }
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            getChildAt(i4).getHitRect(this.f35987p);
            if (this.f35987p.contains(i2, i3)) {
                return i4;
            }
        }
        return -1;
    }

    public final int c(View view) {
        return (int) ((((float) view.getMeasuredHeight()) * 0.35000002f) / 2.0f);
    }

    public int d(View view) {
        return view.getTop() - c(view);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return super.drawChild(canvas, view, j2);
        }
        int top = view.getTop();
        int left = view.getLeft();
        int width = view.getWidth() / 2;
        int height = view.getHeight() / 2;
        float height2 = (float) (getHeight() / 2);
        float f2 = (((float) (top + height)) - height2) / height2;
        float cos = (float) (1.0d - ((1.0d - Math.cos((double) f2)) * 0.15000000596046448d));
        float f3 = (((float) this.f35979h) - (f2 * 20.0f)) % 90.0f;
        if (f3 < 0.0f) {
            f3 += 90.0f;
        }
        float f4 = f3;
        if (f4 < 45.0f) {
            Canvas canvas2 = canvas;
            Bitmap bitmap = drawingCache;
            int i2 = top;
            int i3 = left;
            int i4 = width;
            int i5 = height;
            float f5 = cos;
            a(canvas2, bitmap, i2, i3, i4, i5, f5, f4 - 90.0f);
            a(canvas2, bitmap, i2, i3, i4, i5, f5, f4);
            return false;
        }
        Canvas canvas3 = canvas;
        Bitmap bitmap2 = drawingCache;
        int i6 = top;
        int i7 = left;
        int i8 = width;
        int i9 = height;
        float f6 = cos;
        a(canvas3, bitmap2, i6, i7, i8, i9, f6, f4);
        a(canvas3, bitmap2, i6, i7, i8, i9, f6, f4 - 90.0f);
        return false;
    }

    public Adapter getAdapter() {
        return this.f35972a;
    }

    public View getSelectedView() {
        return null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f35984m);
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        View view;
        super.onLayout(z2, i2, i3, i4, i5);
        if (this.f35992u && this.f35972a != null) {
            if (getChildCount() == 0) {
                if (this.f35994w) {
                    this.f35977f = getHeight() / 3;
                }
                this.f35981j = -1;
                a(this.f35977f, 0);
            } else {
                int d2 = (this.f35977f + this.f35978g) - d(getChildAt(0));
                int childCount = getChildCount();
                if (this.f35981j != this.f35972a.getCount() - 1 && childCount > 1) {
                    View childAt = getChildAt(0);
                    while (childAt != null && a(childAt) + d2 < 0) {
                        removeViewInLayout(childAt);
                        childCount--;
                        this.f35985n.addLast(childAt);
                        this.f35980i++;
                        this.f35978g += b(childAt);
                        if (childCount > 1) {
                            childAt = getChildAt(0);
                        } else {
                            childAt = null;
                        }
                    }
                }
                if (this.f35980i != 0 && childCount > 1) {
                    View childAt2 = getChildAt(childCount - 1);
                    while (childAt2 != null && d(childAt2) + d2 > getHeight()) {
                        removeViewInLayout(childAt2);
                        childCount--;
                        this.f35985n.addLast(childAt2);
                        this.f35981j--;
                        if (childCount > 1) {
                            childAt2 = getChildAt(childCount - 1);
                        } else {
                            childAt2 = null;
                        }
                    }
                }
                a(a(getChildAt(getChildCount() - 1)), d2);
                int d3 = d(getChildAt(0));
                while (d3 + d2 > 0 && (i6 = this.f35980i) > 0) {
                    int i7 = i6 - 1;
                    this.f35980i = i7;
                    Adapter adapter = this.f35972a;
                    if (this.f35985n.size() != 0) {
                        view = this.f35985n.removeFirst();
                    } else {
                        view = null;
                    }
                    View view2 = adapter.getView(i7, view, this);
                    a(view2, 1);
                    int b2 = b(view2);
                    d3 -= b2;
                    this.f35978g -= b2;
                }
            }
            int i8 = this.f35977f + this.f35978g;
            float width = ((float) getWidth()) * 0.0f;
            float height = 1.0f / (((float) getHeight()) * 0.9f);
            for (int i9 = 0; i9 < getChildCount(); i9++) {
                View childAt3 = getChildAt(i9);
                int measuredWidth = childAt3.getMeasuredWidth();
                int measuredHeight = childAt3.getMeasuredHeight();
                int sin = ((int) (((double) width) * Math.sin(((double) height) * 6.283185307179586d * ((double) i8)))) + ((getWidth() - measuredWidth) / 2);
                int c2 = c(childAt3);
                int i10 = i8 + c2;
                childAt3.layout(sin, i10, measuredWidth + sin, i10 + measuredHeight);
                i8 += measuredHeight + (c2 * 2);
            }
            if (this.f35994w && !this.f35995x) {
                this.f35995x = true;
                dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 0, 0.0f, 0.0f, 0));
                postDelayed(new g4(this), 5);
            }
            invalidate();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        if (r1 <= (r0 + 10)) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r6.getChildCount()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            int r0 = r7.getAction()
            r2 = 1
            if (r0 == 0) goto L_0x0097
            r1 = 0
            r3 = 2
            if (r0 == r2) goto L_0x0059
            if (r0 == r3) goto L_0x001a
            r6.a((float) r1)
            goto L_0x00f3
        L_0x001a:
            int r0 = r6.f35973b
            if (r0 != r2) goto L_0x0043
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            int r4 = r6.f35974c
            int r5 = r4 + -10
            if (r0 < r5) goto L_0x003c
            int r4 = r4 + 10
            if (r0 > r4) goto L_0x003c
            int r0 = r6.f35975d
            int r4 = r0 + -10
            if (r1 < r4) goto L_0x003c
            int r0 = r0 + 10
            if (r1 <= r0) goto L_0x0043
        L_0x003c:
            java.lang.Runnable r0 = r6.f35986o
            r6.removeCallbacks(r0)
            r6.f35973b = r3
        L_0x0043:
            int r0 = r6.f35973b
            if (r0 != r3) goto L_0x00f3
            android.view.VelocityTracker r0 = r6.f35982k
            r0.addMovement(r7)
            float r7 = r7.getY()
            int r7 = (int) r7
            int r0 = r6.f35975d
            int r7 = r7 - r0
            r6.a((int) r7)
            goto L_0x00f3
        L_0x0059:
            int r0 = r6.f35973b
            if (r0 != r2) goto L_0x007f
            float r0 = r7.getX()
            int r0 = (int) r0
            float r7 = r7.getY()
            int r7 = (int) r7
            int r7 = r6.b(r0, r7)
            r0 = -1
            if (r7 == r0) goto L_0x0093
            android.view.View r0 = r6.getChildAt(r7)
            int r3 = r6.f35980i
            int r3 = r3 + r7
            android.widget.Adapter r7 = r6.f35972a
            long r4 = r7.getItemId(r3)
            r6.performItemClick(r0, r3, r4)
            goto L_0x0093
        L_0x007f:
            if (r0 != r3) goto L_0x0093
            android.view.VelocityTracker r0 = r6.f35982k
            r0.addMovement(r7)
            android.view.VelocityTracker r7 = r6.f35982k
            r0 = 1000(0x3e8, float:1.401E-42)
            r7.computeCurrentVelocity(r0)
            android.view.VelocityTracker r7 = r6.f35982k
            float r1 = r7.getYVelocity()
        L_0x0093:
            r6.a((float) r1)
            goto L_0x00f3
        L_0x0097:
            boolean r0 = r6.a()
            if (r0 == 0) goto L_0x00b3
            int r0 = com.startapp.hc.f34643a
            android.view.ViewPropertyAnimator r0 = r6.animate()
            r3 = 1065353216(0x3f800000, float:1.0)
            android.view.ViewPropertyAnimator r0 = r0.alpha(r3)
            r3 = 1500(0x5dc, double:7.41E-321)
            android.view.ViewPropertyAnimator r0 = r0.setDuration(r3)
            r3 = 0
            r0.setListener(r3)
        L_0x00b3:
            java.lang.Runnable r0 = r6.f35984m
            r6.removeCallbacks(r0)
            float r0 = r7.getX()
            int r0 = (int) r0
            r6.f35974c = r0
            float r0 = r7.getY()
            int r0 = (int) r0
            r6.f35975d = r0
            android.view.View r0 = r6.getChildAt(r1)
            int r0 = r6.d(r0)
            int r1 = r6.f35978g
            int r0 = r0 - r1
            r6.f35976e = r0
            java.lang.Runnable r0 = r6.f35986o
            if (r0 != 0) goto L_0x00de
            com.startapp.i4 r0 = new com.startapp.i4
            r0.<init>(r6)
            r6.f35986o = r0
        L_0x00de:
            java.lang.Runnable r0 = r6.f35986o
            int r1 = android.view.ViewConfiguration.getLongPressTimeout()
            long r3 = (long) r1
            r6.postDelayed(r0, r3)
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.f35982k = r0
            r0.addMovement(r7)
            r6.f35973b = r2
        L_0x00f3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.list3d.List3DView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAdapter(Adapter adapter) {
        if (a() && this.f35993v) {
            int i2 = hc.f34643a;
            setAlpha(0.0f);
        }
        this.f35972a = adapter;
        removeAllViewsInLayout();
        requestLayout();
    }

    public void setDynamics(d4 d4Var) {
        d4 d4Var2 = this.f35983l;
        if (d4Var2 != null) {
            float f2 = d4Var2.f34337a;
            float f3 = d4Var2.f34338b;
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            d4Var.f34338b = f3;
            d4Var.f34337a = f2;
            d4Var.f34341e = currentAnimationTimeMillis;
        }
        this.f35983l = d4Var;
    }

    public void setFade(boolean z2) {
        this.f35993v = z2;
    }

    public void setHint(boolean z2) {
        this.f35994w = z2;
    }

    public void setSelection(int i2) {
        throw new UnsupportedOperationException("Not supported");
    }

    public void setStarted() {
        this.f35992u = true;
    }

    public void setTag(String str) {
    }

    public final void a(Canvas canvas, Bitmap bitmap, int i2, int i3, int i4, int i5, float f2, float f3) {
        if (this.f35988q == null) {
            this.f35988q = new Camera();
        }
        this.f35988q.save();
        this.f35988q.translate(0.0f, 0.0f, (float) i5);
        this.f35988q.rotateX(f3);
        float f4 = (float) (-i5);
        this.f35988q.translate(0.0f, 0.0f, f4);
        if (this.f35989r == null) {
            this.f35989r = new Matrix();
        }
        this.f35988q.getMatrix(this.f35989r);
        this.f35988q.restore();
        this.f35989r.preTranslate((float) (-i4), f4);
        this.f35989r.postScale(f2, f2);
        this.f35989r.postTranslate((float) (i3 + i4), (float) (i2 + i5));
        if (this.f35990s == null) {
            Paint paint = new Paint();
            this.f35990s = paint;
            paint.setAntiAlias(true);
            this.f35990s.setFilterBitmap(true);
        }
        Paint paint2 = this.f35990s;
        double cos = Math.cos((((double) f3) * 3.141592653589793d) / 180.0d);
        int i6 = ((int) (cos * 200.0d)) + 55;
        int pow = (int) (Math.pow(cos, 200.0d) * 70.0d);
        if (i6 > 255) {
            i6 = JfifUtil.MARKER_FIRST_BYTE;
        }
        if (pow > 255) {
            pow = JfifUtil.MARKER_FIRST_BYTE;
        }
        paint2.setColorFilter(new LightingColorFilter(Color.rgb(i6, i6, i6), Color.rgb(pow, pow, pow)));
        canvas.drawBitmap(bitmap, this.f35989r, this.f35990s);
    }

    public final int b(View view) {
        return view.getMeasuredHeight() + (c(view) * 2);
    }

    public final void a(float f2) {
        VelocityTracker velocityTracker = this.f35982k;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f35982k = null;
            removeCallbacks(this.f35986o);
            if (this.f35984m == null) {
                this.f35984m = new h4(this);
            }
            d4 d4Var = this.f35983l;
            if (d4Var != null) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                d4Var.f34338b = f2;
                d4Var.f34337a = (float) this.f35977f;
                d4Var.f34341e = currentAnimationTimeMillis;
                post(this.f35984m);
            }
            this.f35973b = 0;
        }
    }

    public void a(int i2) {
        int i3;
        int i4 = this.f35976e + i2;
        this.f35977f = i4;
        int height = (-(i4 * RotationOptions.ROTATE_270)) / getHeight();
        this.f35979h = height;
        int i5 = height % 90;
        if (i5 < 45) {
            i3 = ((-(height - i5)) * getHeight()) / RotationOptions.ROTATE_270;
        } else {
            i3 = ((-((height + 90) - i5)) * getHeight()) / RotationOptions.ROTATE_270;
        }
        if (this.f35991t == Integer.MIN_VALUE && this.f35981j == this.f35972a.getCount() - 1 && a(getChildAt(getChildCount() - 1)) < getHeight()) {
            this.f35991t = i3;
        }
        if (i3 > 0) {
            i3 = 0;
        } else {
            int i6 = this.f35991t;
            if (i3 < i6) {
                i3 = i6;
            }
        }
        d4 d4Var = this.f35983l;
        float f2 = (float) i3;
        d4Var.f34339c = f2;
        d4Var.f34340d = f2;
        requestLayout();
    }

    public final void a(int i2, int i3) {
        while (i2 + i3 < getHeight() && this.f35981j < this.f35972a.getCount() - 1) {
            int i4 = this.f35981j + 1;
            this.f35981j = i4;
            View view = this.f35972a.getView(i4, this.f35985n.size() != 0 ? this.f35985n.removeFirst() : null, this);
            a(view, 0);
            i2 += b(view);
        }
    }

    public final void a(View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i3 = i2 == 1 ? 0 : -1;
        view.setDrawingCacheEnabled(true);
        addViewInLayout(view, i3, layoutParams, true);
        view.measure(((int) (((float) getWidth()) * 0.85f)) | 1073741824, 0);
    }

    public final int a(View view) {
        return view.getBottom() + c(view);
    }
}
