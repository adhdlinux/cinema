package com.google.android.exoplayer2.source.dash.manifest;

import com.google.common.base.Objects;

public final class BaseUrl {

    /* renamed from: a  reason: collision with root package name */
    public final String f26274a;

    /* renamed from: b  reason: collision with root package name */
    public final String f26275b;

    /* renamed from: c  reason: collision with root package name */
    public final int f26276c;

    /* renamed from: d  reason: collision with root package name */
    public final int f26277d;

    public BaseUrl(String str, String str2, int i2, int i3) {
        this.f26274a = str;
        this.f26275b = str2;
        this.f26276c = i2;
        this.f26277d = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseUrl)) {
            return false;
        }
        BaseUrl baseUrl = (BaseUrl) obj;
        if (this.f26276c != baseUrl.f26276c || this.f26277d != baseUrl.f26277d || !Objects.a(this.f26274a, baseUrl.f26274a) || !Objects.a(this.f26275b, baseUrl.f26275b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.b(this.f26274a, this.f26275b, Integer.valueOf(this.f26276c), Integer.valueOf(this.f26277d));
    }
}
