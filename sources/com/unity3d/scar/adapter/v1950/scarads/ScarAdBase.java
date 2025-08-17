package com.unity3d.scar.adapter.v1950.scarads;

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
    protected Context f37109a;

    /* renamed from: b  reason: collision with root package name */
    protected ScarAdMetadata f37110b;

    /* renamed from: c  reason: collision with root package name */
    protected QueryInfo f37111c;

    /* renamed from: d  reason: collision with root package name */
    protected IAdsErrorHandler f37112d;

    public ScarAdBase(Context context, ScarAdMetadata scarAdMetadata, QueryInfo queryInfo, IAdsErrorHandler iAdsErrorHandler) {
        this.f37109a = context;
        this.f37110b = scarAdMetadata;
        this.f37111c = queryInfo;
        this.f37112d = iAdsErrorHandler;
    }

    public void b(IScarLoadListener iScarLoadListener) {
        if (this.f37111c != null) {
            c(iScarLoadListener, new AdRequest.Builder().setAdInfo(new AdInfo(this.f37111c, this.f37110b.a())).build());
            return;
        }
        this.f37112d.handleError(GMAAdsError.g(this.f37110b));
    }

    /* access modifiers changed from: protected */
    public abstract void c(IScarLoadListener iScarLoadListener, AdRequest adRequest);
}
