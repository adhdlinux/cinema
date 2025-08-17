package androidx.mediarouter.media;

import android.media.MediaRouter;

final class MediaRouterJellybeanMr2 {

    public static final class RouteInfo {
        private RouteInfo() {
        }

        public static CharSequence a(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getDescription();
        }

        public static boolean b(Object obj) {
            return ((MediaRouter.RouteInfo) obj).isConnecting();
        }
    }

    public static final class UserRouteInfo {
        private UserRouteInfo() {
        }

        public static void a(Object obj, CharSequence charSequence) {
            ((MediaRouter.UserRouteInfo) obj).setDescription(charSequence);
        }
    }

    private MediaRouterJellybeanMr2() {
    }

    public static void a(Object obj, int i2, Object obj2, int i3) {
        ((MediaRouter) obj).addCallback(i2, (MediaRouter.Callback) obj2, i3);
    }

    public static Object b(Object obj) {
        return ((MediaRouter) obj).getDefaultRoute();
    }
}
