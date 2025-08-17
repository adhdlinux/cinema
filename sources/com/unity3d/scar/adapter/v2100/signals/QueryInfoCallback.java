package com.unity3d.scar.adapter.v2100.signals;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.unity3d.scar.adapter.common.signals.ISignalCallbackListener;

public class QueryInfoCallback extends QueryInfoGenerationCallback {

    /* renamed from: a  reason: collision with root package name */
    private String f37196a;

    /* renamed from: b  reason: collision with root package name */
    private ISignalCallbackListener f37197b;

    public QueryInfoCallback(String str, ISignalCallbackListener iSignalCallbackListener) {
        this.f37196a = str;
        this.f37197b = iSignalCallbackListener;
    }

    public void onFailure(String str) {
        this.f37197b.onFailure(str);
    }

    public void onSuccess(QueryInfo queryInfo) {
        this.f37197b.a(this.f37196a, queryInfo.getQuery(), queryInfo);
    }
}
