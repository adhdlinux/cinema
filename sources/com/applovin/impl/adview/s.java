package com.applovin.impl.adview;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.v;
import com.facebook.react.uimanager.ViewProps;
import org.json.JSONObject;

public class s {

    /* renamed from: a  reason: collision with root package name */
    private final int f14126a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14127b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14128c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14129d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f14130e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14131f;

    /* renamed from: g  reason: collision with root package name */
    private final int f14132g;

    /* renamed from: h  reason: collision with root package name */
    private final int f14133h;

    /* renamed from: i  reason: collision with root package name */
    private final float f14134i;

    /* renamed from: j  reason: collision with root package name */
    private final float f14135j;

    public s(JSONObject jSONObject, m mVar) {
        if (v.a()) {
            v A = mVar.A();
            A.c("VideoButtonProperties", "Updating video button properties with JSON = " + JsonUtils.maybeConvertToIndentedString(jSONObject));
        }
        this.f14126a = JsonUtils.getInt(jSONObject, "width", 64);
        this.f14127b = JsonUtils.getInt(jSONObject, "height", 7);
        this.f14128c = JsonUtils.getInt(jSONObject, ViewProps.MARGIN, 20);
        this.f14129d = JsonUtils.getInt(jSONObject, "gravity", 85);
        this.f14130e = JsonUtils.getBoolean(jSONObject, "tap_to_fade", Boolean.FALSE).booleanValue();
        this.f14131f = JsonUtils.getInt(jSONObject, "tap_to_fade_duration_milliseconds", 500);
        this.f14132g = JsonUtils.getInt(jSONObject, "fade_in_duration_milliseconds", 500);
        this.f14133h = JsonUtils.getInt(jSONObject, "fade_out_duration_milliseconds", 500);
        this.f14134i = JsonUtils.getFloat(jSONObject, "fade_in_delay_seconds", 1.0f);
        this.f14135j = JsonUtils.getFloat(jSONObject, "fade_out_delay_seconds", 6.0f);
    }

    public int a() {
        return this.f14126a;
    }

    public int b() {
        return this.f14127b;
    }

    public int c() {
        return this.f14128c;
    }

    public int d() {
        return this.f14129d;
    }

    public boolean e() {
        return this.f14130e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        return this.f14126a == sVar.f14126a && this.f14127b == sVar.f14127b && this.f14128c == sVar.f14128c && this.f14129d == sVar.f14129d && this.f14130e == sVar.f14130e && this.f14131f == sVar.f14131f && this.f14132g == sVar.f14132g && this.f14133h == sVar.f14133h && Float.compare(sVar.f14134i, this.f14134i) == 0 && Float.compare(sVar.f14135j, this.f14135j) == 0;
    }

    public long f() {
        return (long) this.f14131f;
    }

    public long g() {
        return (long) this.f14132g;
    }

    public long h() {
        return (long) this.f14133h;
    }

    public int hashCode() {
        int i2 = ((((((((((((((this.f14126a * 31) + this.f14127b) * 31) + this.f14128c) * 31) + this.f14129d) * 31) + (this.f14130e ? 1 : 0)) * 31) + this.f14131f) * 31) + this.f14132g) * 31) + this.f14133h) * 31;
        float f2 = this.f14134i;
        int i3 = 0;
        int floatToIntBits = (i2 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
        float f3 = this.f14135j;
        if (f3 != 0.0f) {
            i3 = Float.floatToIntBits(f3);
        }
        return floatToIntBits + i3;
    }

    public float i() {
        return this.f14134i;
    }

    public float j() {
        return this.f14135j;
    }

    public String toString() {
        return "VideoButtonProperties{widthPercentOfScreen=" + this.f14126a + ", heightPercentOfScreen=" + this.f14127b + ", margin=" + this.f14128c + ", gravity=" + this.f14129d + ", tapToFade=" + this.f14130e + ", tapToFadeDurationMillis=" + this.f14131f + ", fadeInDurationMillis=" + this.f14132g + ", fadeOutDurationMillis=" + this.f14133h + ", fadeInDelay=" + this.f14134i + ", fadeOutDelay=" + this.f14135j + '}';
    }
}
