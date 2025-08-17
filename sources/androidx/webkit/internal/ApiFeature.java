package androidx.webkit.internal;

import android.os.Build;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public abstract class ApiFeature implements ConditionallySupportedFeature {

    /* renamed from: c  reason: collision with root package name */
    private static final Set<ApiFeature> f12065c = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    private final String f12066a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12067b;

    private static class LAZY_HOLDER {

        /* renamed from: a  reason: collision with root package name */
        static final Set<String> f12068a = new HashSet(Arrays.asList(WebViewGlueCommunicator.c().a()));

        private LAZY_HOLDER() {
        }
    }

    public static class M extends ApiFeature {
        M(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= 23;
        }
    }

    public static class N extends ApiFeature {
        N(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= 24;
        }
    }

    public static class NoFramework extends ApiFeature {
        NoFramework(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return false;
        }
    }

    public static class O extends ApiFeature {
        O(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= 26;
        }
    }

    public static class O_MR1 extends ApiFeature {
        O_MR1(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= 27;
        }
    }

    public static class P extends ApiFeature {
        P(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    public static class Q extends ApiFeature {
        Q(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    public static class T extends ApiFeature {
        T(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }

    ApiFeature(String str, String str2) {
        this.f12066a = str;
        this.f12067b = str2;
        f12065c.add(this);
    }

    public static Set<ApiFeature> d() {
        return Collections.unmodifiableSet(f12065c);
    }

    public String a() {
        return this.f12066a;
    }

    public abstract boolean b();

    public boolean c() {
        return BoundaryInterfaceReflectionUtil.containsFeature((Collection<String>) LAZY_HOLDER.f12068a, this.f12067b);
    }

    public boolean isSupported() {
        return b() || c();
    }
}
