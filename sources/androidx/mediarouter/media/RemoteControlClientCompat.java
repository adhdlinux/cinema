package androidx.mediarouter.media;

import android.content.Context;
import androidx.mediarouter.media.MediaRouterJellybean;
import java.lang.ref.WeakReference;

abstract class RemoteControlClientCompat {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f10708a;

    /* renamed from: b  reason: collision with root package name */
    protected final Object f10709b;

    /* renamed from: c  reason: collision with root package name */
    protected VolumeCallback f10710c;

    static class JellybeanImpl extends RemoteControlClientCompat {

        /* renamed from: d  reason: collision with root package name */
        private final Object f10711d;

        /* renamed from: e  reason: collision with root package name */
        private final Object f10712e;

        /* renamed from: f  reason: collision with root package name */
        private final Object f10713f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f10714g;

        private static final class VolumeCallbackWrapper implements MediaRouterJellybean.VolumeCallback {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<JellybeanImpl> f10715a;

            public VolumeCallbackWrapper(JellybeanImpl jellybeanImpl) {
                this.f10715a = new WeakReference<>(jellybeanImpl);
            }

            public void a(Object obj, int i2) {
                VolumeCallback volumeCallback;
                JellybeanImpl jellybeanImpl = this.f10715a.get();
                if (jellybeanImpl != null && (volumeCallback = jellybeanImpl.f10710c) != null) {
                    volumeCallback.b(i2);
                }
            }

            public void d(Object obj, int i2) {
                VolumeCallback volumeCallback;
                JellybeanImpl jellybeanImpl = this.f10715a.get();
                if (jellybeanImpl != null && (volumeCallback = jellybeanImpl.f10710c) != null) {
                    volumeCallback.a(i2);
                }
            }
        }

        public JellybeanImpl(Context context, Object obj) {
            super(context, obj);
            Object e2 = MediaRouterJellybean.e(context);
            this.f10711d = e2;
            Object b2 = MediaRouterJellybean.b(e2, "", false);
            this.f10712e = b2;
            this.f10713f = MediaRouterJellybean.c(e2, b2);
        }

        public void c(PlaybackInfo playbackInfo) {
            MediaRouterJellybean.UserRouteInfo.e(this.f10713f, playbackInfo.f10716a);
            MediaRouterJellybean.UserRouteInfo.h(this.f10713f, playbackInfo.f10717b);
            MediaRouterJellybean.UserRouteInfo.g(this.f10713f, playbackInfo.f10718c);
            MediaRouterJellybean.UserRouteInfo.b(this.f10713f, playbackInfo.f10719d);
            MediaRouterJellybean.UserRouteInfo.c(this.f10713f, playbackInfo.f10720e);
            if (!this.f10714g) {
                this.f10714g = true;
                MediaRouterJellybean.UserRouteInfo.f(this.f10713f, MediaRouterJellybean.d(new VolumeCallbackWrapper(this)));
                MediaRouterJellybean.UserRouteInfo.d(this.f10713f, this.f10709b);
            }
        }
    }

    public static final class PlaybackInfo {

        /* renamed from: a  reason: collision with root package name */
        public int f10716a;

        /* renamed from: b  reason: collision with root package name */
        public int f10717b;

        /* renamed from: c  reason: collision with root package name */
        public int f10718c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f10719d = 3;

        /* renamed from: e  reason: collision with root package name */
        public int f10720e = 1;

        /* renamed from: f  reason: collision with root package name */
        public String f10721f;
    }

    public interface VolumeCallback {
        void a(int i2);

        void b(int i2);
    }

    protected RemoteControlClientCompat(Context context, Object obj) {
        this.f10708a = context;
        this.f10709b = obj;
    }

    public static RemoteControlClientCompat b(Context context, Object obj) {
        return new JellybeanImpl(context, obj);
    }

    public Object a() {
        return this.f10709b;
    }

    public abstract void c(PlaybackInfo playbackInfo);

    public void d(VolumeCallback volumeCallback) {
        this.f10710c = volumeCallback;
    }
}
