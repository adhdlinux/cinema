package com.xuhao.didi.core.iocore.interfaces;

import com.xuhao.didi.core.protocol.IReaderProtocol;
import java.nio.ByteOrder;

public interface IIOCoreOptions {
    int getMaxReadDataMB();

    ByteOrder getReadByteOrder();

    int getReadPackageBytes();

    IReaderProtocol getReaderProtocol();

    ByteOrder getWriteByteOrder();

    int getWritePackageBytes();

    boolean isDebug();
}
