package com.startapp;

import android.content.Context;
import android.os.Bundle;
import com.startapp.be;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;

public class sb extends be {

    public class a implements xb {
        public a() {
        }

        public void a(Object obj) {
            sb.this.callback.a(sb.this, false);
        }
    }

    public sb(Context context, be.a aVar, Bundle bundle) {
        super(context, aVar, bundle);
    }

    public void run() {
        try {
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
