package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.audio.AudioProcessingPipeline;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.AudioProcessorChain;
import androidx.media3.common.audio.SonicAudioProcessor;
import androidx.media3.common.audio.ToInt16PcmAudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.AudioTrackPositionTracker;
import androidx.media3.exoplayer.audio.DefaultAudioTrackBufferSizeProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class DefaultAudioSink implements AudioSink {

    /* renamed from: n0  reason: collision with root package name */
    public static boolean f5724n0 = false;

    /* renamed from: o0  reason: collision with root package name */
    private static final Object f5725o0 = new Object();

    /* renamed from: p0  reason: collision with root package name */
    private static ExecutorService f5726p0;

    /* renamed from: q0  reason: collision with root package name */
    private static int f5727q0;
    private OnRoutingChangedListenerApi24 A;
    private AudioAttributes B;
    private MediaPositionParameters C;
    private MediaPositionParameters D;
    private PlaybackParameters E;
    private boolean F;
    private ByteBuffer G;
    private int H;
    private long I;
    private long J;
    private long K;
    private long L;
    private int M;
    private boolean N;
    private boolean O;
    private long P;
    private float Q;
    private ByteBuffer R;
    private int S;
    private ByteBuffer T;
    private byte[] U;
    private int V;
    private boolean W;
    private boolean X;
    /* access modifiers changed from: private */
    public boolean Y;
    /* access modifiers changed from: private */
    public boolean Z;

    /* renamed from: a  reason: collision with root package name */
    private final Context f5728a;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f5729a0;

    /* renamed from: b  reason: collision with root package name */
    private final AudioProcessorChain f5730b;

    /* renamed from: b0  reason: collision with root package name */
    private int f5731b0;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f5732c;

    /* renamed from: c0  reason: collision with root package name */
    private AuxEffectInfo f5733c0;

    /* renamed from: d  reason: collision with root package name */
    private final ChannelMappingAudioProcessor f5734d;

    /* renamed from: d0  reason: collision with root package name */
    private AudioDeviceInfoApi23 f5735d0;

    /* renamed from: e  reason: collision with root package name */
    private final TrimmingAudioProcessor f5736e;

    /* renamed from: e0  reason: collision with root package name */
    private boolean f5737e0;

    /* renamed from: f  reason: collision with root package name */
    private final ImmutableList<AudioProcessor> f5738f;

    /* renamed from: f0  reason: collision with root package name */
    private long f5739f0;

    /* renamed from: g  reason: collision with root package name */
    private final ImmutableList<AudioProcessor> f5740g;
    /* access modifiers changed from: private */

    /* renamed from: g0  reason: collision with root package name */
    public long f5741g0;

    /* renamed from: h  reason: collision with root package name */
    private final ConditionVariable f5742h;

    /* renamed from: h0  reason: collision with root package name */
    private boolean f5743h0;

    /* renamed from: i  reason: collision with root package name */
    private final AudioTrackPositionTracker f5744i;

    /* renamed from: i0  reason: collision with root package name */
    private boolean f5745i0;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayDeque<MediaPositionParameters> f5746j;

    /* renamed from: j0  reason: collision with root package name */
    private Looper f5747j0;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f5748k;

    /* renamed from: k0  reason: collision with root package name */
    private long f5749k0;

    /* renamed from: l  reason: collision with root package name */
    private int f5750l;

    /* renamed from: l0  reason: collision with root package name */
    private long f5751l0;

    /* renamed from: m  reason: collision with root package name */
    private StreamEventCallbackV29 f5752m;

    /* renamed from: m0  reason: collision with root package name */
    private Handler f5753m0;

    /* renamed from: n  reason: collision with root package name */
    private final PendingExceptionHolder<AudioSink.InitializationException> f5754n;

    /* renamed from: o  reason: collision with root package name */
    private final PendingExceptionHolder<AudioSink.WriteException> f5755o;

    /* renamed from: p  reason: collision with root package name */
    private final AudioTrackBufferSizeProvider f5756p;

    /* renamed from: q  reason: collision with root package name */
    private final AudioOffloadSupportProvider f5757q;

    /* renamed from: r  reason: collision with root package name */
    private final ExoPlayer.AudioOffloadListener f5758r;

    /* renamed from: s  reason: collision with root package name */
    private PlayerId f5759s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public AudioSink.Listener f5760t;

    /* renamed from: u  reason: collision with root package name */
    private Configuration f5761u;

    /* renamed from: v  reason: collision with root package name */
    private Configuration f5762v;

    /* renamed from: w  reason: collision with root package name */
    private AudioProcessingPipeline f5763w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public AudioTrack f5764x;

    /* renamed from: y  reason: collision with root package name */
    private AudioCapabilities f5765y;

    /* renamed from: z  reason: collision with root package name */
    private AudioCapabilitiesReceiver f5766z;

    private static final class Api23 {
        private Api23() {
        }

        public static void a(AudioTrack audioTrack, AudioDeviceInfoApi23 audioDeviceInfoApi23) {
            AudioDeviceInfo audioDeviceInfo;
            if (audioDeviceInfoApi23 == null) {
                audioDeviceInfo = null;
            } else {
                audioDeviceInfo = audioDeviceInfoApi23.f5647a;
            }
            boolean unused = audioTrack.setPreferredDevice(audioDeviceInfo);
        }
    }

    private static final class Api31 {
        private Api31() {
        }

        public static void a(AudioTrack audioTrack, PlayerId playerId) {
            LogSessionId a2 = playerId.a();
            if (!a2.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                audioTrack.setLogSessionId(a2);
            }
        }
    }

    public interface AudioOffloadSupportProvider {
        AudioOffloadSupport a(Format format, AudioAttributes audioAttributes);
    }

    public interface AudioTrackBufferSizeProvider {

        /* renamed from: a  reason: collision with root package name */
        public static final AudioTrackBufferSizeProvider f5767a = new DefaultAudioTrackBufferSizeProvider.Builder().h();

        int a(int i2, int i3, int i4, int i5, int i6, int i7, double d2);
    }

    private static final class Configuration {

        /* renamed from: a  reason: collision with root package name */
        public final Format f5777a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5778b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5779c;

        /* renamed from: d  reason: collision with root package name */
        public final int f5780d;

        /* renamed from: e  reason: collision with root package name */
        public final int f5781e;

        /* renamed from: f  reason: collision with root package name */
        public final int f5782f;

        /* renamed from: g  reason: collision with root package name */
        public final int f5783g;

        /* renamed from: h  reason: collision with root package name */
        public final int f5784h;

        /* renamed from: i  reason: collision with root package name */
        public final AudioProcessingPipeline f5785i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f5786j;

        /* renamed from: k  reason: collision with root package name */
        public final boolean f5787k;

        /* renamed from: l  reason: collision with root package name */
        public final boolean f5788l;

        public Configuration(Format format, int i2, int i3, int i4, int i5, int i6, int i7, int i8, AudioProcessingPipeline audioProcessingPipeline, boolean z2, boolean z3, boolean z4) {
            this.f5777a = format;
            this.f5778b = i2;
            this.f5779c = i3;
            this.f5780d = i4;
            this.f5781e = i5;
            this.f5782f = i6;
            this.f5783g = i7;
            this.f5784h = i8;
            this.f5785i = audioProcessingPipeline;
            this.f5786j = z2;
            this.f5787k = z3;
            this.f5788l = z4;
        }

        private AudioTrack e(AudioAttributes audioAttributes, int i2) {
            int i3 = Util.f4714a;
            if (i3 >= 29) {
                return g(audioAttributes, i2);
            }
            if (i3 >= 21) {
                return f(audioAttributes, i2);
            }
            return h(audioAttributes, i2);
        }

        private AudioTrack f(AudioAttributes audioAttributes, int i2) {
            return new AudioTrack(j(audioAttributes, this.f5788l), Util.L(this.f5781e, this.f5782f, this.f5783g), this.f5784h, 1, i2);
        }

        private AudioTrack g(AudioAttributes audioAttributes, int i2) {
            AudioTrack.Builder a2 = new AudioTrack.Builder().setAudioAttributes(j(audioAttributes, this.f5788l)).setAudioFormat(Util.L(this.f5781e, this.f5782f, this.f5783g));
            boolean z2 = true;
            AudioTrack.Builder a3 = a2.setTransferMode(1).setBufferSizeInBytes(this.f5784h).setSessionId(i2);
            if (this.f5779c != 1) {
                z2 = false;
            }
            return a3.setOffloadedPlayback(z2).build();
        }

        private AudioTrack h(AudioAttributes audioAttributes, int i2) {
            int m02 = Util.m0(audioAttributes.f3917c);
            if (i2 == 0) {
                return new AudioTrack(m02, this.f5781e, this.f5782f, this.f5783g, this.f5784h, 1);
            }
            return new AudioTrack(m02, this.f5781e, this.f5782f, this.f5783g, this.f5784h, 1, i2);
        }

        private static android.media.AudioAttributes j(AudioAttributes audioAttributes, boolean z2) {
            if (z2) {
                return k();
            }
            return audioAttributes.a().f3921a;
        }

        private static android.media.AudioAttributes k() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public AudioTrack a(androidx.media3.common.AudioAttributes audioAttributes, int i2) throws AudioSink.InitializationException {
            try {
                AudioTrack e2 = e(audioAttributes, i2);
                int state = e2.getState();
                if (state == 1) {
                    return e2;
                }
                try {
                    e2.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.f5781e, this.f5782f, this.f5784h, this.f5777a, m(), (Exception) null);
            } catch (IllegalArgumentException | UnsupportedOperationException e3) {
                throw new AudioSink.InitializationException(0, this.f5781e, this.f5782f, this.f5784h, this.f5777a, m(), e3);
            }
        }

        public AudioSink.AudioTrackConfig b() {
            int i2 = this.f5783g;
            int i3 = this.f5781e;
            int i4 = this.f5782f;
            boolean z2 = this.f5788l;
            boolean z3 = true;
            if (this.f5779c != 1) {
                z3 = false;
            }
            return new AudioSink.AudioTrackConfig(i2, i3, i4, z2, z3, this.f5784h);
        }

        public boolean c(Configuration configuration) {
            return configuration.f5779c == this.f5779c && configuration.f5783g == this.f5783g && configuration.f5781e == this.f5781e && configuration.f5782f == this.f5782f && configuration.f5780d == this.f5780d && configuration.f5786j == this.f5786j && configuration.f5787k == this.f5787k;
        }

        public Configuration d(int i2) {
            return new Configuration(this.f5777a, this.f5778b, this.f5779c, this.f5780d, this.f5781e, this.f5782f, this.f5783g, i2, this.f5785i, this.f5786j, this.f5787k, this.f5788l);
        }

        public long i(long j2) {
            return Util.b1(j2, this.f5781e);
        }

        public long l(long j2) {
            return Util.b1(j2, this.f5777a.C);
        }

        public boolean m() {
            return this.f5779c == 1;
        }
    }

    public static class DefaultAudioProcessorChain implements AudioProcessorChain {

        /* renamed from: a  reason: collision with root package name */
        private final AudioProcessor[] f5789a;

        /* renamed from: b  reason: collision with root package name */
        private final SilenceSkippingAudioProcessor f5790b;

        /* renamed from: c  reason: collision with root package name */
        private final SonicAudioProcessor f5791c;

        public DefaultAudioProcessorChain(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new SilenceSkippingAudioProcessor(), new SonicAudioProcessor());
        }

        public long a(long j2) {
            if (this.f5791c.isActive()) {
                return this.f5791c.f(j2);
            }
            return j2;
        }

        public AudioProcessor[] b() {
            return this.f5789a;
        }

        public long c() {
            return this.f5790b.t();
        }

        public boolean d(boolean z2) {
            this.f5790b.C(z2);
            return z2;
        }

        public PlaybackParameters e(PlaybackParameters playbackParameters) {
            this.f5791c.h(playbackParameters.f4306a);
            this.f5791c.g(playbackParameters.f4307b);
            return playbackParameters;
        }

        public DefaultAudioProcessorChain(AudioProcessor[] audioProcessorArr, SilenceSkippingAudioProcessor silenceSkippingAudioProcessor, SonicAudioProcessor sonicAudioProcessor) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[(audioProcessorArr.length + 2)];
            this.f5789a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f5790b = silenceSkippingAudioProcessor;
            this.f5791c = sonicAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length] = silenceSkippingAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length + 1] = sonicAudioProcessor;
        }
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    private static final class MediaPositionParameters {

        /* renamed from: a  reason: collision with root package name */
        public final PlaybackParameters f5792a;

        /* renamed from: b  reason: collision with root package name */
        public final long f5793b;

        /* renamed from: c  reason: collision with root package name */
        public final long f5794c;

        private MediaPositionParameters(PlaybackParameters playbackParameters, long j2, long j3) {
            this.f5792a = playbackParameters;
            this.f5793b = j2;
            this.f5794c = j3;
        }
    }

    private static final class OnRoutingChangedListenerApi24 {

        /* renamed from: a  reason: collision with root package name */
        private final AudioTrack f5795a;

        /* renamed from: b  reason: collision with root package name */
        private final AudioCapabilitiesReceiver f5796b;

        /* renamed from: c  reason: collision with root package name */
        private AudioRouting.OnRoutingChangedListener f5797c = new y0(this);

        public OnRoutingChangedListenerApi24(AudioTrack audioTrack, AudioCapabilitiesReceiver audioCapabilitiesReceiver) {
            this.f5795a = audioTrack;
            this.f5796b = audioCapabilitiesReceiver;
            audioTrack.addOnRoutingChangedListener(this.f5797c, new Handler(Looper.myLooper()));
        }

        /* access modifiers changed from: private */
        public void b(AudioRouting audioRouting) {
            if (this.f5797c != null && audioRouting.getRoutedDevice() != null) {
                this.f5796b.i(audioRouting.getRoutedDevice());
            }
        }

        public void c() {
            this.f5795a.removeOnRoutingChangedListener((AudioRouting.OnRoutingChangedListener) Assertions.f(this.f5797c));
            this.f5797c = null;
        }
    }

    private static final class PendingExceptionHolder<T extends Exception> {

        /* renamed from: a  reason: collision with root package name */
        private final long f5798a;

        /* renamed from: b  reason: collision with root package name */
        private T f5799b;

        /* renamed from: c  reason: collision with root package name */
        private long f5800c;

        public PendingExceptionHolder(long j2) {
            this.f5798a = j2;
        }

        public void a() {
            this.f5799b = null;
        }

        public void b(T t2) throws Exception {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f5799b == null) {
                this.f5799b = t2;
                this.f5800c = this.f5798a + elapsedRealtime;
            }
            if (elapsedRealtime >= this.f5800c) {
                T t3 = this.f5799b;
                if (t3 != t2) {
                    t3.addSuppressed(t2);
                }
                T t4 = this.f5799b;
                a();
                throw t4;
            }
        }
    }

    private final class PositionTrackerListener implements AudioTrackPositionTracker.Listener {
        private PositionTrackerListener() {
        }

        public void a(int i2, long j2) {
            if (DefaultAudioSink.this.f5760t != null) {
                DefaultAudioSink.this.f5760t.d(i2, j2, SystemClock.elapsedRealtime() - DefaultAudioSink.this.f5741g0);
            }
        }

        public void b(long j2) {
            if (DefaultAudioSink.this.f5760t != null) {
                DefaultAudioSink.this.f5760t.b(j2);
            }
        }

        public void c(long j2) {
            Log.h("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j2);
        }

        public void d(long j2, long j3, long j4, long j5) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j2 + ", " + j3 + ", " + j4 + ", " + j5 + ", " + DefaultAudioSink.this.R() + ", " + DefaultAudioSink.this.S();
            if (!DefaultAudioSink.f5724n0) {
                Log.h("DefaultAudioSink", str);
                return;
            }
            throw new InvalidAudioTrackTimestampException(str);
        }

        public void e(long j2, long j3, long j4, long j5) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j2 + ", " + j3 + ", " + j4 + ", " + j5 + ", " + DefaultAudioSink.this.R() + ", " + DefaultAudioSink.this.S();
            if (!DefaultAudioSink.f5724n0) {
                Log.h("DefaultAudioSink", str);
                return;
            }
            throw new InvalidAudioTrackTimestampException(str);
        }
    }

    private final class StreamEventCallbackV29 {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f5802a = new Handler(Looper.myLooper());

        /* renamed from: b  reason: collision with root package name */
        private final AudioTrack.StreamEventCallback f5803b;

        public StreamEventCallbackV29() {
            this.f5803b = new AudioTrack.StreamEventCallback(DefaultAudioSink.this) {
                public void onDataRequest(AudioTrack audioTrack, int i2) {
                    if (audioTrack.equals(DefaultAudioSink.this.f5764x) && DefaultAudioSink.this.f5760t != null && DefaultAudioSink.this.Z) {
                        DefaultAudioSink.this.f5760t.f();
                    }
                }

                public void onPresentationEnded(AudioTrack audioTrack) {
                    if (audioTrack.equals(DefaultAudioSink.this.f5764x)) {
                        boolean unused = DefaultAudioSink.this.Y = true;
                    }
                }

                public void onTearDown(AudioTrack audioTrack) {
                    if (audioTrack.equals(DefaultAudioSink.this.f5764x) && DefaultAudioSink.this.f5760t != null && DefaultAudioSink.this.Z) {
                        DefaultAudioSink.this.f5760t.f();
                    }
                }
            };
        }

        public void a(AudioTrack audioTrack) {
            Handler handler = this.f5802a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new b1(handler), this.f5803b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f5803b);
            this.f5802a.removeCallbacksAndMessages((Object) null);
        }
    }

    private void J(long j2) {
        PlaybackParameters playbackParameters;
        boolean z2;
        if (!r0()) {
            if (p0()) {
                playbackParameters = this.f5730b.e(this.E);
            } else {
                playbackParameters = PlaybackParameters.f4303d;
            }
            this.E = playbackParameters;
        } else {
            playbackParameters = PlaybackParameters.f4303d;
        }
        PlaybackParameters playbackParameters2 = playbackParameters;
        if (p0()) {
            z2 = this.f5730b.d(this.F);
        } else {
            z2 = false;
        }
        this.F = z2;
        this.f5746j.add(new MediaPositionParameters(playbackParameters2, Math.max(0, j2), this.f5762v.i(S())));
        o0();
        AudioSink.Listener listener = this.f5760t;
        if (listener != null) {
            listener.onSkipSilenceEnabledChanged(this.F);
        }
    }

    private long K(long j2) {
        while (!this.f5746j.isEmpty() && j2 >= this.f5746j.getFirst().f5794c) {
            this.D = this.f5746j.remove();
        }
        long j3 = j2 - this.D.f5794c;
        if (this.f5746j.isEmpty()) {
            return this.D.f5793b + this.f5730b.a(j3);
        }
        MediaPositionParameters first = this.f5746j.getFirst();
        return first.f5793b - Util.e0(first.f5794c - j2, this.D.f5792a.f4306a);
    }

    private long L(long j2) {
        long c2 = this.f5730b.c();
        long i2 = j2 + this.f5762v.i(c2);
        long j3 = this.f5749k0;
        if (c2 > j3) {
            long i3 = this.f5762v.i(c2 - j3);
            this.f5749k0 = c2;
            T(i3);
        }
        return i2;
    }

    private AudioTrack M(Configuration configuration) throws AudioSink.InitializationException {
        try {
            AudioTrack a2 = configuration.a(this.B, this.f5731b0);
            ExoPlayer.AudioOffloadListener audioOffloadListener = this.f5758r;
            if (audioOffloadListener != null) {
                audioOffloadListener.E(X(a2));
            }
            return a2;
        } catch (AudioSink.InitializationException e2) {
            AudioSink.Listener listener = this.f5760t;
            if (listener != null) {
                listener.a(e2);
            }
            throw e2;
        }
    }

    private AudioTrack N() throws AudioSink.InitializationException {
        try {
            return M((Configuration) Assertions.f(this.f5762v));
        } catch (AudioSink.InitializationException e2) {
            Configuration configuration = this.f5762v;
            if (configuration.f5784h > 1000000) {
                Configuration d2 = configuration.d(1000000);
                try {
                    AudioTrack M2 = M(d2);
                    this.f5762v = d2;
                    return M2;
                } catch (AudioSink.InitializationException e3) {
                    e2.addSuppressed(e3);
                    a0();
                    throw e2;
                }
            }
            a0();
            throw e2;
        }
    }

    private boolean O() throws AudioSink.WriteException {
        if (!this.f5763w.f()) {
            ByteBuffer byteBuffer = this.T;
            if (byteBuffer == null) {
                return true;
            }
            s0(byteBuffer, Long.MIN_VALUE);
            if (this.T == null) {
                return true;
            }
            return false;
        }
        this.f5763w.h();
        f0(Long.MIN_VALUE);
        if (!this.f5763w.e()) {
            return false;
        }
        ByteBuffer byteBuffer2 = this.T;
        if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
            return true;
        }
        return false;
    }

    private static int P(int i2, int i3, int i4) {
        boolean z2;
        int minBufferSize = AudioTrack.getMinBufferSize(i2, i3, i4);
        if (minBufferSize != -2) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        return minBufferSize;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005d, code lost:
        return androidx.media3.extractor.Ac3Util.e(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int Q(int r2, java.nio.ByteBuffer r3) {
        /*
            r0 = 20
            if (r2 == r0) goto L_0x0063
            r0 = 30
            if (r2 == r0) goto L_0x005e
            r0 = 1024(0x400, float:1.435E-42)
            r1 = -1
            switch(r2) {
                case 5: goto L_0x0059;
                case 6: goto L_0x0059;
                case 7: goto L_0x005e;
                case 8: goto L_0x005e;
                case 9: goto L_0x0044;
                case 10: goto L_0x0043;
                case 11: goto L_0x0040;
                case 12: goto L_0x0040;
                default: goto L_0x000e;
            }
        L_0x000e:
            switch(r2) {
                case 14: goto L_0x0031;
                case 15: goto L_0x002e;
                case 16: goto L_0x002d;
                case 17: goto L_0x0028;
                case 18: goto L_0x0059;
                default: goto L_0x0011;
            }
        L_0x0011:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unexpected audio encoding: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            r3.<init>(r2)
            throw r3
        L_0x0028:
            int r2 = androidx.media3.extractor.Ac4Util.c(r3)
            return r2
        L_0x002d:
            return r0
        L_0x002e:
            r2 = 512(0x200, float:7.175E-43)
            return r2
        L_0x0031:
            int r2 = androidx.media3.extractor.Ac3Util.b(r3)
            if (r2 != r1) goto L_0x0039
            r2 = 0
            goto L_0x003f
        L_0x0039:
            int r2 = androidx.media3.extractor.Ac3Util.i(r3, r2)
            int r2 = r2 * 16
        L_0x003f:
            return r2
        L_0x0040:
            r2 = 2048(0x800, float:2.87E-42)
            return r2
        L_0x0043:
            return r0
        L_0x0044:
            int r2 = r3.position()
            int r2 = androidx.media3.common.util.Util.O(r3, r2)
            int r2 = androidx.media3.extractor.MpegAudioUtil.m(r2)
            if (r2 == r1) goto L_0x0053
            return r2
        L_0x0053:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            r2.<init>()
            throw r2
        L_0x0059:
            int r2 = androidx.media3.extractor.Ac3Util.e(r3)
            return r2
        L_0x005e:
            int r2 = androidx.media3.extractor.DtsUtil.f(r3)
            return r2
        L_0x0063:
            int r2 = androidx.media3.extractor.OpusUtil.h(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioSink.Q(int, java.nio.ByteBuffer):int");
    }

    /* access modifiers changed from: private */
    public long R() {
        Configuration configuration = this.f5762v;
        if (configuration.f5779c == 0) {
            return this.I / ((long) configuration.f5778b);
        }
        return this.J;
    }

    /* access modifiers changed from: private */
    public long S() {
        Configuration configuration = this.f5762v;
        if (configuration.f5779c == 0) {
            return Util.l(this.K, (long) configuration.f5780d);
        }
        return this.L;
    }

    private void T(long j2) {
        this.f5751l0 += j2;
        if (this.f5753m0 == null) {
            this.f5753m0 = new Handler(Looper.myLooper());
        }
        this.f5753m0.removeCallbacksAndMessages((Object) null);
        this.f5753m0.postDelayed(new h0(this), 100);
    }

    private boolean U() throws AudioSink.InitializationException {
        boolean z2;
        AudioCapabilitiesReceiver audioCapabilitiesReceiver;
        PlayerId playerId;
        if (!this.f5742h.d()) {
            return false;
        }
        AudioTrack N2 = N();
        this.f5764x = N2;
        if (X(N2)) {
            g0(this.f5764x);
            Configuration configuration = this.f5762v;
            if (configuration.f5787k) {
                AudioTrack audioTrack = this.f5764x;
                Format format = configuration.f5777a;
                audioTrack.setOffloadDelayPadding(format.E, format.F);
            }
        }
        int i2 = Util.f4714a;
        if (i2 >= 31 && (playerId = this.f5759s) != null) {
            Api31.a(this.f5764x, playerId);
        }
        this.f5731b0 = this.f5764x.getAudioSessionId();
        AudioTrackPositionTracker audioTrackPositionTracker = this.f5744i;
        AudioTrack audioTrack2 = this.f5764x;
        Configuration configuration2 = this.f5762v;
        if (configuration2.f5779c == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        audioTrackPositionTracker.s(audioTrack2, z2, configuration2.f5783g, configuration2.f5780d, configuration2.f5784h);
        l0();
        int i3 = this.f5733c0.f3927a;
        if (i3 != 0) {
            this.f5764x.attachAuxEffect(i3);
            this.f5764x.setAuxEffectSendLevel(this.f5733c0.f3928b);
        }
        AudioDeviceInfoApi23 audioDeviceInfoApi23 = this.f5735d0;
        if (audioDeviceInfoApi23 != null && i2 >= 23) {
            Api23.a(this.f5764x, audioDeviceInfoApi23);
            AudioCapabilitiesReceiver audioCapabilitiesReceiver2 = this.f5766z;
            if (audioCapabilitiesReceiver2 != null) {
                audioCapabilitiesReceiver2.i(this.f5735d0.f5647a);
            }
        }
        if (i2 >= 24 && (audioCapabilitiesReceiver = this.f5766z) != null) {
            this.A = new OnRoutingChangedListenerApi24(this.f5764x, audioCapabilitiesReceiver);
        }
        this.O = true;
        AudioSink.Listener listener = this.f5760t;
        if (listener != null) {
            listener.m(this.f5762v.b());
        }
        return true;
    }

    private static boolean V(int i2) {
        return (Util.f4714a >= 24 && i2 == -6) || i2 == -32;
    }

    private boolean W() {
        return this.f5764x != null;
    }

    private static boolean X(AudioTrack audioTrack) {
        return Util.f4714a >= 29 && audioTrack.isOffloadedPlayback();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void Z(AudioTrack audioTrack, AudioSink.Listener listener, Handler handler, AudioSink.AudioTrackConfig audioTrackConfig, ConditionVariable conditionVariable) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (listener != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new k0(listener, audioTrackConfig));
            }
            conditionVariable.e();
            synchronized (f5725o0) {
                int i2 = f5727q0 - 1;
                f5727q0 = i2;
                if (i2 == 0) {
                    f5726p0.shutdown();
                    f5726p0 = null;
                }
            }
        } catch (Throwable th) {
            if (listener != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new k0(listener, audioTrackConfig));
            }
            conditionVariable.e();
            synchronized (f5725o0) {
                int i3 = f5727q0 - 1;
                f5727q0 = i3;
                if (i3 == 0) {
                    f5726p0.shutdown();
                    f5726p0 = null;
                }
                throw th;
            }
        }
    }

    private void a0() {
        if (this.f5762v.m()) {
            this.f5743h0 = true;
        }
    }

    /* access modifiers changed from: private */
    public void b0() {
        if (this.f5751l0 >= 300000) {
            this.f5760t.g();
            this.f5751l0 = 0;
        }
    }

    private void c0() {
        if (this.f5766z == null && this.f5728a != null) {
            this.f5747j0 = Looper.myLooper();
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = new AudioCapabilitiesReceiver(this.f5728a, new j0(this), this.B, this.f5735d0);
            this.f5766z = audioCapabilitiesReceiver;
            this.f5765y = audioCapabilitiesReceiver.g();
        }
    }

    private void e0() {
        if (!this.X) {
            this.X = true;
            this.f5744i.g(S());
            if (X(this.f5764x)) {
                this.Y = false;
            }
            this.f5764x.stop();
            this.H = 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        r0 = r2.R;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (r0 == null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r0.hasRemaining() != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        r2.f5763w.i(r2.R);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f0(long r3) throws androidx.media3.exoplayer.audio.AudioSink.WriteException {
        /*
            r2 = this;
            androidx.media3.common.audio.AudioProcessingPipeline r0 = r2.f5763w
            boolean r0 = r0.f()
            if (r0 != 0) goto L_0x0013
            java.nio.ByteBuffer r0 = r2.R
            if (r0 == 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            java.nio.ByteBuffer r0 = androidx.media3.common.audio.AudioProcessor.f4498a
        L_0x000f:
            r2.s0(r0, r3)
            return
        L_0x0013:
            androidx.media3.common.audio.AudioProcessingPipeline r0 = r2.f5763w
            boolean r0 = r0.e()
            if (r0 != 0) goto L_0x0044
        L_0x001b:
            androidx.media3.common.audio.AudioProcessingPipeline r0 = r2.f5763w
            java.nio.ByteBuffer r0 = r0.d()
            boolean r1 = r0.hasRemaining()
            if (r1 == 0) goto L_0x0031
            r2.s0(r0, r3)
            boolean r0 = r0.hasRemaining()
            if (r0 == 0) goto L_0x001b
            return
        L_0x0031:
            java.nio.ByteBuffer r0 = r2.R
            if (r0 == 0) goto L_0x0044
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L_0x003c
            goto L_0x0044
        L_0x003c:
            androidx.media3.common.audio.AudioProcessingPipeline r0 = r2.f5763w
            java.nio.ByteBuffer r1 = r2.R
            r0.i(r1)
            goto L_0x0013
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioSink.f0(long):void");
    }

    private void g0(AudioTrack audioTrack) {
        if (this.f5752m == null) {
            this.f5752m = new StreamEventCallbackV29();
        }
        this.f5752m.a(audioTrack);
    }

    private static void h0(AudioTrack audioTrack, ConditionVariable conditionVariable, AudioSink.Listener listener, AudioSink.AudioTrackConfig audioTrackConfig) {
        conditionVariable.c();
        Handler handler = new Handler(Looper.myLooper());
        synchronized (f5725o0) {
            if (f5726p0 == null) {
                f5726p0 = Util.Q0("ExoPlayer:AudioTrackReleaseThread");
            }
            f5727q0++;
            f5726p0.execute(new i0(audioTrack, listener, handler, audioTrackConfig, conditionVariable));
        }
    }

    private void i0() {
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.f5745i0 = false;
        this.M = 0;
        this.D = new MediaPositionParameters(this.E, 0, 0);
        this.P = 0;
        this.C = null;
        this.f5746j.clear();
        this.R = null;
        this.S = 0;
        this.T = null;
        this.X = false;
        this.W = false;
        this.Y = false;
        this.G = null;
        this.H = 0;
        this.f5736e.m();
        o0();
    }

    private void j0(PlaybackParameters playbackParameters) {
        MediaPositionParameters mediaPositionParameters = new MediaPositionParameters(playbackParameters, -9223372036854775807L, -9223372036854775807L);
        if (W()) {
            this.C = mediaPositionParameters;
        } else {
            this.D = mediaPositionParameters;
        }
    }

    private void k0() {
        if (W()) {
            try {
                this.f5764x.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(this.E.f4306a).setPitch(this.E.f4307b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e2) {
                Log.i("DefaultAudioSink", "Failed to set playback params", e2);
            }
            PlaybackParameters playbackParameters = new PlaybackParameters(this.f5764x.getPlaybackParams().getSpeed(), this.f5764x.getPlaybackParams().getPitch());
            this.E = playbackParameters;
            this.f5744i.t(playbackParameters.f4306a);
        }
    }

    private void l0() {
        if (W()) {
            if (Util.f4714a >= 21) {
                m0(this.f5764x, this.Q);
            } else {
                n0(this.f5764x, this.Q);
            }
        }
    }

    private static void m0(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    private static void n0(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    private void o0() {
        AudioProcessingPipeline audioProcessingPipeline = this.f5762v.f5785i;
        this.f5763w = audioProcessingPipeline;
        audioProcessingPipeline.b();
    }

    private boolean p0() {
        if (!this.f5737e0) {
            Configuration configuration = this.f5762v;
            if (configuration.f5779c != 0 || q0(configuration.f5777a.D)) {
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean q0(int i2) {
        return this.f5732c && Util.E0(i2);
    }

    private boolean r0() {
        Configuration configuration = this.f5762v;
        return configuration != null && configuration.f5786j && Util.f4714a >= 23;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void s0(java.nio.ByteBuffer r13, long r14) throws androidx.media3.exoplayer.audio.AudioSink.WriteException {
        /*
            r12 = this;
            boolean r0 = r13.hasRemaining()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.nio.ByteBuffer r0 = r12.T
            r1 = 21
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0018
            if (r0 != r13) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            androidx.media3.common.util.Assertions.a(r0)
            goto L_0x003b
        L_0x0018:
            r12.T = r13
            int r0 = androidx.media3.common.util.Util.f4714a
            if (r0 >= r1) goto L_0x003b
            int r0 = r13.remaining()
            byte[] r4 = r12.U
            if (r4 == 0) goto L_0x0029
            int r4 = r4.length
            if (r4 >= r0) goto L_0x002d
        L_0x0029:
            byte[] r4 = new byte[r0]
            r12.U = r4
        L_0x002d:
            int r4 = r13.position()
            byte[] r5 = r12.U
            r13.get(r5, r3, r0)
            r13.position(r4)
            r12.V = r3
        L_0x003b:
            int r0 = r13.remaining()
            int r4 = androidx.media3.common.util.Util.f4714a
            if (r4 >= r1) goto L_0x006d
            androidx.media3.exoplayer.audio.AudioTrackPositionTracker r14 = r12.f5744i
            long r4 = r12.K
            int r14 = r14.c(r4)
            if (r14 <= 0) goto L_0x006b
            int r14 = java.lang.Math.min(r0, r14)
            android.media.AudioTrack r15 = r12.f5764x
            byte[] r1 = r12.U
            int r4 = r12.V
            int r14 = r15.write(r1, r4, r14)
            if (r14 <= 0) goto L_0x009c
            int r15 = r12.V
            int r15 = r15 + r14
            r12.V = r15
            int r15 = r13.position()
            int r15 = r15 + r14
            r13.position(r15)
            goto L_0x009c
        L_0x006b:
            r14 = 0
            goto L_0x009c
        L_0x006d:
            boolean r1 = r12.f5737e0
            if (r1 == 0) goto L_0x0096
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x007c
            r1 = 1
            goto L_0x007d
        L_0x007c:
            r1 = 0
        L_0x007d:
            androidx.media3.common.util.Assertions.h(r1)
            r4 = -9223372036854775808
            int r1 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x0089
            long r14 = r12.f5739f0
            goto L_0x008b
        L_0x0089:
            r12.f5739f0 = r14
        L_0x008b:
            r10 = r14
            android.media.AudioTrack r7 = r12.f5764x
            r6 = r12
            r8 = r13
            r9 = r0
            int r14 = r6.u0(r7, r8, r9, r10)
            goto L_0x009c
        L_0x0096:
            android.media.AudioTrack r14 = r12.f5764x
            int r14 = t0(r14, r13, r0)
        L_0x009c:
            long r4 = android.os.SystemClock.elapsedRealtime()
            r12.f5741g0 = r4
            r4 = 0
            if (r14 >= 0) goto L_0x00e1
            boolean r13 = V(r14)
            if (r13 == 0) goto L_0x00c1
            long r0 = r12.S()
            int r13 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r13 <= 0) goto L_0x00b5
            goto L_0x00c2
        L_0x00b5:
            android.media.AudioTrack r13 = r12.f5764x
            boolean r13 = X(r13)
            if (r13 == 0) goto L_0x00c1
            r12.a0()
            goto L_0x00c2
        L_0x00c1:
            r2 = 0
        L_0x00c2:
            androidx.media3.exoplayer.audio.AudioSink$WriteException r13 = new androidx.media3.exoplayer.audio.AudioSink$WriteException
            androidx.media3.exoplayer.audio.DefaultAudioSink$Configuration r15 = r12.f5762v
            androidx.media3.common.Format r15 = r15.f5777a
            r13.<init>(r14, r15, r2)
            androidx.media3.exoplayer.audio.AudioSink$Listener r14 = r12.f5760t
            if (r14 == 0) goto L_0x00d2
            r14.a(r13)
        L_0x00d2:
            boolean r14 = r13.f5670c
            if (r14 != 0) goto L_0x00dc
            androidx.media3.exoplayer.audio.DefaultAudioSink$PendingExceptionHolder<androidx.media3.exoplayer.audio.AudioSink$WriteException> r14 = r12.f5755o
            r14.b(r13)
            return
        L_0x00dc:
            androidx.media3.exoplayer.audio.AudioCapabilities r14 = androidx.media3.exoplayer.audio.AudioCapabilities.f5623c
            r12.f5765y = r14
            throw r13
        L_0x00e1:
            androidx.media3.exoplayer.audio.DefaultAudioSink$PendingExceptionHolder<androidx.media3.exoplayer.audio.AudioSink$WriteException> r15 = r12.f5755o
            r15.a()
            android.media.AudioTrack r15 = r12.f5764x
            boolean r15 = X(r15)
            if (r15 == 0) goto L_0x0107
            long r6 = r12.L
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 <= 0) goto L_0x00f6
            r12.f5745i0 = r3
        L_0x00f6:
            boolean r15 = r12.Z
            if (r15 == 0) goto L_0x0107
            androidx.media3.exoplayer.audio.AudioSink$Listener r15 = r12.f5760t
            if (r15 == 0) goto L_0x0107
            if (r14 >= r0) goto L_0x0107
            boolean r1 = r12.f5745i0
            if (r1 != 0) goto L_0x0107
            r15.c()
        L_0x0107:
            androidx.media3.exoplayer.audio.DefaultAudioSink$Configuration r15 = r12.f5762v
            int r15 = r15.f5779c
            if (r15 != 0) goto L_0x0113
            long r4 = r12.K
            long r6 = (long) r14
            long r4 = r4 + r6
            r12.K = r4
        L_0x0113:
            if (r14 != r0) goto L_0x0130
            if (r15 == 0) goto L_0x012d
            java.nio.ByteBuffer r14 = r12.R
            if (r13 != r14) goto L_0x011c
            goto L_0x011d
        L_0x011c:
            r2 = 0
        L_0x011d:
            androidx.media3.common.util.Assertions.h(r2)
            long r13 = r12.L
            int r15 = r12.M
            long r0 = (long) r15
            int r15 = r12.S
            long r2 = (long) r15
            long r0 = r0 * r2
            long r13 = r13 + r0
            r12.L = r13
        L_0x012d:
            r13 = 0
            r12.T = r13
        L_0x0130:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioSink.s0(java.nio.ByteBuffer, long):void");
    }

    private static int t0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
        return audioTrack.write(byteBuffer, i2, 1);
    }

    private int u0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j2) {
        if (Util.f4714a >= 26) {
            return audioTrack.write(byteBuffer, i2, 1, j2 * 1000);
        }
        if (this.G == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.G = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.G.putInt(1431633921);
        }
        if (this.H == 0) {
            this.G.putInt(4, i2);
            this.G.putLong(8, j2 * 1000);
            this.G.position(0);
            this.H = i2;
        }
        int remaining = this.G.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.G, remaining, 1);
            if (write < 0) {
                this.H = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int t02 = t0(audioTrack, byteBuffer, i2);
        if (t02 < 0) {
            this.H = 0;
            return t02;
        }
        this.H -= t02;
        return t02;
    }

    public boolean a() {
        return !W() || (this.W && !f());
    }

    public PlaybackParameters b() {
        return this.E;
    }

    public boolean c(Format format) {
        return w(format) != 0;
    }

    public void d(float f2) {
        if (this.Q != f2) {
            this.Q = f2;
            l0();
        }
    }

    public void d0(AudioCapabilities audioCapabilities) {
        String str;
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f5747j0;
        if (looper != myLooper) {
            String str2 = "null";
            if (looper == null) {
                str = str2;
            } else {
                str = looper.getThread().getName();
            }
            if (myLooper != null) {
                str2 = myLooper.getThread().getName();
            }
            throw new IllegalStateException("Current looper (" + str2 + ") is not the playback looper (" + str + ")");
        } else if (!audioCapabilities.equals(this.f5765y)) {
            this.f5765y = audioCapabilities;
            AudioSink.Listener listener = this.f5760t;
            if (listener != null) {
                listener.h();
            }
        }
    }

    public void e(PlaybackParameters playbackParameters) {
        this.E = new PlaybackParameters(Util.o(playbackParameters.f4306a, 0.1f, 8.0f), Util.o(playbackParameters.f4307b, 0.1f, 8.0f));
        if (r0()) {
            k0();
        } else {
            j0(playbackParameters);
        }
    }

    public boolean f() {
        if (!W() || ((Util.f4714a >= 29 && this.f5764x.isOffloadedPlayback() && this.Y) || !this.f5744i.h(S()))) {
            return false;
        }
        return true;
    }

    public void flush() {
        OnRoutingChangedListenerApi24 onRoutingChangedListenerApi24;
        if (W()) {
            i0();
            if (this.f5744i.i()) {
                this.f5764x.pause();
            }
            if (X(this.f5764x)) {
                ((StreamEventCallbackV29) Assertions.f(this.f5752m)).b(this.f5764x);
            }
            int i2 = Util.f4714a;
            if (i2 < 21 && !this.f5729a0) {
                this.f5731b0 = 0;
            }
            AudioSink.AudioTrackConfig b2 = this.f5762v.b();
            Configuration configuration = this.f5761u;
            if (configuration != null) {
                this.f5762v = configuration;
                this.f5761u = null;
            }
            this.f5744i.q();
            if (i2 >= 24 && (onRoutingChangedListenerApi24 = this.A) != null) {
                onRoutingChangedListenerApi24.c();
                this.A = null;
            }
            h0(this.f5764x, this.f5742h, this.f5760t, b2);
            this.f5764x = null;
        }
        this.f5755o.a();
        this.f5754n.a();
        this.f5749k0 = 0;
        this.f5751l0 = 0;
        Handler handler = this.f5753m0;
        if (handler != null) {
            ((Handler) Assertions.f(handler)).removeCallbacksAndMessages((Object) null);
        }
    }

    public void g(int i2) {
        boolean z2;
        if (this.f5731b0 != i2) {
            this.f5731b0 = i2;
            if (i2 != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f5729a0 = z2;
            flush();
        }
    }

    public void h() {
        if (this.f5737e0) {
            this.f5737e0 = false;
            flush();
        }
    }

    public boolean i(ByteBuffer byteBuffer, long j2, int i2) throws AudioSink.InitializationException, AudioSink.WriteException {
        boolean z2;
        boolean z3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = j2;
        int i3 = i2;
        ByteBuffer byteBuffer3 = this.R;
        if (byteBuffer3 == null || byteBuffer2 == byteBuffer3) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        if (this.f5761u != null) {
            if (!O()) {
                return false;
            }
            if (!this.f5761u.c(this.f5762v)) {
                e0();
                if (f()) {
                    return false;
                }
                flush();
            } else {
                this.f5762v = this.f5761u;
                this.f5761u = null;
                AudioTrack audioTrack = this.f5764x;
                if (audioTrack != null && X(audioTrack) && this.f5762v.f5787k) {
                    if (this.f5764x.getPlayState() == 3) {
                        this.f5764x.setOffloadEndOfStream();
                        this.f5744i.a();
                    }
                    AudioTrack audioTrack2 = this.f5764x;
                    Format format = this.f5762v.f5777a;
                    audioTrack2.setOffloadDelayPadding(format.E, format.F);
                    this.f5745i0 = true;
                }
            }
            J(j3);
        }
        if (!W()) {
            try {
                if (!U()) {
                    return false;
                }
            } catch (AudioSink.InitializationException e2) {
                AudioSink.InitializationException initializationException = e2;
                if (!initializationException.f5665c) {
                    this.f5754n.b(initializationException);
                    return false;
                }
                throw initializationException;
            }
        }
        this.f5754n.a();
        if (this.O) {
            this.P = Math.max(0, j3);
            this.N = false;
            this.O = false;
            if (r0()) {
                k0();
            }
            J(j3);
            if (this.Z) {
                play();
            }
        }
        if (!this.f5744i.k(S())) {
            return false;
        }
        if (this.R == null) {
            if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.a(z3);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            Configuration configuration = this.f5762v;
            if (configuration.f5779c != 0 && this.M == 0) {
                int Q2 = Q(configuration.f5783g, byteBuffer2);
                this.M = Q2;
                if (Q2 == 0) {
                    return true;
                }
            }
            if (this.C != null) {
                if (!O()) {
                    return false;
                }
                J(j3);
                this.C = null;
            }
            long l2 = this.P + this.f5762v.l(R() - this.f5736e.l());
            if (!this.N && Math.abs(l2 - j3) > 200000) {
                AudioSink.Listener listener = this.f5760t;
                if (listener != null) {
                    listener.a(new AudioSink.UnexpectedDiscontinuityException(j3, l2));
                }
                this.N = true;
            }
            if (this.N) {
                if (!O()) {
                    return false;
                }
                long j4 = j3 - l2;
                this.P += j4;
                this.N = false;
                J(j3);
                AudioSink.Listener listener2 = this.f5760t;
                if (!(listener2 == null || j4 == 0)) {
                    listener2.e();
                }
            }
            if (this.f5762v.f5779c == 0) {
                this.I += (long) byteBuffer.remaining();
            } else {
                this.J += ((long) this.M) * ((long) i3);
            }
            this.R = byteBuffer2;
            this.S = i3;
        }
        f0(j3);
        if (!this.R.hasRemaining()) {
            this.R = null;
            this.S = 0;
            return true;
        } else if (!this.f5744i.j(S())) {
            return false;
        } else {
            Log.h("DefaultAudioSink", "Resetting stalled audio track");
            flush();
            return true;
        }
    }

    public void j() throws AudioSink.WriteException {
        if (!this.W && W() && O()) {
            e0();
            this.W = true;
        }
    }

    public long k(boolean z2) {
        if (!W() || this.O) {
            return Long.MIN_VALUE;
        }
        return L(K(Math.min(this.f5744i.d(z2), this.f5762v.i(S()))));
    }

    public /* synthetic */ void l(long j2) {
        r.a(this, j2);
    }

    public void m() {
        this.N = true;
    }

    public void n() {
        boolean z2;
        if (Util.f4714a >= 21) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        Assertions.h(this.f5729a0);
        if (!this.f5737e0) {
            this.f5737e0 = true;
            flush();
        }
    }

    public void o(boolean z2) {
        PlaybackParameters playbackParameters;
        this.F = z2;
        if (r0()) {
            playbackParameters = PlaybackParameters.f4303d;
        } else {
            playbackParameters = this.E;
        }
        j0(playbackParameters);
    }

    public void p(androidx.media3.common.AudioAttributes audioAttributes) {
        if (!this.B.equals(audioAttributes)) {
            this.B = audioAttributes;
            if (!this.f5737e0) {
                AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.f5766z;
                if (audioCapabilitiesReceiver != null) {
                    audioCapabilitiesReceiver.h(audioAttributes);
                }
                flush();
            }
        }
    }

    public void pause() {
        this.Z = false;
        if (!W()) {
            return;
        }
        if (this.f5744i.p() || X(this.f5764x)) {
            this.f5764x.pause();
        }
    }

    public void play() {
        this.Z = true;
        if (W()) {
            this.f5744i.v();
            this.f5764x.play();
        }
    }

    public AudioOffloadSupport q(Format format) {
        if (this.f5743h0) {
            return AudioOffloadSupport.f5648d;
        }
        return this.f5757q.a(format, this.B);
    }

    public void r(AudioSink.Listener listener) {
        this.f5760t = listener;
    }

    public void release() {
        AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.f5766z;
        if (audioCapabilitiesReceiver != null) {
            audioCapabilitiesReceiver.j();
        }
    }

    public void reset() {
        flush();
        UnmodifiableIterator<AudioProcessor> h2 = this.f5738f.iterator();
        while (h2.hasNext()) {
            h2.next().reset();
        }
        UnmodifiableIterator<AudioProcessor> h3 = this.f5740g.iterator();
        while (h3.hasNext()) {
            h3.next().reset();
        }
        AudioProcessingPipeline audioProcessingPipeline = this.f5763w;
        if (audioProcessingPipeline != null) {
            audioProcessingPipeline.j();
        }
        this.Z = false;
        this.f5743h0 = false;
    }

    public void s(int i2) {
        boolean z2;
        if (Util.f4714a >= 29) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        this.f5750l = i2;
    }

    public void setPreferredDevice(AudioDeviceInfo audioDeviceInfo) {
        AudioDeviceInfoApi23 audioDeviceInfoApi23;
        if (audioDeviceInfo == null) {
            audioDeviceInfoApi23 = null;
        } else {
            audioDeviceInfoApi23 = new AudioDeviceInfoApi23(audioDeviceInfo);
        }
        this.f5735d0 = audioDeviceInfoApi23;
        AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.f5766z;
        if (audioCapabilitiesReceiver != null) {
            audioCapabilitiesReceiver.i(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.f5764x;
        if (audioTrack != null) {
            Api23.a(audioTrack, this.f5735d0);
        }
    }

    public void t(Format format, int i2, int[] iArr) throws AudioSink.ConfigurationException {
        boolean z2;
        boolean z3;
        AudioProcessingPipeline audioProcessingPipeline;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        double d2;
        AudioOffloadSupport audioOffloadSupport;
        int[] iArr2;
        Format format2 = format;
        c0();
        if ("audio/raw".equals(format2.f4015n)) {
            Assertions.a(Util.F0(format2.D));
            i8 = Util.i0(format2.D, format2.B);
            ImmutableList.Builder builder = new ImmutableList.Builder();
            if (q0(format2.D)) {
                builder.j(this.f5740g);
            } else {
                builder.j(this.f5738f);
                builder.i(this.f5730b.b());
            }
            AudioProcessingPipeline audioProcessingPipeline2 = new AudioProcessingPipeline(builder.k());
            if (audioProcessingPipeline2.equals(this.f5763w)) {
                audioProcessingPipeline2 = this.f5763w;
            }
            this.f5736e.n(format2.E, format2.F);
            if (Util.f4714a < 21 && format2.B == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i16 = 0; i16 < 6; i16++) {
                    iArr2[i16] = i16;
                }
            } else {
                iArr2 = iArr;
            }
            this.f5734d.l(iArr2);
            try {
                AudioProcessor.AudioFormat a2 = audioProcessingPipeline2.a(new AudioProcessor.AudioFormat(format2));
                int i17 = a2.f4502c;
                int i18 = a2.f4500a;
                int M2 = Util.M(a2.f4501b);
                i5 = Util.i0(i17, a2.f4501b);
                audioProcessingPipeline = audioProcessingPipeline2;
                i4 = i18;
                i6 = M2;
                z3 = this.f5748k;
                i3 = 0;
                z2 = false;
                i7 = i17;
            } catch (AudioProcessor.UnhandledAudioFormatException e2) {
                throw new AudioSink.ConfigurationException((Throwable) e2, format2);
            }
        } else {
            AudioProcessingPipeline audioProcessingPipeline3 = new AudioProcessingPipeline(ImmutableList.r());
            int i19 = format2.C;
            if (this.f5750l != 0) {
                audioOffloadSupport = q(format);
            } else {
                audioOffloadSupport = AudioOffloadSupport.f5648d;
            }
            if (this.f5750l == 0 || !audioOffloadSupport.f5649a) {
                Pair<Integer, Integer> i20 = this.f5765y.i(format2, this.B);
                if (i20 != null) {
                    int intValue = ((Integer) i20.first).intValue();
                    audioProcessingPipeline = audioProcessingPipeline3;
                    i4 = i19;
                    i6 = ((Integer) i20.second).intValue();
                    i7 = intValue;
                    z3 = this.f5748k;
                    i8 = -1;
                    i5 = -1;
                    i3 = 2;
                    z2 = false;
                } else {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + format2, format2);
                }
            } else {
                int f2 = MimeTypes.f((String) Assertions.f(format2.f4015n), format2.f4011j);
                int M3 = Util.M(format2.B);
                audioProcessingPipeline = audioProcessingPipeline3;
                i4 = i19;
                z2 = audioOffloadSupport.f5650b;
                i7 = f2;
                i6 = M3;
                i8 = -1;
                i5 = -1;
                i3 = 1;
                z3 = true;
            }
        }
        if (i7 == 0) {
            throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i3 + ") for: " + format2, format2);
        } else if (i6 != 0) {
            int i21 = format2.f4010i;
            if (!"audio/vnd.dts.hd;profile=lbr".equals(format2.f4015n) || i21 != -1) {
                i9 = i21;
            } else {
                i9 = 768000;
            }
            if (i2 != 0) {
                i14 = i2;
                i12 = i7;
                i11 = i6;
                i10 = i5;
                i13 = i4;
            } else {
                AudioTrackBufferSizeProvider audioTrackBufferSizeProvider = this.f5756p;
                int P2 = P(i4, i6, i7);
                if (i5 != -1) {
                    i15 = i5;
                } else {
                    i15 = 1;
                }
                if (z3) {
                    d2 = 8.0d;
                } else {
                    d2 = 1.0d;
                }
                i12 = i7;
                i11 = i6;
                int i22 = i9;
                i10 = i5;
                i13 = i4;
                i14 = audioTrackBufferSizeProvider.a(P2, i7, i3, i15, i4, i22, d2);
            }
            this.f5743h0 = false;
            Configuration configuration = r2;
            Configuration configuration2 = new Configuration(format, i8, i3, i10, i13, i11, i12, i14, audioProcessingPipeline, z3, z2, this.f5737e0);
            if (W()) {
                this.f5761u = configuration;
            } else {
                this.f5762v = configuration;
            }
        } else {
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i3 + ") for: " + format2, format2);
        }
    }

    public void u(int i2, int i3) {
        Configuration configuration;
        AudioTrack audioTrack = this.f5764x;
        if (audioTrack != null && X(audioTrack) && (configuration = this.f5762v) != null && configuration.f5787k) {
            this.f5764x.setOffloadDelayPadding(i2, i3);
        }
    }

    public void v(PlayerId playerId) {
        this.f5759s = playerId;
    }

    public int w(Format format) {
        c0();
        if ("audio/raw".equals(format.f4015n)) {
            if (!Util.F0(format.D)) {
                Log.h("DefaultAudioSink", "Invalid PCM encoding: " + format.D);
                return 0;
            }
            int i2 = format.D;
            if (i2 == 2 || (this.f5732c && i2 == 4)) {
                return 2;
            }
            return 1;
        } else if (this.f5765y.k(format, this.B)) {
            return 2;
        } else {
            return 0;
        }
    }

    public void x(AuxEffectInfo auxEffectInfo) {
        if (!this.f5733c0.equals(auxEffectInfo)) {
            int i2 = auxEffectInfo.f3927a;
            float f2 = auxEffectInfo.f3928b;
            AudioTrack audioTrack = this.f5764x;
            if (audioTrack != null) {
                if (this.f5733c0.f3927a != i2) {
                    audioTrack.attachAuxEffect(i2);
                }
                if (i2 != 0) {
                    this.f5764x.setAuxEffectSendLevel(f2);
                }
            }
            this.f5733c0 = auxEffectInfo;
        }
    }

    public void y(Clock clock) {
        this.f5744i.u(clock);
    }

    @RequiresNonNull({"#1.audioProcessorChain"})
    private DefaultAudioSink(Builder builder) {
        AudioCapabilities audioCapabilities;
        Context a2 = builder.f5768a;
        this.f5728a = a2;
        androidx.media3.common.AudioAttributes audioAttributes = androidx.media3.common.AudioAttributes.f3909g;
        this.B = audioAttributes;
        if (a2 != null) {
            audioCapabilities = AudioCapabilities.e(a2, audioAttributes, (AudioDeviceInfo) null);
        } else {
            audioCapabilities = builder.f5769b;
        }
        this.f5765y = audioCapabilities;
        this.f5730b = builder.f5770c;
        int i2 = Util.f4714a;
        boolean z2 = true;
        this.f5732c = i2 >= 21 && builder.f5771d;
        this.f5748k = (i2 < 23 || !builder.f5772e) ? false : z2;
        this.f5750l = 0;
        this.f5756p = builder.f5774g;
        this.f5757q = (AudioOffloadSupportProvider) Assertions.f(builder.f5775h);
        ConditionVariable conditionVariable = new ConditionVariable(Clock.f4616a);
        this.f5742h = conditionVariable;
        conditionVariable.e();
        this.f5744i = new AudioTrackPositionTracker(new PositionTrackerListener());
        ChannelMappingAudioProcessor channelMappingAudioProcessor = new ChannelMappingAudioProcessor();
        this.f5734d = channelMappingAudioProcessor;
        TrimmingAudioProcessor trimmingAudioProcessor = new TrimmingAudioProcessor();
        this.f5736e = trimmingAudioProcessor;
        this.f5738f = ImmutableList.u(new ToInt16PcmAudioProcessor(), channelMappingAudioProcessor, trimmingAudioProcessor);
        this.f5740g = ImmutableList.s(new ToFloatPcmAudioProcessor());
        this.Q = 1.0f;
        this.f5731b0 = 0;
        this.f5733c0 = new AuxEffectInfo(0, 0.0f);
        PlaybackParameters playbackParameters = PlaybackParameters.f4303d;
        this.D = new MediaPositionParameters(playbackParameters, 0, 0);
        this.E = playbackParameters;
        this.F = false;
        this.f5746j = new ArrayDeque<>();
        this.f5754n = new PendingExceptionHolder<>(100);
        this.f5755o = new PendingExceptionHolder<>(100);
        this.f5758r = builder.f5776i;
    }

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Context f5768a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public AudioCapabilities f5769b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public AudioProcessorChain f5770c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f5771d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f5772e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f5773f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public AudioTrackBufferSizeProvider f5774g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public AudioOffloadSupportProvider f5775h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public ExoPlayer.AudioOffloadListener f5776i;

        @Deprecated
        public Builder() {
            this.f5768a = null;
            this.f5769b = AudioCapabilities.f5623c;
            this.f5774g = AudioTrackBufferSizeProvider.f5767a;
        }

        public DefaultAudioSink i() {
            Assertions.h(!this.f5773f);
            this.f5773f = true;
            if (this.f5770c == null) {
                this.f5770c = new DefaultAudioProcessorChain(new AudioProcessor[0]);
            }
            if (this.f5775h == null) {
                this.f5775h = new DefaultAudioOffloadSupportProvider(this.f5768a);
            }
            return new DefaultAudioSink(this);
        }

        @Deprecated
        public Builder j(AudioCapabilities audioCapabilities) {
            Assertions.f(audioCapabilities);
            this.f5769b = audioCapabilities;
            return this;
        }

        public Builder k(AudioProcessorChain audioProcessorChain) {
            Assertions.f(audioProcessorChain);
            this.f5770c = audioProcessorChain;
            return this;
        }

        public Builder l(AudioProcessor[] audioProcessorArr) {
            Assertions.f(audioProcessorArr);
            return k(new DefaultAudioProcessorChain(audioProcessorArr));
        }

        public Builder m(boolean z2) {
            this.f5772e = z2;
            return this;
        }

        public Builder n(boolean z2) {
            this.f5771d = z2;
            return this;
        }

        public Builder(Context context) {
            this.f5768a = context;
            this.f5769b = AudioCapabilities.f5623c;
            this.f5774g = AudioTrackBufferSizeProvider.f5767a;
        }
    }
}
