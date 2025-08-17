package com.startapp;

import android.content.Context;
import android.text.TextUtils;
import com.startapp.ic;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.x6;

public class f7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34516a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ComponentLocator f34517b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ x6 f34518c;

    public f7(StartAppSDKInternal startAppSDKInternal, Context context, ComponentLocator componentLocator, x6 x6Var) {
        this.f34516a = context;
        this.f34517b = componentLocator;
        this.f34518c = x6Var;
    }

    public void run() {
        w8 j2;
        Boolean bool;
        ic.a aVar;
        Integer num;
        Long l2;
        try {
            a7 a7Var = new a7(this.f34516a);
            a7Var.a(this.f34516a, new AdPreferences());
            j2 = this.f34517b.j();
            String str = MetaData.f36379h.J() + AdsConstants.f36190d;
            j2.getClass();
            bool = null;
            aVar = j2.a(str, a7Var, (sa<String, Void>) null);
        } catch (Throwable th) {
            y8.a(this.f34516a, th);
            return;
        }
        if (aVar != null) {
            String str2 = aVar.f34700a;
            if (!TextUtils.isEmpty(str2)) {
                String a2 = lb.a(str2, "@ct@", "@ct@");
                String a3 = lb.a(str2, "@tsc@", "@tsc@");
                String a4 = lb.a(str2, "@apc@", "@apc@");
                try {
                    if (!TextUtils.isEmpty(a2)) {
                        num = Integer.valueOf(Integer.parseInt(a2));
                    } else {
                        num = null;
                    }
                    if (!TextUtils.isEmpty(a3)) {
                        l2 = Long.valueOf(Long.parseLong(a3));
                    } else {
                        l2 = null;
                    }
                    if (!TextUtils.isEmpty(a4)) {
                        bool = Boolean.valueOf(Boolean.parseBoolean(a4));
                    }
                    Boolean bool2 = bool;
                    if (!(num == null && l2 == null && bool2 == null)) {
                        this.f34517b.f().a(num, l2, bool2, false, true);
                    }
                } catch (Throwable th2) {
                    y8.a(this.f34516a, th2);
                }
            }
        }
        x6.a a5 = this.f34518c.edit();
        a5.a("shared_prefs_first_init", Boolean.FALSE);
        a5.f36915a.putBoolean("shared_prefs_first_init", false);
        a5.apply();
    }
}
