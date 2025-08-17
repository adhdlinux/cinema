package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import org.json.JSONObject;

public abstract class zzbbe {
    private final int zza;
    private final String zzb;
    private final Object zzc;

    /* synthetic */ zzbbe(int i2, String str, Object obj, zzbbd zzbbd) {
        this.zza = i2;
        this.zzb = str;
        this.zzc = obj;
        zzba.zza().zzd(this);
    }

    public static zzbbe zzf(int i2, String str, float f2) {
        return new zzbbb(1, str, Float.valueOf(f2));
    }

    public static zzbbe zzg(int i2, String str, int i3) {
        return new zzbaz(1, str, Integer.valueOf(i3));
    }

    public static zzbbe zzh(int i2, String str, long j2) {
        return new zzbba(1, str, Long.valueOf(j2));
    }

    public static zzbbe zzi(int i2, String str, Boolean bool) {
        return new zzbay(i2, str, bool);
    }

    public static zzbbe zzj(int i2, String str, String str2) {
        return new zzbbc(1, str, str2);
    }

    public static zzbbe zzk(int i2, String str) {
        zzbbe zzj = zzj(1, "gads:sdk_core_constants:experiment_id", (String) null);
        zzba.zza().zzc(zzj);
        return zzj;
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(JSONObject jSONObject);

    public abstract Object zzb(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract Object zzc(SharedPreferences sharedPreferences);

    public abstract void zzd(SharedPreferences.Editor editor, Object obj);

    public final int zze() {
        return this.zza;
    }

    public final Object zzl() {
        return zzba.zzc().zzb(this);
    }

    public final Object zzm() {
        return this.zzc;
    }

    public final String zzn() {
        return this.zzb;
    }
}
