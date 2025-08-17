package com.xuhao.didi.core.protocol;

import java.nio.ByteOrder;

public interface IReaderProtocol {
    int getBodyLength(byte[] bArr, ByteOrder byteOrder);

    int getHeaderLength();
}
