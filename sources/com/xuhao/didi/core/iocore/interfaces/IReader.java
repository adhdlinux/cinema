package com.xuhao.didi.core.iocore.interfaces;

import com.xuhao.didi.core.iocore.interfaces.IIOCoreOptions;
import java.io.InputStream;

public interface IReader<T extends IIOCoreOptions> {
    void close();

    void initialize(InputStream inputStream, IStateSender iStateSender);

    void read() throws RuntimeException;

    void setOption(T t2);
}
