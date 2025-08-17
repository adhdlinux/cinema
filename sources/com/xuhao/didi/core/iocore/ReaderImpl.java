package com.xuhao.didi.core.iocore;

import com.xuhao.didi.core.exceptions.ReadException;
import com.xuhao.didi.core.iocore.interfaces.IOAction;
import com.xuhao.didi.core.pojo.OriginalData;
import com.xuhao.didi.core.protocol.IReaderProtocol;
import com.xuhao.didi.core.utils.BytesUtils;
import com.xuhao.didi.core.utils.SLog;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ReaderImpl extends AbsReader {
    private ByteBuffer mRemainingBuf;

    private void readBodyFromChannel(ByteBuffer byteBuffer) throws IOException {
        while (true) {
            if (!byteBuffer.hasRemaining()) {
                break;
            }
            try {
                byte[] bArr = new byte[this.mOkOptions.getReadPackageBytes()];
                int read = this.mInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                int remaining = byteBuffer.remaining();
                if (read > remaining) {
                    byteBuffer.put(bArr, 0, remaining);
                    int i2 = read - remaining;
                    ByteBuffer allocate = ByteBuffer.allocate(i2);
                    this.mRemainingBuf = allocate;
                    allocate.order(this.mOkOptions.getReadByteOrder());
                    this.mRemainingBuf.put(bArr, remaining, i2);
                } else {
                    byteBuffer.put(bArr, 0, read);
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (SLog.isDebug()) {
            SLog.i("read total bytes: " + BytesUtils.toHexStringForLog(byteBuffer.array()));
            SLog.i("read total length:" + (byteBuffer.capacity() - byteBuffer.remaining()));
        }
    }

    private void readHeaderFromChannel(ByteBuffer byteBuffer, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            byte[] bArr = new byte[1];
            int read = this.mInputStream.read(bArr);
            if (read != -1) {
                byteBuffer.put(bArr);
                i3++;
            } else {
                throw new ReadException("read head is wrong, this socket input stream is end of file read " + read + " ,that mean this socket is disconnected by server");
            }
        }
    }

    public void read() throws RuntimeException {
        OriginalData originalData = new OriginalData();
        IReaderProtocol readerProtocol = this.mOkOptions.getReaderProtocol();
        int headerLength = readerProtocol.getHeaderLength();
        ByteBuffer allocate = ByteBuffer.allocate(headerLength);
        allocate.order(this.mOkOptions.getReadByteOrder());
        try {
            ByteBuffer byteBuffer = this.mRemainingBuf;
            if (byteBuffer != null) {
                byteBuffer.flip();
                int min = Math.min(this.mRemainingBuf.remaining(), headerLength);
                allocate.put(this.mRemainingBuf.array(), 0, min);
                if (min < headerLength) {
                    this.mRemainingBuf = null;
                    readHeaderFromChannel(allocate, headerLength - min);
                } else {
                    this.mRemainingBuf.position(headerLength);
                }
            } else {
                readHeaderFromChannel(allocate, allocate.capacity());
            }
            originalData.setHeadBytes(allocate.array());
            if (SLog.isDebug()) {
                SLog.i("read head: " + BytesUtils.toHexStringForLog(allocate.array()));
            }
            int bodyLength = readerProtocol.getBodyLength(originalData.getHeadBytes(), this.mOkOptions.getReadByteOrder());
            if (SLog.isDebug()) {
                SLog.i("need read body length: " + bodyLength);
            }
            if (bodyLength > 0) {
                if (bodyLength <= this.mOkOptions.getMaxReadDataMB() * 1024 * 1024) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(bodyLength);
                    allocate2.order(this.mOkOptions.getReadByteOrder());
                    ByteBuffer byteBuffer2 = this.mRemainingBuf;
                    if (byteBuffer2 != null) {
                        int position = byteBuffer2.position();
                        int min2 = Math.min(this.mRemainingBuf.remaining(), bodyLength);
                        allocate2.put(this.mRemainingBuf.array(), position, min2);
                        this.mRemainingBuf.position(position + min2);
                        if (min2 == bodyLength) {
                            if (this.mRemainingBuf.remaining() > 0) {
                                ByteBuffer allocate3 = ByteBuffer.allocate(this.mRemainingBuf.remaining());
                                allocate3.order(this.mOkOptions.getReadByteOrder());
                                allocate3.put(this.mRemainingBuf.array(), this.mRemainingBuf.position(), this.mRemainingBuf.remaining());
                                this.mRemainingBuf = allocate3;
                            } else {
                                this.mRemainingBuf = null;
                            }
                            originalData.setBodyBytes(allocate2.array());
                            this.mStateSender.sendBroadcast(IOAction.ACTION_READ_COMPLETE, originalData);
                            return;
                        }
                        this.mRemainingBuf = null;
                    }
                    readBodyFromChannel(allocate2);
                    originalData.setBodyBytes(allocate2.array());
                } else {
                    throw new ReadException("Need to follow the transmission protocol.\r\nPlease check the client/server code.\r\nAccording to the packet header data in the transport protocol, the package length is " + bodyLength + " Bytes.\r\nYou need check your <ReaderProtocol> definition");
                }
            } else if (bodyLength == 0) {
                originalData.setBodyBytes(new byte[0]);
                ByteBuffer byteBuffer3 = this.mRemainingBuf;
                if (byteBuffer3 != null) {
                    if (byteBuffer3.hasRemaining()) {
                        ByteBuffer allocate4 = ByteBuffer.allocate(this.mRemainingBuf.remaining());
                        allocate4.order(this.mOkOptions.getReadByteOrder());
                        allocate4.put(this.mRemainingBuf.array(), this.mRemainingBuf.position(), this.mRemainingBuf.remaining());
                        this.mRemainingBuf = allocate4;
                    } else {
                        this.mRemainingBuf = null;
                    }
                }
            } else if (bodyLength < 0) {
                throw new ReadException("read body is wrong,this socket input stream is end of file read " + bodyLength + " ,that mean this socket is disconnected by server");
            }
            this.mStateSender.sendBroadcast(IOAction.ACTION_READ_COMPLETE, originalData);
        } catch (Exception e2) {
            throw new ReadException((Throwable) e2);
        }
    }
}
