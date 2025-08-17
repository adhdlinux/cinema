package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.zzt;
import java.util.List;

public final class zzekq implements zzeqx {
    public final Context zza;
    public final zzq zzb;
    public final List zzc;

    public zzekq(Context context, zzq zzq, List list) {
        this.zza = context;
        this.zzb = zzq;
        this.zzc = list;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        Bundle bundle = (Bundle) obj;
        if (((Boolean) zzbdj.zza.zze()).booleanValue()) {
            Bundle bundle2 = new Bundle();
            zzt.zzp();
            String str = null;
            try {
                ActivityManager activityManager = (ActivityManager) this.zza.getSystemService("activity");
                if (activityManager != null) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                    if (!(runningTasks == null || runningTasks.isEmpty() || (runningTaskInfo = runningTasks.get(0)) == null || runningTaskInfo.topActivity == null)) {
                        str = runningTaskInfo.topActivity.getClassName();
                    }
                }
            } catch (Exception unused) {
            }
            bundle2.putString("activity", str);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("width", this.zzb.zze);
            bundle3.putInt("height", this.zzb.zzb);
            bundle2.putBundle("size", bundle3);
            if (!this.zzc.isEmpty()) {
                List list = this.zzc;
                bundle2.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
            }
            bundle.putBundle("view_hierarchy", bundle2);
        }
    }
}
