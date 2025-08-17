package com.vungle.ads.internal.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vungle.ads.internal.ui.PresenterAdOpenCallback;
import com.vungle.ads.internal.util.Logger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class ActivityManager implements Application.ActivityLifecycleCallbacks {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "ActivityManager";
    /* access modifiers changed from: private */
    public static final ActivityManager instance = new ActivityManager();
    private final CopyOnWriteArraySet<LifeCycleCallback> callbacks = new CopyOnWriteArraySet<>();
    private final AtomicBoolean inBackground = new AtomicBoolean(false);
    private AtomicBoolean isInitialized = new AtomicBoolean(false);
    private String lastStoppedActivityName;
    private final CopyOnWriteArraySet<String> startedActivities = new CopyOnWriteArraySet<>();
    /* access modifiers changed from: private */
    public TargetActivityInfo targetActivityInfo;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getInstance$vungle_ads_release$annotations() {
        }

        private final boolean startActivityHandleException(Context context, Intent intent, Intent intent2, PresenterAdOpenCallback presenterAdOpenCallback) {
            if (intent == null && intent2 == null) {
                return false;
            }
            if (intent != null) {
                try {
                    context.startActivity(intent);
                    if (presenterAdOpenCallback != null) {
                        presenterAdOpenCallback.onDeeplinkClick(true);
                    }
                } catch (Exception e2) {
                    Logger.Companion companion = Logger.Companion;
                    companion.e(ActivityManager.TAG, "Cannot launch/find activity to handle the Implicit intent: " + e2);
                    if (!(intent == null || presenterAdOpenCallback == null)) {
                        try {
                            presenterAdOpenCallback.onDeeplinkClick(false);
                        } catch (Exception unused) {
                            return false;
                        }
                    }
                    if (intent != null) {
                        if (intent2 != null) {
                            context.startActivity(intent2);
                        }
                    }
                    return false;
                }
            } else {
                context.startActivity(intent2);
            }
            return true;
        }

        public final void addLifecycleListener(LifeCycleCallback lifeCycleCallback) {
            Intrinsics.f(lifeCycleCallback, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            getInstance$vungle_ads_release().addListener(lifeCycleCallback);
        }

        public final void deInit(Context context) {
            Intrinsics.f(context, "context");
            getInstance$vungle_ads_release().deInit$vungle_ads_release(context);
        }

        public final ActivityManager getInstance$vungle_ads_release() {
            return ActivityManager.instance;
        }

        public final void init(Context context) {
            Intrinsics.f(context, "context");
            getInstance$vungle_ads_release().init(context);
        }

        public final boolean isForeground() {
            return getInstance$vungle_ads_release().isAppInForeground();
        }

        public final boolean startWhenForeground(Context context, Intent intent, Intent intent2, PresenterAdOpenCallback presenterAdOpenCallback) {
            Intrinsics.f(context, "context");
            if (isForeground()) {
                return startActivityHandleException(context, intent, intent2, presenterAdOpenCallback);
            }
            getInstance$vungle_ads_release().targetActivityInfo = new TargetActivityInfo(new WeakReference(context), intent, intent2, presenterAdOpenCallback);
            return false;
        }
    }

    public static class LifeCycleCallback {
        public void onBackground() {
        }

        public void onForeground() {
        }
    }

    private static final class TargetActivityInfo {
        private final PresenterAdOpenCallback adOpenCallback;
        private final WeakReference<Context> context;
        private final Intent deepLinkOverrideIntent;
        private final Intent defaultIntent;

        public TargetActivityInfo(WeakReference<Context> weakReference, Intent intent, Intent intent2, PresenterAdOpenCallback presenterAdOpenCallback) {
            Intrinsics.f(weakReference, "context");
            this.context = weakReference;
            this.deepLinkOverrideIntent = intent;
            this.defaultIntent = intent2;
            this.adOpenCallback = presenterAdOpenCallback;
        }

        public static /* synthetic */ TargetActivityInfo copy$default(TargetActivityInfo targetActivityInfo, WeakReference<Context> weakReference, Intent intent, Intent intent2, PresenterAdOpenCallback presenterAdOpenCallback, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                weakReference = targetActivityInfo.context;
            }
            if ((i2 & 2) != 0) {
                intent = targetActivityInfo.deepLinkOverrideIntent;
            }
            if ((i2 & 4) != 0) {
                intent2 = targetActivityInfo.defaultIntent;
            }
            if ((i2 & 8) != 0) {
                presenterAdOpenCallback = targetActivityInfo.adOpenCallback;
            }
            return targetActivityInfo.copy(weakReference, intent, intent2, presenterAdOpenCallback);
        }

        public final WeakReference<Context> component1() {
            return this.context;
        }

        public final Intent component2() {
            return this.deepLinkOverrideIntent;
        }

        public final Intent component3() {
            return this.defaultIntent;
        }

        public final PresenterAdOpenCallback component4() {
            return this.adOpenCallback;
        }

        public final TargetActivityInfo copy(WeakReference<Context> weakReference, Intent intent, Intent intent2, PresenterAdOpenCallback presenterAdOpenCallback) {
            Intrinsics.f(weakReference, "context");
            return new TargetActivityInfo(weakReference, intent, intent2, presenterAdOpenCallback);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TargetActivityInfo)) {
                return false;
            }
            TargetActivityInfo targetActivityInfo = (TargetActivityInfo) obj;
            return Intrinsics.a(this.context, targetActivityInfo.context) && Intrinsics.a(this.deepLinkOverrideIntent, targetActivityInfo.deepLinkOverrideIntent) && Intrinsics.a(this.defaultIntent, targetActivityInfo.defaultIntent) && Intrinsics.a(this.adOpenCallback, targetActivityInfo.adOpenCallback);
        }

        public final PresenterAdOpenCallback getAdOpenCallback() {
            return this.adOpenCallback;
        }

        public final WeakReference<Context> getContext() {
            return this.context;
        }

        public final Intent getDeepLinkOverrideIntent() {
            return this.deepLinkOverrideIntent;
        }

        public final Intent getDefaultIntent() {
            return this.defaultIntent;
        }

        public int hashCode() {
            int hashCode = this.context.hashCode() * 31;
            Intent intent = this.deepLinkOverrideIntent;
            int i2 = 0;
            int hashCode2 = (hashCode + (intent == null ? 0 : intent.hashCode())) * 31;
            Intent intent2 = this.defaultIntent;
            int hashCode3 = (hashCode2 + (intent2 == null ? 0 : intent2.hashCode())) * 31;
            PresenterAdOpenCallback presenterAdOpenCallback = this.adOpenCallback;
            if (presenterAdOpenCallback != null) {
                i2 = presenterAdOpenCallback.hashCode();
            }
            return hashCode3 + i2;
        }

        public String toString() {
            return "TargetActivityInfo(context=" + this.context + ", deepLinkOverrideIntent=" + this.deepLinkOverrideIntent + ", defaultIntent=" + this.defaultIntent + ", adOpenCallback=" + this.adOpenCallback + ')';
        }
    }

    private ActivityManager() {
    }

    /* access modifiers changed from: private */
    public final void init(Context context) {
        if (!this.isInitialized.getAndSet(true)) {
            try {
                ThreadUtil.INSTANCE.runOnUiThread(new a(context, this));
            } catch (Exception e2) {
                Logger.Companion.e(TAG, "Error initializing ActivityManager", e2);
                this.isInitialized.set(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-0  reason: not valid java name */
    public static final void m222init$lambda0(Context context, ActivityManager activityManager) {
        Intrinsics.f(context, "$context");
        Intrinsics.f(activityManager, "this$0");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(activityManager);
    }

    private final boolean isAppForeground() {
        return !this.startedActivities.isEmpty();
    }

    /* access modifiers changed from: private */
    public final boolean isAppInForeground() {
        if (!this.isInitialized.get() || this.lastStoppedActivityName == null || isAppForeground()) {
            return true;
        }
        return false;
    }

    public final void addListener(LifeCycleCallback lifeCycleCallback) {
        Intrinsics.f(lifeCycleCallback, "callback");
        this.callbacks.add(lifeCycleCallback);
    }

    public final void deInit$vungle_ads_release(Context context) {
        Intrinsics.f(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).unregisterActivityLifecycleCallbacks(this);
        this.startedActivities.clear();
        this.isInitialized.set(false);
        this.callbacks.clear();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.f(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.f(activity, "activity");
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.f(activity, "activity");
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.f(activity, "activity");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.f(activity, "activity");
        Intrinsics.f(bundle, "outState");
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.f(activity, "activity");
        this.startedActivities.add(activity.toString());
        if (this.inBackground.getAndSet(false)) {
            Iterator<LifeCycleCallback> it2 = this.callbacks.iterator();
            while (it2.hasNext()) {
                it2.next().onForeground();
            }
            TargetActivityInfo targetActivityInfo2 = this.targetActivityInfo;
            if (targetActivityInfo2 != null) {
                Context context = targetActivityInfo2.getContext().get();
                if (context != null) {
                    Companion.startWhenForeground(context, targetActivityInfo2.getDeepLinkOverrideIntent(), targetActivityInfo2.getDefaultIntent(), targetActivityInfo2.getAdOpenCallback());
                }
                this.targetActivityInfo = null;
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.f(activity, "activity");
        this.lastStoppedActivityName = activity.toString();
        this.startedActivities.remove(activity.toString());
        boolean isAppInForeground = isAppInForeground();
        this.inBackground.set(!isAppInForeground);
        if (!isAppInForeground) {
            Iterator<LifeCycleCallback> it2 = this.callbacks.iterator();
            while (it2.hasNext()) {
                it2.next().onBackground();
            }
        }
    }
}
