package com.facebook.react;

import android.view.KeyEvent;
import android.view.View;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ViewProps;
import java.util.Map;

public class ReactAndroidHWInputDeviceHelper {
    private static final Map<Integer, String> KEY_EVENTS_ACTIONS = MapBuilder.builder().put(23, "select").put(66, "select").put(62, "select").put(85, "playPause").put(89, "rewind").put(90, "fastForward").put(86, "stop").put(87, "next").put(88, "previous").put(19, "up").put(22, ViewProps.RIGHT).put(20, "down").put(21, ViewProps.LEFT).put(165, "info").put(82, "menu").build();
    private int mLastFocusedViewId = -1;
    private final ReactRootView mReactRootView;

    ReactAndroidHWInputDeviceHelper(ReactRootView reactRootView) {
        this.mReactRootView = reactRootView;
    }

    private void dispatchEvent(String str, int i2) {
        dispatchEvent(str, i2, -1);
    }

    public void clearFocus() {
        int i2 = this.mLastFocusedViewId;
        if (i2 != -1) {
            dispatchEvent("blur", i2);
        }
        this.mLastFocusedViewId = -1;
    }

    public void handleKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        int action = keyEvent.getAction();
        if (action == 1 || action == 0) {
            Map<Integer, String> map = KEY_EVENTS_ACTIONS;
            if (map.containsKey(Integer.valueOf(keyCode))) {
                dispatchEvent(map.get(Integer.valueOf(keyCode)), this.mLastFocusedViewId, action);
            }
        }
    }

    public void onFocusChanged(View view) {
        if (this.mLastFocusedViewId != view.getId()) {
            int i2 = this.mLastFocusedViewId;
            if (i2 != -1) {
                dispatchEvent("blur", i2);
            }
            this.mLastFocusedViewId = view.getId();
            dispatchEvent("focus", view.getId());
        }
    }

    private void dispatchEvent(String str, int i2, int i3) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("eventType", str);
        writableNativeMap.putInt("eventKeyAction", i3);
        if (i2 != -1) {
            writableNativeMap.putInt("tag", i2);
        }
        this.mReactRootView.sendEvent("onHWKeyEvent", writableNativeMap);
    }
}
