package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

final class zzcev implements DialogInterface.OnClickListener {
    final /* synthetic */ JsPromptResult zza;

    zzcev(JsPromptResult jsPromptResult) {
        this.zza = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.zza.cancel();
    }
}
