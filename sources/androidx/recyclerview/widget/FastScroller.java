package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.common.ConnectionResult;

class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    private static final int[] D = {16842919};
    private static final int[] E = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.OnScrollListener C;

    /* renamed from: a  reason: collision with root package name */
    private final int f11112a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11113b;

    /* renamed from: c  reason: collision with root package name */
    final StateListDrawable f11114c;

    /* renamed from: d  reason: collision with root package name */
    final Drawable f11115d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11116e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11117f;

    /* renamed from: g  reason: collision with root package name */
    private final StateListDrawable f11118g;

    /* renamed from: h  reason: collision with root package name */
    private final Drawable f11119h;

    /* renamed from: i  reason: collision with root package name */
    private final int f11120i;

    /* renamed from: j  reason: collision with root package name */
    private final int f11121j;

    /* renamed from: k  reason: collision with root package name */
    int f11122k;

    /* renamed from: l  reason: collision with root package name */
    int f11123l;

    /* renamed from: m  reason: collision with root package name */
    float f11124m;

    /* renamed from: n  reason: collision with root package name */
    int f11125n;

    /* renamed from: o  reason: collision with root package name */
    int f11126o;

    /* renamed from: p  reason: collision with root package name */
    float f11127p;

    /* renamed from: q  reason: collision with root package name */
    private int f11128q = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f11129r = 0;

    /* renamed from: s  reason: collision with root package name */
    private RecyclerView f11130s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f11131t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f11132u = false;

    /* renamed from: v  reason: collision with root package name */
    private int f11133v = 0;

    /* renamed from: w  reason: collision with root package name */
    private int f11134w = 0;

    /* renamed from: x  reason: collision with root package name */
    private final int[] f11135x = new int[2];

    /* renamed from: y  reason: collision with root package name */
    private final int[] f11136y = new int[2];

    /* renamed from: z  reason: collision with root package name */
    final ValueAnimator f11137z;

    private class AnimatorListener extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f11140a = false;

        AnimatorListener() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f11140a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f11140a) {
                this.f11140a = false;
            } else if (((Float) FastScroller.this.f11137z.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller fastScroller = FastScroller.this;
                fastScroller.A = 0;
                fastScroller.y(0);
            } else {
                FastScroller fastScroller2 = FastScroller.this;
                fastScroller2.A = 2;
                fastScroller2.v();
            }
        }
    }

    private class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        AnimatorUpdater() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.f11114c.setAlpha(floatValue);
            FastScroller.this.f11115d.setAlpha(floatValue);
            FastScroller.this.v();
        }
    }

    FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f11137z = ofFloat;
        this.A = 0;
        this.B = new Runnable() {
            public void run() {
                FastScroller.this.q(500);
            }
        };
        this.C = new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                FastScroller.this.B(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
            }
        };
        this.f11114c = stateListDrawable;
        this.f11115d = drawable;
        this.f11118g = stateListDrawable2;
        this.f11119h = drawable2;
        this.f11116e = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f11117f = Math.max(i2, drawable.getIntrinsicWidth());
        this.f11120i = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.f11121j = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f11112a = i3;
        this.f11113b = i4;
        stateListDrawable.setAlpha(JfifUtil.MARKER_FIRST_BYTE);
        drawable.setAlpha(JfifUtil.MARKER_FIRST_BYTE);
        ofFloat.addListener(new AnimatorListener());
        ofFloat.addUpdateListener(new AnimatorUpdater());
        j(recyclerView);
    }

    private void C(float f2) {
        int[] p2 = p();
        float max = Math.max((float) p2[0], Math.min((float) p2[1], f2));
        if (Math.abs(((float) this.f11123l) - max) >= 2.0f) {
            int x2 = x(this.f11124m, max, p2, this.f11130s.computeVerticalScrollRange(), this.f11130s.computeVerticalScrollOffset(), this.f11129r);
            if (x2 != 0) {
                this.f11130s.scrollBy(0, x2);
            }
            this.f11124m = max;
        }
    }

    private void k() {
        this.f11130s.removeCallbacks(this.B);
    }

    private void l() {
        this.f11130s.removeItemDecoration(this);
        this.f11130s.removeOnItemTouchListener(this);
        this.f11130s.removeOnScrollListener(this.C);
        k();
    }

    private void m(Canvas canvas) {
        int i2 = this.f11129r;
        int i3 = this.f11120i;
        int i4 = i2 - i3;
        int i5 = this.f11126o;
        int i6 = this.f11125n;
        int i7 = i5 - (i6 / 2);
        this.f11118g.setBounds(0, 0, i6, i3);
        this.f11119h.setBounds(0, 0, this.f11128q, this.f11121j);
        canvas.translate(0.0f, (float) i4);
        this.f11119h.draw(canvas);
        canvas.translate((float) i7, 0.0f);
        this.f11118g.draw(canvas);
        canvas.translate((float) (-i7), (float) (-i4));
    }

    private void n(Canvas canvas) {
        int i2 = this.f11128q;
        int i3 = this.f11116e;
        int i4 = i2 - i3;
        int i5 = this.f11123l;
        int i6 = this.f11122k;
        int i7 = i5 - (i6 / 2);
        this.f11114c.setBounds(0, 0, i3, i6);
        this.f11115d.setBounds(0, 0, this.f11117f, this.f11129r);
        if (s()) {
            this.f11115d.draw(canvas);
            canvas.translate((float) this.f11116e, (float) i7);
            canvas.scale(-1.0f, 1.0f);
            this.f11114c.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            canvas.translate((float) (-this.f11116e), (float) (-i7));
            return;
        }
        canvas.translate((float) i4, 0.0f);
        this.f11115d.draw(canvas);
        canvas.translate(0.0f, (float) i7);
        this.f11114c.draw(canvas);
        canvas.translate((float) (-i4), (float) (-i7));
    }

    private int[] o() {
        int[] iArr = this.f11136y;
        int i2 = this.f11113b;
        iArr[0] = i2;
        iArr[1] = this.f11128q - i2;
        return iArr;
    }

    private int[] p() {
        int[] iArr = this.f11135x;
        int i2 = this.f11113b;
        iArr[0] = i2;
        iArr[1] = this.f11129r - i2;
        return iArr;
    }

    private void r(float f2) {
        int[] o2 = o();
        float max = Math.max((float) o2[0], Math.min((float) o2[1], f2));
        if (Math.abs(((float) this.f11126o) - max) >= 2.0f) {
            int x2 = x(this.f11127p, max, o2, this.f11130s.computeHorizontalScrollRange(), this.f11130s.computeHorizontalScrollOffset(), this.f11128q);
            if (x2 != 0) {
                this.f11130s.scrollBy(x2, 0);
            }
            this.f11127p = max;
        }
    }

    private boolean s() {
        return ViewCompat.D(this.f11130s) == 1;
    }

    private void w(int i2) {
        k();
        this.f11130s.postDelayed(this.B, (long) i2);
    }

    private int x(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / ((float) i5)) * ((float) i6));
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    private void z() {
        this.f11130s.addItemDecoration(this);
        this.f11130s.addOnItemTouchListener(this);
        this.f11130s.addOnScrollListener(this.C);
    }

    public void A() {
        int i2 = this.A;
        if (i2 != 0) {
            if (i2 == 3) {
                this.f11137z.cancel();
            } else {
                return;
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f11137z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.f11137z.setDuration(500);
        this.f11137z.setStartDelay(0);
        this.f11137z.start();
    }

    /* access modifiers changed from: package-private */
    public void B(int i2, int i3) {
        boolean z2;
        boolean z3;
        int computeVerticalScrollRange = this.f11130s.computeVerticalScrollRange();
        int i4 = this.f11129r;
        if (computeVerticalScrollRange - i4 <= 0 || i4 < this.f11112a) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f11131t = z2;
        int computeHorizontalScrollRange = this.f11130s.computeHorizontalScrollRange();
        int i5 = this.f11128q;
        if (computeHorizontalScrollRange - i5 <= 0 || i5 < this.f11112a) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.f11132u = z3;
        boolean z4 = this.f11131t;
        if (z4 || z3) {
            if (z4) {
                float f2 = (float) i4;
                this.f11123l = (int) ((f2 * (((float) i3) + (f2 / 2.0f))) / ((float) computeVerticalScrollRange));
                this.f11122k = Math.min(i4, (i4 * i4) / computeVerticalScrollRange);
            }
            if (this.f11132u) {
                float f3 = (float) i5;
                this.f11126o = (int) ((f3 * (((float) i2) + (f3 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.f11125n = Math.min(i5, (i5 * i5) / computeHorizontalScrollRange);
            }
            int i6 = this.f11133v;
            if (i6 == 0 || i6 == 1) {
                y(1);
            }
        } else if (this.f11133v != 0) {
            y(0);
        }
    }

    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f11133v != 0) {
            if (motionEvent.getAction() == 0) {
                boolean u2 = u(motionEvent.getX(), motionEvent.getY());
                boolean t2 = t(motionEvent.getX(), motionEvent.getY());
                if (u2 || t2) {
                    if (t2) {
                        this.f11134w = 1;
                        this.f11127p = (float) ((int) motionEvent.getX());
                    } else if (u2) {
                        this.f11134w = 2;
                        this.f11124m = (float) ((int) motionEvent.getY());
                    }
                    y(2);
                }
            } else if (motionEvent.getAction() == 1 && this.f11133v == 2) {
                this.f11124m = 0.0f;
                this.f11127p = 0.0f;
                y(1);
                this.f11134w = 0;
            } else if (motionEvent.getAction() == 2 && this.f11133v == 2) {
                A();
                if (this.f11134w == 1) {
                    r(motionEvent.getX());
                }
                if (this.f11134w == 2) {
                    C(motionEvent.getY());
                }
            }
        }
    }

    public boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i2 = this.f11133v;
        if (i2 == 1) {
            boolean u2 = u(motionEvent.getX(), motionEvent.getY());
            boolean t2 = t(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!u2 && !t2) {
                return false;
            }
            if (t2) {
                this.f11134w = 1;
                this.f11127p = (float) ((int) motionEvent.getX());
            } else if (u2) {
                this.f11134w = 2;
                this.f11124m = (float) ((int) motionEvent.getY());
            }
            y(2);
        } else if (i2 == 2) {
            return true;
        } else {
            return false;
        }
        return true;
    }

    public void c(boolean z2) {
    }

    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.f11128q != this.f11130s.getWidth() || this.f11129r != this.f11130s.getHeight()) {
            this.f11128q = this.f11130s.getWidth();
            this.f11129r = this.f11130s.getHeight();
            y(0);
        } else if (this.A != 0) {
            if (this.f11131t) {
                n(canvas);
            }
            if (this.f11132u) {
                m(canvas);
            }
        }
    }

    public void j(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f11130s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                l();
            }
            this.f11130s = recyclerView;
            if (recyclerView != null) {
                z();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void q(int i2) {
        int i3 = this.A;
        if (i3 == 1) {
            this.f11137z.cancel();
        } else if (i3 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f11137z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
        this.f11137z.setDuration((long) i2);
        this.f11137z.start();
    }

    /* access modifiers changed from: package-private */
    public boolean t(float f2, float f3) {
        if (f3 >= ((float) (this.f11129r - this.f11120i))) {
            int i2 = this.f11126o;
            int i3 = this.f11125n;
            return f2 >= ((float) (i2 - (i3 / 2))) && f2 <= ((float) (i2 + (i3 / 2)));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean u(float f2, float f3) {
        if (!s() ? f2 >= ((float) (this.f11128q - this.f11116e)) : f2 <= ((float) this.f11116e)) {
            int i2 = this.f11123l;
            int i3 = this.f11122k;
            return f3 >= ((float) (i2 - (i3 / 2))) && f3 <= ((float) (i2 + (i3 / 2)));
        }
    }

    /* access modifiers changed from: package-private */
    public void v() {
        this.f11130s.invalidate();
    }

    /* access modifiers changed from: package-private */
    public void y(int i2) {
        if (i2 == 2 && this.f11133v != 2) {
            this.f11114c.setState(D);
            k();
        }
        if (i2 == 0) {
            v();
        } else {
            A();
        }
        if (this.f11133v == 2 && i2 != 2) {
            this.f11114c.setState(E);
            w(1200);
        } else if (i2 == 1) {
            w(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        this.f11133v = i2;
    }
}
