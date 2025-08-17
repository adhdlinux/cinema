package androidx.mediarouter.media;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Handler;
import androidx.mediarouter.media.MediaRouteProvider;
import androidx.mediarouter.media.RegisteredMediaRouteProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class RegisteredMediaRouteProviderWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final Context f10698a;

    /* renamed from: b  reason: collision with root package name */
    final Callback f10699b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f10700c;

    /* renamed from: d  reason: collision with root package name */
    private final PackageManager f10701d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<RegisteredMediaRouteProvider> f10702e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f10703f;

    /* renamed from: g  reason: collision with root package name */
    private final BroadcastReceiver f10704g = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            RegisteredMediaRouteProviderWatcher.this.g();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f10705h = new Runnable() {
        public void run() {
            RegisteredMediaRouteProviderWatcher.this.g();
        }
    };

    public interface Callback {
        void a(MediaRouteProvider mediaRouteProvider);

        void b(MediaRouteProvider mediaRouteProvider);

        void d(RegisteredMediaRouteProvider registeredMediaRouteProvider, MediaRouteProvider.RouteController routeController);
    }

    RegisteredMediaRouteProviderWatcher(Context context, Callback callback) {
        this.f10698a = context;
        this.f10699b = callback;
        this.f10700c = new Handler();
        this.f10701d = context.getPackageManager();
    }

    private int b(String str, String str2) {
        int size = this.f10702e.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f10702e.get(i2).G(str, str2)) {
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(RegisteredMediaRouteProvider registeredMediaRouteProvider, MediaRouteProvider.RouteController routeController) {
        this.f10699b.d(registeredMediaRouteProvider, routeController);
    }

    static boolean e(List<ServiceInfo> list, ServiceInfo serviceInfo) {
        if (!(serviceInfo == null || list == null || list.isEmpty())) {
            for (ServiceInfo next : list) {
                if (serviceInfo.packageName.equals(next.packageName) && serviceInfo.name.equals(next.name)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public List<ServiceInfo> c() {
        Intent intent = new Intent("android.media.MediaRoute2ProviderService");
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : this.f10701d.queryIntentServices(intent, 0)) {
            arrayList.add(resolveInfo.serviceInfo);
        }
        return arrayList;
    }

    public void f() {
        this.f10700c.post(this.f10705h);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        int i2;
        if (this.f10703f) {
            List arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 30) {
                arrayList = c();
            }
            int i3 = 0;
            for (ResolveInfo resolveInfo : this.f10701d.queryIntentServices(new Intent("android.media.MediaRouteProviderService"), 0)) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null && (!MediaRouter.p() || !e(arrayList, serviceInfo))) {
                    int b2 = b(serviceInfo.packageName, serviceInfo.name);
                    if (b2 < 0) {
                        RegisteredMediaRouteProvider registeredMediaRouteProvider = new RegisteredMediaRouteProvider(this.f10698a, new ComponentName(serviceInfo.packageName, serviceInfo.name));
                        registeredMediaRouteProvider.P(new m0(this, registeredMediaRouteProvider));
                        registeredMediaRouteProvider.R();
                        i2 = i3 + 1;
                        this.f10702e.add(i3, registeredMediaRouteProvider);
                        this.f10699b.a(registeredMediaRouteProvider);
                    } else if (b2 >= i3) {
                        RegisteredMediaRouteProvider registeredMediaRouteProvider2 = this.f10702e.get(b2);
                        registeredMediaRouteProvider2.R();
                        registeredMediaRouteProvider2.O();
                        i2 = i3 + 1;
                        Collections.swap(this.f10702e, b2, i3);
                    }
                    i3 = i2;
                }
            }
            if (i3 < this.f10702e.size()) {
                for (int size = this.f10702e.size() - 1; size >= i3; size--) {
                    RegisteredMediaRouteProvider registeredMediaRouteProvider3 = this.f10702e.get(size);
                    this.f10699b.b(registeredMediaRouteProvider3);
                    this.f10702e.remove(registeredMediaRouteProvider3);
                    registeredMediaRouteProvider3.P((RegisteredMediaRouteProvider.ControllerCallback) null);
                    registeredMediaRouteProvider3.S();
                }
            }
        }
    }

    public void h() {
        if (!this.f10703f) {
            this.f10703f = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addAction("android.intent.action.PACKAGE_RESTARTED");
            intentFilter.addDataScheme("package");
            this.f10698a.registerReceiver(this.f10704g, intentFilter, (String) null, this.f10700c);
            this.f10700c.post(this.f10705h);
        }
    }
}
