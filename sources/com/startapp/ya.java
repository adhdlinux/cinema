package com.startapp;

import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.x6;

public class ya implements da {

    /* renamed from: a  reason: collision with root package name */
    public final x6 f36965a;

    public ya(x6 x6Var) {
        this.f36965a = x6Var;
        MetaData.r().a((da) this);
    }

    public void a(MetaDataRequest.RequestReason requestReason) {
        MetaData.f36379h.a((da) this);
    }

    public void a(MetaDataRequest.RequestReason requestReason, boolean z2) {
        if (z2) {
            boolean z3 = Math.random() < MetaData.f36379h.p();
            x6.a a2 = this.f36965a.edit();
            a2.a("0115fe86041c10c0", Boolean.valueOf(z3));
            a2.f36915a.putBoolean("0115fe86041c10c0", z3);
            a2.apply();
        }
        MetaData.f36379h.a((da) this);
    }
}
