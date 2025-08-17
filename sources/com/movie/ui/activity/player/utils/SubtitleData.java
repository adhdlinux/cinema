package com.movie.ui.activity.player.utils;

import com.google.android.gms.common.internal.ImagesContract;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

public final class SubtitleData {

    /* renamed from: a  reason: collision with root package name */
    private final String f32471a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32472b;

    /* renamed from: c  reason: collision with root package name */
    private final SubtitleOrigin f32473c;

    /* renamed from: d  reason: collision with root package name */
    private final String f32474d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f32475e;

    /* renamed from: f  reason: collision with root package name */
    private final String f32476f;

    public SubtitleData(String str, String str2, SubtitleOrigin subtitleOrigin, String str3, Map<String, String> map, String str4) {
        Intrinsics.f(str, "name");
        Intrinsics.f(str2, ImagesContract.URL);
        Intrinsics.f(subtitleOrigin, "origin");
        Intrinsics.f(str3, "mimeType");
        Intrinsics.f(map, "headers");
        this.f32471a = str;
        this.f32472b = str2;
        this.f32473c = subtitleOrigin;
        this.f32474d = str3;
        this.f32475e = map;
        this.f32476f = str4;
    }

    public final Map<String, String> a() {
        return this.f32475e;
    }

    public final String b() {
        return this.f32472b;
    }

    public final String c() {
        return this.f32476f;
    }

    public final String d() {
        return this.f32474d;
    }

    public final String e() {
        return this.f32471a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubtitleData)) {
            return false;
        }
        SubtitleData subtitleData = (SubtitleData) obj;
        return Intrinsics.a(this.f32471a, subtitleData.f32471a) && Intrinsics.a(this.f32472b, subtitleData.f32472b) && this.f32473c == subtitleData.f32473c && Intrinsics.a(this.f32474d, subtitleData.f32474d) && Intrinsics.a(this.f32475e, subtitleData.f32475e) && Intrinsics.a(this.f32476f, subtitleData.f32476f);
    }

    public final SubtitleOrigin f() {
        return this.f32473c;
    }

    public final String g() {
        return this.f32472b;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f32471a.hashCode() * 31) + this.f32472b.hashCode()) * 31) + this.f32473c.hashCode()) * 31) + this.f32474d.hashCode()) * 31) + this.f32475e.hashCode()) * 31;
        String str = this.f32476f;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return '[' + this.f32476f + "] " + this.f32471a;
    }
}
