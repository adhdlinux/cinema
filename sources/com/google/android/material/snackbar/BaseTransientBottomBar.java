package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: j  reason: collision with root package name */
    static final Handler f30004j = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                ((BaseTransientBottomBar) message.obj).t();
                return true;
            } else if (i2 != 1) {
                return false;
            } else {
                ((BaseTransientBottomBar) message.obj).m(message.arg1);
                return true;
            }
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f30005k = false;

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f30006l = {R$attr.snackbarStyle};

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f30007a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f30008b;

    /* renamed from: c  reason: collision with root package name */
    protected final SnackbarBaseLayout f30009c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ContentViewCallback f30010d;

    /* renamed from: e  reason: collision with root package name */
    private int f30011e;

    /* renamed from: f  reason: collision with root package name */
    private List<BaseCallback<B>> f30012f;

    /* renamed from: g  reason: collision with root package name */
    private Behavior f30013g;

    /* renamed from: h  reason: collision with root package name */
    private final AccessibilityManager f30014h;

    /* renamed from: i  reason: collision with root package name */
    final SnackbarManager.Callback f30015i = new SnackbarManager.Callback() {
        public void a(int i2) {
            Handler handler = BaseTransientBottomBar.f30004j;
            handler.sendMessage(handler.obtainMessage(1, i2, 0, BaseTransientBottomBar.this));
        }

        public void show() {
            Handler handler = BaseTransientBottomBar.f30004j;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    };

    public static abstract class BaseCallback<B> {
        public void a(B b2, int i2) {
        }

        public void b(B b2) {
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: k  reason: collision with root package name */
        private final BehaviorDelegate f30031k = new BehaviorDelegate(this);

        /* access modifiers changed from: private */
        public void O(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f30031k.c(baseTransientBottomBar);
        }

        public boolean D(View view) {
            return this.f30031k.a(view);
        }

        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f30031k.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    public static class BehaviorDelegate {

        /* renamed from: a  reason: collision with root package name */
        private SnackbarManager.Callback f30032a;

        public BehaviorDelegate(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.L(0.1f);
            swipeDismissBehavior.J(0.6f);
            swipeDismissBehavior.M(0);
        }

        public boolean a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    SnackbarManager.c().k(this.f30032a);
                }
            } else if (coordinatorLayout.B(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                SnackbarManager.c().j(this.f30032a);
            }
        }

        public void c(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f30032a = baseTransientBottomBar.f30015i;
        }
    }

    protected interface OnAttachStateChangeListener {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    protected interface OnLayoutChangeListener {
        void a(View view, int i2, int i3, int i4, int i5);
    }

    protected static class SnackbarBaseLayout extends FrameLayout {

        /* renamed from: b  reason: collision with root package name */
        private final AccessibilityManager f30033b;

        /* renamed from: c  reason: collision with root package name */
        private final AccessibilityManagerCompat.TouchExplorationStateChangeListener f30034c;

        /* renamed from: d  reason: collision with root package name */
        private OnLayoutChangeListener f30035d;

        /* renamed from: e  reason: collision with root package name */
        private OnAttachStateChangeListener f30036e;

        protected SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.I2);
            int i2 = R$styleable.K2;
            if (obtainStyledAttributes.hasValue(i2)) {
                ViewCompat.z0(this, (float) obtainStyledAttributes.getDimensionPixelSize(i2, 0));
            }
            obtainStyledAttributes.recycle();
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            this.f30033b = accessibilityManager;
            AnonymousClass1 r4 = new AccessibilityManagerCompat.TouchExplorationStateChangeListener() {
                public void onTouchExplorationStateChanged(boolean z2) {
                    SnackbarBaseLayout.this.setClickableOrFocusableBasedOnAccessibility(z2);
                }
            };
            this.f30034c = r4;
            AccessibilityManagerCompat.a(accessibilityManager, r4);
            setClickableOrFocusableBasedOnAccessibility(accessibilityManager.isTouchExplorationEnabled());
        }

        /* access modifiers changed from: private */
        public void setClickableOrFocusableBasedOnAccessibility(boolean z2) {
            setClickable(!z2);
            setFocusable(z2);
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            OnAttachStateChangeListener onAttachStateChangeListener = this.f30036e;
            if (onAttachStateChangeListener != null) {
                onAttachStateChangeListener.onViewAttachedToWindow(this);
            }
            ViewCompat.o0(this);
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            OnAttachStateChangeListener onAttachStateChangeListener = this.f30036e;
            if (onAttachStateChangeListener != null) {
                onAttachStateChangeListener.onViewDetachedFromWindow(this);
            }
            AccessibilityManagerCompat.b(this.f30033b, this.f30034c);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
            super.onLayout(z2, i2, i3, i4, i5);
            OnLayoutChangeListener onLayoutChangeListener = this.f30035d;
            if (onLayoutChangeListener != null) {
                onLayoutChangeListener.a(this, i2, i3, i4, i5);
            }
        }

        /* access modifiers changed from: package-private */
        public void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
            this.f30036e = onAttachStateChangeListener;
        }

        /* access modifiers changed from: package-private */
        public void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
            this.f30035d = onLayoutChangeListener;
        }
    }

    protected BaseTransientBottomBar(ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (contentViewCallback != null) {
            this.f30007a = viewGroup;
            this.f30010d = contentViewCallback;
            Context context = viewGroup.getContext();
            this.f30008b = context;
            ThemeEnforcement.a(context);
            SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context).inflate(i(), viewGroup, false);
            this.f30009c = snackbarBaseLayout;
            snackbarBaseLayout.addView(view);
            ViewCompat.t0(snackbarBaseLayout, 1);
            ViewCompat.C0(snackbarBaseLayout, 1);
            ViewCompat.A0(snackbarBaseLayout, true);
            ViewCompat.G0(snackbarBaseLayout, new OnApplyWindowInsetsListener() {
                public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.h());
                    return windowInsetsCompat;
                }
            });
            ViewCompat.r0(snackbarBaseLayout, new AccessibilityDelegateCompat() {
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.a(1048576);
                    accessibilityNodeInfoCompat.i0(true);
                }

                public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
                    if (i2 != 1048576) {
                        return super.performAccessibilityAction(view, i2, bundle);
                    }
                    BaseTransientBottomBar.this.e();
                    return true;
                }
            });
            this.f30014h = (AccessibilityManager) context.getSystemService("accessibility");
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    private void d(final int i2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{0, j()});
        valueAnimator.setInterpolator(AnimationUtils.f29396b);
        valueAnimator.setDuration(250);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.o(i2);
            }

            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.f30010d.b(0, RotationOptions.ROTATE_180);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            /* renamed from: a  reason: collision with root package name */
            private int f30018a = 0;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.f30005k) {
                    ViewCompat.c0(BaseTransientBottomBar.this.f30009c, intValue - this.f30018a);
                } else {
                    BaseTransientBottomBar.this.f30009c.setTranslationY((float) intValue);
                }
                this.f30018a = intValue;
            }
        });
        valueAnimator.start();
    }

    private int j() {
        int height = this.f30009c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f30009c.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return height;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int j2 = j();
        if (f30005k) {
            ViewCompat.c0(this.f30009c, j2);
        } else {
            this.f30009c.setTranslationY((float) j2);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{j2, 0});
        valueAnimator.setInterpolator(AnimationUtils.f29396b);
        valueAnimator.setDuration(250);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.p();
            }

            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.f30010d.a(70, RotationOptions.ROTATE_180);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(j2) {

            /* renamed from: a  reason: collision with root package name */
            private int f30028a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f30029b;

            {
                this.f30029b = r2;
                this.f30028a = r2;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.f30005k) {
                    ViewCompat.c0(BaseTransientBottomBar.this.f30009c, intValue - this.f30028a);
                } else {
                    BaseTransientBottomBar.this.f30009c.setTranslationY((float) intValue);
                }
                this.f30028a = intValue;
            }
        });
        valueAnimator.start();
    }

    public void e() {
        f(3);
    }

    /* access modifiers changed from: protected */
    public void f(int i2) {
        SnackbarManager.c().b(this.f30015i, i2);
    }

    public int g() {
        return this.f30011e;
    }

    /* access modifiers changed from: protected */
    public SwipeDismissBehavior<? extends View> h() {
        return new Behavior();
    }

    /* access modifiers changed from: protected */
    public int i() {
        return l() ? R$layout.mtrl_layout_snackbar : R$layout.design_layout_snackbar;
    }

    public View k() {
        return this.f30009c;
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        TypedArray obtainStyledAttributes = this.f30008b.obtainStyledAttributes(f30006l);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void m(int i2) {
        if (!r() || this.f30009c.getVisibility() != 0) {
            o(i2);
        } else {
            d(i2);
        }
    }

    public boolean n() {
        return SnackbarManager.c().e(this.f30015i);
    }

    /* access modifiers changed from: package-private */
    public void o(int i2) {
        SnackbarManager.c().h(this.f30015i);
        List<BaseCallback<B>> list = this.f30012f;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f30012f.get(size).a(this, i2);
            }
        }
        ViewParent parent = this.f30009c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f30009c);
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        SnackbarManager.c().i(this.f30015i);
        List<BaseCallback<B>> list = this.f30012f;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f30012f.get(size).b(this);
            }
        }
    }

    public B q(int i2) {
        this.f30011e = i2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.f30014h.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList == null || !enabledAccessibilityServiceList.isEmpty()) {
            return false;
        }
        return true;
    }

    public void s() {
        SnackbarManager.c().m(g(), this.f30015i);
    }

    /* access modifiers changed from: package-private */
    public final void t() {
        if (this.f30009c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f30009c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                SwipeDismissBehavior swipeDismissBehavior = this.f30013g;
                if (swipeDismissBehavior == null) {
                    swipeDismissBehavior = h();
                }
                if (swipeDismissBehavior instanceof Behavior) {
                    ((Behavior) swipeDismissBehavior).O(this);
                }
                swipeDismissBehavior.K(new SwipeDismissBehavior.OnDismissListener() {
                    public void a(View view) {
                        view.setVisibility(8);
                        BaseTransientBottomBar.this.f(0);
                    }

                    public void b(int i2) {
                        if (i2 == 0) {
                            SnackbarManager.c().k(BaseTransientBottomBar.this.f30015i);
                        } else if (i2 == 1 || i2 == 2) {
                            SnackbarManager.c().j(BaseTransientBottomBar.this.f30015i);
                        }
                    }
                });
                layoutParams2.o(swipeDismissBehavior);
                layoutParams2.f2245g = 80;
            }
            this.f30007a.addView(this.f30009c);
        }
        this.f30009c.setOnAttachStateChangeListener(new OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View view) {
            }

            public void onViewDetachedFromWindow(View view) {
                if (BaseTransientBottomBar.this.n()) {
                    BaseTransientBottomBar.f30004j.post(new Runnable() {
                        public void run() {
                            BaseTransientBottomBar.this.o(3);
                        }
                    });
                }
            }
        });
        if (!ViewCompat.V(this.f30009c)) {
            this.f30009c.setOnLayoutChangeListener(new OnLayoutChangeListener() {
                public void a(View view, int i2, int i3, int i4, int i5) {
                    BaseTransientBottomBar.this.f30009c.setOnLayoutChangeListener((OnLayoutChangeListener) null);
                    if (BaseTransientBottomBar.this.r()) {
                        BaseTransientBottomBar.this.c();
                    } else {
                        BaseTransientBottomBar.this.p();
                    }
                }
            });
        } else if (r()) {
            c();
        } else {
            p();
        }
    }
}
