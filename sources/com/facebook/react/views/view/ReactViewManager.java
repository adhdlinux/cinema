package com.facebook.react.views.view;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.yoga.YogaConstants;
import java.util.Map;

@ReactModule(name = "RCTView")
public class ReactViewManager extends ReactClippingViewManager<ReactViewGroup> {
    private static final int CMD_HOTSPOT_UPDATE = 1;
    private static final int CMD_SET_PRESSED = 2;
    private static final String HOTSPOT_UPDATE_KEY = "hotspotUpdate";
    @VisibleForTesting
    public static final String REACT_CLASS = "RCTView";
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3, 4, 5};

    /* renamed from: com.facebook.react.views.view.ReactViewManager$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$bridge$ReadableType = r0
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Null     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Map     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.ReactViewManager.AnonymousClass2.<clinit>():void");
        }
    }

    private void handleHotspotUpdate(ReactViewGroup reactViewGroup, ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() != 2) {
            throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'updateHotspot' command");
        }
        reactViewGroup.drawableHotspotChanged(PixelUtil.toPixelFromDIP(readableArray.getDouble(0)), PixelUtil.toPixelFromDIP(readableArray.getDouble(1)));
    }

    private void handleSetPressed(ReactViewGroup reactViewGroup, ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() != 1) {
            throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'setPressed' command");
        }
        reactViewGroup.setPressed(readableArray.getBoolean(0));
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of(HOTSPOT_UPDATE_KEY, 1, "setPressed", 2);
    }

    public String getName() {
        return "RCTView";
    }

    @ReactProp(defaultInt = -1, name = "nextFocusDown")
    public void nextFocusDown(ReactViewGroup reactViewGroup, int i2) {
        reactViewGroup.setNextFocusDownId(i2);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusForward")
    public void nextFocusForward(ReactViewGroup reactViewGroup, int i2) {
        reactViewGroup.setNextFocusForwardId(i2);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusLeft")
    public void nextFocusLeft(ReactViewGroup reactViewGroup, int i2) {
        reactViewGroup.setNextFocusLeftId(i2);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusRight")
    public void nextFocusRight(ReactViewGroup reactViewGroup, int i2) {
        reactViewGroup.setNextFocusRightId(i2);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusUp")
    public void nextFocusUp(ReactViewGroup reactViewGroup, int i2) {
        reactViewGroup.setNextFocusUpId(i2);
    }

    @ReactProp(name = "accessible")
    public void setAccessible(ReactViewGroup reactViewGroup, boolean z2) {
        reactViewGroup.setFocusable(z2);
    }

    @ReactProp(name = "backfaceVisibility")
    public void setBackfaceVisibility(ReactViewGroup reactViewGroup, String str) {
        reactViewGroup.setBackfaceVisibility(str);
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor", "borderStartColor", "borderEndColor"})
    public void setBorderColor(ReactViewGroup reactViewGroup, int i2, Integer num) {
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
        reactViewGroup.setBorderColor(SPACING_TYPES[i2], f2, f3);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius", "borderTopStartRadius", "borderTopEndRadius", "borderBottomStartRadius", "borderBottomEndRadius"})
    public void setBorderRadius(ReactViewGroup reactViewGroup, int i2, float f2) {
        if (!YogaConstants.isUndefined(f2) && f2 < 0.0f) {
            f2 = Float.NaN;
        }
        if (!YogaConstants.isUndefined(f2)) {
            f2 = PixelUtil.toPixelFromDIP(f2);
        }
        if (i2 == 0) {
            reactViewGroup.setBorderRadius(f2);
        } else {
            reactViewGroup.setBorderRadius(f2, i2 - 1);
        }
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactViewGroup reactViewGroup, String str) {
        reactViewGroup.setBorderStyle(str);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth", "borderStartWidth", "borderEndWidth"})
    public void setBorderWidth(ReactViewGroup reactViewGroup, int i2, float f2) {
        if (!YogaConstants.isUndefined(f2) && f2 < 0.0f) {
            f2 = Float.NaN;
        }
        if (!YogaConstants.isUndefined(f2)) {
            f2 = PixelUtil.toPixelFromDIP(f2);
        }
        reactViewGroup.setBorderWidth(SPACING_TYPES[i2], f2);
    }

    @ReactProp(name = "collapsable")
    public void setCollapsable(ReactViewGroup reactViewGroup, boolean z2) {
    }

    @ReactProp(name = "focusable")
    public void setFocusable(final ReactViewGroup reactViewGroup, boolean z2) {
        if (z2) {
            reactViewGroup.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) reactViewGroup.getContext(), reactViewGroup.getId());
                    if (eventDispatcherForReactTag != null) {
                        eventDispatcherForReactTag.dispatchEvent(new ViewGroupClickEvent(UIManagerHelper.getSurfaceId(reactViewGroup.getContext()), reactViewGroup.getId()));
                    }
                }
            });
            reactViewGroup.setFocusable(true);
            return;
        }
        reactViewGroup.setOnClickListener((View.OnClickListener) null);
        reactViewGroup.setClickable(false);
    }

    @ReactProp(name = "hitSlop")
    public void setHitSlop(ReactViewGroup reactViewGroup, Dynamic dynamic) {
        int i2;
        int i3;
        int i4;
        int i5 = AnonymousClass2.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()];
        if (i5 == 1) {
            reactViewGroup.setHitSlopRect((Rect) null);
        } else if (i5 == 2) {
            ReadableMap asMap = dynamic.asMap();
            int i6 = 0;
            if (asMap.hasKey(ViewProps.LEFT)) {
                i2 = (int) PixelUtil.toPixelFromDIP(asMap.getDouble(ViewProps.LEFT));
            } else {
                i2 = 0;
            }
            if (asMap.hasKey(ViewProps.TOP)) {
                i3 = (int) PixelUtil.toPixelFromDIP(asMap.getDouble(ViewProps.TOP));
            } else {
                i3 = 0;
            }
            if (asMap.hasKey(ViewProps.RIGHT)) {
                i4 = (int) PixelUtil.toPixelFromDIP(asMap.getDouble(ViewProps.RIGHT));
            } else {
                i4 = 0;
            }
            if (asMap.hasKey(ViewProps.BOTTOM)) {
                i6 = (int) PixelUtil.toPixelFromDIP(asMap.getDouble(ViewProps.BOTTOM));
            }
            reactViewGroup.setHitSlopRect(new Rect(i2, i3, i4, i6));
        } else if (i5 == 3) {
            int pixelFromDIP = (int) PixelUtil.toPixelFromDIP(dynamic.asDouble());
            reactViewGroup.setHitSlopRect(new Rect(pixelFromDIP, pixelFromDIP, pixelFromDIP, pixelFromDIP));
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid type for 'hitSlop' value " + dynamic.getType());
        }
    }

    @ReactProp(name = "nativeBackgroundAndroid")
    public void setNativeBackground(ReactViewGroup reactViewGroup, ReadableMap readableMap) {
        Drawable drawable;
        if (readableMap == null) {
            drawable = null;
        } else {
            drawable = ReactDrawableHelper.createDrawableFromJSDescription(reactViewGroup.getContext(), readableMap);
        }
        reactViewGroup.setTranslucentBackgroundDrawable(drawable);
    }

    @ReactProp(name = "nativeForegroundAndroid")
    @TargetApi(23)
    public void setNativeForeground(ReactViewGroup reactViewGroup, ReadableMap readableMap) {
        Drawable drawable;
        if (readableMap == null) {
            drawable = null;
        } else {
            drawable = ReactDrawableHelper.createDrawableFromJSDescription(reactViewGroup.getContext(), readableMap);
        }
        reactViewGroup.setForeground(drawable);
    }

    @ReactProp(name = "needsOffscreenAlphaCompositing")
    public void setNeedsOffscreenAlphaCompositing(ReactViewGroup reactViewGroup, boolean z2) {
        reactViewGroup.setNeedsOffscreenAlphaCompositing(z2);
    }

    @ReactProp(name = "overflow")
    public void setOverflow(ReactViewGroup reactViewGroup, String str) {
        reactViewGroup.setOverflow(str);
    }

    @ReactProp(name = "pointerEvents")
    public void setPointerEvents(ReactViewGroup reactViewGroup, String str) {
        reactViewGroup.setPointerEvents(PointerEvents.parsePointerEvents(str));
    }

    @ReactProp(name = "hasTVPreferredFocus")
    public void setTVPreferredFocus(ReactViewGroup reactViewGroup, boolean z2) {
        if (z2) {
            reactViewGroup.setFocusable(true);
            reactViewGroup.setFocusableInTouchMode(true);
            reactViewGroup.requestFocus();
        }
    }

    public ReactViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactViewGroup(themedReactContext);
    }

    public void setOpacity(ReactViewGroup reactViewGroup, float f2) {
        reactViewGroup.setOpacityIfPossible(f2);
    }

    public void setTransform(ReactViewGroup reactViewGroup, ReadableArray readableArray) {
        super.setTransform(reactViewGroup, readableArray);
        reactViewGroup.setBackfaceVisibilityDependantOpacity();
    }

    public void receiveCommand(ReactViewGroup reactViewGroup, int i2, ReadableArray readableArray) {
        if (i2 == 1) {
            handleHotspotUpdate(reactViewGroup, readableArray);
        } else if (i2 == 2) {
            handleSetPressed(reactViewGroup, readableArray);
        }
    }

    public void receiveCommand(ReactViewGroup reactViewGroup, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setPressed")) {
            handleSetPressed(reactViewGroup, readableArray);
        } else if (str.equals(HOTSPOT_UPDATE_KEY)) {
            handleHotspotUpdate(reactViewGroup, readableArray);
        }
    }
}
