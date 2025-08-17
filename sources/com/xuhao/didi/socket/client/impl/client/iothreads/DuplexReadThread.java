package com.xuhao.didi.socket.client.impl.client.iothreads;

import com.xuhao.didi.core.iocore.interfaces.IReader;
import com.xuhao.didi.core.iocore.interfaces.IStateSender;
import com.xuhao.didi.core.utils.SLog;
import com.xuhao.didi.socket.client.impl.exceptions.ManuallyDisconnectException;
import com.xuhao.didi.socket.common.interfaces.basic.AbsLoopThread;
import java.io.IOException;

public class DuplexReadThread extends AbsLoopThread {
    private IReader mReader;
    private IStateSender mStateSender;

    public DuplexReadThread(IReader iReader, IStateSender iStateSender) {
        super("client_duplex_read_thread");
        this.mStateSender = iStateSender;
        this.mReader = iReader;
    }

    /* access modifiers changed from: protected */
    public void beforeLoop() {
        this.mStateSender.sendBroadcast("action_read_thread_start");
    }

    /* access modifiers changed from: protected */
    public void loopFinish(Exception exc) {
        if (exc instanceof ManuallyDisconnectException) {
            exc = null;
        }
        if (exc != null) {
            SLog.e("duplex read error,thread is dead with exception:" + exc.getMessage());
        }
        this.mStateSender.sendBroadcast("action_read_thread_shutdown", exc);
    }

    /* access modifiers changed from: protected */
    public void runInLoopThread() throws IOException {
        this.mReader.read();
    }

    public synchronized void shutdown(Exception exc) {
        this.mReader.close();
        super.shutdown(exc);
    }
}
