package com.facebook.common.streams;

import com.facebook.infer.annotation.Nullsafe;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Nullsafe(Nullsafe.Mode.STRICT)
public class TailAppendingInputStream extends FilterInputStream {
    private int mMarkedTailOffset;
    private final byte[] mTail;
    private int mTailOffset;

    public TailAppendingInputStream(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        inputStream.getClass();
        bArr.getClass();
        this.mTail = bArr;
    }

    private int readNextTailByte() {
        int i2 = this.mTailOffset;
        byte[] bArr = this.mTail;
        if (i2 >= bArr.length) {
            return -1;
        }
        this.mTailOffset = i2 + 1;
        return bArr[i2] & 255;
    }

    public void mark(int i2) {
        if (this.in.markSupported()) {
            super.mark(i2);
            this.mMarkedTailOffset = this.mTailOffset;
        }
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (read != -1) {
            return read;
        }
        return readNextTailByte();
    }

    public void reset() throws IOException {
        if (this.in.markSupported()) {
            this.in.reset();
            this.mTailOffset = this.mMarkedTailOffset;
            return;
        }
        throw new IOException("mark is not supported");
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = this.in.read(bArr, i2, i3);
        if (read != -1) {
            return read;
        }
        int i4 = 0;
        if (i3 == 0) {
            return 0;
        }
        while (i4 < i3) {
            int readNextTailByte = readNextTailByte();
            if (readNextTailByte == -1) {
                break;
            }
            bArr[i2 + i4] = (byte) readNextTailByte;
            i4++;
        }
        if (i4 > 0) {
            return i4;
        }
        return -1;
    }
}
