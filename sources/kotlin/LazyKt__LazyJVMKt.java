package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

class LazyKt__LazyJVMKt {

    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40255a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlin.LazyThreadSafetyMode[] r0 = kotlin.LazyThreadSafetyMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.LazyThreadSafetyMode r1 = kotlin.LazyThreadSafetyMode.SYNCHRONIZED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.LazyThreadSafetyMode r1 = kotlin.LazyThreadSafetyMode.PUBLICATION     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.LazyThreadSafetyMode r1 = kotlin.LazyThreadSafetyMode.NONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f40255a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.LazyKt__LazyJVMKt.WhenMappings.<clinit>():void");
        }
    }

    public static <T> Lazy<T> a(LazyThreadSafetyMode lazyThreadSafetyMode, Function0<? extends T> function0) {
        Intrinsics.f(lazyThreadSafetyMode, "mode");
        Intrinsics.f(function0, "initializer");
        int i2 = WhenMappings.f40255a[lazyThreadSafetyMode.ordinal()];
        if (i2 == 1) {
            return new SynchronizedLazyImpl(function0, (Object) null, 2, (DefaultConstructorMarker) null);
        }
        if (i2 == 2) {
            return new SafePublicationLazyImpl(function0);
        }
        if (i2 == 3) {
            return new UnsafeLazyImpl(function0);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static <T> Lazy<T> b(Function0<? extends T> function0) {
        Intrinsics.f(function0, "initializer");
        return new SynchronizedLazyImpl(function0, (Object) null, 2, (DefaultConstructorMarker) null);
    }
}
