package com.facebook.react.views.scroll;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.common.MapBuilder;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ReactModule(name = "RCTScrollView")
public class ReactScrollViewManager extends ViewGroupManager<ReactScrollView> implements ReactScrollViewCommandHelper.ScrollCommandHandler<ReactScrollView> {
    public static final String REACT_CLASS = "RCTScrollView";
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    private FpsListener mFpsListener;

    public ReactScrollViewManager() {
        this((FpsListener) null);
    }

    public static Map<String, Object> createExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), MapBuilder.of("registrationName", "onScroll")).put(ScrollEventType.getJSEventName(ScrollEventType.BEGIN_DRAG), MapBuilder.of("registrationName", "onScrollBeginDrag")).put(ScrollEventType.getJSEventName(ScrollEventType.END_DRAG), MapBuilder.of("registrationName", "onScrollEndDrag")).put(ScrollEventType.getJSEventName(ScrollEventType.MOMENTUM_BEGIN), MapBuilder.of("registrationName", "onMomentumScrollBegin")).put(ScrollEventType.getJSEventName(ScrollEventType.MOMENTUM_END), MapBuilder.of("registrationName", "onMomentumScrollEnd")).build();
    }

    public Map<String, Integer> getCommandsMap() {
        return ReactScrollViewCommandHelper.getCommandsMap();
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.putAll(createExportedCustomDirectEventTypeConstants());
        return exportedCustomDirectEventTypeConstants;
    }

    public String getName() {
        return REACT_CLASS;
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactScrollView reactScrollView, int i2, Integer num) {
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
        reactScrollView.setBorderColor(SPACING_TYPES[i2], f2, f3);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactScrollView reactScrollView, int i2, float f2) {
        if (!YogaConstants.isUndefined(f2)) {
            f2 = PixelUtil.toPixelFromDIP(f2);
        }
        if (i2 == 0) {
            reactScrollView.setBorderRadius(f2);
        } else {
            reactScrollView.setBorderRadius(f2, i2 - 1);
        }
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactScrollView reactScrollView, String str) {
        reactScrollView.setBorderStyle(str);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactScrollView reactScrollView, int i2, float f2) {
        if (!YogaConstants.isUndefined(f2)) {
            f2 = PixelUtil.toPixelFromDIP(f2);
        }
        reactScrollView.setBorderWidth(SPACING_TYPES[i2], f2);
    }

    @ReactProp(customType = "Color", defaultInt = 0, name = "endFillColor")
    public void setBottomFillColor(ReactScrollView reactScrollView, int i2) {
        reactScrollView.setEndFillColor(i2);
    }

    @ReactProp(customType = "Point", name = "contentOffset")
    public void setContentOffset(ReactScrollView reactScrollView, ReadableMap readableMap) {
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
            reactScrollView.scrollTo((int) PixelUtil.toPixelFromDIP(d2), (int) PixelUtil.toPixelFromDIP(d3));
            return;
        }
        reactScrollView.scrollTo(0, 0);
    }

    @ReactProp(name = "decelerationRate")
    public void setDecelerationRate(ReactScrollView reactScrollView, float f2) {
        reactScrollView.setDecelerationRate(f2);
    }

    @ReactProp(name = "disableIntervalMomentum")
    public void setDisableIntervalMomentum(ReactScrollView reactScrollView, boolean z2) {
        reactScrollView.setDisableIntervalMomentum(z2);
    }

    @ReactProp(name = "fadingEdgeLength")
    public void setFadingEdgeLength(ReactScrollView reactScrollView, int i2) {
        if (i2 > 0) {
            reactScrollView.setVerticalFadingEdgeEnabled(true);
            reactScrollView.setFadingEdgeLength(i2);
            return;
        }
        reactScrollView.setVerticalFadingEdgeEnabled(false);
        reactScrollView.setFadingEdgeLength(0);
    }

    @ReactProp(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(ReactScrollView reactScrollView, boolean z2) {
        ViewCompat.F0(reactScrollView, z2);
    }

    @ReactProp(name = "overScrollMode")
    public void setOverScrollMode(ReactScrollView reactScrollView, String str) {
        reactScrollView.setOverScrollMode(ReactScrollViewHelper.parseOverScrollMode(str));
    }

    @ReactProp(name = "overflow")
    public void setOverflow(ReactScrollView reactScrollView, String str) {
        reactScrollView.setOverflow(str);
    }

    @ReactProp(name = "pagingEnabled")
    public void setPagingEnabled(ReactScrollView reactScrollView, boolean z2) {
        reactScrollView.setPagingEnabled(z2);
    }

    @ReactProp(name = "persistentScrollbar")
    public void setPersistentScrollbar(ReactScrollView reactScrollView, boolean z2) {
        reactScrollView.setScrollbarFadingEnabled(!z2);
    }

    @ReactProp(name = "pointerEvents")
    public void setPointerEvents(ReactScrollView reactScrollView, String str) {
        reactScrollView.setPointerEvents(PointerEvents.parsePointerEvents(str));
    }

    @ReactProp(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(ReactScrollView reactScrollView, boolean z2) {
        reactScrollView.setRemoveClippedSubviews(z2);
    }

    @ReactProp(defaultBoolean = true, name = "scrollEnabled")
    public void setScrollEnabled(ReactScrollView reactScrollView, boolean z2) {
        reactScrollView.setScrollEnabled(z2);
        reactScrollView.setFocusable(z2);
    }

    @ReactProp(name = "scrollEventThrottle")
    public void setScrollEventThrottle(ReactScrollView reactScrollView, int i2) {
        reactScrollView.setScrollEventThrottle(i2);
    }

    @ReactProp(name = "scrollPerfTag")
    public void setScrollPerfTag(ReactScrollView reactScrollView, String str) {
        reactScrollView.setScrollPerfTag(str);
    }

    @ReactProp(name = "sendMomentumEvents")
    public void setSendMomentumEvents(ReactScrollView reactScrollView, boolean z2) {
        reactScrollView.setSendMomentumEvents(z2);
    }

    @ReactProp(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(ReactScrollView reactScrollView, boolean z2) {
        reactScrollView.setVerticalScrollBarEnabled(z2);
    }

    @ReactProp(name = "snapToAlignment")
    public void setSnapToAlignment(ReactScrollView reactScrollView, String str) {
        reactScrollView.setSnapToAlignment(ReactScrollViewHelper.parseSnapToAlignment(str));
    }

    @ReactProp(name = "snapToEnd")
    public void setSnapToEnd(ReactScrollView reactScrollView, boolean z2) {
        reactScrollView.setSnapToEnd(z2);
    }

    @ReactProp(name = "snapToInterval")
    public void setSnapToInterval(ReactScrollView reactScrollView, float f2) {
        reactScrollView.setSnapInterval((int) (f2 * PixelUtil.getDisplayMetricDensity()));
    }

    @ReactProp(name = "snapToOffsets")
    public void setSnapToOffsets(ReactScrollView reactScrollView, ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            reactScrollView.setSnapOffsets((List<Integer>) null);
            return;
        }
        float displayMetricDensity = PixelUtil.getDisplayMetricDensity();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            arrayList.add(Integer.valueOf((int) (readableArray.getDouble(i2) * ((double) displayMetricDensity))));
        }
        reactScrollView.setSnapOffsets(arrayList);
    }

    @ReactProp(name = "snapToStart")
    public void setSnapToStart(ReactScrollView reactScrollView, boolean z2) {
        reactScrollView.setSnapToStart(z2);
    }

    public ReactScrollViewManager(FpsListener fpsListener) {
        this.mFpsListener = fpsListener;
    }

    public ReactScrollView createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactScrollView(themedReactContext, this.mFpsListener);
    }

    public void flashScrollIndicators(ReactScrollView reactScrollView) {
        reactScrollView.flashScrollIndicators();
    }

    public void scrollTo(ReactScrollView reactScrollView, ReactScrollViewCommandHelper.ScrollToCommandData scrollToCommandData) {
        if (scrollToCommandData.mAnimated) {
            reactScrollView.reactSmoothScrollTo(scrollToCommandData.mDestX, scrollToCommandData.mDestY);
        } else {
            reactScrollView.scrollTo(scrollToCommandData.mDestX, scrollToCommandData.mDestY);
        }
    }

    public void scrollToEnd(ReactScrollView reactScrollView, ReactScrollViewCommandHelper.ScrollToEndCommandData scrollToEndCommandData) {
        View childAt = reactScrollView.getChildAt(0);
        if (childAt != null) {
            int height = childAt.getHeight() + reactScrollView.getPaddingBottom();
            if (scrollToEndCommandData.mAnimated) {
                reactScrollView.reactSmoothScrollTo(reactScrollView.getScrollX(), height);
            } else {
                reactScrollView.scrollTo(reactScrollView.getScrollX(), height);
            }
        } else {
            throw new RetryableMountingLayerException("scrollToEnd called on ScrollView without child");
        }
    }

    public Object updateState(ReactScrollView reactScrollView, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        reactScrollView.getFabricViewStateManager().setStateWrapper(stateWrapper);
        return null;
    }

    public void receiveCommand(ReactScrollView reactScrollView, int i2, ReadableArray readableArray) {
        ReactScrollViewCommandHelper.receiveCommand(this, reactScrollView, i2, readableArray);
    }

    public void receiveCommand(ReactScrollView reactScrollView, String str, ReadableArray readableArray) {
        ReactScrollViewCommandHelper.receiveCommand(this, reactScrollView, str, readableArray);
    }
}
