package androidx.mediarouter.media;

import android.content.Context;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.SparseArray;
import androidx.media3.exoplayer.audio.b1;
import androidx.mediarouter.R$string;
import androidx.mediarouter.media.MediaRouteDescriptor;
import androidx.mediarouter.media.MediaRouteProvider;
import androidx.mediarouter.media.MediaRouteProviderDescriptor;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

class MediaRoute2Provider extends MediaRouteProvider {

    /* renamed from: s  reason: collision with root package name */
    static final boolean f10470s = Log.isLoggable("MR2Provider", 3);

    /* renamed from: i  reason: collision with root package name */
    final MediaRouter2 f10471i;

    /* renamed from: j  reason: collision with root package name */
    final Callback f10472j;

    /* renamed from: k  reason: collision with root package name */
    final Map<MediaRouter2.RoutingController, GroupRouteController> f10473k = new ArrayMap();

    /* renamed from: l  reason: collision with root package name */
    private final MediaRouter2.RouteCallback f10474l = new RouteCallback();

    /* renamed from: m  reason: collision with root package name */
    private final MediaRouter2.TransferCallback f10475m = new TransferCallback();

    /* renamed from: n  reason: collision with root package name */
    private final MediaRouter2.ControllerCallback f10476n = new ControllerCallback();

    /* renamed from: o  reason: collision with root package name */
    private final Handler f10477o;

    /* renamed from: p  reason: collision with root package name */
    private final Executor f10478p;

    /* renamed from: q  reason: collision with root package name */
    private List<MediaRoute2Info> f10479q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private Map<String, String> f10480r = new ArrayMap();

    static abstract class Callback {
        Callback() {
        }

        public abstract void a(MediaRouteProvider.RouteController routeController);

        public abstract void b(int i2);

        public abstract void c(String str, int i2);
    }

    private class ControllerCallback extends MediaRouter2.ControllerCallback {
        ControllerCallback() {
        }

        public void onControllerUpdated(MediaRouter2.RoutingController routingController) {
            MediaRoute2Provider.this.D(routingController);
        }
    }

    private class GroupRouteController extends MediaRouteProvider.DynamicGroupRouteController {

        /* renamed from: f  reason: collision with root package name */
        final String f10482f;

        /* renamed from: g  reason: collision with root package name */
        final MediaRouter2.RoutingController f10483g;

        /* renamed from: h  reason: collision with root package name */
        final Messenger f10484h;

        /* renamed from: i  reason: collision with root package name */
        final Messenger f10485i;

        /* renamed from: j  reason: collision with root package name */
        final SparseArray<MediaRouter.ControlRequestCallback> f10486j = new SparseArray<>();

        /* renamed from: k  reason: collision with root package name */
        final Handler f10487k;

        /* renamed from: l  reason: collision with root package name */
        AtomicInteger f10488l = new AtomicInteger(1);

        /* renamed from: m  reason: collision with root package name */
        private final Runnable f10489m = new z(this);

        /* renamed from: n  reason: collision with root package name */
        int f10490n = -1;

        /* renamed from: o  reason: collision with root package name */
        MediaRouteDescriptor f10491o;

        class ReceiveHandler extends Handler {
            ReceiveHandler() {
                super(Looper.getMainLooper());
            }

            public void handleMessage(Message message) {
                String str;
                int i2 = message.what;
                int i3 = message.arg1;
                Object obj = message.obj;
                Bundle peekData = message.peekData();
                MediaRouter.ControlRequestCallback controlRequestCallback = GroupRouteController.this.f10486j.get(i3);
                if (controlRequestCallback == null) {
                    Log.w("MR2Provider", "Pending callback not found for control request.");
                    return;
                }
                GroupRouteController.this.f10486j.remove(i3);
                if (i2 == 3) {
                    controlRequestCallback.b((Bundle) obj);
                } else if (i2 == 4) {
                    if (peekData == null) {
                        str = null;
                    } else {
                        str = peekData.getString(MRAIDPresenter.ERROR);
                    }
                    controlRequestCallback.a(str, (Bundle) obj);
                }
            }
        }

