package com.facebook.binaryresource;

import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ByteArrayBinaryResource implements BinaryResource {
    private final byte[] mBytes;

    public ByteArrayBinaryResource(byte[] bArr) {
        this.mBytes = (byte[]) Preconditions.checkNotNull(bArr);
    }

    public InputStream openStream() throws IOException {
        return new ByteArrayInputStream(this.mBytes);
    }

    public byte[] read() {
        return this.mBytes;
    }

    public long size() {
        return (long) this.mBytes.length;
    }
}
