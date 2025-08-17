package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

public class Response<T extends Result> {
    private Result zza;

    public Response() {
    }

    protected Response(T t2) {
        this.zza = t2;
    }

    /* access modifiers changed from: protected */
    public T getResult() {
        return this.zza;
    }

    public void setResult(T t2) {
        this.zza = t2;
    }
}
