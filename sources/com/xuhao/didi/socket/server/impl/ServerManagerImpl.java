package com.xuhao.didi.socket.server.impl;

import com.xuhao.didi.core.utils.SLog;
import com.xuhao.didi.socket.common.interfaces.basic.AbsLoopThread;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IClient;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IClientPool;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IServerManagerPrivate;
import com.xuhao.didi.socket.server.action.IAction;
import com.xuhao.didi.socket.server.exceptions.IllegalAccessException;
import com.xuhao.didi.socket.server.exceptions.InitiativeDisconnectException;
import com.xuhao.didi.socket.server.impl.clientpojo.ClientImpl;
import com.xuhao.didi.socket.server.impl.clientpojo.ClientPoolImpl;
import java.io.IOException;
import java.net.ServerSocket;

public class ServerManagerImpl extends AbsServerRegisterProxy implements IServerManagerPrivate<OkServerOptions> {
    private boolean isInit = false;
    private AbsLoopThread mAcceptThread;
    /* access modifiers changed from: private */
    public ClientPoolImpl mClientPoolImpl;
    /* access modifiers changed from: private */
    public OkServerOptions mServerOptions;
    private int mServerPort = -999;
    /* access modifiers changed from: private */
    public ServerSocket mServerSocket;

    private class AcceptThread extends AbsLoopThread {
        public AcceptThread(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public void beforeLoop() throws Exception {
            ServerManagerImpl serverManagerImpl = ServerManagerImpl.this;
            ClientPoolImpl unused = serverManagerImpl.mClientPoolImpl = new ClientPoolImpl(serverManagerImpl.mServerOptions.getConnectCapacity());
            ServerManagerImpl serverManagerImpl2 = ServerManagerImpl.this;
            serverManagerImpl2.mServerActionDispatcher.setClientPool(serverManagerImpl2.mClientPoolImpl);
            ServerManagerImpl.this.sendBroadcast(IAction.Server.ACTION_SERVER_LISTENING);
        }

        /* access modifiers changed from: protected */
        public void loopFinish(Exception exc) {
            if (!(exc instanceof InitiativeDisconnectException)) {
                ServerManagerImpl.this.sendBroadcast(IAction.Server.ACTION_SERVER_WILL_BE_SHUTDOWN, exc);
            }
        }

        /* access modifiers changed from: protected */
        public void runInLoopThread() throws Exception {
            ClientImpl clientImpl = new ClientImpl(ServerManagerImpl.this.mServerSocket.accept(), ServerManagerImpl.this.mServerOptions);
            clientImpl.setClientPool(ServerManagerImpl.this.mClientPoolImpl);
            clientImpl.setServerStateSender(ServerManagerImpl.this);
            clientImpl.startIOEngine();
        }
    }

    private void checkCallStack() {
        boolean z2 = false;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getClassName().contains("ManagerHolder") && stackTraceElement.getMethodName().equals("getServer")) {
                z2 = true;
            }
        }
        if (!z2) {
            throw new IllegalAccessException("You can't call this method directly.This is privately function! ");
        }
    }

    private void configuration(ServerSocket serverSocket) {
    }

    public IClientPool<String, IClient> getClientPool() {
        return this.mClientPoolImpl;
    }

    public void initServerPrivate(int i2) {
        checkCallStack();
        if (this.isInit || this.mServerPort != -999) {
            SLog.e("duplicate init server manager!");
            return;
        }
        init(this);
        this.mServerPort = i2;
        this.mServerActionDispatcher.setServerPort(i2);
        this.isInit = true;
        SLog.w("server manager initiation");
    }

    public boolean isLive() {
        ServerSocket serverSocket;
        AbsLoopThread absLoopThread;
        if (!this.isInit || (serverSocket = this.mServerSocket) == null || serverSocket.isClosed() || (absLoopThread = this.mAcceptThread) == null || absLoopThread.isShutdown()) {
            return false;
        }
        return true;
    }

    public void shutdown() {
        if (this.mServerSocket != null) {
            ClientPoolImpl clientPoolImpl = this.mClientPoolImpl;
            if (clientPoolImpl != null) {
                clientPoolImpl.serverDown();
            }
            try {
                this.mServerSocket.close();
            } catch (IOException unused) {
            }
            this.mServerSocket = null;
            this.mClientPoolImpl = null;
            this.mAcceptThread.shutdown(new InitiativeDisconnectException());
            this.mAcceptThread = null;
            sendBroadcast(IAction.Server.ACTION_SERVER_ALLREADY_SHUTDOWN);
        }
    }

    public void listen() {
        if (this.mServerOptions == null) {
            this.mServerOptions = OkServerOptions.getDefault();
        }
        listen(this.mServerOptions);
    }

    public void listen(OkServerOptions okServerOptions) {
        if (okServerOptions != null) {
            try {
                this.mServerOptions = okServerOptions;
                ServerSocket serverSocket = new ServerSocket(this.mServerPort);
                this.mServerSocket = serverSocket;
                configuration(serverSocket);
                AcceptThread acceptThread = new AcceptThread("server accepting in " + this.mServerPort);
                this.mAcceptThread = acceptThread;
                acceptThread.start();
            } catch (Exception unused) {
                shutdown();
            }
        } else {
            throw new IllegalArgumentException("option can not be null");
        }
    }
}
