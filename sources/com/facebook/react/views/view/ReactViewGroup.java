package com.facebook.react.views.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.animation.Animation;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.touch.OnInterceptTouchEventListener;
import com.facebook.react.touch.ReactHitSlopView;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactClippingProhibitedView;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactOverflowViewWithInset;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ReactZIndexedViewGroup;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewUtil;
import com.facebook.react.uimanager.ViewGroupDrawingOrderHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.views.view.ReactViewBackgroundDrawable;
import com.facebook.yoga.YogaConstants;

@TargetApi(21)
public class ReactViewGroup extends ViewGroup implements ReactInterceptingViewGroup, ReactClippingViewGroup, ReactPointerEventsView, ReactHitSlopView, ReactZIndexedViewGroup, ReactOverflowViewWithInset {
    private static final int ARRAY_CAPACITY_INCREMENT = 12;
    private static final int DEFAULT_BACKGROUND_COLOR = 0;
    private static final ViewGroup.LayoutParams sDefaultLayoutParam = new ViewGroup.LayoutParams(0, 0);
    private static final Rect sHelperRect = new Rect();
    private View[] mAllChildren = null;
    private int mAllChildrenCount;
    private float mBackfaceOpacity = 1.0f;
    private String mBackfaceVisibility = ViewProps.VISIBLE;
    private ChildrenLayoutChangeListener mChildrenLayoutChangeListener;
    private Rect mClippingRect;
    private ViewGroupDrawingOrderHelper mDrawingOrderHelper = null;
    private Rect mHitSlopRect;
    private int mLayoutDirection;
    private boolean mNeedsOffscreenAlphaCompositing = false;
    private OnInterceptTouchEventListener mOnInterceptTouchEventListener;
    private String mOverflow;
    private final Rect mOverflowInset = new Rect();
    private Path mPath;
    private PointerEvents mPointerEvents = PointerEvents.AUTO;
    private ReactViewBackgroundDrawable mReactBackgroundDrawable;
    private boolean mRemoveClippedSubviews = false;

    private static final class ChildrenLayoutChangeListener implements View.OnLayoutChangeListener {
        private final ReactViewGroup mParent;

        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (this.mParent.getRemoveClippedSubviews()) {
                this.mParent.updateSubviewClipStatus(view);
            }
        }

