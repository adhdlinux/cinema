package com.facebook.react.views.scroll;

import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper;
import com.facebook.yoga.YogaConstants;
import java.util.ArrayList;
import java.util.List;

@ReactModule(name = "AndroidHorizontalScrollView")
public class ReactHorizontalScrollViewManager extends ViewGroupManager<ReactHorizontalScrollView> implements ReactScrollViewCommandHelper.ScrollCommandHandler<ReactHorizontalScrollView> {
    public static final String REACT_CLASS = "AndroidHorizontalScrollView";
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    private FpsListener mFpsListener;

    public ReactHorizontalScrollViewManager() {
        this((FpsListener) null);
    }

    public String getName() {
        return REACT_CLASS;
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactHorizontalScrollView reactHorizontalScrollView, int i2, Integer num) {
        float f2;
        float f3 = Float.NaN;
        if (num == null) {
            f2 = Float.NaN;
        } else {
            f2 = (float) (num.intValue() & 16777215);
        }
        if (num != null) {
            f3 = (float) (num.intValue() >>> 24);
        }
        reactHorizontalScrollView.setBorderColor(SPACING_TYPES[i2], f2, f3);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactHorizontalScrollView reactHorizontalScrollView, int i2, float f2) {
        if (!YogaConstants.isUndefined(f2)) {
            f2 = PixelUtil.toPixelFromDIP(f2);
        }
        if (i2 == 0) {
            reactHorizontalScrollView.setBorderRadius(f2);
        } else {
            reactHorizontalScrollView.setBorderRadius(f2, i2 - 1);
        }
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactHorizontalScrollView reactHorizontalScrollView, String str) {
        reactHorizontalScrollView.setBorderStyle(str);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactHorizontalScrollView reactHorizontalScrollView, int i2, float f2) {
        if (!YogaConstants.isUndefined(f2)) {
            f2 = PixelUtil.toPixelFromDIP(f2);
        }
        reactHorizontalScrollView.setBorderWidth(SPACING_TYPES[i2], f2);
    }

    @ReactProp(customType = "Color", defaultInt = 0, name = "endFillColor")
    public void setBottomFillColor(ReactHorizontalScrollView reactHorizontalScrollView, int i2) {
        reactHorizontalScrollView.setEndFillColor(i2);
    }

    @ReactProp(name = "contentOffset")
    public void setContentOffset(ReactHorizontalScrollView reactHorizontalScrollView, ReadableMap readableMap) {
        double d2;
        if (readableMap != null) {
            double d3 = 0.0d;
            if (readableMap.hasKey("x")) {
                d2 = readableMap.getDouble("x");
            } else {
                d2 = 0.0d;
            }
            if (readableMap.hasKey("y")) {
                d3 = readableMap.getDouble("y");
            }
            reactHorizontalScrollView.scrollTo((int) PixelUtil.toPixelFromDIP(d2), (int) PixelUtil.toPixelFromDIP(d3));
            return;
        }
        reactHorizontalScrollView.scrollTo(0, 0);
    }

    @ReactProp(name = "decelerationRate")
    public void setDecelerationRate(ReactHorizontalScrollView reactHorizontalScrollView, float f2) {
        reactHorizontalScrollView.setDecelerationRate(f2);
    }

    @ReactProp(name = "disableIntervalMomentum")
    public void setDisableIntervalMomentum(ReactHorizontalScrollView reactHorizontalScrollView, boolean z2) {
        reactHorizontalScrollView.setDisableIntervalMomentum(z2);
    }

    @ReactProp(name = "fadingEdgeLength")
    public void setFadingEdgeLength(ReactHorizontalScrollView reactHorizontalScrollView, int i2) {
        if (i2 > 0) {
            reactHorizontalScrollView.setHorizontalFadingEdgeEnabled(true);
            reactHorizontalScrollView.setFadingEdgeLength(i2);
            return;
        }
        reactHorizontalScrollView.setHorizontalFadingEdgeEnabled(false);
        reactHorizontalScrollView.setFadingEdgeLength(0);
    }

