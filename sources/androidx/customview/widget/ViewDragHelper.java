package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

public class ViewDragHelper {

    /* renamed from: w  reason: collision with root package name */
    private static final Interpolator f3003w = new Interpolator() {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f3004a;

    /* renamed from: b  reason: collision with root package name */
    private int f3005b;

    /* renamed from: c  reason: collision with root package name */
    private int f3006c = -1;

    /* renamed from: d  reason: collision with root package name */
    private float[] f3007d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f3008e;

    /* renamed from: f  reason: collision with root package name */
    private float[] f3009f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f3010g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f3011h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f3012i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f3013j;

    /* renamed from: k  reason: collision with root package name */
    private int f3014k;

    /* renamed from: l  reason: collision with root package name */
    private VelocityTracker f3015l;

    /* renamed from: m  reason: collision with root package name */
    private float f3016m;

    /* renamed from: n  reason: collision with root package name */
    private float f3017n;

    /* renamed from: o  reason: collision with root package name */
    private int f3018o;

    /* renamed from: p  reason: collision with root package name */
    private int f3019p;

    /* renamed from: q  reason: collision with root package name */
    private OverScroller f3020q;

    /* renamed from: r  reason: collision with root package name */
    private final Callback f3021r;

    /* renamed from: s  reason: collision with root package name */
    private View f3022s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f3023t;

    /* renamed from: u  reason: collision with root package name */
    private final ViewGroup f3024u;

    /* renamed from: v  reason: collision with root package name */
    private final Runnable f3025v = new Runnable() {
        public void run() {
            ViewDragHelper.this.K(0);
        }
    };

    public static abstract class Callback {
        public int a(View view, int i2, int i3) {
            return 0;
        }

        public int b(View view, int i2, int i3) {
            return 0;
        }

        public int c(int i2) {
            return i2;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i2, int i3) {
        }

        public boolean g(int i2) {
            return false;
        }

        public void h(int i2, int i3) {
        }

        public void i(View view, int i2) {
        }

        public void j(int i2) {
        }

        public void k(View view, int i2, int i3, int i4, int i5) {
        }

        public void l(View view, float f2, float f3) {
        }

        public abstract boolean m(View view, int i2);
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback != null) {
            this.f3024u = viewGroup;
            this.f3021r = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f3018o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f3005b = viewConfiguration.getScaledTouchSlop();
            this.f3016m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f3017n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f3020q = new OverScroller(context, f3003w);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    private boolean D(int i2) {
        if (C(i2)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i2 + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void G() {
        this.f3015l.computeCurrentVelocity(1000, this.f3016m);
        q(h(this.f3015l.getXVelocity(this.f3006c), this.f3017n, this.f3016m), h(this.f3015l.getYVelocity(this.f3006c), this.f3017n, this.f3016m));
    }

    private void H(float f2, float f3, int i2) {
        boolean d2 = d(f2, f3, i2, 1);
        if (d(f3, f2, i2, 4)) {
            d2 |= true;
        }
        if (d(f2, f3, i2, 2)) {
            d2 |= true;
        }
        if (d(f3, f2, i2, 8)) {
            d2 |= true;
        }
        if (d2) {
            int[] iArr = this.f3012i;
            iArr[i2] = iArr[i2] | d2;
            this.f3021r.f(d2 ? 1 : 0, i2);
        }
    }

    private void I(float f2, float f3, int i2) {
        t(i2);
        float[] fArr = this.f3007d;
        this.f3009f[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.f3008e;
        this.f3010g[i2] = f3;
        fArr2[i2] = f3;
        this.f3011h[i2] = y((int) f2, (int) f3);
        this.f3014k |= 1 << i2;
    }

    private void J(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (D(pointerId)) {
                float x2 = motionEvent.getX(i2);
                float y2 = motionEvent.getY(i2);
                this.f3009f[pointerId] = x2;
                this.f3010g[pointerId] = y2;
            }
        }
    }

    private boolean d(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.f3011h[i2] & i3) != i3 || (this.f3019p & i3) == 0 || (this.f3013j[i2] & i3) == i3 || (this.f3012i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.f3005b;
        if (abs <= ((float) i4) && abs2 <= ((float) i4)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f3021r.g(i3)) {
            int[] iArr = this.f3013j;
            iArr[i2] = iArr[i2] | i3;
            return false;
        } else if ((this.f3012i[i2] & i3) != 0 || abs <= ((float) this.f3005b)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean g(View view, float f2, float f3) {
        boolean z2;
        boolean z3;
        if (view == null) {
            return false;
        }
        if (this.f3021r.d(view) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f3021r.e(view) > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 && z3) {
            int i2 = this.f3005b;
            if ((f2 * f2) + (f3 * f3) > ((float) (i2 * i2))) {
                return true;
            }
            return false;
        } else if (z2) {
            if (Math.abs(f2) > ((float) this.f3005b)) {
                return true;
            }
            return false;
        } else if (!z3 || Math.abs(f3) <= ((float) this.f3005b)) {
            return false;
        } else {
            return true;
        }
    }

    private float h(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        return abs > f4 ? f2 > 0.0f ? f4 : -f4 : f2;
    }

    private int i(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        return abs > i4 ? i2 > 0 ? i4 : -i4 : i2;
    }

    private void j() {
        float[] fArr = this.f3007d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f3008e, 0.0f);
            Arrays.fill(this.f3009f, 0.0f);
            Arrays.fill(this.f3010g, 0.0f);
            Arrays.fill(this.f3011h, 0);
            Arrays.fill(this.f3012i, 0);
            Arrays.fill(this.f3013j, 0);
            this.f3014k = 0;
        }
    }

    private void k(int i2) {
        if (this.f3007d != null && C(i2)) {
            this.f3007d[i2] = 0.0f;
            this.f3008e[i2] = 0.0f;
            this.f3009f[i2] = 0.0f;
            this.f3010g[i2] = 0.0f;
            this.f3011h[i2] = 0;
            this.f3012i[i2] = 0;
            this.f3013j[i2] = 0;
            this.f3014k = (~(1 << i2)) & this.f3014k;
        }
    }

    private int l(int i2, int i3, int i4) {
        int i5;
        if (i2 == 0) {
            return 0;
        }
        int width = this.f3024u.getWidth();
        float f2 = (float) (width / 2);
        float r2 = f2 + (r(Math.min(1.0f, ((float) Math.abs(i2)) / ((float) width))) * f2);
        int abs = Math.abs(i3);
        if (abs > 0) {
            i5 = Math.round(Math.abs(r2 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i5 = (int) (((((float) Math.abs(i2)) / ((float) i4)) + 1.0f) * 256.0f);
        }
        return Math.min(i5, 600);
    }

    private int m(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int i6 = i(i4, (int) this.f3017n, (int) this.f3016m);
        int i7 = i(i5, (int) this.f3017n, (int) this.f3016m);
        int abs = Math.abs(i2);
        int abs2 = Math.abs(i3);
        int abs3 = Math.abs(i6);
        int abs4 = Math.abs(i7);
        int i8 = abs3 + abs4;
        int i9 = abs + abs2;
        if (i6 != 0) {
            f3 = (float) abs3;
            f2 = (float) i8;
        } else {
            f3 = (float) abs;
            f2 = (float) i9;
        }
        float f6 = f3 / f2;
        if (i7 != 0) {
            f5 = (float) abs4;
            f4 = (float) i8;
        } else {
            f5 = (float) abs2;
            f4 = (float) i9;
        }
        float f7 = f5 / f4;
        return (int) ((((float) l(i2, i6, this.f3021r.d(view))) * f6) + (((float) l(i3, i7, this.f3021r.e(view))) * f7));
    }

    public static ViewDragHelper o(ViewGroup viewGroup, float f2, Callback callback) {
        ViewDragHelper p2 = p(viewGroup, callback);
        p2.f3005b = (int) (((float) p2.f3005b) * (1.0f / f2));
        return p2;
    }

    public static ViewDragHelper p(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void q(float f2, float f3) {
        this.f3023t = true;
        this.f3021r.l(this.f3022s, f2, f3);
        this.f3023t = false;
        if (this.f3004a == 1) {
            K(0);
        }
    }

    private float r(float f2) {
        return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
    }

    private void s(int i2, int i3, int i4, int i5) {
        int left = this.f3022s.getLeft();
        int top = this.f3022s.getTop();
        if (i4 != 0) {
            i2 = this.f3021r.a(this.f3022s, i2, i4);
            ViewCompat.b0(this.f3022s, i2 - left);
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.f3021r.b(this.f3022s, i3, i5);
            ViewCompat.c0(this.f3022s, i3 - top);
        }
        int i7 = i3;
        if (i4 != 0 || i5 != 0) {
            this.f3021r.k(this.f3022s, i6, i7, i6 - left, i7 - top);
        }
    }

    private void t(int i2) {
        float[] fArr = this.f3007d;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f3008e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f3009f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f3010g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f3011h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f3012i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f3013j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f3007d = fArr2;
            this.f3008e = fArr3;
            this.f3009f = fArr4;
            this.f3010g = fArr5;
            this.f3011h = iArr;
            this.f3012i = iArr2;
            this.f3013j = iArr3;
        }
    }

    private boolean v(int i2, int i3, int i4, int i5) {
        int left = this.f3022s.getLeft();
        int top = this.f3022s.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.f3020q.abortAnimation();
            K(0);
            return false;
        }
        this.f3020q.startScroll(left, top, i6, i7, m(this.f3022s, i6, i7, i4, i5));
        K(2);
        return true;
    }

    private int y(int i2, int i3) {
        int i4;
        if (i2 < this.f3024u.getLeft() + this.f3018o) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        if (i3 < this.f3024u.getTop() + this.f3018o) {
            i4 |= 4;
        }
        if (i2 > this.f3024u.getRight() - this.f3018o) {
            i4 |= 2;
        }
        if (i3 > this.f3024u.getBottom() - this.f3018o) {
            return i4 | 8;
        }
        return i4;
    }

    public int A() {
        return this.f3004a;
    }

    public boolean B(int i2, int i3) {
        return E(this.f3022s, i2, i3);
    }

    public boolean C(int i2) {
        return ((1 << i2) & this.f3014k) != 0;
    }

    public boolean E(View view, int i2, int i3) {
        if (view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public void F(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.f3015l == null) {
            this.f3015l = VelocityTracker.obtain();
        }
        this.f3015l.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View u2 = u((int) x2, (int) y2);
            I(x2, y2, pointerId);
            Q(u2, pointerId);
            int i4 = this.f3011h[pointerId];
            int i5 = this.f3019p;
            if ((i4 & i5) != 0) {
                this.f3021r.h(i4 & i5, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f3004a == 1) {
                G();
            }
            b();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f3004a == 1) {
                    q(0.0f, 0.0f);
                }
                b();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x3 = motionEvent.getX(actionIndex);
                float y3 = motionEvent.getY(actionIndex);
                I(x3, y3, pointerId2);
                if (this.f3004a == 0) {
                    Q(u((int) x3, (int) y3), pointerId2);
                    int i6 = this.f3011h[pointerId2];
                    int i7 = this.f3019p;
                    if ((i6 & i7) != 0) {
                        this.f3021r.h(i6 & i7, pointerId2);
                    }
                } else if (B((int) x3, (int) y3)) {
                    Q(this.f3022s, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.f3004a == 1 && pointerId3 == this.f3006c) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i3 >= pointerCount) {
                            i2 = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i3);
                        if (pointerId4 != this.f3006c) {
                            View u3 = u((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                            View view = this.f3022s;
                            if (u3 == view && Q(view, pointerId4)) {
                                i2 = this.f3006c;
                                break;
                            }
                        }
                        i3++;
                    }
                    if (i2 == -1) {
                        G();
                    }
                }
                k(pointerId3);
            }
        } else if (this.f3004a != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i3 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i3);
                if (D(pointerId5)) {
                    float x4 = motionEvent.getX(i3);
                    float y4 = motionEvent.getY(i3);
                    float f2 = x4 - this.f3007d[pointerId5];
                    float f3 = y4 - this.f3008e[pointerId5];
                    H(f2, f3, pointerId5);
                    if (this.f3004a != 1) {
                        View u4 = u((int) x4, (int) y4);
                        if (g(u4, f2, f3) && Q(u4, pointerId5)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i3++;
            }
            J(motionEvent);
        } else if (D(this.f3006c)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f3006c);
            float x5 = motionEvent.getX(findPointerIndex);
            float y5 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.f3009f;
            int i8 = this.f3006c;
            int i9 = (int) (x5 - fArr[i8]);
            int i10 = (int) (y5 - this.f3010g[i8]);
            s(this.f3022s.getLeft() + i9, this.f3022s.getTop() + i10, i9, i10);
            J(motionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void K(int i2) {
        this.f3024u.removeCallbacks(this.f3025v);
        if (this.f3004a != i2) {
            this.f3004a = i2;
            this.f3021r.j(i2);
            if (this.f3004a == 0) {
                this.f3022s = null;
            }
        }
    }

    public void L(int i2) {
        this.f3019p = i2;
    }

    public void M(float f2) {
        this.f3017n = f2;
    }

    public boolean N(int i2, int i3) {
        if (this.f3023t) {
            return v(i2, i3, (int) this.f3015l.getXVelocity(this.f3006c), (int) this.f3015l.getYVelocity(this.f3006c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r12 != r11) goto L_0x00e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean O(android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r17.getActionMasked()
            int r3 = r17.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r16.b()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.f3015l
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f3015l = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.f3015l
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0104
            if (r2 == r6) goto L_0x00ff
            if (r2 == r4) goto L_0x0070
            r7 = 3
            if (r2 == r7) goto L_0x00ff
            r7 = 5
            if (r2 == r7) goto L_0x003c
            r4 = 6
            if (r2 == r4) goto L_0x0034
        L_0x0031:
            r5 = 0
            goto L_0x0135
        L_0x0034:
            int r1 = r1.getPointerId(r3)
            r0.k(r1)
            goto L_0x0031
        L_0x003c:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.I(r7, r1, r2)
            int r3 = r0.f3004a
            if (r3 != 0) goto L_0x0060
            int[] r1 = r0.f3011h
            r1 = r1[r2]
            int r3 = r0.f3019p
            r4 = r1 & r3
            if (r4 == 0) goto L_0x0031
            androidx.customview.widget.ViewDragHelper$Callback r4 = r0.f3021r
            r1 = r1 & r3
            r4.h(r1, r2)
            goto L_0x0031
        L_0x0060:
            if (r3 != r4) goto L_0x0031
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.u(r3, r1)
            android.view.View r3 = r0.f3022s
            if (r1 != r3) goto L_0x0031
            r0.Q(r1, r2)
            goto L_0x0031
        L_0x0070:
            float[] r2 = r0.f3007d
            if (r2 == 0) goto L_0x0031
            float[] r2 = r0.f3008e
            if (r2 != 0) goto L_0x0079
            goto L_0x0031
        L_0x0079:
            int r2 = r17.getPointerCount()
            r3 = 0
        L_0x007e:
            if (r3 >= r2) goto L_0x00fa
            int r4 = r1.getPointerId(r3)
            boolean r7 = r0.D(r4)
            if (r7 != 0) goto L_0x008c
            goto L_0x00f7
        L_0x008c:
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.f3007d
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.f3008e
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.u(r7, r8)
            if (r7 == 0) goto L_0x00b0
            boolean r8 = r0.g(r7, r9, r10)
            if (r8 == 0) goto L_0x00b0
            r8 = 1
            goto L_0x00b1
        L_0x00b0:
            r8 = 0
        L_0x00b1:
            if (r8 == 0) goto L_0x00e6
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r13 = r11 + r12
            androidx.customview.widget.ViewDragHelper$Callback r14 = r0.f3021r
            int r12 = r14.a(r7, r13, r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r15 = r13 + r14
            androidx.customview.widget.ViewDragHelper$Callback r5 = r0.f3021r
            int r5 = r5.b(r7, r15, r14)
            androidx.customview.widget.ViewDragHelper$Callback r14 = r0.f3021r
            int r14 = r14.d(r7)
            androidx.customview.widget.ViewDragHelper$Callback r15 = r0.f3021r
            int r15 = r15.e(r7)
            if (r14 == 0) goto L_0x00df
            if (r14 <= 0) goto L_0x00e6
            if (r12 != r11) goto L_0x00e6
        L_0x00df:
            if (r15 == 0) goto L_0x00fa
            if (r15 <= 0) goto L_0x00e6
            if (r5 != r13) goto L_0x00e6
            goto L_0x00fa
        L_0x00e6:
            r0.H(r9, r10, r4)
            int r5 = r0.f3004a
            if (r5 != r6) goto L_0x00ee
            goto L_0x00fa
        L_0x00ee:
            if (r8 == 0) goto L_0x00f7
            boolean r4 = r0.Q(r7, r4)
            if (r4 == 0) goto L_0x00f7
            goto L_0x00fa
        L_0x00f7:
            int r3 = r3 + 1
            goto L_0x007e
        L_0x00fa:
            r16.J(r17)
            goto L_0x0031
        L_0x00ff:
            r16.b()
            goto L_0x0031
        L_0x0104:
            float r2 = r17.getX()
            float r3 = r17.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.I(r2, r3, r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.u(r2, r3)
            android.view.View r3 = r0.f3022s
            if (r2 != r3) goto L_0x0125
            int r3 = r0.f3004a
            if (r3 != r4) goto L_0x0125
            r0.Q(r2, r1)
        L_0x0125:
            int[] r2 = r0.f3011h
            r2 = r2[r1]
            int r3 = r0.f3019p
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0135
            androidx.customview.widget.ViewDragHelper$Callback r4 = r0.f3021r
            r2 = r2 & r3
            r4.h(r2, r1)
        L_0x0135:
            int r1 = r0.f3004a
            if (r1 != r6) goto L_0x013a
            r5 = 1
        L_0x013a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.O(android.view.MotionEvent):boolean");
    }

    public boolean P(View view, int i2, int i3) {
        this.f3022s = view;
        this.f3006c = -1;
        boolean v2 = v(i2, i3, 0, 0);
        if (!v2 && this.f3004a == 0 && this.f3022s != null) {
            this.f3022s = null;
        }
        return v2;
    }

    /* access modifiers changed from: package-private */
    public boolean Q(View view, int i2) {
        if (view == this.f3022s && this.f3006c == i2) {
            return true;
        }
        if (view == null || !this.f3021r.m(view, i2)) {
            return false;
        }
        this.f3006c = i2;
        c(view, i2);
        return true;
    }

    public void a() {
        b();
        if (this.f3004a == 2) {
            int currX = this.f3020q.getCurrX();
            int currY = this.f3020q.getCurrY();
            this.f3020q.abortAnimation();
            int currX2 = this.f3020q.getCurrX();
            int currY2 = this.f3020q.getCurrY();
            this.f3021r.k(this.f3022s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        K(0);
    }

    public void b() {
        this.f3006c = -1;
        j();
        VelocityTracker velocityTracker = this.f3015l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3015l = null;
        }
    }

    public void c(View view, int i2) {
        if (view.getParent() == this.f3024u) {
            this.f3022s = view;
            this.f3006c = i2;
            this.f3021r.i(view, i2);
            K(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f3024u + ")");
    }

    public boolean e(int i2) {
        int length = this.f3007d.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (f(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(int i2, int i3) {
        boolean z2;
        boolean z3;
        if (!C(i3)) {
            return false;
        }
        if ((i2 & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((i2 & 2) == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        float f2 = this.f3009f[i3] - this.f3007d[i3];
        float f3 = this.f3010g[i3] - this.f3008e[i3];
        if (z2 && z3) {
            int i4 = this.f3005b;
            if ((f2 * f2) + (f3 * f3) > ((float) (i4 * i4))) {
                return true;
            }
            return false;
        } else if (z2) {
            if (Math.abs(f2) > ((float) this.f3005b)) {
                return true;
            }
            return false;
        } else if (!z3 || Math.abs(f3) <= ((float) this.f3005b)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean n(boolean z2) {
        if (this.f3004a == 2) {
            boolean computeScrollOffset = this.f3020q.computeScrollOffset();
            int currX = this.f3020q.getCurrX();
            int currY = this.f3020q.getCurrY();
            int left = currX - this.f3022s.getLeft();
            int top = currY - this.f3022s.getTop();
            if (left != 0) {
                ViewCompat.b0(this.f3022s, left);
            }
            if (top != 0) {
                ViewCompat.c0(this.f3022s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f3021r.k(this.f3022s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f3020q.getFinalX() && currY == this.f3020q.getFinalY()) {
                this.f3020q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z2) {
                    this.f3024u.post(this.f3025v);
                } else {
                    K(0);
                }
            }
        }
        if (this.f3004a == 2) {
            return true;
        }
        return false;
    }

    public View u(int i2, int i3) {
        for (int childCount = this.f3024u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f3024u.getChildAt(this.f3021r.c(childCount));
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public View w() {
        return this.f3022s;
    }

    public int x() {
        return this.f3018o;
    }

    public int z() {
        return this.f3005b;
    }
}