        private ChildrenLayoutChangeListener(ReactViewGroup reactViewGroup) {
            this.mParent = reactViewGroup;
        }
    }

    public ReactViewGroup(Context context) {
        super(context);
        setClipChildren(false);
    }

    private void addInArray(View view, int i2) {
        View[] viewArr = (View[]) Assertions.assertNotNull(this.mAllChildren);
        int i3 = this.mAllChildrenCount;
        int length = viewArr.length;
        if (i2 == i3) {
            if (length == i3) {
                View[] viewArr2 = new View[(length + 12)];
                this.mAllChildren = viewArr2;
                System.arraycopy(viewArr, 0, viewArr2, 0, length);
                viewArr = this.mAllChildren;
            }
            int i4 = this.mAllChildrenCount;
            this.mAllChildrenCount = i4 + 1;
            viewArr[i4] = view;
        } else if (i2 < i3) {
            if (length == i3) {
                View[] viewArr3 = new View[(length + 12)];
                this.mAllChildren = viewArr3;
                System.arraycopy(viewArr, 0, viewArr3, 0, i2);
                System.arraycopy(viewArr, i2, this.mAllChildren, i2 + 1, i3 - i2);
                viewArr = this.mAllChildren;
            } else {
                System.arraycopy(viewArr, i2, viewArr, i2 + 1, i3 - i2);
            }
            viewArr[i2] = view;
            this.mAllChildrenCount++;
        } else {
            throw new IndexOutOfBoundsException("index=" + i2 + " count=" + i3);
        }
    }

    private boolean customDrawOrderDisabled() {
        if (getId() != -1 && ViewUtil.getUIManagerType(getId()) == 2) {
            return true;
        }
        return false;
    }

    private void dispatchOverflowDraw(Canvas canvas) {
        float f2;
        float f3;
        boolean z2;
        float f4;
        boolean z3;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        Canvas canvas2 = canvas;
        String str = this.mOverflow;
        if (str != null) {
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1217487446:
                    if (str.equals(ViewProps.HIDDEN)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -907680051:
                    if (str.equals(ViewProps.SCROLL)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 466743410:
                    if (str.equals(ViewProps.VISIBLE)) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                case 1:
                    float width = (float) getWidth();
                    float height = (float) getHeight();
                    ReactViewBackgroundDrawable reactViewBackgroundDrawable = this.mReactBackgroundDrawable;
                    if (reactViewBackgroundDrawable != null) {
                        RectF directionAwareBorderInsets = reactViewBackgroundDrawable.getDirectionAwareBorderInsets();
                        float f10 = directionAwareBorderInsets.top;
                        if (f10 > 0.0f || directionAwareBorderInsets.left > 0.0f || directionAwareBorderInsets.bottom > 0.0f || directionAwareBorderInsets.right > 0.0f) {
                            f4 = directionAwareBorderInsets.left + 0.0f;
                            f2 = f10 + 0.0f;
                            width -= directionAwareBorderInsets.right;
                            height -= directionAwareBorderInsets.bottom;
                        } else {
                            f2 = 0.0f;
                            f4 = 0.0f;
                        }
                        float fullBorderRadius = this.mReactBackgroundDrawable.getFullBorderRadius();
                        float borderRadiusOrDefaultTo = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_LEFT);
                        float borderRadiusOrDefaultTo2 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_RIGHT);
                        float borderRadiusOrDefaultTo3 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_LEFT);
                        float borderRadiusOrDefaultTo4 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_RIGHT);
                        if (this.mLayoutDirection == 1) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        float borderRadius = this.mReactBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_START);
                        float borderRadius2 = this.mReactBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_END);
                        float borderRadius3 = this.mReactBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_START);
                        float f11 = borderRadiusOrDefaultTo4;
                        float borderRadius4 = this.mReactBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_END);
                        float f12 = borderRadiusOrDefaultTo;
                        if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(getContext())) {
                            if (YogaConstants.isUndefined(borderRadius)) {
                                f5 = f12;
                            } else {
                                f5 = borderRadius;
                            }
                            if (!YogaConstants.isUndefined(borderRadius2)) {
                                borderRadiusOrDefaultTo2 = borderRadius2;
                            }
                            if (!YogaConstants.isUndefined(borderRadius3)) {
                                borderRadiusOrDefaultTo3 = borderRadius3;
                            }
                            if (YogaConstants.isUndefined(borderRadius4)) {
                                borderRadius4 = f11;
                            }
                            if (z3) {
                                f7 = borderRadiusOrDefaultTo2;
                            } else {
                                f7 = f5;
                            }
                            if (!z3) {
                                f5 = borderRadiusOrDefaultTo2;
                            }
                            if (z3) {
                                f6 = borderRadius4;
                            } else {
                                f6 = borderRadiusOrDefaultTo3;
                            }
                            if (z3) {
                                borderRadius4 = borderRadiusOrDefaultTo3;
                            }
                        } else {
                            if (z3) {
                                f8 = borderRadius2;
                            } else {
                                f8 = borderRadius;
                            }
                            if (!z3) {
                                borderRadius = borderRadius2;
                            }
                            if (z3) {
                                f9 = borderRadius4;
                            } else {
                                f9 = borderRadius3;
                            }
                            if (!z3) {
                                borderRadius3 = borderRadius4;
                            }
                            if (YogaConstants.isUndefined(f8)) {
                                f8 = f12;
                            }
                            if (!YogaConstants.isUndefined(borderRadius)) {
                                borderRadiusOrDefaultTo2 = borderRadius;
                            }
                            if (!YogaConstants.isUndefined(f9)) {
                                borderRadiusOrDefaultTo3 = f9;
                            }
                            if (!YogaConstants.isUndefined(borderRadius3)) {
                                borderRadius4 = borderRadius3;
                                f7 = f8;
                                f5 = borderRadiusOrDefaultTo2;
                                f6 = borderRadiusOrDefaultTo3;
                            } else {
                                f7 = f8;
                                f5 = borderRadiusOrDefaultTo2;
                                f6 = borderRadiusOrDefaultTo3;
                                borderRadius4 = f11;
                            }
                        }
                        if (f7 > 0.0f || f5 > 0.0f || borderRadius4 > 0.0f || f6 > 0.0f) {
                            if (this.mPath == null) {
                                this.mPath = new Path();
                            }
                            this.mPath.rewind();
                            this.mPath.addRoundRect(new RectF(f4, f2, width, height), new float[]{Math.max(f7 - directionAwareBorderInsets.left, 0.0f), Math.max(f7 - directionAwareBorderInsets.top, 0.0f), Math.max(f5 - directionAwareBorderInsets.right, 0.0f), Math.max(f5 - directionAwareBorderInsets.top, 0.0f), Math.max(borderRadius4 - directionAwareBorderInsets.right, 0.0f), Math.max(borderRadius4 - directionAwareBorderInsets.bottom, 0.0f), Math.max(f6 - directionAwareBorderInsets.left, 0.0f), Math.max(f6 - directionAwareBorderInsets.bottom, 0.0f)}, Path.Direction.CW);
                            canvas2.clipPath(this.mPath);
                            f3 = f4;
                            z2 = true;
                        } else {
                            f3 = f4;
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                        f3 = 0.0f;
                        f2 = 0.0f;
                    }
                    if (!z2) {
                        canvas2.clipRect(new RectF(f3, f2, width, height));
                        return;
                    }
                    return;
                case 2:
                    Path path = this.mPath;
                    if (path != null) {
                        path.rewind();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private ViewGroupDrawingOrderHelper getDrawingOrderHelper() {
        if (this.mDrawingOrderHelper == null) {
            this.mDrawingOrderHelper = new ViewGroupDrawingOrderHelper(this);
        }
        return this.mDrawingOrderHelper;
    }

    private ReactViewBackgroundDrawable getOrCreateReactViewBackground() {
        if (this.mReactBackgroundDrawable == null) {
            this.mReactBackgroundDrawable = new ReactViewBackgroundDrawable(getContext());
            Drawable background = getBackground();
            updateBackgroundDrawable((Drawable) null);
            if (background == null) {
                updateBackgroundDrawable(this.mReactBackgroundDrawable);
            } else {
                updateBackgroundDrawable(new LayerDrawable(new Drawable[]{this.mReactBackgroundDrawable, background}));
            }
            boolean isRTL = I18nUtil.getInstance().isRTL(getContext());
            this.mLayoutDirection = isRTL ? 1 : 0;
            this.mReactBackgroundDrawable.setResolvedLayoutDirection(isRTL);
        }
        return this.mReactBackgroundDrawable;
    }

    private int indexOfChildInAllChildren(View view) {
        int i2 = this.mAllChildrenCount;
        View[] viewArr = (View[]) Assertions.assertNotNull(this.mAllChildren);
        for (int i3 = 0; i3 < i2; i3++) {
            if (viewArr[i3] == view) {
                return i3;
            }
        }
        return -1;
    }

    private void removeFromArray(int i2) {
        View[] viewArr = (View[]) Assertions.assertNotNull(this.mAllChildren);
        int i3 = this.mAllChildrenCount;
        if (i2 == i3 - 1) {
            int i4 = i3 - 1;
            this.mAllChildrenCount = i4;
            viewArr[i4] = null;
        } else if (i2 < 0 || i2 >= i3) {
            throw new IndexOutOfBoundsException();
        } else {
            System.arraycopy(viewArr, i2 + 1, viewArr, i2, (i3 - i2) - 1);
            int i5 = this.mAllChildrenCount - 1;
            this.mAllChildrenCount = i5;
            viewArr[i5] = null;
        }
    }

    private void updateBackgroundDrawable(Drawable drawable) {
        super.setBackground(drawable);
    }

    private void updateClippingToRect(Rect rect) {
        Assertions.assertNotNull(this.mAllChildren);
        int i2 = 0;
        for (int i3 = 0; i3 < this.mAllChildrenCount; i3++) {
            updateSubviewClipStatus(rect, i3, i2);
            if (this.mAllChildren[i3].getParent() == null) {
                i2++;
            }
        }
    }

    private void updateSubviewClipStatus(Rect rect, int i2, int i3) {
        UiThreadUtil.assertOnUiThread();
        View view = ((View[]) Assertions.assertNotNull(this.mAllChildren))[i2];
        Rect rect2 = sHelperRect;
        rect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        boolean intersects = rect.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom);
        Animation animation = view.getAnimation();
        boolean z2 = true;
        boolean z3 = animation != null && !animation.hasEnded();
        if (!intersects && view.getParent() != null && !z3) {
            super.removeViewsInLayout(i2 - i3, 1);
        } else if (intersects && view.getParent() == null) {
            super.addViewInLayout(view, i2 - i3, sDefaultLayoutParam, true);
            invalidate();
        } else if (!intersects) {
            z2 = false;
        }
        if (z2 && (view instanceof ReactClippingViewGroup)) {
            ReactClippingViewGroup reactClippingViewGroup = (ReactClippingViewGroup) view;
            if (reactClippingViewGroup.getRemoveClippedSubviews()) {
                reactClippingViewGroup.updateClippingRect();
            }
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!customDrawOrderDisabled()) {
            getDrawingOrderHelper().handleAddView(view);
            setChildrenDrawingOrderEnabled(getDrawingOrderHelper().shouldEnableCustomDrawingOrder());
        } else {
            setChildrenDrawingOrderEnabled(false);
        }
        super.addView(view, i2, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void addViewWithSubviewClippingEnabled(View view, int i2) {
        addViewWithSubviewClippingEnabled(view, i2, sDefaultLayoutParam);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        try {
            dispatchOverflowDraw(canvas);
            super.dispatchDraw(canvas);
        } catch (NullPointerException | StackOverflowError e2) {
            RootView rootView = RootViewUtil.getRootView(this);
            if (rootView != null) {
                rootView.handleException(e2);
            } else if (getContext() instanceof ReactContext) {
                ((ReactContext) getContext()).handleException(new IllegalViewOperationException("StackOverflowException", this, e2));
            } else {
                throw e2;
            }
        }
    }

    @TargetApi(23)
    public void dispatchProvideStructure(ViewStructure viewStructure) {
        try {
            super.dispatchProvideStructure(viewStructure);
        } catch (NullPointerException e2) {
            FLog.e(ReactConstants.TAG, "NullPointerException when executing dispatchProvideStructure", (Throwable) e2);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean z2) {
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z2;
        if (view.getElevation() <= 0.0f || !ReactFeatureFlags.insertZReorderBarriersOnViewGroupChildren) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            CanvasUtil.enableZ(canvas, true);
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        if (z2) {
            CanvasUtil.enableZ(canvas, false);
        }
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    public int getAllChildrenCount() {
        return this.mAllChildrenCount;
    }

    @VisibleForTesting
    public int getBackgroundColor() {
        if (getBackground() != null) {
            return ((ReactViewBackgroundDrawable) getBackground()).getColor();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public View getChildAtWithSubviewClippingEnabled(int i2) {
        return ((View[]) Assertions.assertNotNull(this.mAllChildren))[i2];
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        UiThreadUtil.assertOnUiThread();
        if (!customDrawOrderDisabled()) {
            return getDrawingOrderHelper().getChildDrawingOrder(i2, i3);
        }
        return i3;
    }

    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        return super.getChildVisibleRect(view, rect, point);
    }

    public void getClippingRect(Rect rect) {
        rect.set(this.mClippingRect);
    }

    public Rect getHitSlopRect() {
        return this.mHitSlopRect;
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

    public boolean getRemoveClippedSubviews() {
        return this.mRemoveClippedSubviews;
    }

    public int getZIndexMappedChildIndex(int i2) {
        UiThreadUtil.assertOnUiThread();
        if (customDrawOrderDisabled() || !getDrawingOrderHelper().shouldEnableCustomDrawingOrder()) {
            return i2;
        }
        return getDrawingOrderHelper().getChildDrawingOrder(getChildCount(), i2);
    }

    public boolean hasOverlappingRendering() {
        return this.mNeedsOffscreenAlphaCompositing;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        PointerEvents pointerEvents;
        OnInterceptTouchEventListener onInterceptTouchEventListener = this.mOnInterceptTouchEventListener;
        if ((onInterceptTouchEventListener != null && onInterceptTouchEventListener.onInterceptTouchEvent(this, motionEvent)) || (pointerEvents = this.mPointerEvents) == PointerEvents.NONE || pointerEvents == PointerEvents.BOX_ONLY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        MeasureSpecAssertions.assertExplicitMeasureSpec(i2, i3);
        setMeasuredDimension(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
    }

    public void onRtlPropertiesChanged(int i2) {
        ReactViewBackgroundDrawable reactViewBackgroundDrawable = this.mReactBackgroundDrawable;
        if (reactViewBackgroundDrawable != null) {
            reactViewBackgroundDrawable.setResolvedLayoutDirection(this.mLayoutDirection);
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
        PointerEvents pointerEvents = this.mPointerEvents;
        return (pointerEvents == PointerEvents.NONE || pointerEvents == PointerEvents.BOX_NONE) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public void removeAllViewsWithSubviewClippingEnabled() {
        Assertions.assertCondition(this.mRemoveClippedSubviews);
        Assertions.assertNotNull(this.mAllChildren);
        for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
            this.mAllChildren[i2].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        }
        removeAllViewsInLayout();
        this.mAllChildrenCount = 0;
    }

    public void removeView(View view) {
        UiThreadUtil.assertOnUiThread();
        if (!customDrawOrderDisabled()) {
            getDrawingOrderHelper().handleRemoveView(view);
            setChildrenDrawingOrderEnabled(getDrawingOrderHelper().shouldEnableCustomDrawingOrder());
        } else {
            setChildrenDrawingOrderEnabled(false);
        }
        super.removeView(view);
    }

    public void removeViewAt(int i2) {
        UiThreadUtil.assertOnUiThread();
        if (!customDrawOrderDisabled()) {
            getDrawingOrderHelper().handleRemoveView(getChildAt(i2));
            setChildrenDrawingOrderEnabled(getDrawingOrderHelper().shouldEnableCustomDrawingOrder());
        } else {
            setChildrenDrawingOrderEnabled(false);
        }
        super.removeViewAt(i2);
    }

    /* access modifiers changed from: package-private */
    public void removeViewWithSubviewClippingEnabled(View view) {
        UiThreadUtil.assertOnUiThread();
        Assertions.assertCondition(this.mRemoveClippedSubviews);
        Assertions.assertNotNull(this.mClippingRect);
        Assertions.assertNotNull(this.mAllChildren);
        view.removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        int indexOfChildInAllChildren = indexOfChildInAllChildren(view);
        if (this.mAllChildren[indexOfChildInAllChildren].getParent() != null) {
            int i2 = 0;
            for (int i3 = 0; i3 < indexOfChildInAllChildren; i3++) {
                if (this.mAllChildren[i3].getParent() == null) {
                    i2++;
                }
            }
            super.removeViewsInLayout(indexOfChildInAllChildren - i2, 1);
        }
        removeFromArray(indexOfChildInAllChildren);
    }

    @SuppressLint({"MissingSuperCall"})
    public void requestLayout() {
    }

    public void setBackfaceVisibility(String str) {
        this.mBackfaceVisibility = str;
        setBackfaceVisibilityDependantOpacity();
    }

    public void setBackfaceVisibilityDependantOpacity() {
        boolean z2;
        if (this.mBackfaceVisibility.equals(ViewProps.VISIBLE)) {
            setAlpha(this.mBackfaceOpacity);
            return;
        }
        float rotationX = getRotationX();
        float rotationY = getRotationY();
        if (rotationX < -90.0f || rotationX >= 90.0f || rotationY < -90.0f || rotationY >= 90.0f) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            setAlpha(this.mBackfaceOpacity);
        } else {
            setAlpha(0.0f);
        }
    }

    public void setBackground(Drawable drawable) {
        throw new UnsupportedOperationException("This method is not supported for ReactViewGroup instances");
    }

    public void setBackgroundColor(int i2) {
        if (i2 != 0 || this.mReactBackgroundDrawable != null) {
            getOrCreateReactViewBackground().setColor(i2);
        }
    }

    public void setBorderColor(int i2, float f2, float f3) {
        getOrCreateReactViewBackground().setBorderColor(i2, f2, f3);
    }

    public void setBorderRadius(float f2) {
        getOrCreateReactViewBackground().setRadius(f2);
    }

    public void setBorderStyle(String str) {
        getOrCreateReactViewBackground().setBorderStyle(str);
    }

    public void setBorderWidth(int i2, float f2) {
        getOrCreateReactViewBackground().setBorderWidth(i2, f2);
    }

    public void setHitSlopRect(Rect rect) {
        this.mHitSlopRect = rect;
    }

    public void setNeedsOffscreenAlphaCompositing(boolean z2) {
        this.mNeedsOffscreenAlphaCompositing = z2;
    }

    public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.mOnInterceptTouchEventListener = onInterceptTouchEventListener;
    }

    public void setOpacityIfPossible(float f2) {
        this.mBackfaceOpacity = f2;
        setBackfaceVisibilityDependantOpacity();
    }

    public void setOverflow(String str) {
        this.mOverflow = str;
        invalidate();
    }

    public void setOverflowInset(int i2, int i3, int i4, int i5) {
        this.mOverflowInset.set(i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void setPointerEvents(PointerEvents pointerEvents) {
        this.mPointerEvents = pointerEvents;
    }

    public void setRemoveClippedSubviews(boolean z2) {
        if (z2 != this.mRemoveClippedSubviews) {
            this.mRemoveClippedSubviews = z2;
            if (z2) {
                Rect rect = new Rect();
                this.mClippingRect = rect;
                ReactClippingViewGroupHelper.calculateClippingRect(this, rect);
                int childCount = getChildCount();
                this.mAllChildrenCount = childCount;
                this.mAllChildren = new View[Math.max(12, childCount)];
                this.mChildrenLayoutChangeListener = new ChildrenLayoutChangeListener();
                for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
                    View childAt = getChildAt(i2);
                    this.mAllChildren[i2] = childAt;
                    childAt.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
                }
                updateClippingRect();
                return;
            }
            Assertions.assertNotNull(this.mClippingRect);
            Assertions.assertNotNull(this.mAllChildren);
            Assertions.assertNotNull(this.mChildrenLayoutChangeListener);
            for (int i3 = 0; i3 < this.mAllChildrenCount; i3++) {
                this.mAllChildren[i3].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
            }
            getDrawingRect(this.mClippingRect);
            updateClippingToRect(this.mClippingRect);
            this.mAllChildren = null;
            this.mClippingRect = null;
            this.mAllChildrenCount = 0;
            this.mChildrenLayoutChangeListener = null;
        }
    }

    public void setTranslucentBackgroundDrawable(Drawable drawable) {
        updateBackgroundDrawable((Drawable) null);
        if (this.mReactBackgroundDrawable != null && drawable != null) {
            updateBackgroundDrawable(new LayerDrawable(new Drawable[]{this.mReactBackgroundDrawable, drawable}));
        } else if (drawable != null) {
            updateBackgroundDrawable(drawable);
        }
    }

    public void updateClippingRect() {
        if (this.mRemoveClippedSubviews) {
            Assertions.assertNotNull(this.mClippingRect);
            Assertions.assertNotNull(this.mAllChildren);
            ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
            updateClippingToRect(this.mClippingRect);
        }
    }

    public void updateDrawingOrder() {
        if (!customDrawOrderDisabled()) {
            getDrawingOrderHelper().update();
            setChildrenDrawingOrderEnabled(getDrawingOrderHelper().shouldEnableCustomDrawingOrder());
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void addViewWithSubviewClippingEnabled(final View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Assertions.assertCondition(this.mRemoveClippedSubviews);
        Assertions.assertNotNull(this.mClippingRect);
        Assertions.assertNotNull(this.mAllChildren);
        addInArray(view, i2);
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (this.mAllChildren[i4].getParent() == null) {
                i3++;
            }
        }
        updateSubviewClipStatus(this.mClippingRect, i2, i3);
        view.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        if (view instanceof ReactClippingProhibitedView) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (!view.isShown()) {
                        ReactSoftExceptionLogger.logSoftException(ReactConstants.TAG, new ReactNoCrashSoftException("Child view has been added to Parent view in which it is clipped and not visible. This is not legal for this particular child view. Child: [" + view.getId() + "] " + view.toString() + " Parent: [" + ReactViewGroup.this.getId() + "] " + toString()));
                    }
                }
            });
        }
    }

    public void setBorderRadius(float f2, int i2) {
        getOrCreateReactViewBackground().setRadius(f2, i2);
    }

    /* access modifiers changed from: private */
    public void updateSubviewClipStatus(View view) {
        if (this.mRemoveClippedSubviews && getParent() != null) {
            Assertions.assertNotNull(this.mClippingRect);
            Assertions.assertNotNull(this.mAllChildren);
            Rect rect = sHelperRect;
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (this.mClippingRect.intersects(rect.left, rect.top, rect.right, rect.bottom) != (view.getParent() != null)) {
                int i2 = 0;
                for (int i3 = 0; i3 < this.mAllChildrenCount; i3++) {
                    View view2 = this.mAllChildren[i3];
                    if (view2 == view) {
                        updateSubviewClipStatus(this.mClippingRect, i3, i2);
                        return;
                    }
                    if (view2.getParent() == null) {
                        i2++;
                    }
                }
            }
        }
    }
}
