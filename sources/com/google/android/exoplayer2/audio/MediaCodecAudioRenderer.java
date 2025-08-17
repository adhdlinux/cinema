package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.b2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;

public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    private final Context L0;
    /* access modifiers changed from: private */
    public final AudioRendererEventListener.EventDispatcher M0;
    private final AudioSink N0;
    private int O0;
    private boolean P0;
    private Format Q0;
    private Format R0;
    private long S0;
    private boolean T0;
    private boolean U0;
    private boolean V0;
    private boolean W0;
    /* access modifiers changed from: private */
    public Renderer.WakeupListener X0;

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
            MediaCodecAudioRenderer.this.M0.l(exc);
        }

        public void b(long j2) {
            MediaCodecAudioRenderer.this.M0.B(j2);
        }

        public void c() {
            if (MediaCodecAudioRenderer.this.X0 != null) {
                MediaCodecAudioRenderer.this.X0.a();
            }
        }

        public void d(int i2, long j2, long j3) {
            MediaCodecAudioRenderer.this.M0.D(i2, j2, j3);
        }

        public void e() {
            MediaCodecAudioRenderer.this.v1();
        }

        public void f() {
            if (MediaCodecAudioRenderer.this.X0 != null) {
                MediaCodecAudioRenderer.this.X0.b();
            }
        }

        public void onSkipSilenceEnabledChanged(boolean z2) {
            MediaCodecAudioRenderer.this.M0.C(z2);
        }
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, boolean z2, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(1, factory, mediaCodecSelector, z2, 44100.0f);
        this.L0 = context.getApplicationContext();
        this.N0 = audioSink;
        this.M0 = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        audioSink.r(new AudioSinkListener());
    }

    private static boolean p1(String str) {
        if (Util.f28808a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(Util.f28810c)) {
            String str2 = Util.f28809b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    private static boolean q1() {
        if (Util.f28808a == 23) {
            String str = Util.f28811d;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int r1(MediaCodecInfo mediaCodecInfo, Format format) {
        int i2;
        if (!"OMX.google.raw.decoder".equals(mediaCodecInfo.f25273a) || (i2 = Util.f28808a) >= 24 || (i2 == 23 && Util.A0(this.L0))) {
            return format.f23072n;
        }
        return -1;
    }

    private static List<MediaCodecInfo> t1(MediaCodecSelector mediaCodecSelector, Format format, boolean z2, AudioSink audioSink) throws MediaCodecUtil.DecoderQueryException {
        MediaCodecInfo v2;
        String str = format.f23071m;
        if (str == null) {
            return ImmutableList.r();
        }
        if (audioSink.c(format) && (v2 = MediaCodecUtil.v()) != null) {
            return ImmutableList.s(v2);
        }
        List<MediaCodecInfo> a2 = mediaCodecSelector.a(str, z2, false);
        String m2 = MediaCodecUtil.m(format);
        if (m2 == null) {
            return ImmutableList.n(a2);
        }
        return ImmutableList.k().j(a2).j(mediaCodecSelector.a(m2, z2, false)).k();
    }

    private void w1() {
        long k2 = this.N0.k(a());
        if (k2 != Long.MIN_VALUE) {
            if (!this.U0) {
                k2 = Math.max(this.S0, k2);
            }
            this.S0 = k2;
            this.U0 = false;
        }
    }

    /* access modifiers changed from: protected */
    public void D() {
        this.V0 = true;
        this.Q0 = null;
        try {
            this.N0.flush();
            try {
                super.D();
            } finally {
                this.M0.o(this.G0);
            }
        } catch (Throwable th) {
            super.D();
            throw th;
        } finally {
            this.M0.o(this.G0);
        }
    }

    /* access modifiers changed from: protected */
    public void E(boolean z2, boolean z3) throws ExoPlaybackException {
        super.E(z2, z3);
        this.M0.p(this.G0);
        if (x().f23451a) {
            this.N0.n();
        } else {
            this.N0.h();
        }
        this.N0.q(A());
    }

    /* access modifiers changed from: protected */
    public void F(long j2, boolean z2) throws ExoPlaybackException {
        super.F(j2, z2);
        if (this.W0) {
            this.N0.t();
        } else {
            this.N0.flush();
        }
        this.S0 = j2;
        this.T0 = true;
        this.U0 = true;
    }

    /* access modifiers changed from: protected */
    public void F0(Exception exc) {
        Log.d("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.M0.k(exc);
    }

    /* access modifiers changed from: protected */
    public void G() {
        try {
            super.G();
        } finally {
            if (this.V0) {
                this.V0 = false;
                this.N0.reset();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void G0(String str, MediaCodecAdapter.Configuration configuration, long j2, long j3) {
        this.M0.m(str, j2, j3);
    }

    /* access modifiers changed from: protected */
    public void H() {
        super.H();
        this.N0.play();
    }

    /* access modifiers changed from: protected */
    public void H0(String str) {
        this.M0.n(str);
    }

    /* access modifiers changed from: protected */
    public void I() {
        w1();
        this.N0.pause();
        super.I();
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation I0(FormatHolder formatHolder) throws ExoPlaybackException {
        this.Q0 = (Format) Assertions.e(formatHolder.f23112b);
        DecoderReuseEvaluation I0 = super.I0(formatHolder);
        this.M0.q(this.Q0, I0);
        return I0;
    }

    /* access modifiers changed from: protected */
    public void J0(Format format, MediaFormat mediaFormat) throws ExoPlaybackException {
        int i2;
        int i3;
        Format format2 = this.R0;
        int[] iArr = null;
        if (format2 != null) {
            format = format2;
        } else if (l0() != null) {
            if ("audio/raw".equals(format.f23071m)) {
                i2 = format.B;
            } else if (Util.f28808a >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                i2 = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                i2 = Util.d0(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                i2 = 2;
            }
            Format G = new Format.Builder().g0("audio/raw").a0(i2).P(format.C).Q(format.D).J(mediaFormat.getInteger("channel-count")).h0(mediaFormat.getInteger("sample-rate")).G();
            if (this.P0 && G.f23084z == 6 && (i3 = format.f23084z) < 6) {
                iArr = new int[i3];
                for (int i4 = 0; i4 < format.f23084z; i4++) {
                    iArr[i4] = i4;
                }
            }
            format = G;
        }
        try {
            this.N0.v(format, 0, iArr);
        } catch (AudioSink.ConfigurationException e2) {
            throw v(e2, e2.f23688b, 5001);
        }
    }

    /* access modifiers changed from: protected */
    public void K0(long j2) {
        this.N0.l(j2);
    }

    /* access modifiers changed from: protected */
    public void M0() {
        super.M0();
        this.N0.m();
    }

    /* access modifiers changed from: protected */
    public void N0(DecoderInputBuffer decoderInputBuffer) {
        if (this.T0 && !decoderInputBuffer.j()) {
            if (Math.abs(decoderInputBuffer.f23963f - this.S0) > 500000) {
                this.S0 = decoderInputBuffer.f23963f;
            }
            this.T0 = false;
        }
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation P(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        int i2;
        DecoderReuseEvaluation f2 = mediaCodecInfo.f(format, format2);
        int i3 = f2.f23975e;
        if (r1(mediaCodecInfo, format2) > this.O0) {
            i3 |= 64;
        }
        int i4 = i3;
        String str = mediaCodecInfo.f25273a;
        if (i4 != 0) {
            i2 = 0;
        } else {
            i2 = f2.f23974d;
        }
        return new DecoderReuseEvaluation(str, format, format2, i2, i4);
    }

    /* access modifiers changed from: protected */
    public boolean P0(long j2, long j3, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i2, int i3, int i4, long j4, boolean z2, boolean z3, Format format) throws ExoPlaybackException {
        Assertions.e(byteBuffer);
        if (this.R0 != null && (i3 & 2) != 0) {
            ((MediaCodecAdapter) Assertions.e(mediaCodecAdapter)).l(i2, false);
            return true;
        } else if (z2) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.l(i2, false);
            }
            this.G0.f23953f += i4;
            this.N0.m();
            return true;
        } else {
            try {
                if (!this.N0.i(byteBuffer, j4, i4)) {
                    return false;
                }
                if (mediaCodecAdapter != null) {
                    mediaCodecAdapter.l(i2, false);
                }
                this.G0.f23952e += i4;
                return true;
            } catch (AudioSink.InitializationException e2) {
                throw w(e2, this.Q0, e2.f23690c, 5001);
            } catch (AudioSink.WriteException e3) {
                throw w(e3, format, e3.f23695c, 5002);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void U0() throws ExoPlaybackException {
        try {
            this.N0.j();
        } catch (AudioSink.WriteException e2) {
            throw w(e2, e2.f23696d, e2.f23695c, 5002);
        }
    }

    public boolean a() {
        return super.a() && this.N0.a();
    }

    public PlaybackParameters b() {
        return this.N0.b();
    }

    public void e(PlaybackParameters playbackParameters) {
        this.N0.e(playbackParameters);
    }

    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    /* access modifiers changed from: protected */
    public boolean h1(Format format) {
        return this.N0.c(format);
    }

    /* access modifiers changed from: protected */
    public int i1(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i2;
        boolean z2;
        boolean z3;
        int i3;
        int i4 = 0;
        if (!MimeTypes.o(format.f23071m)) {
            return b2.a(0);
        }
        if (Util.f28808a >= 21) {
            i2 = 32;
        } else {
            i2 = 0;
        }
        boolean z4 = true;
        if (format.H != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean j12 = MediaCodecRenderer.j1(format);
        int i5 = 8;
        int i6 = 4;
        if (j12 && this.N0.c(format) && (!z2 || MediaCodecUtil.v() != null)) {
            return b2.b(4, 8, i2);
        }
        if ("audio/raw".equals(format.f23071m) && !this.N0.c(format)) {
            return b2.a(1);
        }
        if (!this.N0.c(Util.e0(2, format.f23084z, format.A))) {
            return b2.a(1);
        }
        List<MediaCodecInfo> t1 = t1(mediaCodecSelector, format, false, this.N0);
        if (t1.isEmpty()) {
            return b2.a(1);
        }
        if (!j12) {
            return b2.a(2);
        }
        MediaCodecInfo mediaCodecInfo = t1.get(0);
        boolean o2 = mediaCodecInfo.o(format);
        if (!o2) {
            int i7 = 1;
            while (true) {
                if (i7 >= t1.size()) {
                    break;
                }
                MediaCodecInfo mediaCodecInfo2 = t1.get(i7);
                if (mediaCodecInfo2.o(format)) {
                    mediaCodecInfo = mediaCodecInfo2;
                    z3 = false;
                    break;
                }
                i7++;
            }
        }
        z4 = o2;
        z3 = true;
        if (!z4) {
            i6 = 3;
        }
        if (z4 && mediaCodecInfo.r(format)) {
            i5 = 16;
        }
        if (mediaCodecInfo.f25280h) {
            i3 = 64;
        } else {
            i3 = 0;
        }
        if (z3) {
            i4 = 128;
        }
        return b2.c(i6, i5, i2, i3, i4);
    }

    public boolean isReady() {
        return this.N0.f() || super.isReady();
    }

    public void j(int i2, Object obj) throws ExoPlaybackException {
        if (i2 == 2) {
            this.N0.d(((Float) obj).floatValue());
        } else if (i2 == 3) {
            this.N0.p((AudioAttributes) obj);
        } else if (i2 != 6) {
            switch (i2) {
                case 9:
                    this.N0.o(((Boolean) obj).booleanValue());
                    return;
                case 10:
                    this.N0.g(((Integer) obj).intValue());
                    return;
                case 11:
                    this.X0 = (Renderer.WakeupListener) obj;
                    return;
                case 12:
                    if (Util.f28808a >= 23) {
                        Api23.a(this.N0, obj);
                        return;
                    }
                    return;
                default:
                    super.j(i2, obj);
                    return;
            }
        } else {
            this.N0.u((AuxEffectInfo) obj);
        }
    }

    public long n() {
        if (getState() == 2) {
            w1();
        }
        return this.S0;
    }

    /* access modifiers changed from: protected */
    public float o0(float f2, Format format, Format[] formatArr) {
        int i2 = -1;
        for (Format format2 : formatArr) {
            int i3 = format2.A;
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
    public List<MediaCodecInfo> q0(MediaCodecSelector mediaCodecSelector, Format format, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.u(t1(mediaCodecSelector, format, z2, this.N0), format);
    }

    public MediaClock s() {
        return this;
    }

    /* access modifiers changed from: protected */
    public MediaCodecAdapter.Configuration s0(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f2) {
        boolean z2;
        Format format2;
        this.O0 = s1(mediaCodecInfo, format, B());
        this.P0 = p1(mediaCodecInfo.f25273a);
        MediaFormat u1 = u1(format, mediaCodecInfo.f25275c, this.O0, f2);
        if (!"audio/raw".equals(mediaCodecInfo.f25274b) || "audio/raw".equals(format.f23071m)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            format2 = format;
        } else {
            format2 = null;
        }
        this.R0 = format2;
        return MediaCodecAdapter.Configuration.a(mediaCodecInfo, u1, format, mediaCrypto);
    }

    /* access modifiers changed from: protected */
    public int s1(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int r12 = r1(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            return r12;
        }
        for (Format format2 : formatArr) {
            if (mediaCodecInfo.f(format, format2).f23974d != 0) {
                r12 = Math.max(r12, r1(mediaCodecInfo, format2));
            }
        }
        return r12;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    public MediaFormat u1(Format format, String str, int i2, float f2) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", format.f23084z);
        mediaFormat.setInteger("sample-rate", format.A);
        MediaFormatUtil.e(mediaFormat, format.f23073o);
        MediaFormatUtil.d(mediaFormat, "max-input-size", i2);
        int i3 = Util.f28808a;
        if (i3 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f2 != -1.0f && !q1()) {
                mediaFormat.setFloat("operating-rate", f2);
            }
        }
        if (i3 <= 28 && "audio/ac4".equals(format.f23071m)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i3 >= 24 && this.N0.s(Util.e0(4, format.f23084z, format.A)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i3 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    public void v1() {
        this.U0 = true;
    }
}
