package com.xuhao.didi.socket.server.action;

import com.xuhao.didi.core.iocore.interfaces.IStateSender;
import com.xuhao.didi.socket.common.interfaces.basic.AbsLoopThread;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.dispatcher.IRegister;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IClient;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IClientPool;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IServerActionListener;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.server.IServerManager;
import com.xuhao.didi.socket.server.action.IAction;
import com.xuhao.didi.socket.server.impl.OkServerOptions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerActionDispatcher implements IRegister<IServerActionListener, IServerManager>, IStateSender {
    /* access modifiers changed from: private */
    public static final LinkedBlockingQueue<ActionBean> ACTION_QUEUE = new LinkedBlockingQueue<>();
    private static final DispatchThread HANDLE_THREAD;
    private volatile IClientPool<IClient, String> mClientPool;
    /* access modifiers changed from: private */
    public volatile List<IServerActionListener> mResponseHandlerList = new ArrayList();
    private volatile IServerManager<OkServerOptions> mServerManager;
    private volatile int mServerPort;

    protected static class ActionBean {
        Serializable arg;
        String mAction;
        ServerActionDispatcher mDispatcher;

        public ActionBean(String str, Serializable serializable, ServerActionDispatcher serverActionDispatcher) {
            this.mAction = str;
            this.arg = serializable;
            this.mDispatcher = serverActionDispatcher;
        }
    }

    private static class DispatchThread extends AbsLoopThread {
        public DispatchThread() {
            super("server_action_dispatch_thread");
        }

        /* access modifiers changed from: protected */
        public void loopFinish(Exception exc) {
        }

        /* access modifiers changed from: protected */
        public void runInLoopThread() throws Exception {
            ServerActionDispatcher serverActionDispatcher;
            ActionBean actionBean = (ActionBean) ServerActionDispatcher.ACTION_QUEUE.take();
            if (actionBean != null && (serverActionDispatcher = actionBean.mDispatcher) != null) {
                synchronized (serverActionDispatcher.mResponseHandlerList) {
                    for (IServerActionListener access$200 : new ArrayList(serverActionDispatcher.mResponseHandlerList)) {
                        serverActionDispatcher.dispatchActionToListener(actionBean.mAction, actionBean.arg, access$200);
                    }
                }
            }
        }
    }

    static {
        DispatchThread dispatchThread = new DispatchThread();
        HANDLE_THREAD = dispatchThread;
        dispatchThread.start();
    }

    public ServerActionDispatcher(IServerManager<OkServerOptions> iServerManager) {
        this.mServerManager = iServerManager;
    }

    /* access modifiers changed from: private */
    public void dispatchActionToListener(String str, Object obj, IServerActionListener iServerActionListener) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1742784898:
                if (str.equals(IAction.Server.ACTION_CLIENT_CONNECTED)) {
                    c2 = 0;
                    break;
                }
                break;
            case -745620826:
                if (str.equals(IAction.Server.ACTION_CLIENT_DISCONNECTED)) {
                    c2 = 1;
                    break;
                }
                break;
            case 876031064:
                if (str.equals(IAction.Server.ACTION_SERVER_WILL_BE_SHUTDOWN)) {
                    c2 = 2;
                    break;
                }
                break;
            case 1378049344:
                if (str.equals(IAction.Server.ACTION_SERVER_ALLREADY_SHUTDOWN)) {
                    c2 = 3;
                    break;
                }
                break;
            case 1855351208:
                if (str.equals(IAction.Server.ACTION_SERVER_LISTENING)) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                try {
                    iServerActionListener.onClientConnected((IClient) obj, this.mServerPort, this.mClientPool);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case 1:
                try {
                    iServerActionListener.onClientDisconnected((IClient) obj, this.mServerPort, this.mClientPool);
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case 2:
                try {
                    iServerActionListener.onServerWillBeShutdown(this.mServerPort, this.mServerManager, this.mClientPool, (Throwable) obj);
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case 3:
                try {
                    iServerActionListener.onServerAlreadyShutdown(this.mServerPort);
                    return;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            case 4:
                try {
                    iServerActionListener.onServerListening(this.mServerPort);
                    return;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
            default:
                return;
        }
    }

    public void sendBroadcast(String str, Serializable serializable) {
        ACTION_QUEUE.offer(new ActionBean(str, serializable, this));
    }

    public void setClientPool(IClientPool<IClient, String> iClientPool) {
        this.mClientPool = iClientPool;
    }

    public void setServerPort(int i2) {
        this.mServerPort = i2;
    }

    public IServerManager<OkServerOptions> registerReceiver(IServerActionListener iServerActionListener) {
        if (iServerActionListener != null) {
            synchronized (this.mResponseHandlerList) {
                if (!this.mResponseHandlerList.contains(iServerActionListener)) {
                    this.mResponseHandlerList.add(iServerActionListener);
                }
            }
        }
        return this.mServerManager;
    }

    public IServerManager<OkServerOptions> unRegisterReceiver(IServerActionListener iServerActionListener) {
        synchronized (this.mResponseHandlerList) {
            this.mResponseHandlerList.remove(iServerActionListener);
        }
        return this.mServerManager;
    }

    public void sendBroadcast(String str) {
        sendBroadcast(str, (Serializable) null);
    }
}
