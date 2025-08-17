package com.google.android.exoplayer2.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

final class StyledPlayerControlViewLayoutManager {
    /* access modifiers changed from: private */
    public boolean A;
    /* access modifiers changed from: private */
    public boolean B;
    private boolean C = true;

    /* renamed from: a  reason: collision with root package name */
    private final StyledPlayerControlView f28159a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final View f28160b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f28161c;

    /* renamed from: d  reason: collision with root package name */
    private final ViewGroup f28162d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ViewGroup f28163e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final ViewGroup f28164f;

    /* renamed from: g  reason: collision with root package name */
    private final ViewGroup f28165g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final ViewGroup f28166h;

    /* renamed from: i  reason: collision with root package name */
    private final ViewGroup f28167i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final View f28168j;

    /* renamed from: k  reason: collision with root package name */
    private final View f28169k;

    /* renamed from: l  reason: collision with root package name */
    private final AnimatorSet f28170l;

    /* renamed from: m  reason: collision with root package name */
    private final AnimatorSet f28171m;

    /* renamed from: n  reason: collision with root package name */
    private final AnimatorSet f28172n;

    /* renamed from: o  reason: collision with root package name */
    private final AnimatorSet f28173o;

    /* renamed from: p  reason: collision with root package name */
    private final AnimatorSet f28174p;

    /* renamed from: q  reason: collision with root package name */
    private final ValueAnimator f28175q;

    /* renamed from: r  reason: collision with root package name */
    private final ValueAnimator f28176r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public final Runnable f28177s = new h(this);

    /* renamed from: t  reason: collision with root package name */
    private final Runnable f28178t = new n(this);

    /* renamed from: u  reason: collision with root package name */
    private final Runnable f28179u = new o(this);

    /* renamed from: v  reason: collision with root package name */
    private final Runnable f28180v = new p(this);

    /* renamed from: w  reason: collision with root package name */
    private final Runnable f28181w = new q(this);

    /* renamed from: x  reason: collision with root package name */
    private final View.OnLayoutChangeListener f28182x = new r(this);

    /* renamed from: y  reason: collision with root package name */
    private final List<View> f28183y = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    private int f28184z = 0;

    public StyledPlayerControlViewLayoutManager(final StyledPlayerControlView styledPlayerControlView) {
        this.f28159a = styledPlayerControlView;
        this.f28160b = styledPlayerControlView.findViewById(R$id.f27974l);
        this.f28161c = (ViewGroup) styledPlayerControlView.findViewById(R$id.f27969g);
        this.f28163e = (ViewGroup) styledPlayerControlView.findViewById(R$id.f27984v);
        ViewGroup viewGroup = (ViewGroup) styledPlayerControlView.findViewById(R$id.f27967e);
        this.f28162d = viewGroup;
        this.f28167i = (ViewGroup) styledPlayerControlView.findViewById(R$id.T);
        View findViewById = styledPlayerControlView.findViewById(R$id.H);
        this.f28168j = findViewById;
        this.f28164f = (ViewGroup) styledPlayerControlView.findViewById(R$id.f27966d);
        this.f28165g = (ViewGroup) styledPlayerControlView.findViewById(R$id.f27977o);
        this.f28166h = (ViewGroup) styledPlayerControlView.findViewById(R$id.f27978p);
        View findViewById2 = styledPlayerControlView.findViewById(R$id.f27988z);
        this.f28169k = findViewById2;
        View findViewById3 = styledPlayerControlView.findViewById(R$id.f27987y);
        if (!(findViewById2 == null || findViewById3 == null)) {
            findViewById2.setOnClickListener(new s(this));
            findViewById3.setOnClickListener(new s(this));
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new t(this));
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (StyledPlayerControlViewLayoutManager.this.f28160b != null) {
                    StyledPlayerControlViewLayoutManager.this.f28160b.setVisibility(4);
                }
                if (StyledPlayerControlViewLayoutManager.this.f28161c != null) {
                    StyledPlayerControlViewLayoutManager.this.f28161c.setVisibility(4);
                }
                if (StyledPlayerControlViewLayoutManager.this.f28163e != null) {
                    StyledPlayerControlViewLayoutManager.this.f28163e.setVisibility(4);
                }
            }

