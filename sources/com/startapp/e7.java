package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;

public final class e7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34449a;

    public e7(Context context) {
        this.f34449a = context;
    }

    public void run() {
        boolean z2;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.c.f36252a;
        Context context = this.f34449a;
        if (startAppSDKInternal.f36222e) {
            if (startAppSDKInternal.f36235r || !CacheMetaData.f36308a.a().f()) {
                d8 d8Var = d8.f34354a;
                d8Var.f34357d = true;
                ComponentLocator.a(context).h().execute(new k8(context, new z7(d8Var)));
            } else if (startAppSDKInternal.f36223f) {
                d8 d8Var2 = d8.f34354a;
                d8Var2.getClass();
                Context b2 = ia.b(context);
                d8Var2.f34361h = b2;
                if (d8Var2.f34357d || !CacheMetaData.f36308a.a().f()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    d8Var2.f34358e = true;
                    ComponentLocator.a(b2).h().execute(new l8(b2, new y7(d8Var2, b2)));
                }
            }
            startAppSDKInternal.e(context);
            d8 d8Var3 = d8.f34354a;
            d8Var3.getClass();
            a8 a8Var = new a8(d8Var3, context, ComponentLocator.a(context).d());
            synchronized (MetaData.f36372a) {
                MetaData.f36379h.a((da) a8Var);
            }
        }
    }
}
