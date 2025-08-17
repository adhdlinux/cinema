package com.unity3d.scar.adapter.v1950.signals;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.unity3d.scar.adapter.common.signals.ISignalCallbackListener;

public class QueryInfoCallback extends QueryInfoGenerationCallback {

    /* renamed from: a  reason: collision with root package name */
    private String f37129a;

    /* renamed from: b  reason: collision with root package name */
    private ISignalCallbackListener f37130b;

    public QueryInfoCallback(String str, ISignalCallbackListener iSignalCallbackListener) {
        this.f37129a = str;
        this.f37130b = iSignalCallbackListener;
    }

    public void onFailure(String str) {
        this.f37130b.onFailure(str);
    }

    public void onSuccess(QueryInfo queryInfo) {
        this.f37130b.a(this.f37129a, queryInfo.getQuery(), queryInfo);
    }
}