            public void onAnimationStart(Animator animator) {
                if ((StyledPlayerControlViewLayoutManager.this.f28168j instanceof DefaultTimeBar) && !StyledPlayerControlViewLayoutManager.this.A) {
                    ((DefaultTimeBar) StyledPlayerControlViewLayoutManager.this.f28168j).h(250);
                }
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new i(this));
        ofFloat2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                int i2 = 0;
                if (StyledPlayerControlViewLayoutManager.this.f28160b != null) {
                    StyledPlayerControlViewLayoutManager.this.f28160b.setVisibility(0);
                }
                if (StyledPlayerControlViewLayoutManager.this.f28161c != null) {
                    StyledPlayerControlViewLayoutManager.this.f28161c.setVisibility(0);
                }
                if (StyledPlayerControlViewLayoutManager.this.f28163e != null) {
                    ViewGroup r2 = StyledPlayerControlViewLayoutManager.this.f28163e;
                    if (!StyledPlayerControlViewLayoutManager.this.A) {
                        i2 = 4;
                    }
                    r2.setVisibility(i2);
                }
                if ((StyledPlayerControlViewLayoutManager.this.f28168j instanceof DefaultTimeBar) && !StyledPlayerControlViewLayoutManager.this.A) {
                    ((DefaultTimeBar) StyledPlayerControlViewLayoutManager.this.f28168j).u(250);
                }
            }
        });
        Resources resources = styledPlayerControlView.getResources();
        int i2 = R$dimen.f27940b;
        float dimension = resources.getDimension(i2) - resources.getDimension(R$dimen.f27941c);
        float dimension2 = resources.getDimension(i2);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f28170l = animatorSet;
        animatorSet.setDuration(250);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.Z(1);
                if (StyledPlayerControlViewLayoutManager.this.B) {
                    styledPlayerControlView.post(StyledPlayerControlViewLayoutManager.this.f28177s);
                    boolean unused = StyledPlayerControlViewLayoutManager.this.B = false;
                }
            }

            public void onAnimationStart(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.Z(3);
            }
        });
        animatorSet.play(ofFloat).with(N(0.0f, dimension, findViewById)).with(N(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f28171m = animatorSet2;
        animatorSet2.setDuration(250);
        animatorSet2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.Z(2);
                if (StyledPlayerControlViewLayoutManager.this.B) {
                    styledPlayerControlView.post(StyledPlayerControlViewLayoutManager.this.f28177s);
                    boolean unused = StyledPlayerControlViewLayoutManager.this.B = false;
                }
            }

            public void onAnimationStart(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.Z(3);
            }
        });
        animatorSet2.play(N(dimension, dimension2, findViewById)).with(N(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f28172n = animatorSet3;
        animatorSet3.setDuration(250);
        animatorSet3.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.Z(2);
                if (StyledPlayerControlViewLayoutManager.this.B) {
                    styledPlayerControlView.post(StyledPlayerControlViewLayoutManager.this.f28177s);
                    boolean unused = StyledPlayerControlViewLayoutManager.this.B = false;
                }
            }

            public void onAnimationStart(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.Z(3);
            }
        });
        animatorSet3.play(ofFloat).with(N(0.0f, dimension2, findViewById)).with(N(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f28173o = animatorSet4;
        animatorSet4.setDuration(250);
        animatorSet4.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.Z(0);
            }

            public void onAnimationStart(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.Z(4);
            }
        });
        animatorSet4.play(ofFloat2).with(N(dimension, 0.0f, findViewById)).with(N(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f28174p = animatorSet5;
        animatorSet5.setDuration(250);
        animatorSet5.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.Z(0);
            }

            public void onAnimationStart(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.Z(4);
            }
        });
        animatorSet5.play(ofFloat2).with(N(dimension2, 0.0f, findViewById)).with(N(dimension2, 0.0f, viewGroup));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f28175q = ofFloat3;
        ofFloat3.setDuration(250);
        ofFloat3.addUpdateListener(new l(this));
        ofFloat3.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (StyledPlayerControlViewLayoutManager.this.f28164f != null) {
                    StyledPlayerControlViewLayoutManager.this.f28164f.setVisibility(4);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (StyledPlayerControlViewLayoutManager.this.f28166h != null) {
                    StyledPlayerControlViewLayoutManager.this.f28166h.setVisibility(0);
                    StyledPlayerControlViewLayoutManager.this.f28166h.setTranslationX((float) StyledPlayerControlViewLayoutManager.this.f28166h.getWidth());
                    StyledPlayerControlViewLayoutManager.this.f28166h.scrollTo(StyledPlayerControlViewLayoutManager.this.f28166h.getWidth(), 0);
                }
            }
        });
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.f28176r = ofFloat4;
        ofFloat4.setDuration(250);
        ofFloat4.addUpdateListener(new m(this));
        ofFloat4.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (StyledPlayerControlViewLayoutManager.this.f28166h != null) {
                    StyledPlayerControlViewLayoutManager.this.f28166h.setVisibility(4);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (StyledPlayerControlViewLayoutManager.this.f28164f != null) {
                    StyledPlayerControlViewLayoutManager.this.f28164f.setVisibility(0);
                }
            }
        });
    }

    private static int B(View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    /* access modifiers changed from: private */
    public void D() {
        this.f28172n.start();
    }

    /* access modifiers changed from: private */
    public void E() {
        Z(2);
    }

    /* access modifiers changed from: private */
    public void G() {
        this.f28170l.start();
        U(this.f28179u, 2000);
    }

    /* access modifiers changed from: private */
    public void H() {
        this.f28171m.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f28160b;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.f28161c;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.f28163e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f28160b;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.f28161c;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.f28163e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private static ObjectAnimator N(float f2, float f3, View view) {
        return ObjectAnimator.ofFloat(view, "translationY", new float[]{f2, f3});
    }

    /* access modifiers changed from: private */
    public void R(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean z2;
        boolean e02 = e0();
        if (this.A != e02) {
            this.A = e02;
            view.post(new j(this));
        }
        if (i4 - i2 != i8 - i6) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!this.A && z2) {
            view.post(new k(this));
        }
    }

    /* access modifiers changed from: private */
    public void S() {
        int i2;
        if (this.f28164f != null && this.f28165g != null) {
            int width = (this.f28159a.getWidth() - this.f28159a.getPaddingLeft()) - this.f28159a.getPaddingRight();
            while (true) {
                if (this.f28165g.getChildCount() <= 1) {
                    break;
                }
                int childCount = this.f28165g.getChildCount() - 2;
                View childAt = this.f28165g.getChildAt(childCount);
                this.f28165g.removeViewAt(childCount);
                this.f28164f.addView(childAt, 0);
            }
            View view = this.f28169k;
            if (view != null) {
                view.setVisibility(8);
            }
            int B2 = B(this.f28167i);
            int childCount2 = this.f28164f.getChildCount() - 1;
            for (int i3 = 0; i3 < childCount2; i3++) {
                B2 += B(this.f28164f.getChildAt(i3));
            }
            if (B2 > width) {
                View view2 = this.f28169k;
                if (view2 != null) {
                    view2.setVisibility(0);
                    B2 += B(this.f28169k);
                }
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < childCount2; i4++) {
                    View childAt2 = this.f28164f.getChildAt(i4);
                    B2 -= B(childAt2);
                    arrayList.add(childAt2);
                    if (B2 <= width) {
                        break;
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.f28164f.removeViews(0, arrayList.size());
                    for (i2 = 0; i2 < arrayList.size(); i2++) {
                        this.f28165g.addView((View) arrayList.get(i2), this.f28165g.getChildCount() - 1);
                    }
                    return;
                }
                return;
            }
            ViewGroup viewGroup = this.f28166h;
            if (viewGroup != null && viewGroup.getVisibility() == 0 && !this.f28176r.isStarted()) {
                this.f28175q.cancel();
                this.f28176r.start();
            }
        }
    }

    /* access modifiers changed from: private */
    public void T(View view) {
        W();
        if (view.getId() == R$id.f27988z) {
            this.f28175q.start();
        } else if (view.getId() == R$id.f27987y) {
            this.f28176r.start();
        }
    }

    private void U(Runnable runnable, long j2) {
        if (j2 >= 0) {
            this.f28159a.postDelayed(runnable, j2);
        }
    }

    /* access modifiers changed from: private */
    public void Z(int i2) {
        int i3 = this.f28184z;
        this.f28184z = i2;
        if (i2 == 2) {
            this.f28159a.setVisibility(8);
        } else if (i3 == 2) {
            this.f28159a.setVisibility(0);
        }
        if (i3 != i2) {
            this.f28159a.i0();
        }
    }

    private boolean a0(View view) {
        int id = view.getId();
        if (id == R$id.f27967e || id == R$id.G || id == R$id.f27986x || id == R$id.K || id == R$id.L || id == R$id.f27979q || id == R$id.f27980r) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void c0() {
        if (!this.C) {
            Z(0);
            W();
            return;
        }
        int i2 = this.f28184z;
        if (i2 == 1) {
            this.f28173o.start();
        } else if (i2 == 2) {
            this.f28174p.start();
        } else if (i2 == 3) {
            this.B = true;
        } else if (i2 == 4) {
            return;
        }
        W();
    }

    /* access modifiers changed from: private */
    public void d0() {
        int i2;
        int i3;
        ViewGroup viewGroup = this.f28163e;
        if (viewGroup != null) {
            if (this.A) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            viewGroup.setVisibility(i3);
        }
        if (this.f28168j != null) {
            int dimensionPixelSize = this.f28159a.getResources().getDimensionPixelSize(R$dimen.f27942d);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f28168j.getLayoutParams();
            if (marginLayoutParams != null) {
                if (this.A) {
                    dimensionPixelSize = 0;
                }
                marginLayoutParams.bottomMargin = dimensionPixelSize;
                this.f28168j.setLayoutParams(marginLayoutParams);
            }
            View view = this.f28168j;
            if (view instanceof DefaultTimeBar) {
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                if (this.A) {
                    defaultTimeBar.i(true);
                } else {
                    int i4 = this.f28184z;
                    if (i4 == 1) {
                        defaultTimeBar.i(false);
                    } else if (i4 != 3) {
                        defaultTimeBar.t();
                    }
                }
            }
        }
        for (View next : this.f28183y) {
            if (!this.A || !a0(next)) {
                i2 = 0;
            } else {
                i2 = 4;
            }
            next.setVisibility(i2);
        }
    }

    private boolean e0() {
        int i2;
        int i3;
        int width = (this.f28159a.getWidth() - this.f28159a.getPaddingLeft()) - this.f28159a.getPaddingRight();
        int height = (this.f28159a.getHeight() - this.f28159a.getPaddingBottom()) - this.f28159a.getPaddingTop();
        int B2 = B(this.f28161c);
        ViewGroup viewGroup = this.f28161c;
        if (viewGroup != null) {
            i2 = viewGroup.getPaddingLeft() + this.f28161c.getPaddingRight();
        } else {
            i2 = 0;
        }
        int i4 = B2 - i2;
        int z2 = z(this.f28161c);
        ViewGroup viewGroup2 = this.f28161c;
        if (viewGroup2 != null) {
            i3 = viewGroup2.getPaddingTop() + this.f28161c.getPaddingBottom();
        } else {
            i3 = 0;
        }
        int max = Math.max(i4, B(this.f28167i) + B(this.f28169k));
        int z3 = (z2 - i3) + (z(this.f28162d) * 2);
        if (width <= max || height <= z3) {
            return true;
        }
        return false;
    }

    private void y(float f2) {
        ViewGroup viewGroup = this.f28166h;
        if (viewGroup != null) {
            this.f28166h.setTranslationX((float) ((int) (((float) viewGroup.getWidth()) * (1.0f - f2))));
        }
        ViewGroup viewGroup2 = this.f28167i;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f2);
        }
        ViewGroup viewGroup3 = this.f28164f;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f2);
        }
    }

    private static int z(View view) {
        if (view == null) {
            return 0;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return height;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public boolean A(View view) {
        return view != null && this.f28183y.contains(view);
    }

    public void C() {
        int i2 = this.f28184z;
        if (i2 != 3 && i2 != 2) {
            V();
            if (!this.C) {
                E();
            } else if (this.f28184z == 1) {
                H();
            } else {
                D();
            }
        }
    }

    public void F() {
        int i2 = this.f28184z;
        if (i2 != 3 && i2 != 2) {
            V();
            E();
        }
    }

    public boolean I() {
        return this.f28184z == 0 && this.f28159a.h0();
    }

    public void O() {
        this.f28159a.addOnLayoutChangeListener(this.f28182x);
    }

    public void P() {
        this.f28159a.removeOnLayoutChangeListener(this.f28182x);
    }

    public void Q(boolean z2, int i2, int i3, int i4, int i5) {
        View view = this.f28160b;
        if (view != null) {
            view.layout(0, 0, i4 - i2, i5 - i3);
        }
    }

    public void V() {
        this.f28159a.removeCallbacks(this.f28181w);
        this.f28159a.removeCallbacks(this.f28178t);
        this.f28159a.removeCallbacks(this.f28180v);
        this.f28159a.removeCallbacks(this.f28179u);
    }

    public void W() {
        if (this.f28184z != 3) {
            V();
            int showTimeoutMs = this.f28159a.getShowTimeoutMs();
            if (showTimeoutMs <= 0) {
                return;
            }
            if (!this.C) {
                U(this.f28181w, (long) showTimeoutMs);
            } else if (this.f28184z == 1) {
                U(this.f28179u, 2000);
            } else {
                U(this.f28180v, (long) showTimeoutMs);
            }
        }
    }

    public void X(boolean z2) {
        this.C = z2;
    }

    public void Y(View view, boolean z2) {
        if (view != null) {
            if (!z2) {
                view.setVisibility(8);
                this.f28183y.remove(view);
                return;
            }
            if (!this.A || !a0(view)) {
                view.setVisibility(0);
            } else {
                view.setVisibility(4);
            }
            this.f28183y.add(view);
        }
    }

    public void b0() {
        if (!this.f28159a.h0()) {
            this.f28159a.setVisibility(0);
            this.f28159a.s0();
            this.f28159a.n0();
        }
        c0();
    }
}
