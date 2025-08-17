package com.xuhao.didi.socket.common.interfaces.default_protocol;

import com.xuhao.didi.core.protocol.IReaderProtocol;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class DefaultNormalReaderProtocol implements IReaderProtocol {
    public int getBodyLength(byte[] bArr, ByteOrder byteOrder) {
        if (bArr == null || bArr.length < getHeaderLength()) {
            return 0;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(byteOrder);
        return wrap.getInt();
    }

    public int getHeaderLength() {
        return 4;
    }
}
