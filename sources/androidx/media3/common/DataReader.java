package androidx.media3.common;

import java.io.IOException;

public interface DataReader {
    int read(byte[] bArr, int i2, int i3) throws IOException;
}
