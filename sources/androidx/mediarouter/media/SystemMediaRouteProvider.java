package androidx.mediarouter.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.view.Display;
import androidx.mediarouter.R$string;
import androidx.mediarouter.media.MediaRouteDescriptor;
import androidx.mediarouter.media.MediaRouteProvider;
import androidx.mediarouter.media.MediaRouteProviderDescriptor;
import androidx.mediarouter.media.MediaRouter;
import androidx.mediarouter.media.MediaRouterJellybean;
import androidx.mediarouter.media.MediaRouterJellybeanMr1;
import androidx.mediarouter.media.MediaRouterJellybeanMr2;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

abstract class SystemMediaRouteProvider extends MediaRouteProvider {

    private static class Api24Impl extends JellybeanMr2Impl {
        public Api24Impl(Context context, SyncCallback syncCallback) {
            super(context, syncCallback);
        }

        /* access modifiers changed from: protected */
        public void O(JellybeanImpl.SystemRouteRecord systemRouteRecord, MediaRouteDescriptor.Builder builder) {
            super.O(systemRouteRecord, builder);
            builder.i(MediaRouterApi24$RouteInfo.a(systemRouteRecord.f10735a));
        }
    }

    static class JellybeanImpl extends SystemMediaRouteProvider implements MediaRouterJellybean.Callback, MediaRouterJellybean.VolumeCallback {

        /* renamed from: s  reason: collision with root package name */
        private static final ArrayList<IntentFilter> f10722s;

        /* renamed from: t  reason: collision with root package name */
        private static final ArrayList<IntentFilter> f10723t;

        /* renamed from: i  reason: collision with root package name */
        private final SyncCallback f10724i;

        /* renamed from: j  reason: collision with root package name */
        protected final Object f10725j;

        /* renamed from: k  reason: collision with root package name */
        protected final Object f10726k;

        /* renamed from: l  reason: collision with root package name */
        protected final Object f10727l;

        /* renamed from: m  reason: collision with root package name */
        protected final Object f10728m;

        /* renamed from: n  reason: collision with root package name */
        protected int f10729n;

        /* renamed from: o  reason: collision with root package name */
        protected boolean f10730o;

        /* renamed from: p  reason: collision with root package name */
        protected boolean f10731p;

        /* renamed from: q  reason: collision with root package name */
        protected final ArrayList<SystemRouteRecord> f10732q = new ArrayList<>();

        /* renamed from: r  reason: collision with root package name */
        protected final ArrayList<UserRouteRecord> f10733r = new ArrayList<>();

        protected static final class SystemRouteController extends MediaRouteProvider.RouteController {

            /* renamed from: a  reason: collision with root package name */
            private final Object f10734a;

            public SystemRouteController(Object obj) {
                this.f10734a = obj;
            }

            public void f(int i2) {
                MediaRouterJellybean.RouteInfo.i(this.f10734a, i2);
            }

            public void i(int i2) {
                MediaRouterJellybean.RouteInfo.j(this.f10734a, i2);
            }
        }

        protected static final class SystemRouteRecord {

            /* renamed from: a  reason: collision with root package name */
            public final Object f10735a;

            /* renamed from: b  reason: collision with root package name */
            public final String f10736b;

            /* renamed from: c  reason: collision with root package name */
            public MediaRouteDescriptor f10737c;

            public SystemRouteRecord(Object obj, String str) {
                this.f10735a = obj;
                this.f10736b = str;
            }
        }

        protected static final class UserRouteRecord {

            /* renamed from: a  reason: collision with root package name */
            public final MediaRouter.RouteInfo f10738a;

            /* renamed from: b  reason: collision with root package name */
            public final Object f10739b;

            public UserRouteRecord(MediaRouter.RouteInfo routeInfo, Object obj) {
                this.f10738a = routeInfo;
                this.f10739b = obj;
            }
        }

        static {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addCategory("android.media.intent.category.LIVE_AUDIO");
            ArrayList<IntentFilter> arrayList = new ArrayList<>();
            f10722s = arrayList;
            arrayList.add(intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addCategory("android.media.intent.category.LIVE_VIDEO");
            ArrayList<IntentFilter> arrayList2 = new ArrayList<>();
            f10723t = arrayList2;
            arrayList2.add(intentFilter2);
        }

        public JellybeanImpl(Context context, SyncCallback syncCallback) {
            super(context);
            this.f10724i = syncCallback;
            Object e2 = MediaRouterJellybean.e(context);
            this.f10725j = e2;
            this.f10726k = G();
            this.f10727l = H();
            this.f10728m = MediaRouterJellybean.b(e2, context.getResources().getString(R$string.mr_user_route_category_name), false);
            T();
        }

        private boolean E(Object obj) {
            if (N(obj) != null || I(obj) >= 0) {
                return false;
            }
            SystemRouteRecord systemRouteRecord = new SystemRouteRecord(obj, F(obj));
            S(systemRouteRecord);
            this.f10732q.add(systemRouteRecord);
            return true;
        }

        private String F(Object obj) {
            boolean z2;
            String str;
            if (L() == obj) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                str = "DEFAULT_ROUTE";
            } else {
                str = String.format(Locale.US, "ROUTE_%08x", new Object[]{Integer.valueOf(M(obj).hashCode())});
            }
            if (J(str) < 0) {
                return str;
            }
            int i2 = 2;
            while (true) {
                String format = String.format(Locale.US, "%s_%d", new Object[]{str, Integer.valueOf(i2)});
                if (J(format) < 0) {
                    return format;
                }
                i2++;
            }
        }

