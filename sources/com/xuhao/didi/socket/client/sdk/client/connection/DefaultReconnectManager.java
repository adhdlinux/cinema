package com.xuhao.didi.socket.client.sdk.client.connection;

import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.xuhao.didi.core.utils.SLog;
import com.xuhao.didi.socket.client.sdk.client.ConnectionInfo;
import com.xuhao.didi.socket.common.interfaces.basic.AbsLoopThread;
import com.xuhao.didi.socket.common.interfaces.utils.ThreadUtils;

public class DefaultReconnectManager extends AbsReconnectionManager {
    private static final int MAX_CONNECTION_FAILED_TIMES = 12;
    private int mConnectionFailedTimes = 0;
    private volatile ReconnectTestingThread mReconnectTestingThread = new ReconnectTestingThread();

    private class ReconnectTestingThread extends AbsLoopThread {
        private long mReconnectTimeDelay;

        private ReconnectTestingThread() {
            this.mReconnectTimeDelay = NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
        }

        /* access modifiers changed from: protected */
        public void beforeLoop() throws Exception {
            super.beforeLoop();
            if (this.mReconnectTimeDelay < ((long) (DefaultReconnectManager.this.mConnectionManager.getOption().getConnectTimeoutSecond() * 1000))) {
                this.mReconnectTimeDelay = (long) (DefaultReconnectManager.this.mConnectionManager.getOption().getConnectTimeoutSecond() * 1000);
            }
        }

        /* access modifiers changed from: protected */
        public void loopFinish(Exception exc) {
        }

        /* access modifiers changed from: protected */
        public void runInLoopThread() throws Exception {
            if (DefaultReconnectManager.this.mDetach) {
                SLog.i("ReconnectionManager already detached by framework.We decide gave up this reconnection mission!");
                shutdown();
                return;
            }
            SLog.i("Reconnect after " + this.mReconnectTimeDelay + " mills ...");
            ThreadUtils.sleep(this.mReconnectTimeDelay);
            if (DefaultReconnectManager.this.mDetach) {
                SLog.i("ReconnectionManager already detached by framework.We decide gave up this reconnection mission!");
                shutdown();
            } else if (DefaultReconnectManager.this.mConnectionManager.isConnect()) {
                shutdown();
            } else if (!DefaultReconnectManager.this.mConnectionManager.getOption().isConnectionHolden()) {
                DefaultReconnectManager.this.detach();
                shutdown();
            } else {
                ConnectionInfo remoteConnectionInfo = DefaultReconnectManager.this.mConnectionManager.getRemoteConnectionInfo();
                SLog.i("Reconnect the server " + remoteConnectionInfo.getIp() + ":" + remoteConnectionInfo.getPort() + " ...");
                synchronized (DefaultReconnectManager.this.mConnectionManager) {
                    if (!DefaultReconnectManager.this.mConnectionManager.isConnect()) {
                        DefaultReconnectManager.this.mConnectionManager.connect();
                    } else {
                        shutdown();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isNeedReconnect(java.lang.Exception r6) {
        /*
            r5 = this;
            java.util.Set<java.lang.Class<? extends java.lang.Exception>> r0 = r5.mIgnoreDisconnectExceptionList
            monitor-enter(r0)
            r1 = 0
            if (r6 == 0) goto L_0x002b
            boolean r2 = r6 instanceof com.xuhao.didi.socket.client.impl.exceptions.ManuallyDisconnectException     // Catch:{ all -> 0x002d }
            if (r2 != 0) goto L_0x002b
            java.util.Set<java.lang.Class<? extends java.lang.Exception>> r2 = r5.mIgnoreDisconnectExceptionList     // Catch:{ all -> 0x002d }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x002d }
        L_0x0010:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x002d }
            if (r3 == 0) goto L_0x0028
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x002d }
            java.lang.Class r3 = (java.lang.Class) r3     // Catch:{ all -> 0x002d }
            java.lang.Class r4 = r6.getClass()     // Catch:{ all -> 0x002d }
            boolean r3 = r3.isAssignableFrom(r4)     // Catch:{ all -> 0x002d }
            if (r3 == 0) goto L_0x0010
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r1
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            r6 = 1
            return r6
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r1
        L_0x002d:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xuhao.didi.socket.client.sdk.client.connection.DefaultReconnectManager.isNeedReconnect(java.lang.Exception):boolean");
    }

    private void reconnectDelay() {
        synchronized (this.mReconnectTestingThread) {
            if (this.mReconnectTestingThread.isShutdown()) {
                this.mReconnectTestingThread.start();
            }
        }
    }

    private synchronized void resetThread() {
        if (this.mReconnectTestingThread != null) {
            this.mReconnectTestingThread.shutdown();
        }
    }

    public void detach() {
        super.detach();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass();
    }

    public void onSocketConnectionFailed(ConnectionInfo connectionInfo, String str, Exception exc) {
        if (exc != null) {
            int i2 = this.mConnectionFailedTimes + 1;
            this.mConnectionFailedTimes = i2;
            if (i2 > 12) {
                resetThread();
                ConnectionInfo remoteConnectionInfo = this.mConnectionManager.getRemoteConnectionInfo();
                ConnectionInfo backupInfo = remoteConnectionInfo.getBackupInfo();
                if (backupInfo != null) {
                    backupInfo.setBackupInfo(new ConnectionInfo(remoteConnectionInfo.getIp(), remoteConnectionInfo.getPort()));
                    if (!this.mConnectionManager.isConnect()) {
                        SLog.i("Prepare switch to the backup line " + backupInfo.getIp() + ":" + backupInfo.getPort() + " ...");
                        synchronized (this.mConnectionManager) {
                            this.mConnectionManager.switchConnectionInfo(backupInfo);
                        }
                        reconnectDelay();
                        return;
                    }
                    return;
                }
                reconnectDelay();
                return;
            }
            reconnectDelay();
        }
    }

    public void onSocketConnectionSuccess(ConnectionInfo connectionInfo, String str) {
        resetThread();
    }

    public void onSocketDisconnection(ConnectionInfo connectionInfo, String str, Exception exc) {
        if (isNeedReconnect(exc)) {
            reconnectDelay();
        } else {
            resetThread();
        }
    }
}
