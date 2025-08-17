package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

public final class zzasf extends zzath {
    public zzasf(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3) {
        super(zzart, "W3XZxcuCkVWMGpB7rckmrrZNc8kIRKZXHq2IDWH2bOmQhacxUDxUUq9zi2tOIl+6", "TZLhLjkSWa88s5Ub32Va4FnAdRMP/dTQp+jLbB+9PU0=", zzanq, i2, 49);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzaa(3);
        try {
            int i2 = 1;
            boolean booleanValue = ((Boolean) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()})).booleanValue();
            zzanq zzanq = this.zze;
            if (true == booleanValue) {
                i2 = 2;
            }
            zzanq.zzaa(i2);
        } catch (InvocationTargetException e2) {
            if (!(e2.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e2;
            }
        }
    }
}
