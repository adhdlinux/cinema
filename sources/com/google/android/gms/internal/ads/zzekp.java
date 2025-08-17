package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.ArrayList;
import java.util.List;

public final class zzekp implements zzeqy {
    private final zzfwn zza;
    private final zzfwn zzb;
    private final Context zzc;
    private final zzfai zzd;
    private final View zze;

    public zzekp(zzfwn zzfwn, zzfwn zzfwn2, Context context, zzfai zzfai, ViewGroup viewGroup) {
        this.zza = zzfwn;
        this.zzb = zzfwn2;
        this.zzc = context;
        this.zzd = zzfai;
        this.zze = viewGroup;
    }

    private final List zze() {
        int i2;
        ArrayList arrayList = new ArrayList();
        View view = this.zze;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            if (parent instanceof ViewGroup) {
                i2 = ((ViewGroup) parent).indexOfChild(view);
            } else {
                i2 = -1;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", i2);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return arrayList;
    }

    public final int zza() {
        return 3;
    }

    public final zzfwm zzb() {
        zzbbm.zza(this.zzc);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjD)).booleanValue()) {
            return this.zzb.zzb(new zzekn(this));
        }
        return this.zza.zzb(new zzeko(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzekq zzc() throws Exception {
        return new zzekq(this.zzc, this.zzd.zze, zze());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzekq zzd() throws Exception {
        return new zzekq(this.zzc, this.zzd.zze, zze());
    }
}
