package androidx.media3.exoplayer.dash;

import android.os.Handler;
import android.os.Message;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.g;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import androidx.media3.extractor.metadata.emsg.EventMessageDecoder;
import com.uwetrottmann.trakt5.TraktV2;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public final class PlayerEmsgHandler implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    private final Allocator f6020b;

    /* renamed from: c  reason: collision with root package name */
    private final PlayerEmsgCallback f6021c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final EventMessageDecoder f6022d = new EventMessageDecoder();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Handler f6023e = Util.B(this);

    /* renamed from: f  reason: collision with root package name */
    private final TreeMap<Long, Long> f6024f = new TreeMap<>();

    /* renamed from: g  reason: collision with root package name */
    private DashManifest f6025g;

    /* renamed from: h  reason: collision with root package name */
    private long f6026h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6027i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f6028j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6029k;

    private static final class ManifestExpiryEventInfo {

        /* renamed from: a  reason: collision with root package name */
        public final long f6030a;

        /* renamed from: b  reason: collision with root package name */
        public final long f6031b;

        public ManifestExpiryEventInfo(long j2, long j3) {
            this.f6030a = j2;
            this.f6031b = j3;
        }
    }

    public interface PlayerEmsgCallback {
        void a(long j2);

        void b();
    }

    public final class PlayerTrackEmsgHandler implements TrackOutput {

        /* renamed from: a  reason: collision with root package name */
        private final SampleQueue f6032a;

        /* renamed from: b  reason: collision with root package name */
        private final FormatHolder f6033b = new FormatHolder();

        /* renamed from: c  reason: collision with root package name */
        private final MetadataInputBuffer f6034c = new MetadataInputBuffer();

        /* renamed from: d  reason: collision with root package name */
        private long f6035d = -9223372036854775807L;

        PlayerTrackEmsgHandler(Allocator allocator) {
            this.f6032a = SampleQueue.l(allocator);
        }

        private MetadataInputBuffer g() {
            this.f6034c.clear();
            if (this.f6032a.T(this.f6033b, this.f6034c, 0, false) != -4) {
                return null;
            }
            this.f6034c.g();
            return this.f6034c;
        }

        private void k(long j2, long j3) {
            PlayerEmsgHandler.this.f6023e.sendMessage(PlayerEmsgHandler.this.f6023e.obtainMessage(1, new ManifestExpiryEventInfo(j2, j3)));
        }

        private void l() {
            while (this.f6032a.L(false)) {
                MetadataInputBuffer g2 = g();
                if (g2 != null) {
                    long j2 = g2.f5069f;
                    Metadata a2 = PlayerEmsgHandler.this.f6022d.a(g2);
                    if (a2 != null) {
                        EventMessage eventMessage = (EventMessage) a2.e(0);
                        if (PlayerEmsgHandler.h(eventMessage.f8270b, eventMessage.f8271c)) {
                            m(j2, eventMessage);
                        }
                    }
                }
            }
            this.f6032a.s();
        }

        private void m(long j2, EventMessage eventMessage) {
            long c2 = PlayerEmsgHandler.f(eventMessage);
            if (c2 != -9223372036854775807L) {
                k(j2, c2);
            }
        }

        public void a(ParsableByteArray parsableByteArray, int i2, int i3) {
            this.f6032a.b(parsableByteArray, i2);
        }

        public /* synthetic */ void b(ParsableByteArray parsableByteArray, int i2) {
            g.b(this, parsableByteArray, i2);
        }

        public void c(Format format) {
            this.f6032a.c(format);
        }

        public /* synthetic */ int d(DataReader dataReader, int i2, boolean z2) {
            return g.a(this, dataReader, i2, z2);
        }

        public int e(DataReader dataReader, int i2, boolean z2, int i3) throws IOException {
            return this.f6032a.d(dataReader, i2, z2);
        }

        public void f(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
            this.f6032a.f(j2, i2, i3, i4, cryptoData);
            l();
        }

        public boolean h(long j2) {
            return PlayerEmsgHandler.this.j(j2);
        }

        public void i(Chunk chunk) {
            long j2 = this.f6035d;
            if (j2 == -9223372036854775807L || chunk.f7224h > j2) {
                this.f6035d = chunk.f7224h;
            }
            PlayerEmsgHandler.this.m(chunk);
        }

        public boolean j(Chunk chunk) {
            boolean z2;
            long j2 = this.f6035d;
            if (j2 == -9223372036854775807L || j2 >= chunk.f7223g) {
                z2 = false;
            } else {
                z2 = true;
            }
            return PlayerEmsgHandler.this.n(z2);
        }

        public void n() {
            this.f6032a.U();
        }
    }

    public PlayerEmsgHandler(DashManifest dashManifest, PlayerEmsgCallback playerEmsgCallback, Allocator allocator) {
        this.f6025g = dashManifest;
        this.f6021c = playerEmsgCallback;
        this.f6020b = allocator;
    }

    private Map.Entry<Long, Long> e(long j2) {
        return this.f6024f.ceilingEntry(Long.valueOf(j2));
    }

    /* access modifiers changed from: private */
    public static long f(EventMessage eventMessage) {
        try {
            return Util.W0(Util.H(eventMessage.f8274f));
        } catch (ParserException unused) {
            return -9223372036854775807L;
        }
    }

    private void g(long j2, long j3) {
        Long l2 = this.f6024f.get(Long.valueOf(j3));
        if (l2 == null) {
            this.f6024f.put(Long.valueOf(j3), Long.valueOf(j2));
        } else if (l2.longValue() > j2) {
            this.f6024f.put(Long.valueOf(j3), Long.valueOf(j2));
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
        if (this.f6027i) {
            this.f6028j = true;
            this.f6027i = false;
            this.f6021c.b();
        }
    }

    private void l() {
        this.f6021c.a(this.f6026h);
    }

    private void p() {
        Iterator<Map.Entry<Long, Long>> it2 = this.f6024f.entrySet().iterator();
        while (it2.hasNext()) {
            if (((Long) it2.next().getKey()).longValue() < this.f6025g.f6056h) {
                it2.remove();
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (this.f6029k) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        ManifestExpiryEventInfo manifestExpiryEventInfo = (ManifestExpiryEventInfo) message.obj;
        g(manifestExpiryEventInfo.f6030a, manifestExpiryEventInfo.f6031b);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean j(long j2) {
        DashManifest dashManifest = this.f6025g;
        boolean z2 = false;
        if (!dashManifest.f6052d) {
            return false;
        }
        if (this.f6028j) {
            return true;
        }
        Map.Entry<Long, Long> e2 = e(dashManifest.f6056h);
        if (e2 != null && e2.getValue().longValue() < j2) {
            this.f6026h = e2.getKey().longValue();
            l();
            z2 = true;
        }
        if (z2) {
            i();
        }
        return z2;
    }

    public PlayerTrackEmsgHandler k() {
        return new PlayerTrackEmsgHandler(this.f6020b);
    }

    /* access modifiers changed from: package-private */
    public void m(Chunk chunk) {
        this.f6027i = true;
    }

    /* access modifiers changed from: package-private */
    public boolean n(boolean z2) {
        if (!this.f6025g.f6052d) {
            return false;
        }
        if (this.f6028j) {
            return true;
        }
        if (!z2) {
            return false;
        }
        i();
        return true;
    }

    public void o() {
        this.f6029k = true;
        this.f6023e.removeCallbacksAndMessages((Object) null);
    }

    public void q(DashManifest dashManifest) {
        this.f6028j = false;
        this.f6026h = -9223372036854775807L;
        this.f6025g = dashManifest;
        p();
    }
}
