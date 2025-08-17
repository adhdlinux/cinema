package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import java.lang.reflect.InvocationTargetException;

public final class zzate extends zzath {
    private final View zzi;

    public zzate(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3, View view) {
        super(zzart, "ZCuJ2BZ9pjX66HItj5rJVOE3CFRvMlTjLwpTXK/hjirliOmVxPsb2SejOT7YbM4P", "ALSn7l1sKMxPVb0fohyyuRzRspt/TYmvV6oorF8J62I=", zzanq, i2, 57);
        this.zzi = view;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            Boolean bool = (Boolean) zzba.zzc().zzb(zzbbm.zzdb);
            Boolean bool2 = (Boolean) zzba.zzc().zzb(zzbbm.zzjy);
            DisplayMetrics displayMetrics = this.zzb.zzb().getResources().getDisplayMetrics();
            zzarx zzarx = new zzarx((String) this.zzf.invoke((Object) null, new Object[]{this.zzi, displayMetrics, bool, bool2}));
            zzaol zza = zzaom.zza();
            zza.zzb(zzarx.zza.longValue());
            zza.zzd(zzarx.zzb.longValue());
            zza.zze(zzarx.zzc.longValue());
            if (bool2.booleanValue()) {
                zza.zzc(zzarx.zze.longValue());
            }
            if (bool.booleanValue()) {
                zza.zza(zzarx.zzd.longValue());
            }
            this.zze.zzY((zzaom) zza.zzal());
        }
    }
}
