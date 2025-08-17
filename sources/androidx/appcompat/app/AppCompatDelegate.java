package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppLocalesStorageHelper;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.ArraySet;
import androidx.core.os.BuildCompat;
import androidx.core.os.LocaleListCompat;
import com.facebook.hermes.intl.Constants;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class AppCompatDelegate {

    /* renamed from: b  reason: collision with root package name */
    static AppLocalesStorageHelper.SerialExecutor f407b = new AppLocalesStorageHelper.SerialExecutor(new AppLocalesStorageHelper.ThreadPerTaskExecutor());

    /* renamed from: c  reason: collision with root package name */
    private static int f408c = -100;

    /* renamed from: d  reason: collision with root package name */
    private static LocaleListCompat f409d = null;

    /* renamed from: e  reason: collision with root package name */
    private static LocaleListCompat f410e = null;

    /* renamed from: f  reason: collision with root package name */
    private static Boolean f411f = null;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f412g = false;

    /* renamed from: h  reason: collision with root package name */
    private static final ArraySet<WeakReference<AppCompatDelegate>> f413h = new ArraySet<>();

    /* renamed from: i  reason: collision with root package name */
    private static final Object f414i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static final Object f415j = new Object();

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    AppCompatDelegate() {
    }

    static void F(AppCompatDelegate appCompatDelegate) {
        synchronized (f414i) {
            G(appCompatDelegate);
        }
    }

    private static void G(AppCompatDelegate appCompatDelegate) {
        synchronized (f414i) {
            Iterator<WeakReference<AppCompatDelegate>> it2 = f413h.iterator();
            while (it2.hasNext()) {
                AppCompatDelegate appCompatDelegate2 = (AppCompatDelegate) it2.next().get();
                if (appCompatDelegate2 == appCompatDelegate || appCompatDelegate2 == null) {
                    it2.remove();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void Q(android.content.Context r3) {
        /*
            boolean r0 = v(r3)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = androidx.core.os.BuildCompat.d()
            if (r0 == 0) goto L_0x001c
            boolean r0 = f412g
            if (r0 != 0) goto L_0x0054
            androidx.appcompat.app.AppLocalesStorageHelper$SerialExecutor r0 = f407b
            androidx.appcompat.app.a r1 = new androidx.appcompat.app.a
            r1.<init>(r3)
            r0.execute(r1)
            goto L_0x0054
        L_0x001c:
            java.lang.Object r0 = f415j
            monitor-enter(r0)
            androidx.core.os.LocaleListCompat r1 = f409d     // Catch:{ all -> 0x0055 }
            if (r1 != 0) goto L_0x0040
            androidx.core.os.LocaleListCompat r1 = f410e     // Catch:{ all -> 0x0055 }
            if (r1 != 0) goto L_0x0031
            java.lang.String r3 = androidx.appcompat.app.AppLocalesStorageHelper.b(r3)     // Catch:{ all -> 0x0055 }
            androidx.core.os.LocaleListCompat r3 = androidx.core.os.LocaleListCompat.c(r3)     // Catch:{ all -> 0x0055 }
            f410e = r3     // Catch:{ all -> 0x0055 }
        L_0x0031:
            androidx.core.os.LocaleListCompat r3 = f410e     // Catch:{ all -> 0x0055 }
            boolean r3 = r3.f()     // Catch:{ all -> 0x0055 }
            if (r3 == 0) goto L_0x003b
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            return
        L_0x003b:
            androidx.core.os.LocaleListCompat r3 = f410e     // Catch:{ all -> 0x0055 }
            f409d = r3     // Catch:{ all -> 0x0055 }
            goto L_0x0053
        L_0x0040:
            androidx.core.os.LocaleListCompat r2 = f410e     // Catch:{ all -> 0x0055 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0055 }
            if (r1 != 0) goto L_0x0053
            androidx.core.os.LocaleListCompat r1 = f409d     // Catch:{ all -> 0x0055 }
            f410e = r1     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = r1.h()     // Catch:{ all -> 0x0055 }
            androidx.appcompat.app.AppLocalesStorageHelper.a(r3, r1)     // Catch:{ all -> 0x0055 }
        L_0x0053:
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
        L_0x0054:
            return
        L_0x0055:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegate.Q(android.content.Context):void");
    }

    static void d(AppCompatDelegate appCompatDelegate) {
        synchronized (f414i) {
            G(appCompatDelegate);
            f413h.add(new WeakReference(appCompatDelegate));
        }
    }

    public static AppCompatDelegate h(Activity activity, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(activity, appCompatCallback);
    }

    public static AppCompatDelegate i(Dialog dialog, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(dialog, appCompatCallback);
    }

    public static LocaleListCompat k() {
        if (BuildCompat.d()) {
            Object p2 = p();
            if (p2 != null) {
                return LocaleListCompat.i(Api33Impl.a(p2));
            }
        } else {
            LocaleListCompat localeListCompat = f409d;
            if (localeListCompat != null) {
                return localeListCompat;
            }
        }
        return LocaleListCompat.e();
    }

    public static int m() {
        return f408c;
    }

    static Object p() {
        Context l2;
        Iterator<WeakReference<AppCompatDelegate>> it2 = f413h.iterator();
        while (it2.hasNext()) {
            AppCompatDelegate appCompatDelegate = (AppCompatDelegate) it2.next().get();
            if (appCompatDelegate != null && (l2 = appCompatDelegate.l()) != null) {
                return l2.getSystemService(Constants.LOCALE);
            }
        }
        return null;
    }

    static LocaleListCompat r() {
        return f409d;
    }

    static boolean v(Context context) {
        if (f411f == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.a(context).metaData;
                if (bundle != null) {
                    f411f = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f411f = Boolean.FALSE;
            }
        }
        return f411f.booleanValue();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void w(Context context) {
        AppLocalesStorageHelper.c(context);
        f412g = true;
    }

    public abstract void A(Bundle bundle);

    public abstract void B();

    public abstract void C(Bundle bundle);

    public abstract void D();

    public abstract void E();

    public abstract boolean H(int i2);

    public abstract void I(int i2);

    public abstract void J(View view);

    public abstract void K(View view, ViewGroup.LayoutParams layoutParams);

    public void L(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void M(Toolbar toolbar);

    public void N(int i2) {
    }

    public abstract void O(CharSequence charSequence);

    public abstract ActionMode P(ActionMode.Callback callback);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    @Deprecated
    public void f(Context context) {
    }

    public Context g(Context context) {
        f(context);
        return context;
    }

    public abstract <T extends View> T j(int i2);

    public Context l() {
        return null;
    }

    public abstract ActionBarDrawerToggle.Delegate n();

    public int o() {
        return -100;
    }

    public abstract MenuInflater q();

    public abstract ActionBar s();

    public abstract void t();

    public abstract void u();

    public abstract void x(Configuration configuration);

    public abstract void y(Bundle bundle);

    public abstract void z();
}
