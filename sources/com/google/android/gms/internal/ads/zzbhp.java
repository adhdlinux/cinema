package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.HashMap;
import java.util.Map;

final class zzbhp implements zzbij {
    zzbhp() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcez = (zzcez) obj;
        zzt.zzp();
        DisplayMetrics zzq = zzs.zzq((WindowManager) zzcez.getContext().getSystemService("window"));
        int i2 = zzq.widthPixels;
        int i3 = zzq.heightPixels;
        int[] iArr = new int[2];
        HashMap hashMap = new HashMap();
        ((View) zzcez).getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i2));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i3));
        zzcez.zzd("locationReady", hashMap);
        zzbzr.zzj("GET LOCATION COMPILED");
    }
}
