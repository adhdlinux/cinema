package com.facebook.react.views.drawer;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerDelegate;
import com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface;
import com.facebook.react.views.drawer.events.DrawerClosedEvent;
import com.facebook.react.views.drawer.events.DrawerOpenedEvent;
import com.facebook.react.views.drawer.events.DrawerSlideEvent;
import com.facebook.react.views.drawer.events.DrawerStateChangedEvent;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "AndroidDrawerLayout")
public class ReactDrawerLayoutManager extends ViewGroupManager<ReactDrawerLayout> implements AndroidDrawerLayoutManagerInterface<ReactDrawerLayout> {
    public static final int CLOSE_DRAWER = 2;
    public static final int OPEN_DRAWER = 1;
    public static final String REACT_CLASS = "AndroidDrawerLayout";
    private final ViewManagerDelegate<ReactDrawerLayout> mDelegate = new AndroidDrawerLayoutManagerDelegate(this);

    public static class DrawerEventEmitter implements DrawerLayout.DrawerListener {
        private final DrawerLayout mDrawerLayout;
        private final EventDispatcher mEventDispatcher;

        public DrawerEventEmitter(DrawerLayout drawerLayout, EventDispatcher eventDispatcher) {
            this.mDrawerLayout = drawerLayout;
            this.mEventDispatcher = eventDispatcher;
        }

        public void onDrawerClosed(View view) {
            this.mEventDispatcher.dispatchEvent(new DrawerClosedEvent(UIManagerHelper.getSurfaceId((View) this.mDrawerLayout), this.mDrawerLayout.getId()));
        }

        public void onDrawerOpened(View view) {
            this.mEventDispatcher.dispatchEvent(new DrawerOpenedEvent(UIManagerHelper.getSurfaceId((View) this.mDrawerLayout), this.mDrawerLayout.getId()));
        }

        public void onDrawerSlide(View view, float f2) {
            this.mEventDispatcher.dispatchEvent(new DrawerSlideEvent(UIManagerHelper.getSurfaceId((View) this.mDrawerLayout), this.mDrawerLayout.getId(), f2));
        }

        public void onDrawerStateChanged(int i2) {
            this.mEventDispatcher.dispatchEvent(new DrawerStateChangedEvent(UIManagerHelper.getSurfaceId((View) this.mDrawerLayout), this.mDrawerLayout.getId(), i2));
        }
    }

    private void setDrawerPositionInternal(ReactDrawerLayout reactDrawerLayout, String str) {
        if (str.equals(ViewProps.LEFT)) {
            reactDrawerLayout.setDrawerPosition(8388611);
        } else if (str.equals(ViewProps.RIGHT)) {
            reactDrawerLayout.setDrawerPosition(8388613);
        } else {
            throw new JSApplicationIllegalArgumentException("drawerPosition must be 'left' or 'right', received" + str);
        }
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("openDrawer", 1, "closeDrawer", 2);
    }

    public ViewManagerDelegate<ReactDrawerLayout> getDelegate() {
        return this.mDelegate;
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        Map exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap();
        }
        exportedCustomDirectEventTypeConstants.putAll(MapBuilder.of(DrawerSlideEvent.EVENT_NAME, MapBuilder.of("registrationName", "onDrawerSlide"), DrawerOpenedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onDrawerOpen"), DrawerClosedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onDrawerClose"), DrawerStateChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onDrawerStateChanged")));
        return exportedCustomDirectEventTypeConstants;
    }

    public Map getExportedViewConstants() {
        return MapBuilder.of("DrawerPosition", MapBuilder.of("Left", 8388611, "Right", 8388613));
    }

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @ReactProp(customType = "Color", name = "drawerBackgroundColor")
    public void setDrawerBackgroundColor(ReactDrawerLayout reactDrawerLayout, Integer num) {
    }

    @ReactProp(name = "keyboardDismissMode")
    public void setKeyboardDismissMode(ReactDrawerLayout reactDrawerLayout, String str) {
    }

