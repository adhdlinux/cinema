package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.source.rtsp.RtspMessageChannel;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.Map;
import u0.b;

final class UdpDataSourceRtpDataChannel implements RtpDataChannel {

    /* renamed from: a  reason: collision with root package name */
    private final UdpDataSource f26965a;

    /* renamed from: b  reason: collision with root package name */
    private UdpDataSourceRtpDataChannel f26966b;

    public UdpDataSourceRtpDataChannel(long j2) {
        this.f26965a = new UdpDataSource(2000, Ints.d(j2));
    }

    public Uri b() {
        return this.f26965a.b();
    }

    public void close() {
        this.f26965a.close();
        UdpDataSourceRtpDataChannel udpDataSourceRtpDataChannel = this.f26966b;
        if (udpDataSourceRtpDataChannel != null) {
            udpDataSourceRtpDataChannel.close();
        }
    }

    public /* synthetic */ Map d() {
        return b.a(this);
    }

    public long i(DataSpec dataSpec) throws IOException {
        return this.f26965a.i(dataSpec);
    }

    public String n() {
        boolean z2;
        int o2 = o();
        if (o2 != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        return Util.C("RTP/AVP;unicast;client_port=%d-%d", Integer.valueOf(o2), Integer.valueOf(o2 + 1));
    }

    public int o() {
        int o2 = this.f26965a.o();
        if (o2 == -1) {
            return -1;
        }
        return o2;
    }

    public void p(TransferListener transferListener) {
        this.f26965a.p(transferListener);
    }

    public void q(UdpDataSourceRtpDataChannel udpDataSourceRtpDataChannel) {
        boolean z2;
        if (this != udpDataSourceRtpDataChannel) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f26966b = udpDataSourceRtpDataChannel;
    }

    public RtspMessageChannel.InterleavedBinaryDataListener r() {
        return null;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        try {
            return this.f26965a.read(bArr, i2, i3);
        } catch (UdpDataSource.UdpDataSourceException e2) {
            if (e2.f28332b == 2002) {
                return -1;
            }
            throw e2;
        }
    }
}
