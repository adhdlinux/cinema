package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.wrappers.Wrappers;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbbk implements SharedPreferences.OnSharedPreferenceChangeListener {
    volatile boolean zza = false;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    /* access modifiers changed from: private */
    public SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private Context zzg;
    private JSONObject zzh = new JSONObject();

    private final void zzf() {
        if (this.zze != null) {
            try {
                this.zzh = new JSONObject((String) zzbbr.zza(new zzbbi(this)));
            } catch (JSONException unused) {
            }
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzf();
        }
    }

    public final Object zzb(zzbbe zzbbe) {
        if (!this.zzc.block(5000)) {
            synchronized (this.zzb) {
                if (!this.zza) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzd || this.zze == null) {
            synchronized (this.zzb) {
                if (this.zzd) {
                    if (this.zze == null) {
                    }
                }
                Object zzm = zzbbe.zzm();
                return zzm;
            }
        }
        if (zzbbe.zze() == 2) {
            Bundle bundle = this.zzf;
            if (bundle == null) {
                return zzbbe.zzm();
            }
            return zzbbe.zzb(bundle);
        } else if (zzbbe.zze() != 1 || !this.zzh.has(zzbbe.zzn())) {
            return zzbbr.zza(new zzbbh(this, zzbbe));
        } else {
            return zzbbe.zza(this.zzh);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(zzbbe zzbbe) {
        return zzbbe.zzc(this.zze);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzd() {
        return this.zze.getString("flag_configuration", JsonUtils.EMPTY_JSON);
    }

    public final void zze(Context context) {
        Context context2;
        if (!this.zzd) {
            synchronized (this.zzb) {
                if (!this.zzd) {
                    if (!this.zza) {
                        this.zza = true;
                    }
                    if (context.getApplicationContext() == null) {
                        context2 = context;
                    } else {
                        context2 = context.getApplicationContext();
                    }
                    this.zzg = context2;
                    try {
                        this.zzf = Wrappers.packageManager(context2).getApplicationInfo(this.zzg.getPackageName(), 128).metaData;
                    } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                    }
                    try {
                        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                        if (!(remoteContext == null && (remoteContext = context.getApplicationContext()) == null)) {
                            context = remoteContext;
                        }
                        if (context != null) {
                            zzba.zzb();
                            SharedPreferences zza2 = zzbbg.zza(context);
                            this.zze = zza2;
                            if (zza2 != null) {
                                zza2.registerOnSharedPreferenceChangeListener(this);
                            }
                            zzbdw.zzc(new zzbbj(this));
                            zzf();
                            this.zzd = true;
                            this.zza = false;
                            this.zzc.open();
                        }
                    } finally {
                        this.zza = false;
                        this.zzc.open();
                    }
                }
            }
        }
    }
}
