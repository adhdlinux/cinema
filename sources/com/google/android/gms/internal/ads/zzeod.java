package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.Set;
import okhttp3.internal.http2.Http2Connection;

public final class zzeod implements zzeqy {
    private final zzfwn zza;
    private final ViewGroup zzb;
    private final Context zzc;
    private final Set zzd;

    public zzeod(zzfwn zzfwn, ViewGroup viewGroup, Context context, Set set) {
        this.zza = zzfwn;
        this.zzd = set;
        this.zzb = viewGroup;
        this.zzc = context;
    }

    public final int zza() {
        return 22;
    }

    public final zzfwm zzb() {
        return this.zza.zzb(new zzeoc(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeoe zzc() throws Exception {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfG)).booleanValue() && this.zzb != null && this.zzd.contains("banner")) {
            return new zzeoe(Boolean.valueOf(this.zzb.isHardwareAccelerated()));
        }
        Boolean bool = null;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfH)).booleanValue() && this.zzd.contains("native")) {
            Context context = this.zzc;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                Window window = activity.getWindow();
                if (window == null || (window.getAttributes().flags & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) == 0) {
                    try {
                        boolean z2 = false;
                        if ((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) != 0) {
                            z2 = true;
                        }
                        bool = Boolean.valueOf(z2);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                } else {
                    bool = Boolean.TRUE;
                }
                return new zzeoe(bool);
            }
        }
        return new zzeoe((Boolean) null);
    }
}
