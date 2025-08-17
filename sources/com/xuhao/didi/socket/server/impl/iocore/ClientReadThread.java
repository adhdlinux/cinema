package com.xuhao.didi.socket.server.impl.iocore;

import com.xuhao.didi.core.iocore.interfaces.IReader;
import com.xuhao.didi.core.iocore.interfaces.IStateSender;
import com.xuhao.didi.core.utils.SLog;
import com.xuhao.didi.socket.common.interfaces.basic.AbsLoopThread;
import com.xuhao.didi.socket.server.exceptions.InitiativeDisconnectException;
import java.io.IOException;

public class ClientReadThread extends AbsLoopThread {
    private IStateSender mClientStateSender;
    private IReader mReader;

    public ClientReadThread(IReader iReader, IStateSender iStateSender) {
        super("server_client_read_thread");
        this.mClientStateSender = iStateSender;
        this.mReader = iReader;
    }

    /* access modifiers changed from: protected */
    public void beforeLoop() {
        this.mClientStateSender.sendBroadcast("action_read_thread_start");
    }

    /* access modifiers changed from: protected */
    public void loopFinish(Exception exc) {
        if (exc instanceof InitiativeDisconnectException) {
            exc = null;
        }
        if (exc != null) {
            SLog.e("duplex read error,thread is dead with exception:" + exc.getMessage());
        }
        this.mClientStateSender.sendBroadcast("action_read_thread_shutdown", exc);
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
