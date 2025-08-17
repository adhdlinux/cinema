package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import android.os.SystemClock;
import com.facebook.ads.AdError;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.FrameworkCryptoConfig;
import com.google.android.exoplayer2.drm.i;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class MediaCodecRenderer extends BaseRenderer {
    private static final byte[] K0 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private Format A;
    private DrmSession B;
    private DrmSession C;
    private MediaCrypto D;
    private boolean E;
    private long F;
    private ExoPlaybackException F0;
    private float G;
    protected DecoderCounters G0;
    private float H;
    private OutputStreamInfo H0;
    private MediaCodecAdapter I;
    private long I0;
    private Format J;
    private boolean J0;
    private MediaFormat K;
    private boolean L;
    private float M;
    private ArrayDeque<MediaCodecInfo> N;
    private DecoderInitializationException O;
    private MediaCodecInfo P;
    private int Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f25284a0;

    /* renamed from: b0  reason: collision with root package name */
    private C2Mp3TimestampTracker f25285b0;

    /* renamed from: c0  reason: collision with root package name */
    private long f25286c0;

    /* renamed from: d0  reason: collision with root package name */
    private int f25287d0;

    /* renamed from: e0  reason: collision with root package name */
    private int f25288e0;

    /* renamed from: f0  reason: collision with root package name */
    private ByteBuffer f25289f0;

    /* renamed from: g0  reason: collision with root package name */
    private boolean f25290g0;

    /* renamed from: h0  reason: collision with root package name */
    private boolean f25291h0;

    /* renamed from: i0  reason: collision with root package name */
    private boolean f25292i0;

    /* renamed from: j0  reason: collision with root package name */
    private boolean f25293j0;

    /* renamed from: k0  reason: collision with root package name */
    private boolean f25294k0;

    /* renamed from: l0  reason: collision with root package name */
    private boolean f25295l0;

    /* renamed from: m0  reason: collision with root package name */
    private int f25296m0;

    /* renamed from: n0  reason: collision with root package name */
    private int f25297n0;

    /* renamed from: o  reason: collision with root package name */
    private final MediaCodecAdapter.Factory f25298o;

    /* renamed from: o0  reason: collision with root package name */
    private int f25299o0;

    /* renamed from: p  reason: collision with root package name */
    private final MediaCodecSelector f25300p;

    /* renamed from: p0  reason: collision with root package name */
    private boolean f25301p0;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f25302q;

    /* renamed from: q0  reason: collision with root package name */
    private boolean f25303q0;

    /* renamed from: r  reason: collision with root package name */
    private final float f25304r;

    /* renamed from: r0  reason: collision with root package name */
    private boolean f25305r0;

    /* renamed from: s  reason: collision with root package name */
    private final DecoderInputBuffer f25306s = DecoderInputBuffer.t();

    /* renamed from: s0  reason: collision with root package name */
    private long f25307s0;

    /* renamed from: t  reason: collision with root package name */
    private final DecoderInputBuffer f25308t = new DecoderInputBuffer(0);

    /* renamed from: t0  reason: collision with root package name */
    private long f25309t0;

    /* renamed from: u  reason: collision with root package name */
    private final DecoderInputBuffer f25310u = new DecoderInputBuffer(2);

    /* renamed from: u0  reason: collision with root package name */
    private boolean f25311u0;

    /* renamed from: v  reason: collision with root package name */
    private final BatchBuffer f25312v;

    /* renamed from: v0  reason: collision with root package name */
    private boolean f25313v0;

    /* renamed from: w  reason: collision with root package name */
    private final ArrayList<Long> f25314w;

    /* renamed from: w0  reason: collision with root package name */
    private boolean f25315w0;

    /* renamed from: x  reason: collision with root package name */
    private final MediaCodec.BufferInfo f25316x;

    /* renamed from: x0  reason: collision with root package name */
    private boolean f25317x0;

    /* renamed from: y  reason: collision with root package name */
    private final ArrayDeque<OutputStreamInfo> f25318y;

    /* renamed from: z  reason: collision with root package name */
    private Format f25319z;

    private static final class Api31 {
        private Api31() {
        }

        public static void a(MediaCodecAdapter.Configuration configuration, PlayerId playerId) {
            LogSessionId a2 = playerId.a();
            if (!a2.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                configuration.f25266b.setString("log-session-id", a2.getStringId());
            }
        }
    }

    private static final class OutputStreamInfo {

        /* renamed from: e  reason: collision with root package name */
        public static final OutputStreamInfo f25325e = new OutputStreamInfo(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L);

        /* renamed from: a  reason: collision with root package name */
        public final long f25326a;

        /* renamed from: b  reason: collision with root package name */
        public final long f25327b;

        /* renamed from: c  reason: collision with root package name */
        public final long f25328c;

        /* renamed from: d  reason: collision with root package name */
        public final TimedValueQueue<Format> f25329d = new TimedValueQueue<>();

        public OutputStreamInfo(long j2, long j3, long j4) {
            this.f25326a = j2;
            this.f25327b = j3;
            this.f25328c = j4;
        }
    }

    public MediaCodecRenderer(int i2, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, boolean z2, float f2) {
        super(i2);
        this.f25298o = factory;
        this.f25300p = (MediaCodecSelector) Assertions.e(mediaCodecSelector);
        this.f25302q = z2;
        this.f25304r = f2;
        BatchBuffer batchBuffer = new BatchBuffer();
        this.f25312v = batchBuffer;
        this.f25314w = new ArrayList<>();
        this.f25316x = new MediaCodec.BufferInfo();
        this.G = 1.0f;
        this.H = 1.0f;
        this.F = -9223372036854775807L;
        this.f25318y = new ArrayDeque<>();
        a1(OutputStreamInfo.f25325e);
        batchBuffer.q(0);
        batchBuffer.f23961d.order(ByteOrder.nativeOrder());
        this.M = -1.0f;
        this.Q = 0;
        this.f25296m0 = 0;
        this.f25287d0 = -1;
        this.f25288e0 = -1;
        this.f25286c0 = -9223372036854775807L;
        this.f25307s0 = -9223372036854775807L;
        this.f25309t0 = -9223372036854775807L;
        this.I0 = -9223372036854775807L;
        this.f25297n0 = 0;
        this.f25299o0 = 0;
    }

    private static boolean A0(IllegalStateException illegalStateException) {
        if (Util.f28808a >= 21 && B0(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        if (stackTrace.length <= 0 || !stackTrace[0].getClassName().equals("android.media.MediaCodec")) {
            return false;
        }
        return true;
    }

    private static boolean B0(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    private static boolean C0(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    private void E0(MediaCrypto mediaCrypto, boolean z2) throws DecoderInitializationException {
        if (this.N == null) {
            try {
                List<MediaCodecInfo> k02 = k0(z2);
                ArrayDeque<MediaCodecInfo> arrayDeque = new ArrayDeque<>();
                this.N = arrayDeque;
                if (this.f25302q) {
                    arrayDeque.addAll(k02);
                } else if (!k02.isEmpty()) {
                    this.N.add(k02.get(0));
                }
                this.O = null;
            } catch (MediaCodecUtil.DecoderQueryException e2) {
                throw new DecoderInitializationException(this.f25319z, (Throwable) e2, z2, -49998);
            }
        }
        if (!this.N.isEmpty()) {
            MediaCodecInfo peekFirst = this.N.peekFirst();
            while (this.I == null) {
                MediaCodecInfo peekFirst2 = this.N.peekFirst();
                if (f1(peekFirst2)) {
                    try {
                        y0(peekFirst2, mediaCrypto);
                    } catch (Exception e3) {
                        if (peekFirst2 == peekFirst) {
                            Log.i("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                            Thread.sleep(50);
                            y0(peekFirst2, mediaCrypto);
                        } else {
                            throw e3;
                        }
                    } catch (Exception e4) {
                        Log.j("MediaCodecRenderer", "Failed to initialize decoder: " + peekFirst2, e4);
                        this.N.removeFirst();
                        DecoderInitializationException decoderInitializationException = new DecoderInitializationException(this.f25319z, (Throwable) e4, z2, peekFirst2);
                        F0(decoderInitializationException);
                        DecoderInitializationException decoderInitializationException2 = this.O;
                        if (decoderInitializationException2 == null) {
                            this.O = decoderInitializationException;
                        } else {
                            this.O = decoderInitializationException2.c(decoderInitializationException);
                        }
                        if (this.N.isEmpty()) {
                            throw this.O;
                        }
                    }
                } else {
                    return;
                }
            }
            this.N = null;
            return;
        }
        throw new DecoderInitializationException(this.f25319z, (Throwable) null, z2, -49999);
    }

    private void N() throws ExoPlaybackException {
        Assertions.g(!this.f25311u0);
        FormatHolder y2 = y();
        this.f25310u.f();
        do {
            this.f25310u.f();
            int K2 = K(y2, this.f25310u, 0);
            if (K2 == -5) {
                I0(y2);
                return;
            } else if (K2 != -4) {
                if (K2 != -3) {
                    throw new IllegalStateException();
                }
                return;
            } else if (this.f25310u.k()) {
                this.f25311u0 = true;
                return;
            } else {
                if (this.f25315w0) {
                    Format format = (Format) Assertions.e(this.f25319z);
                    this.A = format;
                    J0(format, (MediaFormat) null);
                    this.f25315w0 = false;
                }
                this.f25310u.r();
            }
        } while (this.f25312v.v(this.f25310u));
        this.f25293j0 = true;
    }

    private boolean O(long j2, long j3) throws ExoPlaybackException {
        Assertions.g(!this.f25313v0);
        if (this.f25312v.A()) {
            BatchBuffer batchBuffer = this.f25312v;
            if (!P0(j2, j3, (MediaCodecAdapter) null, batchBuffer.f23961d, this.f25288e0, 0, batchBuffer.z(), this.f25312v.x(), this.f25312v.j(), this.f25312v.k(), this.A)) {
                return false;
            }
            L0(this.f25312v.y());
            this.f25312v.f();
        }
        if (this.f25311u0) {
            this.f25313v0 = true;
            return false;
        }
        if (this.f25293j0) {
            Assertions.g(this.f25312v.v(this.f25310u));
            this.f25293j0 = false;
        }
        if (this.f25294k0) {
            if (this.f25312v.A()) {
                return true;
            }
            a0();
            this.f25294k0 = false;
            D0();
            if (!this.f25292i0) {
                return false;
            }
        }
        N();
        if (this.f25312v.A()) {
            this.f25312v.r();
        }
        if (this.f25312v.A() || this.f25311u0 || this.f25294k0) {
            return true;
        }
        return false;
    }

    @TargetApi(23)
    private void O0() throws ExoPlaybackException {
        int i2 = this.f25299o0;
        if (i2 == 1) {
            h0();
        } else if (i2 == 2) {
            h0();
            l1();
        } else if (i2 != 3) {
            this.f25313v0 = true;
            U0();
        } else {
            S0();
        }
    }

    private int Q(String str) {
        int i2 = Util.f28808a;
        if (i2 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = Util.f28811d;
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
        String str3 = Util.f28809b;
        if ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) {
            return 1;
        }
        return 0;
    }

    private void Q0() {
        this.f25305r0 = true;
        MediaFormat c2 = this.I.c();
        if (this.Q != 0 && c2.getInteger("width") == 32 && c2.getInteger("height") == 32) {
            this.Z = true;
            return;
        }
        if (this.X) {
            c2.setInteger("channel-count", 1);
        }
        this.K = c2;
        this.L = true;
    }

    private static boolean R(String str, Format format) {
        if (Util.f28808a >= 21 || !format.f23073o.isEmpty() || !"OMX.MTK.VIDEO.DECODER.AVC".equals(str)) {
            return false;
        }
        return true;
    }

    private boolean R0(int i2) throws ExoPlaybackException {
        FormatHolder y2 = y();
        this.f25306s.f();
        int K2 = K(y2, this.f25306s, i2 | 4);
        if (K2 == -5) {
            I0(y2);
            return true;
        } else if (K2 != -4 || !this.f25306s.k()) {
            return false;
        } else {
            this.f25311u0 = true;
            O0();
            return false;
        }
    }

    private static boolean S(String str) {
        if (Util.f28808a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(Util.f28810c)) {
            String str2 = Util.f28809b;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    private void S0() throws ExoPlaybackException {
        T0();
        D0();
    }

    private static boolean T(String str) {
        int i2 = Util.f28808a;
        if (i2 > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i2 <= 19) {
                String str2 = Util.f28809b;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private static boolean U(String str) {
        return Util.f28808a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean V(MediaCodecInfo mediaCodecInfo) {
        String str = mediaCodecInfo.f25273a;
        int i2 = Util.f28808a;
        if ((i2 > 25 || !"OMX.rk.video_decoder.avc".equals(str)) && ((i2 > 17 || !"OMX.allwinner.video.decoder.avc".equals(str)) && ((i2 > 29 || (!"OMX.broadcom.video_decoder.tunnel".equals(str) && !"OMX.broadcom.video_decoder.tunnel.secure".equals(str) && !"OMX.bcm.vdec.avc.tunnel".equals(str) && !"OMX.bcm.vdec.avc.tunnel.secure".equals(str) && !"OMX.bcm.vdec.hevc.tunnel".equals(str) && !"OMX.bcm.vdec.hevc.tunnel.secure".equals(str))) && (!"Amazon".equals(Util.f28810c) || !"AFTS".equals(Util.f28811d) || !mediaCodecInfo.f25279g)))) {
            return false;
        }
        return true;
    }

    private static boolean W(String str) {
        int i2 = Util.f28808a;
        if (i2 < 18 || ((i2 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i2 == 19 && Util.f28811d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str))))) {
            return true;
        }
        return false;
    }

    private static boolean X(String str, Format format) {
        if (Util.f28808a > 18 || format.f23084z != 1 || !"OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
            return false;
        }
        return true;
    }

    private void X0() {
        this.f25287d0 = -1;
        this.f25308t.f23961d = null;
    }

    private static boolean Y(String str) {
        return Util.f28808a == 29 && "c2.android.aac.decoder".equals(str);
    }

    private void Y0() {
        this.f25288e0 = -1;
        this.f25289f0 = null;
    }

    private void Z0(DrmSession drmSession) {
        i.a(this.B, drmSession);
        this.B = drmSession;
    }

    private void a0() {
        this.f25294k0 = false;
        this.f25312v.f();
        this.f25310u.f();
        this.f25293j0 = false;
        this.f25292i0 = false;
    }

    private void a1(OutputStreamInfo outputStreamInfo) {
        this.H0 = outputStreamInfo;
        long j2 = outputStreamInfo.f25328c;
        if (j2 != -9223372036854775807L) {
            this.J0 = true;
            K0(j2);
        }
    }

    private boolean b0() {
        if (this.f25301p0) {
            this.f25297n0 = 1;
            if (this.S || this.U) {
                this.f25299o0 = 3;
                return false;
            }
            this.f25299o0 = 1;
        }
        return true;
    }

    private void c0() throws ExoPlaybackException {
        if (this.f25301p0) {
            this.f25297n0 = 1;
            this.f25299o0 = 3;
            return;
        }
        S0();
    }

    @TargetApi(23)
    private boolean d0() throws ExoPlaybackException {
        if (this.f25301p0) {
            this.f25297n0 = 1;
            if (this.S || this.U) {
                this.f25299o0 = 3;
                return false;
            }
            this.f25299o0 = 2;
        } else {
            l1();
        }
        return true;
    }

    private void d1(DrmSession drmSession) {
        i.a(this.C, drmSession);
        this.C = drmSession;
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e0(long r20, long r22) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r19 = this;
            r15 = r19
            boolean r0 = r19.w0()
            r16 = 1
            r14 = 0
            if (r0 != 0) goto L_0x00c2
            boolean r0 = r15.V
            if (r0 == 0) goto L_0x0028
            boolean r0 = r15.f25303q0
            if (r0 == 0) goto L_0x0028
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r0 = r15.I     // Catch:{ IllegalStateException -> 0x001c }
            android.media.MediaCodec$BufferInfo r1 = r15.f25316x     // Catch:{ IllegalStateException -> 0x001c }
            int r0 = r0.k(r1)     // Catch:{ IllegalStateException -> 0x001c }
            goto L_0x0030
        L_0x001c:
            r19.O0()
            boolean r0 = r15.f25313v0
            if (r0 == 0) goto L_0x0027
            r19.T0()
        L_0x0027:
            return r14
        L_0x0028:
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r0 = r15.I
            android.media.MediaCodec$BufferInfo r1 = r15.f25316x
            int r0 = r0.k(r1)
        L_0x0030:
            if (r0 >= 0) goto L_0x004a
            r1 = -2
            if (r0 != r1) goto L_0x0039
            r19.Q0()
            return r16
        L_0x0039:
            boolean r0 = r15.f25284a0
            if (r0 == 0) goto L_0x0049
            boolean r0 = r15.f25311u0
            if (r0 != 0) goto L_0x0046
            int r0 = r15.f25297n0
            r1 = 2
            if (r0 != r1) goto L_0x0049
        L_0x0046:
            r19.O0()
        L_0x0049:
            return r14
        L_0x004a:
            boolean r1 = r15.Z
            if (r1 == 0) goto L_0x0056
            r15.Z = r14
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r1 = r15.I
            r1.l(r0, r14)
            return r16
        L_0x0056:
            android.media.MediaCodec$BufferInfo r1 = r15.f25316x
            int r2 = r1.size
            if (r2 != 0) goto L_0x0066
            int r1 = r1.flags
            r1 = r1 & 4
            if (r1 == 0) goto L_0x0066
            r19.O0()
            return r14
        L_0x0066:
            r15.f25288e0 = r0
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r1 = r15.I
            java.nio.ByteBuffer r0 = r1.m(r0)
            r15.f25289f0 = r0
            if (r0 == 0) goto L_0x0085
            android.media.MediaCodec$BufferInfo r1 = r15.f25316x
            int r1 = r1.offset
            r0.position(r1)
            java.nio.ByteBuffer r0 = r15.f25289f0
            android.media.MediaCodec$BufferInfo r1 = r15.f25316x
            int r2 = r1.offset
            int r1 = r1.size
            int r2 = r2 + r1
            r0.limit(r2)
        L_0x0085:
            boolean r0 = r15.W
            if (r0 == 0) goto L_0x00a6
            android.media.MediaCodec$BufferInfo r0 = r15.f25316x
            long r1 = r0.presentationTimeUs
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x00a6
            int r1 = r0.flags
            r1 = r1 & 4
            if (r1 == 0) goto L_0x00a6
            long r1 = r15.f25307s0
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00a6
            r0.presentationTimeUs = r1
        L_0x00a6:
            android.media.MediaCodec$BufferInfo r0 = r15.f25316x
            long r0 = r0.presentationTimeUs
            boolean r0 = r15.z0(r0)
            r15.f25290g0 = r0
            long r0 = r15.f25309t0
            android.media.MediaCodec$BufferInfo r2 = r15.f25316x
            long r2 = r2.presentationTimeUs
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00bc
            r0 = 1
            goto L_0x00bd
        L_0x00bc:
            r0 = 0
        L_0x00bd:
            r15.f25291h0 = r0
            r15.m1(r2)
        L_0x00c2:
            boolean r0 = r15.V
            if (r0 == 0) goto L_0x00fc
            boolean r0 = r15.f25303q0
            if (r0 == 0) goto L_0x00fc
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r5 = r15.I     // Catch:{ IllegalStateException -> 0x00ee }
            java.nio.ByteBuffer r6 = r15.f25289f0     // Catch:{ IllegalStateException -> 0x00ee }
            int r7 = r15.f25288e0     // Catch:{ IllegalStateException -> 0x00ee }
            android.media.MediaCodec$BufferInfo r0 = r15.f25316x     // Catch:{ IllegalStateException -> 0x00ee }
            int r8 = r0.flags     // Catch:{ IllegalStateException -> 0x00ee }
            r9 = 1
            long r10 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x00ee }
            boolean r12 = r15.f25290g0     // Catch:{ IllegalStateException -> 0x00ee }
            boolean r13 = r15.f25291h0     // Catch:{ IllegalStateException -> 0x00ee }
            com.google.android.exoplayer2.Format r3 = r15.A     // Catch:{ IllegalStateException -> 0x00ee }
            r0 = r19
            r1 = r20
            r17 = r3
            r3 = r22
            r18 = 0
            r14 = r17
            boolean r0 = r0.P0(r1, r3, r5, r6, r7, r8, r9, r10, r12, r13, r14)     // Catch:{ IllegalStateException -> 0x00f0 }
            goto L_0x011b
        L_0x00ee:
            r18 = 0
        L_0x00f0:
            r19.O0()
            boolean r0 = r15.f25313v0
            if (r0 == 0) goto L_0x00fb
            r19.T0()
        L_0x00fb:
            return r18
        L_0x00fc:
            r18 = 0
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r5 = r15.I
            java.nio.ByteBuffer r6 = r15.f25289f0
            int r7 = r15.f25288e0
            android.media.MediaCodec$BufferInfo r0 = r15.f25316x
            int r8 = r0.flags
            r9 = 1
            long r10 = r0.presentationTimeUs
            boolean r12 = r15.f25290g0
            boolean r13 = r15.f25291h0
            com.google.android.exoplayer2.Format r14 = r15.A
            r0 = r19
            r1 = r20
            r3 = r22
            boolean r0 = r0.P0(r1, r3, r5, r6, r7, r8, r9, r10, r12, r13, r14)
        L_0x011b:
            if (r0 == 0) goto L_0x0138
            android.media.MediaCodec$BufferInfo r0 = r15.f25316x
            long r0 = r0.presentationTimeUs
            r15.L0(r0)
            android.media.MediaCodec$BufferInfo r0 = r15.f25316x
            int r0 = r0.flags
            r0 = r0 & 4
            if (r0 == 0) goto L_0x012e
            r14 = 1
            goto L_0x012f
        L_0x012e:
            r14 = 0
        L_0x012f:
            r19.Y0()
            if (r14 != 0) goto L_0x0135
            return r16
        L_0x0135:
            r19.O0()
        L_0x0138:
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.e0(long, long):boolean");
    }

    private boolean e1(long j2) {
        if (this.F == -9223372036854775807L || SystemClock.elapsedRealtime() - j2 < this.F) {
            return true;
        }
        return false;
    }

    private boolean f0(MediaCodecInfo mediaCodecInfo, Format format, DrmSession drmSession, DrmSession drmSession2) throws ExoPlaybackException {
        FrameworkCryptoConfig r02;
        boolean z2;
        if (drmSession == drmSession2) {
            return false;
        }
        if (drmSession2 == null || drmSession == null || !drmSession2.a().equals(drmSession.a()) || Util.f28808a < 23) {
            return true;
        }
        UUID uuid = C.f22820e;
        if (uuid.equals(drmSession.a()) || uuid.equals(drmSession2.a()) || (r02 = r0(drmSession2)) == null) {
            return true;
        }
        if (r02.f24102c) {
            z2 = false;
        } else {
            z2 = drmSession2.e(format.f23071m);
        }
        if (mediaCodecInfo.f25279g || !z2) {
            return false;
        }
        return true;
    }

    private boolean g0() throws ExoPlaybackException {
        int i2;
        if (this.I == null || (i2 = this.f25297n0) == 2 || this.f25311u0) {
            return false;
        }
        if (i2 == 0 && g1()) {
            c0();
        }
        if (this.f25287d0 < 0) {
            int j2 = this.I.j();
            this.f25287d0 = j2;
            if (j2 < 0) {
                return false;
            }
            this.f25308t.f23961d = this.I.e(j2);
            this.f25308t.f();
        }
        if (this.f25297n0 == 1) {
            if (!this.f25284a0) {
                this.f25303q0 = true;
                this.I.a(this.f25287d0, 0, 0, 0, 4);
                X0();
            }
            this.f25297n0 = 2;
            return false;
        } else if (this.Y) {
            this.Y = false;
            ByteBuffer byteBuffer = this.f25308t.f23961d;
            byte[] bArr = K0;
            byteBuffer.put(bArr);
            this.I.a(this.f25287d0, 0, bArr.length, 0, 0);
            X0();
            this.f25301p0 = true;
            return true;
        } else {
            if (this.f25296m0 == 1) {
                for (int i3 = 0; i3 < this.J.f23073o.size(); i3++) {
                    this.f25308t.f23961d.put(this.J.f23073o.get(i3));
                }
                this.f25296m0 = 2;
            }
            int position = this.f25308t.f23961d.position();
            FormatHolder y2 = y();
            try {
                int K2 = K(y2, this.f25308t, 0);
                if (g() || this.f25308t.n()) {
                    this.f25309t0 = this.f25307s0;
                }
                if (K2 == -3) {
                    return false;
                }
                if (K2 == -5) {
                    if (this.f25296m0 == 2) {
                        this.f25308t.f();
                        this.f25296m0 = 1;
                    }
                    I0(y2);
                    return true;
                } else if (this.f25308t.k()) {
                    if (this.f25296m0 == 2) {
                        this.f25308t.f();
                        this.f25296m0 = 1;
                    }
                    this.f25311u0 = true;
                    if (!this.f25301p0) {
                        O0();
                        return false;
                    }
                    try {
                        if (!this.f25284a0) {
                            this.f25303q0 = true;
                            this.I.a(this.f25287d0, 0, 0, 0, 4);
                            X0();
                        }
                        return false;
                    } catch (MediaCodec.CryptoException e2) {
                        throw v(e2, this.f25319z, Util.W(e2.getErrorCode()));
                    }
                } else if (this.f25301p0 || this.f25308t.m()) {
                    boolean s2 = this.f25308t.s();
                    if (s2) {
                        this.f25308t.f23960c.b(position);
                    }
                    if (this.R && !s2) {
                        NalUnitUtil.b(this.f25308t.f23961d);
                        if (this.f25308t.f23961d.position() == 0) {
                            return true;
                        }
                        this.R = false;
                    }
                    DecoderInputBuffer decoderInputBuffer = this.f25308t;
                    long j3 = decoderInputBuffer.f23963f;
                    C2Mp3TimestampTracker c2Mp3TimestampTracker = this.f25285b0;
                    if (c2Mp3TimestampTracker != null) {
                        j3 = c2Mp3TimestampTracker.d(this.f25319z, decoderInputBuffer);
                        this.f25307s0 = Math.max(this.f25307s0, this.f25285b0.b(this.f25319z));
                    }
                    long j4 = j3;
                    if (this.f25308t.j()) {
                        this.f25314w.add(Long.valueOf(j4));
                    }
                    if (this.f25315w0) {
                        if (!this.f25318y.isEmpty()) {
                            this.f25318y.peekLast().f25329d.a(j4, this.f25319z);
                        } else {
                            this.H0.f25329d.a(j4, this.f25319z);
                        }
                        this.f25315w0 = false;
                    }
                    this.f25307s0 = Math.max(this.f25307s0, j4);
                    this.f25308t.r();
                    if (this.f25308t.i()) {
                        v0(this.f25308t);
                    }
                    N0(this.f25308t);
                    if (s2) {
                        try {
                            this.I.g(this.f25287d0, 0, this.f25308t.f23960c, j4, 0);
                        } catch (MediaCodec.CryptoException e3) {
                            throw v(e3, this.f25319z, Util.W(e3.getErrorCode()));
                        }
                    } else {
                        this.I.a(this.f25287d0, 0, this.f25308t.f23961d.limit(), j4, 0);
                    }
                    X0();
                    this.f25301p0 = true;
                    this.f25296m0 = 0;
                    this.G0.f23950c++;
                    return true;
                } else {
                    this.f25308t.f();
                    if (this.f25296m0 == 2) {
                        this.f25296m0 = 1;
                    }
                    return true;
                }
            } catch (DecoderInputBuffer.InsufficientCapacityException e4) {
                F0(e4);
                R0(0);
                h0();
                return true;
            }
        }
    }

    private void h0() {
        try {
            this.I.flush();
        } finally {
            V0();
        }
    }

    protected static boolean j1(Format format) {
        int i2 = format.H;
        return i2 == 0 || i2 == 2;
    }

    private List<MediaCodecInfo> k0(boolean z2) throws MediaCodecUtil.DecoderQueryException {
        List<MediaCodecInfo> q02 = q0(this.f25300p, this.f25319z, z2);
        if (q02.isEmpty() && z2) {
            q02 = q0(this.f25300p, this.f25319z, false);
            if (!q02.isEmpty()) {
                Log.i("MediaCodecRenderer", "Drm session requires secure decoder for " + this.f25319z.f23071m + ", but no secure decoder available. Trying to proceed with " + q02 + ".");
            }
        }
        return q02;
    }

    private boolean k1(Format format) throws ExoPlaybackException {
        if (!(Util.f28808a < 23 || this.I == null || this.f25299o0 == 3 || getState() == 0)) {
            float o02 = o0(this.H, format, B());
            float f2 = this.M;
            if (f2 == o02) {
                return true;
            }
            if (o02 == -1.0f) {
                c0();
                return false;
            } else if (f2 == -1.0f && o02 <= this.f25304r) {
                return true;
            } else {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", o02);
                this.I.b(bundle);
                this.M = o02;
            }
        }
        return true;
    }

    private void l1() throws ExoPlaybackException {
        try {
            this.D.setMediaDrmSession(r0(this.C).f24101b);
            Z0(this.C);
            this.f25297n0 = 0;
            this.f25299o0 = 0;
        } catch (MediaCryptoException e2) {
            throw v(e2, this.f25319z, 6006);
        }
    }

    private FrameworkCryptoConfig r0(DrmSession drmSession) throws ExoPlaybackException {
        CryptoConfig c2 = drmSession.c();
        if (c2 == null || (c2 instanceof FrameworkCryptoConfig)) {
            return (FrameworkCryptoConfig) c2;
        }
        throw v(new IllegalArgumentException("Expecting FrameworkCryptoConfig but found: " + c2), this.f25319z, AdError.MEDIAVIEW_MISSING_ERROR_CODE);
    }

    private boolean w0() {
        return this.f25288e0 >= 0;
    }

    private void x0(Format format) {
        a0();
        String str = format.f23071m;
        if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
            this.f25312v.B(32);
        } else {
            this.f25312v.B(1);
        }
        this.f25292i0 = true;
    }

    /* JADX INFO: finally extract failed */
    private void y0(MediaCodecInfo mediaCodecInfo, MediaCrypto mediaCrypto) throws Exception {
        float f2;
        boolean z2;
        String str = mediaCodecInfo.f25273a;
        int i2 = Util.f28808a;
        float f3 = -1.0f;
        if (i2 < 23) {
            f2 = -1.0f;
        } else {
            f2 = o0(this.H, this.f25319z, B());
        }
        if (f2 > this.f25304r) {
            f3 = f2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        MediaCodecAdapter.Configuration s02 = s0(mediaCodecInfo, this.f25319z, mediaCrypto, f3);
        if (i2 >= 31) {
            Api31.a(s02, A());
        }
        try {
            TraceUtil.a("createCodec:" + str);
            this.I = this.f25298o.a(s02);
            TraceUtil.c();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            boolean z3 = false;
            if (!mediaCodecInfo.o(this.f25319z)) {
                Log.i("MediaCodecRenderer", Util.C("Format exceeds selected codec's capabilities [%s, %s]", Format.j(this.f25319z), str));
            }
            this.P = mediaCodecInfo;
            this.M = f3;
            this.J = this.f25319z;
            this.Q = Q(str);
            this.R = R(str, this.J);
            this.S = W(str);
            this.T = Y(str);
            this.U = T(str);
            this.V = U(str);
            this.W = S(str);
            this.X = X(str, this.J);
            if (V(mediaCodecInfo) || n0()) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f25284a0 = z2;
            if (this.I.h()) {
                this.f25295l0 = true;
                this.f25296m0 = 1;
                if (this.Q != 0) {
                    z3 = true;
                }
                this.Y = z3;
            }
            if ("c2.android.mp3.decoder".equals(mediaCodecInfo.f25273a)) {
                this.f25285b0 = new C2Mp3TimestampTracker();
            }
            if (getState() == 2) {
                this.f25286c0 = SystemClock.elapsedRealtime() + 1000;
            }
            this.G0.f23948a++;
            G0(str, s02, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
        } catch (Throwable th) {
            TraceUtil.c();
            throw th;
        }
    }

    private boolean z0(long j2) {
        int size = this.f25314w.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f25314w.get(i2).longValue() == j2) {
                this.f25314w.remove(i2);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void D() {
        this.f25319z = null;
        a1(OutputStreamInfo.f25325e);
        this.f25318y.clear();
        j0();
    }

    /* access modifiers changed from: protected */
    public final void D0() throws ExoPlaybackException {
        Format format;
        boolean z2;
        if (this.I == null && !this.f25292i0 && (format = this.f25319z) != null) {
            if (this.C != null || !h1(format)) {
                Z0(this.C);
                String str = this.f25319z.f23071m;
                DrmSession drmSession = this.B;
                if (drmSession != null) {
                    if (this.D == null) {
                        FrameworkCryptoConfig r02 = r0(drmSession);
                        if (r02 != null) {
                            try {
                                MediaCrypto mediaCrypto = new MediaCrypto(r02.f24100a, r02.f24101b);
                                this.D = mediaCrypto;
                                if (r02.f24102c || !mediaCrypto.requiresSecureDecoderComponent(str)) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                this.E = z2;
                            } catch (MediaCryptoException e2) {
                                throw v(e2, this.f25319z, 6006);
                            }
                        } else if (this.B.getError() == null) {
                            return;
                        }
                    }
                    if (FrameworkCryptoConfig.f24099d) {
                        int state = this.B.getState();
                        if (state == 1) {
                            DrmSession.DrmSessionException drmSessionException = (DrmSession.DrmSessionException) Assertions.e(this.B.getError());
                            throw v(drmSessionException, this.f25319z, drmSessionException.f24084b);
                        } else if (state != 4) {
                            return;
                        }
                    }
                }
                try {
                    E0(this.D, this.E);
                } catch (DecoderInitializationException e3) {
                    throw v(e3, this.f25319z, 4001);
                }
            } else {
                x0(this.f25319z);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void E(boolean z2, boolean z3) throws ExoPlaybackException {
        this.G0 = new DecoderCounters();
    }

    /* access modifiers changed from: protected */
    public void F(long j2, boolean z2) throws ExoPlaybackException {
        this.f25311u0 = false;
        this.f25313v0 = false;
        this.f25317x0 = false;
        if (this.f25292i0) {
            this.f25312v.f();
            this.f25310u.f();
            this.f25293j0 = false;
        } else {
            i0();
        }
        if (this.H0.f25329d.l() > 0) {
            this.f25315w0 = true;
        }
        this.H0.f25329d.c();
        this.f25318y.clear();
    }

    /* access modifiers changed from: protected */
    public abstract void F0(Exception exc);

    /* access modifiers changed from: protected */
    public void G() {
        try {
            a0();
            T0();
        } finally {
            d1((DrmSession) null);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void G0(String str, MediaCodecAdapter.Configuration configuration, long j2, long j3);

    /* access modifiers changed from: protected */
    public void H() {
    }

    /* access modifiers changed from: protected */
    public abstract void H0(String str);

    /* access modifiers changed from: protected */
    public void I() {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0080, code lost:
        if (d0() == false) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b2, code lost:
        if (d0() == false) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00cf, code lost:
        r7 = 2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00eb A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.decoder.DecoderReuseEvaluation I0(com.google.android.exoplayer2.FormatHolder r12) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r11 = this;
            r0 = 1
            r11.f25315w0 = r0
            com.google.android.exoplayer2.Format r1 = r12.f23112b
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.e(r1)
            r5 = r1
            com.google.android.exoplayer2.Format r5 = (com.google.android.exoplayer2.Format) r5
            java.lang.String r1 = r5.f23071m
            if (r1 == 0) goto L_0x00ec
            com.google.android.exoplayer2.drm.DrmSession r12 = r12.f23111a
            r11.d1(r12)
            r11.f25319z = r5
            boolean r12 = r11.f25292i0
            r1 = 0
            if (r12 == 0) goto L_0x001f
            r11.f25294k0 = r0
            return r1
        L_0x001f:
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r12 = r11.I
            if (r12 != 0) goto L_0x0029
            r11.N = r1
            r11.D0()
            return r1
        L_0x0029:
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r1 = r11.P
            com.google.android.exoplayer2.Format r4 = r11.J
            com.google.android.exoplayer2.drm.DrmSession r2 = r11.B
            com.google.android.exoplayer2.drm.DrmSession r3 = r11.C
            boolean r2 = r11.f0(r1, r5, r2, r3)
            if (r2 == 0) goto L_0x0046
            r11.c0()
            com.google.android.exoplayer2.decoder.DecoderReuseEvaluation r12 = new com.google.android.exoplayer2.decoder.DecoderReuseEvaluation
            java.lang.String r3 = r1.f25273a
            r6 = 0
            r7 = 128(0x80, float:1.794E-43)
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            return r12
        L_0x0046:
            com.google.android.exoplayer2.drm.DrmSession r2 = r11.C
            com.google.android.exoplayer2.drm.DrmSession r3 = r11.B
            r6 = 0
            if (r2 == r3) goto L_0x004f
            r2 = 1
            goto L_0x0050
        L_0x004f:
            r2 = 0
        L_0x0050:
            if (r2 == 0) goto L_0x005b
            int r3 = com.google.android.exoplayer2.util.Util.f28808a
            r7 = 23
            if (r3 < r7) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r3 = 0
            goto L_0x005c
        L_0x005b:
            r3 = 1
        L_0x005c:
            com.google.android.exoplayer2.util.Assertions.g(r3)
            com.google.android.exoplayer2.decoder.DecoderReuseEvaluation r3 = r11.P(r1, r4, r5)
            int r7 = r3.f23974d
            r8 = 3
            if (r7 == 0) goto L_0x00d1
            r9 = 16
            r10 = 2
            if (r7 == r0) goto L_0x00b5
            if (r7 == r10) goto L_0x0089
            if (r7 != r8) goto L_0x0083
            boolean r0 = r11.k1(r5)
            if (r0 != 0) goto L_0x0078
            goto L_0x00bb
        L_0x0078:
            r11.J = r5
            if (r2 == 0) goto L_0x00d4
            boolean r0 = r11.d0()
            if (r0 != 0) goto L_0x00d4
            goto L_0x00cf
        L_0x0083:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>()
            throw r12
        L_0x0089:
            boolean r7 = r11.k1(r5)
            if (r7 != 0) goto L_0x0090
            goto L_0x00bb
        L_0x0090:
            r11.f25295l0 = r0
            r11.f25296m0 = r0
            int r7 = r11.Q
            if (r7 == r10) goto L_0x00a8
            if (r7 != r0) goto L_0x00a7
            int r7 = r5.f23076r
            int r9 = r4.f23076r
            if (r7 != r9) goto L_0x00a7
            int r7 = r5.f23077s
            int r9 = r4.f23077s
            if (r7 != r9) goto L_0x00a7
            goto L_0x00a8
        L_0x00a7:
            r0 = 0
        L_0x00a8:
            r11.Y = r0
            r11.J = r5
            if (r2 == 0) goto L_0x00d4
            boolean r0 = r11.d0()
            if (r0 != 0) goto L_0x00d4
            goto L_0x00cf
        L_0x00b5:
            boolean r0 = r11.k1(r5)
            if (r0 != 0) goto L_0x00be
        L_0x00bb:
            r7 = 16
            goto L_0x00d5
        L_0x00be:
            r11.J = r5
            if (r2 == 0) goto L_0x00c9
            boolean r0 = r11.d0()
            if (r0 != 0) goto L_0x00d4
            goto L_0x00cf
        L_0x00c9:
            boolean r0 = r11.b0()
            if (r0 != 0) goto L_0x00d4
        L_0x00cf:
            r7 = 2
            goto L_0x00d5
        L_0x00d1:
            r11.c0()
        L_0x00d4:
            r7 = 0
        L_0x00d5:
            int r0 = r3.f23974d
            if (r0 == 0) goto L_0x00eb
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r0 = r11.I
            if (r0 != r12) goto L_0x00e1
            int r12 = r11.f25299o0
            if (r12 != r8) goto L_0x00eb
        L_0x00e1:
            com.google.android.exoplayer2.decoder.DecoderReuseEvaluation r12 = new com.google.android.exoplayer2.decoder.DecoderReuseEvaluation
            java.lang.String r3 = r1.f25273a
            r6 = 0
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            return r12
        L_0x00eb:
            return r3
        L_0x00ec:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            r12.<init>()
            r0 = 4005(0xfa5, float:5.612E-42)
            com.google.android.exoplayer2.ExoPlaybackException r12 = r11.v(r12, r5, r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.I0(com.google.android.exoplayer2.FormatHolder):com.google.android.exoplayer2.decoder.DecoderReuseEvaluation");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        if (r5 >= r1) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J(com.google.android.exoplayer2.Format[] r16, long r17, long r19) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r15 = this;
            r0 = r15
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$OutputStreamInfo r1 = r0.H0
            long r1 = r1.f25328c
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0021
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$OutputStreamInfo r1 = new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$OutputStreamInfo
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = r1
            r9 = r17
            r11 = r19
            r6.<init>(r7, r9, r11)
            r15.a1(r1)
            goto L_0x0068
        L_0x0021:
            java.util.ArrayDeque<com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$OutputStreamInfo> r1 = r0.f25318y
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0057
            long r1 = r0.f25307s0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0039
            long r5 = r0.I0
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x0057
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 < 0) goto L_0x0057
        L_0x0039:
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$OutputStreamInfo r1 = new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$OutputStreamInfo
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = r1
            r11 = r17
            r13 = r19
            r8.<init>(r9, r11, r13)
            r15.a1(r1)
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$OutputStreamInfo r1 = r0.H0
            long r1 = r1.f25328c
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0068
            r15.M0()
            goto L_0x0068
        L_0x0057:
            java.util.ArrayDeque<com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$OutputStreamInfo> r1 = r0.f25318y
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$OutputStreamInfo r9 = new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$OutputStreamInfo
            long r3 = r0.f25307s0
            r2 = r9
            r5 = r17
            r7 = r19
            r2.<init>(r3, r5, r7)
            r1.add(r9)
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.J(com.google.android.exoplayer2.Format[], long, long):void");
    }

    /* access modifiers changed from: protected */
    public abstract void J0(Format format, MediaFormat mediaFormat) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    public void K0(long j2) {
    }

    /* access modifiers changed from: protected */
    public void L0(long j2) {
        this.I0 = j2;
        while (!this.f25318y.isEmpty() && j2 >= this.f25318y.peek().f25326a) {
            a1(this.f25318y.poll());
            M0();
        }
    }

    /* access modifiers changed from: protected */
    public void M0() {
    }

    /* access modifiers changed from: protected */
    public abstract void N0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    public abstract DecoderReuseEvaluation P(MediaCodecInfo mediaCodecInfo, Format format, Format format2);

    /* access modifiers changed from: protected */
    public abstract boolean P0(long j2, long j3, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i2, int i3, int i4, long j4, boolean z2, boolean z3, Format format) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    public void T0() {
        try {
            MediaCodecAdapter mediaCodecAdapter = this.I;
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.release();
                this.G0.f23949b++;
                H0(this.P.f25273a);
            }
            this.I = null;
            try {
                MediaCrypto mediaCrypto = this.D;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
                this.D = null;
                Z0((DrmSession) null);
                W0();
            }
        } catch (Throwable th) {
            this.I = null;
            MediaCrypto mediaCrypto2 = this.D;
            if (mediaCrypto2 != null) {
                mediaCrypto2.release();
            }
            throw th;
        } finally {
            this.D = null;
            Z0((DrmSession) null);
            W0();
        }
    }

    /* access modifiers changed from: protected */
    public void U0() throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void V0() {
        X0();
        Y0();
        this.f25286c0 = -9223372036854775807L;
        this.f25303q0 = false;
        this.f25301p0 = false;
        this.Y = false;
        this.Z = false;
        this.f25290g0 = false;
        this.f25291h0 = false;
        this.f25314w.clear();
        this.f25307s0 = -9223372036854775807L;
        this.f25309t0 = -9223372036854775807L;
        this.I0 = -9223372036854775807L;
        C2Mp3TimestampTracker c2Mp3TimestampTracker = this.f25285b0;
        if (c2Mp3TimestampTracker != null) {
            c2Mp3TimestampTracker.c();
        }
        this.f25297n0 = 0;
        this.f25299o0 = 0;
        this.f25296m0 = this.f25295l0 ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void W0() {
        V0();
        this.F0 = null;
        this.f25285b0 = null;
        this.N = null;
        this.P = null;
        this.J = null;
        this.K = null;
        this.L = false;
        this.f25305r0 = false;
        this.M = -1.0f;
        this.Q = 0;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.f25284a0 = false;
        this.f25295l0 = false;
        this.f25296m0 = 0;
        this.E = false;
    }

    /* access modifiers changed from: protected */
    public MediaCodecDecoderException Z(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecDecoderException(th, mediaCodecInfo);
    }

    public boolean a() {
        return this.f25313v0;
    }

    /* access modifiers changed from: protected */
    public final void b1() {
        this.f25317x0 = true;
    }

    public final int c(Format format) throws ExoPlaybackException {
        try {
            return i1(this.f25300p, format);
        } catch (MediaCodecUtil.DecoderQueryException e2) {
            throw v(e2, format, 4002);
        }
    }

    /* access modifiers changed from: protected */
    public final void c1(ExoPlaybackException exoPlaybackException) {
        this.F0 = exoPlaybackException;
    }

    public void f(long j2, long j3) throws ExoPlaybackException {
        boolean z2 = false;
        if (this.f25317x0) {
            this.f25317x0 = false;
            O0();
        }
        ExoPlaybackException exoPlaybackException = this.F0;
        if (exoPlaybackException == null) {
            try {
                if (this.f25313v0) {
                    U0();
                } else if (this.f25319z != null || R0(2)) {
                    D0();
                    if (this.f25292i0) {
                        TraceUtil.a("bypassRender");
                        while (O(j2, j3)) {
                        }
                        TraceUtil.c();
                    } else if (this.I != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        TraceUtil.a("drainAndFeed");
                        while (e0(j2, j3) && e1(elapsedRealtime)) {
                        }
                        while (g0() && e1(elapsedRealtime)) {
                        }
                        TraceUtil.c();
                    } else {
                        this.G0.f23951d += M(j2);
                        R0(1);
                    }
                    this.G0.c();
                }
            } catch (IllegalStateException e2) {
                if (A0(e2)) {
                    F0(e2);
                    if (Util.f28808a >= 21 && C0(e2)) {
                        z2 = true;
                    }
                    if (z2) {
                        T0();
                    }
                    throw w(Z(e2, m0()), this.f25319z, z2, 4003);
                }
                throw e2;
            }
        } else {
            this.F0 = null;
            throw exoPlaybackException;
        }
    }

    /* access modifiers changed from: protected */
    public boolean f1(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean g1() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean h1(Format format) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean i0() throws ExoPlaybackException {
        boolean j02 = j0();
        if (j02) {
            D0();
        }
        return j02;
    }

    /* access modifiers changed from: protected */
    public abstract int i1(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException;

    public boolean isReady() {
        if (this.f25319z == null || (!C() && !w0() && (this.f25286c0 == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.f25286c0))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean j0() {
        boolean z2;
        if (this.I == null) {
            return false;
        }
        int i2 = this.f25299o0;
        if (i2 == 3 || this.S || ((this.T && !this.f25305r0) || (this.U && this.f25303q0))) {
            T0();
            return true;
        }
        if (i2 == 2) {
            int i3 = Util.f28808a;
            if (i3 >= 23) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            if (i3 >= 23) {
                try {
                    l1();
                } catch (ExoPlaybackException e2) {
                    Log.j("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e2);
                    T0();
                    return true;
                }
            }
        }
        h0();
        return false;
    }

    /* access modifiers changed from: protected */
    public final MediaCodecAdapter l0() {
        return this.I;
    }

    /* access modifiers changed from: protected */
    public final MediaCodecInfo m0() {
        return this.P;
    }

    /* access modifiers changed from: protected */
    public final void m1(long j2) throws ExoPlaybackException {
        boolean z2;
        Format j3 = this.H0.f25329d.j(j2);
        if (j3 == null && this.J0 && this.K != null) {
            j3 = this.H0.f25329d.i();
        }
        if (j3 != null) {
            this.A = j3;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || (this.L && this.A != null)) {
            J0(this.A, this.K);
            this.L = false;
            this.J0 = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean n0() {
        return false;
    }

    public void o(float f2, float f3) throws ExoPlaybackException {
        this.G = f2;
        this.H = f3;
        k1(this.J);
    }

    /* access modifiers changed from: protected */
    public abstract float o0(float f2, Format format, Format[] formatArr);

    public final int p() {
        return 8;
    }

    /* access modifiers changed from: protected */
    public final MediaFormat p0() {
        return this.K;
    }

    /* access modifiers changed from: protected */
    public abstract List<MediaCodecInfo> q0(MediaCodecSelector mediaCodecSelector, Format format, boolean z2) throws MediaCodecUtil.DecoderQueryException;

    /* access modifiers changed from: protected */
    public abstract MediaCodecAdapter.Configuration s0(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f2);

    /* access modifiers changed from: protected */
    public final long t0() {
        return this.H0.f25328c;
    }

    /* access modifiers changed from: protected */
    public float u0() {
        return this.G;
    }

    /* access modifiers changed from: protected */
    public void v0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    public static class DecoderInitializationException extends Exception {

        /* renamed from: b  reason: collision with root package name */
        public final String f25320b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f25321c;

        /* renamed from: d  reason: collision with root package name */
        public final MediaCodecInfo f25322d;

        /* renamed from: e  reason: collision with root package name */
        public final String f25323e;

        /* renamed from: f  reason: collision with root package name */
        public final DecoderInitializationException f25324f;

        public DecoderInitializationException(Format format, Throwable th, boolean z2, int i2) {
            this("Decoder init failed: [" + i2 + "], " + format, th, format.f23071m, z2, (MediaCodecInfo) null, b(i2), (DecoderInitializationException) null);
        }

        private static String b(int i2) {
            String str;
            if (i2 < 0) {
                str = "neg_";
            } else {
                str = "";
            }
            return "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + str + Math.abs(i2);
        }

        /* access modifiers changed from: private */
        public DecoderInitializationException c(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.f25320b, this.f25321c, this.f25322d, this.f25323e, decoderInitializationException);
        }

        private static String d(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public DecoderInitializationException(Format format, Throwable th, boolean z2, MediaCodecInfo mediaCodecInfo) {
            this("Decoder init failed: " + mediaCodecInfo.f25273a + ", " + format, th, format.f23071m, z2, mediaCodecInfo, Util.f28808a >= 21 ? d(th) : null, (DecoderInitializationException) null);
        }

        private DecoderInitializationException(String str, Throwable th, String str2, boolean z2, MediaCodecInfo mediaCodecInfo, String str3, DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.f25320b = str2;
            this.f25321c = z2;
            this.f25322d = mediaCodecInfo;
            this.f25323e = str3;
            this.f25324f = decoderInitializationException;
        }
    }
}
