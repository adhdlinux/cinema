package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import com.google.android.gms.cast.internal.Logger;

public final class zzl {
    public static long zza = System.currentTimeMillis();
    private static final Logger zzl = new Logger("ApplicationAnalyticsSession");
    public String zzb;
    public String zzc;
    public long zzd = zza;
    public int zze = 1;
    public String zzf;
    public int zzg;
    public String zzh;
    public boolean zzi;
    public boolean zzj;
    public int zzk;

    private zzl(boolean z2) {
        this.zzi = z2;
    }

    public static zzl zza(boolean z2) {
        zzl zzl2 = new zzl(z2);
        zza++;
        return zzl2;
    }

    public static zzl zzb(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return null;
        }
        zzl zzl2 = new zzl(sharedPreferences.getBoolean("is_app_backgrounded", false));
        zzl2.zzj = sharedPreferences.getBoolean("is_output_switcher_enabled", false);
        if (!sharedPreferences.contains("application_id")) {
            return null;
        }
        zzl2.zzb = sharedPreferences.getString("application_id", "");
        if (!sharedPreferences.contains("receiver_metrics_id")) {
            return null;
        }
        zzl2.zzc = sharedPreferences.getString("receiver_metrics_id", "");
        if (!sharedPreferences.contains("analytics_session_id")) {
            return null;
        }
        zzl2.zzd = sharedPreferences.getLong("analytics_session_id", 0);
        if (!sharedPreferences.contains("event_sequence_number")) {
            return null;
        }
        zzl2.zze = sharedPreferences.getInt("event_sequence_number", 0);
        if (!sharedPreferences.contains("receiver_session_id")) {
            return null;
        }
        zzl2.zzf = sharedPreferences.getString("receiver_session_id", "");
        zzl2.zzg = sharedPreferences.getInt("device_capabilities", 0);
        zzl2.zzh = sharedPreferences.getString("device_model_name", "");
        zzl2.zzk = sharedPreferences.getInt("analytics_session_start_type", 0);
        return zzl2;
    }

    public final void zzc(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            zzl.d("Save the ApplicationAnalyticsSession to SharedPreferences %s", sharedPreferences);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("application_id", this.zzb);
            edit.putString("receiver_metrics_id", this.zzc);
            edit.putLong("analytics_session_id", this.zzd);
            edit.putInt("event_sequence_number", this.zze);
            edit.putString("receiver_session_id", this.zzf);
            edit.putInt("device_capabilities", this.zzg);
            edit.putString("device_model_name", this.zzh);
            edit.putInt("analytics_session_start_type", this.zzk);
            edit.putBoolean("is_app_backgrounded", this.zzi);
            edit.putBoolean("is_output_switcher_enabled", this.zzj);
            edit.apply();
        }
    }
}
