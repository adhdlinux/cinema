package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.HashMap;
import java.util.Map;

final class zzfko implements zzfje {
    private final Object zza;
    private final zzfkp zzb;
    private final zzfla zzc;
    private final zzfjb zzd;

    zzfko(Object obj, zzfkp zzfkp, zzfla zzfla, zzfjb zzfjb) {
        this.zza = obj;
        this.zzb = zzfkp;
        this.zzc = zzfla;
        this.zzd = zzfjb;
    }

    private static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzaoz zza2 = zzapa.zza();
        zza2.zzc(5);
        zza2.zza(zzgoe.zzv(bArr, 0, bArr.length));
        return Base64.encodeToString(((zzapa) zza2.zzal()).zzax(), 11);
    }

    private final synchronized byte[] zzj(Map map, Map map2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e2) {
            this.zzd.zzc(2007, System.currentTimeMillis() - currentTimeMillis, e2);
            return null;
        }
        return (byte[]) this.zza.getClass().getDeclaredMethod("xss", new Class[]{Map.class, Map.class}).invoke(this.zza, new Object[]{null, map2});
    }

    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map zza2;
        zza2 = this.zzc.zza();
        zza2.put("f", "c");
        zza2.put("ctx", context);
        zza2.put("cs", str2);
        zza2.put("aid", (Object) null);
        zza2.put("view", view);
        zza2.put("act", activity);
        return zzi(zzj((Map) null, zza2));
    }

    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map zzc2;
        zzc2 = this.zzc.zzc();
        zzc2.put("f", "v");
        zzc2.put("ctx", context);
        zzc2.put("aid", (Object) null);
        zzc2.put("view", view);
        zzc2.put("act", activity);
        return zzi(zzj((Map) null, zzc2));
    }

    public final synchronized String zzc(Context context, String str) {
        Map zzb2;
        zzb2 = this.zzc.zzb();
        zzb2.put("f", "q");
        zzb2.put("ctx", context);
        zzb2.put("aid", (Object) null);
        return zzi(zzj((Map) null, zzb2));
    }

    public final synchronized void zzd(String str, MotionEvent motionEvent) throws zzfky {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("t", new Throwable());
            hashMap.put("aid", (Object) null);
            hashMap.put("evt", motionEvent);
            this.zza.getClass().getDeclaredMethod("he", new Class[]{Map.class}).invoke(this.zza, new Object[]{hashMap});
            this.zzd.zzd(AuthApiStatusCodes.AUTH_API_SERVER_ERROR, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e2) {
            throw new zzfky(2005, (Throwable) e2);
        }
    }

    public final synchronized int zze() throws zzfky {
        try {
        } catch (Exception e2) {
            throw new zzfky(2006, (Throwable) e2);
        }
        return ((Integer) this.zza.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.zza, new Object[0])).intValue();
    }

    /* access modifiers changed from: package-private */
    public final zzfkp zzf() {
        return this.zzb;
    }

    public final synchronized void zzg() throws zzfky {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.zza.getClass().getDeclaredMethod(MRAIDPresenter.CLOSE, new Class[0]).invoke(this.zza, new Object[0]);
            this.zzd.zzd(3001, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e2) {
            throw new zzfky(2003, (Throwable) e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzh() throws zzfky {
        try {
        } catch (Exception e2) {
            throw new zzfky(2001, (Throwable) e2);
        }
        return ((Boolean) this.zza.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.zza, new Object[0])).booleanValue();
    }
}
