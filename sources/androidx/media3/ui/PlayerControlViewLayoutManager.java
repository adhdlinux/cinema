package androidx.media3.ui;

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

final class PlayerControlViewLayoutManager {
    /* access modifiers changed from: private */
    public boolean A;
    /* access modifiers changed from: private */
    public boolean B;
    private boolean C = true;

    /* renamed from: a  reason: collision with root package name */
    private final PlayerControlView f9902a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final View f9903b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f9904c;

    /* renamed from: d  reason: collision with root package name */
    private final ViewGroup f9905d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ViewGroup f9906e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final ViewGroup f9907f;

    /* renamed from: g  reason: collision with root package name */
    private final ViewGroup f9908g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final ViewGroup f9909h;

    /* renamed from: i  reason: collision with root package name */
    private final ViewGroup f9910i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final View f9911j;

    /* renamed from: k  reason: collision with root package name */
    private final View f9912k;

    /* renamed from: l  reason: collision with root package name */
    private final AnimatorSet f9913l;

    /* renamed from: m  reason: collision with root package name */
    private final AnimatorSet f9914m;

    /* renamed from: n  reason: collision with root package name */
    private final AnimatorSet f9915n;

    /* renamed from: o  reason: collision with root package name */
    private final AnimatorSet f9916o;

    /* renamed from: p  reason: collision with root package name */
    private final AnimatorSet f9917p;

    /* renamed from: q  reason: collision with root package name */
    private final ValueAnimator f9918q;

    /* renamed from: r  reason: collision with root package name */
    private final ValueAnimator f9919r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public final Runnable f9920s = new f(this);

    /* renamed from: t  reason: collision with root package name */
    private final Runnable f9921t = new l(this);

    /* renamed from: u  reason: collision with root package name */
    private final Runnable f9922u = new m(this);

    /* renamed from: v  reason: collision with root package name */
    private final Runnable f9923v = new n(this);

    /* renamed from: w  reason: collision with root package name */
    private final Runnable f9924w = new o(this);

    /* renamed from: x  reason: collision with root package name */
    private final View.OnLayoutChangeListener f9925x = new p(this);

    /* renamed from: y  reason: collision with root package name */
    private final List<View> f9926y = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    private int f9927z = 0;

    public PlayerControlViewLayoutManager(final PlayerControlView playerControlView) {
        this.f9902a = playerControlView;
        this.f9903b = playerControlView.findViewById(R$id.f10004l);
        this.f9904c = (ViewGroup) playerControlView.findViewById(R$id.f9999g);
        this.f9906e = (ViewGroup) playerControlView.findViewById(R$id.f10014w);
        ViewGroup viewGroup = (ViewGroup) playerControlView.findViewById(R$id.f9997e);
        this.f9905d = viewGroup;
        this.f9910i = (ViewGroup) playerControlView.findViewById(R$id.U);
        View findViewById = playerControlView.findViewById(R$id.I);
        this.f9911j = findViewById;
        this.f9907f = (ViewGroup) playerControlView.findViewById(R$id.f9996d);
        this.f9908g = (ViewGroup) playerControlView.findViewById(R$id.f10007o);
        this.f9909h = (ViewGroup) playerControlView.findViewById(R$id.f10008p);
        View findViewById2 = playerControlView.findViewById(R$id.A);
        this.f9912k = findViewById2;
        View findViewById3 = playerControlView.findViewById(R$id.f10017z);
        if (!(findViewById2 == null || findViewById3 == null)) {
            findViewById2.setOnClickListener(new q(this));
            findViewById3.setOnClickListener(new q(this));
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new r(this));
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (PlayerControlViewLayoutManager.this.f9903b != null) {
                    PlayerControlViewLayoutManager.this.f9903b.setVisibility(4);
                }
                if (PlayerControlViewLayoutManager.this.f9904c != null) {
                    PlayerControlViewLayoutManager.this.f9904c.setVisibility(4);
                }
                if (PlayerControlViewLayoutManager.this.f9906e != null) {
                    PlayerControlViewLayoutManager.this.f9906e.setVisibility(4);
                }
            }

