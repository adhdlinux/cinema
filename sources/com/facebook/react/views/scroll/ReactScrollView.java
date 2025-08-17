package com.facebook.react.views.scroll;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R;
import com.facebook.react.common.ReactConstants;
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
import java.util.List;

public class ReactScrollView extends ScrollView implements ReactClippingViewGroup, ViewGroup.OnHierarchyChangeListener, View.OnLayoutChangeListener, FabricViewStateManager.HasFabricViewStateManager, ReactOverflowViewWithInset, ReactScrollViewHelper.HasScrollState, ReactScrollViewHelper.HasFlingAnimator, ReactScrollViewHelper.HasScrollEventThrottle {
    private static final int UNSET_CONTENT_OFFSET = -1;
    private static Field sScrollerField = null;
    private static boolean sTriedToGetScrollerField = false;
    private final ValueAnimator DEFAULT_FLING_ANIMATOR;
    /* access modifiers changed from: private */
    public boolean mActivelyScrolling;
    private Rect mClippingRect;
    private View mContentView;
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
    /* access modifiers changed from: private */
    public boolean mPagingEnabled;
    private PointerEvents mPointerEvents;
    /* access modifiers changed from: private */
    public Runnable mPostTouchRunnable;
    private ReactViewBackgroundManager mReactBackgroundManager;
    private final ReactScrollViewHelper.ReactScrollViewScrollState mReactScrollViewScrollState;
    private final Rect mRect;
    private boolean mRemoveClippedSubviews;
    private boolean mScrollEnabled;
    private int mScrollEventThrottle;
    private String mScrollPerfTag;
    private final OverScroller mScroller;
    /* access modifiers changed from: private */
    public boolean mSendMomentumEvents;
    private int mSnapInterval;
    private List<Integer> mSnapOffsets;
    private int mSnapToAlignment;
    private boolean mSnapToEnd;
    private boolean mSnapToStart;
    private final VelocityHelper mVelocityHelper;
    private int pendingContentOffsetX;
    private int pendingContentOffsetY;

