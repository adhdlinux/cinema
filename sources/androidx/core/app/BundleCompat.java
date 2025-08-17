package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;

public final class BundleCompat {

    static class Api18Impl {
        private Api18Impl() {
        }

        static IBinder a(Bundle bundle, String str) {
            return bundle.getBinder(str);
        }

        static void b(Bundle bundle, String str, IBinder iBinder) {
            bundle.putBinder(str, iBinder);
        }
    }

    private BundleCompat() {
    }

    public static IBinder a(Bundle bundle, String str) {
        return Api18Impl.a(bundle, str);
    }

    public static void b(Bundle bundle, String str, IBinder iBinder) {
        Api18Impl.b(bundle, str, iBinder);
    }
}
