package com.facebook.react.views.scroll;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.FabricViewStateManager;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactOverflowViewWithInset;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReactHorizontalScrollView extends HorizontalScrollView implements ReactClippingViewGroup, FabricViewStateManager.HasFabricViewStateManager, ReactOverflowViewWithInset, ReactScrollViewHelper.HasScrollState, ReactScrollViewHelper.HasFlingAnimator, ReactScrollViewHelper.HasScrollEventThrottle {
    private static boolean DEBUG_MODE = false;
    private static int NO_SCROLL_POSITION = Integer.MIN_VALUE;
    private static String TAG = "ReactHorizontalScrollView";
    private static final int UNSET_CONTENT_OFFSET = -1;
    private static Field sScrollerField = null;
    private static boolean sTriedToGetScrollerField = false;
    private final ValueAnimator DEFAULT_FLING_ANIMATOR;
    /* access modifiers changed from: private */
    public boolean mActivelyScrolling;
    private Rect mClippingRect;
    private boolean mDisableIntervalMomentum;
    private boolean mDragging;
    private Drawable mEndBackground;
    private int mEndFillColor;
    private final FabricViewStateManager mFabricViewStateManager;
    private FpsListener mFpsListener;
    private long mLastScrollDispatchTime;
    private final OnScrollDispatchHelper mOnScrollDispatchHelper;
    private String mOverflow;
    private final Rect mOverflowInset;
    private boolean mPagedArrowScrolling;
    /* access modifiers changed from: private */
    public boolean mPagingEnabled;
    private PointerEvents mPointerEvents;
    /* access modifiers changed from: private */
    public Runnable mPostTouchRunnable;
    private ReactViewBackgroundManager mReactBackgroundManager;
    private final ReactScrollViewHelper.ReactScrollViewScrollState mReactScrollViewScrollState;
    private final Rect mRect;
    private boolean mRemoveClippedSubviews;
    /* access modifiers changed from: private */
    public boolean mScrollEnabled;
    private int mScrollEventThrottle;
    private String mScrollPerfTag;
    private int mScrollXAfterMeasure;
    private final OverScroller mScroller;
    /* access modifiers changed from: private */
    public boolean mSendMomentumEvents;
    private int mSnapInterval;
    private List<Integer> mSnapOffsets;
    private int mSnapToAlignment;
    private boolean mSnapToEnd;
    private boolean mSnapToStart;
    private final Rect mTempRect;
    private final VelocityHelper mVelocityHelper;
    private int pendingContentOffsetX;
    private int pendingContentOffsetY;

    public ReactHorizontalScrollView(Context context) {
        this(context, (FpsListener) null);
    }

    private void cancelPostTouchScrolling() {
        Runnable runnable = this.mPostTouchRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.mPostTouchRunnable = null;
            getFlingAnimator().cancel();
        }
    }

    /* access modifiers changed from: private */
    public void disableFpsListener() {
        if (isScrollPerfLoggingEnabled()) {
            Assertions.assertNotNull(this.mFpsListener);
            Assertions.assertNotNull(this.mScrollPerfTag);
            this.mFpsListener.disable(this.mScrollPerfTag);
        }
    }

    private void enableFpsListener() {
        if (isScrollPerfLoggingEnabled()) {
            Assertions.assertNotNull(this.mFpsListener);
            Assertions.assertNotNull(this.mScrollPerfTag);
            this.mFpsListener.enable(this.mScrollPerfTag);
        }
    }

    /* access modifiers changed from: private */
    public void flingAndSnap(int i2) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        OverScroller overScroller;
        int i9;
        int i10;
        if (DEBUG_MODE) {
            FLog.i(TAG, "smoothScrollAndSnap[%d] velocityX %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i2));
        }
        if (getChildCount() > 0) {
            if (this.mSnapInterval == 0 && this.mSnapOffsets == null && this.mSnapToAlignment == 0) {
                smoothScrollAndSnap(i2);
                return;
            }
            if (getFlingAnimator() != this.DEFAULT_FLING_ANIMATOR) {
                z2 = true;
            } else {
                z2 = false;
            }
            int max = Math.max(0, computeHorizontalScrollRange() - getWidth());
            int predictFinalScrollPosition = predictFinalScrollPosition(i2);
            if (this.mDisableIntervalMomentum) {
                predictFinalScrollPosition = getScrollX();
            }
            int width = (getWidth() - ViewCompat.I(this)) - ViewCompat.H(this);
            int layoutDirection = getReactScrollViewScrollState().getLayoutDirection();
            if (layoutDirection == 1) {
                predictFinalScrollPosition = max - predictFinalScrollPosition;
                i3 = -i2;
            } else {
                i3 = i2;
            }
            List<Integer> list = this.mSnapOffsets;
            if (list == null || list.isEmpty()) {
                int i11 = this.mSnapToAlignment;
                if (i11 != 0) {
                    int i12 = this.mSnapInterval;
                    if (i12 > 0) {
                        double d2 = ((double) predictFinalScrollPosition) / ((double) i12);
                        double floor = Math.floor(d2);
                        int i13 = this.mSnapInterval;
                        i5 = Math.max(getItemStartOffset(i11, (int) (floor * ((double) i13)), i13, width), 0);
                        int i14 = this.mSnapToAlignment;
                        double ceil = Math.ceil(d2);
                        int i15 = this.mSnapInterval;
                        i4 = Math.min(getItemStartOffset(i14, (int) (ceil * ((double) i15)), i15, width), max);
                    } else {
                        ViewGroup viewGroup = (ViewGroup) getContentView();
                        int i16 = max;
                        int i17 = i16;
                        int i18 = 0;
                        int i19 = 0;
                        for (int i20 = 0; i20 < viewGroup.getChildCount(); i20++) {
                            View childAt = viewGroup.getChildAt(i20);
                            int itemStartOffset = getItemStartOffset(this.mSnapToAlignment, childAt.getLeft(), childAt.getWidth(), width);
                            if (itemStartOffset <= predictFinalScrollPosition && predictFinalScrollPosition - itemStartOffset < predictFinalScrollPosition - i18) {
                                i18 = itemStartOffset;
                            }
                            if (itemStartOffset >= predictFinalScrollPosition && itemStartOffset - predictFinalScrollPosition < i17 - predictFinalScrollPosition) {
                                i17 = itemStartOffset;
                            }
                            i16 = Math.min(i16, itemStartOffset);
                            i19 = Math.max(i19, itemStartOffset);
                        }
                        int max2 = Math.max(i18, i16);
                        i4 = Math.min(i17, i19);
                        i6 = max;
                        i5 = max2;
                        i7 = 0;
                    }
                } else {
                    double snapInterval = (double) getSnapInterval();
                    double d3 = ((double) predictFinalScrollPosition) / snapInterval;
                    i5 = (int) (Math.floor(d3) * snapInterval);
                    i4 = Math.min((int) (Math.ceil(d3) * snapInterval), max);
                }
                i6 = max;
                i7 = 0;
            } else {
                i7 = this.mSnapOffsets.get(0).intValue();
                List<Integer> list2 = this.mSnapOffsets;
                i6 = list2.get(list2.size() - 1).intValue();
                i4 = max;
                i5 = 0;
                for (int i21 = 0; i21 < this.mSnapOffsets.size(); i21++) {
                    int intValue = this.mSnapOffsets.get(i21).intValue();
                    if (intValue <= predictFinalScrollPosition && predictFinalScrollPosition - intValue < predictFinalScrollPosition - i5) {
                        i5 = intValue;
                    }
                    if (intValue >= predictFinalScrollPosition && intValue - predictFinalScrollPosition < i4 - predictFinalScrollPosition) {
                        i4 = intValue;
                    }
                }
            }
            int i22 = predictFinalScrollPosition - i5;
            int i23 = i4 - predictFinalScrollPosition;
            if (Math.abs(i22) < Math.abs(i23)) {
                i8 = i5;
            } else {
                i8 = i4;
            }
            int scrollX = getScrollX();
            if (layoutDirection == 1) {
                scrollX = max - scrollX;
            }
            if (this.mSnapToEnd || predictFinalScrollPosition < i6) {
                if (this.mSnapToStart || predictFinalScrollPosition > i7) {
                    if (i3 > 0) {
                        if (!z2) {
                            i3 += (int) (((double) i23) * 10.0d);
                        }
                        predictFinalScrollPosition = i4;
                    } else if (i3 < 0) {
                        if (!z2) {
                            i3 -= (int) (((double) i22) * 10.0d);
                        }
                        predictFinalScrollPosition = i5;
                    } else {
                        predictFinalScrollPosition = i8;
                    }
                } else if (scrollX > i7) {
                    predictFinalScrollPosition = i7;
                }
            } else if (scrollX < i6) {
                predictFinalScrollPosition = i6;
            }
            int min = Math.min(Math.max(0, predictFinalScrollPosition), max);
            if (layoutDirection == 1) {
                min = max - min;
                i3 = -i3;
            }
            int i24 = min;
            if (z2 || (overScroller = this.mScroller) == null) {
                reactSmoothScrollTo(i24, getScrollY());
                return;
            }
            this.mActivelyScrolling = true;
            int scrollX2 = getScrollX();
            int scrollY = getScrollY();
            if (i3 != 0) {
                i9 = i3;
            } else {
                i9 = i24 - getScrollX();
            }
            if (i24 == 0 || i24 == max) {
                i10 = width / 2;
            } else {
                i10 = 0;
            }
            overScroller.fling(scrollX2, scrollY, i9, 0, i24, i24, 0, 0, i10, 0);
            postInvalidateOnAnimation();
        }
    }

    private View getContentView() {
        return getChildAt(0);
    }

    private int getItemStartOffset(int i2, int i3, int i4, int i5) {
        int i6;
        if (i2 == 1) {
            return i3;
        }
        if (i2 == 2) {
            i6 = (i5 - i4) / 2;
        } else if (i2 == 3) {
            i6 = i5 - i4;
        } else {
            throw new IllegalStateException("Invalid SnapToAlignment value: " + this.mSnapToAlignment);
        }
        return i3 - i6;
    }

    private OverScroller getOverScrollerFromParent() {
        if (!sTriedToGetScrollerField) {
            sTriedToGetScrollerField = true;
            try {
                Field declaredField = HorizontalScrollView.class.getDeclaredField("mScroller");
                sScrollerField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                FLog.w(TAG, "Failed to get mScroller field for HorizontalScrollView! This app will exhibit the bounce-back scrolling bug :(");
            }
        }
        Field field = sScrollerField;
        if (field == null) {
            return null;
        }
        try {
            Object obj = field.get(this);
            if (obj instanceof OverScroller) {
                return (OverScroller) obj;
            }
            FLog.w(TAG, "Failed to cast mScroller field in HorizontalScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
            return null;
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Failed to get mScroller from HorizontalScrollView!", e2);
        }
    }

    private int getScrollDelta(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        return computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
    }

    private int getSnapInterval() {
        int i2 = this.mSnapInterval;
        if (i2 != 0) {
            return i2;
        }
        return getWidth();
    }

    private void handlePostTouchScrolling(int i2, int i3) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "handlePostTouchScrolling[%d] velocityX %d velocityY %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i2), (Object) Integer.valueOf(i3));
        }
        if (this.mPostTouchRunnable == null) {
            if (this.mSendMomentumEvents) {
                ReactScrollViewHelper.emitScrollMomentumBeginEvent(this, i2, i3);
            }
            this.mActivelyScrolling = false;
            AnonymousClass2 r6 = new Runnable() {
                private boolean mRunning = true;
                private boolean mSnappingToPage = false;
                private int mStableFrames = 0;

                public void run() {
                    boolean z2;
                    if (ReactHorizontalScrollView.this.mActivelyScrolling) {
                        boolean unused = ReactHorizontalScrollView.this.mActivelyScrolling = false;
                        this.mStableFrames = 0;
                        this.mRunning = true;
                    } else {
                        ReactScrollViewHelper.updateFabricScrollState(ReactHorizontalScrollView.this);
                        int i2 = this.mStableFrames + 1;
                        this.mStableFrames = i2;
                        if (i2 < 3) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.mRunning = z2;
                        if (!ReactHorizontalScrollView.this.mPagingEnabled || this.mSnappingToPage) {
                            if (ReactHorizontalScrollView.this.mSendMomentumEvents) {
                                ReactScrollViewHelper.emitScrollMomentumEndEvent(ReactHorizontalScrollView.this);
                            }
                            ReactHorizontalScrollView.this.disableFpsListener();
                        } else {
                            this.mSnappingToPage = true;
                            ReactHorizontalScrollView.this.flingAndSnap(0);
                            ViewCompat.k0(ReactHorizontalScrollView.this, this, 20);
                        }
                    }
                    if (this.mRunning) {
                        ViewCompat.k0(ReactHorizontalScrollView.this, this, 20);
                    } else {
                        Runnable unused2 = ReactHorizontalScrollView.this.mPostTouchRunnable = null;
                    }
                }
            };
            this.mPostTouchRunnable = r6;
            ViewCompat.k0(this, r6, 20);
        }
    }

    private boolean isContentReady() {
        View contentView = getContentView();
        if (contentView == null || contentView.getWidth() == 0 || contentView.getHeight() == 0) {
            return false;
        }
        return true;
    }

    private boolean isMostlyScrolledInView(View view) {
        int scrollDelta = getScrollDelta(view);
        view.getDrawingRect(this.mTempRect);
        if (scrollDelta == 0 || Math.abs(scrollDelta) >= this.mTempRect.width() / 2) {
            return false;
        }
        return true;
    }

    private boolean isPartiallyScrolledInView(View view) {
        int scrollDelta = getScrollDelta(view);
        view.getDrawingRect(this.mTempRect);
        if (scrollDelta == 0 || Math.abs(scrollDelta) >= this.mTempRect.width()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.mScrollPerfTag;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isScrollPerfLoggingEnabled() {
        /*
            r1 = this;
            com.facebook.react.views.scroll.FpsListener r0 = r1.mFpsListener
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r1.mScrollPerfTag
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.ReactHorizontalScrollView.isScrollPerfLoggingEnabled():boolean");
    }

    private boolean isScrolledInView(View view) {
        return getScrollDelta(view) == 0;
    }

    private int predictFinalScrollPosition(int i2) {
        int max = Math.max(0, computeHorizontalScrollRange() - getWidth());
        if (getFlingAnimator() == this.DEFAULT_FLING_ANIMATOR) {
            return ReactScrollViewHelper.predictFinalScrollPosition(this, i2, 0, max, 0).x;
        }
        return getFlingExtrapolatedDistance(i2) + ReactScrollViewHelper.getNextFlingStartValue(this, getScrollX(), getReactScrollViewScrollState().getFinalAnimatedPositionScroll().x, i2);
    }

    private void scrollToChild(View view) {
        int scrollDelta = getScrollDelta(view);
        if (scrollDelta != 0) {
            scrollBy(scrollDelta, 0);
        }
    }

    private void setPendingContentOffsets(int i2, int i3) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "setPendingContentOffsets[%d] x %d y %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i2), (Object) Integer.valueOf(i3));
        }
        if (isContentReady()) {
            this.pendingContentOffsetX = -1;
            this.pendingContentOffsetY = -1;
            return;
        }
        this.pendingContentOffsetX = i2;
        this.pendingContentOffsetY = i3;
    }

    private void smoothScrollAndSnap(int i2) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "smoothScrollAndSnap[%d] velocity %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i2));
        }
        double snapInterval = (double) getSnapInterval();
        double nextFlingStartValue = (double) ReactScrollViewHelper.getNextFlingStartValue(this, getScrollX(), getReactScrollViewScrollState().getFinalAnimatedPositionScroll().x, i2);
        double d2 = nextFlingStartValue / snapInterval;
        int floor = (int) Math.floor(d2);
        int ceil = (int) Math.ceil(d2);
        int round = (int) Math.round(d2);
        int round2 = (int) Math.round(((double) predictFinalScrollPosition(i2)) / snapInterval);
        if (i2 > 0 && ceil == floor) {
            ceil++;
        } else if (i2 < 0 && floor == ceil) {
            floor--;
        }
        if (i2 > 0 && round < ceil && round2 > floor) {
            round = ceil;
        } else if (i2 < 0 && round > floor && round2 < ceil) {
            round = floor;
        }
        double d3 = ((double) round) * snapInterval;
        if (d3 != nextFlingStartValue) {
            this.mActivelyScrolling = true;
            reactSmoothScrollTo((int) d3, getScrollY());
        }
    }

    private void smoothScrollToNextPage(int i2) {
        int i3;
        if (DEBUG_MODE) {
            FLog.i(TAG, "smoothScrollToNextPage[%d] direction %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i2));
        }
        int width = getWidth();
        int scrollX = getScrollX();
        int i4 = scrollX / width;
        if (scrollX % width != 0) {
            i4++;
        }
        if (i2 == 17) {
            i3 = i4 - 1;
        } else {
            i3 = i4 + 1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        reactSmoothScrollTo(i3 * width, getScrollY());
        handlePostTouchScrolling(0, 0);
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (!this.mPagingEnabled || this.mPagedArrowScrolling) {
            super.addFocusables(arrayList, i2, i3);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        super.addFocusables(arrayList2, i2, i3);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            View view = (View) it2.next();
            if (isScrolledInView(view) || isPartiallyScrolledInView(view) || view.isFocused()) {
                arrayList.add(view);
            }
        }
    }

    public boolean arrowScroll(int i2) {
        if (!this.mPagingEnabled) {
            return super.arrowScroll(i2);
        }
        boolean z2 = true;
        this.mPagedArrowScrolling = true;
        if (getChildCount() > 0) {
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus(), i2);
            View contentView = getContentView();
            if (contentView == null || findNextFocus == null || findNextFocus.getParent() != contentView) {
                smoothScrollToNextPage(i2);
            } else {
                if (!isScrolledInView(findNextFocus) && !isMostlyScrolledInView(findNextFocus)) {
                    smoothScrollToNextPage(i2);
                }
                findNextFocus.requestFocus();
            }
        } else {
            z2 = false;
        }
        this.mPagedArrowScrolling = false;
        return z2;
    }

    public void draw(Canvas canvas) {
        if (this.mEndFillColor != 0) {
            View contentView = getContentView();
            if (!(this.mEndBackground == null || contentView == null || contentView.getRight() >= getWidth())) {
                this.mEndBackground.setBounds(contentView.getRight(), 0, getWidth(), getHeight());
                this.mEndBackground.draw(canvas);
            }
        }
        super.draw(canvas);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.mScrollEnabled || (keyCode != 21 && keyCode != 22)) {
            return super.executeKeyEvent(keyEvent);
        }
        return false;
    }

    public void flashScrollIndicators() {
        awakenScrollBars();
    }

    public void fling(int i2) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "fling[%d] velocityX %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i2));
        }
        int abs = (int) (((float) Math.abs(i2)) * Math.signum(this.mOnScrollDispatchHelper.getXFlingVelocity()));
        if (this.mPagingEnabled) {
            flingAndSnap(abs);
        } else if (this.mScroller != null) {
            int width = (getWidth() - ViewCompat.I(this)) - ViewCompat.H(this);
            this.mScroller.fling(getScrollX(), getScrollY(), abs, 0, 0, Integer.MAX_VALUE, 0, 0, width / 2, 0);
            ViewCompat.i0(this);
        } else {
            super.fling(abs);
        }
        handlePostTouchScrolling(abs, 0);
    }

    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        return super.getChildVisibleRect(view, rect, point);
    }

    public void getClippingRect(Rect rect) {
        rect.set((Rect) Assertions.assertNotNull(this.mClippingRect));
    }

    public FabricViewStateManager getFabricViewStateManager() {
        return this.mFabricViewStateManager;
    }

    public ValueAnimator getFlingAnimator() {
        return this.DEFAULT_FLING_ANIMATOR;
    }

    public int getFlingExtrapolatedDistance(int i2) {
        return ReactScrollViewHelper.predictFinalScrollPosition(this, i2, 0, Math.max(0, computeHorizontalScrollRange() - getWidth()), 0).x;
    }

    public long getLastScrollDispatchTime() {
        return this.mLastScrollDispatchTime;
    }

    public String getOverflow() {
        return this.mOverflow;
    }

    public Rect getOverflowInset() {
        return this.mOverflowInset;
    }

    public PointerEvents getPointerEvents() {
        return this.mPointerEvents;
    }

    public ReactScrollViewHelper.ReactScrollViewScrollState getReactScrollViewScrollState() {
        return this.mReactScrollViewScrollState;
    }

    public boolean getRemoveClippedSubviews() {
        return this.mRemoveClippedSubviews;
    }

    public int getScrollEventThrottle() {
        return this.mScrollEventThrottle;
    }

    /* access modifiers changed from: protected */
    public void handleInterceptedTouchEvent(MotionEvent motionEvent) {
        NativeGestureUtil.notifyNativeGestureStarted(this, motionEvent);
        ReactScrollViewHelper.emitScrollBeginDragEvent(this);
        this.mDragging = true;
        enableFpsListener();
        getFlingAnimator().cancel();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "onDraw[%d]", (Object) Integer.valueOf(getId()));
        }
        getDrawingRect(this.mRect);
        String str = this.mOverflow;
        str.hashCode();
        if (!str.equals(ViewProps.VISIBLE)) {
            canvas.clipRect(this.mRect);
        }
        super.onDraw(canvas);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        if (!PointerEvents.canChildrenBeTouchTarget(this.mPointerEvents)) {
            return true;
        }
        try {
            if (super.onInterceptTouchEvent(motionEvent)) {
                handleInterceptedTouchEvent(motionEvent);
                return true;
            }
        } catch (IllegalArgumentException e2) {
            FLog.w(ReactConstants.TAG, "Error intercepting touch event.", (Throwable) e2);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        OverScroller overScroller;
        if (DEBUG_MODE) {
            FLog.i(TAG, "onLayout[%d] l %d t %d r %d b %d", Integer.valueOf(getId()), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        }
        int i6 = this.mScrollXAfterMeasure;
        if (!(i6 == NO_SCROLL_POSITION || (overScroller = this.mScroller) == null || i6 == overScroller.getFinalX() || this.mScroller.isFinished())) {
            if (DEBUG_MODE) {
                FLog.i(TAG, "onLayout[%d] scroll hack enabled: reset to previous scrollX position of %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(this.mScrollXAfterMeasure));
            }
            OverScroller overScroller2 = this.mScroller;
            overScroller2.startScroll(this.mScrollXAfterMeasure, overScroller2.getFinalY(), 0, 0);
            this.mScroller.forceFinished(true);
            this.mScrollXAfterMeasure = NO_SCROLL_POSITION;
        }
        int i7 = this.pendingContentOffsetX;
        if (i7 == -1) {
            i7 = getScrollX();
        }
        int i8 = this.pendingContentOffsetY;
        if (i8 == -1) {
            i8 = getScrollY();
        }
        scrollTo(i7, i8);
        ReactScrollViewHelper.emitLayoutEvent(this);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z2;
        OverScroller overScroller;
        MeasureSpecAssertions.assertExplicitMeasureSpec(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (DEBUG_MODE) {
            FLog.i(TAG, "onMeasure[%d] measured width: %d measured height: %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(size), (Object) Integer.valueOf(size2));
        }
        if (getMeasuredHeight() != size2) {
            z2 = true;
        } else {
            z2 = false;
        }
        setMeasuredDimension(size, size2);
        if (z2 && (overScroller = this.mScroller) != null) {
            this.mScrollXAfterMeasure = overScroller.getCurrX();
        }
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
        int computeHorizontalScrollRange;
        if (DEBUG_MODE) {
            FLog.i(TAG, "onOverScrolled[%d] scrollX %d scrollY %d clampedX %b clampedY %b", Integer.valueOf(getId()), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z3));
        }
        OverScroller overScroller = this.mScroller;
        if (overScroller != null && !overScroller.isFinished() && this.mScroller.getCurrX() != this.mScroller.getFinalX() && i2 >= (computeHorizontalScrollRange = computeHorizontalScrollRange() - getWidth())) {
            this.mScroller.abortAnimation();
            i2 = computeHorizontalScrollRange;
        }
        super.onOverScrolled(i2, i3, z2, z3);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "onScrollChanged[%d] x %d y %d oldx %d oldy %d", Integer.valueOf(getId()), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        }
        super.onScrollChanged(i2, i3, i4, i5);
        this.mActivelyScrolling = true;
        if (this.mOnScrollDispatchHelper.onScrollChanged(i2, i3)) {
            if (this.mRemoveClippedSubviews) {
                updateClippingRect();
            }
            ReactScrollViewHelper.updateStateOnScrollChanged(this, this.mOnScrollDispatchHelper.getXFlingVelocity(), this.mOnScrollDispatchHelper.getYFlingVelocity());
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled || !PointerEvents.canBeTouchTarget(this.mPointerEvents)) {
            return false;
        }
        this.mVelocityHelper.calculateVelocity(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 && this.mDragging) {
            ReactScrollViewHelper.updateFabricScrollState(this);
            float xVelocity = this.mVelocityHelper.getXVelocity();
            float yVelocity = this.mVelocityHelper.getYVelocity();
            ReactScrollViewHelper.emitScrollEndDragEvent(this, xVelocity, yVelocity);
            this.mDragging = false;
            handlePostTouchScrolling(Math.round(xVelocity), Math.round(yVelocity));
        }
        if (actionMasked == 0) {
            cancelPostTouchScrolling();
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean pageScroll(int i2) {
        boolean pageScroll = super.pageScroll(i2);
        if (this.mPagingEnabled && pageScroll) {
            handlePostTouchScrolling(0, 0);
        }
        return pageScroll;
    }

    public void reactSmoothScrollTo(int i2, int i3) {
        ReactScrollViewHelper.smoothScrollTo(this, i2, i3);
        setPendingContentOffsets(i2, i3);
    }

    public void requestChildFocus(View view, View view2) {
        if (view2 != null && !this.mPagingEnabled) {
            scrollToChild(view2);
        }
        super.requestChildFocus(view, view2);
    }

    public void scrollTo(int i2, int i3) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "scrollTo[%d] x %d y %d", (Object) Integer.valueOf(getId()), (Object) Integer.valueOf(i2), (Object) Integer.valueOf(i3));
        }
        super.scrollTo(i2, i3);
        ReactScrollViewHelper.updateFabricScrollState(this);
        setPendingContentOffsets(i2, i3);
    }

    public void setBackgroundColor(int i2) {
        this.mReactBackgroundManager.setBackgroundColor(i2);
    }

    public void setBorderColor(int i2, float f2, float f3) {
        this.mReactBackgroundManager.setBorderColor(i2, f2, f3);
    }

    public void setBorderRadius(float f2) {
        this.mReactBackgroundManager.setBorderRadius(f2);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.setBorderStyle(str);
    }

    public void setBorderWidth(int i2, float f2) {
        this.mReactBackgroundManager.setBorderWidth(i2, f2);
    }

    public void setDecelerationRate(float f2) {
        getReactScrollViewScrollState().setDecelerationRate(f2);
        OverScroller overScroller = this.mScroller;
        if (overScroller != null) {
            overScroller.setFriction(1.0f - f2);
        }
    }

    public void setDisableIntervalMomentum(boolean z2) {
        this.mDisableIntervalMomentum = z2;
    }

    public void setEndFillColor(int i2) {
        if (i2 != this.mEndFillColor) {
            this.mEndFillColor = i2;
            this.mEndBackground = new ColorDrawable(this.mEndFillColor);
        }
    }

    public void setLastScrollDispatchTime(long j2) {
        this.mLastScrollDispatchTime = j2;
    }

    public void setOverflow(String str) {
        this.mOverflow = str;
        invalidate();
    }

    public void setOverflowInset(int i2, int i3, int i4, int i5) {
        this.mOverflowInset.set(i2, i3, i4, i5);
    }

    public void setPagingEnabled(boolean z2) {
        this.mPagingEnabled = z2;
    }

    public void setPointerEvents(PointerEvents pointerEvents) {
        this.mPointerEvents = pointerEvents;
    }

    public void setRemoveClippedSubviews(boolean z2) {
        if (z2 && this.mClippingRect == null) {
            this.mClippingRect = new Rect();
        }
        this.mRemoveClippedSubviews = z2;
        updateClippingRect();
    }

    public void setScrollEnabled(boolean z2) {
        this.mScrollEnabled = z2;
    }

    public void setScrollEventThrottle(int i2) {
        this.mScrollEventThrottle = i2;
    }

    public void setScrollPerfTag(String str) {
        this.mScrollPerfTag = str;
    }

    public void setSendMomentumEvents(boolean z2) {
        this.mSendMomentumEvents = z2;
    }

    public void setSnapInterval(int i2) {
        this.mSnapInterval = i2;
    }

    public void setSnapOffsets(List<Integer> list) {
        this.mSnapOffsets = list;
    }

    public void setSnapToAlignment(int i2) {
        this.mSnapToAlignment = i2;
    }

    public void setSnapToEnd(boolean z2) {
        this.mSnapToEnd = z2;
    }

    public void setSnapToStart(boolean z2) {
        this.mSnapToStart = z2;
    }

    public void startFlingAnimator(int i2, int i3) {
        this.DEFAULT_FLING_ANIMATOR.cancel();
        this.DEFAULT_FLING_ANIMATOR.setDuration((long) ReactScrollViewHelper.getDefaultScrollAnimationDuration(getContext())).setIntValues(new int[]{i2, i3});
        this.DEFAULT_FLING_ANIMATOR.start();
    }

    public void updateClippingRect() {
        if (this.mRemoveClippedSubviews) {
            Assertions.assertNotNull(this.mClippingRect);
            ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
            View contentView = getContentView();
            if (contentView instanceof ReactClippingViewGroup) {
                ((ReactClippingViewGroup) contentView).updateClippingRect();
            }
        }
    }

    public ReactHorizontalScrollView(Context context, FpsListener fpsListener) {
        super(context);
        this.mScrollXAfterMeasure = NO_SCROLL_POSITION;
        this.mOnScrollDispatchHelper = new OnScrollDispatchHelper();
        this.mVelocityHelper = new VelocityHelper();
        this.mRect = new Rect();
        this.mOverflowInset = new Rect();
        this.mOverflow = ViewProps.HIDDEN;
        this.mPagingEnabled = false;
        this.mScrollEnabled = true;
        this.mFpsListener = null;
        this.mEndFillColor = 0;
        this.mDisableIntervalMomentum = false;
        this.mSnapInterval = 0;
        this.mSnapToStart = true;
        this.mSnapToEnd = true;
        this.mSnapToAlignment = 0;
        this.mPagedArrowScrolling = false;
        this.pendingContentOffsetX = -1;
        this.pendingContentOffsetY = -1;
        this.mFabricViewStateManager = new FabricViewStateManager();
        this.DEFAULT_FLING_ANIMATOR = ObjectAnimator.ofInt(this, "scrollX", new int[]{0, 0});
        this.mPointerEvents = PointerEvents.AUTO;
        this.mLastScrollDispatchTime = 0;
        this.mScrollEventThrottle = 0;
        this.mTempRect = new Rect();
        this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
        this.mFpsListener = fpsListener;
        ViewCompat.r0(this, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setScrollable(ReactHorizontalScrollView.this.mScrollEnabled);
            }

            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.z0(ReactHorizontalScrollView.this.mScrollEnabled);
            }
        });
        this.mScroller = getOverScrollerFromParent();
        this.mReactScrollViewScrollState = new ReactScrollViewHelper.ReactScrollViewScrollState(I18nUtil.getInstance().isRTL(context) ? 1 : 0);
    }

    public void setBorderRadius(float f2, int i2) {
        this.mReactBackgroundManager.setBorderRadius(f2, i2);
    }
}
