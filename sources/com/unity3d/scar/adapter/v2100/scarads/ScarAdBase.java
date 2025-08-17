package com.unity3d.scar.adapter.v2100.scarads;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.scarads.IScarAd;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.v2100.requests.AdRequestFactory;

public abstract class ScarAdBase<T> implements IScarAd {

    /* renamed from: a  reason: collision with root package name */
    protected T f37175a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f37176b;

    /* renamed from: c  reason: collision with root package name */
    protected ScarAdMetadata f37177c;

    /* renamed from: d  reason: collision with root package name */
    protected AdRequestFactory f37178d;

    /* renamed from: e  reason: collision with root package name */
    protected ScarAdListener f37179e;

    /* renamed from: f  reason: collision with root package name */
    protected IAdsErrorHandler f37180f;

    public ScarAdBase(Context context, ScarAdMetadata scarAdMetadata, AdRequestFactory adRequestFactory, IAdsErrorHandler iAdsErrorHandler) {
        this.f37176b = context;
        this.f37177c = scarAdMetadata;
        this.f37178d = adRequestFactory;
        this.f37180f = iAdsErrorHandler;
    }

    public void b(IScarLoadListener iScarLoadListener) {
        AdRequest b2 = this.f37178d.b(this.f37177c.a());
        this.f37179e.a(iScarLoadListener);
        c(b2, iScarLoadListener);
    }

    /* access modifiers changed from: protected */
    public abstract void c(AdRequest adRequest, IScarLoadListener iScarLoadListener);

    public void d(T t2) {
        this.f37175a = t2;
    }
}
