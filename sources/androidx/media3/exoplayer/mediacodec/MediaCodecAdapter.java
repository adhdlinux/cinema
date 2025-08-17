package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.decoder.CryptoInfo;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface MediaCodecAdapter {

    public static final class Configuration {

        /* renamed from: a  reason: collision with root package name */
        public final MediaCodecInfo f6678a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaFormat f6679b;

        /* renamed from: c  reason: collision with root package name */
        public final Format f6680c;

        /* renamed from: d  reason: collision with root package name */
        public final Surface f6681d;

        /* renamed from: e  reason: collision with root package name */
        public final MediaCrypto f6682e;

        /* renamed from: f  reason: collision with root package name */
        public final int f6683f;

        private Configuration(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, Format format, Surface surface, MediaCrypto mediaCrypto, int i2) {
            this.f6678a = mediaCodecInfo;
            this.f6679b = mediaFormat;
            this.f6680c = format;
            this.f6681d = surface;
            this.f6682e = mediaCrypto;
            this.f6683f = i2;
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

    public interface OnBufferAvailableListener {
        void a();

        void b();
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

    boolean n(OnBufferAvailableListener onBufferAvailableListener);

    void o(OnFrameRenderedListener onFrameRenderedListener, Handler handler);

    void release();
}
