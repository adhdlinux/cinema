package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.exoplayer.audio.b1;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.AudioTrackPositionTracker;
import com.google.android.exoplayer2.audio.DefaultAudioTrackBufferSizeProvider;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class DefaultAudioSink implements AudioSink {

    /* renamed from: e0  reason: collision with root package name */
    public static boolean f23745e0 = false;

    /* renamed from: f0  reason: collision with root package name */
    private static final Object f23746f0 = new Object();

    /* renamed from: g0  reason: collision with root package name */
    private static ExecutorService f23747g0;

    /* renamed from: h0  reason: collision with root package name */
    private static int f23748h0;
    private ByteBuffer A;
    private int B;
    private long C;
    private long D;
    private long E;
    private long F;
    private int G;
    private boolean H;
    private boolean I;
    private long J;
    private float K;
    private AudioProcessor[] L;
    private ByteBuffer[] M;
    private ByteBuffer N;
    private int O;
    private ByteBuffer P;
    private byte[] Q;
    private int R;
    private int S;
    private boolean T;
    private boolean U;
    /* access modifiers changed from: private */
    public boolean V;
    private boolean W;
    private int X;
    private AuxEffectInfo Y;
    private AudioDeviceInfoApi23 Z;

    /* renamed from: a  reason: collision with root package name */
    private final AudioCapabilities f23749a;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f23750a0;

    /* renamed from: b  reason: collision with root package name */
    private final AudioProcessorChain f23751b;
    /* access modifiers changed from: private */

    /* renamed from: b0  reason: collision with root package name */
    public long f23752b0;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f23753c;

    /* renamed from: c0  reason: collision with root package name */
    private boolean f23754c0;

    /* renamed from: d  reason: collision with root package name */
    private final ChannelMappingAudioProcessor f23755d;

    /* renamed from: d0  reason: collision with root package name */
    private boolean f23756d0;

    /* renamed from: e  reason: collision with root package name */
    private final TrimmingAudioProcessor f23757e;

    /* renamed from: f  reason: collision with root package name */
    private final AudioProcessor[] f23758f;

    /* renamed from: g  reason: collision with root package name */
    private final AudioProcessor[] f23759g;

    /* renamed from: h  reason: collision with root package name */
    private final ConditionVariable f23760h;

    /* renamed from: i  reason: collision with root package name */
    private final AudioTrackPositionTracker f23761i;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayDeque<MediaPositionParameters> f23762j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f23763k;

    /* renamed from: l  reason: collision with root package name */
    private final int f23764l;

    /* renamed from: m  reason: collision with root package name */
    private StreamEventCallbackV29 f23765m;

    /* renamed from: n  reason: collision with root package name */
    private final PendingExceptionHolder<AudioSink.InitializationException> f23766n;

    /* renamed from: o  reason: collision with root package name */
    private final PendingExceptionHolder<AudioSink.WriteException> f23767o;

    /* renamed from: p  reason: collision with root package name */
    private final AudioTrackBufferSizeProvider f23768p;

    /* renamed from: q  reason: collision with root package name */
    private final ExoPlayer.AudioOffloadListener f23769q;

    /* renamed from: r  reason: collision with root package name */
    private PlayerId f23770r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public AudioSink.Listener f23771s;

    /* renamed from: t  reason: collision with root package name */
    private Configuration f23772t;

    /* renamed from: u  reason: collision with root package name */
    private Configuration f23773u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public AudioTrack f23774v;

    /* renamed from: w  reason: collision with root package name */
    private AudioAttributes f23775w;

    /* renamed from: x  reason: collision with root package name */
    private MediaPositionParameters f23776x;

    /* renamed from: y  reason: collision with root package name */
    private MediaPositionParameters f23777y;

    /* renamed from: z  reason: collision with root package name */
    private PlaybackParameters f23778z;

    private static final class Api23 {
        private Api23() {
        }

        public static void a(AudioTrack audioTrack, AudioDeviceInfoApi23 audioDeviceInfoApi23) {
            AudioDeviceInfo audioDeviceInfo;
            if (audioDeviceInfoApi23 == null) {
                audioDeviceInfo = null;
            } else {
                audioDeviceInfo = audioDeviceInfoApi23.f23779a;
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

    private static final class AudioDeviceInfoApi23 {

        /* renamed from: a  reason: collision with root package name */
        public final AudioDeviceInfo f23779a;

        public AudioDeviceInfoApi23(AudioDeviceInfo audioDeviceInfo) {
            this.f23779a = audioDeviceInfo;
        }
    }

    public interface AudioTrackBufferSizeProvider {

        /* renamed from: a  reason: collision with root package name */
        public static final AudioTrackBufferSizeProvider f23780a = new DefaultAudioTrackBufferSizeProvider.Builder().g();

        int a(int i2, int i3, int i4, int i5, int i6, int i7, double d2);
    }

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public AudioCapabilities f23781a = AudioCapabilities.f23674c;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public AudioProcessorChain f23782b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f23783c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f23784d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f23785e = 0;

        /* renamed from: f  reason: collision with root package name */
        AudioTrackBufferSizeProvider f23786f = AudioTrackBufferSizeProvider.f23780a;

        /* renamed from: g  reason: collision with root package name */
        ExoPlayer.AudioOffloadListener f23787g;

        public DefaultAudioSink f() {
            if (this.f23782b == null) {
                this.f23782b = new DefaultAudioProcessorChain(new AudioProcessor[0]);
            }
            return new DefaultAudioSink(this);
        }

        public Builder g(AudioCapabilities audioCapabilities) {
            Assertions.e(audioCapabilities);
            this.f23781a = audioCapabilities;
            return this;
        }

        public Builder h(boolean z2) {
            this.f23784d = z2;
            return this;
        }

        public Builder i(boolean z2) {
            this.f23783c = z2;
            return this;
        }

        public Builder j(int i2) {
            this.f23785e = i2;
            return this;
        }
    }

    private static final class Configuration {

        /* renamed from: a  reason: collision with root package name */
        public final Format f23788a;

        /* renamed from: b  reason: collision with root package name */
        public final int f23789b;

        /* renamed from: c  reason: collision with root package name */
        public final int f23790c;

        /* renamed from: d  reason: collision with root package name */
        public final int f23791d;

        /* renamed from: e  reason: collision with root package name */
        public final int f23792e;

        /* renamed from: f  reason: collision with root package name */
        public final int f23793f;

        /* renamed from: g  reason: collision with root package name */
        public final int f23794g;

        /* renamed from: h  reason: collision with root package name */
        public final int f23795h;

        /* renamed from: i  reason: collision with root package name */
        public final AudioProcessor[] f23796i;

        public Configuration(Format format, int i2, int i3, int i4, int i5, int i6, int i7, int i8, AudioProcessor[] audioProcessorArr) {
            this.f23788a = format;
            this.f23789b = i2;
            this.f23790c = i3;
            this.f23791d = i4;
            this.f23792e = i5;
            this.f23793f = i6;
            this.f23794g = i7;
            this.f23795h = i8;
            this.f23796i = audioProcessorArr;
        }

        private AudioTrack d(boolean z2, AudioAttributes audioAttributes, int i2) {
            int i3 = Util.f28808a;
            if (i3 >= 29) {
                return f(z2, audioAttributes, i2);
            }
            if (i3 >= 21) {
                return e(z2, audioAttributes, i2);
            }
            return g(audioAttributes, i2);
        }

        private AudioTrack e(boolean z2, AudioAttributes audioAttributes, int i2) {
            return new AudioTrack(i(audioAttributes, z2), DefaultAudioSink.L(this.f23792e, this.f23793f, this.f23794g), this.f23795h, 1, i2);
        }

        private AudioTrack f(boolean z2, AudioAttributes audioAttributes, int i2) {
            AudioFormat B = DefaultAudioSink.L(this.f23792e, this.f23793f, this.f23794g);
            AudioAttributes i3 = i(audioAttributes, z2);
            boolean z3 = true;
            AudioTrack.Builder a2 = new AudioTrack.Builder().setAudioAttributes(i3).setAudioFormat(B).setTransferMode(1).setBufferSizeInBytes(this.f23795h).setSessionId(i2);
            if (this.f23790c != 1) {
                z3 = false;
            }
            return a2.setOffloadedPlayback(z3).build();
        }

        private AudioTrack g(AudioAttributes audioAttributes, int i2) {
            int h02 = Util.h0(audioAttributes.f23664d);
            if (i2 == 0) {
                return new AudioTrack(h02, this.f23792e, this.f23793f, this.f23794g, this.f23795h, 1);
            }
            return new AudioTrack(h02, this.f23792e, this.f23793f, this.f23794g, this.f23795h, 1, i2);
        }

        private static AudioAttributes i(AudioAttributes audioAttributes, boolean z2) {
            if (z2) {
                return j();
            }
            return audioAttributes.b().f23668a;
        }

        private static AudioAttributes j() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public AudioTrack a(boolean z2, AudioAttributes audioAttributes, int i2) throws AudioSink.InitializationException {
            try {
                AudioTrack d2 = d(z2, audioAttributes, i2);
                int state = d2.getState();
                if (state == 1) {
                    return d2;
                }
                try {
                    d2.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.f23792e, this.f23793f, this.f23795h, this.f23788a, l(), (Exception) null);
            } catch (IllegalArgumentException | UnsupportedOperationException e2) {
                throw new AudioSink.InitializationException(0, this.f23792e, this.f23793f, this.f23795h, this.f23788a, l(), e2);
            }
        }

        public boolean b(Configuration configuration) {
            return configuration.f23790c == this.f23790c && configuration.f23794g == this.f23794g && configuration.f23792e == this.f23792e && configuration.f23793f == this.f23793f && configuration.f23791d == this.f23791d;
        }

        public Configuration c(int i2) {
            return new Configuration(this.f23788a, this.f23789b, this.f23790c, this.f23791d, this.f23792e, this.f23793f, this.f23794g, i2, this.f23796i);
        }

        public long h(long j2) {
            return (j2 * 1000000) / ((long) this.f23792e);
        }

        public long k(long j2) {
            return (j2 * 1000000) / ((long) this.f23788a.A);
        }

        public boolean l() {
            return this.f23790c == 1;
        }
    }

    public static class DefaultAudioProcessorChain implements AudioProcessorChain {

        /* renamed from: a  reason: collision with root package name */
        private final AudioProcessor[] f23797a;

        /* renamed from: b  reason: collision with root package name */
        private final SilenceSkippingAudioProcessor f23798b;

        /* renamed from: c  reason: collision with root package name */
        private final SonicAudioProcessor f23799c;

        public DefaultAudioProcessorChain(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new SilenceSkippingAudioProcessor(), new SonicAudioProcessor());
        }

        public long a(long j2) {
            return this.f23799c.f(j2);
        }

        public AudioProcessor[] b() {
            return this.f23797a;
        }

        public long c() {
            return this.f23798b.o();
        }

        public boolean d(boolean z2) {
            this.f23798b.u(z2);
            return z2;
        }

        public PlaybackParameters e(PlaybackParameters playbackParameters) {
            this.f23799c.h(playbackParameters.f23399b);
            this.f23799c.g(playbackParameters.f23400c);
            return playbackParameters;
        }

        public DefaultAudioProcessorChain(AudioProcessor[] audioProcessorArr, SilenceSkippingAudioProcessor silenceSkippingAudioProcessor, SonicAudioProcessor sonicAudioProcessor) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[(audioProcessorArr.length + 2)];
            this.f23797a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f23798b = silenceSkippingAudioProcessor;
            this.f23799c = sonicAudioProcessor;
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
        public final PlaybackParameters f23800a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f23801b;

        /* renamed from: c  reason: collision with root package name */
        public final long f23802c;

        /* renamed from: d  reason: collision with root package name */
        public final long f23803d;

        private MediaPositionParameters(PlaybackParameters playbackParameters, boolean z2, long j2, long j3) {
            this.f23800a = playbackParameters;
            this.f23801b = z2;
            this.f23802c = j2;
            this.f23803d = j3;
        }
    }

    private static final class PendingExceptionHolder<T extends Exception> {

        /* renamed from: a  reason: collision with root package name */
        private final long f23804a;

        /* renamed from: b  reason: collision with root package name */
        private T f23805b;

        /* renamed from: c  reason: collision with root package name */
        private long f23806c;

        public PendingExceptionHolder(long j2) {
            this.f23804a = j2;
        }

        public void a() {
            this.f23805b = null;
        }

        public void b(T t2) throws Exception {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f23805b == null) {
                this.f23805b = t2;
                this.f23806c = this.f23804a + elapsedRealtime;
            }
            if (elapsedRealtime >= this.f23806c) {
                T t3 = this.f23805b;
                if (t3 != t2) {
                    t3.addSuppressed(t2);
                }
                T t4 = this.f23805b;
                a();
                throw t4;
            }
        }
    }

    private final class PositionTrackerListener implements AudioTrackPositionTracker.Listener {
        private PositionTrackerListener() {
        }

        public void a(int i2, long j2) {
            if (DefaultAudioSink.this.f23771s != null) {
                DefaultAudioSink.this.f23771s.d(i2, j2, SystemClock.elapsedRealtime() - DefaultAudioSink.this.f23752b0);
            }
        }

        public void b(long j2) {
            if (DefaultAudioSink.this.f23771s != null) {
                DefaultAudioSink.this.f23771s.b(j2);
            }
        }

        public void c(long j2) {
            Log.i("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j2);
        }

        public void d(long j2, long j3, long j4, long j5) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j2 + ", " + j3 + ", " + j4 + ", " + j5 + ", " + DefaultAudioSink.this.S() + ", " + DefaultAudioSink.this.T();
            if (!DefaultAudioSink.f23745e0) {
                Log.i("DefaultAudioSink", str);
                return;
            }
            throw new InvalidAudioTrackTimestampException(str);
        }

        public void e(long j2, long j3, long j4, long j5) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j2 + ", " + j3 + ", " + j4 + ", " + j5 + ", " + DefaultAudioSink.this.S() + ", " + DefaultAudioSink.this.T();
            if (!DefaultAudioSink.f23745e0) {
                Log.i("DefaultAudioSink", str);
                return;
            }
            throw new InvalidAudioTrackTimestampException(str);
        }
    }

    private final class StreamEventCallbackV29 {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f23808a = new Handler(Looper.myLooper());

        /* renamed from: b  reason: collision with root package name */
        private final AudioTrack.StreamEventCallback f23809b;

        public StreamEventCallbackV29() {
            this.f23809b = new AudioTrack.StreamEventCallback(DefaultAudioSink.this) {
                public void onDataRequest(AudioTrack audioTrack, int i2) {
                    if (audioTrack.equals(DefaultAudioSink.this.f23774v) && DefaultAudioSink.this.f23771s != null && DefaultAudioSink.this.V) {
                        DefaultAudioSink.this.f23771s.f();
                    }
                }

                public void onTearDown(AudioTrack audioTrack) {
                    if (audioTrack.equals(DefaultAudioSink.this.f23774v) && DefaultAudioSink.this.f23771s != null && DefaultAudioSink.this.V) {
                        DefaultAudioSink.this.f23771s.f();
                    }
                }
            };
        }

        public void a(AudioTrack audioTrack) {
            Handler handler = this.f23808a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new b1(handler), this.f23809b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f23809b);
            this.f23808a.removeCallbacksAndMessages((Object) null);
        }
    }

    private void E(long j2) {
        PlaybackParameters playbackParameters;
        boolean z2;
        if (l0()) {
            playbackParameters = this.f23751b.e(M());
        } else {
            playbackParameters = PlaybackParameters.f23395e;
        }
        PlaybackParameters playbackParameters2 = playbackParameters;
        if (l0()) {
            z2 = this.f23751b.d(R());
        } else {
            z2 = false;
        }
        this.f23762j.add(new MediaPositionParameters(playbackParameters2, z2, Math.max(0, j2), this.f23773u.h(T())));
        k0();
        AudioSink.Listener listener = this.f23771s;
        if (listener != null) {
            listener.onSkipSilenceEnabledChanged(z2);
        }
    }

    private long F(long j2) {
        while (!this.f23762j.isEmpty() && j2 >= this.f23762j.getFirst().f23803d) {
            this.f23777y = this.f23762j.remove();
        }
        MediaPositionParameters mediaPositionParameters = this.f23777y;
        long j3 = j2 - mediaPositionParameters.f23803d;
        if (mediaPositionParameters.f23800a.equals(PlaybackParameters.f23395e)) {
            return this.f23777y.f23802c + j3;
        }
        if (this.f23762j.isEmpty()) {
            return this.f23777y.f23802c + this.f23751b.a(j3);
        }
        MediaPositionParameters first = this.f23762j.getFirst();
        return first.f23802c - Util.b0(first.f23803d - j2, this.f23777y.f23800a.f23399b);
    }

    private long G(long j2) {
        return j2 + this.f23773u.h(this.f23751b.c());
    }

    private AudioTrack H(Configuration configuration) throws AudioSink.InitializationException {
        try {
            AudioTrack a2 = configuration.a(this.f23750a0, this.f23775w, this.X);
            ExoPlayer.AudioOffloadListener audioOffloadListener = this.f23769q;
            if (audioOffloadListener != null) {
                audioOffloadListener.A(X(a2));
            }
            return a2;
        } catch (AudioSink.InitializationException e2) {
            AudioSink.Listener listener = this.f23771s;
            if (listener != null) {
                listener.a(e2);
            }
            throw e2;
        }
    }

    private AudioTrack I() throws AudioSink.InitializationException {
        try {
            return H((Configuration) Assertions.e(this.f23773u));
        } catch (AudioSink.InitializationException e2) {
            Configuration configuration = this.f23773u;
            if (configuration.f23795h > 1000000) {
                Configuration c2 = configuration.c(1000000);
                try {
                    AudioTrack H2 = H(c2);
                    this.f23773u = c2;
                    return H2;
                } catch (AudioSink.InitializationException e3) {
                    e2.addSuppressed(e3);
                    Z();
                    throw e2;
                }
            }
            Z();
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean J() throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        /*
            r9 = this;
            int r0 = r9.S
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto L_0x000b
            r9.S = r2
        L_0x0009:
            r0 = 1
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            int r4 = r9.S
            com.google.android.exoplayer2.audio.AudioProcessor[] r5 = r9.L
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x002f
            r4 = r5[r4]
            if (r0 == 0) goto L_0x001f
            r4.d()
        L_0x001f:
            r9.b0(r7)
            boolean r0 = r4.a()
            if (r0 != 0) goto L_0x0029
            return r2
        L_0x0029:
            int r0 = r9.S
            int r0 = r0 + r1
            r9.S = r0
            goto L_0x0009
        L_0x002f:
            java.nio.ByteBuffer r0 = r9.P
            if (r0 == 0) goto L_0x003b
            r9.o0(r0, r7)
            java.nio.ByteBuffer r0 = r9.P
            if (r0 == 0) goto L_0x003b
            return r2
        L_0x003b:
            r9.S = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.J():boolean");
    }

    private void K() {
        int i2 = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.L;
            if (i2 < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i2];
                audioProcessor.flush();
                this.M[i2] = audioProcessor.b();
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public static AudioFormat L(int i2, int i3, int i4) {
        return new AudioFormat.Builder().setSampleRate(i2).setChannelMask(i3).setEncoding(i4).build();
    }

    private PlaybackParameters M() {
        return P().f23800a;
    }

    private static int N(int i2, int i3, int i4) {
        boolean z2;
        int minBufferSize = AudioTrack.getMinBufferSize(i2, i3, i4);
        if (minBufferSize != -2) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        return minBufferSize;
    }

    private static int O(int i2, ByteBuffer byteBuffer) {
        switch (i2) {
            case 5:
            case 6:
            case 18:
                return Ac3Util.e(byteBuffer);
            case 7:
            case 8:
                return DtsUtil.e(byteBuffer);
            case 9:
                int m2 = MpegAudioUtil.m(Util.I(byteBuffer, byteBuffer.position()));
                if (m2 != -1) {
                    return m2;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 14:
                int b2 = Ac3Util.b(byteBuffer);
                if (b2 == -1) {
                    return 0;
                }
                return Ac3Util.i(byteBuffer, b2) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return Ac4Util.c(byteBuffer);
            case 20:
                return OpusUtil.g(byteBuffer);
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i2);
        }
    }

    private MediaPositionParameters P() {
        MediaPositionParameters mediaPositionParameters = this.f23776x;
        if (mediaPositionParameters != null) {
            return mediaPositionParameters;
        }
        if (!this.f23762j.isEmpty()) {
            return this.f23762j.getLast();
        }
        return this.f23777y;
    }

    @SuppressLint({"InlinedApi"})
    private int Q(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        int i2 = Util.f28808a;
        if (i2 >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        }
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return 0;
        }
        if (i2 != 30 || !Util.f28811d.startsWith("Pixel")) {
            return 1;
        }
        return 2;
    }

    /* access modifiers changed from: private */
    public long S() {
        Configuration configuration = this.f23773u;
        if (configuration.f23790c == 0) {
            return this.C / ((long) configuration.f23789b);
        }
        return this.D;
    }

    /* access modifiers changed from: private */
    public long T() {
        Configuration configuration = this.f23773u;
        if (configuration.f23790c == 0) {
            return this.E / ((long) configuration.f23791d);
        }
        return this.F;
    }

    private boolean U() throws AudioSink.InitializationException {
        boolean z2;
        PlayerId playerId;
        if (!this.f23760h.e()) {
            return false;
        }
        AudioTrack I2 = I();
        this.f23774v = I2;
        if (X(I2)) {
            c0(this.f23774v);
            if (this.f23764l != 3) {
                AudioTrack audioTrack = this.f23774v;
                Format format = this.f23773u.f23788a;
                audioTrack.setOffloadDelayPadding(format.C, format.D);
            }
        }
        int i2 = Util.f28808a;
        if (i2 >= 31 && (playerId = this.f23770r) != null) {
            Api31.a(this.f23774v, playerId);
        }
        this.X = this.f23774v.getAudioSessionId();
        AudioTrackPositionTracker audioTrackPositionTracker = this.f23761i;
        AudioTrack audioTrack2 = this.f23774v;
        Configuration configuration = this.f23773u;
        if (configuration.f23790c == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        audioTrackPositionTracker.s(audioTrack2, z2, configuration.f23794g, configuration.f23791d, configuration.f23795h);
        h0();
        int i3 = this.Y.f23734a;
        if (i3 != 0) {
            this.f23774v.attachAuxEffect(i3);
            this.f23774v.setAuxEffectSendLevel(this.Y.f23735b);
        }
        AudioDeviceInfoApi23 audioDeviceInfoApi23 = this.Z;
        if (audioDeviceInfoApi23 != null && i2 >= 23) {
            Api23.a(this.f23774v, audioDeviceInfoApi23);
        }
        this.I = true;
        return true;
    }

    private static boolean V(int i2) {
        return (Util.f28808a >= 24 && i2 == -6) || i2 == -32;
    }

    private boolean W() {
        return this.f23774v != null;
    }

    private static boolean X(AudioTrack audioTrack) {
        return Util.f28808a >= 29 && audioTrack.isOffloadedPlayback();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void Y(AudioTrack audioTrack, ConditionVariable conditionVariable) {
        try {
            audioTrack.flush();
            audioTrack.release();
            conditionVariable.f();
            synchronized (f23746f0) {
                int i2 = f23748h0 - 1;
                f23748h0 = i2;
                if (i2 == 0) {
                    f23747g0.shutdown();
                    f23747g0 = null;
                }
            }
        } catch (Throwable th) {
            conditionVariable.f();
            synchronized (f23746f0) {
                int i3 = f23748h0 - 1;
                f23748h0 = i3;
                if (i3 == 0) {
                    f23747g0.shutdown();
                    f23747g0 = null;
                }
                throw th;
            }
        }
    }

    private void Z() {
        if (this.f23773u.l()) {
            this.f23754c0 = true;
        }
    }

    private void a0() {
        if (!this.U) {
            this.U = true;
            this.f23761i.g(T());
            this.f23774v.stop();
            this.B = 0;
        }
    }

    private void b0(long j2) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.L.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                byteBuffer = this.M[i2 - 1];
            } else {
                byteBuffer = this.N;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.f23680a;
                }
            }
            if (i2 == length) {
                o0(byteBuffer, j2);
            } else {
                AudioProcessor audioProcessor = this.L[i2];
                if (i2 > this.S) {
                    audioProcessor.c(byteBuffer);
                }
                ByteBuffer b2 = audioProcessor.b();
                this.M[i2] = b2;
                if (b2.hasRemaining()) {
                    i2++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i2--;
            } else {
                return;
            }
        }
    }

    private void c0(AudioTrack audioTrack) {
        if (this.f23765m == null) {
            this.f23765m = new StreamEventCallbackV29();
        }
        this.f23765m.a(audioTrack);
    }

    private static void d0(AudioTrack audioTrack, ConditionVariable conditionVariable) {
        conditionVariable.d();
        synchronized (f23746f0) {
            if (f23747g0 == null) {
                f23747g0 = Util.G0("ExoPlayer:AudioTrackReleaseThread");
            }
            f23748h0++;
            f23747g0.execute(new n(audioTrack, conditionVariable));
        }
    }

    private void e0() {
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.f23756d0 = false;
        this.G = 0;
        this.f23777y = new MediaPositionParameters(M(), R(), 0, 0);
        this.J = 0;
        this.f23776x = null;
        this.f23762j.clear();
        this.N = null;
        this.O = 0;
        this.P = null;
        this.U = false;
        this.T = false;
        this.S = -1;
        this.A = null;
        this.B = 0;
        this.f23757e.m();
        K();
    }

    private void f0(PlaybackParameters playbackParameters, boolean z2) {
        MediaPositionParameters P2 = P();
        if (!playbackParameters.equals(P2.f23800a) || z2 != P2.f23801b) {
            MediaPositionParameters mediaPositionParameters = new MediaPositionParameters(playbackParameters, z2, -9223372036854775807L, -9223372036854775807L);
            if (W()) {
                this.f23776x = mediaPositionParameters;
            } else {
                this.f23777y = mediaPositionParameters;
            }
        }
    }

    private void g0(PlaybackParameters playbackParameters) {
        if (W()) {
            try {
                this.f23774v.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(playbackParameters.f23399b).setPitch(playbackParameters.f23400c).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e2) {
                Log.j("DefaultAudioSink", "Failed to set playback params", e2);
            }
            playbackParameters = new PlaybackParameters(this.f23774v.getPlaybackParams().getSpeed(), this.f23774v.getPlaybackParams().getPitch());
            this.f23761i.t(playbackParameters.f23399b);
        }
        this.f23778z = playbackParameters;
    }

    private void h0() {
        if (W()) {
            if (Util.f28808a >= 21) {
                i0(this.f23774v, this.K);
            } else {
                j0(this.f23774v, this.K);
            }
        }
    }

    private static void i0(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    private static void j0(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    private void k0() {
        AudioProcessor[] audioProcessorArr = this.f23773u.f23796i;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.L = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.M = new ByteBuffer[size];
        K();
    }

    private boolean l0() {
        if (this.f23750a0 || !"audio/raw".equals(this.f23773u.f23788a.f23071m) || m0(this.f23773u.f23788a.B)) {
            return false;
        }
        return true;
    }

    private boolean m0(int i2) {
        return this.f23753c && Util.w0(i2);
    }

    private boolean n0(Format format, AudioAttributes audioAttributes) {
        int f2;
        int G2;
        int Q2;
        boolean z2;
        boolean z3;
        if (Util.f28808a < 29 || this.f23764l == 0 || (f2 = MimeTypes.f((String) Assertions.e(format.f23071m), format.f23068j)) == 0 || (G2 = Util.G(format.f23084z)) == 0 || (Q2 = Q(L(format.A, G2, f2), audioAttributes.b().f23668a)) == 0) {
            return false;
        }
        if (Q2 == 1) {
            if (format.C == 0 && format.D == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (this.f23764l == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z2 || !z3) {
                return true;
            }
            return false;
        } else if (Q2 == 2) {
            return true;
        } else {
            throw new IllegalStateException();
        }
    }

    private void o0(ByteBuffer byteBuffer, long j2) throws AudioSink.WriteException {
        int i2;
        AudioSink.Listener listener;
        boolean z2;
        boolean z3;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.P;
            boolean z4 = true;
            if (byteBuffer2 != null) {
                if (byteBuffer2 == byteBuffer) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Assertions.a(z3);
            } else {
                this.P = byteBuffer;
                if (Util.f28808a < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.Q;
                    if (bArr == null || bArr.length < remaining) {
                        this.Q = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.Q, 0, remaining);
                    byteBuffer.position(position);
                    this.R = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (Util.f28808a < 21) {
                int c2 = this.f23761i.c(this.E);
                if (c2 > 0) {
                    i2 = this.f23774v.write(this.Q, this.R, Math.min(remaining2, c2));
                    if (i2 > 0) {
                        this.R += i2;
                        byteBuffer.position(byteBuffer.position() + i2);
                    }
                } else {
                    i2 = 0;
                }
            } else if (this.f23750a0) {
                if (j2 != -9223372036854775807L) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.g(z2);
                i2 = q0(this.f23774v, byteBuffer, remaining2, j2);
            } else {
                i2 = p0(this.f23774v, byteBuffer, remaining2);
            }
            this.f23752b0 = SystemClock.elapsedRealtime();
            if (i2 < 0) {
                if (!V(i2) || this.F <= 0) {
                    z4 = false;
                }
                AudioSink.WriteException writeException = new AudioSink.WriteException(i2, this.f23773u.f23788a, z4);
                AudioSink.Listener listener2 = this.f23771s;
                if (listener2 != null) {
                    listener2.a(writeException);
                }
                if (!writeException.f23695c) {
                    this.f23767o.b(writeException);
                    return;
                }
                throw writeException;
            }
            this.f23767o.a();
            if (X(this.f23774v)) {
                if (this.F > 0) {
                    this.f23756d0 = false;
                }
                if (this.V && (listener = this.f23771s) != null && i2 < remaining2 && !this.f23756d0) {
                    listener.c();
                }
            }
            int i3 = this.f23773u.f23790c;
            if (i3 == 0) {
                this.E += (long) i2;
            }
            if (i2 == remaining2) {
                if (i3 != 0) {
                    if (byteBuffer != this.N) {
                        z4 = false;
                    }
                    Assertions.g(z4);
                    this.F += ((long) this.G) * ((long) this.O);
                }
                this.P = null;
            }
        }
    }

    private static int p0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
        return audioTrack.write(byteBuffer, i2, 1);
    }

    private int q0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j2) {
        if (Util.f28808a >= 26) {
            return audioTrack.write(byteBuffer, i2, 1, j2 * 1000);
        }
        if (this.A == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.A = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.A.putInt(1431633921);
        }
        if (this.B == 0) {
            this.A.putInt(4, i2);
            this.A.putLong(8, j2 * 1000);
            this.A.position(0);
            this.B = i2;
        }
        int remaining = this.A.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.A, remaining, 1);
            if (write < 0) {
                this.B = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int p02 = p0(audioTrack, byteBuffer, i2);
        if (p02 < 0) {
            this.B = 0;
            return p02;
        }
        this.B -= p02;
        return p02;
    }

    public boolean R() {
        return P().f23801b;
    }

    public boolean a() {
        return !W() || (this.T && !f());
    }

    public PlaybackParameters b() {
        if (this.f23763k) {
            return this.f23778z;
        }
        return M();
    }

    public boolean c(Format format) {
        return s(format) != 0;
    }

    public void d(float f2) {
        if (this.K != f2) {
            this.K = f2;
            h0();
        }
    }

    public void e(PlaybackParameters playbackParameters) {
        PlaybackParameters playbackParameters2 = new PlaybackParameters(Util.p(playbackParameters.f23399b, 0.1f, 8.0f), Util.p(playbackParameters.f23400c, 0.1f, 8.0f));
        if (!this.f23763k || Util.f28808a < 23) {
            f0(playbackParameters2, R());
        } else {
            g0(playbackParameters2);
        }
    }

    public boolean f() {
        if (!W() || !this.f23761i.h(T())) {
            return false;
        }
        return true;
    }

    public void flush() {
        if (W()) {
            e0();
            if (this.f23761i.i()) {
                this.f23774v.pause();
            }
            if (X(this.f23774v)) {
                ((StreamEventCallbackV29) Assertions.e(this.f23765m)).b(this.f23774v);
            }
            if (Util.f28808a < 21 && !this.W) {
                this.X = 0;
            }
            Configuration configuration = this.f23772t;
            if (configuration != null) {
                this.f23773u = configuration;
                this.f23772t = null;
            }
            this.f23761i.q();
            d0(this.f23774v, this.f23760h);
            this.f23774v = null;
        }
        this.f23767o.a();
        this.f23766n.a();
    }

    public void g(int i2) {
        boolean z2;
        if (this.X != i2) {
            this.X = i2;
            if (i2 != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.W = z2;
            flush();
        }
    }

    public void h() {
        if (this.f23750a0) {
            this.f23750a0 = false;
            flush();
        }
    }

    public boolean i(ByteBuffer byteBuffer, long j2, int i2) throws AudioSink.InitializationException, AudioSink.WriteException {
        boolean z2;
        boolean z3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = j2;
        int i3 = i2;
        ByteBuffer byteBuffer3 = this.N;
        if (byteBuffer3 == null || byteBuffer2 == byteBuffer3) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        if (this.f23772t != null) {
            if (!J()) {
                return false;
            }
            if (!this.f23772t.b(this.f23773u)) {
                a0();
                if (f()) {
                    return false;
                }
                flush();
            } else {
                this.f23773u = this.f23772t;
                this.f23772t = null;
                if (X(this.f23774v) && this.f23764l != 3) {
                    if (this.f23774v.getPlayState() == 3) {
                        this.f23774v.setOffloadEndOfStream();
                    }
                    AudioTrack audioTrack = this.f23774v;
                    Format format = this.f23773u.f23788a;
                    audioTrack.setOffloadDelayPadding(format.C, format.D);
                    this.f23756d0 = true;
                }
            }
            E(j3);
        }
        if (!W()) {
            try {
                if (!U()) {
                    return false;
                }
            } catch (AudioSink.InitializationException e2) {
                AudioSink.InitializationException initializationException = e2;
                if (!initializationException.f23690c) {
                    this.f23766n.b(initializationException);
                    return false;
                }
                throw initializationException;
            }
        }
        this.f23766n.a();
        if (this.I) {
            this.J = Math.max(0, j3);
            this.H = false;
            this.I = false;
            if (this.f23763k && Util.f28808a >= 23) {
                g0(this.f23778z);
            }
            E(j3);
            if (this.V) {
                play();
            }
        }
        if (!this.f23761i.k(T())) {
            return false;
        }
        if (this.N == null) {
            if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.a(z3);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            Configuration configuration = this.f23773u;
            if (configuration.f23790c != 0 && this.G == 0) {
                int O2 = O(configuration.f23794g, byteBuffer2);
                this.G = O2;
                if (O2 == 0) {
                    return true;
                }
            }
            if (this.f23776x != null) {
                if (!J()) {
                    return false;
                }
                E(j3);
                this.f23776x = null;
            }
            long k2 = this.J + this.f23773u.k(S() - this.f23757e.l());
            if (!this.H && Math.abs(k2 - j3) > 200000) {
                AudioSink.Listener listener = this.f23771s;
                if (listener != null) {
                    listener.a(new AudioSink.UnexpectedDiscontinuityException(j3, k2));
                }
                this.H = true;
            }
            if (this.H) {
                if (!J()) {
                    return false;
                }
                long j4 = j3 - k2;
                this.J += j4;
                this.H = false;
                E(j3);
                AudioSink.Listener listener2 = this.f23771s;
                if (!(listener2 == null || j4 == 0)) {
                    listener2.e();
                }
            }
            if (this.f23773u.f23790c == 0) {
                this.C += (long) byteBuffer.remaining();
            } else {
                this.D += ((long) this.G) * ((long) i3);
            }
            this.N = byteBuffer2;
            this.O = i3;
        }
        b0(j3);
        if (!this.N.hasRemaining()) {
            this.N = null;
            this.O = 0;
            return true;
        } else if (!this.f23761i.j(T())) {
            return false;
        } else {
            Log.i("DefaultAudioSink", "Resetting stalled audio track");
            flush();
            return true;
        }
    }

    public void j() throws AudioSink.WriteException {
        if (!this.T && W() && J()) {
            a0();
            this.T = true;
        }
    }

    public long k(boolean z2) {
        if (!W() || this.I) {
            return Long.MIN_VALUE;
        }
        return G(F(Math.min(this.f23761i.d(z2), this.f23773u.h(T()))));
    }

    public /* synthetic */ void l(long j2) {
        m.a(this, j2);
    }

    public void m() {
        this.H = true;
    }

    public void n() {
        boolean z2;
        if (Util.f28808a >= 21) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        Assertions.g(this.W);
        if (!this.f23750a0) {
            this.f23750a0 = true;
            flush();
        }
    }

    public void o(boolean z2) {
        f0(M(), z2);
    }

    public void p(AudioAttributes audioAttributes) {
        if (!this.f23775w.equals(audioAttributes)) {
            this.f23775w = audioAttributes;
            if (!this.f23750a0) {
                flush();
            }
        }
    }

    public void pause() {
        this.V = false;
        if (W() && this.f23761i.p()) {
            this.f23774v.pause();
        }
    }

    public void play() {
        this.V = true;
        if (W()) {
            this.f23761i.u();
            this.f23774v.play();
        }
    }

    public void q(PlayerId playerId) {
        this.f23770r = playerId;
    }

    public void r(AudioSink.Listener listener) {
        this.f23771s = listener;
    }

    public void reset() {
        flush();
        for (AudioProcessor reset : this.f23758f) {
            reset.reset();
        }
        for (AudioProcessor reset2 : this.f23759g) {
            reset2.reset();
        }
        this.V = false;
        this.f23754c0 = false;
    }

    public int s(Format format) {
        if ("audio/raw".equals(format.f23071m)) {
            if (!Util.x0(format.B)) {
                Log.i("DefaultAudioSink", "Invalid PCM encoding: " + format.B);
                return 0;
            }
            int i2 = format.B;
            if (i2 == 2 || (this.f23753c && i2 == 4)) {
                return 2;
            }
            return 1;
        } else if ((this.f23754c0 || !n0(format, this.f23775w)) && !this.f23749a.h(format)) {
            return 0;
        } else {
            return 2;
        }
    }

    public void setPreferredDevice(AudioDeviceInfo audioDeviceInfo) {
        AudioDeviceInfoApi23 audioDeviceInfoApi23;
        if (audioDeviceInfo == null) {
            audioDeviceInfoApi23 = null;
        } else {
            audioDeviceInfoApi23 = new AudioDeviceInfoApi23(audioDeviceInfo);
        }
        this.Z = audioDeviceInfoApi23;
        AudioTrack audioTrack = this.f23774v;
        if (audioTrack != null) {
            Api23.a(audioTrack, audioDeviceInfoApi23);
        }
    }

    public void t() {
        boolean z2;
        if (Util.f28808a < 25) {
            flush();
            return;
        }
        this.f23767o.a();
        this.f23766n.a();
        if (W()) {
            e0();
            if (this.f23761i.i()) {
                this.f23774v.pause();
            }
            this.f23774v.flush();
            this.f23761i.q();
            AudioTrackPositionTracker audioTrackPositionTracker = this.f23761i;
            AudioTrack audioTrack = this.f23774v;
            Configuration configuration = this.f23773u;
            if (configuration.f23790c == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            audioTrackPositionTracker.s(audioTrack, z2, configuration.f23794g, configuration.f23791d, configuration.f23795h);
            this.I = true;
        }
    }

    public void u(AuxEffectInfo auxEffectInfo) {
        if (!this.Y.equals(auxEffectInfo)) {
            int i2 = auxEffectInfo.f23734a;
            float f2 = auxEffectInfo.f23735b;
            AudioTrack audioTrack = this.f23774v;
            if (audioTrack != null) {
                if (this.Y.f23734a != i2) {
                    audioTrack.attachAuxEffect(i2);
                }
                if (i2 != 0) {
                    this.f23774v.setAuxEffectSendLevel(f2);
                }
            }
            this.Y = auxEffectInfo;
        }
    }

    public void v(Format format, int i2, int[] iArr) throws AudioSink.ConfigurationException {
        AudioProcessor[] audioProcessorArr;
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
        double d2;
        AudioProcessor[] audioProcessorArr2;
        int[] iArr2;
        Format format2 = format;
        if ("audio/raw".equals(format2.f23071m)) {
            Assertions.a(Util.x0(format2.B));
            i8 = Util.f0(format2.B, format2.f23084z);
            if (m0(format2.B)) {
                audioProcessorArr2 = this.f23759g;
            } else {
                audioProcessorArr2 = this.f23758f;
            }
            this.f23757e.n(format2.C, format2.D);
            if (Util.f28808a < 21 && format2.f23084z == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i15 = 0; i15 < 6; i15++) {
                    iArr2[i15] = i15;
                }
            } else {
                iArr2 = iArr;
            }
            this.f23755d.l(iArr2);
            AudioProcessor.AudioFormat audioFormat = new AudioProcessor.AudioFormat(format2.A, format2.f23084z, format2.B);
            int length = audioProcessorArr2.length;
            int i16 = 0;
            while (i16 < length) {
                AudioProcessor audioProcessor = audioProcessorArr2[i16];
                try {
                    AudioProcessor.AudioFormat e2 = audioProcessor.e(audioFormat);
                    if (audioProcessor.isActive()) {
                        audioFormat = e2;
                    }
                    i16++;
                } catch (AudioProcessor.UnhandledAudioFormatException e3) {
                    throw new AudioSink.ConfigurationException((Throwable) e3, format2);
                }
            }
            int i17 = audioFormat.f23684c;
            int i18 = audioFormat.f23682a;
            int G2 = Util.G(audioFormat.f23683b);
            audioProcessorArr = audioProcessorArr2;
            i5 = Util.f0(i17, audioFormat.f23683b);
            i7 = i17;
            i4 = i18;
            i6 = G2;
            i3 = 0;
        } else {
            AudioProcessor[] audioProcessorArr3 = new AudioProcessor[0];
            int i19 = format2.A;
            if (n0(format2, this.f23775w)) {
                audioProcessorArr = audioProcessorArr3;
                i4 = i19;
                i7 = MimeTypes.f((String) Assertions.e(format2.f23071m), format2.f23068j);
                i6 = Util.G(format2.f23084z);
                i8 = -1;
                i5 = -1;
                i3 = 1;
            } else {
                Pair<Integer, Integer> f2 = this.f23749a.f(format2);
                if (f2 != null) {
                    int intValue = ((Integer) f2.first).intValue();
                    audioProcessorArr = audioProcessorArr3;
                    i4 = i19;
                    i6 = ((Integer) f2.second).intValue();
                    i7 = intValue;
                    i8 = -1;
                    i5 = -1;
                    i3 = 2;
                } else {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + format2, format2);
                }
            }
        }
        if (i7 == 0) {
            throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i3 + ") for: " + format2, format2);
        } else if (i6 != 0) {
            if (i2 != 0) {
                i13 = i2;
                i12 = i7;
                i11 = i6;
                i9 = i5;
                i10 = i4;
            } else {
                AudioTrackBufferSizeProvider audioTrackBufferSizeProvider = this.f23768p;
                int N2 = N(i4, i6, i7);
                if (i5 != -1) {
                    i14 = i5;
                } else {
                    i14 = 1;
                }
                int i20 = format2.f23067i;
                if (this.f23763k) {
                    d2 = 8.0d;
                } else {
                    d2 = 1.0d;
                }
                i12 = i7;
                i11 = i6;
                i9 = i5;
                i10 = i4;
                i13 = audioTrackBufferSizeProvider.a(N2, i7, i3, i14, i4, i20, d2);
            }
            this.f23754c0 = false;
            Configuration configuration = new Configuration(format, i8, i3, i9, i10, i11, i12, i13, audioProcessorArr);
            if (W()) {
                this.f23772t = configuration;
            } else {
                this.f23773u = configuration;
            }
        } else {
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i3 + ") for: " + format2, format2);
        }
    }

    @RequiresNonNull({"#1.audioProcessorChain"})
    private DefaultAudioSink(Builder builder) {
        this.f23749a = builder.f23781a;
        AudioProcessorChain b2 = builder.f23782b;
        this.f23751b = b2;
        int i2 = Util.f28808a;
        this.f23753c = i2 >= 21 && builder.f23783c;
        this.f23763k = i2 >= 23 && builder.f23784d;
        this.f23764l = i2 >= 29 ? builder.f23785e : 0;
        this.f23768p = builder.f23786f;
        ConditionVariable conditionVariable = new ConditionVariable(Clock.f28651a);
        this.f23760h = conditionVariable;
        conditionVariable.f();
        this.f23761i = new AudioTrackPositionTracker(new PositionTrackerListener());
        ChannelMappingAudioProcessor channelMappingAudioProcessor = new ChannelMappingAudioProcessor();
        this.f23755d = channelMappingAudioProcessor;
        TrimmingAudioProcessor trimmingAudioProcessor = new TrimmingAudioProcessor();
        this.f23757e = trimmingAudioProcessor;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new BaseAudioProcessor[]{new ResamplingAudioProcessor(), channelMappingAudioProcessor, trimmingAudioProcessor});
        Collections.addAll(arrayList, b2.b());
        this.f23758f = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.f23759g = new AudioProcessor[]{new FloatResamplingAudioProcessor()};
        this.K = 1.0f;
        this.f23775w = AudioAttributes.f23655h;
        this.X = 0;
        this.Y = new AuxEffectInfo(0, 0.0f);
        PlaybackParameters playbackParameters = PlaybackParameters.f23395e;
        this.f23777y = new MediaPositionParameters(playbackParameters, false, 0, 0);
        this.f23778z = playbackParameters;
        this.S = -1;
        this.L = new AudioProcessor[0];
        this.M = new ByteBuffer[0];
        this.f23762j = new ArrayDeque<>();
        this.f23766n = new PendingExceptionHolder<>(100);
        this.f23767o = new PendingExceptionHolder<>(100);
        this.f23769q = builder.f23787g;
    }
}
