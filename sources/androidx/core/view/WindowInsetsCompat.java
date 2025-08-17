package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class WindowInsetsCompat {

    /* renamed from: b  reason: collision with root package name */
    public static final WindowInsetsCompat f2809b;

    /* renamed from: a  reason: collision with root package name */
    private final Impl f2810a;

    @SuppressLint({"SoonBlockedPrivateApi"})
    static class Api21ReflectionHolder {

        /* renamed from: a  reason: collision with root package name */
        private static Field f2811a;

        /* renamed from: b  reason: collision with root package name */
        private static Field f2812b;

        /* renamed from: c  reason: collision with root package name */
        private static Field f2813c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f2814d = true;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f2811a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f2812b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f2813c = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e2.getMessage(), e2);
            }
        }

        private Api21ReflectionHolder() {
        }

        public static WindowInsetsCompat a(View view) {
            if (f2814d && view.isAttachedToWindow()) {
                try {
                    Object obj = f2811a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f2812b.get(obj);
                        Rect rect2 = (Rect) f2813c.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            WindowInsetsCompat a2 = new Builder().b(Insets.c(rect)).c(Insets.c(rect2)).a();
                            a2.s(a2);
                            a2.d(view.getRootView());
                            return a2;
                        }
                    }
                } catch (IllegalAccessException e2) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e2.getMessage(), e2);
                }
            }
            return null;
        }
    }

    private static class BuilderImpl {

        /* renamed from: a  reason: collision with root package name */
        private final WindowInsetsCompat f2816a;

        /* renamed from: b  reason: collision with root package name */
        Insets[] f2817b;

        BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        /* access modifiers changed from: protected */
        public final void a() {
            Insets[] insetsArr = this.f2817b;
            if (insetsArr != null) {
                Insets insets = insetsArr[Type.a(1)];
                Insets insets2 = this.f2817b[Type.a(2)];
                if (insets2 == null) {
                    insets2 = this.f2816a.f(2);
                }
                if (insets == null) {
                    insets = this.f2816a.f(1);
                }
                f(Insets.a(insets, insets2));
                Insets insets3 = this.f2817b[Type.a(16)];
                if (insets3 != null) {
                    e(insets3);
                }
                Insets insets4 = this.f2817b[Type.a(32)];
                if (insets4 != null) {
                    c(insets4);
                }
                Insets insets5 = this.f2817b[Type.a(64)];
                if (insets5 != null) {
                    g(insets5);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat b() {
            a();
            return this.f2816a;
        }

        /* access modifiers changed from: package-private */
        public void c(Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void d(Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void e(Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void f(Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void g(Insets insets) {
        }

        BuilderImpl(WindowInsetsCompat windowInsetsCompat) {
            this.f2816a = windowInsetsCompat;
        }
    }

    private static class BuilderImpl30 extends BuilderImpl29 {
        BuilderImpl30() {
        }

        BuilderImpl30(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    private static class Impl {

        /* renamed from: b  reason: collision with root package name */
        static final WindowInsetsCompat f2825b = new Builder().a().a().b().c();

        /* renamed from: a  reason: collision with root package name */
        final WindowInsetsCompat f2826a;

        Impl(WindowInsetsCompat windowInsetsCompat) {
            this.f2826a = windowInsetsCompat;
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat a() {
            return this.f2826a;
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat b() {
            return this.f2826a;
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat c() {
            return this.f2826a;
        }

        /* access modifiers changed from: package-private */
        public void d(View view) {
        }

        /* access modifiers changed from: package-private */
        public void e(WindowInsetsCompat windowInsetsCompat) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl)) {
                return false;
            }
            Impl impl = (Impl) obj;
            if (o() != impl.o() || n() != impl.n() || !ObjectsCompat.a(k(), impl.k()) || !ObjectsCompat.a(i(), impl.i()) || !ObjectsCompat.a(f(), impl.f())) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public DisplayCutoutCompat f() {
            return null;
        }

        /* access modifiers changed from: package-private */
        public Insets g(int i2) {
            return Insets.f2541e;
        }

        /* access modifiers changed from: package-private */
        public Insets h() {
            return k();
        }

        public int hashCode() {
            return ObjectsCompat.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        /* access modifiers changed from: package-private */
        public Insets i() {
            return Insets.f2541e;
        }

        /* access modifiers changed from: package-private */
        public Insets j() {
            return k();
        }

        /* access modifiers changed from: package-private */
        public Insets k() {
            return Insets.f2541e;
        }

        /* access modifiers changed from: package-private */
        public Insets l() {
            return k();
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat m(int i2, int i3, int i4, int i5) {
            return f2825b;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean o() {
            return false;
        }

        public void p(Insets[] insetsArr) {
        }

        /* access modifiers changed from: package-private */
        public void q(Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void r(WindowInsetsCompat windowInsetsCompat) {
        }

        public void s(Insets insets) {
        }
    }

    private static class Impl28 extends Impl21 {
        Impl28(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat a() {
            return WindowInsetsCompat.v(this.f2832c.consumeDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl28)) {
                return false;
            }
            Impl28 impl28 = (Impl28) obj;
            if (!Objects.equals(this.f2832c, impl28.f2832c) || !Objects.equals(this.f2836g, impl28.f2836g)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public DisplayCutoutCompat f() {
            return DisplayCutoutCompat.e(this.f2832c.getDisplayCutout());
        }

        public int hashCode() {
            return this.f2832c.hashCode();
        }

        Impl28(WindowInsetsCompat windowInsetsCompat, Impl28 impl28) {
            super(windowInsetsCompat, (Impl21) impl28);
        }
    }

    private static class Impl30 extends Impl29 {

        /* renamed from: q  reason: collision with root package name */
        static final WindowInsetsCompat f2841q = WindowInsetsCompat.v(WindowInsets.CONSUMED);

        Impl30(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        public final void d(View view) {
        }

        public Insets g(int i2) {
            return Insets.d(this.f2832c.getInsets(TypeImpl30.a(i2)));
        }

        Impl30(WindowInsetsCompat windowInsetsCompat, Impl30 impl30) {
            super(windowInsetsCompat, (Impl29) impl30);
        }
    }

    public static final class Type {
        private Type() {
        }

        static int a(int i2) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 4) {
                return 2;
            }
            if (i2 == 8) {
                return 3;
            }
            if (i2 == 16) {
                return 4;
            }
            if (i2 == 32) {
                return 5;
            }
            if (i2 == 64) {
                return 6;
            }
            if (i2 == 128) {
                return 7;
            }
            if (i2 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i2);
        }

        public static int b() {
            return 7;
        }
    }

    private static final class TypeImpl30 {
        private TypeImpl30() {
        }

        static int a(int i2) {
            int i3;
            int i4 = 0;
            for (int i5 = 1; i5 <= 256; i5 <<= 1) {
                if ((i2 & i5) != 0) {
                    if (i5 == 1) {
                        i3 = WindowInsets.Type.statusBars();
                    } else if (i5 == 2) {
                        i3 = WindowInsets.Type.navigationBars();
                    } else if (i5 == 4) {
                        i3 = WindowInsets.Type.captionBar();
                    } else if (i5 == 8) {
                        i3 = WindowInsets.Type.ime();
                    } else if (i5 == 16) {
                        i3 = WindowInsets.Type.systemGestures();
                    } else if (i5 == 32) {
                        i3 = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i5 == 64) {
                        i3 = WindowInsets.Type.tappableElement();
                    } else if (i5 == 128) {
                        i3 = WindowInsets.Type.displayCutout();
                    }
                    i4 |= i3;
                }
            }
            return i4;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f2809b = Impl30.f2841q;
        } else {
            f2809b = Impl.f2825b;
        }
    }

    private WindowInsetsCompat(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.f2810a = new Impl30(this, windowInsets);
        } else if (i2 >= 29) {
            this.f2810a = new Impl29(this, windowInsets);
        } else if (i2 >= 28) {
            this.f2810a = new Impl28(this, windowInsets);
        } else {
            this.f2810a = new Impl21(this, windowInsets);
        }
    }

    static Insets n(Insets insets, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, insets.f2542a - i2);
        int max2 = Math.max(0, insets.f2543b - i3);
        int max3 = Math.max(0, insets.f2544c - i4);
        int max4 = Math.max(0, insets.f2545d - i5);
        if (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) {
            return insets;
        }
        return Insets.b(max, max2, max3, max4);
    }

    public static WindowInsetsCompat v(WindowInsets windowInsets) {
        return w(windowInsets, (View) null);
    }

    public static WindowInsetsCompat w(WindowInsets windowInsets, View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) Preconditions.g(windowInsets));
        if (view != null && ViewCompat.U(view)) {
            windowInsetsCompat.s(ViewCompat.K(view));
            windowInsetsCompat.d(view.getRootView());
        }
        return windowInsetsCompat;
    }

    @Deprecated
    public WindowInsetsCompat a() {
        return this.f2810a.a();
    }

    @Deprecated
    public WindowInsetsCompat b() {
        return this.f2810a.b();
    }

    @Deprecated
    public WindowInsetsCompat c() {
        return this.f2810a.c();
    }

    /* access modifiers changed from: package-private */
    public void d(View view) {
        this.f2810a.d(view);
    }

    public DisplayCutoutCompat e() {
        return this.f2810a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat)) {
            return false;
        }
        return ObjectsCompat.a(this.f2810a, ((WindowInsetsCompat) obj).f2810a);
    }

    public Insets f(int i2) {
        return this.f2810a.g(i2);
    }

    @Deprecated
    public Insets g() {
        return this.f2810a.i();
    }

    @Deprecated
    public int h() {
        return this.f2810a.k().f2545d;
    }

    public int hashCode() {
        Impl impl = this.f2810a;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f2810a.k().f2542a;
    }

    @Deprecated
    public int j() {
        return this.f2810a.k().f2544c;
    }

    @Deprecated
    public int k() {
        return this.f2810a.k().f2543b;
    }

    @Deprecated
    public boolean l() {
        return !this.f2810a.k().equals(Insets.f2541e);
    }

    public WindowInsetsCompat m(int i2, int i3, int i4, int i5) {
        return this.f2810a.m(i2, i3, i4, i5);
    }

    public boolean o() {
        return this.f2810a.n();
    }

    @Deprecated
    public WindowInsetsCompat p(int i2, int i3, int i4, int i5) {
        return new Builder(this).c(Insets.b(i2, i3, i4, i5)).a();
    }

    /* access modifiers changed from: package-private */
    public void q(Insets[] insetsArr) {
        this.f2810a.p(insetsArr);
    }

    /* access modifiers changed from: package-private */
    public void r(Insets insets) {
        this.f2810a.q(insets);
    }

    /* access modifiers changed from: package-private */
    public void s(WindowInsetsCompat windowInsetsCompat) {
        this.f2810a.r(windowInsetsCompat);
    }

    /* access modifiers changed from: package-private */
    public void t(Insets insets) {
        this.f2810a.s(insets);
    }

    public WindowInsets u() {
        Impl impl = this.f2810a;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).f2832c;
        }
        return null;
    }

    private static class BuilderImpl20 extends BuilderImpl {

        /* renamed from: e  reason: collision with root package name */
        private static Field f2818e = null;

        /* renamed from: f  reason: collision with root package name */
        private static boolean f2819f = false;

        /* renamed from: g  reason: collision with root package name */
        private static Constructor<WindowInsets> f2820g = null;

        /* renamed from: h  reason: collision with root package name */
        private static boolean f2821h = false;

        /* renamed from: c  reason: collision with root package name */
        private WindowInsets f2822c;

        /* renamed from: d  reason: collision with root package name */
        private Insets f2823d;

        BuilderImpl20() {
            this.f2822c = h();
        }

        private static WindowInsets h() {
            Class<WindowInsets> cls = WindowInsets.class;
            if (!f2819f) {
                try {
                    f2818e = cls.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f2819f = true;
            }
            Field field = f2818e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get((Object) null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!f2821h) {
                try {
                    f2820g = cls.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f2821h = true;
            }
            Constructor<WindowInsets> constructor = f2820g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat v2 = WindowInsetsCompat.v(this.f2822c);
            v2.q(this.f2817b);
            v2.t(this.f2823d);
            return v2;
        }

        /* access modifiers changed from: package-private */
        public void d(Insets insets) {
            this.f2823d = insets;
        }

        /* access modifiers changed from: package-private */
        public void f(Insets insets) {
            WindowInsets windowInsets = this.f2822c;
            if (windowInsets != null) {
                this.f2822c = windowInsets.replaceSystemWindowInsets(insets.f2542a, insets.f2543b, insets.f2544c, insets.f2545d);
            }
        }

        BuilderImpl20(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.f2822c = windowInsetsCompat.u();
        }
    }

    private static class BuilderImpl29 extends BuilderImpl {

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets.Builder f2824c;

        BuilderImpl29() {
            this.f2824c = new WindowInsets.Builder();
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat v2 = WindowInsetsCompat.v(this.f2824c.build());
            v2.q(this.f2817b);
            return v2;
        }

        /* access modifiers changed from: package-private */
        public void c(Insets insets) {
            WindowInsets.Builder unused = this.f2824c.setMandatorySystemGestureInsets(insets.e());
        }

        /* access modifiers changed from: package-private */
        public void d(Insets insets) {
            WindowInsets.Builder unused = this.f2824c.setStableInsets(insets.e());
        }

        /* access modifiers changed from: package-private */
        public void e(Insets insets) {
            WindowInsets.Builder unused = this.f2824c.setSystemGestureInsets(insets.e());
        }

        /* access modifiers changed from: package-private */
        public void f(Insets insets) {
            WindowInsets.Builder unused = this.f2824c.setSystemWindowInsets(insets.e());
        }

        /* access modifiers changed from: package-private */
        public void g(Insets insets) {
            WindowInsets.Builder unused = this.f2824c.setTappableElementInsets(insets.e());
        }

        BuilderImpl29(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets.Builder builder;
            WindowInsets u2 = windowInsetsCompat.u();
            if (u2 != null) {
                builder = new WindowInsets.Builder(u2);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f2824c = builder;
        }
    }

    private static class Impl21 extends Impl20 {

        /* renamed from: m  reason: collision with root package name */
        private Insets f2837m = null;

        Impl21(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat b() {
            return WindowInsetsCompat.v(this.f2832c.consumeStableInsets());
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat c() {
            return WindowInsetsCompat.v(this.f2832c.consumeSystemWindowInsets());
        }

        /* access modifiers changed from: package-private */
        public final Insets i() {
            if (this.f2837m == null) {
                this.f2837m = Insets.b(this.f2832c.getStableInsetLeft(), this.f2832c.getStableInsetTop(), this.f2832c.getStableInsetRight(), this.f2832c.getStableInsetBottom());
            }
            return this.f2837m;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return this.f2832c.isConsumed();
        }

        public void s(Insets insets) {
            this.f2837m = insets;
        }

        Impl21(WindowInsetsCompat windowInsetsCompat, Impl21 impl21) {
            super(windowInsetsCompat, (Impl20) impl21);
            this.f2837m = impl21.f2837m;
        }
    }

    private static class Impl20 extends Impl {

        /* renamed from: h  reason: collision with root package name */
        private static boolean f2827h = false;

        /* renamed from: i  reason: collision with root package name */
        private static Method f2828i;

        /* renamed from: j  reason: collision with root package name */
        private static Class<?> f2829j;

        /* renamed from: k  reason: collision with root package name */
        private static Field f2830k;

        /* renamed from: l  reason: collision with root package name */
        private static Field f2831l;

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets f2832c;

        /* renamed from: d  reason: collision with root package name */
        private Insets[] f2833d;

        /* renamed from: e  reason: collision with root package name */
        private Insets f2834e;

        /* renamed from: f  reason: collision with root package name */
        private WindowInsetsCompat f2835f;

        /* renamed from: g  reason: collision with root package name */
        Insets f2836g;

        Impl20(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.f2834e = null;
            this.f2832c = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        private Insets t(int i2, boolean z2) {
            Insets insets = Insets.f2541e;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    insets = Insets.a(insets, u(i3, z2));
                }
            }
            return insets;
        }

        private Insets v() {
            WindowInsetsCompat windowInsetsCompat = this.f2835f;
            if (windowInsetsCompat != null) {
                return windowInsetsCompat.g();
            }
            return Insets.f2541e;
        }

        private Insets w(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f2827h) {
                    x();
                }
                Method method = f2828i;
                if (!(method == null || f2829j == null || f2830k == null)) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f2830k.get(f2831l.get(invoke));
                        if (rect != null) {
                            return Insets.c(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e2) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void x() {
            try {
                f2828i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f2829j = cls;
                f2830k = cls.getDeclaredField("mVisibleInsets");
                f2831l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f2830k.setAccessible(true);
                f2831l.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
            f2827h = true;
        }

        /* access modifiers changed from: package-private */
        public void d(View view) {
            Insets w2 = w(view);
            if (w2 == null) {
                w2 = Insets.f2541e;
            }
            q(w2);
        }

        /* access modifiers changed from: package-private */
        public void e(WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.s(this.f2835f);
            windowInsetsCompat.r(this.f2836g);
        }

        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f2836g, ((Impl20) obj).f2836g);
        }

        public Insets g(int i2) {
            return t(i2, false);
        }

        /* access modifiers changed from: package-private */
        public final Insets k() {
            if (this.f2834e == null) {
                this.f2834e = Insets.b(this.f2832c.getSystemWindowInsetLeft(), this.f2832c.getSystemWindowInsetTop(), this.f2832c.getSystemWindowInsetRight(), this.f2832c.getSystemWindowInsetBottom());
            }
            return this.f2834e;
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat m(int i2, int i3, int i4, int i5) {
            Builder builder = new Builder(WindowInsetsCompat.v(this.f2832c));
            builder.c(WindowInsetsCompat.n(k(), i2, i3, i4, i5));
            builder.b(WindowInsetsCompat.n(i(), i2, i3, i4, i5));
            return builder.a();
        }

        /* access modifiers changed from: package-private */
        public boolean o() {
            return this.f2832c.isRound();
        }

        public void p(Insets[] insetsArr) {
            this.f2833d = insetsArr;
        }

        /* access modifiers changed from: package-private */
        public void q(Insets insets) {
            this.f2836g = insets;
        }

        /* access modifiers changed from: package-private */
        public void r(WindowInsetsCompat windowInsetsCompat) {
            this.f2835f = windowInsetsCompat;
        }

        /* access modifiers changed from: protected */
        public Insets u(int i2, boolean z2) {
            int i3;
            DisplayCutoutCompat displayCutoutCompat;
            if (i2 != 1) {
                Insets insets = null;
                if (i2 != 2) {
                    if (i2 == 8) {
                        Insets[] insetsArr = this.f2833d;
                        if (insetsArr != null) {
                            insets = insetsArr[Type.a(8)];
                        }
                        if (insets != null) {
                            return insets;
                        }
                        Insets k2 = k();
                        Insets v2 = v();
                        int i4 = k2.f2545d;
                        if (i4 > v2.f2545d) {
                            return Insets.b(0, 0, 0, i4);
                        }
                        Insets insets2 = this.f2836g;
                        if (insets2 == null || insets2.equals(Insets.f2541e) || (i3 = this.f2836g.f2545d) <= v2.f2545d) {
                            return Insets.f2541e;
                        }
                        return Insets.b(0, 0, 0, i3);
                    } else if (i2 == 16) {
                        return j();
                    } else {
                        if (i2 == 32) {
                            return h();
                        }
                        if (i2 == 64) {
                            return l();
                        }
                        if (i2 != 128) {
                            return Insets.f2541e;
                        }
                        WindowInsetsCompat windowInsetsCompat = this.f2835f;
                        if (windowInsetsCompat != null) {
                            displayCutoutCompat = windowInsetsCompat.e();
                        } else {
                            displayCutoutCompat = f();
                        }
                        if (displayCutoutCompat != null) {
                            return Insets.b(displayCutoutCompat.b(), displayCutoutCompat.d(), displayCutoutCompat.c(), displayCutoutCompat.a());
                        }
                        return Insets.f2541e;
                    }
                } else if (z2) {
                    Insets v3 = v();
                    Insets i5 = i();
                    return Insets.b(Math.max(v3.f2542a, i5.f2542a), 0, Math.max(v3.f2544c, i5.f2544c), Math.max(v3.f2545d, i5.f2545d));
                } else {
                    Insets k3 = k();
                    WindowInsetsCompat windowInsetsCompat2 = this.f2835f;
                    if (windowInsetsCompat2 != null) {
                        insets = windowInsetsCompat2.g();
                    }
                    int i6 = k3.f2545d;
                    if (insets != null) {
                        i6 = Math.min(i6, insets.f2545d);
                    }
                    return Insets.b(k3.f2542a, 0, k3.f2544c, i6);
                }
            } else if (z2) {
                return Insets.b(0, Math.max(v().f2543b, k().f2543b), 0, 0);
            } else {
                return Insets.b(0, k().f2543b, 0, 0);
            }
        }

        Impl20(WindowInsetsCompat windowInsetsCompat, Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.f2832c));
        }
    }

    private static class Impl29 extends Impl28 {

        /* renamed from: n  reason: collision with root package name */
        private Insets f2838n = null;

        /* renamed from: o  reason: collision with root package name */
        private Insets f2839o = null;

        /* renamed from: p  reason: collision with root package name */
        private Insets f2840p = null;

        Impl29(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        public Insets h() {
            if (this.f2839o == null) {
                this.f2839o = Insets.d(this.f2832c.getMandatorySystemGestureInsets());
            }
            return this.f2839o;
        }

        /* access modifiers changed from: package-private */
        public Insets j() {
            if (this.f2838n == null) {
                this.f2838n = Insets.d(this.f2832c.getSystemGestureInsets());
            }
            return this.f2838n;
        }

        /* access modifiers changed from: package-private */
        public Insets l() {
            if (this.f2840p == null) {
                this.f2840p = Insets.d(this.f2832c.getTappableElementInsets());
            }
            return this.f2840p;
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat m(int i2, int i3, int i4, int i5) {
            return WindowInsetsCompat.v(this.f2832c.inset(i2, i3, i4, i5));
        }

        public void s(Insets insets) {
        }

        Impl29(WindowInsetsCompat windowInsetsCompat, Impl29 impl29) {
            super(windowInsetsCompat, (Impl28) impl29);
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final BuilderImpl f2815a;

        public Builder() {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.f2815a = new BuilderImpl30();
            } else if (i2 >= 29) {
                this.f2815a = new BuilderImpl29();
            } else {
                this.f2815a = new BuilderImpl20();
            }
        }

        public WindowInsetsCompat a() {
            return this.f2815a.b();
        }

        @Deprecated
        public Builder b(Insets insets) {
            this.f2815a.d(insets);
            return this;
        }

        @Deprecated
        public Builder c(Insets insets) {
            this.f2815a.f(insets);
            return this;
        }

        public Builder(WindowInsetsCompat windowInsetsCompat) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.f2815a = new BuilderImpl30(windowInsetsCompat);
            } else if (i2 >= 29) {
                this.f2815a = new BuilderImpl29(windowInsetsCompat);
            } else {
                this.f2815a = new BuilderImpl20(windowInsetsCompat);
            }
        }
    }

    public WindowInsetsCompat(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            Impl impl = windowInsetsCompat.f2810a;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && (impl instanceof Impl30)) {
                this.f2810a = new Impl30(this, (Impl30) impl);
            } else if (i2 >= 29 && (impl instanceof Impl29)) {
                this.f2810a = new Impl29(this, (Impl29) impl);
            } else if (i2 >= 28 && (impl instanceof Impl28)) {
                this.f2810a = new Impl28(this, (Impl28) impl);
            } else if (impl instanceof Impl21) {
                this.f2810a = new Impl21(this, (Impl21) impl);
            } else if (impl instanceof Impl20) {
                this.f2810a = new Impl20(this, (Impl20) impl);
            } else {
                this.f2810a = new Impl(this);
            }
            impl.e(this);
            return;
        }
        this.f2810a = new Impl(this);
    }
}
