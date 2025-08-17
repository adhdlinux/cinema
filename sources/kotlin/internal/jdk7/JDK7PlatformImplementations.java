package kotlin.internal.jdk7;

import kotlin.internal.PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;

public class JDK7PlatformImplementations extends PlatformImplementations {

    private static final class ReflectSdkVersion {

        /* renamed from: a  reason: collision with root package name */
        public static final ReflectSdkVersion f40383a = new ReflectSdkVersion();

        /* renamed from: b  reason: collision with root package name */
        public static final Integer f40384b;

        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        static {
            /*
                kotlin.internal.jdk7.JDK7PlatformImplementations$ReflectSdkVersion r0 = new kotlin.internal.jdk7.JDK7PlatformImplementations$ReflectSdkVersion
                r0.<init>()
                f40383a = r0
                r0 = 0
                java.lang.String r1 = "android.os.Build$VERSION"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x001f }
                java.lang.String r2 = "SDK_INT"
                java.lang.reflect.Field r1 = r1.getField(r2)     // Catch:{ all -> 0x001f }
                java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x001f }
                boolean r2 = r1 instanceof java.lang.Integer     // Catch:{ all -> 0x001f }
                if (r2 == 0) goto L_0x0020
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x001f }
                goto L_0x0021
            L_0x001f:
            L_0x0020:
                r1 = r0
            L_0x0021:
                if (r1 == 0) goto L_0x002f
                int r2 = r1.intValue()
                if (r2 <= 0) goto L_0x002b
                r2 = 1
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                if (r2 == 0) goto L_0x002f
                r0 = r1
            L_0x002f:
                f40384b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.jdk7.JDK7PlatformImplementations.ReflectSdkVersion.<clinit>():void");
        }

        private ReflectSdkVersion() {
        }
    }

    private final boolean c(int i2) {
        Integer num = ReflectSdkVersion.f40384b;
        return num == null || num.intValue() >= i2;
    }

    public void a(Throwable th, Throwable th2) {
        Intrinsics.f(th, "cause");
        Intrinsics.f(th2, "exception");
        if (c(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
