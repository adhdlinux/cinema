package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageBuffer = new Buffer();
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final BufferedSink sink;
    private final Buffer sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z2, BufferedSink bufferedSink, Random random2, boolean z3, boolean z4, long j2) {
        byte[] bArr;
        Intrinsics.f(bufferedSink, "sink");
        Intrinsics.f(random2, "random");
        this.isClient = z2;
        this.sink = bufferedSink;
        this.random = random2;
        this.perMessageDeflate = z3;
        this.noContextTakeover = z4;
        this.minimumDeflateSize = j2;
        this.sinkBuffer = bufferedSink.c();
        Buffer.UnsafeCursor unsafeCursor = null;
        if (z2) {
            bArr = new byte[4];
        } else {
            bArr = null;
        }
        this.maskKey = bArr;
        this.maskCursor = z2 ? new Buffer.UnsafeCursor() : unsafeCursor;
    }

    private final void writeControlFrame(int i2, ByteString byteString) throws IOException {
        boolean z2;
        if (!this.writerClosed) {
            int size = byteString.size();
            if (((long) size) <= 125) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.sinkBuffer.writeByte(i2 | 128);
                if (this.isClient) {
                    this.sinkBuffer.writeByte(size | 128);
                    Random random2 = this.random;
                    byte[] bArr = this.maskKey;
                    Intrinsics.c(bArr);
                    random2.nextBytes(bArr);
                    this.sinkBuffer.write(this.maskKey);
                    if (size > 0) {
                        long size2 = this.sinkBuffer.size();
                        this.sinkBuffer.h0(byteString);
                        Buffer buffer = this.sinkBuffer;
                        Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                        Intrinsics.c(unsafeCursor);
                        buffer.j0(unsafeCursor);
                        this.maskCursor.k(size2);
                        WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.writeByte(size);
                    this.sinkBuffer.h0(byteString);
                }
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        throw new IOException("closed");
    }

    public void close() {
        MessageDeflater messageDeflater2 = this.messageDeflater;
        if (messageDeflater2 != null) {
            messageDeflater2.close();
        }
    }

    public final Random getRandom() {
        return this.random;
    }

    public final BufferedSink getSink() {
        return this.sink;
    }

    public final void writeClose(int i2, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.f41332f;
        if (!(i2 == 0 && byteString == null)) {
            if (i2 != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i2);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i2);
            if (byteString != null) {
                buffer.h0(byteString);
            }
            byteString2 = buffer.c0();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i2, ByteString byteString) throws IOException {
        Intrinsics.f(byteString, "data");
        if (!this.writerClosed) {
            this.messageBuffer.h0(byteString);
            int i3 = 128;
            int i4 = i2 | 128;
            if (this.perMessageDeflate && ((long) byteString.size()) >= this.minimumDeflateSize) {
                MessageDeflater messageDeflater2 = this.messageDeflater;
                if (messageDeflater2 == null) {
                    messageDeflater2 = new MessageDeflater(this.noContextTakeover);
                    this.messageDeflater = messageDeflater2;
                }
                messageDeflater2.deflate(this.messageBuffer);
                i4 |= 64;
            }
            long size = this.messageBuffer.size();
            this.sinkBuffer.writeByte(i4);
            if (!this.isClient) {
                i3 = 0;
            }
            if (size <= 125) {
                this.sinkBuffer.writeByte(((int) size) | i3);
            } else if (size <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                this.sinkBuffer.writeByte(i3 | 126);
                this.sinkBuffer.writeShort((int) size);
            } else {
                this.sinkBuffer.writeByte(i3 | 127);
                this.sinkBuffer.G0(size);
            }
            if (this.isClient) {
                Random random2 = this.random;
                byte[] bArr = this.maskKey;
                Intrinsics.c(bArr);
                random2.nextBytes(bArr);
                this.sinkBuffer.write(this.maskKey);
                if (size > 0) {
                    Buffer buffer = this.messageBuffer;
                    Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                    Intrinsics.c(unsafeCursor);
                    buffer.j0(unsafeCursor);
                    this.maskCursor.k(0);
                    WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            this.sinkBuffer.write(this.messageBuffer, size);
            this.sink.h();
            return;
        }
        throw new IOException("closed");
    }

    public final void writePing(ByteString byteString) throws IOException {
        Intrinsics.f(byteString, "payload");
        writeControlFrame(9, byteString);
    }

    public final void writePong(ByteString byteString) throws IOException {
        Intrinsics.f(byteString, "payload");
        writeControlFrame(10, byteString);
    }
}
