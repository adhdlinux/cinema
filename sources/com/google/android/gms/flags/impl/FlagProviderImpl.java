package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.flags.zzd;

@DynamiteApi
public class FlagProviderImpl extends zzd {
    private boolean zza = false;
    private SharedPreferences zzb;

    public boolean getBooleanFlagValue(String str, boolean z2, int i2) {
        String str2;
        if (!this.zza) {
            return z2;
        }
        SharedPreferences sharedPreferences = this.zzb;
        Boolean valueOf = Boolean.valueOf(z2);
        try {
            valueOf = (Boolean) com.google.android.gms.internal.flags.zzd.zza(new zza(sharedPreferences, str, valueOf));
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            if (valueOf2.length() != 0) {
                str2 = "Flag value not available, returning default: ".concat(valueOf2);
            } else {
                str2 = new String("Flag value not available, returning default: ");
            }
            Log.w("FlagDataUtils", str2);
        }
        return valueOf.booleanValue();
    }

    public int getIntFlagValue(String str, int i2, int i3) {
        String str2;
        if (!this.zza) {
            return i2;
        }
        SharedPreferences sharedPreferences = this.zzb;
        Integer valueOf = Integer.valueOf(i2);
        try {
            valueOf = (Integer) com.google.android.gms.internal.flags.zzd.zza(new zzb(sharedPreferences, str, valueOf));
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            if (valueOf2.length() != 0) {
                str2 = "Flag value not available, returning default: ".concat(valueOf2);
            } else {
                str2 = new String("Flag value not available, returning default: ");
            }
            Log.w("FlagDataUtils", str2);
        }
        return valueOf.intValue();
    }

    public long getLongFlagValue(String str, long j2, int i2) {
        String str2;
        if (!this.zza) {
            return j2;
        }
        SharedPreferences sharedPreferences = this.zzb;
        Long valueOf = Long.valueOf(j2);
        try {
            valueOf = (Long) com.google.android.gms.internal.flags.zzd.zza(new zzc(sharedPreferences, str, valueOf));
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            if (valueOf2.length() != 0) {
                str2 = "Flag value not available, returning default: ".concat(valueOf2);
            } else {
                str2 = new String("Flag value not available, returning default: ");
            }
            Log.w("FlagDataUtils", str2);
        }
        return valueOf.longValue();
    }

    public String getStringFlagValue(String str, String str2, int i2) {
        String str3;
        if (!this.zza) {
            return str2;
        }
        try {
            return (String) com.google.android.gms.internal.flags.zzd.zza(new zzd(this.zzb, str, str2));
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                str3 = "Flag value not available, returning default: ".concat(valueOf);
            } else {
                str3 = new String("Flag value not available, returning default: ");
            }
            Log.w("FlagDataUtils", str3);
            return str2;
        }
    }

    public void init(IObjectWrapper iObjectWrapper) {
        String str;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (!this.zza) {
            try {
                this.zzb = zzf.zza(context.createPackageContext("com.google.android.gms", 0));
                this.zza = true;
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                if (valueOf.length() != 0) {
                    str = "Could not retrieve sdk flags, continuing with defaults: ".concat(valueOf);
                } else {
                    str = new String("Could not retrieve sdk flags, continuing with defaults: ");
                }
                Log.w("FlagProviderImpl", str);
            }
        }
    }
}
