package com.facebook.react.modules.network;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CountingOutputStream extends FilterOutputStream {
    private long mCount = 0;

    public CountingOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void close() throws IOException {
        this.out.close();
    }

    public long getCount() {
        return this.mCount;
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.out.write(bArr, i2, i3);
        this.mCount += (long) i3;
    }

    public void write(int i2) throws IOException {
        this.out.write(i2);
        this.mCount++;
    }
}
