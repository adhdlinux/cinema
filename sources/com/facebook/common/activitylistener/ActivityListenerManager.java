package com.facebook.common.activitylistener;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.lang.ref.WeakReference;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class ActivityListenerManager {

    private static class Listener extends BaseActivityListener {
        private final WeakReference<ActivityListener> mActivityListenerRef;

        public Listener(ActivityListener activityListener) {
            this.mActivityListenerRef = new WeakReference<>(activityListener);
        }

        private ActivityListener getListenerOrCleanUp(Activity activity) {
            ActivityListener activityListener = this.mActivityListenerRef.get();
            if (activityListener == null) {
                Preconditions.checkArgument(Boolean.valueOf(activity instanceof ListenableActivity));
                ((ListenableActivity) activity).removeActivityListener(this);
            }
            return activityListener;
        }

        public void onActivityCreate(Activity activity) {
            ActivityListener listenerOrCleanUp = getListenerOrCleanUp(activity);
            if (listenerOrCleanUp != null) {
                listenerOrCleanUp.onActivityCreate(activity);
            }
        }

        public void onDestroy(Activity activity) {
            ActivityListener listenerOrCleanUp = getListenerOrCleanUp(activity);
            if (listenerOrCleanUp != null) {
                listenerOrCleanUp.onDestroy(activity);
            }
        }

        public void onPause(Activity activity) {
            ActivityListener listenerOrCleanUp = getListenerOrCleanUp(activity);
            if (listenerOrCleanUp != null) {
                listenerOrCleanUp.onPause(activity);
            }
        }

        public void onResume(Activity activity) {
            ActivityListener listenerOrCleanUp = getListenerOrCleanUp(activity);
            if (listenerOrCleanUp != null) {
                listenerOrCleanUp.onResume(activity);
            }
        }

        public void onStart(Activity activity) {
            ActivityListener listenerOrCleanUp = getListenerOrCleanUp(activity);
            if (listenerOrCleanUp != null) {
                listenerOrCleanUp.onStart(activity);
            }
        }

        public void onStop(Activity activity) {
            ActivityListener listenerOrCleanUp = getListenerOrCleanUp(activity);
            if (listenerOrCleanUp != null) {
                listenerOrCleanUp.onStop(activity);
            }
        }
    }

    public static ListenableActivity getListenableActivity(Context context) {
        if (!(context instanceof ListenableActivity) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof ListenableActivity) {
            return (ListenableActivity) context;
        }
        return null;
    }

    public static void register(ActivityListener activityListener, Context context) {
        ListenableActivity listenableActivity = getListenableActivity(context);
        if (listenableActivity != null) {
            listenableActivity.addActivityListener(new Listener(activityListener));
        }
    }
}
