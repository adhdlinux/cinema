package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

final class zzces implements DialogInterface.OnClickListener {
    final /* synthetic */ JsResult zza;

    zzces(JsResult jsResult) {
        this.zza = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.zza.cancel();
    }
}
