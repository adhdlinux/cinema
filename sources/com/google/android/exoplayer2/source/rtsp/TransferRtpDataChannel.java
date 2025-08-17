package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.source.rtsp.RtspMessageChannel;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

final class TransferRtpDataChannel extends BaseDataSource implements RtpDataChannel, RtspMessageChannel.InterleavedBinaryDataListener {

    /* renamed from: e  reason: collision with root package name */
    private final LinkedBlockingQueue<byte[]> f26960e = new LinkedBlockingQueue<>();

    /* renamed from: f  reason: collision with root package name */
    private final long f26961f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f26962g = new byte[0];

    /* renamed from: h  reason: collision with root package name */
    private int f26963h = -1;

    public TransferRtpDataChannel(long j2) {
        super(true);
        this.f26961f = j2;
    }

    public Uri b() {
        return null;
    }

    public void close() {
    }

    public long i(DataSpec dataSpec) {
        this.f26963h = dataSpec.f28339a.getPort();
        return -1;
    }

    public String n() {
        boolean z2;
        if (this.f26963h != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        return Util.C("RTP/AVP/TCP;unicast;interleaved=%d-%d", Integer.valueOf(this.f26963h), Integer.valueOf(this.f26963h + 1));
    }

    public int o() {
        return this.f26963h;
    }

    public void q(byte[] bArr) {
        this.f26960e.add(bArr);
    }

    public RtspMessageChannel.InterleavedBinaryDataListener r() {
        return this;
    }

    public int read(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, this.f26962g.length);
        System.arraycopy(this.f26962g, 0, bArr, i2, min);
        int i4 = min + 0;
        byte[] bArr2 = this.f26962g;
        this.f26962g = Arrays.copyOfRange(bArr2, min, bArr2.length);
        if (i4 == i3) {
            return i4;
        }
        try {
            byte[] poll = this.f26960e.poll(this.f26961f, TimeUnit.MILLISECONDS);
            if (poll == null) {
                return -1;
            }
            int min2 = Math.min(i3 - i4, poll.length);
            System.arraycopy(poll, 0, bArr, i2 + i4, min2);
            if (min2 < poll.length) {
                this.f26962g = Arrays.copyOfRange(poll, min2, poll.length);
            }
            return i4 + min2;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return -1;
        }
    }
}
