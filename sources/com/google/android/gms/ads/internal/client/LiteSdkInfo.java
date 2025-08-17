package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbnt;
import com.google.android.gms.internal.ads.zzbnw;

@KeepForSdk
public class LiteSdkInfo extends zzck {
    public LiteSdkInfo(Context context) {
    }

    public zzbnw getAdapterCreator() {
        return new zzbnt();
    }

    public zzen getLiteSdkVersion() {
        return new zzen(ModuleDescriptor.MODULE_VERSION, ModuleDescriptor.MODULE_VERSION, "22.3.0");
    }
}
