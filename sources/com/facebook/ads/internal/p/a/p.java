package com.facebook.ads.internal.p.a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class p implements Map<String, String> {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f20478a = new HashMap();

    public p a(Map<? extends String, ? extends String> map) {
        putAll(map);
        return this;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.f20478a.keySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(next);
            String str = this.f20478a.get(next);
            if (str != null) {
                sb.append("=");
                try {
                    sb.append(URLEncoder.encode(str, "UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public String get(Object obj) {
        return this.f20478a.get(obj);
    }

    /* renamed from: a */
    public String put(String str, String str2) {
        return this.f20478a.put(str, str2);
    }

    /* renamed from: b */
    public String remove(Object obj) {
        return this.f20478a.remove(obj);
    }

    public byte[] b() {
        try {
            return a().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void clear() {
        this.f20478a.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f20478a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f20478a.containsValue(obj);
    }

    public Set<Map.Entry<String, String>> entrySet() {
        return this.f20478a.entrySet();
    }

    public boolean isEmpty() {
        return this.f20478a.isEmpty();
    }

    public Set<String> keySet() {
        return this.f20478a.keySet();
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        this.f20478a.putAll(map);
    }

    public int size() {
        return this.f20478a.size();
    }

    public Collection<String> values() {
        return this.f20478a.values();
    }
}
