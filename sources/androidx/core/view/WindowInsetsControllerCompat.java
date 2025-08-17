package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.collection.SimpleArrayMap;
import com.google.protobuf.CodedOutputStream;

public final class WindowInsetsControllerCompat {

    /* renamed from: a  reason: collision with root package name */
    private final Impl f2842a;

    private static class Impl {
        Impl() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
        }
    }

    private static class Impl20 extends Impl {

        /* renamed from: a  reason: collision with root package name */
        protected final Window f2843a;

        /* renamed from: b  reason: collision with root package name */
        private final View f2844b;

        Impl20(Window window, View view) {
            this.f2843a = window;
            this.f2844b = view;
        }

        private void c(int i2) {
            if (i2 == 1) {
                d(4);
            } else if (i2 == 2) {
                d(2);
            } else if (i2 == 8) {
                ((InputMethodManager) this.f2843a.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f2843a.getDecorView().getWindowToken(), 0);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    c(i3);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            if (i2 == 0) {
                e(6144);
            } else if (i2 == 1) {
                e(CodedOutputStream.DEFAULT_BUFFER_SIZE);
                d(2048);
            } else if (i2 == 2) {
                e(2048);
                d(CodedOutputStream.DEFAULT_BUFFER_SIZE);
            }
        }

        /* access modifiers changed from: protected */
        public void d(int i2) {
            View decorView = this.f2843a.getDecorView();
            decorView.setSystemUiVisibility(i2 | decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void e(int i2) {
            View decorView = this.f2843a.getDecorView();
            decorView.setSystemUiVisibility((~i2) & decorView.getSystemUiVisibility());
        }
    }

    private static class Impl23 extends Impl20 {
        Impl23(Window window, View view) {
            super(window, view);
        }
    }

    private static class Impl26 extends Impl23 {
        Impl26(Window window, View view) {
            super(window, view);
        }
    }

    public WindowInsetsControllerCompat(Window window, View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.f2842a = new Impl30(window, this);
        } else if (i2 >= 26) {
            this.f2842a = new Impl26(window, view);
        } else if (i2 >= 23) {
            this.f2842a = new Impl23(window, view);
        } else {
            this.f2842a = new Impl20(window, view);
        }
    }

    public void a(int i2) {
        this.f2842a.a(i2);
    }

    public void b(int i2) {
        this.f2842a.b(i2);
    }

    private static class Impl30 extends Impl {

        /* renamed from: a  reason: collision with root package name */
        final WindowInsetsControllerCompat f2845a;

        /* renamed from: b  reason: collision with root package name */
        final WindowInsetsController f2846b;

        /* renamed from: c  reason: collision with root package name */
        private final SimpleArrayMap<Object, WindowInsetsController.OnControllableInsetsChangedListener> f2847c;

        /* renamed from: d  reason: collision with root package name */
        protected Window f2848d;

        Impl30(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat) {
            this(window.getInsetsController(), windowInsetsControllerCompat);
            this.f2848d = window;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.f2846b.hide(i2);
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            this.f2846b.setSystemBarsBehavior(i2);
        }

        Impl30(WindowInsetsController windowInsetsController, WindowInsetsControllerCompat windowInsetsControllerCompat) {
            this.f2847c = new SimpleArrayMap<>();
            this.f2846b = windowInsetsController;
            this.f2845a = windowInsetsControllerCompat;
        }
    }
}
