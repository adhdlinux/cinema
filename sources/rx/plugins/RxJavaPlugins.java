package rx.plugins;

import androidx.media3.exoplayer.mediacodec.f;
import java.util.concurrent.atomic.AtomicReference;

public class RxJavaPlugins {

    /* renamed from: d  reason: collision with root package name */
    private static final RxJavaPlugins f42097d = new RxJavaPlugins();

    /* renamed from: e  reason: collision with root package name */
    static final RxJavaErrorHandler f42098e = new RxJavaErrorHandler() {
    };

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<RxJavaErrorHandler> f42099a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<RxJavaObservableExecutionHook> f42100b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<RxJavaSchedulersHook> f42101c = new AtomicReference<>();

    RxJavaPlugins() {
    }

    public static RxJavaPlugins b() {
        return f42097d;
    }

    private static Object d(Class<?> cls) {
        String simpleName = cls.getSimpleName();
        String property = System.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException unused) {
            throw new RuntimeException(simpleName + " implementation is not an instance of " + simpleName + ": " + property);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(simpleName + " implementation class not found: " + property, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(simpleName + " implementation not able to be instantiated: " + property, e3);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(simpleName + " implementation not able to be accessed: " + property, e4);
        }
    }

    public RxJavaErrorHandler a() {
        if (this.f42099a.get() == null) {
            Object d2 = d(RxJavaErrorHandler.class);
            if (d2 == null) {
                f.a(this.f42099a, (Object) null, f42098e);
            } else {
                f.a(this.f42099a, (Object) null, (RxJavaErrorHandler) d2);
            }
        }
        return this.f42099a.get();
    }

    public RxJavaObservableExecutionHook c() {
        if (this.f42100b.get() == null) {
            Object d2 = d(RxJavaObservableExecutionHook.class);
            if (d2 == null) {
                f.a(this.f42100b, (Object) null, RxJavaObservableExecutionHookDefault.b());
            } else {
                f.a(this.f42100b, (Object) null, (RxJavaObservableExecutionHook) d2);
            }
        }
        return this.f42100b.get();
    }

    public RxJavaSchedulersHook e() {
        if (this.f42101c.get() == null) {
            Object d2 = d(RxJavaSchedulersHook.class);
            if (d2 == null) {
                f.a(this.f42101c, (Object) null, RxJavaSchedulersHook.b());
            } else {
                f.a(this.f42101c, (Object) null, (RxJavaSchedulersHook) d2);
            }
        }
        return this.f42101c.get();
    }
}
