package com.xuhao.didi.core.iocore.interfaces;

import com.xuhao.didi.core.iocore.interfaces.IIOCoreOptions;
import java.io.OutputStream;

public interface IWriter<T extends IIOCoreOptions> {
    void close();

    void initialize(OutputStream outputStream, IStateSender iStateSender);

    void offer(ISendable iSendable);

    void setOption(T t2);

    boolean write() throws RuntimeException;
}
