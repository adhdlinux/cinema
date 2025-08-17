package com.google.android.gms.ads.query;

import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class UpdateClickUrlCallback {
    @KeepForSdk
    public void onFailure(String str) {
    }

    @KeepForSdk
    public void onSuccess(Uri uri) {
    }
}