    public ReactScrollView(Context context) {
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
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void flingAndSnap(int r28) {
        /*
            r27 = this;
            r0 = r27
            int r1 = r27.getChildCount()
            if (r1 > 0) goto L_0x0009
            return
        L_0x0009:
            int r1 = r0.mSnapInterval
            if (r1 != 0) goto L_0x0019
            java.util.List<java.lang.Integer> r1 = r0.mSnapOffsets
            if (r1 != 0) goto L_0x0019
            int r1 = r0.mSnapToAlignment
            if (r1 != 0) goto L_0x0019
            r27.smoothScrollAndSnap(r28)
            return
        L_0x0019:
            android.animation.ValueAnimator r1 = r27.getFlingAnimator()
            android.animation.ValueAnimator r2 = r0.DEFAULT_FLING_ANIMATOR
            r3 = 1
            r4 = 0
            if (r1 == r2) goto L_0x0025
            r1 = 1
            goto L_0x0026
        L_0x0025:
            r1 = 0
        L_0x0026:
            int r2 = r27.getMaxScrollY()
            int r5 = r27.predictFinalScrollPosition(r28)
            boolean r6 = r0.mDisableIntervalMomentum
            if (r6 == 0) goto L_0x0036
            int r5 = r27.getScrollY()
        L_0x0036:
            int r6 = r27.getHeight()
            int r7 = r27.getPaddingBottom()
            int r6 = r6 - r7
            int r7 = r27.getPaddingTop()
            int r6 = r6 - r7
            java.util.List<java.lang.Integer> r7 = r0.mSnapOffsets
            r8 = 2
            if (r7 == 0) goto L_0x0090
            java.lang.Object r7 = r7.get(r4)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.util.List<java.lang.Integer> r9 = r0.mSnapOffsets
            int r10 = r9.size()
            int r10 = r10 - r3
            java.lang.Object r9 = r9.get(r10)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            r12 = r2
            r10 = 0
            r11 = 0
        L_0x0067:
            java.util.List<java.lang.Integer> r13 = r0.mSnapOffsets
            int r13 = r13.size()
            if (r10 >= r13) goto L_0x015c
            java.util.List<java.lang.Integer> r13 = r0.mSnapOffsets
            java.lang.Object r13 = r13.get(r10)
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            if (r13 > r5) goto L_0x0084
            int r14 = r5 - r13
            int r15 = r5 - r11
            if (r14 >= r15) goto L_0x0084
            r11 = r13
        L_0x0084:
            if (r13 < r5) goto L_0x008d
            int r14 = r13 - r5
            int r15 = r12 - r5
            if (r14 >= r15) goto L_0x008d
            r12 = r13
        L_0x008d:
            int r10 = r10 + 1
            goto L_0x0067
        L_0x0090:
            int r7 = r0.mSnapToAlignment
            if (r7 == 0) goto L_0x0140
            int r9 = r0.mSnapInterval
            if (r9 <= 0) goto L_0x00c5
            double r10 = (double) r5
            double r12 = (double) r9
            double r10 = r10 / r12
            double r12 = java.lang.Math.floor(r10)
            int r9 = r0.mSnapInterval
            double r14 = (double) r9
            double r12 = r12 * r14
            int r12 = (int) r12
            int r7 = r0.getItemStartOffset(r7, r12, r9, r6)
            int r7 = java.lang.Math.max(r7, r4)
            int r9 = r0.mSnapToAlignment
            double r10 = java.lang.Math.ceil(r10)
            int r12 = r0.mSnapInterval
            double r13 = (double) r12
            double r10 = r10 * r13
            int r10 = (int) r10
            int r9 = r0.getItemStartOffset(r9, r10, r12, r6)
            int r12 = java.lang.Math.min(r9, r2)
            r9 = r2
            r11 = r7
            goto L_0x015b
        L_0x00c5:
            android.view.View r7 = r27.getContentView()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            r11 = r2
            r12 = r11
            r9 = 0
            r10 = 0
            r13 = 0
        L_0x00d0:
            int r14 = r7.getChildCount()
            if (r9 >= r14) goto L_0x0136
            android.view.View r14 = r7.getChildAt(r9)
            int r15 = r0.mSnapToAlignment
            if (r15 == r3) goto L_0x0114
            if (r15 == r8) goto L_0x0107
            r3 = 3
            if (r15 != r3) goto L_0x00ee
            int r3 = r14.getTop()
            int r14 = r14.getHeight()
            int r14 = r6 - r14
            goto L_0x0112
        L_0x00ee:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid SnapToAlignment value: "
            r2.append(r3)
            int r3 = r0.mSnapToAlignment
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0107:
            int r3 = r14.getTop()
            int r14 = r14.getHeight()
            int r14 = r6 - r14
            int r14 = r14 / r8
        L_0x0112:
            int r3 = r3 - r14
            goto L_0x0118
        L_0x0114:
            int r3 = r14.getTop()
        L_0x0118:
            if (r3 > r5) goto L_0x0121
            int r14 = r5 - r3
            int r15 = r5 - r10
            if (r14 >= r15) goto L_0x0121
            r10 = r3
        L_0x0121:
            if (r3 < r5) goto L_0x012a
            int r14 = r3 - r5
            int r15 = r12 - r5
            if (r14 >= r15) goto L_0x012a
            r12 = r3
        L_0x012a:
            int r11 = java.lang.Math.min(r11, r3)
            int r13 = java.lang.Math.max(r13, r3)
            int r9 = r9 + 1
            r3 = 1
            goto L_0x00d0
        L_0x0136:
            int r11 = java.lang.Math.max(r10, r11)
            int r12 = java.lang.Math.min(r12, r13)
            r9 = r2
            goto L_0x015b
        L_0x0140:
            int r3 = r27.getSnapInterval()
            double r9 = (double) r3
            double r11 = (double) r5
            double r11 = r11 / r9
            double r13 = java.lang.Math.floor(r11)
            double r13 = r13 * r9
            int r3 = (int) r13
            double r11 = java.lang.Math.ceil(r11)
            double r11 = r11 * r9
            int r7 = (int) r11
            int r12 = java.lang.Math.min(r7, r2)
            r9 = r2
            r11 = r3
        L_0x015b:
            r7 = 0
        L_0x015c:
            int r3 = r5 - r11
            int r10 = java.lang.Math.abs(r3)
            int r13 = r12 - r5
            int r14 = java.lang.Math.abs(r13)
            if (r10 >= r14) goto L_0x016c
            r10 = r11
            goto L_0x016d
        L_0x016c:
            r10 = r12
        L_0x016d:
            boolean r14 = r0.mSnapToEnd
            if (r14 != 0) goto L_0x017e
            if (r5 < r9) goto L_0x017e
            int r3 = r27.getScrollY()
            if (r3 < r9) goto L_0x017a
            goto L_0x018a
        L_0x017a:
            r3 = r28
            r5 = r9
            goto L_0x01b4
        L_0x017e:
            boolean r9 = r0.mSnapToStart
            if (r9 != 0) goto L_0x0191
            if (r5 > r7) goto L_0x0191
            int r3 = r27.getScrollY()
            if (r3 > r7) goto L_0x018d
        L_0x018a:
            r3 = r28
            goto L_0x01b4
        L_0x018d:
            r3 = r28
            r5 = r7
            goto L_0x01b4
        L_0x0191:
            r14 = 4621819117588971520(0x4024000000000000, double:10.0)
            if (r28 <= 0) goto L_0x01a2
            if (r1 != 0) goto L_0x019e
            double r9 = (double) r13
            double r9 = r9 * r14
            int r3 = (int) r9
            int r3 = r28 + r3
            goto L_0x01a0
        L_0x019e:
            r3 = r28
        L_0x01a0:
            r5 = r12
            goto L_0x01b4
        L_0x01a2:
            if (r28 >= 0) goto L_0x01b1
            if (r1 != 0) goto L_0x01ad
            double r9 = (double) r3
            double r9 = r9 * r14
            int r3 = (int) r9
            int r3 = r28 - r3
            goto L_0x01af
        L_0x01ad:
            r3 = r28
        L_0x01af:
            r5 = r11
            goto L_0x01b4
        L_0x01b1:
            r3 = r28
            r5 = r10
        L_0x01b4:
            int r5 = java.lang.Math.max(r4, r5)
            int r5 = java.lang.Math.min(r5, r2)
            if (r1 != 0) goto L_0x01fa
            android.widget.OverScroller r1 = r0.mScroller
            if (r1 != 0) goto L_0x01c3
            goto L_0x01fa
        L_0x01c3:
            r7 = 1
            r0.mActivelyScrolling = r7
            int r17 = r27.getScrollX()
            int r18 = r27.getScrollY()
            r19 = 0
            if (r3 == 0) goto L_0x01d3
            goto L_0x01d9
        L_0x01d3:
            int r3 = r27.getScrollY()
            int r3 = r5 - r3
        L_0x01d9:
            r20 = r3
            r21 = 0
            r22 = 0
            r25 = 0
            if (r5 == 0) goto L_0x01e9
            if (r5 != r2) goto L_0x01e6
            goto L_0x01e9
        L_0x01e6:
            r26 = 0
            goto L_0x01ed
        L_0x01e9:
            int r4 = r6 / 2
            r26 = r4
        L_0x01ed:
            r16 = r1
            r23 = r5
            r24 = r5
            r16.fling(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r27.postInvalidateOnAnimation()
            goto L_0x0201
        L_0x01fa:
            int r1 = r27.getScrollX()
            r0.reactSmoothScrollTo(r1, r5)
        L_0x0201:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.ReactScrollView.flingAndSnap(int):void");
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

    private int getMaxScrollY() {
        return Math.max(0, this.mContentView.getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
    }

    private OverScroller getOverScrollerFromParent() {
        if (!sTriedToGetScrollerField) {
            sTriedToGetScrollerField = true;
            try {
                Field declaredField = ScrollView.class.getDeclaredField("mScroller");
                sScrollerField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                FLog.w(ReactConstants.TAG, "Failed to get mScroller field for ScrollView! This app will exhibit the bounce-back scrolling bug :(");
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
            FLog.w(ReactConstants.TAG, "Failed to cast mScroller field in ScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
            return null;
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Failed to get mScroller from ScrollView!", e2);
        }
    }

    private int getSnapInterval() {
        int i2 = this.mSnapInterval;
        if (i2 != 0) {
            return i2;
        }
        return getHeight();
    }

    private void handlePostTouchScrolling(int i2, int i3) {
        if (this.mPostTouchRunnable == null) {
            if (this.mSendMomentumEvents) {
                enableFpsListener();
                ReactScrollViewHelper.emitScrollMomentumBeginEvent(this, i2, i3);
            }
            this.mActivelyScrolling = false;
            AnonymousClass1 r3 = new Runnable() {
                private boolean mRunning = true;
                private boolean mSnappingToPage = false;
                private int mStableFrames = 0;

                public void run() {
                    boolean z2;
                    if (ReactScrollView.this.mActivelyScrolling) {
                        boolean unused = ReactScrollView.this.mActivelyScrolling = false;
                        this.mStableFrames = 0;
                        this.mRunning = true;
                    } else {
                        ReactScrollViewHelper.updateFabricScrollState(ReactScrollView.this);
                        int i2 = this.mStableFrames + 1;
                        this.mStableFrames = i2;
                        if (i2 < 3) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.mRunning = z2;
                        if (!ReactScrollView.this.mPagingEnabled || this.mSnappingToPage) {
                            if (ReactScrollView.this.mSendMomentumEvents) {
                                ReactScrollViewHelper.emitScrollMomentumEndEvent(ReactScrollView.this);
                            }
                            ReactScrollView.this.disableFpsListener();
                        } else {
                            this.mSnappingToPage = true;
                            ReactScrollView.this.flingAndSnap(0);
                            ViewCompat.k0(ReactScrollView.this, this, 20);
                        }
                    }
                    if (this.mRunning) {
                        ViewCompat.k0(ReactScrollView.this, this, 20);
                    } else {
                        Runnable unused2 = ReactScrollView.this.mPostTouchRunnable = null;
                    }
                }
            };
            this.mPostTouchRunnable = r3;
            ViewCompat.k0(this, r3, 20);
        }
    }

    private boolean isContentReady() {
        View contentView = getContentView();
        if (contentView == null || contentView.getWidth() == 0 || contentView.getHeight() == 0) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.ReactScrollView.isScrollPerfLoggingEnabled():boolean");
    }

    private int predictFinalScrollPosition(int i2) {
        if (getFlingAnimator() == this.DEFAULT_FLING_ANIMATOR) {
            return ReactScrollViewHelper.predictFinalScrollPosition(this, 0, i2, 0, getMaxScrollY()).y;
        }
        return getFlingExtrapolatedDistance(i2) + ReactScrollViewHelper.getNextFlingStartValue(this, getScrollY(), getReactScrollViewScrollState().getFinalAnimatedPositionScroll().y, i2);
    }

    private void scrollToChild(View view) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private void setPendingContentOffsets(int i2, int i3) {
        if (isContentReady()) {
            this.pendingContentOffsetX = -1;
            this.pendingContentOffsetY = -1;
            return;
        }
        this.pendingContentOffsetX = i2;
        this.pendingContentOffsetY = i3;
    }

    private void smoothScrollAndSnap(int i2) {
        double snapInterval = (double) getSnapInterval();
        double nextFlingStartValue = (double) ReactScrollViewHelper.getNextFlingStartValue(this, getScrollY(), getReactScrollViewScrollState().getFinalAnimatedPositionScroll().y, i2);
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
            reactSmoothScrollTo(getScrollX(), (int) d3);
        }
    }

    private void updateScrollAwayState(int i2) {
        getReactScrollViewScrollState().setScrollAwayPaddingTop(i2);
        ReactScrollViewHelper.forceUpdateState(this);
    }

    public void draw(Canvas canvas) {
        if (this.mEndFillColor != 0) {
            View childAt = getChildAt(0);
            if (!(this.mEndBackground == null || childAt == null || childAt.getBottom() >= getHeight())) {
                this.mEndBackground.setBounds(0, childAt.getBottom(), getWidth(), getHeight());
                this.mEndBackground.draw(canvas);
            }
        }
        getDrawingRect(this.mRect);
        String str = this.mOverflow;
        str.hashCode();
        if (!str.equals(ViewProps.VISIBLE)) {
            canvas.clipRect(this.mRect);
        }
        super.draw(canvas);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.mScrollEnabled || (keyCode != 19 && keyCode != 20)) {
            return super.executeKeyEvent(keyEvent);
        }
        return false;
    }

    public void flashScrollIndicators() {
        awakenScrollBars();
    }

    public void fling(int i2) {
        float signum = Math.signum(this.mOnScrollDispatchHelper.getYFlingVelocity());
        if (signum == 0.0f) {
            signum = Math.signum((float) i2);
        }
        int abs = (int) (((float) Math.abs(i2)) * signum);
        if (this.mPagingEnabled) {
            flingAndSnap(abs);
        } else if (this.mScroller != null) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            this.mScroller.fling(getScrollX(), getScrollY(), 0, abs, 0, 0, 0, Integer.MAX_VALUE, 0, height / 2);
            ViewCompat.i0(this);
        } else {
            super.fling(abs);
        }
        handlePostTouchScrolling(0, abs);
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
        return ReactScrollViewHelper.predictFinalScrollPosition(this, 0, i2, 0, getMaxScrollY()).y;
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

    public void onChildViewAdded(View view, View view2) {
        this.mContentView = view2;
        view2.addOnLayoutChangeListener(this);
    }

    public void onChildViewRemoved(View view, View view2) {
        this.mContentView.removeOnLayoutChangeListener(this);
        this.mContentView = null;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        String str = (String) getTag(R.id.react_test_id);
        if (str != null) {
            accessibilityNodeInfo.setViewIdResourceName(str);
        }
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
        int i6 = this.pendingContentOffsetX;
        if (i6 == -1) {
            i6 = getScrollX();
        }
        int i7 = this.pendingContentOffsetY;
        if (i7 == -1) {
            i7 = getScrollY();
        }
        scrollTo(i6, i7);
        ReactScrollViewHelper.emitLayoutEvent(this);
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int maxScrollY;
        if (this.mContentView != null && getScrollY() > (maxScrollY = getMaxScrollY())) {
            scrollTo(getScrollX(), maxScrollY);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        MeasureSpecAssertions.assertExplicitMeasureSpec(i2, i3);
        setMeasuredDimension(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
        int maxScrollY;
        OverScroller overScroller = this.mScroller;
        if (!(overScroller == null || this.mContentView == null || overScroller.isFinished() || this.mScroller.getCurrY() == this.mScroller.getFinalY() || i3 < (maxScrollY = getMaxScrollY()))) {
            this.mScroller.abortAnimation();
            i3 = maxScrollY;
        }
        super.onOverScrolled(i2, i3, z2, z3);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
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

    public void reactSmoothScrollTo(int i2, int i3) {
        ReactScrollViewHelper.smoothScrollTo(this, i2, i3);
        setPendingContentOffsets(i2, i3);
    }

    public void requestChildFocus(View view, View view2) {
        if (view2 != null) {
            scrollToChild(view2);
        }
        super.requestChildFocus(view, view2);
    }

    public void scrollTo(int i2, int i3) {
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

    public void setScrollAwayTopPaddingEnabledUnstable(int i2) {
        int childCount = getChildCount();
        boolean z2 = true;
        if (childCount != 1) {
            z2 = false;
        }
        Assertions.assertCondition(z2, "React Native ScrollView always has exactly 1 child; a content View");
        if (childCount > 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setTranslationY((float) i2);
            }
            setPadding(0, 0, 0, i2);
        }
        updateScrollAwayState(i2);
        setRemoveClippedSubviews(this.mRemoveClippedSubviews);
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
            View childAt = getChildAt(0);
            if (childAt instanceof ReactClippingViewGroup) {
                ((ReactClippingViewGroup) childAt).updateClippingRect();
            }
        }
    }

    public ReactScrollView(Context context, FpsListener fpsListener) {
        super(context);
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
        this.pendingContentOffsetX = -1;
        this.pendingContentOffsetY = -1;
        this.mFabricViewStateManager = new FabricViewStateManager();
        this.mReactScrollViewScrollState = new ReactScrollViewHelper.ReactScrollViewScrollState(0);
        this.DEFAULT_FLING_ANIMATOR = ObjectAnimator.ofInt(this, "scrollY", new int[]{0, 0});
        this.mPointerEvents = PointerEvents.AUTO;
        this.mLastScrollDispatchTime = 0;
        this.mScrollEventThrottle = 0;
        this.mFpsListener = fpsListener;
        this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
        this.mScroller = getOverScrollerFromParent();
        setOnHierarchyChangeListener(this);
        setScrollBarStyle(33554432);
    }

    public void setBorderRadius(float f2, int i2) {
        this.mReactBackgroundManager.setBorderRadius(f2, i2);
    }
}
