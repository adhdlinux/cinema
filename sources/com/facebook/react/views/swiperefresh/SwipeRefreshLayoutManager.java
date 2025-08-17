package com.facebook.react.views.swiperefresh;

import android.view.View;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerDelegate;
import com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "AndroidSwipeRefreshLayout")
public class SwipeRefreshLayoutManager extends ViewGroupManager<ReactSwipeRefreshLayout> implements AndroidSwipeRefreshLayoutManagerInterface<ReactSwipeRefreshLayout> {
    public static final String REACT_CLASS = "AndroidSwipeRefreshLayout";
    private final ViewManagerDelegate<ReactSwipeRefreshLayout> mDelegate = new AndroidSwipeRefreshLayoutManagerDelegate(this);

    /* access modifiers changed from: protected */
    public ViewManagerDelegate<ReactSwipeRefreshLayout> getDelegate() {
        return this.mDelegate;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.putAll(MapBuilder.builder().put("topRefresh", MapBuilder.of("registrationName", "onRefresh")).build());
        return exportedCustomDirectEventTypeConstants;
    }

    public Map<String, Object> getExportedViewConstants() {
        return MapBuilder.of("SIZE", MapBuilder.of("DEFAULT", 1, "LARGE", 0));
    }

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(final ThemedReactContext themedReactContext, final ReactSwipeRefreshLayout reactSwipeRefreshLayout) {
        reactSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(themedReactContext, reactSwipeRefreshLayout.getId());
                if (eventDispatcherForReactTag != null) {
                    eventDispatcherForReactTag.dispatchEvent(new RefreshEvent(UIManagerHelper.getSurfaceId((View) reactSwipeRefreshLayout), reactSwipeRefreshLayout.getId()));
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public ReactSwipeRefreshLayout createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactSwipeRefreshLayout(themedReactContext);
    }

    public void receiveCommand(ReactSwipeRefreshLayout reactSwipeRefreshLayout, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setNativeRefreshing") && readableArray != null) {
            setRefreshing(reactSwipeRefreshLayout, readableArray.getBoolean(0));
        }
    }

    @ReactProp(customType = "ColorArray", name = "colors")
    public void setColors(ReactSwipeRefreshLayout reactSwipeRefreshLayout, ReadableArray readableArray) {
        if (readableArray != null) {
            int[] iArr = new int[readableArray.size()];
            for (int i2 = 0; i2 < readableArray.size(); i2++) {
                if (readableArray.getType(i2) == ReadableType.Map) {
                    iArr[i2] = ColorPropConverter.getColor(readableArray.getMap(i2), reactSwipeRefreshLayout.getContext()).intValue();
                } else {
                    iArr[i2] = readableArray.getInt(i2);
                }
            }
            reactSwipeRefreshLayout.setColorSchemeColors(iArr);
            return;
        }
        reactSwipeRefreshLayout.setColorSchemeColors(new int[0]);
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactSwipeRefreshLayout reactSwipeRefreshLayout, boolean z2) {
        reactSwipeRefreshLayout.setEnabled(z2);
    }

    public void setNativeRefreshing(ReactSwipeRefreshLayout reactSwipeRefreshLayout, boolean z2) {
        setRefreshing(reactSwipeRefreshLayout, z2);
    }

    @ReactProp(customType = "Color", name = "progressBackgroundColor")
    public void setProgressBackgroundColor(ReactSwipeRefreshLayout reactSwipeRefreshLayout, Integer num) {
        reactSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(num == null ? 0 : num.intValue());
    }

    @ReactProp(defaultFloat = 0.0f, name = "progressViewOffset")
    public void setProgressViewOffset(ReactSwipeRefreshLayout reactSwipeRefreshLayout, float f2) {
        reactSwipeRefreshLayout.setProgressViewOffset(f2);
    }

    @ReactProp(name = "refreshing")
    public void setRefreshing(ReactSwipeRefreshLayout reactSwipeRefreshLayout, boolean z2) {
        reactSwipeRefreshLayout.setRefreshing(z2);
    }

    public void setSize(ReactSwipeRefreshLayout reactSwipeRefreshLayout, int i2) {
        reactSwipeRefreshLayout.setSize(i2);
    }

    public void setSize(ReactSwipeRefreshLayout reactSwipeRefreshLayout, String str) {
        if (str == null || str.equals(Constants.COLLATION_DEFAULT)) {
            reactSwipeRefreshLayout.setSize(1);
        } else if (str.equals("large")) {
            reactSwipeRefreshLayout.setSize(0);
        } else {
            throw new IllegalArgumentException("Size must be 'default' or 'large', received: " + str);
        }
    }

    @ReactProp(name = "size")
    public void setSize(ReactSwipeRefreshLayout reactSwipeRefreshLayout, Dynamic dynamic) {
        if (dynamic.isNull()) {
            reactSwipeRefreshLayout.setSize(1);
        } else if (dynamic.getType() == ReadableType.Number) {
            reactSwipeRefreshLayout.setSize(dynamic.asInt());
        } else if (dynamic.getType() == ReadableType.String) {
            setSize(reactSwipeRefreshLayout, dynamic.asString());
        } else {
            throw new IllegalArgumentException("Size must be 'default' or 'large'");
        }
    }
}
