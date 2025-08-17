package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.protobuf.CodedOutputStream;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import t0.a;
import t0.b;

public class DefaultTimeBar extends View implements TimeBar {
    private final float A;
    private int B;
    private long C;
    private int D;
    private Rect E;
    private ValueAnimator F;
    private float G;
    private boolean H;
    private boolean I;
    private long J;
    private long K;
    private long L;
    private long M;
    private int N;
    private long[] O;
    private boolean[] P;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f27851b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f27852c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f27853d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f27854e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f27855f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f27856g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f27857h;

    /* renamed from: i  reason: collision with root package name */
    private final Paint f27858i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f27859j;

    /* renamed from: k  reason: collision with root package name */
    private final Paint f27860k;

    /* renamed from: l  reason: collision with root package name */
    private final Drawable f27861l;

    /* renamed from: m  reason: collision with root package name */
    private final int f27862m;

    /* renamed from: n  reason: collision with root package name */
    private final int f27863n;

    /* renamed from: o  reason: collision with root package name */
    private final int f27864o;

    /* renamed from: p  reason: collision with root package name */
    private final int f27865p;

    /* renamed from: q  reason: collision with root package name */
    private final int f27866q;

    /* renamed from: r  reason: collision with root package name */
    private final int f27867r;

    /* renamed from: s  reason: collision with root package name */
    private final int f27868s;

    /* renamed from: t  reason: collision with root package name */
    private final int f27869t;

    /* renamed from: u  reason: collision with root package name */
    private final int f27870u;

    /* renamed from: v  reason: collision with root package name */
    private final StringBuilder f27871v;

    /* renamed from: w  reason: collision with root package name */
    private final Formatter f27872w;

    /* renamed from: x  reason: collision with root package name */
    private final Runnable f27873x;

    /* renamed from: y  reason: collision with root package name */
    private final CopyOnWriteArraySet<TimeBar.OnScrubListener> f27874y;

    /* renamed from: z  reason: collision with root package name */
    private final Point f27875z;

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    private static int e(float f2, int i2) {
        return (int) ((((float) i2) * f2) + 0.5f);
    }

    private void f(Canvas canvas) {
        int i2;
        if (this.K > 0) {
            Rect rect = this.f27854e;
            int q2 = Util.q(rect.right, rect.left, this.f27852c.right);
            int centerY = this.f27854e.centerY();
            Drawable drawable = this.f27861l;
            if (drawable == null) {
                if (this.I || isFocused()) {
                    i2 = this.f27868s;
                } else if (isEnabled()) {
                    i2 = this.f27866q;
                } else {
                    i2 = this.f27867r;
                }
                canvas.drawCircle((float) q2, (float) centerY, (float) ((int) ((((float) i2) * this.G) / 2.0f)), this.f27860k);
                return;
            }
            int intrinsicWidth = ((int) (((float) drawable.getIntrinsicWidth()) * this.G)) / 2;
            int intrinsicHeight = ((int) (((float) this.f27861l.getIntrinsicHeight()) * this.G)) / 2;
            this.f27861l.setBounds(q2 - intrinsicWidth, centerY - intrinsicHeight, q2 + intrinsicWidth, centerY + intrinsicHeight);
            this.f27861l.draw(canvas);
        }
    }

