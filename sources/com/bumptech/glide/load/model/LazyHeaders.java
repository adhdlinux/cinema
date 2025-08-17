package com.bumptech.glide.load.model;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class LazyHeaders implements Headers {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<LazyHeaderFactory>> f16705c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Map<String, String> f16706d;

    public static final class Builder {

        /* renamed from: d  reason: collision with root package name */
        private static final String f16707d;

        /* renamed from: e  reason: collision with root package name */
        private static final Map<String, List<LazyHeaderFactory>> f16708e;

        /* renamed from: a  reason: collision with root package name */
        private boolean f16709a = true;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, List<LazyHeaderFactory>> f16710b = f16708e;

        /* renamed from: c  reason: collision with root package name */
        private boolean f16711c = true;

        static {
            String b2 = b();
            f16707d = b2;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("User-Agent", Collections.singletonList(new StringHeaderFactory(b2)));
            }
            f16708e = Collections.unmodifiableMap(hashMap);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = property.charAt(i2);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public LazyHeaders a() {
            this.f16709a = true;
            return new LazyHeaders(this.f16710b);
        }
    }

    static final class StringHeaderFactory implements LazyHeaderFactory {

        /* renamed from: a  reason: collision with root package name */
        private final String f16712a;

        StringHeaderFactory(String str) {
            this.f16712a = str;
        }

        public String a() {
            return this.f16712a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof StringHeaderFactory) {
                return this.f16712a.equals(((StringHeaderFactory) obj).f16712a);
            }
            return false;
        }

        public int hashCode() {
            return this.f16712a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f16712a + '\'' + '}';
        }
    }

    LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        this.f16705c = Collections.unmodifiableMap(map);
    }

    private String b(List<LazyHeaderFactory> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String a2 = list.get(i2).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> c() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f16705c.entrySet()) {
            String b2 = b((List) next.getValue());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put(next.getKey(), b2);
            }
        }
        return hashMap;
    }

    public Map<String, String> a() {
        if (this.f16706d == null) {
            synchronized (this) {
                if (this.f16706d == null) {
                    this.f16706d = Collections.unmodifiableMap(c());
                }
            }
        }
        return this.f16706d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.f16705c.equals(((LazyHeaders) obj).f16705c);
        }
        return false;
    }

    public int hashCode() {
        return this.f16705c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f16705c + '}';
    }
}
