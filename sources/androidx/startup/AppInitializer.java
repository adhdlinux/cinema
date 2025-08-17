package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class AppInitializer {

    /* renamed from: d  reason: collision with root package name */
    private static volatile AppInitializer f11635d;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f11636e = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Map<Class<?>, Object> f11637a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Set<Class<? extends Initializer<?>>> f11638b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    final Context f11639c;

    AppInitializer(Context context) {
        this.f11639c = context.getApplicationContext();
    }

    private <T> T d(Class<? extends Initializer<?>> cls, Set<Class<?>> set) {
        T t2;
        if (Trace.d()) {
            try {
                Trace.a(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.b();
                throw th;
            }
        }
        if (!set.contains(cls)) {
            if (!this.f11637a.containsKey(cls)) {
                set.add(cls);
                Initializer initializer = (Initializer) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends Initializer<?>>> dependencies = initializer.dependencies();
                if (!dependencies.isEmpty()) {
                    for (Class next : dependencies) {
                        if (!this.f11637a.containsKey(next)) {
                            d(next, set);
                        }
                    }
                }
                t2 = initializer.create(this.f11639c);
                set.remove(cls);
                this.f11637a.put(cls, t2);
            } else {
                t2 = this.f11637a.get(cls);
            }
            Trace.b();
            return t2;
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{cls.getName()}));
    }

    public static AppInitializer e(Context context) {
        if (f11635d == null) {
            synchronized (f11636e) {
                if (f11635d == null) {
                    f11635d = new AppInitializer(context);
                }
            }
        }
        return f11635d;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        try {
            Trace.a("Startup");
            b(this.f11639c.getPackageManager().getProviderInfo(new ComponentName(this.f11639c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            Trace.b();
        } catch (PackageManager.NameNotFoundException e2) {
            throw new StartupException((Throwable) e2);
        } catch (Throwable th) {
            Trace.b();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Bundle bundle) {
        String string = this.f11639c.getString(R$string.f11640a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String next : bundle.keySet()) {
                    if (string.equals(bundle.getString(next, (String) null))) {
                        Class<?> cls = Class.forName(next);
                        if (Initializer.class.isAssignableFrom(cls)) {
                            this.f11638b.add(cls);
                        }
                    }
                }
                for (Class<? extends Initializer<?>> d2 : this.f11638b) {
                    d(d2, hashSet);
                }
            } catch (ClassNotFoundException e2) {
                throw new StartupException((Throwable) e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public <T> T c(Class<? extends Initializer<?>> cls) {
        T t2;
        synchronized (f11636e) {
            t2 = this.f11637a.get(cls);
            if (t2 == null) {
                t2 = d(cls, new HashSet());
            }
        }
        return t2;
    }

    public <T> T f(Class<? extends Initializer<T>> cls) {
        return c(cls);
    }

    public boolean g(Class<? extends Initializer<?>> cls) {
        return this.f11638b.contains(cls);
    }
}
