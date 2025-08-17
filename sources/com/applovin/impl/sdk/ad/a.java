package com.applovin.impl.sdk.ad;

import android.net.Uri;
import com.applovin.impl.adview.i;
import com.applovin.impl.sdk.a.c;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.unity3d.services.core.device.MimeTypes;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends e {

    /* renamed from: a  reason: collision with root package name */
    private final String f15078a = b();

    /* renamed from: b  reason: collision with root package name */
    private final String f15079b = i();

    /* renamed from: c  reason: collision with root package name */
    private final String f15080c = aM();

    /* renamed from: d  reason: collision with root package name */
    private final c f15081d = new c(this);

    public a(JSONObject jSONObject, JSONObject jSONObject2, b bVar, m mVar) {
        super(jSONObject, jSONObject2, bVar, mVar);
    }

    private String aM() {
        return getStringFromAdObject("stream_url", "");
    }

    public void a() {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html", this.f15078a);
            JsonUtils.putString(this.adObject, "stream_url", this.f15080c);
        }
    }

    public void a(Uri uri) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, MimeTypes.BASE_TYPE_VIDEO, uri.toString());
        }
    }

    public void a(String str) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html", str);
        }
    }

    public String b() {
        String string;
        synchronized (this.adObjectLock) {
            string = JsonUtils.getString(this.adObject, "html", "");
        }
        return string;
    }

    /* renamed from: c */
    public c o() {
        return this.f15081d;
    }

    public String d() {
        return this.f15079b;
    }

    public String e() {
        return this.f15080c;
    }

    public boolean f() {
        return this.adObject.has("stream_url");
    }

    public void g() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("stream_url");
        }
    }

    public JSONObject getOriginalFullResponse() {
        JSONObject deepCopy;
        synchronized (this.fullResponseLock) {
            deepCopy = JsonUtils.deepCopy(this.fullResponse);
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(deepCopy, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, 0, new JSONObject());
            JsonUtils.putString(jSONObject, "html", this.f15078a);
            JsonUtils.putString(jSONObject, MimeTypes.BASE_TYPE_VIDEO, this.f15079b);
            JsonUtils.putString(jSONObject, "stream_url", this.f15080c);
        }
        return deepCopy;
    }

    public Uri h() {
        String aM = aM();
        if (StringUtils.isValidString(aM)) {
            return Uri.parse(aM);
        }
        String i2 = i();
        if (StringUtils.isValidString(i2)) {
            return Uri.parse(i2);
        }
        return null;
    }

    public boolean hasVideoUrl() {
        return h() != null;
    }

    public String i() {
        return getStringFromAdObject(MimeTypes.BASE_TYPE_VIDEO, "");
    }

    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", Boolean.FALSE);
    }

    public Uri j() {
        String stringFromAdObject = getStringFromAdObject("click_url", "");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public Uri k() {
        String stringFromAdObject = getStringFromAdObject("video_click_url", "");
        return StringUtils.isValidString(stringFromAdObject) ? Uri.parse(stringFromAdObject) : j();
    }

    public float l() {
        return getFloatFromAdObject("mraid_close_delay_graphic", 0.0f);
    }

    public boolean m() {
        if (this.adObject.has("close_button_expandable_hidden")) {
            return getBooleanFromAdObject("close_button_expandable_hidden", Boolean.FALSE);
        }
        return true;
    }

    public i.a n() {
        return a(getIntFromAdObject("expandable_style", i.a.INVISIBLE.a()));
    }
}
