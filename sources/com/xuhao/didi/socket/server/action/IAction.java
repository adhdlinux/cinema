package com.xuhao.didi.socket.server.action;

import com.xuhao.didi.core.iocore.interfaces.IOAction;

public interface IAction {

    public interface Client extends IOAction {
        public static final String ACTION_READ_THREAD_SHUTDOWN = "action_read_thread_shutdown";
        public static final String ACTION_READ_THREAD_START = "action_read_thread_start";
        public static final String ACTION_WRITE_THREAD_SHUTDOWN = "action_write_thread_shutdown";
        public static final String ACTION_WRITE_THREAD_START = "action_write_thread_start";
    }

    public interface Server {
        public static final String ACTION_CLIENT_CONNECTED = "action_client_connected";
        public static final String ACTION_CLIENT_DISCONNECTED = "action_client_disconnected";
        public static final String ACTION_SERVER_ALLREADY_SHUTDOWN = "action_server_allready_shutdown";
        public static final String ACTION_SERVER_LISTENING = "action_server_listening";
        public static final String ACTION_SERVER_WILL_BE_SHUTDOWN = "action_server_will_be_shutdown";
        public static final String SERVER_ACTION_DATA = "server_action_data";
    }
}
