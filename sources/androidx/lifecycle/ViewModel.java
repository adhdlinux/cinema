package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class ViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f3755a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Set<Closeable> f3756b = new LinkedHashSet();

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f3757c = false;

    private static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f3757c = true;
        Map<String, Object> map = this.f3755a;
        if (map != null) {
            synchronized (map) {
                for (Object b2 : this.f3755a.values()) {
                    b(b2);
                }
            }
        }
        Set<Closeable> set = this.f3756b;
        if (set != null) {
            synchronized (set) {
                for (Closeable b3 : this.f3756b) {
                    b(b3);
                }
            }
        }
        d();
    }

    /* access modifiers changed from: package-private */
    public <T> T c(String str) {
        T t2;
        Map<String, Object> map = this.f3755a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t2 = this.f3755a.get(str);
        }
        return t2;
    }

    /* access modifiers changed from: protected */
    public void d() {
    }

    /* access modifiers changed from: package-private */
    public <T> T e(String str, T t2) {
        T t3;
        synchronized (this.f3755a) {
            t3 = this.f3755a.get(str);
            if (t3 == null) {
                this.f3755a.put(str, t2);
            }
        }
        if (t3 != null) {
            t2 = t3;
        }
        if (this.f3757c) {
            b(t2);
        }
        return t2;
    }
}
