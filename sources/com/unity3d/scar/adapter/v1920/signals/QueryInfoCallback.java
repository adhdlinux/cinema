package com.unity3d.scar.adapter.v1920.signals;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.unity3d.scar.adapter.common.signals.ISignalCallbackListener;

public class QueryInfoCallback extends QueryInfoGenerationCallback {

    /* renamed from: a  reason: collision with root package name */
    private String f37097a;

    /* renamed from: b  reason: collision with root package name */
    private ISignalCallbackListener f37098b;

    public QueryInfoCallback(String str, ISignalCallbackListener iSignalCallbackListener) {
        this.f37097a = str;
        this.f37098b = iSignalCallbackListener;
    }

    public void onFailure(String str) {
        this.f37098b.onFailure(str);
    }

    public void onSuccess(QueryInfo queryInfo) {
        this.f37098b.a(this.f37097a, queryInfo.getQuery(), queryInfo);
    }
}
