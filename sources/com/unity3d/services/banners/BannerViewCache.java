package com.unity3d.services.banners;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.operation.load.LoadBannerModule;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.core.misc.Utilities;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class BannerViewCache {
    private static BannerViewCache instance;
    private HashMap<String, WeakReference<BannerView>> _bannerViews = new HashMap<>();

    public static BannerViewCache getInstance() {
        if (instance == null) {
            instance = new BannerViewCache();
        }
        return instance;
    }

    public synchronized String addBannerView(BannerView bannerView) {
        this._bannerViews.put(bannerView.getViewId(), new WeakReference(bannerView));
        return bannerView.getViewId();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.unity3d.services.banners.BannerView getBannerView(java.lang.String r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<com.unity3d.services.banners.BannerView>> r0 = r1._bannerViews     // Catch:{ all -> 0x001c }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001c }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x0019
            java.lang.Object r0 = r2.get()     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0019
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x001c }
            com.unity3d.services.banners.BannerView r2 = (com.unity3d.services.banners.BannerView) r2     // Catch:{ all -> 0x001c }
            monitor-exit(r1)
            return r2
        L_0x0019:
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x001c:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.banners.BannerViewCache.getBannerView(java.lang.String):com.unity3d.services.banners.BannerView");
    }

    public synchronized boolean loadWebPlayer(String str, UnityBannerSize unityBannerSize) {
        BannerView bannerView = getBannerView(str);
        if (bannerView == null) {
            return false;
        }
        bannerView.loadWebPlayer(unityBannerSize);
        return true;
    }

    public synchronized void removeBannerView(String str) {
        this._bannerViews.remove(str);
    }

    public synchronized void triggerBannerClickEvent(String str) {
        final BannerView bannerView = getBannerView(str);
        if (!(bannerView == null || bannerView.getListener() == null)) {
            final BannerView.IListener listener = bannerView.getListener();
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    BannerView.IListener iListener = listener;
                    if (iListener != null) {
                        iListener.onBannerClick(bannerView);
                    }
                }
            });
        }
    }

    public synchronized void triggerBannerErrorEvent(String str, BannerErrorInfo bannerErrorInfo) {
        LoadBannerModule.getInstance().onUnityAdsFailedToLoad(str, UnityAds.UnityAdsLoadError.INTERNAL_ERROR, bannerErrorInfo.errorMessage);
    }

    public synchronized void triggerBannerLeftApplicationEvent(String str) {
        final BannerView bannerView = getBannerView(str);
        if (!(bannerView == null || bannerView.getListener() == null)) {
            final BannerView.IListener listener = bannerView.getListener();
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    BannerView.IListener iListener = listener;
                    if (iListener != null) {
                        iListener.onBannerLeftApplication(bannerView);
                    }
                }
            });
        }
    }

    public synchronized void triggerBannerLoadEvent(String str) {
        final BannerView bannerView = getBannerView(str);
        if (!(bannerView == null || bannerView.getListener() == null)) {
            final BannerView.IListener listener = bannerView.getListener();
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    BannerView.IListener iListener = listener;
                    if (iListener != null) {
                        iListener.onBannerLoaded(bannerView);
                    }
                }
            });
        }
    }
}
