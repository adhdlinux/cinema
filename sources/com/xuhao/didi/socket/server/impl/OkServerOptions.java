package com.xuhao.didi.socket.server.impl;

import com.xuhao.didi.core.iocore.interfaces.IIOCoreOptions;
import com.xuhao.didi.core.protocol.IReaderProtocol;
import com.xuhao.didi.socket.common.interfaces.default_protocol.DefaultNormalReaderProtocol;
import java.nio.ByteOrder;

public class OkServerOptions implements IIOCoreOptions {
    private static boolean isDebug;
    /* access modifiers changed from: private */
    public int mConnectCapacity;
    /* access modifiers changed from: private */
    public int mMaxReadDataMB;
    /* access modifiers changed from: private */
    public ByteOrder mReadOrder;
    /* access modifiers changed from: private */
    public int mReadPackageBytes;
    /* access modifiers changed from: private */
    public IReaderProtocol mReaderProtocol;
    /* access modifiers changed from: private */
    public ByteOrder mWriteOrder;
    /* access modifiers changed from: private */
    public int mWritePackageBytes;

    public static OkServerOptions getDefault() {
        OkServerOptions okServerOptions = new OkServerOptions();
        okServerOptions.mReaderProtocol = new DefaultNormalReaderProtocol();
        okServerOptions.mConnectCapacity = 50;
        okServerOptions.mMaxReadDataMB = 10;
        okServerOptions.mWritePackageBytes = 100;
        okServerOptions.mReadPackageBytes = 50;
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        okServerOptions.mReadOrder = byteOrder;
        okServerOptions.mWriteOrder = byteOrder;
        return okServerOptions;
    }

    public static void setIsDebug(boolean z2) {
        isDebug = z2;
    }

    public int getConnectCapacity() {
        return this.mConnectCapacity;
    }

    public int getMaxReadDataMB() {
        return this.mMaxReadDataMB;
    }

    public ByteOrder getReadByteOrder() {
        return this.mReadOrder;
    }

    public int getReadPackageBytes() {
        return this.mReadPackageBytes;
    }

    public IReaderProtocol getReaderProtocol() {
        return this.mReaderProtocol;
    }

    public ByteOrder getWriteByteOrder() {
        return this.mWriteOrder;
    }

    public int getWritePackageBytes() {
        return this.mWritePackageBytes;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public static class Builder {
        private OkServerOptions mOptions;

        public Builder() {
            this.mOptions = OkServerOptions.getDefault();
        }

        public OkServerOptions build() {
            return this.mOptions;
        }

        public Builder setConnectCapacity(int i2) {
            int unused = this.mOptions.mConnectCapacity = i2;
            return this;
        }

        public Builder setMaxReadDataMB(int i2) {
            int unused = this.mOptions.mMaxReadDataMB = i2;
            return this;
        }

        public Builder setReadOrder(ByteOrder byteOrder) {
            ByteOrder unused = this.mOptions.mReadOrder = byteOrder;
            return this;
        }

        public Builder setReadPackageBytes(int i2) {
            int unused = this.mOptions.mReadPackageBytes = i2;
            return this;
        }

        public Builder setReaderProtocol(IReaderProtocol iReaderProtocol) {
            IReaderProtocol unused = this.mOptions.mReaderProtocol = iReaderProtocol;
            return this;
        }

        public Builder setWriteOrder(ByteOrder byteOrder) {
            ByteOrder unused = this.mOptions.mWriteOrder = byteOrder;
            return this;
        }

        public Builder setWritePackageBytes(int i2) {
            int unused = this.mOptions.mWritePackageBytes = i2;
            return this;
        }

        public Builder(OkServerOptions okServerOptions) {
            OkServerOptions okServerOptions2 = new OkServerOptions();
            IReaderProtocol unused = okServerOptions2.mReaderProtocol = okServerOptions.mReaderProtocol;
            int unused2 = okServerOptions2.mConnectCapacity = okServerOptions.mConnectCapacity;
            int unused3 = okServerOptions2.mMaxReadDataMB = okServerOptions.mMaxReadDataMB;
            int unused4 = okServerOptions2.mWritePackageBytes = okServerOptions.mWritePackageBytes;
            int unused5 = okServerOptions2.mReadPackageBytes = okServerOptions.mReadPackageBytes;
            ByteOrder unused6 = okServerOptions2.mReadOrder = okServerOptions.mReadOrder;
            ByteOrder unused7 = okServerOptions2.mWriteOrder = okServerOptions.mWriteOrder;
            this.mOptions = okServerOptions2;
        }
    }

    private OkServerOptions() {
    }
}
