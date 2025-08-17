package com.original.tase.socket;

import com.xuhao.didi.core.iocore.interfaces.ISendable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

class Data implements ISendable {
    private String str;

    public Data(String str2) {
        this.str = str2;
    }

    public byte[] parse() {
        byte[] bytes = this.str.getBytes(Charset.defaultCharset());
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 4);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.putInt(bytes.length);
        allocate.put(bytes);
        return allocate.array();
    }
}