        private void T() {
            R();
            boolean z2 = false;
            for (Object E : MediaRouterJellybean.f(this.f10725j)) {
                z2 |= E(E);
            }
            if (z2) {
                P();
            }
        }

        public void A(MediaRouter.RouteInfo routeInfo) {
            if (routeInfo.r() != this) {
                Object c2 = MediaRouterJellybean.c(this.f10725j, this.f10728m);
                UserRouteRecord userRouteRecord = new UserRouteRecord(routeInfo, c2);
                MediaRouterJellybean.RouteInfo.k(c2, userRouteRecord);
                MediaRouterJellybean.UserRouteInfo.f(c2, this.f10727l);
                U(userRouteRecord);
                this.f10733r.add(userRouteRecord);
                MediaRouterJellybean.a(this.f10725j, c2);
                return;
            }
            int I = I(MediaRouterJellybean.g(this.f10725j, 8388611));
            if (I >= 0 && this.f10732q.get(I).f10736b.equals(routeInfo.e())) {
                routeInfo.I();
            }
        }

        public void B(MediaRouter.RouteInfo routeInfo) {
            int K;
            if (routeInfo.r() != this && (K = K(routeInfo)) >= 0) {
                U(this.f10733r.get(K));
            }
        }

        public void C(MediaRouter.RouteInfo routeInfo) {
            int K;
            if (routeInfo.r() != this && (K = K(routeInfo)) >= 0) {
                UserRouteRecord remove = this.f10733r.remove(K);
                MediaRouterJellybean.RouteInfo.k(remove.f10739b, (Object) null);
                MediaRouterJellybean.UserRouteInfo.f(remove.f10739b, (Object) null);
                MediaRouterJellybean.i(this.f10725j, remove.f10739b);
            }
        }

        public void D(MediaRouter.RouteInfo routeInfo) {
            if (routeInfo.C()) {
                if (routeInfo.r() != this) {
                    int K = K(routeInfo);
                    if (K >= 0) {
                        Q(this.f10733r.get(K).f10739b);
                        return;
                    }
                    return;
                }
                int J = J(routeInfo.e());
                if (J >= 0) {
                    Q(this.f10732q.get(J).f10735a);
                }
            }
        }

        /* access modifiers changed from: protected */
        public Object G() {
            throw null;
        }

        /* access modifiers changed from: protected */
        public Object H() {
            return MediaRouterJellybean.d(this);
        }

