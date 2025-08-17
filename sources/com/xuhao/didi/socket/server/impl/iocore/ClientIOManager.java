package com.xuhao.didi.socket.server.impl.iocore;

import com.xuhao.didi.core.iocore.ReaderImpl;
import com.xuhao.didi.core.iocore.WriterImpl;
import com.xuhao.didi.core.iocore.interfaces.IReader;
import com.xuhao.didi.core.iocore.interfaces.ISendable;
import com.xuhao.didi.core.iocore.interfaces.IStateSender;
import com.xuhao.didi.core.iocore.interfaces.IWriter;
import com.xuhao.didi.core.protocol.IReaderProtocol;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.IIOManager;
import com.xuhao.didi.socket.server.exceptions.InitiativeDisconnectException;
import com.xuhao.didi.socket.server.impl.OkServerOptions;
import java.io.InputStream;
import java.io.OutputStream;

public class ClientIOManager implements IIOManager<OkServerOptions> {
    private ClientReadThread mClientReadThread;
    private IStateSender mClientStateSender;
    private ClientWriteThread mClientWriteThread;
    private InputStream mInputStream;
    private OkServerOptions mOptions;
    private OutputStream mOutputStream;
    private IReader mReader;
    private IWriter mWriter;

    public ClientIOManager(InputStream inputStream, OutputStream outputStream, OkServerOptions okServerOptions, IStateSender iStateSender) {
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
        this.mOptions = okServerOptions;
        this.mClientStateSender = iStateSender;
        initIO();
    }

    private void assertHeaderProtocolNotEmpty() {
        IReaderProtocol readerProtocol = this.mOptions.getReaderProtocol();
        if (readerProtocol == null) {
            throw new IllegalArgumentException("The reader protocol can not be Null.");
        } else if (readerProtocol.getHeaderLength() == 0) {
            throw new IllegalArgumentException("The header length can not be zero.");
        }
    }

    private void initIO() {
        assertHeaderProtocolNotEmpty();
        this.mReader = new ReaderImpl();
        this.mWriter = new WriterImpl();
        setOkOptions(this.mOptions);
        this.mReader.initialize(this.mInputStream, this.mClientStateSender);
        this.mWriter.initialize(this.mOutputStream, this.mClientStateSender);
    }

    private void shutdownAllThread(Exception exc) {
        ClientReadThread clientReadThread = this.mClientReadThread;
        if (clientReadThread != null) {
            clientReadThread.shutdown(exc);
            this.mClientReadThread = null;
        }
        ClientWriteThread clientWriteThread = this.mClientWriteThread;
        if (clientWriteThread != null) {
            clientWriteThread.shutdown(exc);
            this.mClientWriteThread = null;
        }
    }

    public void close() {
        close(new InitiativeDisconnectException());
    }

    public void send(ISendable iSendable) {
        this.mWriter.offer(iSendable);
    }

    public void startEngine() {
    }

    public void startReadEngine() {
        ClientReadThread clientReadThread = this.mClientReadThread;
        if (clientReadThread != null) {
            clientReadThread.shutdown();
            this.mClientReadThread = null;
        }
        ClientReadThread clientReadThread2 = new ClientReadThread(this.mReader, this.mClientStateSender);
        this.mClientReadThread = clientReadThread2;
        clientReadThread2.start();
    }

    public void startWriteEngine() {
        ClientWriteThread clientWriteThread = this.mClientWriteThread;
        if (clientWriteThread != null) {
            clientWriteThread.shutdown();
            this.mClientWriteThread = null;
        }
        ClientWriteThread clientWriteThread2 = new ClientWriteThread(this.mWriter, this.mClientStateSender);
        this.mClientWriteThread = clientWriteThread2;
        clientWriteThread2.start();
    }

    public void close(Exception exc) {
        shutdownAllThread(exc);
    }

    public void setOkOptions(OkServerOptions okServerOptions) {
        this.mOptions = okServerOptions;
        assertHeaderProtocolNotEmpty();
        IWriter iWriter = this.mWriter;
        if (iWriter != null && this.mReader != null) {
            iWriter.setOption(this.mOptions);
            this.mReader.setOption(this.mOptions);
        }
    }
}
