package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

public interface BufferedSink extends Sink, WritableByteChannel {
    BufferedSink O(long j2) throws IOException;

    BufferedSink b0(long j2) throws IOException;

    Buffer c();

    void flush() throws IOException;

    BufferedSink h() throws IOException;

    BufferedSink h0(ByteString byteString) throws IOException;

    OutputStream k0();

    BufferedSink r() throws IOException;

    BufferedSink w(String str) throws IOException;

    BufferedSink write(byte[] bArr) throws IOException;

    BufferedSink write(byte[] bArr, int i2, int i3) throws IOException;

    BufferedSink writeByte(int i2) throws IOException;

    BufferedSink writeInt(int i2) throws IOException;

    BufferedSink writeShort(int i2) throws IOException;

    long y(Source source) throws IOException;
}
