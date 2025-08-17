package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtpDataChannel;
import q0.a;

final class TransferRtpDataChannelFactory implements RtpDataChannel.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final long f26964a;

    public TransferRtpDataChannelFactory(long j2) {
        this.f26964a = j2;
    }

    public RtpDataChannel a(int i2) {
        TransferRtpDataChannel transferRtpDataChannel = new TransferRtpDataChannel(this.f26964a);
        transferRtpDataChannel.i(RtpUtils.a(i2 * 2));
        return transferRtpDataChannel;
    }

    public /* synthetic */ RtpDataChannel.Factory b() {
        return a.a(this);
    }
}
