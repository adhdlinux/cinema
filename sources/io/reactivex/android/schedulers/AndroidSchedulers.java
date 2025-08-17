package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import java.util.concurrent.Callable;

public final class AndroidSchedulers {

    /* renamed from: a  reason: collision with root package name */
    private static final Scheduler f38316a = RxAndroidPlugins.d(new Callable<Scheduler>() {
        /* renamed from: b */
        public Scheduler call() throws Exception {
            return MainHolder.f38317a;
        }
    });

    private static final class MainHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Scheduler f38317a = new HandlerScheduler(new Handler(Looper.getMainLooper()), false);

        private MainHolder() {
        }
    }

    private AndroidSchedulers() {
        throw new AssertionError("No instances.");
    }

    public static Scheduler a() {
        return RxAndroidPlugins.e(f38316a);
    }
}
