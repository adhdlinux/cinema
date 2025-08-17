package com.xuhao.didi.socket.server.impl.iocore;

import com.xuhao.didi.core.iocore.interfaces.IStateSender;
import com.xuhao.didi.core.iocore.interfaces.IWriter;
import com.xuhao.didi.core.utils.SLog;
import com.xuhao.didi.socket.common.interfaces.basic.AbsLoopThread;
import com.xuhao.didi.socket.server.exceptions.InitiativeDisconnectException;
import java.io.IOException;

public class ClientWriteThread extends AbsLoopThread {
    private IStateSender mClientStateSender;
    private IWriter mWriter;

    public ClientWriteThread(IWriter iWriter, IStateSender iStateSender) {
        super("server_client_write_thread");
        this.mClientStateSender = iStateSender;
        this.mWriter = iWriter;
    }

    /* access modifiers changed from: protected */
    public void beforeLoop() {
        this.mClientStateSender.sendBroadcast("action_write_thread_start");
    }

    /* access modifiers changed from: protected */
    public void loopFinish(Exception exc) {
        if (exc instanceof InitiativeDisconnectException) {
            exc = null;
        }
        if (exc != null) {
            SLog.e("duplex write error,thread is dead with exception:" + exc.getMessage());
        }
        this.mClientStateSender.sendBroadcast("action_write_thread_shutdown", exc);
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
