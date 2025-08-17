package androidx.mediarouter.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import androidx.mediarouter.media.MediaRouteProvider;
import androidx.mediarouter.media.MediaRouter;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class RegisteredMediaRouteProvider extends MediaRouteProvider implements ServiceConnection {

    /* renamed from: q  reason: collision with root package name */
    static final boolean f10659q = Log.isLoggable("MediaRouteProviderProxy", 3);

    /* renamed from: i  reason: collision with root package name */
    private final ComponentName f10660i;

    /* renamed from: j  reason: collision with root package name */
    final PrivateHandler f10661j;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList<ControllerConnection> f10662k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private boolean f10663l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10664m;

    /* renamed from: n  reason: collision with root package name */
    private Connection f10665n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f10666o;

    /* renamed from: p  reason: collision with root package name */
    private ControllerCallback f10667p;

    private final class Connection implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        private final Messenger f10668a;

        /* renamed from: b  reason: collision with root package name */
        private final ReceiveHandler f10669b;

        /* renamed from: c  reason: collision with root package name */
        private final Messenger f10670c;

        /* renamed from: d  reason: collision with root package name */
        private int f10671d = 1;

        /* renamed from: e  reason: collision with root package name */
        private int f10672e = 1;

        /* renamed from: f  reason: collision with root package name */
        private int f10673f;

        /* renamed from: g  reason: collision with root package name */
        private int f10674g;

        /* renamed from: h  reason: collision with root package name */
        private final SparseArray<MediaRouter.ControlRequestCallback> f10675h = new SparseArray<>();

        public Connection(Messenger messenger) {
            this.f10668a = messenger;
            ReceiveHandler receiveHandler = new ReceiveHandler(this);
            this.f10669b = receiveHandler;
            this.f10670c = new Messenger(receiveHandler);
        }

        private boolean s(int i2, int i3, int i4, Object obj, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.arg1 = i3;
            obtain.arg2 = i4;
            obtain.obj = obj;
            obtain.setData(bundle);
            obtain.replyTo = this.f10670c;
            try {
                this.f10668a.send(obtain);
                return true;
            } catch (DeadObjectException unused) {
                return false;
            } catch (RemoteException e2) {
                if (i2 == 2) {
                    return false;
                }
                Log.e("MediaRouteProviderProxy", "Could not send message to service.", e2);
                return false;
            }
        }

        public void a(int i2, String str) {
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            int i3 = this.f10671d;
            this.f10671d = i3 + 1;
            s(12, i3, i2, (Object) null, bundle);
        }

        public int b(String str, MediaRouter.ControlRequestCallback controlRequestCallback) {
            int i2 = this.f10672e;
            this.f10672e = i2 + 1;
            int i3 = this.f10671d;
            this.f10671d = i3 + 1;
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            s(11, i3, i2, (Object) null, bundle);
            this.f10675h.put(i3, controlRequestCallback);
            return i2;
        }

        public void binderDied() {
            RegisteredMediaRouteProvider.this.f10661j.post(new Runnable() {
                public void run() {
                    Connection connection = Connection.this;
                    RegisteredMediaRouteProvider.this.J(connection);
                }
            });
        }

        public int c(String str, String str2) {
            int i2 = this.f10672e;
            this.f10672e = i2 + 1;
            Bundle bundle = new Bundle();
            bundle.putString("routeId", str);
            bundle.putString("routeGroupId", str2);
            int i3 = this.f10671d;
            this.f10671d = i3 + 1;
            s(3, i3, i2, (Object) null, bundle);
            return i2;
        }

        public void d() {
            s(2, 0, 0, (Object) null, (Bundle) null);
            this.f10669b.a();
            this.f10668a.getBinder().unlinkToDeath(this, 0);
            RegisteredMediaRouteProvider.this.f10661j.post(new Runnable() {
                public void run() {
                    Connection.this.e();
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void e() {
            int size = this.f10675h.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f10675h.valueAt(i2).a((String) null, (Bundle) null);
            }
            this.f10675h.clear();
        }

        public boolean f(int i2, String str, Bundle bundle) {
            MediaRouter.ControlRequestCallback controlRequestCallback = this.f10675h.get(i2);
            if (controlRequestCallback == null) {
                return false;
            }
            this.f10675h.remove(i2);
            controlRequestCallback.a(str, bundle);
            return true;
        }

        public boolean g(int i2, Bundle bundle) {
            MediaRouter.ControlRequestCallback controlRequestCallback = this.f10675h.get(i2);
            if (controlRequestCallback == null) {
                return false;
            }
            this.f10675h.remove(i2);
            controlRequestCallback.b(bundle);
            return true;
        }

        public void h(int i2) {
            RegisteredMediaRouteProvider.this.H(this, i2);
        }

        public boolean i(Bundle bundle) {
            if (this.f10673f == 0) {
                return false;
            }
            RegisteredMediaRouteProvider.this.I(this, MediaRouteProviderDescriptor.a(bundle));
            return true;
        }

        public void j(int i2, Bundle bundle) {
            MediaRouter.ControlRequestCallback controlRequestCallback = this.f10675h.get(i2);
            if (bundle == null || !bundle.containsKey("routeId")) {
                controlRequestCallback.a("DynamicGroupRouteController is created without valid route id.", bundle);
                return;
            }
            this.f10675h.remove(i2);
            controlRequestCallback.b(bundle);
        }

        public boolean k(int i2, Bundle bundle) {
            MediaRouteDescriptor mediaRouteDescriptor;
            if (this.f10673f == 0) {
                return false;
            }
            Bundle bundle2 = (Bundle) bundle.getParcelable("groupRoute");
            if (bundle2 != null) {
                mediaRouteDescriptor = MediaRouteDescriptor.d(bundle2);
            } else {
                mediaRouteDescriptor = null;
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("dynamicRoutes");
            ArrayList arrayList = new ArrayList();
            Iterator it2 = parcelableArrayList.iterator();
            while (it2.hasNext()) {
                arrayList.add(MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor.a((Bundle) it2.next()));
            }
            RegisteredMediaRouteProvider.this.N(this, i2, mediaRouteDescriptor, arrayList);
            return true;
        }

        public boolean l(int i2) {
            if (i2 == this.f10674g) {
                this.f10674g = 0;
                RegisteredMediaRouteProvider.this.K(this, "Registration failed");
            }
            MediaRouter.ControlRequestCallback controlRequestCallback = this.f10675h.get(i2);
            if (controlRequestCallback == null) {
                return true;
            }
            this.f10675h.remove(i2);
            controlRequestCallback.a((String) null, (Bundle) null);
            return true;
        }

        public boolean m(int i2) {
            return true;
        }

        public boolean n(int i2, int i3, Bundle bundle) {
            if (this.f10673f != 0 || i2 != this.f10674g || i3 < 1) {
                return false;
            }
            this.f10674g = 0;
            this.f10673f = i3;
            RegisteredMediaRouteProvider.this.I(this, MediaRouteProviderDescriptor.a(bundle));
            RegisteredMediaRouteProvider.this.L(this);
            return true;
        }

        public boolean o() {
            int i2 = this.f10671d;
            this.f10671d = i2 + 1;
            this.f10674g = i2;
            if (!s(1, i2, 4, (Object) null, (Bundle) null)) {
                return false;
            }
            try {
                this.f10668a.getBinder().linkToDeath(this, 0);
                return true;
            } catch (RemoteException unused) {
                binderDied();
                return false;
            }
        }

        public void p(int i2) {
            int i3 = this.f10671d;
            this.f10671d = i3 + 1;
            s(4, i3, i2, (Object) null, (Bundle) null);
        }

        public void q(int i2, String str) {
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            int i3 = this.f10671d;
            this.f10671d = i3 + 1;
            s(13, i3, i2, (Object) null, bundle);
        }

        public void r(int i2) {
            int i3 = this.f10671d;
            this.f10671d = i3 + 1;
            s(5, i3, i2, (Object) null, (Bundle) null);
        }

        public void t(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
            Bundle bundle;
            int i2 = this.f10671d;
            this.f10671d = i2 + 1;
            if (mediaRouteDiscoveryRequest != null) {
                bundle = mediaRouteDiscoveryRequest.a();
            } else {
                bundle = null;
            }
            s(10, i2, 0, bundle, (Bundle) null);
        }

        public void u(int i2, int i3) {
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i3);
            int i4 = this.f10671d;
            this.f10671d = i4 + 1;
            s(7, i4, i2, (Object) null, bundle);
        }

        public void v(int i2, int i3) {
            Bundle bundle = new Bundle();
            bundle.putInt("unselectReason", i3);
            int i4 = this.f10671d;
            this.f10671d = i4 + 1;
            s(6, i4, i2, (Object) null, bundle);
        }

        public void w(int i2, List<String> list) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("memberRouteIds", new ArrayList(list));
            int i3 = this.f10671d;
            this.f10671d = i3 + 1;
            s(14, i3, i2, (Object) null, bundle);
        }

        public void x(int i2, int i3) {
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i3);
            int i4 = this.f10671d;
            this.f10671d = i4 + 1;
            s(8, i4, i2, (Object) null, bundle);
        }
    }

    interface ControllerCallback {
        void a(MediaRouteProvider.RouteController routeController);
    }

    interface ControllerConnection {
        int a();

        void b();

        void c(Connection connection);
    }

    private static final class PrivateHandler extends Handler {
        PrivateHandler() {
        }
    }

    private static final class ReceiveHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<Connection> f10679a;

        public ReceiveHandler(Connection connection) {
            this.f10679a = new WeakReference<>(connection);
        }

        private boolean b(Connection connection, int i2, int i3, int i4, Object obj, Bundle bundle) {
            String str;
            switch (i2) {
                case 0:
                    connection.l(i3);
                    return true;
                case 1:
                    connection.m(i3);
                    return true;
                case 2:
                    if (obj == null || (obj instanceof Bundle)) {
                        return connection.n(i3, i4, (Bundle) obj);
                    }
                    return false;
                case 3:
                    if (obj == null || (obj instanceof Bundle)) {
                        return connection.g(i3, (Bundle) obj);
                    }
                    return false;
                case 4:
                    if (obj != null && !(obj instanceof Bundle)) {
                        return false;
                    }
                    if (bundle == null) {
                        str = null;
                    } else {
                        str = bundle.getString(MRAIDPresenter.ERROR);
                    }
                    return connection.f(i3, str, (Bundle) obj);
                case 5:
                    if (obj == null || (obj instanceof Bundle)) {
                        return connection.i((Bundle) obj);
                    }
                    return false;
                case 6:
                    if (obj instanceof Bundle) {
                        connection.j(i3, (Bundle) obj);
                        return false;
                    }
                    Log.w("MediaRouteProviderProxy", "No further information on the dynamic group controller");
                    return false;
                case 7:
                    if (obj == null || (obj instanceof Bundle)) {
                        return connection.k(i4, (Bundle) obj);
                    }
                    return false;
                case 8:
                    connection.h(i4);
                    return false;
                default:
                    return false;
            }
        }

        public void a() {
            this.f10679a.clear();
        }

        public void handleMessage(Message message) {
            Connection connection = this.f10679a.get();
            if (connection != null) {
                if (!b(connection, message.what, message.arg1, message.arg2, message.obj, message.peekData()) && RegisteredMediaRouteProvider.f10659q) {
                    Log.d("MediaRouteProviderProxy", "Unhandled message from server: " + message);
                }
            }
        }
    }

    private final class RegisteredDynamicController extends MediaRouteProvider.DynamicGroupRouteController implements ControllerConnection {

        /* renamed from: f  reason: collision with root package name */
        private final String f10680f;

        /* renamed from: g  reason: collision with root package name */
        String f10681g;

        /* renamed from: h  reason: collision with root package name */
        String f10682h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f10683i;

        /* renamed from: j  reason: collision with root package name */
        private int f10684j = -1;

        /* renamed from: k  reason: collision with root package name */
        private int f10685k;

        /* renamed from: l  reason: collision with root package name */
        private Connection f10686l;

        /* renamed from: m  reason: collision with root package name */
        private int f10687m = -1;

        RegisteredDynamicController(String str) {
            this.f10680f = str;
        }

        public int a() {
            return this.f10687m;
        }

        public void b() {
            Connection connection = this.f10686l;
            if (connection != null) {
                connection.p(this.f10687m);
                this.f10686l = null;
                this.f10687m = 0;
            }
        }

        public void c(Connection connection) {
            AnonymousClass1 r02 = new MediaRouter.ControlRequestCallback() {
                public void a(String str, Bundle bundle) {
                    Log.d("MediaRouteProviderProxy", "Error: " + str + ", data: " + bundle);
                }

                public void b(Bundle bundle) {
                    RegisteredDynamicController.this.f10681g = bundle.getString("groupableTitle");
                    RegisteredDynamicController.this.f10682h = bundle.getString("transferableTitle");
                }
            };
            this.f10686l = connection;
            int b2 = connection.b(this.f10680f, r02);
            this.f10687m = b2;
            if (this.f10683i) {
                connection.r(b2);
                int i2 = this.f10684j;
                if (i2 >= 0) {
                    connection.u(this.f10687m, i2);
                    this.f10684j = -1;
                }
                int i3 = this.f10685k;
                if (i3 != 0) {
                    connection.x(this.f10687m, i3);
                    this.f10685k = 0;
                }
            }
        }

        public void d() {
            RegisteredMediaRouteProvider.this.M(this);
        }

        public void e() {
            this.f10683i = true;
            Connection connection = this.f10686l;
            if (connection != null) {
                connection.r(this.f10687m);
            }
        }

        public void f(int i2) {
            Connection connection = this.f10686l;
            if (connection != null) {
                connection.u(this.f10687m, i2);
                return;
            }
            this.f10684j = i2;
            this.f10685k = 0;
        }

        public void g() {
            h(0);
        }

        public void h(int i2) {
            this.f10683i = false;
            Connection connection = this.f10686l;
            if (connection != null) {
                connection.v(this.f10687m, i2);
            }
        }

        public void i(int i2) {
            Connection connection = this.f10686l;
            if (connection != null) {
                connection.x(this.f10687m, i2);
            } else {
                this.f10685k += i2;
            }
        }

        public String j() {
            return this.f10681g;
        }

        public String k() {
            return this.f10682h;
        }

        public void m(String str) {
            Connection connection = this.f10686l;
            if (connection != null) {
                connection.a(this.f10687m, str);
            }
        }

        public void n(String str) {
            Connection connection = this.f10686l;
            if (connection != null) {
                connection.q(this.f10687m, str);
            }
        }

        public void o(List<String> list) {
            Connection connection = this.f10686l;
            if (connection != null) {
                connection.w(this.f10687m, list);
            }
        }

        /* access modifiers changed from: package-private */
        public void q(MediaRouteDescriptor mediaRouteDescriptor, List<MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor> list) {
            l(mediaRouteDescriptor, list);
        }
    }

    private final class RegisteredRouteController extends MediaRouteProvider.RouteController implements ControllerConnection {

        /* renamed from: a  reason: collision with root package name */
        private final String f10690a;

        /* renamed from: b  reason: collision with root package name */
        private final String f10691b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10692c;

        /* renamed from: d  reason: collision with root package name */
        private int f10693d = -1;

        /* renamed from: e  reason: collision with root package name */
        private int f10694e;

        /* renamed from: f  reason: collision with root package name */
        private Connection f10695f;

        /* renamed from: g  reason: collision with root package name */
        private int f10696g;

        RegisteredRouteController(String str, String str2) {
            this.f10690a = str;
            this.f10691b = str2;
        }

        public int a() {
            return this.f10696g;
        }

        public void b() {
            Connection connection = this.f10695f;
            if (connection != null) {
                connection.p(this.f10696g);
                this.f10695f = null;
                this.f10696g = 0;
            }
        }

        public void c(Connection connection) {
            this.f10695f = connection;
            int c2 = connection.c(this.f10690a, this.f10691b);
            this.f10696g = c2;
            if (this.f10692c) {
                connection.r(c2);
                int i2 = this.f10693d;
                if (i2 >= 0) {
                    connection.u(this.f10696g, i2);
                    this.f10693d = -1;
                }
                int i3 = this.f10694e;
                if (i3 != 0) {
                    connection.x(this.f10696g, i3);
                    this.f10694e = 0;
                }
            }
        }

        public void d() {
            RegisteredMediaRouteProvider.this.M(this);
        }

        public void e() {
            this.f10692c = true;
            Connection connection = this.f10695f;
            if (connection != null) {
                connection.r(this.f10696g);
            }
        }

        public void f(int i2) {
            Connection connection = this.f10695f;
            if (connection != null) {
                connection.u(this.f10696g, i2);
                return;
            }
            this.f10693d = i2;
            this.f10694e = 0;
        }

        public void g() {
            h(0);
        }

        public void h(int i2) {
            this.f10692c = false;
            Connection connection = this.f10695f;
            if (connection != null) {
                connection.v(this.f10696g, i2);
            }
        }

        public void i(int i2) {
            Connection connection = this.f10695f;
            if (connection != null) {
                connection.x(this.f10696g, i2);
            } else {
                this.f10694e += i2;
            }
        }
    }

    public RegisteredMediaRouteProvider(Context context, ComponentName componentName) {
        super(context, new MediaRouteProvider.ProviderMetadata(componentName));
        this.f10660i = componentName;
        this.f10661j = new PrivateHandler();
    }

    private void A() {
        int i2;
        if (!this.f10664m) {
            boolean z2 = f10659q;
            if (z2) {
                Log.d("MediaRouteProviderProxy", this + ": Binding");
            }
            Intent intent = new Intent("android.media.MediaRouteProviderService");
            intent.setComponent(this.f10660i);
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    i2 = 4097;
                } else {
                    i2 = 1;
                }
                boolean bindService = n().bindService(intent, this, i2);
                this.f10664m = bindService;
                if (!bindService && z2) {
                    Log.d("MediaRouteProviderProxy", this + ": Bind failed");
                }
            } catch (SecurityException e2) {
                if (f10659q) {
                    Log.d("MediaRouteProviderProxy", this + ": Bind failed", e2);
                }
            }
        }
    }

    private MediaRouteProvider.DynamicGroupRouteController B(String str) {
        MediaRouteProviderDescriptor o2 = o();
        if (o2 == null) {
            return null;
        }
        List<MediaRouteDescriptor> b2 = o2.b();
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (b2.get(i2).l().equals(str)) {
                RegisteredDynamicController registeredDynamicController = new RegisteredDynamicController(str);
                this.f10662k.add(registeredDynamicController);
                if (this.f10666o) {
                    registeredDynamicController.c(this.f10665n);
                }
                U();
                return registeredDynamicController;
            }
        }
        return null;
    }

    private MediaRouteProvider.RouteController C(String str, String str2) {
        MediaRouteProviderDescriptor o2 = o();
        if (o2 == null) {
            return null;
        }
        List<MediaRouteDescriptor> b2 = o2.b();
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (b2.get(i2).l().equals(str)) {
                RegisteredRouteController registeredRouteController = new RegisteredRouteController(str, str2);
                this.f10662k.add(registeredRouteController);
                if (this.f10666o) {
                    registeredRouteController.c(this.f10665n);
                }
                U();
                return registeredRouteController;
            }
        }
        return null;
    }

    private void D() {
        int size = this.f10662k.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f10662k.get(i2).b();
        }
    }

    private void E() {
        if (this.f10665n != null) {
            w((MediaRouteProviderDescriptor) null);
            this.f10666o = false;
            D();
            this.f10665n.d();
            this.f10665n = null;
        }
    }

    private ControllerConnection F(int i2) {
        Iterator<ControllerConnection> it2 = this.f10662k.iterator();
        while (it2.hasNext()) {
            ControllerConnection next = it2.next();
            if (next.a() == i2) {
                return next;
            }
        }
        return null;
    }

    private boolean Q() {
        if (!this.f10663l) {
            return false;
        }
        if (p() == null && this.f10662k.isEmpty()) {
            return false;
        }
        return true;
    }

    private void T() {
        if (this.f10664m) {
            if (f10659q) {
                Log.d("MediaRouteProviderProxy", this + ": Unbinding");
            }
            this.f10664m = false;
            E();
            try {
                n().unbindService(this);
            } catch (IllegalArgumentException e2) {
                Log.e("MediaRouteProviderProxy", this + ": unbindService failed", e2);
            }
        }
    }

    private void U() {
        if (Q()) {
            A();
        } else {
            T();
        }
    }

    private void z() {
        int size = this.f10662k.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f10662k.get(i2).c(this.f10665n);
        }
    }

    public boolean G(String str, String str2) {
        if (!this.f10660i.getPackageName().equals(str) || !this.f10660i.getClassName().equals(str2)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void H(Connection connection, int i2) {
        if (this.f10665n == connection) {
            ControllerConnection F = F(i2);
            ControllerCallback controllerCallback = this.f10667p;
            if (controllerCallback != null && (F instanceof MediaRouteProvider.RouteController)) {
                controllerCallback.a((MediaRouteProvider.RouteController) F);
            }
            M(F);
        }
    }

    /* access modifiers changed from: package-private */
    public void I(Connection connection, MediaRouteProviderDescriptor mediaRouteProviderDescriptor) {
        if (this.f10665n == connection) {
            if (f10659q) {
                Log.d("MediaRouteProviderProxy", this + ": Descriptor changed, descriptor=" + mediaRouteProviderDescriptor);
            }
            w(mediaRouteProviderDescriptor);
        }
    }

    /* access modifiers changed from: package-private */
    public void J(Connection connection) {
        if (this.f10665n == connection) {
            if (f10659q) {
                Log.d("MediaRouteProviderProxy", this + ": Service connection died");
            }
            E();
        }
    }

    /* access modifiers changed from: package-private */
    public void K(Connection connection, String str) {
        if (this.f10665n == connection) {
            if (f10659q) {
                Log.d("MediaRouteProviderProxy", this + ": Service connection error - " + str);
            }
            T();
        }
    }

    /* access modifiers changed from: package-private */
    public void L(Connection connection) {
        if (this.f10665n == connection) {
            this.f10666o = true;
            z();
            MediaRouteDiscoveryRequest p2 = p();
            if (p2 != null) {
                this.f10665n.t(p2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void M(ControllerConnection controllerConnection) {
        this.f10662k.remove(controllerConnection);
        controllerConnection.b();
        U();
    }

    /* access modifiers changed from: package-private */
    public void N(Connection connection, int i2, MediaRouteDescriptor mediaRouteDescriptor, List<MediaRouteProvider.DynamicGroupRouteController.DynamicRouteDescriptor> list) {
        if (this.f10665n == connection) {
            if (f10659q) {
                Log.d("MediaRouteProviderProxy", this + ": DynamicRouteDescriptors changed, descriptors=" + list);
            }
            ControllerConnection F = F(i2);
            if (F instanceof RegisteredDynamicController) {
                ((RegisteredDynamicController) F).q(mediaRouteDescriptor, list);
            }
        }
    }

    public void O() {
        if (this.f10665n == null && Q()) {
            T();
            A();
        }
    }

    public void P(ControllerCallback controllerCallback) {
        this.f10667p = controllerCallback;
    }

    public void R() {
        if (!this.f10663l) {
            if (f10659q) {
                Log.d("MediaRouteProviderProxy", this + ": Starting");
            }
            this.f10663l = true;
            U();
        }
    }

    public void S() {
        if (this.f10663l) {
            if (f10659q) {
                Log.d("MediaRouteProviderProxy", this + ": Stopping");
            }
            this.f10663l = false;
            U();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Messenger messenger;
        boolean z2 = f10659q;
        if (z2) {
            Log.d("MediaRouteProviderProxy", this + ": Connected");
        }
        if (this.f10664m) {
            E();
            if (iBinder != null) {
                messenger = new Messenger(iBinder);
            } else {
                messenger = null;
            }
            if (MediaRouteProviderProtocol.a(messenger)) {
                Connection connection = new Connection(messenger);
                if (connection.o()) {
                    this.f10665n = connection;
                } else if (z2) {
                    Log.d("MediaRouteProviderProxy", this + ": Registration failed");
                }
            } else {
                Log.e("MediaRouteProviderProxy", this + ": Service returned invalid messenger binder");
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (f10659q) {
            Log.d("MediaRouteProviderProxy", this + ": Service disconnected");
        }
        E();
    }

    public MediaRouteProvider.DynamicGroupRouteController r(String str) {
        if (str != null) {
            return B(str);
        }
        throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
    }

    public MediaRouteProvider.RouteController s(String str) {
        if (str != null) {
            return C(str, (String) null);
        }
        throw new IllegalArgumentException("routeId cannot be null");
    }

    public MediaRouteProvider.RouteController t(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        } else if (str2 != null) {
            return C(str, str2);
        } else {
            throw new IllegalArgumentException("routeGroupId cannot be null");
        }
    }

    public String toString() {
        return "Service connection " + this.f10660i.flattenToShortString();
    }

    public void u(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
        if (this.f10666o) {
            this.f10665n.t(mediaRouteDiscoveryRequest);
        }
        U();
    }
}
