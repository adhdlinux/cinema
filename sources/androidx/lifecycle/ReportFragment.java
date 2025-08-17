package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

public class ReportFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private ActivityInitializationListener f3719b;

    interface ActivityInitializationListener {
        void onCreate();

        void onResume();

        void onStart();
    }

    static class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        LifecycleCallbacks() {
        }

        static void registerIn(Activity activity) {
            activity.registerActivityLifecycleCallbacks(new LifecycleCallbacks());
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            ReportFragment.a(activity, Lifecycle.Event.ON_CREATE);
        }

        public void onActivityPostResumed(Activity activity) {
            ReportFragment.a(activity, Lifecycle.Event.ON_RESUME);
        }

        public void onActivityPostStarted(Activity activity) {
            ReportFragment.a(activity, Lifecycle.Event.ON_START);
        }

        public void onActivityPreDestroyed(Activity activity) {
            ReportFragment.a(activity, Lifecycle.Event.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity activity) {
            ReportFragment.a(activity, Lifecycle.Event.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity activity) {
            ReportFragment.a(activity, Lifecycle.Event.ON_STOP);
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static void a(Activity activity, Lifecycle.Event event) {
        if (activity instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner) activity).getLifecycle().h(event);
        } else if (activity instanceof LifecycleOwner) {
            Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
            if (lifecycle instanceof LifecycleRegistry) {
                ((LifecycleRegistry) lifecycle).h(event);
            }
        }
    }

    private void b(Lifecycle.Event event) {
        if (Build.VERSION.SDK_INT < 29) {
            a(getActivity(), event);
        }
    }

    private void c(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onCreate();
        }
    }

    private void d(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onResume();
        }
    }

    private void e(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onStart();
        }
    }

    static ReportFragment f(Activity activity) {
        return (ReportFragment) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public static void g(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            LifecycleCallbacks.registerIn(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* access modifiers changed from: package-private */
    public void h(ActivityInitializationListener activityInitializationListener) {
        this.f3719b = activityInitializationListener;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        c(this.f3719b);
        b(Lifecycle.Event.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        b(Lifecycle.Event.ON_DESTROY);
        this.f3719b = null;
    }

    public void onPause() {
        super.onPause();
        b(Lifecycle.Event.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        d(this.f3719b);
        b(Lifecycle.Event.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        e(this.f3719b);
        b(Lifecycle.Event.ON_START);
    }

    public void onStop() {
        super.onStop();
        b(Lifecycle.Event.ON_STOP);
    }
}
