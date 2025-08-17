package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

public abstract class SimpleSubtitleDecoder extends SimpleDecoder<SubtitleInputBuffer, SubtitleOutputBuffer, SubtitleDecoderException> implements SubtitleDecoder {

    /* renamed from: n  reason: collision with root package name */
    private final String f27250n;

    protected SimpleSubtitleDecoder(String str) {
        super(new SubtitleInputBuffer[2], new SubtitleOutputBuffer[2]);
        this.f27250n = str;
        u(1024);
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public final SubtitleDecoderException j(SubtitleInputBuffer subtitleInputBuffer, SubtitleOutputBuffer subtitleOutputBuffer, boolean z2) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.e(subtitleInputBuffer.f23961d);
            SubtitleOutputBuffer subtitleOutputBuffer2 = subtitleOutputBuffer;
            subtitleOutputBuffer2.q(subtitleInputBuffer.f23963f, z(byteBuffer.array(), byteBuffer.limit(), z2), subtitleInputBuffer.f27264j);
            subtitleOutputBuffer.g(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e2) {
            return e2;
        }
    }

    public void b(long j2) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public final SubtitleInputBuffer g() {
        return new SubtitleInputBuffer();
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public final SubtitleOutputBuffer h() {
        return new SubtitleOutputBuffer() {
            public void p() {
                SimpleSubtitleDecoder.this.r(this);
            }
        };
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public final SubtitleDecoderException i(Throwable th) {
        return new SubtitleDecoderException("Unexpected decode error", th);
    }

    /* access modifiers changed from: protected */
    public abstract Subtitle z(byte[] bArr, int i2, boolean z2) throws SubtitleDecoderException;
}
