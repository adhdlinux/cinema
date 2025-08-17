package com.google.android.gms.ads.nonagon.signalgeneration;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzaq implements Callable {
    public final /* synthetic */ TaggingLibraryJsInterface zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzaq(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        this.zza = taggingLibraryJsInterface;
        this.zzb = str;
    }

    public final Object call() {
        return this.zza.getClickSignals(this.zzb);
    }
}