    private void g(Canvas canvas) {
        Paint paint;
        int height = this.f27852c.height();
        int centerY = this.f27852c.centerY() - (height / 2);
        int i2 = height + centerY;
        if (this.K <= 0) {
            Rect rect = this.f27852c;
            canvas.drawRect((float) rect.left, (float) centerY, (float) rect.right, (float) i2, this.f27857h);
            return;
        }
        Rect rect2 = this.f27853d;
        int i3 = rect2.left;
        int i4 = rect2.right;
        int max = Math.max(Math.max(this.f27852c.left, i4), this.f27854e.right);
        int i5 = this.f27852c.right;
        if (max < i5) {
            canvas.drawRect((float) max, (float) centerY, (float) i5, (float) i2, this.f27857h);
        }
        int max2 = Math.max(i3, this.f27854e.right);
        if (i4 > max2) {
            canvas.drawRect((float) max2, (float) centerY, (float) i4, (float) i2, this.f27856g);
        }
        if (this.f27854e.width() > 0) {
            Rect rect3 = this.f27854e;
            canvas.drawRect((float) rect3.left, (float) centerY, (float) rect3.right, (float) i2, this.f27855f);
        }
        if (this.N != 0) {
            long[] jArr = (long[]) Assertions.e(this.O);
            boolean[] zArr = (boolean[]) Assertions.e(this.P);
            int i6 = this.f27865p / 2;
            for (int i7 = 0; i7 < this.N; i7++) {
                long r2 = Util.r(jArr[i7], 0, this.K);
                Rect rect4 = this.f27852c;
                int min = rect4.left + Math.min(rect4.width() - this.f27865p, Math.max(0, ((int) ((((long) this.f27852c.width()) * r2) / this.K)) - i6));
                if (zArr[i7]) {
                    paint = this.f27859j;
                } else {
                    paint = this.f27858i;
                }
                Canvas canvas2 = canvas;
                canvas2.drawRect((float) min, (float) centerY, (float) (min + this.f27865p), (float) i2, paint);
            }
        }
    }

    private long getPositionIncrement() {
        long j2 = this.C;
        if (j2 != -9223372036854775807L) {
            return j2;
        }
        long j3 = this.K;
        if (j3 == -9223372036854775807L) {
            return 0;
        }
        return j3 / ((long) this.B);
    }

    private String getProgressText() {
        return Util.i0(this.f27871v, this.f27872w, this.L);
    }

    private long getScrubberPosition() {
        if (this.f27852c.width() <= 0 || this.K == -9223372036854775807L) {
            return 0;
        }
        return (((long) this.f27854e.width()) * this.K) / ((long) this.f27852c.width());
    }

