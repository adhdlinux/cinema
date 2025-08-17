package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

public final class zzebl extends zzbrl {
    private final Context zza;
    private final zzdqa zzb;
    private final zzbzw zzc;
    private final zzeba zzd;
    private final zzfev zze;
    private String zzf;
    private String zzg;

    public zzebl(Context context, zzeba zzeba, zzbzw zzbzw, zzdqa zzdqa, zzfev zzfev) {
        this.zza = context;
        this.zzb = zzdqa;
        this.zzc = zzbzw;
        this.zzd = zzeba;
        this.zze = zzfev;
    }

    public static void zzc(Context context, zzdqa zzdqa, zzfev zzfev, zzeba zzeba, String str, String str2, Map map) {
        String str3;
        String str4;
        if (true != zzt.zzo().zzx(context)) {
            str3 = "offline";
        } else {
            str3 = "online";
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzig)).booleanValue() || zzdqa == null) {
            zzfeu zzb2 = zzfeu.zzb(str2);
            zzb2.zza("gqi", str);
            zzb2.zza("device_connectivity", str3);
            zzb2.zza("event_timestamp", String.valueOf(zzt.zzB().currentTimeMillis()));
            for (Map.Entry entry : map.entrySet()) {
                zzb2.zza((String) entry.getKey(), (String) entry.getValue());
            }
            str4 = zzfev.zza(zzb2);
        } else {
            zzdpz zza2 = zzdqa.zza();
            zza2.zzb("gqi", str);
            zza2.zzb("action", str2);
            zza2.zzb("device_connectivity", str3);
            zza2.zzb("event_timestamp", String.valueOf(zzt.zzB().currentTimeMillis()));
            for (Map.Entry entry2 : map.entrySet()) {
                zza2.zzb((String) entry2.getKey(), (String) entry2.getValue());
            }
            str4 = zza2.zzf();
        }
        zzeba.zzd(new zzebc(zzt.zzB().currentTimeMillis(), str, str4, 2));
    }

    private static String zzo(int i2, String str) {
        Resources zzd2 = zzt.zzo().zzd();
        if (zzd2 == null) {
            return str;
        }
        return zzd2.getString(i2);
    }

    private final void zzp(String str, String str2, Map map) {
        zzc(this.zza, this.zzb, this.zze, this.zzd, str, str2, map);
    }

    private final void zzq(zzbr zzbr) {
        try {
            if (zzbr.zzf(ObjectWrapper.wrap(this.zza), this.zzg, this.zzf)) {
                return;
            }
        } catch (RemoteException e2) {
            zzbzr.zzh("Failed to schedule offline notification poster.", e2);
        }
        this.zzd.zzc(this.zzf);
        zzp(this.zzf, "offline_notification_worker_not_scheduled", zzfsf.zzd());
    }

    private final void zzr(Activity activity, zzl zzl, zzbr zzbr) {
        zzt.zzp();
        if (NotificationManagerCompat.d(activity).a()) {
            zzq(zzbr);
            zzs(activity, zzl);
        } else if (Build.VERSION.SDK_INT < 33) {
            zzt.zzp();
            AlertDialog.Builder zzG = zzs.zzG(activity);
            zzG.setTitle(zzo(R.string.notifications_permission_title, "Allow app to send you notifications?")).setPositiveButton(zzo(R.string.notifications_permission_confirm, "Allow"), new zzebd(this, activity, zzbr, zzl)).setNegativeButton(zzo(R.string.notifications_permission_decline, "Don't allow"), new zzebe(this, zzl)).setOnCancelListener(new zzebf(this, zzl));
            zzG.create().show();
            zzp(this.zzf, "rtsdi", zzfsf.zzd());
        } else {
            activity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 12345);
            zzp(this.zzf, "asnpdi", zzfsf.zzd());
        }
    }

    private final void zzs(Activity activity, zzl zzl) {
        String zzo = zzo(R.string.offline_opt_in_confirmation, "You'll get a notification with the link when you're back online");
        zzt.zzp();
        AlertDialog.Builder zzG = zzs.zzG(activity);
        zzG.setMessage(zzo).setOnCancelListener(new zzebj(zzl));
        AlertDialog create = zzG.create();
        create.show();
        Timer timer = new Timer();
        timer.schedule(new zzebk(this, create, timer, zzl), 3000);
    }

    private static final PendingIntent zzt(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setClassName(context, AdService.CLASS_NAME);
        intent.setAction(str);
        intent.putExtra("offline_notification_action", str);
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str3);
        return zzfmm.zza(context, 0, intent, zzfmm.zza | 1073741824, 0);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Activity activity, zzbr zzbr, zzl zzl, DialogInterface dialogInterface, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "confirm");
        zzp(this.zzf, "rtsdc", hashMap);
        activity.startActivity(zzt.zzq().zzg(activity));
        zzq(zzbr);
        if (zzl != null) {
            zzl.zzb();
        }
    }

    public final void zze(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra("uri");
            boolean zzx = zzt.zzo().zzx(this.zza);
            HashMap hashMap = new HashMap();
            char c2 = 2;
            if (stringExtra.equals("offline_notification_clicked")) {
                hashMap.put("offline_notification_action", "offline_notification_clicked");
                if (true == zzx) {
                    c2 = 1;
                }
                hashMap.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                hashMap.put("olaih", String.valueOf(stringExtra3.startsWith(UriUtil.HTTP_SCHEME)));
                try {
                    Intent launchIntentForPackage = this.zza.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                    if (launchIntentForPackage == null) {
                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                        launchIntentForPackage.setData(Uri.parse(stringExtra3));
                    }
                    launchIntentForPackage.addFlags(268435456);
                    this.zza.startActivity(launchIntentForPackage);
                    hashMap.put("olaa", "olas");
                } catch (ActivityNotFoundException unused) {
                    hashMap.put("olaa", "olaf");
                }
            } else {
                hashMap.put("offline_notification_action", "offline_notification_dismissed");
            }
            zzp(stringExtra2, "offline_notification_action", hashMap);
            try {
                SQLiteDatabase writableDatabase = this.zzd.getWritableDatabase();
                if (c2 == 1) {
                    this.zzd.zzg(writableDatabase, this.zzc, stringExtra2);
                } else {
                    zzeba.zzi(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e2) {
                zzbzr.zzg("Failed to get writable offline buffering database: ".concat(e2.toString()));
            }
        }
    }

    public final void zzf(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) {
        int i2 = 0;
        while (i2 < strArr.length) {
            if (!strArr[i2].equals("android.permission.POST_NOTIFICATIONS")) {
                i2++;
            } else {
                zzebn zzebn = (zzebn) ObjectWrapper.unwrap(iObjectWrapper);
                Activity zza2 = zzebn.zza();
                zzbr zzc2 = zzebn.zzc();
                zzl zzb2 = zzebn.zzb();
                HashMap hashMap = new HashMap();
                if (iArr[i2] == 0) {
                    hashMap.put("dialog_action", "confirm");
                    if (zzc2 != null) {
                        zzq(zzc2);
                    }
                    zzs(zza2, zzb2);
                } else {
                    hashMap.put("dialog_action", "dismiss");
                    if (zzb2 != null) {
                        zzb2.zzb();
                    }
                }
                zzp(this.zzf, "asnpdc", hashMap);
                return;
            }
        }
    }

    public final void zzg(IObjectWrapper iObjectWrapper) {
        zzebn zzebn = (zzebn) ObjectWrapper.unwrap(iObjectWrapper);
        Activity zza2 = zzebn.zza();
        zzl zzb2 = zzebn.zzb();
        zzbr zzc2 = zzebn.zzc();
        this.zzf = zzebn.zzd();
        this.zzg = zzebn.zze();
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzhZ)).booleanValue()) {
            zzp(this.zzf, "dialog_impression", zzfsf.zzd());
            zzt.zzp();
            AlertDialog.Builder zzG = zzs.zzG(zza2);
            zzG.setTitle(zzo(R.string.offline_opt_in_title, "Open ad when you're back online.")).setMessage(zzo(R.string.offline_opt_in_message, "We'll send you a notification with a link to the advertiser site.")).setPositiveButton(zzo(R.string.offline_opt_in_confirm, "OK"), new zzebg(this, zza2, zzb2, zzc2)).setNegativeButton(zzo(R.string.offline_opt_in_decline, "No thanks"), new zzebh(this, zzb2)).setOnCancelListener(new zzebi(this, zzb2));
            zzG.create().show();
            return;
        }
        zzr(zza2, zzb2, zzc2);
    }

    public final void zzh() {
        this.zzd.zze(new zzeaw(this.zzc));
    }

    public final void zzi(IObjectWrapper iObjectWrapper, String str, String str2) {
        String str3;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzt.zzq().zzh(context, "offline_notification_channel", "AdMob Offline Notifications");
        NotificationCompat.Builder y2 = new NotificationCompat.Builder(context, "offline_notification_channel").m(zzo(R.string.offline_notification_title, "View the ad you saved when you were offline")).l(zzo(R.string.offline_notification_text, "Tap to open ad")).g(true).n(zzt(context, "offline_notification_dismissed", str2, str)).k(zzt(context, "offline_notification_clicked", str2, str)).y(context.getApplicationInfo().icon);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        HashMap hashMap = new HashMap();
        try {
            notificationManager.notify(str2, 54321, y2.c());
            str3 = "offline_notification_impression";
        } catch (IllegalArgumentException e2) {
            hashMap.put("notification_not_shown_reason", e2.getMessage());
            str3 = "offline_notification_failed";
        }
        zzp(str2, str3, hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(zzl zzl, DialogInterface dialogInterface, int i2) {
        this.zzd.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzp(this.zzf, "rtsdc", hashMap);
        if (zzl != null) {
            zzl.zzb();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzl zzl, DialogInterface dialogInterface) {
        this.zzd.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzp(this.zzf, "rtsdc", hashMap);
        if (zzl != null) {
            zzl.zzb();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(Activity activity, zzl zzl, zzbr zzbr, DialogInterface dialogInterface, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "confirm");
        zzp(this.zzf, "dialog_click", hashMap);
        zzr(activity, zzl, zzbr);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(zzl zzl, DialogInterface dialogInterface, int i2) {
        this.zzd.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzp(this.zzf, "dialog_click", hashMap);
        if (zzl != null) {
            zzl.zzb();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(zzl zzl, DialogInterface dialogInterface) {
        this.zzd.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzp(this.zzf, "dialog_click", hashMap);
        if (zzl != null) {
            zzl.zzb();
        }
    }
}
