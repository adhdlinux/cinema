package kotlin.internal.jdk8;

import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.random.Random;
import kotlin.random.jdk8.PlatformThreadLocalRandom;

public class JDK8PlatformImplementations extends JDK7PlatformImplementations {

    private static final class ReflectSdkVersion {

        /* renamed from: a  reason: collision with root package name */
        public static final ReflectSdkVersion f40385a = new ReflectSdkVersion();

        /* renamed from: b  reason: collision with root package name */
        public static final Integer f40386b;

        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        static {
            /*
                kotlin.internal.jdk8.JDK8PlatformImplementations$ReflectSdkVersion r0 = new kotlin.internal.jdk8.JDK8PlatformImplementations$ReflectSdkVersion
                r0.<init>()
                f40385a = r0
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
                f40386b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.jdk8.JDK8PlatformImplementations.ReflectSdkVersion.<clinit>():void");
        }

        private ReflectSdkVersion() {
        }
    }

    private final boolean c(int i2) {
        Integer num = ReflectSdkVersion.f40386b;
        return num == null || num.intValue() >= i2;
    }

    public Random b() {
        return c(34) ? new PlatformThreadLocalRandom() : super.b();
    }
}
