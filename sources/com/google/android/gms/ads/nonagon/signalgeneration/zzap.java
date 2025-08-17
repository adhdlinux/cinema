package com.google.android.gms.ads.nonagon.signalgeneration;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzap implements Callable {
    public final /* synthetic */ TaggingLibraryJsInterface zza;

    public /* synthetic */ zzap(TaggingLibraryJsInterface taggingLibraryJsInterface) {
        this.zza = taggingLibraryJsInterface;
    }

    public final Object call() {
        return this.zza.getViewSignals();
    }
}
