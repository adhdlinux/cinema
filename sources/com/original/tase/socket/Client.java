package com.original.tase.socket;

import android.app.Activity;
import com.ads.videoreward.AdsManager;
import com.facebook.ads.AudienceNetworkActivity;
import com.google.gson.Gson;
import com.movie.FreeMoviesApp;
import com.original.tase.I18N;
import com.original.tase.Logger;
import com.original.tase.model.socket.UserPlayerPluginInfo;
import com.original.tase.model.socket.UserResponces;
import com.utils.Utils;
import com.xuhao.didi.core.pojo.OriginalData;
import com.xuhao.didi.socket.client.sdk.OkSocket;
import com.xuhao.didi.socket.client.sdk.client.ConnectionInfo;
import com.xuhao.didi.socket.client.sdk.client.action.SocketActionAdapter;
import com.xuhao.didi.socket.client.sdk.client.connection.IConnectionManager;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    private static volatile Client mClient;
    public List<IConnectionManager> iConnectionManagerList = new ArrayList();
    boolean isresponce = false;
    private CompositeDisposable mSubscriptions = new CompositeDisposable();
    public IConnectionManager manager = null;
    /* access modifiers changed from: private */
    public String mdata = "";
    private int port = 19811;

    private Client() {
    }

    public static Client getIntance() {
        if (mClient == null) {
            synchronized (Client.class) {
                if (mClient == null) {
                    mClient = new Client();
                }
            }
        }
        return mClient;
    }

    public void autoconnect(final ObservableEmitter<String> observableEmitter) {
        String O = Utils.O();
        int lastIndexOf = O.lastIndexOf(".");
        String str = O.substring(0, lastIndexOf) + ".%s";
        this.isresponce = false;
        for (int i2 = 0; i2 <= 255; i2++) {
            IConnectionManager open = OkSocket.open(new ConnectionInfo(String.format(str, new Object[]{Integer.valueOf(i2)}), this.port));
            this.iConnectionManagerList.add(open);
            open.registerReceiver(new SocketActionAdapter() {
                public void onSocketConnectionFailed(ConnectionInfo connectionInfo, String str, Exception exc) {
                }

                public void onSocketConnectionSuccess(ConnectionInfo connectionInfo, String str) {
                    Logger.b("Client", connectionInfo.getIp().toString());
                    observableEmitter.onNext(connectionInfo.getIp());
                    Client.this.isresponce = true;
                }

                public void onSocketDisconnection(ConnectionInfo connectionInfo, String str, Exception exc) {
                    observableEmitter.onComplete();
                }

                public void onSocketReadResponse(ConnectionInfo connectionInfo, String str, OriginalData originalData) {
                }
            });
            open.connect();
        }
        while (!this.isresponce) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void connect(final ObservableEmitter<? super Object> observableEmitter, final String str) {
        IConnectionManager iConnectionManager = this.manager;
        if (iConnectionManager == null || !iConnectionManager.isConnect()) {
            IConnectionManager open = OkSocket.open(new ConnectionInfo(str, this.port));
            this.manager = open;
            open.registerReceiver(new SocketActionAdapter() {
                public void onSocketConnectionFailed(ConnectionInfo connectionInfo, String str, Exception exc) {
                    observableEmitter.onNext(new UserPlayerPluginInfo(connectionInfo.getIp(), str, false, ""));
                }

                public void onSocketConnectionSuccess(ConnectionInfo connectionInfo, String str) {
                    Logger.b("Client", connectionInfo.getIp().toString());
                    observableEmitter.onNext(new UserPlayerPluginInfo(connectionInfo.getIp(), str, true, ""));
                }

                public void onSocketDisconnection(ConnectionInfo connectionInfo, String str, Exception exc) {
                    observableEmitter.onComplete();
                }

                public void onSocketReadResponse(ConnectionInfo connectionInfo, String str, OriginalData originalData) {
                    byte[] bodyBytes = originalData.getBodyBytes();
                    String str2 = new String(Arrays.copyOfRange(bodyBytes, 0, bodyBytes.length), Charset.forName(AudienceNetworkActivity.WEBVIEW_ENCODING));
                    try {
                        UserResponces userResponces = (UserResponces) new Gson().l(str2, UserResponces.class);
                        if (userResponces != null) {
                            observableEmitter.onNext(userResponces);
                        }
                    } catch (Throwable unused) {
                    }
                    Logger.b("Client", str2);
                }
            });
            this.manager.connect();
            return;
        }
        observableEmitter.onNext(new UserPlayerPluginInfo(this.manager.getLocalConnectionInfo().getIp(), str, true, ""));
    }

    public Observable<Object> createObservable(final String str) {
        return Observable.create(new ObservableOnSubscribe<Object>() {
            public void setSubscriber(ObservableEmitter<? super Object> observableEmitter) {
                Client.this.connect(observableEmitter, str);
            }

            public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
                setSubscriber(observableEmitter);
            }
        });
    }

    public void disconnect() {
        IConnectionManager iConnectionManager = this.manager;
        if (iConnectionManager != null && iConnectionManager.isConnect()) {
            this.manager.disconnect();
        }
    }

    public void disconnectall() {
        Utils.O().lastIndexOf(".");
        this.isresponce = false;
        for (int i2 = 0; i2 < this.iConnectionManagerList.size(); i2++) {
            if (this.iConnectionManagerList.get(i2).isConnect()) {
                this.iConnectionManagerList.get(i2).disconnect();
            }
        }
        this.iConnectionManagerList.clear();
    }

    public boolean iconnected() {
        return this.manager.isConnect();
    }

    public void senddata(String str, final Activity activity) {
        this.mdata = str;
        this.mSubscriptions.b(getIntance().createObservable(FreeMoviesApp.p().getString("ip_player_plugin", "")).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new Consumer<Object>() {
            public void accept(Object obj) throws Exception {
                if (obj instanceof UserPlayerPluginInfo) {
                    UserPlayerPluginInfo userPlayerPluginInfo = (UserPlayerPluginInfo) obj;
                    if (userPlayerPluginInfo.iConnect) {
                        FreeMoviesApp.p().edit().putBoolean("use_player_plugin", true).apply();
                        FreeMoviesApp.p().edit().putString("ip_player_plugin", userPlayerPluginInfo.serverIP).apply();
                        if (!Client.this.mdata.isEmpty()) {
                            Client client = Client.this;
                            client.manager.send(new Data(client.mdata));
                            String unused = Client.this.mdata = "";
                        }
                    }
                } else if (obj instanceof UserResponces) {
                    UserResponces userResponces = (UserResponces) obj;
                    int i2 = userResponces.code;
                    if (i2 == 200) {
                        Utils.i0(activity, I18N.a(R.string.player_plugin_connected));
                        AdsManager.d().p(activity);
                    } else if (i2 == 404) {
                        Utils.i0(activity, I18N.a(R.string.player_plugin_try));
                    }
                    Logger.b("Client", "" + userResponces.code);
                }
            }
        }));
    }
}
