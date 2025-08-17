package com.unity3d.scar.adapter.v2000.scarads;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.GMAAdsError;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.scarads.IScarAd;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;

public abstract class ScarAdBase<T> implements IScarAd {

    /* renamed from: a  reason: collision with root package name */
    protected T f37141a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f37142b;

    /* renamed from: c  reason: collision with root package name */
    protected ScarAdMetadata f37143c;

    /* renamed from: d  reason: collision with root package name */
    protected QueryInfo f37144d;

    /* renamed from: e  reason: collision with root package name */
    protected ScarAdListener f37145e;

    /* renamed from: f  reason: collision with root package name */
    protected IAdsErrorHandler f37146f;

    public ScarAdBase(Context context, ScarAdMetadata scarAdMetadata, QueryInfo queryInfo, IAdsErrorHandler iAdsErrorHandler) {
        this.f37142b = context;
        this.f37143c = scarAdMetadata;
        this.f37144d = queryInfo;
        this.f37146f = iAdsErrorHandler;
    }

    public void b(IScarLoadListener iScarLoadListener) {
        if (this.f37144d != null) {
            AdRequest build = new AdRequest.Builder().setAdInfo(new AdInfo(this.f37144d, this.f37143c.a())).build();
            this.f37145e.a(iScarLoadListener);
            c(build, iScarLoadListener);
            return;
        }
        this.f37146f.handleError(GMAAdsError.g(this.f37143c));
    }

    /* access modifiers changed from: protected */
    public abstract void c(AdRequest adRequest, IScarLoadListener iScarLoadListener);

    public void d(T t2) {
        this.f37141a = t2;
    }
}
