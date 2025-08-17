package com.xuhao.didi.socket.client.impl.client.iothreads;

import com.xuhao.didi.core.iocore.ReaderImpl;
import com.xuhao.didi.core.iocore.WriterImpl;
import com.xuhao.didi.core.iocore.interfaces.IReader;
import com.xuhao.didi.core.iocore.interfaces.ISendable;
import com.xuhao.didi.core.iocore.interfaces.IStateSender;
import com.xuhao.didi.core.iocore.interfaces.IWriter;
import com.xuhao.didi.core.protocol.IReaderProtocol;
import com.xuhao.didi.core.utils.SLog;
import com.xuhao.didi.socket.client.impl.exceptions.ManuallyDisconnectException;
import com.xuhao.didi.socket.client.sdk.client.OkSocketOptions;
import com.xuhao.didi.socket.common.interfaces.basic.AbsLoopThread;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.IIOManager;
import java.io.InputStream;
import java.io.OutputStream;

public class IOThreadManager implements IIOManager<OkSocketOptions> {
    private OkSocketOptions.IOThreadMode mCurrentThreadMode;
    private DuplexReadThread mDuplexReadThread;
    private DuplexWriteThread mDuplexWriteThread;
    private InputStream mInputStream;
    private volatile OkSocketOptions mOkOptions;
    private OutputStream mOutputStream;
    private IReader mReader;
    private IStateSender mSender;
    private AbsLoopThread mSimplexThread;
    private IWriter mWriter;

    /* renamed from: com.xuhao.didi.socket.client.impl.client.iothreads.IOThreadManager$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xuhao$didi$socket$client$sdk$client$OkSocketOptions$IOThreadMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.xuhao.didi.socket.client.sdk.client.OkSocketOptions$IOThreadMode[] r0 = com.xuhao.didi.socket.client.sdk.client.OkSocketOptions.IOThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$xuhao$didi$socket$client$sdk$client$OkSocketOptions$IOThreadMode = r0
                com.xuhao.didi.socket.client.sdk.client.OkSocketOptions$IOThreadMode r1 = com.xuhao.didi.socket.client.sdk.client.OkSocketOptions.IOThreadMode.DUPLEX     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$xuhao$didi$socket$client$sdk$client$OkSocketOptions$IOThreadMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xuhao.didi.socket.client.sdk.client.OkSocketOptions$IOThreadMode r1 = com.xuhao.didi.socket.client.sdk.client.OkSocketOptions.IOThreadMode.SIMPLEX     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xuhao.didi.socket.client.impl.client.iothreads.IOThreadManager.AnonymousClass1.<clinit>():void");
        }
    }

    public IOThreadManager(InputStream inputStream, OutputStream outputStream, OkSocketOptions okSocketOptions, IStateSender iStateSender) {
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
        this.mOkOptions = okSocketOptions;
        this.mSender = iStateSender;
        initIO();
    }

    private void assertHeaderProtocolNotEmpty() {
        IReaderProtocol readerProtocol = this.mOkOptions.getReaderProtocol();
        if (readerProtocol == null) {
            throw new IllegalArgumentException("The reader protocol can not be Null.");
        } else if (readerProtocol.getHeaderLength() == 0) {
            throw new IllegalArgumentException("The header length can not be zero.");
        }
    }

    private void assertTheThreadModeNotChanged() {
        if (this.mOkOptions.getIOThreadMode() != this.mCurrentThreadMode) {
            throw new IllegalArgumentException("can't hot change iothread mode from " + this.mCurrentThreadMode + " to " + this.mOkOptions.getIOThreadMode() + " in blocking io manager");
        }
    }

    private void duplex() {
        shutdownAllThread((Exception) null);
        this.mDuplexWriteThread = new DuplexWriteThread(this.mWriter, this.mSender);
        this.mDuplexReadThread = new DuplexReadThread(this.mReader, this.mSender);
        this.mDuplexWriteThread.start();
        this.mDuplexReadThread.start();
    }

    private void initIO() {
        assertHeaderProtocolNotEmpty();
        ReaderImpl readerImpl = new ReaderImpl();
        this.mReader = readerImpl;
        readerImpl.initialize(this.mInputStream, this.mSender);
        WriterImpl writerImpl = new WriterImpl();
        this.mWriter = writerImpl;
        writerImpl.initialize(this.mOutputStream, this.mSender);
    }

    private void shutdownAllThread(Exception exc) {
        AbsLoopThread absLoopThread = this.mSimplexThread;
        if (absLoopThread != null) {
            absLoopThread.shutdown(exc);
            this.mSimplexThread = null;
        }
        DuplexReadThread duplexReadThread = this.mDuplexReadThread;
        if (duplexReadThread != null) {
            duplexReadThread.shutdown(exc);
            this.mDuplexReadThread = null;
        }
        DuplexWriteThread duplexWriteThread = this.mDuplexWriteThread;
        if (duplexWriteThread != null) {
            duplexWriteThread.shutdown(exc);
            this.mDuplexWriteThread = null;
        }
    }

    private void simplex() {
        shutdownAllThread((Exception) null);
        SimplexIOThread simplexIOThread = new SimplexIOThread(this.mReader, this.mWriter, this.mSender);
        this.mSimplexThread = simplexIOThread;
        simplexIOThread.start();
    }

    public void close() {
        close(new ManuallyDisconnectException());
    }

    public void send(ISendable iSendable) {
        this.mWriter.offer(iSendable);
    }

    public void startEngine() {
        this.mCurrentThreadMode = this.mOkOptions.getIOThreadMode();
        this.mReader.setOption(this.mOkOptions);
        this.mWriter.setOption(this.mOkOptions);
        int i2 = AnonymousClass1.$SwitchMap$com$xuhao$didi$socket$client$sdk$client$OkSocketOptions$IOThreadMode[this.mOkOptions.getIOThreadMode().ordinal()];
        if (i2 == 1) {
            SLog.w("DUPLEX is processing");
            duplex();
        } else if (i2 == 2) {
            SLog.w("SIMPLEX is processing");
            simplex();
        } else {
            throw new RuntimeException("未定义的线程模式");
        }
    }

    public void close(Exception exc) {
        shutdownAllThread(exc);
        this.mCurrentThreadMode = null;
    }

    public void setOkOptions(OkSocketOptions okSocketOptions) {
        this.mOkOptions = okSocketOptions;
        if (this.mCurrentThreadMode == null) {
            this.mCurrentThreadMode = this.mOkOptions.getIOThreadMode();
        }
        assertTheThreadModeNotChanged();
        assertHeaderProtocolNotEmpty();
        this.mWriter.setOption(this.mOkOptions);
        this.mReader.setOption(this.mOkOptions);
    }
}
