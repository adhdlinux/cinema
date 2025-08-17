package com.iab.omid.library.vungle.internal;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import java.lang.ref.WeakReference;

public class j {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    private static j f31727d = new j();

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Context> f31728a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f31729b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f31730c = false;

    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            j jVar;
            boolean d2;
            boolean z2;
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                jVar = j.this;
                d2 = jVar.f31730c;
                z2 = true;
            } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                jVar = j.this;
                d2 = jVar.f31730c;
                z2 = false;
            } else {
                return;
            }
            jVar.c(z2, d2);
            boolean unused = j.this.f31729b = z2;
        }
    }

    public static j f() {
        return f31727d;
    }

    public void a() {
        Context context = this.f31728a.get();
        if (context != null) {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            boolean a2 = Build.VERSION.SDK_INT >= 22 ? keyguardManager.isDeviceLocked() : keyguardManager.inKeyguardRestrictedInputMode();
            c(this.f31729b, a2);
            this.f31730c = a2;
        }
    }

    public void b(Context context) {
        if (context != null) {
            this.f31728a = new WeakReference<>(context);
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            context.registerReceiver(new a(), intentFilter);
        }
    }

    public void c(boolean z2, boolean z3) {
        if ((z3 || z2) != (this.f31730c || this.f31729b)) {
            for (com.iab.omid.library.vungle.adsession.a m2 : c.e().c()) {
                m2.m().l(z3 || z2);
            }
        }
    }
}
