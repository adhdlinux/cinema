package androidx.mediarouter.media;

import android.content.Context;
import android.media.MediaRouter;
import android.media.RemoteControlClient;
import java.util.ArrayList;
import java.util.List;

final class MediaRouterJellybean {

    public interface Callback {
        void b(Object obj, Object obj2);

        void c(Object obj, Object obj2, int i2);

        void e(Object obj);

        void f(int i2, Object obj);

        void g(Object obj);

        void h(int i2, Object obj);

        void j(Object obj);

        void k(Object obj);
    }

    static class CallbackProxy<T extends Callback> extends MediaRouter.Callback {

        /* renamed from: a  reason: collision with root package name */
        protected final T f10647a;

        public CallbackProxy(T t2) {
            this.f10647a = t2;
        }

        public void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.f10647a.j(routeInfo);
        }

        public void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.f10647a.e(routeInfo);
        }

        public void onRouteGrouped(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup, int i2) {
            this.f10647a.c(routeInfo, routeGroup, i2);
        }

        public void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.f10647a.g(routeInfo);
        }

        public void onRouteSelected(MediaRouter mediaRouter, int i2, MediaRouter.RouteInfo routeInfo) {
            this.f10647a.h(i2, routeInfo);
        }

        public void onRouteUngrouped(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup) {
            this.f10647a.b(routeInfo, routeGroup);
        }

        public void onRouteUnselected(MediaRouter mediaRouter, int i2, MediaRouter.RouteInfo routeInfo) {
            this.f10647a.f(i2, routeInfo);
        }

        public void onRouteVolumeChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.f10647a.k(routeInfo);
        }
    }

    public static final class RouteInfo {
        private RouteInfo() {
        }

        public static CharSequence a(Object obj, Context context) {
            return ((MediaRouter.RouteInfo) obj).getName(context);
        }

        public static int b(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getPlaybackStream();
        }

        public static int c(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getPlaybackType();
        }

        public static int d(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getSupportedTypes();
        }

        public static Object e(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getTag();
        }

        public static int f(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getVolume();
        }

        public static int g(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getVolumeHandling();
        }

        public static int h(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getVolumeMax();
        }

        public static void i(Object obj, int i2) {
            ((MediaRouter.RouteInfo) obj).requestSetVolume(i2);
        }

        public static void j(Object obj, int i2) {
            ((MediaRouter.RouteInfo) obj).requestUpdateVolume(i2);
        }

        public static void k(Object obj, Object obj2) {
            ((MediaRouter.RouteInfo) obj).setTag(obj2);
        }
    }

    public static final class UserRouteInfo {
        private UserRouteInfo() {
        }

        public static void a(Object obj, CharSequence charSequence) {
            ((MediaRouter.UserRouteInfo) obj).setName(charSequence);
        }

        public static void b(Object obj, int i2) {
            ((MediaRouter.UserRouteInfo) obj).setPlaybackStream(i2);
        }

        public static void c(Object obj, int i2) {
            ((MediaRouter.UserRouteInfo) obj).setPlaybackType(i2);
        }

        public static void d(Object obj, Object obj2) {
            ((MediaRouter.UserRouteInfo) obj).setRemoteControlClient((RemoteControlClient) obj2);
        }

        public static void e(Object obj, int i2) {
            ((MediaRouter.UserRouteInfo) obj).setVolume(i2);
        }

        public static void f(Object obj, Object obj2) {
            ((MediaRouter.UserRouteInfo) obj).setVolumeCallback((MediaRouter.VolumeCallback) obj2);
        }

        public static void g(Object obj, int i2) {
            ((MediaRouter.UserRouteInfo) obj).setVolumeHandling(i2);
        }

        public static void h(Object obj, int i2) {
            ((MediaRouter.UserRouteInfo) obj).setVolumeMax(i2);
        }
    }

    public interface VolumeCallback {
        void a(Object obj, int i2);

        void d(Object obj, int i2);
    }

    static class VolumeCallbackProxy<T extends VolumeCallback> extends MediaRouter.VolumeCallback {

        /* renamed from: a  reason: collision with root package name */
        protected final T f10648a;

        public VolumeCallbackProxy(T t2) {
            this.f10648a = t2;
        }

        public void onVolumeSetRequest(MediaRouter.RouteInfo routeInfo, int i2) {
            this.f10648a.d(routeInfo, i2);
        }

        public void onVolumeUpdateRequest(MediaRouter.RouteInfo routeInfo, int i2) {
            this.f10648a.a(routeInfo, i2);
        }
    }

    private MediaRouterJellybean() {
    }

    public static void a(Object obj, Object obj2) {
        ((MediaRouter) obj).addUserRoute((MediaRouter.UserRouteInfo) obj2);
    }

    public static Object b(Object obj, String str, boolean z2) {
        return ((MediaRouter) obj).createRouteCategory(str, z2);
    }

    public static Object c(Object obj, Object obj2) {
        return ((MediaRouter) obj).createUserRoute((MediaRouter.RouteCategory) obj2);
    }

    public static Object d(VolumeCallback volumeCallback) {
        return new VolumeCallbackProxy(volumeCallback);
    }

    public static Object e(Context context) {
        return context.getSystemService("media_router");
    }

    public static List f(Object obj) {
        MediaRouter mediaRouter = (MediaRouter) obj;
        int routeCount = mediaRouter.getRouteCount();
        ArrayList arrayList = new ArrayList(routeCount);
        for (int i2 = 0; i2 < routeCount; i2++) {
            arrayList.add(mediaRouter.getRouteAt(i2));
        }
        return arrayList;
    }

    public static Object g(Object obj, int i2) {
        return ((MediaRouter) obj).getSelectedRoute(i2);
    }

    public static void h(Object obj, Object obj2) {
        ((MediaRouter) obj).removeCallback((MediaRouter.Callback) obj2);
    }

    public static void i(Object obj, Object obj2) {
        ((MediaRouter) obj).removeUserRoute((MediaRouter.UserRouteInfo) obj2);
    }

    public static void j(Object obj, int i2, Object obj2) {
        ((MediaRouter) obj).selectRoute(i2, (MediaRouter.RouteInfo) obj2);
    }
}
