package com.utils.cast;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.utils.cast.CastHelper;

public final /* synthetic */ class a implements ResultCallback {
    public final void onResult(Result result) {
        CastHelper.AnonymousClass2.b((RemoteMediaClient.MediaChannelResult) result);
    }
}
