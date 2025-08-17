package com.facebook.common.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.io.InputStream;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class PooledByteBufferInputStream extends InputStream {
    int mMark = 0;
    int mOffset = 0;
    final PooledByteBuffer mPooledByteBuffer;

    public PooledByteBufferInputStream(PooledByteBuffer pooledByteBuffer) {
        Preconditions.checkArgument(Boolean.valueOf(!pooledByteBuffer.isClosed()));
        this.mPooledByteBuffer = (PooledByteBuffer) Preconditions.checkNotNull(pooledByteBuffer);
    }

    public int available() {
        return this.mPooledByteBuffer.size() - this.mOffset;
    }

    public void mark(int i2) {
        this.mMark = this.mOffset;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        if (available() <= 0) {
            return -1;
        }
        PooledByteBuffer pooledByteBuffer = this.mPooledByteBuffer;
        int i2 = this.mOffset;
        this.mOffset = i2 + 1;
        return pooledByteBuffer.read(i2) & 255;
    }

    public void reset() {
        this.mOffset = this.mMark;
    }

    public long skip(long j2) {
        boolean z2;
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        int min = Math.min((int) j2, available());
        this.mOffset += min;
        return (long) min;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) {
        if (i2 < 0 || i3 < 0 || i2 + i3 > bArr.length) {
            throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i2 + "; regionLength=" + i3);
        }
        int available = available();
        if (available <= 0) {
            return -1;
        }
        if (i3 <= 0) {
            return 0;
        }
        int min = Math.min(available, i3);
        this.mPooledByteBuffer.read(this.mOffset, bArr, i2, min);
        this.mOffset += min;
        return min;
    }
}
