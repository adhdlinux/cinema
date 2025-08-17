package com.xuhao.didi.socket.client.sdk.client;

import com.xuhao.didi.core.iocore.interfaces.IIOCoreOptions;
import com.xuhao.didi.core.protocol.IReaderProtocol;
import com.xuhao.didi.socket.client.impl.client.action.ActionDispatcher;
import com.xuhao.didi.socket.client.sdk.client.connection.AbsReconnectionManager;
import com.xuhao.didi.socket.client.sdk.client.connection.DefaultReconnectManager;
import com.xuhao.didi.socket.client.sdk.client.connection.abilities.IConfiguration;
import com.xuhao.didi.socket.common.interfaces.default_protocol.DefaultNormalReaderProtocol;
import java.nio.ByteOrder;

public class OkSocketOptions implements IIOCoreOptions {
    private static boolean isDebug;
    private boolean isCallbackInIndependentThread;
    /* access modifiers changed from: private */
    public boolean isConnectionHolden;
    /* access modifiers changed from: private */
    public ThreadModeToken mCallbackThreadModeToken;
    /* access modifiers changed from: private */
    public int mConnectTimeoutSecond;
    /* access modifiers changed from: private */
    public IOThreadMode mIOThreadMode;
    /* access modifiers changed from: private */
    public int mMaxReadDataMB;
    /* access modifiers changed from: private */
    public OkSocketFactory mOkSocketFactory;
    /* access modifiers changed from: private */
    public int mPulseFeedLoseTimes;
    /* access modifiers changed from: private */
    public long mPulseFrequency;
    /* access modifiers changed from: private */
    public ByteOrder mReadByteOrder;
    /* access modifiers changed from: private */
    public int mReadPackageBytes;
    /* access modifiers changed from: private */
    public IReaderProtocol mReaderProtocol;
    /* access modifiers changed from: private */
    public AbsReconnectionManager mReconnectionManager;
    /* access modifiers changed from: private */
    public OkSocketSSLConfig mSSLConfig;
    /* access modifiers changed from: private */
    public ByteOrder mWriteOrder;
    /* access modifiers changed from: private */
    public int mWritePackageBytes;

    public static class Builder {
        private OkSocketOptions mOptions;

        public Builder() {
            this(OkSocketOptions.getDefault());
        }

        public OkSocketOptions build() {
            return this.mOptions;
        }

        public Builder setCallbackThreadModeToken(ThreadModeToken threadModeToken) {
            ThreadModeToken unused = this.mOptions.mCallbackThreadModeToken = threadModeToken;
            return this;
        }

        public Builder setConnectTimeoutSecond(int i2) {
            int unused = this.mOptions.mConnectTimeoutSecond = i2;
            return this;
        }

        public Builder setConnectionHolden(boolean z2) {
            boolean unused = this.mOptions.isConnectionHolden = z2;
            return this;
        }

        public Builder setIOThreadMode(IOThreadMode iOThreadMode) {
            IOThreadMode unused = this.mOptions.mIOThreadMode = iOThreadMode;
            return this;
        }

        public Builder setMaxReadDataMB(int i2) {
            int unused = this.mOptions.mMaxReadDataMB = i2;
            return this;
        }

        public Builder setPulseFeedLoseTimes(int i2) {
            int unused = this.mOptions.mPulseFeedLoseTimes = i2;
            return this;
        }

        public Builder setPulseFrequency(long j2) {
            long unused = this.mOptions.mPulseFrequency = j2;
            return this;
        }

