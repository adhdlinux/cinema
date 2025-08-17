package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

final class zzcer implements DialogInterface.OnCancelListener {
    final /* synthetic */ JsResult zza;

    zzcer(JsResult jsResult) {
        this.zza = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zza.cancel();
    }
}
