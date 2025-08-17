package com.google.android.exoplayer2.source.dash;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.uwetrottmann.trakt5.TraktV2;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public final class PlayerEmsgHandler implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    private final Allocator f26249b;

    /* renamed from: c  reason: collision with root package name */
    private final PlayerEmsgCallback f26250c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final EventMessageDecoder f26251d = new EventMessageDecoder();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Handler f26252e = Util.x(this);

    /* renamed from: f  reason: collision with root package name */
    private final TreeMap<Long, Long> f26253f = new TreeMap<>();

    /* renamed from: g  reason: collision with root package name */
    private DashManifest f26254g;

    /* renamed from: h  reason: collision with root package name */
    private long f26255h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f26256i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f26257j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f26258k;

    private static final class ManifestExpiryEventInfo {

        /* renamed from: a  reason: collision with root package name */
        public final long f26259a;

        /* renamed from: b  reason: collision with root package name */
        public final long f26260b;

        public ManifestExpiryEventInfo(long j2, long j3) {
            this.f26259a = j2;
            this.f26260b = j3;
        }
    }

    public interface PlayerEmsgCallback {
        void a(long j2);

        void b();
    }

    public final class PlayerTrackEmsgHandler implements TrackOutput {

        /* renamed from: a  reason: collision with root package name */
        private final SampleQueue f26261a;

        /* renamed from: b  reason: collision with root package name */
        private final FormatHolder f26262b = new FormatHolder();

        /* renamed from: c  reason: collision with root package name */
        private final MetadataInputBuffer f26263c = new MetadataInputBuffer();

        /* renamed from: d  reason: collision with root package name */
        private long f26264d = -9223372036854775807L;

        PlayerTrackEmsgHandler(Allocator allocator) {
            this.f26261a = SampleQueue.l(allocator);
        }

        private MetadataInputBuffer g() {
            this.f26263c.f();
            if (this.f26261a.S(this.f26262b, this.f26263c, 0, false) != -4) {
                return null;
            }
            this.f26263c.r();
            return this.f26263c;
        }

        private void k(long j2, long j3) {
            PlayerEmsgHandler.this.f26252e.sendMessage(PlayerEmsgHandler.this.f26252e.obtainMessage(1, new ManifestExpiryEventInfo(j2, j3)));
        }

        private void l() {
            while (this.f26261a.K(false)) {
                MetadataInputBuffer g2 = g();
                if (g2 != null) {
                    long j2 = g2.f23963f;
                    Metadata a2 = PlayerEmsgHandler.this.f26251d.a(g2);
                    if (a2 != null) {
                        EventMessage eventMessage = (EventMessage) a2.e(0);
                        if (PlayerEmsgHandler.h(eventMessage.f25370b, eventMessage.f25371c)) {
                            m(j2, eventMessage);
                        }
                    }
                }
            }
            this.f26261a.s();
        }

        private void m(long j2, EventMessage eventMessage) {
            long c2 = PlayerEmsgHandler.f(eventMessage);
            if (c2 != -9223372036854775807L) {
                k(j2, c2);
            }
        }

        public int a(DataReader dataReader, int i2, boolean z2, int i3) throws IOException {
            return this.f26261a.b(dataReader, i2, z2);
        }

        public /* synthetic */ int b(DataReader dataReader, int i2, boolean z2) {
            return f.a(this, dataReader, i2, z2);
        }

        public /* synthetic */ void c(ParsableByteArray parsableByteArray, int i2) {
            f.b(this, parsableByteArray, i2);
        }

        public void d(Format format) {
            this.f26261a.d(format);
        }

        public void e(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
            this.f26261a.e(j2, i2, i3, i4, cryptoData);
            l();
        }

        public void f(ParsableByteArray parsableByteArray, int i2, int i3) {
            this.f26261a.c(parsableByteArray, i2);
        }

        public boolean h(long j2) {
            return PlayerEmsgHandler.this.j(j2);
        }

        public void i(Chunk chunk) {
            long j2 = this.f26264d;
            if (j2 == -9223372036854775807L || chunk.f26085h > j2) {
                this.f26264d = chunk.f26085h;
            }
            PlayerEmsgHandler.this.m(chunk);
        }

        public boolean j(Chunk chunk) {
            boolean z2;
            long j2 = this.f26264d;
            if (j2 == -9223372036854775807L || j2 >= chunk.f26084g) {
                z2 = false;
            } else {
                z2 = true;
            }
            return PlayerEmsgHandler.this.n(z2);
        }

        public void n() {
            this.f26261a.T();
        }
    }

    public PlayerEmsgHandler(DashManifest dashManifest, PlayerEmsgCallback playerEmsgCallback, Allocator allocator) {
        this.f26254g = dashManifest;
        this.f26250c = playerEmsgCallback;
        this.f26249b = allocator;
    }

    private Map.Entry<Long, Long> e(long j2) {
        return this.f26253f.ceilingEntry(Long.valueOf(j2));
    }

    /* access modifiers changed from: private */
    public static long f(EventMessage eventMessage) {
        try {
            return Util.M0(Util.D(eventMessage.f25374f));
        } catch (ParserException unused) {
            return -9223372036854775807L;
        }
    }

    private void g(long j2, long j3) {
        Long l2 = this.f26253f.get(Long.valueOf(j3));
        if (l2 == null) {
            this.f26253f.put(Long.valueOf(j3), Long.valueOf(j2));
        } else if (l2.longValue() > j2) {
            this.f26253f.put(Long.valueOf(j3), Long.valueOf(j2));
        }
    }

    /* access modifiers changed from: private */
    public static boolean h(String str, String str2) {
        if (!"urn:mpeg:dash:event:2012".equals(str) || (!"1".equals(str2) && !TraktV2.API_VERSION.equals(str2) && !"3".equals(str2))) {
            return false;
        }
        return true;
    }

    private void i() {
        if (this.f26256i) {
            this.f26257j = true;
            this.f26256i = false;
            this.f26250c.b();
        }
    }

    private void l() {
        this.f26250c.a(this.f26255h);
    }

    private void p() {
        Iterator<Map.Entry<Long, Long>> it2 = this.f26253f.entrySet().iterator();
        while (it2.hasNext()) {
            if (((Long) it2.next().getKey()).longValue() < this.f26254g.f26285h) {
                it2.remove();
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (this.f26258k) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        ManifestExpiryEventInfo manifestExpiryEventInfo = (ManifestExpiryEventInfo) message.obj;
        g(manifestExpiryEventInfo.f26259a, manifestExpiryEventInfo.f26260b);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean j(long j2) {
        DashManifest dashManifest = this.f26254g;
        boolean z2 = false;
        if (!dashManifest.f26281d) {
            return false;
        }
        if (this.f26257j) {
            return true;
        }
        Map.Entry<Long, Long> e2 = e(dashManifest.f26285h);
        if (e2 != null && e2.getValue().longValue() < j2) {
            this.f26255h = e2.getKey().longValue();
            l();
            z2 = true;
        }
        if (z2) {
            i();
        }
        return z2;
    }

    public PlayerTrackEmsgHandler k() {
        return new PlayerTrackEmsgHandler(this.f26249b);
    }

    /* access modifiers changed from: package-private */
    public void m(Chunk chunk) {
        this.f26256i = true;
    }

    /* access modifiers changed from: package-private */
    public boolean n(boolean z2) {
        if (!this.f26254g.f26281d) {
            return false;
        }
        if (this.f26257j) {
            return true;
        }
        if (!z2) {
            return false;
        }
        i();
        return true;
    }

    public void o() {
        this.f26258k = true;
        this.f26252e.removeCallbacksAndMessages((Object) null);
    }

    public void q(DashManifest dashManifest) {
        this.f26257j = false;
        this.f26255h = -9223372036854775807L;
        this.f26254g = dashManifest;
        p();
    }
}
