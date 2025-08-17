package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface MediaCodecAdapter {

    public static final class Configuration {

        /* renamed from: a  reason: collision with root package name */
        public final MediaCodecInfo f25265a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaFormat f25266b;

        /* renamed from: c  reason: collision with root package name */
        public final Format f25267c;

        /* renamed from: d  reason: collision with root package name */
        public final Surface f25268d;

        /* renamed from: e  reason: collision with root package name */
        public final MediaCrypto f25269e;

        /* renamed from: f  reason: collision with root package name */
        public final int f25270f;

        private Configuration(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, Format format, Surface surface, MediaCrypto mediaCrypto, int i2) {
            this.f25265a = mediaCodecInfo;
            this.f25266b = mediaFormat;
            this.f25267c = format;
            this.f25268d = surface;
            this.f25269e = mediaCrypto;
            this.f25270f = i2;
        }

        public static Configuration a(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, Format format, MediaCrypto mediaCrypto) {
            return new Configuration(mediaCodecInfo, mediaFormat, format, (Surface) null, mediaCrypto, 0);
        }

        public static Configuration b(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, Format format, Surface surface, MediaCrypto mediaCrypto) {
            return new Configuration(mediaCodecInfo, mediaFormat, format, surface, mediaCrypto, 0);
        }
    }

    public interface Factory {
        MediaCodecAdapter a(Configuration configuration) throws IOException;
    }

    public interface OnFrameRenderedListener {
        void a(MediaCodecAdapter mediaCodecAdapter, long j2, long j3);
    }

    void a(int i2, int i3, int i4, long j2, int i5);

    void b(Bundle bundle);

    MediaFormat c();

    void d(int i2);

    ByteBuffer e(int i2);

    void f(Surface surface);

    void flush();

    void g(int i2, int i3, CryptoInfo cryptoInfo, long j2, int i4);

    boolean h();

    void i(int i2, long j2);

    int j();

    int k(MediaCodec.BufferInfo bufferInfo);

    void l(int i2, boolean z2);

    ByteBuffer m(int i2);

    void n(OnFrameRenderedListener onFrameRenderedListener, Handler handler);

    void release();
}
