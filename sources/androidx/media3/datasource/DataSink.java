package androidx.media3.datasource;

import java.io.IOException;

public interface DataSink {

    public interface Factory {
        DataSink a();
    }

    void close() throws IOException;

    void i(DataSpec dataSpec) throws IOException;

    void write(byte[] bArr, int i2, int i3) throws IOException;
}
