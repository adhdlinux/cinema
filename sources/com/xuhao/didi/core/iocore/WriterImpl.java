package com.xuhao.didi.core.iocore;

import com.xuhao.didi.core.exceptions.WriteException;
import com.xuhao.didi.core.iocore.interfaces.IIOCoreOptions;
import com.xuhao.didi.core.iocore.interfaces.IOAction;
import com.xuhao.didi.core.iocore.interfaces.IPulseSendable;
import com.xuhao.didi.core.iocore.interfaces.ISendable;
import com.xuhao.didi.core.iocore.interfaces.IStateSender;
import com.xuhao.didi.core.iocore.interfaces.IWriter;
import com.xuhao.didi.core.utils.BytesUtils;
import com.xuhao.didi.core.utils.SLog;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

public class WriterImpl implements IWriter<IIOCoreOptions> {
    private volatile IIOCoreOptions mOkOptions;
    private OutputStream mOutputStream;
    private LinkedBlockingQueue<ISendable> mQueue = new LinkedBlockingQueue<>();
    private IStateSender mStateSender;

    public void close() {
        OutputStream outputStream = this.mOutputStream;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public void initialize(OutputStream outputStream, IStateSender iStateSender) {
        this.mStateSender = iStateSender;
        this.mOutputStream = outputStream;
    }

    public void offer(ISendable iSendable) {
        this.mQueue.offer(iSendable);
    }

    public void setOption(IIOCoreOptions iIOCoreOptions) {
        this.mOkOptions = iIOCoreOptions;
    }

    public boolean write() throws RuntimeException {
        ISendable iSendable;
        try {
            iSendable = this.mQueue.take();
        } catch (InterruptedException unused) {
            iSendable = null;
        }
        int i2 = 0;
        if (iSendable == null) {
            return false;
        }
        try {
            byte[] parse = iSendable.parse();
            int writePackageBytes = this.mOkOptions.getWritePackageBytes();
            int length = parse.length;
            ByteBuffer allocate = ByteBuffer.allocate(writePackageBytes);
            allocate.order(this.mOkOptions.getWriteByteOrder());
            while (length > 0) {
                int min = Math.min(writePackageBytes, length);
                allocate.clear();
                allocate.rewind();
                allocate.put(parse, i2, min);
                allocate.flip();
                byte[] bArr = new byte[min];
                allocate.get(bArr);
                this.mOutputStream.write(bArr);
                this.mOutputStream.flush();
                if (SLog.isDebug()) {
                    byte[] copyOfRange = Arrays.copyOfRange(parse, i2, i2 + min);
                    SLog.i("write bytes: " + BytesUtils.toHexStringForLog(copyOfRange));
                    SLog.i("bytes write length:" + min);
                }
                i2 += min;
                length -= min;
            }
            if (iSendable instanceof IPulseSendable) {
                this.mStateSender.sendBroadcast(IOAction.ACTION_PULSE_REQUEST, iSendable);
                return true;
            }
            this.mStateSender.sendBroadcast(IOAction.ACTION_WRITE_COMPLETE, iSendable);
            return true;
        } catch (Exception e2) {
            throw new WriteException((Throwable) e2);
        }
    }
}