        /* access modifiers changed from: protected */
        public int I(Object obj) {
            int size = this.f10732q.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f10732q.get(i2).f10735a == obj) {
                    return i2;
                }
            }
            return -1;
        }

        /* access modifiers changed from: protected */
        public int J(String str) {
            int size = this.f10732q.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f10732q.get(i2).f10736b.equals(str)) {
                    return i2;
                }
            }
            return -1;
        }

        /* access modifiers changed from: protected */
        public int K(MediaRouter.RouteInfo routeInfo) {
            int size = this.f10733r.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f10733r.get(i2).f10738a == routeInfo) {
                    return i2;
                }
            }
            return -1;
        }

        /* access modifiers changed from: protected */
        public Object L() {
            throw null;
        }

        /* access modifiers changed from: protected */
        public String M(Object obj) {
            CharSequence a2 = MediaRouterJellybean.RouteInfo.a(obj, n());
            if (a2 != null) {
                return a2.toString();
            }
            return "";
        }

        /* access modifiers changed from: protected */
        public UserRouteRecord N(Object obj) {
            Object e2 = MediaRouterJellybean.RouteInfo.e(obj);
            if (e2 instanceof UserRouteRecord) {
                return (UserRouteRecord) e2;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void O(SystemRouteRecord systemRouteRecord, MediaRouteDescriptor.Builder builder) {
            int d2 = MediaRouterJellybean.RouteInfo.d(systemRouteRecord.f10735a);
            if ((d2 & 1) != 0) {
                builder.b(f10722s);
            }
            if ((d2 & 2) != 0) {
                builder.b(f10723t);
            }
            builder.p(MediaRouterJellybean.RouteInfo.c(systemRouteRecord.f10735a));
            builder.o(MediaRouterJellybean.RouteInfo.b(systemRouteRecord.f10735a));
            builder.r(MediaRouterJellybean.RouteInfo.f(systemRouteRecord.f10735a));
            builder.t(MediaRouterJellybean.RouteInfo.h(systemRouteRecord.f10735a));
            builder.s(MediaRouterJellybean.RouteInfo.g(systemRouteRecord.f10735a));
        }

        /* access modifiers changed from: protected */
        public void P() {
            MediaRouteProviderDescriptor.Builder builder = new MediaRouteProviderDescriptor.Builder();
            int size = this.f10732q.size();
            for (int i2 = 0; i2 < size; i2++) {
                builder.a(this.f10732q.get(i2).f10737c);
            }
            w(builder.c());
        }

        /* access modifiers changed from: protected */
        public void Q(Object obj) {
            throw null;
        }

        /* access modifiers changed from: protected */
        public void R() {
            throw null;
        }

        /* access modifiers changed from: protected */
        public void S(SystemRouteRecord systemRouteRecord) {
            MediaRouteDescriptor.Builder builder = new MediaRouteDescriptor.Builder(systemRouteRecord.f10736b, M(systemRouteRecord.f10735a));
            O(systemRouteRecord, builder);
            systemRouteRecord.f10737c = builder.e();
        }

        /* access modifiers changed from: protected */
        public void U(UserRouteRecord userRouteRecord) {
            MediaRouterJellybean.UserRouteInfo.a(userRouteRecord.f10739b, userRouteRecord.f10738a.m());
            MediaRouterJellybean.UserRouteInfo.c(userRouteRecord.f10739b, userRouteRecord.f10738a.o());
            MediaRouterJellybean.UserRouteInfo.b(userRouteRecord.f10739b, userRouteRecord.f10738a.n());
            MediaRouterJellybean.UserRouteInfo.e(userRouteRecord.f10739b, userRouteRecord.f10738a.s());
            MediaRouterJellybean.UserRouteInfo.h(userRouteRecord.f10739b, userRouteRecord.f10738a.u());
            MediaRouterJellybean.UserRouteInfo.g(userRouteRecord.f10739b, userRouteRecord.f10738a.t());
        }

        public void a(Object obj, int i2) {
            UserRouteRecord N = N(obj);
            if (N != null) {
                N.f10738a.H(i2);
            }
        }

        public void b(Object obj, Object obj2) {
        }

        public void c(Object obj, Object obj2, int i2) {
        }

        public void d(Object obj, int i2) {
            UserRouteRecord N = N(obj);
            if (N != null) {
                N.f10738a.G(i2);
            }
        }

        public void e(Object obj) {
            int I;
            if (N(obj) == null && (I = I(obj)) >= 0) {
                S(this.f10732q.get(I));
                P();
            }
        }

        public void f(int i2, Object obj) {
        }

        public void g(Object obj) {
            int I;
            if (N(obj) == null && (I = I(obj)) >= 0) {
                this.f10732q.remove(I);
                P();
            }
        }

        public void h(int i2, Object obj) {
            if (obj == MediaRouterJellybean.g(this.f10725j, 8388611)) {
                UserRouteRecord N = N(obj);
                if (N != null) {
                    N.f10738a.I();
                    return;
                }
                int I = I(obj);
                if (I >= 0) {
                    this.f10724i.c(this.f10732q.get(I).f10736b);
                }
            }
        }

        public void j(Object obj) {
            if (E(obj)) {
                P();
            }
        }

        public void k(Object obj) {
            int I;
            if (N(obj) == null && (I = I(obj)) >= 0) {
                SystemRouteRecord systemRouteRecord = this.f10732q.get(I);
                int f2 = MediaRouterJellybean.RouteInfo.f(obj);
                if (f2 != systemRouteRecord.f10737c.t()) {
                    systemRouteRecord.f10737c = new MediaRouteDescriptor.Builder(systemRouteRecord.f10737c).r(f2).e();
                    P();
                }
            }
        }

        public MediaRouteProvider.RouteController s(String str) {
            int J = J(str);
            if (J >= 0) {
                return new SystemRouteController(this.f10732q.get(J).f10735a);
            }
            return null;
        }

        public void u(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
            boolean z2;
            int i2 = 0;
            if (mediaRouteDiscoveryRequest != null) {
                List<String> e2 = mediaRouteDiscoveryRequest.c().e();
                int size = e2.size();
                int i3 = 0;
                while (i2 < size) {
                    String str = e2.get(i2);
                    if (str.equals("android.media.intent.category.LIVE_AUDIO")) {
                        i3 |= 1;
                    } else if (str.equals("android.media.intent.category.LIVE_VIDEO")) {
                        i3 |= 2;
                    } else {
                        i3 |= 8388608;
                    }
                    i2++;
                }
                z2 = mediaRouteDiscoveryRequest.d();
                i2 = i3;
            } else {
                z2 = false;
            }
            if (this.f10729n != i2 || this.f10730o != z2) {
                this.f10729n = i2;
                this.f10730o = z2;
                T();
            }
        }
    }

    private static class JellybeanMr1Impl extends JellybeanImpl implements MediaRouterJellybeanMr1.Callback {
        public JellybeanMr1Impl(Context context, SyncCallback syncCallback) {
            super(context, syncCallback);
        }

        /* access modifiers changed from: protected */
        public Object G() {
            return MediaRouterJellybeanMr1.a(this);
        }

        /* access modifiers changed from: protected */
        public void O(JellybeanImpl.SystemRouteRecord systemRouteRecord, MediaRouteDescriptor.Builder builder) {
            super.O(systemRouteRecord, builder);
            if (!MediaRouterJellybeanMr1.RouteInfo.b(systemRouteRecord.f10735a)) {
                builder.j(false);
            }
            if (V(systemRouteRecord)) {
                builder.g(1);
            }
            Display a2 = MediaRouterJellybeanMr1.RouteInfo.a(systemRouteRecord.f10735a);
            if (a2 != null) {
                builder.q(a2.getDisplayId());
            }
        }

        /* access modifiers changed from: protected */
        public boolean V(JellybeanImpl.SystemRouteRecord systemRouteRecord) {
            throw null;
        }

        public void i(Object obj) {
            int i2;
            int I = I(obj);
            if (I >= 0) {
                JellybeanImpl.SystemRouteRecord systemRouteRecord = this.f10732q.get(I);
                Display a2 = MediaRouterJellybeanMr1.RouteInfo.a(obj);
                if (a2 != null) {
                    i2 = a2.getDisplayId();
                } else {
                    i2 = -1;
                }
                if (i2 != systemRouteRecord.f10737c.r()) {
                    systemRouteRecord.f10737c = new MediaRouteDescriptor.Builder(systemRouteRecord.f10737c).q(i2).e();
                    P();
                }
            }
        }
    }

    private static class JellybeanMr2Impl extends JellybeanMr1Impl {
        public JellybeanMr2Impl(Context context, SyncCallback syncCallback) {
            super(context, syncCallback);
        }

        /* access modifiers changed from: protected */
        public Object L() {
            return MediaRouterJellybeanMr2.b(this.f10725j);
        }

        /* access modifiers changed from: protected */
        public void O(JellybeanImpl.SystemRouteRecord systemRouteRecord, MediaRouteDescriptor.Builder builder) {
            super.O(systemRouteRecord, builder);
            CharSequence a2 = MediaRouterJellybeanMr2.RouteInfo.a(systemRouteRecord.f10735a);
            if (a2 != null) {
                builder.h(a2.toString());
            }
        }

        /* access modifiers changed from: protected */
        public void Q(Object obj) {
            MediaRouterJellybean.j(this.f10725j, 8388611, obj);
        }

        /* access modifiers changed from: protected */
        public void R() {
            if (this.f10731p) {
                MediaRouterJellybean.h(this.f10725j, this.f10726k);
            }
            this.f10731p = true;
            MediaRouterJellybeanMr2.a(this.f10725j, this.f10729n, this.f10726k, this.f10730o | true ? 1 : 0);
        }

        /* access modifiers changed from: protected */
        public void U(JellybeanImpl.UserRouteRecord userRouteRecord) {
            super.U(userRouteRecord);
            MediaRouterJellybeanMr2.UserRouteInfo.a(userRouteRecord.f10739b, userRouteRecord.f10738a.d());
        }

        /* access modifiers changed from: protected */
        public boolean V(JellybeanImpl.SystemRouteRecord systemRouteRecord) {
            return MediaRouterJellybeanMr2.RouteInfo.b(systemRouteRecord.f10735a);
        }
    }

    public interface SyncCallback {
        void c(String str);
    }

    protected SystemMediaRouteProvider(Context context) {
        super(context, new MediaRouteProvider.ProviderMetadata(new ComponentName("android", SystemMediaRouteProvider.class.getName())));
    }

    public static SystemMediaRouteProvider z(Context context, SyncCallback syncCallback) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Api24Impl(context, syncCallback);
        }
        return new JellybeanMr2Impl(context, syncCallback);
    }

    public void A(MediaRouter.RouteInfo routeInfo) {
    }

    public void B(MediaRouter.RouteInfo routeInfo) {
    }

    public void C(MediaRouter.RouteInfo routeInfo) {
    }

    public void D(MediaRouter.RouteInfo routeInfo) {
    }
}
