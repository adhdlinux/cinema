package com.facebook.binaryresource;

import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.InputStream;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface BinaryResource {
    InputStream openStream() throws IOException;

    byte[] read() throws IOException;

    long size();
}
