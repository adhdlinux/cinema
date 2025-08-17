package androidx.media3.exoplayer.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.MediaClock;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.extractor.VorbisUtil;
import com.applovin.mediation.MaxErrorCode;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.common.collect.ImmutableList;
import e.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    private final Context P0;
    /* access modifiers changed from: private */
    public final AudioRendererEventListener.EventDispatcher Q0;
    private final AudioSink R0;
    private int S0;
    private boolean T0;
    private boolean U0;
    private Format V0;
    private Format W0;
    private long X0;
    private boolean Y0;
    private boolean Z0;
    /* access modifiers changed from: private */

    /* renamed from: a1  reason: collision with root package name */
    public boolean f5821a1;

    /* renamed from: b1  reason: collision with root package name */
    private int f5822b1 = MaxErrorCode.NETWORK_ERROR;

    /* renamed from: c1  reason: collision with root package name */
    private boolean f5823c1;

    /* renamed from: d1  reason: collision with root package name */
    private long f5824d1;

    private static final class Api23 {
        private Api23() {
        }

        public static void a(AudioSink audioSink, Object obj) {
            audioSink.setPreferredDevice((AudioDeviceInfo) obj);
        }
    }

    private final class AudioSinkListener implements AudioSink.Listener {
        private AudioSinkListener() {
        }

        public void a(Exception exc) {
            Log.d("MediaCodecAudioRenderer", "Audio sink error", exc);
            MediaCodecAudioRenderer.this.Q0.n(exc);
        }

        public void b(long j2) {
            MediaCodecAudioRenderer.this.Q0.H(j2);
        }

        public void c() {
            Renderer.WakeupListener O1 = MediaCodecAudioRenderer.this.N0();
            if (O1 != null) {
                O1.a();
            }
        }

        public void d(int i2, long j2, long j3) {
            MediaCodecAudioRenderer.this.Q0.J(i2, j2, j3);
        }

        public void e() {
            MediaCodecAudioRenderer.this.Y1();
        }

        public void f() {
            Renderer.WakeupListener N1 = MediaCodecAudioRenderer.this.N0();
            if (N1 != null) {
                N1.b();
            }
        }

        public void g() {
            boolean unused = MediaCodecAudioRenderer.this.f5821a1 = true;
        }

        public void h() {
            MediaCodecAudioRenderer.this.T();
        }

        public void m(AudioSink.AudioTrackConfig audioTrackConfig) {
            MediaCodecAudioRenderer.this.Q0.o(audioTrackConfig);
        }

        public void o(AudioSink.AudioTrackConfig audioTrackConfig) {
            MediaCodecAudioRenderer.this.Q0.p(audioTrackConfig);
        }

        public void onSkipSilenceEnabledChanged(boolean z2) {
            MediaCodecAudioRenderer.this.Q0.I(z2);
        }
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, boolean z2, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(1, factory, mediaCodecSelector, z2, 44100.0f);
        this.P0 = context.getApplicationContext();
        this.R0 = audioSink;
        this.Q0 = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        this.f5824d1 = -9223372036854775807L;
        audioSink.r(new AudioSinkListener());
    }

    private static boolean Q1(String str) {
        if (Util.f4714a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(Util.f4716c)) {
            String str2 = Util.f4715b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    private static boolean R1(String str) {
        if (str.equals("OMX.google.opus.decoder") || str.equals("c2.android.opus.decoder") || str.equals("OMX.google.vorbis.decoder") || str.equals("c2.android.vorbis.decoder")) {
            return true;
        }
        return false;
    }

    private static boolean S1() {
        if (Util.f4714a == 23) {
            String str = Util.f4717d;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int T1(Format format) {
        int i2;
        AudioOffloadSupport q2 = this.R0.q(format);
        if (!q2.f5649a) {
            return 0;
        }
        if (q2.f5650b) {
            i2 = 1536;
        } else {
            i2 = 512;
        }
        if (q2.f5651c) {
            return i2 | 2048;
        }
        return i2;
    }

    private int U1(MediaCodecInfo mediaCodecInfo, Format format) {
        int i2;
        if (!"OMX.google.raw.decoder".equals(mediaCodecInfo.f6687a) || (i2 = Util.f4714a) >= 24 || (i2 == 23 && Util.J0(this.P0))) {
            return format.f4016o;
        }
        return -1;
    }

    private static List<MediaCodecInfo> W1(MediaCodecSelector mediaCodecSelector, Format format, boolean z2, AudioSink audioSink) throws MediaCodecUtil.DecoderQueryException {
        MediaCodecInfo x2;
        if (format.f4015n == null) {
            return ImmutableList.r();
        }
        if (!audioSink.c(format) || (x2 = MediaCodecUtil.x()) == null) {
            return MediaCodecUtil.v(mediaCodecSelector, format, z2, false);
        }
        return ImmutableList.s(x2);
    }

    private void Z1() {
        MediaCodecAdapter A0 = A0();
        if (A0 != null && Util.f4714a >= 35) {
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.f5822b1));
            A0.b(bundle);
        }
    }

    private void a2() {
        long k2 = this.R0.k(a());
        if (k2 != Long.MIN_VALUE) {
            if (!this.Y0) {
                k2 = Math.max(this.X0, k2);
            }
            this.X0 = k2;
            this.Y0 = false;
        }
    }

    /* access modifiers changed from: protected */
    public float E0(float f2, Format format, Format[] formatArr) {
        int i2 = -1;
        for (Format format2 : formatArr) {
            int i3 = format2.C;
            if (i3 != -1) {
                i2 = Math.max(i2, i3);
            }
        }
        if (i2 == -1) {
            return -1.0f;
        }
        return f2 * ((float) i2);
    }

    /* access modifiers changed from: protected */
    public boolean F1(Format format) {
        if (H().f5508a != 0) {
            int T1 = T1(format);
            if ((T1 & 512) != 0) {
                if (H().f5508a == 2 || (T1 & 1024) != 0) {
                    return true;
                }
                if (format.E == 0 && format.F == 0) {
                    return true;
                }
            }
        }
        return this.R0.c(format);
    }

    /* access modifiers changed from: protected */
    public List<MediaCodecInfo> G0(MediaCodecSelector mediaCodecSelector, Format format, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.w(W1(mediaCodecSelector, format, z2, this.R0), format);
    }

    /* access modifiers changed from: protected */
    public int G1(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (!MimeTypes.o(format.f4015n)) {
            return x.a(0);
        }
        if (Util.f4714a >= 21) {
            i2 = 32;
        } else {
            i2 = 0;
        }
        boolean z4 = true;
        if (format.K != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean H1 = MediaCodecRenderer.H1(format);
        if (!H1 || (z2 && MediaCodecUtil.x() == null)) {
            i3 = 0;
        } else {
            int T1 = T1(format);
            if (this.R0.c(format)) {
                return x.c(4, 8, i2, T1);
            }
            i3 = T1;
        }
        if ("audio/raw".equals(format.f4015n) && !this.R0.c(format)) {
            return x.a(1);
        }
        if (!this.R0.c(Util.h0(2, format.B, format.C))) {
            return x.a(1);
        }
        List<MediaCodecInfo> W1 = W1(mediaCodecSelector, format, false, this.R0);
        if (W1.isEmpty()) {
            return x.a(1);
        }
        if (!H1) {
            return x.a(2);
        }
        MediaCodecInfo mediaCodecInfo = W1.get(0);
        boolean m2 = mediaCodecInfo.m(format);
        if (!m2) {
            int i8 = 1;
            while (true) {
                if (i8 >= W1.size()) {
                    break;
                }
                MediaCodecInfo mediaCodecInfo2 = W1.get(i8);
                if (mediaCodecInfo2.m(format)) {
                    mediaCodecInfo = mediaCodecInfo2;
                    z3 = false;
                    break;
                }
                i8++;
            }
        }
        z4 = m2;
        z3 = true;
        if (z4) {
            i4 = 4;
        } else {
            i4 = 3;
        }
        if (!z4 || !mediaCodecInfo.p(format)) {
            i5 = 8;
        } else {
            i5 = 16;
        }
        if (mediaCodecInfo.f6694h) {
            i6 = 64;
        } else {
            i6 = 0;
        }
        if (z3) {
            i7 = 128;
        } else {
            i7 = 0;
        }
        return x.e(i4, i5, i2, i6, i7, i3);
    }

    public long H0(boolean z2, long j2, long j3) {
        float f2;
        long j4 = this.f5824d1;
        if (j4 == -9223372036854775807L) {
            return super.H0(z2, j2, j3);
        }
        float f3 = (float) (j4 - j2);
        if (b() != null) {
            f2 = b().f4306a;
        } else {
            f2 = 1.0f;
        }
        long j5 = (long) ((f3 / f2) / 2.0f);
        if (this.f5823c1) {
            j5 -= Util.P0(G().elapsedRealtime()) - j3;
        }
        return Math.max(NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS, j5);
    }

    /* access modifiers changed from: protected */
    public MediaCodecAdapter.Configuration J0(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f2) {
        boolean z2;
        Format format2;
        this.S0 = V1(mediaCodecInfo, format, M());
        this.T0 = Q1(mediaCodecInfo.f6687a);
        this.U0 = R1(mediaCodecInfo.f6687a);
        MediaFormat X1 = X1(format, mediaCodecInfo.f6689c, this.S0, f2);
        if (!"audio/raw".equals(mediaCodecInfo.f6688b) || "audio/raw".equals(format.f4015n)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            format2 = format;
        } else {
            format2 = null;
        }
        this.W0 = format2;
        return MediaCodecAdapter.Configuration.a(mediaCodecInfo, X1, format, mediaCrypto);
    }

    /* access modifiers changed from: protected */
    public void O() {
        this.Z0 = true;
        this.V0 = null;
        try {
            this.R0.flush();
            try {
                super.O();
            } finally {
                this.Q0.s(this.K0);
            }
        } catch (Throwable th) {
            super.O();
            throw th;
        } finally {
            this.Q0.s(this.K0);
        }
    }

    /* access modifiers changed from: protected */
    public void O0(DecoderInputBuffer decoderInputBuffer) {
        Format format;
        if (Util.f4714a >= 29 && (format = decoderInputBuffer.f5065b) != null && Objects.equals(format.f4015n, "audio/opus") && U0()) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.f(decoderInputBuffer.f5070g);
            int i2 = ((Format) Assertions.f(decoderInputBuffer.f5065b)).E;
            if (byteBuffer.remaining() == 8) {
                this.R0.u(i2, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void P(boolean z2, boolean z3) throws ExoPlaybackException {
        super.P(z2, z3);
        this.Q0.t(this.K0);
        if (H().f5509b) {
            this.R0.n();
        } else {
            this.R0.h();
        }
        this.R0.v(L());
        this.R0.y(G());
    }

    /* access modifiers changed from: protected */
    public void R(long j2, boolean z2) throws ExoPlaybackException {
        super.R(j2, z2);
        this.R0.flush();
        this.X0 = j2;
        this.f5821a1 = false;
        this.Y0 = true;
    }

    /* access modifiers changed from: protected */
    public void S() {
        this.R0.release();
    }

    /* access modifiers changed from: protected */
    public void U() {
        this.f5821a1 = false;
        try {
            super.U();
        } finally {
            if (this.Z0) {
                this.Z0 = false;
                this.R0.reset();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void V() {
        super.V();
        this.R0.play();
        this.f5823c1 = true;
    }

    /* access modifiers changed from: protected */
    public int V1(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int U1 = U1(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            return U1;
        }
        for (Format format2 : formatArr) {
            if (mediaCodecInfo.e(format, format2).f5165d != 0) {
                U1 = Math.max(U1, U1(mediaCodecInfo, format2));
            }
        }
        return U1;
    }

    /* access modifiers changed from: protected */
    public void W() {
        a2();
        this.f5823c1 = false;
        this.R0.pause();
        super.W();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    public MediaFormat X1(Format format, String str, int i2, float f2) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", format.B);
        mediaFormat.setInteger("sample-rate", format.C);
        MediaFormatUtil.e(mediaFormat, format.f4018q);
        MediaFormatUtil.d(mediaFormat, "max-input-size", i2);
        int i3 = Util.f4714a;
        if (i3 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f2 != -1.0f && !S1()) {
                mediaFormat.setFloat("operating-rate", f2);
            }
        }
        if (i3 <= 28 && "audio/ac4".equals(format.f4015n)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i3 >= 24 && this.R0.w(Util.h0(4, format.B, format.C)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i3 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        if (i3 >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.f5822b1));
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    public void Y1() {
        this.Y0 = true;
    }

    public boolean a() {
        return super.a() && this.R0.a();
    }

    public PlaybackParameters b() {
        return this.R0.b();
    }

    /* access modifiers changed from: protected */
    public void c1(Exception exc) {
        Log.d("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.Q0.m(exc);
    }

    /* access modifiers changed from: protected */
    public void d1(String str, MediaCodecAdapter.Configuration configuration, long j2, long j3) {
        this.Q0.q(str, j2, j3);
    }

    public void e(PlaybackParameters playbackParameters) {
        this.R0.e(playbackParameters);
    }

    /* access modifiers changed from: protected */
    public void e1(String str) {
        this.Q0.r(str);
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation f0(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        int i2;
        DecoderReuseEvaluation e2 = mediaCodecInfo.e(format, format2);
        int i3 = e2.f5166e;
        if (V0(format2)) {
            i3 |= 32768;
        }
        if (U1(mediaCodecInfo, format2) > this.S0) {
            i3 |= 64;
        }
        int i4 = i3;
        String str = mediaCodecInfo.f6687a;
        if (i4 != 0) {
            i2 = 0;
        } else {
            i2 = e2.f5165d;
        }
        return new DecoderReuseEvaluation(str, format, format2, i2, i4);
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation f1(FormatHolder formatHolder) throws ExoPlaybackException {
        Format format = (Format) Assertions.f(formatHolder.f5385b);
        this.V0 = format;
        DecoderReuseEvaluation f12 = super.f1(formatHolder);
        this.Q0.u(format, f12);
        return f12;
    }

    /* access modifiers changed from: protected */
    public void g1(Format format, MediaFormat mediaFormat) throws ExoPlaybackException {
        int i2;
        int i3;
        Format format2 = this.W0;
        int[] iArr = null;
        if (format2 != null) {
            format = format2;
        } else if (A0() != null) {
            Assertions.f(mediaFormat);
            if ("audio/raw".equals(format.f4015n)) {
                i2 = format.D;
            } else if (Util.f4714a >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                i2 = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                i2 = Util.g0(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                i2 = 2;
            }
            Format K = new Format.Builder().o0("audio/raw").i0(i2).V(format.E).W(format.F).h0(format.f4012k).T(format.f4013l).a0(format.f4002a).c0(format.f4003b).d0(format.f4004c).e0(format.f4005d).q0(format.f4006e).m0(format.f4007f).N(mediaFormat.getInteger("channel-count")).p0(mediaFormat.getInteger("sample-rate")).K();
            if (this.T0 && K.B == 6 && (i3 = format.B) < 6) {
                iArr = new int[i3];
                for (int i4 = 0; i4 < format.B; i4++) {
                    iArr[i4] = i4;
                }
            } else if (this.U0) {
                iArr = VorbisUtil.a(K.B);
            }
            format = K;
        }
        try {
            if (Util.f4714a >= 29) {
                if (!U0() || H().f5508a == 0) {
                    this.R0.s(0);
                } else {
                    this.R0.s(H().f5508a);
                }
            }
            this.R0.t(format, 0, iArr);
        } catch (AudioSink.ConfigurationException e2) {
            throw E(e2, e2.f5663b, 5001);
        }
    }

    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    /* access modifiers changed from: protected */
    public void h1(long j2) {
        this.R0.l(j2);
    }

    public boolean isReady() {
        return this.R0.f() || super.isReady();
    }

    public void j(int i2, Object obj) throws ExoPlaybackException {
        if (i2 == 2) {
            this.R0.d(((Float) Assertions.f(obj)).floatValue());
        } else if (i2 == 3) {
            this.R0.p((AudioAttributes) Assertions.f((AudioAttributes) obj));
        } else if (i2 == 6) {
            this.R0.x((AuxEffectInfo) Assertions.f((AuxEffectInfo) obj));
        } else if (i2 != 12) {
            if (i2 == 16) {
                this.f5822b1 = ((Integer) Assertions.f(obj)).intValue();
                Z1();
            } else if (i2 == 9) {
                this.R0.o(((Boolean) Assertions.f(obj)).booleanValue());
            } else if (i2 != 10) {
                super.j(i2, obj);
            } else {
                this.R0.g(((Integer) Assertions.f(obj)).intValue());
            }
        } else if (Util.f4714a >= 23) {
            Api23.a(this.R0, obj);
        }
    }

    /* access modifiers changed from: protected */
    public void j1() {
        super.j1();
        this.R0.m();
    }

    public long n() {
        if (getState() == 2) {
            a2();
        }
        return this.X0;
    }

    /* access modifiers changed from: protected */
    public boolean n1(long j2, long j3, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i2, int i3, int i4, long j4, boolean z2, boolean z3, Format format) throws ExoPlaybackException {
        int i5;
        int i6;
        Assertions.f(byteBuffer);
        this.f5824d1 = -9223372036854775807L;
        if (this.W0 != null && (i3 & 2) != 0) {
            ((MediaCodecAdapter) Assertions.f(mediaCodecAdapter)).l(i2, false);
            return true;
        } else if (z2) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.l(i2, false);
            }
            this.K0.f5155f += i4;
            this.R0.m();
            return true;
        } else {
            try {
                if (this.R0.i(byteBuffer, j4, i4)) {
                    if (mediaCodecAdapter != null) {
                        mediaCodecAdapter.l(i2, false);
                    }
                    this.K0.f5154e += i4;
                    return true;
                }
                this.f5824d1 = j4;
                return false;
            } catch (AudioSink.InitializationException e2) {
                Format format2 = this.V0;
                boolean z4 = e2.f5665c;
                if (!U0() || H().f5508a == 0) {
                    i5 = 5001;
                } else {
                    i5 = 5004;
                }
                throw F(e2, format2, z4, i5);
            } catch (AudioSink.WriteException e3) {
                boolean z5 = e3.f5670c;
                if (!U0() || H().f5508a == 0) {
                    i6 = 5002;
                } else {
                    i6 = 5003;
                }
                throw F(e3, format, z5, i6);
            }
        }
    }

    public MediaClock s() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void s1() throws ExoPlaybackException {
        int i2;
        try {
            this.R0.j();
            if (I0() != -9223372036854775807L) {
                this.f5824d1 = I0();
            }
        } catch (AudioSink.WriteException e2) {
            Format format = e2.f5671d;
            boolean z2 = e2.f5670c;
            if (U0()) {
                i2 = 5003;
            } else {
                i2 = 5002;
            }
            throw F(e2, format, z2, i2);
        }
    }

    public boolean w() {
        boolean z2 = this.f5821a1;
        this.f5821a1 = false;
        return z2;
    }
}
