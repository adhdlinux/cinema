package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.c;
import java.util.Map;
import org.json.JSONObject;

public class i<T> extends c {

    /* renamed from: a  reason: collision with root package name */
    private String f15724a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f15725b;

    public static class a<T> extends c.a<T> {
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public String f15726o;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public boolean f15727p;

        public a(m mVar) {
            super(mVar);
            this.f15642h = ((Integer) mVar.a(b.cI)).intValue();
            this.f15643i = ((Integer) mVar.a(b.cH)).intValue();
            this.f15644j = ((Integer) mVar.a(b.cN)).intValue();
        }

        /* renamed from: b */
        public a a(T t2) {
            this.f15641g = t2;
            return this;
        }

        /* renamed from: b */
        public a a(JSONObject jSONObject) {
            this.f15640f = jSONObject;
            return this;
        }

        /* renamed from: b */
        public i<T> a() {
            return new i<>(this);
        }

        /* renamed from: c */
        public a a(Map<String, String> map) {
            this.f15638d = map;
            return this;
        }

        /* renamed from: d */
        public a a(int i2) {
            this.f15642h = i2;
            return this;
        }

        /* renamed from: d */
        public a a(String str) {
            this.f15636b = str;
            return this;
        }

        /* renamed from: d */
        public a b(Map<String, String> map) {
            this.f15639e = map;
            return this;
        }

        /* renamed from: e */
        public a b(int i2) {
            this.f15643i = i2;
            return this;
        }

        /* renamed from: e */
        public a c(String str) {
            this.f15637c = str;
            return this;
        }

        /* renamed from: e */
        public a c(boolean z2) {
            this.f15647m = z2;
            return this;
        }

        /* renamed from: f */
        public a c(int i2) {
            this.f15644j = i2;
            return this;
        }

        /* renamed from: f */
        public a b(String str) {
            this.f15635a = str;
            return this;
        }

        /* renamed from: f */
        public a d(boolean z2) {
            this.f15648n = z2;
            return this;
        }

        public a g(String str) {
            this.f15726o = str;
            return this;
        }

        public a g(boolean z2) {
            this.f15727p = z2;
            return this;
        }
    }

    protected i(a aVar) {
        super(aVar);
        this.f15724a = aVar.f15726o;
        this.f15725b = aVar.f15727p;
    }

    public static a b(m mVar) {
        return new a(mVar);
    }

    public boolean p() {
        return this.f15724a != null;
    }

    public String q() {
        return this.f15724a;
    }

    public boolean r() {
        return this.f15725b;
    }
}
