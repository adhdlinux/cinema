package com.startapp;

import android.content.Context;
import android.os.Bundle;
import com.startapp.be;
import com.startapp.ic;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.components.ComponentLocator;

public class ea extends be {
    public static final String LOG_TAG = "ea";

    public ea(Context context, be.a aVar, Bundle bundle) {
        super(context, aVar, bundle);
    }

    private void sendMetaDataRequest(Context context) {
        AdPreferences adPreferences = new AdPreferences();
        a aVar = new a(context, adPreferences, MetaDataRequest.RequestReason.PERIODIC, context, adPreferences);
        ComponentLocator a2 = ComponentLocator.a(context);
        a2.o().execute(new aa(aVar, a2));
    }

    public void run() {
        try {
            ComponentLocator.a(this.context).t().b();
            MetaData.c(this.context);
            if (MetaData.f36379h.S()) {
                sendMetaDataRequest(this.context);
            } else {
                this.callback.a(this, false);
            }
        } catch (Throwable th) {
            y8.a(this.context, th);
        }
    }

    public class a extends ba {

        /* renamed from: l  reason: collision with root package name */
        public MetaData f34480l;

        /* renamed from: m  reason: collision with root package name */
        public final /* synthetic */ Context f34481m;

        /* renamed from: n  reason: collision with root package name */
        public final /* synthetic */ AdPreferences f34482n;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context, AdPreferences adPreferences, MetaDataRequest.RequestReason requestReason, Context context2, AdPreferences adPreferences2) {
            super(context, adPreferences, requestReason);
            this.f34481m = context2;
            this.f34482n = adPreferences2;
        }

        public Boolean a() {
            try {
                SimpleTokenUtils.e(this.f34481m);
                MetaDataRequest metaDataRequest = new MetaDataRequest(this.f34481m, ComponentLocator.a(this.f34481m).d(), MetaDataRequest.RequestReason.PERIODIC);
                metaDataRequest.a(this.f34481m, this.f34482n);
                ic.a a2 = ba.a(this.f34481m, metaDataRequest);
                if (a2 != null) {
                    this.f34480l = (MetaData) lb.a(a2.f34700a, MetaData.class);
                }
                return Boolean.TRUE;
            } catch (Throwable th) {
                y8.a(this.f34481m, th);
                return Boolean.FALSE;
            }
        }

        public void a(Boolean bool) {
            MetaData metaData;
            Context context;
            try {
                if (!(!bool.booleanValue() || (metaData = this.f34480l) == null || (context = this.f34481m) == null)) {
                    MetaData.a(context, metaData, MetaDataRequest.RequestReason.PERIODIC, this.f34259k);
                }
                ea.this.callback.a(ea.this, false);
            } catch (Throwable th) {
                y8.a(this.f34481m, th);
            }
        }
    }
}
