package com.applovin.impl.mediation.debugger.ui.testmode;

import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class b implements AppLovinCommunicatorSubscriber {

    /* renamed from: a  reason: collision with root package name */
    private final m f14789a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14790b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14791c;

    /* renamed from: d  reason: collision with root package name */
    private String f14792d;

    public b(m mVar) {
        this.f14789a = mVar;
        d dVar = d.B;
        this.f14792d = (String) mVar.b(dVar, null);
        mVar.b(dVar);
        if (StringUtils.isValidString(this.f14792d)) {
            this.f14791c = true;
        }
        d dVar2 = d.C;
        this.f14790b = ((Boolean) mVar.b(dVar2, Boolean.FALSE)).booleanValue();
        mVar.b(dVar2);
        AppLovinCommunicator.getInstance(mVar.L()).subscribe((AppLovinCommunicatorSubscriber) this, "test_mode_settings");
    }

    public void a(String str) {
        this.f14792d = str;
    }

    public void a(JSONObject jSONObject) {
        if (!this.f14790b) {
            this.f14790b = JsonUtils.containsCaseInsensitiveString(this.f14789a.V().k().f15744b, JsonUtils.getJSONArray(jSONObject, "test_mode_idfas", new JSONArray())) || this.f14789a.V().g() || AppLovinSdkUtils.isEmulator();
        }
    }

    public void a(boolean z2) {
        this.f14791c = z2;
    }

    public boolean a() {
        return this.f14790b;
    }

    public void b(String str) {
        this.f14789a.a(d.B, str);
    }

    public boolean b() {
        return this.f14791c;
    }

    public String c() {
        return this.f14792d;
    }

    public void d() {
        this.f14789a.a(d.C, Boolean.TRUE);
    }

    public String getCommunicatorId() {
        return b.class.getSimpleName();
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("test_mode_settings".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            String string = BundleUtils.getString("force_ad_network", messageData);
            if (StringUtils.isValidString(string)) {
                this.f14791c = true;
                this.f14792d = string;
            }
            String string2 = BundleUtils.getString("test_mode_network_next_session", messageData);
            if (StringUtils.isValidString(string2)) {
                d();
                b(string2);
            }
        }
    }
}
