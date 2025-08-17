package com.facebook.imagepipeline.memory;

import android.util.Log;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.soloader.nativeloader.NativeLoader;
import java.io.Closeable;
import java.nio.ByteBuffer;

@Nullsafe(Nullsafe.Mode.STRICT)
@DoNotStrip
public class NativeMemoryChunk implements MemoryChunk, Closeable {
    private static final String TAG = "NativeMemoryChunk";
    private boolean mIsClosed;
    private final long mNativePtr;
    private final int mSize;

    static {
        NativeLoader.loadLibrary(ImagePipelineNativeLoader.DSO_NAME);
    }

    public NativeMemoryChunk(int i2) {
        Preconditions.checkArgument(Boolean.valueOf(i2 > 0));
        this.mSize = i2;
        this.mNativePtr = nativeAllocate(i2);
        this.mIsClosed = false;
    }

    private void doCopy(int i2, MemoryChunk memoryChunk, int i3, int i4) {
        if (memoryChunk instanceof NativeMemoryChunk) {
            Preconditions.checkState(!isClosed());
            Preconditions.checkState(!memoryChunk.isClosed());
            MemoryChunkUtil.checkBounds(i2, memoryChunk.getSize(), i3, i4, this.mSize);
            nativeMemcpy(memoryChunk.getNativePtr() + ((long) i3), this.mNativePtr + ((long) i2), i4);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @DoNotStrip
    private static native long nativeAllocate(int i2);

    @DoNotStrip
    private static native void nativeCopyFromByteArray(long j2, byte[] bArr, int i2, int i3);

    @DoNotStrip
    private static native void nativeCopyToByteArray(long j2, byte[] bArr, int i2, int i3);

    @DoNotStrip
    private static native void nativeFree(long j2);

    @DoNotStrip
    private static native void nativeMemcpy(long j2, long j3, int i2);

    @DoNotStrip
    private static native byte nativeReadByte(long j2);

    public synchronized void close() {
        if (!this.mIsClosed) {
            this.mIsClosed = true;
            nativeFree(this.mNativePtr);
        }
    }

    public void copy(int i2, MemoryChunk memoryChunk, int i3, int i4) {
        Preconditions.checkNotNull(memoryChunk);
        if (memoryChunk.getUniqueId() == getUniqueId()) {
            Log.w(TAG, "Copying from NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(this)) + " to NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(memoryChunk)) + " which share the same address " + Long.toHexString(this.mNativePtr));
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

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        if (!isClosed()) {
            Log.w(TAG, "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. ");
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    public ByteBuffer getByteBuffer() {
        return null;
    }

    public long getNativePtr() {
        return this.mNativePtr;
    }

    public int getSize() {
        return this.mSize;
    }

    public long getUniqueId() {
        return this.mNativePtr;
    }

    public synchronized boolean isClosed() {
        return this.mIsClosed;
    }

    public synchronized int read(int i2, byte[] bArr, int i3, int i4) {
        int adjustByteCount;
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(!isClosed());
        adjustByteCount = MemoryChunkUtil.adjustByteCount(i2, i4, this.mSize);
        MemoryChunkUtil.checkBounds(i2, bArr.length, i3, adjustByteCount, this.mSize);
        nativeCopyToByteArray(this.mNativePtr + ((long) i2), bArr, i3, adjustByteCount);
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
        adjustByteCount = MemoryChunkUtil.adjustByteCount(i2, i4, this.mSize);
        MemoryChunkUtil.checkBounds(i2, bArr.length, i3, adjustByteCount, this.mSize);
        nativeCopyFromByteArray(this.mNativePtr + ((long) i2), bArr, i3, adjustByteCount);
        return adjustByteCount;
    }

    public NativeMemoryChunk() {
        this.mSize = 0;
        this.mNativePtr = 0;
        this.mIsClosed = true;
    }

    public synchronized byte read(int i2) {
        boolean z2 = true;
        Preconditions.checkState(!isClosed());
        Preconditions.checkArgument(Boolean.valueOf(i2 >= 0));
        if (i2 >= this.mSize) {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        return nativeReadByte(this.mNativePtr + ((long) i2));
    }
}
