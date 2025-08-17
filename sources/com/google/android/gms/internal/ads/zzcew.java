package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

final class zzcew implements DialogInterface.OnClickListener {
    final /* synthetic */ JsPromptResult zza;
    final /* synthetic */ EditText zzb;

    zzcew(JsPromptResult jsPromptResult, EditText editText) {
        this.zza = jsPromptResult;
        this.zzb = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.zza.confirm(this.zzb.getText().toString());
    }
}
