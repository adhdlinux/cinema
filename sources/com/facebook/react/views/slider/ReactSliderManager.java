package com.facebook.react.views.slider;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.SliderManagerDelegate;
import com.facebook.react.viewmanagers.SliderManagerInterface;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import java.util.HashMap;
import java.util.Map;

public class ReactSliderManager extends SimpleViewManager<ReactSlider> implements SliderManagerInterface<ReactSlider> {
    /* access modifiers changed from: private */
    public static final SeekBar.OnSeekBarChangeListener ON_CHANGE_LISTENER = new SeekBar.OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) seekBar.getContext(), seekBar.getId());
            if (eventDispatcherForReactTag != null) {
                eventDispatcherForReactTag.dispatchEvent(new ReactSliderEvent(seekBar.getId(), ((ReactSlider) seekBar).toRealProgress(i2), z2));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) seekBar.getContext(), seekBar.getId());
            if (eventDispatcherForReactTag != null) {
                eventDispatcherForReactTag.dispatchEvent(new ReactSlidingCompleteEvent(UIManagerHelper.getSurfaceId((View) seekBar), seekBar.getId(), ((ReactSlider) seekBar).toRealProgress(seekBar.getProgress())));
            }
        }
    };
    public static final String REACT_CLASS = "RCTSlider";
    private static final int STYLE = 16842875;
    private final ViewManagerDelegate<ReactSlider> mDelegate = new SliderManagerDelegate(this);

    protected class ReactSliderAccessibilityDelegate extends ReactAccessibilityDelegate {
        public ReactSliderAccessibilityDelegate(View view, boolean z2, int i2) {
            super(view, z2, i2);
        }

        private boolean isSliderAction(int i2) {
            if (i2 == AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2869q.b() || i2 == AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2870r.b() || i2 == AccessibilityNodeInfoCompat.AccessibilityActionCompat.L.b()) {
                return true;
            }
            return false;
        }

        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (isSliderAction(i2)) {
                ReactSliderManager.ON_CHANGE_LISTENER.onStartTrackingTouch((SeekBar) view);
            }
            boolean performAccessibilityAction = super.performAccessibilityAction(view, i2, bundle);
            if (isSliderAction(i2)) {
                ReactSliderManager.ON_CHANGE_LISTENER.onStopTrackingTouch((SeekBar) view);
            }
            return performAccessibilityAction;
        }
    }

    static class ReactSliderShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
        private int mHeight;
        private boolean mMeasured;
        private int mWidth;

        private void initMeasureFunction() {
            setMeasureFunction(this);
        }

        public long measure(YogaNode yogaNode, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2) {
            if (!this.mMeasured) {
                ReactSlider reactSlider = new ReactSlider(getThemedContext(), (AttributeSet) null, ReactSliderManager.STYLE);
                reactSlider.disableStateListAnimatorIfNeeded();
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(-2, 0);
                reactSlider.measure(makeMeasureSpec, makeMeasureSpec);
                this.mWidth = reactSlider.getMeasuredWidth();
                this.mHeight = reactSlider.getMeasuredHeight();
                this.mMeasured = true;
            }
            return YogaMeasureOutput.make(this.mWidth, this.mHeight);
        }

        private ReactSliderShadowNode() {
            initMeasureFunction();
        }
    }

    /* access modifiers changed from: protected */
    public ViewManagerDelegate<ReactSlider> getDelegate() {
        return this.mDelegate;
    }

    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        Map<String, Object> exportedCustomBubblingEventTypeConstants = super.getExportedCustomBubblingEventTypeConstants();
        if (exportedCustomBubblingEventTypeConstants == null) {
            exportedCustomBubblingEventTypeConstants = new HashMap<>();
        }
        exportedCustomBubblingEventTypeConstants.putAll(MapBuilder.builder().put("topValueChange", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onValueChange", "captured", "onValueChangeCapture"))).build());
        return exportedCustomBubblingEventTypeConstants;
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        Map exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap();
        }
        exportedCustomDirectEventTypeConstants.putAll(MapBuilder.of(ReactSlidingCompleteEvent.EVENT_NAME, MapBuilder.of("registrationName", "onSlidingComplete")));
        return exportedCustomDirectEventTypeConstants;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public Class getShadowNodeClass() {
        return ReactSliderShadowNode.class;
    }

    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2, float[] fArr) {
        ReactSlider reactSlider = new ReactSlider(context, (AttributeSet) null, STYLE);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(-2, 0);
        reactSlider.measure(makeMeasureSpec, makeMeasureSpec);
        return YogaMeasureOutput.make(PixelUtil.toDIPFromPixel((float) reactSlider.getMeasuredWidth()), PixelUtil.toDIPFromPixel((float) reactSlider.getMeasuredHeight()));
    }

    @ReactProp(name = "disabled")
    public void setDisabled(ReactSlider reactSlider, boolean z2) {
    }

    @ReactProp(customType = "ImageSource", name = "maximumTrackImage")
    public void setMaximumTrackImage(ReactSlider reactSlider, ReadableMap readableMap) {
    }

    @ReactProp(customType = "ImageSource", name = "minimumTrackImage")
    public void setMinimumTrackImage(ReactSlider reactSlider, ReadableMap readableMap) {
    }

    @ReactProp(customType = "ImageSource", name = "thumbImage")
    public void setThumbImage(ReactSlider reactSlider, ReadableMap readableMap) {
    }

    @ReactProp(customType = "ImageSource", name = "trackImage")
    public void setTrackImage(ReactSlider reactSlider, ReadableMap readableMap) {
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, ReactSlider reactSlider) {
        reactSlider.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new ReactSliderShadowNode();
    }

    /* access modifiers changed from: protected */
    public ReactSlider createViewInstance(ThemedReactContext themedReactContext) {
        ReactSlider reactSlider = new ReactSlider(themedReactContext, (AttributeSet) null, STYLE);
        ReactAccessibilityDelegate.setDelegate(reactSlider, reactSlider.isFocusable(), reactSlider.getImportantForAccessibility());
        return reactSlider;
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactSlider reactSlider, boolean z2) {
        reactSlider.setEnabled(z2);
    }

    @ReactProp(customType = "Color", name = "maximumTrackTintColor")
    public void setMaximumTrackTintColor(ReactSlider reactSlider, Integer num) {
        Drawable findDrawableByLayerId = ((LayerDrawable) reactSlider.getProgressDrawable().getCurrent()).findDrawableByLayerId(16908288);
        if (num == null) {
            findDrawableByLayerId.clearColorFilter();
        } else {
            findDrawableByLayerId.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @ReactProp(defaultDouble = 1.0d, name = "maximumValue")
    public void setMaximumValue(ReactSlider reactSlider, double d2) {
        reactSlider.setMaxValue(d2);
    }

    @ReactProp(customType = "Color", name = "minimumTrackTintColor")
    public void setMinimumTrackTintColor(ReactSlider reactSlider, Integer num) {
        Drawable findDrawableByLayerId = ((LayerDrawable) reactSlider.getProgressDrawable().getCurrent()).findDrawableByLayerId(16908301);
        if (num == null) {
            findDrawableByLayerId.clearColorFilter();
        } else {
            findDrawableByLayerId.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @ReactProp(defaultDouble = 0.0d, name = "minimumValue")
    public void setMinimumValue(ReactSlider reactSlider, double d2) {
        reactSlider.setMinValue(d2);
    }

    @ReactProp(defaultDouble = 0.0d, name = "step")
    public void setStep(ReactSlider reactSlider, double d2) {
        reactSlider.setStep(d2);
    }

    public void setTestID(ReactSlider reactSlider, String str) {
        super.setTestId(reactSlider, str);
    }

    @ReactProp(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(ReactSlider reactSlider, Integer num) {
        if (num == null) {
            reactSlider.getThumb().clearColorFilter();
        } else {
            reactSlider.getThumb().setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @ReactProp(defaultDouble = 0.0d, name = "value")
    public void setValue(ReactSlider reactSlider, double d2) {
        reactSlider.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
        reactSlider.setValue(d2);
        reactSlider.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
    }
}
