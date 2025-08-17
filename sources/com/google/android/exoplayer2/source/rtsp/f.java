package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtpDataLoadable;
import com.google.android.exoplayer2.source.rtsp.RtspMediaPeriod;

public final /* synthetic */ class f implements RtpDataLoadable.EventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RtspMediaPeriod.RtpLoadInfo f26975a;

    public /* synthetic */ f(RtspMediaPeriod.RtpLoadInfo rtpLoadInfo) {
        this.f26975a = rtpLoadInfo;
    }

    public final void a(String str, RtpDataChannel rtpDataChannel) {
        this.f26975a.f(str, rtpDataChannel);
    }
}
