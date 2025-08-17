package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

final class NioByteString extends ByteString.LeafByteString {
    /* access modifiers changed from: private */
    public final ByteBuffer buffer;

    NioByteString(ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private ByteBuffer slice(int i2, int i3) {
        if (i2 < this.buffer.position() || i3 > this.buffer.limit() || i2 > i3) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
        }
        ByteBuffer slice = this.buffer.slice();
        slice.position(i2 - this.buffer.position());
        slice.limit(i3 - this.buffer.position());
        return slice;
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    public byte byteAt(int i2) {
        try {
            return this.buffer.get(i2);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new ArrayIndexOutOfBoundsException(e3.getMessage());
        }
    }

    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.buffer.slice());
    }

    /* access modifiers changed from: protected */
    public void copyToInternal(byte[] bArr, int i2, int i3, int i4) {
        ByteBuffer slice = this.buffer.slice();
        slice.position(i2);
        slice.get(bArr, i3, i4);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof NioByteString) {
            return this.buffer.equals(((NioByteString) obj).buffer);
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        return this.buffer.equals(byteString.asReadOnlyByteBuffer());
    }

    /* access modifiers changed from: package-private */
    public boolean equalsRange(ByteString byteString, int i2, int i3) {
        return substring(0, i3).equals(byteString.substring(i2, i3 + i2));
    }

    public byte internalByteAt(int i2) {
        return byteAt(i2);
    }

    public boolean isValidUtf8() {
        return Utf8.isValidUtf8(this.buffer);
    }

    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this.buffer, true);
    }

    public InputStream newInput() {
        return new InputStream() {
            private final ByteBuffer buf;

            {
                this.buf = NioByteString.this.buffer.slice();
            }

            public int available() throws IOException {
                return this.buf.remaining();
            }

            public void mark(int i2) {
                ByteBuffer byteBuffer = (ByteBuffer) this.buf.mark();
            }

            public boolean markSupported() {
                return true;
            }

            public int read() throws IOException {
                if (!this.buf.hasRemaining()) {
                    return -1;
                }
                return this.buf.get() & 255;
            }

            public void reset() throws IOException {
                try {
                    ByteBuffer byteBuffer = (ByteBuffer) this.buf.reset();
                } catch (InvalidMarkException e2) {
                    throw new IOException(e2);
                }
            }

            public int read(byte[] bArr, int i2, int i3) throws IOException {
                if (!this.buf.hasRemaining()) {
                    return -1;
                }
                int min = Math.min(i3, this.buf.remaining());
                this.buf.get(bArr, i2, min);
                return min;
            }
        };
    }

    /* access modifiers changed from: protected */
    public int partialHash(int i2, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + this.buffer.get(i5);
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public int partialIsValidUtf8(int i2, int i3, int i4) {
        return Utf8.partialIsValidUtf8(i2, this.buffer, i3, i4 + i3);
    }

    public int size() {
        return this.buffer.remaining();
    }

    public ByteString substring(int i2, int i3) {
        try {
            return new NioByteString(slice(i2, i3));
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new ArrayIndexOutOfBoundsException(e3.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public String toStringInternal(Charset charset) {
        int i2;
        int i3;
        byte[] bArr;
        if (this.buffer.hasArray()) {
            bArr = this.buffer.array();
            i3 = this.buffer.arrayOffset() + this.buffer.position();
            i2 = this.buffer.remaining();
        } else {
            bArr = toByteArray();
            i2 = bArr.length;
            i3 = 0;
        }
        return new String(bArr, i3, i2, charset);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    /* access modifiers changed from: package-private */
    public void writeToInternal(OutputStream outputStream, int i2, int i3) throws IOException {
        if (this.buffer.hasArray()) {
            outputStream.write(this.buffer.array(), this.buffer.arrayOffset() + this.buffer.position() + i2, i3);
            return;
        }
        ByteBufferWriter.write(slice(i2, i3 + i2), outputStream);
    }

    /* access modifiers changed from: package-private */
    public void writeTo(ByteOutput byteOutput) throws IOException {
        byteOutput.writeLazy(this.buffer.slice());
    }
}
