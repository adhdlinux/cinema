package com.unity3d.scar.adapter.common;

import android.app.Activity;
import android.content.Context;
import com.unity3d.scar.adapter.common.scarads.IScarAd;
import com.unity3d.scar.adapter.common.signals.ISignalCollectionListener;
import com.unity3d.scar.adapter.common.signals.ISignalsCollector;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ScarAdapterBase implements IScarAdapter {

    /* renamed from: a  reason: collision with root package name */
    protected ISignalsCollector f37044a;

    /* renamed from: b  reason: collision with root package name */
    protected Map<String, IScarAd> f37045b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    protected IScarAd f37046c;

    /* renamed from: d  reason: collision with root package name */
    protected IAdsErrorHandler<WebViewAdsError> f37047d;

    public ScarAdapterBase(IAdsErrorHandler<WebViewAdsError> iAdsErrorHandler) {
        this.f37047d = iAdsErrorHandler;
    }

    public void a(Context context, String[] strArr, String[] strArr2, ISignalCollectionListener iSignalCollectionListener) {
        this.f37044a.a(context, strArr, strArr2, iSignalCollectionListener);
    }

    public void b(Context context, ISignalCollectionListener iSignalCollectionListener) {
        this.f37044a.b(context, iSignalCollectionListener);
    }

    public void c(final Activity activity, String str, String str2) {
        IScarAd iScarAd = this.f37045b.get(str2);
        if (iScarAd == null) {
            IAdsErrorHandler<WebViewAdsError> iAdsErrorHandler = this.f37047d;
            iAdsErrorHandler.handleError(GMAAdsError.f(str2, str, "Could not find ad for placement '" + str2 + "'."));
            return;
        }
        this.f37046c = iScarAd;
        Utils.a(new Runnable() {
            public void run() {
                ScarAdapterBase.this.f37046c.a(activity);
            }
        });
    }
}
