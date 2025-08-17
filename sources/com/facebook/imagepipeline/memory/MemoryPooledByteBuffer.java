package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.nio.ByteBuffer;

public class MemoryPooledByteBuffer implements PooledByteBuffer {
    CloseableReference<MemoryChunk> mBufRef;
    private final int mSize;

    public MemoryPooledByteBuffer(CloseableReference<MemoryChunk> closeableReference, int i2) {
        boolean z2;
        Preconditions.checkNotNull(closeableReference);
        if (i2 < 0 || i2 > closeableReference.get().getSize()) {
            z2 = false;
        } else {
            z2 = true;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        this.mBufRef = closeableReference.clone();
        this.mSize = i2;
    }

    public synchronized void close() {
        CloseableReference.closeSafely((CloseableReference<?>) this.mBufRef);
        this.mBufRef = null;
    }

    /* access modifiers changed from: package-private */
    public synchronized void ensureValid() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }

    public synchronized ByteBuffer getByteBuffer() {
        return this.mBufRef.get().getByteBuffer();
    }

    /* access modifiers changed from: package-private */
    public CloseableReference<MemoryChunk> getCloseableReference() {
        return this.mBufRef;
    }

    public synchronized long getNativePtr() throws UnsupportedOperationException {
        ensureValid();
        return this.mBufRef.get().getNativePtr();
    }

    public synchronized boolean isClosed() {
        return !CloseableReference.isValid(this.mBufRef);
    }

    public synchronized byte read(int i2) {
        ensureValid();
        boolean z2 = true;
        Preconditions.checkArgument(Boolean.valueOf(i2 >= 0));
        if (i2 >= this.mSize) {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        return this.mBufRef.get().read(i2);
    }

    public synchronized int size() {
        ensureValid();
        return this.mSize;
    }

    public synchronized int read(int i2, byte[] bArr, int i3, int i4) {
        ensureValid();
        Preconditions.checkArgument(Boolean.valueOf(i2 + i4 <= this.mSize));
        return this.mBufRef.get().read(i2, bArr, i3, i4);
    }
}
