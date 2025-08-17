package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.rtsp.RtpDataChannel;
import com.google.android.exoplayer2.source.rtsp.RtspMediaPeriod;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import javax.net.SocketFactory;

public final class RtspMediaSource extends BaseMediaSource {

    /* renamed from: i  reason: collision with root package name */
    private final MediaItem f26862i;

    /* renamed from: j  reason: collision with root package name */
    private final RtpDataChannel.Factory f26863j;

    /* renamed from: k  reason: collision with root package name */
    private final String f26864k;

    /* renamed from: l  reason: collision with root package name */
    private final Uri f26865l;

    /* renamed from: m  reason: collision with root package name */
    private final SocketFactory f26866m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f26867n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public long f26868o = -9223372036854775807L;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f26869p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f26870q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public boolean f26871r = true;

    public static final class Factory implements MediaSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private long f26873a = 8000;

        /* renamed from: b  reason: collision with root package name */
        private String f26874b = "ExoPlayerLib/2.18.7";

        /* renamed from: c  reason: collision with root package name */
        private SocketFactory f26875c = SocketFactory.getDefault();

        /* renamed from: d  reason: collision with root package name */
        private boolean f26876d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f26877e;

        /* renamed from: d */
        public RtspMediaSource a(MediaItem mediaItem) {
            RtpDataChannel.Factory factory;
            Assertions.e(mediaItem.f23129c);
            if (this.f26876d) {
                factory = new TransferRtpDataChannelFactory(this.f26873a);
            } else {
                factory = new UdpDataSourceRtpDataChannelFactory(this.f26873a);
            }
            return new RtspMediaSource(mediaItem, factory, this.f26874b, this.f26875c, this.f26877e);
        }

        /* renamed from: e */
        public Factory b(DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        /* renamed from: f */
        public Factory c(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }
    }

    public static class RtspPlaybackException extends IOException {
        public RtspPlaybackException(String str) {
            super(str);
        }

        public RtspPlaybackException(Throwable th) {
            super(th);
        }

        public RtspPlaybackException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static final class RtspUdpUnsupportedTransportException extends RtspPlaybackException {
        public RtspUdpUnsupportedTransportException(String str) {
            super(str);
        }
    }

    static {
        ExoPlayerLibraryInfo.a("goog.exo.rtsp");
    }

    RtspMediaSource(MediaItem mediaItem, RtpDataChannel.Factory factory, String str, SocketFactory socketFactory, boolean z2) {
        this.f26862i = mediaItem;
        this.f26863j = factory;
        this.f26864k = str;
        this.f26865l = ((MediaItem.LocalConfiguration) Assertions.e(mediaItem.f23129c)).f23202a;
        this.f26866m = socketFactory;
        this.f26867n = z2;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.google.android.exoplayer2.source.rtsp.RtspMediaSource$2] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K() {
        /*
            r9 = this;
            com.google.android.exoplayer2.source.SinglePeriodTimeline r8 = new com.google.android.exoplayer2.source.SinglePeriodTimeline
            long r1 = r9.f26868o
            boolean r3 = r9.f26869p
            r4 = 0
            boolean r5 = r9.f26870q
            r6 = 0
            com.google.android.exoplayer2.MediaItem r7 = r9.f26862i
            r0 = r8
            r0.<init>(r1, r3, r4, r5, r6, r7)
            boolean r0 = r9.f26871r
            if (r0 == 0) goto L_0x001a
            com.google.android.exoplayer2.source.rtsp.RtspMediaSource$2 r0 = new com.google.android.exoplayer2.source.rtsp.RtspMediaSource$2
            r0.<init>(r9, r8)
            r8 = r0
        L_0x001a:
            r9.D(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.RtspMediaSource.K():void");
    }

    /* access modifiers changed from: protected */
    public void C(TransferListener transferListener) {
        K();
    }

    /* access modifiers changed from: protected */
    public void E() {
    }

    public MediaItem a() {
        return this.f26862i;
    }

    public void c() {
    }

    public MediaPeriod f(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        return new RtspMediaPeriod(allocator, this.f26863j, this.f26865l, new RtspMediaPeriod.Listener() {
            public void a() {
                boolean unused = RtspMediaSource.this.f26869p = false;
                RtspMediaSource.this.K();
            }

            public void b(RtspSessionTiming rtspSessionTiming) {
                long unused = RtspMediaSource.this.f26868o = Util.F0(rtspSessionTiming.a());
                boolean unused2 = RtspMediaSource.this.f26869p = !rtspSessionTiming.c();
                boolean unused3 = RtspMediaSource.this.f26870q = rtspSessionTiming.c();
                boolean unused4 = RtspMediaSource.this.f26871r = false;
                RtspMediaSource.this.K();
            }
        }, this.f26864k, this.f26866m, this.f26867n);
    }

    public void l(MediaPeriod mediaPeriod) {
        ((RtspMediaPeriod) mediaPeriod).W();
    }
}
