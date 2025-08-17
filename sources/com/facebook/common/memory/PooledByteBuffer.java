package com.facebook.common.memory;

import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;
import java.nio.ByteBuffer;

@Nullsafe(Nullsafe.Mode.LOCAL)
public interface PooledByteBuffer extends Closeable {

    public static class ClosedException extends RuntimeException {
        public ClosedException() {
            super("Invalid bytebuf. Already closed");
        }
    }

    void close();

    ByteBuffer getByteBuffer();

    long getNativePtr();

    boolean isClosed();

    byte read(int i2);

    int read(int i2, byte[] bArr, int i3, int i4);

    int size();
}
