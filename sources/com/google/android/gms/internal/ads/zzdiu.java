package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.ads.internal.zzb;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.uwetrottmann.trakt5.TraktV2;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzdiu {
    private final zzdni zza;
    private final zzdlx zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdiu(zzdni zzdni, zzdlx zzdlx) {
        this.zza = zzdni;
        this.zzb = zzdlx;
    }

    private static final int zzf(Context context, String str, int i2) {
        try {
            i2 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        zzay.zzb();
        return zzbzk.zzx(context, i2);
    }

    public final View zza(View view, WindowManager windowManager) throws zzcfk {
        zzcez zza2 = this.zza.zza(zzq.zzc(), (zzezn) null, (zzezq) null);
        View view2 = (View) zza2;
        view2.setVisibility(4);
        view2.setContentDescription("policy_validator");
        zza2.zzad("/sendMessageToSdk", new zzdiq(this));
        zza2.zzad("/hideValidatorOverlay", new zzdir(this, windowManager, view));
        zza2.zzad("/open", new zzbit((zzb) null, (zzbqq) null, (zzeba) null, (zzdqa) null, (zzfev) null));
        this.zzb.zzj(new WeakReference(zza2), "/loadNativeAdPolicyViolations", new zzdis(this, view, windowManager));
        this.zzb.zzj(new WeakReference(zza2), "/showValidatorOverlay", zzdit.zza);
        return (View) zza2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzcez zzcez, Map map) {
        this.zzb.zzg("sendMessageToNativeJs", map);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(WindowManager windowManager, View view, zzcez zzcez, Map map) {
        zzbzr.zze("Hide native ad policy validator overlay.");
        zzcez.zzF().setVisibility(8);
        if (zzcez.zzF().getWindowToken() != null) {
            windowManager.removeView(zzcez.zzF());
        }
        zzcez.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzc != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.zzc);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Map map, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "validatorHtmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzb.zzg("sendMessageToNativeJs", hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(View view, WindowManager windowManager, zzcez zzcez, Map map) {
        int i2;
        zzcez.zzN().zzA(new zzdio(this, map));
        if (map != null) {
            Context context = view.getContext();
            int zzf = zzf(context, (String) map.get("validator_width"), ((Integer) zzba.zzc().zzb(zzbbm.zzhF)).intValue());
            int zzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) zzba.zzc().zzb(zzbbm.zzhG)).intValue());
            int zzf3 = zzf(context, (String) map.get("validator_x"), 0);
            int zzf4 = zzf(context, (String) map.get("validator_y"), 0);
            zzcez.zzag(zzcgo.zzb(zzf, zzf2));
            try {
                zzcez.zzG().getSettings().setUseWideViewPort(((Boolean) zzba.zzc().zzb(zzbbm.zzhH)).booleanValue());
                zzcez.zzG().getSettings().setLoadWithOverviewMode(((Boolean) zzba.zzc().zzb(zzbbm.zzhI)).booleanValue());
            } catch (NullPointerException unused) {
            }
            WindowManager.LayoutParams zzb2 = zzbx.zzb();
            zzb2.x = zzf3;
            zzb2.y = zzf4;
            windowManager.updateViewLayout(zzcez.zzF(), zzb2);
            String str = (String) map.get(AdUnitActivity.EXTRA_ORIENTATION);
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                if ("1".equals(str) || TraktV2.API_VERSION.equals(str)) {
                    i2 = rect.bottom;
                } else {
                    i2 = rect.top;
                }
                this.zzc = new zzdip(view, zzcez, str, zzb2, i2 - zzf4, windowManager);
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnScrollChangedListener(this.zzc);
                }
            }
            String str2 = (String) map.get("overlay_url");
            if (!TextUtils.isEmpty(str2)) {
                zzcez.loadUrl(str2);
            }
        }
    }
}
