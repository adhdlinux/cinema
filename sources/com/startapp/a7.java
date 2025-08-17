package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.common.SDKException;

public class a7 extends q6 {

    /* renamed from: h0  reason: collision with root package name */
    public z9 f34189h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f34190i0;

    public a7(Context context) {
        super(1);
        this.f34189h0 = y9.a(context);
        this.f34190i0 = hc.a(context);
    }

    public void a(eb ebVar) throws SDKException {
        super.a(ebVar);
        ebVar.a("placement", (Object) "INAPP_DOWNLOAD", true, true);
        z9 z9Var = this.f34189h0;
        if (z9Var != null) {
            ebVar.a("install_referrer", (Object) z9Var.f37010a.getString("install_referrer"), true, true);
            ebVar.a("referrer_click_timestamp_seconds", (Object) Long.valueOf(this.f34189h0.f37010a.getLong("referrer_click_timestamp_seconds")), true, true);
            ebVar.a("install_begin_timestamp_seconds", (Object) Long.valueOf(this.f34189h0.f37010a.getLong("install_begin_timestamp_seconds")), true, true);
        }
        ebVar.a("apkSig", (Object) this.f34190i0, true, true);
        long j2 = SimpleTokenUtils.f36203c;
        if (j2 != 0) {
            ebVar.a("firstInstalledAppTS", (Object) Long.valueOf(j2), false, true);
        }
    }
}
