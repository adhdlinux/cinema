package com.movie.ui.activity.player;

import kotlin.jvm.internal.Intrinsics;

public final class AudioTrack {

    /* renamed from: a  reason: collision with root package name */
    private final String f32349a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32350b;

    /* renamed from: c  reason: collision with root package name */
    private final String f32351c;

    public AudioTrack(String str, String str2, String str3) {
        this.f32349a = str;
        this.f32350b = str2;
        this.f32351c = str3;
    }

    public String a() {
        return this.f32349a;
    }

    public String b() {
        return this.f32351c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioTrack)) {
            return false;
        }
        AudioTrack audioTrack = (AudioTrack) obj;
        return Intrinsics.a(this.f32349a, audioTrack.f32349a) && Intrinsics.a(this.f32350b, audioTrack.f32350b) && Intrinsics.a(this.f32351c, audioTrack.f32351c);
    }

    public int hashCode() {
        String str = this.f32349a;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f32350b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f32351c;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "AudioTrack(id=" + this.f32349a + ", label=" + this.f32350b + ", language=" + this.f32351c + ')';
    }
}
