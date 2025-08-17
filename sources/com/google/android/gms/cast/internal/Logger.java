package com.google.android.gms.cast.internal;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Locale;

@KeepForSdk
public class Logger {
    protected final String zza;
    private final boolean zzb;
    private boolean zzc;
    private final String zzd;

    @KeepForSdk
    public Logger(String str) {
        this(str, (String) null);
    }

    @KeepForSdk
    public void d(String str, Object... objArr) {
        if (zzc()) {
            Log.d(this.zza, zza(str, objArr));
        }
    }

    @KeepForSdk
    public void e(String str, Object... objArr) {
        Log.e(this.zza, zza(str, objArr));
    }

    @KeepForSdk
    public void i(String str, Object... objArr) {
        Log.i(this.zza, zza(str, objArr));
    }

    @KeepForSdk
    public void v(String str, Object... objArr) {
    }

    @KeepForSdk
    public void w(String str, Object... objArr) {
        Log.w(this.zza, zza(str, objArr));
    }

    /* access modifiers changed from: protected */
    public final String zza(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(Locale.ROOT, str, objArr);
        }
        if (!TextUtils.isEmpty(this.zzd)) {
            return String.valueOf(this.zzd).concat(String.valueOf(str));
        }
        return str;
    }

    public final void zzb(boolean z2) {
        this.zzc = true;
    }

    public final boolean zzc() {
        if (Build.TYPE.equals("user")) {
            return false;
        }
        if (this.zzc) {
            return true;
        }
        if (!this.zzb || !Log.isLoggable(this.zza, 3)) {
            return false;
        }
        return true;
    }

    protected Logger(String str, String str2) {
        Preconditions.checkNotEmpty(str, "The log tag cannot be null or empty.");
        this.zza = str;
        this.zzb = str.length() <= 23;
        this.zzc = false;
        this.zzd = !TextUtils.isEmpty((CharSequence) null) ? String.format("[%s] ", new Object[]{null}) : null;
    }

    @KeepForSdk
    public void e(Throwable th, String str, Object... objArr) {
        Log.e(this.zza, zza(str, objArr), th);
    }

    @KeepForSdk
    public void i(Throwable th, String str, Object... objArr) {
        Log.i(this.zza, zza(str, objArr), th);
    }

    @KeepForSdk
    public void w(Throwable th, String str, Object... objArr) {
        Log.w(this.zza, zza(str, objArr), th);
    }

    @KeepForSdk
    public void d(Throwable th, String str, Object... objArr) {
        if (zzc()) {
            Log.d(this.zza, zza(str, objArr), th);
        }
    }
}
