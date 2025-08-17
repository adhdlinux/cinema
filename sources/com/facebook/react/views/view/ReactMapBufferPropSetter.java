package com.facebook.react.views.view;

import android.graphics.Rect;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

public final class ReactMapBufferPropSetter {
    private static final int ACCESSIBILITY_ACTION_LABEL = 1;
    private static final int ACCESSIBILITY_ACTION_NAME = 0;
    private static final int ACCESSIBILITY_STATE_BUSY = 0;
    private static final int ACCESSIBILITY_STATE_CHECKED = 4;
    private static final int ACCESSIBILITY_STATE_DISABLED = 1;
    private static final int ACCESSIBILITY_STATE_EXPANDED = 2;
    private static final int ACCESSIBILITY_STATE_SELECTED = 3;
    private static final int CORNER_ALL = 8;
    private static final int CORNER_BOTTOM_END = 6;
    private static final int CORNER_BOTTOM_LEFT = 3;
    private static final int CORNER_BOTTOM_RIGHT = 2;
    private static final int CORNER_BOTTOM_START = 7;
    private static final int CORNER_TOP_END = 5;
    private static final int CORNER_TOP_LEFT = 0;
    private static final int CORNER_TOP_RIGHT = 1;
    private static final int CORNER_TOP_START = 4;
    private static final int EDGE_ALL = 6;
    private static final int EDGE_BOTTOM = 3;
    private static final int EDGE_END = 5;
    private static final int EDGE_LEFT = 1;
    private static final int EDGE_RIGHT = 2;
    private static final int EDGE_START = 4;
    private static final int EDGE_TOP = 0;
    public static final ReactMapBufferPropSetter INSTANCE = new ReactMapBufferPropSetter();
    private static final int NATIVE_DRAWABLE_ATTRIBUTE = 1;
    private static final int NATIVE_DRAWABLE_BORDERLESS = 3;
    private static final int NATIVE_DRAWABLE_COLOR = 2;
    private static final int NATIVE_DRAWABLE_KIND = 0;
    private static final int NATIVE_DRAWABLE_RIPPLE_RADIUS = 4;
    private static final int UNDEF_COLOR = Integer.MAX_VALUE;
    private static final int VP_ACCESSIBILITY_ACTIONS = 0;
    private static final int VP_ACCESSIBILITY_HINT = 1;
    private static final int VP_ACCESSIBILITY_LABEL = 2;
    private static final int VP_ACCESSIBILITY_LABELLED_BY = 3;
    private static final int VP_ACCESSIBILITY_LIVE_REGION = 4;
    private static final int VP_ACCESSIBILITY_ROLE = 5;
    private static final int VP_ACCESSIBILITY_STATE = 6;
    private static final int VP_ACCESSIBILITY_VALUE = 7;
    private static final int VP_ACCESSIBLE = 8;
    private static final int VP_BACKFACE_VISIBILITY = 9;
    private static final int VP_BG_COLOR = 10;
    private static final int VP_BORDER_COLOR = 11;
    private static final int VP_BORDER_RADII = 12;
    private static final int VP_BORDER_STYLE = 13;
    private static final int VP_COLLAPSABLE = 14;
    private static final int VP_ELEVATION = 15;
    private static final int VP_FOCUSABLE = 16;
    private static final int VP_HAS_TV_FOCUS = 17;
    private static final int VP_HIT_SLOP = 18;
    private static final int VP_IMPORTANT_FOR_ACCESSIBILITY = 19;
    private static final int VP_NATIVE_BACKGROUND = 20;
    private static final int VP_NATIVE_FOREGROUND = 21;
    private static final int VP_NATIVE_ID = 22;
    private static final int VP_OFFSCREEN_ALPHA_COMPOSITING = 23;
    private static final int VP_OPACITY = 24;
    private static final int VP_POINTER_ENTER = 26;
    private static final int VP_POINTER_EVENTS = 25;
    private static final int VP_POINTER_LEAVE = 27;
    private static final int VP_POINTER_MOVE = 28;
    private static final int VP_REMOVE_CLIPPED_SUBVIEW = 29;
    private static final int VP_RENDER_TO_HARDWARE_TEXTURE = 30;
    private static final int VP_SHADOW_COLOR = 31;
    private static final int VP_TEST_ID = 32;
    private static final int VP_TRANSFORM = 33;
    private static final int VP_ZINDEX = 34;
    private static final int YG_BORDER_WIDTH = 100;
    private static final int YG_OVERFLOW = 101;

