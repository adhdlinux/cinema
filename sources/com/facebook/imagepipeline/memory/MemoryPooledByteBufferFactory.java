package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.InputStream;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class MemoryPooledByteBufferFactory implements PooledByteBufferFactory {
    private final MemoryChunkPool mPool;
    private final PooledByteStreams mPooledByteStreams;

    public MemoryPooledByteBufferFactory(MemoryChunkPool memoryChunkPool, PooledByteStreams pooledByteStreams) {
        this.mPool = memoryChunkPool;
        this.mPooledByteStreams = pooledByteStreams;
    }

    /* access modifiers changed from: package-private */
    public MemoryPooledByteBuffer newByteBuf(InputStream inputStream, MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream) throws IOException {
        this.mPooledByteStreams.copy(inputStream, memoryPooledByteBufferOutputStream);
        return memoryPooledByteBufferOutputStream.toByteBuffer();
    }

    public MemoryPooledByteBufferOutputStream newOutputStream() {
        return new MemoryPooledByteBufferOutputStream(this.mPool);
    }

    public MemoryPooledByteBufferOutputStream newOutputStream(int i2) {
        return new MemoryPooledByteBufferOutputStream(this.mPool, i2);
    }

    public MemoryPooledByteBuffer newByteBuffer(int i2) {
        Preconditions.checkArgument(Boolean.valueOf(i2 > 0));
        CloseableReference of = CloseableReference.of(this.mPool.get(i2), this.mPool);
        try {
            return new MemoryPooledByteBuffer(of, i2);
        } finally {
            of.close();
        }
    }

    public MemoryPooledByteBuffer newByteBuffer(InputStream inputStream) throws IOException {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.mPool);
        try {
            return newByteBuf(inputStream, memoryPooledByteBufferOutputStream);
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    public MemoryPooledByteBuffer newByteBuffer(byte[] bArr) {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.mPool, bArr.length);
        try {
            memoryPooledByteBufferOutputStream.write(bArr, 0, bArr.length);
            MemoryPooledByteBuffer byteBuffer = memoryPooledByteBufferOutputStream.toByteBuffer();
            memoryPooledByteBufferOutputStream.close();
            return byteBuffer;
        } catch (IOException e2) {
            throw Throwables.propagate(e2);
        } catch (Throwable th) {
            memoryPooledByteBufferOutputStream.close();
            throw th;
        }
    }

    public MemoryPooledByteBuffer newByteBuffer(InputStream inputStream, int i2) throws IOException {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.mPool, i2);
        try {
            return newByteBuf(inputStream, memoryPooledByteBufferOutputStream);
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }
}
