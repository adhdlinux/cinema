package androidx.media3.decoder;

import androidx.media3.decoder.DecoderOutputBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SimpleDecoderOutputBuffer extends DecoderOutputBuffer {

    /* renamed from: b  reason: collision with root package name */
    private final DecoderOutputBuffer.Owner<SimpleDecoderOutputBuffer> f5090b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f5091c;

    public SimpleDecoderOutputBuffer(DecoderOutputBuffer.Owner<SimpleDecoderOutputBuffer> owner) {
        this.f5090b = owner;
    }

    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.f5091c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public ByteBuffer e(long j2, int i2) {
        this.timeUs = j2;
        ByteBuffer byteBuffer = this.f5091c;
        if (byteBuffer == null || byteBuffer.capacity() < i2) {
            this.f5091c = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        }
        this.f5091c.position(0);
        this.f5091c.limit(i2);
        return this.f5091c;
    }

    public void release() {
        this.f5090b.a(this);
    }
}
