package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;

public class ContextThemeWrapper extends ContextWrapper {

    /* renamed from: f  reason: collision with root package name */
    private static Configuration f665f;

    /* renamed from: a  reason: collision with root package name */
    private int f666a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f667b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f668c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f669d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f670e;

    static class Api17Impl {
        private Api17Impl() {
        }

        static Context a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            return contextThemeWrapper.createConfigurationContext(configuration);
        }
    }

    public ContextThemeWrapper() {
        super((Context) null);
    }

    private Resources b() {
        if (this.f670e == null) {
            Configuration configuration = this.f669d;
            if (configuration == null || (Build.VERSION.SDK_INT >= 26 && e(configuration))) {
                this.f670e = super.getResources();
            } else {
                this.f670e = Api17Impl.a(this, this.f669d).getResources();
            }
        }
        return this.f670e;
    }

    private void d() {
        boolean z2;
        if (this.f667b == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.f667b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f667b.setTo(theme);
            }
        }
        f(this.f667b, this.f666a, z2);
    }

    private static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f665f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f665f = configuration2;
        }
        return configuration.equals(f665f);
    }

    public void a(Configuration configuration) {
        if (this.f670e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.f669d == null) {
            this.f669d = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f666a;
    }

    /* access modifiers changed from: protected */
    public void f(Resources.Theme theme, int i2, boolean z2) {
        theme.applyStyle(i2, true);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return b();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f668c == null) {
            this.f668c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f668c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f667b;
        if (theme != null) {
            return theme;
        }
        if (this.f666a == 0) {
            this.f666a = R$style.f234f;
        }
        d();
        return this.f667b;
    }

    public void setTheme(int i2) {
        if (this.f666a != i2) {
            this.f666a = i2;
            d();
        }
    }

    public ContextThemeWrapper(Context context, int i2) {
        super(context);
        this.f666a = i2;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.f667b = theme;
    }
}
