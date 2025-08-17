package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.imageutils.JfifUtil;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {

    /* renamed from: k0  reason: collision with root package name */
    private static final SimpleArrayMap<String, Integer> f416k0 = new SimpleArrayMap<>();

    /* renamed from: l0  reason: collision with root package name */
    private static final boolean f417l0 = false;

    /* renamed from: m0  reason: collision with root package name */
    private static final int[] f418m0 = {16842836};

    /* renamed from: n0  reason: collision with root package name */
    private static final boolean f419n0 = (!"robolectric".equals(Build.FINGERPRINT));

    /* renamed from: o0  reason: collision with root package name */
    private static final boolean f420o0 = true;
    private boolean A;
    private boolean B;
    ViewGroup C;
    private TextView D;
    private View E;
    private boolean F;
    private boolean G;
    boolean H;
    boolean I;
    boolean J;
    boolean K;
    boolean L;
    private boolean M;
    private PanelFeatureState[] N;
    private PanelFeatureState O;
    private boolean P;
    private boolean Q;
    private boolean R;
    boolean S;
    private Configuration T;
    private int U;
    private int V;
    private int W;
    private boolean X;
    private AutoNightModeManager Y;
    private AutoNightModeManager Z;

    /* renamed from: a0  reason: collision with root package name */
    boolean f421a0;

    /* renamed from: b0  reason: collision with root package name */
    int f422b0;

    /* renamed from: c0  reason: collision with root package name */
    private final Runnable f423c0;

    /* renamed from: d0  reason: collision with root package name */
    private boolean f424d0;

    /* renamed from: e0  reason: collision with root package name */
    private Rect f425e0;

    /* renamed from: f0  reason: collision with root package name */
    private Rect f426f0;

    /* renamed from: g0  reason: collision with root package name */
    private AppCompatViewInflater f427g0;

    /* renamed from: h0  reason: collision with root package name */
    private LayoutIncludeDetector f428h0;

    /* renamed from: i0  reason: collision with root package name */
    private OnBackInvokedDispatcher f429i0;

    /* renamed from: j0  reason: collision with root package name */
    private OnBackInvokedCallback f430j0;

    /* renamed from: k  reason: collision with root package name */
    final Object f431k;

    /* renamed from: l  reason: collision with root package name */
    final Context f432l;

    /* renamed from: m  reason: collision with root package name */
    Window f433m;

    /* renamed from: n  reason: collision with root package name */
    private AppCompatWindowCallback f434n;

    /* renamed from: o  reason: collision with root package name */
    final AppCompatCallback f435o;

    /* renamed from: p  reason: collision with root package name */
    ActionBar f436p;

    /* renamed from: q  reason: collision with root package name */
    MenuInflater f437q;

    /* renamed from: r  reason: collision with root package name */
    private CharSequence f438r;

    /* renamed from: s  reason: collision with root package name */
    private DecorContentParent f439s;

    /* renamed from: t  reason: collision with root package name */
    private ActionMenuPresenterCallback f440t;

    /* renamed from: u  reason: collision with root package name */
    private PanelMenuPresenterCallback f441u;

    /* renamed from: v  reason: collision with root package name */
    ActionMode f442v;

    /* renamed from: w  reason: collision with root package name */
    ActionBarContextView f443w;

    /* renamed from: x  reason: collision with root package name */
    PopupWindow f444x;

    /* renamed from: y  reason: collision with root package name */
    Runnable f445y;

    /* renamed from: z  reason: collision with root package name */
    ViewPropertyAnimatorCompat f446z;

    private class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        ActionBarDrawableToggleImpl() {
        }

        public Context a() {
            return AppCompatDelegateImpl.this.o0();
        }

        public boolean b() {
            ActionBar s2 = AppCompatDelegateImpl.this.s();
            if (s2 == null || (s2.i() & 4) == 0) {
                return false;
            }
            return true;
        }

        public void c(Drawable drawable, int i2) {
            ActionBar s2 = AppCompatDelegateImpl.this.s();
            if (s2 != null) {
                s2.x(drawable);
                s2.v(i2);
            }
        }

        public Drawable d() {
            TintTypedArray u2 = TintTypedArray.u(a(), (AttributeSet) null, new int[]{R$attr.F});
            Drawable g2 = u2.g(0);
            u2.w();
            return g2;
        }

        public void e(int i2) {
            ActionBar s2 = AppCompatDelegateImpl.this.s();
            if (s2 != null) {
                s2.v(i2);
            }
        }
    }

    interface ActionBarMenuCallback {
        boolean a(int i2);

        View onCreatePanelView(int i2);
    }

    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        public void a(MenuBuilder menuBuilder, boolean z2) {
            AppCompatDelegateImpl.this.Z(menuBuilder);
        }

        public boolean b(MenuBuilder menuBuilder) {
            Window.Callback v02 = AppCompatDelegateImpl.this.v0();
            if (v02 == null) {
                return true;
            }
            v02.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    class ActionModeCallbackWrapperV9 implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        private ActionMode.Callback f455a;

        public ActionModeCallbackWrapperV9(ActionMode.Callback callback) {
            this.f455a = callback;
        }

        public void a(ActionMode actionMode) {
            this.f455a.a(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.f444x != null) {
                appCompatDelegateImpl.f433m.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f445y);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.f443w != null) {
                appCompatDelegateImpl2.j0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f446z = ViewCompat.d(appCompatDelegateImpl3.f443w).b(0.0f);
                AppCompatDelegateImpl.this.f446z.h(new ViewPropertyAnimatorListenerAdapter() {
                    public void b(View view) {
                        AppCompatDelegateImpl.this.f443w.setVisibility(8);
                        AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                        PopupWindow popupWindow = appCompatDelegateImpl.f444x;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        } else if (appCompatDelegateImpl.f443w.getParent() instanceof View) {
                            ViewCompat.o0((View) AppCompatDelegateImpl.this.f443w.getParent());
                        }
                        AppCompatDelegateImpl.this.f443w.k();
                        AppCompatDelegateImpl.this.f446z.h((ViewPropertyAnimatorListener) null);
                        AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                        appCompatDelegateImpl2.f446z = null;
                        ViewCompat.o0(appCompatDelegateImpl2.C);
                    }
                });
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            AppCompatCallback appCompatCallback = appCompatDelegateImpl4.f435o;
            if (appCompatCallback != null) {
                appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl4.f442v);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.f442v = null;
            ViewCompat.o0(appCompatDelegateImpl5.C);
            AppCompatDelegateImpl.this.c1();
        }

        public boolean b(ActionMode actionMode, Menu menu) {
            return this.f455a.b(actionMode, menu);
        }

        public boolean c(ActionMode actionMode, MenuItem menuItem) {
            return this.f455a.c(actionMode, menuItem);
        }

        public boolean d(ActionMode actionMode, Menu menu) {
            ViewCompat.o0(AppCompatDelegateImpl.this.C);
            return this.f455a.d(actionMode, menu);
        }
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static Context a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        static void b(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i2 = configuration.densityDpi;
            int i3 = configuration2.densityDpi;
            if (i2 != i3) {
                configuration3.densityDpi = i3;
            }
        }

        static void c(Configuration configuration, Locale locale) {
            configuration.setLayoutDirection(locale);
        }

        static void d(Configuration configuration, Locale locale) {
            configuration.setLocale(locale);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList a2 = configuration.getLocales();
            LocaleList a3 = configuration2.getLocales();
            if (!a2.equals(a3)) {
                configuration3.setLocales(a3);
                configuration3.locale = configuration2.locale;
            }
        }

        static LocaleListCompat b(Configuration configuration) {
            return LocaleListCompat.c(configuration.getLocales().toLanguageTags());
        }

        public static void c(LocaleListCompat localeListCompat) {
            LocaleList.setDefault(LocaleList.forLanguageTags(localeListCompat.h()));
        }

        static void d(Configuration configuration, LocaleListCompat localeListCompat) {
            configuration.setLocales(LocaleList.forLanguageTags(localeListCompat.h()));
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode = configuration3.colorMode | (configuration2.colorMode & 3);
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode = configuration3.colorMode | (configuration2.colorMode & 12);
            }
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(Object obj, AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            j jVar = new j(appCompatDelegateImpl);
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, jVar);
            return jVar;
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private class AutoBatteryNightModeManager extends AutoNightModeManager {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f463c;

        AutoBatteryNightModeManager(Context context) {
            super();
            this.f463c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        /* access modifiers changed from: package-private */
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        public int c() {
            return Api21Impl.a(this.f463c) ? 2 : 1;
        }

        public void d() {
            AppCompatDelegateImpl.this.T();
        }
    }

    abstract class AutoNightModeManager {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f465a;

        AutoNightModeManager() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            BroadcastReceiver broadcastReceiver = this.f465a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f432l.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f465a = null;
            }
        }

        /* access modifiers changed from: package-private */
        public abstract IntentFilter b();

        /* access modifiers changed from: package-private */
        public abstract int c();

        /* access modifiers changed from: package-private */
        public abstract void d();

        /* access modifiers changed from: package-private */
        public void e() {
            a();
            IntentFilter b2 = b();
            if (b2 != null && b2.countActions() != 0) {
                if (this.f465a == null) {
                    this.f465a = new BroadcastReceiver() {
                        public void onReceive(Context context, Intent intent) {
                            AutoNightModeManager.this.d();
                        }
                    };
                }
                AppCompatDelegateImpl.this.f432l.registerReceiver(this.f465a, b2);
            }
        }
    }

    private class AutoTimeNightModeManager extends AutoNightModeManager {

        /* renamed from: c  reason: collision with root package name */
        private final TwilightManager f468c;

        AutoTimeNightModeManager(TwilightManager twilightManager) {
            super();
            this.f468c = twilightManager;
        }

        /* access modifiers changed from: package-private */
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        public int c() {
            return this.f468c.d() ? 2 : 1;
        }

        public void d() {
            AppCompatDelegateImpl.this.T();
        }
    }

    private static class ContextThemeWrapperCompatApi17Impl {
        private ContextThemeWrapperCompatApi17Impl() {
        }

        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    private class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        private boolean b(int i2, int i3) {
            return i2 < -5 || i3 < -5 || i2 > getWidth() + 5 || i3 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (AppCompatDelegateImpl.this.h0(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.b0(0);
            return true;
        }

        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(AppCompatResources.b(getContext(), i2));
        }
    }

    protected static final class PanelFeatureState {

        /* renamed from: a  reason: collision with root package name */
        int f471a;

        /* renamed from: b  reason: collision with root package name */
        int f472b;

        /* renamed from: c  reason: collision with root package name */
        int f473c;

        /* renamed from: d  reason: collision with root package name */
        int f474d;

        /* renamed from: e  reason: collision with root package name */
        int f475e;

        /* renamed from: f  reason: collision with root package name */
        int f476f;

        /* renamed from: g  reason: collision with root package name */
        ViewGroup f477g;

        /* renamed from: h  reason: collision with root package name */
        View f478h;

        /* renamed from: i  reason: collision with root package name */
        View f479i;

        /* renamed from: j  reason: collision with root package name */
        MenuBuilder f480j;

        /* renamed from: k  reason: collision with root package name */
        ListMenuPresenter f481k;

        /* renamed from: l  reason: collision with root package name */
        Context f482l;

        /* renamed from: m  reason: collision with root package name */
        boolean f483m;

        /* renamed from: n  reason: collision with root package name */
        boolean f484n;

        /* renamed from: o  reason: collision with root package name */
        boolean f485o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f486p;

        /* renamed from: q  reason: collision with root package name */
        boolean f487q = false;

        /* renamed from: r  reason: collision with root package name */
        boolean f488r;

        /* renamed from: s  reason: collision with root package name */
        Bundle f489s;

        @SuppressLint({"BanParcelableUsage"})
        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.b(parcel, (ClassLoader) null);
                }

                /* renamed from: b */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.b(parcel, classLoader);
                }

                /* renamed from: c */
                public SavedState[] newArray(int i2) {
                    return new SavedState[i2];
                }
            };

            /* renamed from: b  reason: collision with root package name */
            int f490b;

            /* renamed from: c  reason: collision with root package name */
            boolean f491c;

            /* renamed from: d  reason: collision with root package name */
            Bundle f492d;

            SavedState() {
            }

            static SavedState b(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f490b = parcel.readInt();
                boolean z2 = true;
                if (parcel.readInt() != 1) {
                    z2 = false;
                }
                savedState.f491c = z2;
                if (z2) {
                    savedState.f492d = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f490b);
                parcel.writeInt(this.f491c ? 1 : 0);
                if (this.f491c) {
                    parcel.writeBundle(this.f492d);
                }
            }
        }

        PanelFeatureState(int i2) {
            this.f471a = i2;
        }

        /* access modifiers changed from: package-private */
        public MenuView a(MenuPresenter.Callback callback) {
            if (this.f480j == null) {
                return null;
            }
            if (this.f481k == null) {
                ListMenuPresenter listMenuPresenter = new ListMenuPresenter(this.f482l, R$layout.f203l);
                this.f481k = listMenuPresenter;
                listMenuPresenter.c(callback);
                this.f480j.b(this.f481k);
            }
            return this.f481k.l(this.f477g);
        }

        public boolean b() {
            if (this.f478h == null) {
                return false;
            }
            if (this.f479i == null && this.f481k.f().getCount() <= 0) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void c(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.f480j;
            if (menuBuilder != menuBuilder2) {
                if (menuBuilder2 != null) {
                    menuBuilder2.Q(this.f481k);
                }
                this.f480j = menuBuilder;
                if (menuBuilder != null && (listMenuPresenter = this.f481k) != null) {
                    menuBuilder.b(listMenuPresenter);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R$attr.f90a, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            }
            newTheme.resolveAttribute(R$attr.K, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                newTheme.applyStyle(i3, true);
            } else {
                newTheme.applyStyle(R$style.f232d, true);
            }
            androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f482l = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R$styleable.A0);
            this.f472b = obtainStyledAttributes.getResourceId(R$styleable.D0, 0);
            this.f476f = obtainStyledAttributes.getResourceId(R$styleable.C0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    private final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        PanelMenuPresenterCallback() {
        }

        public void a(MenuBuilder menuBuilder, boolean z2) {
            boolean z3;
            MenuBuilder F = menuBuilder.F();
            if (F != menuBuilder) {
                z3 = true;
            } else {
                z3 = false;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z3) {
                menuBuilder = F;
            }
            PanelFeatureState m02 = appCompatDelegateImpl.m0(menuBuilder);
            if (m02 == null) {
                return;
            }
            if (z3) {
                AppCompatDelegateImpl.this.Y(m02.f471a, m02, F);
                AppCompatDelegateImpl.this.c0(m02, true);
                return;
            }
            AppCompatDelegateImpl.this.c0(m02, z2);
        }

        public boolean b(MenuBuilder menuBuilder) {
            Window.Callback v02;
            if (menuBuilder != menuBuilder.F()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.H || (v02 = appCompatDelegateImpl.v0()) == null || AppCompatDelegateImpl.this.S) {
                return true;
            }
            v02.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    AppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this(activity, (Window) null, appCompatCallback, activity);
    }

    private void A0(int i2) {
        this.f422b0 = (1 << i2) | this.f422b0;
        if (!this.f421a0) {
            ViewCompat.j0(this.f433m.getDecorView(), this.f423c0);
            this.f421a0 = true;
        }
    }

    private boolean F0(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState t02 = t0(i2, true);
        if (!t02.f485o) {
            return P0(t02, keyEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean I0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            androidx.appcompat.view.ActionMode r0 = r4.f442v
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r4.t0(r5, r0)
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.DecorContentParent r5 = r4.f439s
            if (r5 == 0) goto L_0x0043
            boolean r5 = r5.a()
            if (r5 == 0) goto L_0x0043
            android.content.Context r5 = r4.f432l
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.DecorContentParent r5 = r4.f439s
            boolean r5 = r5.e()
            if (r5 != 0) goto L_0x003c
            boolean r5 = r4.S
            if (r5 != 0) goto L_0x0062
            boolean r5 = r4.P0(r2, r6)
            if (r5 == 0) goto L_0x0062
            androidx.appcompat.widget.DecorContentParent r5 = r4.f439s
            boolean r0 = r5.c()
            goto L_0x0068
        L_0x003c:
            androidx.appcompat.widget.DecorContentParent r5 = r4.f439s
            boolean r0 = r5.b()
            goto L_0x0068
        L_0x0043:
            boolean r5 = r2.f485o
            if (r5 != 0) goto L_0x0064
            boolean r3 = r2.f484n
            if (r3 == 0) goto L_0x004c
            goto L_0x0064
        L_0x004c:
            boolean r5 = r2.f483m
            if (r5 == 0) goto L_0x0062
            boolean r5 = r2.f488r
            if (r5 == 0) goto L_0x005b
            r2.f483m = r1
            boolean r5 = r4.P0(r2, r6)
            goto L_0x005c
        L_0x005b:
            r5 = 1
        L_0x005c:
            if (r5 == 0) goto L_0x0062
            r4.M0(r2, r6)
            goto L_0x0068
        L_0x0062:
            r0 = 0
            goto L_0x0068
        L_0x0064:
            r4.c0(r2, r0)
            r0 = r5
        L_0x0068:
            if (r0 == 0) goto L_0x0085
            android.content.Context r5 = r4.f432l
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r6 = "audio"
            java.lang.Object r5 = r5.getSystemService(r6)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x007e
            r5.playSoundEffect(r1)
            goto L_0x0085
        L_0x007e:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r6 = "Couldn't get audio manager"
            android.util.Log.w(r5, r6)
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.I0(int, android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void M0(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r13, android.view.KeyEvent r14) {
        /*
            r12 = this;
            boolean r0 = r13.f485o
            if (r0 != 0) goto L_0x00f8
            boolean r0 = r12.S
            if (r0 == 0) goto L_0x000a
            goto L_0x00f8
        L_0x000a:
            int r0 = r13.f471a
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0027
            android.content.Context r0 = r12.f432l
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.screenLayout
            r0 = r0 & 15
            r3 = 4
            if (r0 != r3) goto L_0x0023
            r0 = 1
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            if (r0 == 0) goto L_0x0027
            return
        L_0x0027:
            android.view.Window$Callback r0 = r12.v0()
            if (r0 == 0) goto L_0x003b
            int r3 = r13.f471a
            androidx.appcompat.view.menu.MenuBuilder r4 = r13.f480j
            boolean r0 = r0.onMenuOpened(r3, r4)
            if (r0 != 0) goto L_0x003b
            r12.c0(r13, r2)
            return
        L_0x003b:
            android.content.Context r0 = r12.f432l
            java.lang.String r3 = "window"
            java.lang.Object r0 = r0.getSystemService(r3)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            if (r0 != 0) goto L_0x0048
            return
        L_0x0048:
            boolean r14 = r12.P0(r13, r14)
            if (r14 != 0) goto L_0x004f
            return
        L_0x004f:
            android.view.ViewGroup r14 = r13.f477g
            r3 = -2
            if (r14 == 0) goto L_0x006a
            boolean r4 = r13.f487q
            if (r4 == 0) goto L_0x0059
            goto L_0x006a
        L_0x0059:
            android.view.View r14 = r13.f479i
            if (r14 == 0) goto L_0x00cc
            android.view.ViewGroup$LayoutParams r14 = r14.getLayoutParams()
            if (r14 == 0) goto L_0x00cc
            int r14 = r14.width
            r4 = -1
            if (r14 != r4) goto L_0x00cc
            r5 = -1
            goto L_0x00cd
        L_0x006a:
            if (r14 != 0) goto L_0x0077
            boolean r14 = r12.y0(r13)
            if (r14 == 0) goto L_0x0076
            android.view.ViewGroup r14 = r13.f477g
            if (r14 != 0) goto L_0x0086
        L_0x0076:
            return
        L_0x0077:
            boolean r4 = r13.f487q
            if (r4 == 0) goto L_0x0086
            int r14 = r14.getChildCount()
            if (r14 <= 0) goto L_0x0086
            android.view.ViewGroup r14 = r13.f477g
            r14.removeAllViews()
        L_0x0086:
            boolean r14 = r12.x0(r13)
            if (r14 == 0) goto L_0x00f6
            boolean r14 = r13.b()
            if (r14 != 0) goto L_0x0093
            goto L_0x00f6
        L_0x0093:
            android.view.View r14 = r13.f478h
            android.view.ViewGroup$LayoutParams r14 = r14.getLayoutParams()
            if (r14 != 0) goto L_0x00a0
            android.view.ViewGroup$LayoutParams r14 = new android.view.ViewGroup$LayoutParams
            r14.<init>(r3, r3)
        L_0x00a0:
            int r4 = r13.f472b
            android.view.ViewGroup r5 = r13.f477g
            r5.setBackgroundResource(r4)
            android.view.View r4 = r13.f478h
            android.view.ViewParent r4 = r4.getParent()
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x00b8
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            android.view.View r5 = r13.f478h
            r4.removeView(r5)
        L_0x00b8:
            android.view.ViewGroup r4 = r13.f477g
            android.view.View r5 = r13.f478h
            r4.addView(r5, r14)
            android.view.View r14 = r13.f478h
            boolean r14 = r14.hasFocus()
            if (r14 != 0) goto L_0x00cc
            android.view.View r14 = r13.f478h
            r14.requestFocus()
        L_0x00cc:
            r5 = -2
        L_0x00cd:
            r13.f484n = r1
            android.view.WindowManager$LayoutParams r14 = new android.view.WindowManager$LayoutParams
            r6 = -2
            int r7 = r13.f474d
            int r8 = r13.f475e
            r9 = 1002(0x3ea, float:1.404E-42)
            r10 = 8519680(0x820000, float:1.1938615E-38)
            r11 = -3
            r4 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            int r1 = r13.f473c
            r14.gravity = r1
            int r1 = r13.f476f
            r14.windowAnimations = r1
            android.view.ViewGroup r1 = r13.f477g
            r0.addView(r1, r14)
            r13.f485o = r2
            int r13 = r13.f471a
            if (r13 != 0) goto L_0x00f5
            r12.c1()
        L_0x00f5:
            return
        L_0x00f6:
            r13.f487q = r2
        L_0x00f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.M0(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    private boolean O0(PanelFeatureState panelFeatureState, int i2, KeyEvent keyEvent, int i3) {
        MenuBuilder menuBuilder;
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f483m || P0(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.f480j) != null) {
            z2 = menuBuilder.performShortcut(i2, keyEvent, i3);
        }
        if (z2 && (i3 & 1) == 0 && this.f439s == null) {
            c0(panelFeatureState, true);
        }
        return z2;
    }

    private boolean P0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        boolean z2;
        int i2;
        boolean z3;
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        if (this.S) {
            return false;
        }
        if (panelFeatureState.f483m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.O;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            c0(panelFeatureState2, false);
        }
        Window.Callback v02 = v0();
        if (v02 != null) {
            panelFeatureState.f479i = v02.onCreatePanelView(panelFeatureState.f471a);
        }
        int i3 = panelFeatureState.f471a;
        if (i3 == 0 || i3 == 108) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && (decorContentParent3 = this.f439s) != null) {
            decorContentParent3.f();
        }
        if (panelFeatureState.f479i == null && (!z2 || !(N0() instanceof ToolbarActionBar))) {
            MenuBuilder menuBuilder = panelFeatureState.f480j;
            if (menuBuilder == null || panelFeatureState.f488r) {
                if (menuBuilder == null && (!z0(panelFeatureState) || panelFeatureState.f480j == null)) {
                    return false;
                }
                if (z2 && this.f439s != null) {
                    if (this.f440t == null) {
                        this.f440t = new ActionMenuPresenterCallback();
                    }
                    this.f439s.d(panelFeatureState.f480j, this.f440t);
                }
                panelFeatureState.f480j.h0();
                if (!v02.onCreatePanelMenu(panelFeatureState.f471a, panelFeatureState.f480j)) {
                    panelFeatureState.c((MenuBuilder) null);
                    if (z2 && (decorContentParent2 = this.f439s) != null) {
                        decorContentParent2.d((Menu) null, this.f440t);
                    }
                    return false;
                }
                panelFeatureState.f488r = false;
            }
            panelFeatureState.f480j.h0();
            Bundle bundle = panelFeatureState.f489s;
            if (bundle != null) {
                panelFeatureState.f480j.R(bundle);
                panelFeatureState.f489s = null;
            }
            if (!v02.onPreparePanel(0, panelFeatureState.f479i, panelFeatureState.f480j)) {
                if (z2 && (decorContentParent = this.f439s) != null) {
                    decorContentParent.d((Menu) null, this.f440t);
                }
                panelFeatureState.f480j.g0();
                return false;
            }
            if (keyEvent != null) {
                i2 = keyEvent.getDeviceId();
            } else {
                i2 = -1;
            }
            if (KeyCharacterMap.load(i2).getKeyboardType() != 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            panelFeatureState.f486p = z3;
            panelFeatureState.f480j.setQwertyMode(z3);
            panelFeatureState.f480j.g0();
        }
        panelFeatureState.f483m = true;
        panelFeatureState.f484n = false;
        this.O = panelFeatureState;
        return true;
    }

    private void Q0(boolean z2) {
        DecorContentParent decorContentParent = this.f439s;
        if (decorContentParent == null || !decorContentParent.a() || (ViewConfiguration.get(this.f432l).hasPermanentMenuKey() && !this.f439s.g())) {
            PanelFeatureState t02 = t0(0, true);
            t02.f487q = true;
            c0(t02, false);
            M0(t02, (KeyEvent) null);
            return;
        }
        Window.Callback v02 = v0();
        if (this.f439s.e() && z2) {
            this.f439s.b();
            if (!this.S) {
                v02.onPanelClosed(108, t0(0, true).f480j);
            }
        } else if (v02 != null && !this.S) {
            if (this.f421a0 && (this.f422b0 & 1) != 0) {
                this.f433m.getDecorView().removeCallbacks(this.f423c0);
                this.f423c0.run();
            }
            PanelFeatureState t03 = t0(0, true);
            MenuBuilder menuBuilder = t03.f480j;
            if (menuBuilder != null && !t03.f488r && v02.onPreparePanel(0, t03.f479i, menuBuilder)) {
                v02.onMenuOpened(108, t03.f480j);
                this.f439s.c();
            }
        }
    }

    private boolean R(boolean z2) {
        return S(z2, true);
    }

    private int R0(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i2 != 9) {
            return i2;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private boolean S(boolean z2, boolean z3) {
        LocaleListCompat localeListCompat;
        if (this.S) {
            return false;
        }
        int X2 = X();
        int C0 = C0(this.f432l, X2);
        if (Build.VERSION.SDK_INT < 33) {
            localeListCompat = W(this.f432l);
        } else {
            localeListCompat = null;
        }
        if (!z3 && localeListCompat != null) {
            localeListCompat = s0(this.f432l.getResources().getConfiguration());
        }
        boolean b12 = b1(C0, localeListCompat, z2);
        if (X2 == 0) {
            r0(this.f432l).e();
        } else {
            AutoNightModeManager autoNightModeManager = this.Y;
            if (autoNightModeManager != null) {
                autoNightModeManager.a();
            }
        }
        if (X2 == 3) {
            q0(this.f432l).e();
        } else {
            AutoNightModeManager autoNightModeManager2 = this.Z;
            if (autoNightModeManager2 != null) {
                autoNightModeManager2.a();
            }
        }
        return b12;
    }

    private void U() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.C.findViewById(16908290);
        View decorView = this.f433m.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f432l.obtainStyledAttributes(R$styleable.A0);
        obtainStyledAttributes.getValue(R$styleable.M0, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R$styleable.N0, contentFrameLayout.getMinWidthMinor());
        int i2 = R$styleable.K0;
        if (obtainStyledAttributes.hasValue(i2)) {
            obtainStyledAttributes.getValue(i2, contentFrameLayout.getFixedWidthMajor());
        }
        int i3 = R$styleable.L0;
        if (obtainStyledAttributes.hasValue(i3)) {
            obtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedWidthMinor());
        }
        int i4 = R$styleable.I0;
        if (obtainStyledAttributes.hasValue(i4)) {
            obtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedHeightMajor());
        }
        int i5 = R$styleable.J0;
        if (obtainStyledAttributes.hasValue(i5)) {
            obtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void V(Window window) {
        if (this.f433m == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof AppCompatWindowCallback)) {
                AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(callback);
                this.f434n = appCompatWindowCallback;
                window.setCallback(appCompatWindowCallback);
                TintTypedArray u2 = TintTypedArray.u(this.f432l, (AttributeSet) null, f418m0);
                Drawable h2 = u2.h(0);
                if (h2 != null) {
                    window.setBackgroundDrawable(h2);
                }
                u2.w();
                this.f433m = window;
                if (Build.VERSION.SDK_INT >= 33 && this.f429i0 == null) {
                    L((OnBackInvokedDispatcher) null);
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private boolean V0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f433m.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.U((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private int X() {
        int i2 = this.U;
        return i2 != -100 ? i2 : AppCompatDelegate.m();
    }

    private void Y0() {
        if (this.B) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private AppCompatActivity Z0() {
        Context context = this.f432l;
        while (context != null) {
            if (!(context instanceof AppCompatActivity)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (AppCompatActivity) context;
            }
        }
        return null;
    }

    private void a0() {
        AutoNightModeManager autoNightModeManager = this.Y;
        if (autoNightModeManager != null) {
            autoNightModeManager.a();
        }
        AutoNightModeManager autoNightModeManager2 = this.Z;
        if (autoNightModeManager2 != null) {
            autoNightModeManager2.a();
        }
    }

    private void a1(Configuration configuration) {
        Activity activity = (Activity) this.f431k;
        if (activity instanceof LifecycleOwner) {
            if (((LifecycleOwner) activity).getLifecycle().b().a(Lifecycle.State.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else if (this.R && !this.S) {
            activity.onConfigurationChanged(configuration);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b1(int r9, androidx.core.os.LocaleListCompat r10, boolean r11) {
        /*
            r8 = this;
            android.content.Context r1 = r8.f432l
            r4 = 0
            r5 = 0
            r0 = r8
            r2 = r9
            r3 = r10
            android.content.res.Configuration r0 = r0.d0(r1, r2, r3, r4, r5)
            android.content.Context r1 = r8.f432l
            int r1 = r8.p0(r1)
            android.content.res.Configuration r2 = r8.T
            if (r2 != 0) goto L_0x001f
            android.content.Context r2 = r8.f432l
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L_0x001f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            androidx.core.os.LocaleListCompat r2 = r8.s0(r2)
            r5 = 0
            if (r10 != 0) goto L_0x0030
            r0 = r5
            goto L_0x0034
        L_0x0030:
            androidx.core.os.LocaleListCompat r0 = r8.s0(r0)
        L_0x0034:
            r6 = 0
            if (r3 == r4) goto L_0x003a
            r3 = 512(0x200, float:7.175E-43)
            goto L_0x003b
        L_0x003a:
            r3 = 0
        L_0x003b:
            if (r0 == 0) goto L_0x0047
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0047
            r2 = r3 | 4
            r3 = r2 | 8192(0x2000, float:1.14794E-41)
        L_0x0047:
            int r2 = ~r1
            r2 = r2 & r3
            r7 = 1
            if (r2 == 0) goto L_0x0071
            if (r11 == 0) goto L_0x0071
            boolean r11 = r8.Q
            if (r11 == 0) goto L_0x0071
            boolean r11 = f419n0
            if (r11 != 0) goto L_0x005a
            boolean r11 = r8.R
            if (r11 == 0) goto L_0x0071
        L_0x005a:
            java.lang.Object r11 = r8.f431k
            boolean r2 = r11 instanceof android.app.Activity
            if (r2 == 0) goto L_0x0071
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r11 = r11.isChild()
            if (r11 != 0) goto L_0x0071
            java.lang.Object r11 = r8.f431k
            android.app.Activity r11 = (android.app.Activity) r11
            androidx.core.app.ActivityCompat.f(r11)
            r11 = 1
            goto L_0x0072
        L_0x0071:
            r11 = 0
        L_0x0072:
            if (r11 != 0) goto L_0x007f
            if (r3 == 0) goto L_0x007f
            r11 = r3 & r1
            if (r11 != r3) goto L_0x007b
            r6 = 1
        L_0x007b:
            r8.d1(r4, r0, r6, r5)
            goto L_0x0080
        L_0x007f:
            r7 = r11
        L_0x0080:
            if (r7 == 0) goto L_0x009c
            java.lang.Object r11 = r8.f431k
            boolean r1 = r11 instanceof androidx.appcompat.app.AppCompatActivity
            if (r1 == 0) goto L_0x009c
            r1 = r3 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0091
            androidx.appcompat.app.AppCompatActivity r11 = (androidx.appcompat.app.AppCompatActivity) r11
            r11.onNightModeChanged(r9)
        L_0x0091:
            r9 = r3 & 4
            if (r9 == 0) goto L_0x009c
            java.lang.Object r9 = r8.f431k
            androidx.appcompat.app.AppCompatActivity r9 = (androidx.appcompat.app.AppCompatActivity) r9
            r9.onLocalesChanged(r10)
        L_0x009c:
            if (r7 == 0) goto L_0x00b1
            if (r0 == 0) goto L_0x00b1
            android.content.Context r9 = r8.f432l
            android.content.res.Resources r9 = r9.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            androidx.core.os.LocaleListCompat r9 = r8.s0(r9)
            r8.T0(r9)
        L_0x00b1:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b1(int, androidx.core.os.LocaleListCompat, boolean):boolean");
    }

    private Configuration d0(Context context, int i2, LocaleListCompat localeListCompat, Configuration configuration, boolean z2) {
        int i3;
        if (i2 == 1) {
            i3 = 16;
        } else if (i2 == 2) {
            i3 = 32;
        } else if (z2) {
            i3 = 0;
        } else {
            i3 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        if (localeListCompat != null) {
            S0(configuration2, localeListCompat);
        }
        return configuration2;
    }

    private void d1(int i2, LocaleListCompat localeListCompat, boolean z2, Configuration configuration) {
        Resources resources = this.f432l.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & -49);
        if (localeListCompat != null) {
            S0(configuration2, localeListCompat);
        }
        resources.updateConfiguration(configuration2, (DisplayMetrics) null);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            ResourcesFlusher.a(resources);
        }
        int i4 = this.V;
        if (i4 != 0) {
            this.f432l.setTheme(i4);
            if (i3 >= 23) {
                this.f432l.getTheme().applyStyle(this.V, true);
            }
        }
        if (z2 && (this.f431k instanceof Activity)) {
            a1(configuration2);
        }
    }

    private ViewGroup e0() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f432l.obtainStyledAttributes(R$styleable.A0);
        int i2 = R$styleable.F0;
        if (obtainStyledAttributes.hasValue(i2)) {
            if (obtainStyledAttributes.getBoolean(R$styleable.O0, false)) {
                H(1);
            } else if (obtainStyledAttributes.getBoolean(i2, false)) {
                H(108);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.G0, false)) {
                H(109);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.H0, false)) {
                H(10);
            }
            this.K = obtainStyledAttributes.getBoolean(R$styleable.B0, false);
            obtainStyledAttributes.recycle();
            l0();
            this.f433m.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f432l);
            if (this.L) {
                viewGroup = this.J ? (ViewGroup) from.inflate(R$layout.f208q, (ViewGroup) null) : (ViewGroup) from.inflate(R$layout.f207p, (ViewGroup) null);
            } else if (this.K) {
                viewGroup = (ViewGroup) from.inflate(R$layout.f199h, (ViewGroup) null);
                this.I = false;
                this.H = false;
            } else if (this.H) {
                TypedValue typedValue = new TypedValue();
                this.f432l.getTheme().resolveAttribute(R$attr.f95f, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new androidx.appcompat.view.ContextThemeWrapper(this.f432l, typedValue.resourceId);
                } else {
                    context = this.f432l;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R$layout.f209r, (ViewGroup) null);
                DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(R$id.f182q);
                this.f439s = decorContentParent;
                decorContentParent.setWindowCallback(v0());
                if (this.I) {
                    this.f439s.h(109);
                }
                if (this.F) {
                    this.f439s.h(2);
                }
                if (this.G) {
                    this.f439s.h(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                ViewCompat.G0(viewGroup, new OnApplyWindowInsetsListener() {
                    public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                        int k2 = windowInsetsCompat.k();
                        int e12 = AppCompatDelegateImpl.this.e1(windowInsetsCompat, (Rect) null);
                        if (k2 != e12) {
                            windowInsetsCompat = windowInsetsCompat.p(windowInsetsCompat.i(), e12, windowInsetsCompat.j(), windowInsetsCompat.h());
                        }
                        return ViewCompat.d0(view, windowInsetsCompat);
                    }
                });
                if (this.f439s == null) {
                    this.D = (TextView) viewGroup.findViewById(R$id.S);
                }
                ViewUtils.c(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.f167b);
                ViewGroup viewGroup2 = (ViewGroup) this.f433m.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.f433m.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() {
                    public void a() {
                    }

                    public void onDetachedFromWindow() {
                        AppCompatDelegateImpl.this.g0();
                    }
                });
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.H + ", windowActionBarOverlay: " + this.I + ", android:windowIsFloating: " + this.K + ", windowActionModeOverlay: " + this.J + ", windowNoTitle: " + this.L + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void f1(View view) {
        boolean z2;
        int i2;
        if ((ViewCompat.N(view) & 8192) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i2 = ContextCompat.getColor(this.f432l, R$color.f118b);
        } else {
            i2 = ContextCompat.getColor(this.f432l, R$color.f117a);
        }
        view.setBackgroundColor(i2);
    }

    private void k0() {
        if (!this.B) {
            this.C = e0();
            CharSequence u02 = u0();
            if (!TextUtils.isEmpty(u02)) {
                DecorContentParent decorContentParent = this.f439s;
                if (decorContentParent != null) {
                    decorContentParent.setWindowTitle(u02);
                } else if (N0() != null) {
                    N0().C(u02);
                } else {
                    TextView textView = this.D;
                    if (textView != null) {
                        textView.setText(u02);
                    }
                }
            }
            U();
            L0(this.C);
            this.B = true;
            PanelFeatureState t02 = t0(0, false);
            if (this.S) {
                return;
            }
            if (t02 == null || t02.f480j == null) {
                A0(108);
            }
        }
    }

    private void l0() {
        if (this.f433m == null) {
            Object obj = this.f431k;
            if (obj instanceof Activity) {
                V(((Activity) obj).getWindow());
            }
        }
        if (this.f433m == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration n0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (!(configuration2 == null || configuration.diff(configuration2) == 0)) {
            float f2 = configuration.fontScale;
            float f3 = configuration2.fontScale;
            if (f2 != f3) {
                configuration3.fontScale = f3;
            }
            int i2 = configuration.mcc;
            int i3 = configuration2.mcc;
            if (i2 != i3) {
                configuration3.mcc = i3;
            }
            int i4 = configuration.mnc;
            int i5 = configuration2.mnc;
            if (i4 != i5) {
                configuration3.mnc = i5;
            }
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 24) {
                Api24Impl.a(configuration, configuration2, configuration3);
            } else if (!ObjectsCompat.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i7 = configuration.touchscreen;
            int i8 = configuration2.touchscreen;
            if (i7 != i8) {
                configuration3.touchscreen = i8;
            }
            int i9 = configuration.keyboard;
            int i10 = configuration2.keyboard;
            if (i9 != i10) {
                configuration3.keyboard = i10;
            }
            int i11 = configuration.keyboardHidden;
            int i12 = configuration2.keyboardHidden;
            if (i11 != i12) {
                configuration3.keyboardHidden = i12;
            }
            int i13 = configuration.navigation;
            int i14 = configuration2.navigation;
            if (i13 != i14) {
                configuration3.navigation = i14;
            }
            int i15 = configuration.navigationHidden;
            int i16 = configuration2.navigationHidden;
            if (i15 != i16) {
                configuration3.navigationHidden = i16;
            }
            int i17 = configuration.orientation;
            int i18 = configuration2.orientation;
            if (i17 != i18) {
                configuration3.orientation = i18;
            }
            int i19 = configuration.screenLayout & 15;
            int i20 = configuration2.screenLayout;
            if (i19 != (i20 & 15)) {
                configuration3.screenLayout |= i20 & 15;
            }
            int i21 = configuration.screenLayout & JfifUtil.MARKER_SOFn;
            int i22 = configuration2.screenLayout;
            if (i21 != (i22 & JfifUtil.MARKER_SOFn)) {
                configuration3.screenLayout |= i22 & JfifUtil.MARKER_SOFn;
            }
            int i23 = configuration.screenLayout & 48;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 48)) {
                configuration3.screenLayout |= i24 & 48;
            }
            int i25 = configuration.screenLayout & 768;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 768)) {
                configuration3.screenLayout |= i26 & 768;
            }
            if (i6 >= 26) {
                Api26Impl.a(configuration, configuration2, configuration3);
            }
            int i27 = configuration.uiMode & 15;
            int i28 = configuration2.uiMode;
            if (i27 != (i28 & 15)) {
                configuration3.uiMode |= i28 & 15;
            }
            int i29 = configuration.uiMode & 48;
            int i30 = configuration2.uiMode;
            if (i29 != (i30 & 48)) {
                configuration3.uiMode |= i30 & 48;
            }
            int i31 = configuration.screenWidthDp;
            int i32 = configuration2.screenWidthDp;
            if (i31 != i32) {
                configuration3.screenWidthDp = i32;
            }
            int i33 = configuration.screenHeightDp;
            int i34 = configuration2.screenHeightDp;
            if (i33 != i34) {
                configuration3.screenHeightDp = i34;
            }
            int i35 = configuration.smallestScreenWidthDp;
            int i36 = configuration2.smallestScreenWidthDp;
            if (i35 != i36) {
                configuration3.smallestScreenWidthDp = i36;
            }
            Api17Impl.b(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    private int p0(Context context) {
        int i2;
        if (!this.X && (this.f431k instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 29) {
                    i2 = 269221888;
                } else if (i3 >= 24) {
                    i2 = 786432;
                } else {
                    i2 = 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f431k.getClass()), i2);
                if (activityInfo != null) {
                    this.W = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.W = 0;
            }
        }
        this.X = true;
        return this.W;
    }

    private AutoNightModeManager q0(Context context) {
        if (this.Z == null) {
            this.Z = new AutoBatteryNightModeManager(context);
        }
        return this.Z;
    }

    private AutoNightModeManager r0(Context context) {
        if (this.Y == null) {
            this.Y = new AutoTimeNightModeManager(TwilightManager.a(context));
        }
        return this.Y;
    }

    private void w0() {
        k0();
        if (this.H && this.f436p == null) {
            Object obj = this.f431k;
            if (obj instanceof Activity) {
                this.f436p = new WindowDecorActionBar((Activity) this.f431k, this.I);
            } else if (obj instanceof Dialog) {
                this.f436p = new WindowDecorActionBar((Dialog) this.f431k);
            }
            ActionBar actionBar = this.f436p;
            if (actionBar != null) {
                actionBar.q(this.f424d0);
            }
        }
    }

    private boolean x0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f479i;
        if (view != null) {
            panelFeatureState.f478h = view;
            return true;
        } else if (panelFeatureState.f480j == null) {
            return false;
        } else {
            if (this.f441u == null) {
                this.f441u = new PanelMenuPresenterCallback();
            }
            View view2 = (View) panelFeatureState.a(this.f441u);
            panelFeatureState.f478h = view2;
            if (view2 != null) {
                return true;
            }
            return false;
        }
    }

    private boolean y0(PanelFeatureState panelFeatureState) {
        panelFeatureState.d(o0());
        panelFeatureState.f477g = new ListMenuDecorView(panelFeatureState.f482l);
        panelFeatureState.f473c = 81;
        return true;
    }

    private boolean z0(PanelFeatureState panelFeatureState) {
        Resources.Theme theme;
        Context context = this.f432l;
        int i2 = panelFeatureState.f471a;
        if ((i2 == 0 || i2 == 108) && this.f439s != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme2 = context.getTheme();
            theme2.resolveAttribute(R$attr.f95f, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme = context.getResources().newTheme();
                theme.setTo(theme2);
                theme.applyStyle(typedValue.resourceId, true);
                theme.resolveAttribute(R$attr.f96g, typedValue, true);
            } else {
                theme2.resolveAttribute(R$attr.f96g, typedValue, true);
                theme = null;
            }
            if (typedValue.resourceId != 0) {
                if (theme == null) {
                    theme = context.getResources().newTheme();
                    theme.setTo(theme2);
                }
                theme.applyStyle(typedValue.resourceId, true);
            }
            if (theme != null) {
                androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme);
                context = contextThemeWrapper;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.V(this);
        panelFeatureState.c(menuBuilder);
        return true;
    }

    public void A(Bundle bundle) {
        k0();
    }

    public void B() {
        ActionBar s2 = s();
        if (s2 != null) {
            s2.z(true);
        }
    }

    public boolean B0() {
        return this.A;
    }

    public void C(Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    public int C0(Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 != 0) {
                if (!(i2 == 1 || i2 == 2)) {
                    if (i2 == 3) {
                        return q0(context).c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                return r0(context).c();
            } else {
                return -1;
            }
        }
        return i2;
    }

    public void D() {
        S(true, false);
    }

    /* access modifiers changed from: package-private */
    public boolean D0() {
        boolean z2 = this.P;
        this.P = false;
        PanelFeatureState t02 = t0(0, false);
        if (t02 == null || !t02.f485o) {
            ActionMode actionMode = this.f442v;
            if (actionMode != null) {
                actionMode.c();
                return true;
            }
            ActionBar s2 = s();
            if (s2 == null || !s2.g()) {
                return false;
            }
            return true;
        }
        if (!z2) {
            c0(t02, true);
        }
        return true;
    }

    public void E() {
        ActionBar s2 = s();
        if (s2 != null) {
            s2.z(false);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean E0(int i2, KeyEvent keyEvent) {
        boolean z2 = true;
        if (i2 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z2 = false;
            }
            this.P = z2;
        } else if (i2 == 82) {
            F0(0, keyEvent);
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean G0(int i2, KeyEvent keyEvent) {
        ActionBar s2 = s();
        if (s2 != null && s2.n(i2, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.O;
        if (panelFeatureState == null || !O0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.O == null) {
                PanelFeatureState t02 = t0(0, true);
                P0(t02, keyEvent);
                boolean O0 = O0(t02, keyEvent.getKeyCode(), keyEvent, 1);
                t02.f483m = false;
                if (O0) {
                    return true;
                }
            }
            return false;
        }
        PanelFeatureState panelFeatureState2 = this.O;
        if (panelFeatureState2 != null) {
            panelFeatureState2.f484n = true;
        }
        return true;
    }

    public boolean H(int i2) {
        int R0 = R0(i2);
        if (this.L && R0 == 108) {
            return false;
        }
        if (this.H && R0 == 1) {
            this.H = false;
        }
        if (R0 == 1) {
            Y0();
            this.L = true;
            return true;
        } else if (R0 == 2) {
            Y0();
            this.F = true;
            return true;
        } else if (R0 == 5) {
            Y0();
            this.G = true;
            return true;
        } else if (R0 == 10) {
            Y0();
            this.J = true;
            return true;
        } else if (R0 == 108) {
            Y0();
            this.H = true;
            return true;
        } else if (R0 != 109) {
            return this.f433m.requestFeature(R0);
        } else {
            Y0();
            this.I = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean H0(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            if (i2 == 82) {
                I0(0, keyEvent);
                return true;
            }
        } else if (D0()) {
            return true;
        }
        return false;
    }

    public void I(int i2) {
        k0();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f432l).inflate(i2, viewGroup);
        this.f434n.c(this.f433m.getCallback());
    }

    public void J(View view) {
        k0();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f434n.c(this.f433m.getCallback());
    }

    /* access modifiers changed from: package-private */
    public void J0(int i2) {
        ActionBar s2;
        if (i2 == 108 && (s2 = s()) != null) {
            s2.h(true);
        }
    }

    public void K(View view, ViewGroup.LayoutParams layoutParams) {
        k0();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f434n.c(this.f433m.getCallback());
    }

    /* access modifiers changed from: package-private */
    public void K0(int i2) {
        if (i2 == 108) {
            ActionBar s2 = s();
            if (s2 != null) {
                s2.h(false);
            }
        } else if (i2 == 0) {
            PanelFeatureState t02 = t0(i2, true);
            if (t02.f485o) {
                c0(t02, false);
            }
        }
    }

    public void L(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.L(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.f429i0;
        if (!(onBackInvokedDispatcher2 == null || (onBackInvokedCallback = this.f430j0) == null)) {
            Api33Impl.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.f430j0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.f431k;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                this.f429i0 = Api33Impl.a((Activity) this.f431k);
                c1();
            }
        }
        this.f429i0 = onBackInvokedDispatcher;
        c1();
    }

    /* access modifiers changed from: package-private */
    public void L0(ViewGroup viewGroup) {
    }

    public void M(Toolbar toolbar) {
        if (this.f431k instanceof Activity) {
            ActionBar s2 = s();
            if (!(s2 instanceof WindowDecorActionBar)) {
                this.f437q = null;
                if (s2 != null) {
                    s2.m();
                }
                this.f436p = null;
                if (toolbar != null) {
                    ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, u0(), this.f434n);
                    this.f436p = toolbarActionBar;
                    this.f434n.e(toolbarActionBar.f513c);
                    toolbar.setBackInvokedCallbackEnabled(true);
                } else {
                    this.f434n.e((ActionBarMenuCallback) null);
                }
                u();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    public void N(int i2) {
        this.V = i2;
    }

    /* access modifiers changed from: package-private */
    public final ActionBar N0() {
        return this.f436p;
    }

    public final void O(CharSequence charSequence) {
        this.f438r = charSequence;
        DecorContentParent decorContentParent = this.f439s;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
        } else if (N0() != null) {
            N0().C(charSequence);
        } else {
            TextView textView = this.D;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public ActionMode P(ActionMode.Callback callback) {
        AppCompatCallback appCompatCallback;
        if (callback != null) {
            ActionMode actionMode = this.f442v;
            if (actionMode != null) {
                actionMode.c();
            }
            ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = new ActionModeCallbackWrapperV9(callback);
            ActionBar s2 = s();
            if (s2 != null) {
                ActionMode D2 = s2.D(actionModeCallbackWrapperV9);
                this.f442v = D2;
                if (!(D2 == null || (appCompatCallback = this.f435o) == null)) {
                    appCompatCallback.onSupportActionModeStarted(D2);
                }
            }
            if (this.f442v == null) {
                this.f442v = X0(actionModeCallbackWrapperV9);
            }
            c1();
            return this.f442v;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* access modifiers changed from: package-private */
    public void S0(Configuration configuration, LocaleListCompat localeListCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.d(configuration, localeListCompat);
            return;
        }
        Api17Impl.d(configuration, localeListCompat.d(0));
        Api17Impl.c(configuration, localeListCompat.d(0));
    }

    public boolean T() {
        return R(true);
    }

    /* access modifiers changed from: package-private */
    public void T0(LocaleListCompat localeListCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.c(localeListCompat);
        } else {
            Locale.setDefault(localeListCompat.d(0));
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.C;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean U0() {
        /*
            r1 = this;
            boolean r0 = r1.B
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r0 = r1.C
            if (r0 == 0) goto L_0x0010
            boolean r0 = androidx.core.view.ViewCompat.V(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.U0():boolean");
    }

    /* access modifiers changed from: package-private */
    public LocaleListCompat W(Context context) {
        LocaleListCompat r2;
        LocaleListCompat localeListCompat;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33 || (r2 = AppCompatDelegate.r()) == null) {
            return null;
        }
        LocaleListCompat s02 = s0(context.getApplicationContext().getResources().getConfiguration());
        if (i2 >= 24) {
            localeListCompat = LocaleOverlayHelper.b(r2, s02);
        } else if (r2.f()) {
            localeListCompat = LocaleListCompat.e();
        } else {
            localeListCompat = LocaleListCompat.c(r2.d(0).toString());
        }
        if (localeListCompat.f()) {
            return s02;
        }
        return localeListCompat;
    }

    /* access modifiers changed from: package-private */
    public boolean W0() {
        if (this.f429i0 == null) {
            return false;
        }
        PanelFeatureState t02 = t0(0, false);
        if ((t02 == null || !t02.f485o) && this.f442v == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.view.ActionMode X0(androidx.appcompat.view.ActionMode.Callback r8) {
        /*
            r7 = this;
            r7.j0()
            androidx.appcompat.view.ActionMode r0 = r7.f442v
            if (r0 == 0) goto L_0x000a
            r0.c()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.AppCompatCallback r0 = r7.f435o
            r1 = 0
            if (r0 == 0) goto L_0x0023
            boolean r2 = r7.S
            if (r2 != 0) goto L_0x0023
            androidx.appcompat.view.ActionMode r0 = r0.onWindowStartingSupportActionMode(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0024
        L_0x0022:
        L_0x0023:
            r0 = r1
        L_0x0024:
            if (r0 == 0) goto L_0x002a
            r7.f442v = r0
            goto L_0x015c
        L_0x002a:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f443w
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d5
            boolean r0 = r7.K
            if (r0 == 0) goto L_0x00b6
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.f432l
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.R$attr.f95f
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0069
            android.content.Context r5 = r7.f432l
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            androidx.appcompat.view.ContextThemeWrapper r4 = new androidx.appcompat.view.ContextThemeWrapper
            android.content.Context r6 = r7.f432l
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006b
        L_0x0069:
            android.content.Context r4 = r7.f432l
        L_0x006b:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.f443w = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.R$attr.f98i
            r5.<init>(r4, r1, r6)
            r7.f444x = r5
            r6 = 2
            androidx.core.widget.PopupWindowCompat.b(r5, r6)
            android.widget.PopupWindow r5 = r7.f444x
            androidx.appcompat.widget.ActionBarContextView r6 = r7.f443w
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.f444x
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.R$attr.f91b
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f443w
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.f444x
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.AppCompatDelegateImpl$6 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$6
            r0.<init>()
            r7.f445y = r0
            goto L_0x00d5
        L_0x00b6:
            android.view.ViewGroup r0 = r7.C
            int r4 = androidx.appcompat.R$id.f173h
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d5
            android.content.Context r4 = r7.o0()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.f443w = r0
        L_0x00d5:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f443w
            if (r0 == 0) goto L_0x015c
            r7.j0()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f443w
            r0.k()
            androidx.appcompat.view.StandaloneActionMode r0 = new androidx.appcompat.view.StandaloneActionMode
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f443w
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.f443w
            android.widget.PopupWindow r6 = r7.f444x
            if (r6 != 0) goto L_0x00f0
            goto L_0x00f1
        L_0x00f0:
            r3 = 0
        L_0x00f1:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.e()
            boolean r8 = r8.b(r0, r3)
            if (r8 == 0) goto L_0x015a
            r0.k()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f443w
            r8.h(r0)
            r7.f442v = r0
            boolean r8 = r7.U0()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012b
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f443w
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f443w
            androidx.core.view.ViewPropertyAnimatorCompat r8 = androidx.core.view.ViewCompat.d(r8)
            androidx.core.view.ViewPropertyAnimatorCompat r8 = r8.b(r0)
            r7.f446z = r8
            androidx.appcompat.app.AppCompatDelegateImpl$7 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$7
            r0.<init>()
            r8.h(r0)
            goto L_0x014a
        L_0x012b:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f443w
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f443w
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f443w
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x014a
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f443w
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.view.ViewCompat.o0(r8)
        L_0x014a:
            android.widget.PopupWindow r8 = r7.f444x
            if (r8 == 0) goto L_0x015c
            android.view.Window r8 = r7.f433m
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.f445y
            r8.post(r0)
            goto L_0x015c
        L_0x015a:
            r7.f442v = r1
        L_0x015c:
            androidx.appcompat.view.ActionMode r8 = r7.f442v
            if (r8 == 0) goto L_0x0167
            androidx.appcompat.app.AppCompatCallback r0 = r7.f435o
            if (r0 == 0) goto L_0x0167
            r0.onSupportActionModeStarted(r8)
        L_0x0167:
            r7.c1()
            androidx.appcompat.view.ActionMode r8 = r7.f442v
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.X0(androidx.appcompat.view.ActionMode$Callback):androidx.appcompat.view.ActionMode");
    }

    /* access modifiers changed from: package-private */
    public void Y(int i2, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i2 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.N;
                if (i2 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i2];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f480j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f485o) && !this.S) {
            this.f434n.d(this.f433m.getCallback(), i2, menu);
        }
    }

    /* access modifiers changed from: package-private */
    public void Z(MenuBuilder menuBuilder) {
        if (!this.M) {
            this.M = true;
            this.f439s.l();
            Window.Callback v02 = v0();
            if (v02 != null && !this.S) {
                v02.onPanelClosed(108, menuBuilder);
            }
            this.M = false;
        }
    }

    public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState m02;
        Window.Callback v02 = v0();
        if (v02 == null || this.S || (m02 = m0(menuBuilder.F())) == null) {
            return false;
        }
        return v02.onMenuItemSelected(m02.f471a, menuItem);
    }

    public void b(MenuBuilder menuBuilder) {
        Q0(true);
    }

    /* access modifiers changed from: package-private */
    public void b0(int i2) {
        c0(t0(i2, true), true);
    }

    /* access modifiers changed from: package-private */
    public void c0(PanelFeatureState panelFeatureState, boolean z2) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (!z2 || panelFeatureState.f471a != 0 || (decorContentParent = this.f439s) == null || !decorContentParent.e()) {
            WindowManager windowManager = (WindowManager) this.f432l.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.f485o || (viewGroup = panelFeatureState.f477g) == null)) {
                windowManager.removeView(viewGroup);
                if (z2) {
                    Y(panelFeatureState.f471a, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.f483m = false;
            panelFeatureState.f484n = false;
            panelFeatureState.f485o = false;
            panelFeatureState.f478h = null;
            panelFeatureState.f487q = true;
            if (this.O == panelFeatureState) {
                this.O = null;
            }
            if (panelFeatureState.f471a == 0) {
                c1();
                return;
            }
            return;
        }
        Z(panelFeatureState.f480j);
    }

    /* access modifiers changed from: package-private */
    public void c1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean W0 = W0();
            if (W0 && this.f430j0 == null) {
                this.f430j0 = Api33Impl.b(this.f429i0, this);
            } else if (!W0 && (onBackInvokedCallback = this.f430j0) != null) {
                Api33Impl.c(this.f429i0, onBackInvokedCallback);
            }
        }
    }

    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        k0();
        ((ViewGroup) this.C.findViewById(16908290)).addView(view, layoutParams);
        this.f434n.c(this.f433m.getCallback());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00bf, code lost:
        r11 = (android.view.ViewGroup.MarginLayoutParams) r11.getLayoutParams();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int e1(androidx.core.view.WindowInsetsCompat r11, android.graphics.Rect r12) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L_0x0008
            int r1 = r11.k()
            goto L_0x000e
        L_0x0008:
            if (r12 == 0) goto L_0x000d
            int r1 = r12.top
            goto L_0x000e
        L_0x000d:
            r1 = 0
        L_0x000e:
            androidx.appcompat.widget.ActionBarContextView r2 = r10.f443w
            r3 = 8
            if (r2 == 0) goto L_0x010d
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            boolean r2 = r2 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r2 == 0) goto L_0x010d
            androidx.appcompat.widget.ActionBarContextView r2 = r10.f443w
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
            androidx.appcompat.widget.ActionBarContextView r4 = r10.f443w
            boolean r4 = r4.isShown()
            r5 = 1
            if (r4 == 0) goto L_0x00fb
            android.graphics.Rect r4 = r10.f425e0
            if (r4 != 0) goto L_0x003f
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            r10.f425e0 = r4
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            r10.f426f0 = r4
        L_0x003f:
            android.graphics.Rect r4 = r10.f425e0
            android.graphics.Rect r6 = r10.f426f0
            if (r11 != 0) goto L_0x0049
            r4.set(r12)
            goto L_0x005c
        L_0x0049:
            int r12 = r11.i()
            int r7 = r11.k()
            int r8 = r11.j()
            int r11 = r11.h()
            r4.set(r12, r7, r8, r11)
        L_0x005c:
            android.view.ViewGroup r11 = r10.C
            androidx.appcompat.widget.ViewUtils.a(r11, r4, r6)
            int r11 = r4.top
            int r12 = r4.left
            int r4 = r4.right
            android.view.ViewGroup r6 = r10.C
            androidx.core.view.WindowInsetsCompat r6 = androidx.core.view.ViewCompat.K(r6)
            if (r6 != 0) goto L_0x0071
            r7 = 0
            goto L_0x0075
        L_0x0071:
            int r7 = r6.i()
        L_0x0075:
            if (r6 != 0) goto L_0x0079
            r6 = 0
            goto L_0x007d
        L_0x0079:
            int r6 = r6.j()
        L_0x007d:
            int r8 = r2.topMargin
            if (r8 != r11) goto L_0x008c
            int r8 = r2.leftMargin
            if (r8 != r12) goto L_0x008c
            int r8 = r2.rightMargin
            if (r8 == r4) goto L_0x008a
            goto L_0x008c
        L_0x008a:
            r12 = 0
            goto L_0x0093
        L_0x008c:
            r2.topMargin = r11
            r2.leftMargin = r12
            r2.rightMargin = r4
            r12 = 1
        L_0x0093:
            if (r11 <= 0) goto L_0x00bb
            android.view.View r11 = r10.E
            if (r11 != 0) goto L_0x00bb
            android.view.View r11 = new android.view.View
            android.content.Context r4 = r10.f432l
            r11.<init>(r4)
            r10.E = r11
            r11.setVisibility(r3)
            android.widget.FrameLayout$LayoutParams r11 = new android.widget.FrameLayout$LayoutParams
            int r4 = r2.topMargin
            r8 = 51
            r9 = -1
            r11.<init>(r9, r4, r8)
            r11.leftMargin = r7
            r11.rightMargin = r6
            android.view.ViewGroup r4 = r10.C
            android.view.View r6 = r10.E
            r4.addView(r6, r9, r11)
            goto L_0x00de
        L_0x00bb:
            android.view.View r11 = r10.E
            if (r11 == 0) goto L_0x00de
            android.view.ViewGroup$LayoutParams r11 = r11.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r11 = (android.view.ViewGroup.MarginLayoutParams) r11
            int r4 = r11.height
            int r8 = r2.topMargin
            if (r4 != r8) goto L_0x00d3
            int r4 = r11.leftMargin
            if (r4 != r7) goto L_0x00d3
            int r4 = r11.rightMargin
            if (r4 == r6) goto L_0x00de
        L_0x00d3:
            r11.height = r8
            r11.leftMargin = r7
            r11.rightMargin = r6
            android.view.View r4 = r10.E
            r4.setLayoutParams(r11)
        L_0x00de:
            android.view.View r11 = r10.E
            if (r11 == 0) goto L_0x00e3
            goto L_0x00e4
        L_0x00e3:
            r5 = 0
        L_0x00e4:
            if (r5 == 0) goto L_0x00f1
            int r11 = r11.getVisibility()
            if (r11 == 0) goto L_0x00f1
            android.view.View r11 = r10.E
            r10.f1(r11)
        L_0x00f1:
            boolean r11 = r10.J
            if (r11 != 0) goto L_0x00f8
            if (r5 == 0) goto L_0x00f8
            r1 = 0
        L_0x00f8:
            r11 = r5
            r5 = r12
            goto L_0x0105
        L_0x00fb:
            int r11 = r2.topMargin
            if (r11 == 0) goto L_0x0103
            r2.topMargin = r0
            r11 = 0
            goto L_0x0105
        L_0x0103:
            r11 = 0
            r5 = 0
        L_0x0105:
            if (r5 == 0) goto L_0x010e
            androidx.appcompat.widget.ActionBarContextView r12 = r10.f443w
            r12.setLayoutParams(r2)
            goto L_0x010e
        L_0x010d:
            r11 = 0
        L_0x010e:
            android.view.View r12 = r10.E
            if (r12 == 0) goto L_0x011a
            if (r11 == 0) goto L_0x0115
            goto L_0x0117
        L_0x0115:
            r0 = 8
        L_0x0117:
            r12.setVisibility(r0)
        L_0x011a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.e1(androidx.core.view.WindowInsetsCompat, android.graphics.Rect):int");
    }

    public View f0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2;
        boolean z3 = false;
        if (this.f427g0 == null) {
            String string = this.f432l.obtainStyledAttributes(R$styleable.A0).getString(R$styleable.E0);
            if (string == null) {
                this.f427g0 = new AppCompatViewInflater();
            } else {
                try {
                    this.f427g0 = (AppCompatViewInflater) this.f432l.getClassLoader().loadClass(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f427g0 = new AppCompatViewInflater();
                }
            }
        }
        boolean z4 = f417l0;
        if (z4) {
            if (this.f428h0 == null) {
                this.f428h0 = new LayoutIncludeDetector();
            }
            if (this.f428h0.a(attributeSet)) {
                z2 = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    z3 = V0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    z3 = true;
                }
                z2 = z3;
            }
        } else {
            z2 = false;
        }
        return this.f427g0.createView(view, str, context, attributeSet, z2, z4, true, VectorEnabledTintResources.c());
    }

    public Context g(Context context) {
        Configuration configuration;
        boolean z2 = true;
        this.Q = true;
        int C0 = C0(context, X());
        if (AppCompatDelegate.v(context)) {
            AppCompatDelegate.Q(context);
        }
        LocaleListCompat W2 = W(context);
        if (f420o0 && (context instanceof ContextThemeWrapper)) {
            try {
                ContextThemeWrapperCompatApi17Impl.a((ContextThemeWrapper) context, d0(context, C0, W2, (Configuration) null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            try {
                ((androidx.appcompat.view.ContextThemeWrapper) context).a(d0(context, C0, W2, (Configuration) null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f419n0) {
            return super.g(context);
        }
        Configuration configuration2 = new Configuration();
        configuration2.uiMode = -1;
        configuration2.fontScale = 0.0f;
        Configuration configuration3 = Api17Impl.a(context, configuration2).getResources().getConfiguration();
        Configuration configuration4 = context.getResources().getConfiguration();
        configuration3.uiMode = configuration4.uiMode;
        if (!configuration3.equals(configuration4)) {
            configuration = n0(configuration3, configuration4);
        } else {
            configuration = null;
        }
        Configuration d02 = d0(context, C0, W2, configuration, true);
        androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, R$style.f233e);
        contextThemeWrapper.a(d02);
        boolean z3 = false;
        try {
            if (context.getTheme() == null) {
                z2 = false;
            }
            z3 = z2;
        } catch (NullPointerException unused3) {
        }
        if (z3) {
            ResourcesCompat.ThemeCompat.a(contextThemeWrapper.getTheme());
        }
        return super.g(contextThemeWrapper);
    }

    /* access modifiers changed from: package-private */
    public void g0() {
        MenuBuilder menuBuilder;
        DecorContentParent decorContentParent = this.f439s;
        if (decorContentParent != null) {
            decorContentParent.l();
        }
        if (this.f444x != null) {
            this.f433m.getDecorView().removeCallbacks(this.f445y);
            if (this.f444x.isShowing()) {
                try {
                    this.f444x.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f444x = null;
        }
        j0();
        PanelFeatureState t02 = t0(0, false);
        if (t02 != null && (menuBuilder = t02.f480j) != null) {
            menuBuilder.close();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean h0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f431k;
        boolean z2 = true;
        if (((obj instanceof KeyEventDispatcher.Component) || (obj instanceof AppCompatDialog)) && (decorView = this.f433m.getDecorView()) != null && KeyEventDispatcher.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f434n.b(this.f433m.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z2 = false;
        }
        if (z2) {
            return E0(keyCode, keyEvent);
        }
        return H0(keyCode, keyEvent);
    }

    /* access modifiers changed from: package-private */
    public void i0(int i2) {
        PanelFeatureState t02;
        PanelFeatureState t03 = t0(i2, true);
        if (t03.f480j != null) {
            Bundle bundle = new Bundle();
            t03.f480j.T(bundle);
            if (bundle.size() > 0) {
                t03.f489s = bundle;
            }
            t03.f480j.h0();
            t03.f480j.clear();
        }
        t03.f488r = true;
        t03.f487q = true;
        if ((i2 == 108 || i2 == 0) && this.f439s != null && (t02 = t0(0, false)) != null) {
            t02.f483m = false;
            P0(t02, (KeyEvent) null);
        }
    }

    public <T extends View> T j(int i2) {
        k0();
        return this.f433m.findViewById(i2);
    }

    /* access modifiers changed from: package-private */
    public void j0() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f446z;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.c();
        }
    }

    public Context l() {
        return this.f432l;
    }

    /* access modifiers changed from: package-private */
    public PanelFeatureState m0(Menu menu) {
        int i2;
        PanelFeatureState[] panelFeatureStateArr = this.N;
        if (panelFeatureStateArr != null) {
            i2 = panelFeatureStateArr.length;
        } else {
            i2 = 0;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i3];
            if (panelFeatureState != null && panelFeatureState.f480j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    public final ActionBarDrawerToggle.Delegate n() {
        return new ActionBarDrawableToggleImpl();
    }

    public int o() {
        return this.U;
    }

    /* access modifiers changed from: package-private */
    public final Context o0() {
        Context context;
        ActionBar s2 = s();
        if (s2 != null) {
            context = s2.j();
        } else {
            context = null;
        }
        if (context == null) {
            return this.f432l;
        }
        return context;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return f0(view, str, context, attributeSet);
    }

    public MenuInflater q() {
        Context context;
        if (this.f437q == null) {
            w0();
            ActionBar actionBar = this.f436p;
            if (actionBar != null) {
                context = actionBar.j();
            } else {
                context = this.f432l;
            }
            this.f437q = new SupportMenuInflater(context);
        }
        return this.f437q;
    }

    public ActionBar s() {
        w0();
        return this.f436p;
    }

    /* access modifiers changed from: package-private */
    public LocaleListCompat s0(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.b(configuration);
        }
        return LocaleListCompat.c(Api21Impl.b(configuration.locale));
    }

    public void t() {
        LayoutInflater from = LayoutInflater.from(this.f432l);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.a(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* access modifiers changed from: protected */
    public PanelFeatureState t0(int i2, boolean z2) {
        PanelFeatureState[] panelFeatureStateArr = this.N;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i2) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i2 + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.N = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i2);
        panelFeatureStateArr[i2] = panelFeatureState2;
        return panelFeatureState2;
    }

    public void u() {
        if (N0() != null && !s().k()) {
            A0(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final CharSequence u0() {
        Object obj = this.f431k;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.f438r;
    }

    /* access modifiers changed from: package-private */
    public final Window.Callback v0() {
        return this.f433m.getCallback();
    }

    public void x(Configuration configuration) {
        ActionBar s2;
        if (this.H && this.B && (s2 = s()) != null) {
            s2.l(configuration);
        }
        AppCompatDrawableManager.b().g(this.f432l);
        this.T = new Configuration(this.f432l.getResources().getConfiguration());
        S(false, false);
    }

    public void y(Bundle bundle) {
        String str;
        this.Q = true;
        R(false);
        l0();
        Object obj = this.f431k;
        if (obj instanceof Activity) {
            try {
                str = NavUtils.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                ActionBar N0 = N0();
                if (N0 == null) {
                    this.f424d0 = true;
                } else {
                    N0.q(true);
                }
            }
            AppCompatDelegate.d(this);
        }
        this.T = new Configuration(this.f432l.getResources().getConfiguration());
        this.R = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void z() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f431k
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0009
            androidx.appcompat.app.AppCompatDelegate.F(r3)
        L_0x0009:
            boolean r0 = r3.f421a0
            if (r0 == 0) goto L_0x0018
            android.view.Window r0 = r3.f433m
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f423c0
            r0.removeCallbacks(r1)
        L_0x0018:
            r0 = 1
            r3.S = r0
            int r0 = r3.U
            r1 = -100
            if (r0 == r1) goto L_0x0045
            java.lang.Object r0 = r3.f431k
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0045
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x0045
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = f416k0
            java.lang.Object r1 = r3.f431k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.U
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x0054
        L_0x0045:
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = f416k0
            java.lang.Object r1 = r3.f431k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x0054:
            androidx.appcompat.app.ActionBar r0 = r3.f436p
            if (r0 == 0) goto L_0x005b
            r0.m()
        L_0x005b:
            r3.a0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.z():void");
    }

    AppCompatDelegateImpl(Dialog dialog, AppCompatCallback appCompatCallback) {
        this(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        r3 = f416k0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AppCompatDelegateImpl(android.content.Context r3, android.view.Window r4, androidx.appcompat.app.AppCompatCallback r5, java.lang.Object r6) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.f446z = r0
            r0 = 1
            r2.A = r0
            r0 = -100
            r2.U = r0
            androidx.appcompat.app.AppCompatDelegateImpl$2 r1 = new androidx.appcompat.app.AppCompatDelegateImpl$2
            r1.<init>()
            r2.f423c0 = r1
            r2.f432l = r3
            r2.f435o = r5
            r2.f431k = r6
            int r3 = r2.U
            if (r3 != r0) goto L_0x0032
            boolean r3 = r6 instanceof android.app.Dialog
            if (r3 == 0) goto L_0x0032
            androidx.appcompat.app.AppCompatActivity r3 = r2.Z0()
            if (r3 == 0) goto L_0x0032
            androidx.appcompat.app.AppCompatDelegate r3 = r3.getDelegate()
            int r3 = r3.o()
            r2.U = r3
        L_0x0032:
            int r3 = r2.U
            if (r3 != r0) goto L_0x0059
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r3 = f416k0
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            java.lang.Object r5 = r3.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x0059
            int r5 = r5.intValue()
            r2.U = r5
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            r3.remove(r5)
        L_0x0059:
            if (r4 == 0) goto L_0x005e
            r2.V(r4)
        L_0x005e:
            androidx.appcompat.widget.AppCompatDrawableManager.h()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.<init>(android.content.Context, android.view.Window, androidx.appcompat.app.AppCompatCallback, java.lang.Object):void");
    }

    class AppCompatWindowCallback extends WindowCallbackWrapper {

        /* renamed from: c  reason: collision with root package name */
        private ActionBarMenuCallback f458c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f459d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f460e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f461f;

        AppCompatWindowCallback(Window.Callback callback) {
            super(callback);
        }

        /* JADX INFO: finally extract failed */
        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f460e = true;
                boolean dispatchKeyEvent = callback.dispatchKeyEvent(keyEvent);
                this.f460e = false;
                return dispatchKeyEvent;
            } catch (Throwable th) {
                this.f460e = false;
                throw th;
            }
        }

        /* JADX INFO: finally extract failed */
        public void c(Window.Callback callback) {
            try {
                this.f459d = true;
                callback.onContentChanged();
                this.f459d = false;
            } catch (Throwable th) {
                this.f459d = false;
                throw th;
            }
        }

        /* JADX INFO: finally extract failed */
        public void d(Window.Callback callback, int i2, Menu menu) {
            try {
                this.f461f = true;
                callback.onPanelClosed(i2, menu);
                this.f461f = false;
            } catch (Throwable th) {
                this.f461f = false;
                throw th;
            }
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.f460e) {
                return a().dispatchKeyEvent(keyEvent);
            }
            if (AppCompatDelegateImpl.this.h0(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.G0(keyEvent.getKeyCode(), keyEvent)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void e(ActionBarMenuCallback actionBarMenuCallback) {
            this.f458c = actionBarMenuCallback;
        }

        /* access modifiers changed from: package-private */
        public final android.view.ActionMode f(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImpl.this.f432l, callback);
            androidx.appcompat.view.ActionMode P = AppCompatDelegateImpl.this.P(callbackWrapper);
            if (P != null) {
                return callbackWrapper.e(P);
            }
            return null;
        }

        public void onContentChanged() {
            if (this.f459d) {
                a().onContentChanged();
            }
        }

        public boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        public View onCreatePanelView(int i2) {
            View onCreatePanelView;
            ActionBarMenuCallback actionBarMenuCallback = this.f458c;
            if (actionBarMenuCallback == null || (onCreatePanelView = actionBarMenuCallback.onCreatePanelView(i2)) == null) {
                return super.onCreatePanelView(i2);
            }
            return onCreatePanelView;
        }

        public boolean onMenuOpened(int i2, Menu menu) {
            super.onMenuOpened(i2, menu);
            AppCompatDelegateImpl.this.J0(i2);
            return true;
        }

        public void onPanelClosed(int i2, Menu menu) {
            if (this.f461f) {
                a().onPanelClosed(i2, menu);
                return;
            }
            super.onPanelClosed(i2, menu);
            AppCompatDelegateImpl.this.K0(i2);
        }

        public boolean onPreparePanel(int i2, View view, Menu menu) {
            MenuBuilder menuBuilder;
            if (menu instanceof MenuBuilder) {
                menuBuilder = (MenuBuilder) menu;
            } else {
                menuBuilder = null;
            }
            if (i2 == 0 && menuBuilder == null) {
                return false;
            }
            boolean z2 = true;
            if (menuBuilder != null) {
                menuBuilder.e0(true);
            }
            ActionBarMenuCallback actionBarMenuCallback = this.f458c;
            if (actionBarMenuCallback == null || !actionBarMenuCallback.a(i2)) {
                z2 = false;
            }
            if (!z2) {
                z2 = super.onPreparePanel(i2, view, menu);
            }
            if (menuBuilder != null) {
                menuBuilder.e0(false);
            }
            return z2;
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            MenuBuilder menuBuilder;
            PanelFeatureState t02 = AppCompatDelegateImpl.this.t0(0, true);
            if (t02 == null || (menuBuilder = t02.f480j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i2);
            } else {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i2);
            }
        }

        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.B0()) {
                return f(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            if (!AppCompatDelegateImpl.this.B0() || i2 != 0) {
                return super.onWindowStartingActionMode(callback, i2);
            }
            return f(callback);
        }
    }
}
