package com.unity3d.services.banners.bridge;

import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.services.ads.operation.load.LoadBannerModule;
import com.unity3d.services.ads.operation.load.LoadBannerOperationState;
import com.unity3d.services.banners.BannerErrorCode;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.BannerViewCache;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.WebViewBridgeInvoker;

public class BannerBridge {

    public enum BannerEvent {
        BANNER_VISIBILITY_CHANGED,
        BANNER_RESIZED,
        BANNER_LOADED,
        BANNER_DESTROYED,
        BANNER_ATTACHED,
        BANNER_DETACHED,
        BANNER_LOAD_PLACEMENT,
        BANNER_DESTROY_BANNER
    }

    public static void destroy(String str) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_DESTROY_BANNER, str);
        }
    }

    public static void didAttach(String str) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_ATTACHED, str);
        }
    }

    public static void didDestroy(String str) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_DESTROYED, str);
        }
    }

    public static void didDetach(String str) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_DETACHED, str);
        }
    }

    public static void didLoad(String str) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_LOADED, str);
        }
    }

    public static void load(String str, String str2, UnityBannerSize unityBannerSize) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_LOAD_PLACEMENT, str, str2, Integer.valueOf(unityBannerSize.getWidth()), Integer.valueOf(unityBannerSize.getHeight()));
            return;
        }
        BannerView bannerView = BannerViewCache.getInstance().getBannerView(str2);
        if (bannerView != null && bannerView.getListener() != null) {
            bannerView.getListener().onBannerFailedToLoad(bannerView, new BannerErrorInfo("WebViewApp was not available, this is likely because UnityAds has not been initialized", BannerErrorCode.WEBVIEW_ERROR));
        }
    }

    public static void resize(String str, int i2, int i3, int i4, int i5, float f2) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_RESIZED, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2));
        }
    }

    public static void visibilityChanged(String str, int i2) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.BANNER, BannerEvent.BANNER_VISIBILITY_CHANGED, str, Integer.valueOf(i2));
        }
    }

    public static void load(String str, final String str2, UnityBannerSize unityBannerSize, UnityAdsLoadOptions unityAdsLoadOptions) {
        if (BannerViewCache.getInstance().getBannerView(str2) != null) {
            String str3 = str;
            String str4 = str2;
            UnityBannerSize unityBannerSize2 = unityBannerSize;
            LoadBannerModule.getInstance().executeAdOperation(new WebViewBridgeInvoker(), new LoadBannerOperationState(str3, str4, unityBannerSize2, new IUnityAdsLoadListener() {
                public void onUnityAdsAdLoaded(String str) {
                }

                public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
                    BannerView bannerView = BannerViewCache.getInstance().getBannerView(str2);
                    if (bannerView != null && bannerView.getListener() != null) {
                        bannerView.getListener().onBannerFailedToLoad(bannerView, BannerErrorInfo.fromLoadError(unityAdsLoadError, str2));
                    }
                }
            }, unityAdsLoadOptions, new ConfigurationReader().getCurrentConfiguration()));
        }
    }
}
