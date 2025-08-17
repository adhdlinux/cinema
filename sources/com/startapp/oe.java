package com.startapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.startapp.sdk.adsbase.remoteconfig.RcdMetadata;
import com.startapp.sdk.adsbase.remoteconfig.RcdTargets;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public class oe {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f35574a = {"getSupportFragmentManager", "getFragmentManager"};

    /* renamed from: b  reason: collision with root package name */
    public final Context f35575b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f35576c;

    /* renamed from: d  reason: collision with root package name */
    public final Executor f35577d;

    /* renamed from: e  reason: collision with root package name */
    public final ua<RcdMetadata> f35578e;

    /* renamed from: f  reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f35579f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, Integer> f35580g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, List<WeakReference<Activity>>> f35581h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public String f35582i;

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f35583j = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                oe.this.d();
            } catch (Throwable th) {
                y8.a(oe.this.f35575b, th);
            }
        }
    }

    public class b extends oa {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f35585a;

        public b(Context context) {
            this.f35585a = context;
        }

        public void onActivityPostResumed(Activity activity) {
            try {
                oe.this.a(activity);
            } catch (Throwable th) {
                y8.a(this.f35585a, th);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f35587a;

        public c(Activity activity) {
            this.f35587a = activity;
        }

        public void run() {
            try {
                oe.this.b(this.f35587a);
            } catch (Throwable th) {
                y8.a(oe.this.f35575b, th);
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f35589a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f35590b;

        public d(Activity activity, View view) {
            this.f35589a = activity;
            this.f35590b = view;
        }

        public void run() {
            oe oeVar;
            try {
                oeVar = oe.this;
                Activity activity = this.f35589a;
                View view = this.f35590b;
                RcdTargets a2 = oeVar.a();
                if (a2 != null) {
                    if (oeVar.a(a2, activity)) {
                        return;
                    }
                    try {
                        oeVar.a(a2, view);
                    } catch (Throwable th) {
                        y8.a(oeVar.f35575b, th);
                    }
                    oeVar.f35577d.execute(oeVar.f35583j);
                }
            } catch (Throwable th2) {
                y8.a(oe.this.f35575b, th2);
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StackTraceElement[] f35592a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f35593b;

        public e(StackTraceElement[] stackTraceElementArr, int i2) {
            this.f35592a = stackTraceElementArr;
            this.f35593b = i2;
        }

        public void run() {
            try {
                oe oeVar = oe.this;
                StackTraceElement[] stackTraceElementArr = this.f35592a;
                int i2 = this.f35593b;
                RcdTargets a2 = oeVar.a();
                if (a2 != null) {
                    for (StackTraceElement className : stackTraceElementArr) {
                        oeVar.a(a2, className.getClassName(), i2);
                    }
                    oeVar.f35577d.execute(oeVar.f35583j);
                }
            } catch (Throwable th) {
                y8.a(oe.this.f35575b, th);
            }
        }
    }

    public oe(Context context, Executor executor, ua<RcdMetadata> uaVar) {
        this.f35575b = context;
        this.f35576c = executor;
        this.f35577d = new gb(executor);
        this.f35578e = uaVar;
        this.f35579f = new b(context);
    }

    public final RcdTargets a() {
        RcdMetadata call = this.f35578e.call();
        if (call == null || !call.c()) {
            call = null;
        }
        if (call != null) {
            return call.b();
        }
        return null;
    }

    public final boolean b() {
        RcdMetadata call = this.f35578e.call();
        if (call == null || !call.c()) {
            call = null;
        }
        return Boolean.valueOf(call == null || Math.random() >= call.a()).booleanValue();
    }

    public void c() {
        RcdTargets a2 = a();
        if (a2 != null) {
            for (String next : a2.a(1)) {
                try {
                    Class.forName(next, false, getClass().getClassLoader());
                    a(next, 1);
                } catch (ClassNotFoundException unused) {
                } catch (Throwable th) {
                    y8.a(this.f35575b, th);
                }
            }
            try {
                String packageName = this.f35575b.getPackageName();
                PackageInfo packageInfo = this.f35575b.getPackageManager().getPackageInfo(packageName, 15);
                if (packageInfo != null) {
                    a(a2, packageName, (T[]) packageInfo.activities);
                    a(a2, packageName, (T[]) packageInfo.receivers);
                    a(a2, packageName, (T[]) packageInfo.services);
                    a(a2, packageName, (T[]) packageInfo.providers);
                }
            } catch (Throwable th2) {
                y8.a(this.f35575b, th2);
            }
            this.f35577d.execute(this.f35583j);
        }
    }

    public void d() {
        HashMap hashMap;
        RcdTargets a2 = a();
        if (a2 != null) {
            synchronized (this.f35580g) {
                hashMap = new HashMap(this.f35580g);
            }
            String a3 = a2.a((Map<String, Integer>) hashMap);
            if (!a3.equals(this.f35582i)) {
                this.f35582i = a3;
                y8 y8Var = new y8(z8.f36995b);
                y8Var.f36954d = "RCD.results";
                y8Var.f36955e = a3;
                y8Var.a(this.f35575b);
            }
        }
    }

    public void a(Activity activity) {
        Window window;
        View decorView;
        if (!b()) {
            String name = activity.getClass().getName();
            Map<Activity, Integer> map = lb.f34876a;
            if (!name.startsWith("com.startapp.")) {
                List list = this.f35581h.get(name);
                if (list == null) {
                    list = new ArrayList(2);
                    this.f35581h.put(name, list);
                    this.f35576c.execute(new c(activity));
                }
                Iterator it2 = list.iterator();
                boolean z2 = false;
                while (it2.hasNext()) {
                    WeakReference weakReference = (WeakReference) it2.next();
                    if (weakReference.get() == null) {
                        it2.remove();
                    } else if (weakReference.get() == activity) {
                        z2 = true;
                    }
                }
                if (!z2 && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                    list.add(new WeakReference(activity));
                    this.f35576c.execute(new d(activity, decorView));
                }
            }
        }
    }

    public void b(Activity activity) {
        RcdTargets a2 = a();
        if (a2 != null) {
            try {
                if (a(a2, activity)) {
                    return;
                }
            } catch (Throwable th) {
                y8.a(this.f35575b, th);
            }
            try {
                a(a2, activity, 16, 32);
            } catch (Throwable th2) {
                y8.a(this.f35575b, th2);
            }
            for (String method : f35574a) {
                try {
                    Object invoke = activity.getClass().getMethod(method, new Class[0]).invoke(activity, new Object[0]);
                    if (invoke != null) {
                        Object invoke2 = invoke.getClass().getMethod("getFragments", new Class[0]).invoke(invoke, new Object[0]);
                        if (invoke2 instanceof Collection) {
                            for (Object next : (Collection) invoke2) {
                                if (next != null) {
                                    a(a2, next, 64, 128);
                                }
                            }
                        }
                    }
                } catch (NoSuchMethodException unused) {
                } catch (Throwable th3) {
                    y8.a(this.f35575b, th3);
                }
            }
            this.f35577d.execute(this.f35583j);
        }
    }

    public final <T extends ComponentInfo> void a(RcdTargets rcdTargets, String str, T[] tArr) {
        if (tArr != null) {
            for (T t2 : tArr) {
                if (t2 != null) {
                    String str2 = t2.name;
                    if (str2.startsWith(".")) {
                        a(rcdTargets, str + str2, 2);
                    } else {
                        a(rcdTargets, str2, 2);
                    }
                }
            }
        }
    }

    public void a(int i2) {
        try {
            if (!b()) {
                this.f35576c.execute(new e(Thread.currentThread().getStackTrace(), i2));
            }
        } catch (Throwable th) {
            y8.a(this.f35575b, th);
        }
    }

    public final void a(RcdTargets rcdTargets, View view) {
        if (view != null) {
            a(rcdTargets, view.getClass().getName(), 4);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(rcdTargets, viewGroup.getChildAt(i2));
                }
            }
        }
    }

    public final boolean a(RcdTargets rcdTargets, Activity activity) {
        Collection<String> a2 = rcdTargets.a(8);
        String name = activity.getClass().getName();
        if (!a2.contains(name)) {
            return false;
        }
        a(name, 8);
        return true;
    }

    public final void a(RcdTargets rcdTargets, Object obj, int i2, int i3) {
        Class cls = obj.getClass();
        while (cls != null && !a(cls.getName())) {
            for (Field field : cls.getDeclaredFields()) {
                if (i2 != 0) {
                    a(rcdTargets, field.getType().getName(), i2);
                }
                try {
                    field.setAccessible(true);
                    if (!(field.get(obj) == null || i3 == 0)) {
                        a(rcdTargets, field.getType().getName(), i3);
                    }
                } catch (Throwable unused) {
                }
            }
            cls = cls.getSuperclass();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0065 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.startapp.sdk.adsbase.remoteconfig.RcdTargets r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            boolean r0 = a((java.lang.String) r6)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.util.Map<android.app.Activity, java.lang.Integer> r0 = com.startapp.lb.f34876a
            java.lang.String r0 = "com.startapp."
            boolean r0 = r6.startsWith(r0)
            if (r0 == 0) goto L_0x0012
            return
        L_0x0012:
            java.util.Collection r5 = r5.a((int) r7)
            java.util.Iterator r5 = r5.iterator()
        L_0x001a:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0065
            java.lang.Object r0 = r5.next()
            java.lang.String r0 = (java.lang.String) r0
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x0062
            boolean r1 = r6.startsWith(r0)
            if (r1 == 0) goto L_0x0062
            int r1 = r0.length()
            r2 = 1
            int r1 = r1 - r2
            char r1 = r0.charAt(r1)
            r3 = 46
            if (r1 != r3) goto L_0x0044
            r4.a((java.lang.String) r0, (int) r7)
            goto L_0x0062
        L_0x0044:
            int r1 = r6.length()
            int r3 = r0.length()
            if (r1 <= r3) goto L_0x005e
            int r1 = r0.length()
            char r1 = r6.charAt(r1)
            r2 = 36
            if (r1 != r2) goto L_0x0062
            r4.a((java.lang.String) r0, (int) r7)
            goto L_0x0062
        L_0x005e:
            r4.a((java.lang.String) r0, (int) r7)
            goto L_0x0063
        L_0x0062:
            r2 = 0
        L_0x0063:
            if (r2 == 0) goto L_0x001a
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.oe.a(com.startapp.sdk.adsbase.remoteconfig.RcdTargets, java.lang.String, int):void");
    }

    public final void a(String str, int i2) {
        synchronized (this.f35580g) {
            Integer num = this.f35580g.get(str);
            if (num == null) {
                num = 0;
            }
            this.f35580g.put(str, Integer.valueOf(i2 | num.intValue()));
        }
    }

    public static boolean a(String str) {
        return str.startsWith("android") || str.startsWith("java.");
    }
}
