package com.google.android.exoplayer2.audio;

import android.media.AudioDeviceInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import java.nio.ByteBuffer;

public interface AudioSink {

    public static final class InitializationException extends Exception {

        /* renamed from: b  reason: collision with root package name */
        public final int f23689b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f23690c;

        /* renamed from: d  reason: collision with root package name */
        public final Format f23691d;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InitializationException(int r4, int r5, int r6, int r7, com.google.android.exoplayer2.Format r8, boolean r9, java.lang.Exception r10) {
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
                r3.f23689b = r4
                r3.f23690c = r9
                r3.f23691d = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioSink.InitializationException.<init>(int, int, int, int, com.google.android.exoplayer2.Format, boolean, java.lang.Exception):void");
        }
    }

    public interface Listener {
        void a(Exception exc);

        void b(long j2);

        void c();

        void d(int i2, long j2, long j3);

        void e();

        void f();

        void onSkipSilenceEnabledChanged(boolean z2);
    }

    public static final class UnexpectedDiscontinuityException extends Exception {

        /* renamed from: b  reason: collision with root package name */
        public final long f23692b;

        /* renamed from: c  reason: collision with root package name */
        public final long f23693c;

        public UnexpectedDiscontinuityException(long j2, long j3) {
            super("Unexpected audio track timestamp discontinuity: expected " + j3 + ", got " + j2);
            this.f23692b = j2;
            this.f23693c = j3;
        }
    }

    public static final class WriteException extends Exception {

        /* renamed from: b  reason: collision with root package name */
        public final int f23694b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f23695c;

        /* renamed from: d  reason: collision with root package name */
        public final Format f23696d;

        public WriteException(int i2, Format format, boolean z2) {
            super("AudioTrack write failed: " + i2);
            this.f23695c = z2;
            this.f23694b = i2;
            this.f23696d = format;
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

    void q(PlayerId playerId);

    void r(Listener listener);

    void reset();

    int s(Format format);

    void setPreferredDevice(AudioDeviceInfo audioDeviceInfo);

    void t();

    void u(AuxEffectInfo auxEffectInfo);

    void v(Format format, int i2, int[] iArr) throws ConfigurationException;

    public static final class ConfigurationException extends Exception {

        /* renamed from: b  reason: collision with root package name */
        public final Format f23688b;

        public ConfigurationException(Throwable th, Format format) {
            super(th);
            this.f23688b = format;
        }

        public ConfigurationException(String str, Format format) {
            super(str);
            this.f23688b = format;
        }
    }
}
