package androidx.mediarouter.media;

import android.media.MediaRouter;
import android.util.Log;
import android.view.Display;
import androidx.mediarouter.media.MediaRouterJellybean;

final class MediaRouterJellybeanMr1 {

    public interface Callback extends MediaRouterJellybean.Callback {
        void i(Object obj);
    }

    static class CallbackProxy<T extends Callback> extends MediaRouterJellybean.CallbackProxy<T> {
        public CallbackProxy(T t2) {
            super(t2);
        }

        public void onRoutePresentationDisplayChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            ((Callback) this.f10647a).i(routeInfo);
        }
    }

    public static final class RouteInfo {
        private RouteInfo() {
        }

        public static Display a(Object obj) {
            try {
                return ((MediaRouter.RouteInfo) obj).getPresentationDisplay();
            } catch (NoSuchMethodError e2) {
                Log.w("MediaRouterJellybeanMr1", "Cannot get presentation display for the route.", e2);
                return null;
            }
        }

        public static boolean b(Object obj) {
            return ((MediaRouter.RouteInfo) obj).isEnabled();
        }
    }

    private MediaRouterJellybeanMr1() {
    }

    public static Object a(Callback callback) {
        return new CallbackProxy(callback);
    }
}
