package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtpDataChannel;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import java.io.IOException;

final class UdpDataSourceRtpDataChannelFactory implements RtpDataChannel.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final long f26967a;

    public UdpDataSourceRtpDataChannelFactory(long j2) {
        this.f26967a = j2;
    }

    public RtpDataChannel a(int i2) throws IOException {
        int i3;
        UdpDataSourceRtpDataChannel udpDataSourceRtpDataChannel = new UdpDataSourceRtpDataChannel(this.f26967a);
        UdpDataSourceRtpDataChannel udpDataSourceRtpDataChannel2 = new UdpDataSourceRtpDataChannel(this.f26967a);
        boolean z2 = false;
        try {
            udpDataSourceRtpDataChannel.i(RtpUtils.a(0));
            int o2 = udpDataSourceRtpDataChannel.o();
            if (o2 % 2 == 0) {
                z2 = true;
            }
            if (z2) {
                i3 = o2 + 1;
            } else {
                i3 = o2 - 1;
            }
            udpDataSourceRtpDataChannel2.i(RtpUtils.a(i3));
            if (z2) {
                udpDataSourceRtpDataChannel.q(udpDataSourceRtpDataChannel2);
                return udpDataSourceRtpDataChannel;
            }
            udpDataSourceRtpDataChannel2.q(udpDataSourceRtpDataChannel);
            return udpDataSourceRtpDataChannel2;
        } catch (IOException e2) {
            DataSourceUtil.a(udpDataSourceRtpDataChannel);
            DataSourceUtil.a(udpDataSourceRtpDataChannel2);
            throw e2;
        }
    }

    public RtpDataChannel.Factory b() {
        return new TransferRtpDataChannelFactory(this.f26967a);
    }
}
