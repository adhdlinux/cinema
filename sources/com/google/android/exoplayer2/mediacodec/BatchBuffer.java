package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

final class BatchBuffer extends DecoderInputBuffer {

    /* renamed from: j  reason: collision with root package name */
    private long f25252j;

    /* renamed from: k  reason: collision with root package name */
    private int f25253k;

    /* renamed from: l  reason: collision with root package name */
    private int f25254l = 32;

    public BatchBuffer() {
        super(2);
    }

    private boolean w(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (!A()) {
            return true;
        }
        if (this.f25253k >= this.f25254l || decoderInputBuffer.j() != j()) {
            return false;
        }
        ByteBuffer byteBuffer2 = decoderInputBuffer.f23961d;
        if (byteBuffer2 == null || (byteBuffer = this.f23961d) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000) {
            return true;
        }
        return false;
    }

    public boolean A() {
        return this.f25253k > 0;
    }

    public void B(int i2) {
        boolean z2;
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f25254l = i2;
    }

    public void f() {
        super.f();
        this.f25253k = 0;
    }

    public boolean v(DecoderInputBuffer decoderInputBuffer) {
        Assertions.a(!decoderInputBuffer.s());
        Assertions.a(!decoderInputBuffer.i());
        Assertions.a(!decoderInputBuffer.k());
        if (!w(decoderInputBuffer)) {
            return false;
        }
        int i2 = this.f25253k;
        this.f25253k = i2 + 1;
        if (i2 == 0) {
            this.f23963f = decoderInputBuffer.f23963f;
            if (decoderInputBuffer.m()) {
                o(1);
            }
        }
        if (decoderInputBuffer.j()) {
            o(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer = decoderInputBuffer.f23961d;
        if (byteBuffer != null) {
            q(byteBuffer.remaining());
            this.f23961d.put(byteBuffer);
        }
        this.f25252j = decoderInputBuffer.f23963f;
        return true;
    }

    public long x() {
        return this.f23963f;
    }

    public long y() {
        return this.f25252j;
    }

    public int z() {
        return this.f25253k;
    }
}
