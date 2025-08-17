package androidx.media3.decoder.ffmpeg;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.decoder.SimpleDecoderOutputBuffer;
import com.facebook.imageutils.JfifUtil;
import java.nio.ByteBuffer;
import java.util.List;

final class FfmpegAudioDecoder extends SimpleDecoder<DecoderInputBuffer, SimpleDecoderOutputBuffer, FfmpegDecoderException> {

    /* renamed from: o  reason: collision with root package name */
    private final String f5101o;

    /* renamed from: p  reason: collision with root package name */
    private final byte[] f5102p;

    /* renamed from: q  reason: collision with root package name */
    private final int f5103q;

    /* renamed from: r  reason: collision with root package name */
    private final int f5104r;

    /* renamed from: s  reason: collision with root package name */
    private long f5105s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f5106t;

    /* renamed from: u  reason: collision with root package name */
    private volatile int f5107u;

    /* renamed from: v  reason: collision with root package name */
    private volatile int f5108v;

    public FfmpegAudioDecoder(Format format, int i2, int i3, int i4, boolean z2) throws FfmpegDecoderException {
        super(new DecoderInputBuffer[i2], new SimpleDecoderOutputBuffer[i3]);
        int i5;
        int i6;
        if (FfmpegLibrary.d()) {
            Assertions.f(format.f4015n);
            String str = (String) Assertions.f(FfmpegLibrary.a(format.f4015n));
            this.f5101o = str;
            byte[] E = E(format.f4015n, format.f4018q);
            this.f5102p = E;
            if (z2) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            this.f5103q = i5;
            if (z2) {
                i6 = 131072;
            } else {
                i6 = 65536;
            }
            this.f5104r = i6;
            long ffmpegInitialize = ffmpegInitialize(str, E, z2, format.C, format.B);
            this.f5105s = ffmpegInitialize;
            if (ffmpegInitialize != 0) {
                w(i4);
                return;
            }
            throw new FfmpegDecoderException("Initialization failed.");
        }
        throw new FfmpegDecoderException("Failed to load decoder native libraries.");
    }

    private static byte[] B(List<byte[]> list) {
        byte[] bArr = list.get(0);
        int length = bArr.length + 12;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1634492771);
        allocate.putInt(0);
        allocate.put(bArr, 0, bArr.length);
        return allocate.array();
    }

    private static byte[] E(String str, List<byte[]> list) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1003765268:
                if (str.equals("audio/vorbis")) {
                    c2 = 0;
                    break;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1504470054:
                if (str.equals("audio/alac")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1504891608:
                if (str.equals("audio/opus")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return G(list);
            case 1:
            case 3:
                return list.get(0);
            case 2:
                return B(list);
            default:
                return null;
        }
    }

    private static byte[] G(List<byte[]> list) {
        byte[] bArr = list.get(0);
        byte[] bArr2 = list.get(1);
        byte[] bArr3 = new byte[(bArr.length + bArr2.length + 6)];
        bArr3[0] = (byte) (bArr.length >> 8);
        bArr3[1] = (byte) (bArr.length & JfifUtil.MARKER_FIRST_BYTE);
        System.arraycopy(bArr, 0, bArr3, 2, bArr.length);
        bArr3[bArr.length + 2] = 0;
        bArr3[bArr.length + 3] = 0;
        bArr3[bArr.length + 4] = (byte) (bArr2.length >> 8);
        bArr3[bArr.length + 5] = (byte) (bArr2.length & JfifUtil.MARKER_FIRST_BYTE);
        System.arraycopy(bArr2, 0, bArr3, bArr.length + 6, bArr2.length);
        return bArr3;
    }

    private native int ffmpegDecode(long j2, ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3);

    private native int ffmpegGetChannelCount(long j2);

    private native int ffmpegGetSampleRate(long j2);

    private native long ffmpegInitialize(String str, byte[] bArr, boolean z2, int i2, int i3);

    private native void ffmpegRelease(long j2);

    private native long ffmpegReset(long j2, byte[] bArr);

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public FfmpegDecoderException l(DecoderInputBuffer decoderInputBuffer, SimpleDecoderOutputBuffer simpleDecoderOutputBuffer, boolean z2) {
        if (z2) {
            long ffmpegReset = ffmpegReset(this.f5105s, this.f5102p);
            this.f5105s = ffmpegReset;
            if (ffmpegReset == 0) {
                return new FfmpegDecoderException("Error resetting (see logcat).");
            }
        }
        ByteBuffer byteBuffer = (ByteBuffer) Util.i(decoderInputBuffer.f5067d);
        int limit = byteBuffer.limit();
        ByteBuffer e2 = simpleDecoderOutputBuffer.e(decoderInputBuffer.f5069f, this.f5104r);
        int ffmpegDecode = ffmpegDecode(this.f5105s, byteBuffer, limit, e2, this.f5104r);
        if (ffmpegDecode == -2) {
            return new FfmpegDecoderException("Error decoding (see logcat).");
        }
        if (ffmpegDecode == -1) {
            simpleDecoderOutputBuffer.shouldBeSkipped = true;
            return null;
        } else if (ffmpegDecode == 0) {
            simpleDecoderOutputBuffer.shouldBeSkipped = true;
            return null;
        } else {
            if (!this.f5106t) {
                this.f5107u = ffmpegGetChannelCount(this.f5105s);
                this.f5108v = ffmpegGetSampleRate(this.f5105s);
                if (this.f5108v == 0 && "alac".equals(this.f5101o)) {
                    Assertions.f(this.f5102p);
                    ParsableByteArray parsableByteArray = new ParsableByteArray(this.f5102p);
                    parsableByteArray.U(this.f5102p.length - 4);
                    this.f5108v = parsableByteArray.L();
                }
                this.f5106t = true;
            }
            e2.position(0);
            e2.limit(ffmpegDecode);
            return null;
        }
    }

    public int C() {
        return this.f5107u;
    }

    public int D() {
        return this.f5103q;
    }

    public int F() {
        return this.f5108v;
    }

    public String getName() {
        return "ffmpeg" + FfmpegLibrary.c() + "-" + this.f5101o;
    }

    /* access modifiers changed from: protected */
    public DecoderInputBuffer i() {
        return new DecoderInputBuffer(2, FfmpegLibrary.b());
    }

    public void release() {
        super.release();
        ffmpegRelease(this.f5105s);
        this.f5105s = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public SimpleDecoderOutputBuffer j() {
        return new SimpleDecoderOutputBuffer(new a(this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public FfmpegDecoderException k(Throwable th) {
        return new FfmpegDecoderException("Unexpected decode error", th);
    }
}
