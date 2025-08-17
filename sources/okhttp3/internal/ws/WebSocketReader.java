package okhttp3.internal.ws;

import com.facebook.imageutils.JfifUtil;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

public final class WebSocketReader implements Closeable {
    private boolean closed;
    private final Buffer controlFrameBuffer = new Buffer();
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageFrameBuffer = new Buffer();
    private MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;
    private final BufferedSource source;

    public interface FrameCallback {
        void onReadClose(int i2, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    public WebSocketReader(boolean z2, BufferedSource bufferedSource, FrameCallback frameCallback2, boolean z3, boolean z4) {
        byte[] bArr;
        Intrinsics.f(bufferedSource, "source");
        Intrinsics.f(frameCallback2, "frameCallback");
        this.isClient = z2;
        this.source = bufferedSource;
        this.frameCallback = frameCallback2;
        this.perMessageDeflate = z3;
        this.noContextTakeover = z4;
        Buffer.UnsafeCursor unsafeCursor = null;
        if (z2) {
            bArr = null;
        } else {
            bArr = new byte[4];
        }
        this.maskKey = bArr;
        this.maskCursor = !z2 ? new Buffer.UnsafeCursor() : unsafeCursor;
    }

    private final void readControlFrame() throws IOException {
        String str;
        short s2;
        long j2 = this.frameLength;
        if (j2 > 0) {
            this.source.p(this.controlFrameBuffer, j2);
            if (!this.isClient) {
                Buffer buffer = this.controlFrameBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                Intrinsics.c(unsafeCursor);
                buffer.j0(unsafeCursor);
                this.maskCursor.k(0);
                WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                Buffer.UnsafeCursor unsafeCursor2 = this.maskCursor;
                byte[] bArr = this.maskKey;
                Intrinsics.c(bArr);
                webSocketProtocol.toggleMask(unsafeCursor2, bArr);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                long size = this.controlFrameBuffer.size();
                if (size != 1) {
                    if (size != 0) {
                        s2 = this.controlFrameBuffer.readShort();
                        str = this.controlFrameBuffer.f0();
                        String closeCodeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(s2);
                        if (closeCodeExceptionMessage != null) {
                            throw new ProtocolException(closeCodeExceptionMessage);
                        }
                    } else {
                        s2 = 1005;
                        str = "";
                    }
                    this.frameCallback.onReadClose(s2, str);
                    this.closed = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.c0());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.c0());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Util.toHexString(this.opcode));
        }
    }

    /* JADX INFO: finally extract failed */
    private final void readHeader() throws IOException, ProtocolException {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String str;
        boolean z7;
        if (!this.closed) {
            long timeoutNanos = this.source.timeout().timeoutNanos();
            this.source.timeout().clearTimeout();
            try {
                int and = Util.and(this.source.readByte(), (int) JfifUtil.MARKER_FIRST_BYTE);
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                int i2 = and & 15;
                this.opcode = i2;
                boolean z8 = false;
                if ((and & 128) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.isFinalFrame = z2;
                if ((and & 8) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.isControlFrame = z3;
                if (!z3 || z2) {
                    if ((and & 64) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (i2 == 1 || i2 == 2) {
                        if (!z4) {
                            z7 = false;
                        } else if (this.perMessageDeflate) {
                            z7 = true;
                        } else {
                            throw new ProtocolException("Unexpected rsv1 flag");
                        }
                        this.readingCompressedMessage = z7;
                    } else if (z4) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    if ((and & 32) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (!z5) {
                        if ((and & 16) != 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (!z6) {
                            int and2 = Util.and(this.source.readByte(), (int) JfifUtil.MARKER_FIRST_BYTE);
                            if ((and2 & 128) != 0) {
                                z8 = true;
                            }
                            if (z8 == this.isClient) {
                                if (this.isClient) {
                                    str = "Server-sent frames must not be masked.";
                                } else {
                                    str = "Client-sent frames must be masked.";
                                }
                                throw new ProtocolException(str);
                            }
                            long j2 = (long) (and2 & 127);
                            this.frameLength = j2;
                            if (j2 == 126) {
                                this.frameLength = (long) Util.and(this.source.readShort(), 65535);
                            } else if (j2 == 127) {
                                long readLong = this.source.readLong();
                                this.frameLength = readLong;
                                if (readLong < 0) {
                                    throw new ProtocolException("Frame length 0x" + Util.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                                }
                            }
                            if (this.isControlFrame && this.frameLength > 125) {
                                throw new ProtocolException("Control frame must be less than 125B.");
                            } else if (z8) {
                                BufferedSource bufferedSource = this.source;
                                byte[] bArr = this.maskKey;
                                Intrinsics.c(bArr);
                                bufferedSource.readFully(bArr);
                            }
                        } else {
                            throw new ProtocolException("Unexpected rsv3 flag");
                        }
                    } else {
                        throw new ProtocolException("Unexpected rsv2 flag");
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    private final void readMessage() throws IOException {
        while (!this.closed) {
            long j2 = this.frameLength;
            if (j2 > 0) {
                this.source.p(this.messageFrameBuffer, j2);
                if (!this.isClient) {
                    Buffer buffer = this.messageFrameBuffer;
                    Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                    Intrinsics.c(unsafeCursor);
                    buffer.j0(unsafeCursor);
                    this.maskCursor.k(this.messageFrameBuffer.size() - this.frameLength);
                    WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                    Buffer.UnsafeCursor unsafeCursor2 = this.maskCursor;
                    byte[] bArr = this.maskKey;
                    Intrinsics.c(bArr);
                    webSocketProtocol.toggleMask(unsafeCursor2, bArr);
                    this.maskCursor.close();
                }
            }
            if (!this.isFinalFrame) {
                readUntilNonControlFrame();
                if (this.opcode != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + Util.toHexString(this.opcode));
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }

    private final void readMessageFrame() throws IOException {
        int i2 = this.opcode;
        if (i2 == 1 || i2 == 2) {
            readMessage();
            if (this.readingCompressedMessage) {
                MessageInflater messageInflater2 = this.messageInflater;
                if (messageInflater2 == null) {
                    messageInflater2 = new MessageInflater(this.noContextTakeover);
                    this.messageInflater = messageInflater2;
                }
                messageInflater2.inflate(this.messageFrameBuffer);
            }
            if (i2 == 1) {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.f0());
            } else {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.c0());
            }
        } else {
            throw new ProtocolException("Unknown opcode: " + Util.toHexString(i2));
        }
    }

    private final void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                return;
            }
        }
    }

    public void close() throws IOException {
        MessageInflater messageInflater2 = this.messageInflater;
        if (messageInflater2 != null) {
            messageInflater2.close();
        }
    }

    public final BufferedSource getSource() {
        return this.source;
    }

    public final void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