        public Builder setReadByteOrder(ByteOrder byteOrder) {
            ByteOrder unused = this.mOptions.mReadByteOrder = byteOrder;
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

        public Builder setReconnectionManager(AbsReconnectionManager absReconnectionManager) {
            AbsReconnectionManager unused = this.mOptions.mReconnectionManager = absReconnectionManager;
            return this;
        }

        public Builder setSSLConfig(OkSocketSSLConfig okSocketSSLConfig) {
            OkSocketSSLConfig unused = this.mOptions.mSSLConfig = okSocketSSLConfig;
            return this;
        }

        public Builder setSocketFactory(OkSocketFactory okSocketFactory) {
            OkSocketFactory unused = this.mOptions.mOkSocketFactory = okSocketFactory;
            return this;
        }

        public Builder setWriteByteOrder(ByteOrder byteOrder) {
            ByteOrder unused = this.mOptions.mWriteOrder = byteOrder;
            return this;
        }

        public Builder setWriteOrder(ByteOrder byteOrder) {
            setWriteByteOrder(byteOrder);
            return this;
        }

        public Builder setWritePackageBytes(int i2) {
            int unused = this.mOptions.mWritePackageBytes = i2;
            return this;
        }

        public Builder(IConfiguration iConfiguration) {
            this(iConfiguration.getOption());
        }

        public Builder(OkSocketOptions okSocketOptions) {
            this.mOptions = okSocketOptions;
        }
    }

    public enum IOThreadMode {
        SIMPLEX,
        DUPLEX
    }

    public static abstract class ThreadModeToken {
        public abstract void handleCallbackEvent(ActionDispatcher.ActionRunnable actionRunnable);
    }

    private OkSocketOptions() {
    }

    public static OkSocketOptions getDefault() {
        OkSocketOptions okSocketOptions = new OkSocketOptions();
        okSocketOptions.mPulseFrequency = 5000;
        okSocketOptions.mIOThreadMode = IOThreadMode.DUPLEX;
        okSocketOptions.mReaderProtocol = new DefaultNormalReaderProtocol();
        okSocketOptions.mMaxReadDataMB = 5;
        okSocketOptions.mConnectTimeoutSecond = 3;
        okSocketOptions.mWritePackageBytes = 100;
        okSocketOptions.mReadPackageBytes = 50;
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        okSocketOptions.mReadByteOrder = byteOrder;
        okSocketOptions.mWriteOrder = byteOrder;
        okSocketOptions.isConnectionHolden = true;
        okSocketOptions.mPulseFeedLoseTimes = 5;
        okSocketOptions.mReconnectionManager = new DefaultReconnectManager();
        okSocketOptions.mSSLConfig = null;
        okSocketOptions.mOkSocketFactory = null;
        okSocketOptions.isCallbackInIndependentThread = true;
        okSocketOptions.mCallbackThreadModeToken = null;
        return okSocketOptions;
    }

    public static void setIsDebug(boolean z2) {
        isDebug = z2;
    }

    public ThreadModeToken getCallbackThreadModeToken() {
        return this.mCallbackThreadModeToken;
    }

    public int getConnectTimeoutSecond() {
        return this.mConnectTimeoutSecond;
    }

    public IOThreadMode getIOThreadMode() {
        return this.mIOThreadMode;
    }

    public int getMaxReadDataMB() {
        return this.mMaxReadDataMB;
    }

    public OkSocketFactory getOkSocketFactory() {
        return this.mOkSocketFactory;
    }

    public int getPulseFeedLoseTimes() {
        return this.mPulseFeedLoseTimes;
    }

    public long getPulseFrequency() {
        return this.mPulseFrequency;
    }

    public ByteOrder getReadByteOrder() {
        return this.mReadByteOrder;
    }

    public int getReadPackageBytes() {
        return this.mReadPackageBytes;
    }

    public IReaderProtocol getReaderProtocol() {
        return this.mReaderProtocol;
    }

    public AbsReconnectionManager getReconnectionManager() {
        return this.mReconnectionManager;
    }

    public OkSocketSSLConfig getSSLConfig() {
        return this.mSSLConfig;
    }

    public ByteOrder getWriteByteOrder() {
        return this.mWriteOrder;
    }

    public int getWritePackageBytes() {
        return this.mWritePackageBytes;
    }

    public boolean isCallbackInIndependentThread() {
        return this.isCallbackInIndependentThread;
    }

    public boolean isConnectionHolden() {
        return this.isConnectionHolden;
    }

    public boolean isDebug() {
        return isDebug;
    }
}
