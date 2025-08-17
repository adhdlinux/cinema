package com.unity3d.scar.adapter.v2000.signals;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.unity3d.scar.adapter.common.signals.ISignalCallbackListener;

public class QueryInfoCallback extends QueryInfoGenerationCallback {

    /* renamed from: a  reason: collision with root package name */
    private String f37162a;

    /* renamed from: b  reason: collision with root package name */
    private ISignalCallbackListener f37163b;

    public QueryInfoCallback(String str, ISignalCallbackListener iSignalCallbackListener) {
        this.f37162a = str;
        this.f37163b = iSignalCallbackListener;
    }

    public void onFailure(String str) {
        this.f37163b.onFailure(str);
    }

    public void onSuccess(QueryInfo queryInfo) {
        this.f37163b.a(this.f37162a, queryInfo.getQuery(), queryInfo);
    }
}
