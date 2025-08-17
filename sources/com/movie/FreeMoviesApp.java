package com.movie;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.multidex.MultiDex;
import com.ads.videoreward.AdsManager;
import com.facebook.soloader.SoLoader;
import com.google.gson.Gson;
import com.movie.data.api.GlobalVariable;
import com.movie.data.api.MoviesApi;
import com.movie.data.model.AppConfig;
import com.movie.data.model.MovieInfo;
import com.movie.data.model.cinema.SyncLink;
import com.movie.data.remotejs.MyReactApplication;
import com.original.tase.Logger;
import com.original.tase.model.media.MediaSource;
import com.original.tase.model.socket.UserResponces;
import com.utils.PrefUtils;
import com.utils.Utils;
import com.yoku.marumovie.R;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.inject.Inject;
import okhttp3.ResponseBody;

public final class FreeMoviesApp extends MyReactApplication implements LifecycleObserver {

    /* renamed from: g  reason: collision with root package name */
    private static boolean f31884g;

    /* renamed from: h  reason: collision with root package name */
    public static int f31885h = UserResponces.USER_RESPONCE_FAIL;

    /* renamed from: i  reason: collision with root package name */
    public static int f31886i = 403;

    /* renamed from: j  reason: collision with root package name */
    public static int f31887j = 402;
    @Inject

    /* renamed from: d  reason: collision with root package name */
    MoviesApi f31888d;

    /* renamed from: e  reason: collision with root package name */
    private CompositeDisposable f31889e;

    /* renamed from: f  reason: collision with root package name */
    private AppComponent f31890f;

    class AppLifecycleTracker implements Application.ActivityLifecycleCallbacks {

        /* renamed from: b  reason: collision with root package name */
        private int f31892b = 0;

        AppLifecycleTracker() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f31892b == 0) {
                FreeMoviesApp.this.o();
            }
            this.f31892b++;
        }

        public void onActivityStopped(Activity activity) {
            this.f31892b--;
        }
    }

    static {
        System.loadLibrary(Deobfuscator$app$ProductionRelease.a(-251706271805636L));
    }

    private void k(String str, int i2) {
    }

    public static FreeMoviesApp m(Context context) {
        return (FreeMoviesApp) context.getApplicationContext();
    }

    public static SharedPreferences p() {
        return PrefUtils.g(Utils.v());
    }

    private void q() {
        RxJavaPlugins.B(new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Exception {
                Logger.b(Deobfuscator$app$ProductionRelease.a(-251680502001860L), th.getMessage());
                th.printStackTrace();
            }
        });
    }

    public static boolean s() {
        return f31884g;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(AppConfig appConfig) throws Exception {
        if (appConfig != null && appConfig.getOs_type().contains(Deobfuscator$app$ProductionRelease.a(-251740631544004L))) {
            GlobalVariable.c().d(new Gson().u(appConfig));
            AppConfig b2 = GlobalVariable.c().b();
            k(b2.getUpdate().getLink(), b2.getUpdate().getVersionCode());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void u(ResponseBody responseBody) throws Exception {
    }

    private void w() {
        AppComponent b2 = DaggerAppComponent.a().a(new AppModule(this)).b();
        this.f31890f = b2;
        b2.t(this);
    }

    public static void x(CompositeDisposable compositeDisposable, MoviesApi moviesApi, MovieInfo movieInfo, ArrayList<MediaSource> arrayList) {
        boolean z2;
        if (movieInfo.tmdbID >= 1) {
            if (((double) GlobalVariable.c().b().getSync().getSync_rate()) >= Math.random() * 100.0d) {
                SyncLink syncLink = new SyncLink();
                syncLink.f31928i = String.valueOf(movieInfo.tmdbID);
                syncLink.f31929s = movieInfo.session;
                syncLink.f31927e = movieInfo.eps;
                syncLink.f31930v = String.valueOf(Utils.b0());
                syncLink.linkList = new ArrayList();
                int i2 = 4;
                if (4 > arrayList.size()) {
                    i2 = arrayList.size();
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    MediaSource mediaSource = arrayList.get(i3);
                    if (mediaSource.isNeedToSync() && (!mediaSource.isHLS() || mediaSource.getPlayHeader() == null)) {
                        Iterator<SyncLink.Link> it2 = syncLink.linkList.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (it2.next().f31933l.equals(mediaSource.getOriginalLink())) {
                                    z2 = true;
                                    break;
                                }
                            } else {
                                z2 = false;
                                break;
                            }
                        }
                        if (!z2 && !mediaSource.isCachedLink() && !Pattern.compile(Deobfuscator$app$ProductionRelease.a(-251611782525124L)).matcher(mediaSource.getOriginalLink()).find()) {
                            syncLink.linkList.add(mediaSource.convertToSynLink());
                        }
                    }
                }
                if (syncLink.linkList.size() > 0) {
                    compositeDisposable.b(moviesApi.syncLink(syncLink).subscribeOn(Schedulers.c()).subscribe(new b(), new c()));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        Utils.u0(this);
        MultiDex.l(this);
        q();
    }

    public AppComponent l() {
        return this.f31890f;
    }

    public CompositeDisposable n() {
        return this.f31889e;
    }

    public void o() {
        f31884g = p().getBoolean(Deobfuscator$app$ProductionRelease.a(-251547358015684L), false);
        this.f31889e.b(this.f31888d.getConfig().subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new d(this), new e()));
    }

    public void onCreate() {
        super.onCreate();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f31889e = compositeDisposable;
        Utils.j0(this, compositeDisposable);
        w();
        r();
        registerActivityLifecycleCallbacks(new AppLifecycleTracker());
        AdsManager.d().f();
        SoLoader.init((Context) this, false);
        ProcessLifecycleOwner.h().getLifecycle().a(this);
        getReactNativeHost().getReactInstanceManager().getCurrentReactContext();
    }

    public void onTerminate() {
        this.f31889e.dispose();
        super.onTerminate();
    }

    public void r() {
        if (Build.VERSION.SDK_INT >= 26) {
            String string = getString(R.string.notification_channel_id);
            String string2 = getString(R.string.notification_channel_name);
            String string3 = getString(R.string.notification_channel_description);
            NotificationChannel notificationChannel = new NotificationChannel(string, string2, 2);
            notificationChannel.setDescription(string3);
            String string4 = getString(R.string.app_update_notification_channel_id);
            String string5 = getString(R.string.app_update_notification_channel_name);
            String string6 = getString(R.string.app_update_notification_channel_description);
            NotificationChannel notificationChannel2 = new NotificationChannel(string4, string5, 2);
            notificationChannel2.setDescription(string6);
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannels(Arrays.asList(new NotificationChannel[]{notificationChannel, notificationChannel2}));
        }
    }

    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (Build.VERSION.SDK_INT < 34 || getApplicationInfo().targetSdkVersion < 34) {
            return super.registerReceiver(broadcastReceiver, intentFilter);
        }
        return super.registerReceiver(broadcastReceiver, intentFilter, 2);
    }
}
