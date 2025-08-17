package com.franmontiel.persistentcookiejar;

import com.franmontiel.persistentcookiejar.cache.CookieCache;
import com.franmontiel.persistentcookiejar.persistence.CookiePersistor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public class PersistentCookieJar implements CookieJar {

    /* renamed from: a  reason: collision with root package name */
    private CookieCache f22051a;

    /* renamed from: b  reason: collision with root package name */
    private CookiePersistor f22052b;

    public PersistentCookieJar(CookieCache cookieCache, CookiePersistor cookiePersistor) {
        this.f22051a = cookieCache;
        this.f22052b = cookiePersistor;
        cookieCache.addAll(cookiePersistor.b());
    }

    private static List<Cookie> a(List<Cookie> list) {
        ArrayList arrayList = new ArrayList();
        for (Cookie next : list) {
            if (next.persistent()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static boolean b(Cookie cookie) {
        return cookie.expiresAt() < System.currentTimeMillis();
    }

    public synchronized List<Cookie> loadForRequest(HttpUrl httpUrl) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList = new ArrayList();
        Iterator it2 = this.f22051a.iterator();
        while (it2.hasNext()) {
            Cookie cookie = (Cookie) it2.next();
            if (b(cookie)) {
                arrayList2.add(cookie);
                it2.remove();
            } else if (cookie.matches(httpUrl)) {
                arrayList.add(cookie);
            }
        }
        this.f22052b.removeAll(arrayList2);
        return arrayList;
    }

    public synchronized void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        this.f22051a.addAll(list);
        this.f22052b.a(a(list));
    }
}
