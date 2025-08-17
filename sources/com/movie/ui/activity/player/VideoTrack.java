package com.movie.ui.activity.player;

import kotlin.jvm.internal.Intrinsics;

public final class VideoTrack {

    /* renamed from: a  reason: collision with root package name */
    private final String f32413a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32414b;

    /* renamed from: c  reason: collision with root package name */
    private final String f32415c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f32416d;

    /* renamed from: e  reason: collision with root package name */
    private final Integer f32417e;

    public VideoTrack(String str, String str2, String str3, Integer num, Integer num2) {
        this.f32413a = str;
        this.f32414b = str2;
        this.f32415c = str3;
        this.f32416d = num;
        this.f32417e = num2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoTrack)) {
            return false;
        }
        VideoTrack videoTrack = (VideoTrack) obj;
        return Intrinsics.a(this.f32413a, videoTrack.f32413a) && Intrinsics.a(this.f32414b, videoTrack.f32414b) && Intrinsics.a(this.f32415c, videoTrack.f32415c) && Intrinsics.a(this.f32416d, videoTrack.f32416d) && Intrinsics.a(this.f32417e, videoTrack.f32417e);
    }

    public int hashCode() {
        String str = this.f32413a;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f32414b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f32415c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.f32416d;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f32417e;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        return hashCode4 + i2;
    }

    public String toString() {
        return "VideoTrack(id=" + this.f32413a + ", label=" + this.f32414b + ", language=" + this.f32415c + ", width=" + this.f32416d + ", height=" + this.f32417e + ')';
    }
}
