package com.utils;

import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import java.util.HashMap;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

public final class HashRefHelpper {

    /* renamed from: a  reason: collision with root package name */
    public static final HashRefHelpper f37561a = new HashRefHelpper();

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, String> f37562b = MapsKt__MapsKt.i(TuplesKt.a(Deobfuscator$app$ProductionRelease.a(-263186719387844L), Deobfuscator$app$ProductionRelease.a(-263075050238148L)), TuplesKt.a(Deobfuscator$app$ProductionRelease.a(-263298388537540L), Deobfuscator$app$ProductionRelease.a(-263251143897284L)));

    private HashRefHelpper() {
    }

    public final String a(String str) {
        Intrinsics.f(str, Deobfuscator$app$ProductionRelease.a(-263178129453252L));
        HashMap<String, String> hashMap = f37562b;
        if (hashMap.containsKey(str)) {
            return (String) MapsKt__MapsKt.h(hashMap, str);
        }
        return Deobfuscator$app$ProductionRelease.a(-263191014355140L);
    }
}
