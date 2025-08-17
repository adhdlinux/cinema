package com.xuhao.didi.core.iocore;

import com.xuhao.didi.core.iocore.interfaces.IIOCoreOptions;
import com.xuhao.didi.core.iocore.interfaces.IReader;
import com.xuhao.didi.core.iocore.interfaces.IStateSender;
import java.io.IOException;
import java.io.InputStream;

public abstract class AbsReader implements IReader<IIOCoreOptions> {
    protected InputStream mInputStream;
    protected volatile IIOCoreOptions mOkOptions;
    protected IStateSender mStateSender;

    public void close() {
        InputStream inputStream = this.mInputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public void initialize(InputStream inputStream, IStateSender iStateSender) {
        this.mStateSender = iStateSender;
        this.mInputStream = inputStream;
    }

    public void setOption(IIOCoreOptions iIOCoreOptions) {
        this.mOkOptions = iIOCoreOptions;
    }
}
