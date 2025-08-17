package androidx.mediarouter.media;

import android.os.Messenger;

abstract class MediaRouteProviderProtocol {
    private MediaRouteProviderProtocol() {
    }

    public static boolean a(Messenger messenger) {
        if (messenger == null) {
            return false;
        }
        try {
            return messenger.getBinder() != null;
        } catch (NullPointerException unused) {
            return false;
        }
    }
}
