package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.cast.MediaTrack;
import com.uwetrottmann.thetvdb.TheTvdb;
import java.util.Map;

public final class zzbqo extends zzbqw {
    private final Map zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    private final String zzc = zze(MediaTrack.ROLE_DESCRIPTION);
    private final long zzd = zzd("start_ticks");
    private final long zze = zzd("end_ticks");
    private final String zzf = zze("summary");
    private final String zzg = zze("location");

    public zzbqo(zzcez zzcez, Map map) {
        super(zzcez, "createCalendarEvent");
        this.zza = map;
        this.zzb = zzcez.zzi();
    }

    private final long zzd(String str) {
        String str2 = (String) this.zza.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private final String zze(String str) {
        return TextUtils.isEmpty((CharSequence) this.zza.get(str)) ? "" : (String) this.zza.get(str);
    }

    /* access modifiers changed from: package-private */
    public final Intent zzb() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzc);
        data.putExtra("eventLocation", this.zzg);
        data.putExtra(MediaTrack.ROLE_DESCRIPTION, this.zzf);
        long j2 = this.zzd;
        if (j2 > -1) {
            data.putExtra("beginTime", j2);
        }
        long j3 = this.zze;
        if (j3 > -1) {
            data.putExtra("endTime", j3);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void zzc() {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.zzb == null) {
            zzg("Activity context is not available.");
            return;
        }
        zzt.zzp();
        if (!new zzbaw(this.zzb).zzb()) {
            zzg("This feature is not available on the device.");
            return;
        }
        zzt.zzp();
        AlertDialog.Builder zzG = zzs.zzG(this.zzb);
        Resources zzd2 = zzt.zzo().zzd();
        if (zzd2 != null) {
            str = zzd2.getString(R.string.s5);
        } else {
            str = "Create calendar event";
        }
        zzG.setTitle(str);
        if (zzd2 != null) {
            str2 = zzd2.getString(R.string.s6);
        } else {
            str2 = "Allow Ad to create a calendar event?";
        }
        zzG.setMessage(str2);
        if (zzd2 != null) {
            str3 = zzd2.getString(R.string.s3);
        } else {
            str3 = TheTvdb.HEADER_ACCEPT;
        }
        zzG.setPositiveButton(str3, new zzbqm(this));
        if (zzd2 != null) {
            str4 = zzd2.getString(R.string.s4);
        } else {
            str4 = "Decline";
        }
        zzG.setNegativeButton(str4, new zzbqn(this));
        zzG.create().show();
    }
}
