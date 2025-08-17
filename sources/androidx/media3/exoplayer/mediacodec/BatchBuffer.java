package androidx.media3.exoplayer.mediacodec;

import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

final class BatchBuffer extends DecoderInputBuffer {

    /* renamed from: j  reason: collision with root package name */
    private long f6672j;

    /* renamed from: k  reason: collision with root package name */
    private int f6673k;

    /* renamed from: l  reason: collision with root package name */
    private int f6674l = 32;

    public BatchBuffer() {
        super(2);
    }

    private boolean l(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (!p()) {
            return true;
        }
        if (this.f6673k >= this.f6674l) {
            return false;
        }
        ByteBuffer byteBuffer2 = decoderInputBuffer.f5067d;
        if (byteBuffer2 == null || (byteBuffer = this.f5067d) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000) {
            return true;
        }
        return false;
    }

    public void clear() {
        super.clear();
        this.f6673k = 0;
    }

    public boolean k(DecoderInputBuffer decoderInputBuffer) {
        Assertions.a(!decoderInputBuffer.h());
        Assertions.a(!decoderInputBuffer.hasSupplementalData());
        Assertions.a(!decoderInputBuffer.isEndOfStream());
        if (!l(decoderInputBuffer)) {
            return false;
        }
        int i2 = this.f6673k;
        this.f6673k = i2 + 1;
        if (i2 == 0) {
            this.f5069f = decoderInputBuffer.f5069f;
            if (decoderInputBuffer.isKeyFrame()) {
                setFlags(1);
            }
        }
        ByteBuffer byteBuffer = decoderInputBuffer.f5067d;
        if (byteBuffer != null) {
            f(byteBuffer.remaining());
            this.f5067d.put(byteBuffer);
        }
        this.f6672j = decoderInputBuffer.f5069f;
        return true;
    }

    public long m() {
        return this.f5069f;
    }

    public long n() {
        return this.f6672j;
    }

    public int o() {
        return this.f6673k;
    }

    public boolean p() {
        return this.f6673k > 0;
    }

    public void q(int i2) {
        boolean z2;
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f6674l = i2;
    }
}
