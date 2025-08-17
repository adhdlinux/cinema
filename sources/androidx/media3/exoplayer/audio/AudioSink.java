package androidx.media3.exoplayer.audio;

import android.media.AudioDeviceInfo;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.analytics.PlayerId;
import java.nio.ByteBuffer;

public interface AudioSink {

    public static final class AudioTrackConfig {

        /* renamed from: a  reason: collision with root package name */
        public final int f5657a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5658b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5659c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f5660d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f5661e;

        /* renamed from: f  reason: collision with root package name */
        public final int f5662f;

        public AudioTrackConfig(int i2, int i3, int i4, boolean z2, boolean z3, int i5) {
            this.f5657a = i2;
            this.f5658b = i3;
            this.f5659c = i4;
            this.f5660d = z2;
            this.f5661e = z3;
            this.f5662f = i5;
        }
    }

    public static final class InitializationException extends Exception {

        /* renamed from: b  reason: collision with root package name */
        public final int f5664b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f5665c;

        /* renamed from: d  reason: collision with root package name */
        public final Format f5666d;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InitializationException(int r4, int r5, int r6, int r7, androidx.media3.common.Format r8, boolean r9, java.lang.Exception r10) {
            /*
                r3 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "AudioTrack init failed "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r1 = " "
                r0.append(r1)
                java.lang.String r2 = "Config("
                r0.append(r2)
                r0.append(r5)
                java.lang.String r5 = ", "
                r0.append(r5)
                r0.append(r6)
                r0.append(r5)
                r0.append(r7)
                java.lang.String r5 = ")"
                r0.append(r5)
                r0.append(r1)
                r0.append(r8)
                if (r9 == 0) goto L_0x0038
                java.lang.String r5 = " (recoverable)"
                goto L_0x003a
            L_0x0038:
                java.lang.String r5 = ""
            L_0x003a:
                r0.append(r5)
                java.lang.String r5 = r0.toString()
                r3.<init>(r5, r10)
                r3.f5664b = r4
                r3.f5665c = r9
                r3.f5666d = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.AudioSink.InitializationException.<init>(int, int, int, int, androidx.media3.common.Format, boolean, java.lang.Exception):void");
        }
    }

    public interface Listener {
        void a(Exception exc);

        void b(long j2);

        void c();

        void d(int i2, long j2, long j3);

        void e();

        void f();

        void g();

        void h();

        void m(AudioTrackConfig audioTrackConfig);

        void o(AudioTrackConfig audioTrackConfig);

        void onSkipSilenceEnabledChanged(boolean z2);
    }

    public static final class UnexpectedDiscontinuityException extends Exception {

        /* renamed from: b  reason: collision with root package name */
        public final long f5667b;

        /* renamed from: c  reason: collision with root package name */
        public final long f5668c;

        public UnexpectedDiscontinuityException(long j2, long j3) {
            super("Unexpected audio track timestamp discontinuity: expected " + j3 + ", got " + j2);
            this.f5667b = j2;
            this.f5668c = j3;
        }
    }

    public static final class WriteException extends Exception {

        /* renamed from: b  reason: collision with root package name */
        public final int f5669b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f5670c;

        /* renamed from: d  reason: collision with root package name */
        public final Format f5671d;

        public WriteException(int i2, Format format, boolean z2) {
            super("AudioTrack write failed: " + i2);
            this.f5670c = z2;
            this.f5669b = i2;
            this.f5671d = format;
        }
    }

    boolean a();

    PlaybackParameters b();

    boolean c(Format format);

    void d(float f2);

    void e(PlaybackParameters playbackParameters);

    boolean f();

    void flush();

    void g(int i2);

    void h();

    boolean i(ByteBuffer byteBuffer, long j2, int i2) throws InitializationException, WriteException;

    void j() throws WriteException;

    long k(boolean z2);

    void l(long j2);

    void m();

    void n();

    void o(boolean z2);

    void p(AudioAttributes audioAttributes);

    void pause();

    void play();

    AudioOffloadSupport q(Format format);

    void r(Listener listener);

    void release();

    void reset();

    void s(int i2);

    void setPreferredDevice(AudioDeviceInfo audioDeviceInfo);

    void t(Format format, int i2, int[] iArr) throws ConfigurationException;

    void u(int i2, int i3);

    void v(PlayerId playerId);

    int w(Format format);

    void x(AuxEffectInfo auxEffectInfo);

    void y(Clock clock);

    public static final class ConfigurationException extends Exception {

        /* renamed from: b  reason: collision with root package name */
        public final Format f5663b;

        public ConfigurationException(Throwable th, Format format) {
            super(th);
            this.f5663b = format;
        }

        public ConfigurationException(String str, Format format) {
            super(str);
            this.f5663b = format;
        }
    }
}
