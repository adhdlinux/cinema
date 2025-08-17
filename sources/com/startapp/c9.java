package com.startapp;

import com.startapp.sdk.adsbase.remoteconfig.AnalyticsCategoryFilterConfig;
import java.util.ArrayList;
import java.util.List;

public class c9 {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f34289a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f34290b;

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f34291c;

    /* renamed from: d  reason: collision with root package name */
    public final List<String> f34292d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f34293e;

    /* renamed from: f  reason: collision with root package name */
    public final long f34294f;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f34295a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f34296b;

        /* renamed from: c  reason: collision with root package name */
        public List<String> f34297c;

        /* renamed from: d  reason: collision with root package name */
        public String f34298d;

        public List<String> a() {
            return this.f34296b;
        }

        public List<String> b() {
            return this.f34297c;
        }

        public List<String> c() {
            return this.f34295a;
        }

        public String d() {
            return this.f34298d;
        }

        public a a(String... strArr) {
            List list = this.f34297c;
            if (list == null) {
                list = new ArrayList();
                this.f34297c = list;
            }
            return a(strArr, list);
        }

        public final a a(String[] strArr, List<String> list) {
            for (String str : strArr) {
                if (str != null) {
                    list.add(str);
                }
            }
            return this;
        }
    }

    public c9(a aVar) {
        this.f34289a = lb.b(aVar.c());
        this.f34290b = lb.b(aVar.a());
        this.f34291c = lb.b((List) null);
        this.f34292d = lb.b((List) null);
        this.f34293e = lb.b(aVar.b());
        this.f34294f = Math.max(0, lb.e(aVar.d()));
    }

    public static List<c9> a(List<AnalyticsCategoryFilterConfig> list) {
        ArrayList arrayList = null;
        if (list == null) {
            return null;
        }
        for (AnalyticsCategoryFilterConfig next : list) {
            if (next != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList(list.size());
                }
                arrayList.add(new c9(next));
            }
        }
        if (arrayList != null) {
            return lb.b(arrayList);
        }
        return arrayList;
    }

    public c9(AnalyticsCategoryFilterConfig analyticsCategoryFilterConfig) {
        this.f34289a = lb.b(analyticsCategoryFilterConfig.e());
        this.f34290b = lb.b(analyticsCategoryFilterConfig.b());
        this.f34291c = lb.b(analyticsCategoryFilterConfig.d());
        this.f34292d = lb.b(analyticsCategoryFilterConfig.a());
        this.f34293e = lb.b(analyticsCategoryFilterConfig.c());
        this.f34294f = Math.max(0, lb.e(analyticsCategoryFilterConfig.f()));
    }
}
