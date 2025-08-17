package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

class LifecycleDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicBoolean f3671a = new AtomicBoolean(false);

    static class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        DispatcherActivityCallback() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            ReportFragment.g(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    private LifecycleDispatcher() {
    }

    static void a(Context context) {
        if (!f3671a.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
        }
    }
}
