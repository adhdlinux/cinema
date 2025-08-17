package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

class IterableByteBufferInputStream extends InputStream {
    private long currentAddress;
    private byte[] currentArray;
    private int currentArrayOffset;
    private ByteBuffer currentByteBuffer;
    private int currentByteBufferPos;
    private int currentIndex;
    private int dataSize = 0;
    private boolean hasArray;
    private Iterator<ByteBuffer> iterator;

    IterableByteBufferInputStream(Iterable<ByteBuffer> iterable) {
        this.iterator = iterable.iterator();
        for (ByteBuffer next : iterable) {
            this.dataSize++;
        }
        this.currentIndex = -1;
        if (!getNextByteBuffer()) {
            this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
            this.currentIndex = 0;
            this.currentByteBufferPos = 0;
            this.currentAddress = 0;
        }
    }

    private boolean getNextByteBuffer() {
        this.currentIndex++;
        if (!this.iterator.hasNext()) {
            return false;
        }
        ByteBuffer next = this.iterator.next();
        this.currentByteBuffer = next;
        this.currentByteBufferPos = next.position();
        if (this.currentByteBuffer.hasArray()) {
            this.hasArray = true;
            this.currentArray = this.currentByteBuffer.array();
            this.currentArrayOffset = this.currentByteBuffer.arrayOffset();
        } else {
            this.hasArray = false;
            this.currentAddress = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentArray = null;
        }
        return true;
    }

    private void updateCurrentByteBufferPos(int i2) {
        int i3 = this.currentByteBufferPos + i2;
        this.currentByteBufferPos = i3;
        if (i3 == this.currentByteBuffer.limit()) {
            getNextByteBuffer();
        }
    }

    public int read() throws IOException {
        if (this.currentIndex == this.dataSize) {
            return -1;
        }
        if (this.hasArray) {
            byte b2 = this.currentArray[this.currentByteBufferPos + this.currentArrayOffset] & 255;
            updateCurrentByteBufferPos(1);
            return b2;
        }
        byte b3 = UnsafeUtil.getByte(((long) this.currentByteBufferPos) + this.currentAddress) & 255;
        updateCurrentByteBufferPos(1);
        return b3;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.currentIndex == this.dataSize) {
            return -1;
        }
        int limit = this.currentByteBuffer.limit();
        int i4 = this.currentByteBufferPos;
        int i5 = limit - i4;
        if (i3 > i5) {
            i3 = i5;
        }
        if (this.hasArray) {
            System.arraycopy(this.currentArray, i4 + this.currentArrayOffset, bArr, i2, i3);
            updateCurrentByteBufferPos(i3);
        } else {
            int position = this.currentByteBuffer.position();
            ByteBuffer byteBuffer = (ByteBuffer) this.currentByteBuffer.position(this.currentByteBufferPos);
            this.currentByteBuffer.get(bArr, i2, i3);
            ByteBuffer byteBuffer2 = (ByteBuffer) this.currentByteBuffer.position(position);
            updateCurrentByteBufferPos(i3);
        }
        return i3;
    }
}
