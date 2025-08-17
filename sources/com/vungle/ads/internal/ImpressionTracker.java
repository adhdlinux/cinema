package com.vungle.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import com.vungle.ads.internal.util.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class ImpressionTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MIN_VISIBILITY_PERCENTAGE = 1;
    private static final String TAG = ImpressionTracker.class.getSimpleName();
    private static final int VISIBILITY_THROTTLE_MILLIS = 100;
    private final Rect clipRect;
    /* access modifiers changed from: private */
    public boolean isVisibilityScheduled;
    private final ViewTreeObserver.OnPreDrawListener onPreDrawListener;
    /* access modifiers changed from: private */
    public boolean setViewTreeObserverSucceed;
    /* access modifiers changed from: private */
    public final Map<View, TrackingInfo> trackedViews;
    private final Handler visibilityHandler;
    private final VisibilityRunnable visibilityRunnable;
    private WeakReference<ViewTreeObserver> weakViewTreeObserver;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface ImpressionListener {
        void onImpression(View view);

        void onViewInvisible(View view);
    }

    public static final class TrackingInfo {
        private ImpressionListener impressionListener;
        private int minViewablePercent;

        public final ImpressionListener getImpressionListener() {
            return this.impressionListener;
        }

        public final int getMinViewablePercent() {
            return this.minViewablePercent;
        }

        public final void setImpressionListener(ImpressionListener impressionListener2) {
            this.impressionListener = impressionListener2;
        }

        public final void setMinViewablePercent(int i2) {
            this.minViewablePercent = i2;
        }
    }

    public final class VisibilityRunnable implements Runnable {
        private final ArrayList<View> invisibleViews = new ArrayList<>();
        private final ArrayList<View> visibleViews = new ArrayList<>();

        public VisibilityRunnable() {
        }

        public void run() {
            ImpressionListener impressionListener;
            ImpressionListener impressionListener2;
            ImpressionTracker.this.isVisibilityScheduled = false;
            for (Map.Entry entry : ImpressionTracker.this.trackedViews.entrySet()) {
                View view = (View) entry.getKey();
                if (ImpressionTracker.this.isVisible(view, ((TrackingInfo) entry.getValue()).getMinViewablePercent())) {
                    this.visibleViews.add(view);
                } else {
                    this.invisibleViews.add(view);
                }
            }
            Iterator<View> it2 = this.visibleViews.iterator();
            while (it2.hasNext()) {
                View next = it2.next();
                TrackingInfo trackingInfo = (TrackingInfo) ImpressionTracker.this.trackedViews.get(next);
                if (!(trackingInfo == null || (impressionListener2 = trackingInfo.getImpressionListener()) == null)) {
                    impressionListener2.onImpression(next);
                }
                ImpressionTracker impressionTracker = ImpressionTracker.this;
                Intrinsics.e(next, "view");
                impressionTracker.removeView(next);
            }
            this.visibleViews.clear();
            Iterator<View> it3 = this.invisibleViews.iterator();
            while (it3.hasNext()) {
                View next2 = it3.next();
                TrackingInfo trackingInfo2 = (TrackingInfo) ImpressionTracker.this.trackedViews.get(next2);
                if (!(trackingInfo2 == null || (impressionListener = trackingInfo2.getImpressionListener()) == null)) {
                    impressionListener.onViewInvisible(next2);
                }
            }
            this.invisibleViews.clear();
            if ((!ImpressionTracker.this.trackedViews.isEmpty()) && !ImpressionTracker.this.setViewTreeObserverSucceed) {
                ImpressionTracker.this.scheduleVisibilityCheck();
            }
        }
    }

    public ImpressionTracker(Context context, Map<View, TrackingInfo> map, Handler handler) {
        Intrinsics.f(context, "context");
        Intrinsics.f(map, "trackedViews");
        Intrinsics.f(handler, "visibilityHandler");
        this.trackedViews = map;
        this.visibilityHandler = handler;
        this.clipRect = new Rect();
        this.visibilityRunnable = new VisibilityRunnable();
        this.onPreDrawListener = new a(this);
        this.weakViewTreeObserver = new WeakReference<>((Object) null);
        this.setViewTreeObserverSucceed = setViewTreeObserver(context, (View) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final boolean m150_init_$lambda0(ImpressionTracker impressionTracker) {
        Intrinsics.f(impressionTracker, "this$0");
        impressionTracker.scheduleVisibilityCheck();
        return true;
    }

    public static /* synthetic */ void getOnPreDrawListener$annotations() {
    }

    private final View getTopView(Context context, View view) {
        View view2;
        if (context instanceof Activity) {
            view2 = ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        } else {
            view2 = null;
        }
        if (view2 != null || view == null) {
            return view2;
        }
        if (!ViewCompat.U(view)) {
            Logger.Companion companion = Logger.Companion;
            String str = TAG;
            Intrinsics.e(str, "TAG");
            companion.w(str, "Trying to call View#rootView() on an unattached View.");
        }
        View rootView = view.getRootView();
        if (rootView != null) {
            view2 = rootView.findViewById(16908290);
        }
        if (view2 == null) {
            return rootView;
        }
        return view2;
    }

    public static /* synthetic */ void getWeakViewTreeObserver$annotations() {
    }

    /* access modifiers changed from: private */
    public final boolean isVisible(View view, int i2) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        while (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.getVisibility() != 0) {
                Logger.Companion companion = Logger.Companion;
                companion.w("ImpressionTracker", "Parent visibility is not visible: " + parent);
                return false;
            }
            parent = viewGroup.getParent();
        }
        if (!view.getGlobalVisibleRect(this.clipRect)) {
            return false;
        }
        long height = ((long) this.clipRect.height()) * ((long) this.clipRect.width());
        long height2 = ((long) view.getHeight()) * ((long) view.getWidth());
        if (height2 > 0 && ((long) 100) * height >= ((long) i2) * height2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void scheduleVisibilityCheck() {
        if (!this.isVisibilityScheduled) {
            this.isVisibilityScheduled = true;
            this.visibilityHandler.postDelayed(this.visibilityRunnable, 100);
        }
    }

    private final boolean setViewTreeObserver(Context context, View view) {
        ViewTreeObserver viewTreeObserver = this.weakViewTreeObserver.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            return true;
        }
        View topView = getTopView(context, view);
        if (topView == null) {
            Logger.Companion companion = Logger.Companion;
            String str = TAG;
            Intrinsics.e(str, "TAG");
            companion.d(str, "Unable to set ViewTreeObserver due to no available root view.");
            return false;
        }
        ViewTreeObserver viewTreeObserver2 = topView.getViewTreeObserver();
        if (!viewTreeObserver2.isAlive()) {
            Logger.Companion companion2 = Logger.Companion;
            String str2 = TAG;
            Intrinsics.e(str2, "TAG");
            companion2.d(str2, "The root view tree observer was not alive");
            return false;
        }
        this.weakViewTreeObserver = new WeakReference<>(viewTreeObserver2);
        viewTreeObserver2.addOnPreDrawListener(this.onPreDrawListener);
        return true;
    }

    public final void addView(View view, ImpressionListener impressionListener) {
        Intrinsics.f(view, "view");
        this.setViewTreeObserverSucceed = setViewTreeObserver(view.getContext(), view);
        TrackingInfo trackingInfo = this.trackedViews.get(view);
        if (trackingInfo == null) {
            trackingInfo = new TrackingInfo();
            this.trackedViews.put(view, trackingInfo);
            scheduleVisibilityCheck();
        }
        trackingInfo.setMinViewablePercent(1);
        trackingInfo.setImpressionListener(impressionListener);
    }

    public final void clear() {
        this.trackedViews.clear();
        this.visibilityHandler.removeMessages(0);
        this.isVisibilityScheduled = false;
    }

    public final void destroy() {
        clear();
        ViewTreeObserver viewTreeObserver = this.weakViewTreeObserver.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.onPreDrawListener);
        }
        this.weakViewTreeObserver.clear();
    }

    public final ViewTreeObserver.OnPreDrawListener getOnPreDrawListener() {
        return this.onPreDrawListener;
    }

    public final WeakReference<ViewTreeObserver> getWeakViewTreeObserver() {
        return this.weakViewTreeObserver;
    }

    public final void removeView(View view) {
        Intrinsics.f(view, "view");
        this.trackedViews.remove(view);
    }

    public final void setWeakViewTreeObserver(WeakReference<ViewTreeObserver> weakReference) {
        Intrinsics.f(weakReference, "<set-?>");
        this.weakViewTreeObserver = weakReference;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImpressionTracker(Context context) {
        this(context, new WeakHashMap(10), new Handler());
        Intrinsics.f(context, "context");
    }
}
