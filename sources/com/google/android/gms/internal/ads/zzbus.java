package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;

public final class zzbus extends ContextWrapper {
    public static Context zza(Context context) {
        if (context instanceof zzbus) {
            return ((zzbus) context).getBaseContext();
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return context;
        }
        return applicationContext;
    }

    public final Context getApplicationContext() {
        throw null;
    }

    public final synchronized ApplicationInfo getApplicationInfo() {
        throw null;
    }

    public final synchronized String getPackageName() {
        throw null;
    }

    public final synchronized String getPackageResourcePath() {
        throw null;
    }

    public final synchronized void startActivity(Intent intent) {
        throw null;
    }
}
