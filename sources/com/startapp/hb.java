package com.startapp;

import android.app.Activity;
import android.content.Context;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import java.util.Map;
import java.util.UUID;

public class hb {

    /* renamed from: a  reason: collision with root package name */
    public static final hb f34639a = new hb();

    /* renamed from: b  reason: collision with root package name */
    public String f34640b = "";

    /* renamed from: c  reason: collision with root package name */
    public long f34641c = 0;

    /* renamed from: d  reason: collision with root package name */
    public MetaDataRequest.RequestReason f34642d = MetaDataRequest.RequestReason.LAUNCH;

    public String a() {
        return this.f34640b;
    }

    public long b() {
        return this.f34641c;
    }

    public synchronized void a(Context context, MetaDataRequest.RequestReason requestReason) {
        this.f34640b = UUID.randomUUID().toString();
        this.f34641c = System.currentTimeMillis();
        this.f34642d = requestReason;
        Map<Activity, Integer> map = lb.f34876a;
        r7 r7Var = r7.f35760a;
        r7Var.f35761b.clear();
        r7Var.f35762c.clear();
        r7Var.f35763d.clear();
        MetaData.f36379h.a(context, new AdPreferences(), requestReason, false, (da) null, true);
    }
}
