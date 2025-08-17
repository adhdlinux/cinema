package com.unity3d.scar.adapter.v1920.scarads;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.GMAAdsError;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.scarads.IScarAd;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;

public abstract class ScarAdBase implements IScarAd {

    /* renamed from: a  reason: collision with root package name */
    protected Context f37077a;

    /* renamed from: b  reason: collision with root package name */
    protected ScarAdMetadata f37078b;

    /* renamed from: c  reason: collision with root package name */
    protected QueryInfo f37079c;

    /* renamed from: d  reason: collision with root package name */
    protected IAdsErrorHandler f37080d;

    public ScarAdBase(Context context, ScarAdMetadata scarAdMetadata, QueryInfo queryInfo, IAdsErrorHandler iAdsErrorHandler) {
        this.f37077a = context;
        this.f37078b = scarAdMetadata;
        this.f37079c = queryInfo;
        this.f37080d = iAdsErrorHandler;
    }

    public void b(IScarLoadListener iScarLoadListener) {
        if (this.f37079c != null) {
            c(iScarLoadListener, new AdRequest.Builder().setAdInfo(new AdInfo(this.f37079c, this.f37078b.a())).build());
            return;
        }
        this.f37080d.handleError(GMAAdsError.g(this.f37078b));
    }

    /* access modifiers changed from: protected */
    public abstract void c(IScarLoadListener iScarLoadListener, AdRequest adRequest);
}
