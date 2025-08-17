package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.uwetrottmann.trakt5.TraktV2;

public final /* synthetic */ class zzdip implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ View zza;
    public final /* synthetic */ zzcez zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ WindowManager.LayoutParams zzd;
    public final /* synthetic */ int zze;
    public final /* synthetic */ WindowManager zzf;

    public /* synthetic */ zzdip(View view, zzcez zzcez, String str, WindowManager.LayoutParams layoutParams, int i2, WindowManager windowManager) {
        this.zza = view;
        this.zzb = zzcez;
        this.zzc = str;
        this.zzd = layoutParams;
        this.zze = i2;
        this.zzf = windowManager;
    }

    public final void onScrollChanged() {
        View view = this.zza;
        zzcez zzcez = this.zzb;
        String str = this.zzc;
        WindowManager.LayoutParams layoutParams = this.zzd;
        int i2 = this.zze;
        WindowManager windowManager = this.zzf;
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect) && zzcez.zzF().getWindowToken() != null) {
            if ("1".equals(str) || TraktV2.API_VERSION.equals(str)) {
                layoutParams.y = rect.bottom - i2;
            } else {
                layoutParams.y = rect.top - i2;
            }
            windowManager.updateViewLayout(zzcez.zzF(), layoutParams);
        }
    }
}
