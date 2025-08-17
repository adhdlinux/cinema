package com.applovin.impl.sdk;

import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.communicator.CommunicatorMessageImpl;
import com.applovin.impl.communicator.c;
import com.applovin.impl.mediation.a.a;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.network.h;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class i implements AppLovinCommunicatorPublisher, AppLovinCommunicatorSubscriber {

    /* renamed from: a  reason: collision with root package name */
    private final m f15480a;

    /* renamed from: b  reason: collision with root package name */
    private final AppLovinCommunicator f15481b;

    i(m mVar) {
        this.f15480a = mVar;
        AppLovinCommunicator instance = AppLovinCommunicator.getInstance(mVar.L());
        this.f15481b = instance;
        if (!mVar.e() && ((Boolean) mVar.a(b.eX)).booleanValue()) {
            instance.a(mVar);
            instance.subscribe((AppLovinCommunicatorSubscriber) this, c.f14158a);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.os.Bundle b(com.applovin.impl.mediation.a.a r4) {
        /*
            r3 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = r4.f()
            java.lang.String r2 = "id"
            r0.putString(r2, r1)
            java.lang.String r1 = "network_name"
            java.lang.String r2 = r4.L()
            r0.putString(r1, r2)
            java.lang.String r1 = "max_ad_unit_id"
            java.lang.String r2 = r4.getAdUnitId()
            r0.putString(r1, r2)
            java.lang.String r1 = "third_party_ad_placement_id"
            java.lang.String r2 = r4.l()
            r0.putString(r1, r2)
            com.applovin.mediation.MaxAdFormat r1 = r4.getFormat()
            java.lang.String r1 = r1.getLabel()
            java.lang.String r2 = "ad_format"
            r0.putString(r2, r1)
            java.lang.String r1 = r4.getCreativeId()
            boolean r1 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r1)
            if (r1 == 0) goto L_0x0049
            java.lang.String r1 = "creative_id"
            java.lang.String r2 = r4.getCreativeId()
            r0.putString(r1, r2)
        L_0x0049:
            java.lang.String r1 = r4.getDspName()
            boolean r1 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r1)
            if (r1 == 0) goto L_0x005c
            java.lang.String r1 = "dsp_name"
            java.lang.String r2 = r4.getDspName()
            r0.putString(r1, r2)
        L_0x005c:
            boolean r1 = r4.k()
            if (r1 == 0) goto L_0x006c
            java.lang.String r1 = "custom_js_network_name"
        L_0x0064:
            java.lang.String r2 = r4.getNetworkName()
            r0.putString(r1, r2)
            goto L_0x007b
        L_0x006c:
            java.lang.String r1 = "CUSTOM_NETWORK_SDK"
            java.lang.String r2 = r4.L()
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x007b
            java.lang.String r1 = "custom_sdk_network_name"
            goto L_0x0064
        L_0x007b:
            org.json.JSONObject r1 = r4.b()
            android.os.Bundle r1 = com.applovin.impl.sdk.utils.JsonUtils.toBundle((org.json.JSONObject) r1)
            r0.putAll(r1)
            boolean r1 = r4 instanceof com.applovin.impl.mediation.a.b
            if (r1 == 0) goto L_0x00be
            com.applovin.impl.mediation.a.b r4 = (com.applovin.impl.mediation.a.b) r4
            android.view.View r4 = r4.w()
            if (r4 == 0) goto L_0x00b7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.Class r2 = r4.getClass()
            java.lang.String r2 = r2.getName()
            r1.append(r2)
            r2 = 64
            r1.append(r2)
            int r4 = r4.hashCode()
            java.lang.String r4 = java.lang.Integer.toHexString(r4)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            goto L_0x00b9
        L_0x00b7:
            java.lang.String r4 = "N/A"
        L_0x00b9:
            java.lang.String r1 = "ad_view"
            r0.putString(r1, r4)
        L_0x00be:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.i.b(com.applovin.impl.mediation.a.a):android.os.Bundle");
    }

    public void a() {
        if (((Boolean) this.f15480a.a(b.eX)).booleanValue()) {
            a(new Bundle(), "privacy_setting_updated");
        }
    }

    public void a(Bundle bundle, String str) {
        if (((Boolean) this.f15480a.a(b.eX)).booleanValue() && !this.f15480a.e()) {
            this.f15481b.getMessagingService().publish(CommunicatorMessageImpl.create(bundle, str, this, this.f15480a.b(b.eW).contains(str)));
        }
    }

    public void a(a aVar) {
        if (((Boolean) this.f15480a.a(b.eX)).booleanValue() && this.f15481b.hasSubscriber("max_revenue_events")) {
            Bundle b2 = b(aVar);
            b2.putAll(JsonUtils.toBundle(aVar.c()));
            b2.putString("country_code", this.f15480a.s().getCountryCode());
            BundleUtils.putStringIfValid("user_segment", this.f15480a.q().getName(), b2);
            a(b2, "max_revenue_events");
        }
    }

    public void a(a aVar, String str) {
        if (((Boolean) this.f15480a.a(b.eX)).booleanValue() && this.f15481b.hasSubscriber("max_ad_events")) {
            Bundle b2 = b(aVar);
            b2.putString("type", str);
            if (v.a()) {
                v A = this.f15480a.A();
                A.b("CommunicatorService", "Sending \"max_ad_events\" message: " + b2);
            }
            a(b2, "max_ad_events");
        }
    }

    public void a(MaxAdapter.InitializationStatus initializationStatus, String str) {
        if (((Boolean) this.f15480a.a(b.eX)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("adapter_class", str);
            bundle.putInt("init_status", initializationStatus.getCode());
            a(bundle, "adapter_initialization_status");
        }
    }

    public void a(String str, String str2) {
        if (((Boolean) this.f15480a.a(b.eX)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("adapter_class", str2);
            bundle.putString("sdk_version", str);
            a(bundle, "network_sdk_version_updated");
        }
    }

    public void a(String str, String str2, int i2, Object obj, String str3, boolean z2) {
        if (((Boolean) this.f15480a.a(b.eX)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putString(ImagesContract.URL, str2);
            bundle.putInt("code", i2);
            bundle.putBundle("body", JsonUtils.toBundle(obj));
            bundle.putBoolean("success", z2);
            BundleUtils.putString("error_message", str3, bundle);
            a(bundle, "receive_http_response");
        }
    }

    public void a(String str, String str2, String str3) {
        if (((Boolean) this.f15480a.a(b.eX)).booleanValue()) {
            String maybeConvertToIndentedString = JsonUtils.maybeConvertToIndentedString(str3, 2);
            String maybeConvertToIndentedString2 = JsonUtils.maybeConvertToIndentedString(str, 2);
            Bundle bundle = new Bundle();
            bundle.putString("request_url", str2);
            bundle.putString("request_body", maybeConvertToIndentedString);
            bundle.putString("response", maybeConvertToIndentedString2);
            a(bundle, "responses");
        }
    }

    public void a(JSONObject jSONObject, boolean z2) {
        if (((Boolean) this.f15480a.a(b.eX)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f15480a.z());
            bundle.putString("applovin_random_token", this.f15480a.o());
            bundle.putString("compass_random_token", this.f15480a.n());
            bundle.putString("device_type", AppLovinSdkUtils.isTablet(this.f15480a.L()) ? "tablet" : "phone");
            bundle.putString("init_success", String.valueOf(z2));
            bundle.putParcelableArrayList("installed_mediation_adapters", JsonUtils.toBundle(com.applovin.impl.mediation.d.c.a(this.f15480a)));
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "communicator_settings", new JSONObject());
            Bundle bundle2 = (Bundle) bundle.clone();
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject2, "user_engagement_sdk_settings", new JSONObject());
            JsonUtils.putString(jSONObject3, "lsc", "Y29tLmFuZHJvaWQudmVuZGluZy5saWNlbnNpbmcuSUxpY2Vuc2luZ1NlcnZpY2U=");
            JsonUtils.putString(jSONObject3, "psp", "Y29tLmFuZHJvaWQudmVuZGluZw==");
            bundle2.putBundle("settings", JsonUtils.toBundle(jSONObject3));
            a(bundle2, "user_engagement_sdk_init");
            Bundle bundle3 = (Bundle) bundle.clone();
            bundle3.putString("user_id", this.f15480a.m());
            bundle3.putBundle("settings", JsonUtils.toBundle(JsonUtils.getJSONObject(jSONObject2, "safedk_settings", new JSONObject())));
            if (v.a()) {
                v A = this.f15480a.A();
                A.b("CommunicatorService", "Sending \"safedk_init\" message: " + bundle);
            }
            a(bundle3, "safedk_init");
            Bundle bundle4 = (Bundle) bundle.clone();
            bundle4.putBundle("settings", JsonUtils.toBundle(JsonUtils.getJSONObject(jSONObject2, "adjust_settings", new JSONObject())));
            a(bundle4, "adjust_init");
            Bundle bundle5 = (Bundle) bundle.clone();
            bundle5.putBundle("settings", JsonUtils.toBundle(JsonUtils.getJSONObject(jSONObject2, "discovery_settings", new JSONObject())));
            a(bundle5, "discovery_init");
        }
    }

    public boolean a(String str) {
        return c.f14158a.contains(str);
    }

    public String getCommunicatorId() {
        return "applovin_sdk";
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        int i2;
        Map<String, Object> map;
        if (((Boolean) this.f15480a.a(b.eX)).booleanValue()) {
            if ("send_http_request".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                Bundle messageData = appLovinCommunicatorMessage.getMessageData();
                Map<String, String> stringMap = BundleUtils.toStringMap(messageData.getBundle("query_params"));
                Map<String, Object> map2 = BundleUtils.toMap(messageData.getBundle("post_body"));
                Map<String, String> stringMap2 = BundleUtils.toStringMap(messageData.getBundle("headers"));
                String string = messageData.getString("id", "");
                if (!map2.containsKey(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY)) {
                    map2.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f15480a.z());
                }
                this.f15480a.U().a(new h.a().c(messageData.getString(ImagesContract.URL)).d(messageData.getString("backup_url")).a(stringMap).c(map2).b(stringMap2).a(((Boolean) this.f15480a.a(b.ep)).booleanValue()).a(string).a());
            } else if ("send_http_request_v2".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                Bundle messageData2 = appLovinCommunicatorMessage.getMessageData();
                String string2 = messageData2.getString("http_method", "POST");
                long millis = messageData2.containsKey("timeout_sec") ? TimeUnit.SECONDS.toMillis(messageData2.getLong("timeout_sec")) : ((Long) this.f15480a.a(b.dh)).longValue();
                int i3 = messageData2.getInt("retry_count", ((Integer) this.f15480a.a(b.di)).intValue());
                long millis2 = messageData2.containsKey("retry_delay_sec") ? TimeUnit.SECONDS.toMillis(messageData2.getLong("retry_delay_sec")) : ((Long) this.f15480a.a(b.dj)).longValue();
                Map<String, String> stringMap3 = BundleUtils.toStringMap(messageData2.getBundle("query_params"));
                long j2 = millis2;
                if ("GET".equalsIgnoreCase(string2)) {
                    if (messageData2.getBoolean("include_data_collector_info", true)) {
                        stringMap3.putAll(BundleUtils.toStringMap(CollectionUtils.toBundle(this.f15480a.V().a((Map<String, String>) null, false, false))));
                    }
                    i2 = i3;
                    map = null;
                } else {
                    map = BundleUtils.toMap(messageData2.getBundle("post_body"));
                    if (messageData2.getBoolean("include_data_collector_info", true)) {
                        Map<String, Object> h2 = this.f15480a.V().h();
                        Map<String, Object> d2 = this.f15480a.V().d();
                        if (!d2.containsKey("idfv") || !d2.containsKey("idfv_scope")) {
                            i2 = i3;
                        } else {
                            i2 = i3;
                            int intValue = ((Integer) d2.get("idfv_scope")).intValue();
                            d2.remove("idfv");
                            d2.remove("idfv_scope");
                            h2.put("idfv", (String) d2.get("idfv"));
                            h2.put("idfv_scope", Integer.valueOf(intValue));
                        }
                        h2.put("server_installed_at", this.f15480a.a(b.af));
                        h2.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f15480a.z());
                        map.put("app", h2);
                        map.put("device", d2);
                    } else {
                        i2 = i3;
                    }
                }
                this.f15480a.S().a((com.applovin.impl.sdk.e.a) new com.applovin.impl.sdk.network.a(appLovinCommunicatorMessage.getPublisherId(), com.applovin.impl.sdk.network.c.a(this.f15480a).a(messageData2.getString(ImagesContract.URL)).c(messageData2.getString("backup_url")).a(stringMap3).b(string2).b(BundleUtils.toStringMap(messageData2.getBundle("headers"))).a(map != null ? new JSONObject(map) : null).b((int) millis).a(i2).c((int) j2).a(new JSONObject()).c(messageData2.getBoolean("is_encoding_enabled", false)).a(), this.f15480a), o.a.MAIN);
            } else if ("set_ad_request_query_params".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                this.f15480a.u().addCustomQueryParams(Utils.stringifyObjectMap(BundleUtils.toMap(appLovinCommunicatorMessage.getMessageData())));
            } else if ("set_ad_request_post_body".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                this.f15480a.u().setCustomPostBody(BundleUtils.toJSONObject(appLovinCommunicatorMessage.getMessageData()));
            } else if ("set_mediate_request_post_body_data".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                this.f15480a.E().setCustomPostBodyData(BundleUtils.toJSONObject(appLovinCommunicatorMessage.getMessageData()));
            }
        }
    }
}
