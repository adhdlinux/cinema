package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;

public final class zzeap {
    private final zzawz zza;
    private final Context zzb;
    private final zzdzt zzc;
    private final zzbzx zzd;
    private final String zze;
    private final zzfev zzf;
    private final zzg zzg = zzt.zzo().zzh();

    public zzeap(Context context, zzbzx zzbzx, zzawz zzawz, zzdzt zzdzt, String str, zzfev zzfev) {
        this.zzb = context;
        this.zzd = zzbzx;
        this.zza = zzawz;
        this.zzc = zzdzt;
        this.zze = str;
        this.zzf = zzfev;
    }

    private static final void zzc(SQLiteDatabase sQLiteDatabase, ArrayList arrayList) {
        int size = arrayList.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            zzazi zzazi = (zzazi) arrayList.get(i2);
            if (zzazi.zzw() == 2 && zzazi.zze() > j2) {
                j2 = zzazi.zze();
            }
        }
        if (j2 != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, Long.valueOf(j2));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", (String[]) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(boolean z2, SQLiteDatabase sQLiteDatabase) throws Exception {
        String str;
        String str2;
        String str3;
        if (z2) {
            this.zzb.deleteDatabase("OfflineUpload.db");
            return null;
        }
        int i2 = 2;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzig)).booleanValue()) {
            zzfeu zzb2 = zzfeu.zzb("oa_upload");
            zzb2.zza("oa_failed_reqs", String.valueOf(zzeai.zza(sQLiteDatabase, 0)));
            zzb2.zza("oa_total_reqs", String.valueOf(zzeai.zza(sQLiteDatabase, 1)));
            zzb2.zza("oa_upload_time", String.valueOf(zzt.zzB().currentTimeMillis()));
            zzb2.zza("oa_last_successful_time", String.valueOf(zzeai.zzb(sQLiteDatabase, 2)));
            if (this.zzg.zzP()) {
                str = "";
            } else {
                str = this.zze;
            }
            zzb2.zza("oa_session_id", str);
            this.zzf.zzb(zzb2);
            ArrayList zzc2 = zzeai.zzc(sQLiteDatabase);
            zzc(sQLiteDatabase, zzc2);
            int size = zzc2.size();
            for (int i3 = 0; i3 < size; i3++) {
                zzazi zzazi = (zzazi) zzc2.get(i3);
                zzfeu zzb3 = zzfeu.zzb("oa_signals");
                if (this.zzg.zzP()) {
                    str2 = "";
                } else {
                    str2 = this.zze;
                }
                zzb3.zza("oa_session_id", str2);
                zzazd zzf2 = zzazi.zzf();
                if (zzf2.zzf()) {
                    str3 = String.valueOf(zzf2.zzh() - 1);
                } else {
                    str3 = "-1";
                }
                String obj = zzfsq.zzb(zzazi.zzk(), zzeao.zza).toString();
                zzb3.zza("oa_sig_ts", String.valueOf(zzazi.zze()));
                zzb3.zza("oa_sig_status", String.valueOf(zzazi.zzw() - 1));
                zzb3.zza("oa_sig_resp_lat", String.valueOf(zzazi.zzd()));
                zzb3.zza("oa_sig_render_lat", String.valueOf(zzazi.zzc()));
                zzb3.zza("oa_sig_formats", obj);
                zzb3.zza("oa_sig_nw_type", str3);
                zzb3.zza("oa_sig_wifi", String.valueOf(zzazi.zzx() - 1));
                zzb3.zza("oa_sig_airplane", String.valueOf(zzazi.zzt() - 1));
                zzb3.zza("oa_sig_data", String.valueOf(zzazi.zzu() - 1));
                zzb3.zza("oa_sig_nw_resp", String.valueOf(zzazi.zza()));
                zzb3.zza("oa_sig_offline", String.valueOf(zzazi.zzv() - 1));
                zzb3.zza("oa_sig_nw_state", String.valueOf(zzazi.zzj().zza()));
                if (zzf2.zze() && zzf2.zzf() && zzf2.zzh() == 2) {
                    zzb3.zza("oa_sig_cell_type", String.valueOf(zzf2.zzg() - 1));
                }
                this.zzf.zzb(zzb3);
            }
        } else {
            ArrayList zzc3 = zzeai.zzc(sQLiteDatabase);
            zzazj zza2 = zzazn.zza();
            zza2.zzb(this.zzb.getPackageName());
            zza2.zzd(Build.MODEL);
            zza2.zze(zzeai.zza(sQLiteDatabase, 0));
            zza2.zza(zzc3);
            zza2.zzg(zzeai.zza(sQLiteDatabase, 1));
            zza2.zzc(zzeai.zza(sQLiteDatabase, 3));
            zza2.zzh(zzt.zzB().currentTimeMillis());
            zza2.zzf(zzeai.zzb(sQLiteDatabase, 2));
            zzc(sQLiteDatabase, zzc3);
            this.zza.zzb(new zzeam((zzazn) zza2.zzal()));
            zzazy zza3 = zzazz.zza();
            zza3.zza(this.zzd.zzb);
            zza3.zzc(this.zzd.zzc);
            if (true == this.zzd.zzd) {
                i2 = 0;
            }
            zza3.zzb(i2);
            this.zza.zzb(new zzean((zzazz) zza3.zzal()));
            this.zza.zzc(10004);
        }
        zzeai.zzf(sQLiteDatabase);
        return null;
    }

    public final void zzb(boolean z2) {
        try {
            this.zzc.zza(new zzeal(this, z2));
        } catch (Exception e2) {
            zzbzr.zzg("Error in offline signals database startup: ".concat(String.valueOf(e2.getMessage())));
        }
    }
}
