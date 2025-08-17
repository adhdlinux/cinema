package com.facebook.react.views.image;

import android.graphics.PorterDuff;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaConstants;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "RCTImageView")
public class ReactImageManager extends SimpleViewManager<ReactImageView> {
    public static final String REACT_CLASS = "RCTImageView";
    private final Object mCallerContext;
    private final ReactCallerContextFactory mCallerContextFactory;
    private AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    private GlobalImageLoadListener mGlobalImageLoadListener;

    @Deprecated
    public ReactImageManager(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, Object obj) {
        this(abstractDraweeControllerBuilder, (GlobalImageLoadListener) null, obj);
    }

    @Deprecated
    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public AbstractDraweeControllerBuilder getDraweeControllerBuilder() {
        if (this.mDraweeControllerBuilder == null) {
            this.mDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        }
        return this.mDraweeControllerBuilder;
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        Map exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap();
        }
        exportedCustomDirectEventTypeConstants.putAll(MapBuilder.of(ImageLoadEvent.eventNameForType(4), MapBuilder.of("registrationName", "onLoadStart"), ImageLoadEvent.eventNameForType(5), MapBuilder.of("registrationName", "onProgress"), ImageLoadEvent.eventNameForType(2), MapBuilder.of("registrationName", "onLoad"), ImageLoadEvent.eventNameForType(1), MapBuilder.of("registrationName", "onError"), ImageLoadEvent.eventNameForType(3), MapBuilder.of("registrationName", "onLoadEnd")));
        return exportedCustomDirectEventTypeConstants;
    }

    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "accessible")
    public void setAccessible(ReactImageView reactImageView, boolean z2) {
        reactImageView.setFocusable(z2);
    }

    @ReactProp(name = "blurRadius")
    public void setBlurRadius(ReactImageView reactImageView, float f2) {
        reactImageView.setBlurRadius(f2);
    }

    @ReactProp(customType = "Color", name = "borderColor")
    public void setBorderColor(ReactImageView reactImageView, Integer num) {
        if (num == null) {
            reactImageView.setBorderColor(0);
        } else {
            reactImageView.setBorderColor(num.intValue());
        }
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactImageView reactImageView, int i2, float f2) {
        if (!YogaConstants.isUndefined(f2)) {
            f2 = PixelUtil.toPixelFromDIP(f2);
        }
        if (i2 == 0) {
            reactImageView.setBorderRadius(f2);
        } else {
            reactImageView.setBorderRadius(f2, i2 - 1);
        }
    }

    @ReactProp(name = "borderWidth")
    public void setBorderWidth(ReactImageView reactImageView, float f2) {
        reactImageView.setBorderWidth(f2);
    }

    @ReactProp(name = "defaultSrc")
    public void setDefaultSource(ReactImageView reactImageView, String str) {
        reactImageView.setDefaultSource(str);
    }

    @ReactProp(name = "fadeDuration")
    public void setFadeDuration(ReactImageView reactImageView, int i2) {
        reactImageView.setFadeDuration(i2);
    }

    @ReactProp(name = "headers")
    public void setHeaders(ReactImageView reactImageView, ReadableMap readableMap) {
        reactImageView.setHeaders(readableMap);
    }

    @ReactProp(name = "internal_analyticTag")
    public void setInternal_AnalyticsTag(ReactImageView reactImageView, String str) {
        ReactCallerContextFactory reactCallerContextFactory = this.mCallerContextFactory;
        if (reactCallerContextFactory != null) {
            reactImageView.updateCallerContext(reactCallerContextFactory.getOrCreateCallerContext(((ThemedReactContext) reactImageView.getContext()).getModuleName(), str));
        }
    }

    @ReactProp(name = "shouldNotifyLoadEvents")
    public void setLoadHandlersRegistered(ReactImageView reactImageView, boolean z2) {
        reactImageView.setShouldNotifyLoadEvents(z2);
    }

    @ReactProp(name = "loadingIndicatorSrc")
    public void setLoadingIndicatorSource(ReactImageView reactImageView, String str) {
        reactImageView.setLoadingIndicatorSource(str);
    }

    @ReactProp(customType = "Color", name = "overlayColor")
    public void setOverlayColor(ReactImageView reactImageView, Integer num) {
        if (num == null) {
            reactImageView.setOverlayColor(0);
        } else {
            reactImageView.setOverlayColor(num.intValue());
        }
    }

    @ReactProp(name = "progressiveRenderingEnabled")
    public void setProgressiveRenderingEnabled(ReactImageView reactImageView, boolean z2) {
        reactImageView.setProgressiveRenderingEnabled(z2);
    }

    @ReactProp(name = "resizeMethod")
    public void setResizeMethod(ReactImageView reactImageView, String str) {
        if (str == null || "auto".equals(str)) {
            reactImageView.setResizeMethod(ImageResizeMethod.AUTO);
        } else if ("resize".equals(str)) {
            reactImageView.setResizeMethod(ImageResizeMethod.RESIZE);
        } else if ("scale".equals(str)) {
            reactImageView.setResizeMethod(ImageResizeMethod.SCALE);
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid resize method: '" + str + "'");
        }
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(ReactImageView reactImageView, String str) {
        reactImageView.setScaleType(ImageResizeMode.toScaleType(str));
        reactImageView.setTileMode(ImageResizeMode.toTileMode(str));
    }

    @ReactProp(name = "src")
    public void setSource(ReactImageView reactImageView, ReadableArray readableArray) {
        reactImageView.setSource(readableArray);
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public void setTintColor(ReactImageView reactImageView, Integer num) {
        if (num == null) {
            reactImageView.clearColorFilter();
        } else {
            reactImageView.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @Deprecated
    public ReactImageManager(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, Object obj) {
        this.mDraweeControllerBuilder = abstractDraweeControllerBuilder;
        this.mGlobalImageLoadListener = globalImageLoadListener;
        this.mCallerContext = obj;
        this.mCallerContextFactory = null;
    }

    public ReactImageView createViewInstance(ThemedReactContext themedReactContext) {
        Object obj;
        ReactCallerContextFactory reactCallerContextFactory = this.mCallerContextFactory;
        if (reactCallerContextFactory != null) {
            obj = reactCallerContextFactory.getOrCreateCallerContext(themedReactContext.getModuleName(), (String) null);
        } else {
            obj = getCallerContext();
        }
        return new ReactImageView(themedReactContext, getDraweeControllerBuilder(), this.mGlobalImageLoadListener, obj);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ReactImageView reactImageView) {
        super.onAfterUpdateTransaction(reactImageView);
        reactImageView.maybeUpdateView();
    }

    public ReactImageManager(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, ReactCallerContextFactory reactCallerContextFactory) {
        this(abstractDraweeControllerBuilder, (GlobalImageLoadListener) null, reactCallerContextFactory);
    }

    public ReactImageManager(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, ReactCallerContextFactory reactCallerContextFactory) {
        this.mDraweeControllerBuilder = abstractDraweeControllerBuilder;
        this.mGlobalImageLoadListener = globalImageLoadListener;
        this.mCallerContextFactory = reactCallerContextFactory;
        this.mCallerContext = null;
    }

    public ReactImageManager() {
        this.mDraweeControllerBuilder = null;
        this.mCallerContext = null;
        this.mCallerContextFactory = null;
    }
}