    @ReactProp(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(ReactHorizontalScrollView reactHorizontalScrollView, boolean z2) {
        ViewCompat.F0(reactHorizontalScrollView, z2);
    }

    @ReactProp(name = "overScrollMode")
    public void setOverScrollMode(ReactHorizontalScrollView reactHorizontalScrollView, String str) {
        reactHorizontalScrollView.setOverScrollMode(ReactScrollViewHelper.parseOverScrollMode(str));
    }

    @ReactProp(name = "overflow")
    public void setOverflow(ReactHorizontalScrollView reactHorizontalScrollView, String str) {
        reactHorizontalScrollView.setOverflow(str);
    }

    @ReactProp(name = "pagingEnabled")
    public void setPagingEnabled(ReactHorizontalScrollView reactHorizontalScrollView, boolean z2) {
        reactHorizontalScrollView.setPagingEnabled(z2);
    }

    @ReactProp(name = "persistentScrollbar")
    public void setPersistentScrollbar(ReactHorizontalScrollView reactHorizontalScrollView, boolean z2) {
        reactHorizontalScrollView.setScrollbarFadingEnabled(!z2);
    }

    @ReactProp(name = "pointerEvents")
    public void setPointerEvents(ReactHorizontalScrollView reactHorizontalScrollView, String str) {
        reactHorizontalScrollView.setPointerEvents(PointerEvents.parsePointerEvents(str));
    }

    @ReactProp(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(ReactHorizontalScrollView reactHorizontalScrollView, boolean z2) {
        reactHorizontalScrollView.setRemoveClippedSubviews(z2);
    }

    @ReactProp(defaultBoolean = true, name = "scrollEnabled")
    public void setScrollEnabled(ReactHorizontalScrollView reactHorizontalScrollView, boolean z2) {
        reactHorizontalScrollView.setScrollEnabled(z2);
    }

    @ReactProp(name = "scrollEventThrottle")
    public void setScrollEventThrottle(ReactHorizontalScrollView reactHorizontalScrollView, int i2) {
        reactHorizontalScrollView.setScrollEventThrottle(i2);
    }

    @ReactProp(name = "scrollPerfTag")
    public void setScrollPerfTag(ReactHorizontalScrollView reactHorizontalScrollView, String str) {
        reactHorizontalScrollView.setScrollPerfTag(str);
    }

    @ReactProp(name = "sendMomentumEvents")
    public void setSendMomentumEvents(ReactHorizontalScrollView reactHorizontalScrollView, boolean z2) {
        reactHorizontalScrollView.setSendMomentumEvents(z2);
    }

    @ReactProp(name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(ReactHorizontalScrollView reactHorizontalScrollView, boolean z2) {
        reactHorizontalScrollView.setHorizontalScrollBarEnabled(z2);
    }

    @ReactProp(name = "snapToAlignment")
    public void setSnapToAlignment(ReactHorizontalScrollView reactHorizontalScrollView, String str) {
        reactHorizontalScrollView.setSnapToAlignment(ReactScrollViewHelper.parseSnapToAlignment(str));
    }

    @ReactProp(name = "snapToEnd")
    public void setSnapToEnd(ReactHorizontalScrollView reactHorizontalScrollView, boolean z2) {
        reactHorizontalScrollView.setSnapToEnd(z2);
    }

    @ReactProp(name = "snapToInterval")
    public void setSnapToInterval(ReactHorizontalScrollView reactHorizontalScrollView, float f2) {
        reactHorizontalScrollView.setSnapInterval((int) (f2 * PixelUtil.getDisplayMetricDensity()));
    }

    @ReactProp(name = "snapToOffsets")
    public void setSnapToOffsets(ReactHorizontalScrollView reactHorizontalScrollView, ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            reactHorizontalScrollView.setSnapOffsets((List<Integer>) null);
            return;
        }
        float displayMetricDensity = PixelUtil.getDisplayMetricDensity();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            arrayList.add(Integer.valueOf((int) (readableArray.getDouble(i2) * ((double) displayMetricDensity))));
        }
        reactHorizontalScrollView.setSnapOffsets(arrayList);
    }

    @ReactProp(name = "snapToStart")
    public void setSnapToStart(ReactHorizontalScrollView reactHorizontalScrollView, boolean z2) {
        reactHorizontalScrollView.setSnapToStart(z2);
    }

    public ReactHorizontalScrollViewManager(FpsListener fpsListener) {
        this.mFpsListener = fpsListener;
    }

    public ReactHorizontalScrollView createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactHorizontalScrollView(themedReactContext, this.mFpsListener);
    }

    public void flashScrollIndicators(ReactHorizontalScrollView reactHorizontalScrollView) {
        reactHorizontalScrollView.flashScrollIndicators();
    }

    public void scrollTo(ReactHorizontalScrollView reactHorizontalScrollView, ReactScrollViewCommandHelper.ScrollToCommandData scrollToCommandData) {
        if (scrollToCommandData.mAnimated) {
            reactHorizontalScrollView.reactSmoothScrollTo(scrollToCommandData.mDestX, scrollToCommandData.mDestY);
        } else {
            reactHorizontalScrollView.scrollTo(scrollToCommandData.mDestX, scrollToCommandData.mDestY);
        }
    }

    public void scrollToEnd(ReactHorizontalScrollView reactHorizontalScrollView, ReactScrollViewCommandHelper.ScrollToEndCommandData scrollToEndCommandData) {
        int width = reactHorizontalScrollView.getChildAt(0).getWidth() + reactHorizontalScrollView.getPaddingRight();
        if (scrollToEndCommandData.mAnimated) {
            reactHorizontalScrollView.reactSmoothScrollTo(width, reactHorizontalScrollView.getScrollY());
        } else {
            reactHorizontalScrollView.scrollTo(width, reactHorizontalScrollView.getScrollY());
        }
    }

    public Object updateState(ReactHorizontalScrollView reactHorizontalScrollView, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        reactHorizontalScrollView.getFabricViewStateManager().setStateWrapper(stateWrapper);
        return null;
    }

    public void receiveCommand(ReactHorizontalScrollView reactHorizontalScrollView, int i2, ReadableArray readableArray) {
        ReactScrollViewCommandHelper.receiveCommand(this, reactHorizontalScrollView, i2, readableArray);
    }

    public void receiveCommand(ReactHorizontalScrollView reactHorizontalScrollView, String str, ReadableArray readableArray) {
        ReactScrollViewCommandHelper.receiveCommand(this, reactHorizontalScrollView, str, readableArray);
    }
}
