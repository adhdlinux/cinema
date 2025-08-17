package com.xuhao.didi.socket.client.impl.client.iothreads;

import com.xuhao.didi.core.iocore.interfaces.IStateSender;
import com.xuhao.didi.core.iocore.interfaces.IWriter;
import com.xuhao.didi.core.utils.SLog;
import com.xuhao.didi.socket.client.impl.exceptions.ManuallyDisconnectException;
import com.xuhao.didi.socket.common.interfaces.basic.AbsLoopThread;
import java.io.IOException;

public class DuplexWriteThread extends AbsLoopThread {
    private IStateSender mStateSender;
    private IWriter mWriter;

    public DuplexWriteThread(IWriter iWriter, IStateSender iStateSender) {
        super("client_duplex_write_thread");
        this.mStateSender = iStateSender;
        this.mWriter = iWriter;
    }

    /* access modifiers changed from: protected */
    public void beforeLoop() {
        this.mStateSender.sendBroadcast("action_write_thread_start");
    }

    /* access modifiers changed from: protected */
    public void loopFinish(Exception exc) {
        if (exc instanceof ManuallyDisconnectException) {
            exc = null;
        }
        if (exc != null) {
            SLog.e("duplex write error,thread is dead with exception:" + exc.getMessage());
        }
        this.mStateSender.sendBroadcast("action_write_thread_shutdown", exc);
    }

    /* access modifiers changed from: protected */
    public void runInLoopThread() throws IOException {
        this.mWriter.write();
    }

    public synchronized void shutdown(Exception exc) {
        this.mWriter.close();
        super.shutdown(exc);
    }
}
