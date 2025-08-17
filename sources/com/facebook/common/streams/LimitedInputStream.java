package com.facebook.common.streams;

import com.facebook.infer.annotation.Nullsafe;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Nullsafe(Nullsafe.Mode.STRICT)
public class LimitedInputStream extends FilterInputStream {
    private int mBytesToRead;
    private int mBytesToReadWhenMarked;

    public LimitedInputStream(InputStream inputStream, int i2) {
        super(inputStream);
        inputStream.getClass();
        if (i2 >= 0) {
            this.mBytesToRead = i2;
            this.mBytesToReadWhenMarked = -1;
            return;
        }
        throw new IllegalArgumentException("limit must be >= 0");
    }

    public int available() throws IOException {
        return Math.min(this.in.available(), this.mBytesToRead);
    }

    public void mark(int i2) {
        if (this.in.markSupported()) {
            this.in.mark(i2);
            this.mBytesToReadWhenMarked = this.mBytesToRead;
        }
    }

    public int read() throws IOException {
        if (this.mBytesToRead == 0) {
            return -1;
        }
        int read = this.in.read();
        if (read != -1) {
            this.mBytesToRead--;
        }
        return read;
    }

    public void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("mark is not supported");
        } else if (this.mBytesToReadWhenMarked != -1) {
            this.in.reset();
            this.mBytesToRead = this.mBytesToReadWhenMarked;
        } else {
            throw new IOException("mark not set");
        }
    }

    public long skip(long j2) throws IOException {
        long skip = this.in.skip(Math.min(j2, (long) this.mBytesToRead));
        this.mBytesToRead = (int) (((long) this.mBytesToRead) - skip);
        return skip;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.mBytesToRead;
        if (i4 == 0) {
            return -1;
        }
        int read = this.in.read(bArr, i2, Math.min(i3, i4));
        if (read > 0) {
            this.mBytesToRead -= read;
        }
        return read;
    }
}
