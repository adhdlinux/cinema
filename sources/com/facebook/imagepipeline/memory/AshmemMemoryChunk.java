package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.util.Log;
import com.facebook.common.internal.Preconditions;
import java.io.Closeable;
import java.nio.ByteBuffer;

@TargetApi(27)
public class AshmemMemoryChunk implements MemoryChunk, Closeable {
    private static final String TAG = "AshmemMemoryChunk";
    private ByteBuffer mByteBuffer;
    private final long mId;
    private SharedMemory mSharedMemory;

    public AshmemMemoryChunk(int i2) {
        Preconditions.checkArgument(Boolean.valueOf(i2 > 0));
        try {
            SharedMemory a2 = SharedMemory.create(TAG, i2);
            this.mSharedMemory = a2;
            this.mByteBuffer = a2.mapReadWrite();
            this.mId = (long) System.identityHashCode(this);
        } catch (ErrnoException e2) {
            throw new RuntimeException("Fail to create AshmemMemory", e2);
        }
    }

    private void doCopy(int i2, MemoryChunk memoryChunk, int i3, int i4) {
        if (memoryChunk instanceof AshmemMemoryChunk) {
            Preconditions.checkState(!isClosed());
            Preconditions.checkState(!memoryChunk.isClosed());
            MemoryChunkUtil.checkBounds(i2, memoryChunk.getSize(), i3, i4, getSize());
            this.mByteBuffer.position(i2);
            memoryChunk.getByteBuffer().position(i3);
            byte[] bArr = new byte[i4];
            this.mByteBuffer.get(bArr, 0, i4);
            memoryChunk.getByteBuffer().put(bArr, 0, i4);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    public synchronized void close() {
        if (!isClosed()) {
            SharedMemory.unmap(this.mByteBuffer);
            this.mSharedMemory.close();
            this.mByteBuffer = null;
            this.mSharedMemory = null;
        }
    }

    public void copy(int i2, MemoryChunk memoryChunk, int i3, int i4) {
        Preconditions.checkNotNull(memoryChunk);
        if (memoryChunk.getUniqueId() == getUniqueId()) {
            Log.w(TAG, "Copying from AshmemMemoryChunk " + Long.toHexString(getUniqueId()) + " to AshmemMemoryChunk " + Long.toHexString(memoryChunk.getUniqueId()) + " which are the same ");
            Preconditions.checkArgument(Boolean.FALSE);
        }
        if (memoryChunk.getUniqueId() < getUniqueId()) {
            synchronized (memoryChunk) {
                synchronized (this) {
                    doCopy(i2, memoryChunk, i3, i4);
                }
            }
            return;
        }
        synchronized (this) {
            synchronized (memoryChunk) {
                doCopy(i2, memoryChunk, i3, i4);
            }
        }
    }

    public ByteBuffer getByteBuffer() {
        return this.mByteBuffer;
    }

    public long getNativePtr() {
        throw new UnsupportedOperationException("Cannot get the pointer of an  AshmemMemoryChunk");
    }

    public int getSize() {
        Preconditions.checkState(!isClosed());
        return this.mSharedMemory.getSize();
    }

    public long getUniqueId() {
        return this.mId;
    }

    public synchronized boolean isClosed() {
        boolean z2;
        if (this.mByteBuffer == null || this.mSharedMemory == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        return z2;
    }

    public synchronized int read(int i2, byte[] bArr, int i3, int i4) {
        int adjustByteCount;
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(!isClosed());
        adjustByteCount = MemoryChunkUtil.adjustByteCount(i2, i4, getSize());
        MemoryChunkUtil.checkBounds(i2, bArr.length, i3, adjustByteCount, getSize());
        this.mByteBuffer.position(i2);
        this.mByteBuffer.get(bArr, i3, adjustByteCount);
        return adjustByteCount;
    }

    public synchronized int write(int i2, byte[] bArr, int i3, int i4) {
        boolean z2;
        int adjustByteCount;
        Preconditions.checkNotNull(bArr);
        if (!isClosed()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        adjustByteCount = MemoryChunkUtil.adjustByteCount(i2, i4, getSize());
        MemoryChunkUtil.checkBounds(i2, bArr.length, i3, adjustByteCount, getSize());
        this.mByteBuffer.position(i2);
        this.mByteBuffer.put(bArr, i3, adjustByteCount);
        return adjustByteCount;
    }

    public AshmemMemoryChunk() {
        this.mSharedMemory = null;
        this.mByteBuffer = null;
        this.mId = (long) System.identityHashCode(this);
    }

    public synchronized byte read(int i2) {
        boolean z2 = true;
        Preconditions.checkState(!isClosed());
        Preconditions.checkArgument(Boolean.valueOf(i2 >= 0));
        if (i2 >= getSize()) {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        return this.mByteBuffer.get(i2);
    }
}
