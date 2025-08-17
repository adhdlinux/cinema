package com.facebook.react.views.scroll;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.uimanager.FabricViewStateManager;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class ReactScrollViewHelper {
    public static final String AUTO = "auto";
    private static final String CONTENT_OFFSET_LEFT = "contentOffsetLeft";
    private static final String CONTENT_OFFSET_TOP = "contentOffsetTop";
    private static boolean DEBUG_MODE = false;
    public static final long MOMENTUM_DELAY = 20;
    public static final String OVER_SCROLL_ALWAYS = "always";
    public static final String OVER_SCROLL_NEVER = "never";
    private static final String SCROLL_AWAY_PADDING_TOP = "scrollAwayPaddingTop";
    private static int SMOOTH_SCROLL_DURATION = 250;
    public static final int SNAP_ALIGNMENT_CENTER = 2;
    public static final int SNAP_ALIGNMENT_DISABLED = 0;
    public static final int SNAP_ALIGNMENT_END = 3;
    public static final int SNAP_ALIGNMENT_START = 1;
    private static String TAG = ReactHorizontalScrollView.class.getSimpleName();
    private static boolean mSmoothScrollDurationInitialized = false;
    private static final Set<ScrollListener> sScrollListeners = Collections.newSetFromMap(new WeakHashMap());

    public interface HasFlingAnimator {
        ValueAnimator getFlingAnimator();

        int getFlingExtrapolatedDistance(int i2);

        void startFlingAnimator(int i2, int i3);
    }

    public interface HasScrollEventThrottle {
        long getLastScrollDispatchTime();

        int getScrollEventThrottle();

        void setLastScrollDispatchTime(long j2);

        void setScrollEventThrottle(int i2);
    }

    public interface HasScrollState {
        ReactScrollViewScrollState getReactScrollViewScrollState();
    }

    private static class OverScrollerDurationGetter extends OverScroller {
        private int mScrollAnimationDuration = 250;

        OverScrollerDurationGetter(Context context) {
            super(context);
        }

        public int getScrollAnimationDuration() {
            super.startScroll(0, 0, 0, 0);
            return this.mScrollAnimationDuration;
        }

        public void startScroll(int i2, int i3, int i4, int i5, int i6) {
            this.mScrollAnimationDuration = i6;
        }
    }

    public static class ReactScrollViewScrollState {
        private float mDecelerationRate = 0.985f;
        private final Point mFinalAnimatedPositionScroll = new Point();
        private boolean mIsCanceled = false;
        private boolean mIsFinished = true;
        private final Point mLastStateUpdateScroll = new Point(-1, -1);
        private final int mLayoutDirection;
        private int mScrollAwayPaddingTop = 0;

        public ReactScrollViewScrollState(int i2) {
            this.mLayoutDirection = i2;
        }

        public float getDecelerationRate() {
            return this.mDecelerationRate;
        }

        public Point getFinalAnimatedPositionScroll() {
            return this.mFinalAnimatedPositionScroll;
        }

        public boolean getIsCanceled() {
            return this.mIsCanceled;
        }

        public boolean getIsFinished() {
            return this.mIsFinished;
        }

        public Point getLastStateUpdateScroll() {
            return this.mLastStateUpdateScroll;
        }

        public int getLayoutDirection() {
            return this.mLayoutDirection;
        }

        public int getScrollAwayPaddingTop() {
            return this.mScrollAwayPaddingTop;
        }

        public ReactScrollViewScrollState setDecelerationRate(float f2) {
            this.mDecelerationRate = f2;
            return this;
        }

        public ReactScrollViewScrollState setFinalAnimatedPositionScroll(int i2, int i3) {
            this.mFinalAnimatedPositionScroll.set(i2, i3);
            return this;
        }

        public ReactScrollViewScrollState setIsCanceled(boolean z2) {
            this.mIsCanceled = z2;
            return this;
        }

        public ReactScrollViewScrollState setIsFinished(boolean z2) {
            this.mIsFinished = z2;
            return this;
        }

        public ReactScrollViewScrollState setLastStateUpdateScroll(int i2, int i3) {
            this.mLastStateUpdateScroll.set(i2, i3);
            return this;
        }

        public ReactScrollViewScrollState setScrollAwayPaddingTop(int i2) {
            this.mScrollAwayPaddingTop = i2;
            return this;
        }
    }

    public interface ScrollListener {
        void onLayout(ViewGroup viewGroup);

        void onScroll(ViewGroup viewGroup, ScrollEventType scrollEventType, float f2, float f3);
    }

    public static void addScrollListener(ScrollListener scrollListener) {
        sScrollListeners.add(scrollListener);
    }

    public static void emitLayoutEvent(ViewGroup viewGroup) {
        for (ScrollListener onLayout : sScrollListeners) {
            onLayout.onLayout(viewGroup);
        }
    }

    public static <T extends ViewGroup & HasScrollEventThrottle> void emitScrollBeginDragEvent(T t2) {
        emitScrollEvent(t2, ScrollEventType.BEGIN_DRAG);
    }

    public static <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEndDragEvent(T t2, float f2, float f3) {
        emitScrollEvent(t2, ScrollEventType.END_DRAG, f2, f3);
    }

    public static <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEvent(T t2, float f2, float f3) {
        emitScrollEvent(t2, ScrollEventType.SCROLL, f2, f3);
    }

    public static <T extends ViewGroup & HasScrollEventThrottle> void emitScrollMomentumBeginEvent(T t2, int i2, int i3) {
        emitScrollEvent(t2, ScrollEventType.MOMENTUM_BEGIN, (float) i2, (float) i3);
    }

    public static <T extends ViewGroup & HasScrollEventThrottle> void emitScrollMomentumEndEvent(T t2) {
        emitScrollEvent(t2, ScrollEventType.MOMENTUM_END);
    }

    public static <T extends ViewGroup & FabricViewStateManager.HasFabricViewStateManager & HasScrollState & HasFlingAnimator> void forceUpdateState(T t2) {
        int i2;
        ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) t2).getReactScrollViewScrollState();
        final int scrollAwayPaddingTop = reactScrollViewScrollState.getScrollAwayPaddingTop();
        Point lastStateUpdateScroll = reactScrollViewScrollState.getLastStateUpdateScroll();
        final int i3 = lastStateUpdateScroll.x;
        final int i4 = lastStateUpdateScroll.y;
        if (reactScrollViewScrollState.getLayoutDirection() == 1) {
            int i5 = 0;
            View childAt = t2.getChildAt(0);
            if (childAt != null) {
                i5 = childAt.getWidth();
            }
            i2 = -((i5 - i3) - t2.getWidth());
        } else {
            i2 = i3;
        }
        if (DEBUG_MODE) {
            FLog.i(TAG, "updateFabricScrollState[%d] scrollX %d scrollY %d fabricScrollX", (Object) Integer.valueOf(t2.getId()), (Object) Integer.valueOf(i3), (Object) Integer.valueOf(i4), (Object) Integer.valueOf(i2));
        }
        ((FabricViewStateManager.HasFabricViewStateManager) t2).getFabricViewStateManager().setState(new FabricViewStateManager.StateUpdateCallback() {
            public WritableMap getStateUpdate() {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putDouble(ReactScrollViewHelper.CONTENT_OFFSET_LEFT, (double) PixelUtil.toDIPFromPixel((float) i3));
                writableNativeMap.putDouble(ReactScrollViewHelper.CONTENT_OFFSET_TOP, (double) PixelUtil.toDIPFromPixel((float) i4));
                writableNativeMap.putDouble(ReactScrollViewHelper.SCROLL_AWAY_PADDING_TOP, (double) PixelUtil.toDIPFromPixel((float) scrollAwayPaddingTop));
                return writableNativeMap;
            }
        });
    }

    public static int getDefaultScrollAnimationDuration(Context context) {
        if (!mSmoothScrollDurationInitialized) {
            mSmoothScrollDurationInitialized = true;
            try {
                SMOOTH_SCROLL_DURATION = new OverScrollerDurationGetter(context).getScrollAnimationDuration();
            } catch (Throwable unused) {
            }
        }
        return SMOOTH_SCROLL_DURATION;
    }

    public static <T extends ViewGroup & FabricViewStateManager.HasFabricViewStateManager & HasScrollState & HasFlingAnimator> int getNextFlingStartValue(T t2, int i2, int i3, int i4) {
        int i5;
        ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) t2).getReactScrollViewScrollState();
        boolean z2 = false;
        if (i4 != 0) {
            i5 = i4 / Math.abs(i4);
        } else {
            i5 = 0;
        }
        if (i5 * (i3 - i2) > 0) {
            z2 = true;
        }
        if (!reactScrollViewScrollState.getIsFinished() || (reactScrollViewScrollState.getIsCanceled() && z2)) {
            return i3;
        }
        return i2;
    }

    public static int parseOverScrollMode(String str) {
        if (str == null || str.equals("auto")) {
            return 1;
        }
        if (str.equals(OVER_SCROLL_ALWAYS)) {
            return 0;
        }
        if (str.equals(OVER_SCROLL_NEVER)) {
            return 2;
        }
        throw new JSApplicationIllegalArgumentException("wrong overScrollMode: " + str);
    }

    public static int parseSnapToAlignment(String str) {
        if (str == null) {
            return 0;
        }
        if (ViewProps.START.equalsIgnoreCase(str)) {
            return 1;
        }
        if ("center".equalsIgnoreCase(str)) {
            return 2;
        }
        if (ViewProps.END.equals(str)) {
            return 3;
        }
        throw new JSApplicationIllegalArgumentException("wrong snap alignment value: " + str);
    }

    public static <T extends ViewGroup & FabricViewStateManager.HasFabricViewStateManager & HasScrollState & HasFlingAnimator> Point predictFinalScrollPosition(T t2, int i2, int i3, int i4, int i5) {
        ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) t2).getReactScrollViewScrollState();
        OverScroller overScroller = new OverScroller(t2.getContext());
        overScroller.setFriction(1.0f - reactScrollViewScrollState.getDecelerationRate());
        int width = (t2.getWidth() - ViewCompat.I(t2)) - ViewCompat.H(t2);
        int height = (t2.getHeight() - t2.getPaddingBottom()) - t2.getPaddingTop();
        Point finalAnimatedPositionScroll = reactScrollViewScrollState.getFinalAnimatedPositionScroll();
        int i6 = i2;
        overScroller.fling(getNextFlingStartValue(t2, t2.getScrollX(), finalAnimatedPositionScroll.x, i2), getNextFlingStartValue(t2, t2.getScrollY(), finalAnimatedPositionScroll.y, i3), i2, i3, 0, i4, 0, i5, width / 2, height / 2);
        return new Point(overScroller.getFinalX(), overScroller.getFinalY());
    }

    public static <T extends ViewGroup & FabricViewStateManager.HasFabricViewStateManager & HasScrollState & HasFlingAnimator> void registerFlingAnimator(final T t2) {
        ((HasFlingAnimator) t2).getFlingAnimator().addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
                ((HasScrollState) t2).getReactScrollViewScrollState().setIsCanceled(true);
            }

            public void onAnimationEnd(Animator animator) {
                ((HasScrollState) t2).getReactScrollViewScrollState().setIsFinished(true);
                ReactScrollViewHelper.updateFabricScrollState(t2);
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) t2).getReactScrollViewScrollState();
                reactScrollViewScrollState.setIsCanceled(false);
                reactScrollViewScrollState.setIsFinished(false);
            }
        });
    }

    public static void removeScrollListener(ScrollListener scrollListener) {
        sScrollListeners.remove(scrollListener);
    }

    public static <T extends ViewGroup & FabricViewStateManager.HasFabricViewStateManager & HasScrollState & HasFlingAnimator> void smoothScrollTo(T t2, int i2, int i3) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "smoothScrollTo[%d] x %d y %d", (Object) Integer.valueOf(t2.getId()), (Object) Integer.valueOf(i2), (Object) Integer.valueOf(i3));
        }
        ValueAnimator flingAnimator = ((HasFlingAnimator) t2).getFlingAnimator();
        if (flingAnimator.getListeners() == null || flingAnimator.getListeners().size() == 0) {
            registerFlingAnimator(t2);
        }
        ((HasScrollState) t2).getReactScrollViewScrollState().setFinalAnimatedPositionScroll(i2, i3);
        int scrollX = t2.getScrollX();
        int scrollY = t2.getScrollY();
        if (scrollX != i2) {
            ((HasFlingAnimator) t2).startFlingAnimator(scrollX, i2);
        }
        if (scrollY != i3) {
            ((HasFlingAnimator) t2).startFlingAnimator(scrollY, i3);
        }
        updateFabricScrollState(t2, i2, i3);
    }

    public static <T extends ViewGroup & FabricViewStateManager.HasFabricViewStateManager & HasScrollState & HasFlingAnimator> boolean updateFabricScrollState(T t2) {
        return updateFabricScrollState(t2, t2.getScrollX(), t2.getScrollY());
    }

    public static <T extends ViewGroup & FabricViewStateManager.HasFabricViewStateManager & HasScrollState & HasFlingAnimator & HasScrollEventThrottle> void updateStateOnScrollChanged(T t2, float f2, float f3) {
        updateFabricScrollState(t2);
        emitScrollEvent(t2, f2, f3);
    }

    private static <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEvent(T t2, ScrollEventType scrollEventType) {
        emitScrollEvent(t2, scrollEventType, 0.0f, 0.0f);
    }

    public static <T extends ViewGroup & FabricViewStateManager.HasFabricViewStateManager & HasScrollState & HasFlingAnimator> boolean updateFabricScrollState(T t2, int i2, int i3) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "updateFabricScrollState[%d] scrollX %d scrollY %d", (Object) Integer.valueOf(t2.getId()), (Object) Integer.valueOf(i2), (Object) Integer.valueOf(i3));
        }
        if (ViewUtil.getUIManagerType(t2.getId()) == 1) {
            return false;
        }
        ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) t2).getReactScrollViewScrollState();
        if (reactScrollViewScrollState.getLastStateUpdateScroll().equals(i2, i3)) {
            return false;
        }
        reactScrollViewScrollState.setLastStateUpdateScroll(i2, i3);
        forceUpdateState(t2);
        return true;
    }

    private static <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEvent(T t2, ScrollEventType scrollEventType, float f2, float f3) {
        T t3 = t2;
        long currentTimeMillis = System.currentTimeMillis();
        if (ReactFeatureFlags.enableScrollEventThrottle) {
            HasScrollEventThrottle hasScrollEventThrottle = (HasScrollEventThrottle) t3;
            if (((long) hasScrollEventThrottle.getScrollEventThrottle()) >= Math.max(17, currentTimeMillis - hasScrollEventThrottle.getLastScrollDispatchTime())) {
                return;
            }
        }
        View childAt = t3.getChildAt(0);
        if (childAt != null) {
            for (ScrollListener onScroll : sScrollListeners) {
                onScroll.onScroll(t3, scrollEventType, f2, f3);
            }
            ScrollEventType scrollEventType2 = scrollEventType;
            float f4 = f2;
            float f5 = f3;
            ReactContext reactContext = (ReactContext) t2.getContext();
            int surfaceId = UIManagerHelper.getSurfaceId((Context) reactContext);
            EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, t2.getId());
            if (eventDispatcherForReactTag != null) {
                eventDispatcherForReactTag.dispatchEvent(ScrollEvent.obtain(surfaceId, t2.getId(), scrollEventType, (float) t2.getScrollX(), (float) t2.getScrollY(), f2, f3, childAt.getWidth(), childAt.getHeight(), t2.getWidth(), t2.getHeight()));
                ((HasScrollEventThrottle) t3).setLastScrollDispatchTime(currentTimeMillis);
            }
        }
    }
}
