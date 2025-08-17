package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtspMessageUtil;

final class RtspSetupResponse {

    /* renamed from: a  reason: collision with root package name */
    public final int f26927a;

    /* renamed from: b  reason: collision with root package name */
    public final RtspMessageUtil.RtspSessionHeader f26928b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26929c;

    public RtspSetupResponse(int i2, RtspMessageUtil.RtspSessionHeader rtspSessionHeader, String str) {
        this.f26927a = i2;
        this.f26928b = rtspSessionHeader;
        this.f26929c = str;
    }
}
