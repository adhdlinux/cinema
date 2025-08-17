package androidx.mediarouter.media;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import androidx.collection.ArrayMap;
import androidx.core.app.ActivityManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pair;
import androidx.media.VolumeProviderCompat;
import androidx.mediarouter.media.MediaRoute2Provider;
import androidx.mediarouter.media.MediaRouteProvider;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.RegisteredMediaRouteProviderWatcher;
import androidx.mediarouter.media.RemoteControlClientCompat;
import androidx.mediarouter.media.SystemMediaRouteProvider;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public final class MediaRouter {

    /* renamed from: c  reason: collision with root package name */
    static final boolean f10548c = Log.isLoggable("MediaRouter", 3);

    /* renamed from: d  reason: collision with root package name */
    static GlobalMediaRouter f10549d;

    /* renamed from: a  reason: collision with root package name */
    final Context f10550a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<CallbackRecord> f10551b = new ArrayList<>();

    public static abstract class Callback {
        public void onProviderAdded(MediaRouter mediaRouter, ProviderInfo providerInfo) {
        }

        public void onProviderChanged(MediaRouter mediaRouter, ProviderInfo providerInfo) {
        }

        public void onProviderRemoved(MediaRouter mediaRouter, ProviderInfo providerInfo) {
        }

        public void onRouteAdded(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        public void onRouteChanged(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        public void onRoutePresentationDisplayChanged(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        public void onRouteRemoved(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        @Deprecated
        public void onRouteSelected(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        public void onRouteSelected(MediaRouter mediaRouter, RouteInfo routeInfo, int i2) {
            onRouteSelected(mediaRouter, routeInfo);
        }

        @Deprecated
        public void onRouteUnselected(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        public void onRouteUnselected(MediaRouter mediaRouter, RouteInfo routeInfo, int i2) {
            onRouteUnselected(mediaRouter, routeInfo);
        }

        public void onRouteVolumeChanged(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        public void onRouterParamsChanged(MediaRouter mediaRouter, MediaRouterParams mediaRouterParams) {
        }

        public void onRouteSelected(MediaRouter mediaRouter, RouteInfo routeInfo, int i2, RouteInfo routeInfo2) {
            onRouteSelected(mediaRouter, routeInfo, i2);
        }
    }

    private static final class CallbackRecord {

        /* renamed from: a  reason: collision with root package name */
        public final MediaRouter f10552a;

        /* renamed from: b  reason: collision with root package name */
        public final Callback f10553b;

        /* renamed from: c  reason: collision with root package name */
        public MediaRouteSelector f10554c = MediaRouteSelector.f10544c;

        /* renamed from: d  reason: collision with root package name */
        public int f10555d;

        /* renamed from: e  reason: collision with root package name */
        public long f10556e;

        public CallbackRecord(MediaRouter mediaRouter, Callback callback) {
            this.f10552a = mediaRouter;
            this.f10553b = callback;
        }

        public boolean a(RouteInfo routeInfo, int i2, RouteInfo routeInfo2, int i3) {
            if ((this.f10555d & 2) != 0 || routeInfo.E(this.f10554c)) {
                return true;
            }
            if (!MediaRouter.r() || !routeInfo.w() || i2 != 262 || i3 != 3 || routeInfo2 == null) {
                return false;
            }
            return !routeInfo2.w();
        }
    }

    public static abstract class ControlRequestCallback {
        public void a(String str, Bundle bundle) {
        }

        public void b(Bundle bundle) {
        }
    }

    static final class GlobalMediaRouter implements SystemMediaRouteProvider.SyncCallback, RegisteredMediaRouteProviderWatcher.Callback {
        private int A;
        OnPrepareTransferListener B;
        PrepareTransferNotifier C;
        private MediaSessionRecord D;
        MediaSessionCompat E;
        private MediaSessionCompat F;
        private final MediaSessionCompat.OnActiveChangeListener G = new MediaSessionCompat.OnActiveChangeListener() {
            public void onActiveChanged() {
                MediaSessionCompat mediaSessionCompat = GlobalMediaRouter.this.E;
                if (mediaSessionCompat == null) {
                    return;
                }
                if (mediaSessionCompat.isActive()) {
                    GlobalMediaRouter globalMediaRouter = GlobalMediaRouter.this;
                    globalMediaRouter.f(globalMediaRouter.E.getRemoteControlClient());
                    return;
                }
                GlobalMediaRouter globalMediaRouter2 = GlobalMediaRouter.this;
                globalMediaRouter2.G(globalMediaRouter2.E.getRemoteControlClient());
            }
        };
        MediaRouteProvider.DynamicGroupRouteController.OnDynamicRoutesChangedListener H = new MediaRouteProvider.DynamicGroupRouteController.OnDynamicRoutesChangedListener() {
            public void a(MediaRouteProvider.DynamicGroupRouteController dynamicGroupRouteController, MediaRouteDescriptor mediaRouteDescriptor, Collection<MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor> collection) {
                GlobalMediaRouter globalMediaRouter = GlobalMediaRouter.this;
                if (dynamicGroupRouteController == globalMediaRouter.f10579w && mediaRouteDescriptor != null) {
                    ProviderInfo q2 = globalMediaRouter.f10578v.q();
                    String l2 = mediaRouteDescriptor.l();
                    RouteInfo routeInfo = new RouteInfo(q2, l2, GlobalMediaRouter.this.g(q2, l2));
                    routeInfo.F(mediaRouteDescriptor);
                    GlobalMediaRouter globalMediaRouter2 = GlobalMediaRouter.this;
                    if (globalMediaRouter2.f10576t != routeInfo) {
                        globalMediaRouter2.E(globalMediaRouter2, routeInfo, globalMediaRouter2.f10579w, 3, globalMediaRouter2.f10578v, collection);
                        GlobalMediaRouter globalMediaRouter3 = GlobalMediaRouter.this;
                        globalMediaRouter3.f10578v = null;
                        globalMediaRouter3.f10579w = null;
                    }
                } else if (dynamicGroupRouteController == globalMediaRouter.f10577u) {
                    if (mediaRouteDescriptor != null) {
                        globalMediaRouter.V(globalMediaRouter.f10576t, mediaRouteDescriptor);
                    }
                    GlobalMediaRouter.this.f10576t.L(collection);
                }
            }
        };

        /* renamed from: a  reason: collision with root package name */
        final Context f10557a;

        /* renamed from: b  reason: collision with root package name */
        boolean f10558b;

        /* renamed from: c  reason: collision with root package name */
        SystemMediaRouteProvider f10559c;

        /* renamed from: d  reason: collision with root package name */
        RegisteredMediaRouteProviderWatcher f10560d;

        /* renamed from: e  reason: collision with root package name */
        boolean f10561e;

        /* renamed from: f  reason: collision with root package name */
        MediaRoute2Provider f10562f;

        /* renamed from: g  reason: collision with root package name */
        final ArrayList<WeakReference<MediaRouter>> f10563g = new ArrayList<>();

        /* renamed from: h  reason: collision with root package name */
        private final ArrayList<RouteInfo> f10564h = new ArrayList<>();

        /* renamed from: i  reason: collision with root package name */
        private final Map<Pair<String, String>, String> f10565i = new HashMap();

        /* renamed from: j  reason: collision with root package name */
        private final ArrayList<ProviderInfo> f10566j = new ArrayList<>();

        /* renamed from: k  reason: collision with root package name */
        private final ArrayList<RemoteControlClientRecord> f10567k = new ArrayList<>();

        /* renamed from: l  reason: collision with root package name */
        final RemoteControlClientCompat.PlaybackInfo f10568l = new RemoteControlClientCompat.PlaybackInfo();

        /* renamed from: m  reason: collision with root package name */
        private final ProviderCallback f10569m = new ProviderCallback();

        /* renamed from: n  reason: collision with root package name */
        final CallbackHandler f10570n = new CallbackHandler();

        /* renamed from: o  reason: collision with root package name */
        private final boolean f10571o;

        /* renamed from: p  reason: collision with root package name */
        private MediaRouterActiveScanThrottlingHelper f10572p;

        /* renamed from: q  reason: collision with root package name */
        private MediaRouterParams f10573q;

        /* renamed from: r  reason: collision with root package name */
        RouteInfo f10574r;

        /* renamed from: s  reason: collision with root package name */
        private RouteInfo f10575s;

        /* renamed from: t  reason: collision with root package name */
        RouteInfo f10576t;

        /* renamed from: u  reason: collision with root package name */
        MediaRouteProvider.RouteController f10577u;

        /* renamed from: v  reason: collision with root package name */
        RouteInfo f10578v;

        /* renamed from: w  reason: collision with root package name */
        MediaRouteProvider.RouteController f10579w;

        /* renamed from: x  reason: collision with root package name */
        final Map<String, MediaRouteProvider.RouteController> f10580x = new HashMap();

        /* renamed from: y  reason: collision with root package name */
        private MediaRouteDiscoveryRequest f10581y;

        /* renamed from: z  reason: collision with root package name */
        private MediaRouteDiscoveryRequest f10582z;

        private final class CallbackHandler extends Handler {

            /* renamed from: a  reason: collision with root package name */
            private final ArrayList<CallbackRecord> f10586a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            private final List<RouteInfo> f10587b = new ArrayList();

            CallbackHandler() {
            }

            private void a(CallbackRecord callbackRecord, int i2, Object obj, int i3) {
                RouteInfo routeInfo;
                RouteInfo routeInfo2;
                MediaRouter mediaRouter = callbackRecord.f10552a;
                Callback callback = callbackRecord.f10553b;
                int i4 = 65280 & i2;
                if (i4 == 256) {
                    if (i2 == 264 || i2 == 262) {
                        routeInfo = (RouteInfo) ((Pair) obj).f2722b;
                    } else {
                        routeInfo = (RouteInfo) obj;
                    }
                    if (i2 == 264 || i2 == 262) {
                        routeInfo2 = (RouteInfo) ((Pair) obj).f2721a;
                    } else {
                        routeInfo2 = null;
                    }
                    if (routeInfo != null && callbackRecord.a(routeInfo, i2, routeInfo2, i3)) {
                        switch (i2) {
                            case 257:
                                callback.onRouteAdded(mediaRouter, routeInfo);
                                return;
                            case 258:
                                callback.onRouteRemoved(mediaRouter, routeInfo);
                                return;
                            case 259:
                                callback.onRouteChanged(mediaRouter, routeInfo);
                                return;
                            case 260:
                                callback.onRouteVolumeChanged(mediaRouter, routeInfo);
                                return;
                            case 261:
                                callback.onRoutePresentationDisplayChanged(mediaRouter, routeInfo);
                                return;
                            case 262:
                                callback.onRouteSelected(mediaRouter, routeInfo, i3, routeInfo);
                                return;
                            case 263:
                                callback.onRouteUnselected(mediaRouter, routeInfo, i3);
                                return;
                            case 264:
                                callback.onRouteSelected(mediaRouter, routeInfo, i3, routeInfo2);
                                return;
                            default:
                                return;
                        }
                    }
                } else if (i4 == 512) {
                    ProviderInfo providerInfo = (ProviderInfo) obj;
                    switch (i2) {
                        case 513:
                            callback.onProviderAdded(mediaRouter, providerInfo);
                            return;
                        case 514:
                            callback.onProviderRemoved(mediaRouter, providerInfo);
                            return;
                        case 515:
                            callback.onProviderChanged(mediaRouter, providerInfo);
                            return;
                        default:
                            return;
                    }
                } else if (i4 == 768 && i2 == 769) {
                    callback.onRouterParamsChanged(mediaRouter, (MediaRouterParams) obj);
                }
            }

            private void d(int i2, Object obj) {
                if (i2 == 262) {
                    RouteInfo routeInfo = (RouteInfo) ((Pair) obj).f2722b;
                    GlobalMediaRouter.this.f10559c.D(routeInfo);
                    if (GlobalMediaRouter.this.f10574r != null && routeInfo.w()) {
                        for (RouteInfo C : this.f10587b) {
                            GlobalMediaRouter.this.f10559c.C(C);
                        }
                        this.f10587b.clear();
                    }
                } else if (i2 != 264) {
                    switch (i2) {
                        case 257:
                            GlobalMediaRouter.this.f10559c.A((RouteInfo) obj);
                            return;
                        case 258:
                            GlobalMediaRouter.this.f10559c.C((RouteInfo) obj);
                            return;
                        case 259:
                            GlobalMediaRouter.this.f10559c.B((RouteInfo) obj);
                            return;
                        default:
                            return;
                    }
                } else {
                    RouteInfo routeInfo2 = (RouteInfo) ((Pair) obj).f2722b;
                    this.f10587b.add(routeInfo2);
                    GlobalMediaRouter.this.f10559c.A(routeInfo2);
                    GlobalMediaRouter.this.f10559c.D(routeInfo2);
                }
            }

            public void b(int i2, Object obj) {
                obtainMessage(i2, obj).sendToTarget();
            }

            public void c(int i2, Object obj, int i3) {
                Message obtainMessage = obtainMessage(i2, obj);
                obtainMessage.arg1 = i3;
                obtainMessage.sendToTarget();
            }

            public void handleMessage(Message message) {
                int i2 = message.what;
                Object obj = message.obj;
                int i3 = message.arg1;
                if (i2 == 259 && GlobalMediaRouter.this.v().k().equals(((RouteInfo) obj).k())) {
                    GlobalMediaRouter.this.W(true);
                }
                d(i2, obj);
                try {
                    int size = GlobalMediaRouter.this.f10563g.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        MediaRouter mediaRouter = (MediaRouter) GlobalMediaRouter.this.f10563g.get(size).get();
                        if (mediaRouter == null) {
                            GlobalMediaRouter.this.f10563g.remove(size);
                        } else {
                            this.f10586a.addAll(mediaRouter.f10551b);
                        }
                    }
                    int size2 = this.f10586a.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a(this.f10586a.get(i4), i2, obj, i3);
                    }
                } finally {
                    this.f10586a.clear();
                }
            }
        }

        private final class MediaSessionRecord {

            /* renamed from: a  reason: collision with root package name */
            private final MediaSessionCompat f10589a;

            /* renamed from: b  reason: collision with root package name */
            private int f10590b;

            /* renamed from: c  reason: collision with root package name */
            private int f10591c;

            /* renamed from: d  reason: collision with root package name */
            private VolumeProviderCompat f10592d;

            MediaSessionRecord(MediaSessionCompat mediaSessionCompat) {
                this.f10589a = mediaSessionCompat;
            }

            public void a() {
                MediaSessionCompat mediaSessionCompat = this.f10589a;
                if (mediaSessionCompat != null) {
                    mediaSessionCompat.setPlaybackToLocal(GlobalMediaRouter.this.f10568l.f10719d);
                    this.f10592d = null;
                }
            }

            public void b(int i2, int i3, int i4, String str) {
                if (this.f10589a != null) {
                    VolumeProviderCompat volumeProviderCompat = this.f10592d;
                    if (volumeProviderCompat != null && i2 == this.f10590b && i3 == this.f10591c) {
                        volumeProviderCompat.h(i4);
                        return;
                    }
                    AnonymousClass1 r2 = new VolumeProviderCompat(i2, i3, i4, str) {
                        public void e(final int i2) {
                            GlobalMediaRouter.this.f10570n.post(new Runnable() {
                                public void run() {
                                    RouteInfo routeInfo = GlobalMediaRouter.this.f10576t;
                                    if (routeInfo != null) {
                                        routeInfo.H(i2);
                                    }
                                }
                            });
                        }

                        public void f(final int i2) {
                            GlobalMediaRouter.this.f10570n.post(new Runnable() {
                                public void run() {
                                    RouteInfo routeInfo = GlobalMediaRouter.this.f10576t;
                                    if (routeInfo != null) {
                                        routeInfo.G(i2);
                                    }
                                }
                            });
                        }
                    };
                    this.f10592d = r2;
                    this.f10589a.setPlaybackToRemote(r2);
                }
            }

            public MediaSessionCompat.Token c() {
                MediaSessionCompat mediaSessionCompat = this.f10589a;
                if (mediaSessionCompat != null) {
                    return mediaSessionCompat.getSessionToken();
                }
                return null;
            }
        }

        final class Mr2ProviderCallback extends MediaRoute2Provider.Callback {
            Mr2ProviderCallback() {
            }

            public void a(MediaRouteProvider.RouteController routeController) {
                if (routeController == GlobalMediaRouter.this.f10577u) {
                    d(2);
                } else if (MediaRouter.f10548c) {
                    Log.d("MediaRouter", "A RouteController unrelated to the selected route is released. controller=" + routeController);
                }
            }

            public void b(int i2) {
                d(i2);
            }

            public void c(String str, int i2) {
                RouteInfo routeInfo;
                Iterator<RouteInfo> it2 = GlobalMediaRouter.this.u().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        routeInfo = null;
                        break;
                    }
                    routeInfo = it2.next();
                    if (routeInfo.r() == GlobalMediaRouter.this.f10562f && TextUtils.equals(str, routeInfo.e())) {
                        break;
                    }
                }
                if (routeInfo == null) {
                    Log.w("MediaRouter", "onSelectRoute: The target RouteInfo is not found for descriptorId=" + str);
                    return;
                }
                GlobalMediaRouter.this.K(routeInfo, i2);
            }

            /* access modifiers changed from: package-private */
            public void d(int i2) {
                RouteInfo h2 = GlobalMediaRouter.this.h();
                if (GlobalMediaRouter.this.v() != h2) {
                    GlobalMediaRouter.this.K(h2, i2);
                }
            }
        }

        private final class ProviderCallback extends MediaRouteProvider.Callback {
            ProviderCallback() {
            }

            public void a(MediaRouteProvider mediaRouteProvider, MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
                GlobalMediaRouter.this.U(mediaRouteProvider, mediaRouteProviderDescriptor);
            }
        }

        private final class RemoteControlClientRecord implements RemoteControlClientCompat.VolumeCallback {

            /* renamed from: a  reason: collision with root package name */
            private final RemoteControlClientCompat f10601a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f10602b;

            public RemoteControlClientRecord(Object obj) {
                RemoteControlClientCompat b2 = RemoteControlClientCompat.b(GlobalMediaRouter.this.f10557a, obj);
                this.f10601a = b2;
                b2.d(this);
                e();
            }

            public void a(int i2) {
                RouteInfo routeInfo;
                if (!this.f10602b && (routeInfo = GlobalMediaRouter.this.f10576t) != null) {
                    routeInfo.G(i2);
                }
            }

            public void b(int i2) {
                RouteInfo routeInfo;
                if (!this.f10602b && (routeInfo = GlobalMediaRouter.this.f10576t) != null) {
                    routeInfo.H(i2);
                }
            }

            public void c() {
                this.f10602b = true;
                this.f10601a.d((RemoteControlClientCompat.VolumeCallback) null);
            }

            public Object d() {
                return this.f10601a.a();
            }

            public void e() {
                this.f10601a.c(GlobalMediaRouter.this.f10568l);
            }
        }

        GlobalMediaRouter(Context context) {
            this.f10557a = context;
            this.f10571o = ActivityManagerCompat.a((ActivityManager) context.getSystemService("activity"));
        }

        private boolean A(RouteInfo routeInfo) {
            if (routeInfo.r() != this.f10559c || !routeInfo.f10619b.equals("DEFAULT_ROUTE")) {
                return false;
            }
            return true;
        }

        private boolean B(RouteInfo routeInfo) {
            if (routeInfo.r() != this.f10559c || !routeInfo.J("android.media.intent.category.LIVE_AUDIO") || routeInfo.J("android.media.intent.category.LIVE_VIDEO")) {
                return false;
            }
            return true;
        }

        private void M(MediaSessionRecord mediaSessionRecord) {
            MediaSessionRecord mediaSessionRecord2 = this.D;
            if (mediaSessionRecord2 != null) {
                mediaSessionRecord2.a();
            }
            this.D = mediaSessionRecord;
            if (mediaSessionRecord != null) {
                S();
            }
        }

        private void O() {
            this.f10572p = new MediaRouterActiveScanThrottlingHelper(new Runnable() {
                public void run() {
                    GlobalMediaRouter.this.Q();
                }
            });
            a(this.f10559c);
            MediaRoute2Provider mediaRoute2Provider = this.f10562f;
            if (mediaRoute2Provider != null) {
                a(mediaRoute2Provider);
            }
            RegisteredMediaRouteProviderWatcher registeredMediaRouteProviderWatcher = new RegisteredMediaRouteProviderWatcher(this.f10557a, this);
            this.f10560d = registeredMediaRouteProviderWatcher;
            registeredMediaRouteProviderWatcher.h();
        }

        private void R(MediaRouteSelector mediaRouteSelector, boolean z2) {
            if (y()) {
                MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest = this.f10582z;
                if (mediaRouteDiscoveryRequest == null || !mediaRouteDiscoveryRequest.c().equals(mediaRouteSelector) || this.f10582z.d() != z2) {
                    if (!mediaRouteSelector.f() || z2) {
                        this.f10582z = new MediaRouteDiscoveryRequest(mediaRouteSelector, z2);
                    } else if (this.f10582z != null) {
                        this.f10582z = null;
                    } else {
                        return;
                    }
                    if (MediaRouter.f10548c) {
                        Log.d("MediaRouter", "Updated MediaRoute2Provider's discovery request: " + this.f10582z);
                    }
                    this.f10562f.x(this.f10582z);
                }
            }
        }

        private void T(ProviderInfo providerInfo, MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
            boolean z2;
            if (providerInfo.h(mediaRouteProviderDescriptor)) {
                int i2 = 0;
                if (mediaRouteProviderDescriptor == null || (!mediaRouteProviderDescriptor.c() && mediaRouteProviderDescriptor != this.f10559c.o())) {
                    Log.w("MediaRouter", "Ignoring invalid provider descriptor: " + mediaRouteProviderDescriptor);
                    z2 = false;
                } else {
                    List<MediaRouteDescriptor> b2 = mediaRouteProviderDescriptor.b();
                    ArrayList<Pair> arrayList = new ArrayList<>();
                    ArrayList<Pair> arrayList2 = new ArrayList<>();
                    z2 = false;
                    for (MediaRouteDescriptor next : b2) {
                        if (next == null || !next.x()) {
                            Log.w("MediaRouter", "Ignoring invalid system route descriptor: " + next);
                        } else {
                            String l2 = next.l();
                            int b3 = providerInfo.b(l2);
                            if (b3 < 0) {
                                RouteInfo routeInfo = new RouteInfo(providerInfo, l2, g(providerInfo, l2));
                                int i3 = i2 + 1;
                                providerInfo.f10615b.add(i2, routeInfo);
                                this.f10564h.add(routeInfo);
                                if (next.j().size() > 0) {
                                    arrayList.add(new Pair(routeInfo, next));
                                } else {
                                    routeInfo.F(next);
                                    if (MediaRouter.f10548c) {
                                        Log.d("MediaRouter", "Route added: " + routeInfo);
                                    }
                                    this.f10570n.b(257, routeInfo);
                                }
                                i2 = i3;
                            } else if (b3 < i2) {
                                Log.w("MediaRouter", "Ignoring route descriptor with duplicate id: " + next);
                            } else {
                                RouteInfo routeInfo2 = providerInfo.f10615b.get(b3);
                                int i4 = i2 + 1;
                                Collections.swap(providerInfo.f10615b, b3, i2);
                                if (next.j().size() > 0) {
                                    arrayList2.add(new Pair(routeInfo2, next));
                                } else if (V(routeInfo2, next) != 0 && routeInfo2 == this.f10576t) {
                                    i2 = i4;
                                    z2 = true;
                                }
                                i2 = i4;
                            }
                        }
                    }
                    for (Pair pair : arrayList) {
                        RouteInfo routeInfo3 = (RouteInfo) pair.f2721a;
                        routeInfo3.F((MediaRouteDescriptor) pair.f2722b);
                        if (MediaRouter.f10548c) {
                            Log.d("MediaRouter", "Route added: " + routeInfo3);
                        }
                        this.f10570n.b(257, routeInfo3);
                    }
                    for (Pair pair2 : arrayList2) {
                        RouteInfo routeInfo4 = (RouteInfo) pair2.f2721a;
                        if (V(routeInfo4, (MediaRouteDescriptor) pair2.f2722b) != 0 && routeInfo4 == this.f10576t) {
                            z2 = true;
                        }
                    }
                }
                for (int size = providerInfo.f10615b.size() - 1; size >= i2; size--) {
                    RouteInfo routeInfo5 = providerInfo.f10615b.get(size);
                    routeInfo5.F((MediaRouteDescriptor) null);
                    this.f10564h.remove(routeInfo5);
                }
                W(z2);
                for (int size2 = providerInfo.f10615b.size() - 1; size2 >= i2; size2--) {
                    RouteInfo remove = providerInfo.f10615b.remove(size2);
                    if (MediaRouter.f10548c) {
                        Log.d("MediaRouter", "Route removed: " + remove);
                    }
                    this.f10570n.b(258, remove);
                }
                if (MediaRouter.f10548c) {
                    Log.d("MediaRouter", "Provider changed: " + providerInfo);
                }
                this.f10570n.b(515, providerInfo);
            }
        }

        private ProviderInfo j(MediaRouteProvider mediaRouteProvider) {
            int size = this.f10566j.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f10566j.get(i2).f10614a == mediaRouteProvider) {
                    return this.f10566j.get(i2);
                }
            }
            return null;
        }

        private int k(Object obj) {
            int size = this.f10567k.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f10567k.get(i2).d() == obj) {
                    return i2;
                }
            }
            return -1;
        }

        private int l(String str) {
            int size = this.f10564h.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f10564h.get(i2).f10620c.equals(str)) {
                    return i2;
                }
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public boolean C() {
            MediaRouterParams mediaRouterParams = this.f10573q;
            if (mediaRouterParams == null) {
                return false;
            }
            return mediaRouterParams.e();
        }

        /* access modifiers changed from: package-private */
        public void D() {
            if (this.f10576t.y()) {
                List<RouteInfo> l2 = this.f10576t.l();
                HashSet hashSet = new HashSet();
                for (RouteInfo routeInfo : l2) {
                    hashSet.add(routeInfo.f10620c);
                }
                Iterator<Map.Entry<String, MediaRouteProvider.RouteController>> it2 = this.f10580x.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry next = it2.next();
                    if (!hashSet.contains(next.getKey())) {
                        MediaRouteProvider.RouteController routeController = (MediaRouteProvider.RouteController) next.getValue();
                        routeController.h(0);
                        routeController.d();
                        it2.remove();
                    }
                }
                for (RouteInfo next2 : l2) {
                    if (!this.f10580x.containsKey(next2.f10620c)) {
                        MediaRouteProvider.RouteController t2 = next2.r().t(next2.f10619b, this.f10576t.f10619b);
                        t2.e();
                        this.f10580x.put(next2.f10620c, t2);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void E(GlobalMediaRouter globalMediaRouter, RouteInfo routeInfo, MediaRouteProvider.RouteController routeController, int i2, RouteInfo routeInfo2, Collection<MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor> collection) {
            OnPrepareTransferListener onPrepareTransferListener;
            PrepareTransferNotifier prepareTransferNotifier = this.C;
            if (prepareTransferNotifier != null) {
                prepareTransferNotifier.a();
                this.C = null;
            }
            PrepareTransferNotifier prepareTransferNotifier2 = new PrepareTransferNotifier(globalMediaRouter, routeInfo, routeController, i2, routeInfo2, collection);
            this.C = prepareTransferNotifier2;
            if (prepareTransferNotifier2.f10605b != 3 || (onPrepareTransferListener = this.B) == null) {
                prepareTransferNotifier2.b();
                return;
            }
            ListenableFuture<Void> onPrepareTransfer = onPrepareTransferListener.onPrepareTransfer(this.f10576t, prepareTransferNotifier2.f10607d);
            if (onPrepareTransfer == null) {
                this.C.b();
            } else {
                this.C.d(onPrepareTransfer);
            }
        }

        /* access modifiers changed from: package-private */
        public void F(RouteInfo routeInfo) {
            if (this.f10577u instanceof MediaRouteProvider.DynamicGroupRouteController) {
                RouteInfo.DynamicGroupState p2 = p(routeInfo);
                if (!this.f10576t.l().contains(routeInfo) || p2 == null || !p2.d()) {
                    Log.w("MediaRouter", "Ignoring attempt to remove a non-unselectable member route : " + routeInfo);
                } else if (this.f10576t.l().size() <= 1) {
                    Log.w("MediaRouter", "Ignoring attempt to remove the last member route.");
                } else {
                    ((MediaRouteProvider.DynamicGroupRouteController) this.f10577u).n(routeInfo.e());
                }
            } else {
                throw new IllegalStateException("There is no currently selected dynamic group route.");
            }
        }

        public void G(Object obj) {
            int k2 = k(obj);
            if (k2 >= 0) {
                this.f10567k.remove(k2).c();
            }
        }

        public void H(RouteInfo routeInfo, int i2) {
            MediaRouteProvider.RouteController routeController;
            MediaRouteProvider.RouteController routeController2;
            if (routeInfo == this.f10576t && (routeController2 = this.f10577u) != null) {
                routeController2.f(i2);
            } else if (!this.f10580x.isEmpty() && (routeController = this.f10580x.get(routeInfo.f10620c)) != null) {
                routeController.f(i2);
            }
        }

        public void I(RouteInfo routeInfo, int i2) {
            MediaRouteProvider.RouteController routeController;
            MediaRouteProvider.RouteController routeController2;
            if (routeInfo == this.f10576t && (routeController2 = this.f10577u) != null) {
                routeController2.i(i2);
            } else if (!this.f10580x.isEmpty() && (routeController = this.f10580x.get(routeInfo.f10620c)) != null) {
                routeController.i(i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void J(RouteInfo routeInfo, int i2) {
            MediaRoute2Provider mediaRoute2Provider;
            if (!this.f10564h.contains(routeInfo)) {
                Log.w("MediaRouter", "Ignoring attempt to select removed route: " + routeInfo);
            } else if (!routeInfo.f10624g) {
                Log.w("MediaRouter", "Ignoring attempt to select disabled route: " + routeInfo);
            } else if (Build.VERSION.SDK_INT < 30 || routeInfo.r() != (mediaRoute2Provider = this.f10562f) || this.f10576t == routeInfo) {
                K(routeInfo, i2);
            } else {
                mediaRoute2Provider.E(routeInfo.e());
            }
        }

        /* access modifiers changed from: package-private */
        public void K(RouteInfo routeInfo, int i2) {
            if (MediaRouter.f10549d == null || (this.f10575s != null && routeInfo.v())) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                StringBuilder sb = new StringBuilder();
                for (int i3 = 3; i3 < stackTrace.length; i3++) {
                    StackTraceElement stackTraceElement = stackTrace[i3];
                    sb.append(stackTraceElement.getClassName());
                    sb.append(".");
                    sb.append(stackTraceElement.getMethodName());
                    sb.append(":");
                    sb.append(stackTraceElement.getLineNumber());
                    sb.append("  ");
                }
                if (MediaRouter.f10549d == null) {
                    Log.w("MediaRouter", "setSelectedRouteInternal is called while sGlobal is null: pkgName=" + this.f10557a.getPackageName() + ", callers=" + sb.toString());
                } else {
                    Log.w("MediaRouter", "Default route is selected while a BT route is available: pkgName=" + this.f10557a.getPackageName() + ", callers=" + sb.toString());
                }
            }
            if (this.f10576t != routeInfo) {
                if (this.f10578v != null) {
                    this.f10578v = null;
                    MediaRouteProvider.RouteController routeController = this.f10579w;
                    if (routeController != null) {
                        routeController.h(3);
                        this.f10579w.d();
                        this.f10579w = null;
                    }
                }
                if (y() && routeInfo.q().g()) {
                    MediaRouteProvider.DynamicGroupRouteController r2 = routeInfo.r().r(routeInfo.f10619b);
                    if (r2 != null) {
                        r2.p(ContextCompat.getMainExecutor(this.f10557a), this.H);
                        this.f10578v = routeInfo;
                        this.f10579w = r2;
                        r2.e();
                        return;
                    }
                    Log.w("MediaRouter", "setSelectedRouteInternal: Failed to create dynamic group route controller. route=" + routeInfo);
                }
                MediaRouteProvider.RouteController s2 = routeInfo.r().s(routeInfo.f10619b);
                if (s2 != null) {
                    s2.e();
                }
                if (MediaRouter.f10548c) {
                    Log.d("MediaRouter", "Route selected: " + routeInfo);
                }
                if (this.f10576t == null) {
                    this.f10576t = routeInfo;
                    this.f10577u = s2;
                    this.f10570n.c(262, new Pair(null, routeInfo), i2);
                    return;
                }
                E(this, routeInfo, s2, i2, (RouteInfo) null, (Collection<MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor>) null);
            }
        }

        public void L(MediaSessionCompat mediaSessionCompat) {
            MediaSessionRecord mediaSessionRecord;
            this.F = mediaSessionCompat;
            if (mediaSessionCompat != null) {
                mediaSessionRecord = new MediaSessionRecord(mediaSessionCompat);
            } else {
                mediaSessionRecord = null;
            }
            M(mediaSessionRecord);
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"NewApi"})
        public void N(MediaRouterParams mediaRouterParams) {
            boolean z2;
            MediaRouterParams mediaRouterParams2 = this.f10573q;
            this.f10573q = mediaRouterParams;
            if (y()) {
                if (this.f10562f == null) {
                    MediaRoute2Provider mediaRoute2Provider = new MediaRoute2Provider(this.f10557a, new Mr2ProviderCallback());
                    this.f10562f = mediaRoute2Provider;
                    a(mediaRoute2Provider);
                    Q();
                    this.f10560d.f();
                }
                boolean z3 = false;
                if (mediaRouterParams2 == null) {
                    z2 = false;
                } else {
                    z2 = mediaRouterParams2.e();
                }
                if (mediaRouterParams != null) {
                    z3 = mediaRouterParams.e();
                }
                if (z2 != z3) {
                    this.f10562f.y(this.f10582z);
                }
            } else {
                MediaRoute2Provider mediaRoute2Provider2 = this.f10562f;
                if (mediaRoute2Provider2 != null) {
                    b(mediaRoute2Provider2);
                    this.f10562f = null;
                    this.f10560d.f();
                }
            }
            this.f10570n.b(769, mediaRouterParams);
        }

        /* access modifiers changed from: package-private */
        public void P(RouteInfo routeInfo) {
            if (this.f10577u instanceof MediaRouteProvider.DynamicGroupRouteController) {
                RouteInfo.DynamicGroupState p2 = p(routeInfo);
                if (p2 == null || !p2.c()) {
                    Log.w("MediaRouter", "Ignoring attempt to transfer to a non-transferable route.");
                } else {
                    ((MediaRouteProvider.DynamicGroupRouteController) this.f10577u).o(Collections.singletonList(routeInfo.e()));
                }
            } else {
                throw new IllegalStateException("There is no currently selected dynamic group route.");
            }
        }

        public void Q() {
            MediaRouteSelector mediaRouteSelector;
            boolean z2;
            MediaRouteSelector.Builder builder = new MediaRouteSelector.Builder();
            this.f10572p.c();
            int size = this.f10563g.size();
            int i2 = 0;
            boolean z3 = false;
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                MediaRouter mediaRouter = (MediaRouter) this.f10563g.get(size).get();
                if (mediaRouter == null) {
                    this.f10563g.remove(size);
                } else {
                    int size2 = mediaRouter.f10551b.size();
                    i2 += size2;
                    for (int i3 = 0; i3 < size2; i3++) {
                        CallbackRecord callbackRecord = mediaRouter.f10551b.get(i3);
                        builder.c(callbackRecord.f10554c);
                        if ((callbackRecord.f10555d & 1) != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.f10572p.b(z2, callbackRecord.f10556e);
                        if (z2) {
                            z3 = true;
                        }
                        int i4 = callbackRecord.f10555d;
                        if ((i4 & 4) != 0 && !this.f10571o) {
                            z3 = true;
                        }
                        if ((i4 & 8) != 0) {
                            z3 = true;
                        }
                    }
                }
            }
            boolean a2 = this.f10572p.a();
            this.A = i2;
            if (z3) {
                mediaRouteSelector = builder.d();
            } else {
                mediaRouteSelector = MediaRouteSelector.f10544c;
            }
            R(builder.d(), a2);
            MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest = this.f10581y;
            if (mediaRouteDiscoveryRequest == null || !mediaRouteDiscoveryRequest.c().equals(mediaRouteSelector) || this.f10581y.d() != a2) {
                if (!mediaRouteSelector.f() || a2) {
                    this.f10581y = new MediaRouteDiscoveryRequest(mediaRouteSelector, a2);
                } else if (this.f10581y != null) {
                    this.f10581y = null;
                } else {
                    return;
                }
                if (MediaRouter.f10548c) {
                    Log.d("MediaRouter", "Updated discovery request: " + this.f10581y);
                }
                if (z3 && !a2 && this.f10571o) {
                    Log.i("MediaRouter", "Forcing passive route discovery on a low-RAM device, system performance may be affected.  Please consider using CALLBACK_FLAG_REQUEST_DISCOVERY instead of CALLBACK_FLAG_FORCE_DISCOVERY.");
                }
                int size3 = this.f10566j.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    MediaRouteProvider mediaRouteProvider = this.f10566j.get(i5).f10614a;
                    if (mediaRouteProvider != this.f10562f) {
                        mediaRouteProvider.x(this.f10581y);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"NewApi"})
        public void S() {
            RouteInfo routeInfo = this.f10576t;
            if (routeInfo != null) {
                this.f10568l.f10716a = routeInfo.s();
                this.f10568l.f10717b = this.f10576t.u();
                this.f10568l.f10718c = this.f10576t.t();
                this.f10568l.f10719d = this.f10576t.n();
                this.f10568l.f10720e = this.f10576t.o();
                if (!y() || this.f10576t.r() != this.f10562f) {
                    this.f10568l.f10721f = null;
                } else {
                    this.f10568l.f10721f = MediaRoute2Provider.B(this.f10577u);
                }
                int size = this.f10567k.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    this.f10567k.get(i3).e();
                }
                if (this.D == null) {
                    return;
                }
                if (this.f10576t == o() || this.f10576t == m()) {
                    this.D.a();
                    return;
                }
                RemoteControlClientCompat.PlaybackInfo playbackInfo = this.f10568l;
                if (playbackInfo.f10718c == 1) {
                    i2 = 2;
                }
                this.D.b(i2, playbackInfo.f10717b, playbackInfo.f10716a, playbackInfo.f10721f);
                return;
            }
            MediaSessionRecord mediaSessionRecord = this.D;
            if (mediaSessionRecord != null) {
                mediaSessionRecord.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void U(MediaRouteProvider mediaRouteProvider, MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
            ProviderInfo j2 = j(mediaRouteProvider);
            if (j2 != null) {
                T(j2, mediaRouteProviderDescriptor);
            }
        }

        /* access modifiers changed from: package-private */
        public int V(RouteInfo routeInfo, MediaRouteDescriptor mediaRouteDescriptor) {
            int F2 = routeInfo.F(mediaRouteDescriptor);
            if (F2 != 0) {
                if ((F2 & 1) != 0) {
                    if (MediaRouter.f10548c) {
                        Log.d("MediaRouter", "Route changed: " + routeInfo);
                    }
                    this.f10570n.b(259, routeInfo);
                }
                if ((F2 & 2) != 0) {
                    if (MediaRouter.f10548c) {
                        Log.d("MediaRouter", "Route volume changed: " + routeInfo);
                    }
                    this.f10570n.b(260, routeInfo);
                }
                if ((F2 & 4) != 0) {
                    if (MediaRouter.f10548c) {
                        Log.d("MediaRouter", "Route presentation display changed: " + routeInfo);
                    }
                    this.f10570n.b(261, routeInfo);
                }
            }
            return F2;
        }

        /* access modifiers changed from: package-private */
        public void W(boolean z2) {
            RouteInfo routeInfo = this.f10574r;
            if (routeInfo != null && !routeInfo.B()) {
                Log.i("MediaRouter", "Clearing the default route because it is no longer selectable: " + this.f10574r);
                this.f10574r = null;
            }
            if (this.f10574r == null && !this.f10564h.isEmpty()) {
                Iterator<RouteInfo> it2 = this.f10564h.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    RouteInfo next = it2.next();
                    if (A(next) && next.B()) {
                        this.f10574r = next;
                        Log.i("MediaRouter", "Found default route: " + this.f10574r);
                        break;
                    }
                }
            }
            RouteInfo routeInfo2 = this.f10575s;
            if (routeInfo2 != null && !routeInfo2.B()) {
                Log.i("MediaRouter", "Clearing the bluetooth route because it is no longer selectable: " + this.f10575s);
                this.f10575s = null;
            }
            if (this.f10575s == null && !this.f10564h.isEmpty()) {
                Iterator<RouteInfo> it3 = this.f10564h.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    RouteInfo next2 = it3.next();
                    if (B(next2) && next2.B()) {
                        this.f10575s = next2;
                        Log.i("MediaRouter", "Found bluetooth route: " + this.f10575s);
                        break;
                    }
                }
            }
            RouteInfo routeInfo3 = this.f10576t;
            if (routeInfo3 == null || !routeInfo3.x()) {
                Log.i("MediaRouter", "Unselecting the current route because it is no longer selectable: " + this.f10576t);
                K(h(), 0);
            } else if (z2) {
                D();
                S();
            }
        }

        public void a(MediaRouteProvider mediaRouteProvider) {
            if (j(mediaRouteProvider) == null) {
                ProviderInfo providerInfo = new ProviderInfo(mediaRouteProvider);
                this.f10566j.add(providerInfo);
                if (MediaRouter.f10548c) {
                    Log.d("MediaRouter", "Provider added: " + providerInfo);
                }
                this.f10570n.b(513, providerInfo);
                T(providerInfo, mediaRouteProvider.o());
                mediaRouteProvider.v(this.f10569m);
                mediaRouteProvider.x(this.f10581y);
            }
        }

        public void b(MediaRouteProvider mediaRouteProvider) {
            ProviderInfo j2 = j(mediaRouteProvider);
            if (j2 != null) {
                mediaRouteProvider.v((MediaRouteProvider.Callback) null);
                mediaRouteProvider.x((MediaRouteDiscoveryRequest) null);
                T(j2, (MediaRouteProviderDescriptor) null);
                if (MediaRouter.f10548c) {
                    Log.d("MediaRouter", "Provider removed: " + j2);
                }
                this.f10570n.b(514, j2);
                this.f10566j.remove(j2);
            }
        }

        public void c(String str) {
            RouteInfo a2;
            this.f10570n.removeMessages(262);
            ProviderInfo j2 = j(this.f10559c);
            if (j2 != null && (a2 = j2.a(str)) != null) {
                a2.I();
            }
        }

        public void d(RegisteredMediaRouteProvider registeredMediaRouteProvider, MediaRouteProvider.RouteController routeController) {
            if (this.f10577u == routeController) {
                J(h(), 2);
            }
        }

        /* access modifiers changed from: package-private */
        public void e(RouteInfo routeInfo) {
            if (this.f10577u instanceof MediaRouteProvider.DynamicGroupRouteController) {
                RouteInfo.DynamicGroupState p2 = p(routeInfo);
                if (this.f10576t.l().contains(routeInfo) || p2 == null || !p2.b()) {
                    Log.w("MediaRouter", "Ignoring attempt to add a non-groupable route to dynamic group : " + routeInfo);
                    return;
                }
                ((MediaRouteProvider.DynamicGroupRouteController) this.f10577u).m(routeInfo.e());
                return;
            }
            throw new IllegalStateException("There is no currently selected dynamic group route.");
        }

        public void f(Object obj) {
            if (k(obj) < 0) {
                this.f10567k.add(new RemoteControlClientRecord(obj));
            }
        }

        /* access modifiers changed from: package-private */
        public String g(ProviderInfo providerInfo, String str) {
            String flattenToShortString = providerInfo.c().flattenToShortString();
            String str2 = flattenToShortString + ":" + str;
            if (l(str2) < 0) {
                this.f10565i.put(new Pair(flattenToShortString, str), str2);
                return str2;
            }
            Log.w("MediaRouter", "Either " + str + " isn't unique in " + flattenToShortString + " or we're trying to assign a unique ID for an already added route");
            int i2 = 2;
            while (true) {
                String format = String.format(Locale.US, "%s_%d", new Object[]{str2, Integer.valueOf(i2)});
                if (l(format) < 0) {
                    this.f10565i.put(new Pair(flattenToShortString, str), format);
                    return format;
                }
                i2++;
            }
        }

        /* access modifiers changed from: package-private */
        public RouteInfo h() {
            Iterator<RouteInfo> it2 = this.f10564h.iterator();
            while (it2.hasNext()) {
                RouteInfo next = it2.next();
                if (next != this.f10574r && B(next) && next.B()) {
                    return next;
                }
            }
            return this.f10574r;
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"NewApi", "SyntheticAccessor"})
        public void i() {
            if (!this.f10558b) {
                this.f10558b = true;
                if (Build.VERSION.SDK_INT >= 30) {
                    this.f10561e = MediaTransferReceiver.a(this.f10557a);
                } else {
                    this.f10561e = false;
                }
                if (this.f10561e) {
                    this.f10562f = new MediaRoute2Provider(this.f10557a, new Mr2ProviderCallback());
                } else {
                    this.f10562f = null;
                }
                this.f10559c = SystemMediaRouteProvider.z(this.f10557a, this);
                O();
            }
        }

        /* access modifiers changed from: package-private */
        public RouteInfo m() {
            return this.f10575s;
        }

        /* access modifiers changed from: package-private */
        public int n() {
            return this.A;
        }

        /* access modifiers changed from: package-private */
        public RouteInfo o() {
            RouteInfo routeInfo = this.f10574r;
            if (routeInfo != null) {
                return routeInfo;
            }
            throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
        }

        /* access modifiers changed from: package-private */
        public RouteInfo.DynamicGroupState p(RouteInfo routeInfo) {
            return this.f10576t.h(routeInfo);
        }

        public MediaSessionCompat.Token q() {
            MediaSessionRecord mediaSessionRecord = this.D;
            if (mediaSessionRecord != null) {
                return mediaSessionRecord.c();
            }
            MediaSessionCompat mediaSessionCompat = this.F;
            if (mediaSessionCompat != null) {
                return mediaSessionCompat.getSessionToken();
            }
            return null;
        }

        public RouteInfo r(String str) {
            Iterator<RouteInfo> it2 = this.f10564h.iterator();
            while (it2.hasNext()) {
                RouteInfo next = it2.next();
                if (next.f10620c.equals(str)) {
                    return next;
                }
            }
            return null;
        }

        public MediaRouter s(Context context) {
            int size = this.f10563g.size();
            while (true) {
                size--;
                if (size >= 0) {
                    MediaRouter mediaRouter = (MediaRouter) this.f10563g.get(size).get();
                    if (mediaRouter == null) {
                        this.f10563g.remove(size);
                    } else if (mediaRouter.f10550a == context) {
                        return mediaRouter;
                    }
                } else {
                    MediaRouter mediaRouter2 = new MediaRouter(context);
                    this.f10563g.add(new WeakReference(mediaRouter2));
                    return mediaRouter2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public MediaRouterParams t() {
            return this.f10573q;
        }

        public List<RouteInfo> u() {
            return this.f10564h;
        }

        /* access modifiers changed from: package-private */
        public RouteInfo v() {
            RouteInfo routeInfo = this.f10576t;
            if (routeInfo != null) {
                return routeInfo;
            }
            throw new IllegalStateException("There is no currently selected route.  The media router has not yet been fully initialized.");
        }

        /* access modifiers changed from: package-private */
        public String w(ProviderInfo providerInfo, String str) {
            return this.f10565i.get(new Pair(providerInfo.c().flattenToShortString(), str));
        }

        public boolean x() {
            Bundle bundle;
            MediaRouterParams mediaRouterParams = this.f10573q;
            if (mediaRouterParams == null || (bundle = mediaRouterParams.f10653e) == null || bundle.getBoolean("androidx.mediarouter.media.MediaRouterParams.ENABLE_GROUP_VOLUME_UX", true)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean y() {
            MediaRouterParams mediaRouterParams;
            if (!this.f10561e || ((mediaRouterParams = this.f10573q) != null && !mediaRouterParams.c())) {
                return false;
            }
            return true;
        }

        public boolean z(MediaRouteSelector mediaRouteSelector, int i2) {
            boolean z2;
            if (mediaRouteSelector.f()) {
                return false;
            }
            if ((i2 & 2) == 0 && this.f10571o) {
                return true;
            }
            MediaRouterParams mediaRouterParams = this.f10573q;
            if (mediaRouterParams == null || !mediaRouterParams.d() || !y()) {
                z2 = false;
            } else {
                z2 = true;
            }
            int size = this.f10564h.size();
            for (int i3 = 0; i3 < size; i3++) {
                RouteInfo routeInfo = this.f10564h.get(i3);
                if (((i2 & 1) == 0 || !routeInfo.w()) && ((!z2 || routeInfo.w() || routeInfo.r() == this.f10562f) && routeInfo.E(mediaRouteSelector))) {
                    return true;
                }
            }
            return false;
        }
    }

    public interface OnPrepareTransferListener {
        ListenableFuture<Void> onPrepareTransfer(RouteInfo routeInfo, RouteInfo routeInfo2);
    }

    static final class PrepareTransferNotifier {

        /* renamed from: a  reason: collision with root package name */
        final MediaRouteProvider.RouteController f10604a;

        /* renamed from: b  reason: collision with root package name */
        final int f10605b;

        /* renamed from: c  reason: collision with root package name */
        private final RouteInfo f10606c;

        /* renamed from: d  reason: collision with root package name */
        final RouteInfo f10607d;

        /* renamed from: e  reason: collision with root package name */
        private final RouteInfo f10608e;

        /* renamed from: f  reason: collision with root package name */
        final List<MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor> f10609f;

        /* renamed from: g  reason: collision with root package name */
        private final WeakReference<GlobalMediaRouter> f10610g;

        /* renamed from: h  reason: collision with root package name */
        private ListenableFuture<Void> f10611h = null;

        /* renamed from: i  reason: collision with root package name */
        private boolean f10612i = false;

        /* renamed from: j  reason: collision with root package name */
        private boolean f10613j = false;

        PrepareTransferNotifier(GlobalMediaRouter globalMediaRouter, RouteInfo routeInfo, MediaRouteProvider.RouteController routeController, int i2, RouteInfo routeInfo2, Collection<MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor> collection) {
            ArrayList arrayList = null;
            this.f10610g = new WeakReference<>(globalMediaRouter);
            this.f10607d = routeInfo;
            this.f10604a = routeController;
            this.f10605b = i2;
            this.f10606c = globalMediaRouter.f10576t;
            this.f10608e = routeInfo2;
            this.f10609f = collection != null ? new ArrayList(collection) : arrayList;
            globalMediaRouter.f10570n.postDelayed(new b0(this), 15000);
        }

        private void c() {
            GlobalMediaRouter globalMediaRouter = this.f10610g.get();
            if (globalMediaRouter != null) {
                RouteInfo routeInfo = this.f10607d;
                globalMediaRouter.f10576t = routeInfo;
                globalMediaRouter.f10577u = this.f10604a;
                RouteInfo routeInfo2 = this.f10608e;
                if (routeInfo2 == null) {
                    globalMediaRouter.f10570n.c(262, new Pair(this.f10606c, routeInfo), this.f10605b);
                } else {
                    globalMediaRouter.f10570n.c(264, new Pair(routeInfo2, routeInfo), this.f10605b);
                }
                globalMediaRouter.f10580x.clear();
                globalMediaRouter.D();
                globalMediaRouter.S();
                List<MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor> list = this.f10609f;
                if (list != null) {
                    globalMediaRouter.f10576t.L(list);
                }
            }
        }

        private void e() {
            RouteInfo routeInfo;
            GlobalMediaRouter globalMediaRouter = this.f10610g.get();
            if (globalMediaRouter != null && globalMediaRouter.f10576t == (routeInfo = this.f10606c)) {
                globalMediaRouter.f10570n.c(263, routeInfo, this.f10605b);
                MediaRouteProvider.RouteController routeController = globalMediaRouter.f10577u;
                if (routeController != null) {
                    routeController.h(this.f10605b);
                    globalMediaRouter.f10577u.d();
                }
                if (!globalMediaRouter.f10580x.isEmpty()) {
                    for (MediaRouteProvider.RouteController next : globalMediaRouter.f10580x.values()) {
                        next.h(this.f10605b);
                        next.d();
                    }
                    globalMediaRouter.f10580x.clear();
                }
                globalMediaRouter.f10577u = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (!this.f10612i && !this.f10613j) {
                this.f10613j = true;
                MediaRouteProvider.RouteController routeController = this.f10604a;
                if (routeController != null) {
                    routeController.h(0);
                    this.f10604a.d();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            ListenableFuture<Void> listenableFuture;
            MediaRouter.d();
            if (!this.f10612i && !this.f10613j) {
                GlobalMediaRouter globalMediaRouter = this.f10610g.get();
                if (globalMediaRouter == null || globalMediaRouter.C != this || ((listenableFuture = this.f10611h) != null && listenableFuture.isCancelled())) {
                    a();
                    return;
                }
                this.f10612i = true;
                globalMediaRouter.C = null;
                e();
                c();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(ListenableFuture<Void> listenableFuture) {
            GlobalMediaRouter globalMediaRouter = this.f10610g.get();
            if (globalMediaRouter == null || globalMediaRouter.C != this) {
                Log.w("MediaRouter", "Router is released. Cancel transfer");
                a();
            } else if (this.f10611h == null) {
                this.f10611h = listenableFuture;
                b0 b0Var = new b0(this);
                GlobalMediaRouter.CallbackHandler callbackHandler = globalMediaRouter.f10570n;
                Objects.requireNonNull(callbackHandler);
                listenableFuture.addListener(b0Var, new c0(callbackHandler));
            } else {
                throw new IllegalStateException("future is already set");
            }
        }
    }

    public static final class ProviderInfo {

        /* renamed from: a  reason: collision with root package name */
        final MediaRouteProvider f10614a;

        /* renamed from: b  reason: collision with root package name */
        final List<RouteInfo> f10615b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final MediaRouteProvider.ProviderMetadata f10616c;

        /* renamed from: d  reason: collision with root package name */
        private MediaRouteProviderDescriptor f10617d;

        ProviderInfo(MediaRouteProvider mediaRouteProvider) {
            this.f10614a = mediaRouteProvider;
            this.f10616c = mediaRouteProvider.q();
        }

        /* access modifiers changed from: package-private */
        public RouteInfo a(String str) {
            int size = this.f10615b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f10615b.get(i2).f10619b.equals(str)) {
                    return this.f10615b.get(i2);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int b(String str) {
            int size = this.f10615b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f10615b.get(i2).f10619b.equals(str)) {
                    return i2;
                }
            }
            return -1;
        }

        public ComponentName c() {
            return this.f10616c.a();
        }

        public String d() {
            return this.f10616c.b();
        }

        public MediaRouteProvider e() {
            MediaRouter.d();
            return this.f10614a;
        }

        public List<RouteInfo> f() {
            MediaRouter.d();
            return Collections.unmodifiableList(this.f10615b);
        }

        /* access modifiers changed from: package-private */
        public boolean g() {
            MediaRouteProviderDescriptor mediaRouteProviderDescriptor = this.f10617d;
            return mediaRouteProviderDescriptor != null && mediaRouteProviderDescriptor.d();
        }

        /* access modifiers changed from: package-private */
        public boolean h(MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
            if (this.f10617d == mediaRouteProviderDescriptor) {
                return false;
            }
            this.f10617d = mediaRouteProviderDescriptor;
            return true;
        }

        public String toString() {
            return "MediaRouter.RouteProviderInfo{ packageName=" + d() + " }";
        }
    }

    public static class RouteInfo {

        /* renamed from: a  reason: collision with root package name */
        private final ProviderInfo f10618a;

        /* renamed from: b  reason: collision with root package name */
        final String f10619b;

        /* renamed from: c  reason: collision with root package name */
        final String f10620c;

        /* renamed from: d  reason: collision with root package name */
        private String f10621d;

        /* renamed from: e  reason: collision with root package name */
        private String f10622e;

        /* renamed from: f  reason: collision with root package name */
        private Uri f10623f;

        /* renamed from: g  reason: collision with root package name */
        boolean f10624g;

        /* renamed from: h  reason: collision with root package name */
        private int f10625h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f10626i;

        /* renamed from: j  reason: collision with root package name */
        private final ArrayList<IntentFilter> f10627j = new ArrayList<>();

        /* renamed from: k  reason: collision with root package name */
        private int f10628k;

        /* renamed from: l  reason: collision with root package name */
        private int f10629l;

        /* renamed from: m  reason: collision with root package name */
        private int f10630m;

        /* renamed from: n  reason: collision with root package name */
        private int f10631n;

        /* renamed from: o  reason: collision with root package name */
        private int f10632o;

        /* renamed from: p  reason: collision with root package name */
        private int f10633p;

        /* renamed from: q  reason: collision with root package name */
        private Display f10634q;

        /* renamed from: r  reason: collision with root package name */
        private int f10635r = -1;

        /* renamed from: s  reason: collision with root package name */
        private Bundle f10636s;

        /* renamed from: t  reason: collision with root package name */
        private IntentSender f10637t;

        /* renamed from: u  reason: collision with root package name */
        MediaRouteDescriptor f10638u;

        /* renamed from: v  reason: collision with root package name */
        private List<RouteInfo> f10639v = new ArrayList();

        /* renamed from: w  reason: collision with root package name */
        private Map<String, MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor> f10640w;

        public static final class DynamicGroupState {

            /* renamed from: a  reason: collision with root package name */
            final MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor f10641a;

            DynamicGroupState(MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor dynamicRouteDescriptor) {
                this.f10641a = dynamicRouteDescriptor;
            }

            public int a() {
                MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor dynamicRouteDescriptor = this.f10641a;
                if (dynamicRouteDescriptor != null) {
                    return dynamicRouteDescriptor.c();
                }
                return 1;
            }

            public boolean b() {
                MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor dynamicRouteDescriptor = this.f10641a;
                return dynamicRouteDescriptor != null && dynamicRouteDescriptor.d();
            }

            public boolean c() {
                MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor dynamicRouteDescriptor = this.f10641a;
                return dynamicRouteDescriptor != null && dynamicRouteDescriptor.e();
            }

            public boolean d() {
                MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor dynamicRouteDescriptor = this.f10641a;
                return dynamicRouteDescriptor == null || dynamicRouteDescriptor.f();
            }
        }

        RouteInfo(ProviderInfo providerInfo, String str, String str2) {
            this.f10618a = providerInfo;
            this.f10619b = str;
            this.f10620c = str2;
        }

        private boolean A(List<IntentFilter> list, List<IntentFilter> list2) {
            if (list == list2) {
                return true;
            }
            if (list == null || list2 == null) {
                return false;
            }
            ListIterator<IntentFilter> listIterator = list.listIterator();
            ListIterator<IntentFilter> listIterator2 = list2.listIterator();
            while (listIterator.hasNext() && listIterator2.hasNext()) {
                if (!z(listIterator.next(), listIterator2.next())) {
                    return false;
                }
            }
            if (listIterator.hasNext() || listIterator2.hasNext()) {
                return false;
            }
            return true;
        }

        private static boolean D(RouteInfo routeInfo) {
            return TextUtils.equals(routeInfo.r().q().b(), "android");
        }

        private boolean z(IntentFilter intentFilter, IntentFilter intentFilter2) {
            int countActions;
            if (intentFilter == intentFilter2) {
                return true;
            }
            if (intentFilter == null || intentFilter2 == null || (countActions = intentFilter.countActions()) != intentFilter2.countActions()) {
                return false;
            }
            for (int i2 = 0; i2 < countActions; i2++) {
                if (!intentFilter.getAction(i2).equals(intentFilter2.getAction(i2))) {
                    return false;
                }
            }
            int countCategories = intentFilter.countCategories();
            if (countCategories != intentFilter2.countCategories()) {
                return false;
            }
            for (int i3 = 0; i3 < countCategories; i3++) {
                if (!intentFilter.getCategory(i3).equals(intentFilter2.getCategory(i3))) {
                    return false;
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean B() {
            return this.f10638u != null && this.f10624g;
        }

        public boolean C() {
            MediaRouter.d();
            if (MediaRouter.i().v() == this) {
                return true;
            }
            return false;
        }

        public boolean E(MediaRouteSelector mediaRouteSelector) {
            if (mediaRouteSelector != null) {
                MediaRouter.d();
                return mediaRouteSelector.h(this.f10627j);
            }
            throw new IllegalArgumentException("selector must not be null");
        }

        /* access modifiers changed from: package-private */
        public int F(MediaRouteDescriptor mediaRouteDescriptor) {
            if (this.f10638u != mediaRouteDescriptor) {
                return K(mediaRouteDescriptor);
            }
            return 0;
        }

        public void G(int i2) {
            MediaRouter.d();
            MediaRouter.i().H(this, Math.min(this.f10633p, Math.max(0, i2)));
        }

        public void H(int i2) {
            MediaRouter.d();
            if (i2 != 0) {
                MediaRouter.i().I(this, i2);
            }
        }

        public void I() {
            MediaRouter.d();
            MediaRouter.i().J(this, 3);
        }

        public boolean J(String str) {
            if (str != null) {
                MediaRouter.d();
                int size = this.f10627j.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.f10627j.get(i2).hasCategory(str)) {
                        return true;
                    }
                }
                return false;
            }
            throw new IllegalArgumentException("category must not be null");
        }

        /* access modifiers changed from: package-private */
        public int K(MediaRouteDescriptor mediaRouteDescriptor) {
            int i2;
            this.f10638u = mediaRouteDescriptor;
            boolean z2 = false;
            if (mediaRouteDescriptor == null) {
                return 0;
            }
            if (!ObjectsCompat.a(this.f10621d, mediaRouteDescriptor.o())) {
                this.f10621d = mediaRouteDescriptor.o();
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (!ObjectsCompat.a(this.f10622e, mediaRouteDescriptor.g())) {
                this.f10622e = mediaRouteDescriptor.g();
                i2 |= 1;
            }
            if (!ObjectsCompat.a(this.f10623f, mediaRouteDescriptor.k())) {
                this.f10623f = mediaRouteDescriptor.k();
                i2 |= 1;
            }
            if (this.f10624g != mediaRouteDescriptor.w()) {
                this.f10624g = mediaRouteDescriptor.w();
                i2 |= 1;
            }
            if (this.f10625h != mediaRouteDescriptor.e()) {
                this.f10625h = mediaRouteDescriptor.e();
                i2 |= 1;
            }
            if (!A(this.f10627j, mediaRouteDescriptor.f())) {
                this.f10627j.clear();
                this.f10627j.addAll(mediaRouteDescriptor.f());
                i2 |= 1;
            }
            if (this.f10628k != mediaRouteDescriptor.q()) {
                this.f10628k = mediaRouteDescriptor.q();
                i2 |= 1;
            }
            if (this.f10629l != mediaRouteDescriptor.p()) {
                this.f10629l = mediaRouteDescriptor.p();
                i2 |= 1;
            }
            if (this.f10630m != mediaRouteDescriptor.h()) {
                this.f10630m = mediaRouteDescriptor.h();
                i2 |= 1;
            }
            if (this.f10631n != mediaRouteDescriptor.u()) {
                this.f10631n = mediaRouteDescriptor.u();
                i2 |= 3;
            }
            if (this.f10632o != mediaRouteDescriptor.t()) {
                this.f10632o = mediaRouteDescriptor.t();
                i2 |= 3;
            }
            if (this.f10633p != mediaRouteDescriptor.v()) {
                this.f10633p = mediaRouteDescriptor.v();
                i2 |= 3;
            }
            if (this.f10635r != mediaRouteDescriptor.r()) {
                this.f10635r = mediaRouteDescriptor.r();
                this.f10634q = null;
                i2 |= 5;
            }
            if (!ObjectsCompat.a(this.f10636s, mediaRouteDescriptor.i())) {
                this.f10636s = mediaRouteDescriptor.i();
                i2 |= 1;
            }
            if (!ObjectsCompat.a(this.f10637t, mediaRouteDescriptor.s())) {
                this.f10637t = mediaRouteDescriptor.s();
                i2 |= 1;
            }
            if (this.f10626i != mediaRouteDescriptor.a()) {
                this.f10626i = mediaRouteDescriptor.a();
                i2 |= 5;
            }
            List<String> j2 = mediaRouteDescriptor.j();
            ArrayList arrayList = new ArrayList();
            if (j2.size() != this.f10639v.size()) {
                z2 = true;
            }
            if (!j2.isEmpty()) {
                GlobalMediaRouter i3 = MediaRouter.i();
                for (String w2 : j2) {
                    RouteInfo r2 = i3.r(i3.w(q(), w2));
                    if (r2 != null) {
                        arrayList.add(r2);
                        if (!z2 && !this.f10639v.contains(r2)) {
                            z2 = true;
                        }
                    }
                }
            }
            if (!z2) {
                return i2;
            }
            this.f10639v = arrayList;
            return i2 | 1;
        }

        /* access modifiers changed from: package-private */
        public void L(Collection<MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor> collection) {
            this.f10639v.clear();
            if (this.f10640w == null) {
                this.f10640w = new ArrayMap();
            }
            this.f10640w.clear();
            for (MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor next : collection) {
                RouteInfo b2 = b(next);
                if (b2 != null) {
                    this.f10640w.put(b2.f10620c, next);
                    if (next.c() == 2 || next.c() == 3) {
                        this.f10639v.add(b2);
                    }
                }
            }
            MediaRouter.i().f10570n.b(259, this);
        }

        public boolean a() {
            return this.f10626i;
        }

        /* access modifiers changed from: package-private */
        public RouteInfo b(MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor dynamicRouteDescriptor) {
            return q().a(dynamicRouteDescriptor.b().l());
        }

        public int c() {
            return this.f10625h;
        }

        public String d() {
            return this.f10622e;
        }

        /* access modifiers changed from: package-private */
        public String e() {
            return this.f10619b;
        }

        public int f() {
            return this.f10630m;
        }

        public MediaRouteProvider.DynamicGroupRouteController g() {
            MediaRouter.d();
            MediaRouteProvider.RouteController routeController = MediaRouter.i().f10577u;
            if (routeController instanceof MediaRouteProvider.DynamicGroupRouteController) {
                return (MediaRouteProvider.DynamicGroupRouteController) routeController;
            }
            return null;
        }

        public DynamicGroupState h(RouteInfo routeInfo) {
            if (routeInfo != null) {
                Map<String, MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor> map = this.f10640w;
                if (map == null || !map.containsKey(routeInfo.f10620c)) {
                    return null;
                }
                return new DynamicGroupState(this.f10640w.get(routeInfo.f10620c));
            }
            throw new NullPointerException("route must not be null");
        }

        public Bundle i() {
            return this.f10636s;
        }

        public Uri j() {
            return this.f10623f;
        }

        public String k() {
            return this.f10620c;
        }

        public List<RouteInfo> l() {
            return Collections.unmodifiableList(this.f10639v);
        }

        public String m() {
            return this.f10621d;
        }

        public int n() {
            return this.f10629l;
        }

        public int o() {
            return this.f10628k;
        }

        public int p() {
            return this.f10635r;
        }

        public ProviderInfo q() {
            return this.f10618a;
        }

        public MediaRouteProvider r() {
            return this.f10618a.e();
        }

        public int s() {
            return this.f10632o;
        }

        public int t() {
            if (!y() || MediaRouter.o()) {
                return this.f10631n;
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MediaRouter.RouteInfo{ uniqueId=" + this.f10620c + ", name=" + this.f10621d + ", description=" + this.f10622e + ", iconUri=" + this.f10623f + ", enabled=" + this.f10624g + ", connectionState=" + this.f10625h + ", canDisconnect=" + this.f10626i + ", playbackType=" + this.f10628k + ", playbackStream=" + this.f10629l + ", deviceType=" + this.f10630m + ", volumeHandling=" + this.f10631n + ", volume=" + this.f10632o + ", volumeMax=" + this.f10633p + ", presentationDisplayId=" + this.f10635r + ", extras=" + this.f10636s + ", settingsIntent=" + this.f10637t + ", providerPackageName=" + this.f10618a.d());
            if (y()) {
                sb.append(", members=[");
                int size = this.f10639v.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    if (this.f10639v.get(i2) != this) {
                        sb.append(this.f10639v.get(i2).k());
                    }
                }
                sb.append(']');
            }
            sb.append(" }");
            return sb.toString();
        }

        public int u() {
            return this.f10633p;
        }

        public boolean v() {
            MediaRouter.d();
            if (MediaRouter.i().o() == this) {
                return true;
            }
            return false;
        }

        public boolean w() {
            if (v() || this.f10630m == 3) {
                return true;
            }
            if (!D(this) || !J("android.media.intent.category.LIVE_AUDIO") || J("android.media.intent.category.LIVE_VIDEO")) {
                return false;
            }
            return true;
        }

        public boolean x() {
            return this.f10624g;
        }

        public boolean y() {
            return l().size() >= 1;
        }
    }

    MediaRouter(Context context) {
        this.f10550a = context;
    }

    static void d() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("The media router service must only be accessed on the application's main thread.");
        }
    }

    private int e(Callback callback) {
        int size = this.f10551b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f10551b.get(i2).f10553b == callback) {
                return i2;
            }
        }
        return -1;
    }

    static int h() {
        if (f10549d == null) {
            return 0;
        }
        return i().n();
    }

    static GlobalMediaRouter i() {
        GlobalMediaRouter globalMediaRouter = f10549d;
        if (globalMediaRouter == null) {
            return null;
        }
        globalMediaRouter.i();
        return f10549d;
    }

    public static MediaRouter j(Context context) {
        if (context != null) {
            d();
            if (f10549d == null) {
                f10549d = new GlobalMediaRouter(context.getApplicationContext());
            }
            return f10549d.s(context);
        }
        throw new IllegalArgumentException("context must not be null");
    }

    public static boolean o() {
        if (f10549d == null) {
            return false;
        }
        return i().x();
    }

    public static boolean p() {
        if (f10549d == null) {
            return false;
        }
        return i().y();
    }

    static boolean r() {
        GlobalMediaRouter i2 = i();
        if (i2 == null) {
            return false;
        }
        return i2.C();
    }

    public void a(MediaRouteSelector mediaRouteSelector, Callback callback) {
        b(mediaRouteSelector, callback, 0);
    }

    public void b(MediaRouteSelector mediaRouteSelector, Callback callback, int i2) {
        CallbackRecord callbackRecord;
        boolean z2;
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (callback != null) {
            d();
            if (f10548c) {
                Log.d("MediaRouter", "addCallback: selector=" + mediaRouteSelector + ", callback=" + callback + ", flags=" + Integer.toHexString(i2));
            }
            int e2 = e(callback);
            if (e2 < 0) {
                callbackRecord = new CallbackRecord(this, callback);
                this.f10551b.add(callbackRecord);
            } else {
                callbackRecord = this.f10551b.get(e2);
            }
            boolean z3 = true;
            if (i2 != callbackRecord.f10555d) {
                callbackRecord.f10555d = i2;
                z2 = true;
            } else {
                z2 = false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if ((i2 & 1) != 0) {
                z2 = true;
            }
            callbackRecord.f10556e = elapsedRealtime;
            if (!callbackRecord.f10554c.b(mediaRouteSelector)) {
                callbackRecord.f10554c = new MediaRouteSelector.Builder(callbackRecord.f10554c).c(mediaRouteSelector).d();
            } else {
                z3 = z2;
            }
            if (z3) {
                i().Q();
            }
        } else {
            throw new IllegalArgumentException("callback must not be null");
        }
    }

    public void c(RouteInfo routeInfo) {
        if (routeInfo != null) {
            d();
            i().e(routeInfo);
            return;
        }
        throw new NullPointerException("route must not be null");
    }

    public RouteInfo f() {
        d();
        GlobalMediaRouter i2 = i();
        if (i2 == null) {
            return null;
        }
        return i2.m();
    }

    public RouteInfo g() {
        d();
        return i().o();
    }

    public MediaSessionCompat.Token k() {
        GlobalMediaRouter globalMediaRouter = f10549d;
        if (globalMediaRouter == null) {
            return null;
        }
        return globalMediaRouter.q();
    }

    public MediaRouterParams l() {
        d();
        GlobalMediaRouter i2 = i();
        if (i2 == null) {
            return null;
        }
        return i2.t();
    }

    public List<RouteInfo> m() {
        d();
        GlobalMediaRouter i2 = i();
        if (i2 == null) {
            return Collections.emptyList();
        }
        return i2.u();
    }

    public RouteInfo n() {
        d();
        return i().v();
    }

    public boolean q(MediaRouteSelector mediaRouteSelector, int i2) {
        if (mediaRouteSelector != null) {
            d();
            return i().z(mediaRouteSelector, i2);
        }
        throw new IllegalArgumentException("selector must not be null");
    }

    public void s(Callback callback) {
        if (callback != null) {
            d();
            if (f10548c) {
                Log.d("MediaRouter", "removeCallback: callback=" + callback);
            }
            int e2 = e(callback);
            if (e2 >= 0) {
                this.f10551b.remove(e2);
                i().Q();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("callback must not be null");
    }

    public void t(RouteInfo routeInfo) {
        if (routeInfo != null) {
            d();
            i().F(routeInfo);
            return;
        }
        throw new NullPointerException("route must not be null");
    }

    public void u(RouteInfo routeInfo) {
        if (routeInfo != null) {
            d();
            if (f10548c) {
                Log.d("MediaRouter", "selectRoute: " + routeInfo);
            }
            i().J(routeInfo, 3);
            return;
        }
        throw new IllegalArgumentException("route must not be null");
    }

    public void v(MediaSessionCompat mediaSessionCompat) {
        d();
        if (f10548c) {
            Log.d("MediaRouter", "setMediaSessionCompat: " + mediaSessionCompat);
        }
        i().L(mediaSessionCompat);
    }

    public void w(OnPrepareTransferListener onPrepareTransferListener) {
        d();
        i().B = onPrepareTransferListener;
    }

    public void x(MediaRouterParams mediaRouterParams) {
        d();
        i().N(mediaRouterParams);
    }

    public void y(RouteInfo routeInfo) {
        if (routeInfo != null) {
            d();
            i().P(routeInfo);
            return;
        }
        throw new NullPointerException("route must not be null");
    }

    public void z(int i2) {
        if (i2 < 0 || i2 > 3) {
            throw new IllegalArgumentException("Unsupported reason to unselect route");
        }
        d();
        GlobalMediaRouter i3 = i();
        RouteInfo h2 = i3.h();
        if (i3.v() != h2) {
            i3.J(h2, i2);
        }
    }
}
