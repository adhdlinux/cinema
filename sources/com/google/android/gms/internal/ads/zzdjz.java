package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;

public final /* synthetic */ class zzdjz implements zzfov {
    public final /* synthetic */ String zza;
    public final /* synthetic */ double zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ int zzd;

    public /* synthetic */ zzdjz(String str, double d2, int i2, int i3) {
        this.zza = str;
        this.zzb = d2;
        this.zzc = i2;
        this.zzd = i3;
    }

    public final Object apply(Object obj) {
        String str = this.zza;
        return new zzbed(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.zzb, this.zzc, this.zzd);
    }
}
