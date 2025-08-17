package com.facebook.cache.common;

import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.OutputStream;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface WriterCallback {
    void write(OutputStream outputStream) throws IOException;
}
