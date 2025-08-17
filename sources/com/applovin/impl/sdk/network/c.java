package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.m;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    private String f15620a;

    /* renamed from: b  reason: collision with root package name */
    private String f15621b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f15622c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, String> f15623d;

    /* renamed from: e  reason: collision with root package name */
    private final JSONObject f15624e;

    /* renamed from: f  reason: collision with root package name */
    private String f15625f;

    /* renamed from: g  reason: collision with root package name */
    private final T f15626g;

    /* renamed from: h  reason: collision with root package name */
    private final int f15627h;

    /* renamed from: i  reason: collision with root package name */
    private int f15628i;

    /* renamed from: j  reason: collision with root package name */
    private final int f15629j;

    /* renamed from: k  reason: collision with root package name */
    private final int f15630k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f15631l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f15632m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f15633n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f15634o;

    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        String f15635a;

        /* renamed from: b  reason: collision with root package name */
        String f15636b;

        /* renamed from: c  reason: collision with root package name */
        String f15637c;

        /* renamed from: d  reason: collision with root package name */
        Map<String, String> f15638d;

        /* renamed from: e  reason: collision with root package name */
        Map<String, String> f15639e;

        /* renamed from: f  reason: collision with root package name */
        JSONObject f15640f;

        /* renamed from: g  reason: collision with root package name */
        T f15641g;

        /* renamed from: h  reason: collision with root package name */
        int f15642h = 1;

        /* renamed from: i  reason: collision with root package name */
        int f15643i;

        /* renamed from: j  reason: collision with root package name */
        int f15644j;

        /* renamed from: k  reason: collision with root package name */
        boolean f15645k;

        /* renamed from: l  reason: collision with root package name */
        boolean f15646l;

        /* renamed from: m  reason: collision with root package name */
        boolean f15647m;

        /* renamed from: n  reason: collision with root package name */
        boolean f15648n;

        public a(m mVar) {
            this.f15643i = ((Integer) mVar.a(b.cO)).intValue();
            this.f15644j = ((Integer) mVar.a(b.cN)).intValue();
            this.f15646l = ((Boolean) mVar.a(b.cM)).booleanValue();
            this.f15647m = ((Boolean) mVar.a(b.ep)).booleanValue();
            this.f15648n = ((Boolean) mVar.a(b.eu)).booleanValue();
            this.f15638d = new HashMap();
        }

        public a<T> a(int i2) {
            this.f15642h = i2;
            return this;
        }

        public a<T> a(T t2) {
            this.f15641g = t2;
            return this;
        }

        public a<T> a(String str) {
            this.f15636b = str;
            return this;
        }

        public a<T> a(Map<String, String> map) {
            this.f15638d = map;
            return this;
        }

        public a<T> a(JSONObject jSONObject) {
            this.f15640f = jSONObject;
            return this;
        }

        public a<T> a(boolean z2) {
            this.f15645k = z2;
            return this;
        }

        public c<T> a() {
            return new c<>(this);
        }

        public a<T> b(int i2) {
            this.f15643i = i2;
            return this;
        }

        public a<T> b(String str) {
            this.f15635a = str;
            return this;
        }

        public a<T> b(Map<String, String> map) {
            this.f15639e = map;
            return this;
        }

        public a<T> b(boolean z2) {
            this.f15646l = z2;
            return this;
        }

        public a<T> c(int i2) {
            this.f15644j = i2;
            return this;
        }

        public a<T> c(String str) {
            this.f15637c = str;
            return this;
        }

        public a<T> c(boolean z2) {
            this.f15647m = z2;
            return this;
        }

        public a<T> d(boolean z2) {
            this.f15648n = z2;
            return this;
        }
    }

    protected c(a<T> aVar) {
        this.f15620a = aVar.f15636b;
        this.f15621b = aVar.f15635a;
        this.f15622c = aVar.f15638d;
        this.f15623d = aVar.f15639e;
        this.f15624e = aVar.f15640f;
        this.f15625f = aVar.f15637c;
        this.f15626g = aVar.f15641g;
        int i2 = aVar.f15642h;
        this.f15627h = i2;
        this.f15628i = i2;
        this.f15629j = aVar.f15643i;
        this.f15630k = aVar.f15644j;
        this.f15631l = aVar.f15645k;
        this.f15632m = aVar.f15646l;
        this.f15633n = aVar.f15647m;
        this.f15634o = aVar.f15648n;
    }

    public static <T> a<T> a(m mVar) {
        return new a<>(mVar);
    }

    public String a() {
        return this.f15620a;
    }

    public void a(int i2) {
        this.f15628i = i2;
    }

    public void a(String str) {
        this.f15620a = str;
    }

    public String b() {
        return this.f15621b;
    }

    public void b(String str) {
        this.f15621b = str;
    }

    public Map<String, String> c() {
        return this.f15622c;
    }

    public Map<String, String> d() {
        return this.f15623d;
    }

    public JSONObject e() {
        return this.f15624e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        String str = this.f15620a;
        if (str == null ? cVar.f15620a != null : !str.equals(cVar.f15620a)) {
            return false;
        }
        Map<String, String> map = this.f15622c;
        if (map == null ? cVar.f15622c != null : !map.equals(cVar.f15622c)) {
            return false;
        }
        Map<String, String> map2 = this.f15623d;
        if (map2 == null ? cVar.f15623d != null : !map2.equals(cVar.f15623d)) {
            return false;
        }
        String str2 = this.f15625f;
        if (str2 == null ? cVar.f15625f != null : !str2.equals(cVar.f15625f)) {
            return false;
        }
        String str3 = this.f15621b;
        if (str3 == null ? cVar.f15621b != null : !str3.equals(cVar.f15621b)) {
            return false;
        }
        JSONObject jSONObject = this.f15624e;
        if (jSONObject == null ? cVar.f15624e != null : !jSONObject.equals(cVar.f15624e)) {
            return false;
        }
        T t2 = this.f15626g;
        if (t2 == null ? cVar.f15626g == null : t2.equals(cVar.f15626g)) {
            return this.f15627h == cVar.f15627h && this.f15628i == cVar.f15628i && this.f15629j == cVar.f15629j && this.f15630k == cVar.f15630k && this.f15631l == cVar.f15631l && this.f15632m == cVar.f15632m && this.f15633n == cVar.f15633n && this.f15634o == cVar.f15634o;
        }
        return false;
    }

    public String f() {
        return this.f15625f;
    }

    public T g() {
        return this.f15626g;
    }

    public int h() {
        return this.f15628i;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f15620a;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f15625f;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f15621b;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        T t2 = this.f15626g;
        if (t2 != null) {
            i2 = t2.hashCode();
        }
        int i3 = ((((((((((((((((hashCode4 + i2) * 31) + this.f15627h) * 31) + this.f15628i) * 31) + this.f15629j) * 31) + this.f15630k) * 31) + (this.f15631l ? 1 : 0)) * 31) + (this.f15632m ? 1 : 0)) * 31) + (this.f15633n ? 1 : 0)) * 31) + (this.f15634o ? 1 : 0);
        Map<String, String> map = this.f15622c;
        if (map != null) {
            i3 = (i3 * 31) + map.hashCode();
        }
        Map<String, String> map2 = this.f15623d;
        if (map2 != null) {
            i3 = (i3 * 31) + map2.hashCode();
        }
        JSONObject jSONObject = this.f15624e;
        if (jSONObject == null) {
            return i3;
        }
        char[] charArray = jSONObject.toString().toCharArray();
        Arrays.sort(charArray);
        return (i3 * 31) + new String(charArray).hashCode();
    }

    public int i() {
        return this.f15627h - this.f15628i;
    }

    public int j() {
        return this.f15629j;
    }

    public int k() {
        return this.f15630k;
    }

    public boolean l() {
        return this.f15631l;
    }

    public boolean m() {
        return this.f15632m;
    }

    public boolean n() {
        return this.f15633n;
    }

    public boolean o() {
        return this.f15634o;
    }

    public String toString() {
        return "HttpRequest {endpoint=" + this.f15620a + ", backupEndpoint=" + this.f15625f + ", httpMethod=" + this.f15621b + ", httpHeaders=" + this.f15623d + ", body=" + this.f15624e + ", emptyResponse=" + this.f15626g + ", initialRetryAttempts=" + this.f15627h + ", retryAttemptsLeft=" + this.f15628i + ", timeoutMillis=" + this.f15629j + ", retryDelayMillis=" + this.f15630k + ", exponentialRetries=" + this.f15631l + ", retryOnAllErrors=" + this.f15632m + ", encodingEnabled=" + this.f15633n + ", gzipBodyEncoding=" + this.f15634o + '}';
    }
}