    @ReactProp(customType = "Color", name = "statusBarBackgroundColor")
    public void setStatusBarBackgroundColor(ReactDrawerLayout reactDrawerLayout, Integer num) {
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, ReactDrawerLayout reactDrawerLayout) {
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(themedReactContext, reactDrawerLayout.getId());
        if (eventDispatcherForReactTag != null) {
            reactDrawerLayout.addDrawerListener(new DrawerEventEmitter(reactDrawerLayout, eventDispatcherForReactTag));
        }
    }

    public void addView(ReactDrawerLayout reactDrawerLayout, View view, int i2) {
        if (getChildCount(reactDrawerLayout) >= 2) {
            throw new JSApplicationIllegalArgumentException("The Drawer cannot have more than two children");
        } else if (i2 == 0 || i2 == 1) {
            reactDrawerLayout.addView(view, i2);
            reactDrawerLayout.setDrawerProperties();
        } else {
            throw new JSApplicationIllegalArgumentException("The only valid indices for drawer's child are 0 or 1. Got " + i2 + " instead.");
        }
    }

    public void closeDrawer(ReactDrawerLayout reactDrawerLayout) {
        reactDrawerLayout.closeDrawer();
    }

    /* access modifiers changed from: protected */
    public ReactDrawerLayout createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactDrawerLayout(themedReactContext);
    }

    public void openDrawer(ReactDrawerLayout reactDrawerLayout) {
        reactDrawerLayout.openDrawer();
    }

    @ReactProp(name = "drawerLockMode")
    public void setDrawerLockMode(ReactDrawerLayout reactDrawerLayout, String str) {
        if (str == null || "unlocked".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(0);
        } else if ("locked-closed".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(1);
        } else if ("locked-open".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(2);
        } else {
            throw new JSApplicationIllegalArgumentException("Unknown drawerLockMode " + str);
        }
    }

    public void setDrawerPosition(ReactDrawerLayout reactDrawerLayout, String str) {
        if (str == null) {
            reactDrawerLayout.setDrawerPosition(8388611);
        } else {
            setDrawerPositionInternal(reactDrawerLayout, str);
        }
    }

    @ReactProp(defaultFloat = Float.NaN, name = "drawerWidth")
    public void setDrawerWidth(ReactDrawerLayout reactDrawerLayout, float f2) {
        int i2;
        if (Float.isNaN(f2)) {
            i2 = -1;
        } else {
            i2 = Math.round(PixelUtil.toPixelFromDIP(f2));
        }
        reactDrawerLayout.setDrawerWidth(i2);
    }

    public void setElevation(ReactDrawerLayout reactDrawerLayout, float f2) {
        reactDrawerLayout.setDrawerElevation(PixelUtil.toPixelFromDIP(f2));
    }

    public void receiveCommand(ReactDrawerLayout reactDrawerLayout, int i2, ReadableArray readableArray) {
        if (i2 == 1) {
            reactDrawerLayout.openDrawer();
        } else if (i2 == 2) {
            reactDrawerLayout.closeDrawer();
        }
    }

    @ReactProp(name = "drawerPosition")
    public void setDrawerPosition(ReactDrawerLayout reactDrawerLayout, Dynamic dynamic) {
        if (dynamic.isNull()) {
            reactDrawerLayout.setDrawerPosition(8388611);
        } else if (dynamic.getType() == ReadableType.Number) {
            int asInt = dynamic.asInt();
            if (8388611 == asInt || 8388613 == asInt) {
                reactDrawerLayout.setDrawerPosition(asInt);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Unknown drawerPosition " + asInt);
        } else if (dynamic.getType() == ReadableType.String) {
            setDrawerPositionInternal(reactDrawerLayout, dynamic.asString());
        } else {
            throw new JSApplicationIllegalArgumentException("drawerPosition must be a string or int");
        }
    }

    public void receiveCommand(ReactDrawerLayout reactDrawerLayout, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("closeDrawer")) {
            reactDrawerLayout.closeDrawer();
        } else if (str.equals("openDrawer")) {
            reactDrawerLayout.openDrawer();
        }
    }

    public void setDrawerWidth(ReactDrawerLayout reactDrawerLayout, Float f2) {
        reactDrawerLayout.setDrawerWidth(f2 == null ? -1 : Math.round(PixelUtil.toPixelFromDIP(f2.floatValue())));
    }
}
