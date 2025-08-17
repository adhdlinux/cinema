package com.xuhao.didi.socket.client.impl.client.iothreads;

import com.xuhao.didi.core.iocore.interfaces.IReader;
import com.xuhao.didi.core.iocore.interfaces.IStateSender;
import com.xuhao.didi.core.iocore.interfaces.IWriter;
import com.xuhao.didi.core.utils.SLog;
import com.xuhao.didi.socket.client.impl.exceptions.ManuallyDisconnectException;
import com.xuhao.didi.socket.common.interfaces.basic.AbsLoopThread;
import java.io.IOException;

public class SimplexIOThread extends AbsLoopThread {
    private boolean isWrite = false;
    private IReader mReader;
    private IStateSender mStateSender;
    private IWriter mWriter;

    public SimplexIOThread(IReader iReader, IWriter iWriter, IStateSender iStateSender) {
        super("client_simplex_io_thread");
        this.mStateSender = iStateSender;
        this.mReader = iReader;
        this.mWriter = iWriter;
    }

    /* access modifiers changed from: protected */
    public void beforeLoop() throws IOException {
        this.mStateSender.sendBroadcast("action_write_thread_start");
        this.mStateSender.sendBroadcast("action_read_thread_start");
    }

    /* access modifiers changed from: protected */
    public void loopFinish(Exception exc) {
        if (exc instanceof ManuallyDisconnectException) {
            exc = null;
        }
        if (exc != null) {
            SLog.e("simplex error,thread is dead with exception:" + exc.getMessage());
        }
        this.mStateSender.sendBroadcast("action_write_thread_shutdown", exc);
        this.mStateSender.sendBroadcast("action_read_thread_shutdown", exc);
    }

    /* access modifiers changed from: protected */
    public void runInLoopThread() throws IOException {
        boolean write = this.mWriter.write();
        this.isWrite = write;
        if (write) {
            this.isWrite = false;
            this.mReader.read();
        }
    }

    public synchronized void shutdown(Exception exc) {
        this.mReader.close();
        this.mWriter.close();
        super.shutdown(exc);
    }
}
