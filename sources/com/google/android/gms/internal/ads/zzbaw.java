package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzcb;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzbaw {
    private final Context zza;

    public zzbaw(Context context) {
        Preconditions.checkNotNull(context, "Context can not be null");
        this.zza = context;
    }

    public final boolean zza(Intent intent) {
        Preconditions.checkNotNull(intent, "Intent can not be null");
        if (!this.zza.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
            return true;
        }
        return false;
    }

    public final boolean zzb() {
        return zza(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }

    public final boolean zzc() {
        if (!((Boolean) zzcb.zza(this.zza, zzbav.zza)).booleanValue() || Wrappers.packageManager(this.zza).checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            return false;
        }
        return true;
    }
}
