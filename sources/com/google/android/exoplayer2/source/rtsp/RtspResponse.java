package com.google.android.exoplayer2.source.rtsp;

final class RtspResponse {

    /* renamed from: a  reason: collision with root package name */
    public final int f26920a;

    /* renamed from: b  reason: collision with root package name */
    public final RtspHeaders f26921b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26922c;

    public RtspResponse(int i2, RtspHeaders rtspHeaders, String str) {
        this.f26920a = i2;
        this.f26921b = rtspHeaders;
        this.f26922c = str;
    }

    public RtspResponse(int i2, RtspHeaders rtspHeaders) {
        this(i2, rtspHeaders, "");
    }
}
