package com.chartboost.sdk.impl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.json.JSONArray;

public abstract /* synthetic */ class s5 {
    public static final List a(JSONArray jSONArray) {
        Intrinsics.f(jSONArray, "<this>");
        IntRange j2 = RangesKt___RangesKt.j(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(j2, 10));
        Iterator it2 = j2.iterator();
        while (it2.hasNext()) {
            arrayList.add(jSONArray.get(((IntIterator) it2).nextInt()));
        }
        return arrayList;
    }

    public static final List b(JSONArray jSONArray) {
        Intrinsics.f(jSONArray, "<this>");
        IntRange j2 = RangesKt___RangesKt.j(0, jSONArray.length());
        ArrayList arrayList = new ArrayList();
        Iterator it2 = j2.iterator();
        while (it2.hasNext()) {
            Object obj = jSONArray.get(((IntIterator) it2).nextInt());
            if (obj == null) {
                obj = null;
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final hb a(gb gbVar) {
        Intrinsics.f(gbVar, "<this>");
        return new hb(gbVar.a(), gbVar.b(), gbVar.c());
    }

    public static final t9 a(r2 r2Var) {
        Intrinsics.f(r2Var, "<this>");
        return new t9(Integer.valueOf(r2Var.a()), Integer.valueOf(r2Var.c().b()), r2Var.b(), r2Var.f());
    }

    public static final String a(PackageManager packageManager, String str) {
        Intrinsics.f(packageManager, "<this>");
        Intrinsics.f(str, "packageName");
        try {
            String str2 = r5.getPackageInfoCompat(packageManager, str, 128).versionName;
            Intrinsics.e(str2, "{\n        getPackageInfo…A_DATA).versionName\n    }");
            return str2;
        } catch (Exception e2) {
            w7.a("Request Body", "Exception raised getting package manager object", e2);
            return "";
        }
    }

    public static final PackageInfo a(PackageManager packageManager, String str, int i2) {
        Intrinsics.f(packageManager, "<this>");
        Intrinsics.f(str, "packageName");
        if (Build.VERSION.SDK_INT >= 33) {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of((long) i2));
            Intrinsics.e(packageInfo, "{\n        getPackageInfo…of(flags.toLong()))\n    }");
            return packageInfo;
        }
        PackageInfo packageInfo2 = packageManager.getPackageInfo(str, i2);
        Intrinsics.e(packageInfo2, "{\n        @Suppress(\"DEP…packageName, flags)\n    }");
        return packageInfo2;
    }
}
