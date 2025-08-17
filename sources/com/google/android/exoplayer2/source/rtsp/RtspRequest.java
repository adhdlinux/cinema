package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;

final class RtspRequest {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f26916a;

    /* renamed from: b  reason: collision with root package name */
    public final int f26917b;

    /* renamed from: c  reason: collision with root package name */
    public final RtspHeaders f26918c;

    /* renamed from: d  reason: collision with root package name */
    public final String f26919d;

    public RtspRequest(Uri uri, int i2, RtspHeaders rtspHeaders, String str) {
        this.f26916a = uri;
        this.f26917b = i2;
        this.f26918c = rtspHeaders;
        this.f26919d = str;
    }
}
