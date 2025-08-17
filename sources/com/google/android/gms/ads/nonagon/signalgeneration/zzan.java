package com.google.android.gms.ads.nonagon.signalgeneration;

public final /* synthetic */ class zzan implements Runnable {
    public final /* synthetic */ TaggingLibraryJsInterface zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzan(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        this.zza = taggingLibraryJsInterface;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
