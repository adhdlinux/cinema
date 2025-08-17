package com.applovin.impl.sdk.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class r {

    /* renamed from: a  reason: collision with root package name */
    public static final r f15920a = new r();

    /* renamed from: b  reason: collision with root package name */
    protected String f15921b;

    /* renamed from: c  reason: collision with root package name */
    protected final List<r> f15922c;

    /* renamed from: d  reason: collision with root package name */
    private final r f15923d;

    /* renamed from: e  reason: collision with root package name */
    private final String f15924e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f15925f;

    private r() {
        this.f15923d = null;
        this.f15924e = "";
        this.f15925f = Collections.emptyMap();
        this.f15921b = "";
        this.f15922c = Collections.emptyList();
    }

    public r(String str, Map<String, String> map, r rVar) {
        this.f15923d = rVar;
        this.f15924e = str;
        this.f15925f = Collections.unmodifiableMap(map);
        this.f15922c = new ArrayList();
    }

    public String a() {
        return this.f15924e;
    }

    public List<r> a(String str) {
        if (str != null) {
            ArrayList arrayList = new ArrayList(this.f15922c.size());
            for (r next : this.f15922c) {
                if (str.equalsIgnoreCase(next.a())) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    public r b(String str) {
        if (str != null) {
            for (r next : this.f15922c) {
                if (str.equalsIgnoreCase(next.a())) {
                    return next;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    public Map<String, String> b() {
        return this.f15925f;
    }

    public r c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        } else if (this.f15922c.size() <= 0) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            while (!arrayList.isEmpty()) {
                r rVar = (r) arrayList.get(0);
                arrayList.remove(0);
                if (str.equalsIgnoreCase(rVar.a())) {
                    return rVar;
                }
                arrayList.addAll(rVar.d());
            }
            return null;
        }
    }

    public String c() {
        return this.f15921b;
    }

    public List<r> d() {
        return Collections.unmodifiableList(this.f15922c);
    }

    public String toString() {
        return "XmlNode{elementName='" + this.f15924e + '\'' + ", text='" + this.f15921b + '\'' + ", attributes=" + this.f15925f + '}';
    }
}
