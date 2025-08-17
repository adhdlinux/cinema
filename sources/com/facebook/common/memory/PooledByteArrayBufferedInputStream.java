package com.facebook.common.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.InputStream;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class PooledByteArrayBufferedInputStream extends InputStream {
    private static final String TAG = "PooledByteInputStream";
    private int mBufferOffset = 0;
    private int mBufferedSize = 0;
    private final byte[] mByteArray;
    private boolean mClosed = false;
    private final InputStream mInputStream;
    private final ResourceReleaser<byte[]> mResourceReleaser;

    /* JADX WARNING: type inference failed for: r3v0, types: [com.facebook.common.references.ResourceReleaser<byte[]>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PooledByteArrayBufferedInputStream(java.io.InputStream r1, byte[] r2, com.facebook.common.references.ResourceReleaser<byte[]> r3) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r1)
            java.io.InputStream r1 = (java.io.InputStream) r1
            r0.mInputStream = r1
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r2)
            byte[] r1 = (byte[]) r1
            r0.mByteArray = r1
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r3)
            com.facebook.common.references.ResourceReleaser r1 = (com.facebook.common.references.ResourceReleaser) r1
            r0.mResourceReleaser = r1
            r1 = 0
            r0.mBufferedSize = r1
            r0.mBufferOffset = r1
            r0.mClosed = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.memory.PooledByteArrayBufferedInputStream.<init>(java.io.InputStream, byte[], com.facebook.common.references.ResourceReleaser):void");
    }

    private boolean ensureDataInBuffer() throws IOException {
        if (this.mBufferOffset < this.mBufferedSize) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.mBufferedSize = read;
        this.mBufferOffset = 0;
        return true;
    }

    private void ensureNotClosed() throws IOException {
        if (this.mClosed) {
            throw new IOException("stream already closed");
        }
    }

    public int available() throws IOException {
        boolean z2;
        if (this.mBufferOffset <= this.mBufferedSize) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        ensureNotClosed();
        return (this.mBufferedSize - this.mBufferOffset) + this.mInputStream.available();
    }

    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.mResourceReleaser.release(this.mByteArray);
            super.close();
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        if (!this.mClosed) {
            FLog.e(TAG, "Finalized without closing");
            close();
        }
        super.finalize();
    }

    public int read() throws IOException {
        Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        if (!ensureDataInBuffer()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i2 = this.mBufferOffset;
        this.mBufferOffset = i2 + 1;
        return bArr[i2] & 255;
    }

    public long skip(long j2) throws IOException {
        boolean z2;
        if (this.mBufferOffset <= this.mBufferedSize) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        ensureNotClosed();
        int i2 = this.mBufferedSize;
        int i3 = this.mBufferOffset;
        long j3 = (long) (i2 - i3);
        if (j3 >= j2) {
            this.mBufferOffset = (int) (((long) i3) + j2);
            return j2;
        }
        this.mBufferOffset = i2;
        return j3 + this.mInputStream.skip(j2 - j3);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        if (!ensureDataInBuffer()) {
            return -1;
        }
        int min = Math.min(this.mBufferedSize - this.mBufferOffset, i3);
        System.arraycopy(this.mByteArray, this.mBufferOffset, bArr, i2, min);
        this.mBufferOffset += min;
        return min;
    }
}
