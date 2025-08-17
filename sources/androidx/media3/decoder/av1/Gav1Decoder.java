package androidx.media3.decoder.av1;

import android.view.Surface;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import java.nio.ByteBuffer;

public final class Gav1Decoder extends SimpleDecoder<DecoderInputBuffer, VideoDecoderOutputBuffer, Gav1DecoderException> {

    /* renamed from: o  reason: collision with root package name */
    private final long f5092o;

    /* renamed from: p  reason: collision with root package name */
    private volatile int f5093p;

    public Gav1Decoder(int i2, int i3, int i4, int i5) throws Gav1DecoderException {
        super(new DecoderInputBuffer[i2], new VideoDecoderOutputBuffer[i3]);
        if (Gav1Library.a()) {
            if (i5 == 0 && (i5 = gav1GetThreads()) <= 0) {
                i5 = Runtime.getRuntime().availableProcessors();
            }
            long gav1Init = gav1Init(i5);
            this.f5092o = gav1Init;
            if (gav1Init == 0 || gav1CheckError(gav1Init) == 0) {
                throw new Gav1DecoderException("Failed to initialize decoder. Error: " + gav1GetErrorMessage(gav1Init));
            }
            w(i4);
            return;
        }
        throw new Gav1DecoderException("Failed to load decoder native library.");
    }

    private native int gav1CheckError(long j2);

    private native void gav1Close(long j2);

    private native int gav1Decode(long j2, ByteBuffer byteBuffer, int i2);

    private native String gav1GetErrorMessage(long j2);

    private native int gav1GetFrame(long j2, VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z2);

    private native int gav1GetThreads();

    private native long gav1Init(int i2);

    private native void gav1ReleaseFrame(long j2, VideoDecoderOutputBuffer videoDecoderOutputBuffer);

    private native int gav1RenderFrame(long j2, Surface surface, VideoDecoderOutputBuffer videoDecoderOutputBuffer);

    /* access modifiers changed from: protected */
    public void A(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        if (videoDecoderOutputBuffer.mode == 1 && !videoDecoderOutputBuffer.shouldBeSkipped) {
            gav1ReleaseFrame(this.f5092o, videoDecoderOutputBuffer);
        }
        super.t(videoDecoderOutputBuffer);
    }

    public void B(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) throws Gav1DecoderException {
        if (videoDecoderOutputBuffer.mode != 1) {
            throw new Gav1DecoderException("Invalid output mode.");
        } else if (gav1RenderFrame(this.f5092o, surface, videoDecoderOutputBuffer) == 0) {
            throw new Gav1DecoderException("Buffer render error: " + gav1GetErrorMessage(this.f5092o));
        }
    }

    public void C(int i2) {
        this.f5093p = i2;
    }

    public String getName() {
        return "libgav1";
    }

    /* access modifiers changed from: protected */
    public DecoderInputBuffer i() {
        return new DecoderInputBuffer(2);
    }

    public void release() {
        super.release();
        gav1Close(this.f5092o);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public VideoDecoderOutputBuffer j() {
        return new VideoDecoderOutputBuffer(new a(this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public Gav1DecoderException k(Throwable th) {
        return new Gav1DecoderException("Unexpected decode error", th);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public Gav1DecoderException l(DecoderInputBuffer decoderInputBuffer, VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z2) {
        ByteBuffer byteBuffer = (ByteBuffer) Util.i(decoderInputBuffer.f5067d);
        if (gav1Decode(this.f5092o, byteBuffer, byteBuffer.limit()) == 0) {
            return new Gav1DecoderException("gav1Decode error: " + gav1GetErrorMessage(this.f5092o));
        }
        boolean z3 = !p(decoderInputBuffer.f5069f);
        if (!z3) {
            videoDecoderOutputBuffer.init(decoderInputBuffer.f5069f, this.f5093p, (ByteBuffer) null);
        }
        int gav1GetFrame = gav1GetFrame(this.f5092o, videoDecoderOutputBuffer, z3);
        if (gav1GetFrame == 0) {
            return new Gav1DecoderException("gav1GetFrame error: " + gav1GetErrorMessage(this.f5092o));
        }
        if (gav1GetFrame == 2) {
            videoDecoderOutputBuffer.shouldBeSkipped = true;
        }
        if (!z3) {
            videoDecoderOutputBuffer.format = decoderInputBuffer.f5065b;
        }
        return null;
    }
}