    private boolean j(float f2, float f3) {
        return this.f27851b.contains((int) f2, (int) f3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k() {
        w(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(ValueAnimator valueAnimator) {
        this.G = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.f27851b);
    }

    private void m(float f2) {
        Rect rect = this.f27854e;
        Rect rect2 = this.f27852c;
        rect.right = Util.q((int) f2, rect2.left, rect2.right);
    }

    private static int n(float f2, int i2) {
        return (int) (((float) i2) / f2);
    }

    private Point o(MotionEvent motionEvent) {
        this.f27875z.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.f27875z;
    }

    private boolean p(long j2) {
        long j3;
        long j4 = this.K;
        if (j4 <= 0) {
            return false;
        }
        if (this.I) {
            j3 = this.J;
        } else {
            j3 = this.L;
        }
        long j5 = j3;
        long r2 = Util.r(j5 + j2, 0, j4);
        if (r2 == j5) {
            return false;
        }
        if (!this.I) {
            v(r2);
        } else {
            z(r2);
        }
        x();
        return true;
    }

    private boolean q(Drawable drawable) {
        return Util.f28808a >= 23 && r(drawable, getLayoutDirection());
    }

    private static boolean r(Drawable drawable, int i2) {
        return Util.f28808a >= 23 && drawable.setLayoutDirection(i2);
    }

    private void s(int i2, int i3) {
        Rect rect = this.E;
        if (rect == null || rect.width() != i2 || this.E.height() != i3) {
            Rect rect2 = new Rect(0, 0, i2, i3);
            this.E = rect2;
            setSystemGestureExclusionRects(Collections.singletonList(rect2));
        }
    }

    private void v(long j2) {
        this.J = j2;
        this.I = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<TimeBar.OnScrubListener> it2 = this.f27874y.iterator();
        while (it2.hasNext()) {
            it2.next().u(this, j2);
        }
    }

    private void w(boolean z2) {
        removeCallbacks(this.f27873x);
        this.I = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<TimeBar.OnScrubListener> it2 = this.f27874y.iterator();
        while (it2.hasNext()) {
            it2.next().r(this, this.J, z2);
        }
    }

    private void x() {
        long j2;
        this.f27853d.set(this.f27852c);
        this.f27854e.set(this.f27852c);
        if (this.I) {
            j2 = this.J;
        } else {
            j2 = this.L;
        }
        if (this.K > 0) {
            int width = (int) ((((long) this.f27852c.width()) * this.M) / this.K);
            Rect rect = this.f27853d;
            Rect rect2 = this.f27852c;
            rect.right = Math.min(rect2.left + width, rect2.right);
            int width2 = (int) ((((long) this.f27852c.width()) * j2) / this.K);
            Rect rect3 = this.f27854e;
            Rect rect4 = this.f27852c;
            rect3.right = Math.min(rect4.left + width2, rect4.right);
        } else {
            Rect rect5 = this.f27853d;
            int i2 = this.f27852c.left;
            rect5.right = i2;
            this.f27854e.right = i2;
        }
        invalidate(this.f27851b);
    }

    private void y() {
        Drawable drawable = this.f27861l;
        if (drawable != null && drawable.isStateful() && this.f27861l.setState(getDrawableState())) {
            invalidate();
        }
    }

    private void z(long j2) {
        if (this.J != j2) {
            this.J = j2;
            Iterator<TimeBar.OnScrubListener> it2 = this.f27874y.iterator();
            while (it2.hasNext()) {
                it2.next().p(this, j2);
            }
        }
    }

    public void a(long[] jArr, boolean[] zArr, int i2) {
        boolean z2;
        if (i2 == 0 || !(jArr == null || zArr == null)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.N = i2;
        this.O = jArr;
        this.P = zArr;
        x();
    }

    public void b(TimeBar.OnScrubListener onScrubListener) {
        Assertions.e(onScrubListener);
        this.f27874y.add(onScrubListener);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        y();
    }

    public long getPreferredUpdateDelay() {
        int n2 = n(this.A, this.f27852c.width());
        if (n2 != 0) {
            long j2 = this.K;
            if (!(j2 == 0 || j2 == -9223372036854775807L)) {
                return j2 / ((long) n2);
            }
        }
        return Clock.MAX_TIME;
    }

    public void h(long j2) {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.F.setFloatValues(new float[]{this.G, 0.0f});
        this.F.setDuration(j2);
        this.F.start();
    }

    public void i(boolean z2) {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.H = z2;
        this.G = 0.0f;
        invalidate(this.f27851b);
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f27861l;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        g(canvas);
        f(canvas);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        if (this.I && !z2) {
            w(false);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.K > 0) {
            if (Util.f28808a >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
                return;
            }
            accessibilityNodeInfo.addAction(CodedOutputStream.DEFAULT_BUFFER_SIZE);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (p(r0) == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        removeCallbacks(r4.f27873x);
        postDelayed(r4.f27873x, 1000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L_0x0030
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L_0x0027
            switch(r5) {
                case 21: goto L_0x0013;
                case 22: goto L_0x0014;
                case 23: goto L_0x0027;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0030
        L_0x0013:
            long r0 = -r0
        L_0x0014:
            boolean r0 = r4.p(r0)
            if (r0 == 0) goto L_0x0030
            java.lang.Runnable r5 = r4.f27873x
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.f27873x
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L_0x0027:
            boolean r0 = r4.I
            if (r0 == 0) goto L_0x0030
            r5 = 0
            r4.w(r5)
            return r3
        L_0x0030:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9 = i4 - i2;
        int i10 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i9 - getPaddingRight();
        if (this.H) {
            i6 = 0;
        } else {
            i6 = this.f27869t;
        }
        if (this.f27864o == 1) {
            i8 = (i10 - getPaddingBottom()) - this.f27863n;
            int i11 = this.f27862m;
            i7 = ((i10 - getPaddingBottom()) - i11) - Math.max(i6 - (i11 / 2), 0);
        } else {
            i8 = (i10 - this.f27863n) / 2;
            i7 = (i10 - this.f27862m) / 2;
        }
        this.f27851b.set(paddingLeft, i8, paddingRight, this.f27863n + i8);
        Rect rect = this.f27852c;
        Rect rect2 = this.f27851b;
        rect.set(rect2.left + i6, i7, rect2.right - i6, this.f27862m + i7);
        if (Util.f28808a >= 29) {
            s(i9, i10);
        }
        x();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 0) {
            size = this.f27863n;
        } else if (mode != 1073741824) {
            size = Math.min(this.f27863n, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i2), size);
        y();
    }

    public void onRtlPropertiesChanged(int i2) {
        Drawable drawable = this.f27861l;
        if (drawable != null && r(drawable, i2)) {
            invalidate();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if (r3 != 3) goto L_0x0076;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x0076
            long r2 = r7.K
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0010
            goto L_0x0076
        L_0x0010:
            android.graphics.Point r0 = r7.o(r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L_0x005d
            r5 = 3
            if (r3 == r4) goto L_0x004e
            r6 = 2
            if (r3 == r6) goto L_0x0028
            if (r3 == r5) goto L_0x004e
            goto L_0x0076
        L_0x0028:
            boolean r8 = r7.I
            if (r8 == 0) goto L_0x0076
            int r8 = r7.f27870u
            if (r0 >= r8) goto L_0x003a
            int r8 = r7.D
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
            r7.m(r8)
            goto L_0x0040
        L_0x003a:
            r7.D = r2
            float r8 = (float) r2
            r7.m(r8)
        L_0x0040:
            long r0 = r7.getScrubberPosition()
            r7.z(r0)
            r7.x()
            r7.invalidate()
            return r4
        L_0x004e:
            boolean r0 = r7.I
            if (r0 == 0) goto L_0x0076
            int r8 = r8.getAction()
            if (r8 != r5) goto L_0x0059
            r1 = 1
        L_0x0059:
            r7.w(r1)
            return r4
        L_0x005d:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.j(r8, r0)
            if (r0 == 0) goto L_0x0076
            r7.m(r8)
            long r0 = r7.getScrubberPosition()
            r7.v(r0)
            r7.x()
            r7.invalidate()
            return r4
        L_0x0076:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        if (super.performAccessibilityAction(i2, bundle)) {
            return true;
        }
        if (this.K <= 0) {
            return false;
        }
        if (i2 == 8192) {
            if (p(-getPositionIncrement())) {
                w(false);
            }
        } else if (i2 != 4096) {
            return false;
        } else {
            if (p(getPositionIncrement())) {
                w(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public void setAdMarkerColor(int i2) {
        this.f27858i.setColor(i2);
        invalidate(this.f27851b);
    }

    public void setBufferedColor(int i2) {
        this.f27856g.setColor(i2);
        invalidate(this.f27851b);
    }

    public void setBufferedPosition(long j2) {
        if (this.M != j2) {
            this.M = j2;
            x();
        }
    }

    public void setDuration(long j2) {
        if (this.K != j2) {
            this.K = j2;
            if (this.I && j2 == -9223372036854775807L) {
                w(true);
            }
            x();
        }
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (this.I && !z2) {
            w(true);
        }
    }

    public void setKeyCountIncrement(int i2) {
        boolean z2;
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.B = i2;
        this.C = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j2) {
        boolean z2;
        if (j2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.B = -1;
        this.C = j2;
    }

    public void setPlayedAdMarkerColor(int i2) {
        this.f27859j.setColor(i2);
        invalidate(this.f27851b);
    }

    public void setPlayedColor(int i2) {
        this.f27855f.setColor(i2);
        invalidate(this.f27851b);
    }

    public void setPosition(long j2) {
        if (this.L != j2) {
            this.L = j2;
            setContentDescription(getProgressText());
            x();
        }
    }

    public void setScrubberColor(int i2) {
        this.f27860k.setColor(i2);
        invalidate(this.f27851b);
    }

    public void setUnplayedColor(int i2) {
        this.f27857h.setColor(i2);
        invalidate(this.f27851b);
    }

    public void t() {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.H = false;
        this.G = 1.0f;
        invalidate(this.f27851b);
    }

    public void u(long j2) {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.H = false;
        this.F.setFloatValues(new float[]{this.G, 1.0f});
        this.F.setDuration(j2);
        this.F.start();
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2) {
        this(context, attributeSet, i2, attributeSet2, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet, i2);
        AttributeSet attributeSet3 = attributeSet2;
        this.f27851b = new Rect();
        this.f27852c = new Rect();
        this.f27853d = new Rect();
        this.f27854e = new Rect();
        Paint paint = new Paint();
        this.f27855f = paint;
        Paint paint2 = new Paint();
        this.f27856g = paint2;
        Paint paint3 = new Paint();
        this.f27857h = paint3;
        Paint paint4 = new Paint();
        this.f27858i = paint4;
        Paint paint5 = new Paint();
        this.f27859j = paint5;
        Paint paint6 = new Paint();
        this.f27860k = paint6;
        paint6.setAntiAlias(true);
        this.f27874y = new CopyOnWriteArraySet<>();
        this.f27875z = new Point();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.A = f2;
        this.f27870u = e(f2, -50);
        int e2 = e(f2, 4);
        int e3 = e(f2, 26);
        int e4 = e(f2, 4);
        int e5 = e(f2, 12);
        int e6 = e(f2, 0);
        int e7 = e(f2, 16);
        if (attributeSet3 != null) {
            Paint paint7 = paint4;
            Paint paint8 = paint5;
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet3, R$styleable.f28036e, i2, i3);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.f28058p);
                this.f27861l = drawable;
                if (drawable != null) {
                    q(drawable);
                    e3 = Math.max(drawable.getMinimumHeight(), e3);
                }
                this.f27862m = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f28044i, e2);
                this.f27863n = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f28062r, e3);
                this.f27864o = obtainStyledAttributes.getInt(R$styleable.f28042h, 0);
                this.f27865p = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f28040g, e4);
                this.f27866q = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f28060q, e5);
                this.f27867r = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f28054n, e6);
                this.f27868s = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f28056o, e7);
                int i4 = obtainStyledAttributes.getInt(R$styleable.f28050l, -1);
                int i5 = obtainStyledAttributes.getInt(R$styleable.f28052m, -1);
                int i6 = obtainStyledAttributes.getInt(R$styleable.f28046j, -855638017);
                int i7 = obtainStyledAttributes.getInt(R$styleable.f28064s, 872415231);
                int i8 = obtainStyledAttributes.getInt(R$styleable.f28038f, -1291845888);
                int i9 = obtainStyledAttributes.getInt(R$styleable.f28048k, 872414976);
                paint.setColor(i4);
                paint6.setColor(i5);
                paint2.setColor(i6);
                paint3.setColor(i7);
                paint7.setColor(i8);
                paint8.setColor(i9);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.f27862m = e2;
            this.f27863n = e3;
            this.f27864o = 0;
            this.f27865p = e4;
            this.f27866q = e5;
            this.f27867r = e6;
            this.f27868s = e7;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.f27861l = null;
        }
        StringBuilder sb = new StringBuilder();
        this.f27871v = sb;
        this.f27872w = new Formatter(sb, Locale.getDefault());
        this.f27873x = new a(this);
        Drawable drawable2 = this.f27861l;
        if (drawable2 != null) {
            this.f27869t = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.f27869t = (Math.max(this.f27867r, Math.max(this.f27866q, this.f27868s)) + 1) / 2;
        }
        this.G = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.F = valueAnimator;
        valueAnimator.addUpdateListener(new b(this));
        this.K = -9223372036854775807L;
        this.C = -9223372036854775807L;
        this.B = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
