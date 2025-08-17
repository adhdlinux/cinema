package com.xuhao.didi.socket.client.impl.client;

import com.xuhao.didi.core.iocore.interfaces.ISendable;
import com.xuhao.didi.core.utils.SLog;
import com.xuhao.didi.socket.client.impl.client.action.ActionHandler;
import com.xuhao.didi.socket.client.impl.client.iothreads.IOThreadManager;
import com.xuhao.didi.socket.client.impl.exceptions.ManuallyDisconnectException;
import com.xuhao.didi.socket.client.impl.exceptions.UnConnectException;
import com.xuhao.didi.socket.client.sdk.client.ConnectionInfo;
import com.xuhao.didi.socket.client.sdk.client.OkSocketOptions;
import com.xuhao.didi.socket.client.sdk.client.OkSocketSSLConfig;
import com.xuhao.didi.socket.client.sdk.client.action.IAction;
import com.xuhao.didi.socket.client.sdk.client.connection.AbsReconnectionManager;
import com.xuhao.didi.socket.client.sdk.client.connection.IConnectionManager;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.IIOManager;
import com.xuhao.didi.socket.common.interfaces.default_protocol.DefaultX509ProtocolTrustManager;
import com.xuhao.didi.socket.common.interfaces.utils.TextUtils;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class ConnectionManagerImpl extends AbsConnectionManager {
    /* access modifiers changed from: private */
    public volatile boolean isConnectionPermitted;
    /* access modifiers changed from: private */
    public volatile boolean isDisconnecting;
    /* access modifiers changed from: private */
    public ActionHandler mActionHandler;
    /* access modifiers changed from: private */
    public Thread mConnectThread;
    /* access modifiers changed from: private */
    public IIOManager mManager;
    /* access modifiers changed from: private */
    public volatile OkSocketOptions mOptions;
    private volatile PulseManager mPulseManager;
    private volatile AbsReconnectionManager mReconnectionManager;
    /* access modifiers changed from: private */
    public volatile Socket mSocket;

    private class ConnectionThread extends Thread {
        public ConnectionThread(String str) {
            super(str);
        }

        public void run() {
            try {
                ConnectionManagerImpl connectionManagerImpl = ConnectionManagerImpl.this;
                Socket unused = connectionManagerImpl.mSocket = connectionManagerImpl.getSocketByConfig();
                if (ConnectionManagerImpl.this.mLocalConnectionInfo != null) {
                    SLog.i("try bind: " + ConnectionManagerImpl.this.mLocalConnectionInfo.getIp() + " port:" + ConnectionManagerImpl.this.mLocalConnectionInfo.getPort());
                    ConnectionManagerImpl.this.mSocket.bind(new InetSocketAddress(ConnectionManagerImpl.this.mLocalConnectionInfo.getIp(), ConnectionManagerImpl.this.mLocalConnectionInfo.getPort()));
                }
                SLog.i("Start connect: " + ConnectionManagerImpl.this.mRemoteConnectionInfo.getIp() + ":" + ConnectionManagerImpl.this.mRemoteConnectionInfo.getPort() + " socket server...");
                ConnectionManagerImpl.this.mSocket.connect(new InetSocketAddress(ConnectionManagerImpl.this.mRemoteConnectionInfo.getIp(), ConnectionManagerImpl.this.mRemoteConnectionInfo.getPort()), ConnectionManagerImpl.this.mOptions.getConnectTimeoutSecond() * 1000);
                ConnectionManagerImpl.this.mSocket.setTcpNoDelay(true);
                ConnectionManagerImpl.this.resolveManager();
                ConnectionManagerImpl.this.sendBroadcast(IAction.ACTION_CONNECTION_SUCCESS);
                SLog.i("Socket server: " + ConnectionManagerImpl.this.mRemoteConnectionInfo.getIp() + ":" + ConnectionManagerImpl.this.mRemoteConnectionInfo.getPort() + " connect successful!");
            } catch (Exception e2) {
                if (ConnectionManagerImpl.this.mOptions.isDebug()) {
                    e2.printStackTrace();
                }
                throw new UnConnectException("Create socket failed.", e2);
            } catch (Exception e3) {
                try {
                    if (ConnectionManagerImpl.this.mOptions.isDebug()) {
                        e3.printStackTrace();
                    }
                    UnConnectException unConnectException = new UnConnectException((Throwable) e3);
                    SLog.e("Socket server " + ConnectionManagerImpl.this.mRemoteConnectionInfo.getIp() + ":" + ConnectionManagerImpl.this.mRemoteConnectionInfo.getPort() + " connect failed! error msg:" + e3.getMessage());
                    ConnectionManagerImpl.this.sendBroadcast(IAction.ACTION_CONNECTION_FAILED, unConnectException);
                } catch (Throwable th) {
                    boolean unused2 = ConnectionManagerImpl.this.isConnectionPermitted = true;
                    throw th;
                }
            }
            boolean unused3 = ConnectionManagerImpl.this.isConnectionPermitted = true;
        }
    }

    private class DisconnectThread extends Thread {
        private Exception mException;

        public DisconnectThread(Exception exc, String str) {
            super(str);
            this.mException = exc;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|(1:4)|5|(7:9|10|11|12|13|15|16)|17|(2:19|20)|21|22|(1:24)|25|(3:29|(1:31)|32)|33|(2:35|(2:37|53)(1:55))(1:54)) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0060 */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0068 A[Catch:{ all -> 0x00d6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x009b A[DONT_GENERATE] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00ac A[DONT_GENERATE] */
        /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                java.lang.String r0 = "action_disconnection"
                java.lang.String r1 = "socket is disconnecting because: "
                r2 = 1
                r3 = 0
                r4 = 0
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r5 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this     // Catch:{ all -> 0x00d6 }
                com.xuhao.didi.socket.common.interfaces.common_interfacies.IIOManager r5 = r5.mManager     // Catch:{ all -> 0x00d6 }
                if (r5 == 0) goto L_0x001a
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r5 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this     // Catch:{ all -> 0x00d6 }
                com.xuhao.didi.socket.common.interfaces.common_interfacies.IIOManager r5 = r5.mManager     // Catch:{ all -> 0x00d6 }
                java.lang.Exception r6 = r7.mException     // Catch:{ all -> 0x00d6 }
                r5.close(r6)     // Catch:{ all -> 0x00d6 }
            L_0x001a:
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r5 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this     // Catch:{ all -> 0x00d6 }
                java.lang.Thread r5 = r5.mConnectThread     // Catch:{ all -> 0x00d6 }
                if (r5 == 0) goto L_0x004f
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r5 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this     // Catch:{ all -> 0x00d6 }
                java.lang.Thread r5 = r5.mConnectThread     // Catch:{ all -> 0x00d6 }
                boolean r5 = r5.isAlive()     // Catch:{ all -> 0x00d6 }
                if (r5 == 0) goto L_0x004f
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r5 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this     // Catch:{ all -> 0x00d6 }
                java.lang.Thread r5 = r5.mConnectThread     // Catch:{ all -> 0x00d6 }
                r5.interrupt()     // Catch:{ all -> 0x00d6 }
                java.lang.String r5 = "disconnect thread need waiting for connection thread done."
                com.xuhao.didi.core.utils.SLog.i(r5)     // Catch:{ InterruptedException -> 0x0045 }
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r5 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this     // Catch:{ InterruptedException -> 0x0045 }
                java.lang.Thread r5 = r5.mConnectThread     // Catch:{ InterruptedException -> 0x0045 }
                r5.join()     // Catch:{ InterruptedException -> 0x0045 }
            L_0x0045:
                java.lang.String r5 = "connection thread is done. disconnection thread going on"
                com.xuhao.didi.core.utils.SLog.i(r5)     // Catch:{ all -> 0x00d6 }
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r5 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this     // Catch:{ all -> 0x00d6 }
                java.lang.Thread unused = r5.mConnectThread = r4     // Catch:{ all -> 0x00d6 }
            L_0x004f:
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r5 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this     // Catch:{ all -> 0x00d6 }
                java.net.Socket r5 = r5.mSocket     // Catch:{ all -> 0x00d6 }
                if (r5 == 0) goto L_0x0060
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r5 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this     // Catch:{ IOException -> 0x0060 }
                java.net.Socket r5 = r5.mSocket     // Catch:{ IOException -> 0x0060 }
                r5.close()     // Catch:{ IOException -> 0x0060 }
            L_0x0060:
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r5 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this     // Catch:{ all -> 0x00d6 }
                com.xuhao.didi.socket.client.impl.client.action.ActionHandler r5 = r5.mActionHandler     // Catch:{ all -> 0x00d6 }
                if (r5 == 0) goto L_0x007d
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r5 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this     // Catch:{ all -> 0x00d6 }
                com.xuhao.didi.socket.client.impl.client.action.ActionHandler r5 = r5.mActionHandler     // Catch:{ all -> 0x00d6 }
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r6 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this     // Catch:{ all -> 0x00d6 }
                r5.detach(r6)     // Catch:{ all -> 0x00d6 }
                java.lang.String r5 = "mActionHandler is detached."
                com.xuhao.didi.core.utils.SLog.i(r5)     // Catch:{ all -> 0x00d6 }
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r5 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this     // Catch:{ all -> 0x00d6 }
                com.xuhao.didi.socket.client.impl.client.action.ActionHandler unused = r5.mActionHandler = r4     // Catch:{ all -> 0x00d6 }
            L_0x007d:
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r5 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this
                boolean unused = r5.isDisconnecting = r3
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r3 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this
                boolean unused = r3.isConnectionPermitted = r2
                java.lang.Exception r2 = r7.mException
                boolean r2 = r2 instanceof com.xuhao.didi.socket.client.impl.exceptions.UnConnectException
                if (r2 != 0) goto L_0x00a3
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r2 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this
                java.net.Socket r2 = r2.mSocket
                if (r2 == 0) goto L_0x00a3
                java.lang.Exception r2 = r7.mException
                boolean r3 = r2 instanceof com.xuhao.didi.socket.client.impl.exceptions.ManuallyDisconnectException
                if (r3 == 0) goto L_0x009c
                r2 = r4
            L_0x009c:
                r7.mException = r2
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r3 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this
                r3.sendBroadcast(r0, r2)
            L_0x00a3:
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r0 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this
                java.net.Socket unused = r0.mSocket = r4
                java.lang.Exception r0 = r7.mException
                if (r0 == 0) goto L_0x00d5
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r1)
                java.lang.Exception r1 = r7.mException
                java.lang.String r1 = r1.getMessage()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                com.xuhao.didi.core.utils.SLog.e(r0)
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r0 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this
                com.xuhao.didi.socket.client.sdk.client.OkSocketOptions r0 = r0.mOptions
                boolean r0 = r0.isDebug()
                if (r0 == 0) goto L_0x00d5
                java.lang.Exception r0 = r7.mException
                r0.printStackTrace()
            L_0x00d5:
                return
            L_0x00d6:
                r5 = move-exception
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r6 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this
                boolean unused = r6.isDisconnecting = r3
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r3 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this
                boolean unused = r3.isConnectionPermitted = r2
                java.lang.Exception r2 = r7.mException
                boolean r2 = r2 instanceof com.xuhao.didi.socket.client.impl.exceptions.UnConnectException
                if (r2 != 0) goto L_0x00fd
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r2 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this
                java.net.Socket r2 = r2.mSocket
                if (r2 == 0) goto L_0x00fd
                java.lang.Exception r2 = r7.mException
                boolean r3 = r2 instanceof com.xuhao.didi.socket.client.impl.exceptions.ManuallyDisconnectException
                if (r3 == 0) goto L_0x00f6
                r2 = r4
            L_0x00f6:
                r7.mException = r2
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r3 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this
                r3.sendBroadcast(r0, r2)
            L_0x00fd:
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r0 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this
                java.net.Socket unused = r0.mSocket = r4
                java.lang.Exception r0 = r7.mException
                if (r0 == 0) goto L_0x012f
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r1)
                java.lang.Exception r1 = r7.mException
                java.lang.String r1 = r1.getMessage()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                com.xuhao.didi.core.utils.SLog.e(r0)
                com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl r0 = com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.this
                com.xuhao.didi.socket.client.sdk.client.OkSocketOptions r0 = r0.mOptions
                boolean r0 = r0.isDebug()
                if (r0 == 0) goto L_0x012f
                java.lang.Exception r0 = r7.mException
                r0.printStackTrace()
            L_0x012f:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.DisconnectThread.run():void");
        }
    }

    protected ConnectionManagerImpl(ConnectionInfo connectionInfo) {
        this(connectionInfo, (ConnectionInfo) null);
    }

    /* access modifiers changed from: private */
    public synchronized Socket getSocketByConfig() throws Exception {
        if (this.mOptions.getOkSocketFactory() != null) {
            return this.mOptions.getOkSocketFactory().createSocket(this.mRemoteConnectionInfo, this.mOptions);
        }
        OkSocketSSLConfig sSLConfig = this.mOptions.getSSLConfig();
        if (sSLConfig == null) {
            return new Socket();
        }
        SSLSocketFactory customSSLFactory = sSLConfig.getCustomSSLFactory();
        if (customSSLFactory == null) {
            String str = "SSL";
            if (!TextUtils.isEmpty(sSLConfig.getProtocol())) {
                str = sSLConfig.getProtocol();
            }
            TrustManager[] trustManagers = sSLConfig.getTrustManagers();
            if (trustManagers == null || trustManagers.length == 0) {
                trustManagers = new TrustManager[]{new DefaultX509ProtocolTrustManager()};
            }
            try {
                SSLContext instance = SSLContext.getInstance(str);
                instance.init(sSLConfig.getKeyManagers(), trustManagers, new SecureRandom());
                return instance.getSocketFactory().createSocket();
            } catch (Exception e2) {
                if (this.mOptions.isDebug()) {
                    e2.printStackTrace();
                }
                SLog.e(e2.getMessage());
                return new Socket();
            }
        } else {
            try {
                return customSSLFactory.createSocket();
            } catch (IOException e3) {
                if (this.mOptions.isDebug()) {
                    e3.printStackTrace();
                }
                SLog.e(e3.getMessage());
                return new Socket();
            }
        }
    }

    /* access modifiers changed from: private */
    public void resolveManager() throws IOException {
        this.mPulseManager = new PulseManager(this, this.mOptions);
        IOThreadManager iOThreadManager = new IOThreadManager(this.mSocket.getInputStream(), this.mSocket.getOutputStream(), this.mOptions, this.mActionDispatcher);
        this.mManager = iOThreadManager;
        iOThreadManager.startEngine();
    }

    public synchronized void connect() {
        SLog.i("Thread name:" + Thread.currentThread().getName() + " id:" + Thread.currentThread().getId());
        if (this.isConnectionPermitted) {
            this.isConnectionPermitted = false;
            if (!isConnect()) {
                this.isDisconnecting = false;
                if (this.mRemoteConnectionInfo != null) {
                    ActionHandler actionHandler = this.mActionHandler;
                    if (actionHandler != null) {
                        actionHandler.detach(this);
                        SLog.i("mActionHandler is detached.");
                    }
                    ActionHandler actionHandler2 = new ActionHandler();
                    this.mActionHandler = actionHandler2;
                    actionHandler2.attach(this, this);
                    SLog.i("mActionHandler is attached.");
                    if (this.mReconnectionManager != null) {
                        this.mReconnectionManager.detach();
                        SLog.i("ReconnectionManager is detached.");
                    }
                    this.mReconnectionManager = this.mOptions.getReconnectionManager();
                    if (this.mReconnectionManager != null) {
                        this.mReconnectionManager.attach(this);
                        SLog.i("ReconnectionManager is attached.");
                    }
                    ConnectionThread connectionThread = new ConnectionThread(" Connect thread for " + (this.mRemoteConnectionInfo.getIp() + ":" + this.mRemoteConnectionInfo.getPort()));
                    this.mConnectThread = connectionThread;
                    connectionThread.setDaemon(true);
                    this.mConnectThread.start();
                    return;
                }
                this.isConnectionPermitted = true;
                throw new UnConnectException("连接参数为空,检查连接参数");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        if ((r6 instanceof com.xuhao.didi.socket.client.impl.exceptions.ManuallyDisconnectException) == false) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        if (r5.mReconnectionManager == null) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        r5.mReconnectionManager.detach();
        com.xuhao.didi.core.utils.SLog.i("ReconnectionManager is detached.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r2 = new com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.DisconnectThread(r5, r6, "Disconnect Thread for " + (r5.mRemoteConnectionInfo.getIp() + ":" + r5.mRemoteConnectionInfo.getPort()));
        r2.setDaemon(true);
        r2.start();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void disconnect(java.lang.Exception r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.isDisconnecting     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r5)     // Catch:{ all -> 0x006b }
            return
        L_0x0007:
            r0 = 1
            r5.isDisconnecting = r0     // Catch:{ all -> 0x006b }
            com.xuhao.didi.socket.client.impl.client.PulseManager r1 = r5.mPulseManager     // Catch:{ all -> 0x006b }
            if (r1 == 0) goto L_0x0016
            com.xuhao.didi.socket.client.impl.client.PulseManager r1 = r5.mPulseManager     // Catch:{ all -> 0x006b }
            r1.dead()     // Catch:{ all -> 0x006b }
            r1 = 0
            r5.mPulseManager = r1     // Catch:{ all -> 0x006b }
        L_0x0016:
            monitor-exit(r5)     // Catch:{ all -> 0x006b }
            boolean r1 = r6 instanceof com.xuhao.didi.socket.client.impl.exceptions.ManuallyDisconnectException
            if (r1 == 0) goto L_0x0029
            com.xuhao.didi.socket.client.sdk.client.connection.AbsReconnectionManager r1 = r5.mReconnectionManager
            if (r1 == 0) goto L_0x0029
            com.xuhao.didi.socket.client.sdk.client.connection.AbsReconnectionManager r1 = r5.mReconnectionManager
            r1.detach()
            java.lang.String r1 = "ReconnectionManager is detached."
            com.xuhao.didi.core.utils.SLog.i(r1)
        L_0x0029:
            monitor-enter(r5)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r1.<init>()     // Catch:{ all -> 0x0068 }
            com.xuhao.didi.socket.client.sdk.client.ConnectionInfo r2 = r5.mRemoteConnectionInfo     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = r2.getIp()     // Catch:{ all -> 0x0068 }
            r1.append(r2)     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = ":"
            r1.append(r2)     // Catch:{ all -> 0x0068 }
            com.xuhao.didi.socket.client.sdk.client.ConnectionInfo r2 = r5.mRemoteConnectionInfo     // Catch:{ all -> 0x0068 }
            int r2 = r2.getPort()     // Catch:{ all -> 0x0068 }
            r1.append(r2)     // Catch:{ all -> 0x0068 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0068 }
            com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl$DisconnectThread r2 = new com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl$DisconnectThread     // Catch:{ all -> 0x0068 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r3.<init>()     // Catch:{ all -> 0x0068 }
            java.lang.String r4 = "Disconnect Thread for "
            r3.append(r4)     // Catch:{ all -> 0x0068 }
            r3.append(r1)     // Catch:{ all -> 0x0068 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0068 }
            r2.<init>(r6, r1)     // Catch:{ all -> 0x0068 }
            r2.setDaemon(r0)     // Catch:{ all -> 0x0068 }
            r2.start()     // Catch:{ all -> 0x0068 }
            monitor-exit(r5)     // Catch:{ all -> 0x0068 }
            return
        L_0x0068:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0068 }
            throw r6
        L_0x006b:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x006b }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xuhao.didi.socket.client.impl.client.ConnectionManagerImpl.disconnect(java.lang.Exception):void");
    }

    public ConnectionInfo getLocalConnectionInfo() {
        InetSocketAddress inetSocketAddress;
        ConnectionInfo localConnectionInfo = super.getLocalConnectionInfo();
        if (localConnectionInfo != null || !isConnect() || (inetSocketAddress = (InetSocketAddress) this.mSocket.getLocalSocketAddress()) == null) {
            return localConnectionInfo;
        }
        return new ConnectionInfo(inetSocketAddress.getHostName(), inetSocketAddress.getPort());
    }

    public OkSocketOptions getOption() {
        return this.mOptions;
    }

    public PulseManager getPulseManager() {
        return this.mPulseManager;
    }

    public AbsReconnectionManager getReconnectionManager() {
        return this.mOptions.getReconnectionManager();
    }

    public boolean isConnect() {
        if (this.mSocket != null && this.mSocket.isConnected() && !this.mSocket.isClosed()) {
            return true;
        }
        return false;
    }

    public boolean isDisconnecting() {
        return this.isDisconnecting;
    }

    public IConnectionManager option(OkSocketOptions okSocketOptions) {
        if (okSocketOptions == null) {
            return this;
        }
        this.mOptions = okSocketOptions;
        IIOManager iIOManager = this.mManager;
        if (iIOManager != null) {
            iIOManager.setOkOptions(this.mOptions);
        }
        if (this.mPulseManager != null) {
            this.mPulseManager.setOkOptions(this.mOptions);
        }
        if (this.mReconnectionManager != null && !this.mReconnectionManager.equals(this.mOptions.getReconnectionManager())) {
            if (this.mReconnectionManager != null) {
                this.mReconnectionManager.detach();
            }
            SLog.i("reconnection manager is replaced");
            this.mReconnectionManager = this.mOptions.getReconnectionManager();
            this.mReconnectionManager.attach(this);
        }
        return this;
    }

    public void setIsConnectionHolder(boolean z2) {
        this.mOptions = new OkSocketOptions.Builder(this.mOptions).setConnectionHolden(z2).build();
    }

    public void setLocalConnectionInfo(ConnectionInfo connectionInfo) {
        if (!isConnect()) {
            this.mLocalConnectionInfo = connectionInfo;
            return;
        }
        throw new IllegalStateException("Socket is connected, can't set local info after connect.");
    }

    public ConnectionManagerImpl(ConnectionInfo connectionInfo, ConnectionInfo connectionInfo2) {
        super(connectionInfo, connectionInfo2);
        String str;
        this.isConnectionPermitted = true;
        this.isDisconnecting = false;
        String str2 = "";
        if (connectionInfo != null) {
            String ip = connectionInfo.getIp();
            str = connectionInfo.getPort() + str2;
            str2 = ip;
        } else {
            str = str2;
        }
        SLog.i("block connection init with:" + str2 + ":" + str);
        if (connectionInfo2 != null) {
            SLog.i("binding local addr:" + connectionInfo2.getIp() + " port:" + connectionInfo2.getPort());
        }
    }

    public IConnectionManager send(ISendable iSendable) {
        if (!(this.mManager == null || iSendable == null || !isConnect())) {
            this.mManager.send(iSendable);
        }
        return this;
    }

    public void disconnect() {
        disconnect(new ManuallyDisconnectException());
    }
}
