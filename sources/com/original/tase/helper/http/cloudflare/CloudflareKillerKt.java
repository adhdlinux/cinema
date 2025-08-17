package com.original.tase.helper.http.cloudflare;

import com.original.Constants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.Request;

public final class CloudflareKillerKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, String> f33918a = MapsKt__MapsJVMKt.e(TuplesKt.a("user-agent", Constants.C));

    public static final Map<String, String> a(Headers headers, String str) {
        boolean z2;
        String str2;
        String obj;
        Intrinsics.f(headers, "<this>");
        Intrinsics.f(str, "cookieKey");
        ArrayList<Pair> arrayList = new ArrayList<>();
        for (Object next : headers) {
            if (StringsKt__StringsJVMKt.t((String) ((Pair) next).c(), str, true)) {
                arrayList.add(next);
            }
        }
        ArrayList<String> arrayList2 = new ArrayList<>(CollectionsKt__IterablesKt.p(arrayList, 10));
        for (Pair d2 : arrayList) {
            arrayList2.add(StringsKt__StringsKt.M0((String) d2.d(), ";", (String) null, 2, (Object) null));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.b(MapsKt__MapsJVMKt.d(CollectionsKt__IterablesKt.p(arrayList2, 10)), 16));
        for (String v02 : arrayList2) {
            List v03 = StringsKt__StringsKt.v0(v02, new String[]{"="}, false, 0, 6, (Object) null);
            String str3 = (String) CollectionsKt___CollectionsKt.E(v03, 0);
            String str4 = "";
            if (str3 == null || (str2 = StringsKt__StringsKt.N0(str3).toString()) == null) {
                str2 = str4;
            }
            String str5 = (String) CollectionsKt___CollectionsKt.E(v03, 1);
            if (!(str5 == null || (obj = StringsKt__StringsKt.N0(str5).toString()) == null)) {
                str4 = obj;
            }
            Pair a2 = TuplesKt.a(str2, str4);
            linkedHashMap.put(a2.c(), a2.d());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (!(!StringsKt__StringsJVMKt.v((CharSequence) entry.getKey())) || !(!StringsKt__StringsJVMKt.v((CharSequence) entry.getValue()))) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap2;
    }

    public static final Map<String, String> b(Request request) {
        Intrinsics.f(request, "<this>");
        return a(request.headers(), "Cookie");
    }

    public static final Headers c(Map<String, String> map, Map<String, String> map2) {
        Map map3;
        Intrinsics.f(map, "headers");
        Intrinsics.f(map2, "cookie");
        if (!map2.isEmpty()) {
            map3 = MapsKt__MapsJVMKt.e(TuplesKt.a("Cookie", CollectionsKt___CollectionsKt.J(map2.entrySet(), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, CloudflareKillerKt$getHeaders$cookieMap$1.f33919f, 30, (Object) null)));
        } else {
            map3 = MapsKt__MapsKt.g();
        }
        return Headers.Companion.of((Map<String, String>) MapsKt__MapsKt.o(MapsKt__MapsKt.o(f33918a, map), map3));
    }
}
