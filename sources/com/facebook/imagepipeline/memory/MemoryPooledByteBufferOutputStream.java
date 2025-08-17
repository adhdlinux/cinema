package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class MemoryPooledByteBufferOutputStream extends PooledByteBufferOutputStream {
    private CloseableReference<MemoryChunk> mBufRef;
    private int mCount;
    private final MemoryChunkPool mPool;

    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool) {
        this(memoryChunkPool, memoryChunkPool.getMinBufferSize());
    }

    private void ensureValid() {
        if (!CloseableReference.isValid(this.mBufRef)) {
            throw new InvalidStreamException();
        }
    }

    public void close() {
        CloseableReference.closeSafely((CloseableReference<?>) this.mBufRef);
        this.mBufRef = null;
        this.mCount = -1;
        super.close();
    }

    /* access modifiers changed from: package-private */
    public void realloc(int i2) {
        ensureValid();
        Preconditions.checkNotNull(this.mBufRef);
        if (i2 > this.mBufRef.get().getSize()) {
            MemoryChunk memoryChunk = (MemoryChunk) this.mPool.get(i2);
            Preconditions.checkNotNull(this.mBufRef);
            this.mBufRef.get().copy(0, memoryChunk, 0, this.mCount);
            this.mBufRef.close();
            this.mBufRef = CloseableReference.of(memoryChunk, this.mPool);
        }
    }

    public int size() {
        return this.mCount;
    }

    public void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool, int i2) {
        Preconditions.checkArgument(Boolean.valueOf(i2 > 0));
        MemoryChunkPool memoryChunkPool2 = (MemoryChunkPool) Preconditions.checkNotNull(memoryChunkPool);
        this.mPool = memoryChunkPool2;
        this.mCount = 0;
        this.mBufRef = CloseableReference.of(memoryChunkPool2.get(i2), memoryChunkPool2);
    }

    public MemoryPooledByteBuffer toByteBuffer() {
        ensureValid();
        return new MemoryPooledByteBuffer((CloseableReference) Preconditions.checkNotNull(this.mBufRef), this.mCount);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > bArr.length) {
            throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i2 + "; regionLength=" + i3);
        }
        ensureValid();
        realloc(this.mCount + i3);
        ((MemoryChunk) ((CloseableReference) Preconditions.checkNotNull(this.mBufRef)).get()).write(this.mCount, bArr, i2, i3);
        this.mCount += i3;
    }
}
