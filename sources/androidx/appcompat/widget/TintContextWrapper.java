package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TintContextWrapper extends ContextWrapper {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f1457c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static ArrayList<WeakReference<TintContextWrapper>> f1458d;

    /* renamed from: a  reason: collision with root package name */
    private final Resources f1459a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources.Theme f1460b;

    private TintContextWrapper(Context context) {
        super(context);
        if (VectorEnabledTintResources.c()) {
            VectorEnabledTintResources vectorEnabledTintResources = new VectorEnabledTintResources(this, context.getResources());
            this.f1459a = vectorEnabledTintResources;
            Resources.Theme newTheme = vectorEnabledTintResources.newTheme();
            this.f1460b = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f1459a = new TintResources(this, context.getResources());
        this.f1460b = null;
    }

    private static boolean a(Context context) {
        if ((context instanceof TintContextWrapper) || (context.getResources() instanceof TintResources) || (context.getResources() instanceof VectorEnabledTintResources) || !VectorEnabledTintResources.c()) {
            return false;
        }
        return true;
    }

    public static Context b(Context context) {
        TintContextWrapper tintContextWrapper;
        if (!a(context)) {
            return context;
        }
        synchronized (f1457c) {
            ArrayList<WeakReference<TintContextWrapper>> arrayList = f1458d;
            if (arrayList == null) {
                f1458d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = f1458d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1458d.remove(size);
                    }
                }
                for (int size2 = f1458d.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = f1458d.get(size2);
                    if (weakReference2 != null) {
                        tintContextWrapper = (TintContextWrapper) weakReference2.get();
                    } else {
                        tintContextWrapper = null;
                    }
                    if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                        return tintContextWrapper;
                    }
                }
            }
            TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
            f1458d.add(new WeakReference(tintContextWrapper2));
            return tintContextWrapper2;
        }
    }

    public AssetManager getAssets() {
        return this.f1459a.getAssets();
    }

    public Resources getResources() {
        return this.f1459a;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1460b;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i2) {
        Resources.Theme theme = this.f1460b;
        if (theme == null) {
            super.setTheme(i2);
        } else {
            theme.applyStyle(i2, true);
        }
    }
}
