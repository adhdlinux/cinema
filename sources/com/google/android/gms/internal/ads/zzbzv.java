package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

public final class zzbzv {
    public static Context zza(Context context) throws zzbzu {
        return zzc(context).getModuleContext();
    }

    public static Object zzb(Context context, String str, zzbzt zzbzt) throws zzbzu {
        try {
            return zzbzt.zza(zzc(context).instantiate(str));
        } catch (Exception e2) {
            throw new zzbzu(e2);
        }
    }

    private static DynamiteModule zzc(Context context) throws zzbzu {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID);
        } catch (Exception e2) {
            throw new zzbzu(e2);
        }
    }
}
