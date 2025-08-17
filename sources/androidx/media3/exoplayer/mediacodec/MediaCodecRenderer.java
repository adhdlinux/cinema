package androidx.media3.exoplayer.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.OggOpusAudioPacketizer;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.FrameworkCryptoConfig;
import androidx.media3.exoplayer.drm.i;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.extractor.OpusUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public abstract class MediaCodecRenderer extends BaseRenderer {
    private static final byte[] O0 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private final MediaCodec.BufferInfo A;
    private final ArrayDeque<OutputStreamInfo> B;
    private final OggOpusAudioPacketizer C;
    private Format D;
    private Format E;
    private DrmSession F;
    private boolean F0;
    private DrmSession G;
    private boolean G0;
    /* access modifiers changed from: private */
    public Renderer.WakeupListener H;
    private boolean H0;
    private MediaCrypto I;
    private boolean I0;
    private long J;
    private ExoPlaybackException J0;
    private float K;
    protected DecoderCounters K0;
    private float L;
    private OutputStreamInfo L0;
    private MediaCodecAdapter M;
    private long M0;
    private Format N;
    private boolean N0;
    private MediaFormat O;
    private boolean P;
    private float Q;
    private ArrayDeque<MediaCodecInfo> R;
    private DecoderInitializationException S;
    private MediaCodecInfo T;
    private int U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f6699a0;

    /* renamed from: b0  reason: collision with root package name */
    private boolean f6700b0;

    /* renamed from: c0  reason: collision with root package name */
    private boolean f6701c0;

    /* renamed from: d0  reason: collision with root package name */
    private boolean f6702d0;

    /* renamed from: e0  reason: collision with root package name */
    private boolean f6703e0;

    /* renamed from: f0  reason: collision with root package name */
    private boolean f6704f0;

    /* renamed from: g0  reason: collision with root package name */
    private long f6705g0;

    /* renamed from: h0  reason: collision with root package name */
    private int f6706h0;

    /* renamed from: i0  reason: collision with root package name */
    private int f6707i0;

    /* renamed from: j0  reason: collision with root package name */
    private ByteBuffer f6708j0;

    /* renamed from: k0  reason: collision with root package name */
    private boolean f6709k0;

    /* renamed from: l0  reason: collision with root package name */
    private boolean f6710l0;

    /* renamed from: m0  reason: collision with root package name */
    private boolean f6711m0;

    /* renamed from: n0  reason: collision with root package name */
    private boolean f6712n0;

    /* renamed from: o0  reason: collision with root package name */
    private boolean f6713o0;

    /* renamed from: p0  reason: collision with root package name */
    private boolean f6714p0;

    /* renamed from: q0  reason: collision with root package name */
    private int f6715q0;

    /* renamed from: r0  reason: collision with root package name */
    private int f6716r0;

    /* renamed from: s  reason: collision with root package name */
    private final MediaCodecAdapter.Factory f6717s;

    /* renamed from: s0  reason: collision with root package name */
    private int f6718s0;

    /* renamed from: t  reason: collision with root package name */
    private final MediaCodecSelector f6719t;

    /* renamed from: t0  reason: collision with root package name */
    private boolean f6720t0;

    /* renamed from: u  reason: collision with root package name */
    private final boolean f6721u;

    /* renamed from: u0  reason: collision with root package name */
    private boolean f6722u0;

    /* renamed from: v  reason: collision with root package name */
    private final float f6723v;

    /* renamed from: v0  reason: collision with root package name */
    private boolean f6724v0;

    /* renamed from: w  reason: collision with root package name */
    private final DecoderInputBuffer f6725w = DecoderInputBuffer.i();

    /* renamed from: w0  reason: collision with root package name */
    private long f6726w0;

    /* renamed from: x  reason: collision with root package name */
    private final DecoderInputBuffer f6727x = new DecoderInputBuffer(0);

    /* renamed from: x0  reason: collision with root package name */
    private long f6728x0;

    /* renamed from: y  reason: collision with root package name */
    private final DecoderInputBuffer f6729y = new DecoderInputBuffer(2);

    /* renamed from: z  reason: collision with root package name */
    private final BatchBuffer f6730z;

    private static final class Api21 {
        private Api21() {
        }

        public static boolean a(MediaCodecAdapter mediaCodecAdapter, MediaCodecRendererCodecAdapterListener mediaCodecRendererCodecAdapterListener) {
            return mediaCodecAdapter.n(mediaCodecRendererCodecAdapterListener);
        }
    }

    private static final class Api31 {
        private Api31() {
        }

        public static void a(MediaCodecAdapter.Configuration configuration, PlayerId playerId) {
            LogSessionId a2 = playerId.a();
            if (!a2.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                configuration.f6679b.setString("log-session-id", a2.getStringId());
            }
        }
    }

    private final class MediaCodecRendererCodecAdapterListener implements MediaCodecAdapter.OnBufferAvailableListener {
        private MediaCodecRendererCodecAdapterListener() {
        }

        public void a() {
            if (MediaCodecRenderer.this.H != null) {
                MediaCodecRenderer.this.H.b();
            }
        }

        public void b() {
            if (MediaCodecRenderer.this.H != null) {
                MediaCodecRenderer.this.H.b();
            }
        }
    }

    private static final class OutputStreamInfo {

        /* renamed from: e  reason: collision with root package name */
        public static final OutputStreamInfo f6737e = new OutputStreamInfo(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L);

        /* renamed from: a  reason: collision with root package name */
        public final long f6738a;

        /* renamed from: b  reason: collision with root package name */
        public final long f6739b;

        /* renamed from: c  reason: collision with root package name */
        public final long f6740c;

        /* renamed from: d  reason: collision with root package name */
        public final TimedValueQueue<Format> f6741d = new TimedValueQueue<>();

        public OutputStreamInfo(long j2, long j3, long j4) {
            this.f6738a = j2;
            this.f6739b = j3;
            this.f6740c = j4;
        }
    }

    public MediaCodecRenderer(int i2, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, boolean z2, float f2) {
        super(i2);
        this.f6717s = factory;
        this.f6719t = (MediaCodecSelector) Assertions.f(mediaCodecSelector);
        this.f6721u = z2;
        this.f6723v = f2;
        BatchBuffer batchBuffer = new BatchBuffer();
        this.f6730z = batchBuffer;
        this.A = new MediaCodec.BufferInfo();
        this.K = 1.0f;
        this.L = 1.0f;
        this.J = -9223372036854775807L;
        this.B = new ArrayDeque<>();
        this.L0 = OutputStreamInfo.f6737e;
        batchBuffer.f(0);
        batchBuffer.f5067d.order(ByteOrder.nativeOrder());
        this.C = new OggOpusAudioPacketizer();
        this.Q = -1.0f;
        this.U = 0;
        this.f6715q0 = 0;
        this.f6706h0 = -1;
        this.f6707i0 = -1;
        this.f6705g0 = -9223372036854775807L;
        this.f6726w0 = -9223372036854775807L;
        this.f6728x0 = -9223372036854775807L;
        this.M0 = -9223372036854775807L;
        this.f6716r0 = 0;
        this.f6718s0 = 0;
        this.K0 = new DecoderCounters();
    }

    private void B1(DrmSession drmSession) {
        i.a(this.G, drmSession);
        this.G = drmSession;
    }

    private boolean C1(long j2) {
        if (this.J == -9223372036854775807L || G().elapsedRealtime() - j2 < this.J) {
            return true;
        }
        return false;
    }

    protected static boolean H1(Format format) {
        int i2 = format.K;
        return i2 == 0 || i2 == 2;
    }

    private boolean I1(Format format) throws ExoPlaybackException {
        if (!(Util.f4714a < 23 || this.M == null || this.f6718s0 == 3 || getState() == 0)) {
            float E0 = E0(this.L, (Format) Assertions.f(format), M());
            float f2 = this.Q;
            if (f2 == E0) {
                return true;
            }
            if (E0 == -1.0f) {
                r0();
                return false;
            } else if (f2 == -1.0f && E0 <= this.f6723v) {
                return true;
            } else {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", E0);
                ((MediaCodecAdapter) Assertions.f(this.M)).b(bundle);
                this.Q = E0;
            }
        }
        return true;
    }

    private void J1() throws ExoPlaybackException {
        CryptoConfig c2 = ((DrmSession) Assertions.f(this.G)).c();
        if (c2 instanceof FrameworkCryptoConfig) {
            try {
                ((MediaCrypto) Assertions.f(this.I)).setMediaDrmSession(((FrameworkCryptoConfig) c2).f6237b);
            } catch (MediaCryptoException e2) {
                throw E(e2, this.D, 6006);
            }
        }
        x1(this.G);
        this.f6716r0 = 0;
        this.f6718s0 = 0;
    }

    private boolean P0() {
        return this.f6707i0 >= 0;
    }

    private boolean Q0() {
        if (!this.f6730z.p()) {
            return true;
        }
        long K2 = K();
        if (W0(K2, this.f6730z.n()) == W0(K2, this.f6729y.f5069f)) {
            return true;
        }
        return false;
    }

    private void R0(Format format) {
        p0();
        String str = format.f4015n;
        if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
            this.f6730z.q(32);
        } else {
            this.f6730z.q(1);
        }
        this.f6711m0 = true;
    }

    /* JADX INFO: finally extract failed */
    private void S0(MediaCodecInfo mediaCodecInfo, MediaCrypto mediaCrypto) throws Exception {
        float f2;
        boolean z2;
        boolean z3;
        Format format = (Format) Assertions.f(this.D);
        String str = mediaCodecInfo.f6687a;
        int i2 = Util.f4714a;
        float f3 = -1.0f;
        if (i2 < 23) {
            f2 = -1.0f;
        } else {
            f2 = E0(this.L, format, M());
        }
        if (f2 > this.f6723v) {
            f3 = f2;
        }
        l1(format);
        long elapsedRealtime = G().elapsedRealtime();
        MediaCodecAdapter.Configuration J02 = J0(mediaCodecInfo, format, mediaCrypto, f3);
        if (i2 >= 31) {
            Api31.a(J02, L());
        }
        try {
            TraceUtil.a("createCodec:" + str);
            MediaCodecAdapter a2 = this.f6717s.a(J02);
            this.M = a2;
            boolean z4 = false;
            if (i2 < 21 || !Api21.a(a2, new MediaCodecRendererCodecAdapterListener())) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.f6704f0 = z2;
            TraceUtil.b();
            long elapsedRealtime2 = G().elapsedRealtime();
            if (!mediaCodecInfo.m(format)) {
                Log.h("MediaCodecRenderer", Util.G("Format exceeds selected codec's capabilities [%s, %s]", Format.g(format), str));
            }
            this.T = mediaCodecInfo;
            this.Q = f3;
            this.N = format;
            this.U = g0(str);
            this.V = h0(str, (Format) Assertions.f(this.N));
            this.W = m0(str);
            this.X = n0(str);
            this.Y = j0(str);
            this.Z = k0(str);
            this.f6699a0 = i0(str);
            this.f6700b0 = false;
            if (l0(mediaCodecInfo) || D0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f6703e0 = z3;
            if (((MediaCodecAdapter) Assertions.f(this.M)).h()) {
                this.f6714p0 = true;
                this.f6715q0 = 1;
                if (this.U != 0) {
                    z4 = true;
                }
                this.f6701c0 = z4;
            }
            if (getState() == 2) {
                this.f6705g0 = G().elapsedRealtime() + 1000;
            }
            this.K0.f5150a++;
            d1(str, J02, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
        } catch (Throwable th) {
            TraceUtil.b();
            throw th;
        }
    }

    @RequiresNonNull({"this.codecDrmSession"})
    private boolean T0() throws ExoPlaybackException {
        boolean z2;
        if (this.I == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        DrmSession drmSession = this.F;
        CryptoConfig c2 = drmSession.c();
        if (FrameworkCryptoConfig.f6235d && (c2 instanceof FrameworkCryptoConfig)) {
            int state = drmSession.getState();
            if (state == 1) {
                DrmSession.DrmSessionException drmSessionException = (DrmSession.DrmSessionException) Assertions.f(drmSession.getError());
                throw E(drmSessionException, this.D, drmSessionException.f6221b);
            } else if (state != 4) {
                return false;
            }
        }
        if (c2 != null) {
            if (c2 instanceof FrameworkCryptoConfig) {
                FrameworkCryptoConfig frameworkCryptoConfig = (FrameworkCryptoConfig) c2;
                try {
                    this.I = new MediaCrypto(frameworkCryptoConfig.f6236a, frameworkCryptoConfig.f6237b);
                } catch (MediaCryptoException e2) {
                    throw E(e2, this.D, 6006);
                }
            }
            return true;
        } else if (drmSession.getError() != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean W0(long j2, long j3) {
        Format format;
        if (j3 >= j2 || ((format = this.E) != null && Objects.equals(format.f4015n, "audio/opus") && OpusUtil.g(j2, j3))) {
            return false;
        }
        return true;
    }

    private static boolean X0(IllegalStateException illegalStateException) {
        if (Util.f4714a >= 21 && Y0(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        if (stackTrace.length <= 0 || !stackTrace[0].getClassName().equals("android.media.MediaCodec")) {
            return false;
        }
        return true;
    }

    private static boolean Y0(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    private static boolean Z0(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    private void b1(MediaCrypto mediaCrypto, boolean z2) throws DecoderInitializationException {
        Format format = (Format) Assertions.f(this.D);
        if (this.R == null) {
            try {
                List<MediaCodecInfo> z02 = z0(z2);
                ArrayDeque<MediaCodecInfo> arrayDeque = new ArrayDeque<>();
                this.R = arrayDeque;
                if (this.f6721u) {
                    arrayDeque.addAll(z02);
                } else if (!z02.isEmpty()) {
                    this.R.add(z02.get(0));
                }
                this.S = null;
            } catch (MediaCodecUtil.DecoderQueryException e2) {
                throw new DecoderInitializationException(format, (Throwable) e2, z2, -49998);
            }
        }
        if (!this.R.isEmpty()) {
            ArrayDeque arrayDeque2 = (ArrayDeque) Assertions.f(this.R);
            while (this.M == null) {
                MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) Assertions.f((MediaCodecInfo) arrayDeque2.peekFirst());
                if (D1(mediaCodecInfo)) {
                    try {
                        S0(mediaCodecInfo, mediaCrypto);
                    } catch (Exception e3) {
                        Log.i("MediaCodecRenderer", "Failed to initialize decoder: " + mediaCodecInfo, e3);
                        arrayDeque2.removeFirst();
                        DecoderInitializationException decoderInitializationException = new DecoderInitializationException(format, (Throwable) e3, z2, mediaCodecInfo);
                        c1(decoderInitializationException);
                        if (this.S == null) {
                            this.S = decoderInitializationException;
                        } else {
                            this.S = this.S.c(decoderInitializationException);
                        }
                        if (arrayDeque2.isEmpty()) {
                            throw this.S;
                        }
                    }
                } else {
                    return;
                }
            }
            this.R = null;
            return;
        }
        throw new DecoderInitializationException(format, (Throwable) null, z2, -49999);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0105 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d0() throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r8 = this;
            boolean r0 = r8.F0
            r1 = 1
            r0 = r0 ^ r1
            androidx.media3.common.util.Assertions.h(r0)
            androidx.media3.exoplayer.FormatHolder r0 = r8.I()
            androidx.media3.decoder.DecoderInputBuffer r2 = r8.f6729y
            r2.clear()
        L_0x0010:
            androidx.media3.decoder.DecoderInputBuffer r2 = r8.f6729y
            r2.clear()
            androidx.media3.decoder.DecoderInputBuffer r2 = r8.f6729y
            r3 = 0
            int r2 = r8.Z(r0, r2, r3)
            r4 = -5
            if (r2 == r4) goto L_0x0105
            r4 = -4
            if (r2 == r4) goto L_0x0036
            r0 = -3
            if (r2 != r0) goto L_0x0030
            boolean r0 = r8.g()
            if (r0 == 0) goto L_0x002f
            long r0 = r8.f6726w0
            r8.f6728x0 = r0
        L_0x002f:
            return
        L_0x0030:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x0036:
            androidx.media3.decoder.DecoderInputBuffer r2 = r8.f6729y
            boolean r2 = r2.isEndOfStream()
            if (r2 == 0) goto L_0x0045
            r8.F0 = r1
            long r0 = r8.f6726w0
            r8.f6728x0 = r0
            return
        L_0x0045:
            long r4 = r8.f6726w0
            androidx.media3.decoder.DecoderInputBuffer r2 = r8.f6729y
            long r6 = r2.f5069f
            long r4 = java.lang.Math.max(r4, r6)
            r8.f6726w0 = r4
            boolean r2 = r8.g()
            if (r2 != 0) goto L_0x005f
            androidx.media3.decoder.DecoderInputBuffer r2 = r8.f6727x
            boolean r2 = r2.isLastSample()
            if (r2 == 0) goto L_0x0063
        L_0x005f:
            long r4 = r8.f6726w0
            r8.f6728x0 = r4
        L_0x0063:
            boolean r2 = r8.H0
            java.lang.String r4 = "audio/opus"
            if (r2 == 0) goto L_0x00b1
            androidx.media3.common.Format r2 = r8.D
            java.lang.Object r2 = androidx.media3.common.util.Assertions.f(r2)
            androidx.media3.common.Format r2 = (androidx.media3.common.Format) r2
            r8.E = r2
            java.lang.String r2 = r2.f4015n
            boolean r2 = java.util.Objects.equals(r2, r4)
            if (r2 == 0) goto L_0x00a9
            androidx.media3.common.Format r2 = r8.E
            java.util.List<byte[]> r2 = r2.f4018q
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x00a9
            androidx.media3.common.Format r2 = r8.E
            java.util.List<byte[]> r2 = r2.f4018q
            java.lang.Object r2 = r2.get(r3)
            byte[] r2 = (byte[]) r2
            int r2 = androidx.media3.extractor.OpusUtil.f(r2)
            androidx.media3.common.Format r5 = r8.E
            java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r5)
            androidx.media3.common.Format r5 = (androidx.media3.common.Format) r5
            androidx.media3.common.Format$Builder r5 = r5.a()
            androidx.media3.common.Format$Builder r2 = r5.V(r2)
            androidx.media3.common.Format r2 = r2.K()
            r8.E = r2
        L_0x00a9:
            androidx.media3.common.Format r2 = r8.E
            r5 = 0
            r8.g1(r2, r5)
            r8.H0 = r3
        L_0x00b1:
            androidx.media3.decoder.DecoderInputBuffer r2 = r8.f6729y
            r2.g()
            androidx.media3.common.Format r2 = r8.E
            if (r2 == 0) goto L_0x00f2
            java.lang.String r2 = r2.f4015n
            boolean r2 = java.util.Objects.equals(r2, r4)
            if (r2 == 0) goto L_0x00f2
            androidx.media3.decoder.DecoderInputBuffer r2 = r8.f6729y
            boolean r2 = r2.hasSupplementalData()
            if (r2 == 0) goto L_0x00d3
            androidx.media3.decoder.DecoderInputBuffer r2 = r8.f6729y
            androidx.media3.common.Format r3 = r8.E
            r2.f5065b = r3
            r8.O0(r2)
        L_0x00d3:
            long r2 = r8.K()
            androidx.media3.decoder.DecoderInputBuffer r4 = r8.f6729y
            long r4 = r4.f5069f
            boolean r2 = androidx.media3.extractor.OpusUtil.g(r2, r4)
            if (r2 == 0) goto L_0x00f2
            androidx.media3.exoplayer.audio.OggOpusAudioPacketizer r2 = r8.C
            androidx.media3.decoder.DecoderInputBuffer r3 = r8.f6729y
            androidx.media3.common.Format r4 = r8.E
            java.lang.Object r4 = androidx.media3.common.util.Assertions.f(r4)
            androidx.media3.common.Format r4 = (androidx.media3.common.Format) r4
            java.util.List<byte[]> r4 = r4.f4018q
            r2.a(r3, r4)
        L_0x00f2:
            boolean r2 = r8.Q0()
            if (r2 == 0) goto L_0x0102
            androidx.media3.exoplayer.mediacodec.BatchBuffer r2 = r8.f6730z
            androidx.media3.decoder.DecoderInputBuffer r3 = r8.f6729y
            boolean r2 = r2.k(r3)
            if (r2 != 0) goto L_0x0010
        L_0x0102:
            r8.f6712n0 = r1
            return
        L_0x0105:
            r8.f1(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.d0():void");
    }

    private boolean e0(long j2, long j3) throws ExoPlaybackException {
        Assertions.h(!this.G0);
        if (this.f6730z.p()) {
            BatchBuffer batchBuffer = this.f6730z;
            if (!n1(j2, j3, (MediaCodecAdapter) null, batchBuffer.f5067d, this.f6707i0, 0, batchBuffer.o(), this.f6730z.m(), W0(K(), this.f6730z.n()), this.f6730z.isEndOfStream(), (Format) Assertions.f(this.E))) {
                return false;
            }
            i1(this.f6730z.n());
            this.f6730z.clear();
        }
        if (this.F0) {
            this.G0 = true;
            return false;
        }
        if (this.f6712n0) {
            Assertions.h(this.f6730z.k(this.f6729y));
            this.f6712n0 = false;
        }
        if (this.f6713o0) {
            if (this.f6730z.p()) {
                return true;
            }
            p0();
            this.f6713o0 = false;
            a1();
            if (!this.f6711m0) {
                return false;
            }
        }
        d0();
        if (this.f6730z.p()) {
            this.f6730z.g();
        }
        if (this.f6730z.p() || this.F0 || this.f6713o0) {
            return true;
        }
        return false;
    }

    private int g0(String str) {
        int i2 = Util.f4714a;
        if (i2 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = Util.f4717d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i2 >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = Util.f4715b;
        if ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) {
            return 1;
        }
        return 0;
    }

    private static boolean h0(String str, Format format) {
        if (Util.f4714a >= 21 || !format.f4018q.isEmpty() || !"OMX.MTK.VIDEO.DECODER.AVC".equals(str)) {
            return false;
        }
        return true;
    }

    private static boolean i0(String str) {
        if (Util.f4714a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(Util.f4716c)) {
            String str2 = Util.f4715b;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    private static boolean j0(String str) {
        int i2 = Util.f4714a;
        if (i2 > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i2 == 19) {
                String str2 = Util.f4715b;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private static boolean k0(String str) {
        return Util.f4714a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean l0(MediaCodecInfo mediaCodecInfo) {
        String str = mediaCodecInfo.f6687a;
        int i2 = Util.f4714a;
        if ((i2 > 25 || !"OMX.rk.video_decoder.avc".equals(str)) && ((i2 > 29 || (!"OMX.broadcom.video_decoder.tunnel".equals(str) && !"OMX.broadcom.video_decoder.tunnel.secure".equals(str) && !"OMX.bcm.vdec.avc.tunnel".equals(str) && !"OMX.bcm.vdec.avc.tunnel.secure".equals(str) && !"OMX.bcm.vdec.hevc.tunnel".equals(str) && !"OMX.bcm.vdec.hevc.tunnel.secure".equals(str))) && (!"Amazon".equals(Util.f4716c) || !"AFTS".equals(Util.f4717d) || !mediaCodecInfo.f6693g))) {
            return false;
        }
        return true;
    }

    private static boolean m0(String str) {
        if (Util.f4714a != 19 || !Util.f4717d.startsWith("SM-G800") || (!"OMX.Exynos.avc.dec".equals(str) && !"OMX.Exynos.avc.dec.secure".equals(str))) {
            return false;
        }
        return true;
    }

    @TargetApi(23)
    private void m1() throws ExoPlaybackException {
        int i2 = this.f6718s0;
        if (i2 == 1) {
            w0();
        } else if (i2 == 2) {
            w0();
            J1();
        } else if (i2 != 3) {
            this.G0 = true;
            s1();
        } else {
            q1();
        }
    }

    private static boolean n0(String str) {
        return Util.f4714a == 29 && "c2.android.aac.decoder".equals(str);
    }

    private void o1() {
        this.f6724v0 = true;
        MediaFormat c2 = ((MediaCodecAdapter) Assertions.f(this.M)).c();
        if (this.U != 0 && c2.getInteger("width") == 32 && c2.getInteger("height") == 32) {
            this.f6702d0 = true;
            return;
        }
        if (this.f6700b0) {
            c2.setInteger("channel-count", 1);
        }
        this.O = c2;
        this.P = true;
    }

    private void p0() {
        this.f6713o0 = false;
        this.f6730z.clear();
        this.f6729y.clear();
        this.f6712n0 = false;
        this.f6711m0 = false;
        this.C.d();
    }

    private boolean p1(int i2) throws ExoPlaybackException {
        FormatHolder I2 = I();
        this.f6725w.clear();
        int Z2 = Z(I2, this.f6725w, i2 | 4);
        if (Z2 == -5) {
            f1(I2);
            return true;
        } else if (Z2 != -4 || !this.f6725w.isEndOfStream()) {
            return false;
        } else {
            this.F0 = true;
            m1();
            return false;
        }
    }

    private boolean q0() {
        if (this.f6720t0) {
            this.f6716r0 = 1;
            if (this.W || this.Y) {
                this.f6718s0 = 3;
                return false;
            }
            this.f6718s0 = 1;
        }
        return true;
    }

    private void q1() throws ExoPlaybackException {
        r1();
        a1();
    }

    private void r0() throws ExoPlaybackException {
        if (this.f6720t0) {
            this.f6716r0 = 1;
            this.f6718s0 = 3;
            return;
        }
        q1();
    }

    @TargetApi(23)
    private boolean s0() throws ExoPlaybackException {
        if (this.f6720t0) {
            this.f6716r0 = 1;
            if (this.W || this.Y) {
                this.f6718s0 = 3;
                return false;
            }
            this.f6718s0 = 2;
        } else {
            J1();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean t0(long r20, long r22) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r19 = this;
            r15 = r19
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter r0 = r15.M
            java.lang.Object r0 = androidx.media3.common.util.Assertions.f(r0)
            r5 = r0
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter r5 = (androidx.media3.exoplayer.mediacodec.MediaCodecAdapter) r5
            boolean r0 = r19.P0()
            r16 = 1
            r14 = 0
            if (r0 != 0) goto L_0x00d4
            boolean r0 = r15.Z
            if (r0 == 0) goto L_0x002f
            boolean r0 = r15.f6722u0
            if (r0 == 0) goto L_0x002f
            android.media.MediaCodec$BufferInfo r0 = r15.A     // Catch:{ IllegalStateException -> 0x0023 }
            int r0 = r5.k(r0)     // Catch:{ IllegalStateException -> 0x0023 }
            goto L_0x0035
        L_0x0023:
            r19.m1()
            boolean r0 = r15.G0
            if (r0 == 0) goto L_0x002e
            r19.r1()
        L_0x002e:
            return r14
        L_0x002f:
            android.media.MediaCodec$BufferInfo r0 = r15.A
            int r0 = r5.k(r0)
        L_0x0035:
            if (r0 >= 0) goto L_0x004f
            r1 = -2
            if (r0 != r1) goto L_0x003e
            r19.o1()
            return r16
        L_0x003e:
            boolean r0 = r15.f6703e0
            if (r0 == 0) goto L_0x004e
            boolean r0 = r15.F0
            if (r0 != 0) goto L_0x004b
            int r0 = r15.f6716r0
            r1 = 2
            if (r0 != r1) goto L_0x004e
        L_0x004b:
            r19.m1()
        L_0x004e:
            return r14
        L_0x004f:
            boolean r1 = r15.f6702d0
            if (r1 == 0) goto L_0x0059
            r15.f6702d0 = r14
            r5.l(r0, r14)
            return r16
        L_0x0059:
            android.media.MediaCodec$BufferInfo r1 = r15.A
            int r2 = r1.size
            if (r2 != 0) goto L_0x0069
            int r1 = r1.flags
            r1 = r1 & 4
            if (r1 == 0) goto L_0x0069
            r19.m1()
            return r14
        L_0x0069:
            r15.f6707i0 = r0
            java.nio.ByteBuffer r0 = r5.m(r0)
            r15.f6708j0 = r0
            if (r0 == 0) goto L_0x0086
            android.media.MediaCodec$BufferInfo r1 = r15.A
            int r1 = r1.offset
            r0.position(r1)
            java.nio.ByteBuffer r0 = r15.f6708j0
            android.media.MediaCodec$BufferInfo r1 = r15.A
            int r2 = r1.offset
            int r1 = r1.size
            int r2 = r2 + r1
            r0.limit(r2)
        L_0x0086:
            boolean r0 = r15.f6699a0
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L_0x00a9
            android.media.MediaCodec$BufferInfo r0 = r15.A
            long r3 = r0.presentationTimeUs
            r6 = 0
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x00a9
            int r3 = r0.flags
            r3 = r3 & 4
            if (r3 == 0) goto L_0x00a9
            long r3 = r15.f6726w0
            int r6 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r6 == 0) goto L_0x00a9
            long r3 = r15.f6728x0
            r0.presentationTimeUs = r3
        L_0x00a9:
            android.media.MediaCodec$BufferInfo r0 = r15.A
            long r3 = r0.presentationTimeUs
            long r6 = r19.K()
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x00b7
            r0 = 1
            goto L_0x00b8
        L_0x00b7:
            r0 = 0
        L_0x00b8:
            r15.f6709k0 = r0
            long r3 = r15.f6728x0
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00ca
            android.media.MediaCodec$BufferInfo r0 = r15.A
            long r0 = r0.presentationTimeUs
            int r2 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ca
            r0 = 1
            goto L_0x00cb
        L_0x00ca:
            r0 = 0
        L_0x00cb:
            r15.f6710l0 = r0
            android.media.MediaCodec$BufferInfo r0 = r15.A
            long r0 = r0.presentationTimeUs
            r15.K1(r0)
        L_0x00d4:
            boolean r0 = r15.Z
            if (r0 == 0) goto L_0x0112
            boolean r0 = r15.f6722u0
            if (r0 == 0) goto L_0x0112
            java.nio.ByteBuffer r6 = r15.f6708j0     // Catch:{ IllegalStateException -> 0x0104 }
            int r7 = r15.f6707i0     // Catch:{ IllegalStateException -> 0x0104 }
            android.media.MediaCodec$BufferInfo r0 = r15.A     // Catch:{ IllegalStateException -> 0x0104 }
            int r8 = r0.flags     // Catch:{ IllegalStateException -> 0x0104 }
            r9 = 1
            long r10 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0104 }
            boolean r12 = r15.f6709k0     // Catch:{ IllegalStateException -> 0x0104 }
            boolean r13 = r15.f6710l0     // Catch:{ IllegalStateException -> 0x0104 }
            androidx.media3.common.Format r0 = r15.E     // Catch:{ IllegalStateException -> 0x0104 }
            java.lang.Object r0 = androidx.media3.common.util.Assertions.f(r0)     // Catch:{ IllegalStateException -> 0x0104 }
            r17 = r0
            androidx.media3.common.Format r17 = (androidx.media3.common.Format) r17     // Catch:{ IllegalStateException -> 0x0104 }
            r0 = r19
            r1 = r20
            r3 = r22
            r18 = 0
            r14 = r17
            boolean r0 = r0.n1(r1, r3, r5, r6, r7, r8, r9, r10, r12, r13, r14)     // Catch:{ IllegalStateException -> 0x0106 }
            goto L_0x0136
        L_0x0104:
            r18 = 0
        L_0x0106:
            r19.m1()
            boolean r0 = r15.G0
            if (r0 == 0) goto L_0x0111
            r19.r1()
        L_0x0111:
            return r18
        L_0x0112:
            r18 = 0
            java.nio.ByteBuffer r6 = r15.f6708j0
            int r7 = r15.f6707i0
            android.media.MediaCodec$BufferInfo r0 = r15.A
            int r8 = r0.flags
            r9 = 1
            long r10 = r0.presentationTimeUs
            boolean r12 = r15.f6709k0
            boolean r13 = r15.f6710l0
            androidx.media3.common.Format r0 = r15.E
            java.lang.Object r0 = androidx.media3.common.util.Assertions.f(r0)
            r14 = r0
            androidx.media3.common.Format r14 = (androidx.media3.common.Format) r14
            r0 = r19
            r1 = r20
            r3 = r22
            boolean r0 = r0.n1(r1, r3, r5, r6, r7, r8, r9, r10, r12, r13, r14)
        L_0x0136:
            if (r0 == 0) goto L_0x0153
            android.media.MediaCodec$BufferInfo r0 = r15.A
            long r0 = r0.presentationTimeUs
            r15.i1(r0)
            android.media.MediaCodec$BufferInfo r0 = r15.A
            int r0 = r0.flags
            r0 = r0 & 4
            if (r0 == 0) goto L_0x0149
            r14 = 1
            goto L_0x014a
        L_0x0149:
            r14 = 0
        L_0x014a:
            r19.w1()
            if (r14 != 0) goto L_0x0150
            return r16
        L_0x0150:
            r19.m1()
        L_0x0153:
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.t0(long, long):boolean");
    }

    private boolean u0(MediaCodecInfo mediaCodecInfo, Format format, DrmSession drmSession, DrmSession drmSession2) throws ExoPlaybackException {
        CryptoConfig c2;
        CryptoConfig c3;
        if (drmSession == drmSession2) {
            return false;
        }
        if (!(drmSession2 == null || drmSession == null || (c2 = drmSession2.c()) == null || (c3 = drmSession.c()) == null || !c2.getClass().equals(c3.getClass()))) {
            if (!(c2 instanceof FrameworkCryptoConfig)) {
                return false;
            }
            if (!drmSession2.a().equals(drmSession.a()) || Util.f4714a < 23) {
                return true;
            }
            UUID uuid = C.f3934e;
            if (!uuid.equals(drmSession.a()) && !uuid.equals(drmSession2.a())) {
                if (mediaCodecInfo.f6693g || !drmSession2.e((String) Assertions.f(format.f4015n))) {
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    private boolean v0() throws ExoPlaybackException {
        int i2;
        if (this.M == null || (i2 = this.f6716r0) == 2 || this.F0) {
            return false;
        }
        if (i2 == 0 && E1()) {
            r0();
        }
        MediaCodecAdapter mediaCodecAdapter = (MediaCodecAdapter) Assertions.f(this.M);
        if (this.f6706h0 < 0) {
            int j2 = mediaCodecAdapter.j();
            this.f6706h0 = j2;
            if (j2 < 0) {
                return false;
            }
            this.f6727x.f5067d = mediaCodecAdapter.e(j2);
            this.f6727x.clear();
        }
        if (this.f6716r0 == 1) {
            if (!this.f6703e0) {
                this.f6722u0 = true;
                mediaCodecAdapter.a(this.f6706h0, 0, 0, 0, 4);
                v1();
            }
            this.f6716r0 = 2;
            return false;
        } else if (this.f6701c0) {
            this.f6701c0 = false;
            byte[] bArr = O0;
            ((ByteBuffer) Assertions.f(this.f6727x.f5067d)).put(bArr);
            mediaCodecAdapter.a(this.f6706h0, 0, bArr.length, 0, 0);
            v1();
            this.f6720t0 = true;
            return true;
        } else {
            if (this.f6715q0 == 1) {
                for (int i3 = 0; i3 < ((Format) Assertions.f(this.N)).f4018q.size(); i3++) {
                    ((ByteBuffer) Assertions.f(this.f6727x.f5067d)).put(this.N.f4018q.get(i3));
                }
                this.f6715q0 = 2;
            }
            int position = ((ByteBuffer) Assertions.f(this.f6727x.f5067d)).position();
            FormatHolder I2 = I();
            try {
                int Z2 = Z(I2, this.f6727x, 0);
                if (Z2 == -3) {
                    if (g()) {
                        this.f6728x0 = this.f6726w0;
                    }
                    return false;
                } else if (Z2 == -5) {
                    if (this.f6715q0 == 2) {
                        this.f6727x.clear();
                        this.f6715q0 = 1;
                    }
                    f1(I2);
                    return true;
                } else if (this.f6727x.isEndOfStream()) {
                    this.f6728x0 = this.f6726w0;
                    if (this.f6715q0 == 2) {
                        this.f6727x.clear();
                        this.f6715q0 = 1;
                    }
                    this.F0 = true;
                    if (!this.f6720t0) {
                        m1();
                        return false;
                    }
                    try {
                        if (!this.f6703e0) {
                            this.f6722u0 = true;
                            mediaCodecAdapter.a(this.f6706h0, 0, 0, 0, 4);
                            v1();
                        }
                        return false;
                    } catch (MediaCodec.CryptoException e2) {
                        throw E(e2, this.D, Util.Y(e2.getErrorCode()));
                    }
                } else if (this.f6720t0 || this.f6727x.isKeyFrame()) {
                    boolean h2 = this.f6727x.h();
                    if (h2) {
                        this.f6727x.f5066c.b(position);
                    }
                    if (this.V && !h2) {
                        NalUnitUtil.b((ByteBuffer) Assertions.f(this.f6727x.f5067d));
                        if (((ByteBuffer) Assertions.f(this.f6727x.f5067d)).position() == 0) {
                            return true;
                        }
                        this.V = false;
                    }
                    long j3 = this.f6727x.f5069f;
                    if (this.H0) {
                        if (!this.B.isEmpty()) {
                            this.B.peekLast().f6741d.a(j3, (Format) Assertions.f(this.D));
                        } else {
                            this.L0.f6741d.a(j3, (Format) Assertions.f(this.D));
                        }
                        this.H0 = false;
                    }
                    this.f6726w0 = Math.max(this.f6726w0, j3);
                    if (g() || this.f6727x.isLastSample()) {
                        this.f6728x0 = this.f6726w0;
                    }
                    this.f6727x.g();
                    if (this.f6727x.hasSupplementalData()) {
                        O0(this.f6727x);
                    }
                    k1(this.f6727x);
                    int B0 = B0(this.f6727x);
                    if (h2) {
                        try {
                            ((MediaCodecAdapter) Assertions.f(mediaCodecAdapter)).g(this.f6706h0, 0, this.f6727x.f5066c, j3, B0);
                        } catch (MediaCodec.CryptoException e3) {
                            throw E(e3, this.D, Util.Y(e3.getErrorCode()));
                        }
                    } else {
                        ((MediaCodecAdapter) Assertions.f(mediaCodecAdapter)).a(this.f6706h0, 0, ((ByteBuffer) Assertions.f(this.f6727x.f5067d)).limit(), j3, B0);
                    }
                    v1();
                    this.f6720t0 = true;
                    this.f6715q0 = 0;
                    this.K0.f5152c++;
                    return true;
                } else {
                    this.f6727x.clear();
                    if (this.f6715q0 == 2) {
                        this.f6715q0 = 1;
                    }
                    return true;
                }
            } catch (DecoderInputBuffer.InsufficientCapacityException e4) {
                c1(e4);
                p1(0);
                w0();
                return true;
            }
        }
    }

    private void v1() {
        this.f6706h0 = -1;
        this.f6727x.f5067d = null;
    }

    private void w0() {
        try {
            ((MediaCodecAdapter) Assertions.j(this.M)).flush();
        } finally {
            t1();
        }
    }

    private void w1() {
        this.f6707i0 = -1;
        this.f6708j0 = null;
    }

    private void x1(DrmSession drmSession) {
        i.a(this.F, drmSession);
        this.F = drmSession;
    }

    private void y1(OutputStreamInfo outputStreamInfo) {
        this.L0 = outputStreamInfo;
        long j2 = outputStreamInfo.f6740c;
        if (j2 != -9223372036854775807L) {
            this.N0 = true;
            h1(j2);
        }
    }

    private List<MediaCodecInfo> z0(boolean z2) throws MediaCodecUtil.DecoderQueryException {
        Format format = (Format) Assertions.f(this.D);
        List<MediaCodecInfo> G02 = G0(this.f6719t, format, z2);
        if (G02.isEmpty() && z2) {
            G02 = G0(this.f6719t, format, false);
            if (!G02.isEmpty()) {
                Log.h("MediaCodecRenderer", "Drm session requires secure decoder for " + format.f4015n + ", but no secure decoder available. Trying to proceed with " + G02 + ".");
            }
        }
        return G02;
    }

    public final long A(long j2, long j3) {
        return H0(this.f6704f0, j2, j3);
    }

    /* access modifiers changed from: protected */
    public final MediaCodecAdapter A0() {
        return this.M;
    }

    /* access modifiers changed from: protected */
    public final void A1(ExoPlaybackException exoPlaybackException) {
        this.J0 = exoPlaybackException;
    }

    /* access modifiers changed from: protected */
    public int B0(DecoderInputBuffer decoderInputBuffer) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final MediaCodecInfo C0() {
        return this.T;
    }

    /* access modifiers changed from: protected */
    public boolean D0() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean D1(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract float E0(float f2, Format format, Format[] formatArr);

    /* access modifiers changed from: protected */
    public boolean E1() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final MediaFormat F0() {
        return this.O;
    }

    /* access modifiers changed from: protected */
    public boolean F1(Format format) {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract List<MediaCodecInfo> G0(MediaCodecSelector mediaCodecSelector, Format format, boolean z2) throws MediaCodecUtil.DecoderQueryException;

    /* access modifiers changed from: protected */
    public abstract int G1(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException;

    /* access modifiers changed from: protected */
    public long H0(boolean z2, long j2, long j3) {
        return super.A(j2, j3);
    }

    /* access modifiers changed from: protected */
    public long I0() {
        return this.f6728x0;
    }

    /* access modifiers changed from: protected */
    public abstract MediaCodecAdapter.Configuration J0(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f2);

    /* access modifiers changed from: protected */
    public final long K0() {
        return this.L0.f6740c;
    }

    /* access modifiers changed from: protected */
    public final void K1(long j2) throws ExoPlaybackException {
        boolean z2;
        Format j3 = this.L0.f6741d.j(j2);
        if (j3 == null && this.N0 && this.O != null) {
            j3 = this.L0.f6741d.i();
        }
        if (j3 != null) {
            this.E = j3;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || (this.P && this.E != null)) {
            g1((Format) Assertions.f(this.E), this.O);
            this.P = false;
            this.N0 = false;
        }
    }

    /* access modifiers changed from: protected */
    public final long L0() {
        return this.L0.f6739b;
    }

    /* access modifiers changed from: protected */
    public float M0() {
        return this.K;
    }

    /* access modifiers changed from: protected */
    public final Renderer.WakeupListener N0() {
        return this.H;
    }

    /* access modifiers changed from: protected */
    public void O() {
        this.D = null;
        y1(OutputStreamInfo.f6737e);
        this.B.clear();
        y0();
    }

    /* access modifiers changed from: protected */
    public abstract void O0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    public void P(boolean z2, boolean z3) throws ExoPlaybackException {
        this.K0 = new DecoderCounters();
    }

    /* access modifiers changed from: protected */
    public void R(long j2, boolean z2) throws ExoPlaybackException {
        this.F0 = false;
        this.G0 = false;
        this.I0 = false;
        if (this.f6711m0) {
            this.f6730z.clear();
            this.f6729y.clear();
            this.f6712n0 = false;
            this.C.d();
        } else {
            x0();
        }
        if (this.L0.f6741d.l() > 0) {
            this.H0 = true;
        }
        this.L0.f6741d.c();
        this.B.clear();
    }

    /* access modifiers changed from: protected */
    public void U() {
        try {
            p0();
            r1();
        } finally {
            B1((DrmSession) null);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean U0() {
        return this.f6711m0;
    }

    /* access modifiers changed from: protected */
    public void V() {
    }

    /* access modifiers changed from: protected */
    public final boolean V0(Format format) {
        return this.G == null && F1(format);
    }

    /* access modifiers changed from: protected */
    public void W() {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        if (r5 >= r1) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void X(androidx.media3.common.Format[] r16, long r17, long r19, androidx.media3.exoplayer.source.MediaSource.MediaPeriodId r21) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r15 = this;
            r0 = r15
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r1 = r0.L0
            long r1 = r1.f6740c
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0021
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r1 = new androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = r1
            r9 = r17
            r11 = r19
            r6.<init>(r7, r9, r11)
            r15.y1(r1)
            goto L_0x0068
        L_0x0021:
            java.util.ArrayDeque<androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo> r1 = r0.B
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0057
            long r1 = r0.f6726w0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0039
            long r5 = r0.M0
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x0057
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 < 0) goto L_0x0057
        L_0x0039:
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r1 = new androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = r1
            r11 = r17
            r13 = r19
            r8.<init>(r9, r11, r13)
            r15.y1(r1)
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r1 = r0.L0
            long r1 = r1.f6740c
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0068
            r15.j1()
            goto L_0x0068
        L_0x0057:
            java.util.ArrayDeque<androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo> r1 = r0.B
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r9 = new androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo
            long r3 = r0.f6726w0
            r2 = r9
            r5 = r17
            r7 = r19
            r2.<init>(r3, r5, r7)
            r1.add(r9)
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.X(androidx.media3.common.Format[], long, long, androidx.media3.exoplayer.source.MediaSource$MediaPeriodId):void");
    }

    public boolean a() {
        return this.G0;
    }

    /* access modifiers changed from: protected */
    public final void a1() throws ExoPlaybackException {
        Format format;
        boolean z2;
        if (this.M == null && !this.f6711m0 && (format = this.D) != null) {
            if (V0(format)) {
                R0(format);
                return;
            }
            x1(this.G);
            if (this.F == null || T0()) {
                try {
                    DrmSession drmSession = this.F;
                    if (drmSession == null || !drmSession.e((String) Assertions.j(format.f4015n))) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    b1(this.I, z2);
                } catch (DecoderInitializationException e2) {
                    throw E(e2, format, 4001);
                }
            }
            MediaCrypto mediaCrypto = this.I;
            if (mediaCrypto != null && this.M == null) {
                mediaCrypto.release();
                this.I = null;
            }
        }
    }

    public final int c(Format format) throws ExoPlaybackException {
        try {
            return G1(this.f6719t, format);
        } catch (MediaCodecUtil.DecoderQueryException e2) {
            throw E(e2, format, 4002);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void c1(Exception exc);

    /* access modifiers changed from: protected */
    public abstract void d1(String str, MediaCodecAdapter.Configuration configuration, long j2, long j3);

    /* access modifiers changed from: protected */
    public abstract void e1(String str);

    public void f(long j2, long j3) throws ExoPlaybackException {
        int i2;
        boolean z2 = false;
        if (this.I0) {
            this.I0 = false;
            m1();
        }
        ExoPlaybackException exoPlaybackException = this.J0;
        if (exoPlaybackException == null) {
            try {
                if (this.G0) {
                    s1();
                } else if (this.D != null || p1(2)) {
                    a1();
                    if (this.f6711m0) {
                        TraceUtil.a("bypassRender");
                        while (e0(j2, j3)) {
                        }
                        TraceUtil.b();
                    } else if (this.M != null) {
                        long elapsedRealtime = G().elapsedRealtime();
                        TraceUtil.a("drainAndFeed");
                        while (t0(j2, j3) && C1(elapsedRealtime)) {
                        }
                        while (v0() && C1(elapsedRealtime)) {
                        }
                        TraceUtil.b();
                    } else {
                        this.K0.f5153d += b0(j2);
                        p1(1);
                    }
                    this.K0.c();
                }
            } catch (IllegalStateException e2) {
                if (X0(e2)) {
                    c1(e2);
                    if (Util.f4714a >= 21 && Z0(e2)) {
                        z2 = true;
                    }
                    if (z2) {
                        r1();
                    }
                    MediaCodecDecoderException o02 = o0(e2, C0());
                    if (o02.f6686d == 1101) {
                        i2 = 4006;
                    } else {
                        i2 = 4003;
                    }
                    throw F(o02, this.D, z2, i2);
                }
                throw e2;
            }
        } else {
            this.J0 = null;
            throw exoPlaybackException;
        }
    }

    /* access modifiers changed from: protected */
    public abstract DecoderReuseEvaluation f0(MediaCodecInfo mediaCodecInfo, Format format, Format format2);

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a9, code lost:
        if (s0() == false) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00db, code lost:
        if (s0() == false) goto L_0x00f6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0112 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.exoplayer.DecoderReuseEvaluation f1(androidx.media3.exoplayer.FormatHolder r12) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r11 = this;
            r0 = 1
            r11.H0 = r0
            androidx.media3.common.Format r1 = r12.f5385b
            java.lang.Object r1 = androidx.media3.common.util.Assertions.f(r1)
            androidx.media3.common.Format r1 = (androidx.media3.common.Format) r1
            java.lang.String r2 = r1.f4015n
            if (r2 == 0) goto L_0x0113
            java.lang.String r3 = "video/av01"
            boolean r2 = java.util.Objects.equals(r2, r3)
            r3 = 0
            if (r2 == 0) goto L_0x002c
            java.util.List<byte[]> r2 = r1.f4018q
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x002c
            androidx.media3.common.Format$Builder r1 = r1.a()
            androidx.media3.common.Format$Builder r1 = r1.b0(r3)
            androidx.media3.common.Format r1 = r1.K()
        L_0x002c:
            r7 = r1
            androidx.media3.exoplayer.drm.DrmSession r12 = r12.f5384a
            r11.B1(r12)
            r11.D = r7
            boolean r12 = r11.f6711m0
            if (r12 == 0) goto L_0x003b
            r11.f6713o0 = r0
            return r3
        L_0x003b:
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter r12 = r11.M
            if (r12 != 0) goto L_0x0045
            r11.R = r3
            r11.a1()
            return r3
        L_0x0045:
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r1 = r11.T
            java.lang.Object r1 = androidx.media3.common.util.Assertions.f(r1)
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r1 = (androidx.media3.exoplayer.mediacodec.MediaCodecInfo) r1
            androidx.media3.common.Format r2 = r11.N
            java.lang.Object r2 = androidx.media3.common.util.Assertions.f(r2)
            r6 = r2
            androidx.media3.common.Format r6 = (androidx.media3.common.Format) r6
            androidx.media3.exoplayer.drm.DrmSession r2 = r11.F
            androidx.media3.exoplayer.drm.DrmSession r3 = r11.G
            boolean r2 = r11.u0(r1, r7, r2, r3)
            if (r2 == 0) goto L_0x006f
            r11.r0()
            androidx.media3.exoplayer.DecoderReuseEvaluation r12 = new androidx.media3.exoplayer.DecoderReuseEvaluation
            java.lang.String r5 = r1.f6687a
            r8 = 0
            r9 = 128(0x80, float:1.794E-43)
            r4 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            return r12
        L_0x006f:
            androidx.media3.exoplayer.drm.DrmSession r2 = r11.G
            androidx.media3.exoplayer.drm.DrmSession r3 = r11.F
            r4 = 0
            if (r2 == r3) goto L_0x0078
            r2 = 1
            goto L_0x0079
        L_0x0078:
            r2 = 0
        L_0x0079:
            if (r2 == 0) goto L_0x0084
            int r3 = androidx.media3.common.util.Util.f4714a
            r5 = 23
            if (r3 < r5) goto L_0x0082
            goto L_0x0084
        L_0x0082:
            r3 = 0
            goto L_0x0085
        L_0x0084:
            r3 = 1
        L_0x0085:
            androidx.media3.common.util.Assertions.h(r3)
            androidx.media3.exoplayer.DecoderReuseEvaluation r3 = r11.f0(r1, r6, r7)
            int r5 = r3.f5165d
            r8 = 3
            if (r5 == 0) goto L_0x00f8
            r9 = 16
            r10 = 2
            if (r5 == r0) goto L_0x00de
            if (r5 == r10) goto L_0x00b2
            if (r5 != r8) goto L_0x00ac
            boolean r0 = r11.I1(r7)
            if (r0 != 0) goto L_0x00a1
            goto L_0x00fc
        L_0x00a1:
            r11.N = r7
            if (r2 == 0) goto L_0x00fb
            boolean r0 = r11.s0()
            if (r0 != 0) goto L_0x00fb
            goto L_0x00f6
        L_0x00ac:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>()
            throw r12
        L_0x00b2:
            boolean r5 = r11.I1(r7)
            if (r5 != 0) goto L_0x00b9
            goto L_0x00fc
        L_0x00b9:
            r11.f6714p0 = r0
            r11.f6715q0 = r0
            int r5 = r11.U
            if (r5 == r10) goto L_0x00d1
            if (r5 != r0) goto L_0x00d0
            int r5 = r7.f4021t
            int r9 = r6.f4021t
            if (r5 != r9) goto L_0x00d0
            int r5 = r7.f4022u
            int r9 = r6.f4022u
            if (r5 != r9) goto L_0x00d0
            goto L_0x00d1
        L_0x00d0:
            r0 = 0
        L_0x00d1:
            r11.f6701c0 = r0
            r11.N = r7
            if (r2 == 0) goto L_0x00fb
            boolean r0 = r11.s0()
            if (r0 != 0) goto L_0x00fb
            goto L_0x00f6
        L_0x00de:
            boolean r0 = r11.I1(r7)
            if (r0 != 0) goto L_0x00e5
            goto L_0x00fc
        L_0x00e5:
            r11.N = r7
            if (r2 == 0) goto L_0x00f0
            boolean r0 = r11.s0()
            if (r0 != 0) goto L_0x00fb
            goto L_0x00f6
        L_0x00f0:
            boolean r0 = r11.q0()
            if (r0 != 0) goto L_0x00fb
        L_0x00f6:
            r9 = 2
            goto L_0x00fc
        L_0x00f8:
            r11.r0()
        L_0x00fb:
            r9 = 0
        L_0x00fc:
            int r0 = r3.f5165d
            if (r0 == 0) goto L_0x0112
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter r0 = r11.M
            if (r0 != r12) goto L_0x0108
            int r12 = r11.f6718s0
            if (r12 != r8) goto L_0x0112
        L_0x0108:
            androidx.media3.exoplayer.DecoderReuseEvaluation r12 = new androidx.media3.exoplayer.DecoderReuseEvaluation
            java.lang.String r5 = r1.f6687a
            r8 = 0
            r4 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            return r12
        L_0x0112:
            return r3
        L_0x0113:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Sample MIME type is null."
            r12.<init>(r0)
            r0 = 4005(0xfa5, float:5.612E-42)
            androidx.media3.exoplayer.ExoPlaybackException r12 = r11.E(r12, r1, r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.f1(androidx.media3.exoplayer.FormatHolder):androidx.media3.exoplayer.DecoderReuseEvaluation");
    }

    /* access modifiers changed from: protected */
    public abstract void g1(Format format, MediaFormat mediaFormat) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    public void h1(long j2) {
    }

    /* access modifiers changed from: protected */
    public void i1(long j2) {
        this.M0 = j2;
        while (!this.B.isEmpty() && j2 >= this.B.peek().f6738a) {
            y1((OutputStreamInfo) Assertions.f(this.B.poll()));
            j1();
        }
    }

    public boolean isReady() {
        if (this.D == null || (!N() && !P0() && (this.f6705g0 == -9223372036854775807L || G().elapsedRealtime() >= this.f6705g0))) {
            return false;
        }
        return true;
    }

    public void j(int i2, Object obj) throws ExoPlaybackException {
        if (i2 == 11) {
            this.H = (Renderer.WakeupListener) obj;
        } else {
            super.j(i2, obj);
        }
    }

    /* access modifiers changed from: protected */
    public void j1() {
    }

    /* access modifiers changed from: protected */
    public void k1(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void l1(Format format) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public abstract boolean n1(long j2, long j3, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i2, int i3, int i4, long j4, boolean z2, boolean z3, Format format) throws ExoPlaybackException;

    public void o(float f2, float f3) throws ExoPlaybackException {
        this.K = f2;
        this.L = f3;
        I1(this.N);
    }

    /* access modifiers changed from: protected */
    public MediaCodecDecoderException o0(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecDecoderException(th, mediaCodecInfo);
    }

    public final int p() {
        return 8;
    }

    /* access modifiers changed from: protected */
    public void r1() {
        try {
            MediaCodecAdapter mediaCodecAdapter = this.M;
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.release();
                this.K0.f5151b++;
                e1(((MediaCodecInfo) Assertions.f(this.T)).f6687a);
            }
            this.M = null;
            try {
                MediaCrypto mediaCrypto = this.I;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
                this.I = null;
                x1((DrmSession) null);
                u1();
            }
        } catch (Throwable th) {
            this.M = null;
            MediaCrypto mediaCrypto2 = this.I;
            if (mediaCrypto2 != null) {
                mediaCrypto2.release();
            }
            throw th;
        } finally {
            this.I = null;
            x1((DrmSession) null);
            u1();
        }
    }

    /* access modifiers changed from: protected */
    public void s1() throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void t1() {
        v1();
        w1();
        this.f6705g0 = -9223372036854775807L;
        this.f6722u0 = false;
        this.f6720t0 = false;
        this.f6701c0 = false;
        this.f6702d0 = false;
        this.f6709k0 = false;
        this.f6710l0 = false;
        this.f6726w0 = -9223372036854775807L;
        this.f6728x0 = -9223372036854775807L;
        this.M0 = -9223372036854775807L;
        this.f6716r0 = 0;
        this.f6718s0 = 0;
        this.f6715q0 = this.f6714p0 ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void u1() {
        t1();
        this.J0 = null;
        this.R = null;
        this.T = null;
        this.N = null;
        this.O = null;
        this.P = false;
        this.f6724v0 = false;
        this.Q = -1.0f;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f6699a0 = false;
        this.f6700b0 = false;
        this.f6703e0 = false;
        this.f6704f0 = false;
        this.f6714p0 = false;
        this.f6715q0 = 0;
    }

    /* access modifiers changed from: protected */
    public final boolean x0() throws ExoPlaybackException {
        boolean y02 = y0();
        if (y02) {
            a1();
        }
        return y02;
    }

    /* access modifiers changed from: protected */
    public boolean y0() {
        boolean z2;
        if (this.M == null) {
            return false;
        }
        int i2 = this.f6718s0;
        if (i2 == 3 || this.W || ((this.X && !this.f6724v0) || (this.Y && this.f6722u0))) {
            r1();
            return true;
        }
        if (i2 == 2) {
            int i3 = Util.f4714a;
            if (i3 >= 23) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.h(z2);
            if (i3 >= 23) {
                try {
                    J1();
                } catch (ExoPlaybackException e2) {
                    Log.i("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e2);
                    r1();
                    return true;
                }
            }
        }
        w0();
        return false;
    }

    /* access modifiers changed from: protected */
    public final void z1() {
        this.I0 = true;
    }

    public static class DecoderInitializationException extends Exception {

        /* renamed from: b  reason: collision with root package name */
        public final String f6731b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f6732c;

        /* renamed from: d  reason: collision with root package name */
        public final MediaCodecInfo f6733d;

        /* renamed from: e  reason: collision with root package name */
        public final String f6734e;

        /* renamed from: f  reason: collision with root package name */
        public final DecoderInitializationException f6735f;

        public DecoderInitializationException(Format format, Throwable th, boolean z2, int i2) {
            this("Decoder init failed: [" + i2 + "], " + format, th, format.f4015n, z2, (MediaCodecInfo) null, b(i2), (DecoderInitializationException) null);
        }

        private static String b(int i2) {
            String str;
            if (i2 < 0) {
                str = "neg_";
            } else {
                str = "";
            }
            return "androidx.media3.exoplayer.mediacodec" + ".MediaCodecRenderer_" + str + Math.abs(i2);
        }

        /* access modifiers changed from: private */
        public DecoderInitializationException c(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.f6731b, this.f6732c, this.f6733d, this.f6734e, decoderInitializationException);
        }

        private static String d(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public DecoderInitializationException(Format format, Throwable th, boolean z2, MediaCodecInfo mediaCodecInfo) {
            this("Decoder init failed: " + mediaCodecInfo.f6687a + ", " + format, th, format.f4015n, z2, mediaCodecInfo, Util.f4714a >= 21 ? d(th) : null, (DecoderInitializationException) null);
        }

        private DecoderInitializationException(String str, Throwable th, String str2, boolean z2, MediaCodecInfo mediaCodecInfo, String str3, DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.f6731b = str2;
            this.f6732c = z2;
            this.f6733d = mediaCodecInfo;
            this.f6734e = str3;
            this.f6735f = decoderInitializationException;
        }
    }
}
