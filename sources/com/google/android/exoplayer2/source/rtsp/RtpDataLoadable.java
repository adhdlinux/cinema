package com.google.android.exoplayer2.source.rtsp;

import android.os.Handler;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.source.rtsp.RtpDataChannel;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

final class RtpDataLoadable implements Loader.Loadable {

    /* renamed from: a  reason: collision with root package name */
    public final int f26736a;

    /* renamed from: b  reason: collision with root package name */
    public final RtspMediaTrack f26737b;

    /* renamed from: c  reason: collision with root package name */
    private final EventListener f26738c;

    /* renamed from: d  reason: collision with root package name */
    private final ExtractorOutput f26739d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f26740e = Util.w();

    /* renamed from: f  reason: collision with root package name */
    private final RtpDataChannel.Factory f26741f;

    /* renamed from: g  reason: collision with root package name */
    private RtpExtractor f26742g;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f26743h;

    /* renamed from: i  reason: collision with root package name */
    private volatile long f26744i;

    /* renamed from: j  reason: collision with root package name */
    private volatile long f26745j;

    public interface EventListener {
        void a(String str, RtpDataChannel rtpDataChannel);
    }

    public RtpDataLoadable(int i2, RtspMediaTrack rtspMediaTrack, EventListener eventListener, ExtractorOutput extractorOutput, RtpDataChannel.Factory factory) {
        this.f26736a = i2;
        this.f26737b = rtspMediaTrack;
        this.f26738c = eventListener;
        this.f26739d = extractorOutput;
        this.f26741f = factory;
        this.f26744i = -9223372036854775807L;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(String str, RtpDataChannel rtpDataChannel) {
        this.f26738c.a(str, rtpDataChannel);
    }

    public void a() throws IOException {
        RtpDataChannel rtpDataChannel = null;
        try {
            rtpDataChannel = this.f26741f.a(this.f26736a);
            this.f26740e.post(new a(this, rtpDataChannel.n(), rtpDataChannel));
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput((DataReader) Assertions.e(rtpDataChannel), 0, -1);
            RtpExtractor rtpExtractor = new RtpExtractor(this.f26737b.f26878a, this.f26736a);
            this.f26742g = rtpExtractor;
            rtpExtractor.c(this.f26739d);
            while (!this.f26743h) {
                if (this.f26744i != -9223372036854775807L) {
                    this.f26742g.a(this.f26745j, this.f26744i);
                    this.f26744i = -9223372036854775807L;
                }
                if (this.f26742g.i(defaultExtractorInput, new PositionHolder()) == -1) {
                    break;
                }
            }
        } finally {
            DataSourceUtil.a(rtpDataChannel);
        }
    }

    public void b() {
        this.f26743h = true;
    }

    public void e() {
        ((RtpExtractor) Assertions.e(this.f26742g)).e();
    }

    public void f(long j2, long j3) {
        this.f26744i = j2;
        this.f26745j = j3;
    }

    public void g(int i2) {
        if (!((RtpExtractor) Assertions.e(this.f26742g)).d()) {
            this.f26742g.f(i2);
        }
    }

    public void h(long j2) {
        if (j2 != -9223372036854775807L && !((RtpExtractor) Assertions.e(this.f26742g)).d()) {
            this.f26742g.h(j2);
        }
    }
}
