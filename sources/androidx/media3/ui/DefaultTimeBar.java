package androidx.media3.ui;

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
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.ui.TimeBar;
import com.facebook.common.time.Clock;
import com.google.protobuf.CodedOutputStream;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import p.a;
import p.b;

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
    private final Rect f9773b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f9774c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f9775d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f9776e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f9777f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f9778g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f9779h;

    /* renamed from: i  reason: collision with root package name */
    private final Paint f9780i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f9781j;

    /* renamed from: k  reason: collision with root package name */
    private final Paint f9782k;

    /* renamed from: l  reason: collision with root package name */
    private final Drawable f9783l;

    /* renamed from: m  reason: collision with root package name */
    private final int f9784m;

    /* renamed from: n  reason: collision with root package name */
    private final int f9785n;

    /* renamed from: o  reason: collision with root package name */
    private final int f9786o;

    /* renamed from: p  reason: collision with root package name */
    private final int f9787p;

    /* renamed from: q  reason: collision with root package name */
    private final int f9788q;

    /* renamed from: r  reason: collision with root package name */
    private final int f9789r;

    /* renamed from: s  reason: collision with root package name */
    private final int f9790s;

    /* renamed from: t  reason: collision with root package name */
    private final int f9791t;

    /* renamed from: u  reason: collision with root package name */
    private final int f9792u;

    /* renamed from: v  reason: collision with root package name */
    private final StringBuilder f9793v;

    /* renamed from: w  reason: collision with root package name */
    private final Formatter f9794w;

    /* renamed from: x  reason: collision with root package name */
    private final Runnable f9795x;

    /* renamed from: y  reason: collision with root package name */
    private final CopyOnWriteArraySet<TimeBar.OnScrubListener> f9796y;

    /* renamed from: z  reason: collision with root package name */
    private final Point f9797z;

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private static int e(float f2, int i2) {
        return (int) ((((float) i2) * f2) + 0.5f);
    }

    private void f(Canvas canvas) {
        int i2;
        if (this.K > 0) {
            Rect rect = this.f9776e;
            int p2 = Util.p(rect.right, rect.left, this.f9774c.right);
            int centerY = this.f9776e.centerY();
            Drawable drawable = this.f9783l;
            if (drawable == null) {
                if (this.I || isFocused()) {
                    i2 = this.f9790s;
                } else if (isEnabled()) {
                    i2 = this.f9788q;
                } else {
                    i2 = this.f9789r;
                }
                canvas.drawCircle((float) p2, (float) centerY, (float) ((int) ((((float) i2) * this.G) / 2.0f)), this.f9782k);
                return;
            }
            int intrinsicWidth = ((int) (((float) drawable.getIntrinsicWidth()) * this.G)) / 2;
            int intrinsicHeight = ((int) (((float) this.f9783l.getIntrinsicHeight()) * this.G)) / 2;
            this.f9783l.setBounds(p2 - intrinsicWidth, centerY - intrinsicHeight, p2 + intrinsicWidth, centerY + intrinsicHeight);
            this.f9783l.draw(canvas);
        }
    }

    private void g(Canvas canvas) {
        Paint paint;
        int height = this.f9774c.height();
        int centerY = this.f9774c.centerY() - (height / 2);
        int i2 = height + centerY;
        if (this.K <= 0) {
            Rect rect = this.f9774c;
            canvas.drawRect((float) rect.left, (float) centerY, (float) rect.right, (float) i2, this.f9779h);
            return;
        }
        Rect rect2 = this.f9775d;
        int i3 = rect2.left;
        int i4 = rect2.right;
        int max = Math.max(Math.max(this.f9774c.left, i4), this.f9776e.right);
        int i5 = this.f9774c.right;
        if (max < i5) {
            canvas.drawRect((float) max, (float) centerY, (float) i5, (float) i2, this.f9779h);
        }
        int max2 = Math.max(i3, this.f9776e.right);
        if (i4 > max2) {
            canvas.drawRect((float) max2, (float) centerY, (float) i4, (float) i2, this.f9778g);
        }
        if (this.f9776e.width() > 0) {
            Rect rect3 = this.f9776e;
            canvas.drawRect((float) rect3.left, (float) centerY, (float) rect3.right, (float) i2, this.f9777f);
        }
        if (this.N != 0) {
            long[] jArr = (long[]) Assertions.f(this.O);
            boolean[] zArr = (boolean[]) Assertions.f(this.P);
            int i6 = this.f9787p / 2;
            for (int i7 = 0; i7 < this.N; i7++) {
                long q2 = Util.q(jArr[i7], 0, this.K);
                Rect rect4 = this.f9774c;
                int min = rect4.left + Math.min(rect4.width() - this.f9787p, Math.max(0, ((int) ((((long) this.f9774c.width()) * q2) / this.K)) - i6));
                if (zArr[i7]) {
                    paint = this.f9781j;
                } else {
                    paint = this.f9780i;
                }
                Canvas canvas2 = canvas;
                canvas2.drawRect((float) min, (float) centerY, (float) (min + this.f9787p), (float) i2, paint);
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
        return Util.n0(this.f9793v, this.f9794w, this.L);
    }

    private long getScrubberPosition() {
        if (this.f9774c.width() <= 0 || this.K == -9223372036854775807L) {
            return 0;
        }
        return (((long) this.f9776e.width()) * this.K) / ((long) this.f9774c.width());
    }

    private boolean j(float f2, float f3) {
        return this.f9773b.contains((int) f2, (int) f3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k() {
        w(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(ValueAnimator valueAnimator) {
        this.G = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.f9773b);
    }

    private void m(float f2) {
        Rect rect = this.f9776e;
        Rect rect2 = this.f9774c;
        rect.right = Util.p((int) f2, rect2.left, rect2.right);
    }

    private static int n(float f2, int i2) {
        return (int) (((float) i2) / f2);
    }

    private Point o(MotionEvent motionEvent) {
        this.f9797z.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.f9797z;
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
        long q2 = Util.q(j5 + j2, 0, j4);
        if (q2 == j5) {
            return false;
        }
        if (!this.I) {
            v(q2);
        } else {
            z(q2);
        }
        x();
        return true;
    }

    private boolean q(Drawable drawable) {
        return Util.f4714a >= 23 && r(drawable, getLayoutDirection());
    }

    private static boolean r(Drawable drawable, int i2) {
        return Util.f4714a >= 23 && drawable.setLayoutDirection(i2);
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
        Iterator<TimeBar.OnScrubListener> it2 = this.f9796y.iterator();
        while (it2.hasNext()) {
            it2.next().p(this, j2);
        }
    }

    private void w(boolean z2) {
        removeCallbacks(this.f9795x);
        this.I = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<TimeBar.OnScrubListener> it2 = this.f9796y.iterator();
        while (it2.hasNext()) {
            it2.next().v(this, this.J, z2);
        }
    }

    private void x() {
        long j2;
        this.f9775d.set(this.f9774c);
        this.f9776e.set(this.f9774c);
        if (this.I) {
            j2 = this.J;
        } else {
            j2 = this.L;
        }
        if (this.K > 0) {
            int width = (int) ((((long) this.f9774c.width()) * this.M) / this.K);
            Rect rect = this.f9775d;
            Rect rect2 = this.f9774c;
            rect.right = Math.min(rect2.left + width, rect2.right);
            int width2 = (int) ((((long) this.f9774c.width()) * j2) / this.K);
            Rect rect3 = this.f9776e;
            Rect rect4 = this.f9774c;
            rect3.right = Math.min(rect4.left + width2, rect4.right);
        } else {
            Rect rect5 = this.f9775d;
            int i2 = this.f9774c.left;
            rect5.right = i2;
            this.f9776e.right = i2;
        }
        invalidate(this.f9773b);
    }

    private void y() {
        Drawable drawable = this.f9783l;
        if (drawable != null && drawable.isStateful() && this.f9783l.setState(getDrawableState())) {
            invalidate();
        }
    }

    private void z(long j2) {
        if (this.J != j2) {
            this.J = j2;
            Iterator<TimeBar.OnScrubListener> it2 = this.f9796y.iterator();
            while (it2.hasNext()) {
                it2.next().u(this, j2);
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
        Assertions.f(onScrubListener);
        this.f9796y.add(onScrubListener);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        y();
    }

    public long getPreferredUpdateDelay() {
        int n2 = n(this.A, this.f9774c.width());
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
        invalidate(this.f9773b);
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f9783l;
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
            if (Util.f4714a >= 21) {
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
        removeCallbacks(r4.f9795x);
        postDelayed(r4.f9795x, 1000);
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
            java.lang.Runnable r5 = r4.f9795x
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.f9795x
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
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
            i6 = this.f9791t;
        }
        if (this.f9786o == 1) {
            i8 = (i10 - getPaddingBottom()) - this.f9785n;
            int i11 = this.f9784m;
            i7 = ((i10 - getPaddingBottom()) - i11) - Math.max(i6 - (i11 / 2), 0);
        } else {
            i8 = (i10 - this.f9785n) / 2;
            i7 = (i10 - this.f9784m) / 2;
        }
        this.f9773b.set(paddingLeft, i8, paddingRight, this.f9785n + i8);
        Rect rect = this.f9774c;
        Rect rect2 = this.f9773b;
        rect.set(rect2.left + i6, i7, rect2.right - i6, this.f9784m + i7);
        if (Util.f4714a >= 29) {
            s(i9, i10);
        }
        x();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 0) {
            size = this.f9785n;
        } else if (mode != 1073741824) {
            size = Math.min(this.f9785n, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i2), size);
        y();
    }

    public void onRtlPropertiesChanged(int i2) {
        Drawable drawable = this.f9783l;
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
            int r8 = r7.f9792u
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
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
        this.f9780i.setColor(i2);
        invalidate(this.f9773b);
    }

    public void setBufferedColor(int i2) {
        this.f9778g.setColor(i2);
        invalidate(this.f9773b);
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
        this.f9781j.setColor(i2);
        invalidate(this.f9773b);
    }

    public void setPlayedColor(int i2) {
        this.f9777f.setColor(i2);
        invalidate(this.f9773b);
    }

    public void setPosition(long j2) {
        if (this.L != j2) {
            this.L = j2;
            setContentDescription(getProgressText());
            x();
        }
    }

    public void setScrubberColor(int i2) {
        this.f9782k.setColor(i2);
        invalidate(this.f9773b);
    }

    public void setUnplayedColor(int i2) {
        this.f9779h.setColor(i2);
        invalidate(this.f9773b);
    }

    public void t() {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.H = false;
        this.G = 1.0f;
        invalidate(this.f9773b);
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

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2) {
        this(context, attributeSet, i2, attributeSet2, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet, i2);
        AttributeSet attributeSet3 = attributeSet2;
        this.f9773b = new Rect();
        this.f9774c = new Rect();
        this.f9775d = new Rect();
        this.f9776e = new Rect();
        Paint paint = new Paint();
        this.f9777f = paint;
        Paint paint2 = new Paint();
        this.f9778g = paint2;
        Paint paint3 = new Paint();
        this.f9779h = paint3;
        Paint paint4 = new Paint();
        this.f9780i = paint4;
        Paint paint5 = new Paint();
        this.f9781j = paint5;
        Paint paint6 = new Paint();
        this.f9782k = paint6;
        paint6.setAntiAlias(true);
        this.f9796y = new CopyOnWriteArraySet<>();
        this.f9797z = new Point();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.A = f2;
        this.f9792u = e(f2, -50);
        int e2 = e(f2, 4);
        int e3 = e(f2, 26);
        int e4 = e(f2, 4);
        int e5 = e(f2, 12);
        int e6 = e(f2, 0);
        int e7 = e(f2, 16);
        if (attributeSet3 != null) {
            Paint paint7 = paint4;
            Paint paint8 = paint5;
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet3, R$styleable.f10063e, i2, i3);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.f10085p);
                this.f9783l = drawable;
                if (drawable != null) {
                    q(drawable);
                    e3 = Math.max(drawable.getMinimumHeight(), e3);
                }
                this.f9784m = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f10071i, e2);
                this.f9785n = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f10089r, e3);
                this.f9786o = obtainStyledAttributes.getInt(R$styleable.f10069h, 0);
                this.f9787p = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f10067g, e4);
                this.f9788q = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f10087q, e5);
                this.f9789r = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f10081n, e6);
                this.f9790s = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f10083o, e7);
                int i4 = obtainStyledAttributes.getInt(R$styleable.f10077l, -1);
                int i5 = obtainStyledAttributes.getInt(R$styleable.f10079m, -1);
                int i6 = obtainStyledAttributes.getInt(R$styleable.f10073j, -855638017);
                int i7 = obtainStyledAttributes.getInt(R$styleable.f10091s, 872415231);
                int i8 = obtainStyledAttributes.getInt(R$styleable.f10065f, -1291845888);
                int i9 = obtainStyledAttributes.getInt(R$styleable.f10075k, 872414976);
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
            this.f9784m = e2;
            this.f9785n = e3;
            this.f9786o = 0;
            this.f9787p = e4;
            this.f9788q = e5;
            this.f9789r = e6;
            this.f9790s = e7;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.f9783l = null;
        }
        StringBuilder sb = new StringBuilder();
        this.f9793v = sb;
        this.f9794w = new Formatter(sb, Locale.getDefault());
        this.f9795x = new a(this);
        Drawable drawable2 = this.f9783l;
        if (drawable2 != null) {
            this.f9791t = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.f9791t = (Math.max(this.f9789r, Math.max(this.f9788q, this.f9790s)) + 1) / 2;
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
