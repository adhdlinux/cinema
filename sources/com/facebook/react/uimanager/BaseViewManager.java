package com.facebook.react.uimanager;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.MatrixMathHelper;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.PointerEventHelper;
import com.facebook.react.uimanager.util.ReactFindViewUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseViewManager<T extends View, C extends LayoutShadowNode> extends ViewManager<T, C> implements BaseViewManagerInterface<T> {
    private static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = ((float) Math.sqrt(5.0d));
    private static final int PERSPECTIVE_ARRAY_INVERTED_CAMERA_DISTANCE_INDEX = 2;
    private static final String STATE_BUSY = "busy";
    private static final String STATE_CHECKED = "checked";
    private static final String STATE_EXPANDED = "expanded";
    private static final String STATE_MIXED = "mixed";
    private static MatrixMathHelper.MatrixDecompositionContext sMatrixDecompositionContext = new MatrixMathHelper.MatrixDecompositionContext();
    public static final Map<String, Integer> sStateDescription;
    private static double[] sTransformDecompositionArray = new double[16];

    static {
        HashMap hashMap = new HashMap();
        sStateDescription = hashMap;
        hashMap.put(STATE_BUSY, Integer.valueOf(R.string.state_busy_description));
        hashMap.put(STATE_EXPANDED, Integer.valueOf(R.string.state_expanded_description));
        hashMap.put("collapsed", Integer.valueOf(R.string.state_collapsed_description));
    }

    private void logUnsupportedPropertyWarning(String str) {
        FLog.w(ReactConstants.TAG, "%s doesn't support property '%s'", getName(), str);
    }

    private static void resetTransformProperty(View view) {
        view.setTranslationX(PixelUtil.toPixelFromDIP((float) CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        view.setTranslationY(PixelUtil.toPixelFromDIP((float) CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        view.setRotation(CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        view.setRotationX(CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        view.setRotationY(CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setCameraDistance(CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
    }

    private static float sanitizeFloatPropertyValue(float f2) {
        if (f2 >= -3.4028235E38f && f2 <= Float.MAX_VALUE) {
            return f2;
        }
        if (f2 < -3.4028235E38f || f2 == Float.NEGATIVE_INFINITY) {
            return -3.4028235E38f;
        }
        if (f2 > Float.MAX_VALUE || f2 == Float.POSITIVE_INFINITY) {
            return Float.MAX_VALUE;
        }
        if (Float.isNaN(f2)) {
            return CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        }
        throw new IllegalStateException("Invalid float property value: " + f2);
    }

    private static void setTransformProperty(View view, ReadableArray readableArray) {
        sMatrixDecompositionContext.reset();
        TransformHelper.processTransform(readableArray, sTransformDecompositionArray);
        MatrixMathHelper.decomposeMatrix(sTransformDecompositionArray, sMatrixDecompositionContext);
        view.setTranslationX(PixelUtil.toPixelFromDIP(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.translation[0])));
        view.setTranslationY(PixelUtil.toPixelFromDIP(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.translation[1])));
        view.setRotation(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.rotationDegrees[2]));
        view.setRotationX(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.rotationDegrees[0]));
        view.setRotationY(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.rotationDegrees[1]));
        view.setScaleX(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.scale[0]));
        view.setScaleY(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.scale[1]));
        double[] dArr = sMatrixDecompositionContext.perspective;
        if (dArr.length > 2) {
            float f2 = (float) dArr[2];
            if (f2 == CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                f2 = 7.8125E-4f;
            }
            float f3 = -1.0f / f2;
            float f4 = DisplayMetricsHolder.getScreenDisplayMetrics().density;
            view.setCameraDistance(sanitizeFloatPropertyValue(f4 * f4 * f3 * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        }
    }

    private void updateViewAccessibility(T t2) {
        ReactAccessibilityDelegate.setDelegate(t2, t2.isFocusable(), t2.getImportantForAccessibility());
    }

    private void updateViewContentDescription(T t2) {
        Dynamic dynamic;
        int i2;
        String str = (String) t2.getTag(R.id.accessibility_label);
        ReadableMap readableMap = (ReadableMap) t2.getTag(R.id.accessibility_state);
        String str2 = (String) t2.getTag(R.id.accessibility_hint);
        ArrayList arrayList = new ArrayList();
        ReadableMap readableMap2 = (ReadableMap) t2.getTag(R.id.accessibility_value);
        if (str != null) {
            arrayList.add(str);
        }
        if (readableMap != null) {
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                Dynamic dynamic2 = readableMap.getDynamic(nextKey);
                if (nextKey.equals(STATE_CHECKED) && dynamic2.getType() == ReadableType.String && dynamic2.asString().equals(STATE_MIXED)) {
                    arrayList.add(t2.getContext().getString(R.string.state_mixed_description));
                } else if (nextKey.equals(STATE_BUSY) && dynamic2.getType() == ReadableType.Boolean && dynamic2.asBoolean()) {
                    arrayList.add(t2.getContext().getString(R.string.state_busy_description));
                } else if (nextKey.equals(STATE_EXPANDED) && dynamic2.getType() == ReadableType.Boolean) {
                    Context context = t2.getContext();
                    if (dynamic2.asBoolean()) {
                        i2 = R.string.state_expanded_description;
                    } else {
                        i2 = R.string.state_collapsed_description;
                    }
                    arrayList.add(context.getString(i2));
                }
            }
        }
        if (readableMap2 != null && readableMap2.hasKey("text") && (dynamic = readableMap2.getDynamic("text")) != null && dynamic.getType() == ReadableType.String) {
            arrayList.add(dynamic.asString());
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (arrayList.size() > 0) {
            t2.setContentDescription(TextUtils.join(", ", arrayList));
        }
    }

    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        MapBuilder.Builder put = MapBuilder.builder().put(PointerEventHelper.POINTER_CANCEL, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPointerCancel", "captured", "onPointerCancelCapture"))).put(PointerEventHelper.POINTER_DOWN, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPointerDown", "captured", "onPointerDownCapture")));
        Boolean bool = Boolean.TRUE;
        exportedCustomDirectEventTypeConstants.putAll(put.put(PointerEventHelper.POINTER_ENTER, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPointerEnter2", "captured", "onPointerEnter2Capture", "skipBubbling", bool))).put(PointerEventHelper.POINTER_LEAVE, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPointerLeave2", "captured", "onPointerLeave2Capture", "skipBubbling", bool))).put(PointerEventHelper.POINTER_MOVE, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPointerMove2", "captured", "onPointerMove2Capture"))).put(PointerEventHelper.POINTER_UP, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPointerUp", "captured", "onPointerUpCapture"))).build());
        return exportedCustomDirectEventTypeConstants;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.putAll(MapBuilder.builder().put(ReactAccessibilityDelegate.TOP_ACCESSIBILITY_ACTION_EVENT, MapBuilder.of("registrationName", "onAccessibilityAction")).build());
        return exportedCustomDirectEventTypeConstants;
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(T t2) {
        super.onAfterUpdateTransaction(t2);
        updateViewAccessibility(t2);
    }

    @ReactProp(name = "accessibilityActions")
    public void setAccessibilityActions(T t2, ReadableArray readableArray) {
        if (readableArray != null) {
            t2.setTag(R.id.accessibility_actions, readableArray);
        }
    }

    @ReactProp(name = "accessibilityHint")
    public void setAccessibilityHint(T t2, String str) {
        t2.setTag(R.id.accessibility_hint, str);
        updateViewContentDescription(t2);
    }

    @ReactProp(name = "accessibilityLabel")
    public void setAccessibilityLabel(T t2, String str) {
        t2.setTag(R.id.accessibility_label, str);
        updateViewContentDescription(t2);
    }

    @ReactProp(name = "accessibilityLabelledBy")
    public void setAccessibilityLabelledBy(T t2, Dynamic dynamic) {
        if (!dynamic.isNull()) {
            if (dynamic.getType() == ReadableType.String) {
                t2.setTag(R.id.labelled_by, dynamic.asString());
            } else if (dynamic.getType() == ReadableType.Array) {
                t2.setTag(R.id.labelled_by, dynamic.asArray().getString(0));
            }
        }
    }

    @ReactProp(name = "accessibilityLiveRegion")
    public void setAccessibilityLiveRegion(T t2, String str) {
        if (str == null || str.equals("none")) {
            ViewCompat.t0(t2, 0);
        } else if (str.equals("polite")) {
            ViewCompat.t0(t2, 1);
        } else if (str.equals("assertive")) {
            ViewCompat.t0(t2, 2);
        }
    }

    @ReactProp(name = "accessibilityRole")
    public void setAccessibilityRole(T t2, String str) {
        if (str != null) {
            t2.setTag(R.id.accessibility_role, ReactAccessibilityDelegate.AccessibilityRole.fromValue(str));
        }
    }

    @ReactProp(name = "accessibilityValue")
    public void setAccessibilityValue(T t2, ReadableMap readableMap) {
        if (readableMap != null) {
            t2.setTag(R.id.accessibility_value, readableMap);
            if (readableMap.hasKey("text")) {
                updateViewContentDescription(t2);
            }
        }
    }

    @ReactProp(customType = "Color", defaultInt = 0, name = "backgroundColor")
    public void setBackgroundColor(T t2, int i2) {
        t2.setBackgroundColor(i2);
    }

    public void setBorderBottomLeftRadius(T t2, float f2) {
        logUnsupportedPropertyWarning(ViewProps.BORDER_BOTTOM_LEFT_RADIUS);
    }

    public void setBorderBottomRightRadius(T t2, float f2) {
        logUnsupportedPropertyWarning(ViewProps.BORDER_BOTTOM_RIGHT_RADIUS);
    }

    public void setBorderRadius(T t2, float f2) {
        logUnsupportedPropertyWarning(ViewProps.BORDER_RADIUS);
    }

    public void setBorderTopLeftRadius(T t2, float f2) {
        logUnsupportedPropertyWarning(ViewProps.BORDER_TOP_LEFT_RADIUS);
    }

    public void setBorderTopRightRadius(T t2, float f2) {
        logUnsupportedPropertyWarning(ViewProps.BORDER_TOP_RIGHT_RADIUS);
    }

    @ReactProp(name = "elevation")
    public void setElevation(T t2, float f2) {
        ViewCompat.z0(t2, PixelUtil.toPixelFromDIP(f2));
    }

    @ReactProp(name = "importantForAccessibility")
    public void setImportantForAccessibility(T t2, String str) {
        if (str == null || str.equals("auto")) {
            ViewCompat.C0(t2, 0);
        } else if (str.equals("yes")) {
            ViewCompat.C0(t2, 1);
        } else if (str.equals("no")) {
            ViewCompat.C0(t2, 2);
        } else if (str.equals("no-hide-descendants")) {
            ViewCompat.C0(t2, 4);
        }
    }

    @ReactProp(name = "onMoveShouldSetResponder")
    public void setMoveShouldSetResponder(T t2, boolean z2) {
    }

    @ReactProp(name = "onMoveShouldSetResponderCapture")
    public void setMoveShouldSetResponderCapture(T t2, boolean z2) {
    }

    @ReactProp(name = "nativeID")
    public void setNativeId(T t2, String str) {
        t2.setTag(R.id.view_tag_native_id, str);
        ReactFindViewUtil.notifyViewRendered(t2);
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(T t2, float f2) {
        t2.setAlpha(f2);
    }

    @ReactProp(name = "onPointerEnter")
    public void setPointerEnter(T t2, boolean z2) {
        t2.setTag(R.id.pointer_enter, Boolean.valueOf(z2));
    }

    @ReactProp(name = "onPointerLeave")
    public void setPointerLeave(T t2, boolean z2) {
        t2.setTag(R.id.pointer_leave, Boolean.valueOf(z2));
    }

    @ReactProp(name = "onPointerMove")
    public void setPointerMove(T t2, boolean z2) {
        t2.setTag(R.id.pointer_move, Boolean.valueOf(z2));
    }

    @ReactProp(name = "renderToHardwareTextureAndroid")
    public void setRenderToHardwareTexture(T t2, boolean z2) {
        t2.setLayerType(z2 ? 2 : 0, (Paint) null);
    }

    @ReactProp(name = "onResponderEnd")
    public void setResponderEnd(T t2, boolean z2) {
    }

    @ReactProp(name = "onResponderGrant")
    public void setResponderGrant(T t2, boolean z2) {
    }

    @ReactProp(name = "onResponderMove")
    public void setResponderMove(T t2, boolean z2) {
    }

    @ReactProp(name = "onResponderReject")
    public void setResponderReject(T t2, boolean z2) {
    }

    @ReactProp(name = "onResponderRelease")
    public void setResponderRelease(T t2, boolean z2) {
    }

    @ReactProp(name = "onResponderStart")
    public void setResponderStart(T t2, boolean z2) {
    }

    @ReactProp(name = "onResponderTerminate")
    public void setResponderTerminate(T t2, boolean z2) {
    }

    @ReactProp(name = "onResponderTerminationRequest")
    public void setResponderTerminationRequest(T t2, boolean z2) {
    }

    @ReactProp(name = "rotation")
    @Deprecated
    public void setRotation(T t2, float f2) {
        t2.setRotation(f2);
    }

    @ReactProp(defaultFloat = 1.0f, name = "scaleX")
    @Deprecated
    public void setScaleX(T t2, float f2) {
        t2.setScaleX(f2);
    }

    @ReactProp(defaultFloat = 1.0f, name = "scaleY")
    @Deprecated
    public void setScaleY(T t2, float f2) {
        t2.setScaleY(f2);
    }

    @ReactProp(customType = "Color", defaultInt = -16777216, name = "shadowColor")
    public void setShadowColor(T t2, int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            t2.setOutlineAmbientShadowColor(i2);
            t2.setOutlineSpotShadowColor(i2);
        }
    }

    @ReactProp(name = "onShouldBlockNativeResponder")
    public void setShouldBlockNativeResponder(T t2, boolean z2) {
    }

    @ReactProp(name = "onStartShouldSetResponder")
    public void setStartShouldSetResponder(T t2, boolean z2) {
    }

    @ReactProp(name = "onStartShouldSetResponderCapture")
    public void setStartShouldSetResponderCapture(T t2, boolean z2) {
    }

    @ReactProp(name = "testID")
    public void setTestId(T t2, String str) {
        t2.setTag(R.id.react_test_id, str);
        t2.setTag(str);
    }

    @ReactProp(name = "onTouchCancel")
    public void setTouchCancel(T t2, boolean z2) {
    }

    @ReactProp(name = "onTouchEnd")
    public void setTouchEnd(T t2, boolean z2) {
    }

    @ReactProp(name = "onTouchMove")
    public void setTouchMove(T t2, boolean z2) {
    }

    @ReactProp(name = "onTouchStart")
    public void setTouchStart(T t2, boolean z2) {
    }

    @ReactProp(name = "transform")
    public void setTransform(T t2, ReadableArray readableArray) {
        if (readableArray == null) {
            resetTransformProperty(t2);
        } else {
            setTransformProperty(t2, readableArray);
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "translateX")
    @Deprecated
    public void setTranslateX(T t2, float f2) {
        t2.setTranslationX(PixelUtil.toPixelFromDIP(f2));
    }

    @ReactProp(defaultFloat = 0.0f, name = "translateY")
    @Deprecated
    public void setTranslateY(T t2, float f2) {
        t2.setTranslationY(PixelUtil.toPixelFromDIP(f2));
    }

    @ReactProp(name = "accessibilityState")
    public void setViewState(T t2, ReadableMap readableMap) {
        if (readableMap != null) {
            if (readableMap.hasKey("selected")) {
                boolean isSelected = t2.isSelected();
                boolean z2 = readableMap.getBoolean("selected");
                t2.setSelected(z2);
                if (t2.isAccessibilityFocused() && isSelected && !z2) {
                    t2.announceForAccessibility(t2.getContext().getString(R.string.state_unselected_description));
                }
            } else {
                t2.setSelected(false);
            }
            t2.setTag(R.id.accessibility_state, readableMap);
            t2.setEnabled(true);
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                if (nextKey.equals(STATE_BUSY) || nextKey.equals(STATE_EXPANDED) || (nextKey.equals(STATE_CHECKED) && readableMap.getType(STATE_CHECKED) == ReadableType.String)) {
                    updateViewContentDescription(t2);
                    return;
                } else if (t2.isAccessibilityFocused()) {
                    t2.sendAccessibilityEvent(1);
                }
            }
        }
    }

    @ReactProp(name = "zIndex")
    public void setZIndex(T t2, float f2) {
        ViewGroupManager.setViewZIndex(t2, Math.round(f2));
        ViewParent parent = t2.getParent();
        if (parent instanceof ReactZIndexedViewGroup) {
            ((ReactZIndexedViewGroup) parent).updateDrawingOrder();
        }
    }
}
