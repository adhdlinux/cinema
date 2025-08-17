package com.adcolony.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.adcolony.sdk.e0;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdColony {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f12821a = z0.P();

    static AdColonyZone a(String str) {
        AdColonyZone adColonyZone;
        if (a.h()) {
            adColonyZone = a.f().c().get(str);
        } else if (a.i()) {
            adColonyZone = a.f().c().get(str);
        } else {
            adColonyZone = null;
        }
        if (adColonyZone != null) {
            return adColonyZone;
        }
        AdColonyZone adColonyZone2 = new AdColonyZone(str);
        adColonyZone2.f(6);
        return adColonyZone2;
    }

    static void b(Context context, AdColonyAppOptions adColonyAppOptions) {
        k f2 = a.f();
        q x02 = f2.x0();
        if (adColonyAppOptions != null && context != null) {
            String G = z0.G(context);
            String B = z0.B();
            int E = z0.E();
            String O = x02.O();
            String h2 = f2.H0().h();
            HashMap hashMap = new HashMap();
            hashMap.put(JsonStorageKeyNames.SESSION_ID_KEY, "unknown");
            hashMap.put("countryLocale", Locale.getDefault().getDisplayLanguage() + " (" + Locale.getDefault().getDisplayCountry() + ")");
            hashMap.put("countryLocaleShort", a.f().x0().R());
            hashMap.put("manufacturer", a.f().x0().c());
            hashMap.put("model", a.f().x0().f());
            hashMap.put("osVersion", a.f().x0().h());
            hashMap.put("carrierName", O);
            hashMap.put("networkType", h2);
            hashMap.put("platform", "android");
            hashMap.put("appName", G);
            hashMap.put("appVersion", B);
            hashMap.put("appBuildNumber", Integer.valueOf(E));
            hashMap.put("appId", "" + adColonyAppOptions.b());
            hashMap.put("apiLevel", Integer.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("sdkVersion", a.f().x0().i());
            hashMap.put("controllerVersion", "unknown");
            f1 f1Var = new f1(adColonyAppOptions.e());
            f1 f1Var2 = new f1(adColonyAppOptions.h());
            if (!c0.E(f1Var, "mediation_network").equals("")) {
                hashMap.put("mediationNetwork", c0.E(f1Var, "mediation_network"));
                hashMap.put("mediationNetworkVersion", c0.E(f1Var, "mediation_network_version"));
            }
            if (!c0.E(f1Var2, "plugin").equals("")) {
                hashMap.put("plugin", c0.E(f1Var2, "plugin"));
                hashMap.put("pluginVersion", c0.E(f1Var2, "plugin_version"));
            }
            f2.D0().h(hashMap);
        }
    }

    static boolean c(Runnable runnable) {
        return z0.q(f12821a, runnable);
    }

    public static boolean d(AdColonyCustomMessageListener adColonyCustomMessageListener, String str) {
        if (!a.j()) {
            new e0.a().c("Ignoring call to AdColony.addCustomMessageListener as AdColony ").c("has not yet been configured.").d(e0.f13111f);
            return false;
        } else if (!z0.J(str)) {
            new e0.a().c("Ignoring call to AdColony.addCustomMessageListener.").d(e0.f13111f);
            return false;
        } else {
            a.f().v0().put(str, adColonyCustomMessageListener);
            return true;
        }
    }

    static void e() {
        if (f12821a.isShutdown()) {
            f12821a = Executors.newSingleThreadExecutor();
        }
    }

    public static boolean f() {
        if (!a.j()) {
            return false;
        }
        Context a2 = a.a();
        if (a2 != null && (a2 instanceof b)) {
            ((Activity) a2).finish();
        }
        k f2 = a.f();
        f2.T().m();
        f2.p();
        f2.r();
        f2.R(true);
        return true;
    }

    static void g() {
        f12821a.shutdown();
    }

    public static boolean h(String str) {
        if (!a.j()) {
            new e0.a().c("Ignoring call to AdColony.removeCustomMessageListener as AdColony").c(" has not yet been configured.").d(e0.f13111f);
            return false;
        }
        a.f().v0().remove(str);
        return true;
    }
}