    private ReactMapBufferPropSetter() {
    }

    private final void accessibilityActions(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = mapBuffer.iterator();
        while (it2.hasNext()) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            MapBuffer mapBufferValue = ((MapBuffer.Entry) it2.next()).getMapBufferValue();
            if (mapBufferValue != null) {
                javaOnlyMap.putString("name", mapBufferValue.getString(0));
                if (mapBufferValue.contains(1)) {
                    javaOnlyMap.putString("label", mapBufferValue.getString(1));
                }
            }
            arrayList.add(javaOnlyMap);
        }
        reactViewManager.setAccessibilityActions(reactViewGroup, JavaOnlyArray.from(arrayList));
    }

    private final void accessibilityLabelledBy(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        DynamicFromObject dynamicFromObject;
        if (mapBuffer.getCount() == 0) {
            dynamicFromObject = new DynamicFromObject((Object) null);
        } else {
            JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
            Iterator it2 = mapBuffer.iterator();
            while (it2.hasNext()) {
                javaOnlyArray.pushString(((MapBuffer.Entry) it2.next()).getStringValue());
            }
            dynamicFromObject = new DynamicFromObject(javaOnlyArray);
        }
        reactViewManager.setAccessibilityLabelledBy(reactViewGroup, dynamicFromObject);
    }

    private final void accessibilityLiveRegion(ReactViewGroup reactViewGroup, int i2) {
        int i3 = 0;
        if (i2 != 0) {
            if (i2 == 1) {
                i3 = 1;
            } else if (i2 == 2) {
                i3 = 2;
            }
        }
        ViewCompat.t0(reactViewGroup, i3);
    }

    private final void accessibilityState(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putBoolean("selected", mapBuffer.getBoolean(3));
        javaOnlyMap.putBoolean("busy", mapBuffer.getBoolean(0));
        javaOnlyMap.putBoolean("expanded", mapBuffer.getBoolean(2));
        javaOnlyMap.putBoolean("disabled", mapBuffer.getBoolean(1));
        int i2 = mapBuffer.getInt(4);
        if (i2 == 0) {
            javaOnlyMap.putBoolean("checked", false);
        } else if (i2 == 1) {
            javaOnlyMap.putBoolean("checked", true);
        } else if (i2 == 2) {
            javaOnlyMap.putString("checked", "mixed");
        }
        reactViewManager.setViewState(reactViewGroup, javaOnlyMap);
    }

    private final void accessibilityValue(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, String str) {
        boolean z2;
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        if (str.length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            javaOnlyMap.putString("text", str);
        }
        reactViewManager.setAccessibilityValue(reactViewGroup, javaOnlyMap);
    }

    private final void backfaceVisibility(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, int i2) {
        String str;
        if (i2 == 1) {
            str = ViewProps.VISIBLE;
        } else if (i2 != 2) {
            str = "auto";
        } else {
            str = ViewProps.HIDDEN;
        }
        reactViewManager.setBackfaceVisibility(reactViewGroup, str);
    }

    private final void backgroundColor(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, int i2) {
        boolean z2;
        Integer valueOf = Integer.valueOf(i2);
        int i3 = 0;
        if (valueOf.intValue() != Integer.MAX_VALUE) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            valueOf = null;
        }
        if (valueOf != null) {
            i3 = valueOf.intValue();
        }
        reactViewManager.setBackgroundColor(reactViewGroup, i3);
    }

    private final void borderColor(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        int i2;
        Iterator it2 = mapBuffer.iterator();
        while (it2.hasNext()) {
            MapBuffer.Entry entry = (MapBuffer.Entry) it2.next();
            int key = entry.getKey();
            boolean z2 = false;
            switch (key) {
                case 0:
                    i2 = 3;
                    break;
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 2;
                    break;
                case 3:
                    i2 = 4;
                    break;
                case 4:
                    i2 = 5;
                    break;
                case 5:
                    i2 = 6;
                    break;
                case 6:
                    i2 = 0;
                    break;
                default:
                    throw new IllegalArgumentException(Intrinsics.o("Unknown key for border color: ", Integer.valueOf(key)));
            }
            Integer valueOf = Integer.valueOf(entry.getIntValue());
            if (valueOf.intValue() != -1) {
                z2 = true;
            }
            if (!z2) {
                valueOf = null;
            }
            reactViewManager.setBorderColor(reactViewGroup, i2, valueOf);
        }
    }

    private final void borderRadius(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        int i2;
        Iterator it2 = mapBuffer.iterator();
        while (it2.hasNext()) {
            MapBuffer.Entry entry = (MapBuffer.Entry) it2.next();
            int key = entry.getKey();
            switch (key) {
                case 0:
                    i2 = 1;
                    break;
                case 1:
                    i2 = 2;
                    break;
                case 2:
                    i2 = 3;
                    break;
                case 3:
                    i2 = 4;
                    break;
                case 4:
                    i2 = 5;
                    break;
                case 5:
                    i2 = 6;
                    break;
                case 6:
                    i2 = 8;
                    break;
                case 7:
                    i2 = 7;
                    break;
                case 8:
                    i2 = 0;
                    break;
                default:
                    throw new IllegalArgumentException(Intrinsics.o("Unknown key for border style: ", Integer.valueOf(key)));
            }
            double doubleValue = entry.getDoubleValue();
            if (!Double.isNaN(doubleValue)) {
                reactViewManager.setBorderRadius(reactViewGroup, i2, (float) doubleValue);
            }
        }
    }

    private final void borderStyle(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, int i2) {
        String str;
        if (i2 == 0) {
            str = "solid";
        } else if (i2 == 1) {
            str = "dotted";
        } else if (i2 != 2) {
            str = null;
        } else {
            str = "dashed";
        }
        reactViewManager.setBorderStyle(reactViewGroup, str);
    }

    private final void borderWidth(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        int i2;
        Iterator it2 = mapBuffer.iterator();
        while (it2.hasNext()) {
            MapBuffer.Entry entry = (MapBuffer.Entry) it2.next();
            int key = entry.getKey();
            switch (key) {
                case 0:
                    i2 = 3;
                    break;
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 2;
                    break;
                case 3:
                    i2 = 4;
                    break;
                case 4:
                    i2 = 5;
                    break;
                case 5:
                    i2 = 6;
                    break;
                case 6:
                    i2 = 0;
                    break;
                default:
                    throw new IllegalArgumentException(Intrinsics.o("Unknown key for border width: ", Integer.valueOf(key)));
            }
            double doubleValue = entry.getDoubleValue();
            if (!Double.isNaN(doubleValue)) {
                reactViewManager.setBorderWidth(reactViewGroup, i2, (float) doubleValue);
            }
        }
    }

    private final void hitSlop(ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        reactViewGroup.setHitSlopRect(new Rect((int) PixelUtil.toPixelFromDIP(mapBuffer.getDouble(1)), (int) PixelUtil.toPixelFromDIP(mapBuffer.getDouble(0)), (int) PixelUtil.toPixelFromDIP(mapBuffer.getDouble(2)), (int) PixelUtil.toPixelFromDIP(mapBuffer.getDouble(3))));
    }

    private final void importantForAccessibility(ReactViewGroup reactViewGroup, int i2) {
        int i3 = 0;
        if (i2 != 0) {
            if (i2 == 1) {
                i3 = 1;
            } else if (i2 == 2) {
                i3 = 2;
            } else if (i2 == 3) {
                i3 = 4;
            }
        }
        ViewCompat.C0(reactViewGroup, i3);
    }

    private final void nativeBackground(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        reactViewManager.setNativeBackground(reactViewGroup, toJsDrawableDescription(mapBuffer));
    }

    private final void nativeForeground(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        reactViewManager.setNativeForeground(reactViewGroup, toJsDrawableDescription(mapBuffer));
    }

    private final void overflow(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, int i2) {
        String str;
        if (i2 == 0) {
            str = ViewProps.VISIBLE;
        } else if (i2 == 1) {
            str = ViewProps.HIDDEN;
        } else if (i2 == 2) {
            str = ViewProps.SCROLL;
        } else {
            throw new IllegalArgumentException(Intrinsics.o("Unknown overflow value: ", Integer.valueOf(i2)));
        }
        reactViewManager.setOverflow(reactViewGroup, str);
    }

    private final void pointerEvents(ReactViewGroup reactViewGroup, int i2) {
        PointerEvents pointerEvents;
        if (i2 == 0) {
            pointerEvents = PointerEvents.AUTO;
        } else if (i2 == 1) {
            pointerEvents = PointerEvents.NONE;
        } else if (i2 == 2) {
            pointerEvents = PointerEvents.BOX_NONE;
        } else if (i2 == 3) {
            pointerEvents = PointerEvents.BOX_ONLY;
        } else {
            throw new IllegalArgumentException(Intrinsics.o("Unknown value for pointer events: ", Integer.valueOf(i2)));
        }
        reactViewGroup.setPointerEvents(pointerEvents);
    }

    private final void shadowColor(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, int i2) {
        boolean z2;
        int i3;
        Integer valueOf = Integer.valueOf(i2);
        if (valueOf.intValue() != Integer.MAX_VALUE) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            valueOf = null;
        }
        if (valueOf == null) {
            i3 = -16777216;
        } else {
            i3 = valueOf.intValue();
        }
        reactViewManager.setShadowColor(reactViewGroup, i3);
    }

    private final ReadableMap toJsDrawableDescription(MapBuffer mapBuffer) {
        if (mapBuffer.getCount() == 0) {
            return null;
        }
        int i2 = mapBuffer.getInt(0);
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        if (i2 == 0) {
            javaOnlyMap.putString("type", "ThemeAttrAndroid");
            javaOnlyMap.putString("attribute", mapBuffer.getString(1));
        } else if (i2 == 1) {
            javaOnlyMap.putString("type", "RippleAndroid");
            if (mapBuffer.contains(2)) {
                javaOnlyMap.putInt(ViewProps.COLOR, mapBuffer.getInt(2));
            }
            javaOnlyMap.putBoolean("borderless", mapBuffer.getBoolean(3));
            if (mapBuffer.contains(4)) {
                javaOnlyMap.putDouble("rippleRadius", mapBuffer.getDouble(4));
            }
        } else {
            throw new IllegalArgumentException(Intrinsics.o("Unknown native drawable: ", Integer.valueOf(i2)));
        }
        return javaOnlyMap;
    }

    private final void transform(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        Iterator it2 = mapBuffer.iterator();
        while (it2.hasNext()) {
            javaOnlyArray.pushDouble(((MapBuffer.Entry) it2.next()).getDoubleValue());
        }
        reactViewManager.setTransform(reactViewGroup, (ReadableArray) javaOnlyArray);
    }

    public final void setProps(ReactViewGroup reactViewGroup, ReactViewManager reactViewManager, MapBuffer mapBuffer) {
        Intrinsics.f(reactViewGroup, "view");
        Intrinsics.f(reactViewManager, "viewManager");
        Intrinsics.f(mapBuffer, "props");
        Iterator it2 = mapBuffer.iterator();
        while (it2.hasNext()) {
            MapBuffer.Entry entry = (MapBuffer.Entry) it2.next();
            int key = entry.getKey();
            if (key == 100) {
                borderWidth(reactViewManager, reactViewGroup, entry.getMapBufferValue());
            } else if (key != 101) {
                String str = null;
                boolean z2 = true;
                switch (key) {
                    case 0:
                        accessibilityActions(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                        break;
                    case 1:
                        String stringValue = entry.getStringValue();
                        if (stringValue.length() <= 0) {
                            z2 = false;
                        }
                        if (z2) {
                            str = stringValue;
                        }
                        reactViewManager.setAccessibilityHint(reactViewGroup, str);
                        break;
                    case 2:
                        String stringValue2 = entry.getStringValue();
                        if (stringValue2.length() <= 0) {
                            z2 = false;
                        }
                        if (z2) {
                            str = stringValue2;
                        }
                        reactViewManager.setAccessibilityLabel(reactViewGroup, str);
                        break;
                    case 3:
                        accessibilityLabelledBy(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                        break;
                    case 4:
                        accessibilityLiveRegion(reactViewGroup, entry.getIntValue());
                        break;
                    case 5:
                        String stringValue3 = entry.getStringValue();
                        if (stringValue3.length() <= 0) {
                            z2 = false;
                        }
                        if (z2) {
                            str = stringValue3;
                        }
                        reactViewManager.setAccessibilityRole(reactViewGroup, str);
                        break;
                    case 6:
                        accessibilityState(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                        break;
                    case 7:
                        accessibilityValue(reactViewManager, reactViewGroup, entry.getStringValue());
                        break;
                    case 8:
                        reactViewManager.setAccessible(reactViewGroup, entry.getBooleanValue());
                        break;
                    case 9:
                        backfaceVisibility(reactViewManager, reactViewGroup, entry.getIntValue());
                        break;
                    case 10:
                        backgroundColor(reactViewManager, reactViewGroup, entry.getIntValue());
                        break;
                    case 11:
                        borderColor(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                        break;
                    case 12:
                        borderRadius(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                        break;
                    case 13:
                        borderStyle(reactViewManager, reactViewGroup, entry.getIntValue());
                        break;
                    default:
                        switch (key) {
                            case 15:
                                reactViewManager.setElevation(reactViewGroup, (float) entry.getDoubleValue());
                                break;
                            case 16:
                                reactViewManager.setFocusable(reactViewGroup, entry.getBooleanValue());
                                break;
                            case 17:
                                reactViewManager.setTVPreferredFocus(reactViewGroup, entry.getBooleanValue());
                                break;
                            case 18:
                                hitSlop(reactViewGroup, entry.getMapBufferValue());
                                break;
                            case 19:
                                importantForAccessibility(reactViewGroup, entry.getIntValue());
                                break;
                            case 20:
                                nativeBackground(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                                break;
                            case 21:
                                nativeForeground(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                                break;
                            case 22:
                                String stringValue4 = entry.getStringValue();
                                if (stringValue4.length() <= 0) {
                                    z2 = false;
                                }
                                if (z2) {
                                    str = stringValue4;
                                }
                                reactViewManager.setNativeId(reactViewGroup, str);
                                break;
                            case 23:
                                reactViewManager.setNeedsOffscreenAlphaCompositing(reactViewGroup, entry.getBooleanValue());
                                break;
                            case 24:
                                reactViewManager.setOpacity(reactViewGroup, (float) entry.getDoubleValue());
                                break;
                            case 25:
                                pointerEvents(reactViewGroup, entry.getIntValue());
                                break;
                            case 26:
                                reactViewManager.setPointerEnter(reactViewGroup, entry.getBooleanValue());
                                break;
                            case 27:
                                reactViewManager.setPointerLeave(reactViewGroup, entry.getBooleanValue());
                                break;
                            case 28:
                                reactViewManager.setPointerMove(reactViewGroup, entry.getBooleanValue());
                                break;
                            case 29:
                                reactViewManager.setRemoveClippedSubviews(reactViewGroup, entry.getBooleanValue());
                                break;
                            case 30:
                                reactViewManager.setRenderToHardwareTexture(reactViewGroup, entry.getBooleanValue());
                                break;
                            case 31:
                                shadowColor(reactViewManager, reactViewGroup, entry.getIntValue());
                                break;
                            case 32:
                                String stringValue5 = entry.getStringValue();
                                if (stringValue5.length() <= 0) {
                                    z2 = false;
                                }
                                if (z2) {
                                    str = stringValue5;
                                }
                                reactViewManager.setTestId(reactViewGroup, str);
                                break;
                            case 33:
                                transform(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                                break;
                            case 34:
                                reactViewManager.setZIndex(reactViewGroup, (float) entry.getIntValue());
                                break;
                        }
                }
            } else {
                overflow(reactViewManager, reactViewGroup, entry.getIntValue());
            }
        }
    }
}
