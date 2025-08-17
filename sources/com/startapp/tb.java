package com.startapp;

import android.content.Context;
import android.os.Bundle;
import com.startapp.be;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;

public class tb extends be {

    public class a implements xb {
        public a() {
        }

        public void a(Object obj) {
            tb.this.callback.a(tb.this, false);
        }
    }

    public tb(Context context, be.a aVar, Bundle bundle) {
        super(context, aVar, bundle);
    }

    public void run() {
        try {
            MetaData.c(this.context);
            MetaData.f36379h.f36382k = true;
            if (MetaData.f36379h.R()) {
                ComponentLocator.a(this.context).t().b();
                StartAppSDKInternal.a(this.context, true, new a());
                return;
            }
            this.callback.a(this, false);
        } catch (Throwable th) {
            y8.a(this.context, th);
        }
    }
}
