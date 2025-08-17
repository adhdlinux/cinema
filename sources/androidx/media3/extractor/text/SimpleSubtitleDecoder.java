package androidx.media3.extractor.text;

import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.SimpleDecoder;
import java.nio.ByteBuffer;

public abstract class SimpleSubtitleDecoder extends SimpleDecoder<SubtitleInputBuffer, SubtitleOutputBuffer, SubtitleDecoderException> implements SubtitleDecoder {

    /* renamed from: o  reason: collision with root package name */
    private final String f8780o;

    protected SimpleSubtitleDecoder(String str) {
        super(new SubtitleInputBuffer[2], new SubtitleOutputBuffer[2]);
        this.f8780o = str;
        w(1024);
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public final SubtitleDecoderException k(Throwable th) {
        return new SubtitleDecoderException("Unexpected decode error", th);
    }

    /* access modifiers changed from: protected */
    public abstract Subtitle B(byte[] bArr, int i2, boolean z2) throws SubtitleDecoderException;

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public final SubtitleDecoderException l(SubtitleInputBuffer subtitleInputBuffer, SubtitleOutputBuffer subtitleOutputBuffer, boolean z2) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.f(subtitleInputBuffer.f5067d);
            SubtitleOutputBuffer subtitleOutputBuffer2 = subtitleOutputBuffer;
            subtitleOutputBuffer2.e(subtitleInputBuffer.f5069f, B(byteBuffer.array(), byteBuffer.limit(), z2), subtitleInputBuffer.f8795j);
            subtitleOutputBuffer.shouldBeSkipped = false;
            return null;
        } catch (SubtitleDecoderException e2) {
            return e2;
        }
    }

    public void b(long j2) {
    }

    public final String getName() {
        return this.f8780o;
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public final SubtitleInputBuffer i() {
        return new SubtitleInputBuffer();
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public final SubtitleOutputBuffer j() {
        return new SubtitleOutputBuffer() {
            public void release() {
                SimpleSubtitleDecoder.this.t(this);
            }
        };
    }
}
