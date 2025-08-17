package com.facebook.imagepipeline.memory;

import com.facebook.infer.annotation.Nullsafe;
import java.nio.ByteBuffer;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface MemoryChunk {
    void close();

    void copy(int i2, MemoryChunk memoryChunk, int i3, int i4);

    ByteBuffer getByteBuffer();

    long getNativePtr() throws UnsupportedOperationException;

    int getSize();

    long getUniqueId();

    boolean isClosed();

    byte read(int i2);

    int read(int i2, byte[] bArr, int i3, int i4);

    int write(int i2, byte[] bArr, int i3, int i4);
}
