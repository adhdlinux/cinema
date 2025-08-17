package com.startapp;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.view.WindowManager;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static q f35531a = new q();

    public static void a(Context context) {
        q qVar = f35531a;
        Context applicationContext = context.getApplicationContext();
        p.a((Object) applicationContext, "Application Context cannot be null");
        if (!qVar.f35624a) {
            qVar.f35624a = true;
            m a2 = m.a();
            a2.f34888d.getClass();
            b bVar = new b();
            f fVar = a2.f34887c;
            Handler handler = new Handler();
            fVar.getClass();
            a2.f34889e = new e(handler, applicationContext, bVar, a2);
            h hVar = h.f34604a;
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(hVar);
            }
            WindowManager windowManager = fg.f34542a;
            fg.f34544c = applicationContext.getResources().getDisplayMetrics().density;
            fg.f34542a = (WindowManager) applicationContext.getSystemService("window");
            j.f34712a.f34713b = applicationContext.getApplicationContext();
        }
    }
}