        GroupRouteController(MediaRouter2.RoutingController routingController, String str) {
            Messenger messenger;
            this.f10483g = routingController;
            this.f10482f = str;
            Messenger z2 = MediaRoute2Provider.z(routingController);
            this.f10484h = z2;
            if (z2 == null) {
                messenger = null;
            } else {
                messenger = new Messenger(new ReceiveHandler());
            }
            this.f10485i = messenger;
            this.f10487k = new Handler(Looper.getMainLooper());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void s() {
            this.f10490n = -1;
        }

        private void t() {
            this.f10487k.removeCallbacks(this.f10489m);
            this.f10487k.postDelayed(this.f10489m, 1000);
        }

        public void d() {
            this.f10483g.release();
        }

        public void f(int i2) {
            MediaRouter2.RoutingController routingController = this.f10483g;
            if (routingController != null) {
                routingController.setVolume(i2);
                this.f10490n = i2;
                t();
            }
        }

        public void i(int i2) {
            MediaRouter2.RoutingController routingController = this.f10483g;
            if (routingController != null) {
                int i3 = this.f10490n;
                if (i3 < 0) {
                    i3 = routingController.getVolume();
                }
                int max = Math.max(0, Math.min(i3 + i2, this.f10483g.getVolumeMax()));
                this.f10490n = max;
                this.f10483g.setVolume(max);
                t();
            }
        }

        public void m(String str) {
            if (str == null || str.isEmpty()) {
                Log.w("MR2Provider", "onAddMemberRoute: Ignoring null or empty routeId.");
                return;
            }
            MediaRoute2Info A = MediaRoute2Provider.this.A(str);
            if (A == null) {
                Log.w("MR2Provider", "onAddMemberRoute: Specified route not found. routeId=" + str);
                return;
            }
            this.f10483g.selectRoute(A);
        }

        public void n(String str) {
            if (str == null || str.isEmpty()) {
                Log.w("MR2Provider", "onRemoveMemberRoute: Ignoring null or empty routeId.");
                return;
            }
            MediaRoute2Info A = MediaRoute2Provider.this.A(str);
            if (A == null) {
                Log.w("MR2Provider", "onRemoveMemberRoute: Specified route not found. routeId=" + str);
                return;
            }
            this.f10483g.deselectRoute(A);
        }

        public void o(List<String> list) {
            if (list == null || list.isEmpty()) {
                Log.w("MR2Provider", "onUpdateMemberRoutes: Ignoring null or empty routeIds.");
                return;
            }
            String str = list.get(0);
            MediaRoute2Info A = MediaRoute2Provider.this.A(str);
            if (A == null) {
                Log.w("MR2Provider", "onUpdateMemberRoutes: Specified route not found. routeId=" + str);
                return;
            }
            MediaRoute2Provider.this.f10471i.transferTo(A);
        }

        public String r() {
            MediaRouteDescriptor mediaRouteDescriptor = this.f10491o;
            if (mediaRouteDescriptor != null) {
                return mediaRouteDescriptor.l();
            }
            return this.f10483g.getId();
        }

        /* access modifiers changed from: package-private */
        public void u(MediaRouteDescriptor mediaRouteDescriptor) {
            this.f10491o = mediaRouteDescriptor;
        }

        /* access modifiers changed from: package-private */
        public void v(String str, int i2) {
            MediaRouter2.RoutingController routingController = this.f10483g;
            if (routingController != null && !routingController.isReleased() && this.f10484h != null) {
                int andIncrement = this.f10488l.getAndIncrement();
                Message obtain = Message.obtain();
                obtain.what = 7;
                obtain.arg1 = andIncrement;
                Bundle bundle = new Bundle();
                bundle.putInt("volume", i2);
                bundle.putString("routeId", str);
                obtain.setData(bundle);
                obtain.replyTo = this.f10485i;
                try {
                    this.f10484h.send(obtain);
                } catch (DeadObjectException unused) {
                } catch (RemoteException e2) {
                    Log.e("MR2Provider", "Could not send control request to service.", e2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void w(String str, int i2) {
            MediaRouter2.RoutingController routingController = this.f10483g;
            if (routingController != null && !routingController.isReleased() && this.f10484h != null) {
                int andIncrement = this.f10488l.getAndIncrement();
                Message obtain = Message.obtain();
                obtain.what = 8;
                obtain.arg1 = andIncrement;
                Bundle bundle = new Bundle();
                bundle.putInt("volume", i2);
                bundle.putString("routeId", str);
                obtain.setData(bundle);
                obtain.replyTo = this.f10485i;
                try {
                    this.f10484h.send(obtain);
                } catch (DeadObjectException unused) {
                } catch (RemoteException e2) {
                    Log.e("MR2Provider", "Could not send control request to service.", e2);
                }
            }
        }
    }

    private class MemberRouteController extends MediaRouteProvider.RouteController {

        /* renamed from: a  reason: collision with root package name */
        final String f10494a;

        /* renamed from: b  reason: collision with root package name */
        final GroupRouteController f10495b;

        MemberRouteController(String str, GroupRouteController groupRouteController) {
            this.f10494a = str;
            this.f10495b = groupRouteController;
        }

        public void f(int i2) {
            GroupRouteController groupRouteController;
            String str = this.f10494a;
            if (str != null && (groupRouteController = this.f10495b) != null) {
                groupRouteController.v(str, i2);
            }
        }

        public void i(int i2) {
            GroupRouteController groupRouteController;
            String str = this.f10494a;
            if (str != null && (groupRouteController = this.f10495b) != null) {
                groupRouteController.w(str, i2);
            }
        }
    }

    private class RouteCallback extends MediaRouter2.RouteCallback {
        RouteCallback() {
        }

        public void onRoutesAdded(List<MediaRoute2Info> list) {
            MediaRoute2Provider.this.C();
        }

        public void onRoutesChanged(List<MediaRoute2Info> list) {
            MediaRoute2Provider.this.C();
        }

        public void onRoutesRemoved(List<MediaRoute2Info> list) {
            MediaRoute2Provider.this.C();
        }
    }

    private class TransferCallback extends MediaRouter2.TransferCallback {
        TransferCallback() {
        }

        public void onStop(MediaRouter2.RoutingController routingController) {
            MediaRouteProvider.RouteController remove = MediaRoute2Provider.this.f10473k.remove(routingController);
            if (remove != null) {
                MediaRoute2Provider.this.f10472j.a(remove);
                return;
            }
            Log.w("MR2Provider", "onStop: No matching routeController found. routingController=" + routingController);
        }

        public void onTransfer(MediaRouter2.RoutingController routingController, MediaRouter2.RoutingController routingController2) {
            MediaRoute2Provider.this.f10473k.remove(routingController);
            if (routingController2 == MediaRoute2Provider.this.f10471i.getSystemController()) {
                MediaRoute2Provider.this.f10472j.b(3);
                return;
            }
            List a2 = routingController2.getSelectedRoutes();
            if (a2.isEmpty()) {
                Log.w("MR2Provider", "Selected routes are empty. This shouldn't happen.");
                return;
            }
            String a3 = ((MediaRoute2Info) a2.get(0)).getId();
            MediaRoute2Provider.this.f10473k.put(routingController2, new GroupRouteController(routingController2, a3));
            MediaRoute2Provider.this.f10472j.c(a3, 3);
            MediaRoute2Provider.this.D(routingController2);
        }

        public void onTransferFailure(MediaRoute2Info mediaRoute2Info) {
            Log.w("MR2Provider", "Transfer failed. requestedRoute=" + mediaRoute2Info);
        }
    }

    MediaRoute2Provider(Context context, Callback callback) {
        super(context);
        this.f10471i = MediaRouter2.getInstance(context);
        this.f10472j = callback;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f10477o = handler;
        Objects.requireNonNull(handler);
        this.f10478p = new b1(handler);
    }

    static String B(MediaRouteProvider.RouteController routeController) {
        MediaRouter2.RoutingController routingController;
        if ((routeController instanceof GroupRouteController) && (routingController = ((GroupRouteController) routeController).f10483g) != null) {
            return routingController.getId();
        }
        return null;
    }

    private MediaRouteDiscoveryRequest F(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest, boolean z2) {
        if (mediaRouteDiscoveryRequest == null) {
            mediaRouteDiscoveryRequest = new MediaRouteDiscoveryRequest(MediaRouteSelector.f10544c, false);
        }
        List<String> e2 = mediaRouteDiscoveryRequest.c().e();
        if (!z2) {
            e2.remove("android.media.intent.category.LIVE_AUDIO");
        } else if (!e2.contains("android.media.intent.category.LIVE_AUDIO")) {
            e2.add("android.media.intent.category.LIVE_AUDIO");
        }
        return new MediaRouteDiscoveryRequest(new MediaRouteSelector.Builder().a(e2).d(), mediaRouteDiscoveryRequest.d());
    }

    static Messenger z(MediaRouter2.RoutingController routingController) {
        Bundle a2;
        if (routingController == null || (a2 = routingController.getControlHints()) == null) {
            return null;
        }
        return (Messenger) a2.getParcelable("androidx.mediarouter.media.KEY_MESSENGER");
    }

    /* access modifiers changed from: package-private */
    public MediaRoute2Info A(String str) {
        if (str == null) {
            return null;
        }
        for (MediaRoute2Info next : this.f10479q) {
            if (TextUtils.equals(next.getId(), str)) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void C() {
        ArrayList arrayList = new ArrayList();
        ArraySet arraySet = new ArraySet();
        for (MediaRoute2Info mediaRoute2Info : this.f10471i.getRoutes()) {
            if (mediaRoute2Info != null && !arraySet.contains(mediaRoute2Info) && !mediaRoute2Info.isSystemRoute()) {
                arraySet.add(mediaRoute2Info);
                arrayList.add(mediaRoute2Info);
            }
        }
        if (!arrayList.equals(this.f10479q)) {
            this.f10479q = arrayList;
            this.f10480r.clear();
            for (MediaRoute2Info next : this.f10479q) {
                Bundle a2 = next.getExtras();
                if (a2 == null || a2.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID") == null) {
                    Log.w("MR2Provider", "Cannot find the original route Id. route=" + next);
                } else {
                    this.f10480r.put(next.getId(), a2.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID"));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (MediaRoute2Info next2 : this.f10479q) {
                MediaRouteDescriptor c2 = MediaRouter2Utils.c(next2);
                if (next2 != null) {
                    arrayList2.add(c2);
                }
            }
            w(new MediaRouteProviderDescriptor.Builder().d(true).b(arrayList2).c());
        }
    }

    /* access modifiers changed from: package-private */
    public void D(MediaRouter2.RoutingController routingController) {
        int i2;
        GroupRouteController groupRouteController = this.f10473k.get(routingController);
        if (groupRouteController == null) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: No matching routeController found. routingController=" + routingController);
            return;
        }
        List a2 = routingController.getSelectedRoutes();
        if (a2.isEmpty()) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: No selected routes. This may happen when the selected routes become invalid.routingController=" + routingController);
            return;
        }
        List<String> a3 = MediaRouter2Utils.a(a2);
        MediaRouteDescriptor c2 = MediaRouter2Utils.c((MediaRoute2Info) a2.get(0));
        Bundle a4 = routingController.getControlHints();
        String string = n().getString(R$string.mr_dialog_default_group_name);
        MediaRouteDescriptor mediaRouteDescriptor = null;
        if (a4 != null) {
            try {
                String string2 = a4.getString("androidx.mediarouter.media.KEY_SESSION_NAME");
                if (!TextUtils.isEmpty(string2)) {
                    string = string2;
                }
                Bundle bundle = a4.getBundle("androidx.mediarouter.media.KEY_GROUP_ROUTE");
                if (bundle != null) {
                    mediaRouteDescriptor = MediaRouteDescriptor.d(bundle);
                }
            } catch (Exception e2) {
                Log.w("MR2Provider", "Exception while unparceling control hints.", e2);
            }
        }
        if (mediaRouteDescriptor == null) {
            mediaRouteDescriptor = new MediaRouteDescriptor.Builder(routingController.getId(), string).g(2).p(1).r(routingController.getVolume()).t(routingController.getVolumeMax()).s(routingController.getVolumeHandling()).b(c2.f()).d(a3).e();
        }
        List<String> a5 = MediaRouter2Utils.a(routingController.getSelectableRoutes());
        List<String> a6 = MediaRouter2Utils.a(routingController.getDeselectableRoutes());
        MediaRouteProviderDescriptor o2 = o();
        if (o2 == null) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: providerDescriptor is not set.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<MediaRouteDescriptor> b2 = o2.b();
        if (!b2.isEmpty()) {
            for (MediaRouteDescriptor next : b2) {
                String l2 = next.l();
                MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor.Builder builder = new MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor.Builder(next);
                if (a3.contains(l2)) {
                    i2 = 3;
                } else {
                    i2 = 1;
                }
                arrayList.add(builder.e(i2).b(a5.contains(l2)).d(a6.contains(l2)).c(true).a());
            }
        }
        groupRouteController.u(mediaRouteDescriptor);
        groupRouteController.l(mediaRouteDescriptor, arrayList);
    }

    public void E(String str) {
        MediaRoute2Info A = A(str);
        if (A == null) {
            Log.w("MR2Provider", "transferTo: Specified route not found. routeId=" + str);
            return;
        }
        this.f10471i.transferTo(A);
    }

    public MediaRouteProvider.DynamicGroupRouteController r(String str) {
        for (Map.Entry<MediaRouter2.RoutingController, GroupRouteController> value : this.f10473k.entrySet()) {
            GroupRouteController groupRouteController = (GroupRouteController) value.getValue();
            if (TextUtils.equals(str, groupRouteController.f10482f)) {
                return groupRouteController;
            }
        }
        return null;
    }

    public MediaRouteProvider.RouteController s(String str) {
        return new MemberRouteController(this.f10480r.get(str), (GroupRouteController) null);
    }

    public MediaRouteProvider.RouteController t(String str, String str2) {
        String str3 = this.f10480r.get(str);
        for (GroupRouteController next : this.f10473k.values()) {
            if (TextUtils.equals(str2, next.r())) {
                return new MemberRouteController(str3, next);
            }
        }
        Log.w("MR2Provider", "Could not find the matching GroupRouteController. routeId=" + str + ", routeGroupId=" + str2);
        return new MemberRouteController(str3, (GroupRouteController) null);
    }

    public void u(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
        if (MediaRouter.h() > 0) {
            this.f10471i.registerRouteCallback(this.f10478p, this.f10474l, MediaRouter2Utils.b(F(mediaRouteDiscoveryRequest, MediaRouter.r())));
            this.f10471i.registerTransferCallback(this.f10478p, this.f10475m);
            this.f10471i.registerControllerCallback(this.f10478p, this.f10476n);
            return;
        }
        this.f10471i.unregisterRouteCallback(this.f10474l);
        this.f10471i.unregisterTransferCallback(this.f10475m);
        this.f10471i.unregisterControllerCallback(this.f10476n);
    }
}
