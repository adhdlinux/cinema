package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.tb;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

public final class eb implements a5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a5 f17647a;

    public static final class a extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f17648b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Map map) {
            super(1);
            this.f17648b = map;
        }

        /* renamed from: a */
        public final CharSequence invoke(MatchResult matchResult) {
            Intrinsics.f(matchResult, "matchResult");
            String value = matchResult.getValue();
            String str = (String) this.f17648b.get(value);
            if (str != null) {
                return str;
            }
            return value;
        }
    }

    public eb(a5 a5Var) {
        Intrinsics.f(a5Var, "eventTracker");
        this.f17647a = a5Var;
    }

    public final String a(File file, Map map, String str, String str2) {
        Intrinsics.f(file, "htmlFile");
        Intrinsics.f(map, "allParams");
        Intrinsics.f(str, "adTypeName");
        Intrinsics.f(str2, "location");
        try {
            Regex regex = new Regex("\\{\\{\\s*([^}]+)\\s*\\}\\}|\\{\\%\\s*([^}]+)\\s*\\%\\}");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getKey();
                if (StringsKt__StringsJVMKt.G(str3, "{{", false, 2, (Object) null) || StringsKt__StringsJVMKt.G(str3, "{%", false, 2, (Object) null)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return a(regex.i(FilesKt__FileReadWriteKt.a(file, Charsets.f40513b), new a(linkedHashMap)));
        } catch (Exception e2) {
            String a2 = fb.f17704a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Failed to parse template", e2);
            a(str, str2, e2.toString());
            return null;
        }
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f17647a.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f17647a.clearFromStorage(qbVar);
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f17647a.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f17647a.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f17647a.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f17647a.track(qbVar);
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m21clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f17647a.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m22persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f17647a.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m23refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f17647a.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m24store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f17647a.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m25track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f17647a.track(qbVar);
    }

    public final String a(String str) {
        if (!StringsKt__StringsKt.L(str, "{{", false, 2, (Object) null)) {
            return str;
        }
        throw new IllegalArgumentException("Missing required template parameter " + str);
    }

    public final void a(String str, String str2, String str3) {
        track((qb) d4.f17420m.a(tb.h.HTML_MISSING_MUSTACHE_ERROR, str3, str, str2));
    }
}
