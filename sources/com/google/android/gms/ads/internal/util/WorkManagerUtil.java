package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster;
import com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbzr;

@KeepForSdk
public class WorkManagerUtil extends zzbq {
    private static void zzb(Context context) {
        try {
            WorkManager.e(context.getApplicationContext(), new Configuration.Builder().a());
        } catch (IllegalStateException unused) {
        }
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzb(context);
        try {
            WorkManager d2 = WorkManager.d(context);
            d2.a("offline_ping_sender_work");
            d2.b((OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(OfflinePingSender.class).e(new Constraints.Builder().b(NetworkType.CONNECTED).a())).a("offline_ping_sender_work")).b());
        } catch (IllegalStateException e2) {
            zzbzr.zzk("Failed to instantiate WorkManager.", e2);
        }
    }

    public final boolean zzf(IObjectWrapper iObjectWrapper, String str, String str2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzb(context);
        Constraints a2 = new Constraints.Builder().b(NetworkType.CONNECTED).a();
        try {
            WorkManager.d(context).b((OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(OfflineNotificationPoster.class).e(a2)).f(new Data.Builder().f("uri", str).f("gws_query_id", str2).a())).a("offline_notification_work")).b());
            return true;
        } catch (IllegalStateException e2) {
            zzbzr.zzk("Failed to instantiate WorkManager.", e2);
            return false;
        }
    }
}
