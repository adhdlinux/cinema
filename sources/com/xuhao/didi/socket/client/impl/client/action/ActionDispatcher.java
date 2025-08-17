package com.xuhao.didi.socket.client.impl.client.action;

import com.xuhao.didi.core.iocore.interfaces.IOAction;
import com.xuhao.didi.core.iocore.interfaces.IPulseSendable;
import com.xuhao.didi.core.iocore.interfaces.ISendable;
import com.xuhao.didi.core.iocore.interfaces.IStateSender;
import com.xuhao.didi.core.pojo.OriginalData;
import com.xuhao.didi.core.utils.SLog;
import com.xuhao.didi.socket.client.sdk.client.ConnectionInfo;
import com.xuhao.didi.socket.client.sdk.client.OkSocketOptions;
import com.xuhao.didi.socket.client.sdk.client.action.IAction;
import com.xuhao.didi.socket.client.sdk.client.action.ISocketActionListener;
import com.xuhao.didi.socket.client.sdk.client.connection.IConnectionManager;
import com.xuhao.didi.socket.common.interfaces.basic.AbsLoopThread;
import com.xuhao.didi.socket.common.interfaces.common_interfacies.dispatcher.IRegister;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ActionDispatcher implements IRegister<ISocketActionListener, IConnectionManager>, IStateSender {
    /* access modifiers changed from: private */
    public static final LinkedBlockingQueue<ActionBean> ACTION_QUEUE = new LinkedBlockingQueue<>();
    private static final DispatchThread HANDLE_THREAD;
    private volatile ConnectionInfo mConnectionInfo;
    private volatile IConnectionManager mManager;
    /* access modifiers changed from: private */
    public volatile List<ISocketActionListener> mResponseHandlerList = new ArrayList();

    protected static class ActionBean {
        Serializable arg;
        String mAction;
        ActionDispatcher mDispatcher;

        public ActionBean(String str, Serializable serializable, ActionDispatcher actionDispatcher) {
            this.mAction = str;
            this.arg = serializable;
            this.mDispatcher = actionDispatcher;
        }
    }

    public static class ActionRunnable implements Runnable {
        private ActionBean mActionBean;

        ActionRunnable(ActionBean actionBean) {
            this.mActionBean = actionBean;
        }

        public void run() {
            ActionDispatcher actionDispatcher;
            ActionBean actionBean = this.mActionBean;
            if (actionBean != null && (actionDispatcher = actionBean.mDispatcher) != null) {
                synchronized (actionDispatcher.mResponseHandlerList) {
                    for (ISocketActionListener access$200 : new ArrayList(actionDispatcher.mResponseHandlerList)) {
                        ActionBean actionBean2 = this.mActionBean;
                        actionDispatcher.dispatchActionToListener(actionBean2.mAction, actionBean2.arg, access$200);
                    }
                }
            }
        }
    }

    private static class DispatchThread extends AbsLoopThread {
        public DispatchThread() {
            super("client_action_dispatch_thread");
        }

        /* access modifiers changed from: protected */
        public void loopFinish(Exception exc) {
        }

        /* access modifiers changed from: protected */
        public void runInLoopThread() throws Exception {
            ActionDispatcher actionDispatcher;
            ActionBean actionBean = (ActionBean) ActionDispatcher.ACTION_QUEUE.take();
            if (actionBean != null && (actionDispatcher = actionBean.mDispatcher) != null) {
                synchronized (actionDispatcher.mResponseHandlerList) {
                    for (ISocketActionListener access$200 : new ArrayList(actionDispatcher.mResponseHandlerList)) {
                        actionDispatcher.dispatchActionToListener(actionBean.mAction, actionBean.arg, access$200);
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

    public ActionDispatcher(ConnectionInfo connectionInfo, IConnectionManager iConnectionManager) {
        this.mManager = iConnectionManager;
        this.mConnectionInfo = connectionInfo;
    }

    /* access modifiers changed from: private */
    public void dispatchActionToListener(String str, Serializable serializable, ISocketActionListener iSocketActionListener) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1455248519:
                if (str.equals(IOAction.ACTION_READ_COMPLETE)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1321574355:
                if (str.equals("action_read_thread_start")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1245920523:
                if (str.equals(IAction.ACTION_CONNECTION_FAILED)) {
                    c2 = 2;
                    break;
                }
                break;
            case -1201839197:
                if (str.equals(IAction.ACTION_DISCONNECTION)) {
                    c2 = 3;
                    break;
                }
                break;
            case -1121297674:
                if (str.equals("action_write_thread_start")) {
                    c2 = 4;
                    break;
                }
                break;
            case -749410229:
                if (str.equals(IAction.ACTION_CONNECTION_SUCCESS)) {
                    c2 = 5;
                    break;
                }
                break;
            case -542453077:
                if (str.equals("action_read_thread_shutdown")) {
                    c2 = 6;
                    break;
                }
                break;
            case 190576450:
                if (str.equals("action_write_thread_shutdown")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1756120480:
                if (str.equals(IOAction.ACTION_PULSE_REQUEST)) {
                    c2 = 8;
                    break;
                }
                break;
            case 2146005698:
                if (str.equals(IOAction.ACTION_WRITE_COMPLETE)) {
                    c2 = 9;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                try {
                    iSocketActionListener.onSocketReadResponse(this.mConnectionInfo, str, (OriginalData) serializable);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case 1:
            case 4:
                try {
                    iSocketActionListener.onSocketIOThreadStart(str);
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case 2:
                try {
                    iSocketActionListener.onSocketConnectionFailed(this.mConnectionInfo, str, (Exception) serializable);
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case 3:
                try {
                    iSocketActionListener.onSocketDisconnection(this.mConnectionInfo, str, (Exception) serializable);
                    return;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            case 5:
                try {
                    iSocketActionListener.onSocketConnectionSuccess(this.mConnectionInfo, str);
                    return;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
            case 6:
            case 7:
                try {
                    iSocketActionListener.onSocketIOThreadShutdown(str, (Exception) serializable);
                    return;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return;
                }
            case 8:
                try {
                    iSocketActionListener.onPulseSend(this.mConnectionInfo, (IPulseSendable) serializable);
                    return;
                } catch (Exception e8) {
                    e8.printStackTrace();
                    return;
                }
            case 9:
                try {
                    iSocketActionListener.onSocketWriteResponse(this.mConnectionInfo, str, (ISendable) serializable);
                    return;
                } catch (Exception e9) {
                    e9.printStackTrace();
                    return;
                }
            default:
                return;
        }
    }

    public void sendBroadcast(String str, Serializable serializable) {
        OkSocketOptions option = this.mManager.getOption();
        if (option != null) {
            OkSocketOptions.ThreadModeToken callbackThreadModeToken = option.getCallbackThreadModeToken();
            if (callbackThreadModeToken != null) {
                try {
                    callbackThreadModeToken.handleCallbackEvent(new ActionRunnable(new ActionBean(str, serializable, this)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (option.isCallbackInIndependentThread()) {
                ACTION_QUEUE.offer(new ActionBean(str, serializable, this));
            } else if (!option.isCallbackInIndependentThread()) {
                synchronized (this.mResponseHandlerList) {
                    for (ISocketActionListener dispatchActionToListener : new ArrayList(this.mResponseHandlerList)) {
                        dispatchActionToListener(str, serializable, dispatchActionToListener);
                    }
                }
            } else {
                SLog.e("ActionDispatcher error action:" + str + " is not dispatch");
            }
        }
    }

    public void setConnectionInfo(ConnectionInfo connectionInfo) {
        this.mConnectionInfo = connectionInfo;
    }

    public IConnectionManager registerReceiver(ISocketActionListener iSocketActionListener) {
        if (iSocketActionListener != null) {
            synchronized (this.mResponseHandlerList) {
                if (!this.mResponseHandlerList.contains(iSocketActionListener)) {
                    this.mResponseHandlerList.add(iSocketActionListener);
                }
            }
        }
        return this.mManager;
    }

    public IConnectionManager unRegisterReceiver(ISocketActionListener iSocketActionListener) {
        if (iSocketActionListener != null) {
            synchronized (this.mResponseHandlerList) {
                this.mResponseHandlerList.remove(iSocketActionListener);
            }
        }
        return this.mManager;
    }

    public void sendBroadcast(String str) {
        sendBroadcast(str, (Serializable) null);
    }
}
