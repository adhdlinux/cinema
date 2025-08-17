package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzam {
    private final Application zza;
    private final SharedPreferences zzb;
    private final Set<String> zzc;

    zzam(Application application) {
        this.zza = application;
        SharedPreferences sharedPreferences = application.getSharedPreferences("__GOOGLE_FUNDING_CHOICE_SDK_INTERNAL__", 0);
        this.zzb = sharedPreferences;
        this.zzc = new HashSet(sharedPreferences.getStringSet("written_values", Collections.emptySet()));
    }

    public final int zza() {
        return this.zzb.getInt("consent_status", 0);
    }

    public final Map<String, String> zzb() {
        String str;
        String str2;
        String str3;
        String str4;
        Application application = this.zza;
        Set<String> stringSet = this.zzb.getStringSet("stored_info", Collections.emptySet());
        HashMap hashMap = new HashMap();
        for (String next : stringSet) {
            zzby zza2 = zzca.zza(application, next);
            if (zza2 == null) {
                String valueOf = String.valueOf(next);
                if (valueOf.length() != 0) {
                    str4 = "Fetching request info: failed for key: ".concat(valueOf);
                } else {
                    str4 = new String("Fetching request info: failed for key: ");
                }
                Log.d("UserMessagingPlatform", str4);
            } else {
                Object obj = application.getSharedPreferences(zza2.zza, 0).getAll().get(zza2.zzb);
                if (obj == null) {
                    String valueOf2 = String.valueOf(next);
                    if (valueOf2.length() != 0) {
                        str3 = "Stored info not exists: ".concat(valueOf2);
                    } else {
                        str3 = new String("Stored info not exists: ");
                    }
                    Log.d("UserMessagingPlatform", str3);
                } else {
                    if (obj instanceof Boolean) {
                        if (true != ((Boolean) obj).booleanValue()) {
                            str = "0";
                        } else {
                            str = "1";
                        }
                    } else if (obj instanceof Number) {
                        str = obj.toString();
                    } else if (obj instanceof String) {
                        str = (String) obj;
                    } else {
                        String valueOf3 = String.valueOf(next);
                        if (valueOf3.length() != 0) {
                            str2 = "Failed to fetch stored info: ".concat(valueOf3);
                        } else {
                            str2 = new String("Failed to fetch stored info: ");
                        }
                        Log.d("UserMessagingPlatform", str2);
                    }
                    hashMap.put(next, str);
                }
            }
        }
        return hashMap;
    }

    public final Set<String> zzc() {
        return this.zzc;
    }

    public final void zzd() {
        zzca.zzb(this.zza, this.zzc);
        this.zzc.clear();
        this.zzb.edit().remove("stored_info").remove("consent_status").remove("consent_type").apply();
    }

    public final void zze() {
        this.zzb.edit().putStringSet("written_values", this.zzc).apply();
    }

    public final void zzf(int i2) {
        this.zzb.edit().putInt("consent_status", i2).apply();
    }

    public final void zzg(Set<String> set) {
        this.zzb.edit().putStringSet("stored_info", set).apply();
    }
}
