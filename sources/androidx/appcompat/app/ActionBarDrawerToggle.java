package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: a  reason: collision with root package name */
    private final Delegate f307a;

    /* renamed from: b  reason: collision with root package name */
    private final DrawerLayout f308b;

    /* renamed from: c  reason: collision with root package name */
    private DrawerArrowDrawable f309c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f310d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f311e;

    /* renamed from: f  reason: collision with root package name */
    boolean f312f;

    /* renamed from: g  reason: collision with root package name */
    private final int f313g;

    /* renamed from: h  reason: collision with root package name */
    private final int f314h;

    /* renamed from: i  reason: collision with root package name */
    View.OnClickListener f315i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f316j;

    public interface Delegate {
        Context a();

        boolean b();

        void c(Drawable drawable, int i2);

        Drawable d();

        void e(int i2);
    }

    public interface DelegateProvider {
        Delegate getDrawerToggleDelegate();
    }

    private static class FrameworkActionBarDelegate implements Delegate {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f318a;

        static class Api18Impl {
            private Api18Impl() {
            }

            static void a(ActionBar actionBar, int i2) {
                actionBar.setHomeActionContentDescription(i2);
            }

            static void b(ActionBar actionBar, Drawable drawable) {
                actionBar.setHomeAsUpIndicator(drawable);
            }
        }

        FrameworkActionBarDelegate(Activity activity) {
            this.f318a = activity;
        }

        public Context a() {
            ActionBar actionBar = this.f318a.getActionBar();
            if (actionBar != null) {
                return actionBar.getThemedContext();
            }
            return this.f318a;
        }

        public boolean b() {
            ActionBar actionBar = this.f318a.getActionBar();
            if (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) {
                return false;
            }
            return true;
        }

        public void c(Drawable drawable, int i2) {
            ActionBar actionBar = this.f318a.getActionBar();
            if (actionBar != null) {
                Api18Impl.b(actionBar, drawable);
                Api18Impl.a(actionBar, i2);
            }
        }

        public Drawable d() {
            TypedArray obtainStyledAttributes = a().obtainStyledAttributes((AttributeSet) null, new int[]{16843531}, 16843470, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public void e(int i2) {
            ActionBar actionBar = this.f318a.getActionBar();
            if (actionBar != null) {
                Api18Impl.a(actionBar, i2);
            }
        }
    }

    static class ToolbarCompatDelegate implements Delegate {

        /* renamed from: a  reason: collision with root package name */
        final Toolbar f319a;

        /* renamed from: b  reason: collision with root package name */
        final Drawable f320b;

        /* renamed from: c  reason: collision with root package name */
        final CharSequence f321c;

        ToolbarCompatDelegate(Toolbar toolbar) {
            this.f319a = toolbar;
            this.f320b = toolbar.getNavigationIcon();
            this.f321c = toolbar.getNavigationContentDescription();
        }

        public Context a() {
            return this.f319a.getContext();
        }

        public boolean b() {
            return true;
        }

        public void c(Drawable drawable, int i2) {
            this.f319a.setNavigationIcon(drawable);
            e(i2);
        }

        public Drawable d() {
            return this.f320b;
        }

        public void e(int i2) {
            if (i2 == 0) {
                this.f319a.setNavigationContentDescription(this.f321c);
            } else {
                this.f319a.setNavigationContentDescription(i2);
            }
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int i2, int i3) {
        this(activity, toolbar, drawerLayout, (DrawerArrowDrawable) null, i2, i3);
    }

    private void d(float f2) {
        if (f2 == 1.0f) {
            this.f309c.g(true);
        } else if (f2 == 0.0f) {
            this.f309c.g(false);
        }
        this.f309c.e(f2);
    }

    /* access modifiers changed from: package-private */
    public Drawable a() {
        return this.f307a.d();
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        this.f307a.e(i2);
    }

    /* access modifiers changed from: package-private */
    public void c(Drawable drawable, int i2) {
        if (!this.f316j && !this.f307a.b()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.f316j = true;
        }
        this.f307a.c(drawable, i2);
    }

    public void e() {
        int i2;
        if (this.f308b.isDrawerOpen(8388611)) {
            d(1.0f);
        } else {
            d(0.0f);
        }
        if (this.f312f) {
            DrawerArrowDrawable drawerArrowDrawable = this.f309c;
            if (this.f308b.isDrawerOpen(8388611)) {
                i2 = this.f314h;
            } else {
                i2 = this.f313g;
            }
            c(drawerArrowDrawable, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        int drawerLockMode = this.f308b.getDrawerLockMode(8388611);
        if (this.f308b.isDrawerVisible(8388611) && drawerLockMode != 2) {
            this.f308b.closeDrawer(8388611);
        } else if (drawerLockMode != 1) {
            this.f308b.openDrawer(8388611);
        }
    }

    public void onDrawerClosed(View view) {
        d(0.0f);
        if (this.f312f) {
            b(this.f313g);
        }
    }

    public void onDrawerOpened(View view) {
        d(1.0f);
        if (this.f312f) {
            b(this.f314h);
        }
    }

    public void onDrawerSlide(View view, float f2) {
        if (this.f310d) {
            d(Math.min(1.0f, Math.max(0.0f, f2)));
        } else {
            d(0.0f);
        }
    }

    public void onDrawerStateChanged(int i2) {
    }

    ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, DrawerArrowDrawable drawerArrowDrawable, int i2, int i3) {
        this.f310d = true;
        this.f312f = true;
        this.f316j = false;
        if (toolbar != null) {
            this.f307a = new ToolbarCompatDelegate(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ActionBarDrawerToggle actionBarDrawerToggle = ActionBarDrawerToggle.this;
                    if (actionBarDrawerToggle.f312f) {
                        actionBarDrawerToggle.f();
                        return;
                    }
                    View.OnClickListener onClickListener = actionBarDrawerToggle.f315i;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            });
        } else if (activity instanceof DelegateProvider) {
            this.f307a = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.f307a = new FrameworkActionBarDelegate(activity);
        }
        this.f308b = drawerLayout;
        this.f313g = i2;
        this.f314h = i3;
        if (drawerArrowDrawable == null) {
            this.f309c = new DrawerArrowDrawable(this.f307a.a());
        } else {
            this.f309c = drawerArrowDrawable;
        }
        this.f311e = a();
    }
}
