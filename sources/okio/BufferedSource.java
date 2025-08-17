package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

public interface BufferedSource extends Source, ReadableByteChannel {
    String F() throws IOException;

    byte[] G(long j2) throws IOException;

    void N(long j2) throws IOException;

    ByteString Q(long j2) throws IOException;

    byte[] U() throws IOException;

    boolean V() throws IOException;

    long W() throws IOException;

    String a0(Charset charset) throws IOException;

    Buffer c();

    ByteString c0() throws IOException;

    InputStream d();

    String f0() throws IOException;

    long i0(Sink sink) throws IOException;

    long l0() throws IOException;

    int n0(Options options) throws IOException;

    void p(Buffer buffer, long j2) throws IOException;

    BufferedSource peek();

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    boolean request(long j2) throws IOException;

    void skip(long j2) throws IOException;

    String t(long j2) throws IOException;

    boolean x(long j2, ByteString byteString) throws IOException;
}
