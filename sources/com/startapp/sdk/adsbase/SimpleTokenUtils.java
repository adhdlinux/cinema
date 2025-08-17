package com.startapp.sdk.adsbase;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Pair;
import com.startapp.b7;
import com.startapp.da;
import com.startapp.hc;
import com.startapp.ia;
import com.startapp.lb;
import com.startapp.p;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.common.Constants;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.x6;
import com.startapp.y8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class SimpleTokenUtils {

    /* renamed from: a  reason: collision with root package name */
    public static List<PackageInfo> f36201a = null;

    /* renamed from: b  reason: collision with root package name */
    public static List<PackageInfo> f36202b = null;

    /* renamed from: c  reason: collision with root package name */
    public static long f36203c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static volatile Pair<TokenType, String> f36204d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile Pair<TokenType, String> f36205e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f36206f = true;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f36207g = false;

    /* renamed from: h  reason: collision with root package name */
    public static TokenType f36208h = TokenType.UNDEFINED;

    public enum TokenType {
        T1("token"),
        T2("token2"),
        UNDEFINED("");
        
        private final String text;

        /* access modifiers changed from: public */
        TokenType(String str) {
            this.text = str;
        }

        public static TokenType a(String str) {
            TokenType tokenType = T1;
            if (tokenType.text.equals(str)) {
                return tokenType;
            }
            TokenType tokenType2 = T2;
            if (tokenType2.text.equals(str)) {
                return tokenType2;
            }
            return UNDEFINED;
        }

        public String toString() {
            return this.text;
        }
    }

    public static class a extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            SimpleTokenUtils.f36204d = null;
            SimpleTokenUtils.f36205e = null;
            SimpleTokenUtils.f(context);
        }
    }

    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f36214a;

        public c(Context context) {
            this.f36214a = context;
        }

        public void run() {
            SimpleTokenUtils.e(this.f36214a);
        }
    }

    public static Pair<String, String> a() {
        if (f36204d != null) {
            return new Pair<>(((TokenType) f36204d.first).toString(), f36204d.second);
        }
        return new Pair<>(TokenType.T1.toString(), "");
    }

    public static long b() {
        return f36203c;
    }

    public static void c(Context context) {
        Context b2 = ia.b(context);
        f(b2);
        f36206f = true;
        f36207g = false;
        f36208h = TokenType.UNDEFINED;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        b2.registerReceiver(new a(), intentFilter);
        MetaData.f36379h.a((da) new b(b2));
    }

    @SuppressLint({"VisibleForTests"})
    public static void d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Set<String> q2 = MetaData.f36379h.q();
        Set<String> y2 = MetaData.f36379h.y();
        f36201a = new CopyOnWriteArrayList();
        f36202b = new CopyOnWriteArrayList();
        try {
            List<PackageInfo> a2 = hc.a(packageManager);
            f36203c = System.currentTimeMillis();
            PackageInfo packageInfo = null;
            for (PackageInfo next : a2) {
                if (!hc.a(next)) {
                    long j2 = next.firstInstallTime;
                    if (j2 < f36203c && j2 >= 1291593600000L) {
                        f36203c = j2;
                    }
                    f36201a.add(next);
                    try {
                        String str = next.packageName;
                        String b2 = lb.b(context);
                        if (q2 != null && q2.contains(b2)) {
                            f36202b.add(next);
                        }
                    } catch (Throwable th) {
                        y8.a(context, th);
                    }
                } else if (y2.contains(next.packageName)) {
                    f36201a.add(next);
                } else if (next.packageName.equals(Constants.f36416a)) {
                    packageInfo = next;
                }
            }
            f36201a = a(f36201a);
            f36202b = a(f36202b);
            if (packageInfo != null) {
                f36201a.add(0, packageInfo);
            }
        } catch (Throwable th2) {
            y8.a(context, th2);
        }
    }

    public static void e(Context context) {
        boolean a2 = MetaData.f36379h.E().a(context);
        synchronized (SimpleTokenUtils.class) {
            if ((f36204d == null || f36205e == null) && a2) {
                try {
                    d(context);
                    f36204d = new Pair<>(TokenType.T1, p.a(b(f36201a)));
                    f36205e = new Pair<>(TokenType.T2, p.a(b(f36202b)));
                } catch (Throwable th) {
                    y8.a(context, th);
                }
            }
        }
        return;
    }

    public static void f(Context context) {
        Context b2 = ia.b(context);
        try {
            if ((f36204d == null || f36205e == null) && MetaData.f36379h.E().a(b2)) {
                ComponentLocator.a(b2).i().execute(new c(b2));
            }
        } catch (Throwable th) {
            y8.a(b2, th);
        }
    }

    public static Pair<TokenType, String> b(Context context) {
        if (f36205e == null) {
            e(context);
        }
        x6.a a2 = ComponentLocator.a(context).d().edit();
        String str = (String) f36205e.second;
        a2.a("shared_prefs_simple_token2", str);
        a2.f36915a.putString("shared_prefs_simple_token2", str);
        a2.apply();
        f36206f = false;
        f36208h = TokenType.UNDEFINED;
        return new Pair<>(TokenType.T2, f36205e.second);
    }

    public static Pair<TokenType, String> a(Context context) {
        if (f36204d == null) {
            e(context);
        }
        x6.a a2 = ComponentLocator.a(context).d().edit();
        String str = (String) f36204d.second;
        a2.a("shared_prefs_simple_token", str);
        a2.f36915a.putString("shared_prefs_simple_token", str);
        a2.apply();
        f36206f = false;
        f36208h = TokenType.UNDEFINED;
        return new Pair<>(TokenType.T1, f36204d.second);
    }

    public static class b implements da {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f36213a;

        public b(Context context) {
            this.f36213a = context;
        }

        public void a(MetaDataRequest.RequestReason requestReason, boolean z2) {
            if (z2) {
                SimpleTokenUtils.f36204d = null;
                SimpleTokenUtils.f36205e = null;
                SimpleTokenUtils.f(this.f36213a);
            }
            MetaData.f36379h.a((da) this);
        }

        public void a(MetaDataRequest.RequestReason requestReason) {
            MetaData.f36379h.a((da) this);
        }
    }

    public static List<String> b(List<PackageInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (PackageInfo packageInfo : list) {
            arrayList.add(packageInfo.packageName);
        }
        return arrayList;
    }

    public static List<PackageInfo> a(List<PackageInfo> list) {
        if (list.size() <= 100) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new b7());
        return arrayList.subList(0, 100);
    }
}
