package com.xuhao.didi.socket.server.action;

import com.xuhao.didi.core.iocore.interfaces.IOAction;
import com.xuhao.didi.core.iocore.interfaces.ISendable;
import com.xuhao.didi.core.iocore.interfaces.IStateSender;
import com.xuhao.didi.core.pojo.OriginalData;
import java.io.Serializable;

public class ClientActionDispatcher implements IStateSender {
    private ClientActionListener mActionListener;

    public interface ClientActionListener {
        void onClientRead(OriginalData originalData);

        void onClientReadDead(Exception exc);

        void onClientReadReady();

        void onClientWrite(ISendable iSendable);

        void onClientWriteDead(Exception exc);

        void onClientWriteReady();
    }

    public ClientActionDispatcher(ClientActionListener clientActionListener) {
        this.mActionListener = clientActionListener;
    }

    private void dispatch(String str, Serializable serializable) {
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
            case -1121297674:
                if (str.equals("action_write_thread_start")) {
                    c2 = 2;
                    break;
                }
                break;
            case -542453077:
                if (str.equals("action_read_thread_shutdown")) {
                    c2 = 3;
                    break;
                }
                break;
            case 190576450:
                if (str.equals("action_write_thread_shutdown")) {
                    c2 = 4;
                    break;
                }
                break;
            case 2146005698:
                if (str.equals(IOAction.ACTION_WRITE_COMPLETE)) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                try {
                    this.mActionListener.onClientRead((OriginalData) serializable);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case 1:
                try {
                    this.mActionListener.onClientReadReady();
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case 2:
                try {
                    this.mActionListener.onClientWriteReady();
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case 3:
                try {
                    this.mActionListener.onClientReadDead((Exception) serializable);
                    return;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            case 4:
                try {
                    this.mActionListener.onClientWriteDead((Exception) serializable);
                    return;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
            case 5:
                try {
                    this.mActionListener.onClientWrite((ISendable) serializable);
                    return;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return;
                }
            default:
                return;
        }
    }

    public void sendBroadcast(String str, Serializable serializable) {
        if (this.mActionListener != null) {
            dispatch(str, serializable);
        }
    }

    public void sendBroadcast(String str) {
        sendBroadcast(str, (Serializable) null);
    }
}
