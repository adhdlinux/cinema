package com.facebook.common.memory;

import com.facebook.common.internal.Throwables;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.OutputStream;

@Nullsafe(Nullsafe.Mode.LOCAL)
public abstract class PooledByteBufferOutputStream extends OutputStream {
    public void close() {
        try {
            super.close();
        } catch (IOException e2) {
            Throwables.propagate(e2);
        }
    }

    public abstract int size();

    public abstract PooledByteBuffer toByteBuffer();
}
