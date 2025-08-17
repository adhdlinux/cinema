package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

public interface BaseViewManagerInterface<T extends View> {
    void setAccessibilityActions(T t2, ReadableArray readableArray);

    void setAccessibilityHint(T t2, String str);

    void setAccessibilityLabel(T t2, String str);

    void setAccessibilityLabelledBy(T t2, Dynamic dynamic);

    void setAccessibilityLiveRegion(T t2, String str);

    void setAccessibilityRole(T t2, String str);

    void setBackgroundColor(T t2, int i2);

    void setBorderBottomLeftRadius(T t2, float f2);

    void setBorderBottomRightRadius(T t2, float f2);

    void setBorderRadius(T t2, float f2);

    void setBorderTopLeftRadius(T t2, float f2);

    void setBorderTopRightRadius(T t2, float f2);

    void setElevation(T t2, float f2);

    void setImportantForAccessibility(T t2, String str);

    void setNativeId(T t2, String str);

    void setOpacity(T t2, float f2);

    void setRenderToHardwareTexture(T t2, boolean z2);

    void setRotation(T t2, float f2);

    void setScaleX(T t2, float f2);

    void setScaleY(T t2, float f2);

    void setShadowColor(T t2, int i2);

    void setTestId(T t2, String str);

    void setTransform(T t2, ReadableArray readableArray);

    void setTranslateX(T t2, float f2);

    void setTranslateY(T t2, float f2);

    void setViewState(T t2, ReadableMap readableMap);

    void setZIndex(T t2, float f2);
}
