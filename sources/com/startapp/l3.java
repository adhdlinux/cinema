package com.startapp;

import android.content.Context;
import com.startapp.ha;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;
import com.startapp.sdk.common.SDKException;
import com.startapp.sdk.components.ComponentLocator;

public class l3 extends GetAdRequest {
    public boolean S0;
    public int T0;

    public void a(eb ebVar) throws SDKException {
        super.a(ebVar);
        ebVar.a("fixedSize", (Object) Boolean.valueOf(this.S0), false, true);
        ebVar.a("bnrt", (Object) Integer.valueOf(this.T0), false, true);
    }

    public void f(Context context) {
        String str;
        ha r2 = ComponentLocator.a(context).r();
        AdPreferences.Placement placement = this.f36334h0;
        int i2 = this.T0;
        r2.getClass();
        if (placement == null) {
            str = null;
        } else {
            str = r2.f34636a.get(new ha.a(placement, i2));
        }
        this.f36348v0 = str;
    }
}
