package androidx.core.net;

import android.net.ConnectivityManager;

public final class ConnectivityManagerCompat {

    static class Api16Impl {
        private Api16Impl() {
        }

        static boolean a(ConnectivityManager connectivityManager) {
            return connectivityManager.isActiveNetworkMetered();
        }
    }

    private ConnectivityManagerCompat() {
    }

    public static boolean a(ConnectivityManager connectivityManager) {
        return Api16Impl.a(connectivityManager);
    }
}