            public void onAnimationStart(Animator animator) {
                if ((PlayerControlViewLayoutManager.this.f9911j instanceof DefaultTimeBar) && !PlayerControlViewLayoutManager.this.A) {
                    ((DefaultTimeBar) PlayerControlViewLayoutManager.this.f9911j).h(250);
                }
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new g(this));
        ofFloat2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                int i2 = 0;
                if (PlayerControlViewLayoutManager.this.f9903b != null) {
                    PlayerControlViewLayoutManager.this.f9903b.setVisibility(0);
                }
                if (PlayerControlViewLayoutManager.this.f9904c != null) {
                    PlayerControlViewLayoutManager.this.f9904c.setVisibility(0);
                }
                if (PlayerControlViewLayoutManager.this.f9906e != null) {
                    ViewGroup r2 = PlayerControlViewLayoutManager.this.f9906e;
                    if (!PlayerControlViewLayoutManager.this.A) {
                        i2 = 4;
                    }
                    r2.setVisibility(i2);
                }
                if ((PlayerControlViewLayoutManager.this.f9911j instanceof DefaultTimeBar) && !PlayerControlViewLayoutManager.this.A) {
                    ((DefaultTimeBar) PlayerControlViewLayoutManager.this.f9911j).u(250);
                }
            }
        });
        Resources resources = playerControlView.getResources();
        int i2 = R$dimen.f9972b;
        float dimension = resources.getDimension(i2) - resources.getDimension(R$dimen.f9973c);
        float dimension2 = resources.getDimension(i2);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f9913l = animatorSet;
        animatorSet.setDuration(250);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                PlayerControlViewLayoutManager.this.Z(1);
                if (PlayerControlViewLayoutManager.this.B) {
                    playerControlView.post(PlayerControlViewLayoutManager.this.f9920s);
                    boolean unused = PlayerControlViewLayoutManager.this.B = false;
                }
            }

            public void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager.this.Z(3);
            }
        });
        animatorSet.play(ofFloat).with(N(0.0f, dimension, findViewById)).with(N(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f9914m = animatorSet2;
        animatorSet2.setDuration(250);
        animatorSet2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                PlayerControlViewLayoutManager.this.Z(2);
                if (PlayerControlViewLayoutManager.this.B) {
                    playerControlView.post(PlayerControlViewLayoutManager.this.f9920s);
                    boolean unused = PlayerControlViewLayoutManager.this.B = false;
                }
            }

            public void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager.this.Z(3);
            }
        });
        animatorSet2.play(N(dimension, dimension2, findViewById)).with(N(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f9915n = animatorSet3;
        animatorSet3.setDuration(250);
        animatorSet3.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                PlayerControlViewLayoutManager.this.Z(2);
                if (PlayerControlViewLayoutManager.this.B) {
                    playerControlView.post(PlayerControlViewLayoutManager.this.f9920s);
                    boolean unused = PlayerControlViewLayoutManager.this.B = false;
                }
            }

            public void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager.this.Z(3);
            }
        });
        animatorSet3.play(ofFloat).with(N(0.0f, dimension2, findViewById)).with(N(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f9916o = animatorSet4;
        animatorSet4.setDuration(250);
        animatorSet4.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                PlayerControlViewLayoutManager.this.Z(0);
            }

            public void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager.this.Z(4);
            }
        });
        animatorSet4.play(ofFloat2).with(N(dimension, 0.0f, findViewById)).with(N(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f9917p = animatorSet5;
        animatorSet5.setDuration(250);
        animatorSet5.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                PlayerControlViewLayoutManager.this.Z(0);
            }

            public void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager.this.Z(4);
            }
        });
        animatorSet5.play(ofFloat2).with(N(dimension2, 0.0f, findViewById)).with(N(dimension2, 0.0f, viewGroup));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f9918q = ofFloat3;
        ofFloat3.setDuration(250);
        ofFloat3.addUpdateListener(new j(this));
        ofFloat3.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (PlayerControlViewLayoutManager.this.f9907f != null) {
                    PlayerControlViewLayoutManager.this.f9907f.setVisibility(4);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (PlayerControlViewLayoutManager.this.f9909h != null) {
                    PlayerControlViewLayoutManager.this.f9909h.setVisibility(0);
                    PlayerControlViewLayoutManager.this.f9909h.setTranslationX((float) PlayerControlViewLayoutManager.this.f9909h.getWidth());
                    PlayerControlViewLayoutManager.this.f9909h.scrollTo(PlayerControlViewLayoutManager.this.f9909h.getWidth(), 0);
                }
            }
        });
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.f9919r = ofFloat4;
        ofFloat4.setDuration(250);
        ofFloat4.addUpdateListener(new k(this));
        ofFloat4.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (PlayerControlViewLayoutManager.this.f9909h != null) {
                    PlayerControlViewLayoutManager.this.f9909h.setVisibility(4);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (PlayerControlViewLayoutManager.this.f9907f != null) {
                    PlayerControlViewLayoutManager.this.f9907f.setVisibility(0);
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
        this.f9915n.start();
    }

    /* access modifiers changed from: private */
    public void E() {
        Z(2);
    }

    /* access modifiers changed from: private */
    public void G() {
        this.f9913l.start();
        U(this.f9922u, 2000);
    }

    /* access modifiers changed from: private */
    public void H() {
        this.f9914m.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f9903b;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.f9904c;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.f9906e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f9903b;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.f9904c;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.f9906e;
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
            view.post(new h(this));
        }
        if (i4 - i2 != i8 - i6) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!this.A && z2) {
            view.post(new i(this));
        }
    }

    /* access modifiers changed from: private */
    public void S() {
        int i2;
        if (this.f9907f != null && this.f9908g != null) {
            int width = (this.f9902a.getWidth() - this.f9902a.getPaddingLeft()) - this.f9902a.getPaddingRight();
            while (true) {
                if (this.f9908g.getChildCount() <= 1) {
                    break;
                }
                int childCount = this.f9908g.getChildCount() - 2;
                View childAt = this.f9908g.getChildAt(childCount);
                this.f9908g.removeViewAt(childCount);
                this.f9907f.addView(childAt, 0);
            }
            View view = this.f9912k;
            if (view != null) {
                view.setVisibility(8);
            }
            int B2 = B(this.f9910i);
            int childCount2 = this.f9907f.getChildCount() - 1;
            for (int i3 = 0; i3 < childCount2; i3++) {
                B2 += B(this.f9907f.getChildAt(i3));
            }
            if (B2 > width) {
                View view2 = this.f9912k;
                if (view2 != null) {
                    view2.setVisibility(0);
                    B2 += B(this.f9912k);
                }
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < childCount2; i4++) {
                    View childAt2 = this.f9907f.getChildAt(i4);
                    B2 -= B(childAt2);
                    arrayList.add(childAt2);
                    if (B2 <= width) {
                        break;
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.f9907f.removeViews(0, arrayList.size());
                    for (i2 = 0; i2 < arrayList.size(); i2++) {
                        this.f9908g.addView((View) arrayList.get(i2), this.f9908g.getChildCount() - 1);
                    }
                    return;
                }
                return;
            }
            ViewGroup viewGroup = this.f9909h;
            if (viewGroup != null && viewGroup.getVisibility() == 0 && !this.f9919r.isStarted()) {
                this.f9918q.cancel();
                this.f9919r.start();
            }
        }
    }

    /* access modifiers changed from: private */
    public void T(View view) {
        W();
        if (view.getId() == R$id.A) {
            this.f9918q.start();
        } else if (view.getId() == R$id.f10017z) {
            this.f9919r.start();
        }
    }

    private void U(Runnable runnable, long j2) {
        if (j2 >= 0) {
            this.f9902a.postDelayed(runnable, j2);
        }
    }

    /* access modifiers changed from: private */
    public void Z(int i2) {
        int i3 = this.f9927z;
        this.f9927z = i2;
        if (i2 == 2) {
            this.f9902a.setVisibility(8);
        } else if (i3 == 2) {
            this.f9902a.setVisibility(0);
        }
        if (i3 != i2) {
            this.f9902a.f0();
        }
    }

    private boolean a0(View view) {
        int id = view.getId();
        if (id == R$id.f9997e || id == R$id.H || id == R$id.f10016y || id == R$id.L || id == R$id.M || id == R$id.f10009q || id == R$id.f10010r) {
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
        int i2 = this.f9927z;
        if (i2 == 1) {
            this.f9916o.start();
        } else if (i2 == 2) {
            this.f9917p.start();
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
        ViewGroup viewGroup = this.f9906e;
        if (viewGroup != null) {
            if (this.A) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            viewGroup.setVisibility(i3);
        }
        if (this.f9911j != null) {
            int dimensionPixelSize = this.f9902a.getResources().getDimensionPixelSize(R$dimen.f9974d);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f9911j.getLayoutParams();
            if (marginLayoutParams != null) {
                if (this.A) {
                    dimensionPixelSize = 0;
                }
                marginLayoutParams.bottomMargin = dimensionPixelSize;
                this.f9911j.setLayoutParams(marginLayoutParams);
            }
            View view = this.f9911j;
            if (view instanceof DefaultTimeBar) {
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                if (this.A) {
                    defaultTimeBar.i(true);
                } else {
                    int i4 = this.f9927z;
                    if (i4 == 1) {
                        defaultTimeBar.i(false);
                    } else if (i4 != 3) {
                        defaultTimeBar.t();
                    }
                }
            }
        }
        for (View next : this.f9926y) {
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
        int width = (this.f9902a.getWidth() - this.f9902a.getPaddingLeft()) - this.f9902a.getPaddingRight();
        int height = (this.f9902a.getHeight() - this.f9902a.getPaddingBottom()) - this.f9902a.getPaddingTop();
        int B2 = B(this.f9904c);
        ViewGroup viewGroup = this.f9904c;
        if (viewGroup != null) {
            i2 = viewGroup.getPaddingLeft() + this.f9904c.getPaddingRight();
        } else {
            i2 = 0;
        }
        int i4 = B2 - i2;
        int z2 = z(this.f9904c);
        ViewGroup viewGroup2 = this.f9904c;
        if (viewGroup2 != null) {
            i3 = viewGroup2.getPaddingTop() + this.f9904c.getPaddingBottom();
        } else {
            i3 = 0;
        }
        int max = Math.max(i4, B(this.f9910i) + B(this.f9912k));
        int z3 = (z2 - i3) + (z(this.f9905d) * 2);
        if (width <= max || height <= z3) {
            return true;
        }
        return false;
    }

    private void y(float f2) {
        ViewGroup viewGroup = this.f9909h;
        if (viewGroup != null) {
            this.f9909h.setTranslationX((float) ((int) (((float) viewGroup.getWidth()) * (1.0f - f2))));
        }
        ViewGroup viewGroup2 = this.f9910i;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f2);
        }
        ViewGroup viewGroup3 = this.f9907f;
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
        return view != null && this.f9926y.contains(view);
    }

    public void C() {
        int i2 = this.f9927z;
        if (i2 != 3 && i2 != 2) {
            V();
            if (!this.C) {
                E();
            } else if (this.f9927z == 1) {
                H();
            } else {
                D();
            }
        }
    }

    public void F() {
        int i2 = this.f9927z;
        if (i2 != 3 && i2 != 2) {
            V();
            E();
        }
    }

    public boolean I() {
        return this.f9927z == 0 && this.f9902a.e0();
    }

    public void O() {
        this.f9902a.addOnLayoutChangeListener(this.f9925x);
    }

    public void P() {
        this.f9902a.removeOnLayoutChangeListener(this.f9925x);
    }

    public void Q(boolean z2, int i2, int i3, int i4, int i5) {
        View view = this.f9903b;
        if (view != null) {
            view.layout(0, 0, i4 - i2, i5 - i3);
        }
    }

    public void V() {
        this.f9902a.removeCallbacks(this.f9924w);
        this.f9902a.removeCallbacks(this.f9921t);
        this.f9902a.removeCallbacks(this.f9923v);
        this.f9902a.removeCallbacks(this.f9922u);
    }

    public void W() {
        if (this.f9927z != 3) {
            V();
            int showTimeoutMs = this.f9902a.getShowTimeoutMs();
            if (showTimeoutMs <= 0) {
                return;
            }
            if (!this.C) {
                U(this.f9924w, (long) showTimeoutMs);
            } else if (this.f9927z == 1) {
                U(this.f9922u, 2000);
            } else {
                U(this.f9923v, (long) showTimeoutMs);
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
                this.f9926y.remove(view);
                return;
            }
            if (!this.A || !a0(view)) {
                view.setVisibility(0);
            } else {
                view.setVisibility(4);
            }
            this.f9926y.add(view);
        }
    }

    public void b0() {
        if (!this.f9902a.e0()) {
            this.f9902a.setVisibility(0);
            this.f9902a.o0();
            this.f9902a.k0();
        }
        c0();
    }
}
