package com.startapp;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import java.util.LinkedHashSet;
import java.util.Locale;

public class id extends dd<hd> {
    public id(Context context) {
        super(context);
    }

    public Object a() {
        Locale locale;
        Locale a2;
        Configuration configuration;
        LocaleList a3;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Resources resources = this.f34373a.getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null) {
            locale = null;
        } else {
            locale = configuration.locale;
            if (Build.VERSION.SDK_INT >= 24 && (a3 = configuration.getLocales()) != null && a3.size() > 0) {
                int a4 = a3.size();
                boolean z2 = true;
                for (int i2 = 0; i2 < a4; i2++) {
                    Locale a5 = a3.get(i2);
                    if (a5 != null) {
                        if (linkedHashSet.size() < 11) {
                            linkedHashSet.add(a5);
                        }
                        if (z2) {
                            locale = a5;
                            z2 = false;
                        }
                    }
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 24 && (a2 = Locale.getDefault(Locale.Category.DISPLAY)) != null) {
            if (locale == null) {
                locale = a2;
            }
            if (linkedHashSet.size() < 11) {
                linkedHashSet.add(a2);
            }
        }
        Locale locale2 = Locale.getDefault();
        if (locale2 != null) {
            if (locale == null) {
                locale = locale2;
            }
            if (linkedHashSet.size() < 11) {
                linkedHashSet.add(locale2);
            }
        }
        if (locale == null) {
            locale = new Locale("en");
        }
        linkedHashSet.remove(locale);
        return new hd(locale, linkedHashSet);
    }

    public /* bridge */ /* synthetic */ Object c() {
        return hd.f34644a;
    }
}
