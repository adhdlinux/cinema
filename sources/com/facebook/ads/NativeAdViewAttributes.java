package com.facebook.ads;

import android.graphics.Typeface;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.j.b;
import com.facebook.ads.internal.n.k;
import org.json.JSONObject;

public class NativeAdViewAttributes {

    /* renamed from: a  reason: collision with root package name */
    private k f19534a;

    public NativeAdViewAttributes() {
        this.f19534a = new k();
    }

    NativeAdViewAttributes(k kVar) {
        this.f19534a = kVar;
    }

    public NativeAdViewAttributes(JSONObject jSONObject) {
        try {
            this.f19534a = new k(jSONObject);
        } catch (Exception e2) {
            this.f19534a = new k();
            b.a(a.a(e2, "Error retrieving native ui configuration data"));
        }
    }

    /* access modifiers changed from: package-private */
    public k a() {
        return this.f19534a;
    }

    public boolean getAutoplay() {
        return this.f19534a.j();
    }

    public boolean getAutoplayOnMobile() {
        return this.f19534a.k();
    }

    public int getBackgroundColor() {
        return this.f19534a.b();
    }

    public int getButtonBorderColor() {
        return this.f19534a.g();
    }

    public int getButtonColor() {
        return this.f19534a.e();
    }

    public int getButtonTextColor() {
        return this.f19534a.f();
    }

    public int getDescriptionTextColor() {
        return this.f19534a.d();
    }

    public int getDescriptionTextSize() {
        return this.f19534a.i();
    }

    public int getTitleTextColor() {
        return this.f19534a.c();
    }

    public int getTitleTextSize() {
        return this.f19534a.h();
    }

    public Typeface getTypeface() {
        return this.f19534a.a();
    }

    public NativeAdViewAttributes setAutoplay(boolean z2) {
        this.f19534a.b(z2);
        return this;
    }

    public NativeAdViewAttributes setAutoplayOnMobile(boolean z2) {
        this.f19534a.a(z2);
        return this;
    }

    public NativeAdViewAttributes setBackgroundColor(int i2) {
        this.f19534a.a(i2);
        return this;
    }

    public NativeAdViewAttributes setButtonBorderColor(int i2) {
        this.f19534a.f(i2);
        return this;
    }

    public NativeAdViewAttributes setButtonColor(int i2) {
        this.f19534a.d(i2);
        return this;
    }

    public NativeAdViewAttributes setButtonTextColor(int i2) {
        this.f19534a.e(i2);
        return this;
    }

    public NativeAdViewAttributes setDescriptionTextColor(int i2) {
        this.f19534a.c(i2);
        return this;
    }

    public NativeAdViewAttributes setTitleTextColor(int i2) {
        this.f19534a.b(i2);
        return this;
    }

    public NativeAdViewAttributes setTypeface(Typeface typeface) {
        this.f19534a.a(typeface);
        return this;
    }
}
