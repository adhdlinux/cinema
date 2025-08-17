package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

@Nullsafe(Nullsafe.Mode.STRICT)
public final class Closeables {
    static final Logger logger = Logger.getLogger(Closeables.class.getName());

    private Closeables() {
    }

    public static void close(Closeable closeable, boolean z2) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                if (z2) {
                    logger.log(Level.WARNING, "IOException thrown while closing Closeable.", e2);
                    return;
                }
                throw e2;
            }
        }
    }

    public static void closeQuietly(InputStream inputStream) {
        try {
            close(inputStream, true);
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public static void closeQuietly(Reader reader) {
        try {
            close(reader, true);
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
