package com.startapp.sdk.adsbase.remoteconfig;

import android.content.Context;
import com.startapp.s8;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.x6;
import java.io.Serializable;

public class SimpleTokenConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean enabled = false;

    public boolean a(Context context) {
        ComponentLocator a2 = ComponentLocator.a(context);
        x6 d2 = a2.d();
        s8 f2 = a2.f();
        if (d2.getBoolean("userDisabledSimpleToken", false) || !this.enabled || !f2.c()) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SimpleTokenConfig.class == obj.getClass() && this.enabled == ((SimpleTokenConfig) obj).enabled) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Boolean.valueOf(this.enabled).hashCode();
    }
}
