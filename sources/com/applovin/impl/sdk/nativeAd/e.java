package com.applovin.impl.sdk.nativeAd;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.e.a;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.e.r;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.applovin.impl.sdk.nativeAd.a;
import com.applovin.impl.sdk.network.i;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class e extends a implements a.C0021a, AppLovinAdLoadListener {

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f15579a;

    /* renamed from: c  reason: collision with root package name */
    private final JSONObject f15580c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final AppLovinNativeAdLoadListener f15581d;

    /* renamed from: e  reason: collision with root package name */
    private String f15582e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f15583f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f15584g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f15585h = "";

    /* renamed from: i  reason: collision with root package name */
    private Uri f15586i = null;

    /* renamed from: j  reason: collision with root package name */
    private Uri f15587j = null;

    /* renamed from: k  reason: collision with root package name */
    private Uri f15588k = null;

    /* renamed from: l  reason: collision with root package name */
    private Uri f15589l = null;

    /* renamed from: m  reason: collision with root package name */
    private com.applovin.impl.a.a f15590m;

    /* renamed from: n  reason: collision with root package name */
    private Uri f15591n = null;

    /* renamed from: o  reason: collision with root package name */
    private Uri f15592o = null;

    /* renamed from: p  reason: collision with root package name */
    private final List<String> f15593p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private String f15594q;

    /* renamed from: r  reason: collision with root package name */
    private final List<i> f15595r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    private final List<i> f15596s = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    private final List<i> f15597t = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    private final List<i> f15598u = new ArrayList();

    public e(JSONObject jSONObject, JSONObject jSONObject2, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, m mVar) {
        super("TaskRenderNativeAd", mVar);
        this.f15579a = jSONObject;
        this.f15580c = jSONObject2;
        this.f15581d = appLovinNativeAdLoadListener;
    }

    private void a() {
        AppLovinNativeAdImpl build = new AppLovinNativeAdImpl.Builder(JsonUtils.shallowCopy(this.f15579a), JsonUtils.shallowCopy(this.f15580c), this.f15333b).setTitle(this.f15582e).setAdvertiser(this.f15583f).setBody(this.f15584g).setCallToAction(this.f15585h).setIconUri(this.f15586i).setMainImageUri(this.f15587j).setPrivacyIconUri(this.f15588k).setVastAd(this.f15590m).setPrivacyDestinationUri(this.f15589l).setClickDestinationUri(this.f15591n).setClickDestinationBackupUri(this.f15592o).setClickTrackingUrls(this.f15593p).setJsTracker(this.f15594q).setImpressionRequests(this.f15595r).setViewableMRC50Requests(this.f15596s).setViewableMRC100Requests(this.f15597t).setViewableVideo50Requests(this.f15598u).build();
        build.getAdEventTracker().b();
        if (v.a()) {
            a("Starting cache task for type: " + build.getType() + "...");
        }
        this.f15333b.S().a((com.applovin.impl.sdk.e.a) new a(build, this.f15333b, this), o.a.MAIN);
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            String string = JsonUtils.getString(jSONObject, ImagesContract.URL, (String) null);
            if (StringUtils.isValidString(string)) {
                this.f15591n = Uri.parse(string);
                if (v.a()) {
                    a("Processed click destination URL: " + this.f15591n);
                }
            }
            String string2 = JsonUtils.getString(jSONObject, "fallback", (String) null);
            if (StringUtils.isValidString(string2)) {
                this.f15592o = Uri.parse(string2);
                if (v.a()) {
                    a("Processed click destination backup URL: " + this.f15592o);
                }
            }
            JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "clicktrackers", (JSONArray) null);
            if (jSONArray != null) {
                try {
                    this.f15593p.addAll(JsonUtils.toList(jSONArray));
                    if (v.a()) {
                        a("Processed click tracking URLs: " + this.f15593p);
                    }
                } catch (Throwable th) {
                    if (v.a()) {
                        a("Failed to render click tracking URLs", th);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        this.f15581d.onNativeAdLoadFailed(-6);
    }

    private void b(final AppLovinNativeAdImpl appLovinNativeAdImpl) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (v.a()) {
                    e.this.a("Preparing native ad view components...");
                }
                try {
                    appLovinNativeAdImpl.setUpNativeAdViewComponents();
                    if (v.a()) {
                        e.this.a("Successfully prepared native ad view components");
                    }
                    appLovinNativeAdImpl.getAdEventTracker().c();
                    e.this.f15581d.onNativeAdLoaded(appLovinNativeAdImpl);
                } catch (Throwable th) {
                    if (v.a()) {
                        e.this.a("Failed to prepare native ad view components", th);
                    }
                    e.this.b();
                }
            }
        });
    }

    public void a(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        if (v.a()) {
            a("Successfully cached and loaded ad");
        }
        b(appLovinNativeAdImpl);
    }

    public void adReceived(AppLovinAd appLovinAd) {
        if (v.a()) {
            a("VAST ad rendered successfully");
        }
        this.f15590m = (com.applovin.impl.a.a) appLovinAd;
        a();
    }

    public void failedToReceiveAd(int i2) {
        if (v.a()) {
            d("VAST ad failed to render");
        }
        a();
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [org.json.JSONObject, java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v16 */
    public void run() {
        StringBuilder sb;
        String str;
        String str2;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        String str3;
        String sb5;
        String str4;
        Uri uri;
        ? r2 = 0;
        String string = JsonUtils.getString(this.f15579a, "privacy_icon_url", (String) null);
        if (URLUtil.isValidUrl(string)) {
            this.f15588k = Uri.parse(string);
        }
        String string2 = JsonUtils.getString(this.f15579a, "privacy_url", (String) null);
        if (!URLUtil.isValidUrl(string2)) {
            string2 = "https://www.applovin.com/privacy/";
        }
        this.f15589l = Uri.parse(string2);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f15579a, "ortb_response", (JSONObject) null);
        if (jSONObject == null || jSONObject.length() == 0) {
            if (v.a()) {
                d("No oRtb response provided: " + this.f15579a);
            }
            b();
            return;
        }
        String string3 = JsonUtils.getString(jSONObject, MediationMetaData.KEY_VERSION, (String) null);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, AppMeasurementSdk.ConditionalUserProperty.VALUE, (JSONObject) null);
        if (v.a()) {
            a("Rendering native ad for oRTB version: " + string3);
        }
        JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject2, "native", jSONObject2);
        a(JsonUtils.getJSONObject(jSONObject3, "link", (JSONObject) null));
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject3, "assets", (JSONArray) null);
        if (jSONArray == null || jSONArray.length() == 0) {
            if (v.a()) {
                d("Unable to retrieve assets - failing ad load: " + this.f15579a);
            }
            b();
            return;
        }
        String str5 = "";
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            JSONObject jSONObject4 = JsonUtils.getJSONObject(jSONArray, i2, (JSONObject) r2);
            if (jSONObject4.has("title")) {
                this.f15582e = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject4, "title", (JSONObject) r2), "text", r2);
                if (v.a()) {
                    a("Processed title: " + this.f15582e);
                }
            } else if (jSONObject4.has("link")) {
                a(JsonUtils.getJSONObject(jSONObject4, "link", (JSONObject) r2));
            } else {
                if (jSONObject4.has("img")) {
                    int i3 = JsonUtils.getInt(jSONObject4, "id", -1);
                    JSONObject jSONObject5 = JsonUtils.getJSONObject(jSONObject4, "img", (JSONObject) r2);
                    int i4 = JsonUtils.getInt(jSONObject5, "type", -1);
                    String string4 = JsonUtils.getString(jSONObject5, ImagesContract.URL, r2);
                    if (i4 == 1 || 3 == i3) {
                        this.f15586i = Uri.parse(string4);
                        if (v.a()) {
                            sb2 = new StringBuilder();
                            sb2.append("Processed icon URL: ");
                            uri = this.f15586i;
                        }
                    } else if (i4 == 3 || 2 == i3) {
                        this.f15587j = Uri.parse(string4);
                        if (v.a()) {
                            sb2 = new StringBuilder();
                            sb2.append("Processed main image URL: ");
                            uri = this.f15587j;
                        }
                    } else {
                        if (v.a()) {
                            c("Unrecognized image: " + jSONObject4);
                        }
                        int i5 = JsonUtils.getInt(jSONObject5, "w", -1);
                        int i6 = JsonUtils.getInt(jSONObject5, "h", -1);
                        if (i5 > 0 && i6 > 0) {
                            int i7 = (((double) (((float) i5) / ((float) i6))) > 1.0d ? 1 : (((double) (((float) i5) / ((float) i6))) == 1.0d ? 0 : -1));
                            boolean a2 = v.a();
                            if (i7 > 0) {
                                if (a2) {
                                    a("Inferring main image from " + i5 + "x" + i6 + "...");
                                }
                                this.f15587j = Uri.parse(string4);
                            } else {
                                if (a2) {
                                    a("Inferring icon image from " + i5 + "x" + i6 + "...");
                                }
                                this.f15586i = Uri.parse(string4);
                            }
                        } else if (v.a()) {
                            sb5 = "Skipping...";
                        }
                    }
                    sb2.append(uri);
                    str4 = sb2.toString();
                    a(str4);
                } else {
                    if (jSONObject4.has(MimeTypes.BASE_TYPE_VIDEO)) {
                        str5 = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject4, MimeTypes.BASE_TYPE_VIDEO, (JSONObject) null), "vasttag", (String) null);
                        if (StringUtils.isValidString(str5)) {
                            if (v.a()) {
                                str4 = "Processed VAST video";
                                a(str4);
                            }
                        } else if (v.a()) {
                            sb4 = new StringBuilder();
                            str3 = "Ignoring invalid \"vasttag\" for video: ";
                        }
                    } else if (jSONObject4.has("data")) {
                        int i8 = JsonUtils.getInt(jSONObject4, "id", -1);
                        JSONObject jSONObject6 = JsonUtils.getJSONObject(jSONObject4, "data", (JSONObject) null);
                        int i9 = JsonUtils.getInt(jSONObject6, "type", -1);
                        String string5 = JsonUtils.getString(jSONObject6, AppMeasurementSdk.ConditionalUserProperty.VALUE, (String) null);
                        if (i9 == 1 || i8 == 8) {
                            this.f15583f = string5;
                            if (v.a()) {
                                sb3 = new StringBuilder();
                                sb3.append("Processed advertiser: ");
                                str2 = this.f15583f;
                            }
                        } else if (i9 == 2 || i8 == 4) {
                            this.f15584g = string5;
                            if (v.a()) {
                                sb3 = new StringBuilder();
                                sb3.append("Processed body: ");
                                str2 = this.f15584g;
                            }
                        } else if (i9 == 12 || i8 == 5) {
                            this.f15585h = string5;
                            if (v.a()) {
                                sb3 = new StringBuilder();
                                sb3.append("Processed cta: ");
                                str2 = this.f15585h;
                            }
                        } else if (v.a()) {
                            sb4 = new StringBuilder();
                            str3 = "Skipping unsupported data: ";
                        }
                        sb2.append(str2);
                        str4 = sb2.toString();
                        a(str4);
                    } else if (v.a()) {
                        d("Unsupported asset object: " + jSONObject4);
                    }
                    sb4.append(str3);
                    sb4.append(jSONObject4);
                    sb5 = sb4.toString();
                }
                c(sb5);
            }
            i2++;
            r2 = 0;
        }
        String string6 = JsonUtils.getString(jSONObject3, "jstracker", (String) null);
        if (StringUtils.isValidString(string6)) {
            this.f15594q = string6;
            a("Processed jstracker: " + string6);
        }
        Object obj = null;
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject3, "imptrackers", (JSONArray) null);
        if (jSONArray2 != null) {
            int i10 = 0;
            while (i10 < jSONArray2.length()) {
                Object objectAtIndex = JsonUtils.getObjectAtIndex(jSONArray2, i10, obj);
                if (objectAtIndex instanceof String) {
                    String str6 = (String) objectAtIndex;
                    if (!TextUtils.isEmpty(str6)) {
                        this.f15595r.add(new i.a(this.f15333b).a(str6).d(false).c(false).a());
                        if (v.a()) {
                            a("Processed imptracker URL: " + str6);
                        }
                    }
                }
                i10++;
                obj = null;
            }
        }
        JSONArray jSONArray3 = JsonUtils.getJSONArray(jSONObject3, "eventtrackers", (JSONArray) null);
        if (jSONArray3 != null) {
            for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                JSONObject jSONObject7 = JsonUtils.getJSONObject(jSONArray3, i11, (JSONObject) null);
                int i12 = JsonUtils.getInt(jSONObject7, "event", -1);
                int i13 = JsonUtils.getInt(jSONObject7, "method", -1);
                String string7 = JsonUtils.getString(jSONObject7, ImagesContract.URL, (String) null);
                if (!TextUtils.isEmpty(string7)) {
                    if (i13 == 1 || i13 == 2) {
                        i b2 = new i.a(this.f15333b).a(string7).d(false).c(false).g(i13 == 2).a();
                        if (i12 == 1) {
                            this.f15595r.add(b2);
                            if (v.a()) {
                                a("Processed impression URL: " + string7);
                            }
                        } else {
                            if (i12 == 2) {
                                this.f15596s.add(b2);
                                if (v.a()) {
                                    sb = new StringBuilder();
                                    str = "Processed viewable MRC50 URL: ";
                                }
                            } else if (i12 == 3) {
                                this.f15597t.add(b2);
                                if (v.a()) {
                                    sb = new StringBuilder();
                                    str = "Processed viewable MRC100 URL: ";
                                }
                            } else {
                                if (i12 == 4) {
                                    this.f15598u.add(b2);
                                    if (v.a()) {
                                        a("Processed viewable video 50 URL: " + string7);
                                    }
                                } else if (v.a()) {
                                    d("Unsupported event tracker: " + jSONObject7);
                                }
                            }
                            sb.append(str);
                            sb.append(string7);
                            a(sb.toString());
                        }
                    } else if (v.a()) {
                        d("Unsupported method for event tracker: " + jSONObject7);
                    }
                }
            }
        }
        if (StringUtils.isValidString(str5)) {
            if (v.a()) {
                a("Processing VAST video...");
            }
            this.f15333b.S().a((com.applovin.impl.sdk.e.a) r.a(str5, JsonUtils.shallowCopy(this.f15579a), JsonUtils.shallowCopy(this.f15580c), b.UNKNOWN, this, this.f15333b));
            return;
        }
        a();
    }
}
