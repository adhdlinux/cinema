package com.androidadvance.topsnackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import com.androidadvance.topsnackbar.SnackbarManager;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.android.material.behavior.SwipeDismissBehavior;

public final class TSnackbar {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final Handler f13678g = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                ((TSnackbar) message.obj).u();
                return true;
            } else if (i2 != 1) {
                return false;
            } else {
                ((TSnackbar) message.obj).m(message.arg1);
                return true;
            }
        }
    });

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f13679a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f13680b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final SnackbarLayout f13681c;

    /* renamed from: d  reason: collision with root package name */
    private int f13682d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Callback f13683e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final SnackbarManager.Callback f13684f = new SnackbarManager.Callback() {
        public void a(int i2) {
            TSnackbar.f13678g.sendMessage(TSnackbar.f13678g.obtainMessage(1, i2, 0, TSnackbar.this));
        }

        public void show() {
            TSnackbar.f13678g.sendMessage(TSnackbar.f13678g.obtainMessage(0, TSnackbar.this));
        }
    };

    final class Behavior extends SwipeDismissBehavior<SnackbarLayout> {
        Behavior() {
        }

        public boolean D(View view) {
            return view instanceof SnackbarLayout;
        }

        /* renamed from: N */
        public boolean k(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
            if (coordinatorLayout.B(snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    SnackbarManager.e().c(TSnackbar.this.f13684f);
                } else if (actionMasked == 1 || actionMasked == 3) {
                    SnackbarManager.e().l(TSnackbar.this.f13684f);
                }
            }
            return super.k(coordinatorLayout, snackbarLayout, motionEvent);
        }
    }

    public static abstract class Callback {
        public void a(TSnackbar tSnackbar, int i2) {
        }

        public void b(TSnackbar tSnackbar) {
        }
    }

    public static class SnackbarLayout extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        private TextView f13694b;

        /* renamed from: c  reason: collision with root package name */
        private Button f13695c;

        /* renamed from: d  reason: collision with root package name */
        private int f13696d;

        /* renamed from: e  reason: collision with root package name */
        private final int f13697e;

        /* renamed from: f  reason: collision with root package name */
        private OnLayoutChangeListener f13698f;

        /* renamed from: g  reason: collision with root package name */
        private OnAttachStateChangeListener f13699g;

        interface OnAttachStateChangeListener {
            void onViewAttachedToWindow(View view);

            void onViewDetachedFromWindow(View view);
        }

        interface OnLayoutChangeListener {
            void a(View view, int i2, int i3, int i4, int i5);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f13632f0);
            this.f13696d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f13634g0, -1);
            this.f13697e = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f13638i0, -1);
            int i2 = R$styleable.f13636h0;
            if (obtainStyledAttributes.hasValue(i2)) {
                ViewCompat.z0(this, (float) obtainStyledAttributes.getDimensionPixelSize(i2, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(R$layout.tsnackbar_layout_include, this);
            ViewCompat.t0(this, 1);
        }

        private static void c(View view, int i2, int i3) {
            if (ViewCompat.X(view)) {
                ViewCompat.H0(view, ViewCompat.I(view), i2, ViewCompat.H(view), i3);
            } else {
                view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
            }
        }

        private boolean d(int i2, int i3, int i4) {
            boolean z2;
            if (i2 != getOrientation()) {
                setOrientation(i2);
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.f13694b.getPaddingTop() == i3 && this.f13694b.getPaddingBottom() == i4) {
                return z2;
            }
            c(this.f13694b, i3, i4);
            return true;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            this.f13694b.setAlpha(0.0f);
            long j2 = (long) i3;
            long j3 = (long) i2;
            ViewCompat.d(this.f13694b).b(1.0f).f(j2).j(j3).l();
            if (this.f13695c.getVisibility() == 0) {
                this.f13695c.setAlpha(0.0f);
                ViewCompat.d(this.f13695c).b(1.0f).f(j2).j(j3).l();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, int i3) {
            this.f13694b.setAlpha(1.0f);
            long j2 = (long) i3;
            long j3 = (long) i2;
            ViewCompat.d(this.f13694b).b(0.0f).f(j2).j(j3).l();
            if (this.f13695c.getVisibility() == 0) {
                this.f13695c.setAlpha(1.0f);
                ViewCompat.d(this.f13695c).b(0.0f).f(j2).j(j3).l();
            }
        }

        /* access modifiers changed from: package-private */
        public Button getActionView() {
            return this.f13695c;
        }

        /* access modifiers changed from: package-private */
        public TextView getMessageView() {
            return this.f13694b;
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            OnAttachStateChangeListener onAttachStateChangeListener = this.f13699g;
            if (onAttachStateChangeListener != null) {
                onAttachStateChangeListener.onViewAttachedToWindow(this);
            }
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            OnAttachStateChangeListener onAttachStateChangeListener = this.f13699g;
            if (onAttachStateChangeListener != null) {
                onAttachStateChangeListener.onViewDetachedFromWindow(this);
            }
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            this.f13694b = (TextView) findViewById(R$id.f13620b);
            this.f13695c = (Button) findViewById(R$id.f13619a);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
            super.onLayout(z2, i2, i3, i4, i5);
            OnLayoutChangeListener onLayoutChangeListener = this.f13698f;
            if (onLayoutChangeListener != null) {
                onLayoutChangeListener.a(this, i2, i3, i4, i5);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
            if (d(1, r0, r0 - r1) != false) goto L_0x0060;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
            if (d(0, r0, r0) != false) goto L_0x0060;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMeasure(int r8, int r9) {
            /*
                r7 = this;
                super.onMeasure(r8, r9)
                int r0 = r7.f13696d
                if (r0 <= 0) goto L_0x0018
                int r0 = r7.getMeasuredWidth()
                int r1 = r7.f13696d
                if (r0 <= r1) goto L_0x0018
                r8 = 1073741824(0x40000000, float:2.0)
                int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
                super.onMeasure(r8, r9)
            L_0x0018:
                android.content.res.Resources r0 = r7.getResources()
                int r1 = com.androidadvance.topsnackbar.R$dimen.f13618b
                int r0 = r0.getDimensionPixelSize(r1)
                android.content.res.Resources r1 = r7.getResources()
                int r2 = com.androidadvance.topsnackbar.R$dimen.f13617a
                int r1 = r1.getDimensionPixelSize(r2)
                android.widget.TextView r2 = r7.f13694b
                android.text.Layout r2 = r2.getLayout()
                int r2 = r2.getLineCount()
                r3 = 0
                r4 = 1
                if (r2 <= r4) goto L_0x003c
                r2 = 1
                goto L_0x003d
            L_0x003c:
                r2 = 0
            L_0x003d:
                if (r2 == 0) goto L_0x0056
                int r5 = r7.f13697e
                if (r5 <= 0) goto L_0x0056
                android.widget.Button r5 = r7.f13695c
                int r5 = r5.getMeasuredWidth()
                int r6 = r7.f13697e
                if (r5 <= r6) goto L_0x0056
                int r1 = r0 - r1
                boolean r0 = r7.d(r4, r0, r1)
                if (r0 == 0) goto L_0x0061
                goto L_0x0060
            L_0x0056:
                if (r2 == 0) goto L_0x0059
                goto L_0x005a
            L_0x0059:
                r0 = r1
            L_0x005a:
                boolean r0 = r7.d(r3, r0, r0)
                if (r0 == 0) goto L_0x0061
            L_0x0060:
                r3 = 1
            L_0x0061:
                if (r3 == 0) goto L_0x0066
                super.onMeasure(r8, r9)
            L_0x0066:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.androidadvance.topsnackbar.TSnackbar.SnackbarLayout.onMeasure(int, int):void");
        }

        /* access modifiers changed from: package-private */
        public void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
            this.f13699g = onAttachStateChangeListener;
        }

        /* access modifiers changed from: package-private */
        public void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
            this.f13698f = onLayoutChangeListener;
        }
    }

    private TSnackbar(ViewGroup viewGroup) {
        this.f13679a = viewGroup;
        Context context = viewGroup.getContext();
        this.f13680b = context;
        this.f13681c = (SnackbarLayout) LayoutInflater.from(context).inflate(R$layout.tsnackbar_layout, viewGroup, false);
    }

    /* access modifiers changed from: private */
    public void h() {
        SnackbarLayout snackbarLayout = this.f13681c;
        snackbarLayout.setTranslationY((float) (-snackbarLayout.getHeight()));
        ViewCompat.d(this.f13681c).m(0.0f).g(AnimationUtils.f13615b).f(250).h(new ViewPropertyAnimatorListenerAdapter() {
            public void b(View view) {
                if (TSnackbar.this.f13683e != null) {
                    TSnackbar.this.f13683e.b(TSnackbar.this);
                }
                SnackbarManager.e().k(TSnackbar.this.f13684f);
            }

            public void c(View view) {
                TSnackbar.this.f13681c.a(70, RotationOptions.ROTATE_180);
            }
        }).l();
    }

    private void i(final int i2) {
        ViewCompat.d(this.f13681c).m((float) (-this.f13681c.getHeight())).g(AnimationUtils.f13615b).f(250).h(new ViewPropertyAnimatorListenerAdapter() {
            public void b(View view) {
                TSnackbar.this.q(i2);
            }

            public void c(View view) {
                TSnackbar.this.f13681c.b(0, RotationOptions.ROTATE_180);
            }
        }).l();
    }

    /* access modifiers changed from: private */
    public void k(int i2) {
        SnackbarManager.e().d(this.f13684f, i2);
    }

    private static ViewGroup l(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            } else if (((view instanceof Toolbar) || (view instanceof android.widget.Toolbar)) && (view.getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                if (viewGroup2.getChildCount() > 1) {
                    int childCount = viewGroup2.getChildCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= childCount) {
                            break;
                        } else if (viewGroup2.getChildAt(i2) != view) {
                            i2++;
                        } else if (i2 < childCount - 1) {
                            while (i2 < childCount) {
                                i2++;
                                View childAt = viewGroup2.getChildAt(i2);
                                if (childAt instanceof ViewGroup) {
                                    return (ViewGroup) childAt;
                                }
                            }
                        }
                    }
                }
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    private boolean n() {
        ViewGroup.LayoutParams layoutParams = this.f13681c.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            return false;
        }
        CoordinatorLayout.Behavior f2 = ((CoordinatorLayout.LayoutParams) layoutParams).f();
        if (!(f2 instanceof SwipeDismissBehavior) || ((SwipeDismissBehavior) f2).I() == 0) {
            return false;
        }
        return true;
    }

    public static TSnackbar p(View view, CharSequence charSequence, int i2) {
        TSnackbar tSnackbar = new TSnackbar(l(view));
        tSnackbar.s(charSequence);
        tSnackbar.r(i2);
        return tSnackbar;
    }

    /* access modifiers changed from: private */
    public void q(int i2) {
        SnackbarManager.e().j(this.f13684f);
        Callback callback = this.f13683e;
        if (callback != null) {
            callback.a(this, i2);
        }
        ViewParent parent = this.f13681c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f13681c);
        }
    }

    public void j() {
        k(3);
    }

    /* access modifiers changed from: package-private */
    public final void m(int i2) {
        if (this.f13681c.getVisibility() != 0 || n()) {
            q(i2);
        } else {
            i(i2);
        }
    }

    public boolean o() {
        return SnackbarManager.e().g(this.f13684f);
    }

    public TSnackbar r(int i2) {
        this.f13682d = i2;
        return this;
    }

    public TSnackbar s(CharSequence charSequence) {
        this.f13681c.getMessageView().setText(charSequence);
        return this;
    }

    public void t() {
        SnackbarManager.e().n(this.f13682d, this.f13684f);
    }

    /* access modifiers changed from: package-private */
    public final void u() {
        if (this.f13681c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f13681c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                Behavior behavior = new Behavior();
                behavior.L(0.1f);
                behavior.J(0.6f);
                behavior.M(0);
                behavior.K(new SwipeDismissBehavior.OnDismissListener() {
                    public void a(View view) {
                        TSnackbar.this.k(0);
                    }

                    public void b(int i2) {
                        if (i2 == 0) {
                            SnackbarManager.e().l(TSnackbar.this.f13684f);
                        } else if (i2 == 1 || i2 == 2) {
                            SnackbarManager.e().c(TSnackbar.this.f13684f);
                        }
                    }
                });
                ((CoordinatorLayout.LayoutParams) layoutParams).o(behavior);
            }
            this.f13679a.addView(this.f13681c);
        }
        this.f13681c.setOnAttachStateChangeListener(new SnackbarLayout.OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View view) {
            }

            public void onViewDetachedFromWindow(View view) {
                if (TSnackbar.this.o()) {
                    TSnackbar.f13678g.post(new Runnable() {
                        public void run() {
                            TSnackbar.this.q(3);
                        }
                    });
                }
            }
        });
        if (ViewCompat.V(this.f13681c)) {
            h();
        } else {
            this.f13681c.setOnLayoutChangeListener(new SnackbarLayout.OnLayoutChangeListener() {
                public void a(View view, int i2, int i3, int i4, int i5) {
                    TSnackbar.this.h();
                    TSnackbar.this.f13681c.setOnLayoutChangeListener((SnackbarLayout.OnLayoutChangeListener) null);
                }
            });
        }
    }
}
