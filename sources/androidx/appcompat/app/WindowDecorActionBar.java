package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    private static final Interpolator E = new AccelerateInterpolator();
    private static final Interpolator F = new DecelerateInterpolator();
    boolean A;
    final ViewPropertyAnimatorListener B = new ViewPropertyAnimatorListenerAdapter() {
        public void b(View view) {
            View view2;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.f555t && (view2 = windowDecorActionBar.f543h) != null) {
                view2.setTranslationY(0.0f);
                WindowDecorActionBar.this.f540e.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.f540e.setVisibility(8);
            WindowDecorActionBar.this.f540e.setTransitioning(false);
            WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
            windowDecorActionBar2.f560y = null;
            windowDecorActionBar2.G();
            ActionBarOverlayLayout actionBarOverlayLayout = WindowDecorActionBar.this.f539d;
            if (actionBarOverlayLayout != null) {
                ViewCompat.o0(actionBarOverlayLayout);
            }
        }
    };
    final ViewPropertyAnimatorListener C = new ViewPropertyAnimatorListenerAdapter() {
        public void b(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.f560y = null;
            windowDecorActionBar.f540e.requestLayout();
        }
    };
    final ViewPropertyAnimatorUpdateListener D = new ViewPropertyAnimatorUpdateListener() {
        public void a(View view) {
            ((View) WindowDecorActionBar.this.f540e.getParent()).invalidate();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    Context f536a;

    /* renamed from: b  reason: collision with root package name */
    private Context f537b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f538c;

    /* renamed from: d  reason: collision with root package name */
    ActionBarOverlayLayout f539d;

    /* renamed from: e  reason: collision with root package name */
    ActionBarContainer f540e;

    /* renamed from: f  reason: collision with root package name */
    DecorToolbar f541f;

    /* renamed from: g  reason: collision with root package name */
    ActionBarContextView f542g;

    /* renamed from: h  reason: collision with root package name */
    View f543h;

    /* renamed from: i  reason: collision with root package name */
    ScrollingTabContainerView f544i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<Object> f545j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private int f546k = -1;

    /* renamed from: l  reason: collision with root package name */
    private boolean f547l;

    /* renamed from: m  reason: collision with root package name */
    ActionModeImpl f548m;

    /* renamed from: n  reason: collision with root package name */
    ActionMode f549n;

    /* renamed from: o  reason: collision with root package name */
    ActionMode.Callback f550o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f551p;

    /* renamed from: q  reason: collision with root package name */
    private ArrayList<ActionBar.OnMenuVisibilityListener> f552q = new ArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    private boolean f553r;

    /* renamed from: s  reason: collision with root package name */
    private int f554s = 0;

    /* renamed from: t  reason: collision with root package name */
    boolean f555t = true;

    /* renamed from: u  reason: collision with root package name */
    boolean f556u;

    /* renamed from: v  reason: collision with root package name */
    boolean f557v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f558w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f559x = true;

    /* renamed from: y  reason: collision with root package name */
    ViewPropertyAnimatorCompatSet f560y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f561z;

    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {

        /* renamed from: d  reason: collision with root package name */
        private final Context f565d;

        /* renamed from: e  reason: collision with root package name */
        private final MenuBuilder f566e;

        /* renamed from: f  reason: collision with root package name */
        private ActionMode.Callback f567f;

        /* renamed from: g  reason: collision with root package name */
        private WeakReference<View> f568g;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.f565d = context;
            this.f567f = callback;
            MenuBuilder W = new MenuBuilder(context).W(1);
            this.f566e = W;
            W.V(this);
        }

        public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
            ActionMode.Callback callback = this.f567f;
            if (callback != null) {
                return callback.c(this, menuItem);
            }
            return false;
        }

        public void b(MenuBuilder menuBuilder) {
            if (this.f567f != null) {
                k();
                WindowDecorActionBar.this.f542g.l();
            }
        }

        public void c() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.f548m == this) {
                if (!WindowDecorActionBar.F(windowDecorActionBar.f556u, windowDecorActionBar.f557v, false)) {
                    WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
                    windowDecorActionBar2.f549n = this;
                    windowDecorActionBar2.f550o = this.f567f;
                } else {
                    this.f567f.a(this);
                }
                this.f567f = null;
                WindowDecorActionBar.this.E(false);
                WindowDecorActionBar.this.f542g.g();
                WindowDecorActionBar windowDecorActionBar3 = WindowDecorActionBar.this;
                windowDecorActionBar3.f539d.setHideOnContentScrollEnabled(windowDecorActionBar3.A);
                WindowDecorActionBar.this.f548m = null;
            }
        }

        public View d() {
            WeakReference<View> weakReference = this.f568g;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public Menu e() {
            return this.f566e;
        }

        public MenuInflater f() {
            return new SupportMenuInflater(this.f565d);
        }

        public CharSequence g() {
            return WindowDecorActionBar.this.f542g.getSubtitle();
        }

        public CharSequence i() {
            return WindowDecorActionBar.this.f542g.getTitle();
        }

        public void k() {
            if (WindowDecorActionBar.this.f548m == this) {
                this.f566e.h0();
                try {
                    this.f567f.d(this, this.f566e);
                } finally {
                    this.f566e.g0();
                }
            }
        }

        public boolean l() {
            return WindowDecorActionBar.this.f542g.j();
        }

        public void m(View view) {
            WindowDecorActionBar.this.f542g.setCustomView(view);
            this.f568g = new WeakReference<>(view);
        }

        public void n(int i2) {
            o(WindowDecorActionBar.this.f536a.getResources().getString(i2));
        }

        public void o(CharSequence charSequence) {
            WindowDecorActionBar.this.f542g.setSubtitle(charSequence);
        }

        public void q(int i2) {
            r(WindowDecorActionBar.this.f536a.getResources().getString(i2));
        }

        public void r(CharSequence charSequence) {
            WindowDecorActionBar.this.f542g.setTitle(charSequence);
        }

        public void s(boolean z2) {
            super.s(z2);
            WindowDecorActionBar.this.f542g.setTitleOptional(z2);
        }

        public boolean t() {
            this.f566e.h0();
            try {
                return this.f567f.b(this, this.f566e);
            } finally {
                this.f566e.g0();
            }
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z2) {
        this.f538c = activity;
        View decorView = activity.getWindow().getDecorView();
        M(decorView);
        if (!z2) {
            this.f543h = decorView.findViewById(16908290);
        }
    }

    static boolean F(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return !z2 && !z3;
    }

    private DecorToolbar J(View view) {
        String str;
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        if (view != null) {
            str = view.getClass().getSimpleName();
        } else {
            str = "null";
        }
        sb.append(str);
        throw new IllegalStateException(sb.toString());
    }

    private void L() {
        if (this.f558w) {
            this.f558w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f539d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            S(false);
        }
    }

    private void M(View view) {
        boolean z2;
        boolean z3;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.f182q);
        this.f539d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f541f = J(view.findViewById(R$id.f166a));
        this.f542g = (ActionBarContextView) view.findViewById(R$id.f171f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.f168c);
        this.f540e = actionBarContainer;
        DecorToolbar decorToolbar = this.f541f;
        if (decorToolbar == null || this.f542g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f536a = decorToolbar.getContext();
        if ((this.f541f.y() & 4) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.f547l = true;
        }
        ActionBarPolicy b2 = ActionBarPolicy.b(this.f536a);
        if (b2.a() || z2) {
            z3 = true;
        } else {
            z3 = false;
        }
        y(z3);
        O(b2.g());
        TypedArray obtainStyledAttributes = this.f536a.obtainStyledAttributes((AttributeSet) null, R$styleable.f235a, R$attr.f92c, 0);
        if (obtainStyledAttributes.getBoolean(R$styleable.f265k, false)) {
            P(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f259i, 0);
        if (dimensionPixelSize != 0) {
            N((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void O(boolean z2) {
        boolean z3;
        boolean z4;
        this.f553r = z2;
        if (!z2) {
            this.f541f.t((ScrollingTabContainerView) null);
            this.f540e.setTabContainer(this.f544i);
        } else {
            this.f540e.setTabContainer((ScrollingTabContainerView) null);
            this.f541f.t(this.f544i);
        }
        boolean z5 = true;
        if (K() == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        ScrollingTabContainerView scrollingTabContainerView = this.f544i;
        if (scrollingTabContainerView != null) {
            if (z3) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f539d;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.o0(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        DecorToolbar decorToolbar = this.f541f;
        if (this.f553r || !z3) {
            z4 = false;
        } else {
            z4 = true;
        }
        decorToolbar.r(z4);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f539d;
        if (this.f553r || !z3) {
            z5 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z5);
    }

    private boolean Q() {
        return ViewCompat.V(this.f540e);
    }

    private void R() {
        if (!this.f558w) {
            this.f558w = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f539d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            S(false);
        }
    }

    private void S(boolean z2) {
        if (F(this.f556u, this.f557v, this.f558w)) {
            if (!this.f559x) {
                this.f559x = true;
                I(z2);
            }
        } else if (this.f559x) {
            this.f559x = false;
            H(z2);
        }
    }

    public void A(CharSequence charSequence) {
        this.f541f.j(charSequence);
    }

    public void B(CharSequence charSequence) {
        this.f541f.setTitle(charSequence);
    }

    public void C(CharSequence charSequence) {
        this.f541f.setWindowTitle(charSequence);
    }

    public ActionMode D(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.f548m;
        if (actionModeImpl != null) {
            actionModeImpl.c();
        }
        this.f539d.setHideOnContentScrollEnabled(false);
        this.f542g.k();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.f542g.getContext(), callback);
        if (!actionModeImpl2.t()) {
            return null;
        }
        this.f548m = actionModeImpl2;
        actionModeImpl2.k();
        this.f542g.h(actionModeImpl2);
        E(true);
        return actionModeImpl2;
    }

    public void E(boolean z2) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        if (z2) {
            R();
        } else {
            L();
        }
        if (Q()) {
            if (z2) {
                viewPropertyAnimatorCompat = this.f541f.m(4, 100);
                viewPropertyAnimatorCompat2 = this.f542g.f(0, 200);
            } else {
                viewPropertyAnimatorCompat2 = this.f541f.m(0, 200);
                viewPropertyAnimatorCompat = this.f542g.f(8, 100);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.d(viewPropertyAnimatorCompat, viewPropertyAnimatorCompat2);
            viewPropertyAnimatorCompatSet.h();
        } else if (z2) {
            this.f541f.x(4);
            this.f542g.setVisibility(0);
        } else {
            this.f541f.x(0);
            this.f542g.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void G() {
        ActionMode.Callback callback = this.f550o;
        if (callback != null) {
            callback.a(this.f549n);
            this.f549n = null;
            this.f550o = null;
        }
    }

    public void H(boolean z2) {
        View view;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f560y;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        if (this.f554s != 0 || (!this.f561z && !z2)) {
            this.B.b((View) null);
            return;
        }
        this.f540e.setAlpha(1.0f);
        this.f540e.setTransitioning(true);
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
        float f2 = (float) (-this.f540e.getHeight());
        if (z2) {
            int[] iArr = {0, 0};
            this.f540e.getLocationInWindow(iArr);
            f2 -= (float) iArr[1];
        }
        ViewPropertyAnimatorCompat m2 = ViewCompat.d(this.f540e).m(f2);
        m2.k(this.D);
        viewPropertyAnimatorCompatSet2.c(m2);
        if (this.f555t && (view = this.f543h) != null) {
            viewPropertyAnimatorCompatSet2.c(ViewCompat.d(view).m(f2));
        }
        viewPropertyAnimatorCompatSet2.f(E);
        viewPropertyAnimatorCompatSet2.e(250);
        viewPropertyAnimatorCompatSet2.g(this.B);
        this.f560y = viewPropertyAnimatorCompatSet2;
        viewPropertyAnimatorCompatSet2.h();
    }

    public void I(boolean z2) {
        View view;
        View view2;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f560y;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        this.f540e.setVisibility(0);
        if (this.f554s != 0 || (!this.f561z && !z2)) {
            this.f540e.setAlpha(1.0f);
            this.f540e.setTranslationY(0.0f);
            if (this.f555t && (view = this.f543h) != null) {
                view.setTranslationY(0.0f);
            }
            this.C.b((View) null);
        } else {
            this.f540e.setTranslationY(0.0f);
            float f2 = (float) (-this.f540e.getHeight());
            if (z2) {
                int[] iArr = {0, 0};
                this.f540e.getLocationInWindow(iArr);
                f2 -= (float) iArr[1];
            }
            this.f540e.setTranslationY(f2);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat m2 = ViewCompat.d(this.f540e).m(0.0f);
            m2.k(this.D);
            viewPropertyAnimatorCompatSet2.c(m2);
            if (this.f555t && (view2 = this.f543h) != null) {
                view2.setTranslationY(f2);
                viewPropertyAnimatorCompatSet2.c(ViewCompat.d(this.f543h).m(0.0f));
            }
            viewPropertyAnimatorCompatSet2.f(F);
            viewPropertyAnimatorCompatSet2.e(250);
            viewPropertyAnimatorCompatSet2.g(this.C);
            this.f560y = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.h();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f539d;
        if (actionBarOverlayLayout != null) {
            ViewCompat.o0(actionBarOverlayLayout);
        }
    }

    public int K() {
        return this.f541f.l();
    }

    public void N(float f2) {
        ViewCompat.z0(this.f540e, f2);
    }

    public void P(boolean z2) {
        if (!z2 || this.f539d.w()) {
            this.A = z2;
            this.f539d.setHideOnContentScrollEnabled(z2);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void a() {
        if (this.f557v) {
            this.f557v = false;
            S(true);
        }
    }

    public void b() {
    }

    public void c(boolean z2) {
        this.f555t = z2;
    }

    public void d() {
        if (!this.f557v) {
            this.f557v = true;
            S(true);
        }
    }

    public void e() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f560y;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
            this.f560y = null;
        }
    }

    public boolean g() {
        DecorToolbar decorToolbar = this.f541f;
        if (decorToolbar == null || !decorToolbar.h()) {
            return false;
        }
        this.f541f.collapseActionView();
        return true;
    }

    public void h(boolean z2) {
        if (z2 != this.f551p) {
            this.f551p = z2;
            int size = this.f552q.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f552q.get(i2).onMenuVisibilityChanged(z2);
            }
        }
    }

    public int i() {
        return this.f541f.y();
    }

    public Context j() {
        if (this.f537b == null) {
            TypedValue typedValue = new TypedValue();
            this.f536a.getTheme().resolveAttribute(R$attr.f96g, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f537b = new ContextThemeWrapper(this.f536a, i2);
            } else {
                this.f537b = this.f536a;
            }
        }
        return this.f537b;
    }

    public void l(Configuration configuration) {
        O(ActionBarPolicy.b(this.f536a).g());
    }

    public boolean n(int i2, KeyEvent keyEvent) {
        Menu e2;
        int i3;
        ActionModeImpl actionModeImpl = this.f548m;
        if (actionModeImpl == null || (e2 = actionModeImpl.e()) == null) {
            return false;
        }
        if (keyEvent != null) {
            i3 = keyEvent.getDeviceId();
        } else {
            i3 = -1;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(i3).getKeyboardType() == 1) {
            z2 = false;
        }
        e2.setQwertyMode(z2);
        return e2.performShortcut(i2, keyEvent, 0);
    }

    public void onWindowVisibilityChanged(int i2) {
        this.f554s = i2;
    }

    public void q(boolean z2) {
        if (!this.f547l) {
            r(z2);
        }
    }

    public void r(boolean z2) {
        s(z2 ? 4 : 0, 4);
    }

    public void s(int i2, int i3) {
        int y2 = this.f541f.y();
        if ((i3 & 4) != 0) {
            this.f547l = true;
        }
        this.f541f.i((i2 & i3) | ((~i3) & y2));
    }

    public void t(boolean z2) {
        s(z2 ? 2 : 0, 2);
    }

    public void u(boolean z2) {
        s(z2 ? 8 : 0, 8);
    }

    public void v(int i2) {
        this.f541f.p(i2);
    }

    public void w(int i2) {
        this.f541f.v(i2);
    }

    public void x(Drawable drawable) {
        this.f541f.A(drawable);
    }

    public void y(boolean z2) {
        this.f541f.o(z2);
    }

    public void z(boolean z2) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.f561z = z2;
        if (!z2 && (viewPropertyAnimatorCompatSet = this.f560y) != null) {
            viewPropertyAnimatorCompatSet.a();
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        M(dialog.getWindow().getDecorView());
    }
}
