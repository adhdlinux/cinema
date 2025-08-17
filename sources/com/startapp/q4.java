package com.startapp;

import android.view.View;
import com.startapp.sdk.ads.nativead.NativeAdDetails;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;

public class q4 implements View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NativeAdDetails f35646a;

    public q4(NativeAdDetails nativeAdDetails) {
        this.f35646a = nativeAdDetails;
    }

    public void onViewAttachedToWindow(View view) {
        View view2;
        NativeAdDetails nativeAdDetails = this.f35646a;
        nativeAdDetails.getClass();
        if (MetaData.f36379h.P() && (view2 = nativeAdDetails.f36003h.get()) != null) {
            me meVar = new me(view2.getContext(), nativeAdDetails.f35996a.b(), false);
            nativeAdDetails.f36006k = meVar;
            if (meVar.c()) {
                nativeAdDetails.f36006k.a(view2);
                nativeAdDetails.f36006k.e();
                nativeAdDetails.f36006k.d();
                nativeAdDetails.f36006k.b();
            }
        }
        this.f35646a.a();
    }

    public void onViewDetachedFromWindow(View view) {
        NativeAdDetails nativeAdDetails = this.f35646a;
        ob obVar = nativeAdDetails.f36002g;
        if (obVar != null) {
            obVar.a();
            nativeAdDetails.f36002g = null;
        }
        NativeAdDetails nativeAdDetails2 = this.f35646a;
        me meVar = nativeAdDetails2.f36006k;
        if (meVar != null) {
            meVar.a();
            nativeAdDetails2.f36006k = null;
        }
        view.removeOnAttachStateChangeListener(this.f35646a.f36004i);
    }
}
