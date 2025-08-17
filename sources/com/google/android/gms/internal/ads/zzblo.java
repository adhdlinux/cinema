package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.AudienceNetworkActivity;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzt;
import java.util.Map;
import org.json.JSONObject;

public final class zzblo implements zzblg, zzble {
    private final zzcez zza;

    public zzblo(Context context, zzbzx zzbzx, zzaqs zzaqs, zza zza2) throws zzcfk {
        zzt.zzz();
        zzcez zza3 = zzcfl.zza(context, zzcgo.zza(), "", false, false, (zzaqs) null, (zzbco) null, zzbzx, (zzbce) null, (zzl) null, (zza) null, zzawz.zza(), (zzezn) null, (zzezq) null, (zzebl) null);
        this.zza = zza3;
        ((View) zza3).setWillNotDraw(true);
    }

    private static final void zzs(Runnable runnable) {
        zzay.zzb();
        if (zzbzk.zzu()) {
            runnable.run();
        } else {
            zzs.zza.post(runnable);
        }
    }

    public final void zza(String str) {
        zzs(new zzblj(this, str));
    }

    public final /* synthetic */ void zzb(String str, String str2) {
        zzbld.zzc(this, str, str2);
    }

    public final void zzc() {
        this.zza.destroy();
    }

    public final /* synthetic */ void zzd(String str, Map map) {
        zzbld.zza(this, str, map);
    }

    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbld.zzb(this, str, jSONObject);
    }

    public final void zzf(String str) {
        zzs(new zzblk(this, str));
    }

    public final void zzg(String str) {
        zzs(new zzblm(this, str));
    }

    public final void zzh(String str) {
        zzs(new zzbll(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final boolean zzi() {
        return this.zza.zzaz();
    }

    public final zzbmn zzj() {
        return new zzbmn(this);
    }

    public final void zzk(zzblv zzblv) {
        this.zza.zzN().zzG(new zzblh(zzblv));
    }

    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzbld.zzd(this, str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(String str) {
        this.zza.zza(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(String str) {
        this.zza.loadData(str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, "UTF-8");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(String str) {
        this.zza.loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(String str) {
        this.zza.loadData(str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, "UTF-8");
    }

    public final void zzq(String str, zzbij zzbij) {
        this.zza.zzad(str, new zzbln(this, zzbij));
    }

    public final void zzr(String str, zzbij zzbij) {
        this.zza.zzav(str, new zzbli(zzbij));
    }
}
