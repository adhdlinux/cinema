package com.facebook.ads.internal.n;

import android.graphics.Color;
import android.graphics.Typeface;
import com.facebook.ads.internal.settings.AdInternalSettings;
import org.json.JSONObject;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private Typeface f20381a = Typeface.DEFAULT;

    /* renamed from: b  reason: collision with root package name */
    private int f20382b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f20383c = -16777216;

    /* renamed from: d  reason: collision with root package name */
    private int f20384d = -11643291;

    /* renamed from: e  reason: collision with root package name */
    private int f20385e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f20386f = -12420889;

    /* renamed from: g  reason: collision with root package name */
    private int f20387g = -12420889;

    /* renamed from: h  reason: collision with root package name */
    private boolean f20388h = AdInternalSettings.isVideoAutoplay();

    /* renamed from: i  reason: collision with root package name */
    private boolean f20389i = AdInternalSettings.isVideoAutoplayOnMobile();

    public k() {
    }

    public k(JSONObject jSONObject) {
        int parseColor = jSONObject.getBoolean("background_transparent") ? 0 : Color.parseColor(jSONObject.getString("background_color"));
        int parseColor2 = Color.parseColor(jSONObject.getString("title_text_color"));
        int parseColor3 = Color.parseColor(jSONObject.getString("description_text_color"));
        int parseColor4 = jSONObject.getBoolean("button_transparent") ? 0 : Color.parseColor(jSONObject.getString("button_color"));
        int parseColor5 = jSONObject.getBoolean("button_border_transparent") ? 0 : Color.parseColor(jSONObject.getString("button_border_color"));
        int parseColor6 = Color.parseColor(jSONObject.getString("button_text_color"));
        Typeface create = Typeface.create(jSONObject.getString("android_typeface"), 0);
        this.f20382b = parseColor;
        this.f20383c = parseColor2;
        this.f20384d = parseColor3;
        this.f20385e = parseColor4;
        this.f20387g = parseColor5;
        this.f20386f = parseColor6;
        this.f20381a = create;
    }

    public Typeface a() {
        return this.f20381a;
    }

    public void a(int i2) {
        this.f20382b = i2;
    }

    public void a(Typeface typeface) {
        this.f20381a = typeface;
    }

    public void a(boolean z2) {
        this.f20389i = z2;
    }

    public int b() {
        return this.f20382b;
    }

    public void b(int i2) {
        this.f20383c = i2;
    }

    public void b(boolean z2) {
        this.f20388h = z2;
    }

    public int c() {
        return this.f20383c;
    }

    public void c(int i2) {
        this.f20384d = i2;
    }

    public int d() {
        return this.f20384d;
    }

    public void d(int i2) {
        this.f20385e = i2;
    }

    public int e() {
        return this.f20385e;
    }

    public void e(int i2) {
        this.f20386f = i2;
    }

    public int f() {
        return this.f20386f;
    }

    public void f(int i2) {
        this.f20387g = i2;
    }

    public int g() {
        return this.f20387g;
    }

    public int h() {
        return 16;
    }

    public int i() {
        return 10;
    }

    public boolean j() {
        return this.f20388h;
    }

    public boolean k() {
        return this.f20389i;
    }
}
